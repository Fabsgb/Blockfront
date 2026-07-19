package software.bernie.geckolib.loading.json.raw;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonParseException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.util.JsonUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/json/raw/UVUnion.class */
public final class UVUnion extends Record {
    private final double[] boxUVCoords;

    @Nullable
    private final UVFaces faceUV;
    private final boolean isBoxUV;

    public UVUnion(double[] boxUVCoords, @Nullable UVFaces faceUV, boolean isBoxUV) {
        this.boxUVCoords = boxUVCoords;
        this.faceUV = faceUV;
        this.isBoxUV = isBoxUV;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, UVUnion.class), UVUnion.class, "boxUVCoords;faceUV;isBoxUV", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVUnion;->boxUVCoords:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVUnion;->faceUV:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVUnion;->isBoxUV:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, UVUnion.class), UVUnion.class, "boxUVCoords;faceUV;isBoxUV", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVUnion;->boxUVCoords:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVUnion;->faceUV:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVUnion;->isBoxUV:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, UVUnion.class, Object.class), UVUnion.class, "boxUVCoords;faceUV;isBoxUV", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVUnion;->boxUVCoords:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVUnion;->faceUV:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVUnion;->isBoxUV:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public double[] boxUVCoords() {
        return this.boxUVCoords;
    }

    @Nullable
    public UVFaces faceUV() {
        return this.faceUV;
    }

    public boolean isBoxUV() {
        return this.isBoxUV;
    }

    public static JsonDeserializer<UVUnion> deserializer() throws JsonParseException {
        return (json, type, context) -> {
            if (json.isJsonObject()) {
                return new UVUnion(new double[0], (UVFaces) context.deserialize(json.getAsJsonObject(), UVFaces.class), false);
            }
            if (json.isJsonArray()) {
                return new UVUnion(JsonUtil.jsonArrayToDoubleArray(json.getAsJsonArray()), null, true);
            }
            throw new JsonParseException("Invalid format provided for UVUnion, must be either double array or UVFaces collection");
        };
    }
}
