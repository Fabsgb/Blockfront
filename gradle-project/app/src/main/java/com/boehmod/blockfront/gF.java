package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gF.class */
public final class gF extends EntityRenderer<C0363nl> {
    private static final List<ResourceLocation> K = new ObjectArrayList();
    public static final int jd = 5;

    static {
        for (int i = 0; i < 5; i++) {
            K.add(C0265jv.d("textures/models/entities/flame" + i + ".png"));
        }
    }

    public gF(@NotNull EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.15f;
        this.shadowStrength = 0.75f;
    }

    private static void a(VertexConsumer vertexConsumer, Matrix4f matrix4f, PoseStack.Pose pose, float f, float f2, float f3, float f4, float f5) {
        vertexConsumer.addVertex(matrix4f, f, f2, 0.0f).setColor(1.0f, 1.0f, 1.0f, f3).setUv(f4, f5).setOverlay(OverlayTexture.NO_OVERLAY).setUv2(15728880, 15728880).setNormal(pose, 0.0f, 1.0f, 0.0f);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean shouldRender(@NotNull C0363nl c0363nl, @NotNull Frustum frustum, double d, double d2, double d3) {
        return true;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(C0363nl c0363nl, float f, float f2, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        poseStack.pushPose();
        float fClamp = Mth.clamp(0.1f + (0.15f * c0363nl.tickCount), 0.01f, 1.0f);
        float fG = C0040bk.g();
        float fMin = Math.min(1.5f, 0.1f * c0363nl.tickCount);
        poseStack.scale(fMin, fMin, fMin);
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0f));
        VertexConsumer buffer = Minecraft.getInstance().renderBuffers().bufferSource().getBuffer(RenderType.itemEntityTranslucentCull(K.get((int) ((fG / 3.0f) % 4.0f))));
        PoseStack.Pose poseLast = poseStack.last();
        Matrix4f matrix4fPose = poseLast.pose();
        a(buffer, matrix4fPose, poseLast, -0.5f, -0.25f, fClamp, 0.0f, 1.0f);
        a(buffer, matrix4fPose, poseLast, 0.5f, -0.25f, fClamp, 1.0f, 1.0f);
        a(buffer, matrix4fPose, poseLast, 0.5f, 0.75f, fClamp, 1.0f, 0.0f);
        a(buffer, matrix4fPose, poseLast, -0.5f, 0.75f, fClamp, 0.0f, 0.0f);
        poseStack.popPose();
        super.render(c0363nl, f, f2, poseStack, multiBufferSource, 15728880);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull C0363nl c0363nl) {
        return (ResourceLocation) K.getFirst();
    }
}
