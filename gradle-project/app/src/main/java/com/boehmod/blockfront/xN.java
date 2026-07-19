package com.boehmod.blockfront;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xN.class */
public final class xN {

    @NotNull
    private final xO b;
    private boolean cd = false;
    private long H = 0;
    private boolean ce = false;

    @Nullable
    private C0550uj a = null;

    public xN(@NotNull xO xOVar) {
        this.b = xOVar;
    }

    public void a(@NotNull C0550uj c0550uj, boolean z, long j) {
        this.cd = true;
        this.a = c0550uj;
        this.ce = z;
        this.H = j;
    }

    public boolean J() {
        return this.cd;
    }

    @Nullable
    public C0550uj a() {
        return this.a;
    }

    public int a(long j) {
        return (int) (j - this.H);
    }

    public void e() {
        this.cd = false;
        this.a = null;
    }

    public void a(@NotNull xw xwVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        if (!this.cd || this.a == null) {
            return;
        }
        if (serverPlayer.getMainHandItem().getItem() != this.a || this.b.dm() || oR.a((Player) serverPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) this.b)) {
            e();
            return;
        }
        int iAb = this.a.ab();
        if (a(serverLevel.getGameTime()) >= iAb) {
            C0550uj c0550uj = this.a;
            boolean z = this.ce;
            e();
            c0550uj.a(xwVar.a(), serverPlayer.getMainHandItem(), (Level) serverLevel, serverPlayer, z, iAb);
        }
    }
}
