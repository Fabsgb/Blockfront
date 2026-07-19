package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sF.class */
public class sF extends sG {
    private int lA = 600;

    @Override // com.boehmod.blockfront.sG
    public void a(@NotNull sA sAVar, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Level level, @NotNull Set<UUID> set) {
        int i = this.lA;
        this.lA = i - 1;
        if (i <= 0) {
            this.lA = 600;
            a(sAVar, cVar, set);
        }
    }

    private void a(@NotNull sA sAVar, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Set<UUID> set) {
        ObjectArrayList objectArrayList = new ObjectArrayList(set);
        objectArrayList.removeIf(uuid -> {
            com.boehmod.blockfront.common.player.b bVarB = cVar.b(uuid);
            ServerPlayer serverPlayerA = oR.a(uuid);
            return serverPlayerA == null || oR.a((Player) serverPlayerA, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) bVarB);
        });
        if (objectArrayList.isEmpty()) {
            return;
        }
        Collections.shuffle(objectArrayList);
        ServerPlayer serverPlayerA = oR.a((UUID) objectArrayList.getFirst());
        if (serverPlayerA == null) {
            return;
        }
        serverPlayerA.kill();
        C0582vo.a(new C0588vu(oE.GENERIC, serverPlayerA.position()), sAVar);
        oR.a((oF<?, ?, ?>) sAVar, (Component) Component.translatable("bf.message.gamemode.ttt.randomat.random.explode.player", new Object[]{Component.literal(serverPlayerA.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.GOLD), 80, ak());
    }

    @Override // com.boehmod.blockfront.sG
    public void a(@NotNull sA sAVar, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set) {
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
        return "bf.message.gamemode.ttt.randomat.random.explode";
    }

    @Override // com.boehmod.blockfront.sG
    @NotNull
    public String p() {
        return "bf.message.gamemode.ttt.randomat.random.explode.desc";
    }
}
