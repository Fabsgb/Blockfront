package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.StairBlock;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.lX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lX.class */
public class C0647lX extends StairBlock implements InterfaceC0642lS {

    /* JADX INFO: renamed from: eh */
    private final boolean f3646eh;

    /* JADX INFO: renamed from: ei */
    private final boolean f3647ei;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final InterfaceC0643lT f3648c;

    public C0647lX(BlockState blockState, boolean z, boolean z2, @NotNull InterfaceC0643lT interfaceC0643lT) {
        super(blockState, BlockBehaviour.Properties.of().strength(-1.0f, 3600000.0f).noOcclusion().noLootTable().noTerrainParticles().isSuffocating((blockState2, blockGetter, blockPos) -> {
            return false;
        }).isRedstoneConductor((blockState3, blockGetter2, blockPos2) -> {
            return false;
        }).isValidSpawn((blockState4, blockGetter3, blockPos3, entityType) -> {
            return false;
        }));
        this.f3646eh = z;
        this.f3647ei = z2;
        this.f3648c = interfaceC0643lT;
    }

    /* JADX INFO: renamed from: d */
    public boolean m2923d(@Nullable Entity entity) {
        return this.f3648c.shouldBlockCollision(entity);
    }

    protected boolean isPathfindable(@NotNull BlockState blockState, @NotNull PathComputationType pathComputationType) {
        return this.f3647ei;
    }

    public float getShadeBrightness(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return 1.0f;
    }

    public boolean propagatesSkylightDown(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return true;
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return ((collisionContext instanceof EntityCollisionContext) && m2923d(((EntityCollisionContext) collisionContext).getEntity())) ? Shapes.empty() : super.getShape(blockState, blockGetter, blockPos, collisionContext);
    }

    @NotNull
    public VoxelShape getCollisionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return (!(collisionContext instanceof EntityCollisionContext) || m2923d(((EntityCollisionContext) collisionContext).getEntity())) ? super.getShape(blockState, blockGetter, blockPos, collisionContext) : Shapes.empty();
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        Minecraft minecraft = Minecraft.getInstance();
        return (minecraft.player == null || !minecraft.player.isCreative()) ? RenderShape.INVISIBLE : RenderShape.MODEL;
    }

    @Override // com.boehmod.blockfront.InterfaceC0642lS
    /* JADX INFO: renamed from: av */
    public boolean mo2909av() {
        return this.f3646eh;
    }
}
