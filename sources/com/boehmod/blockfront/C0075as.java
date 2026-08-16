package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerChangeGameTypeEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.as */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/as.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0075as {
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m286a(@NotNull ClientPlayerChangeGameTypeEvent clientPlayerChangeGameTypeEvent) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level != null && clientPlayerChangeGameTypeEvent.getInfo().getProfile().getName().equals(minecraft.getGameProfile().getName())) {
            minecraft.levelRenderer.allChanged();
            C0530jM.log("Refreshing world renderer after game-type change to '%s'", clientPlayerChangeGameTypeEvent.getNewGameType().getName());
        }
    }
}
