package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aa */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aa.class */
public class C0057aa {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Vec3 f404a;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Vec3 f405b;

    /* JADX INFO: renamed from: aO */
    private final int f406aO;

    /* JADX INFO: renamed from: Q */
    private final boolean f407Q;

    /* JADX INFO: renamed from: aP */
    private final int f408aP;

    /* JADX INFO: renamed from: aN */
    private int f409aN;

    public C0057aa(@NotNull Vec3 vec3, @NotNull Vec3 vec4, int i, boolean z, int i2) {
        this.f404a = vec3;
        this.f405b = vec4;
        this.f406aO = i;
        this.f407Q = z;
        this.f409aN = i;
        this.f408aP = i2;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0057aa m256a(int i) {
        return new C0057aa(this.f404a, this.f405b, this.f406aO, this.f407Q, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0057aa m257a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new C0057aa(friendlyByteBuf.readVec3(), friendlyByteBuf.readVec3(), friendlyByteBuf.readInt(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readInt());
    }

    /* JADX INFO: renamed from: a */
    public void m258a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVec3(this.f404a);
        friendlyByteBuf.writeVec3(this.f405b);
        friendlyByteBuf.writeInt(this.f406aO);
        friendlyByteBuf.writeBoolean(this.f407Q);
        friendlyByteBuf.writeInt(this.f408aP);
    }

    /* JADX INFO: renamed from: l */
    public boolean m259l() {
        int i = this.f409aN;
        this.f409aN = i - 1;
        return i <= 0;
    }

    /* JADX INFO: renamed from: b */
    public float m260b() {
        if (this.f407Q) {
            return this.f409aN / this.f406aO;
        }
        return 1.0f;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vec3 m261a() {
        return this.f404a;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Vec3 m262b() {
        return this.f405b;
    }

    public int getColor() {
        return this.f408aP;
    }
}
