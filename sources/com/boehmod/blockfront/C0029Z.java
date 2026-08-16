package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.Z */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/Z.class */
public class C0029Z {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AABB f258a;

    /* JADX INFO: renamed from: aL */
    private final int f259aL;

    /* JADX INFO: renamed from: P */
    private final boolean f260P;

    /* JADX INFO: renamed from: aM */
    private final int f261aM;

    /* JADX INFO: renamed from: aN */
    private int f262aN;

    public C0029Z(@NotNull AABB aabb, int i, boolean z, int i2) {
        this.f258a = aabb;
        this.f259aL = i;
        this.f260P = z;
        this.f262aN = i;
        this.f261aM = i2;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0029Z m169a(int i) {
        return new C0029Z(this.f258a, this.f259aL, this.f260P, i);
    }

    public C0029Z(@NotNull Vec3 vec3, @NotNull Vec3 vec4, int i, boolean z, int i2) {
        this(new AABB(vec3.subtract(vec4), vec3.add(vec4)), i, z, i2);
    }

    /* JADX INFO: renamed from: a */
    public static C0029Z m170a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new C0029Z(new AABB(friendlyByteBuf.readVec3(), friendlyByteBuf.readVec3()), friendlyByteBuf.readInt(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readInt());
    }

    /* JADX INFO: renamed from: a */
    public void m171a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVec3(new Vec3(this.f258a.minX, this.f258a.minY, this.f258a.minZ));
        friendlyByteBuf.writeVec3(new Vec3(this.f258a.maxX, this.f258a.maxY, this.f258a.maxZ));
        friendlyByteBuf.writeInt(this.f259aL);
        friendlyByteBuf.writeBoolean(this.f260P);
        friendlyByteBuf.writeInt(this.f261aM);
    }

    /* JADX INFO: renamed from: l */
    public boolean m172l() {
        int i = this.f262aN;
        this.f262aN = i - 1;
        return i <= 0;
    }

    /* JADX INFO: renamed from: b */
    public float m173b() {
        if (this.f260P) {
            return this.f262aN / this.f259aL;
        }
        return 1.0f;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public AABB m174b() {
        return this.f258a;
    }

    public int getColor() {
        return this.f261aM;
    }
}
