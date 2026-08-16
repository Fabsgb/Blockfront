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

/* JADX INFO: renamed from: com.boehmod.blockfront.kM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kM.class */
public class C0583kM extends C0634lK {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<C0716mn>> f3364c;

    /* JADX INFO: renamed from: c */
    @NotNull
    private static final C0717mo f3365c = new C0717mo(0.0f, 15.75f, 0.0f, 16.0f, 16.0f, 16.0f);

    /* JADX INFO: renamed from: c */
    @NotNull
    private static final DirectionProperty f3366c = BlockStateProperties.HORIZONTAL_FACING;

    public C0583kM(@NotNull BlockBehaviour.Properties properties, @NotNull DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<C0716mn>> deferredHolder) {
        super(properties, deferredHolder);
        this.f3364c = deferredHolder;
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
            return BaseEntityBlock.createTickerHelper(blockEntityType, (BlockEntityType) this.f3364c.get(), (level2, blockPos, blockState2, c0716mn) -> {
                C0716mn.m3265a(blockPos, c0716mn);
            });
        }
        return null;
    }

    @Override // com.boehmod.blockfront.C0634lK
    @NotNull
    public VoxelShape getShape(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3365c.m3266a((Direction) blockState.getValue(f3366c));
    }
}
