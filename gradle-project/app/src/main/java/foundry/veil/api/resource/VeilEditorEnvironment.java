package foundry.veil.api.resource;

import foundry.veil.Veil;
import foundry.veil.api.client.registry.VeilResourceEditorRegistry;
import foundry.veil.api.resource.editor.ResourceFileEditor;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/resource/VeilEditorEnvironment.class */
public interface VeilEditorEnvironment {
    <T extends VeilResource<?>> void open(T t, ResourceFileEditor.Factory<T> factory);

    VeilResourceManager getResourceManager();

    default void open(VeilResource<?> resource, ResourceLocation editorName) {
        ResourceFileEditor.Factory factory = (ResourceFileEditor.Factory) VeilResourceEditorRegistry.REGISTRY.get(editorName);
        if (factory == null) {
            Veil.LOGGER.error("Failed to find editor for resource: {}", resource.resourceInfo().location());
        } else {
            open(resource, (ResourceFileEditor.Factory<VeilResource<?>>) factory);
        }
    }
}
