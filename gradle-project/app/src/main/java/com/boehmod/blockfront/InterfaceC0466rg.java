package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rg.class */
public interface InterfaceC0466rg {
    boolean a(@NotNull Level level, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid);

    /* JADX INFO: renamed from: a */
    void mo1024a(@NotNull Level level, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid);

    float aT();

    static boolean a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerPlayer serverPlayer) {
        return !oR.a((Player) serverPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) cVar.m305a((Player) serverPlayer));
    }

    static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull C0514ta c0514ta, @NotNull LivingEntity livingEntity, @NotNull UUID uuid) {
        ServerPlayer serverPlayerA;
        sZ sZVarM1156a = c0514ta.m1156a();
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderK = sZVarM1156a.k();
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            if (deferredHolderK != null) {
                oR.a(serverPlayer, (SoundEvent) deferredHolderK.get(), SoundSource.PLAYERS, 2.0f);
                oR.m792a(oFVar, uuid, C0529tp.z, 0);
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, C0163g.g, 1, false, false));
            }
        }
        Set<UUID> setH = oFVar.b().h();
        float fRandom = (float) (0.8999999761581421d + (0.20000000298023224d * Math.random()));
        int id = livingEntity.getId();
        C0587vt c0587vt = null;
        if (deferredHolderK != null) {
            c0587vt = new C0587vt(deferredHolderK, SoundSource.PLAYERS, id, fRandom, 2.0f);
        }
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderL = sZVarM1156a.l();
        C0587vt c0587vt2 = null;
        if (deferredHolderL != null) {
            c0587vt2 = new C0587vt(deferredHolderL, SoundSource.PLAYERS, id, fRandom, 5.0f);
        }
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM = sZVarM1156a.m();
        if (Math.random() < 0.5d && deferredHolderM != null) {
            float fRandom2 = (float) (0.8999999761581421d + (0.20000000298023224d * Math.random()));
            int iRandom = ((int) (Math.random() * 32.0d)) - 16;
            int iRandom2 = ((int) (Math.random() * 32.0d)) - 16;
            if (Math.random() < 0.5d) {
                iRandom = -iRandom;
            }
            if (Math.random() < 0.5d) {
                iRandom2 = -iRandom2;
            }
            oR.a(livingEntity.level(), livingEntity.position().add(iRandom, 0.0d, iRandom2), (SoundEvent) deferredHolderM.get(), SoundSource.PLAYERS, 6.0f, fRandom2);
        }
        for (UUID uuid2 : setH) {
            if (!uuid2.equals(uuid) && (serverPlayerA = oR.a(uuid2)) != null) {
                if (c0587vt != null) {
                    C0582vo.a(c0587vt, serverPlayerA);
                }
                if (c0587vt2 != null) {
                    C0582vo.a(c0587vt2, serverPlayerA);
                }
            }
        }
    }
}
