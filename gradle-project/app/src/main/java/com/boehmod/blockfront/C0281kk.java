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

/* JADX INFO: renamed from: com.boehmod.blockfront.kk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kk.class */
public class C0281kk extends C0312lo {

    @NotNull
    private final DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<lL>> b;

    public C0281kk(@NotNull BlockBehaviour.Properties properties, @NotNull DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<lL>> deferredHolder) {
        super(properties, deferredHolder);
        this.b = deferredHolder;
    }

    @Override // com.boehmod.blockfront.C0293kw
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
        if (level.isClientSide()) {
            return BaseEntityBlock.createTickerHelper(blockEntityType, (BlockEntityType) this.b.get(), (level2, blockPos, blockState2, lLVar) -> {
                lL.a(blockPos, lLVar);
            });
        }
        return null;
    }
}
