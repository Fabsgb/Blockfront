package com.boehmod.blockfront;

import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4d;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.M */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/M.class */
public interface InterfaceC0015M {
    /* JADX INFO: renamed from: b */
    double mo68b();

    /* JADX INFO: renamed from: c */
    double mo69c();

    /* JADX INFO: renamed from: d */
    double mo70d();

    /* JADX INFO: renamed from: e */
    double mo71e();

    /* JADX INFO: renamed from: f */
    double mo72f();

    /* JADX INFO: renamed from: g */
    double mo73g();

    /* JADX INFO: renamed from: a */
    default boolean m74a(@NotNull InterfaceC0015M interfaceC0015M) {
        return m76a(interfaceC0015M.mo68b(), interfaceC0015M.mo69c(), interfaceC0015M.mo70d(), interfaceC0015M.mo71e(), interfaceC0015M.mo72f(), interfaceC0015M.mo73g());
    }

    /* JADX INFO: renamed from: a */
    default boolean m75a(@NotNull AABB aabb) {
        return m76a(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
    }

    /* JADX INFO: renamed from: a */
    default boolean m76a(double d, double d2, double d3, double d4, double d5, double d6) {
        return mo71e() >= d && mo72f() >= d2 && mo73g() >= d3 && mo68b() <= d4 && mo69c() <= d5 && mo70d() <= d6;
    }

    /* JADX INFO: renamed from: a */
    default boolean m77a(@NotNull Vector3dc vector3dc) {
        return m78a(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    /* JADX INFO: renamed from: a */
    default boolean m78a(double d, double d2, double d3) {
        return d >= mo68b() && d <= mo71e() && d2 >= mo69c() && d2 <= mo72f() && d3 >= mo70d() && d3 <= mo73g();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    default C0014L m79a(@NotNull Vector3dc vector3dc, @NotNull C0014L c0014l) {
        return m80a(vector3dc.x(), vector3dc.y(), vector3dc.z(), c0014l);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    default C0014L m80a(double d, double d2, double d3, @NotNull C0014L c0014l) {
        c0014l.m67b(this);
        c0014l.f198r = Math.max(c0014l.f198r, d);
        c0014l.f199s = Math.max(c0014l.f199s, d2);
        c0014l.f200t = Math.max(c0014l.f200t, d3);
        c0014l.f195o = Math.min(c0014l.f195o, d);
        c0014l.f196p = Math.min(c0014l.f196p, d2);
        c0014l.f197q = Math.min(c0014l.f197q, d3);
        return c0014l;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    default C0014L m81a(@NotNull InterfaceC0015M interfaceC0015M, @NotNull C0014L c0014l) {
        c0014l.m67b(this);
        c0014l.f198r = Math.max(c0014l.f198r, interfaceC0015M.mo71e());
        c0014l.f199s = Math.max(c0014l.f199s, interfaceC0015M.mo72f());
        c0014l.f200t = Math.max(c0014l.f200t, interfaceC0015M.mo73g());
        c0014l.f195o = Math.min(c0014l.f195o, interfaceC0015M.mo68b());
        c0014l.f196p = Math.min(c0014l.f196p, interfaceC0015M.mo69c());
        c0014l.f197q = Math.min(c0014l.f197q, interfaceC0015M.mo70d());
        return c0014l;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    default C0014L m82a(double d, @NotNull C0014L c0014l) {
        c0014l.m66b(mo68b() - d, mo69c() - d, mo70d() - d, mo71e() + d, mo72f() + d, mo73g() + d);
        return c0014l;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    default C0014L m83a(@NotNull InterfaceC0019Q interfaceC0019Q, @NotNull C0014L c0014l) {
        Matrix4d matrix4dM129a = interfaceC0019Q.m129a(new Matrix4d());
        Vector3dc[] vector3dcArr = {new Vector3d(mo68b(), mo69c(), mo70d()), new Vector3d(mo68b(), mo69c(), mo73g()), new Vector3d(mo68b(), mo72f(), mo70d()), new Vector3d(mo68b(), mo72f(), mo73g()), new Vector3d(mo71e(), mo69c(), mo70d()), new Vector3d(mo71e(), mo69c(), mo73g()), new Vector3d(mo71e(), mo72f(), mo70d()), new Vector3d(mo71e(), mo72f(), mo73g())};
        c0014l.m66b(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        Vector3d vector3d = new Vector3d();
        for (Vector3dc vector3dc : vector3dcArr) {
            matrix4dM129a.transformPosition(vector3dc, vector3d);
            c0014l.m79a((Vector3dc) vector3d, c0014l);
        }
        return c0014l;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    default Vector3d m84a(@NotNull Vector3d vector3d) {
        return vector3d.set((mo68b() + mo71e()) / 2.0d, (mo69c() + mo72f()) / 2.0d, (mo70d() + mo73g()) / 2.0d);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    default Vector3d m85b(@NotNull Vector3d vector3d) {
        return vector3d.set(mo71e() - mo68b(), mo72f() - mo69c(), mo73g() - mo70d());
    }

    /* JADX INFO: renamed from: h */
    default double m86h() {
        return (mo71e() - mo68b()) * (mo72f() - mo69c()) * (mo73g() - mo70d());
    }

    @Contract(" -> new")
    /* JADX INFO: renamed from: a */
    default AABB m87a() {
        return new AABB(mo68b(), mo69c(), mo70d(), mo71e(), mo72f(), mo73g());
    }
}
