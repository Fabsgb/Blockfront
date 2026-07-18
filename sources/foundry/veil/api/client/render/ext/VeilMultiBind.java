package foundry.veil.api.client.render.ext;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.Veil;
import foundry.veil.api.client.render.GpuVendor;
import foundry.veil.api.client.render.VeilRenderSystem;
import java.nio.IntBuffer;
import org.lwjgl.opengl.ARBMultiBind;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11C;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.opengl.GLCapabilities;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/ext/VeilMultiBind.class */
public enum VeilMultiBind {
    LEGACY { // from class: foundry.veil.api.client.render.ext.VeilMultiBind.1
        @Override // foundry.veil.api.client.render.ext.VeilMultiBind
        public void bindTextures(int first, IntBuffer targets, IntBuffer textures) {
            int activeTexture = GlStateManager._getActiveTexture();
            for (int i = 0; i < textures.limit(); i++) {
                RenderSystem.activeTexture(33984 + first + i);
                int texture = textures.get(i);
                int target = targets.get(i);
                if (target == 3553 && first + i < 12) {
                    RenderSystem.bindTexture(texture);
                } else {
                    GL11C.glBindTexture(target, texture);
                }
            }
            RenderSystem.activeTexture(activeTexture);
        }

        @Override // foundry.veil.api.client.render.ext.VeilMultiBind
        public void bindTextures(int first, int[] targets, int[] textures) {
            int activeTexture = GlStateManager._getActiveTexture();
            for (int i = 0; i < textures.length; i++) {
                RenderSystem.activeTexture(33984 + first + i);
                int texture = textures[i];
                int target = targets[i];
                if (target == 3553 && first + i < 12) {
                    RenderSystem.bindTexture(texture);
                } else {
                    GL11C.glBindTexture(target, texture);
                }
            }
            RenderSystem.activeTexture(activeTexture);
        }

        @Override // foundry.veil.api.client.render.ext.VeilMultiBind
        public void bindSamplers(int first, IntBuffer samplers) {
            for (int i = 0; i < samplers.limit(); i++) {
                GL33C.glBindSampler(first + i, samplers.get(i));
            }
        }

        @Override // foundry.veil.api.client.render.ext.VeilMultiBind
        public void bindSamplers(int first, int... samplers) {
            for (int i = 0; i < samplers.length; i++) {
                GL33C.glBindSampler(first + i, samplers[i]);
            }
        }
    },
    SUPPORTED { // from class: foundry.veil.api.client.render.ext.VeilMultiBind.2
        @Override // foundry.veil.api.client.render.ext.VeilMultiBind
        public void bindTextures(int first, IntBuffer targets, IntBuffer textures) {
            int invalidCount = Math.min(12 - first, textures.limit());
            for (int i = first; i < invalidCount; i++) {
                if (targets.get(i - first) == 3553) {
                    GlStateManager.TEXTURES[i].binding = textures.get(i - first);
                }
            }
            ARBMultiBind.glBindTextures(first, textures);
        }

        @Override // foundry.veil.api.client.render.ext.VeilMultiBind
        public void bindTextures(int first, int[] targets, int[] textures) {
            int invalidCount = Math.min(12 - first, textures.length);
            for (int i = first; i < invalidCount; i++) {
                if (targets[i - first] == 3553) {
                    GlStateManager.TEXTURES[i].binding = textures[i - first];
                }
            }
            ARBMultiBind.glBindTextures(first, textures);
        }

        @Override // foundry.veil.api.client.render.ext.VeilMultiBind
        public void bindSamplers(int first, IntBuffer samplers) {
            ARBMultiBind.glBindSamplers(first, samplers);
        }

        @Override // foundry.veil.api.client.render.ext.VeilMultiBind
        public void bindSamplers(int first, int... samplers) {
            ARBMultiBind.glBindSamplers(first, samplers);
        }
    };

    private static VeilMultiBind multiBind;

    public abstract void bindTextures(int i, IntBuffer intBuffer, IntBuffer intBuffer2);

    public abstract void bindTextures(int i, int[] iArr, int[] iArr2);

    public abstract void bindSamplers(int i, IntBuffer intBuffer);

    public abstract void bindSamplers(int i, int... iArr);

    public static VeilMultiBind get() {
        if (multiBind == null) {
            GLCapabilities caps = GL.getCapabilities();
            if (VeilRenderSystem.gpuVendor() != GpuVendor.INTEL && (caps.OpenGL44 || caps.GL_ARB_multi_bind)) {
                multiBind = SUPPORTED;
                Veil.LOGGER.info("Multi-Bind supported, using core");
            } else {
                multiBind = LEGACY;
                Veil.LOGGER.info("Multi-Bind unsupported, using legacy");
            }
        }
        return multiBind;
    }
}
