package foundry.veil.api.client.editor;

import foundry.veil.api.client.render.VeilRenderSystem;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/editor/Inspector.class */
public interface Inspector extends NativeResource {
    public static final Component DEFAULT_GROUP = Component.translatable("inspector_group.veil.default");
    public static final Component EXAMPLE_GROUP = Component.translatable("inspector_group.veil.example");
    public static final Component RENDERER_GROUP = Component.translatable("inspector_group.veil.renderer");
    public static final Component INFO_GROUP = Component.translatable("inspector_group.veil.info");
    public static final Component RESOURCE_GROUP = Component.translatable("inspector_group.veil.resource");

    void render();

    Component getDisplayName();

    default void renderMenuBar() {
    }

    default void renderLast() {
    }

    default Component getGroup() {
        return DEFAULT_GROUP;
    }

    default boolean isEnabled() {
        return true;
    }

    default boolean isMenuBarEnabled() {
        return false;
    }

    default void onShow() {
    }

    default void onHide() {
    }

    default boolean isOpen() {
        return VeilRenderSystem.renderer().getEditorManager().isVisible(this);
    }

    default void free() {
    }

    static Component group(ResourceLocation id) {
        return Component.translatable("editor_group." + id.getNamespace() + "." + id.getPath());
    }
}
