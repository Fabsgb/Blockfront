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

/* JADX INFO: renamed from: com.boehmod.blockfront.kA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kA.class */
public final class C0570kA extends C0617kv implements InterfaceC0574kE, SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final DirectionProperty f3239i;

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final BooleanProperty f3240f;

    /* JADX INFO: renamed from: g */
    @NotNull
    private static final BooleanProperty f3241g;

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final C0641lS f3242e;

    /* JADX INFO: renamed from: dF */
    static final /* synthetic */ boolean f3243dF;

    static {
        f3243dF = !C0570kA.class.desiredAssertionStatus();
        f3239i = BlockStateProperties.HORIZONTAL_FACING;
        f3240f = BlockStateProperties.WATERLOGGED;
        f3241g = C0626lD.f3402D;
        f3242e = new C0641lS(3.0f, 2.0f, 13.0f, 13.0f, 14.0f, 16.0f);
    }

    public C0570kA(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(f3239i, Direction.NORTH)).setValue(f3240f, Boolean.FALSE)).setValue(f3241g, Boolean.FALSE));
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            if (((Boolean) blockState.getValue(f3241g)).booleanValue()) {
                Minecraft minecraft = Minecraft.getInstance();
                C0622l c0622lM2667b = C0622l.m2667b();
                if (!f3243dF && c0622lM2667b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                C0582kM.m2605a(minecraft, c0622lM2667b, clientLevel, blockPos, randomSource);
            }
        }
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3242e.m2835a((Direction) blockState.getValue(f3239i));
    }

    @Override // com.boehmod.blockfront.C0617kv
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{C0626lD.f3402D});
    }

    @Override // com.boehmod.blockfront.InterfaceC0574kE
    /* JADX INFO: renamed from: a */
    public void mo2601a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        C0582kM.m2606a(minecraft, c0622l, clientLevel, blockPos, clientLevel.random, 2, 8);
    }

    @Override // com.boehmod.blockfront.InterfaceC0574kE
    /* JADX INFO: renamed from: ak */
    public boolean mo2602ak() {
        return false;
    }
}
