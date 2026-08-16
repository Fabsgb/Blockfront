package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lV.class */
public class C0645lV {

    /* JADX INFO: renamed from: N */
    @NotNull
    public static final ObjectList<C0645lV> f3638N = new ObjectArrayList();

    /* JADX INFO: renamed from: j */
    @NotNull
    public final DeferredHolder<Block, Block> f3639j;

    /* JADX INFO: renamed from: k */
    @NotNull
    public final DeferredHolder<Block, Block> f3640k;

    /* JADX INFO: renamed from: l */
    @NotNull
    public final DeferredHolder<Block, Block> f3641l;

    /* JADX INFO: renamed from: m */
    @NotNull
    public final DeferredHolder<Block, Block> f3642m;

    public C0645lV(@NotNull String str, boolean z, boolean z2, @NotNull InterfaceC0643lT interfaceC0643lT) {
        this.f3639j = C1295xi.f6988b.register(str, () -> {
            return new C0644lU(z, z2, interfaceC0643lT);
        });
        this.f3640k = C1295xi.f6988b.register(str + "_slab", () -> {
            return new C0646lW(z, z2, interfaceC0643lT);
        });
        this.f3641l = C1295xi.f6988b.register(str + "_stair", () -> {
            return new C0647lX(((Block) this.f3639j.get()).defaultBlockState(), z, z2, interfaceC0643lT);
        });
        this.f3642m = C1295xi.f6988b.register(str + "_wall", () -> {
            return new C0648lY(z, z2, interfaceC0643lT);
        });
        f3638N.add(this);
    }
}
