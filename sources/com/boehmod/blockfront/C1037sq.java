package com.boehmod.blockfront;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sq.class */
public class C1037sq extends AbstractC1084tk<C1030sj, C1034sn> implements InterfaceC1082ti<C1030sj, C1034sn> {

    /* JADX INFO: renamed from: qS */
    public static final int f5519qS = 10;

    /* JADX INFO: renamed from: qT */
    private final int f5520qT;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final C0797oP f5521g = new C0797oP(0, 10);

    public C1037sq(int i) {
        this.f5520qT = i;
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5141a(@NotNull C1085tl<C1030sj, C1034sn> c1085tl) {
        C1030sj c1030sj = (C1030sj) c1085tl.m5989c();
        C0799oR.m3956a(c1085tl.m5992b(), c1085tl.m5994m());
        boolean zM5744bO = c1030sj.m5744bO();
        C0796oO c0796oOM5749f = zM5744bO ? c1030sj.m5749f() : c1030sj.m5750g();
        C0796oO c0796oOM5750g = zM5744bO ? c1030sj.m5750g() : c1030sj.m5749f();
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.of.round.won").withStyle(new ChatFormatting[]{ChatFormatting.GREEN, ChatFormatting.BOLD});
        MutableComponent mutableComponentWithStyle2 = Component.translatable("bf.message.gamemode.of.round.lost").withStyle(new ChatFormatting[]{ChatFormatting.RED, ChatFormatting.BOLD});
        if (c0796oOM5749f != null) {
            C0799oR.m3991a((AbstractC0790oI<?>) c1085tl.m5990c(), c0796oOM5749f, (Component) mutableComponentWithStyle, 200, "of.roundend");
            C0799oR.m3936a(((C1034sn) c1085tl.m5990c()).m3813a(c0796oOM5749f, EnumC0801oT.ALL), (SoundEvent) C1280xc.f7591pW.get(), SoundSource.MASTER, 1.0f, 1.0f);
        }
        if (c0796oOM5750g != null) {
            C0799oR.m3991a((AbstractC0790oI<?>) c1085tl.m5990c(), c0796oOM5750g, (Component) mutableComponentWithStyle2, 200, "of.roundend");
            C0799oR.m3936a(((C1034sn) c1085tl.m5990c()).m3813a(c0796oOM5750g, EnumC0801oT.ALL), (SoundEvent) C1280xc.f7619qy.get(), SoundSource.MASTER, 1.0f, 1.0f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: b */
    public void mo5142b(@NotNull C1085tl<C1030sj, C1034sn> c1085tl) {
        this.f5521g.m3892c(c1085tl.m5994m());
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public boolean mo5143a(@NotNull C1085tl<C1030sj, C1034sn> c1085tl) {
        return !this.f5521g.m3896bs();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1084tk<C1030sj, C1034sn> mo5148a(@NotNull C1030sj c1030sj) {
        return this.f5520qT >= 2 ? new C1035so() : new C1036sp();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0795oN mo5145a() {
        return EnumC0795oN.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC1082ti
    /* JADX INFO: renamed from: a */
    public C0797oP mo5202a(@NotNull C1030sj c1030sj) {
        return this.f5521g;
    }
}
