package foundry.veil.api.client.editor;

import foundry.veil.api.client.render.VeilRenderSystem;
import imgui.ImGui;
import imgui.type.ImBoolean;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/editor/SingleWindowInspector.class */
public abstract class SingleWindowInspector implements Inspector {
    protected final ImBoolean open = new ImBoolean();

    protected abstract void renderComponents();

    @Override // foundry.veil.api.client.editor.Inspector
    public void render() {
        if (ImGui.begin(getWindowTitle().getString(), this.open)) {
            renderComponents();
        }
        ImGui.end();
        if (!this.open.get()) {
            VeilRenderSystem.renderer().getEditorManager().hide(this);
        }
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public void onShow() {
        this.open.set(true);
    }

    protected Component getWindowTitle() {
        return getDisplayName();
    }
}
