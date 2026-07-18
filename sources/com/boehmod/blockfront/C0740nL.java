package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0729nA;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.nL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nL.class */
public class C0740nL extends AbstractC0742nN<AbstractC0729nA> {

    /* JADX INFO: renamed from: dE */
    public static final ResourceLocation f3979dE = C0564jv.m2555d("textures/misc/debug/vehicle_tank.png");

    /* JADX INFO: renamed from: fv */
    public boolean f3980fv;

    /* JADX INFO: renamed from: K */
    @Nullable
    public C0417hG f3981K;

    /* JADX INFO: renamed from: L */
    @Nullable
    public C0417hG f3982L;

    /* JADX INFO: renamed from: jV */
    public float f3983jV;

    /* JADX INFO: renamed from: a */
    @Nullable
    public EntityType<? extends C0760nf> f3984a;

    /* JADX INFO: renamed from: a */
    @OnlyIn(Dist.CLIENT)
    public C0509it<AbstractC0729nA> f3985a;

    /* JADX INFO: renamed from: jW */
    public float f3986jW;

    /* JADX INFO: renamed from: jX */
    public float f3987jX;

    /* JADX INFO: renamed from: jY */
    private float f3988jY;

    /* JADX INFO: renamed from: jZ */
    private static final float f3989jZ = 3.0f;

    /* JADX INFO: renamed from: ka */
    private static final float f3990ka = 0.01f;

    /* JADX INFO: renamed from: kb */
    private static final float f3991kb = 7.0f;

    /* JADX INFO: renamed from: fw */
    protected boolean f3992fw;

    /* JADX INFO: renamed from: fx */
    protected boolean f3993fx;

    /* JADX INFO: renamed from: kc */
    private float f3994kc;

    /* JADX INFO: renamed from: kd */
    private float f3995kd;

    /* JADX INFO: renamed from: mj */
    private int f3996mj;

    /* JADX INFO: renamed from: fy */
    public boolean f3997fy;

    /* JADX INFO: renamed from: jy */
    public float f3998jy;

    /* JADX INFO: renamed from: jz */
    public float f3999jz;

    /* JADX INFO: renamed from: mk */
    private int f4000mk;

    /* JADX INFO: renamed from: a */
    private EnumC0741nM f4001a;

    /* JADX INFO: renamed from: Y */
    private DeferredHolder<Item, ? extends C1144ur> f4002Y;

    /* JADX INFO: renamed from: ml */
    public int f4003ml;

    /* JADX INFO: renamed from: fz */
    public boolean f4004fz;

    /* JADX INFO: renamed from: fA */
    public boolean f4005fA;

    public C0740nL(@NotNull String str, @NotNull AbstractC0729nA abstractC0729nA) {
        super(str, abstractC0729nA);
        this.f3981K = C0418hH.f2672o;
        this.f3982L = C0418hH.f2673p;
        this.f3983jV = 1.5f;
        this.f3984a = (EntityType) C1230wX.f7052kV.get();
        this.f3987jX = 0.0f;
        this.f3988jY = 10.0f;
        this.f3992fw = false;
        this.f3993fx = false;
        this.f3995kd = 0.0f;
        this.f3996mj = 0;
        this.f3997fy = false;
        this.f3998jy = 75.0f;
        this.f3999jz = 105.0f;
        this.f4000mk = 1;
        this.f4001a = EnumC0741nM.SHELL;
        this.f4002Y = C1231wY.f7189lA;
        this.f4003ml = 0;
        this.f4004fz = false;
        this.f4005fA = true;
    }

