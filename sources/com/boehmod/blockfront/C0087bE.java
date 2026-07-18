package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventorySetItemDefault;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/* JADX INFO: renamed from: com.boehmod.blockfront.bE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bE.class */
public final class C0087bE extends AbstractC0084bB {

    /* JADX INFO: renamed from: aF */
    private static final Component f576aF = Component.translatable("bf.message.unequip");

    /* JADX INFO: renamed from: aG */
    private static final Component f577aG = Component.translatable("bf.message.equip");

    /* JADX INFO: renamed from: aH */
    private static final Component f578aH = Component.translatable("bf.screen.dropdown.item.cape");

    public C0087bE(Screen screen, int i, int i2, int i3, int i4, CloudItemStack cloudItemStack) {
        super(screen, i, i2, i3, i4, f578aH, cloudItemStack);
        m1173a(this.f1585a.m1676a(this.f1587b).getInventory().m2159a(this.f1586e.m2670a(), cloudItemStack) ? f576aF : f577aG);
    }

    @Override // com.boehmod.blockfront.AbstractC0191ct
    /* JADX INFO: renamed from: g */
    public void mo286g(int i) {
        C0478iO c0478iOA = ((C0357g) this.f1586e.m2667b()).m1716a();
        C0482iS c0482iSM1676a = this.f1585a.m1676a(this.f1587b);
        switch (i) {
            case 1:
                ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketInventorySetItemDefault(this.f562b.getUUID()));
                c0478iOA.m2165b(RequestType.PLAYER_INVENTORY_DEFAULTS, c0482iSM1676a.getUUID());
                C0484iU.m2209a(this.f1587b, this.f1586e, this.f562b);
                break;
        }
    }
}
