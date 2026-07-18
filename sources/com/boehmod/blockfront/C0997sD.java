package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sD.class */
public class C0997sD extends AbstractC1000sG {
    @Override // com.boehmod.blockfront.AbstractC1000sG
    /* JADX INFO: renamed from: a */
    public void mo5459a(@NotNull C0994sA c0994sA, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull Level level, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    /* JADX INFO: renamed from: a */
    public void mo5460a(@NotNull C0994sA c0994sA, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set) {
        Iterator<UUID> it = set.iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(it.next());
            if (serverPlayerM3963a != null) {
                serverPlayerM3963a.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack((ItemLike) C1231wY.f7274nc.get()));
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    /* JADX INFO: renamed from: a */
    public void mo5461a(@NotNull C0994sA c0994sA, @NotNull Level level, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    @NotNull
    public String getName() {
        return "bf.message.gamemode.ttt.randomat.melon.cannon";
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    @NotNull
    /* JADX INFO: renamed from: p */
    public String mo5462p() {
        return "bf.message.gamemode.ttt.randomat.melon.cannon.desc";
    }
}
