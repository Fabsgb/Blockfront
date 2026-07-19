package com.boehmod.blockfront;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iE.class */
public final class iE {
    private iE() {
    }

    public static boolean c(@NotNull LocalPlayer localPlayer) {
        Item item = localPlayer.getMainHandItem().getItem();
        return (item instanceof C0558ur) && ((C0558ur) item).cu();
    }

    public static boolean d(@NotNull LocalPlayer localPlayer) {
        return c(localPlayer) || C0132ew.J();
    }

    public static boolean a(@NotNull LocalPlayer localPlayer, int i) {
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null) {
            return false;
        }
        if (d(localPlayer)) {
            return true;
        }
        oG<?, ?> oGVarM593a = c0297lB.m593a();
        return oGVarM593a != null && oGVarM593a.bk() && !oR.h(localPlayer) && i >= 0 && i < 9 && localPlayer.getInventory().getItem(i).isEmpty();
    }
}
