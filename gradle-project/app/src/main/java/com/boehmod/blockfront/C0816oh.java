package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.oh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oh.class */
public class C0816oh extends AbstractC0818oj<AbstractC0752nW> {

    /* JADX INFO: renamed from: dC */
    public static final ResourceLocation f4407dC = C0532jO.m2378d("textures/misc/debug/vehicle_tank.png");

    /* JADX INFO: renamed from: fP */
    public boolean f4408fP;

    /* JADX INFO: renamed from: L */
    @Nullable
    public C0434hW f4409L;

    /* JADX INFO: renamed from: M */
    @Nullable
    public C0434hW f4410M;

    /* JADX INFO: renamed from: kO */
    public float f4411kO;

    /* JADX INFO: renamed from: a */
    @Nullable
    public EntityType<? extends C0731nB> f4412a;

    /* JADX INFO: renamed from: a */
    @OnlyIn(Dist.CLIENT)
    public C0475iK<AbstractC0752nW> f4413a;

    /* JADX INFO: renamed from: kP */
    public float f4414kP;

    /* JADX INFO: renamed from: kQ */
    public float f4415kQ;

    /* JADX INFO: renamed from: kR */
    private float f4416kR;

    /* JADX INFO: renamed from: kS */
    private static final float f4417kS = 3.0f;

    /* JADX INFO: renamed from: kT */
    private static final float f4418kT = 0.01f;

    /* JADX INFO: renamed from: kU */
    private static final float f4419kU = 7.0f;

    /* JADX INFO: renamed from: fQ */
    protected boolean f4420fQ;

    /* JADX INFO: renamed from: fR */
    protected boolean f4421fR;

    /* JADX INFO: renamed from: kV */
    private float f4422kV;

    /* JADX INFO: renamed from: kW */
    private float f4423kW;

    /* JADX INFO: renamed from: oh */
    private int f4424oh;

    /* JADX INFO: renamed from: fS */
    public boolean f4425fS;

    /* JADX INFO: renamed from: kr */
    public float f4426kr;

    /* JADX INFO: renamed from: ks */
    public float f4427ks;

    /* JADX INFO: renamed from: oi */
    private int f4428oi;

    /* JADX INFO: renamed from: a */
    private EnumC0817oi f4429a;

    /* JADX INFO: renamed from: Y */
    private DeferredHolder<Item, ? extends C1117uP> f4430Y;

    /* JADX INFO: renamed from: oj */
    public int f4431oj;

    /* JADX INFO: renamed from: fT */
    public boolean f4432fT;

    /* JADX INFO: renamed from: fU */
    public boolean f4433fU;

    public C0816oh(@NotNull String str, @NotNull AbstractC0752nW abstractC0752nW) {
        super(str, abstractC0752nW);
        this.f4409L = C0435hX.f2765o;
        this.f4410M = C0435hX.f2766p;
        this.f4411kO = 1.5f;
        this.f4412a = (EntityType) C1307xu.f7617kV.get();
        this.f4415kQ = 0.0f;
        this.f4416kR = 10.0f;
        this.f4420fQ = false;
        this.f4421fR = false;
        this.f4423kW = 0.0f;
        this.f4424oh = 0;
        this.f4425fS = false;
        this.f4426kr = 75.0f;
        this.f4427ks = 105.0f;
        this.f4428oi = 1;
        this.f4429a = EnumC0817oi.SHELL;
        this.f4430Y = C1308xv.f7754lA;
        this.f4431oj = 0;
        this.f4432fT = false;
        this.f4433fU = true;
    }

