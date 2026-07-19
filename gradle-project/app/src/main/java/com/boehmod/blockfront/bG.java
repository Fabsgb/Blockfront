package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemShowcase;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventorySetItemDefault;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bG.class */
public final class bG extends bB {
    private static final Component aN = Component.translatable("bf.message.inspect");
    private static final Component aO = Component.translatable("bf.message.unequip");
    private static final Component aP = Component.translatable("bf.message.equip");
    private static final Component aQ = Component.translatable("bf.message.showcase.add");
    private static final Component aR = Component.translatable("bf.message.showcase.remove");
    private static final Component aS = Component.translatable("bf.screen.dropdown.item.booster");

    public bG(Screen screen, int i, int i2, int i3, int i4, CloudItemStack cloudItemStack) {
        super(screen, i, i2, i3, i4, aS, cloudItemStack);
        CloudRegistry cloudRegistryA = this.e.a();
        iN inventory = this.a.m404a(this.b).getInventory();
        Component component = inventory.a(cloudRegistryA, cloudItemStack) ? aO : aP;
        Component component2 = inventory.isItemShowcased(cloudItemStack.getUUID()) ? aR : aQ;
        a(aN);
        a(component);
        a(component2);
    }

    @Override // com.boehmod.blockfront.AbstractC0076ct
    public void g(int i) {
        C0163g c0163g = (C0163g) this.e.b();
        iO iOVarA = c0163g.a();
        iS iSVarM404a = this.a.m404a(this.b);
        switch (i) {
            case 1:
                this.b.setScreen(new Cdo(this.b));
                break;
            case 2:
                c0163g.sendPacket(new PacketInventorySetItemDefault(this.b.getUUID()));
                iOVarA.b(RequestType.PLAYER_INVENTORY_DEFAULTS, iSVarM404a.getUUID());
                iU.a(this.b, this.e, this.b);
                break;
            case 3:
                c0163g.sendPacket(new PacketInventoryItemShowcase(this.b.getUUID()));
                iOVarA.b(RequestType.PLAYER_INVENTORY_SHOWCASE, iSVarM404a.getUUID());
                iU.a(this.b, this.e, this.b);
                break;
        }
    }
}
