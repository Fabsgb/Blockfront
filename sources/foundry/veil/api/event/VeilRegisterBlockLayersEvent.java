package foundry.veil.api.event;

import net.minecraft.client.renderer.RenderType;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/event/VeilRegisterBlockLayersEvent.class */
@FunctionalInterface
public interface VeilRegisterBlockLayersEvent {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/event/VeilRegisterBlockLayersEvent$Registry.class */
    @FunctionalInterface
    public interface Registry {
        void registerBlockLayer(RenderType renderType);
    }

    void onRegisterBlockLayers(Registry registry);
}
