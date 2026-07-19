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

/* JADX INFO: renamed from: com.boehmod.blockfront.kq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kq.class */
public class C0287kq extends C0312lo {

    @NotNull
    private final DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<lR>> c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NotNull
    private static final lS f201c = new lS(0.0f, 15.75f, 0.0f, 16.0f, 16.0f, 16.0f);

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NotNull
    private static final DirectionProperty f202c = BlockStateProperties.HORIZONTAL_FACING;

    public C0287kq(@NotNull BlockBehaviour.Properties properties, @NotNull DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<lR>> deferredHolder) {
        super(properties, deferredHolder);
        this.c = deferredHolder;
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
            return BaseEntityBlock.createTickerHelper(blockEntityType, (BlockEntityType) this.c.get(), (level2, blockPos, blockState2, lRVar) -> {
                lR.a(blockPos, lRVar);
            });
        }
        return null;
    }

    @Override // com.boehmod.blockfront.C0312lo
    @NotNull
    public VoxelShape getShape(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f201c.a((Direction) blockState.getValue(f202c));
    }
}
