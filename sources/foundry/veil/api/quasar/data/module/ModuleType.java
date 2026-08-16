package foundry.veil.api.quasar.data.module;

import com.mojang.serialization.MapCodec;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/data/module/ModuleType.class */
public interface ModuleType<T extends ParticleModuleData> {
    MapCodec<T> codec();

    default Supplier<T> defaultValue() {
        return null;
    }

    @Nullable
    default DeprecationStatus deprecationStatus() {
        return null;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/data/module/ModuleType$DeprecationStatus.class */
    public static final class DeprecationStatus extends Record {

        @Nullable
        private final String reason;
        private final String removeVersion;

        public DeprecationStatus(@Nullable String reason, String removeVersion) {
            this.reason = reason;
            this.removeVersion = removeVersion;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, DeprecationStatus.class), DeprecationStatus.class, "reason;removeVersion", "FIELD:Lfoundry/veil/api/quasar/data/module/ModuleType$DeprecationStatus;->reason:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/quasar/data/module/ModuleType$DeprecationStatus;->removeVersion:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, DeprecationStatus.class), DeprecationStatus.class, "reason;removeVersion", "FIELD:Lfoundry/veil/api/quasar/data/module/ModuleType$DeprecationStatus;->reason:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/quasar/data/module/ModuleType$DeprecationStatus;->removeVersion:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, DeprecationStatus.class, Object.class), DeprecationStatus.class, "reason;removeVersion", "FIELD:Lfoundry/veil/api/quasar/data/module/ModuleType$DeprecationStatus;->reason:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/quasar/data/module/ModuleType$DeprecationStatus;->removeVersion:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        @Nullable
        public String reason() {
            return this.reason;
        }

        public String removeVersion() {
            return this.removeVersion;
        }
    }
}
