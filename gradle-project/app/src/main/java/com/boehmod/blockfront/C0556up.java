package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.up, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/up.class */
public final class C0556up extends Record {
    private final int rS;
    private final float mS;
    private final boolean hM;
    private final boolean hN;
    private final boolean hO;
    private final boolean hP;

    @NotNull
    private final Direction d;

    @NotNull
    private final Vec3 ap;

    public C0556up(int i, float f, boolean z, boolean z2, boolean z3, boolean z4, @NotNull Direction direction, @NotNull Vec3 vec3) {
        this.rS = i;
        this.mS = f;
        this.hM = z;
        this.hN = z2;
        this.hO = z3;
        this.hP = z4;
        this.d = direction;
        this.ap = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0556up.class), C0556up.class, "entityId;damageReduction;headShot;collateral;noScope;backpack;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/up;->rS:I", "FIELD:Lcom/boehmod/blockfront/up;->mS:F", "FIELD:Lcom/boehmod/blockfront/up;->hM:Z", "FIELD:Lcom/boehmod/blockfront/up;->hN:Z", "FIELD:Lcom/boehmod/blockfront/up;->hO:Z", "FIELD:Lcom/boehmod/blockfront/up;->hP:Z", "FIELD:Lcom/boehmod/blockfront/up;->d:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/up;->ap:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0556up.class), C0556up.class, "entityId;damageReduction;headShot;collateral;noScope;backpack;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/up;->rS:I", "FIELD:Lcom/boehmod/blockfront/up;->mS:F", "FIELD:Lcom/boehmod/blockfront/up;->hM:Z", "FIELD:Lcom/boehmod/blockfront/up;->hN:Z", "FIELD:Lcom/boehmod/blockfront/up;->hO:Z", "FIELD:Lcom/boehmod/blockfront/up;->hP:Z", "FIELD:Lcom/boehmod/blockfront/up;->d:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/up;->ap:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0556up.class, Object.class), C0556up.class, "entityId;damageReduction;headShot;collateral;noScope;backpack;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/up;->rS:I", "FIELD:Lcom/boehmod/blockfront/up;->mS:F", "FIELD:Lcom/boehmod/blockfront/up;->hM:Z", "FIELD:Lcom/boehmod/blockfront/up;->hN:Z", "FIELD:Lcom/boehmod/blockfront/up;->hO:Z", "FIELD:Lcom/boehmod/blockfront/up;->hP:Z", "FIELD:Lcom/boehmod/blockfront/up;->d:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/up;->ap:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int al() {
        return this.rS;
    }

    public float bu() {
        return this.mS;
    }

    public boolean co() {
        return this.hM;
    }

    public boolean cp() {
        return this.hN;
    }

    public boolean cq() {
        return this.hO;
    }

    public boolean cr() {
        return this.hP;
    }

    @NotNull
    public Direction b() {
        return this.d;
    }

    @NotNull
    public Vec3 z() {
        return this.ap;
    }

    public static C0556up a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new C0556up(friendlyByteBuf.readInt(), friendlyByteBuf.readFloat(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readEnum(Direction.class), friendlyByteBuf.readVec3());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m1195a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.rS);
        friendlyByteBuf.writeFloat(this.mS);
        friendlyByteBuf.writeBoolean(this.hM);
        friendlyByteBuf.writeBoolean(this.hN);
        friendlyByteBuf.writeBoolean(this.hO);
        friendlyByteBuf.writeBoolean(this.hP);
        friendlyByteBuf.writeEnum(this.d);
        friendlyByteBuf.writeVec3(this.ap);
    }
}
