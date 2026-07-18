package foundry.veil.mixin.shader.client;

import com.mojang.blaze3d.shaders.ProgramManager;
import com.mojang.blaze3d.shaders.Shader;
import foundry.veil.impl.client.render.shader.program.ShaderProgramImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/shader/client/ShaderProgramManagerMixin.class */
@Mixin({ProgramManager.class})
public class ShaderProgramManagerMixin {
    @Inject(method = {"createProgram"}, at = {@At("HEAD")}, cancellable = true)
    private static void veil$cancelProgram(CallbackInfoReturnable<Integer> cir) {
        if (ShaderProgramImpl.Wrapper.constructingProgram != null) {
            cir.setReturnValue(Integer.valueOf(ShaderProgramImpl.Wrapper.constructingProgram.getProgram()));
        }
    }

    @Inject(method = {"linkShader"}, at = {@At("HEAD")}, cancellable = true)
    private static void veil$cancelLinkShader(Shader shader, CallbackInfo ci) {
        if (shader instanceof ShaderProgramImpl.Wrapper) {
            ci.cancel();
        }
    }
}
