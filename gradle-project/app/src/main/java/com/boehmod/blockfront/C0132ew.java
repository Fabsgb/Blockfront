package com.boehmod.blockfront;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ew, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ew.class */
@OnlyIn(Dist.CLIENT)
public final class C0132ew {
    private static boolean cd = false;
    private static boolean ce = false;
    private static int ip = 0;

    @Nullable
    private static C0550uj a = null;

    private C0132ew() {
    }

    public static boolean J() {
        return cd;
    }

    public static boolean K() {
        return ce;
    }

    public static int aa() {
        return ip;
    }

    public static int ab() {
        if (a == null) {
            return 0;
        }
        return a.ab();
    }

    public static void a(@NotNull C0550uj c0550uj, boolean z) {
        cd = true;
        a = c0550uj;
        ce = z;
        ip = 0;
    }

    public static void av() {
        cd = false;
        a = null;
        ip = 0;
    }

    public static float u() {
        int iAb;
        if (!cd || a == null || (iAb = a.ab()) <= 0) {
            return 0.0f;
        }
        return Mth.clamp(ip / iAb, 0.0f, 1.0f);
    }

    public static void f(@Nullable LocalPlayer localPlayer) {
        if (cd) {
            if (localPlayer == null || a == null || localPlayer.getMainHandItem().getItem() != a) {
                av();
                return;
            }
            C0297l c0297lB = C0297l.b();
            if (c0297lB != null) {
                fT fTVar = (fT) ((fV) c0297lB.a()).a((Player) localPlayer);
                if (oR.a((Player) localPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) fTVar) || fTVar.dm()) {
                    av();
                    return;
                }
            }
            ip++;
            if (ip >= a.ab()) {
                av();
            }
        }
    }
}
