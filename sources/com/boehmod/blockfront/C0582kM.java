package com.boehmod.blockfront;

import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.render.light.data.PointLightData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kM.class */
public class C0582kM extends CrossCollisionBlock implements InterfaceC0574kE, InterfaceC0671lw {

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final BooleanProperty f3256l;

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final MapCodec<C0582kM> f3257h;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final VoxelShape[] f3258a;

    /* JADX INFO: renamed from: dH */
    static final /* synthetic */ boolean f3259dH;

    static {
        f3259dH = !C0582kM.class.desiredAssertionStatus();
        f3256l = BlockStateProperties.UP;
        f3257h = simpleCodec(C0582kM::new);
    }

    public C0582kM(@NotNull BlockBehaviour.Properties properties) {
        super(0.0f, 3.0f, 0.0f, 16.0f, 24.0f, properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(f3256l, Boolean.TRUE)).setValue(NORTH, Boolean.FALSE)).setValue(EAST, Boolean.FALSE)).setValue(SOUTH, Boolean.FALSE)).setValue(WEST, Boolean.FALSE)).setValue(WATERLOGGED, Boolean.FALSE)).setValue(C0626lD.f3402D, Boolean.FALSE));
        this.f3258a = makeShapes(3.0f, 3.0f, 16.0f, 0.0f, 16.0f);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public static void m2605a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        m2606a(minecraft, c0622l, clientLevel, blockPos, randomSource, 6, 14);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public static void m2606a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource, int i, int i2) {
        Vec3 vec3Add = new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()).add(0.5d, 0.5d, 0.5d);
        float f = 0.0f;
        if (randomSource.nextInt(2) == 0) {
            f = 1.0f;
            SimpleParticleType simpleParticleType = (SimpleParticleType) C1232wZ.f7299nA.get();
            for (int i3 = 0; i3 < 6; i3++) {
                float fNextFloat = 0.5f * randomSource.nextFloat();
                float fNextFloat2 = 0.5f * randomSource.nextFloat();
                float fNextFloat3 = 0.5f * randomSource.nextFloat();
                if (randomSource.nextBoolean()) {
                    fNextFloat = -fNextFloat;
                }
                if (randomSource.nextBoolean()) {
                    fNextFloat2 = -fNextFloat2;
                }
                if (randomSource.nextBoolean()) {
                    fNextFloat3 = -fNextFloat3;
                }
                clientLevel.addParticle(simpleParticleType, vec3Add.x + ((double) fNextFloat), vec3Add.y + ((double) fNextFloat2), vec3Add.z + ((double) fNextFloat3), 0.0d, 0.0d, 0.0d);
            }
            clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1280xc.f7749sY.get(), SoundSource.BLOCKS, 0.2f, 0.8f + (0.4f * randomSource.nextFloat()), false);
        }
        if (randomSource.nextInt(6) == 0) {
            f = 2.0f;
            clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1280xc.f7750sZ.get(), SoundSource.BLOCKS, 0.5f, 0.8f + (0.4f * randomSource.nextFloat()), false);
            clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1280xc.f7751ta.get(), SoundSource.BLOCKS, 1.0f, 0.8f + (0.4f * randomSource.nextFloat()), false);
            clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1280xc.f7749sY.get(), SoundSource.BLOCKS, 1.0f, 0.8f + (0.4f * randomSource.nextFloat()), false);
            C0470iG.m2126a(minecraft, c0622l, clientLevel, (SimpleParticleType) C1232wZ.f7293nu.get(), vec3Add.x, vec3Add.y, vec3Add.z, 0.0d, 0.0d, 0.0d);
            SimpleParticleType simpleParticleType2 = (SimpleParticleType) C1232wZ.f7300nB.get();
            for (int i4 = 0; i4 < 16; i4++) {
                float fNextFloat4 = 0.5f * randomSource.nextFloat();
                float fNextFloat5 = 0.5f * randomSource.nextFloat();
                float fNextFloat6 = 0.5f * randomSource.nextFloat();
                if (randomSource.nextBoolean()) {
                    fNextFloat4 = -fNextFloat4;
                }
                if (randomSource.nextBoolean()) {
                    fNextFloat5 = -fNextFloat5;
                }
                if (randomSource.nextBoolean()) {
                    fNextFloat6 = -fNextFloat6;
                }
                clientLevel.addParticle(simpleParticleType2, vec3Add.x + ((double) fNextFloat4), vec3Add.y + ((double) fNextFloat5), vec3Add.z + ((double) fNextFloat6), 0.0d, 0.0d, 0.0d);
            }
            SimpleParticleType simpleParticleType3 = (SimpleParticleType) C1232wZ.f7299nA.get();
            for (int i5 = 0; i5 < 6; i5++) {
                float fNextFloat7 = 0.5f * randomSource.nextFloat();
                float fNextFloat8 = 0.5f * randomSource.nextFloat();
                float fNextFloat9 = 0.5f * randomSource.nextFloat();
                if (randomSource.nextBoolean()) {
                    fNextFloat7 = -fNextFloat7;
                }
                if (randomSource.nextBoolean()) {
                    fNextFloat8 = -fNextFloat8;
                }
                if (randomSource.nextBoolean()) {
                    fNextFloat9 = -fNextFloat9;
                }
                clientLevel.addParticle(simpleParticleType3, vec3Add.x + ((double) fNextFloat7), vec3Add.y + ((double) fNextFloat8), vec3Add.z + ((double) fNextFloat9), 0.0d, 0.0d, 0.0d);
            }
        }
        if (f > 0.0f) {
            C0384ga.m1842a(new PointLightData().setOcclusionEnabled(true).setPosition(vec3Add.x, vec3Add.y, vec3Add.z).setBrightness(f).setRadius(32.0f).setColor(-2689793), 1);
            C0384ga.m1842a(new PointLightData().setOcclusionEnabled(true).setPosition(vec3Add.x, vec3Add.y, vec3Add.z).setBrightness(2.0f).setRadius(6.0f).setColor(-1), 1);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m2607a(@NotNull BlockState blockState) {
        return blockState.getBlock() instanceof C0582kM;
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            if (((Boolean) blockState.getValue(C0626lD.f3402D)).booleanValue()) {
                Minecraft minecraft = Minecraft.getInstance();
                C0622l c0622lM2667b = C0622l.m2667b();
                if (!f3259dH && c0622lM2667b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                m2605a(minecraft, c0622lM2667b, clientLevel, blockPos, randomSource);
            }
        }
    }

    @NotNull
    protected MapCodec<? extends CrossCollisionBlock> codec() {
        return f3257h;
    }

    @NotNull
    public VoxelShape getShape(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return ((Boolean) blockState.getValue(f3256l)).booleanValue() ? this.f3258a[getAABBIndex(blockState)] : super.getShape(blockState, blockGetter, blockPos, collisionContext);
    }

    @Override // com.boehmod.blockfront.InterfaceC0671lw
    /* JADX INFO: renamed from: al */
    public boolean mo2608al() {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0671lw
    /* JADX INFO: renamed from: b */
    public boolean mo2609b(BlockState blockState) {
        return ((Boolean) blockState.getValue(f3256l)).booleanValue();
    }

    @NotNull
    public VoxelShape getCollisionShape(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return !((Boolean) blockState.getValue(f3256l)).booleanValue() ? Shapes.empty() : getShape(blockState, blockGetter, blockPos, collisionContext);
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockPos clickedPos = blockPlaceContext.getClickedPos();
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        BlockPos blockPosNorth = clickedPos.north();
        BlockPos blockPosEast = clickedPos.east();
        BlockPos blockPosSouth = clickedPos.south();
        BlockPos blockPosWest = clickedPos.west();
        BlockState blockState = level.getBlockState(blockPosNorth);
        BlockState blockState2 = level.getBlockState(blockPosEast);
        BlockState blockState3 = level.getBlockState(blockPosSouth);
        BlockState blockState4 = level.getBlockState(blockPosWest);
        boolean zM2607a = m2607a(blockState);
        boolean zM2607a2 = m2607a(blockState2);
        boolean zM2607a3 = m2607a(blockState3);
        boolean zM2607a4 = m2607a(blockState4);
        return (BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) defaultBlockState().setValue(f3256l, Boolean.valueOf(((!zM2607a || zM2607a2 || !zM2607a3 || zM2607a4) && (zM2607a || !zM2607a2 || zM2607a3 || !zM2607a4)) || !level.isEmptyBlock(clickedPos.above())))).setValue(NORTH, Boolean.valueOf(zM2607a))).setValue(EAST, Boolean.valueOf(zM2607a2))).setValue(SOUTH, Boolean.valueOf(zM2607a3))).setValue(WEST, Boolean.valueOf(zM2607a4))).setValue(WATERLOGGED, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, @NotNull Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (((Boolean) blockState.getValue(WATERLOGGED)).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        if (direction == Direction.DOWN) {
            return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
        }
        boolean zM2607a = direction == Direction.NORTH ? m2607a(blockState2) : ((Boolean) blockState.getValue(NORTH)).booleanValue();
        boolean zM2607a2 = direction == Direction.EAST ? m2607a(blockState2) : ((Boolean) blockState.getValue(EAST)).booleanValue();
        boolean zM2607a3 = direction == Direction.SOUTH ? m2607a(blockState2) : ((Boolean) blockState.getValue(SOUTH)).booleanValue();
        boolean zM2607a4 = direction == Direction.WEST ? m2607a(blockState2) : ((Boolean) blockState.getValue(WEST)).booleanValue();
        return (BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) blockState.setValue(f3256l, Boolean.valueOf((!zM2607a || zM2607a2 || !zM2607a3 || zM2607a4) && (zM2607a || !zM2607a2 || zM2607a3 || !zM2607a4)))).setValue(NORTH, Boolean.valueOf(zM2607a))).setValue(EAST, Boolean.valueOf(zM2607a2))).setValue(SOUTH, Boolean.valueOf(zM2607a3))).setValue(WEST, Boolean.valueOf(zM2607a4));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{f3256l, NORTH, EAST, WEST, SOUTH, WATERLOGGED, C0626lD.f3402D});
    }

    @Override // com.boehmod.blockfront.InterfaceC0574kE
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo2601a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        if (Math.random() < 0.699999988079071d) {
            int i2 = 0;
            while (blockState.getBlock() instanceof C0582kM) {
                blockPos = blockPos.above();
                blockState = clientLevel.getBlockState(blockPos);
                i2++;
                if (i2 > 5) {
                    break;
                }
            }
            BlockPos blockPosBelow = blockPos.below();
            BlockState blockState2 = clientLevel.getBlockState(blockPosBelow);
            if (blockState2.getBlock() instanceof C0582kM) {
                if (((Boolean) blockState2.getValue(NORTH)).booleanValue() || ((Boolean) blockState2.getValue(EAST)).booleanValue() || ((Boolean) blockState2.getValue(SOUTH)).booleanValue() || ((Boolean) blockState2.getValue(WEST)).booleanValue()) {
                    m2605a(minecraft, c0622l, clientLevel, blockPosBelow, clientLevel.getRandom());
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0574kE
    /* JADX INFO: renamed from: ak */
    public boolean mo2602ak() {
        return false;
    }
}
