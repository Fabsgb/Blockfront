package foundry.veil.mixin.pipeline.client;

import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;
import com.mojang.blaze3d.platform.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/pipeline/client/PipelineWindowMixin.class */
@Mixin({Window.class})
public class PipelineWindowMixin {
    @ModifyArg(method = {"<init>"}, at = @At(value = "INVOKE", target = "Lorg/lwjgl/glfw/GLFW;glfwWindowHint(II)V", ordinal = 2, remap = false), index = 1)
    public int captureMajorVersion(int hint, @Share("majorGLVersion") LocalIntRef majorGLVersion) {
        majorGLVersion.set(hint);
        return hint;
    }

    @ModifyArg(method = {"<init>"}, at = @At(value = "INVOKE", target = "Lorg/lwjgl/glfw/GLFW;glfwWindowHint(II)V", ordinal = 3, remap = false), index = 1)
    public int captureMinorVersion(int hint, @Share("majorGLVersion") LocalIntRef majorGLVersion) {
        return majorGLVersion.get() == 3 ? Math.max(3, hint) : hint;
    }
}
