package foundry.veil.forge.event;

import foundry.veil.api.client.render.VeilRenderer;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/event/ForgeVeilRendererAvailableEvent.class */
public class ForgeVeilRendererAvailableEvent extends Event implements IModBusEvent {
    private final VeilRenderer renderer;

    public ForgeVeilRendererAvailableEvent(VeilRenderer renderer) {
        this.renderer = renderer;
    }

    public VeilRenderer getRenderer() {
        return this.renderer;
    }
}
