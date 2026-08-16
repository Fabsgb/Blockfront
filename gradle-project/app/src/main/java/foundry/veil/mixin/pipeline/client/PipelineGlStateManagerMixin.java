package foundry.veil.mixin.pipeline.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.platform.GlStateManager;
import foundry.veil.api.client.render.VeilRenderSystem;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/pipeline/client/PipelineGlStateManagerMixin.class */
@Mixin({GlStateManager.class})
public class PipelineGlStateManagerMixin {
    @WrapOperation(method = {"_glGenBuffers"}, at = {@At(value = "INVOKE", target = "Lorg/lwjgl/opengl/GL15;glGenBuffers()I", remap = false)}, remap = false)
    private static int createBuffers(Operation<Integer> original) {
        return VeilRenderSystem.directStateAccessSupported() ? ARBDirectStateAccess.glCreateBuffers() : ((Integer) original.call(new Object[0])).intValue();
    }

    @WrapOperation(method = {"_glGenVertexArrays"}, at = {@At(value = "INVOKE", target = "Lorg/lwjgl/opengl/GL30;glGenVertexArrays()I", remap = false)}, remap = false)
    private static int createVertexArrays(Operation<Integer> original) {
        return VeilRenderSystem.directStateAccessSupported() ? ARBDirectStateAccess.glCreateVertexArrays() : ((Integer) original.call(new Object[0])).intValue();
    }

    @WrapOperation(method = {"glGenFramebuffers"}, at = {@At(value = "INVOKE", target = "Lorg/lwjgl/opengl/GL30;glGenFramebuffers()I", remap = false)}, remap = false)
    private static int glGenFramebuffers(Operation<Integer> original) {
        return VeilRenderSystem.directStateAccessSupported() ? ARBDirectStateAccess.glCreateFramebuffers() : ((Integer) original.call(new Object[0])).intValue();
    }

    @WrapOperation(method = {"glGenRenderbuffers"}, at = {@At(value = "INVOKE", target = "Lorg/lwjgl/opengl/GL30;glGenRenderbuffers()I", remap = false)}, remap = false)
    private static int glGenRenderbuffers(Operation<Integer> original) {
        return VeilRenderSystem.directStateAccessSupported() ? ARBDirectStateAccess.glCreateRenderbuffers() : ((Integer) original.call(new Object[0])).intValue();
    }
}
