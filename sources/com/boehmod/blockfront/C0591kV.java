package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kV.class */
public class C0591kV extends C0662ln {

    /* JADX INFO: renamed from: dJ */
    static final /* synthetic */ boolean f3286dJ;

    static {
        f3286dJ = !C0591kV.class.desiredAssertionStatus();
    }

    public C0591kV(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) this.stateDefinition.any().setValue(C0626lD.f3402D, Boolean.FALSE));
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            super.animateTick(blockState, level, blockPos, randomSource);
            if (((Boolean) blockState.getValue(C0626lD.f3402D)).booleanValue()) {
                Minecraft minecraft = Minecraft.getInstance();
                C0622l c0622lM2667b = C0622l.m2667b();
                if (!f3286dJ && c0622lM2667b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                C0582kM.m2605a(minecraft, c0622lM2667b, clientLevel, blockPos, randomSource);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0617kv
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{C0626lD.f3402D});
    }

    @Override // com.boehmod.blockfront.C0617kv
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) super.getStateForPlacement(blockPlaceContext).setValue(C0626lD.f3402D, Boolean.FALSE);
    }
}
