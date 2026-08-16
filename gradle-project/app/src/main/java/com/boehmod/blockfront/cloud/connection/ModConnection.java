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
import com.boehmod.bflib.cloud.packet.PacketCodec;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import com.boehmod.bflib.cloud.packet.primitives.ClientHeartBeatPacket;
import com.boehmod.bflib.cloud.packet.primitives.ClientLoginPacket;
import com.boehmod.bflib.cloud.packet.primitives.ClientLogoutPacket;
import com.boehmod.bflib.cloud.packet.primitives.CloudConnectionStatusPacket;
import com.boehmod.bflib.cloud.packet.primitives.CloudDisconnectedPacket;
import com.boehmod.bflib.cloud.packet.primitives.EncryptionKeyExchangePacket;
import com.boehmod.bflib.cloud.packet.primitives.EncryptionReadyPacket;
import com.boehmod.blockfront.AbstractC0531jN;
import com.boehmod.blockfront.C0530jM;
import com.boehmod.blockfront.C0555jl;
import com.boehmod.blockfront.InterfaceC0554jk;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.security.KeyPair;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.SecretKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cloud/connection/ModConnection.class */
public class ModConnection extends Connection<C0555jl> {
    public static final int CONNECT_TIME_MAX_TICKS = 600;
    public static final int CONNECT_JITTER_MAX_TICKS = 300;
    public static final int LOGIN_TIME_MAX_TICKS = 100;

    @NotNull
    private static final AtomicBoolean ATTEMPTING_CONNECTION = new AtomicBoolean(false);
    public static final int MAX_IDLE_SECONDS = 30;
    public static final int HEARTBEAT_INTERVAL_TICKS = 300;

    @NotNull
    private final InterfaceC0554jk clientConnection;

    @NotNull
    private final AbstractC0531jN<?, ?, ?> modManager;

    @Nullable
    private volatile Channel channel;

    @Nullable
    private KeyPair clientKeyPair;

