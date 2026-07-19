package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sI.class */
public class sI extends sG {
    @Override // com.boehmod.blockfront.sG
    public void a(@NotNull sA sAVar, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Level level, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.sG
    public void a(@NotNull sA sAVar, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set) {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Iterator<UUID> it = set.iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerA = oR.a(it.next());
            if (serverPlayerA != null) {
                serverPlayerA.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, threadLocalRandomCurrent.nextInt(C0529tp.rx), threadLocalRandomCurrent.nextInt(4)));
            }
        }
    }

    @Override // com.boehmod.blockfront.sG
    public void a(@NotNull sA sAVar, @NotNull Level level, @NotNull Set<UUID> set) {
        Iterator<UUID> it = set.iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerA = oR.a(it.next());
            if (serverPlayerA != null) {
                serverPlayerA.removeEffect(MobEffects.MOVEMENT_SPEED);
            }
        }
    }

    @Override // com.boehmod.blockfront.sG
    @NotNull
    public String getName() {
        return "bf.message.gamemode.ttt.randomat.speed";
    }

    @Override // com.boehmod.blockfront.sG
    @NotNull
    public String p() {
        return "bf.message.gamemode.ttt.randomat.speed.desc";
    }
}
