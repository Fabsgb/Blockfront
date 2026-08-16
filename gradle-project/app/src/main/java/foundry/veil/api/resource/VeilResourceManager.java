package foundry.veil.api.resource;

import foundry.veil.VeilClient;
import foundry.veil.api.resource.type.McMetaResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceMetadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/VeilResourceManager.class */
public interface VeilResourceManager {
    ResourceManager clientResources();

    ResourceManager serverResources();

    @Nullable
    VeilResource<?> getVeilResource(String str, String str2);

    static VeilResourceManager get() {
        return VeilClient.resourceManager();
    }

    default ResourceManager resources(VeilResourceInfo resourceInfo) {
        return resourceInfo.packType() == PackType.SERVER_DATA ? serverResources() : clientResources();
    }

    @Nullable
    default VeilResource<?> getVeilResource(ResourceLocation location) {
        return getVeilResource(location.getNamespace(), location.getPath());
    }

    @Nullable
    default ResourceMetadata getResourceMetadata(String namespace, String path) {
        VeilResource<?> resource = getVeilResource(namespace, path);
        if (!(resource instanceof McMetaResource)) {
            return null;
        }
        McMetaResource mcMetaResource = (McMetaResource) resource;
        return mcMetaResource.metadata();
    }

    @Nullable
    default ResourceMetadata getResourceMetadata(ResourceLocation location) {
        return getResourceMetadata(location.getNamespace(), location.getPath());
    }
}
