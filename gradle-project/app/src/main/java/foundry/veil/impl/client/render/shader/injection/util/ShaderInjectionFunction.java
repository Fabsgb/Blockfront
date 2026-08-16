package foundry.veil.impl.client.render.shader.injection.util;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/injection/util/ShaderInjectionFunction.class */
@ApiStatus.Internal
public final class ShaderInjectionFunction extends Record {
    private final String name;
    private final int parameters;
    private final boolean head;
    private final String code;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ShaderInjectionFunction.class), ShaderInjectionFunction.class, "name;parameters;head;code", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionFunction;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionFunction;->parameters:I", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionFunction;->head:Z", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionFunction;->code:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ShaderInjectionFunction.class), ShaderInjectionFunction.class, "name;parameters;head;code", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionFunction;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionFunction;->parameters:I", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionFunction;->head:Z", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionFunction;->code:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ShaderInjectionFunction.class, Object.class), ShaderInjectionFunction.class, "name;parameters;head;code", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionFunction;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionFunction;->parameters:I", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionFunction;->head:Z", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionFunction;->code:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public String name() {
        return this.name;
    }

    public int parameters() {
        return this.parameters;
    }

    public boolean head() {
        return this.head;
    }

    public String code() {
        return this.code;
    }

    public ShaderInjectionFunction(String name, int parameters, boolean head, String code) {
        this.name = name;
        this.parameters = parameters;
        this.head = head;
        this.code = code;
    }
}
