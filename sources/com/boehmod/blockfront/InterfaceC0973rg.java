package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.rg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rg.class */
public interface InterfaceC0973rg {
    /* JADX INFO: renamed from: a */
    boolean mo5169a(@NotNull Level level, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid);

    /* JADX INFO: renamed from: a */
    void mo5170a(@NotNull Level level, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid);

    /* JADX INFO: renamed from: aT */
    float mo5171aT();

    /* JADX INFO: renamed from: a */
    static boolean m5309a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerPlayer serverPlayer) {
        return !C0799oR.m4052a((Player) serverPlayer, (AbstractC0182b<?, ?, ?, ?>) abstractC0183c.m1136a((Player) serverPlayer));
    }

    /* JADX INFO: renamed from: a */
    static void m5310a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C1074ta c1074ta, @NotNull LivingEntity livingEntity, @NotNull UUID uuid) {
        ServerPlayer serverPlayerM3963a;
        C1019sZ c1019sZM5976a = c1074ta.m5976a();
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM5678k = c1019sZM5976a.m5678k();
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            if (deferredHolderM5678k != null) {
                C0799oR.m3930a(serverPlayer, (SoundEvent) deferredHolderM5678k.get(), SoundSource.PLAYERS, 2.0f);
                C0799oR.m4011a(abstractC0787oF, uuid, C1089tp.f5709z, 0);
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, C0357g.f2439g, 1, false, false));
            }
        }
        Set<UUID> setM3809h = abstractC0787oF.m3582b().m3809h();
        float fRandom = (float) (0.8999999761581421d + (0.20000000298023224d * Math.random()));
        int id = livingEntity.getId();
        C1199vt c1199vt = null;
        if (deferredHolderM5678k != null) {
            c1199vt = new C1199vt(deferredHolderM5678k, SoundSource.PLAYERS, id, fRandom, 2.0f);
        }
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM5679l = c1019sZM5976a.m5679l();
        C1199vt c1199vt2 = null;
        if (deferredHolderM5679l != null) {
            c1199vt2 = new C1199vt(deferredHolderM5679l, SoundSource.PLAYERS, id, fRandom, 5.0f);
        }
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM5680m = c1019sZM5976a.m5680m();
        if (Math.random() < 0.5d && deferredHolderM5680m != null) {
            float fRandom2 = (float) (0.8999999761581421d + (0.20000000298023224d * Math.random()));
            int iRandom = ((int) (Math.random() * 32.0d)) - 16;
            int iRandom2 = ((int) (Math.random() * 32.0d)) - 16;
            if (Math.random() < 0.5d) {
                iRandom = -iRandom;
            }
            if (Math.random() < 0.5d) {
                iRandom2 = -iRandom2;
            }
            C0799oR.m3941a(livingEntity.level(), livingEntity.position().add(iRandom, 0.0d, iRandom2), (SoundEvent) deferredHolderM5680m.get(), SoundSource.PLAYERS, 6.0f, fRandom2);
        }
        for (UUID uuid2 : setM3809h) {
            if (!uuid2.equals(uuid) && (serverPlayerM3963a = C0799oR.m3963a(uuid2)) != null) {
                if (c1199vt != null) {
                    C1194vo.m6648a(c1199vt, serverPlayerM3963a);
                }
                if (c1199vt2 != null) {
                    C1194vo.m6648a(c1199vt2, serverPlayerM3963a);
                }
            }
        }
    }
}
