package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ew */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ew.class */
@OnlyIn(Dist.CLIENT)
public final class C0300ew {

    /* JADX INFO: renamed from: cd */
    private static boolean f2285cd = false;

    /* JADX INFO: renamed from: ce */
    private static boolean f2286ce = false;

    /* JADX INFO: renamed from: ip */
    private static int f2287ip = 0;

    /* JADX INFO: renamed from: a */
    @Nullable
    private static C1136uj f2288a = null;

    private C0300ew() {
    }

    /* JADX INFO: renamed from: J */
    public static boolean m1583J() {
        return f2285cd;
    }

    /* JADX INFO: renamed from: K */
    public static boolean m1584K() {
        return f2286ce;
    }

    /* JADX INFO: renamed from: aa */
    public static int m1585aa() {
        return f2287ip;
    }

    /* JADX INFO: renamed from: ab */
    public static int m1586ab() {
        if (f2288a == null) {
            return 0;
        }
        return f2288a.mo6250ab();
    }

    /* JADX INFO: renamed from: a */
    public static void m1587a(@NotNull C1136uj c1136uj, boolean z) {
        f2285cd = true;
        f2288a = c1136uj;
        f2286ce = z;
        f2287ip = 0;
    }

    /* JADX INFO: renamed from: av */
    public static void m1588av() {
        f2285cd = false;
        f2288a = null;
        f2287ip = 0;
    }

    /* JADX INFO: renamed from: u */
    public static float m1589u() {
        int iMo6250ab;
        if (!f2285cd || f2288a == null || (iMo6250ab = f2288a.mo6250ab()) <= 0) {
            return 0.0f;
        }
        return Mth.clamp(f2287ip / iMo6250ab, 0.0f, 1.0f);
    }

    /* JADX INFO: renamed from: f */
    public static void m1590f(@Nullable LocalPlayer localPlayer) {
        if (f2285cd) {
            if (localPlayer == null || f2288a == null || localPlayer.getMainHandItem().getItem() != f2288a) {
                m1588av();
                return;
            }
            C0622l c0622lM2667b = C0622l.m2667b();
            if (c0622lM2667b != null) {
                C0324fT c0324fT = (C0324fT) ((C0326fV) c0622lM2667b.m2670a()).m1133a((Player) localPlayer);
                if (C0799oR.m4052a((Player) localPlayer, (AbstractC0182b<?, ?, ?, ?>) c0324fT) || c0324fT.m1093dm()) {
                    m1588av();
                    return;
                }
            }
            f2287ip++;
            if (f2287ip >= f2288a.mo6250ab()) {
                m1588av();
            }
        }
    }
}
