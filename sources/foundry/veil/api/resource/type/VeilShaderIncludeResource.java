package foundry.veil.api.resource.type;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.ShaderManager;
import foundry.veil.api.client.render.shader.compiler.CompiledShader;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.api.resource.VeilResourceAction;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.impl.resource.action.TextEditAction;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/resource/type/VeilShaderIncludeResource.class */
@ApiStatus.Internal
public final class VeilShaderIncludeResource extends Record implements VeilShaderResource<VeilShaderIncludeResource> {
    private final VeilResourceInfo resourceInfo;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, VeilShaderIncludeResource.class), VeilShaderIncludeResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/VeilShaderIncludeResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, VeilShaderIncludeResource.class), VeilShaderIncludeResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/VeilShaderIncludeResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, VeilShaderIncludeResource.class, Object.class), VeilShaderIncludeResource.class, "resourceInfo", "FIELD:Lfoundry/veil/api/resource/type/VeilShaderIncludeResource;->resourceInfo:Lfoundry/veil/api/resource/VeilResourceInfo;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public VeilResourceInfo resourceInfo() {
        return this.resourceInfo;
    }

    public VeilShaderIncludeResource(VeilResourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public List<VeilResourceAction<VeilShaderIncludeResource>> getActions() {
        return List.of(new TextEditAction());
    }

    @Override // foundry.veil.api.resource.VeilResource
    public boolean canHotReload() {
        return true;
    }

    @Override // foundry.veil.api.resource.VeilResource
    public void hotReload(VeilResourceManager resourceManager) {
        ResourceLocation id = ShaderManager.INCLUDE_LISTER.fileToId(this.resourceInfo.location());
        ShaderManager shaderManager = VeilRenderSystem.renderer().getShaderManager();
        Set<ResourceLocation> programs = getShaders(id, shaderManager);
        for (ResourceLocation program : programs) {
            shaderManager.scheduleRecompile(program);
        }
    }

    private static Set<ResourceLocation> getShaders(ResourceLocation id, ShaderManager shaderManager) {
        Set<ResourceLocation> programs = new HashSet<>();
        for (Map.Entry<ResourceLocation, ShaderProgram> entry : shaderManager.getShaders().entrySet()) {
            ShaderProgram program = entry.getValue();
            ObjectIterator it = program.getShaders().values().iterator();
            while (true) {
                if (it.hasNext()) {
                    CompiledShader shader = (CompiledShader) it.next();
                    if (shader.includes().contains(id)) {
                        programs.add(entry.getKey());
                        break;
                    }
                }
            }
        }
        return programs;
    }
}
