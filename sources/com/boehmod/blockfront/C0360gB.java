package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.BakedGeoModel;

/* JADX INFO: renamed from: com.boehmod.blockfront.gB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gB.class */
public class C0360gB extends C0368gJ<C0713mk> {
    public C0360gB(@NotNull BlockEntityRendererProvider.Context context) {
        super(new C0273eU());
    }

    @Override // com.boehmod.blockfront.C0368gJ, software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public long getInstanceId(@NotNull C0713mk c0713mk) {
        return c0713mk.getBlockPos().asLong();
    }

    @Override // com.boehmod.blockfront.C0368gJ, software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void preRender(PoseStack poseStack, C0713mk c0713mk, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        float fMo3246al = c0713mk.mo3246al();
        if (fMo3246al != 0.0f) {
            poseStack.translate(0.5f, 0.5f, 0.5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(fMo3246al));
            poseStack.translate(-0.5f, -0.5f, -0.5f);
        }
        super.preRender(poseStack, c0713mk, bakedGeoModel, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
    }
}
