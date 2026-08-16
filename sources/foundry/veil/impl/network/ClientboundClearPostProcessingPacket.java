package foundry.veil.impl.network;

import foundry.veil.Veil;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/network/ClientboundClearPostProcessingPacket.class */
public enum ClientboundClearPostProcessingPacket implements CustomPacketPayload {
    INSTANCE;

    public static final StreamCodec<ByteBuf, ClientboundClearPostProcessingPacket> CODEC = StreamCodec.unit(INSTANCE);
    public static final CustomPacketPayload.Type<ClientboundClearPostProcessingPacket> TYPE = new CustomPacketPayload.Type<>(Veil.veilPath("clear_post_processing"));

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
