package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;

/* JADX INFO: renamed from: com.boehmod.blockfront.yb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/yb.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public final class C1315yb {
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        r0 = (com.boehmod.blockfront.C1280xT) r0;
     */
    @net.neoforged.bus.api.SubscribeEvent
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m8267a(@org.jetbrains.annotations.NotNull net.neoforged.neoforge.event.ServerChatEvent r8) {
        /*
            com.boehmod.blockfront.a r0 = com.boehmod.blockfront.C0030a.m175a()
            com.boehmod.blockfront.jN r0 = r0.m179a()
            r10 = r0
            r0 = r10
            boolean r0 = r0 instanceof com.boehmod.blockfront.C1280xT
            if (r0 == 0) goto L16
            r0 = r10
            com.boehmod.blockfront.xT r0 = (com.boehmod.blockfront.C1280xT) r0
            r9 = r0
            goto L17
        L16:
            return
        L17:
            r0 = r8
            net.minecraft.server.level.ServerPlayer r0 = r0.getPlayer()
            r10 = r0
            r0 = r10
            java.util.UUID r0 = r0.getUUID()
            r11 = r0
            r0 = r9
            r1 = r11
            com.boehmod.blockfront.pb r0 = r0.mo2354a(r1)
            r12 = r0
            r0 = r12
            if (r0 != 0) goto L2e
            return
        L2e:
            r0 = r10
            net.minecraft.server.level.ServerLevel r0 = r0.serverLevel()
            r13 = r0
            r0 = r9
            r1 = r9
            com.boehmod.blockfront.common.player.c r1 = r1.m7277a()
            com.boehmod.blockfront.yo r1 = (com.boehmod.blockfront.C1328yo) r1
            r2 = r12
            r3 = r13
            r4 = r10
            r5 = r8
            net.minecraft.network.chat.Component r5 = r5.getMessage()
            r6 = r11
            com.boehmod.blockfront.C0875pn.m4493a(r0, r1, r2, r3, r4, r5, r6)
            r0 = r8
            r1 = 1
            r0.setCanceled(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.boehmod.blockfront.C1315yb.m8267a(net.neoforged.neoforge.event.ServerChatEvent):void");
    }
}
