package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uN.class */
public final class C1115uN extends Record {

    /* JADX INFO: renamed from: tV */
    private final int f6031tV;

    /* JADX INFO: renamed from: nR */
    private final float f6032nR;

    /* JADX INFO: renamed from: ig */
    private final boolean f6033ig;

    /* JADX INFO: renamed from: ih */
    private final boolean f6034ih;

    /* JADX INFO: renamed from: ii */
    private final boolean f6035ii;

    /* JADX INFO: renamed from: ij */
    private final boolean f6036ij;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Direction f6037d;

    /* JADX INFO: renamed from: aq */
    @NotNull
    private final Vec3 f6038aq;

    public C1115uN(int i, float f, boolean z, boolean z2, boolean z3, boolean z4, @NotNull Direction direction, @NotNull Vec3 vec3) {
        this.f6031tV = i;
        this.f6032nR = f;
        this.f6033ig = z;
        this.f6034ih = z2;
        this.f6035ii = z3;
        this.f6036ij = z4;
        this.f6037d = direction;
        this.f6038aq = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1115uN.class), C1115uN.class, "entityId;damageReduction;headShot;collateral;noScope;backpack;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/uN;->tV:I", "FIELD:Lcom/boehmod/blockfront/uN;->nR:F", "FIELD:Lcom/boehmod/blockfront/uN;->ig:Z", "FIELD:Lcom/boehmod/blockfront/uN;->ih:Z", "FIELD:Lcom/boehmod/blockfront/uN;->ii:Z", "FIELD:Lcom/boehmod/blockfront/uN;->ij:Z", "FIELD:Lcom/boehmod/blockfront/uN;->d:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/uN;->aq:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1115uN.class), C1115uN.class, "entityId;damageReduction;headShot;collateral;noScope;backpack;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/uN;->tV:I", "FIELD:Lcom/boehmod/blockfront/uN;->nR:F", "FIELD:Lcom/boehmod/blockfront/uN;->ig:Z", "FIELD:Lcom/boehmod/blockfront/uN;->ih:Z", "FIELD:Lcom/boehmod/blockfront/uN;->ii:Z", "FIELD:Lcom/boehmod/blockfront/uN;->ij:Z", "FIELD:Lcom/boehmod/blockfront/uN;->d:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/uN;->aq:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1115uN.class, Object.class), C1115uN.class, "entityId;damageReduction;headShot;collateral;noScope;backpack;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/uN;->tV:I", "FIELD:Lcom/boehmod/blockfront/uN;->nR:F", "FIELD:Lcom/boehmod/blockfront/uN;->ig:Z", "FIELD:Lcom/boehmod/blockfront/uN;->ih:Z", "FIELD:Lcom/boehmod/blockfront/uN;->ii:Z", "FIELD:Lcom/boehmod/blockfront/uN;->ij:Z", "FIELD:Lcom/boehmod/blockfront/uN;->d:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/uN;->aq:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: aB */
    public int m6248aB() {
        return this.f6031tV;
    }

    /* JADX INFO: renamed from: bA */
    public float m6249bA() {
        return this.f6032nR;
    }

    /* JADX INFO: renamed from: an */
    public boolean m6250an() {
        return this.f6033ig;
    }

    /* JADX INFO: renamed from: cy */
    public boolean m6251cy() {
        return this.f6034ih;
    }

    /* JADX INFO: renamed from: cz */
    public boolean m6252cz() {
        return this.f6035ii;
    }

    /* JADX INFO: renamed from: cA */
    public boolean m6253cA() {
        return this.f6036ij;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Direction m6254b() {
        return this.f6037d;
    }

    @NotNull
    /* JADX INFO: renamed from: A */
    public Vec3 m6255A() {
        return this.f6038aq;
    }

    /* JADX INFO: renamed from: a */
    public static C1115uN m6246a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new C1115uN(friendlyByteBuf.readInt(), C1270xJ.m7168e(friendlyByteBuf.readFloat(), 0.0f, Float.MAX_VALUE), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readEnum(Direction.class), friendlyByteBuf.readVec3());
    }

    /* JADX INFO: renamed from: a */
    public void m6247a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f6031tV);
        friendlyByteBuf.writeFloat(this.f6032nR);
        friendlyByteBuf.writeBoolean(this.f6033ig);
        friendlyByteBuf.writeBoolean(this.f6034ih);
        friendlyByteBuf.writeBoolean(this.f6035ii);
        friendlyByteBuf.writeBoolean(this.f6036ij);
        friendlyByteBuf.writeEnum(this.f6037d);
        friendlyByteBuf.writeVec3(this.f6038aq);
    }
}
