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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/json/raw/MinecraftGeometry.class */
public final class MinecraftGeometry extends Record {
    private final Bone[] bones;

    @Nullable
    private final String cape;

    @Nullable
    private final ModelProperties modelProperties;

    public MinecraftGeometry(Bone[] bones, @Nullable String cape, @Nullable ModelProperties modelProperties) {
        this.bones = bones;
        this.cape = cape;
        this.modelProperties = modelProperties;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, MinecraftGeometry.class), MinecraftGeometry.class, "bones;cape;modelProperties", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/MinecraftGeometry;->bones:[Lsoftware/bernie/geckolib/loading/json/raw/Bone;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/MinecraftGeometry;->cape:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/MinecraftGeometry;->modelProperties:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, MinecraftGeometry.class), MinecraftGeometry.class, "bones;cape;modelProperties", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/MinecraftGeometry;->bones:[Lsoftware/bernie/geckolib/loading/json/raw/Bone;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/MinecraftGeometry;->cape:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/MinecraftGeometry;->modelProperties:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, MinecraftGeometry.class, Object.class), MinecraftGeometry.class, "bones;cape;modelProperties", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/MinecraftGeometry;->bones:[Lsoftware/bernie/geckolib/loading/json/raw/Bone;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/MinecraftGeometry;->cape:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/MinecraftGeometry;->modelProperties:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Bone[] bones() {
        return this.bones;
    }

    @Nullable
    public String cape() {
        return this.cape;
    }

    @Nullable
    public ModelProperties modelProperties() {
        return this.modelProperties;
    }

    public static JsonDeserializer<MinecraftGeometry> deserializer() throws JsonParseException {
        return (json, type, context) -> {
            JsonObject obj = json.getAsJsonObject();
            Bone[] bones = (Bone[]) JsonUtil.jsonArrayToObjectArray(GsonHelper.getAsJsonArray(obj, "bones", new JsonArray(0)), context, Bone.class);
            String cape = GsonHelper.getAsString(obj, "cape", (String) null);
            ModelProperties modelProperties = (ModelProperties) GsonHelper.getAsObject(obj, "description", (Object) null, context, ModelProperties.class);
            return new MinecraftGeometry(bones, cape, modelProperties);
        };
    }
}
