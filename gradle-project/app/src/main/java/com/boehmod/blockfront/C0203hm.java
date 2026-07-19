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

/* JADX INFO: renamed from: com.boehmod.blockfront.hm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hm.class */
public class C0203hm extends RenderLayer<mE, C0135ez> {
    public static final ModelLayerLocation a;
    public static final ModelLayerLocation b;
    public static final ModelLayerLocation c;
    public static final ModelLayerLocation d;
    private static final ResourceLocation cW;
    private static final ResourceLocation cX;
    private static final ResourceLocation cY;
    private static final ResourceLocation cZ;
    private static final ResourceLocation da;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public final HumanoidModel<mE> f163a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    public final C0135ez f164b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NotNull
    public final C0135ez f165c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public final C0134ey<mE> f166a;
    static final /* synthetic */ boolean cB;

    static {
        cB = !C0203hm.class.desiredAssertionStatus();
        a = new ModelLayerLocation(C0265jv.d(wX.ed), "eyes_layer");
        b = new ModelLayerLocation(C0265jv.d(wX.ed), "game_armor_layer");
        c = new ModelLayerLocation(C0265jv.d(wX.ed), "game_armor_layer_slim");
        d = new ModelLayerLocation(C0265jv.d(wX.ed), "game_backpack_layer");
        cW = C0265jv.d("textures/models/entities/bot/eyes0.png");
        cX = C0265jv.d("textures/models/entities/bot/eyes0left.png");
        cY = C0265jv.d("textures/models/entities/bot/eyes0right.png");
        cZ = C0265jv.d("textures/models/entities/bot/mouth0.png");
        da = C0265jv.d("textures/models/entities/bot/mouth1.png");
    }

    public C0203hm(@NotNull C0189gz c0189gz, @NotNull EntityRendererProvider.Context context) {
        super(c0189gz);
        this.f163a = new HumanoidModel<>(context.bakeLayer(a));
        this.f164b = new C0135ez(context.bakeLayer(b), false);
        this.f165c = new C0135ez(context.bakeLayer(c), true);
        this.f166a = new C0134ey<>(context.bakeLayer(d));
    }

    public C0135ez a(@NotNull mE mEVar) {
        return mEVar.L() ? this.f165c : this.f164b;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull mE mEVar, float f, float f2, float f3, float f4, float f5, float f6) {
        C0297l c0297lB = C0297l.b();
        if (!cB && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        boolean z = mEVar.av() <= 0;
        boolean z2 = mEVar.az() > 0;
        boolean z3 = z || z2;
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        ResourceLocation resourceLocationA = oFVarM591a != null ? mEVar.a(oFVarM591a) : null;
        ResourceLocation resourceLocationB = oFVarM591a != null ? mEVar.b(oFVarM591a) : null;
        boolean z4 = (resourceLocationA == null && resourceLocationB == null) ? false : true;
        if (z3 || z4) {
            poseStack.pushPose();
            C0135ez parentModel = getParentModel();
            C0135ez c0135ezA = z4 ? a(mEVar) : null;
            if (z3) {
                parentModel.copyPropertiesTo(this.f163a);
                this.f163a.prepareMobModel(mEVar, f, f2, f3);
                this.f163a.setupAnim(mEVar, f, f2, f4, f5, f6);
                C0133ex.a(this.f163a, parentModel);
                this.f163a.hat.visible = true;
            }
            if (c0135ezA != null) {
                parentModel.copyPropertiesTo(c0135ezA);
                c0135ezA.prepareMobModel(mEVar, f, f2, f3);
                c0135ezA.setupAnim(mEVar, f, f2, f4, f5, f6);
                C0133ex.a(c0135ezA, parentModel);
                c0135ezA.hat.visible = true;
            }
            if (resourceLocationB != null) {
                this.f166a.cf = c0135ezA.crouching;
                this.f166a.setupAnim(mEVar, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
            }
            if (z) {
                a(poseStack, multiBufferSource, mEVar.eB ? mEVar.eA ? cX : cY : cW, i);
            }
            if (z2) {
                a(poseStack, multiBufferSource, mEVar.aF() ? da : cZ, i);
            }
            if (resourceLocationA != null) {
                a(poseStack, multiBufferSource, c0135ezA, resourceLocationA, i);
            }
            if (resourceLocationB != null) {
                a(poseStack, multiBufferSource, this.f166a, resourceLocationB, i);
            }
            poseStack.popPose();
        }
    }

    private void a(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull ResourceLocation resourceLocation, int i) {
        VertexConsumer buffer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(resourceLocation));
        this.f163a.head.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
        this.f163a.hat.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
    }

    private void a(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull EntityModel<mE> entityModel, @NotNull ResourceLocation resourceLocation, int i) {
        entityModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(resourceLocation)), i, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
    }
}
