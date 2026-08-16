package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0750nU;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.EntityBoundSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ol */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ol.class */
public class C0820ol<V extends AbstractC0750nU> {

    /* JADX INFO: renamed from: c */
    final V f4456c;

    /* JADX INFO: renamed from: d */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0475iK<V> f4478d;

    /* JADX INFO: renamed from: e */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0475iK<V> f4479e;

    /* JADX INFO: renamed from: f */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0475iK<V> f4480f;

    /* JADX INFO: renamed from: g */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0475iK<V> f4481g;

    /* JADX INFO: renamed from: h */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0475iK<V> f4482h;

    /* JADX INFO: renamed from: an */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4457an = C1312xz.f8066rj;

    /* JADX INFO: renamed from: ao */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4458ao = C1312xz.f8067rk;

    /* JADX INFO: renamed from: ap */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4459ap = C1312xz.f8068rl;

    /* JADX INFO: renamed from: aq */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4460aq = C1312xz.f8071ro;

    /* JADX INFO: renamed from: ar */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4461ar = C1312xz.f8072rp;

    /* JADX INFO: renamed from: as */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4462as = C1312xz.f8073rq;

    /* JADX INFO: renamed from: at */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4463at = C1312xz.f8085rC;

    /* JADX INFO: renamed from: au */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4464au = C1312xz.f8086rD;

    /* JADX INFO: renamed from: av */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4465av = C1312xz.f8084rB;

    /* JADX INFO: renamed from: aw */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4466aw = C1312xz.f8081ry;

    /* JADX INFO: renamed from: ax */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4467ax = C1312xz.f8082rz;

    /* JADX INFO: renamed from: ay */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4468ay = C1312xz.f8083rA;

    /* JADX INFO: renamed from: az */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4469az = C1312xz.f8079rw;

    /* JADX INFO: renamed from: aA */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4470aA = C1312xz.f8080rx;

    /* JADX INFO: renamed from: aB */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4471aB = C1312xz.f8078rv;

    /* JADX INFO: renamed from: aC */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4472aC = C1312xz.f8075rs;

    /* JADX INFO: renamed from: aD */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4473aD = C1312xz.f8076rt;

    /* JADX INFO: renamed from: aE */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4474aE = C1312xz.f8077ru;

    /* JADX INFO: renamed from: aF */
    public DeferredHolder<SoundEvent, SoundEvent> f4475aF = C1312xz.f8070rn;

    /* JADX INFO: renamed from: aG */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4476aG = null;

    /* JADX INFO: renamed from: aH */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4477aH = null;

    /* JADX INFO: renamed from: fV */
    private boolean f4483fV = false;

    /* JADX INFO: renamed from: fW */
    private boolean f4484fW = true;

    /* JADX INFO: renamed from: fX */
    private boolean f4485fX = false;

    /* JADX INFO: renamed from: fY */
    private boolean f4486fY = true;

    public C0820ol(@NotNull V v) {
        this.f4456c = v;
    }

