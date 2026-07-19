package com.boehmod.blockfront;

import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tg.class */
public abstract class AbstractC0520tg<G extends oF<G, P, ?>, P extends oI<G>> extends AbstractC0521th<G, P> {
    static final /* synthetic */ boolean hy;

    static {
        hy = !AbstractC0520tg.class.desiredAssertionStatus();
    }

    public AbstractC0520tg(int i) {
        super(i);
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void e(@NotNull C0525tl<G, P> c0525tl) {
        oF<?, ?, ?> oFVarC = c0525tl.c();
        oI oIVarM1161c = c0525tl.m1161c();
        com.boehmod.blockfront.common.player.c<?> cVarM1162b = c0525tl.m1162b();
        oR.b(cVarM1162b, c0525tl.m());
        oO oOVarA = oIVarM1161c.a(C0529tp.da);
        oO oOVarA2 = oIVarM1161c.a(C0529tp.cZ);
        if (!hy && oOVarA == null) {
            throw new AssertionError();
        }
        if (!hy && oOVarA2 == null) {
            throw new AssertionError();
        }
        oOVarA.a(cVarM1162b, oFVarC);
        oOVarA2.a(cVarM1162b, oFVarC);
        d(c0525tl);
        f(c0525tl);
        oR.a(c0525tl.a(), c0525tl.m(), cVarM1162b);
    }

    protected void d(@NotNull C0525tl<G, P> c0525tl) {
    }

    protected void f(@NotNull C0525tl<G, P> c0525tl) {
        oR.a(c0525tl.a(), (oF<?, ?, ?>) c0525tl.c(), c0525tl.m());
    }

    protected final void g(@NotNull C0525tl<G, P> c0525tl) {
        oF<?, ?, ?> oFVarC = c0525tl.c();
        oI oIVarM1161c = c0525tl.m1161c();
        ServerLevel serverLevelA = c0525tl.a();
        oO oOVarA = oIVarM1161c.a(C0529tp.da);
        oO oOVarA2 = oIVarM1161c.a(C0529tp.cZ);
        if (!hy && oOVarA == null) {
            throw new AssertionError();
        }
        if (!hy && oOVarA2 == null) {
            throw new AssertionError();
        }
        BlockPos blockPosC = ((oX) oOVarA2.B().getFirst()).c();
        sU sUVarA = oOVarA2.a(oFVarC).m1156a().a();
        if (sUVarA != null && sUVarA.j() != null) {
            serverLevelA.playSound((Player) null, blockPosC, (SoundEvent) sUVarA.j().get(), SoundSource.PLAYERS, 5.0f, 1.0f);
        }
        BlockPos blockPosC2 = ((oX) oOVarA.B().getFirst()).c();
        sU sUVarA2 = oOVarA.a(oFVarC).m1156a().a();
        if (sUVarA2 != null && sUVarA2.j() != null) {
            serverLevelA.playSound((Player) null, blockPosC2, (SoundEvent) sUVarA2.j().get(), SoundSource.PLAYERS, 5.0f, 1.0f);
        }
        oX oXVarC = oIVarM1161c.c();
        if (oXVarC != null) {
            serverLevelA.playSound((Player) null, oXVarC.c(), (SoundEvent) C0624xc.Es.get(), SoundSource.AMBIENT, 30.0f, 1.0f);
        }
    }
}
