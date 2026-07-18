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

/* JADX INFO: renamed from: com.boehmod.blockfront.lv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lv.class */
public class C0670lv extends C0617kv {

    /* JADX INFO: renamed from: G */
    @NotNull
    private static final DirectionProperty f3591G = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: y */
    @NotNull
    private static final C0641lS f3592y = new C0641lS(0.0f, 0.0f, 15.0f, 16.0f, 16.0f, 16.0f);

    public C0670lv(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3592y.m2835a((Direction) blockState.getValue(f3591G));
    }
}
