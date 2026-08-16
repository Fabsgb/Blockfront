package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vr.class */
public class C1198vr implements Cloneable {

    /* JADX INFO: renamed from: b */
    public static final C1198vr f6511b = new C1198vr();

    /* JADX INFO: renamed from: aZ */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6512aZ = C1312xz.f8424yd;

    /* JADX INFO: renamed from: ba */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6513ba = null;

    /* JADX INFO: renamed from: bb */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6514bb = null;

    /* JADX INFO: renamed from: bc */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6515bc = null;

    /* JADX INFO: renamed from: bd */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6516bd = null;

    /* JADX INFO: renamed from: be */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6517be = null;

    /* JADX INFO: renamed from: bf */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6518bf = null;

    /* JADX INFO: renamed from: bg */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6519bg = C1312xz.f8260uV;

    /* JADX INFO: renamed from: bh */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6520bh = C1312xz.f8270vf;

    /* JADX INFO: renamed from: bi */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6521bi = C1312xz.f8331wo;

    /* JADX INFO: renamed from: bj */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6522bj = C1312xz.f8332wp;

    /* JADX INFO: renamed from: bk */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6523bk = C1312xz.f8353wK;

    /* JADX INFO: renamed from: bl */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6524bl = C1312xz.f8305vO;

    /* JADX INFO: renamed from: bm */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6525bm = C1312xz.f8306vP;

    /* JADX INFO: renamed from: bn */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6526bn = C1312xz.f8307vQ;

    /* JADX INFO: renamed from: bo */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6527bo = C1312xz.f8312vV;

    /* JADX INFO: renamed from: bp */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6528bp = C1312xz.f8313vW;

    /* JADX INFO: renamed from: bq */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6529bq = null;

    /* JADX INFO: renamed from: br */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6530br = C1312xz.f8383xo;

    /* JADX INFO: renamed from: bs */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6531bs = C1312xz.f8397xC;

    /* JADX INFO: renamed from: bt */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6532bt = C1312xz.f8291vA;

    /* JADX INFO: renamed from: bu */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6533bu = C1312xz.f8285vu;

    /* JADX INFO: renamed from: bv */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6534bv = C1312xz.f8292vB;

    /* JADX INFO: renamed from: bw */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6535bw = null;

    /* JADX INFO: renamed from: bx */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6536bx = null;

    /* JADX INFO: renamed from: by */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6537by = null;

    /* JADX INFO: renamed from: bz */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6538bz = null;

    /* JADX INFO: renamed from: bA */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6539bA = null;

    /* JADX INFO: renamed from: bB */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6540bB = null;

    /* JADX INFO: renamed from: bC */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6541bC = C1312xz.f8659CE;

    /* JADX INFO: renamed from: bD */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6542bD = C1312xz.f8660CF;

    /* JADX INFO: renamed from: bE */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6543bE = C1312xz.f8404xJ;

    /* JADX INFO: renamed from: bF */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6544bF = C1312xz.f8247uI;

    /* JADX INFO: renamed from: oG */
    private float f6545oG = 0.0f;

    /* JADX INFO: renamed from: bG */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6546bG = null;

    /* JADX INFO: renamed from: bH */
    private DeferredHolder<SoundEvent, SoundEvent> f6547bH = null;

    /* JADX INFO: renamed from: iW */
    private boolean f6548iW = false;

    /* JADX INFO: renamed from: oH */
    private float f6549oH = 1.0f;

    /* JADX INFO: renamed from: uv */
    private int f6550uv = 2;

    /* JADX INFO: renamed from: iX */
    private boolean f6551iX = true;

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1198vr m6800a(boolean z) {
        this.f6551iX = z;
        return this;
    }

