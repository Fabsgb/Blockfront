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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xH.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public class xH {
    @SubscribeEvent
    public static void a(@NotNull PlayerTickEvent.Post post) {
        ServerPlayer entity = post.getEntity();
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a instanceof xw) {
            xw xwVar = (xw) abstractC0264juM166a;
            xQ xQVar = (xQ) xwVar.a();
            UUID uuid = entity.getUUID();
            xO xOVar = (xO) xQVar.a((Player) entity);
            iS iSVarA = xQVar.a((Player) entity);
            ServerLevel serverLevel = entity.serverLevel();
            oF<?, ?, ?> oFVarA = xwVar.mo604a(uuid);
            xOVar.a(xwVar, serverLevel, entity, oFVarA);
            iSVarA.b((Player) entity);
            iSVarA.a(xwVar);
            boolean zF = xwVar.f();
            if (oFVarA != null) {
                oFVarA.b().a(xwVar, serverLevel, entity, entity.getScoreboardName(), uuid, zF, iSVarA, xOVar);
            }
        }
    }
}
