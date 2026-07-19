package com.boehmod.blockfront;

import com.boehmod.blockfront.nA;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nL.class */
public class nL extends nN<nA> {
    public static final ResourceLocation dE = C0265jv.d("textures/misc/debug/vehicle_tank.png");
    public boolean fv;

    @Nullable
    public hG K;

    @Nullable
    public hG L;
    public float jV;

    @Nullable
    public EntityType<? extends C0357nf> a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @OnlyIn(Dist.CLIENT)
    public C0236it<nA> f254a;
    public float jW;
    public float jX;
    private float jY;
    private static final float jZ = 3.0f;
    private static final float ka = 0.01f;
    private static final float kb = 7.0f;
    protected boolean fw;
    protected boolean fx;
    private float kc;
    private float kd;
    private int mj;
    public boolean fy;
    public float jy;
    public float jz;
    private int mk;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private nM f255a;
    private DeferredHolder<Item, ? extends C0558ur> Y;
    public int ml;
    public boolean fz;
    public boolean fA;

    public nL(@NotNull String str, @NotNull nA nAVar) {
        super(str, nAVar);
        this.K = hH.o;
        this.L = hH.p;
        this.jV = 1.5f;
        this.a = (EntityType) wX.kV.get();
        this.jX = 0.0f;
        this.jY = 10.0f;
        this.fw = false;
        this.fx = false;
        this.kd = 0.0f;
        this.mj = 0;
        this.fy = false;
        this.jy = 75.0f;
        this.jz = 105.0f;
        this.mk = 1;
        this.f255a = nM.SHELL;
        this.Y = wY.lA;
        this.ml = 0;
        this.fz = false;
        this.fA = true;
    }

    public nL a(float f, float f2) {
        this.fy = true;
        this.jy = f;
        this.jz = f2;
        return this;
    }

    public nL a(@NotNull nM nMVar) {
        this.f255a = nMVar;
        return this;
    }

    public nL a(@NotNull DeferredHolder<Item, ? extends C0558ur> deferredHolder) {
        this.Y = deferredHolder;
        return this;
    }

    @Override // com.boehmod.blockfront.nN
    public nL a(int i) {
        this.mk = i;
        return this;
    }

    public nL a(@NotNull Vector3f vector3f) {
        this.e = vector3f;
        return this;
    }

    public nL a(EntityType<? extends C0357nf> entityType) {
        this.a = entityType;
        return this;
    }

    public nL a() {
        this.fv = true;
        return this;
    }

    public nL a(float f) {
        this.jV = f;
        return this;
    }

    public nL a(@Nullable hG hGVar, @Nullable hG hGVar2) {
        this.K = hGVar;
        this.L = hGVar2;
        return this;
    }

    public nL b(float f) {
        this.jY = f;
        return this;
    }

    public float aD() {
        return this.jY;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public nM m724a() {
        return this.f255a;
    }

    public DeferredHolder<Item, ? extends C0558ur> c() {
        return this.Y;
    }

    public int aP() {
        return this.mj;
    }

    @Override // com.boehmod.blockfront.nN
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull nA nAVar) {
    }

    @Override // com.boehmod.blockfront.nN
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void f(@NotNull nA nAVar) {
        this.kd = this.kc;
        this.kc = Mth.lerp(0.2f, this.kc, 0.0f);
        if (this.mj > 0) {
            this.mj--;
        }
        if (this.ml > 0) {
            this.ml--;
        }
    }

    @Override // com.boehmod.blockfront.nN
    @OnlyIn(Dist.CLIENT)
    public void y(@NotNull Minecraft minecraft) {
        SoundManager soundManager = minecraft.getSoundManager();
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = ((nA) this.a).mo740a().Z;
        Vec3 vec3Position = ((nA) this.a).position();
        if (deferredHolder != null) {
            if (this.f254a == null || !soundManager.isActive(this.f254a)) {
                C0234ir c0234ir = new C0234ir((nA) this.a, this, (SoundEvent) deferredHolder.get(), 2.5f, 1.0f, vec3Position);
                this.f254a = c0234ir;
                soundManager.play(c0234ir);
            }
        }
    }

