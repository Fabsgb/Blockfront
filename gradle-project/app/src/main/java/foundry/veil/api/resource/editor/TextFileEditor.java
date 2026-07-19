package foundry.veil.api.resource.editor;

import foundry.veil.api.resource.VeilEditorEnvironment;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.api.resource.type.VeilTextResource;
import imgui.ImGui;
import imgui.type.ImBoolean;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/resource/editor/TextFileEditor.class */
@ApiStatus.Internal
public class TextFileEditor implements ResourceFileEditor<VeilTextResource<?>> {
    private static final Component SAVE = Component.translatable("gui.veil.save");
    private final VeilResourceManager resourceManager;
    private final VeilTextResource<?> resource;
    private final ImBoolean open = new ImBoolean(true);

    public TextFileEditor(VeilEditorEnvironment environment, VeilTextResource<?> resource) {
        this.resourceManager = environment.getResourceManager();
        this.resource = resource;
        loadFromDisk();
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public void render() {
        if (ImGui.begin("Info", this.open)) {
            ImGui.text("Text Editing is disabled for now. Use an external editor with hotswapping until re-implemented.");
        }
        ImGui.end();
        if (ImGui.beginPopupModal("###open_failed")) {
            ImGui.text("Failed to open file");
            ImGui.endPopup();
        }
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public void loadFromDisk() {
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public boolean isClosed() {
        return !this.open.get();
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public VeilTextResource<?> getResource() {
        return this.resource;
    }
}
