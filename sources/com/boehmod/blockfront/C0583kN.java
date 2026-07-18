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

/* JADX INFO: renamed from: com.boehmod.blockfront.kN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kN.class */
public class C0583kN extends C0617kv implements InterfaceC0574kE, SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final DirectionProperty f3260l;

    /* JADX INFO: renamed from: m */
    @NotNull
    private static final BooleanProperty f3261m;

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final C0641lS f3262f;

    /* JADX INFO: renamed from: dI */
    static final /* synthetic */ boolean f3263dI;

    static {
        f3263dI = !C0583kN.class.desiredAssertionStatus();
        f3260l = BlockStateProperties.HORIZONTAL_FACING;
        f3261m = BlockStateProperties.WATERLOGGED;
        f3262f = new C0641lS(6.5f, 0.0f, 15.0f, 9.5f, 16.0f, 16.0f);
    }

    public C0583kN(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(f3260l, Direction.NORTH)).setValue(f3261m, Boolean.FALSE)).setValue(C0626lD.f3402D, Boolean.FALSE));
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            if (((Boolean) blockState.getValue(C0626lD.f3402D)).booleanValue()) {
                Minecraft minecraft = Minecraft.getInstance();
                C0622l c0622lM2667b = C0622l.m2667b();
                if (!f3263dI && c0622lM2667b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                C0582kM.m2605a(minecraft, c0622lM2667b, clientLevel, blockPos, randomSource);
            }
        }
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3262f.m2835a((Direction) blockState.getValue(f3260l));
    }

    @Override // com.boehmod.blockfront.InterfaceC0574kE
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo2601a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        if (Math.random() < 0.20000000298023224d) {
            C0582kM.m2605a(minecraft, c0622l, clientLevel, blockPos, clientLevel.getRandom());
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0574kE
    /* JADX INFO: renamed from: ak */
    public boolean mo2602ak() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0617kv
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{C0626lD.f3402D});
    }
}
