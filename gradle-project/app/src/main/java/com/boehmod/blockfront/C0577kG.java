package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kG.class */
public class C0577kG extends C0634lK {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<C0710mh>> f3350b;

    public C0577kG(@NotNull BlockBehaviour.Properties properties, @NotNull DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<C0710mh>> deferredHolder) {
        super(properties, deferredHolder);
        this.f3350b = deferredHolder;
    }

    @Override // com.boehmod.blockfront.C0589kS
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
        if (level.isClientSide()) {
            return BaseEntityBlock.createTickerHelper(blockEntityType, (BlockEntityType) this.f3350b.get(), (level2, blockPos, blockState2, c0710mh) -> {
                C0710mh.m3234a(blockPos, c0710mh);
            });
        }
        return null;
    }
}
