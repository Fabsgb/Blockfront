package foundry.veil.impl.client.render.shader.compiler;

import foundry.veil.api.client.render.shader.compiler.CompiledShader;
import foundry.veil.api.client.render.shader.compiler.ShaderCompiler;
import foundry.veil.api.client.render.shader.compiler.ShaderException;
import foundry.veil.api.client.render.shader.compiler.VeilShaderSource;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import java.io.IOException;
import java.util.Objects;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/compiler/CachedShaderCompiler.class */
@ApiStatus.Internal
public class CachedShaderCompiler extends DirectShaderCompiler {
    private final Int2ObjectMap<CompiledShader> shaders;

    public CachedShaderCompiler(@Nullable ShaderCompiler.ShaderProvider provider) {
        super(provider);
        this.shaders = new Int2ObjectArrayMap();
    }

    @Override // foundry.veil.impl.client.render.shader.compiler.DirectShaderCompiler, foundry.veil.api.client.render.shader.compiler.ShaderCompiler
    public CompiledShader compile(int type, ResourceLocation path) throws ShaderException, IOException {
        int hash = Objects.hash(Integer.valueOf(type), path);
        if (this.shaders.containsKey(hash)) {
            return (CompiledShader) this.shaders.get(hash);
        }
        CompiledShader shader = super.compile(type, path);
        this.shaders.put(hash, shader);
        return shader;
    }

    @Override // foundry.veil.impl.client.render.shader.compiler.DirectShaderCompiler, foundry.veil.api.client.render.shader.compiler.ShaderCompiler
    public CompiledShader compile(int type, VeilShaderSource source) throws ShaderException {
        int hash = Objects.hash(Integer.valueOf(type), source.sourceId());
        if (this.shaders.containsKey(hash)) {
            return (CompiledShader) this.shaders.get(hash);
        }
        CompiledShader shader = super.compile(type, source);
        this.shaders.put(hash, shader);
        return shader;
    }

    @Override // foundry.veil.impl.client.render.shader.compiler.DirectShaderCompiler
    public void free() {
        super.free();
        this.shaders.clear();
    }
}
