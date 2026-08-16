package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ta */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ta.class */
public class C1075ta extends AbstractC1078td {
    @Override // com.boehmod.blockfront.AbstractC1078td
    /* JADX INFO: renamed from: a */
    public void mo5947a(@NotNull C1018sX c1018sX, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull Level level, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    /* JADX INFO: renamed from: a */
    public void mo5948a(@NotNull C1018sX c1018sX, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set) {
        Iterator<UUID> it = set.iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(it.next());
            if (serverPlayerM4399a != null) {
                serverPlayerM4399a.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack((ItemLike) C1308xv.f7839nc.get()));
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    /* JADX INFO: renamed from: a */
    public void mo5949a(@NotNull C1018sX c1018sX, @NotNull Level level, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    @NotNull
    public String getName() {
        return "bf.message.gamemode.ttt.randomat.melon.cannon";
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    @NotNull
    /* JADX INFO: renamed from: t */
    public String mo5950t() {
        return "bf.message.gamemode.ttt.randomat.melon.cannon.desc";
    }
}
