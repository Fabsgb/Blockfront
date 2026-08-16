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

/* JADX INFO: renamed from: com.boehmod.blockfront.ok */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ok.class */
public class C0819ok extends C0820ol<AbstractC0752nW> {

    /* JADX INFO: renamed from: Z */
    public DeferredHolder<SoundEvent, SoundEvent> f4439Z;

    /* JADX INFO: renamed from: aa */
    public DeferredHolder<SoundEvent, SoundEvent> f4440aa;

    /* JADX INFO: renamed from: ab */
    public DeferredHolder<SoundEvent, SoundEvent> f4441ab;

    /* JADX INFO: renamed from: ac */
    public DeferredHolder<SoundEvent, SoundEvent> f4442ac;

    /* JADX INFO: renamed from: ad */
    public DeferredHolder<SoundEvent, SoundEvent> f4443ad;

    /* JADX INFO: renamed from: ae */
    public DeferredHolder<SoundEvent, SoundEvent> f4444ae;

    /* JADX INFO: renamed from: af */
    public DeferredHolder<SoundEvent, SoundEvent> f4445af;

    /* JADX INFO: renamed from: ag */
    public DeferredHolder<SoundEvent, SoundEvent> f4446ag;

    /* JADX INFO: renamed from: ah */
    public DeferredHolder<SoundEvent, SoundEvent> f4447ah;

    /* JADX INFO: renamed from: ai */
    public DeferredHolder<SoundEvent, SoundEvent> f4448ai;

    /* JADX INFO: renamed from: aj */
    public DeferredHolder<SoundEvent, SoundEvent> f4449aj;

    /* JADX INFO: renamed from: ak */
    public DeferredHolder<SoundEvent, SoundEvent> f4450ak;

    /* JADX INFO: renamed from: al */
    public DeferredHolder<SoundEvent, SoundEvent> f4451al;

    /* JADX INFO: renamed from: am */
    public DeferredHolder<SoundEvent, SoundEvent> f4452am;

    /* JADX INFO: renamed from: b */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0475iK<AbstractC0752nW> f4453b;

    /* JADX INFO: renamed from: c */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0475iK<AbstractC0752nW> f4454c;

    /* JADX INFO: renamed from: a */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0476iL<AbstractC0752nW> f4455a;

    public C0819ok(AbstractC0752nW abstractC0752nW) {
        super(abstractC0752nW);
        this.f4439Z = C1312xz.f8089rG;
        this.f4440aa = C1312xz.f8090rH;
        this.f4441ab = C1312xz.f8091rI;
        this.f4442ac = C1312xz.f8074rr;
        this.f4443ad = C1312xz.f8093rK;
        this.f4444ae = C1312xz.f8094rL;
        this.f4445af = C1312xz.f8095rM;
        this.f4446ag = C1312xz.f8096rN;
        this.f4447ah = C1312xz.f8092rJ;
        this.f4448ai = C1312xz.f8064rh;
        this.f4449aj = C1312xz.f8065ri;
        this.f4450ak = C1312xz.f8087rE;
        this.f4451al = C1312xz.f8088rF;
        this.f4452am = C1312xz.f8127ss;
    }

    /* JADX INFO: renamed from: a */
    public C0819ok m3783a(DeferredHolder<SoundEvent, SoundEvent> deferredHolder, DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, DeferredHolder<SoundEvent, SoundEvent> deferredHolder3, DeferredHolder<SoundEvent, SoundEvent> deferredHolder4) {
        this.f4443ad = deferredHolder;
        this.f4444ae = deferredHolder2;
        this.f4445af = deferredHolder3;
        this.f4446ag = deferredHolder4;
        return this;
    }

    @Override // com.boehmod.blockfront.C0820ol
    /* JADX INFO: renamed from: a */
    public C0819ok mo3784a(DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f4447ah = deferredHolder;
        return this;
    }

    @Override // com.boehmod.blockfront.C0820ol
    /* JADX INFO: renamed from: a */
    public C0819ok mo3785a(DeferredHolder<SoundEvent, SoundEvent> deferredHolder, DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f4450ak = deferredHolder;
        this.f4451al = deferredHolder2;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0819ok m3786b(DeferredHolder<SoundEvent, SoundEvent> deferredHolder, DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, DeferredHolder<SoundEvent, SoundEvent> deferredHolder3, DeferredHolder<SoundEvent, SoundEvent> deferredHolder4) {
        this.f4439Z = deferredHolder;
        this.f4440aa = deferredHolder2;
        this.f4441ab = deferredHolder3;
        this.f4447ah = deferredHolder4;
        return this;
    }

    @Override // com.boehmod.blockfront.C0820ol
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: A */
    public void mo3787A(@NotNull Minecraft minecraft) {
        super.mo3787A(minecraft);
        C0809oa c0809oaB = ((AbstractC0752nW) this.f4456c).m3431b();
        Vec3 vec3Position = ((AbstractC0752nW) this.f4456c).position();
        SoundManager soundManager = minecraft.getSoundManager();
        Iterator it = c0809oaB.f4373ar.iterator();
        while (it.hasNext()) {
            ((AbstractC0818oj) it.next()).mo3768A(minecraft);
        }
        if (this.f4450ak != null && (this.f4453b == null || !soundManager.isActive(this.f4453b))) {
            C0475iK<AbstractC0752nW> c0475iK = new C0475iK<>((AbstractC0752nW) this.f4456c, true, false, false, true, (SoundEvent) this.f4450ak.get(), vec3Position, 2.5f, 1.0f);
            this.f4453b = c0475iK;
            soundManager.play(c0475iK);
        }
        if (this.f4451al != null && (this.f4454c == null || !soundManager.isActive(this.f4454c))) {
            C0475iK<AbstractC0752nW> c0475iK2 = new C0475iK<>((AbstractC0752nW) this.f4456c, false, true, false, true, (SoundEvent) this.f4451al.get(), vec3Position, 2.5f, 1.0f);
            this.f4454c = c0475iK2;
            soundManager.play(c0475iK2);
        }
        if (this.f4452am != null) {
            if (this.f4455a == null || !soundManager.isActive(this.f4455a)) {
                C0476iL<AbstractC0752nW> c0476iL = new C0476iL<>((AbstractC0752nW) this.f4456c, (SoundEvent) this.f4452am.get(), vec3Position, 2.5f, 1.0f);
                this.f4455a = c0476iL;
                soundManager.play(c0476iL);
            }
        }
    }
}
