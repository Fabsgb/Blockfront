package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0136f;
import com.boehmod.blockfront.C0297l;
import com.boehmod.blockfront.iC;
import com.boehmod.blockfront.iE;
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
        C0297l c0297lB = C0297l.b();
        if (c0297lB != null) {
            C0136f.a(c0297lB, (Minecraft) this);
        }
    }

    @WrapOperation(method = {"handleKeybinds"}, at = {@At(value = "FIELD", target = "Lnet/minecraft/world/entity/player/Inventory;selected:I", opcode = 181)})
    private void bf$onHotbarKeySelect(Inventory inventory, int i, Operation<Void> operation) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null || !iE.a(localPlayer, i)) {
            operation.call(new Object[]{inventory, Integer.valueOf(i)});
        }
    }

    @WrapOperation(method = {"handleKeybinds"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/spectator/SpectatorGui;onHotbarSelected(I)V")})
    private void bf$onSpectatorHotbarSelect(SpectatorGui spectatorGui, int i, Operation<Void> operation) {
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null || !c0297lB.e()) {
            operation.call(new Object[]{spectatorGui, Integer.valueOf(i)});
        }
    }

    @WrapOperation(method = {"shouldEntityAppearGlowing"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/KeyMapping;isDown()Z")})
    private boolean bf$suppressSpectatorOutlines(KeyMapping keyMapping, Operation<Boolean> operation) {
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null || !c0297lB.e()) {
            return ((Boolean) operation.call(new Object[]{keyMapping})).booleanValue();
        }
        return false;
    }

    @WrapOperation(method = {"openChatScreen"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;setOverlayMessage(Lnet/minecraft/network/chat/Component;Z)V")})
    private void bf$brandChatDisabledMessage(Gui gui, Component component, boolean z, Operation<Void> operation) {
        Minecraft minecraft = (Minecraft) this;
        if (iC.X() && minecraft.getChatStatus() == Minecraft.ChatStatus.DISABLED_BY_PROFILE) {
            iC.c(minecraft, iC.hL);
        } else {
            operation.call(new Object[]{gui, component, Boolean.valueOf(z)});
        }
    }
}
