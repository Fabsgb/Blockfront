package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import java.util.Locale;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.CustomizeGuiOverlayEvent;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aD.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0033aD {

    /* JADX INFO: renamed from: aa */
    static final /* synthetic */ boolean f263aa;

    static {
        f263aa = !C0033aD.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m178a(@NotNull RenderGuiLayerEvent.Pre pre) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null) {
            return;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f263aa && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ResourceLocation name = pre.getName();
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (name.equals(VanillaGuiLayers.CROSSHAIR)) {
            if (c0622lM2667b.m2709a().m3241ay()) {
                pre.setCanceled(true);
                return;
            }
            if (C0799oR.m4052a((Player) localPlayer, (AbstractC0182b<?, ?, ?, ?>) ((C0326fV) c0622lM2667b.m2670a()).m1675a(minecraft))) {
                pre.setCanceled(true);
                return;
            } else if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof InterfaceC1098ty)) {
                pre.setCanceled(true);
                return;
            } else if (localPlayer.getVehicle() instanceof AbstractC0779ny) {
                pre.setCanceled(true);
                return;
            }
        }
        if (c0622lM2667b.m2688a() == null) {
            return;
        }
        if (name.equals(VanillaGuiLayers.ARMOR_LEVEL) || name.equals(VanillaGuiLayers.FOOD_LEVEL) || name.equals(VanillaGuiLayers.EXPERIENCE_BAR) || name.equals(VanillaGuiLayers.EXPERIENCE_LEVEL) || name.equals(VanillaGuiLayers.PLAYER_HEALTH) || name.equals(VanillaGuiLayers.VEHICLE_HEALTH) || name.equals(VanillaGuiLayers.HOTBAR) || name.equals(VanillaGuiLayers.TAB_LIST) || name.equals(VanillaGuiLayers.BOSS_OVERLAY) || name.equals(VanillaGuiLayers.SELECTED_ITEM_NAME)) {
            pre.setCanceled(true);
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m179a(CustomizeGuiOverlayEvent.DebugText debugText) {
        if (Minecraft.getInstance().getDebugOverlay().showDebugScreen()) {
            C0622l c0622lM2667b = C0622l.m2667b();
            if (!f263aa && c0622lM2667b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            C0357g c0357g = (C0357g) c0622lM2667b.m2667b();
            C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
            debugText.getRight().add("");
            debugText.getRight().add("bf".toUpperCase(Locale.ROOT) + " Cloud Info:");
            debugText.getRight().add("Connected: " + (c0357g.m1716a().isConnected() ? String.valueOf(ChatFormatting.GREEN) + "true" : String.valueOf(ChatFormatting.RED) + "false"));
            debugText.getRight().add("Reconnect Time: " + String.valueOf(ChatFormatting.GRAY) + (c0357g.m1716a().getReconnectTickCount() / 20));
            debugText.getRight().add("Client UUID: " + String.valueOf(ChatFormatting.GRAY) + String.valueOf(c0357g.mo1723a()));
            debugText.getRight().add("Client Name: " + String.valueOf(ChatFormatting.GRAY) + c0357g.getUsername());
            debugText.getRight().add("");
            debugText.getRight().add("Cached Player Data: " + String.valueOf(ChatFormatting.GRAY) + c0326fV.m1129cv());
            debugText.getRight().add("Cached Player Cloud Data: " + String.valueOf(ChatFormatting.GRAY) + c0326fV.m1130cw());
            String strM7912a = C1293xp.m7912a(c0622lM2667b.m2686a().m1634ae());
            debugText.getRight().add("");
            debugText.getRight().add("Instanced Particle Count: " + String.valueOf(ChatFormatting.GRAY) + strM7912a + String.valueOf(ChatFormatting.WHITE) + " / " + String.valueOf(ChatFormatting.GRAY) + "4096");
            debugText.getRight().add("Instanced Tracer Count: " + String.valueOf(ChatFormatting.GRAY) + C1293xp.m7912a(C0051aV.f352l.size()));
            AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
            if (abstractC0787oFM2688a != null) {
                for (Object obj : abstractC0787oFM2688a.m3653a().m5619ax()) {
                    if (obj instanceof InterfaceC0840pF) {
                        ((InterfaceC0840pF) obj).mo4266a(c0622lM2667b, abstractC0787oFM2688a, debugText.getRight());
                    }
                }
            }
        }
    }
}
