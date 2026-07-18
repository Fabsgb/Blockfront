package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iB.class */
public final class C0465iB {
    private C0465iB() {
    }

    /* JADX INFO: renamed from: e */
    public static boolean m2097e(@NotNull Minecraft minecraft) {
        LocalPlayer localPlayer;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null) {
            return false;
        }
        C0324fT c0324fTM1675a = ((C0326fV) c0622lM2667b.m2670a()).m1675a(minecraft);
        if (c0324fTM1675a.m1087dk() || (localPlayer = minecraft.player) == null || C0799oR.m4052a((Player) localPlayer, (AbstractC0182b<?, ?, ?, ?>) c0324fTM1675a)) {
            return false;
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        return (abstractC0787oFM2688a instanceof InterfaceC0900qM) && abstractC0787oFM2688a.m3587a() == EnumC0795oN.GAME && minecraft.screen == null;
    }

    /* JADX INFO: renamed from: a */
    public static void m2098a(@NotNull Minecraft minecraft, @NotNull EnumC0807oZ enumC0807oZ) {
        LocalPlayer localPlayer;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null || (localPlayer = minecraft.player) == null) {
            return;
        }
        C0324fT c0324fTM1675a = ((C0326fV) c0622lM2667b.m2670a()).m1675a(minecraft);
        if (!C0799oR.m4052a((Player) localPlayer, (AbstractC0182b<?, ?, ?, ?>) c0324fTM1675a) && c0324fTM1675a.f1491td <= 0) {
            c0324fTM1675a.f1491td = 80;
            C1194vo.m6653c(new C1248wp(enumC0807oZ));
        }
    }
}
