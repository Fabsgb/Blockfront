package foundry.veil.impl.client.render.wrapper;

import com.boehmod.blockfront.InterfaceC1294xq;
import com.mojang.blaze3d.pipeline.RenderTarget;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import java.nio.ByteBuffer;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.opengl.ARBClearTexture;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.GL30C;
import org.lwjgl.system.MemoryStack;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/wrapper/DSAVanillaAdvancedFboWrapper.class */
@ApiStatus.Internal
public class DSAVanillaAdvancedFboWrapper extends VanillaAdvancedFboWrapper {
    public DSAVanillaAdvancedFboWrapper(Supplier<RenderTarget> renderTargetSupplier) {
        super(renderTargetSupplier);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void clear(float red, float green, float blue, float alpha, float depth, int clearMask, int... clearBuffers) {
        if (clearMask == 0) {
            return;
        }
        MemoryStack stack = MemoryStack.stackPush();
        try {
            boolean clearTex = VeilRenderSystem.clearTextureSupported();
            RenderTarget renderTarget = mo9156toRenderTarget();
            if ((clearMask & InterfaceC1294xq.f8660tV) != 0) {
                if (clearTex) {
                    ARBClearTexture.glClearTexImage(renderTarget.getColorTextureId(), 0, 6408, 5126, stack.floats(red, green, blue, alpha));
                } else {
                    ARBDirectStateAccess.glClearNamedFramebufferfv(renderTarget.getColorTextureId(), 6144, 0, stack.floats(red, green, blue, alpha));
                }
            }
            if (renderTarget.useDepth) {
                boolean hasStencilAttachment = hasStencilAttachment();
                boolean hasDepth = (clearMask & 256) != 0;
                boolean hasStencil = hasStencilAttachment && (clearMask & InterfaceC1294xq.f8656tR) != 0;
                if (hasDepth || hasStencil) {
                    if (hasStencilAttachment) {
                        if (hasDepth && hasStencil) {
                            if (clearTex) {
                                ARBClearTexture.glClearTexImage(renderTarget.getDepthTextureId(), 0, 34041, 36269, (ByteBuffer) null);
                            } else {
                                ARBDirectStateAccess.glClearNamedFramebufferfi(getId(), 34041, 0, depth, GL30C.glGetInteger(2961));
                            }
                        } else {
                            if (hasDepth) {
                                ARBDirectStateAccess.glClearNamedFramebufferfv(getId(), 6145, 0, stack.floats(depth));
                            }
                            if (hasStencil) {
                                ARBDirectStateAccess.glClearNamedFramebufferiv(getId(), 6146, 0, stack.ints(GL30C.glGetInteger(2961)));
                            }
                        }
                    } else if (clearTex) {
                        ARBClearTexture.glClearTexImage(renderTarget.getDepthTextureId(), 0, 6402, 5126, stack.floats(depth));
                    } else {
                        ARBDirectStateAccess.glClearNamedFramebufferfv(getId(), 6145, 0, stack.floats(depth));
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
    public void resolveToFbo(int id, int width, int height, int mask, int filtering) {
        ARBDirectStateAccess.glBlitNamedFramebuffer(getId(), id, 0, 0, getWidth(), getHeight(), 0, 0, width, height, mask, filtering);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void resolveToAdvancedFbo(AdvancedFbo target, int mask, int filtering) {
        ARBDirectStateAccess.glBlitNamedFramebuffer(getId(), target.getId(), 0, 0, getWidth(), getHeight(), 0, 0, target.getWidth(), target.getHeight(), mask, filtering);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void resolveToRenderTarget(RenderTarget target, int mask, int filtering) {
        ARBDirectStateAccess.glBlitNamedFramebuffer(getId(), target.frameBufferId, 0, 0, getWidth(), getHeight(), 0, 0, target.width, target.height, mask, filtering);
    }
}
