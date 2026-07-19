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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kG.class */
public abstract class kG extends C0292kv implements SimpleWaterloggedBlock {

    @NotNull
    private static final DirectionProperty j;

    @NotNull
    private static final BooleanProperty h;

    @NotNull
    private static final BooleanProperty i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    @NotNull
    private static final BooleanProperty f194j;
    static final /* synthetic */ boolean dG;

    static {
        dG = !kG.class.desiredAssertionStatus();
        j = BlockStateProperties.HORIZONTAL_FACING;
        h = BlockStateProperties.WATERLOGGED;
        i = BlockStateProperties.LIT;
        f194j = lD.D;
    }

    public kG(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(j, Direction.NORTH)).setValue(h, Boolean.FALSE)).setValue(i, Boolean.TRUE)).setValue(f194j, Boolean.FALSE));
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            if (((Boolean) blockState.getValue(f194j)).booleanValue()) {
                Minecraft minecraft = Minecraft.getInstance();
                C0297l c0297lB = C0297l.b();
                if (!dG && c0297lB == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                kM.a(minecraft, c0297lB, clientLevel, blockPos, randomSource);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0292kv
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{i, f194j});
    }
}
