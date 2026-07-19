package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bF.class */
public final class bF extends bB {
    private static final Component aI = Component.translatable("bf.message.open");
    private static final Component aJ = Component.translatable("bf.message.delete");
    private static final Component aK = Component.translatable("bf.screen.dropdown.item.case");
    private static final Component aL = Component.translatable("bf.message.prompt.item.delete.case.title");
    private static final Component aM = Component.translatable("bf.message.prompt.item.delete.case");

    public bF(Screen screen, int i, int i2, int i3, int i4, CloudItemStack cloudItemStack) {
        super(screen, i, i2, i3, i4, aK, cloudItemStack);
        a(aI);
        a(aJ);
    }

    @Override // com.boehmod.blockfront.AbstractC0076ct
    public void g(int i) {
        switch (i) {
            case 1:
                this.b.setScreen(new C0099dq(this.b));
                break;
            case 2:
                dT dTVar = new dT(this.c, aL, z -> {
                    if (z) {
                        this.a.m404a(this.b).getInventory().a(this.e, this.b);
                    }
                });
                dTVar.a(aM);
                this.b.setScreen(dTVar);
                break;
        }
    }
}
