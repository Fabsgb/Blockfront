package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.uv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uv.class */
public class C1148uv {

    /* JADX INFO: renamed from: ni */
    public static final float f6076ni = 0.5f;

    /* JADX INFO: renamed from: nj */
    public static final float f6077nj = 1.0E-4f;

    /* JADX INFO: renamed from: nk */
    public static final float f6078nk = 0.0f;

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    /* JADX INFO: renamed from: a */
    public static float m6430a(@NotNull C1051tD c1051tD, @NotNull EnumC1059tL enumC1059tL, boolean z, @Nullable C1108uH c1108uH, float f, float f2) throws MatchException {
        float fM5840bl;
        switch (enumC1059tL) {
            case IDLE:
                fM5840bl = !z ? c1051tD.m5843bo() : c1051tD.m5844bp();
                break;
            case WALKING:
                fM5840bl = !z ? c1051tD.m5841bm() : c1051tD.m5842bn();
                break;
            case CRAWLING:
                fM5840bl = !z ? c1051tD.m5845bq() : c1051tD.m5846br();
                break;
            case SPRINTING:
            case JUMPING:
                fM5840bl = c1051tD.m5840bl();
                break;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
        float f3 = fM5840bl * (1.0f - (f * 0.5f));
        if (z && c1108uH != null) {
            f3 *= 1.0f - ((1.0f - c1108uH.f5824nu) * f2);
        }
        return Math.max(0.0f, f3);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public static float m6431a(@NotNull C1051tD c1051tD, @Nullable C1108uH c1108uH, boolean z) {
        return m6430a(c1051tD, C0110bb.f672a, z, c1108uH, C0050aU.f330bv, C0053aX.f366bO);
    }

    /* JADX INFO: renamed from: b */
    public static float m6432b(@NotNull C1051tD c1051tD, @Nullable C1108uH c1108uH, boolean z) {
        return m6430a(c1051tD, EnumC1059tL.CRAWLING, true, c1108uH, z ? 1.0f : 0.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static float m6433a(@Nullable C1108uH c1108uH, @NotNull C1051tD c1051tD) {
        return m6430a(c1051tD, EnumC1059tL.JUMPING, false, c1108uH, 0.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m6434a(float f, float f2, float f3) {
        return f >= f2 - 1.0E-4f && f <= f3 + 1.0E-4f;
    }
}
