package foundry.veil.api.event;

import foundry.veil.api.client.editor.EditorManager;
import foundry.veil.api.client.editor.Inspector;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/event/VeilRegisterInspectorsEvent.class */
@FunctionalInterface
public interface VeilRegisterInspectorsEvent {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/event/VeilRegisterInspectorsEvent$Registry.class */
    public interface Registry {
        EditorManager editorManager();

        void registerInspector(Inspector inspector);
    }

    void onRegisterInspectors(Registry registry);
}
