package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.Object2LongMap;
import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kd.class */
public class C0600kd {

    /* JADX INFO: renamed from: I */
    private static final long f3472I = -1;

    /* JADX INFO: renamed from: J */
    private static final long f3473J = 1;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Object2LongMap<Item> f3474a = new Object2LongOpenHashMap();

    public C0600kd() {
        this.f3474a.defaultReturnValue(f3472I);
    }

    /* JADX INFO: renamed from: a */
    public boolean m2666a(@NotNull ItemStack itemStack, long j, boolean z) {
        long jMax;
        Item item = itemStack.getItem();
        if (!(item instanceof C1117uP)) {
            return true;
        }
        long jM6875cw = ((C1117uP) item).m6315a(itemStack).m6875cw();
        long j2 = this.f3474a.getLong(item);
        if (j2 != f3472I && (j <= j2 || j - j2 < jM6875cw - f3473J)) {
            return false;
        }
        if (z) {
            if (j2 != f3472I) {
                jMax = Math.max(j, j2 + jM6875cw);
            } else {
                jMax = j;
            }
            this.f3474a.put(item, jMax);
            return true;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public long m2667a(@NotNull ItemStack itemStack) {
        return this.f3474a.getLong(itemStack.getItem());
    }

    /* JADX INFO: renamed from: bd */
    public void m2668bd() {
        this.f3474a.clear();
    }
}
