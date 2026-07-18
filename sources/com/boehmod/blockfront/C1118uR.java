package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uR.class */
public class C1118uR implements Cloneable {

    /* JADX INFO: renamed from: b */
    public static final C1118uR f5872b = new C1118uR();

    /* JADX INFO: renamed from: aZ */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5873aZ = C1280xc.f8011ya;

    /* JADX INFO: renamed from: ba */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5874ba = null;

    /* JADX INFO: renamed from: bb */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5875bb = null;

    /* JADX INFO: renamed from: bc */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5876bc = null;

    /* JADX INFO: renamed from: bd */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5877bd = null;

    /* JADX INFO: renamed from: be */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5878be = null;

    /* JADX INFO: renamed from: bf */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5879bf = null;

    /* JADX INFO: renamed from: bg */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5880bg = C1280xc.f7847uS;

    /* JADX INFO: renamed from: bh */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5881bh = C1280xc.f7857vc;

    /* JADX INFO: renamed from: bi */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5882bi = C1280xc.f7918wl;

    /* JADX INFO: renamed from: bj */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5883bj = C1280xc.f7919wm;

    /* JADX INFO: renamed from: bk */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5884bk = C1280xc.f7940wH;

    /* JADX INFO: renamed from: bl */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5885bl = C1280xc.f7892vL;

    /* JADX INFO: renamed from: bm */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5886bm = C1280xc.f7893vM;

    /* JADX INFO: renamed from: bn */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5887bn = C1280xc.f7894vN;

    /* JADX INFO: renamed from: bo */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5888bo = C1280xc.f7899vS;

    /* JADX INFO: renamed from: bp */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5889bp = C1280xc.f7900vT;

    /* JADX INFO: renamed from: bq */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5890bq = null;

    /* JADX INFO: renamed from: br */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5891br = C1280xc.f7970xl;

    /* JADX INFO: renamed from: bs */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5892bs = C1280xc.f7984xz;

    /* JADX INFO: renamed from: bt */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5893bt = C1280xc.f7878vx;

    /* JADX INFO: renamed from: bu */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5894bu = C1280xc.f7872vr;

    /* JADX INFO: renamed from: bv */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5895bv = C1280xc.f7879vy;

    /* JADX INFO: renamed from: bw */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5896bw = null;

    /* JADX INFO: renamed from: bx */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5897bx = null;

    /* JADX INFO: renamed from: by */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5898by = null;

    /* JADX INFO: renamed from: bz */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5899bz = null;

    /* JADX INFO: renamed from: bA */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5900bA = null;

    /* JADX INFO: renamed from: bB */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5901bB = null;

    /* JADX INFO: renamed from: bC */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5902bC = C1280xc.f8246CB;

    /* JADX INFO: renamed from: bD */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5903bD = C1280xc.f8247CC;

    /* JADX INFO: renamed from: bE */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5904bE = C1280xc.f7991xG;

    /* JADX INFO: renamed from: bF */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5905bF = C1280xc.f7834uF;

    /* JADX INFO: renamed from: nI */
    private float f5906nI = 0.0f;

    /* JADX INFO: renamed from: bG */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f5907bG = null;

    /* JADX INFO: renamed from: bH */
    private DeferredHolder<SoundEvent, SoundEvent> f5908bH = null;

    /* JADX INFO: renamed from: iC */
    private boolean f5909iC = false;

    /* JADX INFO: renamed from: nJ */
    private float f5910nJ = 1.0f;

    /* JADX INFO: renamed from: sr */
    private int f5911sr = 2;

    /* JADX INFO: renamed from: iD */
    private boolean f5912iD = true;

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1118uR m6147a(boolean z) {
        this.f5912iD = z;
        return this;
    }

