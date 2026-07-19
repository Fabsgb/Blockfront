package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.an, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/an.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0016an {
    static final /* synthetic */ boolean Q;

    static {
        Q = !C0016an.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    public static void a(@NotNull PlayerInteractEvent.EntityInteract entityInteract) {
        a((PlayerInteractEvent) entityInteract);
    }

    @SubscribeEvent
    public static void a(@NotNull PlayerInteractEvent.RightClickBlock rightClickBlock) {
        a((PlayerInteractEvent) rightClickBlock);
    }

    @SubscribeEvent
    public static void a(@NotNull PlayerInteractEvent.RightClickItem rightClickItem) {
        a((PlayerInteractEvent) rightClickItem);
    }

    @SubscribeEvent
    public static void a(@NotNull PlayerInteractEvent.RightClickEmpty rightClickEmpty) {
        a((PlayerInteractEvent) rightClickEmpty);
    }

    @SubscribeEvent
    public static void a(@NotNull PlayerInteractEvent.LeftClickBlock leftClickBlock) {
        a((PlayerInteractEvent) leftClickBlock);
    }

    @SubscribeEvent
    public static void a(@NotNull PlayerInteractEvent.LeftClickEmpty leftClickEmpty) {
        a((PlayerInteractEvent) leftClickEmpty);
    }

    private static void a(@NotNull PlayerInteractEvent playerInteractEvent) {
        C0297l c0297lB = C0297l.b();
        if (!Q && c0297lB == null) {
            throw new AssertionError("Mod manager is not null!");
        }
        if (c0297lB.m591a() == null) {
            return;
        }
        fV fVVar = (fV) c0297lB.a();
        Player entity = playerInteractEvent.getEntity();
        if (oR.a(entity, (fT) fVVar.a(entity)) && (playerInteractEvent instanceof ICancellableEvent)) {
            ((ICancellableEvent) playerInteractEvent).setCanceled(true);
        }
    }
}
