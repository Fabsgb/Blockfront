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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/json/raw/PolyMesh.class */
public final class PolyMesh extends Record {

    @Nullable
    private final Boolean normalizedUVs;
    private final double[] normals;

    @Nullable
    private final PolysUnion polysUnion;
    private final double[] positions;
    private final double[] uvs;

    public PolyMesh(@Nullable Boolean normalizedUVs, double[] normals, @Nullable PolysUnion polysUnion, double[] positions, double[] uvs) {
        this.normalizedUVs = normalizedUVs;
        this.normals = normals;
        this.polysUnion = polysUnion;
        this.positions = positions;
        this.uvs = uvs;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PolyMesh.class), PolyMesh.class, "normalizedUVs;normals;polysUnion;positions;uvs", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;->normalizedUVs:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;->normals:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;->polysUnion:Lsoftware/bernie/geckolib/loading/json/raw/PolysUnion;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;->positions:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;->uvs:[D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PolyMesh.class), PolyMesh.class, "normalizedUVs;normals;polysUnion;positions;uvs", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;->normalizedUVs:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;->normals:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;->polysUnion:Lsoftware/bernie/geckolib/loading/json/raw/PolysUnion;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;->positions:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;->uvs:[D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PolyMesh.class, Object.class), PolyMesh.class, "normalizedUVs;normals;polysUnion;positions;uvs", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;->normalizedUVs:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;->normals:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;->polysUnion:Lsoftware/bernie/geckolib/loading/json/raw/PolysUnion;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;->positions:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;->uvs:[D").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Nullable
    public Boolean normalizedUVs() {
        return this.normalizedUVs;
    }

    public double[] normals() {
        return this.normals;
    }

    @Nullable
    public PolysUnion polysUnion() {
        return this.polysUnion;
    }

    public double[] positions() {
        return this.positions;
    }

    public double[] uvs() {
        return this.uvs;
    }

    public static JsonDeserializer<PolyMesh> deserializer() throws JsonParseException {
        return (json, type, context) -> {
            JsonObject obj = json.getAsJsonObject();
            Boolean normalizedUVs = JsonUtil.getOptionalBoolean(obj, "normalized_uvs");
            double[] normals = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "normals", (JsonArray) null));
            PolysUnion polysUnion = (PolysUnion) GsonHelper.getAsObject(obj, "polys", (Object) null, context, PolysUnion.class);
            double[] positions = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "positions", (JsonArray) null));
            double[] uvs = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "uvs", (JsonArray) null));
            return new PolyMesh(normalizedUVs, normals, polysUnion, positions, uvs);
        };
    }
}
