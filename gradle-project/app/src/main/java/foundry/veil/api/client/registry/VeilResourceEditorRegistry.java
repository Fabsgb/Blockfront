package foundry.veil.api.client.registry;

import foundry.veil.Veil;
import foundry.veil.api.resource.VeilResource;
import foundry.veil.api.resource.editor.BlockModelInspector;
import foundry.veil.api.resource.editor.EffectInspector;
import foundry.veil.api.resource.editor.FramebufferFileEditor;
import foundry.veil.api.resource.editor.ResourceFileEditor;
import foundry.veil.api.resource.editor.ResourceOverrideEditor;
import foundry.veil.api.resource.editor.ShellInspector;
import foundry.veil.api.resource.editor.TextFileEditor;
import foundry.veil.api.resource.type.BlockModelResource;
import foundry.veil.api.resource.type.FlareResource;
import foundry.veil.api.resource.type.FramebufferResource;
import foundry.veil.api.resource.type.ShellResource;
import foundry.veil.api.resource.type.VeilTextResource;
import foundry.veil.platform.registry.RegistrationProvider;
import foundry.veil.platform.registry.RegistryObject;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/registry/VeilResourceEditorRegistry.class */
public final class VeilResourceEditorRegistry {
    public static final ResourceKey<Registry<ResourceFileEditor.Factory<?>>> REGISTRY_KEY = ResourceKey.createRegistryKey(Veil.veilPath("resource_editor"));
    private static final RegistrationProvider<ResourceFileEditor.Factory<?>> VANILLA_PROVIDER = RegistrationProvider.get(REGISTRY_KEY, Veil.MODID);
    public static final Registry<ResourceFileEditor.Factory<?>> REGISTRY = VANILLA_PROVIDER.asVanillaRegistry();
    public static final RegistryObject<ResourceFileEditor.Factory<VeilTextResource<?>>> TEXT = VANILLA_PROVIDER.register("text", () -> {
        return TextFileEditor::new;
    });
    public static final RegistryObject<ResourceFileEditor.Factory<BlockModelResource>> BLOCK_MODEL = VANILLA_PROVIDER.register("block_model", () -> {
        return BlockModelInspector::new;
    });
    public static final RegistryObject<ResourceFileEditor.Factory<FramebufferResource>> FRAMEBUFFER = VANILLA_PROVIDER.register("framebuffer", () -> {
        return FramebufferFileEditor::new;
    });
    public static final RegistryObject<ResourceFileEditor.Factory<ShellResource>> SHELL = VANILLA_PROVIDER.register("flare_shell", () -> {
        return ShellInspector::new;
    });
    public static final RegistryObject<ResourceFileEditor.Factory<FlareResource>> EFFECT = VANILLA_PROVIDER.register("flare_effect", () -> {
        return EffectInspector::new;
    });
    public static final RegistryObject<ResourceFileEditor.Factory<VeilResource<?>>> OVERRIDE = VANILLA_PROVIDER.register("override", () -> {
        return ResourceOverrideEditor::new;
    });

    private VeilResourceEditorRegistry() {
    }

    @ApiStatus.Internal
    public static void bootstrap() {
    }
}
