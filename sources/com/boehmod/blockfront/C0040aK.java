package com.boehmod.blockfront;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aK.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0040aK {

    /* JADX INFO: renamed from: ad */
    static final /* synthetic */ boolean f267ad;

    static {
        f267ad = !C0040aK.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m197a(@NotNull PlayerTickEvent.Post post) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null) {
            return;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f267ad && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
        Player entity = post.getEntity();
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622lM2667b.m2692a();
        C0324fT c0324fT = (C0324fT) c0326fV.m1133a(entity);
        C0482iS c0482iSA = c0326fV.m1133a(entity);
        c0324fT.mo1079a(c0622lM2667b, entity.level(), entity, abstractC0787oFM2688a);
        c0324fT.m1651a(minecraft, ThreadLocalRandom.current(), clientLevel, localPlayer, abstractC0787oFM2688a, abstractC0787oFM2688a != null ? abstractC0788oGM2692a : null, entity);
        c0482iSA.m2186b(entity);
    }
}
