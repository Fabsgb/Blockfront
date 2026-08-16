package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryActivateItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/* JADX INFO: renamed from: com.boehmod.blockfront.bM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bM.class */
public final class C0096bM extends AbstractC0094bK {

    /* JADX INFO: renamed from: aC */
    private static final Component f642aC = Component.translatable("bf.screen.dropdown.item.activated");

    /* JADX INFO: renamed from: aD */
    private static final Component f643aD = Component.translatable("bf.message.inspect");

    /* JADX INFO: renamed from: aE */
    private static final Component f644aE = Component.translatable("bf.message.activate");

    public C0096bM(Screen screen, int i, int i2, int i3, int i4, CloudItemStack cloudItemStack) {
        super(screen, i, i2, i3, i4, f642aC, cloudItemStack);
        m770a(f643aD);
        m770a(f644aE);
    }

    @Override // com.boehmod.blockfront.AbstractC0139cC
    /* JADX INFO: renamed from: g */
    public void mo390g(int i) {
        C0358g c0358g = (C0358g) this.f1057f.m2852b();
        switch (i) {
            case 1:
                this.f1058a.setScreen(new C0249dx(this.f631b));
                break;
            case 2:
                c0358g.sendPacket(new PacketInventoryActivateItem(this.f631b.getUUID()));
                break;
        }
    }
}
