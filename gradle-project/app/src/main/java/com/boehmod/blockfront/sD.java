package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sD.class */
public class sD extends sG {
    @Override // com.boehmod.blockfront.sG
    public void a(@NotNull sA sAVar, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Level level, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.sG
    public void a(@NotNull sA sAVar, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set) {
        Iterator<UUID> it = set.iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerA = oR.a(it.next());
            if (serverPlayerA != null) {
                serverPlayerA.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack((ItemLike) wY.nc.get()));
            }
        }
    }

    @Override // com.boehmod.blockfront.sG
    public void a(@NotNull sA sAVar, @NotNull Level level, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.sG
    @NotNull
    public String getName() {
        return "bf.message.gamemode.ttt.randomat.melon.cannon";
    }

    @Override // com.boehmod.blockfront.sG
    @NotNull
    public String p() {
        return "bf.message.gamemode.ttt.randomat.melon.cannon.desc";
    }
}
