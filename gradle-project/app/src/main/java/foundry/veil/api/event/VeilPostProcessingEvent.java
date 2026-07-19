package foundry.veil.api.event;

import foundry.veil.api.client.render.post.PostPipeline;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/event/VeilPostProcessingEvent.class */
public final class VeilPostProcessingEvent {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/event/VeilPostProcessingEvent$Post.class */
    @FunctionalInterface
    public interface Post {
        void postVeilPostProcessing(ResourceLocation resourceLocation, PostPipeline postPipeline, PostPipeline.Context context);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/event/VeilPostProcessingEvent$Pre.class */
    @FunctionalInterface
    public interface Pre {
        void preVeilPostProcessing(ResourceLocation resourceLocation, PostPipeline postPipeline, PostPipeline.Context context);
    }

    private VeilPostProcessingEvent() {
    }
}
