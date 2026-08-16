package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lc.class */
public abstract class AbstractC0652lc extends C0588kR implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final DirectionProperty f3657j;

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final BooleanProperty f3658h;

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final BooleanProperty f3659i;

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final BooleanProperty f3660j;

    /* JADX INFO: renamed from: dZ */
    static final /* synthetic */ boolean f3661dZ;

    static {
        f3661dZ = !AbstractC0652lc.class.desiredAssertionStatus();
        f3657j = BlockStateProperties.HORIZONTAL_FACING;
        f3658h = BlockStateProperties.WATERLOGGED;
        f3659i = BlockStateProperties.LIT;
        f3660j = C0649lZ.f3656D;
    }

    public AbstractC0652lc(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(f3657j, Direction.NORTH)).setValue(f3658h, Boolean.FALSE)).setValue(f3659i, Boolean.TRUE)).setValue(f3660j, Boolean.FALSE));
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            if (((Boolean) blockState.getValue(f3660j)).booleanValue()) {
                Minecraft minecraft = Minecraft.getInstance();
                C0623l c0623lM2852b = C0623l.m2852b();
                if (!f3661dZ && c0623lM2852b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                C0658li.m2933a(minecraft, c0623lM2852b, clientLevel, blockPos, randomSource);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0588kR
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{f3659i, f3660j});
    }
}
