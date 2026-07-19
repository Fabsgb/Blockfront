package com.boehmod.blockfront;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xJ.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public final class xJ {
    @SubscribeEvent
    public static void a(@NotNull ServerTickEvent.Post post) {
        ServerLevel level;
        MinecraftServer minecraftServerA = C0262js.a();
        if (minecraftServerA == null || (level = minecraftServerA.getLevel(Level.OVERWORLD)) == null) {
            return;
        }
        iM.dm = true;
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a instanceof xw) {
            ((xw) abstractC0264juM166a).a(minecraftServerA, level);
        }
    }
}
