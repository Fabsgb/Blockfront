package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kq.class */
public class C0612kq extends C0663lo {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<C0640lR>> f3332c;

    /* JADX INFO: renamed from: c */
    @NotNull
    private static final C0641lS f3333c = new C0641lS(0.0f, 15.75f, 0.0f, 16.0f, 16.0f, 16.0f);

    /* JADX INFO: renamed from: c */
    @NotNull
    private static final DirectionProperty f3334c = BlockStateProperties.HORIZONTAL_FACING;

    public C0612kq(@NotNull BlockBehaviour.Properties properties, @NotNull DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<C0640lR>> deferredHolder) {
        super(properties, deferredHolder);
        this.f3332c = deferredHolder;
    }

    @Override // com.boehmod.blockfront.C0618kw
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
        if (level.isClientSide()) {
            return BaseEntityBlock.createTickerHelper(blockEntityType, (BlockEntityType) this.f3332c.get(), (level2, blockPos, blockState2, c0640lR) -> {
                C0640lR.m2834a(blockPos, c0640lR);
            });
        }
        return null;
    }

    @Override // com.boehmod.blockfront.C0663lo
    @NotNull
    public VoxelShape getShape(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3333c.m2835a((Direction) blockState.getValue(f3334c));
    }
}
