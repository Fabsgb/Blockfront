package foundry.veil.api.event;

import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/event/VeilRegisterFixedBuffersEvent.class */
@FunctionalInterface
public interface VeilRegisterFixedBuffersEvent {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/event/VeilRegisterFixedBuffersEvent$Registry.class */
    @FunctionalInterface
    public interface Registry {
        void registerFixedBuffer(@Nullable VeilRenderLevelStageEvent.Stage stage, RenderType renderType);
    }

    void onRegisterFixedBuffers(Registry registry);
}
