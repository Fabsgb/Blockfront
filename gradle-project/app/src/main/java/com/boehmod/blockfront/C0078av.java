package com.boehmod.blockfront;

import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.av */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/av.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0078av {

    /* JADX INFO: renamed from: W */
    static final /* synthetic */ boolean f491W;

    static {
        f491W = !C0078av.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m295a(@NotNull InputEvent.Key key) {
        AbstractC0864pc<?, ?> abstractC0864pcM2878a;
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null) {
            return;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f491W && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (key.getKey() == minecraft.options.keyTogglePerspective.getKey().getValue() && (abstractC0864pcM2878a = c0623lM2852b.m2878a()) != null && !abstractC0864pcM2878a.mo4146g(localPlayer) && !localPlayer.isCreative()) {
            minecraft.options.setCameraType(CameraType.FIRST_PERSON);
        }
    }
}
