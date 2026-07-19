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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kM.class */
public class kM extends CrossCollisionBlock implements kE, InterfaceC0320lw {

    @NotNull
    private static final BooleanProperty l;

    @NotNull
    private static final MapCodec<kM> h;

    @NotNull
    private final VoxelShape[] a;
    static final /* synthetic */ boolean dH;

    static {
        dH = !kM.class.desiredAssertionStatus();
        l = BlockStateProperties.UP;
        h = simpleCodec(kM::new);
    }

    public kM(@NotNull BlockBehaviour.Properties properties) {
        super(0.0f, 3.0f, 0.0f, 16.0f, 24.0f, properties);
        registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) getStateDefinition().any().setValue(l, Boolean.TRUE)).setValue(NORTH, Boolean.FALSE)).setValue(EAST, Boolean.FALSE)).setValue(SOUTH, Boolean.FALSE)).setValue(WEST, Boolean.FALSE)).setValue(WATERLOGGED, Boolean.FALSE)).setValue(lD.D, Boolean.FALSE));
        this.a = makeShapes(3.0f, 3.0f, 16.0f, 0.0f, 16.0f);
    }

    @OnlyIn(Dist.CLIENT)
    public static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        a(minecraft, c0297l, clientLevel, blockPos, randomSource, 6, 14);
    }

    @OnlyIn(Dist.CLIENT)
    public static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource, int i, int i2) {
        Vec3 vec3Add = new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()).add(0.5d, 0.5d, 0.5d);
        float f = 0.0f;
        if (randomSource.nextInt(2) == 0) {
            f = 1.0f;
            SimpleParticleType simpleParticleType = (SimpleParticleType) wZ.nA.get();
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
            clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C0624xc.sY.get(), SoundSource.BLOCKS, 0.2f, 0.8f + (0.4f * randomSource.nextFloat()), false);
        }
        if (randomSource.nextInt(6) == 0) {
            f = 2.0f;
            clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C0624xc.sZ.get(), SoundSource.BLOCKS, 0.5f, 0.8f + (0.4f * randomSource.nextFloat()), false);
            clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C0624xc.ta.get(), SoundSource.BLOCKS, 1.0f, 0.8f + (0.4f * randomSource.nextFloat()), false);
            clientLevel.playLocalSound(vec3Add.x, vec3Add.y, vec3Add.z, (SoundEvent) C0624xc.sY.get(), SoundSource.BLOCKS, 1.0f, 0.8f + (0.4f * randomSource.nextFloat()), false);
            iG.a(minecraft, c0297l, clientLevel, (SimpleParticleType) wZ.nu.get(), vec3Add.x, vec3Add.y, vec3Add.z, 0.0d, 0.0d, 0.0d);
            SimpleParticleType simpleParticleType2 = (SimpleParticleType) wZ.nB.get();
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
            SimpleParticleType simpleParticleType3 = (SimpleParticleType) wZ.nA.get();
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
            C0164ga.a(new PointLightData().setOcclusionEnabled(true).setPosition(vec3Add.x, vec3Add.y, vec3Add.z).setBrightness(f).setRadius(32.0f).setColor(-2689793), 1);
            C0164ga.a(new PointLightData().setOcclusionEnabled(true).setPosition(vec3Add.x, vec3Add.y, vec3Add.z).setBrightness(2.0f).setRadius(6.0f).setColor(-1), 1);
        }
    }

    private boolean a(@NotNull BlockState blockState) {
        return blockState.getBlock() instanceof kM;
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            if (((Boolean) blockState.getValue(lD.D)).booleanValue()) {
                Minecraft minecraft = Minecraft.getInstance();
                C0297l c0297lB = C0297l.b();
                if (!dH && c0297lB == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                a(minecraft, c0297lB, clientLevel, blockPos, randomSource);
            }
        }
    }

    @NotNull
    protected MapCodec<? extends CrossCollisionBlock> codec() {
        return h;
    }

    @NotNull
    public VoxelShape getShape(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return ((Boolean) blockState.getValue(l)).booleanValue() ? this.a[getAABBIndex(blockState)] : super.getShape(blockState, blockGetter, blockPos, collisionContext);
    }

    @Override // com.boehmod.blockfront.InterfaceC0320lw
    public boolean al() {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0320lw
    public boolean b(BlockState blockState) {
        return ((Boolean) blockState.getValue(l)).booleanValue();
    }

    @NotNull
    public VoxelShape getCollisionShape(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return !((Boolean) blockState.getValue(l)).booleanValue() ? Shapes.empty() : getShape(blockState, blockGetter, blockPos, collisionContext);
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
        boolean zA = a(blockState);
        boolean zA2 = a(blockState2);
        boolean zA3 = a(blockState3);
        boolean zA4 = a(blockState4);
        return (BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) defaultBlockState().setValue(l, Boolean.valueOf(((!zA || zA2 || !zA3 || zA4) && (zA || !zA2 || zA3 || !zA4)) || !level.isEmptyBlock(clickedPos.above())))).setValue(NORTH, Boolean.valueOf(zA))).setValue(EAST, Boolean.valueOf(zA2))).setValue(SOUTH, Boolean.valueOf(zA3))).setValue(WEST, Boolean.valueOf(zA4))).setValue(WATERLOGGED, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
    }

    @NotNull
    public BlockState updateShape(BlockState blockState, @NotNull Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (((Boolean) blockState.getValue(WATERLOGGED)).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        if (direction == Direction.DOWN) {
            return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
        }
        boolean zA = direction == Direction.NORTH ? a(blockState2) : ((Boolean) blockState.getValue(NORTH)).booleanValue();
        boolean zA2 = direction == Direction.EAST ? a(blockState2) : ((Boolean) blockState.getValue(EAST)).booleanValue();
        boolean zA3 = direction == Direction.SOUTH ? a(blockState2) : ((Boolean) blockState.getValue(SOUTH)).booleanValue();
        boolean zA4 = direction == Direction.WEST ? a(blockState2) : ((Boolean) blockState.getValue(WEST)).booleanValue();
        return (BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) blockState.setValue(l, Boolean.valueOf((!zA || zA2 || !zA3 || zA4) && (zA || !zA2 || zA3 || !zA4)))).setValue(NORTH, Boolean.valueOf(zA))).setValue(EAST, Boolean.valueOf(zA2))).setValue(SOUTH, Boolean.valueOf(zA3))).setValue(WEST, Boolean.valueOf(zA4));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{l, NORTH, EAST, WEST, SOUTH, WATERLOGGED, lD.D});
    }

    @Override // com.boehmod.blockfront.kE
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        if (Math.random() < 0.699999988079071d) {
            int i2 = 0;
            while (blockState.getBlock() instanceof kM) {
                blockPos = blockPos.above();
                blockState = clientLevel.getBlockState(blockPos);
                i2++;
                if (i2 > 5) {
                    break;
                }
            }
            BlockPos blockPosBelow = blockPos.below();
            BlockState blockState2 = clientLevel.getBlockState(blockPosBelow);
            if (blockState2.getBlock() instanceof kM) {
                if (((Boolean) blockState2.getValue(NORTH)).booleanValue() || ((Boolean) blockState2.getValue(EAST)).booleanValue() || ((Boolean) blockState2.getValue(SOUTH)).booleanValue() || ((Boolean) blockState2.getValue(WEST)).booleanValue()) {
                    a(minecraft, c0297l, clientLevel, blockPosBelow, clientLevel.getRandom());
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.kE
    public boolean ak() {
        return false;
    }
}
