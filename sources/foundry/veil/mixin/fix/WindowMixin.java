package foundry.veil.mixin.fix;

import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;
import com.mojang.blaze3d.platform.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/fix/WindowMixin.class */
@Mixin({Window.class})
public class WindowMixin {
    @ModifyArg(method = {"<init>"}, at = @At(value = "INVOKE", target = "Lorg/lwjgl/glfw/GLFW;glfwWindowHint(II)V", ordinal = 4, remap = false), index = 1)
    public int modifyMajorVersion(int value, @Share("major") LocalIntRef major) {
        major.set(value);
        return value;
    }

    @ModifyArg(method = {"<init>"}, at = @At(value = "INVOKE", target = "Lorg/lwjgl/glfw/GLFW;glfwWindowHint(II)V", ordinal = 5, remap = false), index = 1)
    public int modifyMinorVersion(int value, @Share("major") LocalIntRef major) {
        if (major.get() == 3 && value < 3) {
            return 3;
        }
        return value;
    }
}
