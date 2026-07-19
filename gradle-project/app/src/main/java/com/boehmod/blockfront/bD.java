package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryActivateItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bD.class */
public final class bD extends bB {
    private static final Component aC = Component.translatable("bf.screen.dropdown.item.activated");
    private static final Component aD = Component.translatable("bf.message.inspect");
    private static final Component aE = Component.translatable("bf.message.activate");

    public bD(Screen screen, int i, int i2, int i3, int i4, CloudItemStack cloudItemStack) {
        super(screen, i, i2, i3, i4, aC, cloudItemStack);
        a(aD);
        a(aE);
    }

    @Override // com.boehmod.blockfront.AbstractC0076ct
    public void g(int i) {
        C0163g c0163g = (C0163g) this.e.b();
        switch (i) {
            case 1:
                this.b.setScreen(new Cdo(this.b));
                break;
            case 2:
                c0163g.sendPacket(new PacketInventoryActivateItem(this.b.getUUID()));
                break;
        }
    }
}
