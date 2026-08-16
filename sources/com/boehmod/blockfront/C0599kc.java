package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000ac.SuspiciousShot;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMPlayerAimVerdict;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMPlayerSuspicious;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import it.unimi.dsi.fastutil.floats.FloatArrayList;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.kc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kc.class */
public class C0599kc {

    /* JADX INFO: renamed from: in */
    @NotNull
    private static final Component f3405in = Component.translatable("bf.message.gamemode.suspicious.kick").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: lJ */
    private static final int f3406lJ = 200;

    /* JADX INFO: renamed from: lK */
    private static final int f3407lK = 20;

    /* JADX INFO: renamed from: lL */
    private static final int f3409lL = 20;

    /* JADX INFO: renamed from: lM */
    private static final int f3410lM = 5;

    /* JADX INFO: renamed from: lP */
    private static final int f3414lP = 64;

    /* JADX INFO: renamed from: lQ */
    private static final int f3415lQ = 12;

    /* JADX INFO: renamed from: hO */
    private static final float f3416hO = 0.05f;

    /* JADX INFO: renamed from: hP */
    private static final float f3417hP = 0.1f;

    /* JADX INFO: renamed from: hQ */
    private static final float f3418hQ = 0.05f;

    /* JADX INFO: renamed from: lR */
    private static final int f3419lR = 64;

    /* JADX INFO: renamed from: hR */
    public static final float f3420hR = 15.0f;

    /* JADX INFO: renamed from: hS */
    private static final float f3421hS = 20.0f;

    /* JADX INFO: renamed from: hT */
    private static final float f3422hT = 5.0f;

    /* JADX INFO: renamed from: lS */
    private static final int f3423lS = 100;

    /* JADX INFO: renamed from: lT */
    private static final int f3424lT = 40;

    /* JADX INFO: renamed from: lU */
    private static final int f3425lU = 80;

    /* JADX INFO: renamed from: hU */
    private static final float f3426hU = 0.65f;

    /* JADX INFO: renamed from: lV */
    private static final int f3427lV = 8;

    /* JADX INFO: renamed from: lW */
    private static final int f3428lW = 4;

    /* JADX INFO: renamed from: hV */
    private static final float f3429hV = 0.6f;

    /* JADX INFO: renamed from: lX */
    private static final int f3430lX = 60;

    /* JADX INFO: renamed from: lY */
    private static final int f3431lY = 15;

    /* JADX INFO: renamed from: hW */
    private static final float f3432hW = 0.05f;

    /* JADX INFO: renamed from: lZ */
    private static final int f3433lZ = 4;

    /* JADX INFO: renamed from: y */
    private static final long f3434y = 20;

    /* JADX INFO: renamed from: ma */
    private static final int f3435ma = 64;

    /* JADX INFO: renamed from: mb */
    private static final int f3436mb = 48;

    /* JADX INFO: renamed from: hX */
    private static final float f3437hX = 0.005f;

    /* JADX INFO: renamed from: hY */
    private static final float f3438hY = 20.0f;

    /* JADX INFO: renamed from: hZ */
    private static final float f3439hZ = 89.5f;

    /* JADX INFO: renamed from: ia */
    private static final float f3440ia = 2048.0f;

    /* JADX INFO: renamed from: ao */
    private static final double f3441ao = 0.001d;

    /* JADX INFO: renamed from: ib */
    private static final float f3442ib = 0.008f;

    /* JADX INFO: renamed from: ic */
    private static final float f3443ic = 0.85f;

    /* JADX INFO: renamed from: mc */
    private static final int f3444mc = 6;

    /* JADX INFO: renamed from: z */
    private static final long f3445z = 6;

    /* JADX INFO: renamed from: A */
    private static final long f3446A = 300000;

    /* JADX INFO: renamed from: md */
    private int f3452md;

    /* JADX INFO: renamed from: E */
    private long f3457E;

