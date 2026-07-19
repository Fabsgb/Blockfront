package com.boehmod.blockfront;

import net.minecraft.world.level.levelgen.structure.BoundingBox;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3i;
import org.joml.Vector3ic;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/O.class */
public interface O {
    int f();

    int g();

    int h();

    int i();

    int j();

    int k();

    default boolean a(@NotNull O o) {
        return a(o.f(), o.g(), o.h(), o.i(), o.j(), o.k());
    }

    default boolean a(@NotNull BoundingBox boundingBox) {
        return a(boundingBox.minX(), boundingBox.minY(), boundingBox.minZ(), boundingBox.maxX(), boundingBox.maxY(), boundingBox.maxZ());
    }

    default boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
        return i() >= i && j() >= i2 && k() >= i3 && f() <= i4 && g() <= i5 && h() <= i6;
    }

    default boolean a(@NotNull Vector3ic vector3ic) {
        return a(vector3ic.x(), vector3ic.y(), vector3ic.z());
    }

    default boolean a(int i, int i2, int i3) {
        return i >= f() && i <= i() && i2 >= g() && i2 <= j() && i3 >= h() && i3 <= k();
    }

    default N a(@NotNull Vector3ic vector3ic, @NotNull N n) {
        return a(vector3ic.x(), vector3ic.y(), vector3ic.z(), n);
    }

    default N a(int i, int i2, int i3, @NotNull N n) {
        n.a(this);
        n.S = Math.max(n.S, i);
        n.T = Math.max(n.T, i2);
        n.U = Math.max(n.U, i3);
        n.P = Math.min(n.P, i);
        n.Q = Math.min(n.Q, i2);
        n.R = Math.min(n.R, i3);
        return n;
    }

    default N a(@NotNull O o, @NotNull N n) {
        n.a(this);
        n.S = Math.max(n.S, o.i());
        n.T = Math.max(n.T, o.j());
        n.U = Math.max(n.U, o.k());
        n.P = Math.min(n.P, o.f());
        n.Q = Math.min(n.Q, o.g());
        n.R = Math.min(n.R, o.h());
        return n;
    }

    default N b(@NotNull Vector3ic vector3ic, @NotNull N n) {
        return b(vector3ic.x(), vector3ic.y(), vector3ic.z(), n);
    }

    default N b(int i, int i2, int i3, @NotNull N n) {
        n.a(this);
        n.P += i;
        n.Q += i2;
        n.R += i3;
        n.S += i;
        n.T += i2;
        n.U += i3;
        return n;
    }

    default Vector3ic a(@NotNull Vector3i vector3i) {
        return vector3i.set((f() + i()) / 2, (g() + j()) / 2, (h() + k()) / 2);
    }

    default Vector3ic b(@NotNull Vector3i vector3i) {
        return vector3i.set(i() - f(), j() - g(), k() - h());
    }

    default int l() {
        return (i() - f()) * (j() - g()) * (k() - h());
    }
}
