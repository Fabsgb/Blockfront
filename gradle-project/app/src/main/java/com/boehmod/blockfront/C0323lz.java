package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lz.class */
public class C0323lz {

    @NotNull
    public static final ObjectList<C0323lz> E = new ObjectArrayList();

    @NotNull
    public final DeferredHolder<Block, Block> j;

    @NotNull
    public final DeferredHolder<Block, Block> k;

    @NotNull
    public final DeferredHolder<Block, Block> l;

    @NotNull
    public final DeferredHolder<Block, Block> m;

    public C0323lz(@NotNull String str, boolean z, boolean z2, @NotNull InterfaceC0321lx interfaceC0321lx) {
        this.j = wL.b.register(str, () -> {
            return new C0322ly(z, z2, interfaceC0321lx);
        });
        this.k = wL.b.register(str + "_slab", () -> {
            return new lA(z, z2, interfaceC0321lx);
        });
        this.l = wL.b.register(str + "_stair", () -> {
            return new lB(((Block) this.j.get()).defaultBlockState(), z, z2, interfaceC0321lx);
        });
        this.m = wL.b.register(str + "_wall", () -> {
            return new lC(z, z2, interfaceC0321lx);
        });
        E.add(this);
    }
}
