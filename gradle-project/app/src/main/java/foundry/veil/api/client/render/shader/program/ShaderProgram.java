package foundry.veil.api.client.render.shader.program;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexFormat;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.ShaderFeature;
import foundry.veil.api.client.render.shader.compiler.CompiledShader;
import foundry.veil.api.client.render.shader.uniform.ShaderUniform;
import foundry.veil.impl.client.render.shader.program.ShaderProgramImpl;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import java.util.Set;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4fc;
import org.lwjgl.opengl.GL31C;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/program/ShaderProgram.class */
@ApiStatus.NonExtendable
public interface ShaderProgram extends NativeResource, UniformAccess, TextureUniformAccess {
    void setDefaultUniforms(VertexFormat.Mode mode, Matrix4fc matrix4fc, Matrix4fc matrix4fc2);

    int getProgram();

    int getActiveDynamicBuffers();

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    ShaderUniform getUniform(CharSequence charSequence);

    @Nullable
    ProgramDefinition getDefinition();

    Int2ObjectMap<CompiledShader> getShaders();

    boolean isValid();

    Set<ShaderFeature> getRequiredFeatures();

    @Nullable
    VertexFormat getFormat();

    Set<String> getDefinitionDependencies();

    ResourceLocation getName();

    @Deprecated
    ShaderInstance toShaderInstance();

    default void bind() {
        int program = getProgram();
        if (ShaderInstance.lastProgramId != program) {
            ShaderInstance.lastProgramId = program;
            GlStateManager._glUseProgram(program);
        }
        EffectInstance.lastProgramId = -1;
    }

    static void unbind() {
        VeilRenderSystem.clearShaderBlocks();
        GlStateManager._glUseProgram(0);
        ShaderInstance.lastProgramId = -1;
        EffectInstance.lastProgramId = -1;
        VeilRenderSystem.unbindSamplers(0, VeilRenderSystem.maxCombinedTextureUnits());
        ShaderProgramImpl.restoreBlendState();
    }

    default void setDefaultUniforms(VertexFormat.Mode mode) {
        setDefaultUniforms(mode, RenderSystem.getModelViewMatrix(), RenderSystem.getProjectionMatrix());
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    default void setUniformBlock(CharSequence name, int binding) {
        int index = getUniformBlock(name);
        if (index != -1) {
            GL31C.glUniformBlockBinding(getProgram(), index, binding);
        }
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    default void setStorageBlock(CharSequence name, int binding) {
        int index = getStorageBlock(name);
        if (index != -1) {
            GL43C.glShaderStorageBlockBinding(getProgram(), index, binding);
        }
    }

    @Nullable
    default CompiledShader getVertexShader() {
        return (CompiledShader) getShaders().get(35633);
    }

    @Nullable
    default CompiledShader getGeometryShader() {
        return (CompiledShader) getShaders().get(36313);
    }

    @Nullable
    default CompiledShader getTessellationControlShader() {
        return (CompiledShader) getShaders().get(36488);
    }

    @Nullable
    default CompiledShader getTessellationEvaluationShader() {
        return (CompiledShader) getShaders().get(36487);
    }

    @Nullable
    default CompiledShader getFragmentShader() {
        return (CompiledShader) getShaders().get(35632);
    }

    @Nullable
    default CompiledShader getComputeShader() {
        return (CompiledShader) getShaders().get(37305);
    }

    default boolean hasVertex() {
        return getShaders().containsKey(35633);
    }

    default boolean hasGeometry() {
        return getShaders().containsKey(36313);
    }

    default boolean hasFragment() {
        return getShaders().containsKey(35633);
    }

    default boolean hasTesselation() {
        Int2ObjectMap<CompiledShader> shaders = getShaders();
        return shaders.containsKey(36488) && shaders.containsKey(36487);
    }

    default boolean isCompute() {
        return getShaders().containsKey(37305);
    }
}
