package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uo.class */
public final class C1141uo extends Record {

    /* JADX INFO: renamed from: e */
    @NotNull
    private final BlockPos f5962e;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Direction f5963c;

    /* JADX INFO: renamed from: ao */
    @NotNull
    private final Vec3 f5964ao;

    public C1141uo(@NotNull BlockPos blockPos, @NotNull Direction direction, @NotNull Vec3 vec3) {
        this.f5962e = blockPos;
        this.f5963c = direction;
        this.f5964ao = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1141uo.class), C1141uo.class, "blockPos;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/uo;->e:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/uo;->c:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/uo;->ao:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1141uo.class), C1141uo.class, "blockPos;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/uo;->e:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/uo;->c:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/uo;->ao:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1141uo.class, Object.class), C1141uo.class, "blockPos;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/uo;->e:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/uo;->c:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/uo;->ao:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public BlockPos m6279a() {
        return this.f5962e;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Direction m6280b() {
        return this.f5963c;
    }

    @NotNull
    /* JADX INFO: renamed from: z */
    public Vec3 m6281z() {
        return this.f5964ao;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C1141uo m6277a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new C1141uo(friendlyByteBuf.readBlockPos(), friendlyByteBuf.readEnum(Direction.class), friendlyByteBuf.readVec3());
    }

    /* JADX INFO: renamed from: a */
    public void m6278a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.f5962e);
        friendlyByteBuf.writeEnum(this.f5963c);
        friendlyByteBuf.writeVec3(this.f5964ao);
    }
}
