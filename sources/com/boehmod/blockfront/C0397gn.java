package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gn.class */
public class C0397gn implements BlockEntityRenderer<C0638lP> {
    public C0397gn(BlockEntityRendererProvider.Context context) {
    }

    public int getViewDistance() {
        return 48;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AABB getRenderBoundingBox(@NotNull C0638lP c0638lP) {
        return new AABB(c0638lP.getBlockPos()).inflate(1.0d);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(C0638lP c0638lP, float f, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2) {
        ItemStack itemStackA = c0638lP.m2832a();
        if (itemStackA.isEmpty()) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        BlockState blockState = c0638lP.getBlockState();
        ItemRenderer itemRenderer = minecraft.getItemRenderer();
        Direction value = blockState.getValue(HorizontalDirectionalBlock.FACING);
        BakedModel model = itemRenderer.getModel(itemStackA, clientLevel, (LivingEntity) null, 0);
        poseStack.pushPose();
        poseStack.translate(0.5f, 0.85f, 0.5f);
        poseStack.mulPose(Axis.YP.rotationDegrees(-value.toYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(-90.0f));
        itemRenderer.render(itemStackA, ItemDisplayContext.FIXED, false, poseStack, multiBufferSource, i, OverlayTexture.NO_OVERLAY, model);
        poseStack.popPose();
    }
}
