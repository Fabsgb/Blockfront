package com.boehmod.blockfront;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.jJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jJ.class */
public class C0526jJ {

    /* JADX INFO: renamed from: b */
    @Nullable
    private Item f3111b = null;

    /* JADX INFO: renamed from: h */
    private long f3112h = -1;

    /* JADX INFO: renamed from: r */
    private long f3113r = -1;

    /* JADX INFO: renamed from: kh */
    private int f3114kh = 0;

    /* JADX INFO: renamed from: b */
    public void m2326b(@NotNull ItemStack itemStack) {
        Item item = itemStack.getItem();
        if (this.f3111b != item) {
            this.f3111b = item;
            this.f3112h = -1L;
            this.f3113r = -1L;
            this.f3114kh = 0;
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m2327a(@NotNull ItemStack itemStack, long j, boolean z) {
        m2326b(itemStack);
        Item item = itemStack.getItem();
        if (!(item instanceof C1144ur)) {
            return true;
        }
        C1119uS c1119uSM6347a = ((C1144ur) item).m6347a();
        long jM6222cg = c1119uSM6347a.m6222cg();
        int iM6225ch = c1119uSM6347a.m6225ch();
        if (this.f3113r != j) {
            this.f3113r = j;
            this.f3114kh = 0;
        }
        if (this.f3114kh >= iM6225ch) {
            return false;
        }
        if (this.f3114kh == 0) {
            if (this.f3112h >= 0 && j - this.f3112h < jM6222cg) {
                return false;
            }
            if (z) {
                this.f3112h = j;
            }
        }
        this.f3114kh++;
        return true;
    }

    /* JADX INFO: renamed from: h */
    public long m2328h() {
        return this.f3112h;
    }

    /* JADX INFO: renamed from: bf */
    public void m2329bf() {
        this.f3111b = null;
        this.f3112h = -1L;
        this.f3113r = -1L;
        this.f3114kh = 0;
    }
}
