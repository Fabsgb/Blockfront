package com.boehmod.blockfront;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xJ.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public final class C1269xJ {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m7759a(@NotNull ServerTickEvent.Post post) {
        ServerLevel level;
        MinecraftServer minecraftServerM2514a = C0561js.m2514a();
        if (minecraftServerM2514a == null || (level = minecraftServerM2514a.getLevel(Level.OVERWORLD)) == null) {
            return;
        }
        C0476iM.f2925dm = true;
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a instanceof C1300xw) {
            ((C1300xw) abstractC0563juM168a).mo2522a(minecraftServerM2514a, level);
        }
    }
}
