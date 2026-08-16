package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ScreenEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aM.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0043aM {

    /* JADX INFO: renamed from: ag */
    static final /* synthetic */ boolean f364ag;

    static {
        f364ag = !C0043aM.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m222a(@NotNull ScreenEvent.Opening opening) {
        AbstractC0864pc<?, ?> abstractC0864pcM2878a;
        ClientLevel clientLevel = Minecraft.getInstance().level;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f364ag && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        if (opening.getScreen() instanceof TitleScreen) {
            C0117bh.f798ao = true;
            opening.setNewScreen(AbstractC0235dj.m1358b());
            return;
        }
        if ((opening.getScreen() instanceof PauseScreen) && abstractC0863pbM2874a != null) {
            opening.setNewScreen(new C0150cN());
            return;
        }
        if (opening.getScreen() instanceof DisconnectedScreen) {
            C0570k c0570kM2885a = c0623lM2852b.m2885a();
            if (!c0570kM2885a.m2583b()) {
                c0570kM2885a.m2582c();
            }
        }
        if (clientLevel != null && (opening.getScreen() instanceof InventoryScreen) && (abstractC0864pcM2878a = c0623lM2852b.m2878a()) != null && !abstractC0864pcM2878a.mo4153br()) {
            opening.setCanceled(true);
        }
    }
}
