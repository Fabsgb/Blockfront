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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nO.class */
public class nO extends nP<nA> {
    public DeferredHolder<SoundEvent, SoundEvent> Z;
    public DeferredHolder<SoundEvent, SoundEvent> aa;
    public DeferredHolder<SoundEvent, SoundEvent> ab;
    public DeferredHolder<SoundEvent, SoundEvent> ac;
    public DeferredHolder<SoundEvent, SoundEvent> ad;
    public DeferredHolder<SoundEvent, SoundEvent> ae;
    public DeferredHolder<SoundEvent, SoundEvent> af;
    public DeferredHolder<SoundEvent, SoundEvent> ag;
    public DeferredHolder<SoundEvent, SoundEvent> ah;
    public DeferredHolder<SoundEvent, SoundEvent> ai;
    public DeferredHolder<SoundEvent, SoundEvent> aj;
    public DeferredHolder<SoundEvent, SoundEvent> ak;
    public DeferredHolder<SoundEvent, SoundEvent> al;
    public DeferredHolder<SoundEvent, SoundEvent> am;

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0236it<nA> b;

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0236it<nA> c;

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0237iu<nA> a;

    public nO(nA nAVar) {
        super(nAVar);
        this.Z = C0624xc.rF;
        this.aa = C0624xc.rG;
        this.ab = C0624xc.rH;
        this.ac = C0624xc.rq;
        this.ad = C0624xc.rJ;
        this.ae = C0624xc.rK;
        this.af = C0624xc.rL;
        this.ag = C0624xc.rM;
        this.ah = C0624xc.rI;
        this.ai = C0624xc.rg;
        this.aj = C0624xc.rh;
        this.ak = C0624xc.rD;
        this.al = C0624xc.rE;
        this.am = C0624xc.sr;
    }

    public nO a(DeferredHolder<SoundEvent, SoundEvent> deferredHolder, DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, DeferredHolder<SoundEvent, SoundEvent> deferredHolder3, DeferredHolder<SoundEvent, SoundEvent> deferredHolder4) {
        this.ad = deferredHolder;
        this.ae = deferredHolder2;
        this.af = deferredHolder3;
        this.ag = deferredHolder4;
        return this;
    }

    @Override // com.boehmod.blockfront.nP
    public nO a(DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.ah = deferredHolder;
        return this;
    }

    @Override // com.boehmod.blockfront.nP
    public nO a(DeferredHolder<SoundEvent, SoundEvent> deferredHolder, DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.ak = deferredHolder;
        this.al = deferredHolder2;
        return this;
    }

    public nO b(DeferredHolder<SoundEvent, SoundEvent> deferredHolder, DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, DeferredHolder<SoundEvent, SoundEvent> deferredHolder3, DeferredHolder<SoundEvent, SoundEvent> deferredHolder4) {
        this.Z = deferredHolder;
        this.aa = deferredHolder2;
        this.ab = deferredHolder3;
        this.ah = deferredHolder4;
        return this;
    }

    @Override // com.boehmod.blockfront.nP
    @OnlyIn(Dist.CLIENT)
    public void y(@NotNull Minecraft minecraft) {
        super.y(minecraft);
        nE nEVarB = ((nA) this.c).b();
        Vec3 vec3Position = ((nA) this.c).position();
        SoundManager soundManager = minecraft.getSoundManager();
        Iterator it = nEVarB.ak.iterator();
        while (it.hasNext()) {
            ((nN) it.next()).y(minecraft);
        }
        if (this.ak != null && (this.b == null || !soundManager.isActive(this.b))) {
            C0236it<nA> c0236it = new C0236it<>((nA) this.c, true, false, false, true, (SoundEvent) this.ak.get(), vec3Position, 2.5f, 1.0f);
            this.b = c0236it;
            soundManager.play(c0236it);
        }
        if (this.al != null && (this.c == null || !soundManager.isActive(this.c))) {
            C0236it<nA> c0236it2 = new C0236it<>((nA) this.c, false, true, false, true, (SoundEvent) this.al.get(), vec3Position, 2.5f, 1.0f);
            this.c = c0236it2;
            soundManager.play(c0236it2);
        }
        if (this.am != null) {
            if (this.a == null || !soundManager.isActive(this.a)) {
                C0237iu<nA> c0237iu = new C0237iu<>((nA) this.c, (SoundEvent) this.am.get(), vec3Position, 2.5f, 1.0f);
                this.a = c0237iu;
                soundManager.play(c0237iu);
            }
        }
    }
}
