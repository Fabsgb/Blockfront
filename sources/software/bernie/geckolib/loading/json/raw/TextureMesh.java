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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/json/raw/TextureMesh.class */
public final class TextureMesh extends Record {
    private final double[] localPivot;
    private final double[] position;
    private final double[] rotation;
    private final double[] scale;

    @Nullable
    private final String texture;

    public TextureMesh(double[] localPivot, double[] position, double[] rotation, double[] scale, @Nullable String texture) {
        this.localPivot = localPivot;
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
        this.texture = texture;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, TextureMesh.class), TextureMesh.class, "localPivot;position;rotation;scale;texture", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;->localPivot:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;->position:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;->rotation:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;->scale:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;->texture:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, TextureMesh.class), TextureMesh.class, "localPivot;position;rotation;scale;texture", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;->localPivot:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;->position:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;->rotation:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;->scale:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;->texture:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, TextureMesh.class, Object.class), TextureMesh.class, "localPivot;position;rotation;scale;texture", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;->localPivot:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;->position:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;->rotation:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;->scale:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;->texture:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public double[] localPivot() {
        return this.localPivot;
    }

    public double[] position() {
        return this.position;
    }

    public double[] rotation() {
        return this.rotation;
    }

    public double[] scale() {
        return this.scale;
    }

    @Nullable
    public String texture() {
        return this.texture;
    }

    public static JsonDeserializer<TextureMesh> deserializer() throws JsonParseException {
        return (json, type, context) -> {
            JsonObject obj = json.getAsJsonObject();
            double[] pivot = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "local_pivot", (JsonArray) null));
            double[] position = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "position", (JsonArray) null));
            double[] rotation = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "rotation", (JsonArray) null));
            double[] scale = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "scale", (JsonArray) null));
            String texture = GsonHelper.getAsString(obj, "texture", (String) null);
            return new TextureMesh(pivot, position, rotation, scale, texture);
        };
    }
}
