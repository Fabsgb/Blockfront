package foundry.veil.impl.client.render.wrapper;

import com.boehmod.blockfront.InterfaceC1294xq;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.opengl.GL30C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/wrapper/LegacyVanillaAdvancedFboWrapper.class */
@ApiStatus.Internal
public class LegacyVanillaAdvancedFboWrapper extends VanillaAdvancedFboWrapper {
    public LegacyVanillaAdvancedFboWrapper(Supplier<RenderTarget> renderTargetSupplier) {
        super(renderTargetSupplier);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void clear(float red, float green, float blue, float alpha, float depth, int buffers, int... clearBuffers) {
        if (buffers == 0) {
            return;
        }
        int old = GL30C.glGetInteger(36006);
        int id = getId();
        if (old != id) {
            bind(false);
        }
        if ((buffers & InterfaceC1294xq.f8660tV) != 0) {
            RenderSystem.clearColor(red, green, blue, alpha);
        }
        if ((buffers & 256) != 0) {
            RenderSystem.clearDepth(depth);
        }
        RenderSystem.clear(buffers, Minecraft.ON_OSX);
        if (old != id) {
            GlStateManager._glBindFramebuffer(36160, old);
        }
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void resolveToFbo(int id, int width, int height, int mask, int filtering) {
        int oldRead = GL30C.glGetInteger(36010);
        int oldDraw = GL30C.glGetInteger(36006);
        bindRead();
        GlStateManager._glBindFramebuffer(36009, id);
        GL30C.glBlitFramebuffer(0, 0, getWidth(), getHeight(), 0, 0, width, height, mask, filtering);
        GlStateManager._glBindFramebuffer(36008, oldRead);
        GlStateManager._glBindFramebuffer(36009, oldDraw);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void resolveToAdvancedFbo(AdvancedFbo target, int mask, int filtering) {
        int oldRead = GL30C.glGetInteger(36010);
        int oldDraw = GL30C.glGetInteger(36006);
        bindRead();
        target.bindDraw(false);
        GL30C.glBlitFramebuffer(0, 0, getWidth(), getHeight(), 0, 0, target.getWidth(), target.getHeight(), mask, filtering);
        GlStateManager._glBindFramebuffer(36008, oldRead);
        GlStateManager._glBindFramebuffer(36009, oldDraw);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void resolveToRenderTarget(RenderTarget target, int mask, int filtering) {
        int oldRead = GL30C.glGetInteger(36010);
        int oldDraw = GL30C.glGetInteger(36006);
        bindRead();
        GlStateManager._glBindFramebuffer(36009, target.frameBufferId);
        GL30C.glBlitFramebuffer(0, 0, getWidth(), getHeight(), 0, 0, target.width, target.height, mask, filtering);
        GlStateManager._glBindFramebuffer(36008, oldRead);
        GlStateManager._glBindFramebuffer(36009, oldDraw);
    }
}
