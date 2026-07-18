package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryActivateItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/* JADX INFO: renamed from: com.boehmod.blockfront.bD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bD.class */
public final class C0086bD extends AbstractC0084bB {

    /* JADX INFO: renamed from: aC */
    private static final Component f573aC = Component.translatable("bf.screen.dropdown.item.activated");

    /* JADX INFO: renamed from: aD */
    private static final Component f574aD = Component.translatable("bf.message.inspect");

    /* JADX INFO: renamed from: aE */
    private static final Component f575aE = Component.translatable("bf.message.activate");

    public C0086bD(Screen screen, int i, int i2, int i3, int i4, CloudItemStack cloudItemStack) {
        super(screen, i, i2, i3, i4, f573aC, cloudItemStack);
        m1173a(f574aD);
        m1173a(f575aE);
    }

    @Override // com.boehmod.blockfront.AbstractC0191ct
    /* JADX INFO: renamed from: g */
    public void mo286g(int i) {
        C0357g c0357g = (C0357g) this.f1586e.m2667b();
        switch (i) {
            case 1:
                this.f1587b.setScreen(new C0239do(this.f562b));
                break;
            case 2:
                c0357g.sendPacket(new PacketInventoryActivateItem(this.f562b.getUUID()));
                break;
        }
    }
}
