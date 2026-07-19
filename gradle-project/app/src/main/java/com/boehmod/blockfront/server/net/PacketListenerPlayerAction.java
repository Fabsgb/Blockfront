package com.boehmod.blockfront.server.net;

import com.boehmod.blockfront.AbstractC0264ju;
import com.boehmod.blockfront.C0002a;
import com.boehmod.blockfront.oF;
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
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!$assertionsDisabled && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(serverPlayerFromConnection.getUUID());
        if (oFVarMo604a != null) {
            switch (AnonymousClass1.$SwitchMap$net$minecraft$network$protocol$game$ServerboundPlayerActionPacket$Action[serverboundPlayerActionPacket.getAction().ordinal()]) {
                case 1:
                case 2:
                    Inventory inventory = serverPlayerFromConnection.getInventory();
                    ItemStack selected = inventory.getSelected();
                    if (!oFVarMo604a.b().a(serverPlayerFromConnection, selected)) {
                        inventory.setItem(inventory.selected, selected);
                        ((ServerPlayer) serverPlayerFromConnection).containerMenu.sendAllDataToRemote();
                        return;
                    }
                    break;
                case 3:
                    if (!oFVarMo604a.bg()) {
                        return;
                    }
                    break;
            }
        }
        channelHandlerContext.fireChannelRead(serverboundPlayerActionPacket);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.server.net.PacketListenerPlayerAction$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/server/net/PacketListenerPlayerAction$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$network$protocol$game$ServerboundPlayerActionPacket$Action = new int[ServerboundPlayerActionPacket.Action.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$network$protocol$game$ServerboundPlayerActionPacket$Action[ServerboundPlayerActionPacket.Action.DROP_ITEM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$network$protocol$game$ServerboundPlayerActionPacket$Action[ServerboundPlayerActionPacket.Action.DROP_ALL_ITEMS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$network$protocol$game$ServerboundPlayerActionPacket$Action[ServerboundPlayerActionPacket.Action.SWAP_ITEM_WITH_OFFHAND.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
