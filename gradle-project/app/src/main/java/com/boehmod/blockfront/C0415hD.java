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

/* JADX INFO: renamed from: com.boehmod.blockfront.hD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hD.class */
public class C0415hD extends RenderLayer<C0768nm, C0268eP> {

    /* JADX INFO: renamed from: e */
    public static final ModelLayerLocation f2681e = new ModelLayerLocation(C0532jO.m2378d(C1307xu.f7569ep), "eyes_layer");

    /* JADX INFO: renamed from: b */
    public final HumanoidModel<C0768nm> f2682b;

    public C0415hD(C0377gS c0377gS, EntityRendererProvider.Context context) {
        super(c0377gS);
        this.f2682b = new HumanoidModel<>(context.bakeLayer(f2681e));
    }

    /* JADX INFO: renamed from: a */
    private void m1964a(@NotNull C0768nm c0768nm, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull EntityModel<C0768nm> entityModel, int i) {
        entityModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.eyes(c0768nm.mo3635v())), i, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull C0768nm c0768nm, float f, float f2, float f3, float f4, float f5, float f6) {
        poseStack.pushPose();
        C0268eP parentModel = getParentModel();
        parentModel.copyPropertiesTo(this.f2682b);
        this.f2682b.prepareMobModel(c0768nm, f, f2, f3);
        this.f2682b.setupAnim(c0768nm, f, f2, f4, f5, f6);
        C0263eK.m1495a(this.f2682b, parentModel);
        this.f2682b.hat.visible = true;
        m1964a(c0768nm, poseStack, multiBufferSource, this.f2682b, 256);
        poseStack.popPose();
    }
}