    /* JADX INFO: renamed from: cL */
    public boolean m6148cL() {
        return this.f5912iD;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1118uR m6149a(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder3, DeferredHolder<SoundEvent, SoundEvent> deferredHolder4, DeferredHolder<SoundEvent, SoundEvent> deferredHolder5) {
        this.f5897bx = deferredHolder;
        this.f5898by = deferredHolder2;
        this.f5899bz = deferredHolder3;
        this.f5900bA = deferredHolder4;
        this.f5901bB = deferredHolder5;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1118uR m6150a(DeferredHolder<SoundEvent, SoundEvent> deferredHolder, boolean z) {
        this.f5874ba = deferredHolder;
        this.f5909iC = z;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1118uR m6151a(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder, boolean z, int i) {
        this.f5911sr = i;
        return m6150a(deferredHolder, z);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1118uR m6152a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f5876bc = deferredHolder;
        this.f5877bd = deferredHolder2;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: r */
    public DeferredHolder<SoundEvent, SoundEvent> m6153r() {
        return this.f5873aZ;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1118uR m6154a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5873aZ = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: s */
    public DeferredHolder<SoundEvent, SoundEvent> m6155s() {
        return this.f5876bc;
    }

    /* JADX INFO: renamed from: b */
    public C1118uR m6156b(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        return m6152a(deferredHolder, deferredHolder);
    }

    @Nullable
    /* JADX INFO: renamed from: t */
    public DeferredHolder<SoundEvent, SoundEvent> m6157t() {
        return this.f5877bd;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C1118uR m6158c(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5877bd = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: u */
    public DeferredHolder<SoundEvent, SoundEvent> m6159u() {
        return this.f5878be;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C1118uR m6160d(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5878be = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: v */
    public DeferredHolder<SoundEvent, SoundEvent> m6161v() {
        return this.f5879bf;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public C1118uR m6162e(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5879bf = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: w */
    public DeferredHolder<SoundEvent, SoundEvent> m6163w() {
        return this.f5874ba;
    }

    @Nullable
    /* JADX INFO: renamed from: x */
    public DeferredHolder<SoundEvent, SoundEvent> m6164x() {
        return this.f5875bb;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public C1118uR m6165f(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5875bb = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: y */
    public DeferredHolder<SoundEvent, SoundEvent> m6166y() {
        return this.f5880bg;
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    public C1118uR m6167g(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5880bg = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: z */
    public DeferredHolder<SoundEvent, SoundEvent> m6168z() {
        return this.f5881bh;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public C1118uR m6169h(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5881bh = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: A */
    public DeferredHolder<SoundEvent, SoundEvent> m6170A() {
        return this.f5882bi;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1118uR m6171b(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f5882bi = deferredHolder;
        this.f5883bj = deferredHolder2;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: B */
    public DeferredHolder<SoundEvent, SoundEvent> m6172B() {
        return this.f5883bj;
    }

    @Nullable
    /* JADX INFO: renamed from: C */
    public DeferredHolder<SoundEvent, SoundEvent> m6173C() {
        return this.f5884bk;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public C1118uR m6174i(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5884bk = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: D */
    public DeferredHolder<SoundEvent, SoundEvent> m6175D() {
        return this.f5885bl;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C1118uR m6176c(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f5885bl = deferredHolder;
        this.f5886bm = deferredHolder2;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: E */
    public DeferredHolder<SoundEvent, SoundEvent> m6177E() {
        return this.f5886bm;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C1118uR m6178d(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f5887bn = deferredHolder;
        this.f5888bo = deferredHolder2;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: F */
    public DeferredHolder<SoundEvent, SoundEvent> m6179F() {
        return this.f5887bn;
    }

    @Nullable
    /* JADX INFO: renamed from: G */
    public DeferredHolder<SoundEvent, SoundEvent> m6180G() {
        return this.f5888bo;
    }

    @NotNull
    /* JADX INFO: renamed from: j */
    public C1118uR m6181j(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5889bp = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: H */
    public DeferredHolder<SoundEvent, SoundEvent> m6182H() {
        return this.f5889bp;
    }

    @Nullable
    /* JADX INFO: renamed from: I */
    public DeferredHolder<SoundEvent, SoundEvent> m6183I() {
        return this.f5890bq;
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public C1118uR m6184k(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5890bq = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: J */
    public DeferredHolder<SoundEvent, SoundEvent> m6185J() {
        return this.f5891br;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public C1118uR m6186l(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5891br = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: K */
    public DeferredHolder<SoundEvent, SoundEvent> m6187K() {
        return this.f5892bs;
    }

    @NotNull
    /* JADX INFO: renamed from: m */
    public C1118uR m6188m(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5892bs = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: L */
    public DeferredHolder<SoundEvent, SoundEvent> m6189L() {
        return this.f5893bt;
    }

    @NotNull
    /* JADX INFO: renamed from: n */
    public C1118uR m6190n(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5893bt = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: M */
    public DeferredHolder<SoundEvent, SoundEvent> m6191M() {
        return this.f5894bu;
    }

    @NotNull
    /* JADX INFO: renamed from: o */
    public C1118uR m6192o(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5894bu = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: N */
    public DeferredHolder<SoundEvent, SoundEvent> m6193N() {
        return this.f5895bv;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public C1118uR m6194p(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5895bv = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: O */
    public DeferredHolder<SoundEvent, SoundEvent> m6195O() {
        return this.f5896bw;
    }

    @NotNull
    /* JADX INFO: renamed from: q */
    public C1118uR m6196q(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5896bw = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public DeferredHolder<SoundEvent, SoundEvent> m6197a(@NotNull ClientLevel clientLevel, BlockPos blockPos, @NotNull BlockState blockState, @NotNull SoundType soundType) {
        if (clientLevel.isWaterAt(blockPos)) {
            return this.f5901bB;
        }
        if (soundType.equals(SoundType.WOOD) || soundType.equals(SoundType.BAMBOO_WOOD) || soundType.equals(SoundType.NETHER_WOOD)) {
            return this.f5898by;
        }
        if (soundType.equals(SoundType.METAL)) {
            return this.f5899bz;
        }
        if (soundType.equals(SoundType.GRASS) || soundType.equals(SoundType.MOSS) || soundType.equals(SoundType.MUD) || soundType.equals(SoundType.PACKED_MUD)) {
            return this.f5900bA;
        }
        return this.f5897bx;
    }

    @Nullable
    /* JADX INFO: renamed from: P */
    public DeferredHolder<SoundEvent, SoundEvent> m6198P() {
        return this.f5897bx;
    }

    @NotNull
    /* JADX INFO: renamed from: r */
    public C1118uR m6199r(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5897bx = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: Q */
    public DeferredHolder<SoundEvent, SoundEvent> m6200Q() {
        return this.f5898by;
    }

    @NotNull
    /* JADX INFO: renamed from: s */
    public C1118uR m6201s(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5898by = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: R */
    public DeferredHolder<SoundEvent, SoundEvent> m6202R() {
        return this.f5899bz;
    }

    @NotNull
    /* JADX INFO: renamed from: t */
    public C1118uR m6203t(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5899bz = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: S */
    public DeferredHolder<SoundEvent, SoundEvent> m6204S() {
        return this.f5902bC;
    }

    @NotNull
    /* JADX INFO: renamed from: u */
    public C1118uR m6205u(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5902bC = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: T */
    public DeferredHolder<SoundEvent, SoundEvent> m6206T() {
        return this.f5903bD;
    }

    @NotNull
    /* JADX INFO: renamed from: v */
    public C1118uR m6207v(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5903bD = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: U */
    public DeferredHolder<SoundEvent, SoundEvent> m6208U() {
        return this.f5907bG;
    }

    @Nullable
    /* JADX INFO: renamed from: V */
    public DeferredHolder<SoundEvent, SoundEvent> m6209V() {
        return this.f5908bH;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1118uR m6210a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, float f) {
        this.f5907bG = deferredHolder;
        this.f5908bH = deferredHolder2;
        this.f5906nI = f;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: W */
    public DeferredHolder<SoundEvent, SoundEvent> m6211W() {
        return this.f5904bE;
    }

    @NotNull
    /* JADX INFO: renamed from: w */
    public C1118uR m6212w(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5904bE = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: X */
    public DeferredHolder<SoundEvent, SoundEvent> m6213X() {
        return this.f5905bF;
    }

    @NotNull
    /* JADX INFO: renamed from: x */
    public C1118uR m6214x(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f5905bF = deferredHolder;
        return this;
    }

    /* JADX INFO: renamed from: cM */
    public boolean m6215cM() {
        return this.f5909iC;
    }

    /* JADX INFO: renamed from: bH */
    public float m6216bH() {
        return this.f5910nJ;
    }

    /* JADX INFO: renamed from: a */
    public C1118uR m6217a(float f) {
        this.f5910nJ = f;
        return this;
    }

    /* JADX INFO: renamed from: cf */
    public int m6218cf() {
        return this.f5911sr;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1118uR clone() {
        try {
            return (C1118uR) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported", e);
        }
    }

    /* JADX INFO: renamed from: bI */
    public float m6220bI() {
        return this.f5906nI;
    }
}
