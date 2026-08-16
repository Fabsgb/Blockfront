package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tD.class */
public abstract class AbstractC1052tD<G extends AbstractC0863pb<G, P, ?>, P extends AbstractC0866pe<G>> extends AbstractC1053tE<G, P> {

    /* JADX INFO: renamed from: hS */
    static final /* synthetic */ boolean f5708hS;

    static {
        f5708hS = !AbstractC1052tD.class.desiredAssertionStatus();
    }

    public AbstractC1052tD(int i) {
        super(i);
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: e */
    public void mo5605e(@NotNull C1057tI<G, P> c1057tI) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM5869c = c1057tI.m5869c();
        AbstractC0866pe abstractC0866peM5870c = c1057tI.m5870c();
        AbstractC0184c<?> abstractC0184cM5872b = c1057tI.m5872b();
        C0875pn.m4393b(abstractC0184cM5872b, c1057tI.m5874m());
        C0872pk c0872pkM4242a = abstractC0866peM5870c.m4242a(C1062tN.f5783dl);
        C0872pk c0872pkM4242a2 = abstractC0866peM5870c.m4242a(C1062tN.f5782dk);
        if (!f5708hS && c0872pkM4242a == null) {
            throw new AssertionError();
        }
        if (!f5708hS && c0872pkM4242a2 == null) {
            throw new AssertionError();
        }
        c0872pkM4242a.m4298a(abstractC0184cM5872b, abstractC0863pbM5869c);
        c0872pkM4242a2.m4298a(abstractC0184cM5872b, abstractC0863pbM5869c);
        mo5693d(c1057tI);
        mo5782f(c1057tI);
        C0875pn.m4383a(c1057tI.m5873a(), c1057tI.m5874m(), abstractC0184cM5872b);
    }

    /* JADX INFO: renamed from: d */
    protected void mo5693d(@NotNull C1057tI<G, P> c1057tI) {
    }

    /* JADX INFO: renamed from: f */
    protected void mo5782f(@NotNull C1057tI<G, P> c1057tI) {
        C0875pn.m4463a(c1057tI.m5873a(), (AbstractC0863pb<?, ?, ?>) c1057tI.m5869c(), c1057tI.m5874m());
    }

    /* JADX INFO: renamed from: g */
    protected final void m5868g(@NotNull C1057tI<G, P> c1057tI) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM5869c = c1057tI.m5869c();
        AbstractC0866pe abstractC0866peM5870c = c1057tI.m5870c();
        ServerLevel serverLevelM5873a = c1057tI.m5873a();
        C0872pk c0872pkM4242a = abstractC0866peM5870c.m4242a(C1062tN.f5783dl);
        C0872pk c0872pkM4242a2 = abstractC0866peM5870c.m4242a(C1062tN.f5782dk);
        if (!f5708hS && c0872pkM4242a == null) {
            throw new AssertionError();
        }
        if (!f5708hS && c0872pkM4242a2 == null) {
            throw new AssertionError();
        }
        BlockPos blockPosM4587c = ((C0881pt) c0872pkM4242a2.m4309D().getFirst()).m4587c();
        C1092tr c1092trM6164a = c0872pkM4242a2.m4296a(abstractC0863pbM5869c).m6179a().m6164a();
        if (c1092trM6164a != null && c1092trM6164a.m5997j() != null) {
            serverLevelM5873a.playSound((Player) null, blockPosM4587c, (SoundEvent) c1092trM6164a.m5997j().get(), SoundSource.PLAYERS, 5.0f, 1.0f);
        }
        BlockPos blockPosM4587c2 = ((C0881pt) c0872pkM4242a.m4309D().getFirst()).m4587c();
        C1092tr c1092trM6164a2 = c0872pkM4242a.m4296a(abstractC0863pbM5869c).m6179a().m6164a();
        if (c1092trM6164a2 != null && c1092trM6164a2.m5997j() != null) {
            serverLevelM5873a.playSound((Player) null, blockPosM4587c2, (SoundEvent) c1092trM6164a2.m5997j().get(), SoundSource.PLAYERS, 5.0f, 1.0f);
        }
        C0881pt c0881ptM4226c = abstractC0866peM5870c.m4226c();
        if (c0881ptM4226c != null) {
            serverLevelM5873a.playSound((Player) null, c0881ptM4226c.m4587c(), (SoundEvent) C1312xz.f8754Ev.get(), SoundSource.AMBIENT, 30.0f, 1.0f);
        }
    }
}
