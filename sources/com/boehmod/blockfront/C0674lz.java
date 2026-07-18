package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lz.class */
public class C0674lz {

    /* JADX INFO: renamed from: E */
    @NotNull
    public static final ObjectList<C0674lz> f3597E = new ObjectArrayList();

    /* JADX INFO: renamed from: j */
    @NotNull
    public final DeferredHolder<Block, Block> f3598j;

    /* JADX INFO: renamed from: k */
    @NotNull
    public final DeferredHolder<Block, Block> f3599k;

    /* JADX INFO: renamed from: l */
    @NotNull
    public final DeferredHolder<Block, Block> f3600l;

    /* JADX INFO: renamed from: m */
    @NotNull
    public final DeferredHolder<Block, Block> f3601m;

    public C0674lz(@NotNull String str, boolean z, boolean z2, @NotNull InterfaceC0672lx interfaceC0672lx) {
        this.f3598j = C1218wL.f6425b.register(str, () -> {
            return new C0673ly(z, z2, interfaceC0672lx);
        });
        this.f3599k = C1218wL.f6425b.register(str + "_slab", () -> {
            return new C0623lA(z, z2, interfaceC0672lx);
        });
        this.f3600l = C1218wL.f6425b.register(str + "_stair", () -> {
            return new C0624lB(((Block) this.f3598j.get()).defaultBlockState(), z, z2, interfaceC0672lx);
        });
        this.f3601m = C1218wL.f6425b.register(str + "_wall", () -> {
            return new C0625lC(z, z2, interfaceC0672lx);
        });
        f3597E.add(this);
    }
}
