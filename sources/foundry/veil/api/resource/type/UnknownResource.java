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
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/type/UnknownResource.class */
@ApiStatus.Internal
public final class UnknownResource extends Record implements VeilResource<UnknownResource> {
    private final VeilResourceInfo resourceInfo;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, UnknownResource.class), UnknownResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/UnknownResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, UnknownResource.class), UnknownResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/UnknownResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, UnknownResource.class, Object.class), UnknownResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/UnknownResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public VeilResourceInfo resourceInfo() {
        return this.resourceInfo;
    }

    public UnknownResource(VeilResourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public List<VeilResourceAction<UnknownResource>> getActions() {
        return List.of();
    }

    @Override // foundry.veil.api.resource.VeilResource
    public boolean canHotReload() {
        return false;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public void hotReload(VeilResourceManager resourceManager) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // foundry.veil.api.resource.VeilResource
    public int getIconCode() {
        return 60691;
    }
}
