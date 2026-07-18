package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sN.class */
public class C1007sN extends AbstractC1084tk<C0994sA, C0996sC> implements InterfaceC1082ti<C0994sA, C0996sC> {

    /* JADX INFO: renamed from: j */
    private final C0797oP f5280j = new C0797oP(5, 0).m3890a(15);

    /* JADX INFO: renamed from: k */
    private final C0797oP f5281k = new C0797oP(0, 15).m3890a(5);

    /* JADX INFO: renamed from: hi */
    private boolean f5282hi = false;

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5141a(@NotNull C1085tl<C0994sA, C0996sC> c1085tl) {
        C0994sA c0994sA = (C0994sA) c1085tl.m5989c();
        Set<UUID> setM5994m = c1085tl.m5994m();
        Iterator<UUID> it = setM5994m.iterator();
        while (it.hasNext()) {
            C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) c0994sA, it.next(), C1089tp.f5702s, 0);
        }
        c0994sA.m5435c(c1085tl.m5993a(), setM5994m);
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: b */
    public void mo5142b(@NotNull C1085tl<C0994sA, C0996sC> c1085tl) {
        Set<UUID> setM5994m = c1085tl.m5994m();
        this.f5280j.m3892c(setM5994m);
        if (!this.f5282hi) {
            EnumC1005sL enumC1005sLM5437a = ((C0994sA) c1085tl.m5989c()).m5437a();
            if (!this.f5280j.m3896bs()) {
                enumC1005sLM5437a = EnumC1005sL.GOOD;
            }
            if (enumC1005sLM5437a != null) {
                m5470a(c1085tl, enumC1005sLM5437a);
                this.f5282hi = true;
                return;
            }
            return;
        }
        this.f5281k.m3892c(setM5994m);
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public boolean mo5143a(@NotNull C1085tl<C0994sA, C0996sC> c1085tl) {
        return !this.f5281k.m3896bs();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: e */
    public void mo5222e(@NotNull C1085tl<C0994sA, C0996sC> c1085tl) {
        C0994sA c0994sA = (C0994sA) c1085tl.m5989c();
        c0994sA.m5433a((Level) c1085tl.m5993a(), c1085tl.m5994m());
        C0799oR.m3922a(c1085tl.m5993a(), c0994sA, (AbstractC0790oI<?>) c1085tl.m5990c());
        c0994sA.f5263rb++;
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1084tk<C0994sA, C0996sC> mo5148a(@NotNull C0994sA c0994sA) {
        return c0994sA.f5263rb >= 10 ? new C1006sM() : new C1008sO();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0795oN mo5145a() {
        return EnumC0795oN.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC1082ti
    /* JADX INFO: renamed from: a */
    public C0797oP mo5202a(@NotNull C0994sA c0994sA) {
        return this.f5282hi ? this.f5281k : this.f5280j;
    }

    /* JADX INFO: renamed from: a */
    public void m5470a(@NotNull C1085tl<C0994sA, C0996sC> c1085tl, @NotNull EnumC1005sL enumC1005sL) {
        C0994sA c0994sA = (C0994sA) c1085tl.m5989c();
        c0994sA.m5433a((Level) c1085tl.m5993a(), c1085tl.m5994m());
        C0799oR.m3922a(c1085tl.m5993a(), c0994sA, (AbstractC0790oI<?>) c1085tl.m5990c());
        C0799oR.m3934a(c0994sA, (SoundEvent) enumC1005sL.getWinSound().get(), SoundSource.MUSIC);
        C0799oR.m3983a((AbstractC0787oF<?, ?, ?>) c0994sA, (Component) Component.empty(), (Component) Component.empty());
        C0799oR.m3984a((AbstractC0787oF<?, ?, ?>) c0994sA, (Component) Component.empty(), "/c " + String.valueOf(ChatFormatting.WHITE) + String.valueOf(ChatFormatting.BOLD) + c0994sA.getDisplayName().getString());
        C0799oR.m3983a((AbstractC0787oF<?, ?, ?>) c0994sA, (Component) Component.empty(), (Component) Component.literal("/c " + enumC1005sL.getName() + " Won!").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(enumC1005sL.getColor()))).withStyle(ChatFormatting.BOLD));
        C0799oR.m3983a((AbstractC0787oF<?, ?, ?>) c0994sA, (Component) Component.empty(), (Component) Component.empty());
    }
}
