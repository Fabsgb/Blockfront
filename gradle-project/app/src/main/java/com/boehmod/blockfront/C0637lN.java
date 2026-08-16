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

/* JADX INFO: renamed from: com.boehmod.blockfront.lN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lN.class */
public class C0637lN extends C0588kR implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: D */
    @NotNull
    private static final DirectionProperty f3624D = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: v */
    @NotNull
    private static final C0717mo f3625v = new C0717mo(6.0f, 8.0f, 15.0f, 10.0f, 18.0f, 16.0f);

    public C0637lN(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3625v.m3266a((Direction) blockState.getValue(f3624D));
    }
}
