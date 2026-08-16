package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iS.class */
public final class C0483iS {
    private C0483iS() {
    }

    /* JADX INFO: renamed from: e */
    public static boolean m2168e(@NotNull Minecraft minecraft) {
        LocalPlayer localPlayer;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null) {
            return false;
        }
        C0394gj c0394gjM1885a = ((C0396gl) c0623lM2852b.m2855a()).m1885a(minecraft);
        if (c0394gjM1885a.m1104dt() || (localPlayer = minecraft.player) == null || C0875pn.m4488a((Player) localPlayer, (AbstractC0183b<?, ?, ?, ?>) c0394gjM1885a)) {
            return false;
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        return (abstractC0863pbM2874a instanceof InterfaceC0977rj) && abstractC0863pbM2874a.m4023a() == EnumC0871pj.GAME && minecraft.screen == null;
    }

    /* JADX INFO: renamed from: a */
    public static void m2169a(@NotNull Minecraft minecraft, @NotNull EnumC0883pv enumC0883pv) {
        LocalPlayer localPlayer;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null || (localPlayer = minecraft.player) == null) {
            return;
        }
        C0394gj c0394gjM1885a = ((C0396gl) c0623lM2852b.m2855a()).m1885a(minecraft);
        if (!C0875pn.m4488a((Player) localPlayer, (AbstractC0183b<?, ?, ?, ?>) c0394gjM1885a) && c0394gjM1885a.f1413vh <= 0) {
            c0394gjM1885a.f1413vh = 80;
            C1169vO.m6648c(new C1221wN(enumC0883pv));
        }
    }
}
