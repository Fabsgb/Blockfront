package foundry.veil.impl.client.editor;

import foundry.veil.api.client.editor.Inspector;
import foundry.veil.api.client.render.VeilRenderSystem;
import imgui.ImGui;
import imgui.type.ImBoolean;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/editor/DemoInspector.class */
@ApiStatus.Internal
public class DemoInspector implements Inspector {
    public static final Component TITLE = Component.translatable("inspector.veil.example.imgui.title");
    private final ImBoolean open = new ImBoolean();

    @Override // foundry.veil.api.client.editor.Inspector
    public void render() {
        ImGui.showDemoWindow(this.open);
        if (!this.open.get()) {
            VeilRenderSystem.renderer().getEditorManager().hide(this);
        }
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public void onShow() {
        this.open.set(true);
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public Component getDisplayName() {
        return TITLE;
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public Component getGroup() {
        return EXAMPLE_GROUP;
    }
}
