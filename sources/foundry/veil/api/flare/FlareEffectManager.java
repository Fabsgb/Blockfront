package foundry.veil.api.flare;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.flare.data.effect.FlareEffectTemplate;
import foundry.veil.api.flare.data.effect.FlareModule;
import foundry.veil.api.flare.model.BakedShell;
import foundry.veil.api.flare.modifier.ControllerManager;
import foundry.veil.impl.flare.FlareManager;
import foundry.veil.impl.flare.ShellManager;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/flare/FlareEffectManager.class */
public final class FlareEffectManager {
    private final ShellManager shellManager = new ShellManager();
    private final ControllerManager controllerManager = new ControllerManager();

    @ApiStatus.Internal
    public FlareEffectManager() {
    }

    public static FlareEffectManager getInstance() {
        return VeilRenderSystem.renderer().getEffectManager();
    }

    public static FlareEffectTemplate getTemplate(ResourceLocation resourceLocation) {
        return (FlareEffectTemplate) ((Registry) FlareManager.registryAccess().registry(FlareManager.EFFECT_TEMPLATES).orElseThrow()).get(resourceLocation);
    }

    public static FlareModule getModule(ResourceLocation resourceLocation) {
        return (FlareModule) ((Registry) FlareManager.registryAccess().registry(FlareManager.EFFECT_MODULES).orElseThrow()).get(resourceLocation);
    }

    @ApiStatus.Internal
    public ShellManager getShellManager() {
        return this.shellManager;
    }

    public BakedShell getBakedShell(ResourceLocation modelLocation) {
        return this.shellManager.getBakedShell(modelLocation);
    }

    public ControllerManager getControllerManager() {
        return this.controllerManager;
    }
}
