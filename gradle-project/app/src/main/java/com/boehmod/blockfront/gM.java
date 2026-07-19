package com.boehmod.blockfront;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gM.class */
public class gM extends EntityRenderer<mW> {
    public gM(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.15f;
        this.shadowStrength = 0.75f;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull mW mWVar, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) {
            return;
        }
        RenderSystem.enableDepthTest();
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(-C0634xm.e(minecraft.player.yHeadRot, minecraft.player.yHeadRotO, f2)));
        poseStack.translate(1.5f, 0.0f, 0.0f);
        poseStack.scale(3.0f, 3.0f, 3.0f);
        poseStack.translate(0.0f, 1.0f, 0.0f);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0f));
        GuiGraphics guiGraphics = new GuiGraphics(minecraft, minecraft.renderBuffers().bufferSource());
        guiGraphics.pose().mulPose(poseStack.last().pose());
        C0040bk.b(poseStack, guiGraphics, getTextureLocation(mWVar), 0, 0, 1, 1);
        poseStack.popPose();
        super.render(mWVar, f, f2, poseStack, multiBufferSource, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull mW mWVar) {
        return C0265jv.d("textures/models/entities/nextbot/" + mWVar.H() + ".png");
    }
}
