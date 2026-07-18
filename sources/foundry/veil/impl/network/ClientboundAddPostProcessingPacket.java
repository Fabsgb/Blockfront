package foundry.veil.impl.network;

import foundry.veil.Veil;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/network/ClientboundAddPostProcessingPacket.class */
public final class ClientboundAddPostProcessingPacket extends Record implements CustomPacketPayload {
    private final int priority;
    private final ResourceLocation pipeline;
    public static final StreamCodec<FriendlyByteBuf, ClientboundAddPostProcessingPacket> CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.priority();
    }, ResourceLocation.STREAM_CODEC, (v0) -> {
        return v0.pipeline();
    }, (v1, v2) -> {
        return new ClientboundAddPostProcessingPacket(v1, v2);
    });
    public static final CustomPacketPayload.Type<ClientboundAddPostProcessingPacket> TYPE = new CustomPacketPayload.Type<>(Veil.veilPath("add_post_processing"));

    public ClientboundAddPostProcessingPacket(int priority, ResourceLocation pipeline) {
        this.priority = priority;
        this.pipeline = pipeline;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ClientboundAddPostProcessingPacket.class), ClientboundAddPostProcessingPacket.class, "priority;pipeline", "FIELD:Lfoundry/veil/impl/network/ClientboundAddPostProcessingPacket;->priority:I", "FIELD:Lfoundry/veil/impl/network/ClientboundAddPostProcessingPacket;->pipeline:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ClientboundAddPostProcessingPacket.class), ClientboundAddPostProcessingPacket.class, "priority;pipeline", "FIELD:Lfoundry/veil/impl/network/ClientboundAddPostProcessingPacket;->priority:I", "FIELD:Lfoundry/veil/impl/network/ClientboundAddPostProcessingPacket;->pipeline:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ClientboundAddPostProcessingPacket.class, Object.class), ClientboundAddPostProcessingPacket.class, "priority;pipeline", "FIELD:Lfoundry/veil/impl/network/ClientboundAddPostProcessingPacket;->priority:I", "FIELD:Lfoundry/veil/impl/network/ClientboundAddPostProcessingPacket;->pipeline:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public int priority() {
        return this.priority;
    }

    public ResourceLocation pipeline() {
        return this.pipeline;
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
