package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.BakedGeoModel;

/* JADX INFO: renamed from: com.boehmod.blockfront.gl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gl.class */
public class C0395gl extends C0403gt<C0637lO> {
    public C0395gl(@NotNull BlockEntityRendererProvider.Context context) {
        super(new C0259eH());
    }

    @Override // com.boehmod.blockfront.C0403gt, software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public long getInstanceId(@NotNull C0637lO c0637lO) {
        return c0637lO.getBlockPos().asLong();
    }

    @Override // com.boehmod.blockfront.C0403gt, software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void preRender(PoseStack poseStack, C0637lO c0637lO, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        float fMo2815af = c0637lO.mo2815af();
        if (fMo2815af != 0.0f) {
            poseStack.translate(0.5f, 0.5f, 0.5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(fMo2815af));
            poseStack.translate(-0.5f, -0.5f, -0.5f);
        }
        super.preRender(poseStack, c0637lO, bakedGeoModel, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
    }
}
