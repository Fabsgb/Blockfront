package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemShowcase;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventorySetItemDefault;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/* JADX INFO: renamed from: com.boehmod.blockfront.bG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bG.class */
public final class C0089bG extends AbstractC0084bB {

    /* JADX INFO: renamed from: aN */
    private static final Component f584aN = Component.translatable("bf.message.inspect");

    /* JADX INFO: renamed from: aO */
    private static final Component f585aO = Component.translatable("bf.message.unequip");

    /* JADX INFO: renamed from: aP */
    private static final Component f586aP = Component.translatable("bf.message.equip");

    /* JADX INFO: renamed from: aQ */
    private static final Component f587aQ = Component.translatable("bf.message.showcase.add");

    /* JADX INFO: renamed from: aR */
    private static final Component f588aR = Component.translatable("bf.message.showcase.remove");

    /* JADX INFO: renamed from: aS */
    private static final Component f589aS = Component.translatable("bf.screen.dropdown.item.booster");

    public C0089bG(Screen screen, int i, int i2, int i3, int i4, CloudItemStack cloudItemStack) {
        super(screen, i, i2, i3, i4, f589aS, cloudItemStack);
        CloudRegistry cloudRegistryA = this.f1586e.m2670a();
        C0477iN inventory = this.f1585a.m1676a(this.f1587b).getInventory();
        Component component = inventory.m2159a(cloudRegistryA, cloudItemStack) ? f585aO : f586aP;
        Component component2 = inventory.isItemShowcased(cloudItemStack.getUUID()) ? f588aR : f587aQ;
        m1173a(f584aN);
        m1173a(component);
        m1173a(component2);
    }

    @Override // com.boehmod.blockfront.AbstractC0191ct
    /* JADX INFO: renamed from: g */
    public void mo286g(int i) {
        C0357g c0357g = (C0357g) this.f1586e.m2667b();
        C0478iO c0478iOA = c0357g.m1716a();
        C0482iS c0482iSM1676a = this.f1585a.m1676a(this.f1587b);
        switch (i) {
            case 1:
                this.f1587b.setScreen(new C0239do(this.f562b));
                break;
            case 2:
                c0357g.sendPacket(new PacketInventorySetItemDefault(this.f562b.getUUID()));
                c0478iOA.m2165b(RequestType.PLAYER_INVENTORY_DEFAULTS, c0482iSM1676a.getUUID());
                C0484iU.m2209a(this.f1587b, this.f1586e, this.f562b);
                break;
            case 3:
                c0357g.sendPacket(new PacketInventoryItemShowcase(this.f562b.getUUID()));
                c0478iOA.m2165b(RequestType.PLAYER_INVENTORY_SHOWCASE, c0482iSM1676a.getUUID());
                C0484iU.m2209a(this.f1587b, this.f1586e, this.f562b);
                break;
        }
    }
}
