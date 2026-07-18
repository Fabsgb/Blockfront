package com.boehmod.blockfront;

import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ao */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ao.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0070ao {

    /* JADX INFO: renamed from: R */
    static final /* synthetic */ boolean f448R;

    static {
        f448R = !C0070ao.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m241a(@NotNull InputEvent.Key key) {
        AbstractC0788oG<?, ?> abstractC0788oGM2692a;
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null) {
            return;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f448R && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (key.getKey() == minecraft.options.keyTogglePerspective.getKey().getValue() && (abstractC0788oGM2692a = c0622lM2667b.m2692a()) != null && !abstractC0788oGM2692a.mo3710g((Player) localPlayer) && !localPlayer.isCreative()) {
            minecraft.options.setCameraType(CameraType.FIRST_PERSON);
        }
    }
}
