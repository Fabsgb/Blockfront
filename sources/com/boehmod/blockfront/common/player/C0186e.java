package com.boehmod.blockfront.common.player;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.C1169vO;
import com.boehmod.blockfront.C1174vT;
import com.boehmod.blockfront.C1312xz;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.common.player.e */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/common/player/e.class */
public final class C0186e {

    /* JADX INFO: renamed from: pk */
    private static final float f1444pk = 1.0f;

    /* JADX INFO: renamed from: pl */
    private static final float f1445pl = 4.0f;

    private C0186e() {
    }

    /* JADX INFO: renamed from: a */
    public static void m1162a(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        m1164a(serverPlayer, abstractC0863pb, C1312xz.f8882GT, 1.0f, 0);
    }

    /* JADX INFO: renamed from: a */
    public static void m1163a(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull DamageSource damageSource) {
        m1164a(serverPlayer, abstractC0863pb, damageSource.is(DamageTypeTags.IS_EXPLOSION) ? C1312xz.f8873GK : C1312xz.f8872GJ, 4.0f, 6);
    }

    /* JADX INFO: renamed from: a */
    private static void m1164a(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Holder<SoundEvent> holder, float f, int i) {
        C1169vO.m6646a(new C1174vT(holder, SoundSource.HOSTILE, serverPlayer.getId(), 1.0f - (0.1f * serverPlayer.getRandom().nextFloat()), f, i), abstractC0863pb);
    }
}
