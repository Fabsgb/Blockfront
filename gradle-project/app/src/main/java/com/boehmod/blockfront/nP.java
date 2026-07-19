package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0376ny;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nP.class */
public class nP<V extends AbstractC0376ny> {
    final V c;

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0236it<V> d;

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0236it<V> e;

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0236it<V> f;

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0236it<V> g;

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public C0236it<V> h;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> an = C0624xc.ri;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> ao = C0624xc.rj;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> ap = C0624xc.rk;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aq = C0624xc.rn;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> ar = C0624xc.ro;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> as = C0624xc.rp;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> at = C0624xc.rB;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> au = C0624xc.rC;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> av = C0624xc.rA;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aw = C0624xc.rx;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> ax = C0624xc.ry;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> ay = C0624xc.rz;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> az = C0624xc.rv;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aA = C0624xc.rw;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aB = C0624xc.ru;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aC = C0624xc.rr;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aD = C0624xc.rs;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aE = C0624xc.rt;
    public DeferredHolder<SoundEvent, SoundEvent> aF = C0624xc.rm;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aG = null;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aH = null;
    private boolean fB = false;
    private boolean fC = true;
    private boolean fD = false;
    private boolean fE = true;

    public nP(@NotNull V v) {
        this.c = v;
    }

    public nP<V> a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.aG = deferredHolder;
        this.aH = deferredHolder2;
        return this;
    }

    public nP<V> b(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.an = deferredHolder;
        this.ao = deferredHolder2;
        return this;
    }

    public nP<V> a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.ap = deferredHolder;
        return this;
    }

    public nP<V> c(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.at = deferredHolder;
        this.au = deferredHolder2;
        return this;
    }

    public nP<V> b(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.av = deferredHolder;
        return this;
    }

    public nP<V> d(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.av = deferredHolder;
        this.aB = deferredHolder2;
        return this;
    }

    public nP<V> a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder3, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder4, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder5, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder6) {
        this.aw = deferredHolder;
        this.aC = deferredHolder2;
        this.ay = deferredHolder5;
        this.aE = deferredHolder6;
        this.ax = deferredHolder3;
        this.aD = deferredHolder4;
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    public void z(@NotNull Minecraft minecraft) {
        RandomSource randomSourceCreate = RandomSource.create();
        y(minecraft);
        SoundManager soundManager = minecraft.getSoundManager();
        boolean zAR = this.c.aR();
        boolean z = this.c.aS() || this.c.aT();
        if (zAR) {
            this.fC = false;
            if (!this.fB) {
                this.fB = true;
                if (this.at != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.at.get(), SoundSource.NEUTRAL, 2.5f, 1.0f, this.c, randomSourceCreate.nextLong()));
                }
                if (this.az != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.az.get(), SoundSource.NEUTRAL, 6.0f, 1.0f, this.c, randomSourceCreate.nextLong()));
                }
            }
        } else {
            this.fB = false;
            if (!this.fC) {
                this.fC = true;
                if (this.au != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.au.get(), SoundSource.NEUTRAL, 2.5f, 1.0f, this.c, randomSourceCreate.nextLong()));
                }
                if (this.aA != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.aA.get(), SoundSource.NEUTRAL, 6.0f, 1.0f, this.c, randomSourceCreate.nextLong()));
                }
            }
        }
        if (z) {
            this.fE = false;
            if (!this.fD) {
                this.fD = true;
                if (this.ax != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.ax.get(), SoundSource.NEUTRAL, 2.5f, 1.0f, this.c, randomSourceCreate.nextLong()));
                }
                if (this.aD != null) {
                    soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.aD.get(), SoundSource.NEUTRAL, 6.0f, 1.0f, this.c, randomSourceCreate.nextLong()));
                    return;
                }
                return;
            }
            return;
        }
        this.fD = false;
        if (!this.fE) {
            this.fE = true;
            if (this.ay != null) {
                soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.ay.get(), SoundSource.NEUTRAL, 2.5f, 1.0f, this.c, randomSourceCreate.nextLong()));
            }
            if (this.aE != null) {
                soundManager.play(new EntityBoundSoundInstance((SoundEvent) this.aE.get(), SoundSource.NEUTRAL, 6.0f, 1.0f, this.c, randomSourceCreate.nextLong()));
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void y(@NotNull Minecraft minecraft) {
        SoundManager soundManager = minecraft.getSoundManager();
        Vec3 vec3Position = this.c.position();
        if (this.av != null && (this.d == null || !soundManager.isActive(this.d))) {
            C0236it<V> c0236it = new C0236it<>(this.c, false, false, false, true, (SoundEvent) this.av.get(), vec3Position, 2.5f, 1.0f);
            this.d = c0236it;
            soundManager.play(c0236it);
        }
        if (this.aw != null && (this.e == null || !soundManager.isActive(this.e))) {
            C0236it<V> c0236it2 = new C0236it<>(this.c, true, false, false, true, (SoundEvent) this.aw.get(), vec3Position, 2.5f, 1.0f);
            this.e = c0236it2;
            soundManager.play(c0236it2);
        }
        if (this.aF != null && (this.h == null || !soundManager.isActive(this.h))) {
            C0236it<V> c0236it3 = new C0236it<>(this.c, false, false, true, true, (SoundEvent) this.aF.get(), vec3Position, 2.5f, 1.0f);
            this.h = c0236it3;
            soundManager.play(c0236it3);
        }
        if (this.aB != null && (this.f == null || !soundManager.isActive(this.f))) {
            C0236it<V> c0236it4 = new C0236it<>(this.c, false, false, false, true, (SoundEvent) this.aB.get(), vec3Position, 6.0f, 1.0f);
            this.f = c0236it4;
            soundManager.play(c0236it4);
        }
        if (this.aC != null) {
            if (this.g == null || !soundManager.isActive(this.g)) {
                C0236it<V> c0236it5 = new C0236it<>(this.c, true, false, false, true, (SoundEvent) this.aC.get(), vec3Position, 6.0f, 1.0f);
                this.g = c0236it5;
                soundManager.play(c0236it5);
            }
        }
    }
}
