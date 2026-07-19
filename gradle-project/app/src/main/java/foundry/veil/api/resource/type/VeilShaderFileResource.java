package foundry.veil.api.resource.type;

import foundry.veil.api.client.render.shader.ShaderManager;
import foundry.veil.api.client.render.shader.ShaderSourceSet;
import foundry.veil.api.client.render.shader.program.ProgramDefinition;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.api.resource.VeilResourceAction;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.impl.resource.action.TextEditAction;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/resource/type/VeilShaderFileResource.class */
@ApiStatus.Internal
public final class VeilShaderFileResource extends Record implements VeilShaderResource<VeilShaderFileResource> {
    private final VeilResourceInfo resourceInfo;
    private final ShaderManager shaderManager;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, VeilShaderFileResource.class), VeilShaderFileResource.class, "resourceInfo;shaderManager", "FIELD:Lfoundry/veil/api/resource/type/VeilShaderFileResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;", "FIELD:Lfoundry/veil/api/resource/type/VeilShaderFileResource;->shaderManager:Lfoundry/veil/api/client/render/shader/ShaderManager;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, VeilShaderFileResource.class), VeilShaderFileResource.class, "resourceInfo;shaderManager", "FIELD:Lfoundry/veil/api/resource/type/VeilShaderFileResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;", "FIELD:Lfoundry/veil/api/resource/type/VeilShaderFileResource;->shaderManager:Lfoundry/veil/api/client/render/shader/ShaderManager;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, VeilShaderFileResource.class, Object.class), VeilShaderFileResource.class, "resourceInfo;shaderManager", "FIELD:Lfoundry/veil/api/resource/type/VeilShaderFileResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;", "FIELD:Lfoundry/veil/api/resource/type/VeilShaderFileResource;->shaderManager:Lfoundry/veil/api/client/render/shader/ShaderManager;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public VeilResourceInfo resourceInfo() {
        return this.resourceInfo;
    }

    public ShaderManager shaderManager() {
        return this.shaderManager;
    }

    public VeilShaderFileResource(VeilResourceInfo resourceInfo, ShaderManager shaderManager) {
        this.resourceInfo = resourceInfo;
        this.shaderManager = shaderManager;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public List<VeilResourceAction<VeilShaderFileResource>> getActions() {
        return List.of(new TextEditAction());
    }

    @Override // foundry.veil.api.resource.VeilResource
    public boolean canHotReload() {
        return true;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public void hotReload(VeilResourceManager resourceManager) {
        ResourceLocation sourceName;
        int type = ShaderSourceSet.getShaderType(resourceInfo().location());
        if (type == -1) {
            return;
        }
        ShaderSourceSet sourceSet = this.shaderManager.getSourceSet();
        ResourceLocation id = sourceSet.getTypeConverter(type).fileToId(this.resourceInfo.location());
        Set<ResourceLocation> programs = new HashSet<>();
        for (Map.Entry<ResourceLocation, ShaderProgram> entry : this.shaderManager.getShaders().entrySet()) {
            ProgramDefinition definition = entry.getValue().getDefinition();
            if (definition != null && (sourceName = (ResourceLocation) definition.shaders().get(type)) != null && id.equals(sourceName)) {
                programs.add(entry.getKey());
            }
        }
        for (ResourceLocation program : programs) {
            this.shaderManager.scheduleRecompile(program);
        }
    }
}
