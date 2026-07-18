package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xH.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public class C1267xH {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m7757a(@NotNull PlayerTickEvent.Post post) {
        ServerPlayer entity = post.getEntity();
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a instanceof C1300xw) {
            C1300xw c1300xw = (C1300xw) abstractC0563juM168a;
            C1276xQ c1276xQ = (C1276xQ) c1300xw.m7950a();
            UUID uuid = entity.getUUID();
            C1274xO c1274xO = (C1274xO) c1276xQ.m1133a((Player) entity);
            C0482iS c0482iSA = c1276xQ.m1133a((Player) entity);
            ServerLevel serverLevel = entity.serverLevel();
            AbstractC0787oF<?, ?, ?> abstractC0787oFA = c1300xw.mo2531a(uuid);
            c1274xO.m7789a(c1300xw, serverLevel, entity, abstractC0787oFA);
            c0482iSA.m2186b((Player) entity);
            c0482iSA.m2187a(c1300xw);
            boolean zMo2551f = c1300xw.mo2551f();
            if (abstractC0787oFA != null) {
                abstractC0787oFA.m3582b().m3779a(c1300xw, serverLevel, entity, entity.getScoreboardName(), uuid, zMo2551f, c0482iSA, c1274xO);
            }
        }
    }
}
