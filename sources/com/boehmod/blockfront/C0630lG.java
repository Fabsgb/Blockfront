package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lG.class */
public final class C0630lG extends C0588kR implements InterfaceC0650la, SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: x */
    @NotNull
    private static final DirectionProperty f3605x = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: z */
    @NotNull
    private static final BooleanProperty f3606z = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: q */
    @NotNull
    private static final C0717mo f3607q = new C0717mo(3.0f, 1.0f, 3.0f, 13.0f, 3.0f, 13.0f);

    /* JADX INFO: renamed from: ik */
    private static final float f3608ik = 0.1f;

    public C0630lG(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(f3605x, Direction.NORTH)).setValue(f3606z, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3607q.m3266a((Direction) blockState.getValue(f3605x));
    }

    @NotNull
    public InteractionResult useWithoutItem(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult blockHitResult) {
        SoundEvent soundEvent;
        if (!level.isClientSide) {
            if (level.random.nextFloat() < 0.1f) {
                soundEvent = (SoundEvent) C1312xz.f8181tu.get();
            } else {
                soundEvent = (SoundEvent) C1312xz.f8180tt.get();
            }
            level.playSound((Player) null, blockPos, soundEvent, SoundSource.BLOCKS, 1.0f, 0.95f + (0.01f * level.random.nextInt(4)));
        }
        return InteractionResult.SUCCESS;
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    /* JADX INFO: renamed from: a */
    public void mo2615a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        clientLevel.playLocalSound(blockPos.getX() + 0.5f, blockPos.getY() + 0.5f, blockPos.getZ() + 0.5f, (SoundEvent) C1312xz.f8179ts.get(), SoundSource.BLOCKS, 1.0f, 0.8f + (0.1f * clientLevel.random.nextInt(4)), false);
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    /* JADX INFO: renamed from: au */
    public boolean mo2616au() {
        return false;
    }
}
