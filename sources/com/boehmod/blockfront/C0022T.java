package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.T */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/T.class */
public class C0022T {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AABB f215a;

    /* JADX INFO: renamed from: X */
    private final int f216X;

    /* JADX INFO: renamed from: K */
    private final boolean f217K;

    /* JADX INFO: renamed from: Y */
    private final int f218Y;

    /* JADX INFO: renamed from: Z */
    private int f219Z;

    public C0022T(@NotNull AABB aabb, int i, boolean z, int i2) {
        this.f215a = aabb;
        this.f216X = i;
        this.f217K = z;
        this.f219Z = i;
        this.f218Y = i2;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0022T m136a(int i) {
        return new C0022T(this.f215a, this.f216X, this.f217K, i);
    }

    public C0022T(@NotNull Vec3 vec3, @NotNull Vec3 vec32, int i, boolean z, int i2) {
        this(new AABB(vec3.subtract(vec32), vec3.add(vec32)), i, z, i2);
    }

    /* JADX INFO: renamed from: a */
    public static C0022T m137a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new C0022T(new AABB(friendlyByteBuf.readVec3(), friendlyByteBuf.readVec3()), friendlyByteBuf.readInt(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readInt());
    }

    /* JADX INFO: renamed from: a */
    public void m138a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVec3(new Vec3(this.f215a.minX, this.f215a.minY, this.f215a.minZ));
        friendlyByteBuf.writeVec3(new Vec3(this.f215a.maxX, this.f215a.maxY, this.f215a.maxZ));
        friendlyByteBuf.writeInt(this.f216X);
        friendlyByteBuf.writeBoolean(this.f217K);
        friendlyByteBuf.writeInt(this.f218Y);
    }

    /* JADX INFO: renamed from: k */
    public boolean m139k() {
        int i = this.f219Z;
        this.f219Z = i - 1;
        return i <= 0;
    }

    /* JADX INFO: renamed from: b */
    public float m140b() {
        if (this.f217K) {
            return this.f219Z / this.f216X;
        }
        return 1.0f;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public AABB m141b() {
        return this.f215a;
    }

    public int getColor() {
        return this.f218Y;
    }
}
