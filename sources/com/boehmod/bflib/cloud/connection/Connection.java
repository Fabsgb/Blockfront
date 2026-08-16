package com.boehmod.bflib.cloud.connection;

import com.boehmod.bflib.cloud.common.ConnectionType;
import com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketRegistry;
import io.netty.channel.Channel;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/connection/Connection.class */
public abstract class Connection<D extends AbstractPlayerCloudData<?, ?>> {
    public static final int MAX_QUEUED_PACKETS = 1024;

    @NotNull
    private final Queue<IPacket> incomingPackets = new LinkedBlockingQueue(1024);

    @NotNull
    private volatile ConnectionStatus status = ConnectionStatus.CLOSED;

    @NotNull
    private static final Logger LOGGER = LogManager.getLogger("Connection");
    public static final long PROCESS_BUDGET_NANOS = TimeUnit.MILLISECONDS.toNanos(2);

    public abstract D getPlayerCloudData();

    public abstract void onConnectionStatusChanged(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatusContext connectionStatusContext);

    protected abstract boolean shouldHandlePacket(@NotNull IPacket iPacket);

    public abstract void disconnect(@NotNull String str, boolean z);

    @NotNull
    public abstract UUID getUUID();

    public abstract byte[] getHardwareId();

    @NotNull
    public abstract String getUsername();

    @NotNull
    public abstract String getVersion();

    @NotNull
    public abstract String getVersionHash();

    @NotNull
    public abstract ConnectionType getType();

    public abstract void sendPacket(@NotNull IPacket iPacket);

    protected abstract void onSendFailure(@NotNull IPacket iPacket, @NotNull Throwable th);

    public abstract <T extends IPacket> void onIllegalPacket(@NotNull T t, @NotNull ConnectionType connectionType, @NotNull ConnectionType connectionType2);

    @NotNull
    public ConnectionStatus getStatus() {
        return this.status;
    }

    @OverridingMethodsMustInvokeSuper
    public void setStatus(@NotNull ConnectionStatus status, @NotNull ConnectionStatusContext context) {
        this.status = status;
        if (status.isClosed()) {
            this.incomingPackets.clear();
        }
        onConnectionStatusChanged(status, context);
    }

    public boolean isConnectionClosed() {
        return this.status.isClosed();
    }

    public void addIncomingPacket(@NotNull IPacket packet) {
        if (!this.incomingPackets.offer(packet)) {
            onPacketQueueOverflow();
        }
    }

    protected void onPacketQueueOverflow() {
        disconnect("Packet queue overflow", true);
    }

    protected void onPacketProcessError(@NotNull IPacket packet, @NotNull Exception e) {
        LOGGER.error("Error processing packet {}", packet.getClass().getSimpleName(), e);
    }

    private void processIncomingPackets() {
        long deadline = System.nanoTime() + PROCESS_BUDGET_NANOS;
        do {
            IPacket packet = this.incomingPackets.poll();
            if (packet != null) {
                try {
                    if (shouldHandlePacket(packet)) {
                        PacketRegistry.processPacket(packet, getType(), this);
                    }
                } catch (Exception e) {
                    onPacketProcessError(packet, e);
                }
            } else {
                return;
            }
        } while (System.nanoTime() < deadline);
    }

    public void onUpdateCore() {
        processIncomingPackets();
        onUpdate();
    }

    protected void onUpdate() {
    }

    protected void writeAndFlush(@NotNull Channel channel, @NotNull IPacket packet) {
        channel.writeAndFlush(packet).addListener(future -> {
            if (!future.isSuccess()) {
                onSendFailure(packet, future.cause());
            }
        });
    }
}
