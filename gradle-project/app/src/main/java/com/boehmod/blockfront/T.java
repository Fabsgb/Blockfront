package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/T.class */
public class T {

    @NotNull
    private final AABB a;
    private final int X;
    private final boolean K;
    private final int Y;
    private int Z;

    public T(@NotNull AABB aabb, int i, boolean z, int i2) {
        this.a = aabb;
        this.X = i;
        this.K = z;
        this.Z = i;
        this.Y = i2;
    }

    @NotNull
    public T a(int i) {
        return new T(this.a, this.X, this.K, i);
    }

    public T(@NotNull Vec3 vec3, @NotNull Vec3 vec32, int i, boolean z, int i2) {
        this(new AABB(vec3.subtract(vec32), vec3.add(vec32)), i, z, i2);
    }

    public static T a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new T(new AABB(friendlyByteBuf.readVec3(), friendlyByteBuf.readVec3()), friendlyByteBuf.readInt(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readInt());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m160a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVec3(new Vec3(this.a.minX, this.a.minY, this.a.minZ));
        friendlyByteBuf.writeVec3(new Vec3(this.a.maxX, this.a.maxY, this.a.maxZ));
        friendlyByteBuf.writeInt(this.X);
        friendlyByteBuf.writeBoolean(this.K);
        friendlyByteBuf.writeInt(this.Y);
    }

    public boolean k() {
        int i = this.Z;
        this.Z = i - 1;
        return i <= 0;
    }

    public float b() {
        if (this.K) {
            return this.Z / this.X;
        }
        return 1.0f;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public AABB m161b() {
        return this.a;
    }

    public int getColor() {
        return this.Y;
    }
}
