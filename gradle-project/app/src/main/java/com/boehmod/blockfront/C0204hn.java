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

/* JADX INFO: renamed from: com.boehmod.blockfront.hn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hn.class */
public class C0204hn extends RenderLayer<mQ, eC> {
    public static final ModelLayerLocation e = new ModelLayerLocation(C0265jv.d(wX.ee), "eyes_layer");
    public final HumanoidModel<mQ> b;

    public C0204hn(gC gCVar, EntityRendererProvider.Context context) {
        super(gCVar);
        this.b = new HumanoidModel<>(context.bakeLayer(e));
    }

    private void a(@NotNull mQ mQVar, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull EntityModel<mQ> entityModel, int i) {
        entityModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.eyes(mQVar.u())), i, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull mQ mQVar, float f, float f2, float f3, float f4, float f5, float f6) {
        poseStack.pushPose();
        eC parentModel = getParentModel();
        parentModel.copyPropertiesTo(this.b);
        this.b.prepareMobModel(mQVar, f, f2, f3);
        this.b.setupAnim(mQVar, f, f2, f4, f5, f6);
        C0133ex.a(this.b, parentModel);
        this.b.hat.visible = true;
        a(mQVar, poseStack, multiBufferSource, this.b, 256);
        poseStack.popPose();
    }
}