    @Override // com.boehmod.blockfront.nN
    @NotNull
    public ResourceLocation x() {
        return dE;
    }

    @Override // com.boehmod.blockfront.nN
    public float w(float f) {
        return C0634xm.e(this.jW, this.jX, f);
    }

    public void c(@NotNull Level level) {
        this.kc = 1.0f;
        nM nMVarM724a = m724a();
        if (nMVarM724a != nM.SHELL) {
            if (nMVarM724a == nM.BULLET) {
                this.mj = 1;
            }
        } else {
            this.mj = 2;
            Vec3 vec3Position = ((nA) this.a).position();
            oR.a(level, (ParticleOptions) wZ.nW.get(), vec3Position.add(0.0d, 0.10000000149011612d, 0.0d), 2.0d, 8.0d, 40, 0.25f);
            oR.a(level, (ParticleOptions) ParticleTypes.CLOUD, vec3Position.add(0.0d, 0.10000000149011612d, 0.0d), 2.0d, 8.0d, 60, 0.25f);
            oR.a(level, (ParticleOptions) wZ.nC.get(), vec3Position.add(0.0d, 0.10000000149011612d, 0.0d), 2.0d, 8.0d, 60, 0.5f);
        }
    }

    public float x(float f) {
        return this.jY * C0634xm.e(this.kc, this.kd, f);
    }

    public void a(@NotNull EntityDataAccessor<Float> entityDataAccessor) {
        float f;
        SynchedEntityData entityData = ((nA) this.a).getEntityData();
        float fFloatValue = ((Float) entityData.get(entityDataAccessor)).floatValue();
        this.jX = this.jW;
        this.jW = fFloatValue;
        nO nOVarMo740a = ((nA) this.a).mo740a();
        boolean z = false;
        boolean z2 = false;
        Entity entityB = b();
        if (entityB != null && this.fv) {
            float yRot = ((nA) this.a).getYRot();
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
            float fMin = Math.min(this.jV, Math.abs(f)) * Math.signum(f);
            if (Math.abs(f) > ka) {
                z = true;
                float fClamp = fFloatValue - fMin;
                if (this.fy) {
                    float f2 = yRot * 0.017453292f;
                    fClamp = Mth.clamp(fClamp, f2 - this.jy, f2 + this.jy);
                }
                entityData.set(entityDataAccessor, Float.valueOf(fClamp));
            }
            z2 = Math.abs(f) > 3.0f;
        }
        if (!z) {
            this.fw = false;
            if (nOVarMo740a.ab != null && !this.fx) {
                this.fx = true;
                ((nA) this.a).playSound((SoundEvent) nOVarMo740a.ab.get(), 1.5f, 1.0f);
            }
        } else if (z2) {
            this.fx = false;
            if (nOVarMo740a.aa != null && !this.fw) {
                this.fw = true;
                ((nA) this.a).playSound((SoundEvent) nOVarMo740a.aa.get(), 1.5f, 1.0f);
            }
        }
        ((nA) this.a).a(this).a(((nA) this.a).getEntityData(), z2 && z);
    }

    public void b(@NotNull EntityDataAccessor<Float> entityDataAccessor) {
        this.jX = this.jW;
        this.jW = ((Float) ((nA) this.a).getEntityData().get(entityDataAccessor)).floatValue();
    }

    public void b(@NotNull ServerPlayer serverPlayer) {
        C0582vo.b(new C0597wc(((nA) this.a).getId(), this.bD));
        C0582vo.b(new wD(new ItemStack(this.Y), serverPlayer.position(), serverPlayer.getId(), false));
    }

