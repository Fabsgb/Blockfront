package foundry.veil.mixin.debug.client;

import com.mojang.blaze3d.platform.GlDebug;
import foundry.veil.VeilDebugHooks;
import org.lwjgl.opengl.GLDebugMessageCallback;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/debug/client/DebugGlDebugMixin.class */
@Mixin({GlDebug.class})
public class DebugGlDebugMixin {
    @Inject(method = {"printDebugLog"}, at = {@At("RETURN")})
    private static void onGLError(int source, int type, int id, int severity, int length, long messagePointer, long userParam, CallbackInfo ci) {
        VeilDebugHooks.onGLError(source, type, id, severity, GLDebugMessageCallback.getMessage(length, messagePointer), userParam);
    }
}
