package com.boehmod.blockfront.cloud.connection;

import com.boehmod.bflib.cloud.common.ConnectionType;
import com.boehmod.bflib.cloud.connection.Connection;
import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.cloud.connection.ConnectionStatusContext;
import com.boehmod.bflib.cloud.connection.EncryptedConnectionCredentials;
import com.boehmod.bflib.cloud.encryption.AESDecryptionHandler;
import com.boehmod.bflib.cloud.encryption.AESEncryptionHandler;
import com.boehmod.bflib.cloud.encryption.EncryptionUtils;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketRegistry;
import com.boehmod.bflib.cloud.packet.primitives.ClientHeartBeatPacket;
import com.boehmod.bflib.cloud.packet.primitives.ClientLoginPacket;
import com.boehmod.bflib.cloud.packet.primitives.ClientLogoutPacket;
import com.boehmod.bflib.cloud.packet.primitives.EncryptionKeyExchangePacket;
import com.boehmod.bflib.cloud.packet.primitives.EncryptionReadyPacket;
import com.boehmod.blockfront.AbstractC0563ju;
import com.boehmod.blockfront.C0482iS;
import com.boehmod.blockfront.C0562jt;
import com.boehmod.blockfront.InterfaceC0481iR;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.security.KeyPair;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.SecretKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cloud/connection/ModConnection.class */
public class ModConnection extends Connection<C0482iS> {

    @NotNull
    private final ExecutorService connectionExecutor;
    public static final int CONNECT_TIME_MAX_TICKS = 600;
    public static final int LOGIN_TIME_MAX_TICKS = 100;

    @NotNull
    private static final AtomicBoolean ATTEMPTING_CONNECTION = new AtomicBoolean(false);
    public static final int MAX_IDLE_TICKS = 600;
    public static final int HEARTBEAT_INTERVAL_TICKS = 300;

    @NotNull
    private final InterfaceC0481iR clientConnection;

    @NotNull
    private final AbstractC0563ju<?, ?, ?> modManager;

    @NotNull
    private final EventLoopGroup eventLoopGroup;

    @Nullable
    private Channel channel;

    @NotNull
    private final Queue<IPacket> incomingPackets;
    private volatile boolean running;
    private int connectionHeartBeat;
    private int connectionTick;
    private int loginSendTimer;

    @Nullable
    private C0482iS playerCloudData;

    @Nullable
    private KeyPair clientKeyPair;

    public ModConnection(@NotNull InterfaceC0481iR interfaceC0481iR, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        super(600);
        this.connectionExecutor = Executors.newSingleThreadExecutor(runnable -> {
            Thread thread = new Thread(runnable, "Cloud-Connection-Worker");
            thread.setDaemon(true);
            return thread;
        });
        this.incomingPackets = new ConcurrentLinkedQueue();
        this.running = false;
        this.connectionHeartBeat = 0;
        this.connectionTick = 600;
        this.loginSendTimer = 100;
        this.playerCloudData = null;
        this.clientConnection = interfaceC0481iR;
        this.modManager = abstractC0563ju;
        this.eventLoopGroup = new NioEventLoopGroup(2);
    }

    public int getLoginSendTimer() {
        return this.loginSendTimer;
    }

