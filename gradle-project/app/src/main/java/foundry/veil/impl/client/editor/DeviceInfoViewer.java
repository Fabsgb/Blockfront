package foundry.veil.impl.client.editor;

import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.editor.SingleWindowInspector;
import foundry.veil.api.client.imgui.VeilImGuiUtil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.VeilShaderLimits;
import imgui.ImGui;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.opengl.GLCapabilities;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/editor/DeviceInfoViewer.class */
@ApiStatus.Internal
public class DeviceInfoViewer extends SingleWindowInspector {
    public static final Component TITLE = Component.translatable("inspector.veil.device_info.title");
    private static final Component UNSUPPORTED = Component.translatable("inspector.veil.device_info.unsupported");
    private static final Component YES = CommonComponents.GUI_YES.copy().withStyle(style -> {
        return style.withColor(-16711936);
    });
    private static final Component NO = CommonComponents.GUI_NO.copy().withStyle(style -> {
        return style.withColor(-65536);
    });
    private static final Component GL_FEATURE_FLAG = Component.translatable("inspector.veil.device_info.opengl.feature_flag");
    private static final Component GL_VERTEX_ARRAY = Component.translatable("inspector.veil.device_info.opengl.vertex_array");
    private static final Component GL_UNIFORM = Component.translatable("inspector.veil.device_info.opengl.uniform");
    private static final Component GL_TRANSFORM_FEEDBACK = Component.translatable("inspector.veil.device_info.opengl.transform_feedback");
    private static final Component GL_ATOMIC_COUNTER = Component.translatable("inspector.veil.device_info.opengl.atomic_counter");
    private static final Component GL_SHADER_STORAGE = Component.translatable("inspector.veil.device_info.opengl.shader_storage");
    private static final Component GL_TEXTURE = Component.translatable("inspector.veil.device_info.opengl.texture");
    private static final Component GL_FRAMEBUFFER = Component.translatable("inspector.veil.device_info.opengl.framebuffer");
    private static final Map<Integer, Component> SHADER_TYPES;
    private static final int TEXT_COLOR = -5592406;

    static {
        Map<Integer, Component> map = new LinkedHashMap<>();
        map.put(35633, Component.translatable("inspector.veil.shader.vertex_shader"));
        map.put(36488, Component.translatable("inspector.veil.shader.tess_control_shader"));
        map.put(36487, Component.translatable("inspector.veil.shader.tess_eval_shader"));
        map.put(36313, Component.translatable("inspector.veil.shader.geometry_shader"));
        map.put(35632, Component.translatable("inspector.veil.shader.fragment_shader"));
        map.put(37305, Component.translatable("inspector.veil.shader.compute_shader"));
        SHADER_TYPES = Collections.unmodifiableMap(map);
    }

    private static void text(String key, @Nullable String tooltip, @Nullable Object... values) {
        if (values != null) {
            Object[] valueComponents = Arrays.stream(values).filter(Objects::nonNull).map(value -> {
                if (!(value instanceof MutableComponent)) {
                    return Component.literal(value.toString()).withStyle(style -> {
                        return style.withColor(-1);
                    });
                }
                MutableComponent c = (MutableComponent) value;
                return c.withStyle(style2 -> {
                    return style2.withColor(-1);
                });
            }).toArray();
            if (valueComponents.length == 0) {
                VeilImGuiUtil.component(Component.translatable(key, new Object[]{UNSUPPORTED}).withStyle(style -> {
                    return style.withColor(VeilImGuiUtil.getColor(1));
                }));
            } else {
                VeilImGuiUtil.component(Component.translatable(key, valueComponents));
            }
        } else {
            VeilImGuiUtil.component(Component.translatable(key, new Object[]{UNSUPPORTED}).withStyle(style2 -> {
                return style2.withColor(VeilImGuiUtil.getColor(1));
            }));
        }
        if (tooltip != null) {
            ImGui.sameLine();
            VeilImGuiUtil.tooltip(tooltip);
        }
    }

    private static void flagText(String key, boolean supported, @Nullable String tooltip) {
        Object[] objArr = new Object[1];
        objArr[0] = supported ? YES : NO;
        VeilImGuiUtil.component(Component.translatable(key, objArr));
        if (tooltip != null) {
            ImGui.sameLine();
            VeilImGuiUtil.tooltip(tooltip);
        }
    }

    private static void title(Component component) {
        ImGui.pushStyleColor(0, -1);
        VeilImGuiUtil.component(component);
        ImGui.popStyleColor();
    }

