package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerChangeGameTypeEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.al */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/al.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0067al {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m232a(@NotNull ClientPlayerChangeGameTypeEvent clientPlayerChangeGameTypeEvent) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level != null && clientPlayerChangeGameTypeEvent.getInfo().getProfile().getName().equals(minecraft.getGameProfile().getName())) {
            minecraft.levelRenderer.allChanged();
            C0562jt.log("Refreshing world renderer after game-type change to '%s'", clientPlayerChangeGameTypeEvent.getNewGameType().getName());
        }
    }
}
