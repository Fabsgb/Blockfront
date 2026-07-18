package com.boehmod.bflib.cloud.connection;

import com.boehmod.bflib.cloud.common.ConnectionType;
import com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData;
import com.boehmod.bflib.cloud.packet.IPacket;
import java.util.UUID;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/connection/Connection.class */
public abstract class Connection<D extends AbstractPlayerCloudData<?, ?>> {
    private final int maxIdleTicks;

    @NotNull
    private ConnectionStatus status = ConnectionStatus.CLOSED;
    private int idleTicks = 0;

    public abstract D getPlayerCloudData();

    public abstract void onConnectionStatusChanged(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatusContext connectionStatusContext);

    protected abstract void onUpdate();

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

    public abstract <T extends IPacket> void onIllegalPacket(@NotNull T t, @NotNull ConnectionType connectionType, @NotNull ConnectionType connectionType2);

    public Connection(int maxIdleTicks) {
        this.maxIdleTicks = maxIdleTicks;
    }

    @NotNull
    public ConnectionStatus getStatus() {
        return this.status;
    }

    @OverridingMethodsMustInvokeSuper
    public void setStatus(@NotNull ConnectionStatus status, @NotNull ConnectionStatusContext context) {
        this.status = status;
        onConnectionStatusChanged(status, context);
    }

    public boolean isConnectionClosed() {
        return this.status.isClosed();
    }

    public void onUpdateCore() {
        if (!this.status.isClosed()) {
            int i = this.idleTicks;
            this.idleTicks = i + 1;
            if (i >= this.maxIdleTicks) {
                this.idleTicks = 0;
                disconnect("Idle Timeout.", true);
                return;
            }
        }
        onUpdate();
    }

    public void bumpIdle() {
        this.idleTicks = 0;
    }
}