    /* JADX INFO: renamed from: cU */
    public boolean m6801cU() {
        return this.f6551iX;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1198vr m6802a(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder3, DeferredHolder<SoundEvent, SoundEvent> deferredHolder4, DeferredHolder<SoundEvent, SoundEvent> deferredHolder5) {
        this.f6536bx = deferredHolder;
        this.f6537by = deferredHolder2;
        this.f6538bz = deferredHolder3;
        this.f6539bA = deferredHolder4;
        this.f6540bB = deferredHolder5;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1198vr m6803a(DeferredHolder<SoundEvent, SoundEvent> deferredHolder, boolean z) {
        this.f6513ba = deferredHolder;
        this.f6548iW = z;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1198vr m6804a(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder, boolean z, int i) {
        this.f6550uv = i;
        return m6803a(deferredHolder, z);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1198vr m6805a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f6515bc = deferredHolder;
        this.f6516bd = deferredHolder2;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: r */
    public DeferredHolder<SoundEvent, SoundEvent> m6806r() {
        return this.f6512aZ;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1198vr m6807a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6512aZ = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: s */
    public DeferredHolder<SoundEvent, SoundEvent> m6808s() {
        return this.f6515bc;
    }

    /* JADX INFO: renamed from: b */
    public C1198vr m6809b(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        return m6805a(deferredHolder, deferredHolder);
    }

    @Nullable
    /* JADX INFO: renamed from: t */
    public DeferredHolder<SoundEvent, SoundEvent> m6810t() {
        return this.f6516bd;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C1198vr m6811c(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6516bd = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: u */
    public DeferredHolder<SoundEvent, SoundEvent> m6812u() {
        return this.f6517be;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C1198vr m6813d(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6517be = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: v */
    public DeferredHolder<SoundEvent, SoundEvent> m6814v() {
        return this.f6518bf;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public C1198vr m6815e(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6518bf = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: w */
    public DeferredHolder<SoundEvent, SoundEvent> m6816w() {
        return this.f6513ba;
    }

    @Nullable
    /* JADX INFO: renamed from: x */
    public DeferredHolder<SoundEvent, SoundEvent> m6817x() {
        return this.f6514bb;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public C1198vr m6818f(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6514bb = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: y */
    public DeferredHolder<SoundEvent, SoundEvent> m6819y() {
        return this.f6519bg;
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    public C1198vr m6820g(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6519bg = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: z */
    public DeferredHolder<SoundEvent, SoundEvent> m6821z() {
        return this.f6520bh;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public C1198vr m6822h(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6520bh = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: A */
    public DeferredHolder<SoundEvent, SoundEvent> m6823A() {
        return this.f6521bi;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1198vr m6824b(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f6521bi = deferredHolder;
        this.f6522bj = deferredHolder2;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: B */
    public DeferredHolder<SoundEvent, SoundEvent> m6825B() {
        return this.f6522bj;
    }

    @Nullable
    /* JADX INFO: renamed from: C */
    public DeferredHolder<SoundEvent, SoundEvent> m6826C() {
        return this.f6523bk;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public C1198vr m6827i(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6523bk = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: D */
    public DeferredHolder<SoundEvent, SoundEvent> m6828D() {
        return this.f6524bl;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C1198vr m6829c(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f6524bl = deferredHolder;
        this.f6525bm = deferredHolder2;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: E */
    public DeferredHolder<SoundEvent, SoundEvent> m6830E() {
        return this.f6525bm;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C1198vr m6831d(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f6526bn = deferredHolder;
        this.f6527bo = deferredHolder2;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: F */
    public DeferredHolder<SoundEvent, SoundEvent> m6832F() {
        return this.f6526bn;
    }

    @Nullable
    /* JADX INFO: renamed from: G */
    public DeferredHolder<SoundEvent, SoundEvent> m6833G() {
        return this.f6527bo;
    }

    @NotNull
    /* JADX INFO: renamed from: j */
    public C1198vr m6834j(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6528bp = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: H */
    public DeferredHolder<SoundEvent, SoundEvent> m6835H() {
        return this.f6528bp;
    }

    @Nullable
    /* JADX INFO: renamed from: I */
    public DeferredHolder<SoundEvent, SoundEvent> m6836I() {
        return this.f6529bq;
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public C1198vr m6837k(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6529bq = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: J */
    public DeferredHolder<SoundEvent, SoundEvent> m6838J() {
        return this.f6530br;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public C1198vr m6839l(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6530br = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: K */
    public DeferredHolder<SoundEvent, SoundEvent> m6840K() {
        return this.f6531bs;
    }

    @NotNull
    /* JADX INFO: renamed from: m */
    public C1198vr m6841m(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6531bs = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: L */
    public DeferredHolder<SoundEvent, SoundEvent> m6842L() {
        return this.f6532bt;
    }

    @NotNull
    /* JADX INFO: renamed from: n */
    public C1198vr m6843n(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6532bt = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: M */
    public DeferredHolder<SoundEvent, SoundEvent> m6844M() {
        return this.f6533bu;
    }

    @NotNull
    /* JADX INFO: renamed from: o */
    public C1198vr m6845o(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6533bu = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: N */
    public DeferredHolder<SoundEvent, SoundEvent> m6846N() {
        return this.f6534bv;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public C1198vr m6847p(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6534bv = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: O */
    public DeferredHolder<SoundEvent, SoundEvent> m6848O() {
        return this.f6535bw;
    }

    @NotNull
    /* JADX INFO: renamed from: q */
    public C1198vr m6849q(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6535bw = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public DeferredHolder<SoundEvent, SoundEvent> m6850a(@NotNull ClientLevel clientLevel, BlockPos blockPos, @NotNull BlockState blockState, @NotNull SoundType soundType) {
        if (clientLevel.isWaterAt(blockPos)) {
            return this.f6540bB;
        }
        if (soundType.equals(SoundType.WOOD) || soundType.equals(SoundType.BAMBOO_WOOD) || soundType.equals(SoundType.NETHER_WOOD)) {
            return this.f6537by;
        }
        if (soundType.equals(SoundType.METAL)) {
            return this.f6538bz;
        }
        if (soundType.equals(SoundType.GRASS) || soundType.equals(SoundType.MOSS) || soundType.equals(SoundType.MUD) || soundType.equals(SoundType.PACKED_MUD)) {
            return this.f6539bA;
        }
        return this.f6536bx;
    }

    @Nullable
    /* JADX INFO: renamed from: P */
    public DeferredHolder<SoundEvent, SoundEvent> m6851P() {
        return this.f6536bx;
    }

    @NotNull
    /* JADX INFO: renamed from: r */
    public C1198vr m6852r(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6536bx = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: Q */
    public DeferredHolder<SoundEvent, SoundEvent> m6853Q() {
        return this.f6537by;
    }

    @NotNull
    /* JADX INFO: renamed from: s */
    public C1198vr m6854s(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6537by = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: R */
    public DeferredHolder<SoundEvent, SoundEvent> m6855R() {
        return this.f6538bz;
    }

    @NotNull
    /* JADX INFO: renamed from: t */
    public C1198vr m6856t(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6538bz = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: S */
    public DeferredHolder<SoundEvent, SoundEvent> m6857S() {
        return this.f6541bC;
    }

    @NotNull
    /* JADX INFO: renamed from: u */
    public C1198vr m6858u(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6541bC = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: T */
    public DeferredHolder<SoundEvent, SoundEvent> m6859T() {
        return this.f6542bD;
    }

    @NotNull
    /* JADX INFO: renamed from: v */
    public C1198vr m6860v(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6542bD = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: U */
    public DeferredHolder<SoundEvent, SoundEvent> m6861U() {
        return this.f6546bG;
    }

    @Nullable
    /* JADX INFO: renamed from: V */
    public DeferredHolder<SoundEvent, SoundEvent> m6862V() {
        return this.f6547bH;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1198vr m6863a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, float f) {
        this.f6546bG = deferredHolder;
        this.f6547bH = deferredHolder2;
        this.f6545oG = f;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: W */
    public DeferredHolder<SoundEvent, SoundEvent> m6864W() {
        return this.f6543bE;
    }

    @NotNull
    /* JADX INFO: renamed from: w */
    public C1198vr m6865w(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6543bE = deferredHolder;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: X */
    public DeferredHolder<SoundEvent, SoundEvent> m6866X() {
        return this.f6544bF;
    }

    @NotNull
    /* JADX INFO: renamed from: x */
    public C1198vr m6867x(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6544bF = deferredHolder;
        return this;
    }

    /* JADX INFO: renamed from: cV */
    public boolean m6868cV() {
        return this.f6548iW;
    }

    /* JADX INFO: renamed from: bN */
    public float m6869bN() {
        return this.f6549oH;
    }

    /* JADX INFO: renamed from: a */
    public C1198vr m6870a(float f) {
        this.f6549oH = f;
        return this;
    }

    /* JADX INFO: renamed from: cv */
    public int m6871cv() {
        return this.f6550uv;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1198vr clone() {
        try {
            return (C1198vr) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported", e);
        }
    }

    /* JADX INFO: renamed from: bO */
    public float m6873bO() {
        return this.f6545oG;
    }
}
