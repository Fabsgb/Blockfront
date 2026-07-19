package foundry.veil.forge.event;

import foundry.veil.api.client.render.dynamicbuffer.DynamicBuffersChange;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/event/ForgeVeilDynamicBuffersChangedEvent.class */
public class ForgeVeilDynamicBuffersChangedEvent extends Event implements IModBusEvent {
    private final DynamicBuffersChange change;

    public ForgeVeilDynamicBuffersChangedEvent(DynamicBuffersChange change) {
        this.change = change;
    }

    public DynamicBuffersChange getChange() {
        return this.change;
    }
}
