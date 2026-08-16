package foundry.veil.forge.mixin.compat.sodium;

import foundry.veil.impl.client.render.shader.processor.SodiumShaderProcessor;
import net.caffeinemc.mods.sodium.client.gl.shader.GlShader;
import net.caffeinemc.mods.sodium.client.gl.shader.ShaderConstants;
import net.caffeinemc.mods.sodium.client.gl.shader.ShaderLoader;
import net.caffeinemc.mods.sodium.client.gl.shader.ShaderType;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.opengl.GL;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/compat/sodium/ShaderLoaderMixin.class */
@Mixin({ShaderLoader.class})
public class ShaderLoaderMixin {
    @Inject(method = {"loadShader"}, at = {@At("HEAD")})
    private static void preLoadShader(ShaderType type, ResourceLocation name, ShaderConstants constants, CallbackInfoReturnable<GlShader> cir) {
        SodiumShaderProcessor.setShaderType(type.id, name, GL.getCapabilities());
    }
}
