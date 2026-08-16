package foundry.veil.forge.event;

import foundry.veil.api.event.VeilRegisterBlockLayersEvent;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/event/ForgeVeilRegisterBlockLayersEvent.class */
public class ForgeVeilRegisterBlockLayersEvent extends Event implements VeilRegisterBlockLayersEvent.Registry, IModBusEvent {
    private final VeilRegisterBlockLayersEvent.Registry registry;

    public ForgeVeilRegisterBlockLayersEvent(VeilRegisterBlockLayersEvent.Registry registry) {
        this.registry = registry;
    }

    @Override // foundry.veil.api.event.VeilRegisterBlockLayersEvent.Registry
    public void registerBlockLayer(RenderType renderType) {
        this.registry.registerBlockLayer(renderType);
    }
}
