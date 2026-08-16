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

/* JADX INFO: renamed from: com.boehmod.blockfront.lU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lU.class */
public class C0644lU extends Block implements InterfaceC0642lS {

    /* JADX INFO: renamed from: C */
    @NotNull
    public static final BooleanProperty f3634C = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: ed */
    private final boolean f3635ed;

    /* JADX INFO: renamed from: ee */
    private final boolean f3636ee;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final InterfaceC0643lT f3637a;

    public C0644lU(boolean z, boolean z2, @NotNull InterfaceC0643lT interfaceC0643lT) {
        super(BlockBehaviour.Properties.of().strength(-1.0f, 3600000.0f).noOcclusion().noLootTable().noTerrainParticles().isSuffocating((blockState, blockGetter, blockPos) -> {
            return false;
        }).isRedstoneConductor((blockState2, blockGetter2, blockPos2) -> {
            return false;
        }).isValidSpawn((blockState3, blockGetter3, blockPos3, entityType) -> {
            return false;
        }));
        this.f3635ed = z;
        this.f3636ee = z2;
        this.f3637a = interfaceC0643lT;
        registerDefaultState((BlockState) getStateDefinition().any().setValue(f3634C, Boolean.FALSE));
    }

    /* JADX INFO: renamed from: d */
    public boolean m2911d(@Nullable Entity entity) {
        return this.f3637a.shouldBlockCollision(entity);
    }

    protected boolean isPathfindable(@NotNull BlockState blockState, @NotNull PathComputationType pathComputationType) {
        return this.f3636ee;
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, @NotNull Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (((Boolean) blockState.getValue(f3634C)).booleanValue()) {
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
        return (!(collisionContext instanceof EntityCollisionContext) || m2911d(((EntityCollisionContext) collisionContext).getEntity())) ? super.getCollisionShape(blockState, blockGetter, blockPos, collisionContext) : Shapes.empty();
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
        builder.add(new Property[]{f3634C});
    }

    @NotNull
    public FluidState getFluidState(BlockState blockState) {
        return ((Boolean) blockState.getValue(f3634C)).booleanValue() ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockState blockStateDefaultBlockState = defaultBlockState();
        Level level = blockPlaceContext.getLevel();
        BlockPos clickedPos = blockPlaceContext.getClickedPos();
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        if (blockStateDefaultBlockState.canSurvive(level, clickedPos)) {
            return (BlockState) blockStateDefaultBlockState.setValue(f3634C, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
        }
        return null;
    }

    @Override // com.boehmod.blockfront.InterfaceC0642lS
    /* JADX INFO: renamed from: av */
    public boolean mo2909av() {
        return this.f3635ed;
    }
}
