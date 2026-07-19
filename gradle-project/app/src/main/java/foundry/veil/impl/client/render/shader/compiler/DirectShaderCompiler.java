package foundry.veil.impl.client.render.shader.compiler;

import com.mojang.blaze3d.platform.GlStateManager;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.ext.VeilDebug;
import foundry.veil.api.client.render.shader.ShaderManager;
import foundry.veil.api.client.render.shader.compiler.CompiledShader;
import foundry.veil.api.client.render.shader.compiler.ShaderCompiler;
import foundry.veil.api.client.render.shader.compiler.ShaderException;
import foundry.veil.api.client.render.shader.compiler.VeilShaderSource;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL20C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/compiler/DirectShaderCompiler.class */
@ApiStatus.Internal
public class DirectShaderCompiler implements ShaderCompiler {
    private final ShaderCompiler.ShaderProvider provider;

    public DirectShaderCompiler(@Nullable ShaderCompiler.ShaderProvider provider) {
        this.provider = provider;
    }

    private void validateType(int type) throws ShaderException {
        if ((type == 36488 || type == 36487) && !VeilRenderSystem.tessellationSupported()) {
            throw new ShaderException("Tessellation is not supported", null);
        }
        if (type == 37305 && !VeilRenderSystem.computeSupported()) {
            throw new ShaderException("Compute is not supported", null);
        }
    }

    @Override // foundry.veil.api.client.render.shader.compiler.ShaderCompiler
    public CompiledShader compile(int type, ResourceLocation path) throws ShaderException, IOException {
        if (this.provider == null) {
            throw new IOException("Failed to read " + ShaderManager.getTypeName(type) + " from " + String.valueOf(path) + " because no provider was specified");
        }
        return compile(type, this.provider.getShader(path));
    }

    @Override // foundry.veil.api.client.render.shader.compiler.ShaderCompiler
    public CompiledShader compile(int type, VeilShaderSource source) throws ShaderException {
        validateType(type);
        String sourceCode = source.sourceCode();
        ResourceLocation sourceId = source.sourceId();
        int shader = GL20C.glCreateShader(type);
        if (sourceId != null) {
            VeilDebug.get().objectLabel(33505, shader, ShaderManager.getTypeName(type) + " Shader " + String.valueOf(sourceId));
        }
        GlStateManager.glShaderSource(shader, List.of(sourceCode));
        GL20C.glCompileShader(shader);
        if (GL20C.glGetShaderi(shader, 35713) != 1) {
            String log = GL20C.glGetShaderInfoLog(shader);
            if (Veil.VERBOSE_SHADER_ERRORS) {
                log = log + "\n" + sourceCode;
            }
            GL20C.glDeleteShader(shader);
            throw new ShaderException("Failed to compile " + ShaderManager.getTypeName(type) + " shader", log);
        }
        return new CompiledShader(sourceId, shader, Object2IntMaps.unmodifiable(source.uniformBindings()), Collections.unmodifiableSet(source.definitionDependencies()), Collections.unmodifiableSet(source.includes()));
    }

    public void free() {
    }
}
