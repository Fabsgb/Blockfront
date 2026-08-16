package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.tf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tf.class */
public class C1080tf extends AbstractC1078td {
    @Override // com.boehmod.blockfront.AbstractC1078td
    /* JADX INFO: renamed from: a */
    public void mo5947a(@NotNull C1018sX c1018sX, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull Level level, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    /* JADX INFO: renamed from: a */
    public void mo5948a(@NotNull C1018sX c1018sX, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set) {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Iterator<UUID> it = set.iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(it.next());
            if (serverPlayerM4399a != null) {
                serverPlayerM4399a.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, threadLocalRandomCurrent.nextInt(C1062tN.f5737tA), threadLocalRandomCurrent.nextInt(4)));
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    /* JADX INFO: renamed from: a */
    public void mo5949a(@NotNull C1018sX c1018sX, @NotNull Level level, @NotNull Set<UUID> set) {
        Iterator<UUID> it = set.iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(it.next());
            if (serverPlayerM4399a != null) {
                serverPlayerM4399a.removeEffect(MobEffects.MOVEMENT_SPEED);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    @NotNull
    public String getName() {
        return "bf.message.gamemode.ttt.randomat.speed";
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    @NotNull
    /* JADX INFO: renamed from: t */
    public String mo5950t() {
        return "bf.message.gamemode.ttt.randomat.speed.desc";
    }
}
