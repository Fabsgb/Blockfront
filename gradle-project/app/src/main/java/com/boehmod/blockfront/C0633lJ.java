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

/* JADX INFO: renamed from: com.boehmod.blockfront.lJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lJ.class */
public class C0633lJ extends C0588kR implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: z */
    @NotNull
    private static final DirectionProperty f3615z = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: r */
    @NotNull
    private static final C0717mo f3616r = new C0717mo(0.0f, 0.0f, 14.0f, 16.0f, 16.0f, 16.0f);

    public C0633lJ(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3616r.m3266a((Direction) blockState.getValue(f3615z));
    }
}
