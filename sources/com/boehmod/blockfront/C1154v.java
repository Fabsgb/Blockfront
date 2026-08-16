package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.v */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/v.class */
public final class C1154v {

    /* JADX INFO: renamed from: c */
    private static final double f6283c = 0.25d;

    /* JADX INFO: renamed from: M */
    private static final int f6284M = 2;

    /* JADX INFO: renamed from: N */
    private static final int f6285N = 40;

    /* JADX INFO: renamed from: O */
    private static final int f6286O = 128;

    /* JADX INFO: renamed from: d */
    private static double f6288d;

    /* JADX INFO: renamed from: e */
    private static double f6289e;

    /* JADX INFO: renamed from: i */
    private static float f6290i;

    /* JADX INFO: renamed from: j */
    private static float f6291j;

    /* JADX INFO: renamed from: F */
    private static boolean f6292F;

    /* JADX INFO: renamed from: G */
    private static boolean f6293G;

    /* JADX INFO: renamed from: P */
    private static int f6294P;

    /* JADX INFO: renamed from: Q */
    private static int f6295Q;

    /* JADX INFO: renamed from: R */
    private static int f6296R;

    /* JADX INFO: renamed from: a */
    private static long f6297a;

    /* JADX INFO: renamed from: S */
    private static int f6298S;

    /* JADX INFO: renamed from: T */
    private static int f6299T;

    /* JADX INFO: renamed from: U */
    private static int f6300U;

    /* JADX INFO: renamed from: f */
    private static double f6301f;

    /* JADX INFO: renamed from: V */
    private static int f6303V;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Object f6287a = new Object();

    /* JADX INFO: renamed from: a */
    private static final float[] f6302a = new float[128];

    /* JADX INFO: renamed from: b */
    private static final int[] f6304b = new int[a.values().length];

    /* JADX INFO: renamed from: com.boehmod.blockfront.v$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/v$a.class */
    public enum a {
        PACKET,
        SCREEN,
        CAMERA,
        VEHICLE,
        STATE,
        WINDOW
    }

    private C1154v() {
    }

    /* JADX INFO: renamed from: a */
    public static void m6580a(double d, double d2) {
        synchronized (f6287a) {
            f6288d += d;
            f6289e += d2;
        }
    }

