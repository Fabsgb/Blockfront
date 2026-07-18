package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0779ny;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.gS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gS.class */
public abstract class AbstractC0376gS<V extends AbstractC0779ny> extends EntityRenderer<V> {
    /* JADX INFO: renamed from: a */
    public abstract void mo1801a(V v, C0733nE<?> c0733nE, PoseStack poseStack);

    public AbstractC0376gS(EntityRendererProvider.Context context) {
        super(context);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull V v, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        BlockEntityRenderDispatcher blockEntityRenderDispatcher = Minecraft.getInstance().getBlockEntityRenderDispatcher();
        C0636lN c0636lNM3498b = v.m3504aP() ? v.m3498b() : v.m3497a();
        BlockEntityRenderer renderer = blockEntityRenderDispatcher.getRenderer(c0636lNM3498b);
        if (!(renderer instanceof GeoBlockRenderer)) {
            return;
        }
        GeoBlockRenderer geoBlockRenderer = (GeoBlockRenderer) renderer;
        float fM366g = C0119bk.m366g();
        float fSin = Mth.sin(fM366g / 3.0f);
        float fSin2 = Mth.sin(fM366g / 4.0f);
        float fM3541v = v.m3541v(f2);
        float f3 = 0.7f * fSin * fM3541v;
        float f4 = 0.7f * fSin2 * fM3541v;
        float viewYRot = v.getViewYRot(f2);
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0f - viewYRot));
        v.m3500a().m3307b(poseStack, f2);
        poseStack.mulPose(Axis.XP.rotationDegrees(f3));
        poseStack.mulPose(Axis.ZP.rotationDegrees(f4));
        poseStack.translate(-0.5f, 0.0f, -0.5f);
        mo1801a(v, v.m3499b(), poseStack);
        geoBlockRenderer.render(c0636lNM3498b, f2, poseStack, multiBufferSource, LevelRenderer.getLightColor(v.level(), v.getOnPos().above()), OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(v, f, f2, poseStack, multiBufferSource, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull V v) {
        return C0564jv.m2555d("null");
    }
}
