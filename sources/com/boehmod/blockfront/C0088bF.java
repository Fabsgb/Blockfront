package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/* JADX INFO: renamed from: com.boehmod.blockfront.bF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bF.class */
public final class C0088bF extends AbstractC0084bB {

    /* JADX INFO: renamed from: aI */
    private static final Component f579aI = Component.translatable("bf.message.open");

    /* JADX INFO: renamed from: aJ */
    private static final Component f580aJ = Component.translatable("bf.message.delete");

    /* JADX INFO: renamed from: aK */
    private static final Component f581aK = Component.translatable("bf.screen.dropdown.item.case");

    /* JADX INFO: renamed from: aL */
    private static final Component f582aL = Component.translatable("bf.message.prompt.item.delete.case.title");

    /* JADX INFO: renamed from: aM */
    private static final Component f583aM = Component.translatable("bf.message.prompt.item.delete.case");

    public C0088bF(Screen screen, int i, int i2, int i3, int i4, CloudItemStack cloudItemStack) {
        super(screen, i, i2, i3, i4, f581aK, cloudItemStack);
        m1173a(f579aI);
        m1173a(f580aJ);
    }

    @Override // com.boehmod.blockfront.AbstractC0191ct
    /* JADX INFO: renamed from: g */
    public void mo286g(int i) {
        switch (i) {
            case 1:
                this.f1587b.setScreen(new C0241dq(this.f562b));
                break;
            case 2:
                C0218dT c0218dT = new C0218dT(this.f1556c, f582aL, z -> {
                    if (z) {
                        this.f1585a.m1676a(this.f1587b).getInventory().m2158a(this.f1586e, this.f562b);
                    }
                });
                c0218dT.m1273a(f583aM);
                this.f1587b.setScreen(c0218dT);
                break;
        }
    }
}