    /* JADX INFO: renamed from: o */
    public static void m6581o() {
        synchronized (f6287a) {
            f6294P = 2;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m6582a(@NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer) {
        synchronized (f6287a) {
            double d = f6288d;
            double d2 = f6289e;
            f6288d = 0.0d;
            f6289e = 0.0d;
            if (localPlayer == null) {
                f6292F = false;
                return;
            }
            int iIdentityHashCode = System.identityHashCode(localPlayer);
            if (iIdentityHashCode != f6296R) {
                f6296R = iIdentityHashCode;
                f6295Q = 40;
                f6292F = false;
            }
            float yRot = localPlayer.getYRot();
            float xRot = localPlayer.getXRot();
            boolean z = true;
            if (f6294P > 0) {
                f6294P--;
                int[] iArr = f6304b;
                int iOrdinal = a.PACKET.ordinal();
                iArr[iOrdinal] = iArr[iOrdinal] + 1;
            } else if (f6295Q > 0) {
                f6295Q--;
            } else if (minecraft.screen != null || !minecraft.mouseHandler.isMouseGrabbed()) {
                int[] iArr2 = f6304b;
                int iOrdinal2 = a.SCREEN.ordinal();
                iArr2[iOrdinal2] = iArr2[iOrdinal2] + 1;
            } else if (minecraft.getCameraEntity() != localPlayer) {
                int[] iArr3 = f6304b;
                int iOrdinal3 = a.CAMERA.ordinal();
                iArr3[iOrdinal3] = iArr3[iOrdinal3] + 1;
            } else if (localPlayer.isPassenger()) {
                int[] iArr4 = f6304b;
                int iOrdinal4 = a.VEHICLE.ordinal();
                iArr4[iOrdinal4] = iArr4[iOrdinal4] + 1;
            } else if (localPlayer.isSleeping() || localPlayer.isDeadOrDying() || localPlayer.isRemoved()) {
                int[] iArr5 = f6304b;
                int iOrdinal5 = a.STATE.ordinal();
                iArr5[iOrdinal5] = iArr5[iOrdinal5] + 1;
            } else if (!minecraft.isWindowActive()) {
                int[] iArr6 = f6304b;
                int iOrdinal6 = a.WINDOW.ordinal();
                iArr6[iOrdinal6] = iArr6[iOrdinal6] + 1;
            } else {
                z = false;
            }
            if (z || !f6292F) {
                f6290i = yRot;
                f6291j = xRot;
                f6292F = true;
                f6293G = true;
                return;
            }
            if (f6293G) {
                f6293G = false;
                f6290i = yRot;
                f6291j = xRot;
                return;
            }
            double d3 = ((double) (yRot - f6290i)) - d;
            double d4 = ((double) (xRot - f6291j)) - d2;
            f6290i = yRot;
            f6291j = xRot;
            double dHypot = Math.hypot(d3, d4);
            f6297a++;
            if (dHypot > 0.25d) {
                f6298S++;
                f6299T++;
                f6300U = Math.max(f6300U, f6299T);
                f6301f = Math.max(f6301f, dHypot);
                f6302a[f6303V % 128] = (float) dHypot;
                f6303V++;
            } else {
                f6299T = 0;
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static b m6583a() {
        long j;
        int i;
        int i2;
        double d;
        float[] fArrCopyOf;
        int[] iArr;
        synchronized (f6287a) {
            j = f6297a;
            i = f6298S;
            i2 = f6300U;
            d = f6301f;
            fArrCopyOf = Arrays.copyOf(f6302a, Math.min(f6303V, 128));
            iArr = (int[]) f6304b.clone();
        }
        double d2 = 0.0d;
        if (fArrCopyOf.length > 0) {
            Arrays.sort(fArrCopyOf);
            d2 = fArrCopyOf[fArrCopyOf.length / 2];
        }
        return new b(j, i, i2, d2, d, iArr);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.v$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/v$b.class */
    public static final class b extends Record {

        /* JADX INFO: renamed from: b */
        private final long f6305b;

        /* JADX INFO: renamed from: W */
        private final int f6306W;

        /* JADX INFO: renamed from: X */
        private final int f6307X;

        /* JADX INFO: renamed from: g */
        private final double f6308g;

        /* JADX INFO: renamed from: h */
        private final double f6309h;

        /* JADX INFO: renamed from: c */
        private final int[] f6310c;

        public b(long j, int i, int i2, double d, double d2, int[] iArr) {
            this.f6305b = j;
            this.f6306W = i;
            this.f6307X = i2;
            this.f6308g = d;
            this.f6309h = d2;
            this.f6310c = iArr;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "sampledTicks;mismatchTicks;longestRun;medianMagnitude;maxMagnitude;skipCounts", "FIELD:Lcom/boehmod/blockfront/v$b;->b:J", "FIELD:Lcom/boehmod/blockfront/v$b;->W:I", "FIELD:Lcom/boehmod/blockfront/v$b;->X:I", "FIELD:Lcom/boehmod/blockfront/v$b;->g:D", "FIELD:Lcom/boehmod/blockfront/v$b;->h:D", "FIELD:Lcom/boehmod/blockfront/v$b;->c:[I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "sampledTicks;mismatchTicks;longestRun;medianMagnitude;maxMagnitude;skipCounts", "FIELD:Lcom/boehmod/blockfront/v$b;->b:J", "FIELD:Lcom/boehmod/blockfront/v$b;->W:I", "FIELD:Lcom/boehmod/blockfront/v$b;->X:I", "FIELD:Lcom/boehmod/blockfront/v$b;->g:D", "FIELD:Lcom/boehmod/blockfront/v$b;->h:D", "FIELD:Lcom/boehmod/blockfront/v$b;->c:[I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "sampledTicks;mismatchTicks;longestRun;medianMagnitude;maxMagnitude;skipCounts", "FIELD:Lcom/boehmod/blockfront/v$b;->b:J", "FIELD:Lcom/boehmod/blockfront/v$b;->W:I", "FIELD:Lcom/boehmod/blockfront/v$b;->X:I", "FIELD:Lcom/boehmod/blockfront/v$b;->g:D", "FIELD:Lcom/boehmod/blockfront/v$b;->h:D", "FIELD:Lcom/boehmod/blockfront/v$b;->c:[I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: a */
        public long m6584a() {
            return this.f6305b;
        }

        /* JADX INFO: renamed from: h */
        public int m6585h() {
            return this.f6306W;
        }

        /* JADX INFO: renamed from: i */
        public int m6586i() {
            return this.f6307X;
        }

        /* JADX INFO: renamed from: a */
        public double m6587a() {
            return this.f6308g;
        }

        /* JADX INFO: renamed from: b */
        public double m6588b() {
            return this.f6309h;
        }

        /* JADX INFO: renamed from: a */
        public int[] m6589a() {
            return this.f6310c;
        }
    }
}
