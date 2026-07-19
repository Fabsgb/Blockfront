package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0570vc;
import com.boehmod.blockfront.C0582vo;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.multiplayer.ClientPacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/ChatScreenMixin.class */
@Mixin({ChatScreen.class})
public abstract class ChatScreenMixin {
    @Redirect(method = {"handleChatInput"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ClientPacketListener;sendChat(Ljava/lang/String;)V"))
    private void blockFrontAll$redirectSendChat(ClientPacketListener clientPacketListener, String str) {
        C0582vo.c(new C0570vc(str));
    }
}
