package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xL.class */
public class xL {

    @NotNull
    private final ObjectList<oX> ad = new ObjectArrayList();
    private int ux = 0;

    @Nullable
    private oX o;

    @Nullable
    private GameType a;
    private boolean jM;
    private boolean em;
    private static final int uy = 120;

    public boolean a(@NotNull oX oXVar) {
        if (this.ux > 0 && !this.ad.isEmpty() && ((oX) this.ad.getFirst()).equals(oXVar)) {
            this.ad.removeFirst();
            return true;
        }
        return false;
    }

    public void c(@NotNull C0332mh c0332mh) {
        dM();
        this.em = c0332mh.ax();
        int iAl = 0;
        for (C0331mg c0331mg : c0332mh.s()) {
            this.ad.add(c0331mg.a());
            iAl += (int) (c0331mg.al() * 20.0f);
        }
        this.ux = iAl + 120;
    }

    public boolean a(@NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull oX oXVar) {
        if (this.em || !a(oXVar)) {
            return false;
        }
        if (!this.jM) {
            a(serverPlayer, cVar);
        }
        oR.a(cVar, serverPlayer, oXVar);
        return true;
    }

    private void a(@NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        this.o = new oX((Player) serverPlayer);
        this.a = serverPlayer.gameMode.getGameModeForPlayer();
        this.jM = true;
        cVar.m305a((Player) serverPlayer).Y(true);
        serverPlayer.setInvisible(true);
        serverPlayer.setGameMode(GameType.SPECTATOR);
        oR.a(cVar, serverPlayer);
    }

    public void b(@NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        if (!this.em) {
            return;
        }
        this.jM = true;
        cVar.m305a((Player) serverPlayer).Y(true);
        oR.a(cVar, serverPlayer);
    }

    public void c(@NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        a(serverPlayer, cVar, true);
    }

    public void d(@NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        a(serverPlayer, cVar, false);
    }

    private void a(@NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, boolean z) {
        if (!this.jM) {
            dM();
            return;
        }
        this.jM = false;
        cVar.m305a((Player) serverPlayer).Y(false);
        oR.b(cVar, serverPlayer);
        if (!this.em) {
            serverPlayer.setInvisible(false);
            if (this.a != null) {
                serverPlayer.setGameMode(this.a);
            }
            if (z && this.o != null) {
                oR.a(cVar, serverPlayer, this.o);
            }
        }
        this.o = null;
        this.a = null;
        dM();
    }

    public void e(@NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        if (this.ux > 0) {
            this.ux--;
            if (this.ux == 0) {
                c(serverPlayer, cVar);
            }
        }
    }

    private void dM() {
        this.ad.clear();
        this.ux = 0;
        this.em = false;
    }

    public boolean du() {
        return this.ux > 0;
    }
}
