package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hn.class */
public class C0450hn extends RenderLayer<C0692mQ, C0254eC> {

    /* JADX INFO: renamed from: e */
    public static final ModelLayerLocation f2851e = new ModelLayerLocation(C0564jv.m2555d(C1230wX.f7004ee), "eyes_layer");

    /* JADX INFO: renamed from: b */
    public final HumanoidModel<C0692mQ> f2852b;

    public C0450hn(C0360gC c0360gC, EntityRendererProvider.Context context) {
        super(c0360gC);
        this.f2852b = new HumanoidModel<>(context.bakeLayer(f2851e));
    }

    /* JADX INFO: renamed from: a */
    private void m2062a(@NotNull C0692mQ c0692mQ, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull EntityModel<C0692mQ> entityModel, int i) {
        entityModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.eyes(c0692mQ.mo3128u())), i, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull C0692mQ c0692mQ, float f, float f2, float f3, float f4, float f5, float f6) {
        poseStack.pushPose();
        C0254eC parentModel = getParentModel();
        parentModel.copyPropertiesTo(this.f2852b);
        this.f2852b.prepareMobModel(c0692mQ, f, f2, f3);
        this.f2852b.setupAnim(c0692mQ, f, f2, f4, f5, f6);
        C0301ex.m1591a(this.f2852b, parentModel);
        this.f2852b.hat.visible = true;
        m2062a(c0692mQ, poseStack, multiBufferSource, this.f2852b, 256);
        poseStack.popPose();
    }
}
