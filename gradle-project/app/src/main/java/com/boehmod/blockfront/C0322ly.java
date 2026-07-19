package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ly, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ly.class */
public class C0322ly extends Block implements InterfaceC0320lw {

    @NotNull
    public static final BooleanProperty C = BlockStateProperties.WATERLOGGED;
    private final boolean dK;
    private final boolean dL;

    @NotNull
    private final InterfaceC0321lx a;

    public C0322ly(boolean z, boolean z2, @NotNull InterfaceC0321lx interfaceC0321lx) {
        super(BlockBehaviour.Properties.of().strength(-1.0f, 3600000.0f).noOcclusion().noLootTable().noTerrainParticles().isSuffocating((blockState, blockGetter, blockPos) -> {
            return false;
        }).isRedstoneConductor((blockState2, blockGetter2, blockPos2) -> {
            return false;
        }).isValidSpawn((blockState3, blockGetter3, blockPos3, entityType) -> {
            return false;
        }));
        this.dK = z;
        this.dL = z2;
        this.a = interfaceC0321lx;
        registerDefaultState((BlockState) getStateDefinition().any().setValue(C, Boolean.FALSE));
    }

    public boolean d(@Nullable Entity entity) {
        return this.a.shouldBlockCollision(entity);
    }

    protected boolean isPathfindable(@NotNull BlockState blockState, @NotNull PathComputationType pathComputationType) {
        return this.dL;
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, @NotNull Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (((Boolean) blockState.getValue(C)).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        if (collisionContext instanceof EntityCollisionContext) {
            Player entity = ((EntityCollisionContext) collisionContext).getEntity();
            if ((entity instanceof Player) && !entity.isCreative()) {
                return Shapes.empty();
            }
        }
        return super.getShape(blockState, blockGetter, blockPos, collisionContext);
    }

    @NotNull
    public VoxelShape getCollisionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return (!(collisionContext instanceof EntityCollisionContext) || d(((EntityCollisionContext) collisionContext).getEntity())) ? super.getCollisionShape(blockState, blockGetter, blockPos, collisionContext) : Shapes.empty();
    }

    public float getShadeBrightness(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return 1.0f;
    }

    public boolean propagatesSkylightDown(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        return (localPlayer == null || !localPlayer.isCreative()) ? RenderShape.INVISIBLE : RenderShape.MODEL;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{C});
    }

    @NotNull
    public FluidState getFluidState(BlockState blockState) {
        return ((Boolean) blockState.getValue(C)).booleanValue() ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockState blockStateDefaultBlockState = defaultBlockState();
        Level level = blockPlaceContext.getLevel();
        BlockPos clickedPos = blockPlaceContext.getClickedPos();
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        if (blockStateDefaultBlockState.canSurvive(level, clickedPos)) {
            return (BlockState) blockStateDefaultBlockState.setValue(C, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
        }
        return null;
    }

    @Override // com.boehmod.blockfront.InterfaceC0320lw
    public boolean al() {
        return this.dK;
    }
}
