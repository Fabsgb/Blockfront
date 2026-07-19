package com.boehmod.blockfront.common.player;

import com.boehmod.blockfront.C0582vo;
import com.boehmod.blockfront.C0587vt;
import com.boehmod.blockfront.C0624xc;
import com.boehmod.blockfront.oF;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/e.class */
public final class e {
    private static final float om = 1.0f;
    private static final float on = 4.0f;

    private e() {
    }

    public static void a(@NotNull ServerPlayer serverPlayer, @NotNull oF<?, ?, ?> oFVar) {
        a(serverPlayer, oFVar, C0624xc.GP, 1.0f, 0);
    }

    public static void a(@NotNull ServerPlayer serverPlayer, @NotNull oF<?, ?, ?> oFVar, @NotNull DamageSource damageSource) {
        a(serverPlayer, oFVar, damageSource.is(DamageTypeTags.IS_EXPLOSION) ? C0624xc.GG : C0624xc.GF, 4.0f, 6);
    }

    private static void a(@NotNull ServerPlayer serverPlayer, @NotNull oF<?, ?, ?> oFVar, @NotNull Holder<SoundEvent> holder, float f, int i) {
        C0582vo.a(new C0587vt(holder, SoundSource.HOSTILE, serverPlayer.getId(), 1.0f - (0.1f * serverPlayer.getRandom().nextFloat()), f, i), oFVar);
    }
}
