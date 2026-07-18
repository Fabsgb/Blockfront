package software.bernie.geckolib.loading.object;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import software.bernie.geckolib.loading.json.raw.Bone;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/object/BoneStructure.class */
public final class BoneStructure extends Record {
    private final Bone self;
    private final Map<String, BoneStructure> children;

    public BoneStructure(Bone self, Map<String, BoneStructure> children) {
        this.self = self;
        this.children = children;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, BoneStructure.class), BoneStructure.class, "self;children", "FIELD:Lsoftware/bernie/geckolib/loading/object/BoneStructure;->self:Lsoftware/bernie/geckolib/loading/json/raw/Bone;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BoneStructure;->children:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, BoneStructure.class), BoneStructure.class, "self;children", "FIELD:Lsoftware/bernie/geckolib/loading/object/BoneStructure;->self:Lsoftware/bernie/geckolib/loading/json/raw/Bone;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BoneStructure;->children:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, BoneStructure.class, Object.class), BoneStructure.class, "self;children", "FIELD:Lsoftware/bernie/geckolib/loading/object/BoneStructure;->self:Lsoftware/bernie/geckolib/loading/json/raw/Bone;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BoneStructure;->children:Ljava/util/Map;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Bone self() {
        return this.self;
    }

    public Map<String, BoneStructure> children() {
        return this.children;
    }

    public BoneStructure(Bone self) {
        this(self, new Object2ObjectOpenHashMap());
    }
}