    /* JADX INFO: renamed from: a */
    public C0740nL m3380a(float f, float f2) {
        this.f3997fy = true;
        this.f3998jy = f;
        this.f3999jz = f2;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0740nL m3381a(@NotNull EnumC0741nM enumC0741nM) {
        this.f4001a = enumC0741nM;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0740nL m3382a(@NotNull DeferredHolder<Item, ? extends C1144ur> deferredHolder) {
        this.f4002Y = deferredHolder;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0742nN
    /* JADX INFO: renamed from: a */
    public C0740nL mo3383a(int i) {
        this.f4000mk = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0740nL m3384a(@NotNull Vector3f vector3f) {
        this.f4009e = vector3f;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0740nL m3385a(EntityType<? extends C0760nf> entityType) {
        this.f3984a = entityType;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0740nL m3386a() {
        this.f3980fv = true;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0740nL m3387a(float f) {
        this.f3983jV = f;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0740nL m3388a(@Nullable C0417hG c0417hG, @Nullable C0417hG c0417hG2) {
        this.f3981K = c0417hG;
        this.f3982L = c0417hG2;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0740nL m3389b(float f) {
        this.f3988jY = f;
        return this;
    }

    /* JADX INFO: renamed from: aD */
    public float m3390aD() {
        return this.f3988jY;
    }

    /* JADX INFO: renamed from: a */
    public EnumC0741nM m3391a() {
        return this.f4001a;
    }

    /* JADX INFO: renamed from: c */
    public DeferredHolder<Item, ? extends C1144ur> m3392c() {
        return this.f4002Y;
    }

    /* JADX INFO: renamed from: aP */
    public int m3393aP() {
        return this.f3996mj;
    }

    @Override // com.boehmod.blockfront.AbstractC0742nN
    /* JADX INFO: renamed from: a */
    public void mo3407c(@NotNull AbstractC0729nA abstractC0729nA) {
    }

    @Override // com.boehmod.blockfront.AbstractC0742nN
    /* JADX INFO: renamed from: b */
    public void mo3406f(@NotNull AbstractC0729nA abstractC0729nA) {
        this.f3995kd = this.f3994kc;
        this.f3994kc = Mth.lerp(0.2f, this.f3994kc, 0.0f);
        if (this.f3996mj > 0) {
            this.f3996mj--;
        }
        if (this.f4003ml > 0) {
            this.f4003ml--;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0742nN
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: y */
    public void mo3396y(@NotNull Minecraft minecraft) {
        SoundManager soundManager = minecraft.getSoundManager();
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = ((AbstractC0729nA) this.f4010a).mo3293a().f4011Z;
        Vec3 vec3Position = ((AbstractC0729nA) this.f4010a).position();
        if (deferredHolder != null) {
            if (this.f3985a == null || !soundManager.isActive(this.f3985a)) {
                C0507ir c0507ir = new C0507ir((AbstractC0729nA) this.f4010a, this, (SoundEvent) deferredHolder.get(), 2.5f, 1.0f, vec3Position);
                this.f3985a = c0507ir;
                soundManager.play(c0507ir);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0742nN
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo3397x() {
        return f3979dE;
    }

    @Override // com.boehmod.blockfront.AbstractC0742nN
    /* JADX INFO: renamed from: w */
    public float mo3398w(float f) {
        return C1290xm.m7843e(this.f3986jW, this.f3987jX, f);
    }

    /* JADX INFO: renamed from: c */
    public void m3399c(@NotNull Level level) {
        this.f3994kc = 1.0f;
        EnumC0741nM enumC0741nMM3391a = m3391a();
        if (enumC0741nMM3391a != EnumC0741nM.SHELL) {
            if (enumC0741nMM3391a == EnumC0741nM.BULLET) {
                this.f3996mj = 1;
            }
        } else {
            this.f3996mj = 2;
            Vec3 vec3Position = ((AbstractC0729nA) this.f4010a).position();
            C0799oR.m4044a(level, (ParticleOptions) C1232wZ.f7321nW.get(), vec3Position.add(0.0d, 0.10000000149011612d, 0.0d), 2.0d, 8.0d, 40, 0.25f);
            C0799oR.m4044a(level, (ParticleOptions) ParticleTypes.CLOUD, vec3Position.add(0.0d, 0.10000000149011612d, 0.0d), 2.0d, 8.0d, 60, 0.25f);
            C0799oR.m4044a(level, (ParticleOptions) C1232wZ.f7301nC.get(), vec3Position.add(0.0d, 0.10000000149011612d, 0.0d), 2.0d, 8.0d, 60, 0.5f);
        }
    }

    /* JADX INFO: renamed from: x */
    public float m3400x(float f) {
        return this.f3988jY * C1290xm.m7843e(this.f3994kc, this.f3995kd, f);
    }

    /* JADX INFO: renamed from: a */
    public void m3401a(@NotNull EntityDataAccessor<Float> entityDataAccessor) {
        float f;
        SynchedEntityData entityData = ((AbstractC0729nA) this.f4010a).getEntityData();
        float fFloatValue = ((Float) entityData.get(entityDataAccessor)).floatValue();
        this.f3987jX = this.f3986jW;
        this.f3986jW = fFloatValue;
        C0743nO c0743nOMo3293a = ((AbstractC0729nA) this.f4010a).mo3293a();
        boolean z = false;
        boolean z2 = false;
        Entity entityB = m3410b();
        if (entityB != null && this.f3980fv) {
            float yRot = ((AbstractC0729nA) this.f4010a).getYRot();
            float yRot2 = (yRot - entityB.getYRot()) + fFloatValue;
            while (true) {
                f = yRot2;
                if (f <= 180.0f) {
                    break;
                } else {
                    yRot2 = f - 360.0f;
                }
            }
            while (f < -180.0f) {
                f += 360.0f;
            }
            float fMin = Math.min(this.f3983jV, Math.abs(f)) * Math.signum(f);
            if (Math.abs(f) > f3990ka) {
                z = true;
                float fClamp = fFloatValue - fMin;
                if (this.f3997fy) {
                    float f2 = yRot * 0.017453292f;
                    fClamp = Mth.clamp(fClamp, f2 - this.f3998jy, f2 + this.f3998jy);
                }
                entityData.set(entityDataAccessor, Float.valueOf(fClamp));
            }
            z2 = Math.abs(f) > 3.0f;
        }
        if (!z) {
            this.f3992fw = false;
            if (c0743nOMo3293a.f4013ab != null && !this.f3993fx) {
                this.f3993fx = true;
                ((AbstractC0729nA) this.f4010a).playSound((SoundEvent) c0743nOMo3293a.f4013ab.get(), 1.5f, 1.0f);
            }
        } else if (z2) {
            this.f3993fx = false;
            if (c0743nOMo3293a.f4012aa != null && !this.f3992fw) {
                this.f3992fw = true;
                ((AbstractC0729nA) this.f4010a).playSound((SoundEvent) c0743nOMo3293a.f4012aa.get(), 1.5f, 1.0f);
            }
        }
        ((AbstractC0729nA) this.f4010a).m3290a(this).m3300a(((AbstractC0729nA) this.f4010a).getEntityData(), z2 && z);
    }

    /* JADX INFO: renamed from: b */
    public void m3402b(@NotNull EntityDataAccessor<Float> entityDataAccessor) {
        this.f3987jX = this.f3986jW;
        this.f3986jW = ((Float) ((AbstractC0729nA) this.f4010a).getEntityData().get(entityDataAccessor)).floatValue();
    }

    /* JADX INFO: renamed from: b */
    public void m3403b(@NotNull ServerPlayer serverPlayer) {
        C1194vo.m6649b(new C1235wc(((AbstractC0729nA) this.f4010a).getId(), this.f4006bD));
        C1194vo.m6649b(new C1210wD(new ItemStack(this.f4002Y), serverPlayer.position(), serverPlayer.getId(), false));
    }

    /* JADX INFO: renamed from: c */
    public void m3404c(@NotNull ServerPlayer serverPlayer) {
        AbstractC0729nA.a aVarM3290a;
        SynchedEntityData entityData;
        int iM3297a;
        Level level;
        C0760nf c0760nfCreate;
        if (this.f3984a != null && (iM3297a = (aVarM3290a = ((AbstractC0729nA) this.f4010a).m3290a(this)).m3297a((entityData = ((AbstractC0729nA) this.f4010a).getEntityData()))) > 0 && ((AbstractC0729nA) this.f4010a).f3905mf <= 0 && (c0760nfCreate = this.f3984a.create((level = ((AbstractC0729nA) this.f4010a).level()))) != null) {
            List passengers = ((AbstractC0729nA) this.f4010a).getPassengers();
            C0733nE c0733nEB = ((AbstractC0729nA) this.f4010a).m3498b();
            C0743nO c0743nOMo3293a = ((AbstractC0729nA) this.f4010a).mo3293a();
            ((AbstractC0729nA) this.f4010a).f3905mf = c0733nEB.f3951mi;
            float fAE = m3409aE();
            float yRot = ((AbstractC0729nA) this.f4010a).getYRot();
            Vec3 vec3Position = ((AbstractC0729nA) this.f4010a).position();
            Vector3f vector3fRotateY = new Vector3f(this.f4009e).rotateY((-yRot) * 0.017453292f);
            float f = yRot + fAE;
            float xRot = serverPlayer.getXRot();
            float yRot2 = serverPlayer.getYRot();
            if (Math.abs(Math.abs(yRot2 - f)) < 15.0f) {
                f = yRot2;
            }
            c0760nfCreate.m3432a(serverPlayer, vec3Position.add(vector3fRotateY.x, vector3fRotateY.y, vector3fRotateY.z).add((-Mth.sin(f * 0.017453292f)) * 4.0f, (-Mth.sin(r0 * 0.017453292f)) * 4.0f, Mth.cos(f * 0.017453292f) * 4.0f), new ItemStack(((Block) C1218wL.f6745hZ.get()).asItem()), 7.0f, f, xRot + (6.0f * ((AbstractC0729nA) this.f4010a).mo3293a().m3308aA()));
            c0760nfCreate.setNoGravity(true);
            level.addFreshEntity(c0760nfCreate);
            ((AbstractC0729nA) this.f4010a).playSound((SoundEvent) c0743nOMo3293a.f4019ah.get(), 2.0f, 1.0f);
            ((AbstractC0729nA) this.f4010a).playSound((SoundEvent) c0743nOMo3293a.f4015ad.get(), 3.0f, 1.0f);
            ((AbstractC0729nA) this.f4010a).playSound((SoundEvent) c0743nOMo3293a.f4018ag.get(), 3.0f, 1.0f);
            ((AbstractC0729nA) this.f4010a).playSound((SoundEvent) c0743nOMo3293a.f4016ae.get(), 3.0f, 1.0f);
            ((AbstractC0729nA) this.f4010a).playSound((SoundEvent) c0743nOMo3293a.f4017af.get(), 8.0f, 1.0f);
            for (int i = 0; i < 2; i++) {
                ((AbstractC0729nA) this.f4010a).playSound((SoundEvent) C1280xc.f8392Fr.get(), 6.0f, 1.25f);
            }
            ((AbstractC0729nA) this.f4010a).playSound((SoundEvent) C1280xc.f8396Fv.get(), 8.0f, 1.25f);
            aVarM3290a.m3298a(entityData, iM3297a - 1);
            C1194vo.m6649b(new C1235wc(((AbstractC0729nA) this.f4010a).getId(), this.f4006bD));
            Vector3f vector3f = ((AbstractC0729nA) this.f4010a).position().toVector3f();
            C1160vG c1160vG = null;
            C1160vG c1160vG2 = null;
            if (this.f3981K != null) {
                c1160vG = new C1160vG(this.f3981K, vector3f, 5.0f);
            }
            if (this.f3982L != null) {
                c1160vG2 = new C1160vG(this.f3982L, vector3f, 32.0f);
            }
            SoundEvent soundEvent = (SoundEvent) c0743nOMo3293a.f4014ac.get();
            for (ServerPlayer serverPlayer2 : level.players()) {
                if (serverPlayer2 instanceof ServerPlayer) {
                    ServerPlayer serverPlayer3 = serverPlayer2;
                    if (passengers.contains(serverPlayer3)) {
                        serverPlayer3.playNotifySound(soundEvent, SoundSource.NEUTRAL, 3.0f, 1.0f);
                        if (c1160vG != null) {
                            C1194vo.m6648a(c1160vG, serverPlayer3);
                        }
                    } else if (c1160vG2 != null) {
                        C1194vo.m6648a(c1160vG2, serverPlayer3);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: aQ */
    public int m3405aQ() {
        return this.f4000mk;
    }
}
