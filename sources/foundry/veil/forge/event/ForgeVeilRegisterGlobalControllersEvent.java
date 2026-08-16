package foundry.veil.forge.event;

import foundry.veil.api.event.VeilRegisterGlobalControllersEvent;
import foundry.veil.api.flare.modifier.GlobalController;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/event/ForgeVeilRegisterGlobalControllersEvent.class */
public class ForgeVeilRegisterGlobalControllersEvent extends Event implements IModBusEvent, VeilRegisterGlobalControllersEvent.Registry {
    private final VeilRegisterGlobalControllersEvent.Registry registry;

    public ForgeVeilRegisterGlobalControllersEvent(VeilRegisterGlobalControllersEvent.Registry registry) {
        this.registry = registry;
    }

    @Override // foundry.veil.api.event.VeilRegisterGlobalControllersEvent.Registry
    public void registerGlobalController(GlobalController globalController) {
        this.registry.registerGlobalController(globalController);
    }
}