    /* JADX INFO: renamed from: a */
    public C0816oh m3752a(float f, float f2) {
        this.f4425fS = true;
        this.f4426kr = f;
        this.f4427ks = f2;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0816oh m3753a(@NotNull EnumC0817oi enumC0817oi) {
        this.f4429a = enumC0817oi;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0816oh m3754a(@NotNull DeferredHolder<Item, ? extends C1117uP> deferredHolder) {
        this.f4430Y = deferredHolder;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0818oj
    /* JADX INFO: renamed from: a */
    public C0816oh mo3755a(int i) {
        this.f4428oi = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0816oh m3756a(@NotNull Vector3f vector3f) {
        this.f4437e = vector3f;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0816oh m3757a(EntityType<? extends C0731nB> entityType) {
        this.f4412a = entityType;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0816oh m3758a() {
        this.f4408fP = true;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0816oh m3759a(float f) {
        this.f4411kO = f;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0816oh m3760a(@Nullable C0434hW c0434hW, @Nullable C0434hW c0434hW2) {
        this.f4409L = c0434hW;
        this.f4410M = c0434hW2;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0816oh m3761b(float f) {
        this.f4416kR = f;
        return this;
    }

    /* JADX INFO: renamed from: aJ */
    public float m3762aJ() {
        return this.f4416kR;
    }

    /* JADX INFO: renamed from: a */
    public EnumC0817oi m3763a() {
        return this.f4429a;
    }

    /* JADX INFO: renamed from: c */
    public DeferredHolder<Item, ? extends C1117uP> m3764c() {
        return this.f4430Y;
    }

    /* JADX INFO: renamed from: be */
    public int m3765be() {
        return this.f4424oh;
    }

    @Override // com.boehmod.blockfront.AbstractC0818oj
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo3779c(@NotNull AbstractC0752nW abstractC0752nW) {
    }

    @Override // com.boehmod.blockfront.AbstractC0818oj
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void mo3778f(@NotNull AbstractC0752nW abstractC0752nW) {
        this.f4423kW = this.f4422kV;
        this.f4422kV = Mth.lerp(0.2f, this.f4422kV, 0.0f);
        if (this.f4424oh > 0) {
            this.f4424oh--;
        }
        if (this.f4431oj > 0) {
            this.f4431oj--;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0818oj
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: A */
    public void mo3768A(@NotNull Minecraft minecraft) {
        SoundManager soundManager = minecraft.getSoundManager();
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = ((AbstractC0752nW) this.f4438a).mo3433a().f4439Z;
        Vec3 vec3Position = ((AbstractC0752nW) this.f4438a).position();
        if (deferredHolder != null) {
            if (this.f4413a == null || !soundManager.isActive(this.f4413a)) {
                C0473iI c0473iI = new C0473iI((AbstractC0752nW) this.f4438a, this, (SoundEvent) deferredHolder.get(), 2.5f, 1.0f, vec3Position);
                this.f4413a = c0473iI;
                soundManager.play(c0473iI);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0818oj
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3769y() {
        return f4407dC;
    }

    @Override // com.boehmod.blockfront.AbstractC0818oj
    /* JADX INFO: renamed from: z */
    public float mo3770z(float f) {
        return C1270xJ.m7170f(this.f4414kP, this.f4415kQ, f);
    }

    /* JADX INFO: renamed from: c */
    public void m3771c(@NotNull Level level) {
        this.f4422kV = 1.0f;
        EnumC0817oi enumC0817oiM3763a = m3763a();
        if (enumC0817oiM3763a != EnumC0817oi.SHELL) {
            if (enumC0817oiM3763a == EnumC0817oi.BULLET) {
                this.f4424oh = 1;
            }
        } else {
            this.f4424oh = 2;
            Vec3 vec3Position = ((AbstractC0752nW) this.f4438a).position();
            C0875pn.m4480a(level, (ParticleOptions) C1309xw.f7886nW.get(), vec3Position.add(0.0d, 0.10000000149011612d, 0.0d), 2.0d, 8.0d, 40, 0.25f);
            C0875pn.m4480a(level, (ParticleOptions) ParticleTypes.CLOUD, vec3Position.add(0.0d, 0.10000000149011612d, 0.0d), 2.0d, 8.0d, 60, 0.25f);
            C0875pn.m4480a(level, (ParticleOptions) C1309xw.f7866nC.get(), vec3Position.add(0.0d, 0.10000000149011612d, 0.0d), 2.0d, 8.0d, 60, 0.5f);
        }
    }

    /* JADX INFO: renamed from: A */
    public float m3772A(float f) {
        return this.f4416kR * C1270xJ.m7170f(this.f4422kV, this.f4423kW, f);
    }

    /* JADX INFO: renamed from: a */
    public void m3773a(@NotNull EntityDataAccessor<Float> entityDataAccessor) {
        float f;
        SynchedEntityData entityData = ((AbstractC0752nW) this.f4438a).getEntityData();
        float fFloatValue = ((Float) entityData.get(entityDataAccessor)).floatValue();
        this.f4415kQ = this.f4414kP;
        this.f4414kP = fFloatValue;
        C0819ok c0819okMo3433a = ((AbstractC0752nW) this.f4438a).mo3433a();
        boolean z = false;
        boolean z2 = false;
        Entity entityB = m3782b();
        if (entityB != null && this.f4408fP) {
            float yRot = ((AbstractC0752nW) this.f4438a).getYRot();
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
            float fMin = Math.min(this.f4411kO, Math.abs(f)) * Math.signum(f);
            if (Math.abs(f) > f4418kT) {
                z = true;
                float fClamp = fFloatValue - fMin;
                if (this.f4425fS) {
                    float f2 = yRot * 0.017453292f;
                    fClamp = Mth.clamp(fClamp, f2 - this.f4426kr, f2 + this.f4426kr);
                }
                entityData.set(entityDataAccessor, Float.valueOf(fClamp));
            }
            z2 = Math.abs(f) > 3.0f;
        }
        if (!z) {
            this.f4420fQ = false;
            if (c0819okMo3433a.f4441ab != null && !this.f4421fR) {
                this.f4421fR = true;
                ((AbstractC0752nW) this.f4438a).playSound((SoundEvent) c0819okMo3433a.f4441ab.get(), 1.5f, 1.0f);
            }
        } else if (z2) {
            this.f4421fR = false;
            if (c0819okMo3433a.f4440aa != null && !this.f4420fQ) {
                this.f4420fQ = true;
                ((AbstractC0752nW) this.f4438a).playSound((SoundEvent) c0819okMo3433a.f4440aa.get(), 1.5f, 1.0f);
            }
        }
        ((AbstractC0752nW) this.f4438a).m3479a(this).m3487a(((AbstractC0752nW) this.f4438a).getEntityData(), z2 && z);
    }

    /* JADX INFO: renamed from: b */
    public void m3774b(@NotNull EntityDataAccessor<Float> entityDataAccessor) {
        this.f4415kQ = this.f4414kP;
        this.f4414kP = ((Float) ((AbstractC0752nW) this.f4438a).getEntityData().get(entityDataAccessor)).floatValue();
    }

    /* JADX INFO: renamed from: b */
    public void m3775b(@NotNull ServerPlayer serverPlayer) {
        C1169vO.m6644b(new C1209wB(((AbstractC0752nW) this.f4438a).getId(), this.f4434bM));
        C1169vO.m6644b(new C1287xa(new ItemStack(this.f4430Y), serverPlayer.position(), serverPlayer.getId(), false));
    }

    /* JADX INFO: renamed from: c */
    public void m3776c(@NotNull ServerPlayer serverPlayer) {
        AbstractC0752nW.a aVarM3479a;
        SynchedEntityData entityData;
        int iM3484a;
        Level level;
        C0731nB c0731nBCreate;
        if (this.f4412a != null && (iM3484a = (aVarM3479a = ((AbstractC0752nW) this.f4438a).m3479a(this)).m3484a((entityData = ((AbstractC0752nW) this.f4438a).getEntityData()))) > 0 && ((AbstractC0752nW) this.f4438a).f4153od <= 0 && (c0731nBCreate = this.f4412a.create((level = ((AbstractC0752nW) this.f4438a).level()))) != null) {
            List passengers = ((AbstractC0752nW) this.f4438a).getPassengers();
            C0809oa c0809oaB = ((AbstractC0752nW) this.f4438a).m3431b();
            C0819ok c0819okMo3433a = ((AbstractC0752nW) this.f4438a).mo3433a();
            ((AbstractC0752nW) this.f4438a).f4153od = c0809oaB.f4379og;
            float fAK = m3781aK();
            float yRot = ((AbstractC0752nW) this.f4438a).getYRot();
            Vec3 vec3Position = ((AbstractC0752nW) this.f4438a).position();
            Vector3f vector3fRotateY = new Vector3f(this.f4437e).rotateY((-yRot) * 0.017453292f);
            float f = yRot + fAK;
            float xRot = serverPlayer.getXRot();
            float yRot2 = serverPlayer.getYRot();
            if (Math.abs(Math.abs(yRot2 - f)) < 15.0f) {
                f = yRot2;
            }
            float fM3495aG = xRot + (6.0f * ((AbstractC0752nW) this.f4438a).mo3433a().m3495aG());
            c0731nBCreate.m3355a(serverPlayer, vec3Position.add(vector3fRotateY.x, vector3fRotateY.y, vector3fRotateY.z).add((-Mth.sin(f * 0.017453292f)) * 4.0f, (-Mth.sin(fM3495aG * 0.017453292f)) * 4.0f, Mth.cos(f * 0.017453292f) * 4.0f), new ItemStack(((Block) C1295xi.f7308hZ.get()).asItem()), 7.0f, f, fM3495aG);
            c0731nBCreate.setNoGravity(true);
            level.addFreshEntity(c0731nBCreate);
            ((AbstractC0752nW) this.f4438a).playSound((SoundEvent) c0819okMo3433a.f4447ah.get(), 2.0f, 1.0f);
            ((AbstractC0752nW) this.f4438a).playSound((SoundEvent) c0819okMo3433a.f4443ad.get(), 3.0f, 1.0f);
            ((AbstractC0752nW) this.f4438a).playSound((SoundEvent) c0819okMo3433a.f4446ag.get(), 3.0f, 1.0f);
            ((AbstractC0752nW) this.f4438a).playSound((SoundEvent) c0819okMo3433a.f4444ae.get(), 3.0f, 1.0f);
            ((AbstractC0752nW) this.f4438a).playSound((SoundEvent) c0819okMo3433a.f4445af.get(), 8.0f, 1.0f);
            for (int i = 0; i < 2; i++) {
                ((AbstractC0752nW) this.f4438a).playSound((SoundEvent) C1312xz.f8806Fv.get(), 6.0f, 1.25f);
            }
            ((AbstractC0752nW) this.f4438a).playSound((SoundEvent) C1312xz.f8810Fz.get(), 8.0f, 1.25f);
            aVarM3479a.m3485a(entityData, iM3484a - 1);
            C1169vO.m6644b(new C1209wB(((AbstractC0752nW) this.f4438a).getId(), this.f4434bM));
            Vector3f vector3f = ((AbstractC0752nW) this.f4438a).position().toVector3f();
            C1239wf c1239wf = null;
            C1239wf c1239wf2 = null;
            if (this.f4409L != null) {
                c1239wf = new C1239wf(this.f4409L, vector3f, 5.0f);
            }
            if (this.f4410M != null) {
                c1239wf2 = new C1239wf(this.f4410M, vector3f, 32.0f);
            }
            SoundEvent soundEvent = (SoundEvent) c0819okMo3433a.f4442ac.get();
            for (ServerPlayer serverPlayer2 : level.players()) {
                if (serverPlayer2 instanceof ServerPlayer) {
                    ServerPlayer serverPlayer3 = serverPlayer2;
                    if (passengers.contains(serverPlayer3)) {
                        serverPlayer3.playNotifySound(soundEvent, SoundSource.NEUTRAL, 3.0f, 1.0f);
                        if (c1239wf != null) {
                            C1169vO.m6643a(c1239wf, serverPlayer3);
                        }
                    } else if (c1239wf2 != null) {
                        C1169vO.m6643a(c1239wf2, serverPlayer3);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: bf */
    public int m3777bf() {
        return this.f4428oi;
    }
}
