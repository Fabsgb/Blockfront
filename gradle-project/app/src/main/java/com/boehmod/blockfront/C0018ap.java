package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ap, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ap.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0018ap {
    @SubscribeEvent
    public static void a(@NotNull InputEvent.MouseButton.Pre pre) {
        Minecraft minecraft;
        LocalPlayer localPlayer;
        boolean zD;
        boolean z;
        boolean zC;
        int button = pre.getButton();
        boolean z2 = button == 0;
        boolean z3 = button == 1;
        if (z2 || z3) {
            int action = pre.getAction();
            boolean z4 = action == 1;
            boolean z5 = action == 0;
            if ((z4 || z5) && (localPlayer = (minecraft = Minecraft.getInstance()).player) != null) {
                ItemStack mainHandItem = localPlayer.getMainHandItem();
                tB item = mainHandItem.getItem();
                if (item instanceof tB) {
                    tB tBVar = item;
                    if (!z4 || minecraft.screen == null) {
                        if (z4) {
                            if (z2) {
                                zC = tBVar.a(minecraft, localPlayer, mainHandItem);
                            } else {
                                zC = tBVar.c(minecraft, localPlayer, mainHandItem);
                            }
                            z = zC;
                        } else {
                            if (z2) {
                                zD = tBVar.b(minecraft, localPlayer, mainHandItem);
                            } else {
                                zD = tBVar.d(minecraft, localPlayer, mainHandItem);
                            }
                            z = zD;
                        }
                        if (z) {
                            pre.setCanceled(true);
                        }
                    }
                }
            }
        }
    }
}
