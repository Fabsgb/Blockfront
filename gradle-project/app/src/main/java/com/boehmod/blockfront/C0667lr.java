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

/* JADX INFO: renamed from: com.boehmod.blockfront.lr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lr.class */
public class C0667lr extends C0633lJ {

    /* JADX INFO: renamed from: ec */
    static final /* synthetic */ boolean f3698ec;

    static {
        f3698ec = !C0667lr.class.desiredAssertionStatus();
    }

    public C0667lr(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) this.stateDefinition.any().setValue(C0649lZ.f3656D, Boolean.FALSE));
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            super.animateTick(blockState, level, blockPos, randomSource);
            if (((Boolean) blockState.getValue(C0649lZ.f3656D)).booleanValue()) {
                Minecraft minecraft = Minecraft.getInstance();
                C0623l c0623lM2852b = C0623l.m2852b();
                if (!f3698ec && c0623lM2852b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                C0658li.m2933a(minecraft, c0623lM2852b, clientLevel, blockPos, randomSource);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0588kR
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{C0649lZ.f3656D});
    }

    @Override // com.boehmod.blockfront.C0588kR
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState) super.getStateForPlacement(blockPlaceContext).setValue(C0649lZ.f3656D, Boolean.FALSE);
    }
}
