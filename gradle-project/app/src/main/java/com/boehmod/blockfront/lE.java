package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lE.class */
public class lE {

    @NotNull
    public static final ObjectList<lE> F = new ObjectArrayList();

    @NotNull
    public final String bi;

    @NotNull
    public final ResourceLocation dj;

    @NotNull
    public final DeferredHolder<Block, Block> n;

    public lE(@NotNull String str, @NotNull ResourceLocation resourceLocation) {
        this.bi = str;
        this.dj = resourceLocation;
        this.n = wL.c.register(str + "_board", () -> {
            return new C0285ko(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
        });
        F.add(this);
    }
}
