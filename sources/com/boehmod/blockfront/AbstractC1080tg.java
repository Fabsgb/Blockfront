package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tg.class */
public abstract class AbstractC1080tg<G extends AbstractC0787oF<G, P, ?>, P extends AbstractC0790oI<G>> extends AbstractC1081th<G, P> {

    /* JADX INFO: renamed from: hy */
    static final /* synthetic */ boolean f5661hy;

    static {
        f5661hy = !AbstractC1080tg.class.desiredAssertionStatus();
    }

    public AbstractC1080tg(int i) {
        super(i);
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: e */
    public void mo5222e(@NotNull C1085tl<G, P> c1085tl) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFM5989c = c1085tl.m5989c();
        AbstractC0790oI abstractC0790oIM5990c = c1085tl.m5990c();
        AbstractC0183c<?> abstractC0183cM5992b = c1085tl.m5992b();
        C0799oR.m3957b(abstractC0183cM5992b, c1085tl.m5994m());
        C0796oO c0796oOM3806a = abstractC0790oIM5990c.m3806a(C1089tp.f5730da);
        C0796oO c0796oOM3806a2 = abstractC0790oIM5990c.m3806a(C1089tp.f5729cZ);
        if (!f5661hy && c0796oOM3806a == null) {
            throw new AssertionError();
        }
        if (!f5661hy && c0796oOM3806a2 == null) {
            throw new AssertionError();
        }
        c0796oOM3806a.m3862a(abstractC0183cM5992b, abstractC0787oFM5989c);
        c0796oOM3806a2.m3862a(abstractC0183cM5992b, abstractC0787oFM5989c);
        mo5204d(c1085tl);
        mo5245f(c1085tl);
        C0799oR.m3947a(c1085tl.m5993a(), c1085tl.m5994m(), abstractC0183cM5992b);
    }

    /* JADX INFO: renamed from: d */
    protected void mo5204d(@NotNull C1085tl<G, P> c1085tl) {
    }

    /* JADX INFO: renamed from: f */
    protected void mo5245f(@NotNull C1085tl<G, P> c1085tl) {
        C0799oR.m4027a(c1085tl.m5993a(), (AbstractC0787oF<?, ?, ?>) c1085tl.m5989c(), c1085tl.m5994m());
    }

    /* JADX INFO: renamed from: g */
    protected final void m5988g(@NotNull C1085tl<G, P> c1085tl) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFM5989c = c1085tl.m5989c();
        AbstractC0790oI abstractC0790oIM5990c = c1085tl.m5990c();
        ServerLevel serverLevelM5993a = c1085tl.m5993a();
        C0796oO c0796oOM3806a = abstractC0790oIM5990c.m3806a(C1089tp.f5730da);
        C0796oO c0796oOM3806a2 = abstractC0790oIM5990c.m3806a(C1089tp.f5729cZ);
        if (!f5661hy && c0796oOM3806a == null) {
            throw new AssertionError();
        }
        if (!f5661hy && c0796oOM3806a2 == null) {
            throw new AssertionError();
        }
        BlockPos blockPosM4150c = ((C0805oX) c0796oOM3806a2.m3873B().getFirst()).m4150c();
        C1014sU c1014sUM5676a = c0796oOM3806a2.m3860a(abstractC0787oFM5989c).m5976a().m5676a();
        if (c1014sUM5676a != null && c1014sUM5676a.m5509j() != null) {
            serverLevelM5993a.playSound((Player) null, blockPosM4150c, (SoundEvent) c1014sUM5676a.m5509j().get(), SoundSource.PLAYERS, 5.0f, 1.0f);
        }
        BlockPos blockPosM4150c2 = ((C0805oX) c0796oOM3806a.m3873B().getFirst()).m4150c();
        C1014sU c1014sUM5676a2 = c0796oOM3806a.m3860a(abstractC0787oFM5989c).m5976a().m5676a();
        if (c1014sUM5676a2 != null && c1014sUM5676a2.m5509j() != null) {
            serverLevelM5993a.playSound((Player) null, blockPosM4150c2, (SoundEvent) c1014sUM5676a2.m5509j().get(), SoundSource.PLAYERS, 5.0f, 1.0f);
        }
        C0805oX c0805oXM3790c = abstractC0790oIM5990c.m3790c();
        if (c0805oXM3790c != null) {
            serverLevelM5993a.playSound((Player) null, c0805oXM3790c.m4150c(), (SoundEvent) C1280xc.f8341Es.get(), SoundSource.AMBIENT, 30.0f, 1.0f);
        }
    }
}
