package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventorySetItemDefault;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bE.class */
public final class bE extends bB {
    private static final Component aF = Component.translatable("bf.message.unequip");
    private static final Component aG = Component.translatable("bf.message.equip");
    private static final Component aH = Component.translatable("bf.screen.dropdown.item.cape");

    public bE(Screen screen, int i, int i2, int i3, int i4, CloudItemStack cloudItemStack) {
        super(screen, i, i2, i3, i4, aH, cloudItemStack);
        a(this.a.m404a(this.b).getInventory().a(this.e.a(), cloudItemStack) ? aF : aG);
    }

    @Override // com.boehmod.blockfront.AbstractC0076ct
    public void g(int i) {
        iO iOVarA = ((C0163g) this.e.b()).a();
        iS iSVarM404a = this.a.m404a(this.b);
        switch (i) {
            case 1:
                ((C0163g) this.e.b()).sendPacket(new PacketInventorySetItemDefault(this.b.getUUID()));
                iOVarA.b(RequestType.PLAYER_INVENTORY_DEFAULTS, iSVarM404a.getUUID());
                iU.a(this.b, this.e, this.b);
                break;
        }
    }
}
