package com.boehmod.blockfront;

import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4d;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/M.class */
public interface M {
    double b();

    double c();

    double d();

    double e();

    double f();

    double g();

    default boolean a(@NotNull M m) {
        return a(m.b(), m.c(), m.d(), m.e(), m.f(), m.g());
    }

    default boolean a(@NotNull AABB aabb) {
        return a(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
    }

    default boolean a(double d, double d2, double d3, double d4, double d5, double d6) {
        return e() >= d && f() >= d2 && g() >= d3 && b() <= d4 && c() <= d5 && d() <= d6;
    }

    default boolean a(@NotNull Vector3dc vector3dc) {
        return a(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    default boolean a(double d, double d2, double d3) {
        return d >= b() && d <= e() && d2 >= c() && d2 <= f() && d3 >= d() && d3 <= g();
    }

    @NotNull
    default L a(@NotNull Vector3dc vector3dc, @NotNull L l) {
        return a(vector3dc.x(), vector3dc.y(), vector3dc.z(), l);
    }

    @NotNull
    default L a(double d, double d2, double d3, @NotNull L l) {
        l.b(this);
        l.r = Math.max(l.r, d);
        l.s = Math.max(l.s, d2);
        l.t = Math.max(l.t, d3);
        l.o = Math.min(l.o, d);
        l.p = Math.min(l.p, d2);
        l.q = Math.min(l.q, d3);
        return l;
    }

    @NotNull
    default L a(@NotNull M m, @NotNull L l) {
        l.b(this);
        l.r = Math.max(l.r, m.e());
        l.s = Math.max(l.s, m.f());
        l.t = Math.max(l.t, m.g());
        l.o = Math.min(l.o, m.b());
        l.p = Math.min(l.p, m.c());
        l.q = Math.min(l.q, m.d());
        return l;
    }

    @NotNull
    default L a(double d, @NotNull L l) {
        l.b(b() - d, c() - d, d() - d, e() + d, f() + d, g() + d);
        return l;
    }

    @NotNull
    default L a(@NotNull Q q, @NotNull L l) {
        Matrix4d matrix4dA = q.a(new Matrix4d());
        Vector3dc[] vector3dcArr = {new Vector3d(b(), c(), d()), new Vector3d(b(), c(), g()), new Vector3d(b(), f(), d()), new Vector3d(b(), f(), g()), new Vector3d(e(), c(), d()), new Vector3d(e(), c(), g()), new Vector3d(e(), f(), d()), new Vector3d(e(), f(), g())};
        l.b(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        Vector3d vector3d = new Vector3d();
        for (Vector3dc vector3dc : vector3dcArr) {
            matrix4dA.transformPosition(vector3dc, vector3d);
            l.a((Vector3dc) vector3d, l);
        }
        return l;
    }

    @NotNull
    default Vector3d a(@NotNull Vector3d vector3d) {
        return vector3d.set((b() + e()) / 2.0d, (c() + f()) / 2.0d, (d() + g()) / 2.0d);
    }

    @NotNull
    default Vector3d b(@NotNull Vector3d vector3d) {
        return vector3d.set(e() - b(), f() - c(), g() - d());
    }

    default double h() {
        return (e() - b()) * (f() - c()) * (g() - d());
    }

    @Contract(" -> new")
    default AABB a() {
        return new AABB(b(), c(), d(), e(), f(), g());
    }
}
