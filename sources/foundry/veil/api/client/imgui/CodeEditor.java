package foundry.veil.api.client.imgui;

import com.boehmod.blockfront.InterfaceC1274xN;
import foundry.imgui.api.ImGuiMC;
import imgui.ImGui;
import imgui.ImVec2;
import imgui.extension.texteditor.TextEditor;
import imgui.extension.texteditor.TextEditorCursorPosition;
import imgui.type.ImBoolean;
import java.util.Objects;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/imgui/CodeEditor.class */
public class CodeEditor implements NativeResource {
    private static final Component EDITOR = Component.translatable("editor.veil.default");
    private final Component name;
    private final TextEditor editor;
    private final Component saveText;
    private CharSequence oldSource;
    private SaveCallback saveCallback;
    private String fileName;
    private final ImBoolean open;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/imgui/CodeEditor$SaveCallback.class */
    @FunctionalInterface
    public interface SaveCallback {
        void save(String str, ErrorConsumer errorConsumer);
    }

    public CodeEditor(@Nullable Component saveText) {
        this(EDITOR, saveText);
    }

    public CodeEditor(Component name, @Nullable Component saveText) {
        this.name = name;
        this.editor = new TextEditor();
        this.editor.setShowWhitespacesEnabled(false);
        this.saveText = saveText;
        this.oldSource = null;
        this.saveCallback = null;
        this.open = new ImBoolean();
    }

    public boolean hasTextChanged() {
        return (this.oldSource == null || this.oldSource.equals(this.editor.getText())) ? false : true;
    }