    public void c(@NotNull ServerPlayer serverPlayer) {
        nA.a aVarA;
        SynchedEntityData entityData;
        int iM711a;
        Level level;
        C0357nf c0357nfCreate;
        if (this.a != null && (iM711a = (aVarA = ((nA) this.a).a(this)).m711a((entityData = ((nA) this.a).getEntityData()))) > 0 && ((nA) this.a).mf <= 0 && (c0357nfCreate = this.a.create((level = ((nA) this.a).level()))) != null) {
            List passengers = ((nA) this.a).getPassengers();
            nE nEVarB = ((nA) this.a).b();
            nO nOVarMo740a = ((nA) this.a).mo740a();
            ((nA) this.a).mf = nEVarB.mi;
            float fAE = aE();
            float yRot = ((nA) this.a).getYRot();
            Vec3 vec3Position = ((nA) this.a).position();
            Vector3f vector3fRotateY = new Vector3f(this.e).rotateY((-yRot) * 0.017453292f);
            float f = yRot + fAE;
            float xRot = serverPlayer.getXRot();
            float yRot2 = serverPlayer.getYRot();
            if (Math.abs(Math.abs(yRot2 - f)) < 15.0f) {
                f = yRot2;
            }
            c0357nfCreate.a(serverPlayer, vec3Position.add(vector3fRotateY.x, vector3fRotateY.y, vector3fRotateY.z).add((-Mth.sin(f * 0.017453292f)) * 4.0f, (-Mth.sin(r0 * 0.017453292f)) * 4.0f, Mth.cos(f * 0.017453292f) * 4.0f), new ItemStack(((Block) wL.hZ.get()).asItem()), 7.0f, f, xRot + (6.0f * ((nA) this.a).mo740a().aA()));
            c0357nfCreate.setNoGravity(true);
            level.addFreshEntity(c0357nfCreate);
            ((nA) this.a).playSound((SoundEvent) nOVarMo740a.ah.get(), 2.0f, 1.0f);
            ((nA) this.a).playSound((SoundEvent) nOVarMo740a.ad.get(), 3.0f, 1.0f);
            ((nA) this.a).playSound((SoundEvent) nOVarMo740a.ag.get(), 3.0f, 1.0f);
            ((nA) this.a).playSound((SoundEvent) nOVarMo740a.ae.get(), 3.0f, 1.0f);
            ((nA) this.a).playSound((SoundEvent) nOVarMo740a.af.get(), 8.0f, 1.0f);
            for (int i = 0; i < 2; i++) {
                ((nA) this.a).playSound((SoundEvent) C0624xc.Fr.get(), 6.0f, 1.25f);
            }
            ((nA) this.a).playSound((SoundEvent) C0624xc.Fv.get(), 8.0f, 1.25f);
            aVarA.a(entityData, iM711a - 1);
            C0582vo.b(new C0597wc(((nA) this.a).getId(), this.bD));
            Vector3f vector3f = ((nA) this.a).position().toVector3f();
            vG vGVar = null;
            vG vGVar2 = null;
            if (this.K != null) {
                vGVar = new vG(this.K, vector3f, 5.0f);
            }
            if (this.L != null) {
                vGVar2 = new vG(this.L, vector3f, 32.0f);
            }
            SoundEvent soundEvent = (SoundEvent) nOVarMo740a.ac.get();
            for (ServerPlayer serverPlayer2 : level.players()) {
                if (serverPlayer2 instanceof ServerPlayer) {
                    ServerPlayer serverPlayer3 = serverPlayer2;
                    if (passengers.contains(serverPlayer3)) {
                        serverPlayer3.playNotifySound(soundEvent, SoundSource.NEUTRAL, 3.0f, 1.0f);
                        if (vGVar != null) {
                            C0582vo.a(vGVar, serverPlayer3);
                        }
                    } else if (vGVar2 != null) {
                        C0582vo.a(vGVar2, serverPlayer3);
                    }
                }
            }
        }
    }

    public int aQ() {
        return this.mk;
    }
}
