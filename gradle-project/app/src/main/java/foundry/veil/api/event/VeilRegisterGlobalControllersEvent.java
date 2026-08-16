package foundry.veil.api.event;

import foundry.veil.api.flare.modifier.GlobalController;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/event/VeilRegisterGlobalControllersEvent.class */
@FunctionalInterface
public interface VeilRegisterGlobalControllersEvent {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/event/VeilRegisterGlobalControllersEvent$Registry.class */
    @FunctionalInterface
    public interface Registry {
        void registerGlobalController(GlobalController globalController);
    }

    void onRegisterGlobalControllers(Registry registry);
}
