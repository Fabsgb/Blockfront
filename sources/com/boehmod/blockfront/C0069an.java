package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.an */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/an.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0069an {

    /* JADX INFO: renamed from: Q */
    static final /* synthetic */ boolean f447Q;

    static {
        f447Q = !C0069an.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m234a(@NotNull PlayerInteractEvent.EntityInteract entityInteract) {
        m240a((PlayerInteractEvent) entityInteract);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m235a(@NotNull PlayerInteractEvent.RightClickBlock rightClickBlock) {
        m240a((PlayerInteractEvent) rightClickBlock);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m236a(@NotNull PlayerInteractEvent.RightClickItem rightClickItem) {
        m240a((PlayerInteractEvent) rightClickItem);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m237a(@NotNull PlayerInteractEvent.RightClickEmpty rightClickEmpty) {
        m240a((PlayerInteractEvent) rightClickEmpty);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m238a(@NotNull PlayerInteractEvent.LeftClickBlock leftClickBlock) {
        m240a((PlayerInteractEvent) leftClickBlock);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m239a(@NotNull PlayerInteractEvent.LeftClickEmpty leftClickEmpty) {
        m240a((PlayerInteractEvent) leftClickEmpty);
    }

    /* JADX INFO: renamed from: a */
    private static void m240a(@NotNull PlayerInteractEvent playerInteractEvent) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f447Q && c0622lM2667b == null) {
            throw new AssertionError("Mod manager is not null!");
        }
        if (c0622lM2667b.m2688a() == null) {
            return;
        }
        C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
        Player entity = playerInteractEvent.getEntity();
        if (C0799oR.m4052a(entity, (C0324fT) c0326fV.m1133a(entity)) && (playerInteractEvent instanceof ICancellableEvent)) {
            ((ICancellableEvent) playerInteractEvent).setCanceled(true);
        }
    }
}
