package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventorySetItemDefault;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/* JADX INFO: renamed from: com.boehmod.blockfront.bN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bN.class */
public final class C0097bN extends AbstractC0094bK {

    /* JADX INFO: renamed from: aF */
    private static final Component f645aF = Component.translatable("bf.message.unequip");

    /* JADX INFO: renamed from: aG */
    private static final Component f646aG = Component.translatable("bf.message.equip");

    /* JADX INFO: renamed from: aH */
    private static final Component f647aH = Component.translatable("bf.screen.dropdown.item.cape");

    public C0097bN(Screen screen, int i, int i2, int i3, int i4, CloudItemStack cloudItemStack) {
        super(screen, i, i2, i3, i4, f647aH, cloudItemStack);
        m770a(this.f1056a.m1886a(this.f1058a).getInventory().m2486a(this.f1057f.m2855a(), cloudItemStack) ? f645aF : f646aG);
    }

    @Override // com.boehmod.blockfront.AbstractC0139cC
    /* JADX INFO: renamed from: g */
    public void mo390g(int i) {
        C0551jh c0551jhA = ((C0358g) this.f1057f.m2852b()).m1722a();
        C0555jl c0555jlM1886a = this.f1056a.m1886a(this.f1058a);
        switch (i) {
            case 1:
                ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketInventorySetItemDefault(this.f631b.getUUID()));
                c0551jhA.m2492b(RequestType.PLAYER_INVENTORY_DEFAULTS, c0555jlM1886a.getUUID());
                C0557jn.m2536a(this.f1058a, this.f1057f, this.f631b);
                break;
        }
    }
}
