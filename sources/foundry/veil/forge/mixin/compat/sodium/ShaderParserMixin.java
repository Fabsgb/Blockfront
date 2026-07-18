package foundry.veil.forge.mixin.compat.sodium;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.impl.client.render.shader.processor.SodiumShaderProcessor;
import net.caffeinemc.mods.sodium.client.gl.shader.ShaderParser;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/mixin/compat/sodium/ShaderParserMixin.class */
@Mixin({ShaderParser.class})
public class ShaderParserMixin {
    @ModifyReturnValue(method = {"parseShader(Ljava/lang/String;Lnet/caffeinemc/mods/sodium/client/gl/shader/ShaderConstants;)Lnet/caffeinemc/mods/sodium/client/gl/shader/ShaderParser$ParsedShader;"}, at = {@At("RETURN")})
    private static ShaderParser.ParsedShader modifySource(ShaderParser.ParsedShader original) {
        try {
            try {
                int activeBuffers = VeilRenderSystem.renderer().getDynamicBufferManger().getActiveBuffers();
                SodiumShaderProcessor.setup(Minecraft.getInstance().getResourceManager());
                String modified = SodiumShaderProcessor.modify(activeBuffers, original.src());
                ShaderParser.ParsedShader parsedShader = new ShaderParser.ParsedShader(modified, original.includeIds());
                SodiumShaderProcessor.free();
                return parsedShader;
            } catch (Throwable t) {
                Veil.LOGGER.error("Failed to apply Veil shader modifiers to shader: {}", SodiumShaderProcessor.getActiveShaderName(), t);
                SodiumShaderProcessor.free();
                return original;
            }
        } catch (Throwable th) {
            SodiumShaderProcessor.free();
            throw th;
        }
    }
}
