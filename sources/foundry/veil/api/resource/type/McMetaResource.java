package foundry.veil.api.resource.type;

import foundry.veil.api.resource.VeilResource;
import foundry.veil.api.resource.VeilResourceAction;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceManager;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceMetadata;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/resource/type/McMetaResource.class */
@ApiStatus.Internal
public final class McMetaResource extends Record implements VeilResource<McMetaResource> {
    private final VeilResourceInfo resourceInfo;

    @Nullable
    private final ResourceLocation basePath;
    private final ResourceMetadata metadata;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, McMetaResource.class), McMetaResource.class, "resourceInfo;basePath;metadata", "FIELD:Lfoundry/veil/api/resource/type/McMetaResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;", "FIELD:Lfoundry/veil/api/resource/type/McMetaResource;->basePath:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/resource/type/McMetaResource;->metadata:Lnet/minecraft/server/packs/resources/ResourceMetadata;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, McMetaResource.class), McMetaResource.class, "resourceInfo;basePath;metadata", "FIELD:Lfoundry/veil/api/resource/type/McMetaResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;", "FIELD:Lfoundry/veil/api/resource/type/McMetaResource;->basePath:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/resource/type/McMetaResource;->metadata:Lnet/minecraft/server/packs/resources/ResourceMetadata;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, McMetaResource.class, Object.class), McMetaResource.class, "resourceInfo;basePath;metadata", "FIELD:Lfoundry/veil/api/resource/type/McMetaResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;", "FIELD:Lfoundry/veil/api/resource/type/McMetaResource;->basePath:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/resource/type/McMetaResource;->metadata:Lnet/minecraft/server/packs/resources/ResourceMetadata;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public VeilResourceInfo resourceInfo() {
        return this.resourceInfo;
    }

    @Nullable
    public ResourceLocation basePath() {
        return this.basePath;
    }

    public ResourceMetadata metadata() {
        return this.metadata;
    }

    public McMetaResource(VeilResourceInfo resourceInfo, @Nullable ResourceLocation basePath, ResourceMetadata metadata) {
        this.resourceInfo = resourceInfo;
        this.basePath = basePath;
        this.metadata = metadata;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public List<VeilResourceAction<McMetaResource>> getActions() {
        return List.of();
    }

    @Override // foundry.veil.api.resource.VeilResource
    public boolean canHotReload() {
        return this.basePath != null;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public void hotReload(VeilResourceManager resourceManager) throws IOException {
        VeilResource<?> baseResource;
        if (this.basePath != null && (baseResource = resourceManager.getVeilResource(this.basePath)) != null && baseResource.canHotReload()) {
            baseResource.hotReload(resourceManager);
        }
    }

    @Override // foundry.veil.api.resource.VeilResource
    public int getIconCode() {
        return 60650;
    }
}
