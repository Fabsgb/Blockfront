package foundry.veil.impl.network;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.post.PostProcessingManager;
import foundry.veil.api.event.VeilRenderLevelStageEvent;
import foundry.veil.platform.VeilEventPlatform;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/network/VeilClientServerFlags.class */
@ApiStatus.Internal
public final class VeilClientServerFlags {
    private static final Object2IntMap<ResourceLocation> ACTIVE_PIPELINES = new Object2IntOpenHashMap();

    static {
        VeilEventPlatform.INSTANCE.onVeilRenderLevelStage((stage, levelRenderer, bufferSource, matrixStack, frustumMatrix, projectionMatrix, renderTick, deltaTracker, camera, frustum) -> {
            if (stage != VeilRenderLevelStageEvent.Stage.AFTER_SKY || ACTIVE_PIPELINES.isEmpty()) {
                return;
            }
            PostProcessingManager postProcessingManager = VeilRenderSystem.renderer().getPostProcessingManager();
            ObjectIterator it = ACTIVE_PIPELINES.object2IntEntrySet().iterator();
            while (it.hasNext()) {
                Object2IntMap.Entry<ResourceLocation> entry = (Object2IntMap.Entry) it.next();
                postProcessingManager.add(entry.getIntValue(), (ResourceLocation) entry.getKey());
            }
        });
    }

    private VeilClientServerFlags() {
    }

    public static void addPipeline(int priority, ResourceLocation pipeline) {
        VeilRenderSystem.renderer().getPostProcessingManager().add(priority, pipeline);
        ACTIVE_PIPELINES.put(pipeline, priority);
    }

    public static void removePipeline(ResourceLocation pipeline) {
        VeilRenderSystem.renderer().getPostProcessingManager().remove(pipeline);
        ACTIVE_PIPELINES.removeInt(pipeline);
    }

    public static void clearPipelines() {
        PostProcessingManager postProcessingManager = VeilRenderSystem.renderer().getPostProcessingManager();
        ObjectIterator it = ACTIVE_PIPELINES.keySet().iterator();
        while (it.hasNext()) {
            ResourceLocation pipeline = (ResourceLocation) it.next();
            postProcessingManager.remove(pipeline);
        }
        ACTIVE_PIPELINES.clear();
    }

    public static void onDisconnect() {
        clearPipelines();
    }
}