    public void save() {
        ImGuiMC.ActiveContext context = ImGuiMC.withImGui();
        if (context != null) {
            try {
                if (this.saveCallback != null) {
                    SaveCallback saveCallback = this.saveCallback;
                    String text = this.editor.getText();
                    TextEditor textEditor = this.editor;
                    Objects.requireNonNull(textEditor);
                    saveCallback.save(text, textEditor::addMarker);
                }
                if (this.editor.hasMarkers()) {
                    this.oldSource = this.editor.getText();
                }
            } catch (Throwable th) {
                if (context != null) {
                    try {
                        context.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (context != null) {
            context.close();
        }
    }

    public void show(@Nullable String fileName, String source) {
        this.editor.setText(source);
        this.fileName = fileName;
        this.oldSource = this.editor.getText();
        this.editor.clearMarkers();
        this.open.set(true);
        ImGuiMC.ActiveContext context = ImGuiMC.withImGui();
        if (context != null) {
            try {
                ImGui.setWindowFocus("###editor");
                ImGui.setWindowCollapsed("###editor", false);
            } catch (Throwable th) {
                if (context != null) {
                    try {
                        context.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (context != null) {
            context.close();
        }
    }

    public void hide() {
        if (hasTextChanged()) {
            this.open.set(true);
            ImGuiMC.ActiveContext context = ImGuiMC.withImGui();
            if (context != null) {
                try {
                    ImGui.pushID(hashCode());
                    ImGui.openPopup("###save_confirm");
                    ImGui.popID();
                } catch (Throwable th) {
                    if (context != null) {
                        try {
                            context.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            if (context != null) {
                context.close();
                return;
            }
            return;
        }
        this.oldSource = null;
        this.open.set(false);
    }

    public void renderWindow() {
        int flags = 1280;
        if (!this.editor.isReadOnlyEnabled() && hasTextChanged()) {
            flags = 1280 | InterfaceC1274xN.f6861wd;
        }
        if (!this.open.get()) {
            return;
        }
        int id = hashCode();
        ImGui.pushID(id);
        ImGui.setNextWindowSizeConstraints(800.0f, 600.0f, Float.MAX_VALUE, Float.MAX_VALUE);
        if (ImGui.begin(this.name.getString() + (this.fileName != null ? ": " + this.fileName : "") + "###editor" + id, this.open, flags)) {
            render();
        }
        if (!this.open.get()) {
            hide();
        }
        ImGui.end();
        ImGui.popID();
    }

    public void render() {
        ImGui.pushID(hashCode());
        if (this.open.get()) {
            if (!hasTextChanged()) {
                this.editor.clearMarkers();
            }
            if (ImGui.beginMenuBar()) {
                boolean immutable = this.editor.isReadOnlyEnabled();
                if (ImGui.menuItem("Read-only mode", "", immutable)) {
                    this.editor.setReadOnlyEnabled(!immutable);
                }
                if (ImGui.menuItem("Show Whitespace", "", this.editor.isShowWhitespacesEnabled())) {
                    this.editor.setShowWhitespacesEnabled(!this.editor.isShowWhitespacesEnabled());
                }
                if (this.saveText != null && ImGui.menuItem(this.saveText.getString())) {
                    save();
                }
                ImGui.separator();
                ImGui.beginDisabled(immutable);
                ImGui.beginDisabled(!this.editor.canUndo());
                if (ImGui.menuItem("Undo", "ALT-Backspace")) {
                    this.editor.undo();
                }
                ImGui.endDisabled();
                ImGui.beginDisabled(!this.editor.canRedo());
                if (ImGui.menuItem("Redo", "Ctrl-Y")) {
                    this.editor.redo();
                }
                ImGui.endDisabled();
                ImGui.endDisabled();
                ImGui.separator();
                ImGui.beginDisabled(!this.editor.anyCursorHasSelection());
                if (ImGui.menuItem("Copy", "Ctrl-C")) {
                    this.editor.copy();
                }
                ImGui.endDisabled();
                ImGui.beginDisabled(immutable);
                ImGui.beginDisabled(!this.editor.anyCursorHasSelection());
                if (ImGui.menuItem("Cut", "Ctrl-X")) {
                    this.editor.cut();
                }
                ImGui.endDisabled();
                ImGui.beginDisabled(ImGui.getClipboardText() == null);
                if (ImGui.menuItem("Paste", "Ctrl-V")) {
                    this.editor.paste();
                }
                ImGui.endDisabled();
                ImGui.endDisabled();
                ImGui.endMenuBar();
            }
            TextEditorCursorPosition pos = this.editor.getCurrentCursorPosition();
            int cposX = pos.line;
            int cposY = pos.column;
            String overwrite = this.editor.isOverwriteEnabled() ? "Ovr" : "Ins";
            String canUndo = this.editor.canUndo() ? "*" : " ";
            ImGui.text(cposX + ":" + cposY + " " + this.editor.getLineCount() + " lines | " + overwrite + " | " + canUndo);
            this.editor.render("TextEditor");
        }
        ImVec2 center = ImGui.getMainViewport().getCenter();
        ImGui.setNextWindowPos(center.x, center.y, 8, 0.5f, 0.5f);
        if (this.saveText != null) {
            String save = this.saveText.getString();
            if (ImGui.beginPopupModal(save + "?###save_confirm", 64)) {
                ImGui.text("Your changes have not been saved.\nThis operation cannot be undone!");
                ImGui.separator();
                ImGui.setItemDefaultFocus();
                if (ImGui.button(save)) {
                    save();
                    hide();
                    ImGui.closeCurrentPopup();
                }
                ImGui.sameLine();
                if (ImGui.button("Discard")) {
                    this.oldSource = null;
                    hide();
                    ImGui.closeCurrentPopup();
                }
                ImGui.sameLine();
                if (ImGui.button("Cancel")) {
                    ImGui.closeCurrentPopup();
                }
                ImGui.endPopup();
            }
        }
        ImGui.popID();
    }

    public TextEditor getEditor() {
        return this.editor;
    }

    public boolean isOpen() {
        return this.open.get();
    }

    public void setSaveCallback(@Nullable SaveCallback saveCallback) {
        this.saveCallback = saveCallback;
    }

    public void free() {
        this.editor.destroy();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/imgui/CodeEditor$ErrorConsumer.class */
    public interface ErrorConsumer {
        void addMarker(int i, int i2, int i3, String str, String str2);

        default void addMarker(int line, int lineNumberColor, int textColor) {
            addMarker(line, lineNumberColor, textColor, "", "");
        }

        default void addMarker(int line, int lineNumberColor, int textColor, String lineNumberTooltip) {
            addMarker(line, lineNumberColor, textColor, lineNumberTooltip, "");
        }
    }
}
