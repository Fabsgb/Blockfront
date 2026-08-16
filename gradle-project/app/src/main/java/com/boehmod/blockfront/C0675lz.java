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

/* JADX INFO: renamed from: com.boehmod.blockfront.lz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lz.class */
public class C0675lz extends C0633lJ implements InterfaceC0650la {
    public C0675lz(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo2615a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        float fNextInt = 1.0f + (0.05f * clientLevel.random.nextInt(8));
        Vec3 center = blockPos.getCenter();
        clientLevel.playLocalSound(center.x, center.y, center.z, (SoundEvent) C1312xz.f8167tg.get(), SoundSource.BLOCKS, 5.0f, fNextInt, true);
        clientLevel.playLocalSound(center.x, center.y, center.z, (SoundEvent) C1312xz.f8168th.get(), SoundSource.BLOCKS, 12.0f, fNextInt, true);
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    /* JADX INFO: renamed from: a */
    public void mo2931a(@NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @Nullable LivingEntity livingEntity) {
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (abstractC0531jNM179a == null) {
                return;
            }
            Object objMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer.getUUID());
            if (objMo2354a instanceof InterfaceC0944rC) {
                ((InterfaceC0944rC) objMo2354a).mo5181c(abstractC0531jNM179a, serverPlayer);
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    /* JADX INFO: renamed from: au */
    public boolean mo2616au() {
        return false;
    }
}
