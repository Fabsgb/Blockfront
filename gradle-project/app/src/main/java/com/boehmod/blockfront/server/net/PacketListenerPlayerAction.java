package com.boehmod.blockfront.server.net;

import com.boehmod.blockfront.AbstractC0531jN;
import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.C0030a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/server/net/PacketListenerPlayerAction.class */
public class PacketListenerPlayerAction extends SimpleChannelInboundHandler<ServerboundPlayerActionPacket> {
    /* JADX INFO: Access modifiers changed from: protected */
    public void channelRead0(ChannelHandlerContext channelHandlerContext, ServerboundPlayerActionPacket serverboundPlayerActionPacket) {
        if (shouldCancelAction(channelHandlerContext, serverboundPlayerActionPacket)) {
            return;
        }
        channelHandlerContext.fireChannelRead(serverboundPlayerActionPacket);
    }

    private boolean shouldCancelAction(@NotNull ChannelHandlerContext channelHandlerContext, @NotNull ServerboundPlayerActionPacket serverboundPlayerActionPacket) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a;
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a;
        Player serverPlayerFromConnection = PacketListenerUtils.getServerPlayerFromConnection(channelHandlerContext.channel());
        if (serverPlayerFromConnection == null || (abstractC0531jNM179a = C0030a.m175a().m179a()) == null || (abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(serverPlayerFromConnection.getUUID())) == null) {
            return false;
        }
        switch (C10261.f5616xad7c327a[serverboundPlayerActionPacket.getAction().ordinal()]) {
            case 1:
            case 2:
                Inventory inventory = serverPlayerFromConnection.getInventory();
                ItemStack selected = inventory.getSelected();
                if (!abstractC0863pbMo2354a.m4018b().mo4223a(serverPlayerFromConnection, selected)) {
                    inventory.setItem(inventory.selected, selected);
                    ((ServerPlayer) serverPlayerFromConnection).containerMenu.sendAllDataToRemote();
                    return true;
                }
                return false;
            case 3:
                if (!abstractC0863pbMo2354a.m4081bq()) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.server.net.PacketListenerPlayerAction$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/server/net/PacketListenerPlayerAction$1.class */
    static /* synthetic */ class C10261 {

        /* JADX INFO: renamed from: $SwitchMap$net$minecraft$network$protocol$game$ServerboundPlayerActionPacket$Action */
        static final /* synthetic */ int[] f5616xad7c327a = new int[ServerboundPlayerActionPacket.Action.values().length];

        static {
            try {
                f5616xad7c327a[ServerboundPlayerActionPacket.Action.DROP_ITEM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5616xad7c327a[ServerboundPlayerActionPacket.Action.DROP_ALL_ITEMS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5616xad7c327a[ServerboundPlayerActionPacket.Action.SWAP_ITEM_WITH_OFFHAND.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
