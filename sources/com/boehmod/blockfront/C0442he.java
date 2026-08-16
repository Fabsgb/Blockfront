package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.he */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/he.class */
public class C0442he extends EntityRenderer<C0734nE> {

    /* JADX INFO: renamed from: c */
    private final ItemRenderer f2798c;

    public C0442he(EntityRendererProvider.Context context, ItemRenderer itemRenderer) {
        super(context);
        this.f2798c = itemRenderer;
        this.shadowRadius = 0.15f;
        this.shadowStrength = 0.75f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int getBlockLightLevel(@NotNull C0734nE c0734nE, @NotNull BlockPos blockPos) {
        return 15;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull C0734nE c0734nE, float f, float f2, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        poseStack.pushPose();
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        ItemStack itemStack = new ItemStack(c0734nE.getDefaultItem());
        BakedModel model = this.f2798c.getModel(itemStack, c0734nE.level(), (LivingEntity) null, c0734nE.getId());
        poseStack.mulPose(Axis.YP.rotationDegrees(-localPlayer.getYHeadRot()));
        poseStack.scale(1.5f, 1.5f, 1.5f);
        poseStack.pushPose();
        poseStack.translate(0.05f, 0.0f, -0.15f);
        this.f2798c.render(itemStack, ItemDisplayContext.GROUND, false, poseStack, multiBufferSource, i, OverlayTexture.NO_OVERLAY, model);
        poseStack.popPose();
        poseStack.popPose();
        super.render(c0734nE, f, f2, poseStack, multiBufferSource, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull C0734nE c0734nE) {
        return InventoryMenu.BLOCK_ATLAS;
    }
}
