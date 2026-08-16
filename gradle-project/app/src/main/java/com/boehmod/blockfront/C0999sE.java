package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sE.class */
public class C0999sE extends AbstractC1056tH<C1040ss, C1042su> implements InterfaceC1054tF<C1040ss, C1042su> {

    /* JADX INFO: renamed from: e */
    @NotNull
    private final C0873pl f5488e = new C0873pl(0, 25).m4326a(10);

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: b */
    public void mo5313b(@NotNull C1057tI<C1040ss, C1042su> c1057tI) {
        C1040ss c1040ss = (C1040ss) c1057tI.m5869c();
        ServerLevel serverLevelM5873a = c1057tI.m5873a();
        Set<UUID> setM5874m = c1057tI.m5874m();
        c1040ss.m5789a("main").ifPresent(c1047sz -> {
            c1047sz.m5856R(true);
        });
        C0875pn.m4393b(c1057tI.m5872b(), setM5874m);
        if (!c1040ss.m5795a(serverLevelM5873a) && c1040ss.m5800a(serverLevelM5873a).isEmpty()) {
            this.f5488e.m4328c(setM5874m);
            if (!this.f5488e.m4332bC()) {
                c1040ss.m5797b(serverLevelM5873a, setM5874m);
                this.f5488e.m4327cG();
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public boolean mo5314a(@NotNull C1057tI<C1040ss, C1042su> c1057tI) {
        return ((C1042su) c1057tI.m5870c()).mo4260a(c1057tI.m5873a(), c1057tI.m5874m(), this.f5488e) != null;
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: e */
    public void mo5605e(@NotNull C1057tI<C1040ss, C1042su> c1057tI) {
        C1040ss c1040ss = (C1040ss) c1057tI.m5869c();
        Set<UUID> setM5874m = c1057tI.m5874m();
        C0875pn.m4369a(setM5874m, (SoundEvent) C1312xz.f8017qm.get(), SoundSource.MASTER);
        C0887pz c0887pzMo4260a = ((C1042su) c1057tI.m5870c()).mo4260a(c1057tI.m5873a(), setM5874m, this.f5488e);
        if (c0887pzMo4260a != null) {
            c1040ss.m4010a(c1057tI.m5873a(), c1057tI.m5871b(), C1062tN.f5748l, true, c0887pzMo4260a, setM5874m);
            if (c0887pzMo4260a.f4866p != null) {
                Iterator<UUID> it = c0887pzMo4260a.f4866p.iterator();
                while (it.hasNext()) {
                    C0875pn.m4450a(c1057tI.m5871b(), c1040ss, it.next(), C1062tN.f5779Q);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1056tH<C1040ss, C1042su> mo5319a(@NotNull C1040ss c1040ss) {
        return new C0998sD();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0871pj mo5316a() {
        return EnumC0871pj.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC1054tF
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0873pl mo5608a(@NotNull C1040ss c1040ss) {
        return this.f5488e;
    }
}