    /* JADX INFO: renamed from: F */
    private long f3458F;

    /* JADX INFO: renamed from: G */
    private long f3459G;

    /* JADX INFO: renamed from: H */
    private long f3460H;

    /* JADX INFO: renamed from: dN */
    private boolean f3408dN = false;

    /* JADX INFO: renamed from: lN */
    private int f3411lN = 0;

    /* JADX INFO: renamed from: lO */
    private int f3412lO = 0;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ArrayDeque<SuspiciousShot> f3413a = new ArrayDeque<>(5);

    /* JADX INFO: renamed from: b */
    @NotNull
    private final ObjectArrayList<a> f3447b = new ObjectArrayList<>(64);

    /* JADX INFO: renamed from: c */
    @NotNull
    private final ObjectArrayList<c> f3448c = new ObjectArrayList<>(100);

    /* JADX INFO: renamed from: b */
    @NotNull
    private final FloatArrayList f3449b = new FloatArrayList(8);

    /* JADX INFO: renamed from: c */
    @NotNull
    private final FloatArrayList f3450c = new FloatArrayList(60);

    /* JADX INFO: renamed from: B */
    private long f3451B = Long.MIN_VALUE;

    /* JADX INFO: renamed from: C */
    private long f3453C = Long.MIN_VALUE;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final FloatArrayList f3454d = new FloatArrayList(64);

    /* JADX INFO: renamed from: e */
    @NotNull
    private final FloatArrayList f3455e = new FloatArrayList(64);

    /* JADX INFO: renamed from: D */
    private long f3456D = Long.MIN_VALUE;

    /* JADX INFO: renamed from: com.boehmod.blockfront.kc$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kc$a.class */
    public static final class a extends Record {

        /* JADX INFO: renamed from: id */
        private final float f3461id;

        /* JADX INFO: renamed from: ie */
        private final float f3462ie;

        /* JADX INFO: renamed from: if */
        private final float f3463if;

        /* JADX INFO: renamed from: ig */
        private final float f3464ig;

        /* JADX INFO: renamed from: ih */
        private final float f3465ih;

        /* JADX INFO: renamed from: aQ */
        @NotNull
        private final String f3466aQ;

        /* JADX INFO: renamed from: dO */
        private final boolean f3467dO;

