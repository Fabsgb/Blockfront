package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.eJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eJ.class */
@OnlyIn(Dist.CLIENT)
public final class C0262eJ {

    /* JADX INFO: renamed from: cl */
    private static boolean f2155cl = false;

    /* JADX INFO: renamed from: cm */
    private static boolean f2156cm = false;

    /* JADX INFO: renamed from: jF */
    private static int f2157jF = 0;

    /* JADX INFO: renamed from: a */
    @Nullable
    private static C1109uH f2158a = null;

    private C0262eJ() {
    }

    /* JADX INFO: renamed from: K */
    public static boolean m1487K() {
        return f2155cl;
    }

    /* JADX INFO: renamed from: L */
    public static boolean m1488L() {
        return f2156cm;
    }

    /* JADX INFO: renamed from: ak */
    public static int m1489ak() {
        return f2157jF;
    }

    /* JADX INFO: renamed from: al */
    public static int m1490al() {
        if (f2158a == null) {
            return 0;
        }
        return f2158a.mo6210al();
    }

    /* JADX INFO: renamed from: a */
    public static void m1491a(@NotNull C1109uH c1109uH, boolean z) {
        f2155cl = true;
        f2158a = c1109uH;
        f2156cm = z;
        f2157jF = 0;
    }

    /* JADX INFO: renamed from: aA */
    public static void m1492aA() {
        f2155cl = false;
        f2158a = null;
        f2157jF = 0;
    }

    /* JADX INFO: renamed from: u */
    public static float m1493u() {
        int iMo6210al;
        if (!f2155cl || f2158a == null || (iMo6210al = f2158a.mo6210al()) <= 0) {
            return 0.0f;
        }
        return Mth.clamp(f2157jF / iMo6210al, 0.0f, 1.0f);
    }

    /* JADX INFO: renamed from: f */
    public static void m1494f(@Nullable LocalPlayer localPlayer) {
        if (f2155cl) {
            if (localPlayer == null || f2158a == null || localPlayer.getMainHandItem().getItem() != f2158a) {
                m1492aA();
                return;
            }
            C0623l c0623lM2852b = C0623l.m2852b();
            if (c0623lM2852b != null) {
                C0394gj c0394gj = (C0394gj) ((C0396gl) c0623lM2852b.m2855a()).m1150a((Player) localPlayer);
                if (C0875pn.m4488a((Player) localPlayer, (AbstractC0183b<?, ?, ?, ?>) c0394gj) || c0394gj.m1110dv()) {
                    m1492aA();
                    return;
                }
            }
            f2157jF++;
            if (f2157jF >= f2158a.mo6210al()) {
                m1492aA();
            }
        }
    }
}
