package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemShowcase;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventorySetItemDefault;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/* JADX INFO: renamed from: com.boehmod.blockfront.bP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bP.class */
public final class C0099bP extends AbstractC0094bK {

    /* JADX INFO: renamed from: aN */
    private static final Component f653aN = Component.translatable("bf.message.inspect");

    /* JADX INFO: renamed from: aO */
    private static final Component f654aO = Component.translatable("bf.message.unequip");

    /* JADX INFO: renamed from: aP */
    private static final Component f655aP = Component.translatable("bf.message.equip");

    /* JADX INFO: renamed from: aQ */
    private static final Component f656aQ = Component.translatable("bf.message.showcase.add");

    /* JADX INFO: renamed from: aR */
    private static final Component f657aR = Component.translatable("bf.message.showcase.remove");

    /* JADX INFO: renamed from: aS */
    private static final Component f658aS = Component.translatable("bf.screen.dropdown.item.booster");

    public C0099bP(Screen screen, int i, int i2, int i3, int i4, CloudItemStack cloudItemStack) {
        super(screen, i, i2, i3, i4, f658aS, cloudItemStack);
        CloudRegistry cloudRegistryA = this.f1057f.m2855a();
        C0550jg inventory = this.f1056a.m1886a(this.f1058a).getInventory();
        Component component = inventory.m2486a(cloudRegistryA, cloudItemStack) ? f654aO : f655aP;
        Component component2 = inventory.isItemShowcased(cloudItemStack.getUUID()) ? f657aR : f656aQ;
        m770a(f653aN);
        m770a(component);
        m770a(component2);
    }

    @Override // com.boehmod.blockfront.AbstractC0139cC
    /* JADX INFO: renamed from: g */
    public void mo390g(int i) {
        C0358g c0358g = (C0358g) this.f1057f.m2852b();
        C0551jh c0551jhA = c0358g.m1722a();
        C0555jl c0555jlM1886a = this.f1056a.m1886a(this.f1058a);
        switch (i) {
            case 1:
                this.f1058a.setScreen(new C0249dx(this.f631b));
                break;
            case 2:
                c0358g.sendPacket(new PacketInventorySetItemDefault(this.f631b.getUUID()));
                c0551jhA.m2492b(RequestType.PLAYER_INVENTORY_DEFAULTS, c0555jlM1886a.getUUID());
                C0557jn.m2536a(this.f1058a, this.f1057f, this.f631b);
                break;
            case 3:
                c0358g.sendPacket(new PacketInventoryItemShowcase(this.f631b.getUUID()));
                c0551jhA.m2492b(RequestType.PLAYER_INVENTORY_SHOWCASE, c0555jlM1886a.getUUID());
                C0557jn.m2536a(this.f1058a, this.f1057f, this.f631b);
                break;
        }
    }
}
