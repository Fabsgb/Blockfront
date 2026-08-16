package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.py */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/py.class */
public class C0886py {

    /* JADX INFO: renamed from: b */
    private final Item f4861b;

    /* JADX INFO: renamed from: pB */
    private final int f4862pB;

    /* JADX INFO: renamed from: k */
    private final Vec2 f4863k;

    /* JADX INFO: renamed from: pC */
    private int f4864pC;

    public C0886py(@NotNull Item item, int i) {
        this(item, i, null);
    }

    public C0886py(@NotNull Item item, int i, @Nullable Vec2 vec2) {
        this.f4864pC = 1;
        this.f4861b = item;
        this.f4862pB = i;
        this.f4863k = vec2;
    }

    /* JADX INFO: renamed from: a */
    public C0886py m4635a(int i) {
        this.f4864pC = i;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public ItemStack m4636c() {
        return new ItemStack(this.f4861b, this.f4864pC);
    }

    /* JADX INFO: renamed from: bz */
    public int m4637bz() {
        return this.f4862pB;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public Vec2 m4638e() {
        return this.f4863k;
    }
}
