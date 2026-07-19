package foundry.veil.mixin.performance.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.api.client.render.shader.uniform.ShaderUniform;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/performance/client/PerformanceScreenEffectRendererMixin.class */
@Mixin({ScreenEffectRenderer.class})
public class PerformanceScreenEffectRendererMixin {

    @Shadow
    @Final
    private static ResourceLocation UNDERWATER_LOCATION;

    @Unique
    private static final ResourceLocation BLIT_SCREEN_EFFECT_SHADER = Veil.veilPath("core/blit_screen_effect");

    @Inject(method = {"renderTex"}, at = {@At("HEAD")}, cancellable = true)
    private static void renderTex(TextureAtlasSprite texture, PoseStack poseStack, CallbackInfo ci) {
        float xScale;
        float yScale;
        ShaderProgram shader = VeilRenderSystem.setShader(BLIT_SCREEN_EFFECT_SHADER);
        if (shader == null) {
            return;
        }
        ci.cancel();
        Minecraft minecraft = Minecraft.getInstance();
        Window window = minecraft.getWindow();
        if (window.getWidth() > window.getHeight()) {
            xScale = 1.0f;
            yScale = window.getHeight() / window.getWidth();
        } else {
            xScale = window.getWidth() / window.getHeight();
            yScale = 1.0f;
        }
        ShaderUniform colorModulator = shader.getUniform((CharSequence) "ColorModulator");
        if (colorModulator != null) {
            colorModulator.setVector(0.1f, 0.1f, 0.1f, 1.0f);
        }
        ShaderUniform texOffset = shader.getUniform((CharSequence) "TexOffset");
        if (texOffset != null) {
            float u0 = texture.getU0();
            float v0 = texture.getV0();
            float u1 = texture.getU1();
            float v1 = texture.getV1();
            float uWidth = u1 - u0;
            float vHeight = v1 - v0;
            texOffset.setVector(u0 + (uWidth * (1.0f - xScale)), v0 + (vHeight * (1.0f - yScale)), uWidth * xScale, vHeight * yScale);
        }
        int activeTexture = GlStateManager._getActiveTexture();
        RenderSystem.activeTexture(33984);
        minecraft.getTextureManager().bindForSetup(texture.atlasLocation());
        shader.bind();
        VeilRenderSystem.drawScreenQuad();
        ShaderProgram.unbind();
        RenderSystem.activeTexture(activeTexture);
    }

    @Inject(method = {"renderWater"}, at = {@At("HEAD")}, cancellable = true)
    private static void renderWater(Minecraft minecraft, PoseStack poseStack, CallbackInfo ci) {
        float xScale;
        float yScale;
        ShaderProgram shader = VeilRenderSystem.setShader(BLIT_SCREEN_EFFECT_SHADER);
        if (shader == null) {
            return;
        }
        ci.cancel();
        LocalPlayer player = minecraft.player;
        ShaderUniform colorModulator = shader.getUniform((CharSequence) "ColorModulator");
        if (colorModulator != null) {
            float brightness = LightTexture.getBrightness(player.level().dimensionType(), player.level().getMaxLocalRawBrightness(player.blockPosition()));
            colorModulator.setVector(brightness, brightness, brightness, 0.1f);
        }
        ShaderUniform texOffset = shader.getUniform((CharSequence) "TexOffset");
        if (texOffset != null) {
            Window window = minecraft.getWindow();
            if (window.getWidth() > window.getHeight()) {
                xScale = 1.0f;
                yScale = window.getHeight() / window.getWidth();
            } else {
                xScale = window.getWidth() / window.getHeight();
                yScale = 1.0f;
            }
            float u = player.getYRot() / 64.0f;
            float v = (-player.getXRot()) / 64.0f;
            texOffset.setVector(u + (2.0f * (1.0f - xScale)), v + (2.0f * (1.0f - yScale)), 2.0f * xScale, 2.0f * yScale);
        }
        int activeTexture = GlStateManager._getActiveTexture();
        RenderSystem.activeTexture(33984);
        minecraft.getTextureManager().bindForSetup(UNDERWATER_LOCATION);
        RenderSystem.enableBlend();
        shader.bind();
        VeilRenderSystem.drawScreenQuad();
        ShaderProgram.unbind();
        RenderSystem.disableBlend();
        RenderSystem.activeTexture(activeTexture);
    }
}
