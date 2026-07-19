package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kp.class */
public class C0286kp extends kG {

    @NotNull
    private static final lS b = new lS(0.0f, 0.0f, 14.0f, 16.0f, 16.0f, 16.0f);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    private static final DirectionProperty f200b = BlockStateProperties.HORIZONTAL_FACING;

    public C0286kp(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return b.a((Direction) blockState.getValue(f200b));
    }
}
