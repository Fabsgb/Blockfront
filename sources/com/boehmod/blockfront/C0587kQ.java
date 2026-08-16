package com.boehmod.blockfront;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.kQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kQ.class */
public class C0587kQ extends BaseEntityBlock implements InterfaceC0596kZ {

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final MapCodec<C0587kQ> f3372e = simpleCodec(C0587kQ::new);

    public C0587kQ(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return f3372e;
    }

    @NotNull
    public VoxelShape getCollisionShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return Shapes.empty();
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        return (localPlayer == null || !localPlayer.isCreative()) ? RenderShape.INVISIBLE : RenderShape.MODEL;
    }

    @Nullable
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return ((BlockEntityType) C1293xg.f6932bI.get()).create(blockPos, blockState);
    }

    @OnlyIn(Dist.CLIENT)
    protected float getShadeBrightness(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null || minecraft.player.isCreative() || C0549jf.f3265aC == null) {
            return 1.0f;
        }
        return super.getShadeBrightness(blockState, blockGetter, blockPos);
    }

    @OnlyIn(Dist.CLIENT)
    protected boolean propagatesSkylightDown(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null || minecraft.player.isCreative() || C0549jf.f3265aC == null) {
            return true;
        }
        return super.propagatesSkylightDown(blockState, blockGetter, blockPos);
    }
}
