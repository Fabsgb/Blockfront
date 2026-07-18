package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: com.boehmod.blockfront.iw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iw.class */
@OnlyIn(Dist.CLIENT)
public final class C0512iw {
    private C0512iw() {
    }

    /* JADX INFO: renamed from: a */
    public static float[] m2254a(float[] fArr, int i, C0514iy c0514iy) {
        float[] fArrM2260a = c0514iy.m2260a();
        float[] fArrM2261b = c0514iy.m2261b();
        float[] fArrM2262c = c0514iy.m2262c();
        float[] fArrM2265d = c0514iy.m2265d();
        float fM2263S = c0514iy.m2263S();
        float fM2264T = c0514iy.m2264T();
        float fM2266U = c0514iy.m2266U();
        int iM2259R = (int) (c0514iy.m2259R() * i);
        int length = fArr.length + ((int) (c0514iy.m2258Q() * i));
        float[] fArr2 = new float[length];
        for (int i2 = 0; i2 < fArrM2260a.length; i2++) {
            int i3 = iM2259R + ((int) (fArrM2260a[i2] * i));
            float f = fArrM2261b[i2];
            for (int i4 = 0; i4 < fArr.length; i4++) {
                int i5 = i4 + i3;
                if (i5 < length) {
                    fArr2[i5] = fArr2[i5] + (fArr[i4] * f);
                }
            }
        }
        float[] fArr3 = new float[length];
        for (float f2 : fArrM2262c) {
            int iMax = Math.max(1, (int) (f2 * i));
            float[] fArr4 = new float[iMax];
            float f3 = 0.0f;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = i7 - iM2259R;
                float f4 = (i8 < 0 || i8 >= fArr.length) ? 0.0f : fArr[i8];
                float f5 = fArr4[i6];
                f3 = (f5 * (1.0f - fM2264T)) + (f3 * fM2264T);
                fArr4[i6] = f4 + (f3 * fM2263S);
                int i9 = i7;
                fArr3[i9] = fArr3[i9] + f5;
                i6++;
                if (i6 == iMax) {
                    i6 = 0;
                }
            }
        }
        float length2 = 1.0f / fArrM2262c.length;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10;
            fArr2[i11] = fArr2[i11] + (fArr3[i10] * length2);
        }
        for (float f6 : fArrM2265d) {
            int iMax2 = Math.max(1, (int) (f6 * i));
            float[] fArr5 = new float[iMax2];
            int i12 = 0;
            for (int i13 = 0; i13 < length; i13++) {
                float f7 = fArr2[i13];
                float f8 = ((-fM2266U) * f7) + fArr5[i12];
                fArr5[i12] = f7 + (fM2266U * f8);
                fArr2[i13] = f8;
                i12++;
                if (i12 == iMax2) {
                    i12 = 0;
                }
            }
        }
        float fM2267V = c0514iy.m2267V();
        float fM2268W = c0514iy.m2268W();
        float[] fArr6 = new float[length];
        int i14 = 0;
        while (i14 < length) {
            fArr6[i14] = (fM2267V * (i14 < fArr.length ? fArr[i14] : 0.0f)) + (fM2268W * fArr2[i14]);
            i14++;
        }
        float fM2269X = c0514iy.m2269X();
        float f9 = 0.0f;
        for (float f10 : fArr6) {
            float fAbs = Math.abs(f10);
            if (fAbs > f9) {
                f9 = fAbs;
            }
        }
        if (f9 > fM2269X) {
            float f11 = fM2269X / f9;
            for (int i15 = 0; i15 < length; i15++) {
                int i16 = i15;
                fArr6[i16] = fArr6[i16] * f11;
            }
        }
        return fArr6;
    }
}
