package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.aK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aK.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0041aK {

    /* JADX INFO: renamed from: af */
    static final /* synthetic */ boolean f363af;

    static {
        f363af = !C0041aK.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m219a(@NotNull RenderGuiLayerEvent.Pre pre) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null) {
            return;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f363af && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ResourceLocation name = pre.getName();
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (name.equals(VanillaGuiLayers.CROSSHAIR)) {
            if (c0623lM2852b.m2895a().m3074aJ()) {
                pre.setCanceled(true);
                return;
            }
            if (C0875pn.m4488a((Player) localPlayer, (AbstractC0183b<?, ?, ?, ?>) ((C0396gl) c0623lM2852b.m2855a()).m1885a(minecraft))) {
                pre.setCanceled(true);
                return;
            } else if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof InterfaceC1071tW)) {
                pre.setCanceled(true);
                return;
            } else if (localPlayer.getVehicle() instanceof AbstractC0750nU) {
                pre.setCanceled(true);
                return;
            }
        }
        if (c0623lM2852b.m2874a() == null) {
            return;
        }
        if (name.equals(VanillaGuiLayers.ARMOR_LEVEL) || name.equals(VanillaGuiLayers.FOOD_LEVEL) || name.equals(VanillaGuiLayers.EXPERIENCE_BAR) || name.equals(VanillaGuiLayers.EXPERIENCE_LEVEL) || name.equals(VanillaGuiLayers.PLAYER_HEALTH) || name.equals(VanillaGuiLayers.VEHICLE_HEALTH) || name.equals(VanillaGuiLayers.HOTBAR) || name.equals(VanillaGuiLayers.TAB_LIST) || name.equals(VanillaGuiLayers.BOSS_OVERLAY) || name.equals(VanillaGuiLayers.SELECTED_ITEM_NAME)) {
            pre.setCanceled(true);
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m220a(CustomizeGuiOverlayEvent.DebugText debugText) {
        if (Minecraft.getInstance().getDebugOverlay().showDebugScreen()) {
            C0623l c0623lM2852b = C0623l.m2852b();
            if (!f363af && c0623lM2852b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            C0358g c0358g = (C0358g) c0623lM2852b.m2852b();
            C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
            debugText.getRight().add("");
            debugText.getRight().add("bf".toUpperCase(Locale.ROOT) + " Cloud Info:");
            debugText.getRight().add("Connected: " + (c0358g.m1722a().isConnected() ? String.valueOf(ChatFormatting.GREEN) + "true" : String.valueOf(ChatFormatting.RED) + "false"));
            debugText.getRight().add("Reconnect Time: " + String.valueOf(ChatFormatting.GRAY) + (c0358g.m1722a().getReconnectTickCount() / 20));
            debugText.getRight().add("Client UUID: " + String.valueOf(ChatFormatting.GRAY) + String.valueOf(c0358g.mo1729a()));
            debugText.getRight().add("Client Name: " + String.valueOf(ChatFormatting.GRAY) + c0358g.getUsername());
            debugText.getRight().add("");
            debugText.getRight().add("Cached Player Data: " + String.valueOf(ChatFormatting.GRAY) + c0396gl.m1146cL());
            debugText.getRight().add("Cached Player Cloud Data: " + String.valueOf(ChatFormatting.GRAY) + c0396gl.m1147cM());
            String strM7239b = C1273xM.m7239b(c0623lM2852b.m2872a().m1844aq());
            debugText.getRight().add("");
            debugText.getRight().add("Instanced Particle Count: " + String.valueOf(ChatFormatting.GRAY) + strM7239b + String.valueOf(ChatFormatting.WHITE) + " / " + String.valueOf(ChatFormatting.GRAY) + "4096");
            debugText.getRight().add("Instanced Tracer Count: " + String.valueOf(ChatFormatting.GRAY) + C1273xM.m7239b(C0113bd.f766m.size()));
            AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
            if (abstractC0863pbM2874a != null) {
                for (Object obj : abstractC0863pbM2874a.m4089a().m6107az()) {
                    if (obj instanceof InterfaceC0916qb) {
                        ((InterfaceC0916qb) obj).mo5068a(c0623lM2852b, abstractC0863pbM2874a, debugText.getRight());
                    }
                }
            }
        }
    }
}
