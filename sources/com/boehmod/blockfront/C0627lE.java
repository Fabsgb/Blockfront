package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lE.class */
public class C0627lE {

    /* JADX INFO: renamed from: F */
    @NotNull
    public static final ObjectList<C0627lE> f3403F = new ObjectArrayList();

    /* JADX INFO: renamed from: bi */
    @NotNull
    public final String f3404bi;

    /* JADX INFO: renamed from: dj */
    @NotNull
    public final ResourceLocation f3405dj;

    /* JADX INFO: renamed from: n */
    @NotNull
    public final DeferredHolder<Block, Block> f3406n;

    public C0627lE(@NotNull String str, @NotNull ResourceLocation resourceLocation) {
        this.f3404bi = str;
        this.f3405dj = resourceLocation;
        this.f3406n = C1218wL.f6426c.register(str + "_board", () -> {
            return new C0610ko(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
        });
        f3403F.add(this);
    }
}
