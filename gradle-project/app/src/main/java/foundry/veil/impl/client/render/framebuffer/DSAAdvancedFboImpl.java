package foundry.veil.impl.client.render.framebuffer;

import com.boehmod.blockfront.InterfaceC1274xN;
import com.mojang.blaze3d.pipeline.RenderTarget;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.ext.VeilDebug;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment;
import foundry.veil.api.client.render.framebuffer.AdvancedFboTextureAttachment;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.Locale;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.ARBClearTexture;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.GL30C;
import org.lwjgl.system.MemoryStack;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/framebuffer/DSAAdvancedFboImpl.class */
@ApiStatus.Internal
public class DSAAdvancedFboImpl extends AdvancedFboImpl {
    public DSAAdvancedFboImpl(int width, int height, AdvancedFboAttachment[] colorAttachments, @Nullable AdvancedFboAttachment depthAttachment, @Nullable String debugLabel) {
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
        this.f9158id = ARBDirectStateAccess.glCreateFramebuffers();
        if (this.debugLabel != null) {
            VeilDebug.get().objectLabel(36160, this.f9158id, "Advanced Fbo " + this.debugLabel);
        }
        for (int i = 0; i < this.colorAttachments.length; i++) {
            this.colorAttachments[i].attach(this, i);
        }
        if (this.depthAttachment != null) {
            this.depthAttachment.attach(this, 0);
        }
        int status = ARBDirectStateAccess.glCheckNamedFramebufferStatus(this.f9158id, 36160);
        if (status != 36053) {
            String error = ERRORS.containsKey(Integer.valueOf(status)) ? ERRORS.get(Integer.valueOf(status)) : "0x" + Integer.toHexString(status).toUpperCase(Locale.ROOT);
            throw new IllegalStateException("Advanced FBO status did not return GL_FRAMEBUFFER_COMPLETE. " + error);
        }
        this.currentDrawBuffers = this.drawBuffers;
        ARBDirectStateAccess.glNamedFramebufferDrawBuffers(this.f9158id, this.drawBuffers);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x011c A[Catch: Throwable -> 0x01b8, TryCatch #1 {Throwable -> 0x01b8, blocks: (B:6:0x000b, B:8:0x0019, B:11:0x0038, B:13:0x004b, B:15:0x0055, B:17:0x0063, B:19:0x006b, B:20:0x0086, B:21:0x0094, B:22:0x009a, B:24:0x00a1, B:28:0x00af, B:30:0x00b8, B:42:0x00dd, B:50:0x00f3, B:52:0x0101, B:53:0x011c, B:56:0x0136, B:59:0x014d, B:62:0x016b, B:64:0x0179, B:65:0x0199), top: B:83:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0199 A[Catch: Throwable -> 0x01b8, TryCatch #1 {Throwable -> 0x01b8, blocks: (B:6:0x000b, B:8:0x0019, B:11:0x0038, B:13:0x004b, B:15:0x0055, B:17:0x0063, B:19:0x006b, B:20:0x0086, B:21:0x0094, B:22:0x009a, B:24:0x00a1, B:28:0x00af, B:30:0x00b8, B:42:0x00dd, B:50:0x00f3, B:52:0x0101, B:53:0x011c, B:56:0x0136, B:59:0x014d, B:62:0x016b, B:64:0x0179, B:65:0x0199), top: B:83:0x000b }] */
    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void clear(float red, float green, float blue, float alpha, float depth, int clearMask, int... buffers) {
        if (clearMask == 0) {
            return;
        }
        MemoryStack stack = MemoryStack.stackPush();
        try {
            boolean clearTex = VeilRenderSystem.clearTextureSupported();
            if ((clearMask & InterfaceC1274xN.f6857vZ) != 0) {
                FloatBuffer color = stack.floats(red, green, blue, alpha);
                for (int buffer : buffers) {
                    int i = buffer - 36064;
                    if (i >= 0 && i < this.colorAttachments.length) {
                        AdvancedFboAttachment attachment = this.colorAttachments[i];
                        if (clearTex && (attachment instanceof AdvancedFboTextureAttachment)) {
                            AdvancedFboTextureAttachment texture = (AdvancedFboTextureAttachment) attachment;
                            ARBClearTexture.glClearTexImage(texture.getId(), 0, 6408, 5126, color);
                        } else {
                            ARBDirectStateAccess.glClearNamedFramebufferfv(this.f9158id, 6144, i, color);
                        }
                    }
                }
            }
            if (this.depthAttachment != null) {
                boolean hasDepth = (clearMask & 256) != 0;
                boolean hasStencil = this.hasStencil && (clearMask & 1024) != 0;
                if (hasDepth || hasStencil) {
                    if (this.hasStencil) {
                        if (hasDepth && hasStencil) {
                            if (clearTex) {
                                AdvancedFboAttachment advancedFboAttachment = this.depthAttachment;
                                if (advancedFboAttachment instanceof AdvancedFboTextureAttachment) {
                                    AdvancedFboTextureAttachment texture2 = (AdvancedFboTextureAttachment) advancedFboAttachment;
                                    ARBClearTexture.glClearTexImage(texture2.getId(), 0, 34041, 36269, (ByteBuffer) null);
                                } else {
                                    ARBDirectStateAccess.glClearNamedFramebufferfi(this.f9158id, 34041, 0, depth, GL30C.glGetInteger(2961));
                                }
                            } else {
                                ARBDirectStateAccess.glClearNamedFramebufferfi(this.f9158id, 34041, 0, depth, GL30C.glGetInteger(2961));
                            }
                        } else {
                            if (hasDepth) {
                                ARBDirectStateAccess.glClearNamedFramebufferfv(this.f9158id, 6145, 0, stack.floats(depth));
                            }
                            if (hasStencil) {
                                ARBDirectStateAccess.glClearNamedFramebufferiv(this.f9158id, 6146, 0, stack.ints(GL30C.glGetInteger(2961)));
                            }
                        }
                    } else if (clearTex) {
                        AdvancedFboAttachment advancedFboAttachment2 = this.depthAttachment;
                        if (advancedFboAttachment2 instanceof AdvancedFboTextureAttachment) {
                            AdvancedFboTextureAttachment texture3 = (AdvancedFboTextureAttachment) advancedFboAttachment2;
                            ARBClearTexture.glClearTexImage(texture3.getId(), 0, 6402, 5126, stack.floats(depth));
                        } else {
                            ARBDirectStateAccess.glClearNamedFramebufferfv(this.f9158id, 6145, 0, stack.floats(depth));
                        }
                    } else {
                        ARBDirectStateAccess.glClearNamedFramebufferfv(this.f9158id, 6145, 0, stack.floats(depth));
                    }
                } else {
                    if (stack != null) {
                        stack.close();
                        return;
                    }
                    return;
                }
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

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void resetDrawBuffers() {
        if (Arrays.mismatch(this.currentDrawBuffers, this.drawBuffers) >= 0) {
            this.currentDrawBuffers = this.drawBuffers;
            ARBDirectStateAccess.glNamedFramebufferDrawBuffers(this.f9158id, this.drawBuffers);
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
            ARBDirectStateAccess.glNamedFramebufferDrawBuffers(this.f9158id, buffers);
        }
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void resolveToFbo(int id, int width, int height, int mask, int filtering) {
        ARBDirectStateAccess.glBlitNamedFramebuffer(this.f9158id, id, 0, 0, getWidth(), getHeight(), 0, 0, width, height, mask, filtering);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void resolveToAdvancedFbo(AdvancedFbo target, int mask, int filtering) {
        ARBDirectStateAccess.glBlitNamedFramebuffer(this.f9158id, target.getId(), 0, 0, getWidth(), getHeight(), 0, 0, target.getWidth(), target.getHeight(), mask, filtering);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void resolveToRenderTarget(RenderTarget target, int mask, int filtering) {
        ARBDirectStateAccess.glBlitNamedFramebuffer(this.f9158id, target.frameBufferId, 0, 0, getWidth(), getHeight(), 0, 0, target.width, target.height, mask, filtering);
    }
}
