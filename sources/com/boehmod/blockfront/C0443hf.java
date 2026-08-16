package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hf.class */
public final class C0443hf extends EntityRenderer<C0781nz> {

    /* JADX INFO: renamed from: fF */
    public static final float f2799fF = 0.2f;

    /* JADX INFO: renamed from: fG */
    public static final float f2800fG = 8.0f;

    /* JADX INFO: renamed from: fH */
    public static final float f2801fH = 9.0f;

    /* JADX INFO: renamed from: cE */
    static final /* synthetic */ boolean f2802cE;

    static {
        f2802cE = !C0443hf.class.desiredAssertionStatus();
    }

    public C0443hf(@NotNull EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.15f;
        this.shadowStrength = 0.75f;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull C0781nz c0781nz, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        if (!f2802cE && clientLevel == null) {
            throw new AssertionError();
        }
        BlockRenderDispatcher blockRenderer = minecraft.getBlockRenderer();
        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
        poseStack.pushPose();
        poseStack.scale(0.2f, 0.2f, 0.2f);
        poseStack.mulPose(Axis.XP.rotationDegrees((c0781nz.tickCount + f2) * 8.0f));
        poseStack.mulPose(Axis.YP.rotationDegrees((c0781nz.tickCount + f2) * 9.0f));
        C0129bt.m633a(clientLevel, blockRenderer, bufferSource, Blocks.MELON.defaultBlockState(), poseStack, -0.5d, -0.5d, -0.5d);
        poseStack.popPose();
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull C0781nz c0781nz) {
        return InventoryMenu.BLOCK_ATLAS;
    }
}
