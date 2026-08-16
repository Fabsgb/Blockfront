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

/* JADX INFO: renamed from: com.boehmod.blockfront.rQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rQ.class */
public final class C0958rQ extends AbstractC0961rT {
    public C0958rQ(@NotNull ServerPlayer serverPlayer, @NotNull Vec3 vec3, int i, int i2) {
        super(serverPlayer, vec3, i, i2);
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    /* JADX INFO: renamed from: c */
    void mo5293c(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set) {
        C0730nA c0730nACreate;
        if (this.f5319c == null || (c0730nACreate = ((EntityType) C1307xu.f7620kY.get()).create(serverLevel)) == null) {
            return;
        }
        c0730nACreate.mo3118a((Player) this.f5319c, 0.0f, new ItemStack((ItemLike) C1308xv.f7683o.get()), 0.0f, 0.0f);
        c0730nACreate.setPos(this.f5347af.x, serverLevel.getHeight(), this.f5347af.z);
        serverLevel.addFreshEntity(c0730nACreate);
        C0875pn.m4375a(set, (SoundEvent) C1312xz.f8062rf.get(), SoundSource.AMBIENT, 25.0f, this.f5347af.add(new Vec3(64.0d, 0.0d, 64.0d).yRot((float) Math.toRadians(serverLevel.random.nextFloat() * 90.0f))));
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    /* JADX INFO: renamed from: d */
    void mo5294d(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    /* JADX INFO: renamed from: a */
    void mo5295a(@NotNull Level level, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    @Nullable
    /* JADX INFO: renamed from: l */
    public Component mo5296l() {
        return Component.translatable("bf.message.gamemode.radio.command.airstrike.precision");
    }
}
