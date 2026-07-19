package foundry.veil.api.flare.modifier;

import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import foundry.veil.VeilClient;
import foundry.veil.api.flare.EffectHost;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/modifier/ControllerManager.class */
public class ControllerManager {
    private final Table<String, String, HostBoundController> controllers = Tables.newCustomTable(new WeakHashMap(), WeakHashMap::new);
    private final Map<String, GlobalController> globalControllers = new HashMap();

    public ControllerManager() {
        VeilClient.clientPlatform().onRegisterGlobalControllers(this::addGlobalController);
    }

    public void addController(Controller controller) {
        String name = controller.getName();
        if (name.startsWith("global::") || (controller instanceof GlobalController)) {
            throw new IllegalArgumentException("Global controllers should be ");
        }
        HostBoundController hostBound = (HostBoundController) controller;
        String host = hostBound.getHost();
        this.controllers.put(name, host, hostBound);
    }

    private void addGlobalController(GlobalController globalController) {
        String name = globalController.getName();
        this.globalControllers.put(name, globalController);
    }

    @Nullable
    public Controller getController(String name, String host) {
        if (name.startsWith("global::")) {
            return this.globalControllers.get(name);
        }
        return (Controller) this.controllers.get(name, host);
    }

    public Controller getOrCreateController(String name, EffectHost host) {
        Controller controller = getController(name, host.getName());
        if (controller == null) {
            controller = new HostBoundController(name, host);
            controller.initialize();
            addController(controller);
        }
        return controller;
    }

    public void removeHost(String host) {
        this.controllers.columnKeySet().remove(host);
    }
}
