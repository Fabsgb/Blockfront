package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: com.boehmod.blockfront.iN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iN.class */
@OnlyIn(Dist.CLIENT)
public final class C0478iN {
    private C0478iN() {
    }

    /* JADX INFO: renamed from: a */
    public static float[] m2143a(float[] fArr, int i, int i2, C0480iP c0480iP) {
        float[] fArrM2158a = c0480iP.m2158a();
        float[] fArrM2159b = c0480iP.m2159b();
        float[] fArrM2160c = c0480iP.m2160c();
        float[] fArrM2163d = c0480iP.m2163d();
        float fM2161S = c0480iP.m2161S();
        float fM2162T = c0480iP.m2162T();
        float fM2164U = c0480iP.m2164U();
        int iM2157R = (int) (c0480iP.m2157R() * i2);
        int iM2156Q = i + ((int) (c0480iP.m2156Q() * i2));
        float[] fArr2 = new float[iM2156Q];
        for (int i3 = 0; i3 < fArrM2158a.length; i3++) {
            int i4 = iM2157R + ((int) (fArrM2158a[i3] * i2));
            float f = fArrM2159b[i3];
            int iMin = Math.min(i, iM2156Q - i4);
            for (int i5 = 0; i5 < iMin; i5++) {
                int i6 = i5 + i4;
                fArr2[i6] = fArr2[i6] + (fArr[i5] * f);
            }
        }
        float length = 1.0f / fArrM2160c.length;
        for (float f2 : fArrM2160c) {
            int iMax = Math.max(1, (int) (f2 * i2));
            float[] fArr3 = new float[iMax];
            float f3 = 0.0f;
            int i7 = 0;
            for (int i8 = 0; i8 < iM2156Q; i8++) {
                int i9 = i8 - iM2157R;
                float f4 = (i9 < 0 || i9 >= i) ? 0.0f : fArr[i9];
                float f5 = fArr3[i7];
                f3 = (f5 * (1.0f - fM2162T)) + (f3 * fM2162T);
                fArr3[i7] = f4 + (f3 * fM2161S);
                int i10 = i8;
                fArr2[i10] = fArr2[i10] + (f5 * length);
                i7++;
                if (i7 == iMax) {
                    i7 = 0;
                }
            }
        }
        for (float f6 : fArrM2163d) {
            int iMax2 = Math.max(1, (int) (f6 * i2));
            float[] fArr4 = new float[iMax2];
            int i11 = 0;
            for (int i12 = 0; i12 < iM2156Q; i12++) {
                float f7 = fArr2[i12];
                float f8 = ((-fM2164U) * f7) + fArr4[i11];
                fArr4[i11] = f7 + (fM2164U * f8);
                fArr2[i12] = f8;
                i11++;
                if (i11 == iMax2) {
                    i11 = 0;
                }
            }
        }
        float fM2165V = c0480iP.m2165V();
        float fM2166W = c0480iP.m2166W();
        int i13 = 0;
        while (i13 < iM2156Q) {
            fArr2[i13] = (fM2165V * (i13 < i ? fArr[i13] : 0.0f)) + (fM2166W * fArr2[i13]);
            i13++;
        }
        float fM2167X = c0480iP.m2167X();
        float f9 = 0.0f;
        for (float f10 : fArr2) {
            float fAbs = Math.abs(f10);
            if (fAbs > f9) {
                f9 = fAbs;
            }
        }
        if (f9 > fM2167X) {
            float f11 = fM2167X / f9;
            for (int i14 = 0; i14 < iM2156Q; i14++) {
                int i15 = i14;
                fArr2[i15] = fArr2[i15] * f11;
            }
        }
        return fArr2;
    }
}
