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

/* JADX INFO: renamed from: com.boehmod.blockfront.tk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tk.class */
public class C1085tk extends AbstractC1056tH<C1018sX, C1020sZ> implements InterfaceC1054tF<C1018sX, C1020sZ> {

    /* JADX INFO: renamed from: j */
    private final C0873pl f5844j = new C0873pl(5, 0).m4326a(15);

    /* JADX INFO: renamed from: k */
    private final C0873pl f5845k = new C0873pl(0, 15).m4326a(5);

    /* JADX INFO: renamed from: hC */
    private boolean f5846hC = false;

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5312a(@NotNull C1057tI<C1018sX, C1020sZ> c1057tI) {
        C1018sX c1018sX = (C1018sX) c1057tI.m5869c();
        Set<UUID> setM5874m = c1057tI.m5874m();
        Iterator<UUID> it = setM5874m.iterator();
        while (it.hasNext()) {
            C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) c1018sX, it.next(), C1062tN.f5755s, 0);
        }
        c1018sX.m5713c(c1057tI.m5873a(), setM5874m);
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: b */
    public void mo5313b(@NotNull C1057tI<C1018sX, C1020sZ> c1057tI) {
        Set<UUID> setM5874m = c1057tI.m5874m();
        this.f5844j.m4328c(setM5874m);
        if (!this.f5846hC) {
            EnumC1083ti enumC1083tiM5715a = ((C1018sX) c1057tI.m5869c()).m5715a();
            if (!this.f5844j.m4332bC()) {
                enumC1083tiM5715a = EnumC1083ti.GOOD;
            }
            if (enumC1083tiM5715a != null) {
                m5958a(c1057tI, enumC1083tiM5715a);
                this.f5846hC = true;
                return;
            }
            return;
        }
        this.f5845k.m4328c(setM5874m);
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public boolean mo5314a(@NotNull C1057tI<C1018sX, C1020sZ> c1057tI) {
        return !this.f5845k.m4332bC();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: e */
    public void mo5605e(@NotNull C1057tI<C1018sX, C1020sZ> c1057tI) {
        C1018sX c1018sX = (C1018sX) c1057tI.m5869c();
        c1018sX.m5711a((Level) c1057tI.m5873a(), c1057tI.m5874m());
        C0875pn.m4358a(c1057tI.m5873a(), c1018sX, (AbstractC0866pe<?>) c1057tI.m5870c());
        c1018sX.f5592tc++;
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1056tH<C1018sX, C1020sZ> mo5319a(@NotNull C1018sX c1018sX) {
        return c1018sX.f5592tc >= 10 ? new C1084tj() : new C1086tl();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0871pj mo5316a() {
        return EnumC0871pj.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC1054tF
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0873pl mo5608a(@NotNull C1018sX c1018sX) {
        return this.f5846hC ? this.f5845k : this.f5844j;
    }

    /* JADX INFO: renamed from: a */
    public void m5958a(@NotNull C1057tI<C1018sX, C1020sZ> c1057tI, @NotNull EnumC1083ti enumC1083ti) {
        C1018sX c1018sX = (C1018sX) c1057tI.m5869c();
        c1018sX.m5711a((Level) c1057tI.m5873a(), c1057tI.m5874m());
        C0875pn.m4358a(c1057tI.m5873a(), c1018sX, (AbstractC0866pe<?>) c1057tI.m5870c());
        C0875pn.m4370a(c1018sX, (SoundEvent) enumC1083ti.getWinSound().get(), SoundSource.MUSIC);
        C0875pn.m4419a((AbstractC0863pb<?, ?, ?>) c1018sX, (Component) Component.empty(), (Component) Component.empty());
        C0875pn.m4420a((AbstractC0863pb<?, ?, ?>) c1018sX, (Component) Component.empty(), "/c " + String.valueOf(ChatFormatting.WHITE) + String.valueOf(ChatFormatting.BOLD) + c1018sX.getDisplayName().getString());
        C0875pn.m4419a((AbstractC0863pb<?, ?, ?>) c1018sX, (Component) Component.empty(), (Component) Component.literal("/c " + enumC1083ti.getName() + " Won!").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(enumC1083ti.getColor()))).withStyle(ChatFormatting.BOLD));
        C0875pn.m4419a((AbstractC0863pb<?, ?, ?>) c1018sX, (Component) Component.empty(), (Component) Component.empty());
    }
}
