package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pc.class */
public class C0863pc {

    /* JADX INFO: renamed from: c */
    private final Item f4528c;

    /* JADX INFO: renamed from: nC */
    private final int f4529nC;

    /* JADX INFO: renamed from: k */
    private final Vec2 f4530k;

    /* JADX INFO: renamed from: nD */
    private int f4531nD;

    public C0863pc(@NotNull Item item, int i) {
        this(item, i, null);
    }

    public C0863pc(@NotNull Item item, int i, @Nullable Vec2 vec2) {
        this.f4531nD = 1;
        this.f4528c = item;
        this.f4529nC = i;
        this.f4530k = vec2;
    }

    /* JADX INFO: renamed from: a */
    public C0863pc m4310a(int i) {
        this.f4531nD = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ItemStack m4311a() {
        return new ItemStack(this.f4528c, this.f4531nD);
    }

    /* JADX INFO: renamed from: bk */
    public int m4312bk() {
        return this.f4529nC;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public Vec2 m4313e() {
        return this.f4530k;
    }
}
