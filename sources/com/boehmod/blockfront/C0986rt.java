package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.rt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rt.class */
public final class C0986rt extends AbstractC0989rw {
    public C0986rt(@NotNull ServerPlayer serverPlayer, @NotNull Vec3 vec3, int i, int i2) {
        super(serverPlayer, vec3, i, i2);
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    /* JADX INFO: renamed from: c */
    void mo5417c(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
        C0759ne c0759neCreate;
        if (this.f5215b == null || (c0759neCreate = ((EntityType) C1230wX.f7055kY.get()).create(serverLevel)) == null) {
            return;
        }
        c0759neCreate.mo3283a((Player) this.f5215b, 0.0f, new ItemStack((ItemLike) C1231wY.f7118o.get()), 0.0f, 0.0f);
        c0759neCreate.setPos(this.f5243ae.x, serverLevel.getHeight(), this.f5243ae.z);
        serverLevel.addFreshEntity(c0759neCreate);
        Vec3 vec3Add = this.f5243ae.add(new Vec3(64.0d, 0.0d, 64.0d).yRot((float) Math.toRadians(serverLevel.random.nextFloat() * 90.0f)));
        C0799oR.m3939a(set, (SoundEvent) C1280xc.f7650rd.get(), SoundSource.AMBIENT, 25.0f, vec3Add);
        C0799oR.m3939a(set, (SoundEvent) C1280xc.f7651re.get(), SoundSource.AMBIENT, 25.0f, vec3Add);
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    /* JADX INFO: renamed from: d */
    void mo5418d(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    /* JADX INFO: renamed from: a */
    void mo5419a(@NotNull Level level, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    @Nullable
    /* JADX INFO: renamed from: l */
    public Component mo5420l() {
        return Component.translatable("bf.message.gamemode.radio.command.airstrike.precision");
    }
}
