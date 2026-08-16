package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sM.class */
public class C1007sM extends AbstractC1056tH<C1001sG, C1005sK> implements InterfaceC1054tF<C1001sG, C1005sK> {

    /* JADX INFO: renamed from: sS */
    public static final int f5564sS = 8;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final C0873pl f5565f = new C0873pl(0, 8).m4326a(8);

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5312a(@NotNull C1057tI<C1001sG, C1005sK> c1057tI) {
        C0875pn.m4392a(c1057tI.m5872b(), c1057tI.m5874m());
        C0875pn.m4436a((AbstractC0863pb<?, ?, ?>) c1057tI.m5869c(), (Component) Component.translatable("bf.message.gamemode.of.intermission").withColor(ColorReferences.COLOR_STOPWATCH), 80, "of.intermission");
        ((C1001sG) c1057tI.m5869c()).m5634a(c1057tI.m5871b(), c1057tI.m5873a(), c1057tI.m5872b());
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: b */
    public void mo5313b(@NotNull C1057tI<C1001sG, C1005sK> c1057tI) {
        this.f5565f.m4328c(c1057tI.m5874m());
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public boolean mo5314a(@NotNull C1057tI<C1001sG, C1005sK> c1057tI) {
        return !this.f5565f.m4332bC();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: e */
    public void mo5605e(@NotNull C1057tI<C1001sG, C1005sK> c1057tI) {
        C0875pn.m4393b(c1057tI.m5872b(), c1057tI.m5874m());
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1056tH<C1001sG, C1005sK> mo5319a(@NotNull C1001sG c1001sG) {
        return new C1009sO(2);
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
        return this.f5565f;
    }
}
