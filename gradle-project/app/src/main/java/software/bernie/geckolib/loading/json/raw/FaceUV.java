package software.bernie.geckolib.loading.json.raw;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.util.JsonUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/json/raw/FaceUV.class */
public final class FaceUV extends Record {

    @Nullable
    private final String materialInstance;

    /* JADX INFO: renamed from: uv */
    private final double[] f9197uv;
    private final double[] uvSize;
    private final Rotation uvRotation;

    public FaceUV(@Nullable String materialInstance, double[] uv, double[] uvSize, Rotation uvRotation) {
        this.materialInstance = materialInstance;
        this.f9197uv = uv;
        this.uvSize = uvSize;
        this.uvRotation = uvRotation;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, FaceUV.class), FaceUV.class, "materialInstance;uv;uvSize;uvRotation", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;->materialInstance:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;->uv:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;->uvSize:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;->uvRotation:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV$Rotation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FaceUV.class), FaceUV.class, "materialInstance;uv;uvSize;uvRotation", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;->materialInstance:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;->uv:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;->uvSize:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;->uvRotation:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV$Rotation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FaceUV.class, Object.class), FaceUV.class, "materialInstance;uv;uvSize;uvRotation", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;->materialInstance:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;->uv:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;->uvSize:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;->uvRotation:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV$Rotation;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Nullable
    public String materialInstance() {
        return this.materialInstance;
    }

    /* JADX INFO: renamed from: uv */
    public double[] m8361uv() {
        return this.f9197uv;
    }

    public double[] uvSize() {
        return this.uvSize;
    }

    public Rotation uvRotation() {
        return this.uvRotation;
    }

    public FaceUV(@Nullable String materialInstance, double[] uv, double[] uvSize) {
        this(materialInstance, uv, uvSize, Rotation.NONE);
    }

    public static JsonDeserializer<FaceUV> deserializer() throws JsonParseException {
        return (json, type, context) -> {
            JsonObject obj = json.getAsJsonObject();
            String materialInstance = GsonHelper.getAsString(obj, "material_instance", (String) null);
            double[] uv = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "uv", (JsonArray) null));
            double[] uvSize = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "uv_size", (JsonArray) null));
            Rotation uvRotation = Rotation.fromValue(GsonHelper.getAsInt(obj, "uv_rotation", 0));
            return new FaceUV(materialInstance, uv, uvSize, uvRotation);
        };
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/json/raw/FaceUV$Rotation.class */
    public enum Rotation {
        NONE,
        CLOCKWISE_90,
        CLOCKWISE_180,
        CLOCKWISE_270;

        public static Rotation fromValue(int value) throws JsonParseException {
            try {
                return values()[(value % 360) / 90];
            } catch (Exception e) {
                GeckoLibConstants.LOGGER.error("Invalid Face UV rotation: " + value);
                return fromValue(Mth.floor(Math.abs(value) / 90.0f) * 90);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
        public float[] rotateUvs(float u, float v, float uWidth, float vHeight) throws MatchException {
            switch (this) {
                case NONE:
                    return new float[]{u, v, uWidth, v, uWidth, vHeight, u, vHeight};
                case CLOCKWISE_90:
                    return new float[]{uWidth, v, uWidth, vHeight, u, vHeight, u, v};
                case CLOCKWISE_180:
                    return new float[]{uWidth, vHeight, u, vHeight, u, v, uWidth, v};
                case CLOCKWISE_270:
                    return new float[]{u, vHeight, u, v, uWidth, v, uWidth, vHeight};
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
        }
    }
}