    private void renderOpenGL() {
        ImGui.pushStyleColor(0, -1);
        text("inspector.veil.device_info.opengl.vendor", null, GL43C.glGetString(7936));
        text("inspector.veil.device_info.opengl.renderer", null, GL43C.glGetString(7937));
        text("inspector.veil.device_info.opengl.version", null, GL43C.glGetString(7938));
        ImGui.popStyleColor();
        ImGui.separator();
        title(GL_FEATURE_FLAG);
        flagText("inspector.veil.device_info.opengl.feature_flag.tessellation", VeilRenderSystem.tessellationSupported(), "Whether tessellation shaders can be used");
        flagText("inspector.veil.device_info.opengl.feature_flag.compute", VeilRenderSystem.computeSupported(), "Whether compute shaders can be used");
        flagText("inspector.veil.device_info.opengl.feature_flag.atomic_counter", VeilRenderSystem.atomicCounterSupported(), "Whether atomic counters can be used in shaders");
        flagText("inspector.veil.device_info.opengl.feature_flag.transform_feedback", VeilRenderSystem.transformFeedbackSupported(), "Whether transform feedback can be used");
        flagText("inspector.veil.device_info.opengl.feature_flag.multi_bind", VeilRenderSystem.multibindSupported(), "Whether glBindTextures can be used instead of glBindTexture");
        flagText("inspector.veil.device_info.opengl.feature_flag.sparse_buffers", VeilRenderSystem.sparseBuffersSupported(), "Whether sparse buffers can be used");
        flagText("inspector.veil.device_info.opengl.feature_flag.direct_state_access", VeilRenderSystem.directStateAccessSupported(), "Whether direct state accesss can be used");
        flagText("inspector.veil.device_info.opengl.feature_flag.separate_shader_objects", VeilRenderSystem.separateShaderObjectsSupported(), "Whether program pipelines can be used");
        flagText("inspector.veil.device_info.opengl.feature_flag.clear_texture", VeilRenderSystem.clearTextureSupported(), "Whether glClearTexImage can be used");
        flagText("inspector.veil.device_info.opengl.feature_flag.copy_image", VeilRenderSystem.copyImageSupported(), "Whether glCopyImageSubData can be used");
        flagText("inspector.veil.device_info.opengl.feature_flag.shader_storage_buffers", VeilRenderSystem.shaderStorageBufferSupported(), "Whether shader storage buffers can be used");
        flagText("inspector.veil.device_info.opengl.feature_flag.program_interface_query", VeilRenderSystem.programInterfaceQuerySupported(), "Whether the new style program interface query can be used");
        flagText("inspector.veil.device_info.opengl.feature_flag.texture_anisotropy", VeilRenderSystem.textureAnisotropySupported(), "Whether GL_TEXTURE_MAX_ANISOTROPY can be set as a texture parameter");
        flagText("inspector.veil.device_info.opengl.feature_flag.texture_mirror_clamp_to_edge", VeilRenderSystem.textureMirrorClampToEdgeSupported(), "Whether GL_MIRROR_CLAMP_TO_EDGE can be set as a texture edge value option");
        flagText("inspector.veil.device_info.opengl.feature_flag.texture_cube_map_seamless", VeilRenderSystem.textureCubeMapSeamlessSupported(), "Whether GL_TEXTURE_CUBE_MAP_SEAMLESS can be set as a texture parameter");
        flagText("inspector.veil.device_info.opengl.feature_flag.texture_cube_map_array", VeilRenderSystem.textureCubeMapArraySupported(), "Whether GL_TEXTURE_CUBE_MAP_ARRAY can be used as a texture type");
        flagText("inspector.veil.device_info.opengl.feature_flag.nv_draw_texture", VeilRenderSystem.nvDrawTextureSupported(), "Whether glDrawTextureNV can be used");
        flagText("inspector.veil.device_info.opengl.feature_flag.draw_indirect", VeilRenderSystem.drawIndirectSupported(), "Whether glDrawArraysInstanced and glDrawElementsInstancedBaseVertex can be used");
        flagText("inspector.veil.device_info.opengl.feature_flag.multi_draw_indirect", VeilRenderSystem.multiDrawIndirectSupported(), "Whether multiple indirect commands can be natively drawn in one command");
        flagText("inspector.veil.device_info.opengl.feature_flag.shader_float64", VeilRenderSystem.gpuShaderFloat64BitSupported(), "Whether 64-bit floats can be used in shader files");
        flagText("inspector.veil.device_info.opengl.feature_flag.shader_int64", VeilRenderSystem.gpuShaderInt64BitSupported(), "Whether 64-bit integers can be used in shader files");
        flagText("inspector.veil.device_info.opengl.feature_flag.vertex_attribute_64", VeilRenderSystem.vertexAttribute64BitSupported(), "Whether 64-bit values can be used as vertex attributes");
        flagText("inspector.veil.device_info.opengl.feature_flag.bindless_texture", VeilRenderSystem.bindlessTextureSupported(), "Whether shaders can reference textures by handle instead of by unit");
        flagText("inspector.veil.device_info.opengl.feature_flag.vertex_type_10f_11f_11f_rev", VeilRenderSystem.vertexType10F11F11FRevSupported(), "Whether Vertex Arrays can use GL_UNSIGNED_INT_10F_11F_11F_REV");
        flagText("inspector.veil.device_info.opengl.feature_flag.pipeline_statistics_query", VeilRenderSystem.pipelineStatisticsQuerySupported(), "Whether pipeline statistics be queried");
        ImGui.separator();
        GLCapabilities caps = GL.getCapabilities();
        ImGui.popStyleColor();
        for (Map.Entry<Integer, Component> entry : SHADER_TYPES.entrySet()) {
            if (ImGui.collapsingHeader(entry.getValue().getString())) {
                ImGui.pushID(entry.getKey().intValue());
                ImGui.indent();
                ImGui.pushStyleColor(0, TEXT_COLOR);
                VeilShaderLimits limits = VeilRenderSystem.shaderLimits(entry.getKey().intValue());
                text("inspector.veil.device_info.opengl.shader.max_uniform_components", "This is the number of active components of uniform variables that can be defined outside of a uniform block. The term \"component\" is meant as the basic component of a vector/matrix. So a vec3 takes up 3 components. The minimum value here is 1024, enough room for 256 vec4s.", Integer.valueOf(limits.maxUniformComponents()));
                text("inspector.veil.device_info.opengl.shader.max_uniform_blocks", "The maximum number of uniform blocks that this shader stage can access. The OpenGL-required minimum is 12 in GL 3.3, and 14 in GL 4.3.", Integer.valueOf(limits.maxUniformBlocks()));
                if (entry.getKey().intValue() != 37305) {
                    text("inspector.veil.device_info.opengl.shader.max_input_components", "The maximum number of components that this stage can take as input. The required minimum value differs from shader stage to shader stage.", Integer.valueOf(limits.maxInputComponents()));
                    text("inspector.veil.device_info.opengl.shader.max_output_components", "The maximum number of components that this stage can output. The required minimum value differs from shader stage to shader stage.", Integer.valueOf(limits.maxOutputComponents()));
                }
                text("inspector.veil.device_info.opengl.shader.max_texture_image_units", "The maximum number of texture image units that the sampler in this shader can access. The OpenGL-required minimum value is 16 for each stage.", Integer.valueOf(limits.maxTextureImageUnits()));
                Object[] objArr = new Object[1];
                objArr[0] = limits.maxImageUniforms() > 0 ? Integer.valueOf(limits.maxImageUniforms()) : null;
                text("inspector.veil.device_info.opengl.shader.max_image_uniforms", "The maximum number of image variables for this shader stage. The OpenGL-required minimum is 8 for fragment and compute shaders, and 0 for the rest. This means implementations may not allow you to use image variables in non-fragment or compute stages.", objArr);
                boolean atomicCounters = caps.OpenGL42 || caps.GL_ARB_shader_atomic_counters;
                Object[] objArr2 = new Object[1];
                objArr2[0] = atomicCounters ? Integer.valueOf(limits.maxAtomicCounters()) : null;
                text("inspector.veil.device_info.opengl.shader.max_atomic_counters", "The maximum number of Atomic Counter variables that this stage can define. The OpenGL-required minimum is 8 for fragment and compute shaders, and 0 for the rest.", objArr2);
                Object[] objArr3 = new Object[1];
                objArr3[0] = atomicCounters ? Integer.valueOf(limits.maxAtomicCountBuffers()) : null;
                text("inspector.veil.device_info.opengl.shader.max_atomic_counter_buffers", "The maximum number of different buffers that the atomic counter variables can come from. The OpenGL-required minimum is 1 for fragment shaders, 8 for compute shaders (note: possible spec typo), and again 0 for the rest.", objArr3);
                Object[] objArr4 = new Object[1];
                objArr4[0] = (caps.OpenGL43 || caps.GL_ARB_shader_storage_buffer_object) ? Integer.valueOf(limits.maxShaderStorageBlocks()) : null;
                text("inspector.veil.device_info.opengl.shader.max_shader_storage_blocks", "The maximum number of different shader storage blocks that a stage can use. For fragment and compute shaders, the OpenGL-required minimum is 8; for the rest, it is 0.", objArr4);
                ImGui.popStyleColor();
                ImGui.unindent();
                ImGui.popID();
            }
        }
        ImGui.pushStyleColor(0, TEXT_COLOR);
        title(GL_VERTEX_ARRAY);
        text("inspector.veil.device_info.opengl.vertex_array.max_vertex_attributes", null, Integer.valueOf(VeilRenderSystem.maxVertexAttributes()));
        text("inspector.veil.device_info.opengl.vertex_array.max_vertex_attribute_relative_offset", null, Integer.valueOf(VeilRenderSystem.maxVertexAttributeRelativeOffset()));
        ImGui.separator();
        title(GL_UNIFORM);
        text("inspector.veil.device_info.opengl.uniform.max_uniform_buffer_bindings", "The limit on the number of uniform buffer binding points. This is the limit for glBindBufferRange when using GL_UNIFORM_BUFFER.", Integer.valueOf(VeilRenderSystem.maxUniformBuffersBindings()));
        text("inspector.veil.device_info.opengl.uniform.max_uniform_buffer_size", null, Long.valueOf(VeilRenderSystem.maxUniformBufferSize()));
        text("inspector.veil.device_info.opengl.uniform.uniform_buffer_alignment", "If you bind a uniform buffer with glBindBufferRange, the offset field of that parameter must be a multiple of GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT (this is a global value, not a per-program or per-block one). Thus, if you want to put the data for multiple uniform blocks in a single buffer object, you must make sure that the data for each within that block matches this alignment.", Integer.valueOf(VeilRenderSystem.uniformBufferAlignment()));
        text("inspector.veil.device_info.opengl.uniform.max_combined_uniform_blocks", "The maximum number of uniform blocks that all of the active programs can use. If two (or more) shader stages use the same block, they count separately towards this limit.", Integer.valueOf(GL43C.glGetInteger(35374)));
        text("inspector.veil.device_info.opengl.uniform.max_combined_texture_image_units", "The total number of texture units that can be used from all active programs. This is the limit on glActiveTexture(GL_TEXTURE0 + i) and glBindSampler.", Integer.valueOf(VeilRenderSystem.maxCombinedTextureUnits()));
        ImGui.separator();
        title(GL_TRANSFORM_FEEDBACK);
        text("inspector.veil.device_info.opengl.transform_feedback.max_separate_attributes", "When doing separate mode Transform Feedback, this is the maximum number of varying variables that can be captured.", Integer.valueOf(GL43C.glGetInteger(35979)));
        text("inspector.veil.device_info.opengl.transform_feedback.max_separate_components", "When doing separate mode Transform Feedback, this is the maximum number of components for a single varying variable (note that varyings can be arrays or structs) that can be captured.", Integer.valueOf(GL43C.glGetInteger(35968)));
        text("inspector.veil.device_info.opengl.transform_feedback.max_interleaved_components", "When doing interleaved Transform Feedback, this is the total number of components that can be captured within a single buffer.", Integer.valueOf(GL43C.glGetInteger(35978)));
        Object[] objArr5 = new Object[1];
        objArr5[0] = VeilRenderSystem.transformFeedbackSupported() ? Integer.valueOf(VeilRenderSystem.maxTransformFeedbackBindings()) : null;
        text("inspector.veil.device_info.opengl.transform_feedback.max_buffers", "The maximum number of buffers that can be written to in transform feedback operations.", objArr5);
        ImGui.separator();
        boolean atomicCounters2 = VeilRenderSystem.atomicCounterSupported();
        title(GL_ATOMIC_COUNTER);
        Object[] objArr6 = new Object[1];
        objArr6[0] = atomicCounters2 ? Integer.valueOf(VeilRenderSystem.maxAtomicCounterBufferBindings()) : null;
        text("inspector.veil.device_info.opengl.atomic_counter.max_buffer_bindings", "The total number of atomic counter buffer binding points. This is the limit for glBindBufferRange when using GL_ATOMIC_COUNTER_BUFFER.", objArr6);
        Object[] objArr7 = new Object[1];
        objArr7[0] = atomicCounters2 ? Integer.valueOf(GL43C.glGetInteger(37585)) : null;
        text("inspector.veil.device_info.opengl.atomic_counter.max_combined_buffers", "The maximum number of atomic counter buffers variables across all active programs.", objArr7);
        Object[] objArr8 = new Object[1];
        objArr8[0] = atomicCounters2 ? Integer.valueOf(GL43C.glGetInteger(37591)) : null;
        text("inspector.veil.device_info.opengl.atomic_counter.max_combined_counters", "The maximum number of atomic counter variables across all active programs.", objArr8);
        ImGui.separator();
        boolean shaderStorageBuffers = VeilRenderSystem.shaderStorageBufferSupported();
        title(GL_SHADER_STORAGE);
        Object[] objArr9 = new Object[1];
        objArr9[0] = shaderStorageBuffers ? Integer.valueOf(VeilRenderSystem.maxShaderStorageBufferBindings()) : null;
        text("inspector.veil.device_info.opengl.shader_storage.max_bindings", "The total number of shader storage buffer binding points. This is the limit for glBindBufferRange when using GL_SHADER_STORAGE_BUFFER.", objArr9);
        Object[] objArr10 = new Object[1];
        objArr10[0] = shaderStorageBuffers ? Long.valueOf(VeilRenderSystem.maxShaderStorageBufferSize()) : null;
        text("inspector.veil.device_info.opengl.shader_storage.max_size", null, objArr10);
        Object[] objArr11 = new Object[1];
        objArr11[0] = shaderStorageBuffers ? Integer.valueOf(GL43C.glGetInteger(37084)) : null;
        text("inspector.veil.device_info.opengl.shader_storage.max_combined_blocks", "The maximum number of shader storage blocks across all active programs. As with UBOs, blocks that are the same between stages are counted for each stage.", objArr11);
        Object[] objArr12 = new Object[1];
        objArr12[0] = shaderStorageBuffers ? Integer.valueOf(GL43C.glGetInteger(36665)) : null;
        text("inspector.veil.device_info.opengl.shader_storage.max_output_resources", "The total number of shader storage blocks, image variables, and fragment shader outputs across all active programs cannot exceed this number. This is the \"amount of stuff\" that a sequence of shaders can write to (barring Transform Feedback).", objArr12);
        ImGui.separator();
        title(GL_TEXTURE);
        text("inspector.veil.device_info.opengl.texture.max_texture_size", null, Integer.valueOf(RenderSystem.maxSupportedTextureSize()));
        text("inspector.veil.device_info.opengl.texture.max_array_texture_layers", null, Integer.valueOf(VeilRenderSystem.maxArrayTextureLayers()));
        Object[] objArr13 = new Object[1];
        objArr13[0] = VeilRenderSystem.textureAnisotropySupported() ? Float.valueOf(VeilRenderSystem.maxTextureAnisotropy()) : null;
        text("inspector.veil.device_info.opengl.texture.max_texture_anisotropy", "The maximum value GL_TEXTURE_MAX_ANISOTROPY can be set to", objArr13);
        title(GL_FRAMEBUFFER);
        text("inspector.veil.device_info.opengl.framebuffer.max_size", null, Integer.valueOf(VeilRenderSystem.maxFramebufferWidth()), Integer.valueOf(VeilRenderSystem.maxFramebufferHeight()));
        text("inspector.veil.device_info.opengl.framebuffer.max_color_attachments", null, Integer.valueOf(VeilRenderSystem.maxColorAttachments()));
        text("inspector.veil.device_info.opengl.framebuffer.max_samples", null, Integer.valueOf(VeilRenderSystem.maxSamples()));
    }

    public static Component getShaderName(int shader) {
        return SHADER_TYPES.get(Integer.valueOf(shader));
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public Component getDisplayName() {
        return TITLE;
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public Component getGroup() {
        return INFO_GROUP;
    }

    @Override // foundry.veil.api.client.editor.SingleWindowInspector
    protected void renderComponents() {
        ImGui.pushStyleColor(0, TEXT_COLOR);
        renderOpenGL();
        ImGui.popStyleColor();
    }

    @Override // foundry.veil.api.client.editor.SingleWindowInspector, foundry.veil.api.client.editor.Inspector
    public void render() {
        ImGui.setNextWindowSizeConstraints(400.0f, 460.0f, Float.MAX_VALUE, Float.MAX_VALUE);
        super.render();
    }
}
