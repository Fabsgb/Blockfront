package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.au */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/au.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0077au {

    /* JADX INFO: renamed from: V */
    static final /* synthetic */ boolean f490V;

    static {
        f490V = !C0077au.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m288a(@NotNull PlayerInteractEvent.EntityInteract entityInteract) {
        m294a((PlayerInteractEvent) entityInteract);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m289a(@NotNull PlayerInteractEvent.RightClickBlock rightClickBlock) {
        m294a((PlayerInteractEvent) rightClickBlock);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m290a(@NotNull PlayerInteractEvent.RightClickItem rightClickItem) {
        m294a((PlayerInteractEvent) rightClickItem);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m291a(@NotNull PlayerInteractEvent.RightClickEmpty rightClickEmpty) {
        m294a((PlayerInteractEvent) rightClickEmpty);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m292a(@NotNull PlayerInteractEvent.LeftClickBlock leftClickBlock) {
        m294a((PlayerInteractEvent) leftClickBlock);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m293a(@NotNull PlayerInteractEvent.LeftClickEmpty leftClickEmpty) {
        m294a((PlayerInteractEvent) leftClickEmpty);
    }

    /* JADX INFO: renamed from: a */
    private static void m294a(@NotNull PlayerInteractEvent playerInteractEvent) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f490V && c0623lM2852b == null) {
            throw new AssertionError("Mod manager is not null!");
        }
        if (c0623lM2852b.m2874a() == null) {
            return;
        }
        C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
        Player entity = playerInteractEvent.getEntity();
        if (C0875pn.m4488a(entity, (C0394gj) c0396gl.m1150a(entity)) && (playerInteractEvent instanceof ICancellableEvent)) {
            ((ICancellableEvent) playerInteractEvent).setCanceled(true);
        }
    }
}
