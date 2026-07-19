package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uR.class */
public class uR implements Cloneable {
    public static final uR b = new uR();

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> aZ = C0624xc.ya;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> ba = null;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bb = null;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bc = null;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bd = null;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> be = null;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bf = null;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bg = C0624xc.uS;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bh = C0624xc.vc;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bi = C0624xc.wl;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bj = C0624xc.wm;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bk = C0624xc.wH;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bl = C0624xc.vL;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bm = C0624xc.vM;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bn = C0624xc.vN;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bo = C0624xc.vS;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bp = C0624xc.vT;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bq = null;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> br = C0624xc.xl;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bs = C0624xc.xz;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bt = C0624xc.vx;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bu = C0624xc.vr;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bv = C0624xc.vy;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bw = null;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bx = null;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> by = null;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bz = null;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bA = null;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bB = null;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bC = C0624xc.CB;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bD = C0624xc.CC;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bE = C0624xc.xG;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bF = C0624xc.uF;
    private float nI = 0.0f;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> bG = null;
    private DeferredHolder<SoundEvent, SoundEvent> bH = null;
    private boolean iC = false;
    private float nJ = 1.0f;
    private int sr = 2;
    private boolean iD = true;

    @NotNull
    public uR a(boolean z) {
        this.iD = z;
        return this;
    }

    public boolean cL() {
        return this.iD;
    }

    @NotNull
    public uR a(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder3, DeferredHolder<SoundEvent, SoundEvent> deferredHolder4, DeferredHolder<SoundEvent, SoundEvent> deferredHolder5) {
        this.bx = deferredHolder;
        this.by = deferredHolder2;
        this.bz = deferredHolder3;
        this.bA = deferredHolder4;
        this.bB = deferredHolder5;
        return this;
    }

    @NotNull
    public uR a(DeferredHolder<SoundEvent, SoundEvent> deferredHolder, boolean z) {
        this.ba = deferredHolder;
        this.iC = z;
        return this;
    }

    @NotNull
    public uR a(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder, boolean z, int i) {
        this.sr = i;
        return a(deferredHolder, z);
    }

    @NotNull
    public uR a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.bc = deferredHolder;
        this.bd = deferredHolder2;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> r() {
        return this.aZ;
    }

    @NotNull
    public uR a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.aZ = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> s() {
        return this.bc;
    }

    public uR b(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        return a(deferredHolder, deferredHolder);
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> t() {
        return this.bd;
    }

    @NotNull
    public uR c(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bd = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> u() {
        return this.be;
    }

    @NotNull
    public uR d(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.be = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> v() {
        return this.bf;
    }

    @NotNull
    public uR e(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bf = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> w() {
        return this.ba;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> x() {
        return this.bb;
    }

    @NotNull
    public uR f(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bb = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> y() {
        return this.bg;
    }

    @NotNull
    public uR g(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bg = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> z() {
        return this.bh;
    }

    @NotNull
    public uR h(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bh = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> A() {
        return this.bi;
    }

    @NotNull
    public uR b(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.bi = deferredHolder;
        this.bj = deferredHolder2;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> B() {
        return this.bj;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> C() {
        return this.bk;
    }

    @NotNull
    public uR i(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bk = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> D() {
        return this.bl;
    }

    @NotNull
    public uR c(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.bl = deferredHolder;
        this.bm = deferredHolder2;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> E() {
        return this.bm;
    }

    @NotNull
    public uR d(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.bn = deferredHolder;
        this.bo = deferredHolder2;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> F() {
        return this.bn;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> G() {
        return this.bo;
    }

    @NotNull
    public uR j(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bp = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> H() {
        return this.bp;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> I() {
        return this.bq;
    }

    @NotNull
    public uR k(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bq = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> J() {
        return this.br;
    }

    @NotNull
    public uR l(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.br = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> K() {
        return this.bs;
    }

    @NotNull
    public uR m(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bs = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> L() {
        return this.bt;
    }

    @NotNull
    public uR n(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bt = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> M() {
        return this.bu;
    }

    @NotNull
    public uR o(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bu = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> N() {
        return this.bv;
    }

    @NotNull
    public uR p(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bv = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> O() {
        return this.bw;
    }

    @NotNull
    public uR q(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bw = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> a(@NotNull ClientLevel clientLevel, BlockPos blockPos, @NotNull BlockState blockState, @NotNull SoundType soundType) {
        if (clientLevel.isWaterAt(blockPos)) {
            return this.bB;
        }
        if (soundType.equals(SoundType.WOOD) || soundType.equals(SoundType.BAMBOO_WOOD) || soundType.equals(SoundType.NETHER_WOOD)) {
            return this.by;
        }
        if (soundType.equals(SoundType.METAL)) {
            return this.bz;
        }
        if (soundType.equals(SoundType.GRASS) || soundType.equals(SoundType.MOSS) || soundType.equals(SoundType.MUD) || soundType.equals(SoundType.PACKED_MUD)) {
            return this.bA;
        }
        return this.bx;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> P() {
        return this.bx;
    }

    @NotNull
    public uR r(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bx = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> Q() {
        return this.by;
    }

    @NotNull
    public uR s(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.by = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> R() {
        return this.bz;
    }

    @NotNull
    public uR t(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bz = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> S() {
        return this.bC;
    }

    @NotNull
    public uR u(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bC = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> T() {
        return this.bD;
    }

    @NotNull
    public uR v(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bD = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> U() {
        return this.bG;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> V() {
        return this.bH;
    }

    @NotNull
    public uR a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, float f) {
        this.bG = deferredHolder;
        this.bH = deferredHolder2;
        this.nI = f;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> W() {
        return this.bE;
    }

    @NotNull
    public uR w(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bE = deferredHolder;
        return this;
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> X() {
        return this.bF;
    }

    @NotNull
    public uR x(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.bF = deferredHolder;
        return this;
    }

    public boolean cM() {
        return this.iC;
    }

    public float bH() {
        return this.nJ;
    }

    public uR a(float f) {
        this.nJ = f;
        return this;
    }

    public int cf() {
        return this.sr;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public uR clone() {
        try {
            return (uR) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported", e);
        }
    }

    public float bI() {
        return this.nI;
    }
}
