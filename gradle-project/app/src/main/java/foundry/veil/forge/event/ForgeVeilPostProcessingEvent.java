package foundry.veil.forge.event;

import foundry.veil.api.client.render.post.PostPipeline;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.Event;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/event/ForgeVeilPostProcessingEvent.class */
public class ForgeVeilPostProcessingEvent extends Event {
    private final ResourceLocation name;
    private final PostPipeline pipeline;
    private final PostPipeline.Context context;

    public ForgeVeilPostProcessingEvent(ResourceLocation name, PostPipeline pipeline, PostPipeline.Context context) {
        this.name = name;
        this.pipeline = pipeline;
        this.context = context;
    }

    public ResourceLocation getName() {
        return this.name;
    }

    public PostPipeline getPipeline() {
        return this.pipeline;
    }

    public PostPipeline.Context getContext() {
        return this.context;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/event/ForgeVeilPostProcessingEvent$Pre.class */
    public static class Pre extends ForgeVeilPostProcessingEvent {
        public Pre(ResourceLocation name, PostPipeline pipeline, PostPipeline.Context context) {
            super(name, pipeline, context);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/event/ForgeVeilPostProcessingEvent$Post.class */
    public static class Post extends ForgeVeilPostProcessingEvent {
        public Post(ResourceLocation name, PostPipeline pipeline, PostPipeline.Context context) {
            super(name, pipeline, context);
        }
    }
}
