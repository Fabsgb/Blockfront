package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uM.class */
public final class C1114uM extends Record {

    /* JADX INFO: renamed from: e */
    @NotNull
    private final BlockPos f6028e;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Direction f6029c;

    /* JADX INFO: renamed from: ap */
    @NotNull
    private final Vec3 f6030ap;

    public C1114uM(@NotNull BlockPos blockPos, @NotNull Direction direction, @NotNull Vec3 vec3) {
        this.f6028e = blockPos;
        this.f6029c = direction;
        this.f6030ap = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1114uM.class), C1114uM.class, "blockPos;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/uM;->e:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/uM;->c:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/uM;->ap:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1114uM.class), C1114uM.class, "blockPos;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/uM;->e:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/uM;->c:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/uM;->ap:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1114uM.class, Object.class), C1114uM.class, "blockPos;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/uM;->e:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/uM;->c:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/uM;->ap:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public BlockPos m6243a() {
        return this.f6028e;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Direction m6244b() {
        return this.f6029c;
    }

    @NotNull
    /* JADX INFO: renamed from: A */
    public Vec3 m6245A() {
        return this.f6030ap;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C1114uM m6241a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new C1114uM(friendlyByteBuf.readBlockPos(), friendlyByteBuf.readEnum(Direction.class), friendlyByteBuf.readVec3());
    }

    /* JADX INFO: renamed from: a */
    public void m6242a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.f6028e);
        friendlyByteBuf.writeEnum(this.f6029c);
        friendlyByteBuf.writeVec3(this.f6030ap);
    }
}
