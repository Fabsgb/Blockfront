package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0304f;
import com.boehmod.blockfront.C0466iC;
import com.boehmod.blockfront.C0468iE;
import com.boehmod.blockfront.C0622l;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.components.spectator.SpectatorGui;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/MinecraftMixin.class */
@Mixin({Minecraft.class})
public class MinecraftMixin {
    @Inject(method = {"updateTitle"}, at = {@At("TAIL")})
    private void bf$postUpdateTitle(CallbackInfo callbackInfo) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b != null) {
            C0304f.m1601a(c0622lM2667b, (Minecraft) this);
        }
    }

    @WrapOperation(method = {"handleKeybinds"}, at = {@At(value = "FIELD", target = "Lnet/minecraft/world/entity/player/Inventory;selected:I", opcode = 181)})
    private void bf$onHotbarKeySelect(Inventory inventory, int i, Operation<Void> operation) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null || !C0468iE.m2118a(localPlayer, i)) {
            operation.call(new Object[]{inventory, Integer.valueOf(i)});
        }
    }

    @WrapOperation(method = {"handleKeybinds"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/spectator/SpectatorGui;onHotbarSelected(I)V")})
    private void bf$onSpectatorHotbarSelect(SpectatorGui spectatorGui, int i, Operation<Void> operation) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null || !c0622lM2667b.m2690e()) {
            operation.call(new Object[]{spectatorGui, Integer.valueOf(i)});
        }
    }

    @WrapOperation(method = {"shouldEntityAppearGlowing"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/KeyMapping;isDown()Z")})
    private boolean bf$suppressSpectatorOutlines(KeyMapping keyMapping, Operation<Boolean> operation) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null || !c0622lM2667b.m2690e()) {
            return ((Boolean) operation.call(new Object[]{keyMapping})).booleanValue();
        }
        return false;
    }

    @WrapOperation(method = {"openChatScreen"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;setOverlayMessage(Lnet/minecraft/network/chat/Component;Z)V")})
    private void bf$brandChatDisabledMessage(Gui gui, Component component, boolean z, Operation<Void> operation) {
        Minecraft minecraft = (Minecraft) this;
        if (C0466iC.m2101X() && minecraft.getChatStatus() == Minecraft.ChatStatus.DISABLED_BY_PROFILE) {
            C0466iC.m2099c(minecraft, C0466iC.f2882hL);
        } else {
            operation.call(new Object[]{gui, component, Boolean.valueOf(z)});
        }
    }
}
