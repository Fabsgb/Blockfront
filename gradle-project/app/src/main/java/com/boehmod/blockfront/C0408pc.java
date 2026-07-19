package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pc.class */
public class C0408pc {
    private final Item c;
    private final int nC;
    private final Vec2 k;
    private int nD;

    public C0408pc(@NotNull Item item, int i) {
        this(item, i, null);
    }

    public C0408pc(@NotNull Item item, int i, @Nullable Vec2 vec2) {
        this.nD = 1;
        this.c = item;
        this.nC = i;
        this.k = vec2;
    }

    public C0408pc a(int i) {
        this.nD = i;
        return this;
    }

    public ItemStack a() {
        return new ItemStack(this.c, this.nD);
    }

    public int bk() {
        return this.nC;
    }

    @Nullable
    public Vec2 e() {
        return this.k;
    }
}
