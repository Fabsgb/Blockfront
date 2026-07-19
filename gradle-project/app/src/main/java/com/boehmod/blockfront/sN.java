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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sN.class */
public class sN extends AbstractC0524tk<sA, sC> implements InterfaceC0522ti<sA, sC> {
    private final oP j = new oP(5, 0).a(15);
    private final oP k = new oP(0, 15).a(5);
    private boolean hi = false;

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<sA, sC> c0525tl) {
        sA sAVar = (sA) c0525tl.c();
        Set<UUID> setM = c0525tl.m();
        Iterator<UUID> it = setM.iterator();
        while (it.hasNext()) {
            oR.m792a((oF<?, ?, ?>) sAVar, it.next(), C0529tp.s, 0);
        }
        sAVar.c(c0525tl.a(), setM);
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void b(@NotNull C0525tl<sA, sC> c0525tl) {
        Set<UUID> setM = c0525tl.m();
        this.j.c(setM);
        if (!this.hi) {
            sL sLVarM1078a = ((sA) c0525tl.c()).m1078a();
            if (!this.j.bs()) {
                sLVarM1078a = sL.GOOD;
            }
            if (sLVarM1078a != null) {
                a(c0525tl, sLVarM1078a);
                this.hi = true;
                return;
            }
            return;
        }
        this.k.c(setM);
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    /* JADX INFO: renamed from: a */
    public boolean mo1022a(@NotNull C0525tl<sA, sC> c0525tl) {
        return !this.k.bs();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void e(@NotNull C0525tl<sA, sC> c0525tl) {
        sA sAVar = (sA) c0525tl.c();
        sAVar.a((Level) c0525tl.a(), c0525tl.m());
        oR.a(c0525tl.a(), sAVar, (oI<?>) c0525tl.m1161c());
        sAVar.rb++;
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<sA, sC> a(@NotNull sA sAVar) {
        return sAVar.rb >= 10 ? new sM() : new sO();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public oN a() {
        return oN.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC0522ti
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public oP mo1035a(@NotNull sA sAVar) {
        return this.hi ? this.k : this.j;
    }

    public void a(@NotNull C0525tl<sA, sC> c0525tl, @NotNull sL sLVar) {
        sA sAVar = (sA) c0525tl.c();
        sAVar.a((Level) c0525tl.a(), c0525tl.m());
        oR.a(c0525tl.a(), sAVar, (oI<?>) c0525tl.m1161c());
        oR.a(sAVar, (SoundEvent) sLVar.getWinSound().get(), SoundSource.MUSIC);
        oR.a((oF<?, ?, ?>) sAVar, (Component) Component.empty(), (Component) Component.empty());
        oR.a((oF<?, ?, ?>) sAVar, (Component) Component.empty(), "/c " + String.valueOf(ChatFormatting.WHITE) + String.valueOf(ChatFormatting.BOLD) + sAVar.getDisplayName().getString());
        oR.a((oF<?, ?, ?>) sAVar, (Component) Component.empty(), (Component) Component.literal("/c " + sLVar.getName() + " Won!").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(sLVar.getColor()))).withStyle(ChatFormatting.BOLD));
        oR.a((oF<?, ?, ?>) sAVar, (Component) Component.empty(), (Component) Component.empty());
    }
}
