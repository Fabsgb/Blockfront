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

/* JADX INFO: renamed from: com.boehmod.blockfront.ao, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ao.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0017ao {
    static final /* synthetic */ boolean R;

    static {
        R = !C0017ao.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    public static void a(@NotNull InputEvent.Key key) {
        oG<?, ?> oGVarM593a;
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null) {
            return;
        }
        C0297l c0297lB = C0297l.b();
        if (!R && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (key.getKey() == minecraft.options.keyTogglePerspective.getKey().getValue() && (oGVarM593a = c0297lB.m593a()) != null && !oGVarM593a.g((Player) localPlayer) && !localPlayer.isCreative()) {
            minecraft.options.setCameraType(CameraType.FIRST_PERSON);
        }
    }
}
