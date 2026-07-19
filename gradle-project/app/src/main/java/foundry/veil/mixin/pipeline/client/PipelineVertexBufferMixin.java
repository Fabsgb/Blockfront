package foundry.veil.mixin.pipeline.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexFormat;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.ext.VertexBufferExtension;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.ARBMultiDrawIndirect;
import org.lwjgl.opengl.GL11C;
import org.lwjgl.opengl.GL15C;
import org.lwjgl.opengl.GL31C;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/pipeline/client/PipelineVertexBufferMixin.class */
@Mixin({VertexBuffer.class})
public abstract class PipelineVertexBufferMixin implements VertexBufferExtension {

    @Shadow
    private VertexFormat.Mode mode;

    @Shadow
    private int indexBufferId;

    @Shadow
    private int indexCount;

    @Shadow
    @Nullable
    private RenderSystem.AutoStorageIndexBuffer sequentialIndices;

    @Shadow
    private VertexFormat.IndexType indexType;

    @Shadow
    protected abstract VertexFormat.IndexType getIndexType();

    @Override // foundry.veil.ext.VertexBufferExtension
    public void veil$drawInstanced(int instances) {
        VeilRenderSystem.renderThreadExecutor().execute(() -> {
            _veil$drawInstanced(instances);
        });
    }

    @Override // foundry.veil.ext.VertexBufferExtension
    public void veil$drawIndirect(long indirect, int drawCount, int stride) {
        VeilRenderSystem.renderThreadExecutor().execute(() -> {
            _veil$drawIndirect(indirect, drawCount, stride);
        });
    }

    @Override // foundry.veil.ext.VertexBufferExtension
    public int veil$getIndexCount() {
        return this.indexCount;
    }

    @Inject(method = {"draw"}, at = {@At("HEAD")}, cancellable = true)
    public void drawPatches(CallbackInfo ci) {
        ShaderProgram shader;
        if (this.mode == VertexFormat.Mode.QUADS && (shader = VeilRenderSystem.getShader()) != null && shader.hasTesselation() && shader.getProgram() == GL11C.glGetInteger(35725)) {
            GL11C.glDrawArrays(14, 0, (this.indexCount * 4) / 6);
            ci.cancel();
        }
    }

    @ModifyArg(method = {"draw"}, at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;drawElements(III)V", remap = false), index = 0)
    public int modifyDrawMode(int glMode) {
        return veil$getDrawMode(glMode);
    }

    @Unique
    private int veil$getDrawMode(int defaultMode) {
        ShaderProgram shader = VeilRenderSystem.getShader();
        if (shader != null && shader.hasTesselation() && shader.getProgram() == GL11C.glGetInteger(35725)) {
            return 14;
        }
        return defaultMode;
    }

    @Unique
    private void _veil$drawInstanced(int instances) {
        ShaderProgram shader;
        if (this.mode == VertexFormat.Mode.QUADS && (shader = VeilRenderSystem.getShader()) != null && shader.hasTesselation() && shader.getProgram() == GL11C.glGetInteger(35725)) {
            GL31C.glDrawArraysInstanced(14, 0, (this.indexCount * 4) / 6, instances);
        } else {
            GL31C.glDrawElementsInstanced(veil$getDrawMode(this.mode.asGLMode), this.indexCount, getIndexType().asGLType, 0L, instances);
        }
    }

    @Unique
    private void _veil$drawIndirect(long indirect, int drawCount, int stride) {
        if (!VeilRenderSystem.multiDrawIndirectSupported()) {
            throw new UnsupportedOperationException("Indirect rendering is not supported");
        }
        if (this.sequentialIndices != null) {
            this.sequentialIndices.bind(this.indexCount);
            ARBMultiDrawIndirect.glMultiDrawElementsIndirect(veil$getDrawMode(this.mode.asGLMode), this.sequentialIndices.type().asGLType, indirect, drawCount, stride);
        } else {
            GL15C.glBindBuffer(34963, this.indexBufferId);
            ARBMultiDrawIndirect.glMultiDrawElementsIndirect(veil$getDrawMode(this.mode.asGLMode), this.indexType.asGLType, indirect, drawCount, stride);
        }
    }
}
