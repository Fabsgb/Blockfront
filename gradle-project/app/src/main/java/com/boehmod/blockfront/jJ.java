package com.boehmod.blockfront;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jJ.class */
public class jJ {

    @Nullable
    private Item b = null;
    private long h = -1;
    private long r = -1;
    private int kh = 0;

    public void b(@NotNull ItemStack itemStack) {
        Item item = itemStack.getItem();
        if (this.b != item) {
            this.b = item;
            this.h = -1L;
            this.r = -1L;
            this.kh = 0;
        }
    }

    public boolean a(@NotNull ItemStack itemStack, long j, boolean z) {
        b(itemStack);
        Item item = itemStack.getItem();
        if (!(item instanceof C0558ur)) {
            return true;
        }
        uS uSVarM1210a = ((C0558ur) item).m1210a();
        long jCg = uSVarM1210a.cg();
        int iCh = uSVarM1210a.ch();
        if (this.r != j) {
            this.r = j;
            this.kh = 0;
        }
        if (this.kh >= iCh) {
            return false;
        }
        if (this.kh == 0) {
            if (this.h >= 0 && j - this.h < jCg) {
                return false;
            }
            if (z) {
                this.h = j;
            }
        }
        this.kh++;
        return true;
    }

    public long h() {
        return this.h;
    }

    public void bf() {
        this.b = null;
        this.h = -1L;
        this.r = -1L;
        this.kh = 0;
    }
}
