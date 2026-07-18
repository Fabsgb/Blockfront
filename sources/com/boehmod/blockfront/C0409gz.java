package com.boehmod.blockfront;

import com.boehmod.blockfront.C1176vW;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.gz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gz.class */
public final class C0409gz extends HumanoidMobRenderer<C0680mE, C0303ez> implements InterfaceC0021S<C0680mE> {

    /* JADX INFO: renamed from: cH */
    public static final ResourceLocation f2620cH;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0303ez f2621a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0449hm f2622a;

    /* JADX INFO: renamed from: ct */
    static final /* synthetic */ boolean f2623ct;

    static {
        f2623ct = !C0409gz.class.desiredAssertionStatus();
        f2620cH = C0564jv.m2555d("textures/models/entities/corpse/burned.png");
    }

    public C0409gz(EntityRendererProvider.Context context) {
        super(context, new C0303ez(context.bakeLayer(ModelLayers.PLAYER), false), 0.5f);
        this.f2621a = new C0303ez(context.bakeLayer(ModelLayers.PLAYER_SLIM), true);
        this.layers.clear();
        addLayer(new C0451ho(this, context.getItemInHandRenderer()));
        C0449hm c0449hm = new C0449hm(this, context);
        this.f2622a = c0449hm;
        addLayer(c0449hm);
    }

    /* JADX INFO: renamed from: a */
    public void render(C0680mE c0680mE, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        if (c0680mE.isDeadOrDying()) {
            return;
        }
        C0303ez c0303ez = this.model;
        if (c0680mE.m3074L()) {
            this.model = this.f2621a;
        }
        super.render(c0680mE, f, f2, poseStack, multiBufferSource, i);
        this.model = c0303ez;
    }

    /* JADX INFO: renamed from: a */
    public void scale(@NotNull C0680mE c0680mE, @NotNull PoseStack poseStack, float f) {
        poseStack.scale(0.9375f, 0.9375f, 0.9375f);
    }

