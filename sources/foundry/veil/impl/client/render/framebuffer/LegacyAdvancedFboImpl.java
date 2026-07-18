package foundry.veil.impl.client.render.framebuffer;

import com.boehmod.blockfront.InterfaceC1294xq;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.ext.VeilDebug;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.Locale;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL20C;
import org.lwjgl.opengl.GL30C;
import org.lwjgl.system.MemoryStack;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/framebuffer/LegacyAdvancedFboImpl.class */
@ApiStatus.Internal
public class LegacyAdvancedFboImpl extends AdvancedFboImpl {
    public LegacyAdvancedFboImpl(int width, int height, AdvancedFboAttachment[] colorAttachments, @Nullable AdvancedFboAttachment depthAttachment, @Nullable String debugLabel) {
        super(width, height, colorAttachments, depthAttachment, debugLabel);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void create() {
        for (AdvancedFboAttachment attachment : this.colorAttachments) {
            attachment.create();
        }
        if (this.depthAttachment != null) {
            this.depthAttachment.create();
        }
        RenderSystem.bindTexture(0);
        int oldFbo = GL30C.glGetInteger(36006);
        this.f8772id = GL30C.glGenFramebuffers();
        bind(false);
        if (this.debugLabel != null) {
            VeilDebug.get().objectLabel(36160, this.f8772id, "Advanced Fbo " + this.debugLabel);
        }
        for (int i = 0; i < this.colorAttachments.length; i++) {
            this.colorAttachments[i].attach(this, i);
        }
        if (this.depthAttachment != null) {
            this.depthAttachment.attach(this, 0);
        }
        int status = GL30C.glCheckFramebufferStatus(36160);
        if (status != 36053) {
            String error = ERRORS.containsKey(Integer.valueOf(status)) ? ERRORS.get(Integer.valueOf(status)) : "0x" + Integer.toHexString(status).toUpperCase(Locale.ROOT);
            throw new IllegalStateException("Advanced FBO status did not return GL_FRAMEBUFFER_COMPLETE. " + error);
        }
        this.currentDrawBuffers = this.drawBuffers;
        GlStateManager._glBindFramebuffer(36160, oldFbo);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void clear(float red, float green, float blue, float alpha, float depth, int clearMask, int... buffers) {
        if (clearMask == 0) {
            return;
        }
        MemoryStack stack = MemoryStack.stackPush();
        try {
            int oldFbo = GL30C.glGetInteger(36006);
            if (oldFbo != this.f8772id) {
                bind(false);
            }
            boolean hasColor = (clearMask & InterfaceC1294xq.f8660tV) != 0;
            boolean hasDepth = (clearMask & 256) != 0;
            FloatBuffer oldColor = null;
            FloatBuffer oldDepth = null;
            if (hasColor) {
                drawBuffers(buffers);
                oldColor = stack.mallocFloat(4);
                GL30C.glGetFloatv(3106, oldColor);
                GL30C.glClearColor(red, green, blue, alpha);
            }
            if (hasDepth) {
                oldDepth = stack.mallocFloat(1);
                GL30C.glGetFloatv(2931, oldDepth);
                GL30C.glClearDepth(depth);
            }
            GlStateManager._clear(clearMask, Minecraft.ON_OSX);
            if (hasColor) {
                GL30C.glClearColor(oldColor.get(0), oldColor.get(1), oldColor.get(2), oldColor.get(3));
                resetDrawBuffers();
            }
            if (hasDepth) {
                GL30C.glClearDepth(oldDepth.get(0));
            }
            if (oldFbo != this.f8772id) {
                GlStateManager._glBindFramebuffer(36160, oldFbo);
            }
            if (stack != null) {
                stack.close();
            }
            if (Minecraft.ON_OSX) {
                GL30C.glGetError();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void setDrawBuffers(int[] buffers) {
        int oldFbo = GL30C.glGetInteger(36006);
        if (oldFbo != this.f8772id) {
            bind(false);
        }
        GL20C.glDrawBuffers(buffers);
        if (oldFbo != this.f8772id) {
            GlStateManager._glBindFramebuffer(36160, oldFbo);
        }
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void resetDrawBuffers() {
        if (Arrays.mismatch(this.currentDrawBuffers, this.drawBuffers) >= 0) {
            this.currentDrawBuffers = this.drawBuffers;
            setDrawBuffers(this.drawBuffers);
        }
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void drawBuffers(int... buffers) {
        if (Arrays.mismatch(this.currentDrawBuffers, buffers) >= 0) {
            if (this.currentDrawBuffers.length != buffers.length) {
                this.currentDrawBuffers = Arrays.copyOf(buffers, buffers.length);
            } else {
                System.arraycopy(buffers, 0, this.currentDrawBuffers, 0, buffers.length);
            }
            setDrawBuffers(buffers);
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

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void setColorAttachmentTexture(int attachment, int textureId, int layer) {
        int old = GL30C.glGetInteger(36006);
        if (old != this.f8772id) {
            bind(false);
        }
        super.setColorAttachmentTexture(attachment, textureId, layer);
        if (old != this.f8772id) {
            GlStateManager._glBindFramebuffer(36160, old);
        }
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void setDepthAttachmentTexture(int textureId, int layer) {
        int old = GL30C.glGetInteger(36006);
        if (old != this.f8772id) {
            bind(false);
        }
        super.setDepthAttachmentTexture(textureId, layer);
        if (old != this.f8772id) {
            GlStateManager._glBindFramebuffer(36160, old);
        }
    }
}
