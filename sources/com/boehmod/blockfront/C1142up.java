package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.up */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/up.class */
public final class C1142up extends Record {

    /* JADX INFO: renamed from: rS */
    private final int f5965rS;

    /* JADX INFO: renamed from: mS */
    private final float f5966mS;

    /* JADX INFO: renamed from: hM */
    private final boolean f5967hM;

    /* JADX INFO: renamed from: hN */
    private final boolean f5968hN;

    /* JADX INFO: renamed from: hO */
    private final boolean f5969hO;

    /* JADX INFO: renamed from: hP */
    private final boolean f5970hP;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Direction f5971d;

    /* JADX INFO: renamed from: ap */
    @NotNull
    private final Vec3 f5972ap;

    public C1142up(int i, float f, boolean z, boolean z2, boolean z3, boolean z4, @NotNull Direction direction, @NotNull Vec3 vec3) {
        this.f5965rS = i;
        this.f5966mS = f;
        this.f5967hM = z;
        this.f5968hN = z2;
        this.f5969hO = z3;
        this.f5970hP = z4;
        this.f5971d = direction;
        this.f5972ap = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1142up.class), C1142up.class, "entityId;damageReduction;headShot;collateral;noScope;backpack;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/up;->rS:I", "FIELD:Lcom/boehmod/blockfront/up;->mS:F", "FIELD:Lcom/boehmod/blockfront/up;->hM:Z", "FIELD:Lcom/boehmod/blockfront/up;->hN:Z", "FIELD:Lcom/boehmod/blockfront/up;->hO:Z", "FIELD:Lcom/boehmod/blockfront/up;->hP:Z", "FIELD:Lcom/boehmod/blockfront/up;->d:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/up;->ap:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1142up.class), C1142up.class, "entityId;damageReduction;headShot;collateral;noScope;backpack;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/up;->rS:I", "FIELD:Lcom/boehmod/blockfront/up;->mS:F", "FIELD:Lcom/boehmod/blockfront/up;->hM:Z", "FIELD:Lcom/boehmod/blockfront/up;->hN:Z", "FIELD:Lcom/boehmod/blockfront/up;->hO:Z", "FIELD:Lcom/boehmod/blockfront/up;->hP:Z", "FIELD:Lcom/boehmod/blockfront/up;->d:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/up;->ap:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1142up.class, Object.class), C1142up.class, "entityId;damageReduction;headShot;collateral;noScope;backpack;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/up;->rS:I", "FIELD:Lcom/boehmod/blockfront/up;->mS:F", "FIELD:Lcom/boehmod/blockfront/up;->hM:Z", "FIELD:Lcom/boehmod/blockfront/up;->hN:Z", "FIELD:Lcom/boehmod/blockfront/up;->hO:Z", "FIELD:Lcom/boehmod/blockfront/up;->hP:Z", "FIELD:Lcom/boehmod/blockfront/up;->d:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/up;->ap:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: al */
    public int m6284al() {
        return this.f5965rS;
    }

    /* JADX INFO: renamed from: bu */
    public float m6285bu() {
        return this.f5966mS;
    }

    /* JADX INFO: renamed from: co */
    public boolean m6286co() {
        return this.f5967hM;
    }

    /* JADX INFO: renamed from: cp */
    public boolean m6287cp() {
        return this.f5968hN;
    }

    /* JADX INFO: renamed from: cq */
    public boolean m6288cq() {
        return this.f5969hO;
    }

    /* JADX INFO: renamed from: cr */
    public boolean m6289cr() {
        return this.f5970hP;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Direction m6290b() {
        return this.f5971d;
    }

    @NotNull
    /* JADX INFO: renamed from: z */
    public Vec3 m6291z() {
        return this.f5972ap;
    }

    /* JADX INFO: renamed from: a */
    public static C1142up m6282a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new C1142up(friendlyByteBuf.readInt(), friendlyByteBuf.readFloat(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readEnum(Direction.class), friendlyByteBuf.readVec3());
    }

    /* JADX INFO: renamed from: a */
    public void m6283a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f5965rS);
        friendlyByteBuf.writeFloat(this.f5966mS);
        friendlyByteBuf.writeBoolean(this.f5967hM);
        friendlyByteBuf.writeBoolean(this.f5968hN);
        friendlyByteBuf.writeBoolean(this.f5969hO);
        friendlyByteBuf.writeBoolean(this.f5970hP);
        friendlyByteBuf.writeEnum(this.f5971d);
        friendlyByteBuf.writeVec3(this.f5972ap);
    }
}
