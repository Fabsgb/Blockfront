package com.boehmod.blockfront;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.yh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/yh.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public final class C1321yh {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m8275a(@NotNull ServerTickEvent.Post post) {
        ServerLevel level;
        MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
        if (minecraftServerM2335a == null || (level = minecraftServerM2335a.getLevel(Level.OVERWORLD)) == null) {
            return;
        }
        C0549jf.f3275dx = true;
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a instanceof C1280xT) {
            ((C1280xT) abstractC0531jNM179a).mo2345a(minecraftServerM2335a, level);
        }
    }
}
