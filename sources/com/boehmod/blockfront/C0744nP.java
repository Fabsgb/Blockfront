package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0779ny;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.nP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nP.class */
public class C0744nP<V extends AbstractC0779ny> {

    /* JADX INFO: renamed from: c */
    final V f4028c;

    /* JADX INFO: renamed from: d */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0509it<V> f4050d;

    /* JADX INFO: renamed from: e */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0509it<V> f4051e;

    /* JADX INFO: renamed from: f */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0509it<V> f4052f;

    /* JADX INFO: renamed from: g */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0509it<V> f4053g;

    /* JADX INFO: renamed from: h */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0509it<V> f4054h;

    /* JADX INFO: renamed from: an */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4029an = C1280xc.f7655ri;

    /* JADX INFO: renamed from: ao */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4030ao = C1280xc.f7656rj;

    /* JADX INFO: renamed from: ap */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4031ap = C1280xc.f7657rk;

    /* JADX INFO: renamed from: aq */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4032aq = C1280xc.f7660rn;

    /* JADX INFO: renamed from: ar */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4033ar = C1280xc.f7661ro;

    /* JADX INFO: renamed from: as */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4034as = C1280xc.f7662rp;

    /* JADX INFO: renamed from: at */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4035at = C1280xc.f7674rB;

    /* JADX INFO: renamed from: au */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4036au = C1280xc.f7675rC;

    /* JADX INFO: renamed from: av */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4037av = C1280xc.f7673rA;

    /* JADX INFO: renamed from: aw */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4038aw = C1280xc.f7670rx;

    /* JADX INFO: renamed from: ax */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4039ax = C1280xc.f7671ry;

    /* JADX INFO: renamed from: ay */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4040ay = C1280xc.f7672rz;

    /* JADX INFO: renamed from: az */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4041az = C1280xc.f7668rv;

    /* JADX INFO: renamed from: aA */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4042aA = C1280xc.f7669rw;

    /* JADX INFO: renamed from: aB */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4043aB = C1280xc.f7667ru;

    /* JADX INFO: renamed from: aC */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4044aC = C1280xc.f7664rr;

    /* JADX INFO: renamed from: aD */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4045aD = C1280xc.f7665rs;

    /* JADX INFO: renamed from: aE */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4046aE = C1280xc.f7666rt;

    /* JADX INFO: renamed from: aF */
    public DeferredHolder<SoundEvent, SoundEvent> f4047aF = C1280xc.f7659rm;

    /* JADX INFO: renamed from: aG */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4048aG = null;

    /* JADX INFO: renamed from: aH */
    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f4049aH = null;

    /* JADX INFO: renamed from: fB */
    private boolean f4055fB = false;

    /* JADX INFO: renamed from: fC */
    private boolean f4056fC = true;

    /* JADX INFO: renamed from: fD */
    private boolean f4057fD = false;

    /* JADX INFO: renamed from: fE */
    private boolean f4058fE = true;

    public C0744nP(@NotNull V v) {
        this.f4028c = v;
    }

