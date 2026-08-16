package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
import java.util.Set;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sO.class */
public class C1009sO extends AbstractC1056tH<C1001sG, C1005sK> implements InterfaceC1054tF<C1001sG, C1005sK> {

    /* JADX INFO: renamed from: sV */
    private final int f5569sV;

    /* JADX INFO: renamed from: sW */
    private static final int f5571sW = 5;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final C0873pl f5570h = new C0873pl(15, 0).m4326a(20);

    /* JADX INFO: renamed from: sX */
    private int f5572sX = 15;

    /* JADX INFO: renamed from: hx */
    private boolean f5573hx = false;

    public C1009sO(int i) {
        this.f5569sV = i;
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5312a(@NotNull C1057tI<C1001sG, C1005sK> c1057tI) {
        C1001sG c1001sG = (C1001sG) c1057tI.m5869c();
        MutableComponent mutableComponentLiteral = Component.literal(Integer.toString(this.f5569sV));
        C0872pk c0872pkM5637f = c1001sG.m5637f();
        C0872pk c0872pkM5638g = c1001sG.m5638g();
        if (c0872pkM5637f != null) {
            C0875pn.m4427a((AbstractC0866pe<?>) c1057tI.m5870c(), c0872pkM5637f, (Component) Component.translatable("bf.message.gamemode.of.round.attack", new Object[]{mutableComponentLiteral}).withStyle(c0872pkM5637f.m4312a()), 80, "of.round");
        }
        if (c0872pkM5638g != null) {
            C0875pn.m4427a((AbstractC0866pe<?>) c1057tI.m5870c(), c0872pkM5638g, (Component) Component.translatable("bf.message.gamemode.of.round.defend", new Object[]{mutableComponentLiteral}).withStyle(c0872pkM5638g.m4312a()), 80, "of.round");
        }
        C0875pn.m4361a(c1057tI.m5874m(), C0502il.m2254a().m2255a(EnumC1203vw.START).m2259a(5));
        if (c0872pkM5637f != null) {
            C0875pn.m4392a(c1057tI.m5872b(), c0872pkM5637f.m4308h());
        }
        c1001sG.m5648H(this.f5572sX);
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: b */
    public void mo5313b(@NotNull C1057tI<C1001sG, C1005sK> c1057tI) {
        C1001sG c1001sG = (C1001sG) c1057tI.m5869c();
        Set<UUID> setM5874m = c1057tI.m5874m();
        AbstractC0184c<?> abstractC0184cM5872b = c1057tI.m5872b();
        if (this.f5572sX > 0) {
            c1001sG.m5648H(this.f5572sX);
            if (this.f5572sX <= 5) {
                C0873pl.m4329a(setM5874m, this.f5573hx);
                this.f5573hx = !this.f5573hx;
            }
            this.f5572sX--;
            return;
        }
        if (c1001sG.m5647bZ() > 0) {
            c1001sG.m5648H(0);
            c1001sG.m5617i(c1057tI.m5873a());
        }
        this.f5570h.m4328c(setM5874m);
        C0875pn.m4393b(abstractC0184cM5872b, setM5874m);
        c1001sG.m5616c(c1057tI.m5871b(), abstractC0184cM5872b, c1057tI.m5873a(), setM5874m);
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public boolean mo5314a(@NotNull C1057tI<C1001sG, C1005sK> c1057tI) {
        return ((C1001sG) c1057tI.m5869c()).m5631bX() || !this.f5570h.m4332bC();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: e */
    public void mo5605e(@NotNull C1057tI<C1001sG, C1005sK> c1057tI) {
        ((C1001sG) c1057tI.m5869c()).m5633dc();
        ((C1001sG) c1057tI.m5869c()).m5622db();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1056tH<C1001sG, C1005sK> mo5319a(@NotNull C1001sG c1001sG) {
        return new C1008sN(this.f5569sV);
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
        return this.f5570h;
    }
}
