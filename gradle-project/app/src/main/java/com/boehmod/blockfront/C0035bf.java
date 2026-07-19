package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.mm.report.MatchSummary;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bf.class */
public final class C0035bf {
    private static final float co = 0.05f;

    @NotNull
    private final MatchSummary a;
    private final int bm;
    private final int bn;
    private boolean ak;
    private float cp;
    private float cq;

    public C0035bf(@NotNull MatchSummary matchSummary, int i, int i2) {
        this.a = matchSummary;
        this.bm = i;
        this.bn = i2;
    }

    public void x() {
        this.ak = true;
        this.cp = 1.0f;
        this.cq = 1.0f;
    }

    public void tick() {
        this.cq = this.cp;
        this.cp = C0634xm.d(this.cp, 0.0f, 0.05f);
    }

    public boolean m() {
        return this.ak;
    }

    public float f(float f) {
        return C0634xm.e(this.cp, this.cq, f);
    }

    public int n() {
        return this.bm;
    }

    public int o() {
        return this.bn;
    }

    @NotNull
    public MatchSummary a() {
        return this.a;
    }
}
