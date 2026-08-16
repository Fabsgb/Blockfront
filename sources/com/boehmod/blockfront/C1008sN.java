package com.boehmod.blockfront;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sN.class */
public class C1008sN extends AbstractC1056tH<C1001sG, C1005sK> implements InterfaceC1054tF<C1001sG, C1005sK> {

    /* JADX INFO: renamed from: sT */
    public static final int f5566sT = 10;

    /* JADX INFO: renamed from: sU */
    private final int f5567sU;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final C0873pl f5568g = new C0873pl(0, 10);

    public C1008sN(int i) {
        this.f5567sU = i;
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5312a(@NotNull C1057tI<C1001sG, C1005sK> c1057tI) {
        C1001sG c1001sG = (C1001sG) c1057tI.m5869c();
        C0875pn.m4392a(c1057tI.m5872b(), c1057tI.m5874m());
        boolean zM5632bY = c1001sG.m5632bY();
        C0872pk c0872pkM5637f = zM5632bY ? c1001sG.m5637f() : c1001sG.m5638g();
        C0872pk c0872pkM5638g = zM5632bY ? c1001sG.m5638g() : c1001sG.m5637f();
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.of.round.won").withStyle(new ChatFormatting[]{ChatFormatting.GREEN, ChatFormatting.BOLD});
        MutableComponent mutableComponentWithStyle2 = Component.translatable("bf.message.gamemode.of.round.lost").withStyle(new ChatFormatting[]{ChatFormatting.RED, ChatFormatting.BOLD});
        if (c0872pkM5637f != null) {
            C0875pn.m4427a((AbstractC0866pe<?>) c1057tI.m5870c(), c0872pkM5637f, (Component) mutableComponentWithStyle, 200, "of.roundend");
            C0875pn.m4372a(((C1005sK) c1057tI.m5870c()).m4249a(c0872pkM5637f, EnumC0877pp.ALL), (SoundEvent) C1312xz.f8003pY.get(), SoundSource.MASTER, 1.0f, 1.0f);
        }
        if (c0872pkM5638g != null) {
            C0875pn.m4427a((AbstractC0866pe<?>) c1057tI.m5870c(), c0872pkM5638g, (Component) mutableComponentWithStyle2, 200, "of.roundend");
            C0875pn.m4372a(((C1005sK) c1057tI.m5870c()).m4249a(c0872pkM5638g, EnumC0877pp.ALL), (SoundEvent) C1312xz.f8031qA.get(), SoundSource.MASTER, 1.0f, 1.0f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: b */
    public void mo5313b(@NotNull C1057tI<C1001sG, C1005sK> c1057tI) {
        this.f5568g.m4328c(c1057tI.m5874m());
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public boolean mo5314a(@NotNull C1057tI<C1001sG, C1005sK> c1057tI) {
        return !this.f5568g.m4332bC();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1056tH<C1001sG, C1005sK> mo5319a(@NotNull C1001sG c1001sG) {
        return this.f5567sU >= 2 ? new C1006sL() : new C1007sM();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0871pj mo5316a() {
        return EnumC0871pj.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC1054tF
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0873pl mo5608a(@NotNull C1001sG c1001sG) {
        return this.f5568g;
    }
}
