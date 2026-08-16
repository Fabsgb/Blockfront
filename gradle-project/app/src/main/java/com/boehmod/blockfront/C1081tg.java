package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.tg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tg.class */
public class C1081tg extends AbstractC1078td {

    /* JADX INFO: renamed from: td */
    private int f5842td = 10;

    /* JADX INFO: renamed from: hB */
    private boolean f5843hB = false;

    @Override // com.boehmod.blockfront.AbstractC1078td
    /* JADX INFO: renamed from: a */
    public void mo5947a(@NotNull C1018sX c1018sX, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull Level level, @NotNull Set<UUID> set) {
        int i = this.f5842td;
        this.f5842td = i - 1;
        if (i <= 0 && !this.f5843hB) {
            this.f5843hB = true;
            ObjectArrayList objectArrayList = new ObjectArrayList(c1018sX.m5717a(EnumC1082th.TRAITOR, set));
            Collections.shuffle(objectArrayList);
            Iterator it = objectArrayList.iterator();
            while (it.hasNext()) {
                ServerPlayer serverPlayerM4399a = C0875pn.m4399a((UUID) it.next());
                if (serverPlayerM4399a != null && !C0875pn.m4488a((Player) serverPlayerM4399a, (AbstractC0183b<?, ?, ?, ?>) abstractC0184c.m1153a((Player) serverPlayerM4399a))) {
                    serverPlayerM4399a.playSound((SoundEvent) C1312xz.f8009qe.get(), 8.0f, (float) (0.800000011920929d + (0.30000001192092896d * Math.random())));
                    return;
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    /* JADX INFO: renamed from: a */
    public void mo5948a(@NotNull C1018sX c1018sX, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    /* JADX INFO: renamed from: a */
    public void mo5949a(@NotNull C1018sX c1018sX, @NotNull Level level, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    @NotNull
    public String getName() {
        return "bf.message.gamemode.ttt.traitor.fart";
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    @NotNull
    /* JADX INFO: renamed from: t */
    public String mo5950t() {
        return "bf.message.gamemode.ttt.traitor.fart.desc";
    }
}
