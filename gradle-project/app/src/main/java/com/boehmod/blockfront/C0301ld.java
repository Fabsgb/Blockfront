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

/* JADX INFO: renamed from: com.boehmod.blockfront.ld, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ld.class */
public class C0301ld extends C0311ln implements kE {
    public C0301ld(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override // com.boehmod.blockfront.kE
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        float fNextInt = 1.0f + (0.05f * clientLevel.random.nextInt(8));
        Vec3 center = blockPos.getCenter();
        clientLevel.playLocalSound(center.x, center.y, center.z, (SoundEvent) C0624xc.tf.get(), SoundSource.BLOCKS, 5.0f, fNextInt, true);
        clientLevel.playLocalSound(center.x, center.y, center.z, (SoundEvent) C0624xc.tg.get(), SoundSource.BLOCKS, 12.0f, fNextInt, true);
    }

    @Override // com.boehmod.blockfront.kE
    public void a(@NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @Nullable LivingEntity livingEntity) {
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (abstractC0264juM166a == null) {
                return;
            }
            Object objMo604a = abstractC0264juM166a.mo604a(serverPlayer.getUUID());
            if (objMo604a instanceof InterfaceC0465rf) {
                ((InterfaceC0465rf) objMo604a).c(abstractC0264juM166a, serverPlayer);
            }
        }
    }

    @Override // com.boehmod.blockfront.kE
    public boolean ak() {
        return false;
    }
}