    public void attemptConnection() {
        if (getStatus().isClosed()) {
            try {
                String strMo1725a = this.clientConnection.mo1725a();
                int iMo1727c = this.clientConnection.mo1727c();
                C0562jt.log("[Connection Handler] Connecting to '%s:%d'", strMo1725a, Integer.valueOf(iMo1727c));
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(this.eventLoopGroup).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000).handler(new ModConnectionChannelInitializer(this));
                bootstrap.connect(strMo1725a, iMo1727c).addListener(channelFuture -> {
                    try {
                        try {
                            if (channelFuture.isSuccess()) {
                                C0562jt.log("[Connection Handler] Connection established", new Object[0]);
                                this.channel = channelFuture.channel();
                                this.running = true;
                                sendCredentials();
                                C0562jt.log("[Cloud] Established connection to the cloud.", new Object[0]);
                            } else {
                                setStatus(ConnectionStatus.CLOSED, ConnectionStatusContext.CLIENT);
                                C0562jt.log("[Connection Handler] Failed to connect to the cloud: %s", channelFuture.cause().getMessage());
                                if (!channelFuture.isCancelled()) {
                                    channelFuture.cancel(true);
                                }
                            }
                            ATTEMPTING_CONNECTION.set(false);
                        } catch (Exception e) {
                            C0562jt.m2516a("[Connection Handler] Error in connection callback", e, new Object[0]);
                            setStatus(ConnectionStatus.CLOSED, ConnectionStatusContext.CLIENT);
                            ATTEMPTING_CONNECTION.set(false);
                        }
                    } catch (Throwable th) {
                        ATTEMPTING_CONNECTION.set(false);
                        throw th;
                    }
                });
            } catch (Exception e) {
                C0562jt.m2516a("[Connection Handler] An error occurred while attempting to connect to the cloud.", e, new Object[0]);
                setStatus(ConnectionStatus.CLOSED, ConnectionStatusContext.CLIENT);
                ATTEMPTING_CONNECTION.set(false);
            }
        }
    }

    private void sendCredentials() {
        if (this.channel != null) {
            try {
                if (this.channel.isActive()) {
                    try {
                        this.clientKeyPair = EncryptionUtils.generateECDHKeyPair();
                        C0562jt.log("[Connection Handler] Generated ECDH key pair for encryption", new Object[0]);
                        EncryptedConnectionCredentials encryptedConnectionCredentials = new EncryptedConnectionCredentials(this.clientConnection.getType(), getUUID(), getUsername(), getVersion(), getVersionHash(), getHardwareId(), this.clientKeyPair.getPublic());
                        C0562jt.log("[Connection Handler] Sending credentials - UUID: %s, Username: %s, Channel: %s", getUUID(), getUsername(), this.clientConnection.getType());
                        ByteBuf byteBufBuffer = this.channel.alloc().buffer();
                        encryptedConnectionCredentials.writeCredentials(byteBufBuffer);
                        this.channel.writeAndFlush(byteBufBuffer);
                    } catch (Exception e) {
                        C0562jt.m2516a("[Connection Handler] Failed to generate encryption keys - cannot connect without encryption", e, new Object[0]);
                        disconnect("Failed to generate encryption keys", false);
                    }
                }
            } catch (Exception e2) {
                C0562jt.m2516a("[Connection Handler] Error sending credentials", e2, new Object[0]);
                disconnect("Error sending credentials: " + e2.getMessage(), false);
            }
        }
    }

    protected void addIncomingPacket(@NotNull IPacket iPacket) {
        this.incomingPackets.add(iPacket);
    }

    public void handleEncryptionKeyExchange(@NotNull EncryptionKeyExchangePacket encryptionKeyExchangePacket) {
        if (this.clientKeyPair == null) {
            C0562jt.log("[Connection Handler] Received encryption key but client key pair is null", new Object[0]);
            return;
        }
        try {
            SecretKey secretKeyDeriveSharedSecret = EncryptionUtils.deriveSharedSecret(this.clientKeyPair.getPrivate(), encryptionKeyExchangePacket.serverPublicKey());
            if (this.channel != null && this.channel.pipeline() != null) {
                ChannelPipeline channelPipelinePipeline = this.channel.pipeline();
                AESDecryptionHandler aESDecryptionHandler = new AESDecryptionHandler(secretKeyDeriveSharedSecret);
                AESEncryptionHandler aESEncryptionHandler = new AESEncryptionHandler(secretKeyDeriveSharedSecret, false);
                channelPipelinePipeline.addAfter("frameEncoder", EncryptionUtils.PIPELINE_ENCRYPTION, aESEncryptionHandler);
                channelPipelinePipeline.addAfter("frameDecoder", EncryptionUtils.PIPELINE_DECRYPTION, aESDecryptionHandler);
                aESDecryptionHandler.activateDecryption();
                aESEncryptionHandler.activateEncryption();
                C0562jt.log("[Connection Handler] Encryption activated successfully", new Object[0]);
                sendPacket(new EncryptionReadyPacket());
                C0562jt.log("[Connection Handler] Sent encryption ready confirmation to server", new Object[0]);
            }
        } catch (Exception e) {
            C0562jt.m2516a("[Connection Handler] Failed to establish encryption", e, new Object[0]);
            disconnect("Failed to establish encryption: " + e.getMessage(), false);
        }
    }

    private void sendLogin() {
        if (this.running && this.channel != null && this.channel.isActive()) {
            try {
                sendPacket(new ClientLoginPacket(this.clientConnection.mo1726b(), this.clientConnection.mo1724b()));
                C0562jt.log("[Connection Handler] Login packet sent", new Object[0]);
            } catch (Exception e) {
                C0562jt.m2516a("[Connection Handler] Error sending login packet", e, new Object[0]);
                disconnect("Error sending login packet: " + e.getMessage(), false);
            }
        }
    }

    public int getReconnectTickCount() {
        return 600 - this.connectionTick;
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    public void sendPacket(@NotNull IPacket iPacket) {
        if (this.running && this.channel != null && this.channel.isActive()) {
            try {
                this.channel.writeAndFlush(iPacket);
            } catch (Exception e) {
                C0562jt.m2516a("[Connection Handler] Failed to send packet", e, new Object[0]);
                disconnect("Failed to send packet: " + e.getMessage(), false);
            }
        }
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    public <T extends IPacket> void onIllegalPacket(@NotNull T t, @NotNull ConnectionType connectionType, @NotNull ConnectionType connectionType2) {
        C0562jt.log("[Connection Handler] Illegal packet: %s (Expected: %s, Actual: %s)", t.getClass().getSimpleName(), connectionType2, connectionType);
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    public void onConnectionStatusChanged(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatusContext connectionStatusContext) {
        if (connectionStatusContext == ConnectionStatusContext.CLOUD) {
            C0562jt.log("[Connection Handler] Received status change from cloud to '%s'.", connectionStatus.name());
        } else {
            C0562jt.log("[Connection Handler] Performed local status change to '%s'.", connectionStatus.name());
        }
        if (connectionStatus != ConnectionStatus.CONNECTED_VERIFIED) {
            this.loginSendTimer = 100;
        }
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    public C0482iS getPlayerCloudData() {
        if (getType() != ConnectionType.PLAYER) {
            throw new IllegalStateException("Cannot get player data for non-player connection.");
        }
        if (this.playerCloudData != null) {
            return this.playerCloudData;
        }
        this.playerCloudData = this.modManager.m2528a().m1132a(getUUID());
        return this.playerCloudData;
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    public void setStatus(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatusContext connectionStatusContext) {
        ConnectionStatus status = getStatus();
        super.setStatus(connectionStatus, connectionStatusContext);
        if (status != connectionStatus) {
            this.modManager.mo2553a(status, connectionStatus, connectionStatusContext);
        }
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    protected void onUpdate() {
        IPacket iPacketPoll;
        int i = 0;
        while (i < 10 && (iPacketPoll = this.incomingPackets.poll()) != null) {
            try {
                if (shouldHandlePacket(iPacketPoll)) {
                    PacketRegistry.processPacket(iPacketPoll, getType(), this);
                }
                i++;
            } catch (Exception e) {
                C0562jt.m2516a("[Connection Handler] Error processing packet", e, new Object[0]);
            }
        }
        if (getStatus().isClosed()) {
            int i2 = this.connectionTick;
            this.connectionTick = i2 + 1;
            if (i2 > 600) {
                this.connectionTick = 0;
                if (ATTEMPTING_CONNECTION.compareAndSet(false, true)) {
                    this.connectionExecutor.submit(() -> {
                        try {
                            try {
                                if (this.clientConnection.mo1730a()) {
                                    attemptConnection();
                                }
                                ATTEMPTING_CONNECTION.set(false);
                            } catch (Exception e2) {
                                C0562jt.m2516a("[Connection Handler] Error in connection check thread", e2, new Object[0]);
                                ATTEMPTING_CONNECTION.set(false);
                            }
                        } catch (Throwable th) {
                            ATTEMPTING_CONNECTION.set(false);
                            throw th;
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        if (getStatus() == ConnectionStatus.CONNECTED_NOT_VERIFIED) {
            int i3 = this.loginSendTimer;
            this.loginSendTimer = i3 - 1;
            if (i3 <= 0) {
                this.loginSendTimer = 100;
                C0562jt.log("[Connection Handler] Sending login attempt to cloud...", new Object[0]);
                sendLogin();
            }
        } else {
            this.loginSendTimer = 100;
        }
        int i4 = this.connectionHeartBeat;
        this.connectionHeartBeat = i4 + 1;
        if (i4 >= 300) {
            sendPacket(new ClientHeartBeatPacket());
            this.connectionHeartBeat = 0;
        }
    }

    public void bumpReconnectTick() {
        this.connectionTick = 600;
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    protected boolean shouldHandlePacket(@NotNull IPacket iPacket) {
        return true;
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    public void disconnect(@NotNull String str, boolean z) {
        if (isConnectionClosed()) {
            return;
        }
        if (z && this.running && this.channel != null && this.channel.isActive()) {
            try {
                this.channel.writeAndFlush(new ClientLogoutPacket()).awaitUninterruptibly(1L, TimeUnit.SECONDS);
            } catch (Exception e) {
                C0562jt.m2516a("[Connection Handler] Error sending logout packet", e, new Object[0]);
            }
        }
        if (this.channel != null) {
            this.channel.close();
            this.channel = null;
        }
        this.running = false;
        setStatus(ConnectionStatus.CLOSED, ConnectionStatusContext.CLIENT);
        C0562jt.log("[Connection Handler] Disconnected: %s", str);
        C0562jt.log("[Cloud] Lost connection to the cloud.", new Object[0]);
        this.loginSendTimer = 100;
    }

    public void shutdown() {
        disconnect("Client shutting down", true);
        try {
            this.connectionExecutor.shutdown();
            if (!this.connectionExecutor.awaitTermination(500L, TimeUnit.MILLISECONDS)) {
                this.connectionExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            this.connectionExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        this.eventLoopGroup.shutdownGracefully();
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    @NotNull
    public UUID getUUID() {
        return this.clientConnection.mo1723a();
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    public byte[] getHardwareId() {
        return this.clientConnection.getHardwareId();
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    @NotNull
    public String getUsername() {
        return this.clientConnection.getUsername();
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    @NotNull
    public String getVersion() {
        return this.clientConnection.getVersion();
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    @NotNull
    public String getVersionHash() {
        return this.clientConnection.getVersionHash();
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    @NotNull
    public ConnectionType getType() {
        return this.clientConnection.getType();
    }
}