    /* JADX INFO: renamed from: a */
    public C0820ol<V> mo3785a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f4476aG = deferredHolder;
        this.f4477aH = deferredHolder2;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0820ol<V> m3788b(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f4457an = deferredHolder;
        this.f4458ao = deferredHolder2;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0820ol<V> mo3784a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f4459ap = deferredHolder;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C0820ol<V> m3789c(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f4463at = deferredHolder;
        this.f4464au = deferredHolder2;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0820ol<V> m3790b(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f4465av = deferredHolder;
        return this;
    }

    /* JADX INFO: renamed from: d */
    public C0820ol<V> m3791d(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f4465av = deferredHolder;
        this.f4471aB = deferredHolder2;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0820ol<V> m3792a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder3, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder4, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder5, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder6) {
        this.f4466aw = deferredHolder;
        this.f4472aC = deferredHolder2;
        this.f4468ay = deferredHolder5;
        this.f4474aE = deferredHolder6;
        this.f4467ax = deferredHolder3;
        this.f4473aD = deferredHolder4;
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: B */
    public void m3793B(@NotNull Minecraft minecraft) {
        RandomSource randomSourceCreate = RandomSource.create();
        mo3787A(minecraft);
        SoundManager soundManager = minecraft.getSoundManager();
        boolean zM3447bb = this.f4456c.m3447bb();
        boolean z = this.f4456c.m3458bc() || this.f4456c.m3460bd();
        if (zM3447bb) {
            this.f4484fW = false;
            if (!this.f4483fV) {
                this.f4483fV = true;
                if (this.f4463at != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.f4463at.get(), SoundSource.NEUTRAL, 2.5f, 1.0f, this.f4456c, randomSourceCreate.nextLong()));
                }
                if (this.f4469az != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.f4469az.get(), SoundSource.NEUTRAL, 6.0f, 1.0f, this.f4456c, randomSourceCreate.nextLong()));
                }
            }
        } else {
            this.f4483fV = false;
            if (!this.f4484fW) {
                this.f4484fW = true;
                if (this.f4464au != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.f4464au.get(), SoundSource.NEUTRAL, 2.5f, 1.0f, this.f4456c, randomSourceCreate.nextLong()));
                }
                if (this.f4470aA != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.f4470aA.get(), SoundSource.NEUTRAL, 6.0f, 1.0f, this.f4456c, randomSourceCreate.nextLong()));
                }
            }
        }
        if (z) {
            this.f4486fY = false;
            if (!this.f4485fX) {
                this.f4485fX = true;
                if (this.f4467ax != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.f4467ax.get(), SoundSource.NEUTRAL, 2.5f, 1.0f, this.f4456c, randomSourceCreate.nextLong()));
                }
                if (this.f4473aD != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.f4473aD.get(), SoundSource.NEUTRAL, 6.0f, 1.0f, this.f4456c, randomSourceCreate.nextLong()));
                    return;
                }
                return;
            }
            return;
        }
        this.f4485fX = false;
        if (!this.f4486fY) {
            this.f4486fY = true;
            if (this.f4468ay != null) {
                soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.f4468ay.get(), SoundSource.NEUTRAL, 2.5f, 1.0f, this.f4456c, randomSourceCreate.nextLong()));
            }
            if (this.f4474aE != null) {
                soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.f4474aE.get(), SoundSource.NEUTRAL, 6.0f, 1.0f, this.f4456c, randomSourceCreate.nextLong()));
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: A */
    public void mo3787A(@NotNull Minecraft minecraft) {
        SoundManager soundManager = minecraft.getSoundManager();
        Vec3 vec3Position = this.f4456c.position();
        if (this.f4465av != null && (this.f4478d == null || !soundManager.isActive(this.f4478d))) {
            C0475iK<V> c0475iK = new C0475iK<>(this.f4456c, false, false, false, true, (SoundEvent) this.f4465av.get(), vec3Position, 2.5f, 1.0f);
            this.f4478d = c0475iK;
            soundManager.play(c0475iK);
        }
        if (this.f4466aw != null && (this.f4479e == null || !soundManager.isActive(this.f4479e))) {
            C0475iK<V> c0475iK2 = new C0475iK<>(this.f4456c, true, false, false, true, (SoundEvent) this.f4466aw.get(), vec3Position, 2.5f, 1.0f);
            this.f4479e = c0475iK2;
            soundManager.play(c0475iK2);
        }
        if (this.f4475aF != null && (this.f4482h == null || !soundManager.isActive(this.f4482h))) {
            C0475iK<V> c0475iK3 = new C0475iK<>(this.f4456c, false, false, true, true, (SoundEvent) this.f4475aF.get(), vec3Position, 2.5f, 1.0f);
            this.f4482h = c0475iK3;
            soundManager.play(c0475iK3);
        }
        if (this.f4471aB != null && (this.f4480f == null || !soundManager.isActive(this.f4480f))) {
            C0475iK<V> c0475iK4 = new C0475iK<>(this.f4456c, false, false, false, true, (SoundEvent) this.f4471aB.get(), vec3Position, 6.0f, 1.0f);
            this.f4480f = c0475iK4;
            soundManager.play(c0475iK4);
        }
        if (this.f4472aC != null) {
            if (this.f4481g == null || !soundManager.isActive(this.f4481g)) {
                C0475iK<V> c0475iK5 = new C0475iK<>(this.f4456c, true, false, false, true, (SoundEvent) this.f4472aC.get(), vec3Position, 6.0f, 1.0f);
                this.f4481g = c0475iK5;
                soundManager.play(c0475iK5);
            }
        }
    }
}
