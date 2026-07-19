package com.boehmod.blockfront;

import com.boehmod.blockfront.vW;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.gz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gz.class */
public final class C0189gz extends HumanoidMobRenderer<mE, C0135ez> implements S<mE> {
    public static final ResourceLocation cH;

    @NotNull
    private final C0135ez a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final C0203hm f147a;
    static final /* synthetic */ boolean ct;

    static {
        ct = !C0189gz.class.desiredAssertionStatus();
        cH = C0265jv.d("textures/models/entities/corpse/burned.png");
    }

    public C0189gz(EntityRendererProvider.Context context) {
        super(context, new C0135ez(context.bakeLayer(ModelLayers.PLAYER), false), 0.5f);
        this.a = new C0135ez(context.bakeLayer(ModelLayers.PLAYER_SLIM), true);
        this.layers.clear();
        addLayer(new C0205ho(this, context.getItemInHandRenderer()));
        C0203hm c0203hm = new C0203hm(this, context);
        this.f147a = c0203hm;
        addLayer(c0203hm);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(mE mEVar, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        if (mEVar.isDeadOrDying()) {
            return;
        }
        C0135ez c0135ez = this.model;
        if (mEVar.L()) {
            this.model = this.a;
        }
        super.render(mEVar, f, f2, poseStack, multiBufferSource, i);
        this.model = c0135ez;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void scale(@NotNull mE mEVar, @NotNull PoseStack poseStack, float f) {
        poseStack.scale(0.9375f, 0.9375f, 0.9375f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public float getShadowRadius(@NotNull mE mEVar) {
        if (mEVar.isDeadOrDying()) {
            return 0.0f;
        }
        return super.getShadowRadius(mEVar);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(mE mEVar) {
        return mEVar.s();
    }

    @Override // com.boehmod.blockfront.S
    @NotNull
    public Collection<G> a(@NotNull F f, vW.a aVar, @NotNull mE mEVar, @NotNull R r) {
        C0297l c0297lB = C0297l.b();
        if (!ct && c0297lB == null) {
            throw new AssertionError("Mod manager is null!");
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        ResourceLocation resourceLocationA = aVar.cU() ? cH : a(mEVar);
        ResourceLocation resourceLocationA2 = oFVarM591a != null ? mEVar.a(oFVarM591a) : null;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        G gA = a(I.BODY, r, mEVar, resourceLocationA, resourceLocationA2, c0135ez -> {
            return c0135ez.body;
        }, c0135ez2 -> {
            return c0135ez2.i;
        }, 1.0d);
        objectArrayList.add(gA);
        G gA2 = a(I.HEAD, r, mEVar, resourceLocationA, resourceLocationA2, c0135ez3 -> {
            return c0135ez3.head;
        }, c0135ez4 -> {
            return c0135ez4.hat;
        }, 0.4d);
        objectArrayList.add(gA2);
        G gA3 = a(I.ARM, r, mEVar, resourceLocationA, resourceLocationA2, c0135ez5 -> {
            return c0135ez5.leftArm;
        }, c0135ez6 -> {
            return c0135ez6.e;
        }, 1.0d);
        objectArrayList.add(gA3);
        G gA4 = a(I.ARM, r, mEVar, resourceLocationA, resourceLocationA2, c0135ez7 -> {
            return c0135ez7.rightArm;
        }, c0135ez8 -> {
            return c0135ez8.f;
        }, 1.0d);
        objectArrayList.add(gA4);
        G gA5 = a(I.LEG, r, mEVar, resourceLocationA, resourceLocationA2, c0135ez9 -> {
            return c0135ez9.leftLeg;
        }, c0135ez10 -> {
            return c0135ez10.g;
        }, 1.0d);
        objectArrayList.add(gA5);
        G gA6 = a(I.LEG, r, mEVar, resourceLocationA, resourceLocationA2, c0135ez11 -> {
            return c0135ez11.rightLeg;
        }, c0135ez12 -> {
            return c0135ez12.h;
        }, 1.0d);
        objectArrayList.add(gA6);
        Vector3dc vector3dc = G.a;
        Vector3dc vector3dc2 = G.b;
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        boolean z = hN.w.T() && aVar.cV();
        gA2.a(gA, G.c, (Quaterniondc) new Quaterniond());
        if (!z || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            gA6.a(gA, vector3dc, (Quaterniondc) new Quaterniond().rotateZ(-0.39269908169872414d));
        } else {
            gA6.a(new J(100, 20, 2, (SimpleParticleType) wZ.np.get()));
        }
        if (!z || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            gA5.a(gA, vector3dc, (Quaterniondc) new Quaterniond().rotateZ(0.39269908169872414d));
        } else {
            gA5.a(new J(100, 20, 2, (SimpleParticleType) wZ.np.get()));
        }
        if (!z || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            gA4.a(gA, vector3dc2, (Quaterniondc) new Quaterniond().rotateZ(-1.5707963705062866d));
        } else {
            gA4.a(new J(100, 20, 2, (SimpleParticleType) wZ.np.get()));
        }
        if (!z || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            gA3.a(gA, vector3dc2, (Quaterniondc) new Quaterniond().rotateZ(1.5707963705062866d));
        } else {
            gA3.a(new J(100, 20, 2, (SimpleParticleType) wZ.np.get()));
        }
        if (hN.w.T()) {
            gA.a(new J(100, 20, 2, (SimpleParticleType) wZ.np.get()));
        }
        ResourceLocation resourceLocationB = oFVarM591a != null ? mEVar.b(oFVarM591a) : null;
        if (resourceLocationB != null) {
            C0135ez c0135ez13 = mEVar.L() ? this.a : this.model;
            G gA7 = F.a(r, I.BACKPACK, 1.0d, C0134ey.a(c0135ez13.body.storePose(), c0135ez13.crouching), H.a(resourceLocationB, this.f147a.f166a.c, C.BASIC), H.a(resourceLocationB, this.f147a.f166a.d, C.COSMETIC), H.a(resourceLocationB, this.f147a.f166a.a, C.COSMETIC), H.a(resourceLocationB, this.f147a.f166a.b, C.COSMETIC));
            if (!z || threadLocalRandomCurrent.nextFloat() < 0.8f) {
                gA7.a(gA, (Vector3dc) new Vector3d(), (Quaterniondc) new Quaterniond().rotateZ(0.0d));
            }
            objectArrayList.add(gA7);
        }
        return Collections.unmodifiableCollection(objectArrayList);
    }

    private G a(@NotNull I i, @NotNull R r, @NotNull mE mEVar, @NotNull ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2, @NotNull Function<C0135ez, ModelPart> function, @NotNull Function<C0135ez, ModelPart> function2, double d) {
        C0135ez c0135ez = mEVar.L() ? this.a : (C0135ez) this.model;
        ModelPart modelPartApply = function.apply(c0135ez);
        if (resourceLocation2 != null) {
            C0135ez c0135ezA = this.f147a.a(mEVar);
            return F.a(r, i, d, modelPartApply.storePose(), H.a(resourceLocation, modelPartApply, C.BASIC), H.a(resourceLocation2, function.apply(c0135ezA), C.COSMETIC), H.a(resourceLocation2, function2.apply(c0135ezA), C.COSMETIC));
        }
        return F.a(r, i, d, modelPartApply.storePose(), H.a(resourceLocation, modelPartApply, C.BASIC), H.a(resourceLocation, function2.apply(c0135ez), C.COSMETIC));
    }

    @Override // com.boehmod.blockfront.S
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ResourceLocation a(@NotNull mE mEVar) {
        return mEVar.s();
    }
}
