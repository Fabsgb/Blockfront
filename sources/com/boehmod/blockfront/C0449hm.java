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

/* JADX INFO: renamed from: com.boehmod.blockfront.hm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hm.class */
public class C0449hm extends RenderLayer<C0680mE, C0303ez> {

    /* JADX INFO: renamed from: a */
    public static final ModelLayerLocation f2837a;

    /* JADX INFO: renamed from: b */
    public static final ModelLayerLocation f2838b;

    /* JADX INFO: renamed from: c */
    public static final ModelLayerLocation f2839c;

    /* JADX INFO: renamed from: d */
    public static final ModelLayerLocation f2840d;

    /* JADX INFO: renamed from: cW */
    private static final ResourceLocation f2841cW;

    /* JADX INFO: renamed from: cX */
    private static final ResourceLocation f2842cX;

    /* JADX INFO: renamed from: cY */
    private static final ResourceLocation f2843cY;

    /* JADX INFO: renamed from: cZ */
    private static final ResourceLocation f2844cZ;

    /* JADX INFO: renamed from: da */
    private static final ResourceLocation f2845da;

    /* JADX INFO: renamed from: a */
    @NotNull
    public final HumanoidModel<C0680mE> f2846a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C0303ez f2847b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C0303ez f2848c;

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C0302ey<C0680mE> f2849a;

    /* JADX INFO: renamed from: cB */
    static final /* synthetic */ boolean f2850cB;

    static {
        f2850cB = !C0449hm.class.desiredAssertionStatus();
        f2837a = new ModelLayerLocation(C0564jv.m2555d(C1230wX.f7003ed), "eyes_layer");
        f2838b = new ModelLayerLocation(C0564jv.m2555d(C1230wX.f7003ed), "game_armor_layer");
        f2839c = new ModelLayerLocation(C0564jv.m2555d(C1230wX.f7003ed), "game_armor_layer_slim");
        f2840d = new ModelLayerLocation(C0564jv.m2555d(C1230wX.f7003ed), "game_backpack_layer");
        f2841cW = C0564jv.m2555d("textures/models/entities/bot/eyes0.png");
        f2842cX = C0564jv.m2555d("textures/models/entities/bot/eyes0left.png");
        f2843cY = C0564jv.m2555d("textures/models/entities/bot/eyes0right.png");
        f2844cZ = C0564jv.m2555d("textures/models/entities/bot/mouth0.png");
        f2845da = C0564jv.m2555d("textures/models/entities/bot/mouth1.png");
    }

    public C0449hm(@NotNull C0409gz c0409gz, @NotNull EntityRendererProvider.Context context) {
        super(c0409gz);
        this.f2846a = new HumanoidModel<>(context.bakeLayer(f2837a));
        this.f2847b = new C0303ez(context.bakeLayer(f2838b), false);
        this.f2848c = new C0303ez(context.bakeLayer(f2839c), true);
        this.f2849a = new C0302ey<>(context.bakeLayer(f2840d));
    }

    /* JADX INFO: renamed from: a */
    public C0303ez m2058a(@NotNull C0680mE c0680mE) {
        return c0680mE.m3074L() ? this.f2848c : this.f2847b;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull C0680mE c0680mE, float f, float f2, float f3, float f4, float f5, float f6) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2850cB && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        boolean z = c0680mE.m3039av() <= 0;
        boolean z2 = c0680mE.m3064az() > 0;
        boolean z3 = z || z2;
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        ResourceLocation resourceLocationM3041a = abstractC0787oFM2688a != null ? c0680mE.m3041a(abstractC0787oFM2688a) : null;
        ResourceLocation resourceLocationM3042b = abstractC0787oFM2688a != null ? c0680mE.m3042b(abstractC0787oFM2688a) : null;
        boolean z4 = (resourceLocationM3041a == null && resourceLocationM3042b == null) ? false : true;
        if (z3 || z4) {
            poseStack.pushPose();
            C0303ez parentModel = getParentModel();
            C0303ez c0303ezM2058a = z4 ? m2058a(c0680mE) : null;
            if (z3) {
                parentModel.copyPropertiesTo(this.f2846a);
                this.f2846a.prepareMobModel(c0680mE, f, f2, f3);
                this.f2846a.setupAnim(c0680mE, f, f2, f4, f5, f6);
                C0301ex.m1591a(this.f2846a, parentModel);
                this.f2846a.hat.visible = true;
            }
            if (c0303ezM2058a != null) {
                parentModel.copyPropertiesTo(c0303ezM2058a);
                c0303ezM2058a.prepareMobModel(c0680mE, f, f2, f3);
                c0303ezM2058a.setupAnim(c0680mE, f, f2, f4, f5, f6);
                C0301ex.m1591a(c0303ezM2058a, parentModel);
                c0303ezM2058a.hat.visible = true;
            }
            if (resourceLocationM3042b != null) {
                this.f2849a.f2293cf = c0303ezM2058a.crouching;
                this.f2849a.setupAnim(c0680mE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
            }
            if (z) {
                m2060a(poseStack, multiBufferSource, c0680mE.f3655eB ? c0680mE.f3654eA ? f2842cX : f2843cY : f2841cW, i);
            }
            if (z2) {
                m2060a(poseStack, multiBufferSource, c0680mE.m3045aF() ? f2845da : f2844cZ, i);
            }
            if (resourceLocationM3041a != null) {
                m2061a(poseStack, multiBufferSource, c0303ezM2058a, resourceLocationM3041a, i);
            }
            if (resourceLocationM3042b != null) {
                m2061a(poseStack, multiBufferSource, this.f2849a, resourceLocationM3042b, i);
            }
            poseStack.popPose();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2060a(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull ResourceLocation resourceLocation, int i) {
        VertexConsumer buffer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(resourceLocation));
        this.f2846a.head.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
        this.f2846a.hat.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
    }

    /* JADX INFO: renamed from: a */
    private void m2061a(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull EntityModel<C0680mE> entityModel, @NotNull ResourceLocation resourceLocation, int i) {
        entityModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(resourceLocation)), i, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
    }
}
