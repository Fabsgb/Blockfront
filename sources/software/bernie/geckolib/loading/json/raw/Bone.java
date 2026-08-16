package software.bernie.geckolib.loading.json.raw;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import net.minecraft.util.GsonHelper;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.util.JsonUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/json/raw/Bone.class */
public final class Bone extends Record {
    private final double[] bindPoseRotation;
    private final Cube[] cubes;

    @Nullable
    private final Boolean debug;

    @Nullable
    private final Double inflate;

    @Nullable
    private final Map<String, LocatorValue> locators;

    @Nullable
    private final Boolean mirror;

    @Nullable
    private final String name;

    @Nullable
    private final Boolean neverRender;

    @Nullable
    private final String parent;
    private final double[] pivot;

    @Nullable
    private final PolyMesh polyMesh;

    @Nullable
    private final Long renderGroupId;

    @Nullable
    private final Boolean reset;
    private final double[] rotation;

    @Nullable
    private final TextureMesh[] textureMeshes;

    public Bone(double[] bindPoseRotation, Cube[] cubes, @Nullable Boolean debug, @Nullable Double inflate, @Nullable Map<String, LocatorValue> locators, @Nullable Boolean mirror, @Nullable String name, @Nullable Boolean neverRender, @Nullable String parent, double[] pivot, @Nullable PolyMesh polyMesh, @Nullable Long renderGroupId, @Nullable Boolean reset, double[] rotation, @Nullable TextureMesh[] textureMeshes) {
        this.bindPoseRotation = bindPoseRotation;
        this.cubes = cubes;
        this.debug = debug;
        this.inflate = inflate;
        this.locators = locators;
        this.mirror = mirror;
        this.name = name;
        this.neverRender = neverRender;
        this.parent = parent;
        this.pivot = pivot;
        this.polyMesh = polyMesh;
        this.renderGroupId = renderGroupId;
        this.reset = reset;
        this.rotation = rotation;
        this.textureMeshes = textureMeshes;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Bone.class), Bone.class, "bindPoseRotation;cubes;debug;inflate;locators;mirror;name;neverRender;parent;pivot;polyMesh;renderGroupId;reset;rotation;textureMeshes", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->bindPoseRotation:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->cubes:[Lsoftware/bernie/geckolib/loading/json/raw/Cube;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->debug:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->inflate:Ljava/lang/Double;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->locators:Ljava/util/Map;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->mirror:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->name:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->neverRender:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->parent:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->pivot:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->polyMesh:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->renderGroupId:Ljava/lang/Long;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->reset:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->rotation:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->textureMeshes:[Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Bone.class), Bone.class, "bindPoseRotation;cubes;debug;inflate;locators;mirror;name;neverRender;parent;pivot;polyMesh;renderGroupId;reset;rotation;textureMeshes", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->bindPoseRotation:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->cubes:[Lsoftware/bernie/geckolib/loading/json/raw/Cube;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->debug:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->inflate:Ljava/lang/Double;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->locators:Ljava/util/Map;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->mirror:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->name:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->neverRender:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->parent:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->pivot:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->polyMesh:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->renderGroupId:Ljava/lang/Long;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->reset:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->rotation:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->textureMeshes:[Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Bone.class, Object.class), Bone.class, "bindPoseRotation;cubes;debug;inflate;locators;mirror;name;neverRender;parent;pivot;polyMesh;renderGroupId;reset;rotation;textureMeshes", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->bindPoseRotation:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->cubes:[Lsoftware/bernie/geckolib/loading/json/raw/Cube;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->debug:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->inflate:Ljava/lang/Double;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->locators:Ljava/util/Map;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->mirror:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->name:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->neverRender:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->parent:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->pivot:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->polyMesh:Lsoftware/bernie/geckolib/loading/json/raw/PolyMesh;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->renderGroupId:Ljava/lang/Long;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->reset:Ljava/lang/Boolean;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->rotation:[D", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/Bone;->textureMeshes:[Lsoftware/bernie/geckolib/loading/json/raw/TextureMesh;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public double[] bindPoseRotation() {
        return this.bindPoseRotation;
    }

    public Cube[] cubes() {
        return this.cubes;
    }

    @Nullable
    public Boolean debug() {
        return this.debug;
    }

    @Nullable
    public Double inflate() {
        return this.inflate;
    }

    @Nullable
    public Map<String, LocatorValue> locators() {
        return this.locators;
    }

    @Nullable
    public Boolean mirror() {
        return this.mirror;
    }

    @Nullable
    public String name() {
        return this.name;
    }

    @Nullable
    public Boolean neverRender() {
        return this.neverRender;
    }

    @Nullable
    public String parent() {
        return this.parent;
    }

    public double[] pivot() {
        return this.pivot;
    }

    @Nullable
    public PolyMesh polyMesh() {
        return this.polyMesh;
    }

    @Nullable
    public Long renderGroupId() {
        return this.renderGroupId;
    }

    @Nullable
    public Boolean reset() {
        return this.reset;
    }

    public double[] rotation() {
        return this.rotation;
    }

    @Nullable
    public TextureMesh[] textureMeshes() {
        return this.textureMeshes;
    }

    public static JsonDeserializer<Bone> deserializer() throws JsonParseException {
        return (json, type, context) -> {
            JsonObject obj = json.getAsJsonObject();
            double[] bindPoseRotation = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "bind_pose_rotation", (JsonArray) null));
            Cube[] cubes = (Cube[]) JsonUtil.jsonArrayToObjectArray(GsonHelper.getAsJsonArray(obj, "cubes", new JsonArray(0)), context, Cube.class);
            Boolean debug = JsonUtil.getOptionalBoolean(obj, "debug");
            Double inflate = JsonUtil.getOptionalDouble(obj, "inflate");
            Map<String, LocatorValue> locators = obj.has("locators") ? JsonUtil.jsonObjToMap(GsonHelper.getAsJsonObject(obj, "locators"), context, LocatorValue.class) : null;
            Boolean mirror = JsonUtil.getOptionalBoolean(obj, "mirror");
            String name = GsonHelper.getAsString(obj, "name", (String) null);
            Boolean neverRender = JsonUtil.getOptionalBoolean(obj, "neverRender");
            String parent = GsonHelper.getAsString(obj, "parent", (String) null);
            double[] pivot = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "pivot", new JsonArray(0)));
            PolyMesh polyMesh = (PolyMesh) GsonHelper.getAsObject(obj, "poly_mesh", (Object) null, context, PolyMesh.class);
            Long renderGroupId = JsonUtil.getOptionalLong(obj, "render_group_id");
            Boolean reset = JsonUtil.getOptionalBoolean(obj, "reset");
            double[] rotation = JsonUtil.jsonArrayToDoubleArray(GsonHelper.getAsJsonArray(obj, "rotation", (JsonArray) null));
            TextureMesh[] textureMeshes = (TextureMesh[]) JsonUtil.jsonArrayToObjectArray(GsonHelper.getAsJsonArray(obj, "texture_meshes", new JsonArray(0)), context, TextureMesh.class);
            return new Bone(bindPoseRotation, cubes, debug, inflate, locators, mirror, name, neverRender, parent, pivot, polyMesh, renderGroupId, reset, rotation, textureMeshes);
        };
    }
}
