package foundry.veil.platform;

import foundry.veil.api.event.FreeNativeResourcesEvent;
import foundry.veil.api.event.VeilAddShaderPreProcessorsEvent;
import foundry.veil.api.event.VeilDynamicBuffersChangedEvent;
import foundry.veil.api.event.VeilPostProcessingEvent;
import foundry.veil.api.event.VeilRegisterBlockLayersEvent;
import foundry.veil.api.event.VeilRegisterFixedBuffersEvent;
import foundry.veil.api.event.VeilRegisterGlobalControllersEvent;
import foundry.veil.api.event.VeilRegisterInspectorsEvent;
import foundry.veil.api.event.VeilRenderLevelStageEvent;
import foundry.veil.api.event.VeilRendererAvailableEvent;
import foundry.veil.api.event.VeilShaderCompileEvent;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/platform/VeilEventPlatform.class */
public interface VeilEventPlatform {
    public static final VeilEventPlatform INSTANCE = (VeilEventPlatform) ServiceLoader.load(VeilEventPlatform.class).findFirst().orElseThrow(() -> {
        return new RuntimeException("Failed to find platform event provider");
    });

    void onFreeNativeResources(FreeNativeResourcesEvent freeNativeResourcesEvent);

    void onVeilAddShaderProcessors(VeilAddShaderPreProcessorsEvent veilAddShaderPreProcessorsEvent);

    void preVeilPostProcessing(VeilPostProcessingEvent.Pre pre);

    void postVeilPostProcessing(VeilPostProcessingEvent.Post post);

    void onVeilRegisterBlockLayers(VeilRegisterBlockLayersEvent veilRegisterBlockLayersEvent);

    void onVeilRegisterFixedBuffers(VeilRegisterFixedBuffersEvent veilRegisterFixedBuffersEvent);

    void onVeilRegisterGlobalControllers(VeilRegisterGlobalControllersEvent veilRegisterGlobalControllersEvent);

    void onVeilRegisterInspectors(VeilRegisterInspectorsEvent veilRegisterInspectorsEvent);

    void onVeilRendererAvailable(VeilRendererAvailableEvent veilRendererAvailableEvent);

    void onVeilRenderLevelStage(VeilRenderLevelStageEvent veilRenderLevelStageEvent);

    void onVeilShaderCompile(VeilShaderCompileEvent veilShaderCompileEvent);

    void onVeilDynamicBuffersChanged(VeilDynamicBuffersChangedEvent veilDynamicBuffersChangedEvent);
}
