package software.bernie.geckolib.loading.json.raw;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.util.GsonHelper;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.util.JsonUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/json/raw/LocatorClass.class */
public final class LocatorClass extends Record {

    @Nullable
    private final Boolean ignoreInheritedScale;
    private final double[] offset;
    private final double[] rotation;

    public LocatorClass(@Nullable Boolean ignoreInheritedScale, double[] offset, double[] rotation) {
        this.ignoreInheritedScale = ignoreInheritedScale;
        this.offset = offset;
        this.rotation = rotation;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, LocatorClass.class), LocatorClass.class, "ignoreInheritedScale;offset;rotation", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/LocatorClass;->ignoreInheritedScale:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/LocatorClass;->offset:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/LocatorClass;->rotation:[D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, LocatorClass.class), LocatorClass.class, "ignoreInheritedScale;offset;rotation", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/LocatorClass;->ignoreInheritedScale:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/LocatorClass;->offset:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/LocatorClass;->rotation:[D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, LocatorClass.class, Object.class), LocatorClass.class, "ignoreInheritedScale;offset;rotation", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/LocatorClass;->ignoreInheritedScale:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/LocatorClass;->offset:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/LocatorClass;->rotation:[D").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Nullable
    public Boolean ignoreInheritedScale() {
        return this.ignoreInheritedScale;
    }

    public double[] offset() {
        return this.offset;
    }

    public double[] rotation() {
        return this.rotation;
    }

    public static JsonDeserializer<LocatorClass> deserializer() throws JsonParseException {
        return (json, type, context) -> {
            JsonObject obj = json.getAsJsonObject();
            Boolean ignoreInheritedScale = JsonUtil.getOptionalBoolean(obj, "ignore_inherited_scale");
            double[] offset = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "offset", (JsonArray) null));
            double[] rotation = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "rotation", (JsonArray) null));
            return new LocatorClass(ignoreInheritedScale, offset, rotation);
        };
    }
}
