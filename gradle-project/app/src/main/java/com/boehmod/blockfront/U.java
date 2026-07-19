package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/U.class */
public class U {

    @NotNull
    private final Vec3 a;

    @NotNull
    private final Vec3 b;
    private final int aa;
    private final boolean L;
    private final int ab;
    private int Z;

    public U(@NotNull Vec3 vec3, @NotNull Vec3 vec32, int i, boolean z, int i2) {
        this.a = vec3;
        this.b = vec32;
        this.aa = i;
        this.L = z;
        this.Z = i;
        this.ab = i2;
    }

    @NotNull
    public U a(int i) {
        return new U(this.a, this.b, this.aa, this.L, i);
    }

    @NotNull
    public static U a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new U(friendlyByteBuf.readVec3(), friendlyByteBuf.readVec3(), friendlyByteBuf.readInt(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readInt());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m162a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVec3(this.a);
        friendlyByteBuf.writeVec3(this.b);
        friendlyByteBuf.writeInt(this.aa);
        friendlyByteBuf.writeBoolean(this.L);
        friendlyByteBuf.writeInt(this.ab);
    }

    public boolean k() {
        int i = this.Z;
        this.Z = i - 1;
        return i <= 0;
    }

    public float b() {
        if (this.L) {
            return this.Z / this.aa;
        }
        return 1.0f;
    }

    @NotNull
    public Vec3 a() {
        return this.a;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public Vec3 m163b() {
        return this.b;
    }

    public int getColor() {
        return this.ab;
    }
}
