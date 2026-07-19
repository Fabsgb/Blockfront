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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aK.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class aK {
    static final /* synthetic */ boolean ad;

    static {
        ad = !aK.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    public static void a(@NotNull PlayerTickEvent.Post post) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null) {
            return;
        }
        C0297l c0297lB = C0297l.b();
        if (!ad && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        fV fVVar = (fV) c0297lB.a();
        Player entity = post.getEntity();
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        oG<?, ?> oGVarM593a = c0297lB.m593a();
        fT fTVar = (fT) fVVar.a(entity);
        iS iSVarA = fVVar.a(entity);
        fTVar.a(c0297lB, entity.level(), entity, oFVarM591a);
        fTVar.a(minecraft, ThreadLocalRandom.current(), clientLevel, localPlayer, oFVarM591a, oFVarM591a != null ? oGVarM593a : null, entity);
        iSVarA.b(entity);
    }
}
