package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.xL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xL.class */
public class C1271xL {

    /* JADX INFO: renamed from: ad */
    @NotNull
    private final ObjectList<C0805oX> f7467ad = new ObjectArrayList();

    /* JADX INFO: renamed from: ux */
    private int f7468ux = 0;

    /* JADX INFO: renamed from: o */
    @Nullable
    private C0805oX f7469o;

    /* JADX INFO: renamed from: a */
    @Nullable
    private GameType f7470a;

    /* JADX INFO: renamed from: jM */
    private boolean f7471jM;

    /* JADX INFO: renamed from: em */
    private boolean f7472em;

    /* JADX INFO: renamed from: uy */
    private static final int f7473uy = 120;

    /* JADX INFO: renamed from: a */
    public boolean m7765a(@NotNull C0805oX c0805oX) {
        if (this.f7468ux > 0 && !this.f7467ad.isEmpty() && ((C0805oX) this.f7467ad.getFirst()).equals(c0805oX)) {
            this.f7467ad.removeFirst();
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    public void m7766c(@NotNull C0709mh c0709mh) {
        m7774dM();
        this.f7472em = c0709mh.m3205ax();
        int iM3176al = 0;
        for (C0708mg c0708mg : c0709mh.m3200s()) {
            this.f7467ad.add(c0708mg.m3174a());
            iM3176al += (int) (c0708mg.m3176al() * 20.0f);
        }
        this.f7468ux = iM3176al + 120;
    }

    /* JADX INFO: renamed from: a */
    public boolean m7767a(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull C0805oX c0805oX) {
        if (this.f7472em || !m7765a(c0805oX)) {
            return false;
        }
        if (!this.f7471jM) {
            m7768a(serverPlayer, abstractC0183c);
        }
        C0799oR.m3966a(abstractC0183c, serverPlayer, c0805oX);
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m7768a(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0183c<?> abstractC0183c) {
        this.f7469o = new C0805oX((Player) serverPlayer);
        this.f7470a = serverPlayer.gameMode.getGameModeForPlayer();
        this.f7471jM = true;
        abstractC0183c.m1136a((Player) serverPlayer).m1090Y(true);
        serverPlayer.setInvisible(true);
        serverPlayer.setGameMode(GameType.SPECTATOR);
        C0799oR.m3958a(abstractC0183c, serverPlayer);
    }

    /* JADX INFO: renamed from: b */
    public void m7769b(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0183c<?> abstractC0183c) {
        if (!this.f7472em) {
            return;
        }
        this.f7471jM = true;
        abstractC0183c.m1136a((Player) serverPlayer).m1090Y(true);
        C0799oR.m3958a(abstractC0183c, serverPlayer);
    }

    /* JADX INFO: renamed from: c */
    public void m7770c(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0183c<?> abstractC0183c) {
        m7772a(serverPlayer, abstractC0183c, true);
    }

    /* JADX INFO: renamed from: d */
    public void m7771d(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0183c<?> abstractC0183c) {
        m7772a(serverPlayer, abstractC0183c, false);
    }

    /* JADX INFO: renamed from: a */
    private void m7772a(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0183c<?> abstractC0183c, boolean z) {
        if (!this.f7471jM) {
            m7774dM();
            return;
        }
        this.f7471jM = false;
        abstractC0183c.m1136a((Player) serverPlayer).m1090Y(false);
        C0799oR.m3959b(abstractC0183c, serverPlayer);
        if (!this.f7472em) {
            serverPlayer.setInvisible(false);
            if (this.f7470a != null) {
                serverPlayer.setGameMode(this.f7470a);
            }
            if (z && this.f7469o != null) {
                C0799oR.m3966a(abstractC0183c, serverPlayer, this.f7469o);
            }
        }
        this.f7469o = null;
        this.f7470a = null;
        m7774dM();
    }

    /* JADX INFO: renamed from: e */
    public void m7773e(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0183c<?> abstractC0183c) {
        if (this.f7468ux > 0) {
            this.f7468ux--;
            if (this.f7468ux == 0) {
                m7770c(serverPlayer, abstractC0183c);
            }
        }
    }

    /* JADX INFO: renamed from: dM */
    private void m7774dM() {
        this.f7467ad.clear();
        this.f7468ux = 0;
        this.f7472em = false;
    }

    /* JADX INFO: renamed from: du */
    public boolean m7775du() {
        return this.f7468ux > 0;
    }
}
