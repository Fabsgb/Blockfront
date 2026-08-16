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

/* JADX INFO: renamed from: com.boehmod.blockfront.aS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aS.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0049aS {

    /* JADX INFO: renamed from: ai */
    static final /* synthetic */ boolean f367ai;

    static {
        f367ai = !C0049aS.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m239a(@NotNull PlayerTickEvent.Post post) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null) {
            return;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f367ai && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
        Player entity = post.getEntity();
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623lM2852b.m2878a();
        C0394gj c0394gj = (C0394gj) c0396gl.m1150a(entity);
        C0555jl c0555jlA = c0396gl.m1150a(entity);
        c0394gj.mo1096a(c0623lM2852b, entity.level(), entity, abstractC0863pbM2874a);
        c0394gj.m1861a(minecraft, ThreadLocalRandom.current(), clientLevel, localPlayer, abstractC0863pbM2874a, abstractC0863pbM2874a != null ? abstractC0864pcM2878a : null, entity);
        c0555jlA.m2513b(entity);
    }
}
