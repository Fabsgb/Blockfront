package com.boehmod.blockfront;

import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4d;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.S */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/S.class */
public interface InterfaceC0022S {
    /* JADX INFO: renamed from: d */
    double mo101d();

    /* JADX INFO: renamed from: e */
    double mo102e();

    /* JADX INFO: renamed from: f */
    double mo103f();

    /* JADX INFO: renamed from: g */
    double mo104g();

    /* JADX INFO: renamed from: h */
    double mo105h();

    /* JADX INFO: renamed from: i */
    double mo106i();

    /* JADX INFO: renamed from: a */
    default boolean m107a(@NotNull InterfaceC0022S interfaceC0022S) {
        return m109a(interfaceC0022S.mo101d(), interfaceC0022S.mo102e(), interfaceC0022S.mo103f(), interfaceC0022S.mo104g(), interfaceC0022S.mo105h(), interfaceC0022S.mo106i());
    }

    /* JADX INFO: renamed from: a */
    default boolean m108a(@NotNull AABB aabb) {
        return m109a(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
    }

    /* JADX INFO: renamed from: a */
    default boolean m109a(double d, double d2, double d3, double d4, double d5, double d6) {
        return mo104g() >= d && mo105h() >= d2 && mo106i() >= d3 && mo101d() <= d4 && mo102e() <= d5 && mo103f() <= d6;
    }

    /* JADX INFO: renamed from: a */
    default boolean m110a(@NotNull Vector3dc vector3dc) {
        return m111a(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    /* JADX INFO: renamed from: a */
    default boolean m111a(double d, double d2, double d3) {
        return d >= mo101d() && d <= mo104g() && d2 >= mo102e() && d2 <= mo105h() && d3 >= mo103f() && d3 <= mo106i();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    default C0021R m112a(@NotNull Vector3dc vector3dc, @NotNull C0021R c0021r) {
        return m113a(vector3dc.x(), vector3dc.y(), vector3dc.z(), c0021r);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    default C0021R m113a(double d, double d2, double d3, @NotNull C0021R c0021r) {
        c0021r.m100b(this);
        c0021r.f241y = Math.max(c0021r.f241y, d);
        c0021r.f242z = Math.max(c0021r.f242z, d2);
        c0021r.f243A = Math.max(c0021r.f243A, d3);
        c0021r.f238v = Math.min(c0021r.f238v, d);
        c0021r.f239w = Math.min(c0021r.f239w, d2);
        c0021r.f240x = Math.min(c0021r.f240x, d3);
        return c0021r;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    default C0021R m114a(@NotNull InterfaceC0022S interfaceC0022S, @NotNull C0021R c0021r) {
        c0021r.m100b(this);
        c0021r.f241y = Math.max(c0021r.f241y, interfaceC0022S.mo104g());
        c0021r.f242z = Math.max(c0021r.f242z, interfaceC0022S.mo105h());
        c0021r.f243A = Math.max(c0021r.f243A, interfaceC0022S.mo106i());
        c0021r.f238v = Math.min(c0021r.f238v, interfaceC0022S.mo101d());
        c0021r.f239w = Math.min(c0021r.f239w, interfaceC0022S.mo102e());
        c0021r.f240x = Math.min(c0021r.f240x, interfaceC0022S.mo103f());
        return c0021r;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    default C0021R m115a(double d, @NotNull C0021R c0021r) {
        c0021r.m99b(mo101d() - d, mo102e() - d, mo103f() - d, mo104g() + d, mo105h() + d, mo106i() + d);
        return c0021r;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    default C0021R m116a(@NotNull InterfaceC0026W interfaceC0026W, @NotNull C0021R c0021r) {
        Matrix4d matrix4dM162a = interfaceC0026W.m162a(new Matrix4d());
        Vector3dc[] vector3dcArr = {new Vector3d(mo101d(), mo102e(), mo103f()), new Vector3d(mo101d(), mo102e(), mo106i()), new Vector3d(mo101d(), mo105h(), mo103f()), new Vector3d(mo101d(), mo105h(), mo106i()), new Vector3d(mo104g(), mo102e(), mo103f()), new Vector3d(mo104g(), mo102e(), mo106i()), new Vector3d(mo104g(), mo105h(), mo103f()), new Vector3d(mo104g(), mo105h(), mo106i())};
        c0021r.m99b(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        Vector3d vector3d = new Vector3d();
        for (Vector3dc vector3dc : vector3dcArr) {
            matrix4dM162a.transformPosition(vector3dc, vector3d);
            c0021r.m112a((Vector3dc) vector3d, c0021r);
        }
        return c0021r;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    default Vector3d m117a(@NotNull Vector3d vector3d) {
        return vector3d.set((mo101d() + mo104g()) / 2.0d, (mo102e() + mo105h()) / 2.0d, (mo103f() + mo106i()) / 2.0d);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    default Vector3d m118b(@NotNull Vector3d vector3d) {
        return vector3d.set(mo104g() - mo101d(), mo105h() - mo102e(), mo106i() - mo103f());
    }

    /* JADX INFO: renamed from: j */
    default double m119j() {
        return (mo104g() - mo101d()) * (mo105h() - mo102e()) * (mo106i() - mo103f());
    }

    @Contract(" -> new")
    /* JADX INFO: renamed from: a */
    default AABB m120a() {
        return new AABB(mo101d(), mo102e(), mo103f(), mo104g(), mo105h(), mo106i());
    }
}
