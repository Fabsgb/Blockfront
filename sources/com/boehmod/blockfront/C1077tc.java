package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.cloud.connection.ModConnection;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tc.class */
public class C1077tc extends AbstractC1078td {

    /* JADX INFO: renamed from: ny */
    private int f5839ny = ModConnection.CONNECT_TIME_MAX_TICKS;

    @Override // com.boehmod.blockfront.AbstractC1078td
    /* JADX INFO: renamed from: a */
    public void mo5947a(@NotNull C1018sX c1018sX, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull Level level, @NotNull Set<UUID> set) {
        int i = this.f5839ny;
        this.f5839ny = i - 1;
        if (i <= 0) {
            this.f5839ny = ModConnection.CONNECT_TIME_MAX_TICKS;
            m5952a(c1018sX, abstractC0184c, set);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5952a(@NotNull C1018sX c1018sX, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull Set<UUID> set) {
        ObjectArrayList objectArrayList = new ObjectArrayList(set);
        objectArrayList.removeIf(uuid -> {
            AbstractC0183b abstractC0183bM1152b = abstractC0184c.m1152b(uuid);
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(uuid);
            return serverPlayerM4399a == null || C0875pn.m4488a((Player) serverPlayerM4399a, (AbstractC0183b<?, ?, ?, ?>) abstractC0183bM1152b);
        });
        if (objectArrayList.isEmpty()) {
            return;
        }
        Collections.shuffle(objectArrayList);
        ServerPlayer serverPlayerM4399a = C0875pn.m4399a((UUID) objectArrayList.getFirst());
        if (serverPlayerM4399a == null) {
            return;
        }
        serverPlayerM4399a.kill();
        C1169vO.m6646a(new C1175vU(EnumC0862pa.GENERIC, serverPlayerM4399a.position()), c1018sX);
        C0875pn.m4436a((AbstractC0863pb<?, ?, ?>) c1018sX, (Component) Component.translatable("bf.message.gamemode.ttt.randomat.random.explode.player", new Object[]{Component.literal(serverPlayerM4399a.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.GOLD), 80, m5954ar());
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    /* JADX INFO: renamed from: a */
    public void mo5948a(@NotNull C1018sX c1018sX, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set) {
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
        return "bf.message.gamemode.ttt.randomat.random.explode";
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    @NotNull
    /* JADX INFO: renamed from: t */
    public String mo5950t() {
        return "bf.message.gamemode.ttt.randomat.random.explode.desc";
    }
}
