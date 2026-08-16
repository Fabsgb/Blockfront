package com.boehmod.blockfront;

import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.uV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uV.class */
public class C1123uV {

    /* JADX INFO: renamed from: og */
    public static final float f6145og = 0.5f;

    /* JADX INFO: renamed from: oh */
    public static final float f6146oh = 1.0E-4f;

    /* JADX INFO: renamed from: oi */
    public static final float f6147oi = 0.0f;

    /* JADX INFO: renamed from: a */
    public static float m6416a(@NotNull C1129ub c1129ub, @NotNull EnumC1137uj enumC1137uj, @Nullable C1188vh c1188vh, float f, float f2) {
        float fM6476br;
        float fM6476br2;
        float fClamp = Mth.clamp(f2, 0.0f, 1.0f);
        switch (enumC1137uj) {
            case IDLE:
                fM6476br = c1129ub.m6479bu();
                fM6476br2 = c1129ub.m6480bv();
                break;
            case WALKING:
                fM6476br = c1129ub.m6477bs();
                fM6476br2 = c1129ub.m6478bt();
                break;
            case CRAWLING:
                fM6476br = c1129ub.m6481bw();
                fM6476br2 = c1129ub.m6482bx();
                break;
            default:
                fM6476br = c1129ub.m6476br();
                fM6476br2 = c1129ub.m6476br();
                break;
        }
        float fLerp = Mth.lerp(fClamp, fM6476br, fM6476br2) * (1.0f - (f * 0.5f));
        if (c1188vh != null) {
            fLerp *= 1.0f - ((1.0f - c1188vh.f6463os) * fClamp);
        }
        return Math.max(0.0f, fLerp);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public static float m6417a(@NotNull C1129ub c1129ub, @Nullable C1188vh c1188vh) {
        return m6416a(c1129ub, C0119bj.f803a, c1188vh, C0112bc.f744bB, (C0115bf.f780bU + C0115bf.f781bV) / 2.0f);
    }

    /* JADX INFO: renamed from: a */
    public static float m6418a(@NotNull C1129ub c1129ub, @Nullable C1188vh c1188vh, boolean z) {
        return m6416a(c1129ub, EnumC1137uj.CRAWLING, c1188vh, z ? 1.0f : 0.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static float m6419a(@Nullable C1188vh c1188vh, @NotNull C1129ub c1129ub) {
        return m6416a(c1129ub, EnumC1137uj.JUMPING, c1188vh, 0.0f, 0.0f);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m6420a(float f, float f2, float f3) {
        return f >= f2 - 1.0E-4f && f <= f3 + 1.0E-4f;
    }
}
