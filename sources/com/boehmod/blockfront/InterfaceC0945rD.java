package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.rD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rD.class */
public interface InterfaceC0945rD {
    /* JADX INFO: renamed from: a */
    boolean mo5184a(@NotNull Level level, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid);

    /* JADX INFO: renamed from: a */
    void mo5185a(@NotNull Level level, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid);

    /* JADX INFO: renamed from: aZ */
    float mo5186aZ();

    /* JADX INFO: renamed from: a */
    static boolean m5182a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerPlayer serverPlayer) {
        return !C0875pn.m4488a((Player) serverPlayer, (AbstractC0183b<?, ?, ?, ?>) abstractC0184c.m1153a((Player) serverPlayer));
    }

    /* JADX INFO: renamed from: a */
    static void m5183a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C1098tx c1098tx, @NotNull LivingEntity livingEntity, @NotNull UUID uuid) {
        ServerPlayer serverPlayerM4399a;
        C1097tw c1097twM6179a = c1098tx.m6179a();
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6166k = c1097twM6179a.m6166k();
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            if (deferredHolderM6166k != null) {
                C0875pn.m4366a(serverPlayer, (SoundEvent) deferredHolderM6166k.get(), SoundSource.PLAYERS, 2.0f);
                C0875pn.m4447a(abstractC0863pb, uuid, C1062tN.f5762z, 0);
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, C0358g.f2490g, 1, false, false));
            }
        }
        Set<UUID> setM4245h = abstractC0863pb.m4018b().m4245h();
        float fRandom = (float) (0.8999999761581421d + (0.20000000298023224d * Math.random()));
        int id = livingEntity.getId();
        C1174vT c1174vT = null;
        if (deferredHolderM6166k != null) {
            c1174vT = new C1174vT(deferredHolderM6166k, SoundSource.PLAYERS, id, fRandom, 2.0f);
        }
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6167l = c1097twM6179a.m6167l();
        C1174vT c1174vT2 = null;
        if (deferredHolderM6167l != null) {
            c1174vT2 = new C1174vT(deferredHolderM6167l, SoundSource.PLAYERS, id, fRandom, 5.0f);
        }
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6168m = c1097twM6179a.m6168m();
        if (Math.random() < 0.5d && deferredHolderM6168m != null) {
            float fRandom2 = (float) (0.8999999761581421d + (0.20000000298023224d * Math.random()));
            int iRandom = ((int) (Math.random() * 32.0d)) - 16;
            int iRandom2 = ((int) (Math.random() * 32.0d)) - 16;
            if (Math.random() < 0.5d) {
                iRandom = -iRandom;
            }
            if (Math.random() < 0.5d) {
                iRandom2 = -iRandom2;
            }
            C0875pn.m4377a(livingEntity.level(), livingEntity.position().add(iRandom, 0.0d, iRandom2), (SoundEvent) deferredHolderM6168m.get(), SoundSource.PLAYERS, 6.0f, fRandom2);
        }
        for (UUID uuid2 : setM4245h) {
            if (!uuid2.equals(uuid) && (serverPlayerM4399a = C0875pn.m4399a(uuid2)) != null) {
                if (c1174vT != null) {
                    C1169vO.m6643a(c1174vT, serverPlayerM4399a);
                }
                if (c1174vT2 != null) {
                    C1169vO.m6643a(c1174vT2, serverPlayerM4399a);
                }
            }
        }
    }
}
