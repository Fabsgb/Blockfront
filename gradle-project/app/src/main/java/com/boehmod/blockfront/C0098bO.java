package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/* JADX INFO: renamed from: com.boehmod.blockfront.bO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bO.class */
public final class C0098bO extends AbstractC0094bK {

    /* JADX INFO: renamed from: aI */
    private static final Component f648aI = Component.translatable("bf.message.open");

    /* JADX INFO: renamed from: aJ */
    private static final Component f649aJ = Component.translatable("bf.message.delete");

    /* JADX INFO: renamed from: aK */
    private static final Component f650aK = Component.translatable("bf.screen.dropdown.item.case");

    /* JADX INFO: renamed from: aL */
    private static final Component f651aL = Component.translatable("bf.message.prompt.item.delete.case.title");

    /* JADX INFO: renamed from: aM */
    private static final Component f652aM = Component.translatable("bf.message.prompt.item.delete.case");

    public C0098bO(Screen screen, int i, int i2, int i3, int i4, CloudItemStack cloudItemStack) {
        super(screen, i, i2, i3, i4, f650aK, cloudItemStack);
        m770a(f648aI);
        m770a(f649aJ);
    }

    @Override // com.boehmod.blockfront.AbstractC0139cC
    /* JADX INFO: renamed from: g */
    public void mo390g(int i) {
        switch (i) {
            case 1:
                this.f1058a.setScreen(new C0251dz(this.f631b));
                break;
            case 2:
                C0283ee c0283ee = new C0283ee(this.f1035c, f651aL, z -> {
                    if (z) {
                        this.f1056a.m1886a(this.f1058a).getInventory().m2485a(this.f1057f, this.f631b);
                    }
                });
                c0283ee.m1324a(f652aM);
                this.f1058a.setScreen(c0283ee);
                break;
        }
    }
}
