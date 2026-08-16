package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.yj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/yj.class */
public class C1323yj {

    /* JADX INFO: renamed from: am */
    @NotNull
    private final ObjectList<C0881pt> f9051am = new ObjectArrayList();

    /* JADX INFO: renamed from: wB */
    private int f9052wB = 0;

    /* JADX INFO: renamed from: o */
    @Nullable
    private C0881pt f9053o;

    /* JADX INFO: renamed from: a */
    @Nullable
    private GameType f9054a;

    /* JADX INFO: renamed from: kc */
    private boolean f9055kc;

    /* JADX INFO: renamed from: eG */
    private boolean f9056eG;

    /* JADX INFO: renamed from: wC */
    private static final int f9057wC = 120;

    /* JADX INFO: renamed from: a */
    public boolean m8281a(@NotNull C0881pt c0881pt) {
        if (this.f9052wB > 0 && !this.f9051am.isEmpty() && ((C0881pt) this.f9051am.getFirst()).equals(c0881pt)) {
            this.f9051am.removeFirst();
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    public void m8282c(@NotNull C0680mD c0680mD) {
        m8290dW();
        this.f9056eG = c0680mD.m3036aI();
        int iM3007ar = 0;
        for (C0679mC c0679mC : c0680mD.m3031u()) {
            this.f9051am.add(c0679mC.m3005a());
            iM3007ar += (int) (c0679mC.m3007ar() * 20.0f);
        }
        this.f9052wB = iM3007ar + 120;
    }

    /* JADX INFO: renamed from: a */
    public boolean m8283a(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull C0881pt c0881pt) {
        if (this.f9056eG || !m8281a(c0881pt)) {
            return false;
        }
        if (!this.f9055kc) {
            m8284a(serverPlayer, abstractC0184c);
        }
        C0875pn.m4402a(abstractC0184c, serverPlayer, c0881pt);
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m8284a(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0184c<?> abstractC0184c) {
        this.f9053o = new C0881pt((Player) serverPlayer);
        this.f9054a = serverPlayer.gameMode.getGameModeForPlayer();
        this.f9055kc = true;
        abstractC0184c.m1153a((Player) serverPlayer).m1107Z(true);
        serverPlayer.setInvisible(true);
        serverPlayer.setGameMode(GameType.SPECTATOR);
        C0875pn.m4394a(abstractC0184c, serverPlayer);
    }

    /* JADX INFO: renamed from: b */
    public void m8285b(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0184c<?> abstractC0184c) {
        if (!this.f9056eG) {
            return;
        }
        this.f9055kc = true;
        abstractC0184c.m1153a((Player) serverPlayer).m1107Z(true);
        C0875pn.m4394a(abstractC0184c, serverPlayer);
    }

    /* JADX INFO: renamed from: c */
    public void m8286c(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0184c<?> abstractC0184c) {
        m8288a(serverPlayer, abstractC0184c, true);
    }

    /* JADX INFO: renamed from: d */
    public void m8287d(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0184c<?> abstractC0184c) {
        m8288a(serverPlayer, abstractC0184c, false);
    }

    /* JADX INFO: renamed from: a */
    private void m8288a(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0184c<?> abstractC0184c, boolean z) {
        if (!this.f9055kc) {
            m8290dW();
            return;
        }
        this.f9055kc = false;
        abstractC0184c.m1153a((Player) serverPlayer).m1107Z(false);
        C0875pn.m4395b(abstractC0184c, serverPlayer);
        if (!this.f9056eG) {
            serverPlayer.setInvisible(false);
            if (this.f9054a != null) {
                serverPlayer.setGameMode(this.f9054a);
            }
            if (z && this.f9053o != null) {
                C0875pn.m4402a(abstractC0184c, serverPlayer, this.f9053o);
            }
        }
        this.f9053o = null;
        this.f9054a = null;
        m8290dW();
    }

    /* JADX INFO: renamed from: e */
    public void m8289e(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0184c<?> abstractC0184c) {
        if (this.f9052wB > 0) {
            this.f9052wB--;
            if (this.f9052wB == 0) {
                m8286c(serverPlayer, abstractC0184c);
            }
        }
    }

    /* JADX INFO: renamed from: dW */
    private void m8290dW() {
        this.f9051am.clear();
        this.f9052wB = 0;
        this.f9056eG = false;
    }

    /* JADX INFO: renamed from: dD */
    public boolean m8291dD() {
        return this.f9052wB > 0;
    }
}
