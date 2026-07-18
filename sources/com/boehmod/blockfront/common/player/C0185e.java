package com.boehmod.blockfront.common.player;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.C1194vo;
import com.boehmod.blockfront.C1199vt;
import com.boehmod.blockfront.C1280xc;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.common.player.e */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/e.class */
public final class C0185e {

    /* JADX INFO: renamed from: om */
    private static final float f1522om = 1.0f;

    /* JADX INFO: renamed from: on */
    private static final float f1523on = 4.0f;

    private C0185e() {
    }

    /* JADX INFO: renamed from: a */
    public static void m1145a(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        m1147a(serverPlayer, abstractC0787oF, C1280xc.f8468GP, 1.0f, 0);
    }

    /* JADX INFO: renamed from: a */
    public static void m1146a(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull DamageSource damageSource) {
        m1147a(serverPlayer, abstractC0787oF, damageSource.is(DamageTypeTags.IS_EXPLOSION) ? C1280xc.f8459GG : C1280xc.f8458GF, 4.0f, 6);
    }

    /* JADX INFO: renamed from: a */
    private static void m1147a(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Holder<SoundEvent> holder, float f, int i) {
        C1194vo.m6651a(new C1199vt(holder, SoundSource.HOSTILE, serverPlayer.getId(), 1.0f - (0.1f * serverPlayer.getRandom().nextFloat()), f, i), abstractC0787oF);
    }
}
