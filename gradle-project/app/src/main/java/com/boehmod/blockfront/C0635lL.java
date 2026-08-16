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

/* JADX INFO: renamed from: com.boehmod.blockfront.lL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lL.class */
public class C0635lL extends AbstractC0652lc {

    /* JADX INFO: renamed from: t */
    @NotNull
    private static final C0717mo f3619t = new C0717mo(5.0f, 0.0f, 14.0f, 11.0f, 8.0f, 16.0f);

    /* JADX INFO: renamed from: B */
    @NotNull
    private static final DirectionProperty f3620B = BlockStateProperties.HORIZONTAL_FACING;

    public C0635lL(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3619t.m3266a((Direction) blockState.getValue(f3620B));
    }
}
