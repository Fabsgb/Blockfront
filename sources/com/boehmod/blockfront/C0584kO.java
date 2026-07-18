package com.boehmod.blockfront;

import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kO.class */
public class C0584kO extends C0617kv implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: n */
    @NotNull
    private static final BooleanProperty f3264n = BlockStateProperties.POWERED;

    /* JADX INFO: renamed from: m */
    @NotNull
    private static final DirectionProperty f3265m = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: o */
    @NotNull
    private static final BooleanProperty f3266o = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final DeferredHolder<SoundEvent, SoundEvent> f3267e;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final DeferredHolder<SoundEvent, SoundEvent> f3268f;

    public C0584kO(@NotNull BlockBehaviour.Properties properties, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        super(properties);
        this.f3267e = deferredHolder;
        this.f3268f = deferredHolder2;
        registerDefaultState((BlockState) ((BlockState) ((BlockState) this.stateDefinition.any().setValue(f3265m, Direction.NORTH)).setValue(f3266o, false)).setValue(f3264n, false));
    }

    /* JADX INFO: renamed from: a */
    private void m2610a(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos) {
        level.updateNeighborsAt(blockPos, this);
        level.updateNeighborsAt(blockPos.relative(blockState.getValue(f3265m).getOpposite()), this);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return Shapes.block();
    }

    @Override // com.boehmod.blockfront.C0617kv
    @OverridingMethodsMustInvokeSuper
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{f3264n});
    }

    @NotNull
    public InteractionResult useWithoutItem(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult blockHitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }
        BlockState blockState2 = (BlockState) blockState.cycle(f3264n);
        boolean zBooleanValue = ((Boolean) blockState2.getValue(f3264n)).booleanValue();
        level.setBlock(blockPos, blockState2, 3);
        level.playSound((Player) null, blockPos, (SoundEvent) (zBooleanValue ? this.f3267e : this.f3268f).get(), SoundSource.BLOCKS, 1.0f, 1.0f);
        m2610a(blockState2, level, blockPos);
        return InteractionResult.CONSUME;
    }

    public boolean isSignalSource(@NotNull BlockState blockState) {
        return true;
    }

    public int getSignal(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull Direction direction) {
        return ((Boolean) blockState.getValue(f3264n)).booleanValue() ? 15 : 0;
    }

    public int getDirectSignal(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull Direction direction) {
        if (((Boolean) blockState.getValue(f3264n)).booleanValue() && blockState.getValue(f3265m) == direction) {
            return 15;
        }
        return 0;
    }

    public void onRemove(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState2, boolean z) {
        if (!z && !blockState.is(blockState2.getBlock())) {
            if (((Boolean) blockState.getValue(f3264n)).booleanValue()) {
                m2610a(blockState, level, blockPos);
            }
            super.onRemove(blockState, level, blockPos, blockState2, z);
        }
    }
}
