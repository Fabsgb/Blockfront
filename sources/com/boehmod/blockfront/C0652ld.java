package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ld */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ld.class */
public class C0652ld extends C0662ln implements InterfaceC0574kE {
    public C0652ld(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override // com.boehmod.blockfront.InterfaceC0574kE
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo2601a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        float fNextInt = 1.0f + (0.05f * clientLevel.random.nextInt(8));
        Vec3 center = blockPos.getCenter();
        clientLevel.playLocalSound(center.x, center.y, center.z, (SoundEvent) C1280xc.f7756tf.get(), SoundSource.BLOCKS, 5.0f, fNextInt, true);
        clientLevel.playLocalSound(center.x, center.y, center.z, (SoundEvent) C1280xc.f7757tg.get(), SoundSource.BLOCKS, 12.0f, fNextInt, true);
    }

    @Override // com.boehmod.blockfront.InterfaceC0574kE
    /* JADX INFO: renamed from: a */
    public void mo2603a(@NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @Nullable LivingEntity livingEntity) {
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (abstractC0563juM168a == null) {
                return;
            }
            Object objMo2531a = abstractC0563juM168a.mo2531a(serverPlayer.getUUID());
            if (objMo2531a instanceof InterfaceC0972rf) {
                ((InterfaceC0972rf) objMo2531a).mo5308c(abstractC0563juM168a, serverPlayer);
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0574kE
    /* JADX INFO: renamed from: ak */
    public boolean mo2602ak() {
        return false;
    }
}
