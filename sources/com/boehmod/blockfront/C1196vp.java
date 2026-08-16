package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vp.class */
public class C1196vp extends AbstractC1195vo {

    /* JADX INFO: renamed from: dB */
    @NotNull
    private static final String f6501dB = "reload_start";

    /* JADX INFO: renamed from: dC */
    @NotNull
    private static final String f6502dC = "reload";

    /* JADX INFO: renamed from: dD */
    @NotNull
    private static final String f6503dD = "reload_stop";

    /* JADX INFO: renamed from: dE */
    @NotNull
    private static final String f6504dE = "idle";

    /* JADX INFO: renamed from: oB */
    private final float f6505oB;

    /* JADX INFO: renamed from: oC */
    private final float f6506oC;

    /* JADX INFO: renamed from: oD */
    private final float f6507oD;

    public C1196vp(float f, float f2, float f3) {
        this.f6505oB = f;
        this.f6506oC = f2;
        this.f6507oD = f3;
    }

    /* JADX INFO: renamed from: a */
    private int m6799a(@NotNull C1117uP c1117uP, @NotNull ItemStack itemStack, int i, int i2) {
        int iM6402cq = c1117uP.m6283a(itemStack).m6402cq() - i;
        if (i2 < iM6402cq) {
            iM6402cq = i2;
        }
        return iM6402cq;
    }

    @Override // com.boehmod.blockfront.AbstractC1195vo
    /* JADX INFO: renamed from: a */
    public void mo6796a(@NotNull C1117uP c1117uP, @NotNull ItemStack itemStack, int i, int i2, @NotNull List<String> list) {
        int iM6799a = m6799a(c1117uP, itemStack, i, i2);
        list.add(f6501dB);
        for (int i3 = 0; i3 < iM6799a; i3++) {
            list.add(f6502dC);
        }
        list.add(f6503dD);
        list.add(f6504dE);
    }

    @Override // com.boehmod.blockfront.AbstractC1195vo
    /* JADX INFO: renamed from: a */
    public float mo6797a(@NotNull C1117uP c1117uP, @NotNull ItemStack itemStack, int i, int i2) {
        return (this.f6505oB + this.f6507oD + (this.f6506oC * m6799a(c1117uP, itemStack, i, i2))) * 20.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC1195vo
    /* JADX INFO: renamed from: cT */
    public boolean mo6798cT() {
        return false;
    }
}
