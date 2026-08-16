package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0484iT;
import com.boehmod.blockfront.C1157vC;
import com.boehmod.blockfront.C1169vO;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mixin/ChatScreenMixin.class */
@Mixin({ChatScreen.class})
public abstract class ChatScreenMixin extends Screen {
    protected ChatScreenMixin(Component component) {
        super(component);
    }

    @Redirect(method = {"handleChatInput"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ClientPacketListener;sendChat(Ljava/lang/String;)V"))
    private void blockFrontAll$redirectSendChat(ClientPacketListener clientPacketListener, String str) {
        C1169vO.m6648c(new C1157vC(str));
    }

    public boolean handleComponentClicked(@Nullable Style style) {
        if (C0484iT.m2170a(style)) {
            return true;
        }
        return super.handleComponentClicked(style);
    }
}
