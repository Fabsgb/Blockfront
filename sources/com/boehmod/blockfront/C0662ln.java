package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ln */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ln.class */
public class C0662ln extends C0617kv implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: z */
    @NotNull
    private static final DirectionProperty f3574z = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: r */
    @NotNull
    private static final C0641lS f3575r = new C0641lS(0.0f, 0.0f, 14.0f, 16.0f, 16.0f, 16.0f);

    public C0662ln(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3575r.m2835a((Direction) blockState.getValue(f3574z));
    }
}
