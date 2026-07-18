package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sF.class */
public class C0999sF extends AbstractC1000sG {

    /* JADX INFO: renamed from: lA */
    private int f5275lA = 600;

    @Override // com.boehmod.blockfront.AbstractC1000sG
    /* JADX INFO: renamed from: a */
    public void mo5459a(@NotNull C0994sA c0994sA, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull Level level, @NotNull Set<UUID> set) {
        int i = this.f5275lA;
        this.f5275lA = i - 1;
        if (i <= 0) {
            this.f5275lA = 600;
            m5464a(c0994sA, abstractC0183c, set);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5464a(@NotNull C0994sA c0994sA, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull Set<UUID> set) {
        ObjectArrayList objectArrayList = new ObjectArrayList(set);
        objectArrayList.removeIf(uuid -> {
            AbstractC0182b abstractC0182bM1135b = abstractC0183c.m1135b(uuid);
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(uuid);
            return serverPlayerM3963a == null || C0799oR.m4052a((Player) serverPlayerM3963a, (AbstractC0182b<?, ?, ?, ?>) abstractC0182bM1135b);
        });
        if (objectArrayList.isEmpty()) {
            return;
        }
        Collections.shuffle(objectArrayList);
        ServerPlayer serverPlayerM3963a = C0799oR.m3963a((UUID) objectArrayList.getFirst());
        if (serverPlayerM3963a == null) {
            return;
        }
        serverPlayerM3963a.kill();
        C1194vo.m6651a(new C1200vu(EnumC0786oE.GENERIC, serverPlayerM3963a.position()), c0994sA);
        C0799oR.m4000a((AbstractC0787oF<?, ?, ?>) c0994sA, (Component) Component.translatable("bf.message.gamemode.ttt.randomat.random.explode.player", new Object[]{Component.literal(serverPlayerM3963a.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.GOLD), 80, m5466ak());
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    /* JADX INFO: renamed from: a */
    public void mo5460a(@NotNull C0994sA c0994sA, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set) {
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
        return "bf.message.gamemode.ttt.randomat.random.explode";
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    @NotNull
    /* JADX INFO: renamed from: p */
    public String mo5462p() {
        return "bf.message.gamemode.ttt.randomat.random.explode.desc";
    }
}
