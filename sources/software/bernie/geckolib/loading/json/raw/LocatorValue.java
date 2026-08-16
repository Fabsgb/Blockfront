package software.bernie.geckolib.loading.json.raw;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonParseException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.util.JsonUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/json/raw/LocatorValue.class */
public final class LocatorValue extends Record {

    @Nullable
    private final LocatorClass locatorClass;
    private final double[] values;

    public LocatorValue(@Nullable LocatorClass locatorClass, double[] values) {
        this.locatorClass = locatorClass;
        this.values = values;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, LocatorValue.class), LocatorValue.class, "locatorClass;values", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/LocatorValue;->locatorClass:Lsoftware/bernie/geckolib/loading/json/raw/LocatorClass;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/LocatorValue;->values:[D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, LocatorValue.class), LocatorValue.class, "locatorClass;values", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/LocatorValue;->locatorClass:Lsoftware/bernie/geckolib/loading/json/raw/LocatorClass;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/LocatorValue;->values:[D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, LocatorValue.class, Object.class), LocatorValue.class, "locatorClass;values", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/LocatorValue;->locatorClass:Lsoftware/bernie/geckolib/loading/json/raw/LocatorClass;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/LocatorValue;->values:[D").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Nullable
    public LocatorClass locatorClass() {
        return this.locatorClass;
    }

    public double[] values() {
        return this.values;
    }

    public static JsonDeserializer<LocatorValue> deserializer() throws JsonParseException {
        return (json, type, context) -> {
            if (json.isJsonArray()) {
                return new LocatorValue(null, JsonUtil.jsonArrayToDoubleArray(json.getAsJsonArray()));
            }
            if (json.isJsonObject()) {
                return new LocatorValue((LocatorClass) context.deserialize(json.getAsJsonObject(), LocatorClass.class), new double[0]);
            }
            throw new JsonParseException("Invalid format for LocatorValue in json");
        };
    }
}
