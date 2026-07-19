package foundry.veil.impl.network;

import foundry.veil.Veil;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/network/ClientboundRemovePostProcessingPacket.class */
public final class ClientboundRemovePostProcessingPacket extends Record implements CustomPacketPayload {
    private final ResourceLocation pipeline;
    public static final StreamCodec<ByteBuf, ClientboundRemovePostProcessingPacket> CODEC = ResourceLocation.STREAM_CODEC.map(ClientboundRemovePostProcessingPacket::new, (v0) -> {
        return v0.pipeline();
    });
    public static final CustomPacketPayload.Type<ClientboundRemovePostProcessingPacket> TYPE = new CustomPacketPayload.Type<>(Veil.veilPath("remove_post_processing"));

    public ClientboundRemovePostProcessingPacket(ResourceLocation pipeline) {
        this.pipeline = pipeline;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ClientboundRemovePostProcessingPacket.class), ClientboundRemovePostProcessingPacket.class, "pipeline", "FIELD:Lfoundry/veil/impl/network/ClientboundRemovePostProcessingPacket;->pipeline:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ClientboundRemovePostProcessingPacket.class), ClientboundRemovePostProcessingPacket.class, "pipeline", "FIELD:Lfoundry/veil/impl/network/ClientboundRemovePostProcessingPacket;->pipeline:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ClientboundRemovePostProcessingPacket.class, Object.class), ClientboundRemovePostProcessingPacket.class, "pipeline", "FIELD:Lfoundry/veil/impl/network/ClientboundRemovePostProcessingPacket;->pipeline:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public ResourceLocation pipeline() {
        return this.pipeline;
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
