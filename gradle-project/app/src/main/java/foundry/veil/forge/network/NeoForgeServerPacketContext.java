package foundry.veil.forge.network;

import foundry.veil.api.network.handler.ServerPacketContext;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.PacketSendListener;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ClientboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/network/NeoForgeServerPacketContext.class */
@ApiStatus.Internal
public final class NeoForgeServerPacketContext extends Record implements ServerPacketContext {
    private final IPayloadContext context;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, NeoForgeServerPacketContext.class), NeoForgeServerPacketContext.class, "context", "FIELD:Lfoundry/veil/forge/network/NeoForgeServerPacketContext;->context:Lnet/neoforged/neoforge/network/handling/IPayloadContext;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, NeoForgeServerPacketContext.class), NeoForgeServerPacketContext.class, "context", "FIELD:Lfoundry/veil/forge/network/NeoForgeServerPacketContext;->context:Lnet/neoforged/neoforge/network/handling/IPayloadContext;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, NeoForgeServerPacketContext.class, Object.class), NeoForgeServerPacketContext.class, "context", "FIELD:Lfoundry/veil/forge/network/NeoForgeServerPacketContext;->context:Lnet/neoforged/neoforge/network/handling/IPayloadContext;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public IPayloadContext context() {
        return this.context;
    }

    public NeoForgeServerPacketContext(IPayloadContext context) {
        this.context = context;
    }

    @Override // foundry.veil.api.network.handler.ServerPacketContext, foundry.veil.api.network.handler.PacketContext
    @NotNull
    /* JADX INFO: renamed from: player */
    public ServerPlayer mo1889player() {
        return this.context.player();
    }

    @Override // foundry.veil.api.network.handler.PacketContext
    public Packet<?> createPacket(CustomPacketPayload payload) {
        return new ClientboundCustomPayloadPacket(payload);
    }

    @Override // foundry.veil.api.network.handler.PacketContext
    public void sendPacket(Packet<?> packet, @Nullable PacketSendListener callback) {
        this.context.connection().send(packet, callback);
    }

    @Override // foundry.veil.api.network.handler.PacketContext
    public void disconnect(Component disconnectReason) {
        this.context.disconnect(disconnectReason);
    }
}
