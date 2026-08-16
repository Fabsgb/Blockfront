package foundry.veil.platform;

import foundry.veil.api.event.VeilAddShaderPreProcessorsEvent;
import foundry.veil.api.event.VeilDynamicBuffersChangedEvent;
import foundry.veil.api.event.VeilPostProcessingEvent;
import foundry.veil.api.event.VeilRegisterGlobalControllersEvent;
import foundry.veil.api.event.VeilRegisterInspectorsEvent;
import foundry.veil.api.event.VeilShaderCompileEvent;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/platform/VeilClientPlatform.class */
@ApiStatus.Internal
public interface VeilClientPlatform extends VeilPostProcessingEvent.Pre, VeilPostProcessingEvent.Post, VeilAddShaderPreProcessorsEvent, VeilShaderCompileEvent, VeilDynamicBuffersChangedEvent, VeilRegisterGlobalControllersEvent, VeilRegisterInspectorsEvent {
}
