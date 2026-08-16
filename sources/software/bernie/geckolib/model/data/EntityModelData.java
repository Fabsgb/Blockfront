package software.bernie.geckolib.model.data;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/model/data/EntityModelData.class */
public final class EntityModelData extends Record {
    private final boolean isSitting;
    private final boolean isChild;
    private final float netHeadYaw;
    private final float headPitch;

    public EntityModelData(boolean isSitting, boolean isChild, float netHeadYaw, float headPitch) {
        this.isSitting = isSitting;
        this.isChild = isChild;
        this.netHeadYaw = netHeadYaw;
        this.headPitch = headPitch;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, EntityModelData.class), EntityModelData.class, "isSitting;isChild;netHeadYaw;headPitch", "FIELD:Lsoftware/bernie/geckolib/model/data/EntityModelData;->isSitting:Z", "FIELD:Lsoftware/bernie/geckolib/model/data/EntityModelData;->isChild:Z", "FIELD:Lsoftware/bernie/geckolib/model/data/EntityModelData;->netHeadYaw:F", "FIELD:Lsoftware/bernie/geckolib/model/data/EntityModelData;->headPitch:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, EntityModelData.class), EntityModelData.class, "isSitting;isChild;netHeadYaw;headPitch", "FIELD:Lsoftware/bernie/geckolib/model/data/EntityModelData;->isSitting:Z", "FIELD:Lsoftware/bernie/geckolib/model/data/EntityModelData;->isChild:Z", "FIELD:Lsoftware/bernie/geckolib/model/data/EntityModelData;->netHeadYaw:F", "FIELD:Lsoftware/bernie/geckolib/model/data/EntityModelData;->headPitch:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, EntityModelData.class, Object.class), EntityModelData.class, "isSitting;isChild;netHeadYaw;headPitch", "FIELD:Lsoftware/bernie/geckolib/model/data/EntityModelData;->isSitting:Z", "FIELD:Lsoftware/bernie/geckolib/model/data/EntityModelData;->isChild:Z", "FIELD:Lsoftware/bernie/geckolib/model/data/EntityModelData;->netHeadYaw:F", "FIELD:Lsoftware/bernie/geckolib/model/data/EntityModelData;->headPitch:F").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public boolean isSitting() {
        return this.isSitting;
    }

    public boolean isChild() {
        return this.isChild;
    }

    public float netHeadYaw() {
        return this.netHeadYaw;
    }

    public float headPitch() {
        return this.headPitch;
    }
}
