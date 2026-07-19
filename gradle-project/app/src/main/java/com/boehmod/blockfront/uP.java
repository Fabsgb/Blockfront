package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uP.class */
public class uP extends uO {

    @NotNull
    private static final String dq = "reload_start";

    @NotNull
    private static final String dr = "reload";

    @NotNull
    private static final String ds = "reload_stop";

    @NotNull
    private static final String dt = "idle";
    private final float nD;
    private final float nE;
    private final float nF;

    public uP(float f, float f2, float f3) {
        this.nD = f;
        this.nE = f2;
        this.nF = f3;
    }

    private int a(@NotNull C0558ur c0558ur, @NotNull ItemStack itemStack) {
        int iCb = c0558ur.m1206a(itemStack).cb() - C0558ur.a(itemStack);
        int iM1200b = C0558ur.m1200b(itemStack);
        if (iM1200b < iCb) {
            iCb = iM1200b;
        }
        return iCb;
    }

    @Override // com.boehmod.blockfront.uO
    public void a(@NotNull C0558ur c0558ur, @NotNull ItemStack itemStack, @NotNull List<String> list) {
        int iA = a(c0558ur, itemStack);
        list.add(dq);
        for (int i = 0; i < iA; i++) {
            list.add(dr);
        }
        list.add(ds);
        list.add(dt);
    }

    @Override // com.boehmod.blockfront.uO
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public float mo1175a(@NotNull C0558ur c0558ur, @NotNull ItemStack itemStack) {
        return (this.nD + this.nF + (this.nE * a(c0558ur, itemStack))) * 20.0f;
    }

    @Override // com.boehmod.blockfront.uO
    public boolean cK() {
        return false;
    }
}
