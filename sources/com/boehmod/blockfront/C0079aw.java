package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aw.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0079aw {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m296a(@NotNull InputEvent.MouseButton.Pre pre) {
        Minecraft minecraft;
        LocalPlayer localPlayer;
        boolean zMo5946d;
        boolean z;
        boolean zMo5945c;
        int button = pre.getButton();
        boolean z2 = button == 0;
        boolean z3 = button == 1;
        if (z2 || z3) {
            int action = pre.getAction();
            boolean z4 = action == 1;
            boolean z5 = action == 0;
            if ((z4 || z5) && (localPlayer = (minecraft = Minecraft.getInstance()).player) != null) {
                ItemStack mainHandItem = localPlayer.getMainHandItem();
                InterfaceC1074tZ item = mainHandItem.getItem();
                if (item instanceof InterfaceC1074tZ) {
                    InterfaceC1074tZ interfaceC1074tZ = item;
                    if (!z4 || minecraft.screen == null) {
                        if (z4) {
                            if (z2) {
                                zMo5945c = interfaceC1074tZ.mo5943a(minecraft, localPlayer, mainHandItem);
                            } else {
                                zMo5945c = interfaceC1074tZ.mo5945c(minecraft, localPlayer, mainHandItem);
                            }
                            z = zMo5945c;
                        } else {
                            if (z2) {
                                zMo5946d = interfaceC1074tZ.mo5944b(minecraft, localPlayer, mainHandItem);
                            } else {
                                zMo5946d = interfaceC1074tZ.mo5946d(minecraft, localPlayer, mainHandItem);
                            }
                            z = zMo5946d;
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
