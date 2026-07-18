package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.U */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/U.class */
public class C0023U {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Vec3 f220a;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Vec3 f221b;

    /* JADX INFO: renamed from: aa */
    private final int f222aa;

    /* JADX INFO: renamed from: L */
    private final boolean f223L;

    /* JADX INFO: renamed from: ab */
    private final int f224ab;

    /* JADX INFO: renamed from: Z */
    private int f225Z;

    public C0023U(@NotNull Vec3 vec3, @NotNull Vec3 vec32, int i, boolean z, int i2) {
        this.f220a = vec3;
        this.f221b = vec32;
        this.f222aa = i;
        this.f223L = z;
        this.f225Z = i;
        this.f224ab = i2;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0023U m142a(int i) {
        return new C0023U(this.f220a, this.f221b, this.f222aa, this.f223L, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0023U m143a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new C0023U(friendlyByteBuf.readVec3(), friendlyByteBuf.readVec3(), friendlyByteBuf.readInt(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readInt());
    }

    /* JADX INFO: renamed from: a */
    public void m144a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVec3(this.f220a);
        friendlyByteBuf.writeVec3(this.f221b);
        friendlyByteBuf.writeInt(this.f222aa);
        friendlyByteBuf.writeBoolean(this.f223L);
        friendlyByteBuf.writeInt(this.f224ab);
    }

    /* JADX INFO: renamed from: k */
    public boolean m145k() {
        int i = this.f225Z;
        this.f225Z = i - 1;
        return i <= 0;
    }

    /* JADX INFO: renamed from: b */
    public float m146b() {
        if (this.f223L) {
            return this.f225Z / this.f222aa;
        }
        return 1.0f;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vec3 m147a() {
        return this.f220a;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Vec3 m148b() {
        return this.f221b;
    }

    public int getColor() {
        return this.f224ab;
    }
}
