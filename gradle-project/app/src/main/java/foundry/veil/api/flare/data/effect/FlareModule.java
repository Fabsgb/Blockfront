package foundry.veil.api.flare.data.effect;

import com.mojang.serialization.Codec;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/flare/data/effect/FlareModule.class */
public final class FlareModule extends Record {
    private final Map<String, FlareSubModule> subModules;
    public static final Codec<FlareModule> CODEC = Codec.unboundedMap(Codec.STRING, FlareSubModule.CODEC).xmap(FlareModule::new, (v0) -> {
        return v0.subModules();
    }).fieldOf("subModules").codec();

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, FlareModule.class), FlareModule.class, "subModules", "FIELD:Lfoundry/veil/api/flare/data/effect/FlareModule;->subModules:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FlareModule.class), FlareModule.class, "subModules", "FIELD:Lfoundry/veil/api/flare/data/effect/FlareModule;->subModules:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FlareModule.class, Object.class), FlareModule.class, "subModules", "FIELD:Lfoundry/veil/api/flare/data/effect/FlareModule;->subModules:Ljava/util/Map;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Map<String, FlareSubModule> subModules() {
        return this.subModules;
    }

    public FlareModule(Map<String, FlareSubModule> subModules) {
        this.subModules = Map.copyOf(subModules);
    }

    public FlareSubModule getSubModule(String name) {
        return this.subModules.get(name);
    }
}
