package software.bernie.geckolib.cache.object;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Optional;
import software.bernie.geckolib.loading.json.raw.ModelProperties;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/cache/object/BakedGeoModel.class */
public final class BakedGeoModel extends Record {
    private final List<GeoBone> topLevelBones;
    private final ModelProperties properties;

    public BakedGeoModel(List<GeoBone> topLevelBones, ModelProperties properties) {
        this.topLevelBones = topLevelBones;
        this.properties = properties;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, BakedGeoModel.class), BakedGeoModel.class, "topLevelBones;properties", "FIELD:Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;->topLevelBones:Ljava/util/List;", "FIELD:Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;->properties:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, BakedGeoModel.class), BakedGeoModel.class, "topLevelBones;properties", "FIELD:Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;->topLevelBones:Ljava/util/List;", "FIELD:Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;->properties:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, BakedGeoModel.class, Object.class), BakedGeoModel.class, "topLevelBones;properties", "FIELD:Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;->topLevelBones:Ljava/util/List;", "FIELD:Lsoftware/bernie/geckolib/cache/object/BakedGeoModel;->properties:Lsoftware/bernie/geckolib/loading/json/raw/ModelProperties;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public List<GeoBone> topLevelBones() {
        return this.topLevelBones;
    }

    public ModelProperties properties() {
        return this.properties;
    }

    public Optional<GeoBone> getBone(String name) {
        for (GeoBone bone : this.topLevelBones) {
            GeoBone childBone = searchForChildBone(bone, name);
            if (childBone != null) {
                return Optional.of(childBone);
            }
        }
        return Optional.empty();
    }

    public GeoBone searchForChildBone(GeoBone parent, String name) {
        if (parent.getName().equals(name)) {
            return parent;
        }
        for (GeoBone bone : parent.getChildBones()) {
            if (bone.getName().equals(name)) {
                return bone;
            }
            GeoBone subChildBone = searchForChildBone(bone, name);
            if (subChildBone != null) {
                return subChildBone;
            }
        }
        return null;
    }
}