    @NotNull
    private final ExecutorService connectionExecutor = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, "Cloud-Connection-Worker");
        thread.setDaemon(true);
        return thread;
    });
    private volatile boolean running = false;
    private volatile boolean encryptionActive = false;

    @NotNull
    private final IntSet refusedPacketTypes = new IntOpenHashSet();
    private int connectionHeartBeat = 0;
    private int connectionTick = CONNECT_TIME_MAX_TICKS;
    private int connectionTickTarget = CONNECT_TIME_MAX_TICKS;
    private int loginSendTimer = 100;

    @Nullable
    private C0555jl playerCloudData = null;

    @NotNull
    private final EventLoopGroup eventLoopGroup = new NioEventLoopGroup(1);

    public ModConnection(@NotNull InterfaceC0554jk interfaceC0554jk, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        this.clientConnection = interfaceC0554jk;
        this.modManager = abstractC0531jN;
    }

    public int getLoginSendTimer() {
        return this.loginSendTimer;
    }

    public void attemptConnection() {
        if (getStatus().isClosed()) {
            try {
                String strMo1731a = this.clientConnection.mo1731a();
                int iMo1733c = this.clientConnection.mo1733c();
                this.encryptionActive = false;
                C0530jM.log("[Connection Handler] Connecting to '%s:%d'", strMo1731a, Integer.valueOf(iMo1733c));
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(this.eventLoopGroup).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000).handler(new ModConnectionChannelInitializer(this));
                bootstrap.connect(strMo1731a, iMo1733c).addListener(channelFuture -> {
                    AtomicBoolean atomicBoolean;
                    try {
                        if (channelFuture.isSuccess()) {
                            C0530jM.log("[Connection Handler] Connection established", new Object[0]);
                            this.channel = channelFuture.channel();
                            this.running = true;
                            sendCredentials();
                            C0530jM.log("[Cloud] Established connection to the cloud.", new Object[0]);
                        } else {
                            setStatus(ConnectionStatus.CLOSED, ConnectionStatusContext.CLIENT);
                            C0530jM.log("[Connection Handler] Failed to connect to the cloud: %s", channelFuture.cause().getMessage());
                            if (!channelFuture.isCancelled()) {
                                channelFuture.cancel(true);
                            }
                        }
                        atomicBoolean = ATTEMPTING_CONNECTION;
                    } catch (Exception e) {
                        C0530jM.m2338a("[Connection Handler] Error in connection callback", e, new Object[0]);
                        setStatus(ConnectionStatus.CLOSED, ConnectionStatusContext.CLIENT);
                        atomicBoolean = ATTEMPTING_CONNECTION;
                    } finally {
                        ATTEMPTING_CONNECTION.set(false);
                    }
                });
            } catch (Exception e) {
                C0530jM.m2338a("[Connection Handler] An error occurred while attempting to connect to the cloud.", e, new Object[0]);
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
                        C0530jM.log("[Connection Handler] Generated ECDH key pair for encryption", new Object[0]);
                        EncryptedConnectionCredentials encryptedConnectionCredentials = new EncryptedConnectionCredentials(this.clientConnection.getType(), getUUID(), getUsername(), getVersion(), getVersionHash(), getHardwareId(), this.clientKeyPair.getPublic());
                        C0530jM.log("[Connection Handler] Sending credentials - UUID: %s, Username: %s, Channel: %s", getUUID(), getUsername(), this.clientConnection.getType());
                        ByteBuf byteBufBuffer = this.channel.alloc().buffer();
                        encryptedConnectionCredentials.writeCredentials(byteBufBuffer);
                        this.channel.writeAndFlush(byteBufBuffer);
                    } catch (Exception e) {
                        C0530jM.m2338a("[Connection Handler] Failed to generate encryption keys - cannot connect without encryption", e, new Object[0]);
                        disconnect("Failed to generate encryption keys", false);
                    }
                }
            } catch (Exception e2) {
                C0530jM.m2338a("[Connection Handler] Error sending credentials", e2, new Object[0]);
                disconnect("Error sending credentials: " + e2.getMessage(), false);
            }
        }
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    protected void onPacketQueueOverflow() {
        disconnect("Packet queue overflow", false);
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    protected void onPacketProcessError(@NotNull IPacket iPacket, @NotNull Exception exc) {
        C0530jM.m2338a("[Connection Handler] Error processing packet", exc, new Object[0]);
    }

    public void handleEncryptionKeyExchange(@NotNull EncryptionKeyExchangePacket encryptionKeyExchangePacket) {
        if (this.clientKeyPair == null) {
            C0530jM.log("[Connection Handler] Received encryption key but client key pair is null", new Object[0]);
            return;
        }
        try {
            SecretKey secretKeyDeriveSharedSecret = EncryptionUtils.deriveSharedSecret(this.clientKeyPair.getPrivate(), encryptionKeyExchangePacket.serverPublicKey());
            if (this.channel != null && this.channel.pipeline() != null) {
                ChannelPipeline channelPipelinePipeline = this.channel.pipeline();
                AESDecryptionHandler aESDecryptionHandler = new AESDecryptionHandler(secretKeyDeriveSharedSecret, false);
                AESEncryptionHandler aESEncryptionHandler = new AESEncryptionHandler(secretKeyDeriveSharedSecret, false);
                channelPipelinePipeline.addAfter(PacketCodec.PIPELINE_FRAME_ENCODER, EncryptionUtils.PIPELINE_ENCRYPTION, aESEncryptionHandler);
                channelPipelinePipeline.addAfter(PacketCodec.PIPELINE_FRAME_DECODER, EncryptionUtils.PIPELINE_DECRYPTION, aESDecryptionHandler);
                aESDecryptionHandler.activateDecryption();
                aESEncryptionHandler.activateEncryption();
                this.encryptionActive = true;
                C0530jM.log("[Connection Handler] Encryption activated successfully", new Object[0]);
                sendPacket(new EncryptionReadyPacket());
                C0530jM.log("[Connection Handler] Sent encryption ready confirmation to server", new Object[0]);
            }
        } catch (Exception e) {
            C0530jM.m2338a("[Connection Handler] Failed to establish encryption", e, new Object[0]);
            disconnect("Failed to establish encryption: " + e.getMessage(), false);
        }
    }

    private void sendLogin() {
        if (this.running && this.channel != null && this.channel.isActive()) {
            try {
                sendPacket(new ClientLoginPacket(this.clientConnection.mo1732b(), this.clientConnection.mo1730b()));
                C0530jM.log("[Connection Handler] Login packet sent", new Object[0]);
            } catch (Exception e) {
                C0530jM.m2338a("[Connection Handler] Error sending login packet", e, new Object[0]);
                disconnect("Error sending login packet: " + e.getMessage(), false);
            }
        }
    }

    public int getReconnectTickCount() {
        return this.connectionTickTarget - this.connectionTick;
    }

    public int getReconnectTickTarget() {
        return this.connectionTickTarget;
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    public void sendPacket(@NotNull IPacket iPacket) {
        if (this.running && this.channel != null && this.channel.isActive()) {
            try {
                writeAndFlush(this.channel, iPacket);
            } catch (Exception e) {
                C0530jM.m2338a("[Connection Handler] Failed to send packet", e, new Object[0]);
                disconnect("Failed to send packet: " + e.getMessage(), false);
            }
        }
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    protected void onSendFailure(@NotNull IPacket iPacket, @NotNull Throwable th) {
        C0530jM.m2338a("[Connection Handler] Failed to send packet " + iPacket.getClass().getSimpleName(), th, new Object[0]);
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    public <T extends IPacket> void onIllegalPacket(@NotNull T t, @NotNull ConnectionType connectionType, @NotNull ConnectionType connectionType2) {
        C0530jM.log("[Connection Handler] Illegal packet: %s (Expected: %s, Actual: %s)", t.getClass().getSimpleName(), connectionType2, connectionType);
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    public void onConnectionStatusChanged(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatusContext connectionStatusContext) {
        if (connectionStatusContext == ConnectionStatusContext.CLOUD) {
            C0530jM.log("[Connection Handler] Received status change from cloud to '%s'.", connectionStatus.name());
        } else {
            C0530jM.log("[Connection Handler] Performed local status change to '%s'.", connectionStatus.name());
        }
        if (connectionStatus != ConnectionStatus.CONNECTED_VERIFIED) {
            this.loginSendTimer = 100;
        }
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    public C0555jl getPlayerCloudData() {
        if (getType() != ConnectionType.PLAYER) {
            throw new IllegalStateException("Cannot get player data for non-player connection.");
        }
        if (this.playerCloudData != null) {
            return this.playerCloudData;
        }
        this.playerCloudData = this.modManager.m2351a().m1149a(getUUID());
        return this.playerCloudData;
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    public void setStatus(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatusContext connectionStatusContext) {
        ConnectionStatus status = getStatus();
        super.setStatus(connectionStatus, connectionStatusContext);
        if (status != connectionStatus) {
            this.modManager.mo2376a(status, connectionStatus, connectionStatusContext);
        }
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    protected void onUpdate() {
        if (getStatus().isClosed()) {
            int i = this.connectionTick;
            this.connectionTick = i + 1;
            if (i > this.connectionTickTarget) {
                this.connectionTick = 0;
                this.connectionTickTarget = CONNECT_TIME_MAX_TICKS + ThreadLocalRandom.current().nextInt(300);
                if (ATTEMPTING_CONNECTION.compareAndSet(false, true)) {
                    this.connectionExecutor.submit(() -> {
                        AtomicBoolean atomicBoolean;
                        try {
                            if (this.clientConnection.mo1736a()) {
                                attemptConnection();
                            }
                            atomicBoolean = ATTEMPTING_CONNECTION;
                        } catch (Exception e) {
                            C0530jM.m2338a("[Connection Handler] Error in connection check thread", e, new Object[0]);
                            atomicBoolean = ATTEMPTING_CONNECTION;
                        } finally {
                            ATTEMPTING_CONNECTION.set(false);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        if (getStatus() == ConnectionStatus.CONNECTED_NOT_VERIFIED) {
            int i2 = this.loginSendTimer;
            this.loginSendTimer = i2 - 1;
            if (i2 <= 0) {
                this.loginSendTimer = 100;
                if (this.encryptionActive) {
                    C0530jM.log("[Connection Handler] Sending login attempt to cloud...", new Object[0]);
                    sendLogin();
                } else {
                    C0530jM.log("[Connection Handler] Withholding login, encryption is not active.", new Object[0]);
                }
            }
        } else {
            this.loginSendTimer = 100;
        }
        int i3 = this.connectionHeartBeat;
        this.connectionHeartBeat = i3 + 1;
        if (i3 >= 300) {
            sendPacket(new ClientHeartBeatPacket());
            this.connectionHeartBeat = 0;
        }
    }

    public void bumpReconnectTick() {
        this.connectionTick = this.connectionTickTarget;
    }

    @Override // com.boehmod.bflib.cloud.connection.Connection
    protected boolean shouldHandlePacket(@NotNull IPacket iPacket) {
        if ((iPacket instanceof CloudConnectionStatusPacket) || (iPacket instanceof CloudDisconnectedPacket)) {
            return true;
        }
        ConnectionStatus status = getStatus();
        if (status == ConnectionStatus.CONNECTED_NOT_ENCRYPTED) {
            return iPacket instanceof EncryptionKeyExchangePacket;
        }
        PacketIdentifier packetIdentifier = iPacket.getPacketIdentifier();
        if (!status.isVerified() && this.refusedPacketTypes.add(packetIdentifier.hash())) {
            C0530jM.log("[Connection Handler] Refused '%s' received while %s", packetIdentifier.identifier(), status);
        }
        return status.isVerified();
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
                C0530jM.m2338a("[Connection Handler] Error sending logout packet", e, new Object[0]);
            }
        }
        if (this.channel != null) {
            this.channel.close();
            this.channel = null;
        }
        this.running = false;
        setStatus(ConnectionStatus.CLOSED, ConnectionStatusContext.CLIENT);
        C0530jM.log("[Connection Handler] Disconnected: %s", str);
        C0530jM.log("[Cloud] Lost connection to the cloud.", new Object[0]);
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
        return this.clientConnection.mo1729a();
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
