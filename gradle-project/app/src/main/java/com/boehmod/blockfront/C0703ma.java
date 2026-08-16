package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ma */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ma.class */
public class C0703ma {

    /* JADX INFO: renamed from: O */
    @NotNull
    public static final ObjectList<C0703ma> f3877O = new ObjectArrayList();

    /* JADX INFO: renamed from: br */
    @NotNull
    public final String f3878br;

    /* JADX INFO: renamed from: dj */
    @NotNull
    public final ResourceLocation f3879dj;

    /* JADX INFO: renamed from: n */
    @NotNull
    public final DeferredHolder<Block, Block> f3880n;

    public C0703ma(@NotNull String str, @NotNull ResourceLocation resourceLocation) {
        this.f3878br = str;
        this.f3879dj = resourceLocation;
        this.f3880n = C1295xi.f6989c.register(str + "_board", () -> {
            return new C0581kK(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
        });
        f3877O.add(this);
    }
}
