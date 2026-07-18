package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uP.class */
public class C1116uP extends AbstractC1115uO {

    /* JADX INFO: renamed from: dq */
    @NotNull
    private static final String f5862dq = "reload_start";

    /* JADX INFO: renamed from: dr */
    @NotNull
    private static final String f5863dr = "reload";

    /* JADX INFO: renamed from: ds */
    @NotNull
    private static final String f5864ds = "reload_stop";

    /* JADX INFO: renamed from: dt */
    @NotNull
    private static final String f5865dt = "idle";

    /* JADX INFO: renamed from: nD */
    private final float f5866nD;

    /* JADX INFO: renamed from: nE */
    private final float f5867nE;

    /* JADX INFO: renamed from: nF */
    private final float f5868nF;

    public C1116uP(float f, float f2, float f3) {
        this.f5866nD = f;
        this.f5867nE = f2;
        this.f5868nF = f3;
    }

    /* JADX INFO: renamed from: a */
    private int m6146a(@NotNull C1144ur c1144ur, @NotNull ItemStack itemStack) {
        int iM6424cb = c1144ur.m6318a(itemStack).m6424cb() - C1144ur.m6301a(itemStack);
        int iM6304b = C1144ur.m6304b(itemStack);
        if (iM6304b < iM6424cb) {
            iM6424cb = iM6304b;
        }
        return iM6424cb;
    }

    @Override // com.boehmod.blockfront.AbstractC1115uO
    /* JADX INFO: renamed from: a */
    public void mo6143a(@NotNull C1144ur c1144ur, @NotNull ItemStack itemStack, @NotNull List<String> list) {
        int iM6146a = m6146a(c1144ur, itemStack);
        list.add(f5862dq);
        for (int i = 0; i < iM6146a; i++) {
            list.add(f5863dr);
        }
        list.add(f5864ds);
        list.add(f5865dt);
    }

    @Override // com.boehmod.blockfront.AbstractC1115uO
    /* JADX INFO: renamed from: a */
    public float mo6144a(@NotNull C1144ur c1144ur, @NotNull ItemStack itemStack) {
        return (this.f5866nD + this.f5868nF + (this.f5867nE * m6146a(c1144ur, itemStack))) * 20.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC1115uO
    /* JADX INFO: renamed from: cK */
    public boolean mo6145cK() {
        return false;
    }
}
