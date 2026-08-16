package foundry.veil.api.client.render.shader.compiler;

import foundry.veil.impl.client.render.shader.compiler.CachedShaderCompiler;
import foundry.veil.impl.client.render.shader.compiler.DirectShaderCompiler;
import java.io.FileNotFoundException;
import java.io.IOException;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/compiler/ShaderCompiler.class */
public interface ShaderCompiler extends NativeResource {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/compiler/ShaderCompiler$ShaderProvider.class */
    @FunctionalInterface
    public interface ShaderProvider {
        VeilShaderSource getShader(ResourceLocation resourceLocation) throws FileNotFoundException;
    }

    CompiledShader compile(int i, ResourceLocation resourceLocation) throws ShaderException, IOException;

    CompiledShader compile(int i, VeilShaderSource veilShaderSource) throws ShaderException;

    static ShaderCompiler direct(@Nullable ShaderProvider provider) {
        return new DirectShaderCompiler(provider);
    }

    static ShaderCompiler cached(@Nullable ShaderProvider provider) {
        return new CachedShaderCompiler(provider);
    }
}
