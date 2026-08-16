package foundry.veil.api.resource.type;

import foundry.veil.Veil;
import foundry.veil.api.resource.VeilResourceAction;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.impl.resource.action.TextEditAction;
import imgui.extension.texteditor.TextEditorLanguage;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.function.Supplier;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/type/TextResource.class */
@ApiStatus.Internal
public final class TextResource extends Record implements VeilTextResource<TextResource> {
    private final VeilResourceInfo resourceInfo;
    private final Type type;

    @Nullable
    private final TextEditorLanguage languageDefinition;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, TextResource.class), TextResource.class, "resourceInfo;type;languageDefinition", "FIELD:Lfoundry/veil/api/resource/type/TextResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;", "FIELD:Lfoundry/veil/api/resource/type/TextResource;->type:Lfoundry/veil/api/resource/type/TextResource$Type;", "FIELD:Lfoundry/veil/api/resource/type/TextResource;->languageDefinition:Limgui/extension/texteditor/TextEditorLanguage;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, TextResource.class), TextResource.class, "resourceInfo;type;languageDefinition", "FIELD:Lfoundry/veil/api/resource/type/TextResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;", "FIELD:Lfoundry/veil/api/resource/type/TextResource;->type:Lfoundry/veil/api/resource/type/TextResource$Type;", "FIELD:Lfoundry/veil/api/resource/type/TextResource;->languageDefinition:Limgui/extension/texteditor/TextEditorLanguage;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, TextResource.class, Object.class), TextResource.class, "resourceInfo;type;languageDefinition", "FIELD:Lfoundry/veil/api/resource/type/TextResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;", "FIELD:Lfoundry/veil/api/resource/type/TextResource;->type:Lfoundry/veil/api/resource/type/TextResource$Type;", "FIELD:Lfoundry/veil/api/resource/type/TextResource;->languageDefinition:Limgui/extension/texteditor/TextEditorLanguage;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public VeilResourceInfo resourceInfo() {
        return this.resourceInfo;
    }

    public Type type() {
        return this.type;
    }

    @Override // foundry.veil.api.resource.type.VeilTextResource
    @Nullable
    public TextEditorLanguage languageDefinition() {
        return this.languageDefinition;
    }

    public TextResource(VeilResourceInfo resourceInfo, Type type, @Nullable TextEditorLanguage languageDefinition) {
        this.resourceInfo = resourceInfo;
        this.type = type;
        this.languageDefinition = languageDefinition;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public List<VeilResourceAction<TextResource>> getActions() {
        return List.of(new TextEditAction());
    }

    @Override // foundry.veil.api.resource.VeilResource
    public boolean canHotReload() {
        return false;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public void hotReload(VeilResourceManager resourceManager) throws IOException {
    }

    @Override // foundry.veil.api.resource.VeilResource
    public int getIconCode() {
        return this.type.getIcon();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/type/TextResource$Type.class */
    public enum Type {
        TEXT(".txt", 60687),
        JSON(".json", 60621, () -> {
            return TextEditorLanguage::Json;
        });

        private final String extension;
        private final int icon;
        private final Supplier<Supplier<TextEditorLanguage>> languageDefinition;

        Type(@Nullable String extension, int icon, Supplier supplier) {
            this.extension = extension;
            this.icon = icon;
            this.languageDefinition = supplier;
        }

        Type(String extension, int icon) {
            this(extension, icon, null);
        }

        public String getExtension() {
            return this.extension;
        }

        public int getIcon() {
            return this.icon;
        }

        @Nullable
        public TextEditorLanguage getLanguageDefinition() {
            if (!Veil.IMGUIMC || this.languageDefinition == null) {
                return null;
            }
            return this.languageDefinition.get().get();
        }
    }
}
