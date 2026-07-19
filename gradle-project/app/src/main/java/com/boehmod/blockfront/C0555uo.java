package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uo.class */
public final class C0555uo extends Record {

    @NotNull
    private final BlockPos e;

    @NotNull
    private final Direction c;

    @NotNull
    private final Vec3 ao;

    public C0555uo(@NotNull BlockPos blockPos, @NotNull Direction direction, @NotNull Vec3 vec3) {
        this.e = blockPos;
        this.c = direction;
        this.ao = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0555uo.class), C0555uo.class, "blockPos;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/uo;->e:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/uo;->c:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/uo;->ao:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0555uo.class), C0555uo.class, "blockPos;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/uo;->e:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/uo;->c:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/uo;->ao:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0555uo.class, Object.class), C0555uo.class, "blockPos;direction;hitVec", "FIELD:Lcom/boehmod/blockfront/uo;->e:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/uo;->c:Lnet/minecraft/core/Direction;", "FIELD:Lcom/boehmod/blockfront/uo;->ao:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public BlockPos a() {
        return this.e;
    }

    @NotNull
    public Direction b() {
        return this.c;
    }

    @NotNull
    public Vec3 z() {
        return this.ao;
    }

    @NotNull
    public static C0555uo a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new C0555uo(friendlyByteBuf.readBlockPos(), friendlyByteBuf.readEnum(Direction.class), friendlyByteBuf.readVec3());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m1194a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.e);
        friendlyByteBuf.writeEnum(this.c);
        friendlyByteBuf.writeVec3(this.ao);
    }
}
