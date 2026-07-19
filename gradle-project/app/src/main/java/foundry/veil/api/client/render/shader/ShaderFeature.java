package foundry.veil.api.client.render.shader;

import com.mojang.serialization.Codec;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.util.EnumCodec;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/ShaderFeature.class */
public enum ShaderFeature {
    COMPUTE,
    SHADER_STORAGE,
    ATOMIC_COUNTER,
    BINDLESS_TEXTURE,
    CUBE_MAP_ARRAY,
    FLOAT64,
    INT64,
    VERTEX_ATTRIBUTE64,
    TESSELLATION;


    @ApiStatus.Internal
    public static final ShaderFeature[] FEATURES = values();
    public static final Codec<ShaderFeature> CODEC = EnumCodec.builder("Shader Feature").values(values()).build();
    private final String definitionName = "SHADER_FEATURE_" + name();

    ShaderFeature() {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public boolean isSupported() throws MatchException {
        switch (this) {
            case COMPUTE:
                return VeilRenderSystem.computeSupported();
            case SHADER_STORAGE:
                return VeilRenderSystem.shaderStorageBufferSupported();
            case ATOMIC_COUNTER:
                return VeilRenderSystem.atomicCounterSupported();
            case BINDLESS_TEXTURE:
                return VeilRenderSystem.bindlessTextureSupported();
            case CUBE_MAP_ARRAY:
                return VeilRenderSystem.textureCubeMapArraySupported();
            case FLOAT64:
                return VeilRenderSystem.gpuShaderFloat64BitSupported();
            case INT64:
                return VeilRenderSystem.gpuShaderInt64BitSupported();
            case VERTEX_ATTRIBUTE64:
                return VeilRenderSystem.vertexAttribute64BitSupported();
            case TESSELLATION:
                return VeilRenderSystem.tessellationSupported();
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    public String getDefinitionName() {
        return this.definitionName;
    }

    public void modifyShader(int shaderType, GlslTree tree) {
        List<String> directives = tree.getDirectives();
        switch (this) {
            case COMPUTE:
                directives.add("#extension GL_ARB_compute_shader : require");
                break;
            case SHADER_STORAGE:
                directives.add("#extension GL_ARB_shader_storage_buffer_object : require");
                break;
            case ATOMIC_COUNTER:
                directives.add("#extension GL_ARB_shader_atomic_counters : require");
                break;
            case BINDLESS_TEXTURE:
                directives.add("#extension GL_ARB_bindless_texture : require");
                directives.add("#extension GL_NV_gpu_shader5 : enable");
                directives.add("#extension GL_EXT_nonuniform_qualifier : enable");
                break;
            case FLOAT64:
                directives.add("#extension GL_ARB_gpu_shader_fp64 : require");
                break;
            case INT64:
                directives.add("#extension GL_ARB_gpu_shader_int64 : require");
                break;
            case VERTEX_ATTRIBUTE64:
                directives.add("#extension GL_ARB_vertex_attrib_64bit : require");
                break;
            case TESSELLATION:
                if (shaderType == 36488 || shaderType == 36487) {
                    directives.add("#extension GL_ARB_tessellation_shader : require");
                }
                break;
        }
    }
}
