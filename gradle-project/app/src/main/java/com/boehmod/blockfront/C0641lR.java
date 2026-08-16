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

/* JADX INFO: renamed from: com.boehmod.blockfront.lR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lR.class */
public class C0641lR extends C0588kR {

    /* JADX INFO: renamed from: G */
    @NotNull
    private static final DirectionProperty f3632G = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: y */
    @NotNull
    private static final C0717mo f3633y = new C0717mo(0.0f, 0.0f, 15.0f, 16.0f, 16.0f, 16.0f);

    public C0641lR(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3633y.m3266a((Direction) blockState.getValue(f3632G));
    }
}
