package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.yl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/yl.class */
public final class C1325yl {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C1326ym f9058c;

    /* JADX INFO: renamed from: cl */
    private boolean f9059cl = false;

    /* JADX INFO: renamed from: ac */
    private long f9060ac = 0;

    /* JADX INFO: renamed from: cm */
    private boolean f9061cm = false;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C1109uH f9062a = null;

    public C1325yl(@NotNull C1326ym c1326ym) {
        this.f9058c = c1326ym;
    }

    /* JADX INFO: renamed from: a */
    public void m8292a(@NotNull C1109uH c1109uH, boolean z, long j) {
        this.f9059cl = true;
        this.f9062a = c1109uH;
        this.f9061cm = z;
        this.f9060ac = j;
    }

    /* JADX INFO: renamed from: K */
    public boolean m8293K() {
        return this.f9059cl;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1109uH m8294a() {
        return this.f9062a;
    }

    /* JADX INFO: renamed from: b */
    public int m8295b(long j) {
        return (int) (j - this.f9060ac);
    }

    /* JADX INFO: renamed from: e */
    public void m8296e() {
        this.f9059cl = false;
        this.f9062a = null;
    }

    /* JADX INFO: renamed from: a */
    public void m8297a(@NotNull C1280xT c1280xT, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        if (!this.f9059cl || this.f9062a == null) {
            return;
        }
        if (serverPlayer.getMainHandItem().getItem() != this.f9062a || this.f9058c.m1110dv() || C0875pn.m4488a((Player) serverPlayer, (AbstractC0183b<?, ?, ?, ?>) this.f9058c)) {
            m8296e();
            return;
        }
        int iMo6210al = this.f9062a.mo6210al();
        if (m8295b(serverLevel.getGameTime()) >= iMo6210al) {
            C1109uH c1109uH = this.f9062a;
            boolean z = this.f9061cm;
            m8296e();
            c1109uH.m6231a(c1280xT.m7277a(), serverPlayer.getMainHandItem(), (Level) serverLevel, serverPlayer, z, iMo6210al);
        }
    }
}
