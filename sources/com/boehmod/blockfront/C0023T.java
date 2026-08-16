package com.boehmod.blockfront;

import net.minecraft.world.level.levelgen.structure.BoundingBox;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.T */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/T.class */
public class C0023T implements InterfaceC0024U {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC0024U f244a = new C0023T().m123b(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: aD */
    public int f245aD;

    /* JADX INFO: renamed from: aE */
    public int f246aE;

    /* JADX INFO: renamed from: aF */
    public int f247aF;

    /* JADX INFO: renamed from: aG */
    public int f248aG;

    /* JADX INFO: renamed from: aH */
    public int f249aH;

    /* JADX INFO: renamed from: aI */
    public int f250aI;

    public C0023T(int i, int i2, int i3, int i4, int i5, int i6) {
        m122a(i, i2, i3, i4, i5, i6);
    }

    public C0023T(@NotNull InterfaceC0024U interfaceC0024U) {
        m121a(interfaceC0024U);
    }

    public C0023T(@NotNull BoundingBox boundingBox) {
        m122a(boundingBox.minX(), boundingBox.minY(), boundingBox.minZ(), boundingBox.maxX(), boundingBox.maxY(), boundingBox.maxZ());
    }

    public C0023T() {
        this(0, 0, 0, 0, 0, 0);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0023T m121a(@NotNull InterfaceC0024U interfaceC0024U) {
        m122a(interfaceC0024U.mo125j(), interfaceC0024U.mo126k(), interfaceC0024U.mo127l(), interfaceC0024U.mo128m(), interfaceC0024U.mo129n(), interfaceC0024U.mo130o());
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0023T m122a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f245aD = Math.min(i, i4);
        this.f246aE = Math.min(i2, i5);
        this.f247aF = Math.min(i3, i6);
        this.f248aG = Math.max(i, i4);
        this.f249aH = Math.max(i2, i5);
        this.f250aI = Math.max(i3, i6);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0023T m123b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f245aD = i;
        this.f246aE = i2;
        this.f247aF = i3;
        this.f248aG = i4;
        this.f249aH = i5;
        this.f250aI = i6;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0023T m124b(@NotNull InterfaceC0024U interfaceC0024U) {
        this.f245aD = interfaceC0024U.mo125j();
        this.f246aE = interfaceC0024U.mo126k();
        this.f247aF = interfaceC0024U.mo127l();
        this.f248aG = interfaceC0024U.mo128m();
        this.f249aH = interfaceC0024U.mo129n();
        this.f250aI = interfaceC0024U.mo130o();
        return this;
    }

    @Override // com.boehmod.blockfront.InterfaceC0024U
    /* JADX INFO: renamed from: j */
    public int mo125j() {
        return this.f245aD;
    }

    @Override // com.boehmod.blockfront.InterfaceC0024U
    /* JADX INFO: renamed from: k */
    public int mo126k() {
        return this.f246aE;
    }

    @Override // com.boehmod.blockfront.InterfaceC0024U
    /* JADX INFO: renamed from: l */
    public int mo127l() {
        return this.f247aF;
    }

    @Override // com.boehmod.blockfront.InterfaceC0024U
    /* JADX INFO: renamed from: m */
    public int mo128m() {
        return this.f248aG;
    }

    @Override // com.boehmod.blockfront.InterfaceC0024U
    /* JADX INFO: renamed from: n */
    public int mo129n() {
        return this.f249aH;
    }

    @Override // com.boehmod.blockfront.InterfaceC0024U
    /* JADX INFO: renamed from: o */
    public int mo130o() {
        return this.f250aI;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterfaceC0024U)) {
            return false;
        }
        InterfaceC0024U interfaceC0024U = (InterfaceC0024U) obj;
        return mo125j() == interfaceC0024U.mo125j() && mo126k() == interfaceC0024U.mo126k() && mo127l() == interfaceC0024U.mo127l() && mo128m() == interfaceC0024U.mo128m() && mo129n() == interfaceC0024U.mo129n() && mo130o() == interfaceC0024U.mo130o();
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * this.f245aD) + this.f246aE)) + this.f247aF)) + this.f248aG)) + this.f249aH)) + this.f250aI;
    }
}
