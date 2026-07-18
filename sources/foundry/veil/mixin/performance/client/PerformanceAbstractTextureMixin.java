package foundry.veil.mixin.performance.client;

import com.llamalad7.mixinextras.sugar.Local;
import foundry.veil.api.client.render.VeilRenderSystem;
import net.minecraft.client.renderer.texture.AbstractTexture;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/performance/client/PerformanceAbstractTextureMixin.class */
@Mixin({AbstractTexture.class})
public abstract class PerformanceAbstractTextureMixin {

    @Unique
    private boolean veil$initialized;

    @Shadow
    public abstract int getId();

    @Inject(method = {"setFilter"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/texture/AbstractTexture;bind()V")}, cancellable = true)
    public void setFilterDSA(boolean blur, boolean mipmap, CallbackInfo ci, @Local(ordinal = 0) int minFilter, @Local(ordinal = 1) int magFilter) {
        if (!this.veil$initialized || !VeilRenderSystem.directStateAccessSupported()) {
            return;
        }
        ci.cancel();
        int id = getId();
        ARBDirectStateAccess.glTextureParameteri(id, 10241, minFilter);
        ARBDirectStateAccess.glTextureParameteri(id, 10240, magFilter);
    }

    @Inject(method = {"bind"}, at = {@At("TAIL")})
    public void bind(CallbackInfo ci) {
        this.veil$initialized = true;
    }
}
