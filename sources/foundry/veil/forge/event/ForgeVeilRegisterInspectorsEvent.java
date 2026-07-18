package foundry.veil.forge.event;

import foundry.veil.api.client.editor.EditorManager;
import foundry.veil.api.client.editor.Inspector;
import foundry.veil.api.event.VeilRegisterInspectorsEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/event/ForgeVeilRegisterInspectorsEvent.class */
public class ForgeVeilRegisterInspectorsEvent extends Event implements IModBusEvent, VeilRegisterInspectorsEvent.Registry {
    private final VeilRegisterInspectorsEvent.Registry registry;

    public ForgeVeilRegisterInspectorsEvent(VeilRegisterInspectorsEvent.Registry registry) {
        this.registry = registry;
    }

    @Override // foundry.veil.api.event.VeilRegisterInspectorsEvent.Registry
    public EditorManager editorManager() {
        return this.registry.editorManager();
    }

    @Override // foundry.veil.api.event.VeilRegisterInspectorsEvent.Registry
    public void registerInspector(Inspector inspector) {
        this.registry.registerInspector(inspector);
    }
}
