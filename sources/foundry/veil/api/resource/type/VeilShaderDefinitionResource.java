package foundry.veil.api.resource.type;

import foundry.veil.api.client.render.shader.ShaderManager;
import foundry.veil.api.resource.VeilResourceAction;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.impl.resource.action.TextEditAction;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/resource/type/VeilShaderDefinitionResource.class */
@ApiStatus.Internal
public final class VeilShaderDefinitionResource extends Record implements VeilShaderResource<VeilShaderDefinitionResource> {
    private final VeilResourceInfo resourceInfo;
    private final ShaderManager shaderManager;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, VeilShaderDefinitionResource.class), VeilShaderDefinitionResource.class, "resourceInfo;shaderManager", "FIELD:Lfoundry/veil/api/resource/type/VeilShaderDefinitionResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;", "FIELD:Lfoundry/veil/api/resource/type/VeilShaderDefinitionResource;->shaderManager:Lfoundry/veil/api/client/render/shader/ShaderManager;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, VeilShaderDefinitionResource.class), VeilShaderDefinitionResource.class, "resourceInfo;shaderManager", "FIELD:Lfoundry/veil/api/resource/type/VeilShaderDefinitionResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;", "FIELD:Lfoundry/veil/api/resource/type/VeilShaderDefinitionResource;->shaderManager:Lfoundry/veil/api/client/render/shader/ShaderManager;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, VeilShaderDefinitionResource.class, Object.class), VeilShaderDefinitionResource.class, "resourceInfo;shaderManager", "FIELD:Lfoundry/veil/api/resource/type/VeilShaderDefinitionResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;", "FIELD:Lfoundry/veil/api/resource/type/VeilShaderDefinitionResource;->shaderManager:Lfoundry/veil/api/client/render/shader/ShaderManager;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public VeilResourceInfo resourceInfo() {
        return this.resourceInfo;
    }

    public ShaderManager shaderManager() {
        return this.shaderManager;
    }

    public VeilShaderDefinitionResource(VeilResourceInfo resourceInfo, ShaderManager shaderManager) {
        this.resourceInfo = resourceInfo;
        this.shaderManager = shaderManager;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public List<VeilResourceAction<VeilShaderDefinitionResource>> getActions() {
        return List.of(new TextEditAction());
    }

    @Override // foundry.veil.api.resource.VeilResource
    public boolean canHotReload() {
        return true;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public void hotReload(VeilResourceManager resourceManager) throws IOException {
        this.shaderManager.scheduleRecompile(this.shaderManager.getSourceSet().getShaderDefinitionLister().fileToId(this.resourceInfo.location()));
    }

    @Override // foundry.veil.api.resource.type.VeilShaderResource, foundry.veil.api.resource.VeilResource
    public int getIconCode() {
        return 60687;
    }
}
