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

/* JADX INFO: renamed from: com.boehmod.blockfront.rt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rt.class */
public final class C0479rt extends AbstractC0482rw {
    public C0479rt(@NotNull ServerPlayer serverPlayer, @NotNull Vec3 vec3, int i, int i2) {
        super(serverPlayer, vec3, i, i2);
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    void c(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set) {
        C0356ne c0356neCreate;
        if (this.b == null || (c0356neCreate = ((EntityType) wX.kY.get()).create(serverLevel)) == null) {
            return;
        }
        c0356neCreate.a((Player) this.b, 0.0f, new ItemStack((ItemLike) wY.o.get()), 0.0f, 0.0f);
        c0356neCreate.setPos(this.ae.x, serverLevel.getHeight(), this.ae.z);
        serverLevel.addFreshEntity(c0356neCreate);
        Vec3 vec3Add = this.ae.add(new Vec3(64.0d, 0.0d, 64.0d).yRot((float) Math.toRadians(serverLevel.random.nextFloat() * 90.0f)));
        oR.a(set, (SoundEvent) C0624xc.rd.get(), SoundSource.AMBIENT, 25.0f, vec3Add);
        oR.a(set, (SoundEvent) C0624xc.re.get(), SoundSource.AMBIENT, 25.0f, vec3Add);
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    void d(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    void a(@NotNull Level level, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    @Nullable
    public Component l() {
        return Component.translatable("bf.message.gamemode.radio.command.airstrike.precision");
    }
}
