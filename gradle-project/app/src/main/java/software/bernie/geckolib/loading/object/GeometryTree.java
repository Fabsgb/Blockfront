package software.bernie.geckolib.loading.object;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import software.bernie.geckolib.loading.json.raw.Bone;
import software.bernie.geckolib.loading.json.raw.MinecraftGeometry;
import software.bernie.geckolib.loading.json.raw.Model;
import software.bernie.geckolib.loading.json.raw.ModelProperties;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/object/GeometryTree.class */
public final class GeometryTree extends Record {
    private final Map<String, BoneStructure> topLevelBones;
    private final ModelProperties properties;

    public GeometryTree(Map<String, BoneStructure> topLevelBones, ModelProperties properties) {
        this.topLevelBones = topLevelBones;
        this.properties = properties;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, GeometryTree.class), GeometryTree.class, "topLevelBones;properties", "FIELD:Lsoftware/bernie/geckolib/loading/object/GeometryTree;->topLevelBones:Ljava/util/Map;", "FIELD:Lsoftware/bernie/geckolib/loading/object/GeometryTree;->properties:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, GeometryTree.class), GeometryTree.class, "topLevelBones;properties", "FIELD:Lsoftware/bernie/geckolib/loading/object/GeometryTree;->topLevelBones:Ljava/util/Map;", "FIELD:Lsoftware/bernie/geckolib/loading/object/GeometryTree;->properties:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, GeometryTree.class, Object.class), GeometryTree.class, "topLevelBones;properties", "FIELD:Lsoftware/bernie/geckolib/loading/object/GeometryTree;->topLevelBones:Ljava/util/Map;", "FIELD:Lsoftware/bernie/geckolib/loading/object/GeometryTree;->properties:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Map<String, BoneStructure> topLevelBones() {
        return this.topLevelBones;
    }

    public ModelProperties properties() {
        return this.properties;
    }

    public static GeometryTree fromModel(Model model) {
        Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap();
        MinecraftGeometry geometry = model.minecraftGeometry()[0];
        Bone[] bones = geometry.bones();
        Object2ObjectOpenHashMap object2ObjectOpenHashMap2 = new Object2ObjectOpenHashMap(bones.length);
        for (Bone bone : bones) {
            BoneStructure boneStructure = new BoneStructure(bone);
            object2ObjectOpenHashMap2.put(bone.name(), boneStructure);
            if (bone.parent() == null) {
                object2ObjectOpenHashMap.put(bone.name(), boneStructure);
            }
        }
        for (Bone bone2 : bones) {
            String parentName = bone2.parent();
            if (parentName != null) {
                String boneName = bone2.name();
                if (parentName.equals(boneName)) {
                    throw new IllegalArgumentException("Invalid model definition. Bone has defined itself as its own parent: " + boneName);
                }
                BoneStructure parentStructure = (BoneStructure) object2ObjectOpenHashMap2.get(parentName);
                if (parentStructure == null) {
                    throw new IllegalArgumentException("Invalid model definition. Found bone with undefined parent (child -> parent): " + boneName + " -> " + parentName);
                }
                parentStructure.children().put(boneName, (BoneStructure) object2ObjectOpenHashMap2.get(boneName));
            }
        }
        return new GeometryTree(object2ObjectOpenHashMap, geometry.modelProperties());
    }
}
