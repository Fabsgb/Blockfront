package foundry.veil.forge.mixin.client.perspective.sodium;

import foundry.veil.api.client.render.VeilLevelPerspectiveRenderer;
import foundry.veil.forge.ext.RenderSectionExtension;
import net.caffeinemc.mods.sodium.client.render.chunk.RenderSection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/client/perspective/sodium/RenderSectionMixin.class */
@Mixin({RenderSection.class})
public class RenderSectionMixin implements RenderSectionExtension {

    @Unique
    private int veil$perspectiveId;

    @Unique
    private int veil$incomingDirections;

    @Override // foundry.veil.forge.ext.RenderSectionExtension
    public boolean veil$hasNotRendered() {
        return this.veil$perspectiveId != VeilLevelPerspectiveRenderer.getID();
    }

    @Override // foundry.veil.forge.ext.RenderSectionExtension
    public void veil$markRendered() {
        this.veil$perspectiveId = VeilLevelPerspectiveRenderer.getID();
        this.veil$incomingDirections = 0;
    }

    @Override // foundry.veil.forge.ext.RenderSectionExtension
    public void veil$addIncomingDirections(int directions) {
        this.veil$incomingDirections |= directions;
    }

    @Inject(method = {"getIncomingDirections"}, at = {@At("HEAD")}, cancellable = true, remap = false)
    public void getIncomingDirections(CallbackInfoReturnable<Integer> cir) {
        if (VeilLevelPerspectiveRenderer.isRenderingPerspective()) {
            cir.setReturnValue(Integer.valueOf(this.veil$incomingDirections));
        }
    }
}
