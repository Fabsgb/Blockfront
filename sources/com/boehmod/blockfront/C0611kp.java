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

/* JADX INFO: renamed from: com.boehmod.blockfront.kp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kp.class */
public class C0611kp extends AbstractC0576kG {

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final C0641lS f3330b = new C0641lS(0.0f, 0.0f, 14.0f, 16.0f, 16.0f, 16.0f);

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final DirectionProperty f3331b = BlockStateProperties.HORIZONTAL_FACING;

    public C0611kp(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3330b.m2835a((Direction) blockState.getValue(f3331b));
    }
}
