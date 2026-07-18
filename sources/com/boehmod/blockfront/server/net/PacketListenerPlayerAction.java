package com.boehmod.blockfront.server.net;

import com.boehmod.blockfront.AbstractC0563ju;
import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.C0029a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/server/net/PacketListenerPlayerAction.class */
public class PacketListenerPlayerAction extends SimpleChannelInboundHandler<ServerboundPlayerActionPacket> {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !PacketListenerPlayerAction.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void channelRead0(ChannelHandlerContext channelHandlerContext, ServerboundPlayerActionPacket serverboundPlayerActionPacket) {
        Player serverPlayerFromConnection;
        if (serverboundPlayerActionPacket == null || (serverPlayerFromConnection = PacketListenerUtils.getServerPlayerFromConnection(channelHandlerContext.channel())) == null) {
            return;
        }
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!$assertionsDisabled && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(serverPlayerFromConnection.getUUID());
        if (abstractC0787oFMo2531a != null) {
            switch (C10251.f5439xad7c327a[serverboundPlayerActionPacket.getAction().ordinal()]) {
                case 1:
                case 2:
                    Inventory inventory = serverPlayerFromConnection.getInventory();
                    ItemStack selected = inventory.getSelected();
                    if (!abstractC0787oFMo2531a.m3582b().mo3787a(serverPlayerFromConnection, selected)) {
                        inventory.setItem(inventory.selected, selected);
                        ((ServerPlayer) serverPlayerFromConnection).containerMenu.sendAllDataToRemote();
                        return;
                    }
                    break;
                case 3:
                    if (!abstractC0787oFMo2531a.m3645bg()) {
                        return;
                    }
                    break;
            }
        }
        channelHandlerContext.fireChannelRead(serverboundPlayerActionPacket);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.server.net.PacketListenerPlayerAction$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/server/net/PacketListenerPlayerAction$1.class */
    static /* synthetic */ class C10251 {

        /* JADX INFO: renamed from: $SwitchMap$net$minecraft$network$protocol$game$ServerboundPlayerActionPacket$Action */
        static final /* synthetic */ int[] f5439xad7c327a = new int[ServerboundPlayerActionPacket.Action.values().length];

        static {
            try {
                f5439xad7c327a[ServerboundPlayerActionPacket.Action.DROP_ITEM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5439xad7c327a[ServerboundPlayerActionPacket.Action.DROP_ALL_ITEMS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5439xad7c327a[ServerboundPlayerActionPacket.Action.SWAP_ITEM_WITH_OFFHAND.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