    /* JADX INFO: renamed from: a */
    public C0744nP<V> mo3413a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f4048aG = deferredHolder;
        this.f4049aH = deferredHolder2;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0744nP<V> m3416b(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f4029an = deferredHolder;
        this.f4030ao = deferredHolder2;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0744nP<V> mo3412a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f4031ap = deferredHolder;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C0744nP<V> m3417c(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f4035at = deferredHolder;
        this.f4036au = deferredHolder2;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0744nP<V> m3418b(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f4037av = deferredHolder;
        return this;
    }

    /* JADX INFO: renamed from: d */
    public C0744nP<V> m3419d(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.f4037av = deferredHolder;
        this.f4043aB = deferredHolder2;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0744nP<V> m3420a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder3, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder4, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder5, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder6) {
        this.f4038aw = deferredHolder;
        this.f4044aC = deferredHolder2;
        this.f4040ay = deferredHolder5;
        this.f4046aE = deferredHolder6;
        this.f4039ax = deferredHolder3;
        this.f4045aD = deferredHolder4;
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: z */
    public void m3421z(@NotNull Minecraft minecraft) {
        RandomSource randomSourceCreate = RandomSource.create();
        mo3415y(minecraft);
        SoundManager soundManager = minecraft.getSoundManager();
        boolean zM3510aR = this.f4028c.m3510aR();
        boolean z = this.f4028c.m3521aS() || this.f4028c.m3523aT();
        if (zM3510aR) {
            this.f4056fC = false;
            if (!this.f4055fB) {
                this.f4055fB = true;
                if (this.f4035at != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.f4035at.get(), SoundSource.NEUTRAL, 2.5f, 1.0f, this.f4028c, randomSourceCreate.nextLong()));
                }
                if (this.f4041az != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.f4041az.get(), SoundSource.NEUTRAL, 6.0f, 1.0f, this.f4028c, randomSourceCreate.nextLong()));
                }
            }
        } else {
            this.f4055fB = false;
            if (!this.f4056fC) {
                this.f4056fC = true;
                if (this.f4036au != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.f4036au.get(), SoundSource.NEUTRAL, 2.5f, 1.0f, this.f4028c, randomSourceCreate.nextLong()));
                }
                if (this.f4042aA != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.f4042aA.get(), SoundSource.NEUTRAL, 6.0f, 1.0f, this.f4028c, randomSourceCreate.nextLong()));
                }
            }
        }
        if (z) {
            this.f4058fE = false;
            if (!this.f4057fD) {
                this.f4057fD = true;
                if (this.f4039ax != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.f4039ax.get(), SoundSource.NEUTRAL, 2.5f, 1.0f, this.f4028c, randomSourceCreate.nextLong()));
                }
                if (this.f4045aD != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.f4045aD.get(), SoundSource.NEUTRAL, 6.0f, 1.0f, this.f4028c, randomSourceCreate.nextLong()));
                    return;
                }
                return;
            }
            return;
        }
        this.f4057fD = false;
        if (!this.f4058fE) {
            this.f4058fE = true;
            if (this.f4040ay != null) {
                soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.f4040ay.get(), SoundSource.NEUTRAL, 2.5f, 1.0f, this.f4028c, randomSourceCreate.nextLong()));
            }
            if (this.f4046aE != null) {
                soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.f4046aE.get(), SoundSource.NEUTRAL, 6.0f, 1.0f, this.f4028c, randomSourceCreate.nextLong()));
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: y */
    public void mo3415y(@NotNull Minecraft minecraft) {
        SoundManager soundManager = minecraft.getSoundManager();
        Vec3 vec3Position = this.f4028c.position();
        if (this.f4037av != null && (this.f4050d == null || !soundManager.isActive(this.f4050d))) {
            C0509it<V> c0509it = new C0509it<>(this.f4028c, false, false, false, true, (SoundEvent) this.f4037av.get(), vec3Position, 2.5f, 1.0f);
            this.f4050d = c0509it;
            soundManager.play(c0509it);
        }
        if (this.f4038aw != null && (this.f4051e == null || !soundManager.isActive(this.f4051e))) {
            C0509it<V> c0509it2 = new C0509it<>(this.f4028c, true, false, false, true, (SoundEvent) this.f4038aw.get(), vec3Position, 2.5f, 1.0f);
            this.f4051e = c0509it2;
            soundManager.play(c0509it2);
        }
        if (this.f4047aF != null && (this.f4054h == null || !soundManager.isActive(this.f4054h))) {
            C0509it<V> c0509it3 = new C0509it<>(this.f4028c, false, false, true, true, (SoundEvent) this.f4047aF.get(), vec3Position, 2.5f, 1.0f);
            this.f4054h = c0509it3;
            soundManager.play(c0509it3);
        }
        if (this.f4043aB != null && (this.f4052f == null || !soundManager.isActive(this.f4052f))) {
            C0509it<V> c0509it4 = new C0509it<>(this.f4028c, false, false, false, true, (SoundEvent) this.f4043aB.get(), vec3Position, 6.0f, 1.0f);
            this.f4052f = c0509it4;
            soundManager.play(c0509it4);
        }
        if (this.f4044aC != null) {
            if (this.f4053g == null || !soundManager.isActive(this.f4053g)) {
                C0509it<V> c0509it5 = new C0509it<>(this.f4028c, true, false, false, true, (SoundEvent) this.f4044aC.get(), vec3Position, 6.0f, 1.0f);
                this.f4053g = c0509it5;
                soundManager.play(c0509it5);
            }
        }
    }
}
