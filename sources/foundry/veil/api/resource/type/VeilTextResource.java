package foundry.veil.api.resource.type;

import foundry.veil.api.resource.VeilResource;
import foundry.veil.api.resource.type.VeilTextResource;
import imgui.extension.texteditor.TextEditorLanguage;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/type/VeilTextResource.class */
public interface VeilTextResource<T extends VeilTextResource<?>> extends VeilResource<T> {
    @Nullable
    default TextEditorLanguage languageDefinition() {
        return null;
    }
}
