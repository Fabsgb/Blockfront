package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ap */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ap.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0071ap {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m242a(@NotNull InputEvent.MouseButton.Pre pre) {
        Minecraft minecraft;
        LocalPlayer localPlayer;
        boolean zMo5832d;
        boolean z;
        boolean zMo5831c;
        int button = pre.getButton();
        boolean z2 = button == 0;
        boolean z3 = button == 1;
        if (z2 || z3) {
            int action = pre.getAction();
            boolean z4 = action == 1;
            boolean z5 = action == 0;
            if ((z4 || z5) && (localPlayer = (minecraft = Minecraft.getInstance()).player) != null) {
                ItemStack mainHandItem = localPlayer.getMainHandItem();
                InterfaceC1049tB item = mainHandItem.getItem();
                if (item instanceof InterfaceC1049tB) {
                    InterfaceC1049tB interfaceC1049tB = item;
                    if (!z4 || minecraft.screen == null) {
                        if (z4) {
                            if (z2) {
                                zMo5831c = interfaceC1049tB.mo5829a(minecraft, localPlayer, mainHandItem);
                            } else {
                                zMo5831c = interfaceC1049tB.mo5831c(minecraft, localPlayer, mainHandItem);
                            }
                            z = zMo5831c;
                        } else {
                            if (z2) {
                                zMo5832d = interfaceC1049tB.mo5830b(minecraft, localPlayer, mainHandItem);
                            } else {
                                zMo5832d = interfaceC1049tB.mo5832d(minecraft, localPlayer, mainHandItem);
                            }
                            z = zMo5832d;
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
