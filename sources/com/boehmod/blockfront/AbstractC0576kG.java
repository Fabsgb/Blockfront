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

/* JADX INFO: renamed from: com.boehmod.blockfront.kG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kG.class */
public abstract class AbstractC0576kG extends C0617kv implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final DirectionProperty f3245j;

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final BooleanProperty f3246h;

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final BooleanProperty f3247i;

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final BooleanProperty f3248j;

    /* JADX INFO: renamed from: dG */
    static final /* synthetic */ boolean f3249dG;

    static {
        f3249dG = !AbstractC0576kG.class.desiredAssertionStatus();
        f3245j = BlockStateProperties.HORIZONTAL_FACING;
        f3246h = BlockStateProperties.WATERLOGGED;
        f3247i = BlockStateProperties.LIT;
        f3248j = C0626lD.f3402D;
    }

    public AbstractC0576kG(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(f3245j, Direction.NORTH)).setValue(f3246h, Boolean.FALSE)).setValue(f3247i, Boolean.TRUE)).setValue(f3248j, Boolean.FALSE));
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            if (((Boolean) blockState.getValue(f3248j)).booleanValue()) {
                Minecraft minecraft = Minecraft.getInstance();
                C0622l c0622lM2667b = C0622l.m2667b();
                if (!f3249dG && c0622lM2667b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                C0582kM.m2605a(minecraft, c0622lM2667b, clientLevel, blockPos, randomSource);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0617kv
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{f3247i, f3248j});
    }
}