        public a(float f, float f2, float f3, float f4, float f5, @NotNull String str, boolean z) {
            this.f3461id = f;
            this.f3462ie = f2;
            this.f3463if = f3;
            this.f3464ig = f4;
            this.f3465ih = f5;
            this.f3466aQ = str;
            this.f3467dO = z;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "minOffsetDeg;hMissBlk;vMissBlk;preSnapDeg;preOffsetDeg;region;headShot", "FIELD:Lcom/boehmod/blockfront/kc$a;->id:F", "FIELD:Lcom/boehmod/blockfront/kc$a;->ie:F", "FIELD:Lcom/boehmod/blockfront/kc$a;->if:F", "FIELD:Lcom/boehmod/blockfront/kc$a;->ig:F", "FIELD:Lcom/boehmod/blockfront/kc$a;->ih:F", "FIELD:Lcom/boehmod/blockfront/kc$a;->aQ:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/kc$a;->dO:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "minOffsetDeg;hMissBlk;vMissBlk;preSnapDeg;preOffsetDeg;region;headShot", "FIELD:Lcom/boehmod/blockfront/kc$a;->id:F", "FIELD:Lcom/boehmod/blockfront/kc$a;->ie:F", "FIELD:Lcom/boehmod/blockfront/kc$a;->if:F", "FIELD:Lcom/boehmod/blockfront/kc$a;->ig:F", "FIELD:Lcom/boehmod/blockfront/kc$a;->ih:F", "FIELD:Lcom/boehmod/blockfront/kc$a;->aQ:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/kc$a;->dO:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "minOffsetDeg;hMissBlk;vMissBlk;preSnapDeg;preOffsetDeg;region;headShot", "FIELD:Lcom/boehmod/blockfront/kc$a;->id:F", "FIELD:Lcom/boehmod/blockfront/kc$a;->ie:F", "FIELD:Lcom/boehmod/blockfront/kc$a;->if:F", "FIELD:Lcom/boehmod/blockfront/kc$a;->ig:F", "FIELD:Lcom/boehmod/blockfront/kc$a;->ih:F", "FIELD:Lcom/boehmod/blockfront/kc$a;->aQ:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/kc$a;->dO:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: ag */
        public float m2655ag() {
            return this.f3461id;
        }

        /* JADX INFO: renamed from: ah */
        public float m2656ah() {
            return this.f3462ie;
        }

        /* JADX INFO: renamed from: ai */
        public float m2657ai() {
            return this.f3463if;
        }

        /* JADX INFO: renamed from: aj */
        public float m2658aj() {
            return this.f3464ig;
        }

        /* JADX INFO: renamed from: ak */
        public float m2659ak() {
            return this.f3465ih;
        }

        @NotNull
        /* JADX INFO: renamed from: A */
        public String m2660A() {
            return this.f3466aQ;
        }

        /* JADX INFO: renamed from: an */
        public boolean m2661an() {
            return this.f3467dO;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.kc$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kc$c.class */
    public static final class c extends Record {

        /* JADX INFO: renamed from: dQ */
        private final boolean f3470dQ;

        /* JADX INFO: renamed from: dR */
        private final boolean f3471dR;

        public c(boolean z, boolean z2) {
            this.f3470dQ = z;
            this.f3471dR = z2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "hit;headShot", "FIELD:Lcom/boehmod/blockfront/kc$c;->dQ:Z", "FIELD:Lcom/boehmod/blockfront/kc$c;->dR:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "hit;headShot", "FIELD:Lcom/boehmod/blockfront/kc$c;->dQ:Z", "FIELD:Lcom/boehmod/blockfront/kc$c;->dR:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "hit;headShot", "FIELD:Lcom/boehmod/blockfront/kc$c;->dQ:Z", "FIELD:Lcom/boehmod/blockfront/kc$c;->dR:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: ap */
        public boolean m2664ap() {
            return this.f3470dQ;
        }

        /* JADX INFO: renamed from: an */
        public boolean m2665an() {
            return this.f3471dR;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2634a(@NotNull a aVar) {
        if (this.f3447b.size() >= 64) {
            this.f3447b.remove(0);
        }
        this.f3447b.add(aVar);
        m2640bq();
    }

    /* JADX INFO: renamed from: a */
    public void m2635a(boolean z, boolean z2, long j, int i, float f, boolean z3) {
        if (this.f3448c.size() >= 100) {
            this.f3448c.remove(0);
        }
        this.f3448c.add(new c(z, z2));
        m2640bq();
        this.f3452md = j - this.f3451B <= ((long) i) + 2 ? this.f3452md + 1 : 1;
        this.f3451B = j;
        if (z3 && this.f3452md >= 4) {
            if (this.f3450c.size() >= 60) {
                this.f3450c.removeFloat(0);
            }
            this.f3450c.add(f);
        }
    }

    /* JADX INFO: renamed from: g */
    public void m2636g(float f) {
        if (this.f3449b.size() >= 8) {
            this.f3449b.removeFloat(0);
        }
        this.f3449b.add(f);
        m2640bq();
    }

    /* JADX INFO: renamed from: a */
    public long m2637a(long j) {
        long jMax = Math.max(this.f3456D + 1, j - f3445z);
        this.f3456D = Math.max(this.f3456D, j);
        return jMax;
    }

    /* JADX INFO: renamed from: a */
    public void m2638a(boolean z, float f, float f2, float f3, float f4) {
        FloatArrayList floatArrayList = z ? this.f3455e : this.f3454d;
        if (Math.abs(f2) < f3440ia && Math.abs(f) < f3440ia) {
            m2639a(floatArrayList, Math.abs(f2 - f));
        }
        if (Math.abs(f4) < f3439hZ && Math.abs(f3) < f3439hZ) {
            m2639a(floatArrayList, Math.abs(f4 - f3));
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2639a(@NotNull FloatArrayList floatArrayList, float f) {
        if (f <= f3437hX || f > 20.0f) {
            return;
        }
        if (floatArrayList.size() >= 64) {
            floatArrayList.removeFloat(0);
        }
        floatArrayList.add(f);
        m2640bq();
    }

    /* JADX INFO: renamed from: bq */
    private void m2640bq() {
        this.f3457E++;
        this.f3459G = System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: a */
    private static boolean m2641a(@NotNull FloatArrayList floatArrayList) {
        float[] floatArray = floatArrayList.toFloatArray();
        Arrays.sort(floatArray);
        int iCeil = (int) Math.ceil(floatArray.length * f3443ic);
        FloatArrayList floatArrayList2 = new FloatArrayList(24);
        for (float f : floatArray) {
            if (floatArrayList2.size() >= 6) {
                break;
            }
            if (f >= f3442ib && (floatArrayList2.isEmpty() || f > floatArrayList2.getFloat(floatArrayList2.size() - 1) + 0.001f)) {
                floatArrayList2.add(f);
            }
        }
        int size = floatArrayList2.size();
        for (int i = 0; i < size; i++) {
            for (int i2 = i + 1; i2 < size; i2++) {
                float fM2643a = (float) m2643a(floatArrayList2.getFloat(i2), floatArrayList2.getFloat(i));
                if (fM2643a >= f3442ib) {
                    floatArrayList2.add(fM2643a);
                }
            }
        }
        for (int i3 = 0; i3 < floatArrayList2.size(); i3++) {
            float f2 = floatArrayList2.getFloat(i3);
            int i4 = 0;
            for (float f3 : floatArray) {
                double d = f3441ao + (((double) f3) * 1.0E-4d);
                double d2 = f3 % f2;
                if (d2 <= d || ((double) f2) - d2 <= d) {
                    i4++;
                }
            }
            if (i4 >= iCeil) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private static float m2642a(@NotNull FloatArrayList floatArrayList) {
        double dM2643a = 0.0d;
        int size = floatArrayList.size();
        for (int i = 0; i < size; i++) {
            double d = floatArrayList.getFloat(i);
            dM2643a = dM2643a == 0.0d ? d : m2643a(Math.max(dM2643a, d), Math.min(dM2643a, d));
        }
        return (float) dM2643a;
    }

    /* JADX INFO: renamed from: a */
    private static double m2643a(double d, double d2) {
        while (d2 > f3441ao) {
            double d3 = d % d2;
            if (d3 > d2 - f3441ao) {
                d3 = 0.0d;
            }
            d = d2;
            d2 = d3;
        }
        return d;
    }

    /* JADX INFO: renamed from: d */
    public boolean m2644d(long j) {
        if (j - this.f3453C < f3434y) {
            return false;
        }
        this.f3453C = j;
        return true;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.kc$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kc$b.class */
    private static final class b extends Record {

        /* JADX INFO: renamed from: dP */
        private final boolean f3468dP;

        /* JADX INFO: renamed from: aR */
        @NotNull
        private final String f3469aR;

        private b(boolean z, @NotNull String str) {
            this.f3468dP = z;
            this.f3469aR = str;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "suspect;summary", "FIELD:Lcom/boehmod/blockfront/kc$b;->dP:Z", "FIELD:Lcom/boehmod/blockfront/kc$b;->aR:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "suspect;summary", "FIELD:Lcom/boehmod/blockfront/kc$b;->dP:Z", "FIELD:Lcom/boehmod/blockfront/kc$b;->aR:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "suspect;summary", "FIELD:Lcom/boehmod/blockfront/kc$b;->dP:Z", "FIELD:Lcom/boehmod/blockfront/kc$b;->aR:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: ao */
        public boolean m2662ao() {
            return this.f3468dP;
        }

        @NotNull
        /* JADX INFO: renamed from: B */
        public String m2663B() {
            return this.f3469aR;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private b m2645a() {
        String str;
        int size = this.f3447b.size();
        int size2 = this.f3448c.size();
        if (size < 12 && size2 < 40) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int i = 0;
        if (size >= 12) {
            FloatArrayList floatArrayList = new FloatArrayList(size);
            FloatArrayList floatArrayList2 = new FloatArrayList(size);
            FloatArrayList floatArrayList3 = new FloatArrayList(size);
            FloatArrayList floatArrayList4 = new FloatArrayList(size);
            FloatArrayList floatArrayList5 = new FloatArrayList(size);
            ObjectListIterator it = this.f3447b.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                floatArrayList.add(aVar.m2656ah());
                floatArrayList2.add(aVar.m2657ai());
                floatArrayList5.add(aVar.m2655ag());
                if (!Float.isNaN(aVar.m2658aj())) {
                    floatArrayList3.add(aVar.m2658aj());
                }
                if (!Float.isNaN(aVar.m2659ak())) {
                    floatArrayList4.add(aVar.m2659ak());
                }
                if (aVar.m2661an()) {
                    i++;
                }
            }
            float fM2647b = m2647b(floatArrayList);
            float fM2647b2 = m2647b(floatArrayList2);
            float fM2650c = floatArrayList3.isEmpty() ? 0.0f : m2650c(floatArrayList3);
            boolean z2 = fM2647b2 <= 0.05f;
            boolean z3 = size >= 64 && fM2647b <= 0.05f;
            boolean z4 = fM2647b2 <= 0.1f && fM2647b <= 0.1f;
            boolean z5 = z2 || z3 || z4;
            boolean z6 = !floatArrayList3.isEmpty() && fM2650c >= 15.0f;
            float fM2650c2 = floatArrayList4.isEmpty() ? 0.0f : m2650c(floatArrayList4);
            float fM2650c3 = m2650c(floatArrayList5);
            boolean z7 = floatArrayList4.size() >= 12 && fM2650c2 >= 20.0f && fM2650c3 <= 5.0f;
            z = z5 || z6 || z7;
            if (!z5) {
                str = "";
            } else if (z4) {
                str = " [LOCK]";
            } else {
                str = z2 ? " [LOCK-V]" : " [LOCK-H]";
            }
            Object[] objArr = new Object[8];
            objArr[0] = Float.valueOf(fM2647b);
            objArr[1] = Float.valueOf(fM2647b2);
            objArr[2] = str;
            objArr[3] = Float.valueOf(fM2650c);
            objArr[4] = z6 ? " [SNAP]" : "";
            objArr[5] = Float.valueOf(fM2650c2);
            objArr[6] = Float.valueOf(fM2650c3);
            objArr[7] = z7 ? " [RAMP]" : "";
            sb.append(String.format("lock h%.3f/v%.3f blk%s | snap %.1fdeg%s | ramp %.0f>%.1fdeg%s", objArr));
        }
        if (size2 >= 40) {
            int i2 = 0;
            int i3 = 0;
            ObjectListIterator it2 = this.f3448c.iterator();
            while (it2.hasNext()) {
                c cVar = (c) it2.next();
                if (cVar.m2664ap()) {
                    i2++;
                }
                if (cVar.m2665an()) {
                    i3++;
                }
            }
            float f = i2 / size2;
            float f2 = i2 > 0 ? i3 / i2 : 0.0f;
            boolean z8 = size2 >= 80 && f >= f3426hU;
            z |= z8;
            if (!sb.isEmpty()) {
                sb.append(" | ");
            }
            Object[] objArr2 = new Object[4];
            objArr2[0] = Integer.valueOf(Math.round(f * 100.0f));
            objArr2[1] = Integer.valueOf(size2);
            objArr2[2] = Integer.valueOf(Math.round(f2 * 100.0f));
            objArr2[3] = z8 ? " [ACC-RATE]" : "";
            sb.append(String.format("acc %d%% of %d, head %d%%%s", objArr2));
        }
        if (this.f3450c.size() >= 15) {
            float fM2650c4 = m2650c(this.f3450c);
            boolean z9 = fM2650c4 <= 0.05f;
            z |= z9;
            if (!sb.isEmpty()) {
                sb.append(" | ");
            }
            Object[] objArr3 = new Object[3];
            objArr3[0] = Float.valueOf(fM2650c4);
            objArr3[1] = Integer.valueOf(this.f3450c.size());
            objArr3[2] = z9 ? " [NORECOIL]" : "";
            sb.append(String.format("recoil %.2fdeg of %d%s", objArr3));
        }
        boolean z10 = this.f3454d.size() >= f3436mb;
        boolean z11 = this.f3455e.size() >= f3436mb;
        if (z10 || z11) {
            boolean z12 = (z10 && !m2641a(this.f3454d)) || (z11 && !m2641a(this.f3455e));
            if (!sb.isEmpty()) {
                sb.append(" | ");
            }
            Object[] objArr4 = new Object[3];
            objArr4[0] = m2649d(z10 ? m2642a(this.f3454d) : Float.NaN);
            objArr4[1] = m2649d(z11 ? m2642a(this.f3455e) : Float.NaN);
            objArr4[2] = z12 ? " [quant?]" : "";
            sb.append(String.format("quant hip %s / ads %s%s", objArr4));
        }
        if (this.f3449b.size() >= 4) {
            float fM2650c5 = m2650c(this.f3449b);
            boolean z13 = fM2650c5 >= 0.6f;
            z |= z13;
            if (!sb.isEmpty()) {
                sb.append(" | ");
            }
            Object[] objArr5 = new Object[3];
            objArr5[0] = Float.valueOf(fM2650c5);
            objArr5[1] = Integer.valueOf(this.f3449b.size());
            objArr5[2] = z13 ? " [PREAIM]" : "";
            sb.append(String.format("preaim %.2f of %d%s", objArr5));
        }
        if (size > 0) {
            sb.append(String.format(" | n=%d head %d%%", Integer.valueOf(size), Integer.valueOf((i * 100) / size)));
        }
        return new b(z, (z ? "SUSPECT | " : "CLEAR | ") + String.valueOf(sb));
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Component m2646b(@NotNull String str) {
        b bVarM2645a = m2645a();
        if (bVarM2645a == null) {
            return Component.literal("[Aim] " + str + ": GATHERING | n=" + this.f3447b.size() + "/12 pulls=" + this.f3448c.size() + "/40").withStyle(ChatFormatting.GRAY);
        }
        return Component.literal("[Aim] " + str + ": " + bVarM2645a.m2663B()).withStyle(bVarM2645a.m2662ao() ? ChatFormatting.RED : ChatFormatting.GREEN);
    }

    /* JADX INFO: renamed from: b */
    private static float m2647b(@NotNull FloatArrayList floatArrayList) {
        if (floatArrayList.isEmpty()) {
            return 0.0f;
        }
        float[] floatArray = floatArrayList.toFloatArray();
        Arrays.sort(floatArray);
        int length = floatArray.length - 1;
        return floatArray[(length * 3) / 4] - floatArray[length / 4];
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m2648a(@NotNull String str, @NotNull String str2, @NotNull FloatArrayList floatArrayList) {
        StringBuilder sb = new StringBuilder("[Quant] " + str + " " + str2 + ":");
        for (int iMax = Math.max(0, floatArrayList.size() - 16); iMax < floatArrayList.size(); iMax++) {
            sb.append(String.format(" %.4f", Float.valueOf(floatArrayList.getFloat(iMax))));
        }
        return Component.literal(sb.toString()).withStyle(ChatFormatting.GRAY);
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    private static String m2649d(float f) {
        return Float.isNaN(f) ? "-" : String.format("%.4fdeg", Float.valueOf(f));
    }

    /* JADX INFO: renamed from: c */
    private static float m2650c(@NotNull FloatArrayList floatArrayList) {
        float[] floatArray = floatArrayList.toFloatArray();
        Arrays.sort(floatArray);
        int length = floatArray.length / 2;
        return floatArray.length % 2 == 1 ? floatArray[length] : (floatArray[length - 1] + floatArray[length]) * 0.5f;
    }

    /* JADX INFO: renamed from: a */
    public void m2651a(@NotNull SuspiciousShot suspiciousShot) {
        this.f3411lN++;
        this.f3413a.addLast(suspiciousShot);
        if (this.f3413a.size() > 5) {
            this.f3413a.removeFirst();
        }
    }

    /* JADX INFO: renamed from: am */
    public boolean m2652am() {
        return this.f3408dN;
    }

    /* JADX INFO: renamed from: z */
    public void m2653z(boolean z) {
        this.f3408dN = z;
    }

    /* JADX INFO: renamed from: a */
    public void m2654a(@NotNull C1280xT c1280xT, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b) {
        b bVarM2645a;
        this.f3412lO++;
        if (this.f3412lO >= 200) {
            this.f3412lO = 0;
            this.f3411lN = 0;
            if (this.f3408dN && !this.f3447b.isEmpty()) {
                C0875pn.m4410a(serverPlayer.serverLevel(), c1280xT, m2646b(serverPlayer.getScoreboardName()));
            }
            if (this.f3408dN && !this.f3455e.isEmpty()) {
                C0875pn.m4410a(serverPlayer.serverLevel(), c1280xT, m2648a(serverPlayer.getScoreboardName(), "ads", this.f3455e));
            }
            if (this.f3408dN && !this.f3454d.isEmpty()) {
                C0875pn.m4410a(serverPlayer.serverLevel(), c1280xT, m2648a(serverPlayer.getScoreboardName(), "hip", this.f3454d));
            }
            if (C0549jf.f3271dt && !C0875pn.m4488a((Player) serverPlayer, abstractC0183b) && this.f3457E != this.f3458F && System.currentTimeMillis() - this.f3460H >= f3446A && (bVarM2645a = m2645a()) != null && bVarM2645a.m2662ao()) {
                this.f3460H = System.currentTimeMillis();
                this.f3458F = this.f3457E;
                String str = bVarM2645a.m2663B() + " | fresh " + ((System.currentTimeMillis() - this.f3459G) / 1000) + "s";
                C0530jM.log("Player " + serverPlayer.getName().getString() + " tripped the aim verdict: " + str, new Object[0]);
                ((C1278xR) c1280xT.m7289b()).sendPacket(new PacketMMPlayerAimVerdict(serverPlayer.getUUID(), str));
            }
        }
        if (this.f3411lN >= 20) {
            String str2 = "Player " + serverPlayer.getName().getString() + " has been logged as suspicious for firing " + this.f3411lN + " suspicious shots in the last 10 seconds.";
            C0530jM.log(str2, new Object[0]);
            if (C0549jf.f3270ds) {
                ((C1278xR) c1280xT.m7289b()).sendPacket(new PacketMMPlayerSuspicious(serverPlayer.getUUID(), str2, List.copyOf(this.f3413a)));
            }
            this.f3411lN = 0;
            this.f3412lO = 0;
            this.f3413a.clear();
            if (C0549jf.f3269dr) {
                serverPlayer.connection.disconnect(f3405in);
            }
        }
    }
}
