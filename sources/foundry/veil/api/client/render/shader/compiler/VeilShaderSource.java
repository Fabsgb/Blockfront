package foundry.veil.api.client.render.shader.compiler;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Collections;
import java.util.Set;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/compiler/VeilShaderSource.class */
public final class VeilShaderSource extends Record {

    @Nullable
    private final ResourceLocation sourceId;
    private final String sourceCode;
    private final Object2IntMap<String> uniformBindings;
    private final Set<String> definitionDependencies;
    private final Set<ResourceLocation> includes;

    public VeilShaderSource(@Nullable ResourceLocation sourceId, String sourceCode, Object2IntMap<String> uniformBindings, Set<String> definitionDependencies, Set<ResourceLocation> includes) {
        this.sourceId = sourceId;
        this.sourceCode = sourceCode;
        this.uniformBindings = uniformBindings;
        this.definitionDependencies = definitionDependencies;
        this.includes = includes;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, VeilShaderSource.class), VeilShaderSource.class, "sourceId;sourceCode;uniformBindings;definitionDependencies;includes", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/VeilShaderSource;->sourceId:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/VeilShaderSource;->sourceCode:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/VeilShaderSource;->uniformBindings:Lit/unimi/dsi/fastutil/objects/Object2IntMap;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/VeilShaderSource;->definitionDependencies:Ljava/util/Set;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/VeilShaderSource;->includes:Ljava/util/Set;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, VeilShaderSource.class), VeilShaderSource.class, "sourceId;sourceCode;uniformBindings;definitionDependencies;includes", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/VeilShaderSource;->sourceId:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/VeilShaderSource;->sourceCode:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/VeilShaderSource;->uniformBindings:Lit/unimi/dsi/fastutil/objects/Object2IntMap;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/VeilShaderSource;->definitionDependencies:Ljava/util/Set;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/VeilShaderSource;->includes:Ljava/util/Set;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, VeilShaderSource.class, Object.class), VeilShaderSource.class, "sourceId;sourceCode;uniformBindings;definitionDependencies;includes", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/VeilShaderSource;->sourceId:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/VeilShaderSource;->sourceCode:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/VeilShaderSource;->uniformBindings:Lit/unimi/dsi/fastutil/objects/Object2IntMap;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/VeilShaderSource;->definitionDependencies:Ljava/util/Set;", "FIELD:Lfoundry/veil/api/client/render/shader/compiler/VeilShaderSource;->includes:Ljava/util/Set;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Nullable
    public ResourceLocation sourceId() {
        return this.sourceId;
    }

    public String sourceCode() {
        return this.sourceCode;
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

    public VeilShaderSource(@Nullable ResourceLocation sourceId, String sourceCode) {
        this(sourceId, sourceCode, Object2IntMaps.emptyMap(), Collections.emptySet(), Collections.emptySet());
    }
}
