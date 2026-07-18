package foundry.veil.mixin.debug.client;

import com.mojang.blaze3d.vertex.VertexBuffer;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.LevelRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/debug/client/DebugLevelRendererMixin.class */
@Mixin({LevelRenderer.class})
public class DebugLevelRendererMixin {

    @Shadow
    @Nullable
    private VertexBuffer darkBuffer;

    @Shadow
    @Nullable
    private VertexBuffer skyBuffer;

    @Shadow
    @Nullable
    private VertexBuffer starBuffer;

    @Inject(method = {"createDarkSky"}, at = {@At("TAIL")})
    public void nameDarkSky(CallbackInfo ci) {
        this.darkBuffer.veil$setName("Void");
    }

    @Inject(method = {"createLightSky"}, at = {@At("TAIL")})
    public void nameLightSky(CallbackInfo ci) {
        this.skyBuffer.veil$setName("Sky");
    }

    @Inject(method = {"createStars"}, at = {@At("TAIL")})
    public void nameStars(CallbackInfo ci) {
        this.starBuffer.veil$setName("Star");
    }
}
