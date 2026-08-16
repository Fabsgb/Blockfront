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

/* JADX INFO: renamed from: com.boehmod.blockfront.kW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kW.class */
public final class C0593kW extends C0588kR implements InterfaceC0650la, SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final DirectionProperty f3387i;

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final BooleanProperty f3388f;

    /* JADX INFO: renamed from: g */
    @NotNull
    private static final BooleanProperty f3389g;

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final C0717mo f3390e;

    /* JADX INFO: renamed from: dY */
    static final /* synthetic */ boolean f3391dY;

    static {
        f3391dY = !C0593kW.class.desiredAssertionStatus();
        f3387i = BlockStateProperties.HORIZONTAL_FACING;
        f3388f = BlockStateProperties.WATERLOGGED;
        f3389g = C0649lZ.f3656D;
        f3390e = new C0717mo(3.0f, 2.0f, 13.0f, 13.0f, 14.0f, 16.0f);
    }

    public C0593kW(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(f3387i, Direction.NORTH)).setValue(f3388f, Boolean.FALSE)).setValue(f3389g, Boolean.FALSE));
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            if (((Boolean) blockState.getValue(f3389g)).booleanValue()) {
                Minecraft minecraft = Minecraft.getInstance();
                C0623l c0623lM2852b = C0623l.m2852b();
                if (!f3391dY && c0623lM2852b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                C0658li.m2933a(minecraft, c0623lM2852b, clientLevel, blockPos, randomSource);
            }
        }
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3390e.m3266a((Direction) blockState.getValue(f3387i));
    }

    @Override // com.boehmod.blockfront.C0588kR
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{C0649lZ.f3656D});
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    /* JADX INFO: renamed from: a */
    public void mo2615a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        C0658li.m2934a(minecraft, c0623l, clientLevel, blockPos, clientLevel.random, 2, 8);
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    /* JADX INFO: renamed from: au */
    public boolean mo2616au() {
        return false;
    }
}
