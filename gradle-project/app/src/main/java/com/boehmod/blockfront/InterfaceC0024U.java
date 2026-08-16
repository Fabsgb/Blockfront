package com.boehmod.blockfront;

import net.minecraft.world.level.levelgen.structure.BoundingBox;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3i;
import org.joml.Vector3ic;

/* JADX INFO: renamed from: com.boehmod.blockfront.U */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/U.class */
public interface InterfaceC0024U {
    /* JADX INFO: renamed from: j */
    int mo125j();

    /* JADX INFO: renamed from: k */
    int mo126k();

    /* JADX INFO: renamed from: l */
    int mo127l();

    /* JADX INFO: renamed from: m */
    int mo128m();

    /* JADX INFO: renamed from: n */
    int mo129n();

    /* JADX INFO: renamed from: o */
    int mo130o();

    /* JADX INFO: renamed from: a */
    default boolean m131a(@NotNull InterfaceC0024U interfaceC0024U) {
        return m133a(interfaceC0024U.mo125j(), interfaceC0024U.mo126k(), interfaceC0024U.mo127l(), interfaceC0024U.mo128m(), interfaceC0024U.mo129n(), interfaceC0024U.mo130o());
    }

    /* JADX INFO: renamed from: a */
    default boolean m132a(@NotNull BoundingBox boundingBox) {
        return m133a(boundingBox.minX(), boundingBox.minY(), boundingBox.minZ(), boundingBox.maxX(), boundingBox.maxY(), boundingBox.maxZ());
    }

    /* JADX INFO: renamed from: a */
    default boolean m133a(int i, int i2, int i3, int i4, int i5, int i6) {
        return mo128m() >= i && mo129n() >= i2 && mo130o() >= i3 && mo125j() <= i4 && mo126k() <= i5 && mo127l() <= i6;
    }

    /* JADX INFO: renamed from: a */
    default boolean m134a(@NotNull Vector3ic vector3ic) {
        return m135a(vector3ic.x(), vector3ic.y(), vector3ic.z());
    }

    /* JADX INFO: renamed from: a */
    default boolean m135a(int i, int i2, int i3) {
        return i >= mo125j() && i <= mo128m() && i2 >= mo126k() && i2 <= mo129n() && i3 >= mo127l() && i3 <= mo130o();
    }

    /* JADX INFO: renamed from: a */
    default C0023T m136a(@NotNull Vector3ic vector3ic, @NotNull C0023T c0023t) {
        return m137a(vector3ic.x(), vector3ic.y(), vector3ic.z(), c0023t);
    }

    /* JADX INFO: renamed from: a */
    default C0023T m137a(int i, int i2, int i3, @NotNull C0023T c0023t) {
        c0023t.m121a(this);
        c0023t.f248aG = Math.max(c0023t.f248aG, i);
        c0023t.f249aH = Math.max(c0023t.f249aH, i2);
        c0023t.f250aI = Math.max(c0023t.f250aI, i3);
        c0023t.f245aD = Math.min(c0023t.f245aD, i);
        c0023t.f246aE = Math.min(c0023t.f246aE, i2);
        c0023t.f247aF = Math.min(c0023t.f247aF, i3);
        return c0023t;
    }

    /* JADX INFO: renamed from: a */
    default C0023T m138a(@NotNull InterfaceC0024U interfaceC0024U, @NotNull C0023T c0023t) {
        c0023t.m121a(this);
        c0023t.f248aG = Math.max(c0023t.f248aG, interfaceC0024U.mo128m());
        c0023t.f249aH = Math.max(c0023t.f249aH, interfaceC0024U.mo129n());
        c0023t.f250aI = Math.max(c0023t.f250aI, interfaceC0024U.mo130o());
        c0023t.f245aD = Math.min(c0023t.f245aD, interfaceC0024U.mo125j());
        c0023t.f246aE = Math.min(c0023t.f246aE, interfaceC0024U.mo126k());
        c0023t.f247aF = Math.min(c0023t.f247aF, interfaceC0024U.mo127l());
        return c0023t;
    }

    /* JADX INFO: renamed from: b */
    default C0023T m139b(@NotNull Vector3ic vector3ic, @NotNull C0023T c0023t) {
        return m140b(vector3ic.x(), vector3ic.y(), vector3ic.z(), c0023t);
    }

    /* JADX INFO: renamed from: b */
    default C0023T m140b(int i, int i2, int i3, @NotNull C0023T c0023t) {
        c0023t.m121a(this);
        c0023t.f245aD += i;
        c0023t.f246aE += i2;
        c0023t.f247aF += i3;
        c0023t.f248aG += i;
        c0023t.f249aH += i2;
        c0023t.f250aI += i3;
        return c0023t;
    }

    /* JADX INFO: renamed from: a */
    default Vector3ic m141a(@NotNull Vector3i vector3i) {
        return vector3i.set((mo125j() + mo128m()) / 2, (mo126k() + mo129n()) / 2, (mo127l() + mo130o()) / 2);
    }

    /* JADX INFO: renamed from: b */
    default Vector3ic m142b(@NotNull Vector3i vector3i) {
        return vector3i.set(mo128m() - mo125j(), mo129n() - mo126k(), mo130o() - mo127l());
    }

    /* JADX INFO: renamed from: p */
    default int m143p() {
        return (mo128m() - mo125j()) * (mo129n() - mo126k()) * (mo130o() - mo127l());
    }
}
