package foundry.veil.api.event;

import foundry.veil.api.event.VeilRenderLevelStageEvent;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/event/VeilRegisterFixedBuffersEvent.class */
@FunctionalInterface
public interface VeilRegisterFixedBuffersEvent {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/event/VeilRegisterFixedBuffersEvent$Registry.class */
    @FunctionalInterface
    public interface Registry {
        void registerFixedBuffer(@Nullable VeilRenderLevelStageEvent.Stage stage, RenderType renderType);
    }

    void onRegisterFixedBuffers(Registry registry);
}
