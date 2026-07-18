package foundry.veil.forge.platform;

import foundry.veil.api.client.render.dynamicbuffer.DynamicBuffersChange;
import foundry.veil.api.client.render.post.PostPipeline;
import foundry.veil.api.client.render.shader.ShaderManager;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.api.event.VeilAddShaderPreProcessorsEvent;
import foundry.veil.api.event.VeilRegisterGlobalControllersEvent;
import foundry.veil.api.event.VeilRegisterInspectorsEvent;
import foundry.veil.forge.event.ForgeVeilAddShaderProcessorsEvent;
import foundry.veil.forge.event.ForgeVeilDynamicBuffersChangedEvent;
import foundry.veil.forge.event.ForgeVeilPostProcessingEvent;
import foundry.veil.forge.event.ForgeVeilRegisterGlobalControllersEvent;
import foundry.veil.forge.event.ForgeVeilRegisterInspectorsEvent;
import foundry.veil.forge.event.ForgeVeilShaderCompileEvent;
import foundry.veil.platform.VeilClientPlatform;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.neoforged.fml.ModLoader;
import net.neoforged.neoforge.common.NeoForge;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/platform/NeoForgeVeilClientPlatform.class */
@ApiStatus.Internal
public class NeoForgeVeilClientPlatform implements VeilClientPlatform {
    @Override // foundry.veil.api.event.VeilPostProcessingEvent.Pre
    public void preVeilPostProcessing(ResourceLocation name, PostPipeline pipeline, PostPipeline.Context context) {
        NeoForge.EVENT_BUS.post(new ForgeVeilPostProcessingEvent.Pre(name, pipeline, context));
    }

    @Override // foundry.veil.api.event.VeilPostProcessingEvent.Post
    public void postVeilPostProcessing(ResourceLocation name, PostPipeline pipeline, PostPipeline.Context context) {
        NeoForge.EVENT_BUS.post(new ForgeVeilPostProcessingEvent.Post(name, pipeline, context));
    }

    @Override // foundry.veil.api.event.VeilAddShaderPreProcessorsEvent
    public void onRegisterShaderPreProcessors(ResourceProvider resourceProvider, VeilAddShaderPreProcessorsEvent.Registry registry) {
        ModLoader.postEvent(new ForgeVeilAddShaderProcessorsEvent(resourceProvider, registry));
    }

    @Override // foundry.veil.api.event.VeilRegisterGlobalControllersEvent
    public void onRegisterGlobalControllers(VeilRegisterGlobalControllersEvent.Registry registry) {
        ModLoader.postEvent(new ForgeVeilRegisterGlobalControllersEvent(registry));
    }

    @Override // foundry.veil.api.event.VeilRegisterInspectorsEvent
    public void onRegisterInspectors(VeilRegisterInspectorsEvent.Registry registry) {
        ModLoader.postEvent(new ForgeVeilRegisterInspectorsEvent(registry));
    }

    @Override // foundry.veil.api.event.VeilShaderCompileEvent
    public void onVeilCompileShaders(ShaderManager shaderManager, Map<ResourceLocation, ShaderProgram> updatedPrograms) {
        ModLoader.postEvent(new ForgeVeilShaderCompileEvent(shaderManager, updatedPrograms));
    }

    @Override // foundry.veil.api.event.VeilDynamicBuffersChangedEvent
    public void onVeilDynamicBuffersChanged(DynamicBuffersChange change) {
        ModLoader.postEvent(new ForgeVeilDynamicBuffersChangedEvent(change));
    }
}
