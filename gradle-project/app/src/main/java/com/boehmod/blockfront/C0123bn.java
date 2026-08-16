package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p001mm.report.MatchSummary;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bn.class */
public final class C0123bn {

    /* JADX INFO: renamed from: cu */
    private static final float f814cu = 0.05f;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final MatchSummary f815a;

    /* JADX INFO: renamed from: cc */
    private final int f816cc;

    /* JADX INFO: renamed from: cd */
    private final int f817cd;

    /* JADX INFO: renamed from: ap */
    private boolean f818ap;

    /* JADX INFO: renamed from: cv */
    private float f819cv;

    /* JADX INFO: renamed from: cw */
    private float f820cw;

    public C0123bn(@NotNull MatchSummary matchSummary, int i, int i2) {
        this.f815a = matchSummary;
        this.f816cc = i;
        this.f817cd = i2;
    }

    /* JADX INFO: renamed from: A */
    public void m431A() {
        this.f818ap = true;
        this.f819cv = 1.0f;
        this.f820cw = 1.0f;
    }

    public void tick() {
        this.f820cw = this.f819cv;
        this.f819cv = C1270xJ.m7161d(this.f819cv, 0.0f, 0.05f);
    }

    /* JADX INFO: renamed from: n */
    public boolean m432n() {
        return this.f818ap;
    }

    /* JADX INFO: renamed from: f */
    public float m433f(float f) {
        return C1270xJ.m7170f(this.f819cv, this.f820cw, f);
    }

    /* JADX INFO: renamed from: r */
    public int m434r() {
        return this.f816cc;
    }

    /* JADX INFO: renamed from: s */
    public int m435s() {
        return this.f817cd;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public MatchSummary m436a() {
        return this.f815a;
    }
}
