package software.bernie.geckolib.loading.json.raw;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonParseException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.util.JsonUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/json/raw/PolysUnion.class */
public final class PolysUnion extends Record {
    private final double[][][] union;

    @Nullable
    private final Type type;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/json/raw/PolysUnion$Type.class */
    public enum Type {
        QUAD,
        TRI
    }

    public PolysUnion(double[][][] union, @Nullable Type type) {
        this.union = union;
        this.type = type;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PolysUnion.class), PolysUnion.class, "union;type", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolysUnion;->union:[[[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolysUnion;->type:Lsoftware/bernie/geckolib/loading/json/raw/PolysUnion$Type;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PolysUnion.class), PolysUnion.class, "union;type", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolysUnion;->union:[[[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolysUnion;->type:Lsoftware/bernie/geckolib/loading/json/raw/PolysUnion$Type;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PolysUnion.class, Object.class), PolysUnion.class, "union;type", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolysUnion;->union:[[[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/PolysUnion;->type:Lsoftware/bernie/geckolib/loading/json/raw/PolysUnion$Type;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public double[][][] union() {
        return this.union;
    }

    @Nullable
    public Type type() {
        return this.type;
    }

    public static JsonDeserializer<PolysUnion> deserializer() throws JsonParseException {
        return (json, type, context) -> {
            if (json.isJsonPrimitive() && json.getAsJsonPrimitive().isString()) {
                return new PolysUnion(new double[0][0][0], (Type) context.deserialize(json.getAsJsonPrimitive(), Type.class));
            }
            if (json.isJsonArray()) {
                JsonArray array = json.getAsJsonArray();
                double[][][] matrix = makeSizedMatrix(array);
                for (int x = 0; x < array.size(); x++) {
                    JsonArray xArray = array.get(x).getAsJsonArray();
                    for (int y = 0; y < xArray.size(); y++) {
                        JsonArray yArray = xArray.get(y).getAsJsonArray();
                        matrix[x][y] = JsonUtil.jsonArrayToDoubleArray(yArray);
                    }
                }
                return new PolysUnion(matrix, null);
            }
            throw new JsonParseException("Invalid format for PolysUnion, must be either string or array");
        };
    }

    private static double[][][] makeSizedMatrix(JsonArray array) {
        JsonArray subArray = array.size() > 0 ? array.get(0).getAsJsonArray() : null;
        JsonArray subSubArray = (subArray == null || subArray.size() <= 0) ? null : subArray.get(0).getAsJsonArray();
        int ySize = subArray != null ? subArray.size() : 0;
        int zSize = subSubArray != null ? subSubArray.size() : 0;
        return new double[array.size()][ySize][zSize];
    }
}
