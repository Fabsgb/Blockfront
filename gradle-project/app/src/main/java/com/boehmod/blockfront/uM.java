package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uM.class */
public class uM {
    private float nz = 6.0f;
    private float nA = 1.0f;
    private float nB = 16.0f;
    private float nC = 0.5f;
    private int Y = ColorReferences.COLOR_BULLET_TRACER;
    private boolean iA = false;
    private int sq = 2;

    public float bD() {
        return this.nz;
    }

    @NotNull
    public uM a(float f) {
        this.nz = f;
        return this;
    }

    public float bE() {
        return this.nA;
    }

    @NotNull
    public uM b(float f) {
        this.nA = f;
        return this;
    }

    public float bF() {
        return this.nB;
    }

    @NotNull
    public uM c(float f) {
        this.nB = f;
        return this;
    }

    public float bG() {
        return this.nC;
    }

    @NotNull
    public uM d(float f) {
        this.nC = f;
        return this;
    }

    public int getColor() {
        return this.Y;
    }

    @NotNull
    public uM a(int i) {
        this.Y = i;
        return this;
    }

    public boolean cJ() {
        return this.iA;
    }

    @NotNull
    public uM a(boolean z) {
        this.iA = z;
        return this;
    }

    public int ce() {
        return this.sq;
    }

    @NotNull
    public uM b(int i) {
        this.sq = i;
        return this;
    }
}
