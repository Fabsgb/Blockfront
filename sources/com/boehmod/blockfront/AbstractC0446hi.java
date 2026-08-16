package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0750nU;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

/* JADX INFO: renamed from: com.boehmod.blockfront.hi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hi.class */
public abstract class AbstractC0446hi<V extends AbstractC0750nU> extends EntityRenderer<V> {
    /* JADX INFO: renamed from: a */
    public abstract void mo2057a(V v, C0809oa<?> c0809oa, PoseStack poseStack);

    public AbstractC0446hi(EntityRendererProvider.Context context) {
        super(context);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull V v, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        BlockEntityRenderDispatcher blockEntityRenderDispatcher = Minecraft.getInstance().getBlockEntityRenderDispatcher();
        C0712mj c0712mjM3431b = v.m3441aZ() ? v.m3431b() : v.m3430a();
        BlockEntityRenderer renderer = blockEntityRenderDispatcher.getRenderer(c0712mjM3431b);
        if (!(renderer instanceof GeoBlockRenderer)) {
            return;
        }
        GeoBlockRenderer geoBlockRenderer = (GeoBlockRenderer) renderer;
        float fM466g = C0129bt.m466g();
        float fSin = Mth.sin(fM466g / 3.0f);
        float fSin2 = Mth.sin(fM466g / 4.0f);
        float fM3478y = v.m3478y(f2);
        float f3 = 0.7f * fSin * fM3478y;
        float f4 = 0.7f * fSin2 * fM3478y;
        float viewYRot = v.getViewYRot(f2);
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0f - viewYRot));
        v.m3437a().m3494b(poseStack, f2);
        poseStack.mulPose(Axis.XP.rotationDegrees(f3));
        poseStack.mulPose(Axis.ZP.rotationDegrees(f4));
        poseStack.translate(-0.5f, 0.0f, -0.5f);
        mo2057a(v, v.m3436b(), poseStack);
        geoBlockRenderer.render(c0712mjM3431b, f2, poseStack, multiBufferSource, LevelRenderer.getLightColor(v.level(), v.getOnPos().above()), OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(v, f, f2, poseStack, multiBufferSource, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull V v) {
        return C0532jO.m2378d("null");
    }
}
