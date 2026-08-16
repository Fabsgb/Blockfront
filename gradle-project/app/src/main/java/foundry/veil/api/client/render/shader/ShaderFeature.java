package foundry.veil.api.client.render.shader;

import com.boehmod.blockfront.C0994s;
import com.mojang.serialization.Codec;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.util.EnumCodec;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/ShaderFeature.class */
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
        switch (ordinal()) {
            case 0:
                return VeilRenderSystem.computeSupported();
            case 1:
                return VeilRenderSystem.shaderStorageBufferSupported();
            case 2:
                return VeilRenderSystem.atomicCounterSupported();
            case 3:
                return VeilRenderSystem.bindlessTextureSupported();
            case 4:
                return VeilRenderSystem.textureCubeMapArraySupported();
            case 5:
                return VeilRenderSystem.gpuShaderFloat64BitSupported();
            case 6:
                return VeilRenderSystem.gpuShaderInt64BitSupported();
            case C0994s.f5462C /* 7 */:
                return VeilRenderSystem.vertexAttribute64BitSupported();
            case 8:
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
        switch (ordinal()) {
            case 0:
                directives.add("#extension GL_ARB_compute_shader : require");
                break;
            case 1:
                directives.add("#extension GL_ARB_shader_storage_buffer_object : require");
                break;
            case 2:
                directives.add("#extension GL_ARB_shader_atomic_counters : require");
                break;
            case 3:
                directives.add("#extension GL_ARB_bindless_texture : require");
                directives.add("#extension GL_NV_gpu_shader5 : enable");
                directives.add("#extension GL_EXT_nonuniform_qualifier : enable");
                break;
            case 5:
                directives.add("#extension GL_ARB_gpu_shader_fp64 : require");
                break;
            case 6:
                directives.add("#extension GL_ARB_gpu_shader_int64 : require");
                break;
            case C0994s.f5462C /* 7 */:
                directives.add("#extension GL_ARB_vertex_attrib_64bit : require");
                break;
            case 8:
                if (shaderType == 36488 || shaderType == 36487) {
                    directives.add("#extension GL_ARB_tessellation_shader : require");
                }
                break;
        }
    }
}
