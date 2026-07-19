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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aF.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class aF {
    static final /* synthetic */ boolean ab;

    static {
        ab = !aF.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    public static void a(@NotNull ScreenEvent.Opening opening) {
        oG<?, ?> oGVarM593a;
        ClientLevel clientLevel = Minecraft.getInstance().level;
        C0297l c0297lB = C0297l.b();
        if (!ab && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        if (opening.getScreen() instanceof TitleScreen) {
            C0459r.B = true;
            aZ.aj = true;
            opening.setNewScreen(AbstractC0084da.m341b());
        } else {
            if ((opening.getScreen() instanceof PauseScreen) && oFVarM591a != null) {
                opening.setNewScreen(new cE());
                return;
            }
            if (opening.getScreen() instanceof DisconnectedScreen) {
                C0270k c0270kM596a = c0297lB.m596a();
                if (!c0270kM596a.b()) {
                    c0270kM596a.c();
                }
            }
            if (clientLevel != null && (opening.getScreen() instanceof InventoryScreen) && (oGVarM593a = c0297lB.m593a()) != null && !oGVarM593a.bh()) {
                opening.setCanceled(true);
            }
        }
    }
}
