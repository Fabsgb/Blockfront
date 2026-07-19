package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
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
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kN.class */
public class kN extends C0292kv implements kE, SimpleWaterloggedBlock {

    @NotNull
    private static final DirectionProperty l;

    @NotNull
    private static final BooleanProperty m;

    @NotNull
    private static final lS f;
    static final /* synthetic */ boolean dI;

    static {
        dI = !kN.class.desiredAssertionStatus();
        l = BlockStateProperties.HORIZONTAL_FACING;
        m = BlockStateProperties.WATERLOGGED;
        f = new lS(6.5f, 0.0f, 15.0f, 9.5f, 16.0f, 16.0f);
    }

    public kN(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(l, Direction.NORTH)).setValue(m, Boolean.FALSE)).setValue(lD.D, Boolean.FALSE));
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            if (((Boolean) blockState.getValue(lD.D)).booleanValue()) {
                Minecraft minecraft = Minecraft.getInstance();
                C0297l c0297lB = C0297l.b();
                if (!dI && c0297lB == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                kM.a(minecraft, c0297lB, clientLevel, blockPos, randomSource);
            }
        }
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f.a((Direction) blockState.getValue(l));
    }

    @Override // com.boehmod.blockfront.kE
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        if (Math.random() < 0.20000000298023224d) {
            kM.a(minecraft, c0297l, clientLevel, blockPos, clientLevel.getRandom());
        }
    }

    @Override // com.boehmod.blockfront.kE
    public boolean ak() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0292kv
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{lD.D});
    }
}