    /* JADX INFO: renamed from: a */
    public float getShadowRadius(@NotNull C0680mE c0680mE) {
        if (c0680mE.isDeadOrDying()) {
            return 0.0f;
        }
        return super.getShadowRadius(c0680mE);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ResourceLocation getTextureLocation(C0680mE c0680mE) {
        return c0680mE.m3044s();
    }

    @Override // com.boehmod.blockfront.InterfaceC0021S
    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<C0009G> mo134a(@NotNull C0008F c0008f, C1176vW.a aVar, @NotNull C0680mE c0680mE, @NotNull C0020R c0020r) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2623ct && c0622lM2667b == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        ResourceLocation resourceLocationMo135a = aVar.m6583cU() ? f2620cH : mo135a(c0680mE);
        ResourceLocation resourceLocationM3041a = abstractC0787oFM2688a != null ? c0680mE.m3041a(abstractC0787oFM2688a) : null;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        C0009G c0009gM1933a = m1933a(EnumC0011I.BODY, c0020r, c0680mE, resourceLocationMo135a, resourceLocationM3041a, c0303ez -> {
            return c0303ez.body;
        }, c0303ez2 -> {
            return c0303ez2.f2302i;
        }, 1.0d);
        objectArrayList.add(c0009gM1933a);
        C0009G c0009gM1933a2 = m1933a(EnumC0011I.HEAD, c0020r, c0680mE, resourceLocationMo135a, resourceLocationM3041a, c0303ez3 -> {
            return c0303ez3.head;
        }, c0303ez4 -> {
            return c0303ez4.hat;
        }, 0.4d);
        objectArrayList.add(c0009gM1933a2);
        C0009G c0009gM1933a3 = m1933a(EnumC0011I.ARM, c0020r, c0680mE, resourceLocationMo135a, resourceLocationM3041a, c0303ez5 -> {
            return c0303ez5.leftArm;
        }, c0303ez6 -> {
            return c0303ez6.f2298e;
        }, 1.0d);
        objectArrayList.add(c0009gM1933a3);
        C0009G c0009gM1933a4 = m1933a(EnumC0011I.ARM, c0020r, c0680mE, resourceLocationMo135a, resourceLocationM3041a, c0303ez7 -> {
            return c0303ez7.rightArm;
        }, c0303ez8 -> {
            return c0303ez8.f2299f;
        }, 1.0d);
        objectArrayList.add(c0009gM1933a4);
        C0009G c0009gM1933a5 = m1933a(EnumC0011I.LEG, c0020r, c0680mE, resourceLocationMo135a, resourceLocationM3041a, c0303ez9 -> {
            return c0303ez9.leftLeg;
        }, c0303ez10 -> {
            return c0303ez10.f2300g;
        }, 1.0d);
        objectArrayList.add(c0009gM1933a5);
        C0009G c0009gM1933a6 = m1933a(EnumC0011I.LEG, c0020r, c0680mE, resourceLocationMo135a, resourceLocationM3041a, c0303ez11 -> {
            return c0303ez11.rightLeg;
        }, c0303ez12 -> {
            return c0303ez12.f2301h;
        }, 1.0d);
        objectArrayList.add(c0009gM1933a6);
        Vector3dc vector3dc = C0009G.f166a;
        Vector3dc vector3dc2 = C0009G.f167b;
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        boolean z = C0424hN.f2742w.m1996T() && aVar.m6584cV();
        c0009gM1933a2.m44a(c0009gM1933a, C0009G.f168c, (Quaterniondc) new Quaterniond());
        if (!z || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            c0009gM1933a6.m44a(c0009gM1933a, vector3dc, (Quaterniondc) new Quaterniond().rotateZ(-0.39269908169872414d));
        } else {
            c0009gM1933a6.m55a(new C0012J(100, 20, 2, (SimpleParticleType) C1232wZ.f7288np.get()));
        }
        if (!z || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            c0009gM1933a5.m44a(c0009gM1933a, vector3dc, (Quaterniondc) new Quaterniond().rotateZ(0.39269908169872414d));
        } else {
            c0009gM1933a5.m55a(new C0012J(100, 20, 2, (SimpleParticleType) C1232wZ.f7288np.get()));
        }
        if (!z || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            c0009gM1933a4.m44a(c0009gM1933a, vector3dc2, (Quaterniondc) new Quaterniond().rotateZ(-1.5707963705062866d));
        } else {
            c0009gM1933a4.m55a(new C0012J(100, 20, 2, (SimpleParticleType) C1232wZ.f7288np.get()));
        }
        if (!z || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            c0009gM1933a3.m44a(c0009gM1933a, vector3dc2, (Quaterniondc) new Quaterniond().rotateZ(1.5707963705062866d));
        } else {
            c0009gM1933a3.m55a(new C0012J(100, 20, 2, (SimpleParticleType) C1232wZ.f7288np.get()));
        }
        if (C0424hN.f2742w.m1996T()) {
            c0009gM1933a.m55a(new C0012J(100, 20, 2, (SimpleParticleType) C1232wZ.f7288np.get()));
        }
        ResourceLocation resourceLocationM3042b = abstractC0787oFM2688a != null ? c0680mE.m3042b(abstractC0787oFM2688a) : null;
        if (resourceLocationM3042b != null) {
            C0303ez c0303ez13 = c0680mE.m3074L() ? this.f2621a : this.model;
            C0009G c0009gM27a = C0008F.m27a(c0020r, EnumC0011I.BACKPACK, 1.0d, C0302ey.m1593a(c0303ez13.body.storePose(), c0303ez13.crouching), C0010H.m58a(resourceLocationM3042b, this.f2622a.f2849a.f2291c, EnumC0005C.BASIC), C0010H.m58a(resourceLocationM3042b, this.f2622a.f2849a.f2292d, EnumC0005C.COSMETIC), C0010H.m58a(resourceLocationM3042b, this.f2622a.f2849a.f2289a, EnumC0005C.COSMETIC), C0010H.m58a(resourceLocationM3042b, this.f2622a.f2849a.f2290b, EnumC0005C.COSMETIC));
            if (!z || threadLocalRandomCurrent.nextFloat() < 0.8f) {
                c0009gM27a.m44a(c0009gM1933a, (Vector3dc) new Vector3d(), (Quaterniondc) new Quaterniond().rotateZ(0.0d));
            }
            objectArrayList.add(c0009gM27a);
        }
        return Collections.unmodifiableCollection(objectArrayList);
    }

    /* JADX INFO: renamed from: a */
    private C0009G m1933a(@NotNull EnumC0011I enumC0011I, @NotNull C0020R c0020r, @NotNull C0680mE c0680mE, @NotNull ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2, @NotNull Function<C0303ez, ModelPart> function, @NotNull Function<C0303ez, ModelPart> function2, double d) {
        C0303ez c0303ez = c0680mE.m3074L() ? this.f2621a : (C0303ez) this.model;
        ModelPart modelPartApply = function.apply(c0303ez);
        if (resourceLocation2 != null) {
            C0303ez c0303ezM2058a = this.f2622a.m2058a(c0680mE);
            return C0008F.m27a(c0020r, enumC0011I, d, modelPartApply.storePose(), C0010H.m58a(resourceLocation, modelPartApply, EnumC0005C.BASIC), C0010H.m58a(resourceLocation2, function.apply(c0303ezM2058a), EnumC0005C.COSMETIC), C0010H.m58a(resourceLocation2, function2.apply(c0303ezM2058a), EnumC0005C.COSMETIC));
        }
        return C0008F.m27a(c0020r, enumC0011I, d, modelPartApply.storePose(), C0010H.m58a(resourceLocation, modelPartApply, EnumC0005C.BASIC), C0010H.m58a(resourceLocation, function2.apply(c0303ez), EnumC0005C.COSMETIC));
    }

    @Override // com.boehmod.blockfront.InterfaceC0021S
    @NotNull
    /* JADX INFO: renamed from: b */
    public ResourceLocation mo135a(@NotNull C0680mE c0680mE) {
        return c0680mE.m3044s();
    }
}
