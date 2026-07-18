package com.boehmod.blockfront;

import net.minecraft.world.level.levelgen.structure.BoundingBox;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3i;
import org.joml.Vector3ic;

/* JADX INFO: renamed from: com.boehmod.blockfront.O */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/O.class */
public interface InterfaceC0017O {
    /* JADX INFO: renamed from: f */
    int mo92f();

    /* JADX INFO: renamed from: g */
    int mo93g();

    /* JADX INFO: renamed from: h */
    int mo94h();

    /* JADX INFO: renamed from: i */
    int mo95i();

    /* JADX INFO: renamed from: j */
    int mo96j();

    /* JADX INFO: renamed from: k */
    int mo97k();

    /* JADX INFO: renamed from: a */
    default boolean m98a(@NotNull InterfaceC0017O interfaceC0017O) {
        return m100a(interfaceC0017O.mo92f(), interfaceC0017O.mo93g(), interfaceC0017O.mo94h(), interfaceC0017O.mo95i(), interfaceC0017O.mo96j(), interfaceC0017O.mo97k());
    }

    /* JADX INFO: renamed from: a */
    default boolean m99a(@NotNull BoundingBox boundingBox) {
        return m100a(boundingBox.minX(), boundingBox.minY(), boundingBox.minZ(), boundingBox.maxX(), boundingBox.maxY(), boundingBox.maxZ());
    }

    /* JADX INFO: renamed from: a */
    default boolean m100a(int i, int i2, int i3, int i4, int i5, int i6) {
        return mo95i() >= i && mo96j() >= i2 && mo97k() >= i3 && mo92f() <= i4 && mo93g() <= i5 && mo94h() <= i6;
    }

    /* JADX INFO: renamed from: a */
    default boolean m101a(@NotNull Vector3ic vector3ic) {
        return m102a(vector3ic.x(), vector3ic.y(), vector3ic.z());
    }

    /* JADX INFO: renamed from: a */
    default boolean m102a(int i, int i2, int i3) {
        return i >= mo92f() && i <= mo95i() && i2 >= mo93g() && i2 <= mo96j() && i3 >= mo94h() && i3 <= mo97k();
    }

    /* JADX INFO: renamed from: a */
    default C0016N m103a(@NotNull Vector3ic vector3ic, @NotNull C0016N c0016n) {
        return m104a(vector3ic.x(), vector3ic.y(), vector3ic.z(), c0016n);
    }

    /* JADX INFO: renamed from: a */
    default C0016N m104a(int i, int i2, int i3, @NotNull C0016N c0016n) {
        c0016n.m88a(this);
        c0016n.f205S = Math.max(c0016n.f205S, i);
        c0016n.f206T = Math.max(c0016n.f206T, i2);
        c0016n.f207U = Math.max(c0016n.f207U, i3);
        c0016n.f202P = Math.min(c0016n.f202P, i);
        c0016n.f203Q = Math.min(c0016n.f203Q, i2);
        c0016n.f204R = Math.min(c0016n.f204R, i3);
        return c0016n;
    }

    /* JADX INFO: renamed from: a */
    default C0016N m105a(@NotNull InterfaceC0017O interfaceC0017O, @NotNull C0016N c0016n) {
        c0016n.m88a(this);
        c0016n.f205S = Math.max(c0016n.f205S, interfaceC0017O.mo95i());
        c0016n.f206T = Math.max(c0016n.f206T, interfaceC0017O.mo96j());
        c0016n.f207U = Math.max(c0016n.f207U, interfaceC0017O.mo97k());
        c0016n.f202P = Math.min(c0016n.f202P, interfaceC0017O.mo92f());
        c0016n.f203Q = Math.min(c0016n.f203Q, interfaceC0017O.mo93g());
        c0016n.f204R = Math.min(c0016n.f204R, interfaceC0017O.mo94h());
        return c0016n;
    }

    /* JADX INFO: renamed from: b */
    default C0016N m106b(@NotNull Vector3ic vector3ic, @NotNull C0016N c0016n) {
        return m107b(vector3ic.x(), vector3ic.y(), vector3ic.z(), c0016n);
    }

    /* JADX INFO: renamed from: b */
    default C0016N m107b(int i, int i2, int i3, @NotNull C0016N c0016n) {
        c0016n.m88a(this);
        c0016n.f202P += i;
        c0016n.f203Q += i2;
        c0016n.f204R += i3;
        c0016n.f205S += i;
        c0016n.f206T += i2;
        c0016n.f207U += i3;
        return c0016n;
    }

    /* JADX INFO: renamed from: a */
    default Vector3ic m108a(@NotNull Vector3i vector3i) {
        return vector3i.set((mo92f() + mo95i()) / 2, (mo93g() + mo96j()) / 2, (mo94h() + mo97k()) / 2);
    }

    /* JADX INFO: renamed from: b */
    default Vector3ic m109b(@NotNull Vector3i vector3i) {
        return vector3i.set(mo95i() - mo92f(), mo96j() - mo93g(), mo97k() - mo94h());
    }

    /* JADX INFO: renamed from: l */
    default int m110l() {
        return (mo95i() - mo92f()) * (mo96j() - mo93g()) * (mo97k() - mo94h());
    }
}
