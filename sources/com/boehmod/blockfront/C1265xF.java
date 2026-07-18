package com.boehmod.blockfront;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xF.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public class C1265xF {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m7753a(@NotNull PlayerEvent.PlayerLoggedInEvent playerLoggedInEvent) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a instanceof C1300xw) {
            ((C1300xw) abstractC0563juM168a).m7956k((ServerPlayer) playerLoggedInEvent.getEntity());
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m7754a(@NotNull PlayerEvent.PlayerLoggedOutEvent playerLoggedOutEvent) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a instanceof C1300xw) {
            ((C1300xw) abstractC0563juM168a).m7955j((ServerPlayer) playerLoggedOutEvent.getEntity());
        }
    }
}
