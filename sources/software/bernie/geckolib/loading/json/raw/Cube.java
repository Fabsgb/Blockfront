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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/json/raw/Cube.class */
public final class Cube extends Record {

    @Nullable
    private final Double inflate;

    @Nullable
    private final Boolean mirror;
    private final double[] origin;
    private final double[] pivot;
    private final double[] rotation;
    private final double[] size;

    /* JADX INFO: renamed from: uv */
    private final UVUnion f8810uv;

    public Cube(@Nullable Double inflate, @Nullable Boolean mirror, double[] origin, double[] pivot, double[] rotation, double[] size, UVUnion uv) {
        this.inflate = inflate;
        this.mirror = mirror;
        this.origin = origin;
        this.pivot = pivot;
        this.rotation = rotation;
        this.size = size;
        this.f8810uv = uv;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Cube.class), Cube.class, "inflate;mirror;origin;pivot;rotation;size;uv", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->inflate:Ljava/lang/Double;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->mirror:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->origin:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->pivot:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->rotation:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->size:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->uv:Lsoftware/bernie/geckolib/loading/json/raw/UVUnion;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Cube.class), Cube.class, "inflate;mirror;origin;pivot;rotation;size;uv", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->inflate:Ljava/lang/Double;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->mirror:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->origin:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->pivot:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->rotation:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->size:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->uv:Lsoftware/bernie/geckolib/loading/json/raw/UVUnion;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Cube.class, Object.class), Cube.class, "inflate;mirror;origin;pivot;rotation;size;uv", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->inflate:Ljava/lang/Double;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->mirror:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->origin:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->pivot:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->rotation:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->size:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Cube;->uv:Lsoftware/bernie/geckolib/loading/json/raw/UVUnion;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Nullable
    public Double inflate() {
        return this.inflate;
    }

    @Nullable
    public Boolean mirror() {
        return this.mirror;
    }

    public double[] origin() {
        return this.origin;
    }

    public double[] pivot() {
        return this.pivot;
    }

    public double[] rotation() {
        return this.rotation;
    }

    public double[] size() {
        return this.size;
    }

    /* JADX INFO: renamed from: uv */
    public UVUnion m8009uv() {
        return this.f8810uv;
    }

    public static JsonDeserializer<Cube> deserializer() throws JsonParseException {
        return (json, type, context) -> {
            JsonObject obj = json.getAsJsonObject();
            Double inflate = JsonUtil.getOptionalDouble(obj, "inflate");
            Boolean mirror = JsonUtil.getOptionalBoolean(obj, "mirror");
            double[] origin = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "origin", (JsonArray) null));
            double[] pivot = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "pivot", (JsonArray) null));
            double[] rotation = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "rotation", (JsonArray) null));
            double[] size = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "size", (JsonArray) null));
            UVUnion uvUnion = (UVUnion) GsonHelper.getAsObject(obj, "uv", (Object) null, context, UVUnion.class);
            return new Cube(inflate, mirror, origin, pivot, rotation, size, uvUnion);
        };
    }
}
