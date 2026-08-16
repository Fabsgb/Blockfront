package foundry.veil.api.resource.editor;

import foundry.veil.Veil;
import foundry.veil.api.client.imgui.CodeEditor;
import foundry.veil.api.resource.VeilEditorEnvironment;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.api.resource.type.VeilTextResource;
import imgui.ImGui;
import imgui.extension.texteditor.TextEditor;
import imgui.extension.texteditor.TextEditorLanguage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/editor/TextFileEditor.class */
@ApiStatus.Internal
public class TextFileEditor implements ResourceFileEditor<VeilTextResource<?>> {
    private static final Component SAVE = Component.translatable("gui.veil.save");
    private final VeilResourceManager resourceManager;
    private final VeilTextResource<?> resource;
    private final CodeEditor editor = new CodeEditor(SAVE);

    public TextFileEditor(VeilEditorEnvironment environment, VeilTextResource<?> resource) {
        this.editor.show(resource.resourceInfo().fileName(), "");
        this.editor.setSaveCallback(null);
        this.resourceManager = environment.getResourceManager();
        this.resource = resource;
        loadFromDisk();
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public void render() {
        this.editor.renderWindow();
        if (ImGui.beginPopupModal("###open_failed")) {
            ImGui.text("Failed to open file");
            ImGui.endPopup();
        }
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public void loadFromDisk() {
        VeilResourceInfo info = this.resource.resourceInfo();
        TextEditorLanguage languageDefinition = this.resource.languageDefinition();
        TextEditor editor = this.editor.getEditor();
        editor.setReadOnlyEnabled(true);
        info.getResource(this.resourceManager).ifPresentOrElse(data -> {
            CompletableFuture.supplyAsync(() -> {
                try {
                    InputStream stream = data.open();
                    try {
                        String str = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
                        if (stream != null) {
                            stream.close();
                        }
                        return str;
                    } catch (Throwable th) {
                        if (stream != null) {
                            try {
                                stream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    throw new CompletionException(e);
                }
            }, Util.ioPool()).handleAsync((contents, error) -> {
                if (error != null) {
                    this.editor.hide();
                    ImGui.openPopup("###open_failed");
                    Veil.LOGGER.error("Failed to open file", error);
                    return null;
                }
                this.editor.show(info.fileName(), contents);
                this.editor.setSaveCallback((source, errorMap) -> {
                    save(source.getBytes(StandardCharsets.UTF_8), this.resourceManager, this.resource);
                });
                editor.setReadOnlyEnabled(info.isStatic());
                if (languageDefinition != null) {
                    editor.setLanguage(languageDefinition);
                    return null;
                }
                return null;
            }, (Executor) Minecraft.getInstance());
        }, () -> {
            this.editor.hide();
            ImGui.openPopup("###open_failed");
        });
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public boolean isClosed() {
        return !this.editor.isOpen();
    }

    @Override // foundry.veil.api.resource.editor.ResourceFileEditor
    public VeilTextResource<?> getResource() {
        return this.resource;
    }
}
