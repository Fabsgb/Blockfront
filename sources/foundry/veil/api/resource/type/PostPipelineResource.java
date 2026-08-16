package foundry.veil.api.resource.type;

import foundry.veil.api.client.render.VeilRenderSystem;
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
import java.util.concurrent.CompletableFuture;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.util.profiling.InactiveProfiler;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/type/PostPipelineResource.class */
@ApiStatus.Internal
public final class PostPipelineResource extends Record implements VeilTextResource<PostPipelineResource> {
    private final VeilResourceInfo resourceInfo;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PostPipelineResource.class), PostPipelineResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/PostPipelineResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PostPipelineResource.class), PostPipelineResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/PostPipelineResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PostPipelineResource.class, Object.class), PostPipelineResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/PostPipelineResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public VeilResourceInfo resourceInfo() {
        return this.resourceInfo;
    }

    public PostPipelineResource(VeilResourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public List<VeilResourceAction<PostPipelineResource>> getActions() {
        return List.of(new TextEditAction());
    }

    @Override // foundry.veil.api.resource.VeilResource
    public boolean canHotReload() {
        return true;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public void hotReload(VeilResourceManager resourceManager) throws IOException {
        VeilRenderSystem.renderer().getPostProcessingManager().reload(CompletableFuture::completedFuture, resourceManager.resources(this.resourceInfo), InactiveProfiler.INSTANCE, InactiveProfiler.INSTANCE, Util.backgroundExecutor(), Minecraft.getInstance());
    }

    @Override // foundry.veil.api.resource.VeilResource
    public int getIconCode() {
        return 60687;
    }

    @Override // foundry.veil.api.resource.type.VeilTextResource
    public TextEditorLanguage languageDefinition() {
        return TextEditorLanguage.Json();
    }
}
