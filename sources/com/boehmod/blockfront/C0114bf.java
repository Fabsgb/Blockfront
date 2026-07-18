package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000mm.report.MatchSummary;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bf.class */
public final class C0114bf {

    /* JADX INFO: renamed from: co */
    private static final float f683co = 0.05f;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final MatchSummary f684a;

    /* JADX INFO: renamed from: bm */
    private final int f685bm;

    /* JADX INFO: renamed from: bn */
    private final int f686bn;

    /* JADX INFO: renamed from: ak */
    private boolean f687ak;

    /* JADX INFO: renamed from: cp */
    private float f688cp;

    /* JADX INFO: renamed from: cq */
    private float f689cq;

    public C0114bf(@NotNull MatchSummary matchSummary, int i, int i2) {
        this.f684a = matchSummary;
        this.f685bm = i;
        this.f686bn = i2;
    }

    /* JADX INFO: renamed from: x */
    public void m338x() {
        this.f687ak = true;
        this.f688cp = 1.0f;
        this.f689cq = 1.0f;
    }

    public void tick() {
        this.f689cq = this.f688cp;
        this.f688cp = C1290xm.m7835d(this.f688cp, 0.0f, 0.05f);
    }

    /* JADX INFO: renamed from: m */
    public boolean m339m() {
        return this.f687ak;
    }

    /* JADX INFO: renamed from: f */
    public float m340f(float f) {
        return C1290xm.m7843e(this.f688cp, this.f689cq, f);
    }

    /* JADX INFO: renamed from: n */
    public int m341n() {
        return this.f685bm;
    }

    /* JADX INFO: renamed from: o */
    public int m342o() {
        return this.f686bn;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public MatchSummary m343a() {
        return this.f684a;
    }
}
