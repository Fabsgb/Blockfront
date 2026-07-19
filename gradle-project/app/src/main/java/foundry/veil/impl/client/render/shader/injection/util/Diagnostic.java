package foundry.veil.impl.client.render.shader.injection.util;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/injection/util/Diagnostic.class */
@ApiStatus.Internal
public final class Diagnostic extends Record {

    @Nullable
    private final String resourcePath;

    @Nullable
    private final ResourceLocation injectionId;

    @Nullable
    private final ResourceLocation target;

    @Nullable
    private final String field;
    private final String message;
    private final Severity severity;

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Diagnostic.class), Diagnostic.class, "resourcePath;injectionId;target;field;message;severity", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/Diagnostic;->resourcePath:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/Diagnostic;->injectionId:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/Diagnostic;->target:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/Diagnostic;->field:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/Diagnostic;->message:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/Diagnostic;->severity:Lfoundry/veil/impl/client/render/shader/injection/util/Severity;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Diagnostic.class, Object.class), Diagnostic.class, "resourcePath;injectionId;target;field;message;severity", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/Diagnostic;->resourcePath:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/Diagnostic;->injectionId:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/Diagnostic;->target:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/Diagnostic;->field:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/Diagnostic;->message:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/Diagnostic;->severity:Lfoundry/veil/impl/client/render/shader/injection/util/Severity;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Nullable
    public String resourcePath() {
        return this.resourcePath;
    }

    @Nullable
    public ResourceLocation injectionId() {
        return this.injectionId;
    }

    @Nullable
    public ResourceLocation target() {
        return this.target;
    }

    @Nullable
    public String field() {
        return this.field;
    }

    public String message() {
        return this.message;
    }

    public Severity severity() {
        return this.severity;
    }

    public Diagnostic(@Nullable String resourcePath, @Nullable ResourceLocation injectionId, @Nullable ResourceLocation target, @Nullable String field, String message, Severity severity) {
        this.resourcePath = resourcePath;
        this.injectionId = injectionId;
        this.target = target;
        this.field = field;
        this.message = message;
        this.severity = severity;
    }

    @Override // java.lang.Record
    public String toString() {
        return String.valueOf(this.severity) + ": " + this.message + (this.resourcePath != null ? " (" + this.resourcePath + ")" : "") + (this.field != null ? " field=" + this.field : "") + (this.injectionId != null ? " id=" + String.valueOf(this.injectionId) : "") + (this.target != null ? " target=" + String.valueOf(this.target) : "");
    }
}
