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

/* JADX INFO: renamed from: com.boehmod.blockfront.aF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aF.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0035aF {

    /* JADX INFO: renamed from: ab */
    static final /* synthetic */ boolean f264ab;

    static {
        f264ab = !C0035aF.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m181a(@NotNull ScreenEvent.Opening opening) {
        AbstractC0788oG<?, ?> abstractC0788oGM2692a;
        ClientLevel clientLevel = Minecraft.getInstance().level;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f264ab && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        if (opening.getScreen() instanceof TitleScreen) {
            C0940r.f5004B = true;
            C0055aZ.f384aj = true;
            opening.setNewScreen(AbstractC0225da.m1332b());
        } else {
            if ((opening.getScreen() instanceof PauseScreen) && abstractC0787oFM2688a != null) {
                opening.setNewScreen(new C0140cE());
                return;
            }
            if (opening.getScreen() instanceof DisconnectedScreen) {
                C0569k c0569kM2699a = c0622lM2667b.m2699a();
                if (!c0569kM2699a.m2594b()) {
                    c0569kM2699a.m2593c();
                }
            }
            if (clientLevel != null && (opening.getScreen() instanceof InventoryScreen) && (abstractC0788oGM2692a = c0622lM2667b.m2692a()) != null && !abstractC0788oGM2692a.mo3717bh()) {
                opening.setCanceled(true);
            }
        }
    }
}
