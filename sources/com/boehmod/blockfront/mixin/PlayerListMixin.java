package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.AbstractC0531jN;
import com.boehmod.blockfront.C0030a;
import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mixin/PlayerListMixin.class */
@Mixin({PlayerList.class})
public abstract class PlayerListMixin {

    @Shadow
    @Final
    private MinecraftServer server;

    @Shadow
    public abstract List<ServerPlayer> getPlayers();

    @Inject(method = {"broadcastSystemMessage(Lnet/minecraft/network/chat/Component;Z)V"}, at = {@At("HEAD")}, cancellable = true)
    private void blockFrontAll$filterJoinLeaveBroadcast(Component component, boolean z, CallbackInfo callbackInfo) {
        if (isJoinLeaveMessage(component)) {
            callbackInfo.cancel();
            this.server.sendSystemMessage(component);
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            for (ServerPlayer serverPlayer : getPlayers()) {
                if (abstractC0531jNM179a == null || abstractC0531jNM179a.mo2354a(serverPlayer.getUUID()) == null) {
                    serverPlayer.sendSystemMessage(component);
                }
            }
        }
    }

    private static boolean isJoinLeaveMessage(Component component) {
        TranslatableContents contents = component.getContents();
        if (!(contents instanceof TranslatableContents)) {
            return false;
        }
        switch (contents.getKey()) {
            case "multiplayer.player.joined":
            case "multiplayer.player.joined.renamed":
            case "multiplayer.player.left":
                return true;
            default:
                return false;
        }
    }
}
