package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iB.class */
public final class iB {
    private iB() {
    }

    public static boolean e(@NotNull Minecraft minecraft) {
        LocalPlayer localPlayer;
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null) {
            return false;
        }
        fT fTVarA = ((fV) c0297lB.a()).a(minecraft);
        if (fTVarA.dk() || (localPlayer = minecraft.player) == null || oR.a((Player) localPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) fTVarA)) {
            return false;
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        return (oFVarM591a instanceof qM) && oFVarM591a.m750a() == oN.GAME && minecraft.screen == null;
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull oZ oZVar) {
        LocalPlayer localPlayer;
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null || (localPlayer = minecraft.player) == null) {
            return;
        }
        fT fTVarA = ((fV) c0297lB.a()).a(minecraft);
        if (!oR.a((Player) localPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) fTVarA) && fTVarA.td <= 0) {
            fTVarA.td = 80;
            C0582vo.c(new C0610wp(oZVar));
        }
    }
}
