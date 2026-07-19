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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gP.class */
public final class gP extends EntityRenderer<C0355nd> {
    public static final float fv = 0.2f;
    public static final float fw = 8.0f;
    public static final float fx = 9.0f;
    static final /* synthetic */ boolean cv;

    static {
        cv = !gP.class.desiredAssertionStatus();
    }

    public gP(@NotNull EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.15f;
        this.shadowStrength = 0.75f;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull C0355nd c0355nd, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        if (!cv && clientLevel == null) {
            throw new AssertionError();
        }
        BlockRenderDispatcher blockRenderer = minecraft.getBlockRenderer();
        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
        poseStack.pushPose();
        poseStack.scale(0.2f, 0.2f, 0.2f);
        poseStack.mulPose(Axis.XP.rotationDegrees((c0355nd.tickCount + f2) * 8.0f));
        poseStack.mulPose(Axis.YP.rotationDegrees((c0355nd.tickCount + f2) * 9.0f));
        C0040bk.a(clientLevel, blockRenderer, bufferSource, Blocks.MELON.defaultBlockState(), poseStack, -0.5d, -0.5d, -0.5d);
        poseStack.popPose();
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull C0355nd c0355nd) {
        return InventoryMenu.BLOCK_ATLAS;
    }
}
