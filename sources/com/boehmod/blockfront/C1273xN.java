package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.xN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xN.class */
public final class C1273xN {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C1274xO f7474b;

    /* JADX INFO: renamed from: cd */
    private boolean f7475cd = false;

    /* JADX INFO: renamed from: H */
    private long f7476H = 0;

    /* JADX INFO: renamed from: ce */
    private boolean f7477ce = false;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C1136uj f7478a = null;

    public C1273xN(@NotNull C1274xO c1274xO) {
        this.f7474b = c1274xO;
    }

    /* JADX INFO: renamed from: a */
    public void m7776a(@NotNull C1136uj c1136uj, boolean z, long j) {
        this.f7475cd = true;
        this.f7478a = c1136uj;
        this.f7477ce = z;
        this.f7476H = j;
    }

    /* JADX INFO: renamed from: J */
    public boolean m7777J() {
        return this.f7475cd;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1136uj m7778a() {
        return this.f7478a;
    }

    /* JADX INFO: renamed from: a */
    public int m7779a(long j) {
        return (int) (j - this.f7476H);
    }

    /* JADX INFO: renamed from: e */
    public void m7780e() {
        this.f7475cd = false;
        this.f7478a = null;
    }

    /* JADX INFO: renamed from: a */
    public void m7781a(@NotNull C1300xw c1300xw, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        if (!this.f7475cd || this.f7478a == null) {
            return;
        }
        if (serverPlayer.getMainHandItem().getItem() != this.f7478a || this.f7474b.m1093dm() || C0799oR.m4052a((Player) serverPlayer, (AbstractC0182b<?, ?, ?, ?>) this.f7474b)) {
            m7780e();
            return;
        }
        int iMo6250ab = this.f7478a.mo6250ab();
        if (m7779a(serverLevel.getGameTime()) >= iMo6250ab) {
            C1136uj c1136uj = this.f7478a;
            boolean z = this.f7477ce;
            m7780e();
            c1136uj.m6268a(c1300xw.m7950a(), serverPlayer.getMainHandItem(), (Level) serverLevel, serverPlayer, z, iMo6250ab);
        }
    }
}
