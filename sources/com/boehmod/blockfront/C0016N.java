package com.boehmod.blockfront;

import net.minecraft.world.level.levelgen.structure.BoundingBox;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.N */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/N.class */
public class C0016N implements InterfaceC0017O {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC0017O f201a = new C0016N().m90b(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: P */
    public int f202P;

    /* JADX INFO: renamed from: Q */
    public int f203Q;

    /* JADX INFO: renamed from: R */
    public int f204R;

    /* JADX INFO: renamed from: S */
    public int f205S;

    /* JADX INFO: renamed from: T */
    public int f206T;

    /* JADX INFO: renamed from: U */
    public int f207U;

    public C0016N(int i, int i2, int i3, int i4, int i5, int i6) {
        m89a(i, i2, i3, i4, i5, i6);
    }

    public C0016N(@NotNull InterfaceC0017O interfaceC0017O) {
        m88a(interfaceC0017O);
    }

    public C0016N(@NotNull BoundingBox boundingBox) {
        m89a(boundingBox.minX(), boundingBox.minY(), boundingBox.minZ(), boundingBox.maxX(), boundingBox.maxY(), boundingBox.maxZ());
    }

    public C0016N() {
        this(0, 0, 0, 0, 0, 0);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0016N m88a(@NotNull InterfaceC0017O interfaceC0017O) {
        m89a(interfaceC0017O.mo92f(), interfaceC0017O.mo93g(), interfaceC0017O.mo94h(), interfaceC0017O.mo95i(), interfaceC0017O.mo96j(), interfaceC0017O.mo97k());
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0016N m89a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f202P = Math.min(i, i4);
        this.f203Q = Math.min(i2, i5);
        this.f204R = Math.min(i3, i6);
        this.f205S = Math.max(i, i4);
        this.f206T = Math.max(i2, i5);
        this.f207U = Math.max(i3, i6);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0016N m90b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f202P = i;
        this.f203Q = i2;
        this.f204R = i3;
        this.f205S = i4;
        this.f206T = i5;
        this.f207U = i6;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0016N m91b(@NotNull InterfaceC0017O interfaceC0017O) {
        this.f202P = interfaceC0017O.mo92f();
        this.f203Q = interfaceC0017O.mo93g();
        this.f204R = interfaceC0017O.mo94h();
        this.f205S = interfaceC0017O.mo95i();
        this.f206T = interfaceC0017O.mo96j();
        this.f207U = interfaceC0017O.mo97k();
        return this;
    }

    @Override // com.boehmod.blockfront.InterfaceC0017O
    /* JADX INFO: renamed from: f */
    public int mo92f() {
        return this.f202P;
    }

    @Override // com.boehmod.blockfront.InterfaceC0017O
    /* JADX INFO: renamed from: g */
    public int mo93g() {
        return this.f203Q;
    }

    @Override // com.boehmod.blockfront.InterfaceC0017O
    /* JADX INFO: renamed from: h */
    public int mo94h() {
        return this.f204R;
    }

    @Override // com.boehmod.blockfront.InterfaceC0017O
    /* JADX INFO: renamed from: i */
    public int mo95i() {
        return this.f205S;
    }

    @Override // com.boehmod.blockfront.InterfaceC0017O
    /* JADX INFO: renamed from: j */
    public int mo96j() {
        return this.f206T;
    }

    @Override // com.boehmod.blockfront.InterfaceC0017O
    /* JADX INFO: renamed from: k */
    public int mo97k() {
        return this.f207U;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterfaceC0017O)) {
            return false;
        }
        InterfaceC0017O interfaceC0017O = (InterfaceC0017O) obj;
        return mo92f() == interfaceC0017O.mo92f() && mo93g() == interfaceC0017O.mo93g() && mo94h() == interfaceC0017O.mo94h() && mo95i() == interfaceC0017O.mo95i() && mo96j() == interfaceC0017O.mo96j() && mo97k() == interfaceC0017O.mo97k();
    }
}
