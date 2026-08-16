package foundry.veil.impl.client.render.shader.injection.util;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/injection/util/ValidationResult.class */
@ApiStatus.Internal
public final class ValidationResult extends Record {
    private final List<Diagnostic> diagnostics;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ValidationResult.class), ValidationResult.class, "diagnostics", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ValidationResult;->diagnostics:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ValidationResult.class), ValidationResult.class, "diagnostics", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ValidationResult;->diagnostics:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ValidationResult.class, Object.class), ValidationResult.class, "diagnostics", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ValidationResult;->diagnostics:Ljava/util/List;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public List<Diagnostic> diagnostics() {
        return this.diagnostics;
    }

    public ValidationResult(List<Diagnostic> diagnostics) {
        this.diagnostics = List.copyOf(diagnostics);
    }

    public boolean isValid() {
        if (this.diagnostics.isEmpty()) {
            return true;
        }
        for (Diagnostic diagnostic : this.diagnostics) {
            if (diagnostic.severity() == Severity.ERROR) {
                return false;
            }
        }
        return true;
    }
}
