package com.boehmod.blockfront;

import java.util.Random;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.hV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hV.class */
public class C0433hV {

    /* JADX INFO: renamed from: gh */
    private static final float f2722gh = 1.5707964f;

    /* JADX INFO: renamed from: gi */
    private static final float f2723gi = 0.5f;

    /* JADX INFO: renamed from: gj */
    private static final float f2724gj = 0.25f;

    /* JADX INFO: renamed from: gk */
    private static final float f2725gk = 1.5f;

    /* JADX INFO: renamed from: gl */
    private static final float f2726gl = 4.0f;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Random f2727a = new Random();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0434hW f2728a;

    /* JADX INFO: renamed from: gm */
    private float f2729gm;

    /* JADX INFO: renamed from: gn */
    private float f2730gn;

    /* JADX INFO: renamed from: go */
    private float f2731go;

    /* JADX INFO: renamed from: gp */
    private float f2732gp;

    /* JADX INFO: renamed from: gq */
    private float f2733gq;

    /* JADX INFO: renamed from: gr */
    private float f2734gr;

    /* JADX INFO: renamed from: gs */
    private float f2735gs;

    /* JADX INFO: renamed from: gt */
    private float f2736gt;

    /* JADX INFO: renamed from: gu */
    private float f2737gu = 0.0f;

    /* JADX INFO: renamed from: gv */
    private float f2738gv = 0.0f;

    /* JADX INFO: renamed from: aG */
    private float f2739aG = 1.0f;

    /* JADX INFO: renamed from: gw */
    private float f2740gw = 1.0f;

    /* JADX INFO: renamed from: gx */
    private float f2741gx = 0.25f;

    /* JADX INFO: renamed from: gy */
    private float f2742gy = 1.5f;

    public C0433hV(@NotNull C0434hW c0434hW) {
        this.f2728a = c0434hW;
        m1999aW();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0433hV m1993a(float f) {
        this.f2739aG = f;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0433hV m1994a(float f, float f2) {
        this.f2741gx = f;
        this.f2742gy = f2;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0433hV m1995a(float f, float f2, float f3) {
        this.f2732gp = f;
        this.f2733gq = f2;
        this.f2734gr = f3;
        m1999aW();
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0434hW m1996a() {
        return this.f2728a;
    }

    /* JADX INFO: renamed from: E */
    public float m1997E() {
        return this.f2739aG;
    }

    /* JADX INFO: renamed from: b */
    public void m1998b(@NotNull C0433hV c0433hV) {
        if (this.f2737gu >= 4.0f) {
            this.f2738gv = 0.0f;
            this.f2732gp = c0433hV.f2732gp;
            this.f2733gq = c0433hV.f2733gq;
            this.f2734gr = c0433hV.f2734gr;
            m1999aW();
        }
        this.f2737gu = 0.0f;
        this.f2739aG = Math.max(this.f2739aG, c0433hV.f2739aG);
        this.f2740gw = Math.min(this.f2740gw + this.f2741gx, this.f2742gy);
    }

    /* JADX INFO: renamed from: aW */
    private void m1999aW() {
        this.f2729gm = m2000l(this.f2732gp);
        this.f2730gn = m2000l(this.f2733gq);
        this.f2731go = m2000l(this.f2734gr);
    }

    /* JADX INFO: renamed from: l */
    private static float m2000l(float f) {
        float fSignum;
        if (f != 0.0f) {
            fSignum = Math.signum(f);
        } else {
            fSignum = f2727a.nextBoolean() ? 1.0f : -1.0f;
        }
        return fSignum * (1.5707964f + ((f2727a.nextFloat() - 0.5f) * 0.5f));
    }

    /* JADX INFO: renamed from: l */
    public boolean m2001l() {
        this.f2736gt = this.f2735gs;
        m2002aX();
        this.f2737gu += 1.0f;
        this.f2738gv += 1.0f;
        return this.f2737gu >= ((float) this.f2728a.m2016av()) && this.f2735gs <= 0.01f;
    }

    /* JADX INFO: renamed from: aX */
    private void m2002aX() {
        if (this.f2737gu < this.f2728a.m2016av()) {
            this.f2735gs = Mth.lerp(this.f2728a.m2014L(), this.f2735gs, 1.0f);
        } else {
            if (this.f2728a.m2016av() == 0 && this.f2737gu == 0.0f) {
                this.f2735gs = 1.0f;
            }
            this.f2735gs = Mth.lerp(this.f2728a.m2015M(), this.f2735gs, 0.0f);
        }
        this.f2735gs = Mth.clamp(this.f2735gs, 0.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public void m2003a(@NotNull Vector3f vector3f, float f) {
        float fLerp = Mth.lerp(f, this.f2736gt, this.f2735gs) * this.f2739aG * this.f2740gw;
        if (fLerp <= 0.0f) {
            return;
        }
        float f2 = (this.f2738gv - 1.0f) + f;
        vector3f.add(((float) Math.sin((f2 * this.f2728a.m2011I()) + this.f2729gm)) * this.f2728a.m2008F() * fLerp, ((float) Math.sin((f2 * this.f2728a.m2012J()) + this.f2730gn)) * this.f2728a.m2009G() * fLerp, ((float) Math.sin((f2 * this.f2728a.m2013K()) + this.f2731go)) * this.f2728a.m2010H() * fLerp);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0433hV m2004a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        C0433hV c0433hV = new C0433hV(C0434hW.m2007a(friendlyByteBuf));
        c0433hV.m1993a(friendlyByteBuf.readFloat());
        return c0433hV;
    }

    /* JADX INFO: renamed from: b */
    public void m2005b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f2728a.m2006b(friendlyByteBuf);
        friendlyByteBuf.writeFloat(this.f2739aG);
    }
}
