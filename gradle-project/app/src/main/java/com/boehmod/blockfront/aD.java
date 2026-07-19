package com.boehmod.blockfront;

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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aD.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class aD {
    static final /* synthetic */ boolean aa;

    static {
        aa = !aD.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    public static void a(@NotNull RenderGuiLayerEvent.Pre pre) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null) {
            return;
        }
        C0297l c0297lB = C0297l.b();
        if (!aa && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ResourceLocation name = pre.getName();
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (name.equals(VanillaGuiLayers.CROSSHAIR)) {
            if (c0297lB.m602a().ay()) {
                pre.setCanceled(true);
                return;
            }
            if (oR.a((Player) localPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) ((fV) c0297lB.a()).a(minecraft))) {
                pre.setCanceled(true);
                return;
            } else if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof InterfaceC0538ty)) {
                pre.setCanceled(true);
                return;
            } else if (localPlayer.getVehicle() instanceof AbstractC0376ny) {
                pre.setCanceled(true);
                return;
            }
        }
        if (c0297lB.m591a() == null) {
            return;
        }
        if (name.equals(VanillaGuiLayers.ARMOR_LEVEL) || name.equals(VanillaGuiLayers.FOOD_LEVEL) || name.equals(VanillaGuiLayers.EXPERIENCE_BAR) || name.equals(VanillaGuiLayers.EXPERIENCE_LEVEL) || name.equals(VanillaGuiLayers.PLAYER_HEALTH) || name.equals(VanillaGuiLayers.VEHICLE_HEALTH) || name.equals(VanillaGuiLayers.HOTBAR) || name.equals(VanillaGuiLayers.TAB_LIST) || name.equals(VanillaGuiLayers.BOSS_OVERLAY) || name.equals(VanillaGuiLayers.SELECTED_ITEM_NAME)) {
            pre.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void a(CustomizeGuiOverlayEvent.DebugText debugText) {
        if (Minecraft.getInstance().getDebugOverlay().showDebugScreen()) {
            C0297l c0297lB = C0297l.b();
            if (!aa && c0297lB == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            C0163g c0163g = (C0163g) c0297lB.b();
            fV fVVar = (fV) c0297lB.a();
            debugText.getRight().add("");
            debugText.getRight().add("bf".toUpperCase(Locale.ROOT) + " Cloud Info:");
            debugText.getRight().add("Connected: " + (c0163g.a().isConnected() ? String.valueOf(ChatFormatting.GREEN) + "true" : String.valueOf(ChatFormatting.RED) + "false"));
            debugText.getRight().add("Reconnect Time: " + String.valueOf(ChatFormatting.GRAY) + (c0163g.a().getReconnectTickCount() / 20));
            debugText.getRight().add("Client UUID: " + String.valueOf(ChatFormatting.GRAY) + String.valueOf(c0163g.mo409a()));
            debugText.getRight().add("Client Name: " + String.valueOf(ChatFormatting.GRAY) + c0163g.getUsername());
            debugText.getRight().add("");
            debugText.getRight().add("Cached Player Data: " + String.valueOf(ChatFormatting.GRAY) + fVVar.cv());
            debugText.getRight().add("Cached Player Cloud Data: " + String.valueOf(ChatFormatting.GRAY) + fVVar.cw());
            String strA = C0637xp.a(c0297lB.m590a().ae());
            debugText.getRight().add("");
            debugText.getRight().add("Instanced Particle Count: " + String.valueOf(ChatFormatting.GRAY) + strA + String.valueOf(ChatFormatting.WHITE) + " / " + String.valueOf(ChatFormatting.GRAY) + "4096");
            debugText.getRight().add("Instanced Tracer Count: " + String.valueOf(ChatFormatting.GRAY) + C0637xp.a(aV.l.size()));
            oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
            if (oFVarM591a != null) {
                for (Object obj : oFVarM591a.m767a().ax()) {
                    if (obj instanceof pF) {
                        ((pF) obj).a(c0297lB, oFVarM591a, debugText.getRight());
                    }
                }
            }
        }
    }
}
