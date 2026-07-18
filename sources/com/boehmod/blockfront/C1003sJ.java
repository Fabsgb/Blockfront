package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sJ.class */
public class C1003sJ extends AbstractC1000sG {

    /* JADX INFO: renamed from: rc */
    private int f5278rc = 10;

    /* JADX INFO: renamed from: hh */
    private boolean f5279hh = false;

    @Override // com.boehmod.blockfront.AbstractC1000sG
    /* JADX INFO: renamed from: a */
    public void mo5459a(@NotNull C0994sA c0994sA, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull Level level, @NotNull Set<UUID> set) {
        int i = this.f5278rc;
        this.f5278rc = i - 1;
        if (i <= 0 && !this.f5279hh) {
            this.f5279hh = true;
            ObjectArrayList objectArrayList = new ObjectArrayList(c0994sA.m5439a(EnumC1004sK.TRAITOR, set));
            Collections.shuffle(objectArrayList);
            Iterator it = objectArrayList.iterator();
            while (it.hasNext()) {
                ServerPlayer serverPlayerM3963a = C0799oR.m3963a((UUID) it.next());
                if (serverPlayerM3963a != null && !C0799oR.m4052a((Player) serverPlayerM3963a, (AbstractC0182b<?, ?, ?, ?>) abstractC0183c.m1136a((Player) serverPlayerM3963a))) {
                    serverPlayerM3963a.playSound((SoundEvent) C1280xc.f7597qc.get(), 8.0f, (float) (0.800000011920929d + (0.30000001192092896d * Math.random())));
                    return;
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    /* JADX INFO: renamed from: a */
    public void mo5460a(@NotNull C0994sA c0994sA, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    /* JADX INFO: renamed from: a */
    public void mo5461a(@NotNull C0994sA c0994sA, @NotNull Level level, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    @NotNull
    public String getName() {
        return "bf.message.gamemode.ttt.traitor.fart";
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    @NotNull
    /* JADX INFO: renamed from: p */
    public String mo5462p() {
        return "bf.message.gamemode.ttt.traitor.fart.desc";
    }
}
