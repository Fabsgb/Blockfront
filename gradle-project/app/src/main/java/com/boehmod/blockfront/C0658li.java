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

/* JADX INFO: renamed from: com.boehmod.blockfront.li */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/li.class */
public class C0658li extends CrossCollisionBlock implements InterfaceC0642lS, InterfaceC0650la {

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final BooleanProperty f3668l;

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final MapCodec<C0658li> f3669h;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final VoxelShape[] f3670a;

    /* JADX INFO: renamed from: ea */
    static final /* synthetic */ boolean f3671ea;

    static {
        f3671ea = !C0658li.class.desiredAssertionStatus();
        f3668l = BlockStateProperties.UP;
        f3669h = simpleCodec(C0658li::new);
    }

    public C0658li(@NotNull BlockBehaviour.Properties properties) {
        super(0.0f, 3.0f, 0.0f, 16.0f, 24.0f, properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(f3668l, Boolean.TRUE)).setValue(NORTH, Boolean.FALSE)).setValue(EAST, Boolean.FALSE)).setValue(SOUTH, Boolean.FALSE)).setValue(WEST, Boolean.FALSE)).setValue(WATERLOGGED, Boolean.FALSE)).setValue(C0649lZ.f3656D, Boolean.FALSE));
        this.f3670a = makeShapes(3.0f, 3.0f, 16.0f, 0.0f, 16.0f);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public static void m2933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        m2934a(minecraft, c0623l, clientLevel, blockPos, randomSource, 6, 14);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public static void m2934a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource, int i, int i2) {
        Vec3 vec3Add = new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()).add(0.5d, 0.5d, 0.5d);
        float f = 0.0f;
        if (randomSource.nextInt(2) == 0) {
            f = 1.0f;
            SimpleParticleType simpleParticleType = (SimpleParticleType) C1309xw.f7864nA.get();
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
            clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1312xz.f8160sZ.get(), SoundSource.BLOCKS, 0.2f, 0.8f + (0.4f * randomSource.nextFloat()), false);
        }
        if (randomSource.nextInt(6) == 0) {
            f = 2.0f;
            clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1312xz.f8161ta.get(), SoundSource.BLOCKS, 0.5f, 0.8f + (0.4f * randomSource.nextFloat()), false);
            clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1312xz.f8162tb.get(), SoundSource.BLOCKS, 1.0f, 0.8f + (0.4f * randomSource.nextFloat()), false);
            clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C1312xz.f8160sZ.get(), SoundSource.BLOCKS, 1.0f, 0.8f + (0.4f * randomSource.nextFloat()), false);
            C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) C1309xw.f7858nu.get(), vec3Add.x, vec3Add.y, vec3Add.z, 0.0d, 0.0d, 0.0d);
            SimpleParticleType simpleParticleType2 = (SimpleParticleType) C1309xw.f7865nB.get();
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
            SimpleParticleType simpleParticleType3 = (SimpleParticleType) C1309xw.f7864nA.get();
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
            C0401gq.m1906a(new PointLightData().setOcclusionEnabled(true).setPosition(vec3Add.x, vec3Add.y, vec3Add.z).setBrightness(f).setRadius(32.0f).setColor(-2689793), 1);
            C0401gq.m1906a(new PointLightData().setOcclusionEnabled(true).setPosition(vec3Add.x, vec3Add.y, vec3Add.z).setBrightness(2.0f).setRadius(6.0f).setColor(-1), 1);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m2935a(@NotNull BlockState blockState) {
        return blockState.getBlock() instanceof C0658li;
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            if (((Boolean) blockState.getValue(C0649lZ.f3656D)).booleanValue()) {
                Minecraft minecraft = Minecraft.getInstance();
                C0623l c0623lM2852b = C0623l.m2852b();
                if (!f3671ea && c0623lM2852b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                m2933a(minecraft, c0623lM2852b, clientLevel, blockPos, randomSource);
            }
        }
    }

    @NotNull
    protected MapCodec<? extends CrossCollisionBlock> codec() {
        return f3669h;
    }

    @NotNull
    public VoxelShape getShape(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return ((Boolean) blockState.getValue(f3668l)).booleanValue() ? this.f3670a[getAABBIndex(blockState)] : super.getShape(blockState, blockGetter, blockPos, collisionContext);
    }

    @Override // com.boehmod.blockfront.InterfaceC0642lS
    /* JADX INFO: renamed from: av */
    public boolean mo2909av() {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0642lS
    /* JADX INFO: renamed from: b */
    public boolean mo2910b(BlockState blockState) {
        return ((Boolean) blockState.getValue(f3668l)).booleanValue();
    }

    @NotNull
    public VoxelShape getCollisionShape(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return !((Boolean) blockState.getValue(f3668l)).booleanValue() ? Shapes.empty() : getShape(blockState, blockGetter, blockPos, collisionContext);
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
        boolean zM2935a = m2935a(blockState);
        boolean zM2935a2 = m2935a(blockState2);
        boolean zM2935a3 = m2935a(blockState3);
        boolean zM2935a4 = m2935a(blockState4);
        return (BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) defaultBlockState().setValue(f3668l, Boolean.valueOf(((!zM2935a || zM2935a2 || !zM2935a3 || zM2935a4) && (zM2935a || !zM2935a2 || zM2935a3 || !zM2935a4)) || !level.isEmptyBlock(clickedPos.above())))).setValue(NORTH, Boolean.valueOf(zM2935a))).setValue(EAST, Boolean.valueOf(zM2935a2))).setValue(SOUTH, Boolean.valueOf(zM2935a3))).setValue(WEST, Boolean.valueOf(zM2935a4))).setValue(WATERLOGGED, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, @NotNull Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (((Boolean) blockState.getValue(WATERLOGGED)).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        if (direction == Direction.DOWN) {
            return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
        }
        boolean zM2935a = direction == Direction.NORTH ? m2935a(blockState2) : ((Boolean) blockState.getValue(NORTH)).booleanValue();
        boolean zM2935a2 = direction == Direction.EAST ? m2935a(blockState2) : ((Boolean) blockState.getValue(EAST)).booleanValue();
        boolean zM2935a3 = direction == Direction.SOUTH ? m2935a(blockState2) : ((Boolean) blockState.getValue(SOUTH)).booleanValue();
        boolean zM2935a4 = direction == Direction.WEST ? m2935a(blockState2) : ((Boolean) blockState.getValue(WEST)).booleanValue();
        return (BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) blockState.setValue(f3668l, Boolean.valueOf((!zM2935a || zM2935a2 || !zM2935a3 || zM2935a4) && (zM2935a || !zM2935a2 || zM2935a3 || !zM2935a4)))).setValue(NORTH, Boolean.valueOf(zM2935a))).setValue(EAST, Boolean.valueOf(zM2935a2))).setValue(SOUTH, Boolean.valueOf(zM2935a3))).setValue(WEST, Boolean.valueOf(zM2935a4));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{f3668l, NORTH, EAST, WEST, SOUTH, WATERLOGGED, C0649lZ.f3656D});
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo2615a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        if (Math.random() < 0.699999988079071d) {
            int i2 = 0;
            while (blockState.getBlock() instanceof C0658li) {
                blockPos = blockPos.above();
                blockState = clientLevel.getBlockState(blockPos);
                i2++;
                if (i2 > 5) {
                    break;
                }
            }
            BlockPos blockPosBelow = blockPos.below();
            BlockState blockState2 = clientLevel.getBlockState(blockPosBelow);
            if (blockState2.getBlock() instanceof C0658li) {
                if (((Boolean) blockState2.getValue(NORTH)).booleanValue() || ((Boolean) blockState2.getValue(EAST)).booleanValue() || ((Boolean) blockState2.getValue(SOUTH)).booleanValue() || ((Boolean) blockState2.getValue(WEST)).booleanValue()) {
                    m2933a(minecraft, c0623l, clientLevel, blockPosBelow, clientLevel.getRandom());
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    /* JADX INFO: renamed from: au */
    public boolean mo2616au() {
        return false;
    }
}
