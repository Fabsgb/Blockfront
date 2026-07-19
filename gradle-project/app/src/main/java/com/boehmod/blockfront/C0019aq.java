package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aq.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0019aq {
    static final /* synthetic */ boolean S;

    static {
        S = !C0019aq.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    public static void a(@NotNull LivingEvent.LivingJumpEvent livingJumpEvent) {
        oG<?, ?> oGVarM593a;
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        Player entity = livingJumpEvent.getEntity();
        if (!(entity instanceof Player)) {
            return;
        }
        Player player = entity;
        if (player.equals(localPlayer) && fT.b(localPlayer)) {
            C0297l c0297lB = C0297l.b();
            if (!S && c0297lB == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
            if (oFVarM591a == null || !oFVarM591a.e(player) || (oGVarM593a = c0297lB.m593a()) == null) {
                return;
            }
            if (oGVarM593a.aH() < 3.0f) {
                player.setDeltaMovement(player.getDeltaMovement().multiply(0.4000000059604645d, 1.0d, 0.4000000059604645d));
            } else {
                oGVarM593a.l(3.0f);
            }
        }
    }
}
