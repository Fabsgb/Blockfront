package foundry.veil.api.resource.type;

import foundry.veil.api.resource.type.VeilShaderResource;
import imgui.extension.texteditor.TextEditorLanguage;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/type/VeilShaderResource.class */
@ApiStatus.Internal
public interface VeilShaderResource<T extends VeilShaderResource<?>> extends VeilTextResource<T> {
    @Override // foundry.veil.api.resource.VeilResource
    default int getIconCode() {
        return 60625;
    }

    @Override // foundry.veil.api.resource.type.VeilTextResource
    default TextEditorLanguage languageDefinition() {
        return TextEditorLanguage.Glsl();
    }
}
