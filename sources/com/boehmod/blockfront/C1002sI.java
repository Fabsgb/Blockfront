package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sI.class */
public class C1002sI extends AbstractC1000sG {
    @Override // com.boehmod.blockfront.AbstractC1000sG
    /* JADX INFO: renamed from: a */
    public void mo5459a(@NotNull C0994sA c0994sA, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull Level level, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    /* JADX INFO: renamed from: a */
    public void mo5460a(@NotNull C0994sA c0994sA, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set) {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Iterator<UUID> it = set.iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(it.next());
            if (serverPlayerM3963a != null) {
                serverPlayerM3963a.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, threadLocalRandomCurrent.nextInt(C1089tp.f5684rx), threadLocalRandomCurrent.nextInt(4)));
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    /* JADX INFO: renamed from: a */
    public void mo5461a(@NotNull C0994sA c0994sA, @NotNull Level level, @NotNull Set<UUID> set) {
        Iterator<UUID> it = set.iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(it.next());
            if (serverPlayerM3963a != null) {
                serverPlayerM3963a.removeEffect(MobEffects.MOVEMENT_SPEED);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    @NotNull
    public String getName() {
        return "bf.message.gamemode.ttt.randomat.speed";
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    @NotNull
    /* JADX INFO: renamed from: p */
    public String mo5462p() {
        return "bf.message.gamemode.ttt.randomat.speed.desc";
    }
}
