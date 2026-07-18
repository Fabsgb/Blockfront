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

/* JADX INFO: renamed from: com.boehmod.blockfront.gP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gP.class */
public final class C0373gP extends EntityRenderer<C0758nd> {

    /* JADX INFO: renamed from: fv */
    public static final float f2461fv = 0.2f;

    /* JADX INFO: renamed from: fw */
    public static final float f2462fw = 8.0f;

    /* JADX INFO: renamed from: fx */
    public static final float f2463fx = 9.0f;

    /* JADX INFO: renamed from: cv */
    static final /* synthetic */ boolean f2464cv;

    static {
        f2464cv = !C0373gP.class.desiredAssertionStatus();
    }

    public C0373gP(@NotNull EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.15f;
        this.shadowStrength = 0.75f;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull C0758nd c0758nd, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        if (!f2464cv && clientLevel == null) {
            throw new AssertionError();
        }
        BlockRenderDispatcher blockRenderer = minecraft.getBlockRenderer();
        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
        poseStack.pushPose();
        poseStack.scale(0.2f, 0.2f, 0.2f);
        poseStack.mulPose(Axis.XP.rotationDegrees((c0758nd.tickCount + f2) * 8.0f));
        poseStack.mulPose(Axis.YP.rotationDegrees((c0758nd.tickCount + f2) * 9.0f));
        C0119bk.m531a(clientLevel, blockRenderer, bufferSource, Blocks.MELON.defaultBlockState(), poseStack, -0.5d, -0.5d, -0.5d);
        poseStack.popPose();
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull C0758nd c0758nd) {
        return InventoryMenu.BLOCK_ATLAS;
    }
}
