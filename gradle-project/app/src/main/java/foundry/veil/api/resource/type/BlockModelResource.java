package foundry.veil.api.resource.type;

import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.resource.VeilResourceAction;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.impl.resource.action.ModelInspectAction;
import foundry.veil.impl.resource.action.TextEditAction;
import imgui.extension.texteditor.TextEditorLanguage;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/type/BlockModelResource.class */
@ApiStatus.Internal
public final class BlockModelResource extends Record implements VeilTextResource<BlockModelResource> {
    private final VeilResourceInfo resourceInfo;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, BlockModelResource.class), BlockModelResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/BlockModelResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, BlockModelResource.class), BlockModelResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/BlockModelResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, BlockModelResource.class, Object.class), BlockModelResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/BlockModelResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public VeilResourceInfo resourceInfo() {
        return this.resourceInfo;
    }

    public BlockModelResource(VeilResourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public List<VeilResourceAction<BlockModelResource>> getActions() {
        return List.of(new TextEditAction(), new ModelInspectAction());
    }

    @Override // foundry.veil.api.resource.VeilResource
    public boolean canHotReload() {
        return true;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public void hotReload(VeilResourceManager resourceManager) throws IOException {
        ResourceLocation location = this.resourceInfo.location();
        ResourceManager resources = resourceManager.resources(this.resourceInfo);
        Executor minecraft = Minecraft.getInstance();
        ModelManager modelManager = minecraft.getModelManager();
        ProfilerFiller profiler = minecraft.getProfiler();
        modelManager.reload(CompletableFuture::completedFuture, resources, profiler, profiler, Util.backgroundExecutor(), minecraft).thenAcceptAsync(unused -> {
            VeilRenderSystem.rebuildChunks();
        }, minecraft).exceptionally(e -> {
            while (e instanceof CompletionException) {
                e = e.getCause();
            }
            Veil.LOGGER.error("Failed to load model {}", location, e);
            return null;
        });
    }

    @Override // foundry.veil.api.resource.VeilResource
    public int getIconCode() {
        return 62339;
    }

    @Override // foundry.veil.api.resource.type.VeilTextResource
    public TextEditorLanguage languageDefinition() {
        return TextEditorLanguage.Json();
    }
}
