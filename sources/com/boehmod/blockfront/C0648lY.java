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

/* JADX INFO: renamed from: com.boehmod.blockfront.lY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lY.class */
public class C0648lY extends WallBlock implements InterfaceC0642lS {

    /* JADX INFO: renamed from: ej */
    private final boolean f3649ej;

    /* JADX INFO: renamed from: ek */
    private final boolean f3650ek;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final InterfaceC0643lT f3651d;

    public C0648lY(boolean z, boolean z2, @NotNull InterfaceC0643lT interfaceC0643lT) {
        super(BlockBehaviour.Properties.of().strength(-1.0f, 3600000.0f).noOcclusion().noLootTable().noTerrainParticles().isSuffocating((blockState, blockGetter, blockPos) -> {
            return false;
        }).isRedstoneConductor((blockState2, blockGetter2, blockPos2) -> {
            return false;
        }).isValidSpawn((blockState3, blockGetter3, blockPos3, entityType) -> {
            return false;
        }));
        this.f3649ej = z;
        this.f3650ek = z2;
        this.f3651d = interfaceC0643lT;
    }

    /* JADX INFO: renamed from: d */
    public boolean m2927d(@Nullable Entity entity) {
        return this.f3651d.shouldBlockCollision(entity);
    }

    protected boolean isPathfindable(@NotNull BlockState blockState, @NotNull PathComputationType pathComputationType) {
        return this.f3650ek;
    }

    public float getShadeBrightness(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return 1.0f;
    }

    public boolean propagatesSkylightDown(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return true;
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return ((collisionContext instanceof EntityCollisionContext) && m2927d(((EntityCollisionContext) collisionContext).getEntity())) ? Shapes.empty() : super.getShape(blockState, blockGetter, blockPos, collisionContext);
    }

    @NotNull
    public VoxelShape getCollisionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return (!(collisionContext instanceof EntityCollisionContext) || m2927d(((EntityCollisionContext) collisionContext).getEntity())) ? super.getShape(blockState, blockGetter, blockPos, collisionContext) : Shapes.empty();
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
        return this.f3649ej;
    }
}
