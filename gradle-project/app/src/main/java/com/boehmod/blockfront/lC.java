package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lC.class */
public class lC extends WallBlock implements InterfaceC0320lw {
    private final boolean dQ;
    private final boolean dR;

    @NotNull
    private final InterfaceC0321lx d;

    public lC(boolean z, boolean z2, @NotNull InterfaceC0321lx interfaceC0321lx) {
        super(BlockBehaviour.Properties.of().strength(-1.0f, 3600000.0f).noOcclusion().noLootTable().noTerrainParticles().isSuffocating((blockState, blockGetter, blockPos) -> {
            return false;
        }).isRedstoneConductor((blockState2, blockGetter2, blockPos2) -> {
            return false;
        }).isValidSpawn((blockState3, blockGetter3, blockPos3, entityType) -> {
            return false;
        }));
        this.dQ = z;
        this.dR = z2;
        this.d = interfaceC0321lx;
    }

    public boolean d(@Nullable Entity entity) {
        return this.d.shouldBlockCollision(entity);
    }

    protected boolean isPathfindable(@NotNull BlockState blockState, @NotNull PathComputationType pathComputationType) {
        return this.dR;
    }

    public float getShadeBrightness(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return 1.0f;
    }

    public boolean propagatesSkylightDown(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return true;
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return ((collisionContext instanceof EntityCollisionContext) && d(((EntityCollisionContext) collisionContext).getEntity())) ? Shapes.empty() : super.getShape(blockState, blockGetter, blockPos, collisionContext);
    }

    @NotNull
    public VoxelShape getCollisionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return (!(collisionContext instanceof EntityCollisionContext) || d(((EntityCollisionContext) collisionContext).getEntity())) ? super.getShape(blockState, blockGetter, blockPos, collisionContext) : Shapes.empty();
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        Minecraft minecraft = Minecraft.getInstance();
        return (minecraft.player == null || !minecraft.player.isCreative()) ? RenderShape.INVISIBLE : RenderShape.MODEL;
    }

    @Override // com.boehmod.blockfront.InterfaceC0320lw
    public boolean al() {
        return this.dQ;
    }
}
