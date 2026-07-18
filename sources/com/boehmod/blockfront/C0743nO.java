package com.boehmod.blockfront;

import java.util.Iterator;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nO.class */
public class C0743nO extends C0744nP<AbstractC0729nA> {

    /* JADX INFO: renamed from: Z */
    public DeferredHolder<SoundEvent, SoundEvent> f4011Z;

    /* JADX INFO: renamed from: aa */
    public DeferredHolder<SoundEvent, SoundEvent> f4012aa;

    /* JADX INFO: renamed from: ab */
    public DeferredHolder<SoundEvent, SoundEvent> f4013ab;

    /* JADX INFO: renamed from: ac */
    public DeferredHolder<SoundEvent, SoundEvent> f4014ac;

    /* JADX INFO: renamed from: ad */
    public DeferredHolder<SoundEvent, SoundEvent> f4015ad;

    /* JADX INFO: renamed from: ae */
    public DeferredHolder<SoundEvent, SoundEvent> f4016ae;

    /* JADX INFO: renamed from: af */
    public DeferredHolder<SoundEvent, SoundEvent> f4017af;

    /* JADX INFO: renamed from: ag */
    public DeferredHolder<SoundEvent, SoundEvent> f4018ag;

    /* JADX INFO: renamed from: ah */
    public DeferredHolder<SoundEvent, SoundEvent> f4019ah;

    /* JADX INFO: renamed from: ai */
    public DeferredHolder<SoundEvent, SoundEvent> f4020ai;

    /* JADX INFO: renamed from: aj */
    public DeferredHolder<SoundEvent, SoundEvent> f4021aj;

    /* JADX INFO: renamed from: ak */
    public DeferredHolder<SoundEvent, SoundEvent> f4022ak;

    /* JADX INFO: renamed from: al */
    public DeferredHolder<SoundEvent, SoundEvent> f4023al;

    /* JADX INFO: renamed from: am */
    public DeferredHolder<SoundEvent, SoundEvent> f4024am;

    /* JADX INFO: renamed from: b */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0509it<AbstractC0729nA> f4025b;

    /* JADX INFO: renamed from: c */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0509it<AbstractC0729nA> f4026c;

    /* JADX INFO: renamed from: a */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0510iu<AbstractC0729nA> f4027a;

    public C0743nO(AbstractC0729nA abstractC0729nA) {
        super(abstractC0729nA);
        this.f4011Z = C1280xc.f7678rF;
        this.f4012aa = C1280xc.f7679rG;
        this.f4013ab = C1280xc.f7680rH;
        this.f4014ac = C1280xc.f7663rq;
        this.f4015ad = C1280xc.f7682rJ;
        this.f4016ae = C1280xc.f7683rK;
        this.f4017af = C1280xc.f7684rL;
        this.f4018ag = C1280xc.f7685rM;
        this.f4019ah = C1280xc.f7681rI;
        this.f4020ai = C1280xc.f7653rg;
        this.f4021aj = C1280xc.f7654rh;
        this.f4022ak = C1280xc.f7676rD;
        this.f4023al = C1280xc.f7677rE;
        this.f4024am = C1280xc.f7716sr;
    }

    /* JADX INFO: renamed from: a */
    public C0743nO m3411a(DeferredHolder<SoundEvent, SoundEvent> deferredHolder, DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, DeferredHolder<SoundEvent, SoundEvent> deferredHolder3, DeferredHolder<SoundEvent, SoundEvent> deferredHolder4) {
        this.f4015ad = deferredHolder;
        this.f4016ae = deferredHolder2;
        this.f4017af = deferredHolder3;
        this.f4018ag = deferredHolder4;
        return this;
    }

    @Override // com.boehmod.blockfront.C0744nP
    /* JADX INFO: renamed from: a */
    public C0743nO mo3412a(DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f4019ah = deferredHolder;
        return this;
    }

    @Override // com.boehmod.blockfront.C0744nP
    /* JADX INFO: renamed from: a */
    public C0743nO mo3413a(DeferredHolder<SoundEvent, SoundEvent> deferredHolder, DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f4022ak = deferredHolder;
        this.f4023al = deferredHolder2;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0743nO m3414b(DeferredHolder<SoundEvent, SoundEvent> deferredHolder, DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, DeferredHolder<SoundEvent, SoundEvent> deferredHolder3, DeferredHolder<SoundEvent, SoundEvent> deferredHolder4) {
        this.f4011Z = deferredHolder;
        this.f4012aa = deferredHolder2;
        this.f4013ab = deferredHolder3;
        this.f4019ah = deferredHolder4;
        return this;
    }

    @Override // com.boehmod.blockfront.C0744nP
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: y */
    public void mo3415y(@NotNull Minecraft minecraft) {
        super.mo3415y(minecraft);
        C0733nE c0733nEB = ((AbstractC0729nA) this.f4028c).m3498b();
        Vec3 vec3Position = ((AbstractC0729nA) this.f4028c).position();
        SoundManager soundManager = minecraft.getSoundManager();
        Iterator it = c0733nEB.f3945ak.iterator();
        while (it.hasNext()) {
            ((AbstractC0742nN) it.next()).mo3396y(minecraft);
        }
        if (this.f4022ak != null && (this.f4025b == null || !soundManager.isActive(this.f4025b))) {
            C0509it<AbstractC0729nA> c0509it = new C0509it<>((AbstractC0729nA) this.f4028c, true, false, false, true, (SoundEvent) this.f4022ak.get(), vec3Position, 2.5f, 1.0f);
            this.f4025b = c0509it;
            soundManager.play(c0509it);
        }
        if (this.f4023al != null && (this.f4026c == null || !soundManager.isActive(this.f4026c))) {
            C0509it<AbstractC0729nA> c0509it2 = new C0509it<>((AbstractC0729nA) this.f4028c, false, true, false, true, (SoundEvent) this.f4023al.get(), vec3Position, 2.5f, 1.0f);
            this.f4026c = c0509it2;
            soundManager.play(c0509it2);
        }
        if (this.f4024am != null) {
            if (this.f4027a == null || !soundManager.isActive(this.f4027a)) {
                C0510iu<AbstractC0729nA> c0510iu = new C0510iu<>((AbstractC0729nA) this.f4028c, (SoundEvent) this.f4024am.get(), vec3Position, 2.5f, 1.0f);
                this.f4027a = c0510iu;
                soundManager.play(c0510iu);
            }
        }
    }
}
