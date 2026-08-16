package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ax */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ax.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0080ax {

    /* JADX INFO: renamed from: X */
    static final /* synthetic */ boolean f492X;

    static {
        f492X = !C0080ax.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m297a(@NotNull LivingEvent.LivingJumpEvent livingJumpEvent) {
        AbstractC0864pc<?, ?> abstractC0864pcM2878a;
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        Player entity = livingJumpEvent.getEntity();
        if (!(entity instanceof Player)) {
            return;
        }
        Player player = entity;
        if (player.equals(localPlayer) && C0394gj.m1883b(localPlayer)) {
            C0623l c0623lM2852b = C0623l.m2852b();
            if (!f492X && c0623lM2852b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
            if (abstractC0863pbM2874a == null || !abstractC0863pbM2874a.mo4044e(player) || (abstractC0864pcM2878a = c0623lM2852b.m2878a()) == null) {
                return;
            }
            if (abstractC0864pcM2878a.m4113aN() < 3.0f) {
                player.setDeltaMovement(player.getDeltaMovement().multiply(0.4000000059604645d, 1.0d, 0.4000000059604645d));
            } else {
                abstractC0864pcM2878a.m4116k(3.0f);
            }
        }
    }
}
