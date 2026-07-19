package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: com.boehmod.blockfront.iw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iw.class */
@OnlyIn(Dist.CLIENT)
public final class C0239iw {
    private C0239iw() {
    }

    public static float[] a(float[] fArr, int i, C0241iy c0241iy) {
        float[] fArrA = c0241iy.a();
        float[] fArrB = c0241iy.b();
        float[] fArrC = c0241iy.c();
        float[] fArrD = c0241iy.d();
        float fS = c0241iy.S();
        float fT = c0241iy.T();
        float fU = c0241iy.U();
        int iR = (int) (c0241iy.R() * i);
        int length = fArr.length + ((int) (c0241iy.Q() * i));
        float[] fArr2 = new float[length];
        for (int i2 = 0; i2 < fArrA.length; i2++) {
            int i3 = iR + ((int) (fArrA[i2] * i));
            float f = fArrB[i2];
            for (int i4 = 0; i4 < fArr.length; i4++) {
                int i5 = i4 + i3;
                if (i5 < length) {
                    fArr2[i5] = fArr2[i5] + (fArr[i4] * f);
                }
            }
        }
        float[] fArr3 = new float[length];
        for (float f2 : fArrC) {
            int iMax = Math.max(1, (int) (f2 * i));
            float[] fArr4 = new float[iMax];
            float f3 = 0.0f;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = i7 - iR;
                float f4 = (i8 < 0 || i8 >= fArr.length) ? 0.0f : fArr[i8];
                float f5 = fArr4[i6];
                f3 = (f5 * (1.0f - fT)) + (f3 * fT);
                fArr4[i6] = f4 + (f3 * fS);
                int i9 = i7;
                fArr3[i9] = fArr3[i9] + f5;
                i6++;
                if (i6 == iMax) {
                    i6 = 0;
                }
            }
        }
        float length2 = 1.0f / fArrC.length;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10;
            fArr2[i11] = fArr2[i11] + (fArr3[i10] * length2);
        }
        for (float f6 : fArrD) {
            int iMax2 = Math.max(1, (int) (f6 * i));
            float[] fArr5 = new float[iMax2];
            int i12 = 0;
            for (int i13 = 0; i13 < length; i13++) {
                float f7 = fArr2[i13];
                float f8 = ((-fU) * f7) + fArr5[i12];
                fArr5[i12] = f7 + (fU * f8);
                fArr2[i13] = f8;
                i12++;
                if (i12 == iMax2) {
                    i12 = 0;
                }
            }
        }
        float fV = c0241iy.V();
        float fW = c0241iy.W();
        float[] fArr6 = new float[length];
        int i14 = 0;
        while (i14 < length) {
            fArr6[i14] = (fV * (i14 < fArr.length ? fArr[i14] : 0.0f)) + (fW * fArr2[i14]);
            i14++;
        }
        float fX = c0241iy.X();
        float f9 = 0.0f;
        for (float f10 : fArr6) {
            float fAbs = Math.abs(f10);
            if (fAbs > f9) {
                f9 = fAbs;
            }
        }
        if (f9 > fX) {
            float f11 = fX / f9;
            for (int i15 = 0; i15 < length; i15++) {
                int i16 = i15;
                fArr6[i16] = fArr6[i16] * f11;
            }
        }
        return fArr6;
    }
}
