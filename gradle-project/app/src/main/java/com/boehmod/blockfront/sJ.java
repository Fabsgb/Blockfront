package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sJ.class */
public class sJ extends sG {
    private int rc = 10;
    private boolean hh = false;

    @Override // com.boehmod.blockfront.sG
    public void a(@NotNull sA sAVar, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Level level, @NotNull Set<UUID> set) {
        int i = this.rc;
        this.rc = i - 1;
        if (i <= 0 && !this.hh) {
            this.hh = true;
            ObjectArrayList objectArrayList = new ObjectArrayList(sAVar.a(sK.TRAITOR, set));
            Collections.shuffle(objectArrayList);
            Iterator it = objectArrayList.iterator();
            while (it.hasNext()) {
                ServerPlayer serverPlayerA = oR.a((UUID) it.next());
                if (serverPlayerA != null && !oR.a((Player) serverPlayerA, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) cVar.m305a((Player) serverPlayerA))) {
                    serverPlayerA.playSound((SoundEvent) C0624xc.qc.get(), 8.0f, (float) (0.800000011920929d + (0.30000001192092896d * Math.random())));
                    return;
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.sG
    public void a(@NotNull sA sAVar, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.sG
    public void a(@NotNull sA sAVar, @NotNull Level level, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.sG
    @NotNull
    public String getName() {
        return "bf.message.gamemode.ttt.traitor.fart";
    }

    @Override // com.boehmod.blockfront.sG
    @NotNull
    public String p() {
        return "bf.message.gamemode.ttt.traitor.fart.desc";
    }
}
