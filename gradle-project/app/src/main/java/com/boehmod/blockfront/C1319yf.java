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

/* JADX INFO: renamed from: com.boehmod.blockfront.yf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/yf.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public class C1319yf {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m8273a(@NotNull PlayerTickEvent.Post post) {
        ServerPlayer entity = post.getEntity();
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a instanceof C1280xT) {
            C1280xT c1280xT = (C1280xT) abstractC0531jNM179a;
            C1328yo c1328yo = (C1328yo) c1280xT.m7277a();
            UUID uuid = entity.getUUID();
            C1326ym c1326ym = (C1326ym) c1328yo.m1150a((Player) entity);
            C0555jl c0555jlA = c1328yo.m1150a((Player) entity);
            ServerLevel serverLevel = entity.serverLevel();
            AbstractC0863pb<?, ?, ?> abstractC0863pbA = c1280xT.mo2354a(uuid);
            c1326ym.m8305a(c1280xT, serverLevel, entity, abstractC0863pbA);
            c0555jlA.m2513b((Player) entity);
            c0555jlA.m2514a(c1280xT);
            boolean zMo2374f = c1280xT.mo2374f();
            if (abstractC0863pbA != null) {
                abstractC0863pbA.m4018b().m4215a(c1280xT, serverLevel, entity, entity.getScoreboardName(), uuid, zMo2374f, c0555jlA, c1326ym);
            }
        }
    }
}
