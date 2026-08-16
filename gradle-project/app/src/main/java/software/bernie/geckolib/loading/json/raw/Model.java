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
import software.bernie.geckolib.loading.json.FormatVersion;
import software.bernie.geckolib.util.JsonUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/json/raw/Model.class */
public final class Model extends Record {

    @Nullable
    private final FormatVersion formatVersion;
    private final MinecraftGeometry[] minecraftGeometry;

    public Model(@Nullable FormatVersion formatVersion, MinecraftGeometry[] minecraftGeometry) {
        this.formatVersion = formatVersion;
        this.minecraftGeometry = minecraftGeometry;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Model.class), Model.class, "formatVersion;minecraftGeometry", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Model;->formatVersion:Lsoftware/bernie/geckolib/loading/json/FormatVersion;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Model;->minecraftGeometry:[Lsoftware/bernie/geckolib/loading/json/raw/MinecraftGeometry;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Model.class), Model.class, "formatVersion;minecraftGeometry", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Model;->formatVersion:Lsoftware/bernie/geckolib/loading/json/FormatVersion;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Model;->minecraftGeometry:[Lsoftware/bernie/geckolib/loading/json/raw/MinecraftGeometry;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Model.class, Object.class), Model.class, "formatVersion;minecraftGeometry", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Model;->formatVersion:Lsoftware/bernie/geckolib/loading/json/FormatVersion;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Model;->minecraftGeometry:[Lsoftware/bernie/geckolib/loading/json/raw/MinecraftGeometry;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Nullable
    public FormatVersion formatVersion() {
        return this.formatVersion;
    }

    public MinecraftGeometry[] minecraftGeometry() {
        return this.minecraftGeometry;
    }

    public static JsonDeserializer<Model> deserializer() throws JsonParseException {
        return (json, type, context) -> {
            JsonObject obj = json.getAsJsonObject();
            FormatVersion formatVersion = (FormatVersion) context.deserialize(obj.get("format_version"), FormatVersion.class);
            MinecraftGeometry[] minecraftGeometry = (MinecraftGeometry[]) JsonUtil.jsonArrayToObjectArray(GsonHelper.getAsJsonArray(obj, "minecraft:geometry", new JsonArray(0)), context, MinecraftGeometry.class);
            return new Model(formatVersion, minecraftGeometry);
        };
    }
}
