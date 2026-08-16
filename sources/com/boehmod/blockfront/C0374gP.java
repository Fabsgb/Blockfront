package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import javax.annotation.Nullable;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.gP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gP.class */
public final class C0374gP extends HumanoidMobRenderer<C0756na, C0265eM> implements InterfaceC0028Y<C0756na> {

    /* JADX INFO: renamed from: cH */
    public static final ResourceLocation f2521cH;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0265eM f2522a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0414hC f2523a;

    /* JADX INFO: renamed from: cC */
    static final /* synthetic */ boolean f2524cC;

    static {
        f2524cC = !C0374gP.class.desiredAssertionStatus();
        f2521cH = C0532jO.m2378d("textures/models/entities/corpse/burned.png");
    }

    public C0374gP(EntityRendererProvider.Context context) {
        super(context, new C0265eM(context.bakeLayer(ModelLayers.PLAYER), false), 0.5f);
        this.f2522a = new C0265eM(context.bakeLayer(ModelLayers.PLAYER_SLIM), true);
        this.layers.clear();
        addLayer(new C0416hE(this, context.getItemInHandRenderer()));
        C0414hC c0414hC = new C0414hC(this, context);
        this.f2523a = c0414hC;
        addLayer(c0414hC);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(C0756na c0756na, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        if (c0756na.isDeadOrDying()) {
            return;
        }
        C0265eM c0265eM = this.model;
        if (c0756na.m3581M()) {
            this.model = this.f2522a;
        }
        super.render(c0756na, f, f2, poseStack, multiBufferSource, i);
        this.model = c0265eM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void scale(@NotNull C0756na c0756na, @NotNull PoseStack poseStack, float f) {
        poseStack.scale(0.9375f, 0.9375f, 0.9375f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public float getShadowRadius(@NotNull C0756na c0756na) {
        if (c0756na.isDeadOrDying()) {
            return 0.0f;
        }
        return super.getShadowRadius(c0756na);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(C0756na c0756na) {
        return c0756na.m3551t();
    }

    @Override // com.boehmod.blockfront.InterfaceC0028Y
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Collection<C0016M> mo167a(@NotNull C0015L c0015l, C1256ww.a aVar, @NotNull C0756na c0756na, @NotNull C0027X c0027x) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2524cC && c0623lM2852b == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        ResourceLocation resourceLocationMo168a = aVar.m7109dd() ? f2521cH : mo168a(c0756na);
        ResourceLocation resourceLocationM3548a = abstractC0863pbM2874a != null ? c0756na.m3548a(abstractC0863pbM2874a) : null;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        C0016M c0016mM1791a = m1791a(EnumC0018O.BODY, c0027x, c0756na, resourceLocationMo168a, resourceLocationM3548a, c0265eM -> {
            return c0265eM.body;
        }, c0265eM2 -> {
            return c0265eM2.f2172i;
        }, 1.0d);
        objectArrayList.add(c0016mM1791a);
        C0016M c0016mM1791a2 = m1791a(EnumC0018O.HEAD, c0027x, c0756na, resourceLocationMo168a, resourceLocationM3548a, c0265eM3 -> {
            return c0265eM3.head;
        }, c0265eM4 -> {
            return c0265eM4.hat;
        }, 0.4d);
        objectArrayList.add(c0016mM1791a2);
        C0016M c0016mM1791a3 = m1791a(EnumC0018O.ARM, c0027x, c0756na, resourceLocationMo168a, resourceLocationM3548a, c0265eM5 -> {
            return c0265eM5.leftArm;
        }, c0265eM6 -> {
            return c0265eM6.f2168e;
        }, 1.0d);
        objectArrayList.add(c0016mM1791a3);
        C0016M c0016mM1791a4 = m1791a(EnumC0018O.ARM, c0027x, c0756na, resourceLocationMo168a, resourceLocationM3548a, c0265eM7 -> {
            return c0265eM7.rightArm;
        }, c0265eM8 -> {
            return c0265eM8.f2169f;
        }, 1.0d);
        objectArrayList.add(c0016mM1791a4);
        C0016M c0016mM1791a5 = m1791a(EnumC0018O.LEG, c0027x, c0756na, resourceLocationMo168a, resourceLocationM3548a, c0265eM9 -> {
            return c0265eM9.leftLeg;
        }, c0265eM10 -> {
            return c0265eM10.f2170g;
        }, 1.0d);
        objectArrayList.add(c0016mM1791a5);
        C0016M c0016mM1791a6 = m1791a(EnumC0018O.LEG, c0027x, c0756na, resourceLocationMo168a, resourceLocationM3548a, c0265eM11 -> {
            return c0265eM11.rightLeg;
        }, c0265eM12 -> {
            return c0265eM12.f2171h;
        }, 1.0d);
        objectArrayList.add(c0016mM1791a6);
        Vector3dc vector3dc = C0016M.f206a;
        Vector3dc vector3dc2 = C0016M.f207b;
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        boolean z = C0495ie.f3043w.m2230U() && aVar.m7110de();
        c0016mM1791a2.m77a(c0016mM1791a, C0016M.f208c, (Quaterniondc) new Quaterniond());
        if (!z || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            c0016mM1791a6.m77a(c0016mM1791a, vector3dc, (Quaterniondc) new Quaterniond().rotateZ(-0.39269908169872414d));
        } else {
            c0016mM1791a6.m88a(new C0019P(100, 20, 2, (SimpleParticleType) C1309xw.f7853np.get()));
        }
        if (!z || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            c0016mM1791a5.m77a(c0016mM1791a, vector3dc, (Quaterniondc) new Quaterniond().rotateZ(0.39269908169872414d));
        } else {
            c0016mM1791a5.m88a(new C0019P(100, 20, 2, (SimpleParticleType) C1309xw.f7853np.get()));
        }
        if (!z || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            c0016mM1791a4.m77a(c0016mM1791a, vector3dc2, (Quaterniondc) new Quaterniond().rotateZ(-1.5707963705062866d));
        } else {
            c0016mM1791a4.m88a(new C0019P(100, 20, 2, (SimpleParticleType) C1309xw.f7853np.get()));
        }
        if (!z || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            c0016mM1791a3.m77a(c0016mM1791a, vector3dc2, (Quaterniondc) new Quaterniond().rotateZ(1.5707963705062866d));
        } else {
            c0016mM1791a3.m88a(new C0019P(100, 20, 2, (SimpleParticleType) C1309xw.f7853np.get()));
        }
        if (C0495ie.f3043w.m2230U()) {
            c0016mM1791a.m88a(new C0019P(100, 20, 2, (SimpleParticleType) C1309xw.f7853np.get()));
        }
        ResourceLocation resourceLocationM3549b = abstractC0863pbM2874a != null ? c0756na.m3549b(abstractC0863pbM2874a) : null;
        if (resourceLocationM3549b != null) {
            C0265eM c0265eM13 = c0756na.m3581M() ? this.f2522a : this.model;
            C0016M c0016mM59a = C0015L.m59a(c0027x, EnumC0018O.BACKPACK, 1.0d, C0264eL.m1497a(c0265eM13.body.storePose(), c0265eM13.crouching), C0017N.m91a(resourceLocationM3549b, this.f2523a.f2679a.f2161c, EnumC0012I.BASIC), C0017N.m91a(resourceLocationM3549b, this.f2523a.f2679a.f2162d, EnumC0012I.COSMETIC), C0017N.m91a(resourceLocationM3549b, this.f2523a.f2679a.f2159a, EnumC0012I.COSMETIC), C0017N.m91a(resourceLocationM3549b, this.f2523a.f2679a.f2160b, EnumC0012I.COSMETIC));
            if (!z || threadLocalRandomCurrent.nextFloat() < 0.8f) {
                c0016mM59a.m77a(c0016mM1791a, (Vector3dc) new Vector3d(), (Quaterniondc) new Quaterniond().rotateZ(0.0d));
            }
            objectArrayList.add(c0016mM59a);
        }
        return Collections.unmodifiableCollection(objectArrayList);
    }

    /* JADX INFO: renamed from: a */
    private C0016M m1791a(@NotNull EnumC0018O enumC0018O, @NotNull C0027X c0027x, @NotNull C0756na c0756na, @NotNull ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2, @NotNull Function<C0265eM, ModelPart> function, @NotNull Function<C0265eM, ModelPart> function2, double d) {
        C0265eM c0265eM = c0756na.m3581M() ? this.f2522a : (C0265eM) this.model;
        ModelPart modelPartApply = function.apply(c0265eM);
        if (resourceLocation2 != null) {
            C0265eM c0265eMM1960a = this.f2523a.m1960a(c0756na);
            return C0015L.m59a(c0027x, enumC0018O, d, modelPartApply.storePose(), C0017N.m91a(resourceLocation, modelPartApply, EnumC0012I.BASIC), C0017N.m91a(resourceLocation2, function.apply(c0265eMM1960a), EnumC0012I.COSMETIC), C0017N.m91a(resourceLocation2, function2.apply(c0265eMM1960a), EnumC0012I.COSMETIC));
        }
        return C0015L.m59a(c0027x, enumC0018O, d, modelPartApply.storePose(), C0017N.m91a(resourceLocation, modelPartApply, EnumC0012I.BASIC), C0017N.m91a(resourceLocation, function2.apply(c0265eM), EnumC0012I.COSMETIC));
    }

    @Override // com.boehmod.blockfront.InterfaceC0028Y
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ResourceLocation mo168a(@NotNull C0756na c0756na) {
        return c0756na.m3551t();
    }
}
