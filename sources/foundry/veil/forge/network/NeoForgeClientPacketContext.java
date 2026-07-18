package foundry.veil.forge.network;

import foundry.veil.api.network.handler.ClientPacketContext;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.PacketSendListener;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/network/NeoForgeClientPacketContext.class */
@ApiStatus.Internal
public final class NeoForgeClientPacketContext extends Record implements ClientPacketContext {
    private final IPayloadContext context;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, NeoForgeClientPacketContext.class), NeoForgeClientPacketContext.class, "context", "FIELD:Lfoundry/veil/forge/network/NeoForgeClientPacketContext;->context:Lnet/neoforged/neoforge/network/handling/IPayloadContext;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, NeoForgeClientPacketContext.class), NeoForgeClientPacketContext.class, "context", "FIELD:Lfoundry/veil/forge/network/NeoForgeClientPacketContext;->context:Lnet/neoforged/neoforge/network/handling/IPayloadContext;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, NeoForgeClientPacketContext.class, Object.class), NeoForgeClientPacketContext.class, "context", "FIELD:Lfoundry/veil/forge/network/NeoForgeClientPacketContext;->context:Lnet/neoforged/neoforge/network/handling/IPayloadContext;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public IPayloadContext context() {
        return this.context;
    }

    public NeoForgeClientPacketContext(IPayloadContext context) {
        this.context = context;
    }

    @Override // foundry.veil.api.network.handler.ClientPacketContext
    public Minecraft client() {
        return Minecraft.getInstance();
    }

    @Override // foundry.veil.api.network.handler.ClientPacketContext, foundry.veil.api.network.handler.PacketContext
    /* JADX INFO: renamed from: player */
    public LocalPlayer mo9063player() {
        return this.context.player();
    }

    @Override // foundry.veil.api.network.handler.PacketContext
    public Packet<?> createPacket(CustomPacketPayload payload) {
        return new ServerboundCustomPayloadPacket(payload);
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
