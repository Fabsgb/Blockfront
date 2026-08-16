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

/* JADX INFO: renamed from: com.boehmod.blockfront.gD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gD.class */
public class C0362gD implements BlockEntityRenderer<C0714ml> {
    public C0362gD(BlockEntityRendererProvider.Context context) {
    }

    public int getViewDistance() {
        return 48;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AABB getRenderBoundingBox(@NotNull C0714ml c0714ml) {
        return new AABB(c0714ml.getBlockPos()).inflate(1.0d);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(C0714ml c0714ml, float f, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2) {
        ItemStack itemStackC = c0714ml.m3263c();
        if (itemStackC.isEmpty()) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        BlockState blockState = c0714ml.getBlockState();
        ItemRenderer itemRenderer = minecraft.getItemRenderer();
        Direction value = blockState.getValue(HorizontalDirectionalBlock.FACING);
        BakedModel model = itemRenderer.getModel(itemStackC, clientLevel, (LivingEntity) null, 0);
        poseStack.pushPose();
        poseStack.translate(0.5f, 0.85f, 0.5f);
        poseStack.mulPose(Axis.YP.rotationDegrees(-value.toYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(-90.0f));
        itemRenderer.render(itemStackC, ItemDisplayContext.FIXED, false, poseStack, multiBufferSource, i, OverlayTexture.NO_OVERLAY, model);
        poseStack.popPose();
    }
}
