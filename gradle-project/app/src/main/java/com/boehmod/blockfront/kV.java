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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kV.class */
public class kV extends C0311ln {
    static final /* synthetic */ boolean dJ;

    static {
        dJ = !kV.class.desiredAssertionStatus();
    }

    public kV(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) this.stateDefinition.any().setValue(lD.D, Boolean.FALSE));
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            super.animateTick(blockState, level, blockPos, randomSource);
            if (((Boolean) blockState.getValue(lD.D)).booleanValue()) {
                Minecraft minecraft = Minecraft.getInstance();
                C0297l c0297lB = C0297l.b();
                if (!dJ && c0297lB == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                kM.a(minecraft, c0297lB, clientLevel, blockPos, randomSource);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0292kv
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{lD.D});
    }

    @Override // com.boehmod.blockfront.C0292kv
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) super.getStateForPlacement(blockPlaceContext).setValue(lD.D, Boolean.FALSE);
    }
}
