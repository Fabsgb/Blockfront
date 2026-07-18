package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
import java.util.Set;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sr.class */
public class C1038sr extends AbstractC1084tk<C1030sj, C1034sn> implements InterfaceC1082ti<C1030sj, C1034sn> {

    /* JADX INFO: renamed from: qU */
    private final int f5522qU;

    /* JADX INFO: renamed from: qV */
    private static final int f5524qV = 5;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final C0797oP f5523h = new C0797oP(15, 0).m3890a(20);

    /* JADX INFO: renamed from: qW */
    private int f5525qW = 15;

    /* JADX INFO: renamed from: hd */
    private boolean f5526hd = false;

    public C1038sr(int i) {
        this.f5522qU = i;
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5141a(@NotNull C1085tl<C1030sj, C1034sn> c1085tl) {
        C1030sj c1030sj = (C1030sj) c1085tl.m5989c();
        MutableComponent mutableComponentLiteral = Component.literal(Integer.toString(this.f5522qU));
        C0796oO c0796oOM5749f = c1030sj.m5749f();
        C0796oO c0796oOM5750g = c1030sj.m5750g();
        if (c0796oOM5749f != null) {
            C0799oR.m3991a((AbstractC0790oI<?>) c1085tl.m5990c(), c0796oOM5749f, (Component) Component.translatable("bf.message.gamemode.of.round.attack", new Object[]{mutableComponentLiteral}).withStyle(c0796oOM5749f.m3876a()), 80, "of.round");
        }
        if (c0796oOM5750g != null) {
            C0799oR.m3991a((AbstractC0790oI<?>) c1085tl.m5990c(), c0796oOM5750g, (Component) Component.translatable("bf.message.gamemode.of.round.defend", new Object[]{mutableComponentLiteral}).withStyle(c0796oOM5750g.m3876a()), 80, "of.round");
        }
        C0799oR.m3925a(c1085tl.m5994m(), C0431hU.m2020a().m2021a(EnumC1123uW.START).m2025a(5));
        if (c0796oOM5749f != null) {
            C0799oR.m3956a(c1085tl.m5992b(), c0796oOM5749f.m3872h());
        }
        c1030sj.m5760G(this.f5525qW);
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: b */
    public void mo5142b(@NotNull C1085tl<C1030sj, C1034sn> c1085tl) {
        C1030sj c1030sj = (C1030sj) c1085tl.m5989c();
        Set<UUID> setM5994m = c1085tl.m5994m();
        AbstractC0183c<?> abstractC0183cM5992b = c1085tl.m5992b();
        if (this.f5525qW > 0) {
            c1030sj.m5760G(this.f5525qW);
            if (this.f5525qW <= 5) {
                C0797oP.m3893a(setM5994m, this.f5526hd);
                this.f5526hd = !this.f5526hd;
            }
            this.f5525qW--;
            return;
        }
        if (c1030sj.m5759bK() > 0) {
            c1030sj.m5760G(0);
            c1030sj.m5729i(c1085tl.m5993a());
        }
        this.f5523h.m3892c(setM5994m);
        C0799oR.m3957b(abstractC0183cM5992b, setM5994m);
        c1030sj.m5728c(c1085tl.m5991b(), abstractC0183cM5992b, c1085tl.m5993a(), setM5994m);
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public boolean mo5143a(@NotNull C1085tl<C1030sj, C1034sn> c1085tl) {
        return ((C1030sj) c1085tl.m5989c()).m5743bN() || !this.f5523h.m3896bs();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: e */
    public void mo5222e(@NotNull C1085tl<C1030sj, C1034sn> c1085tl) {
        ((C1030sj) c1085tl.m5989c()).m5745cQ();
        ((C1030sj) c1085tl.m5989c()).m5734cP();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1084tk<C1030sj, C1034sn> mo5148a(@NotNull C1030sj c1030sj) {
        return new C1037sq(this.f5522qU);
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0795oN mo5145a() {
        return EnumC0795oN.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC1082ti
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0797oP mo5202a(@NotNull C1030sj c1030sj) {
        return this.f5523h;
    }
}
