package com.boehmod.blockfront;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iX.class */
public final class C0488iX {
    private C0488iX() {
    }

    /* JADX INFO: renamed from: c */
    public static boolean m2208c(@NotNull LocalPlayer localPlayer) {
        Item item = localPlayer.getMainHandItem().getItem();
        return (item instanceof C1117uP) && ((C1117uP) item).m6335cD();
    }

    /* JADX INFO: renamed from: d */
    public static boolean m2209d(@NotNull LocalPlayer localPlayer) {
        return m2208c(localPlayer) || C0262eJ.m1487K();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2210a(@NotNull LocalPlayer localPlayer, int i) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null) {
            return false;
        }
        if (m2209d(localPlayer)) {
            return true;
        }
        AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623lM2852b.m2878a();
        return abstractC0864pcM2878a != null && abstractC0864pcM2878a.mo4157bu() && !C0875pn.m4469h(localPlayer) && i >= 0 && i < 9 && localPlayer.getInventory().getItem(i).isEmpty();
    }
}
