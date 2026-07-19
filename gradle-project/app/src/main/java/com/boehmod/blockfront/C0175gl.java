package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.BakedGeoModel;

/* JADX INFO: renamed from: com.boehmod.blockfront.gl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gl.class */
public class C0175gl extends C0183gt<lO> {
    public C0175gl(@NotNull BlockEntityRendererProvider.Context context) {
        super(new eH());
    }

    @Override // com.boehmod.blockfront.C0183gt, software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public long getInstanceId(@NotNull lO lOVar) {
        return lOVar.getBlockPos().asLong();
    }

    @Override // com.boehmod.blockfront.C0183gt, software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void preRender(PoseStack poseStack, lO lOVar, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        float fAf = lOVar.af();
        if (fAf != 0.0f) {
            poseStack.translate(0.5f, 0.5f, 0.5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(fAf));
            poseStack.translate(-0.5f, -0.5f, -0.5f);
        }
        super.preRender(poseStack, lOVar, bakedGeoModel, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
    }
}
