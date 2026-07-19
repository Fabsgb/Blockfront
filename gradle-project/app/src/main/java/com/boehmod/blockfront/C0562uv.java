package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.uv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uv.class */
public class C0562uv {
    public static final float ni = 0.5f;
    public static final float nj = 1.0E-4f;
    public static final float nk = 0.0f;

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public static float a(@NotNull tD tDVar, @NotNull tL tLVar, boolean z, @Nullable uH uHVar, float f, float f2) throws MatchException {
        float fBl;
        switch (tLVar) {
            case IDLE:
                fBl = !z ? tDVar.bo() : tDVar.bp();
                break;
            case WALKING:
                fBl = !z ? tDVar.bm() : tDVar.bn();
                break;
            case CRAWLING:
                fBl = !z ? tDVar.bq() : tDVar.br();
                break;
            case SPRINTING:
            case JUMPING:
                fBl = tDVar.bl();
                break;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
        float f3 = fBl * (1.0f - (f * 0.5f));
        if (z && uHVar != null) {
            f3 *= 1.0f - ((1.0f - uHVar.nu) * f2);
        }
        return Math.max(0.0f, f3);
    }

    @OnlyIn(Dist.CLIENT)
    public static float a(@NotNull tD tDVar, @Nullable uH uHVar, boolean z) {
        return a(tDVar, C0031bb.a, z, uHVar, aU.bv, aX.bO);
    }

    public static float b(@NotNull tD tDVar, @Nullable uH uHVar, boolean z) {
        return a(tDVar, tL.CRAWLING, true, uHVar, z ? 1.0f : 0.0f, 1.0f);
    }

    public static float a(@Nullable uH uHVar, @NotNull tD tDVar) {
        return a(tDVar, tL.JUMPING, false, uHVar, 0.0f, 1.0f);
    }

    public static boolean a(float f, float f2, float f3) {
        return f >= f2 - 1.0E-4f && f <= f3 + 1.0E-4f;
    }
}
