package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aq.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0072aq {

    /* JADX INFO: renamed from: S */
    static final /* synthetic */ boolean f449S;

    static {
        f449S = !C0072aq.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m243a(@NotNull LivingEvent.LivingJumpEvent livingJumpEvent) {
        AbstractC0788oG<?, ?> abstractC0788oGM2692a;
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        Player entity = livingJumpEvent.getEntity();
        if (!(entity instanceof Player)) {
            return;
        }
        Player player = entity;
        if (player.equals(localPlayer) && C0324fT.m1673b(localPlayer)) {
            C0622l c0622lM2667b = C0622l.m2667b();
            if (!f449S && c0622lM2667b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
            if (abstractC0787oFM2688a == null || !abstractC0787oFM2688a.mo3608e(player) || (abstractC0788oGM2692a = c0622lM2667b.m2692a()) == null) {
                return;
            }
            if (abstractC0788oGM2692a.m3677aH() < 3.0f) {
                player.setDeltaMovement(player.getDeltaMovement().multiply(0.4000000059604645d, 1.0d, 0.4000000059604645d));
            } else {
                abstractC0788oGM2692a.m3680l(3.0f);
            }
        }
    }
}
