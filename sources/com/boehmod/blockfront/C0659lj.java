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

/* JADX INFO: renamed from: com.boehmod.blockfront.lj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lj.class */
public class C0659lj extends C0588kR implements InterfaceC0650la, SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final DirectionProperty f3672l;

    /* JADX INFO: renamed from: m */
    @NotNull
    private static final BooleanProperty f3673m;

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final C0717mo f3674f;

    /* JADX INFO: renamed from: eb */
    static final /* synthetic */ boolean f3675eb;

    static {
        f3675eb = !C0659lj.class.desiredAssertionStatus();
        f3672l = BlockStateProperties.HORIZONTAL_FACING;
        f3673m = BlockStateProperties.WATERLOGGED;
        f3674f = new C0717mo(6.5f, 0.0f, 15.0f, 9.5f, 16.0f, 16.0f);
    }

    public C0659lj(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(f3672l, Direction.NORTH)).setValue(f3673m, Boolean.FALSE)).setValue(C0649lZ.f3656D, Boolean.FALSE));
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            if (((Boolean) blockState.getValue(C0649lZ.f3656D)).booleanValue()) {
                Minecraft minecraft = Minecraft.getInstance();
                C0623l c0623lM2852b = C0623l.m2852b();
                if (!f3675eb && c0623lM2852b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                C0658li.m2933a(minecraft, c0623lM2852b, clientLevel, blockPos, randomSource);
            }
        }
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3674f.m3266a((Direction) blockState.getValue(f3672l));
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo2615a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        if (Math.random() < 0.20000000298023224d) {
            C0658li.m2933a(minecraft, c0623l, clientLevel, blockPos, clientLevel.getRandom());
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    /* JADX INFO: renamed from: au */
    public boolean mo2616au() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0588kR
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{C0649lZ.f3656D});
    }
}
