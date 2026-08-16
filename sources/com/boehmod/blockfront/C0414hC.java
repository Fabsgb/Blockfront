package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hC.class */
public class C0414hC extends RenderLayer<C0756na, C0265eM> {

    /* JADX INFO: renamed from: a */
    public static final ModelLayerLocation f2666a;

    /* JADX INFO: renamed from: b */
    public static final ModelLayerLocation f2667b;

    /* JADX INFO: renamed from: c */
    public static final ModelLayerLocation f2668c;

    /* JADX INFO: renamed from: d */
    public static final ModelLayerLocation f2669d;

    /* JADX INFO: renamed from: cW */
    private static final ResourceLocation f2670cW;

    /* JADX INFO: renamed from: cX */
    private static final ResourceLocation f2671cX;

    /* JADX INFO: renamed from: cY */
    private static final ResourceLocation f2672cY;

    /* JADX INFO: renamed from: cZ */
    private static final ResourceLocation f2673cZ;

    /* JADX INFO: renamed from: da */
    private static final ResourceLocation f2674da;

    /* JADX INFO: renamed from: c */
    public static final ResourceLocation[] f2675c;

    /* JADX INFO: renamed from: a */
    @NotNull
    public final HumanoidModel<C0756na> f2676a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C0265eM f2677b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C0265eM f2678c;

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C0264eL<C0756na> f2679a;

    /* JADX INFO: renamed from: cK */
    static final /* synthetic */ boolean f2680cK;

    static {
        f2680cK = !C0414hC.class.desiredAssertionStatus();
        f2666a = new ModelLayerLocation(C0532jO.m2378d(C1307xu.f7568eo), "eyes_layer");
        f2667b = new ModelLayerLocation(C0532jO.m2378d(C1307xu.f7568eo), "game_armor_layer");
        f2668c = new ModelLayerLocation(C0532jO.m2378d(C1307xu.f7568eo), "game_armor_layer_slim");
        f2669d = new ModelLayerLocation(C0532jO.m2378d(C1307xu.f7568eo), "game_backpack_layer");
        f2670cW = C0532jO.m2378d("textures/models/entities/bot/eyes0.png");
        f2671cX = C0532jO.m2378d("textures/models/entities/bot/eyes0left.png");
        f2672cY = C0532jO.m2378d("textures/models/entities/bot/eyes0right.png");
        f2673cZ = C0532jO.m2378d("textures/models/entities/bot/mouth0.png");
        f2674da = C0532jO.m2378d("textures/models/entities/bot/mouth1.png");
        f2675c = new ResourceLocation[]{f2670cW, f2671cX, f2672cY, f2673cZ, f2674da};
    }

    public C0414hC(@NotNull C0374gP c0374gP, @NotNull EntityRendererProvider.Context context) {
        super(c0374gP);
        this.f2676a = new HumanoidModel<>(context.bakeLayer(f2666a));
        this.f2677b = new C0265eM(context.bakeLayer(f2667b), false);
        this.f2678c = new C0265eM(context.bakeLayer(f2668c), true);
        this.f2679a = new C0264eL<>(context.bakeLayer(f2669d));
    }

    /* JADX INFO: renamed from: a */
    public C0265eM m1960a(@NotNull C0756na c0756na) {
        return c0756na.m3581M() ? this.f2678c : this.f2677b;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull C0756na c0756na, float f, float f2, float f3, float f4, float f5, float f6) {
        ResourceLocation resourceLocation;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2680cK && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        boolean z = c0756na.m3547aK() <= 0;
        boolean z2 = c0756na.m3571aO() > 0;
        boolean z3 = z || z2;
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        ResourceLocation resourceLocationM3548a = abstractC0863pbM2874a != null ? c0756na.m3548a(abstractC0863pbM2874a) : null;
        ResourceLocation resourceLocationM3549b = abstractC0863pbM2874a != null ? c0756na.m3549b(abstractC0863pbM2874a) : null;
        boolean z4 = (resourceLocationM3548a == null && resourceLocationM3549b == null) ? false : true;
        if (z3 || z4) {
            poseStack.pushPose();
            C0265eM parentModel = getParentModel();
            C0265eM c0265eMM1960a = z4 ? m1960a(c0756na) : null;
            if (z3) {
                parentModel.copyPropertiesTo(this.f2676a);
                this.f2676a.prepareMobModel(c0756na, f, f2, f3);
                this.f2676a.setupAnim(c0756na, f, f2, f4, f5, f6);
                C0263eK.m1495a(this.f2676a, parentModel);
                this.f2676a.hat.visible = true;
            }
            if (c0265eMM1960a != null) {
                parentModel.copyPropertiesTo(c0265eMM1960a);
                c0265eMM1960a.prepareMobModel(c0756na, f, f2, f3);
                c0265eMM1960a.setupAnim(c0756na, f, f2, f4, f5, f6);
                C0263eK.m1495a(c0265eMM1960a, parentModel);
                c0265eMM1960a.hat.visible = true;
            }
            if (resourceLocationM3549b != null) {
                this.f2679a.f2163cn = c0265eMM1960a.crouching;
                this.f2679a.setupAnim(c0756na, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
            }
            if (z) {
                if (c0756na.f4218eV) {
                    resourceLocation = c0756na.f4217eU ? f2671cX : f2672cY;
                } else {
                    resourceLocation = f2670cW;
                }
                m1962a(poseStack, multiBufferSource, resourceLocation, i);
            }
            if (z2) {
                m1962a(poseStack, multiBufferSource, c0756na.m3552aQ() ? f2674da : f2673cZ, i);
            }
            if (resourceLocationM3548a != null) {
                m1963a(poseStack, multiBufferSource, c0265eMM1960a, resourceLocationM3548a, i);
            }
            if (resourceLocationM3549b != null) {
                m1963a(poseStack, multiBufferSource, this.f2679a, resourceLocationM3549b, i);
            }
            poseStack.popPose();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1962a(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull ResourceLocation resourceLocation, int i) {
        VertexConsumer buffer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(resourceLocation));
        this.f2676a.head.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
        this.f2676a.hat.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
    }

    /* JADX INFO: renamed from: a */
    private void m1963a(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull EntityModel<C0756na> entityModel, @NotNull ResourceLocation resourceLocation, int i) {
        entityModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(resourceLocation)), i, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
    }
}
