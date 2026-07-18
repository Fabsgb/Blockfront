package com.boehmod.blockfront;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iE.class */
public final class C0468iE {
    private C0468iE() {
    }

    /* JADX INFO: renamed from: c */
    public static boolean m2116c(@NotNull LocalPlayer localPlayer) {
        Item item = localPlayer.getMainHandItem().getItem();
        return (item instanceof C1144ur) && ((C1144ur) item).m6361cu();
    }

    /* JADX INFO: renamed from: d */
    public static boolean m2117d(@NotNull LocalPlayer localPlayer) {
        return m2116c(localPlayer) || C0300ew.m1583J();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2118a(@NotNull LocalPlayer localPlayer, int i) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null) {
            return false;
        }
        if (m2117d(localPlayer)) {
            return true;
        }
        AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622lM2667b.m2692a();
        return abstractC0788oGM2692a != null && abstractC0788oGM2692a.mo3721bk() && !C0799oR.m4033h(localPlayer) && i >= 0 && i < 9 && localPlayer.getInventory().getItem(i).isEmpty();
    }
}
