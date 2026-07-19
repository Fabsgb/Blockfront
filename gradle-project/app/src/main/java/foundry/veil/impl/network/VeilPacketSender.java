package foundry.veil.impl.network;

import foundry.veil.Veil;
import foundry.veil.api.network.VeilPacketManager;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/network/VeilPacketSender.class */
@ApiStatus.Internal
public final class VeilPacketSender {
    private static final VeilPacketManager PLAY = VeilPacketManager.create(Veil.MODID, "1");

    private VeilPacketSender() {
    }

    public static void init() {
        PLAY.registerClientbound(ClientboundAddPostProcessingPacket.TYPE, ClientboundAddPostProcessingPacket.CODEC, (payload, ctx) -> {
            VeilClientServerFlags.addPipeline(payload.priority(), payload.pipeline());
        }, true);
        PLAY.registerClientbound(ClientboundClearPostProcessingPacket.TYPE, ClientboundClearPostProcessingPacket.CODEC, (payload2, ctx2) -> {
            VeilClientServerFlags.clearPipelines();
        }, true);
        PLAY.registerClientbound(ClientboundRemovePostProcessingPacket.TYPE, ClientboundRemovePostProcessingPacket.CODEC, (payload3, ctx3) -> {
            VeilClientServerFlags.removePipeline(payload3.pipeline());
        }, true);
    }
}
