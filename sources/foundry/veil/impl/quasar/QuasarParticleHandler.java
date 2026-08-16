package foundry.veil.impl.quasar;

import foundry.veil.api.client.render.CachedBufferSource;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.event.VeilRenderLevelStageEvent;
import foundry.veil.platform.VeilEventPlatform;
import net.minecraft.client.multiplayer.ClientLevel;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/quasar/QuasarParticleHandler.class */
@ApiStatus.Internal
public class QuasarParticleHandler {
    private static CachedBufferSource cachedBufferSource;

    public static void free() {
        if (cachedBufferSource != null) {
            cachedBufferSource.free();
            cachedBufferSource = null;
        }
    }

    public static void init() {
        VeilEventPlatform.INSTANCE.onFreeNativeResources(QuasarParticleHandler::free);
        VeilEventPlatform.INSTANCE.onVeilRenderLevelStage((stage, levelRenderer, bufferSource, poseStack, modelMatrix, projectionMatrix, renderTick, deltaTracker, camera, frustum) -> {
            if (stage == VeilRenderLevelStageEvent.Stage.AFTER_WEATHER) {
                if (cachedBufferSource == null) {
                    cachedBufferSource = new CachedBufferSource();
                }
                VeilRenderSystem.renderer().getParticleManager().render(poseStack, cachedBufferSource, camera, VeilRenderSystem.getCullingFrustum(), deltaTracker.getGameTimeDeltaPartialTick(false));
                cachedBufferSource.endBatch();
            }
        });
    }

    public static void setLevel(ClientLevel level) {
        VeilRenderSystem.renderer().getParticleManager().setLevel(level);
        free();
    }
}
