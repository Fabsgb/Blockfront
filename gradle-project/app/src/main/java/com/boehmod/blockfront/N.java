package com.boehmod.blockfront;

import net.minecraft.world.level.levelgen.structure.BoundingBox;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/N.class */
public class N implements O {
    public static final O a = new N().b(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;

    public N(int i, int i2, int i3, int i4, int i5, int i6) {
        a(i, i2, i3, i4, i5, i6);
    }

    public N(@NotNull O o) {
        a(o);
    }

    public N(@NotNull BoundingBox boundingBox) {
        a(boundingBox.minX(), boundingBox.minY(), boundingBox.minZ(), boundingBox.maxX(), boundingBox.maxY(), boundingBox.maxZ());
    }

    public N() {
        this(0, 0, 0, 0, 0, 0);
    }

    @NotNull
    public N a(@NotNull O o) {
        a(o.f(), o.g(), o.h(), o.i(), o.j(), o.k());
        return this;
    }

    @NotNull
    public N a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.P = Math.min(i, i4);
        this.Q = Math.min(i2, i5);
        this.R = Math.min(i3, i6);
        this.S = Math.max(i, i4);
        this.T = Math.max(i2, i5);
        this.U = Math.max(i3, i6);
        return this;
    }

    @NotNull
    public N b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.P = i;
        this.Q = i2;
        this.R = i3;
        this.S = i4;
        this.T = i5;
        this.U = i6;
        return this;
    }

    @NotNull
    public N b(@NotNull O o) {
        this.P = o.f();
        this.Q = o.g();
        this.R = o.h();
        this.S = o.i();
        this.T = o.j();
        this.U = o.k();
        return this;
    }

    @Override // com.boehmod.blockfront.O
    public int f() {
        return this.P;
    }

    @Override // com.boehmod.blockfront.O
    public int g() {
        return this.Q;
    }

    @Override // com.boehmod.blockfront.O
    public int h() {
        return this.R;
    }

    @Override // com.boehmod.blockfront.O
    public int i() {
        return this.S;
    }

    @Override // com.boehmod.blockfront.O
    public int j() {
        return this.T;
    }

    @Override // com.boehmod.blockfront.O
    public int k() {
        return this.U;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof O)) {
            return false;
        }
        O o = (O) obj;
        return f() == o.f() && g() == o.g() && h() == o.h() && i() == o.i() && j() == o.j() && k() == o.k();
    }
}
