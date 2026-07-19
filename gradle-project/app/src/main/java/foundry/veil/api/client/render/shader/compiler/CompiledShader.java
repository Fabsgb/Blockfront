package foundry.veil.api.client.render.shader.compiler;

import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.api.client.render.shader.uniform.ShaderUniform;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Set;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL20C;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/compiler/CompiledShader.class */
public final class CompiledShader extends Record implements NativeResource {

    @Nullable
    private final ResourceLocation sourceFile;
    private final int id;
    private final Object2IntMap<String> uniformBindings;
    private final Set<String> definitionDependencies;
    private final Set<ResourceLocation> includes;

    public CompiledShader(@Nullable ResourceLocation sourceFile, int id, Object2IntMap<String> uniformBindings, Set<String> definitionDependencies, Set<ResourceLocation> includes) {
        this.sourceFile = sourceFile;
        this.id = id;
        this.uniformBindings = uniformBindings;
        this.definitionDependencies = definitionDependencies;
        this.includes = includes;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, CompiledShader.class), CompiledShader.class, "sourceFile;id;uniformBindings;definitionDependencies;includes", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/CompiledShader;->sourceFile:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/CompiledShader;->id:I", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/CompiledShader;->uniformBindings:Lit/unimi/dsi/fastutil/objects/Object2IntMap;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/CompiledShader;->definitionDependencies:Ljava/util/Set;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/CompiledShader;->includes:Ljava/util/Set;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, CompiledShader.class), CompiledShader.class, "sourceFile;id;uniformBindings;definitionDependencies;includes", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/CompiledShader;->sourceFile:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/CompiledShader;->id:I", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/CompiledShader;->uniformBindings:Lit/unimi/dsi/fastutil/objects/Object2IntMap;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/CompiledShader;->definitionDependencies:Ljava/util/Set;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/CompiledShader;->includes:Ljava/util/Set;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, CompiledShader.class, Object.class), CompiledShader.class, "sourceFile;id;uniformBindings;definitionDependencies;includes", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/CompiledShader;->sourceFile:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/CompiledShader;->id:I", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/CompiledShader;->uniformBindings:Lit/unimi/dsi/fastutil/objects/Object2IntMap;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/CompiledShader;->definitionDependencies:Ljava/util/Set;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/CompiledShader;->includes:Ljava/util/Set;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Nullable
    public ResourceLocation sourceFile() {
        return this.sourceFile;
    }

    public int id() {
        return this.id;
    }

    public Object2IntMap<String> uniformBindings() {
        return this.uniformBindings;
    }

    public Set<String> definitionDependencies() {
        return this.definitionDependencies;
    }

    public Set<ResourceLocation> includes() {
        return this.includes;
    }

    public void apply(ShaderProgram program) {
        ObjectIterator it = this.uniformBindings.object2IntEntrySet().iterator();
        while (it.hasNext()) {
            Object2IntMap.Entry<String> entry = (Object2IntMap.Entry) it.next();
            ShaderUniform uniform = program.getUniform((CharSequence) entry.getKey());
            if (uniform != null) {
                uniform.setInt(entry.getIntValue());
            }
        }
    }

    public void free() {
        GL20C.glDeleteShader(this.id);
    }
}
