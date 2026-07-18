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

/* JADX INFO: renamed from: com.boehmod.blockfront.lr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lr.class */
public class C0666lr extends C0617kv implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: D */
    @NotNull
    private static final DirectionProperty f3583D = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: v */
    @NotNull
    private static final C0641lS f3584v = new C0641lS(6.0f, 8.0f, 15.0f, 10.0f, 18.0f, 16.0f);

    public C0666lr(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3584v.m2835a((Direction) blockState.getValue(f3583D));
    }
}
