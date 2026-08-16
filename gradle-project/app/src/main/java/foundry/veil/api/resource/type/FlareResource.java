package foundry.veil.api.resource.type;

import foundry.veil.api.resource.VeilResourceAction;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.impl.flare.FlareManager;
import foundry.veil.impl.resource.action.TemplateInspectAction;
import foundry.veil.impl.resource.action.TextEditAction;
import imgui.extension.texteditor.TextEditorLanguage;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.util.profiling.InactiveProfiler;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/type/FlareResource.class */
public final class FlareResource extends Record implements VeilTextResource<FlareResource> {
    private final VeilResourceInfo resourceInfo;

    public FlareResource(VeilResourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, FlareResource.class), FlareResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/FlareResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FlareResource.class), FlareResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/FlareResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FlareResource.class, Object.class), FlareResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/FlareResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public VeilResourceInfo resourceInfo() {
        return this.resourceInfo;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public List<VeilResourceAction<FlareResource>> getActions() {
        if (this.resourceInfo.location().getPath().startsWith("flare/templates")) {
            return List.of(new TextEditAction(), new TemplateInspectAction());
        }
        return List.of(new TextEditAction());
    }

    @Override // foundry.veil.api.resource.VeilResource
    public boolean canHotReload() {
        return true;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public void hotReload(VeilResourceManager resourceManager) throws IOException {
        FlareManager.Reloader.INSTANCE.reload(CompletableFuture::completedFuture, resourceManager.resources(this.resourceInfo), InactiveProfiler.INSTANCE, InactiveProfiler.INSTANCE, Util.backgroundExecutor(), Minecraft.getInstance());
    }

    @Override // foundry.veil.api.resource.VeilResource
    public int getIconCode() {
        return 59932;
    }

    @Override // foundry.veil.api.resource.type.VeilTextResource
    public TextEditorLanguage languageDefinition() {
        return TextEditorLanguage.Json();
    }
}
