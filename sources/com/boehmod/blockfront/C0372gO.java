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

/* JADX INFO: renamed from: com.boehmod.blockfront.gO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gO.class */
public class C0372gO extends EntityRenderer<C0763ni> {

    /* JADX INFO: renamed from: c */
    private final ItemRenderer f2460c;

    public C0372gO(EntityRendererProvider.Context context, ItemRenderer itemRenderer) {
        super(context);
        this.f2460c = itemRenderer;
        this.shadowRadius = 0.15f;
        this.shadowStrength = 0.75f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int getBlockLightLevel(@NotNull C0763ni c0763ni, @NotNull BlockPos blockPos) {
        return 15;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull C0763ni c0763ni, float f, float f2, PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        poseStack.pushPose();
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        ItemStack itemStack = new ItemStack(c0763ni.getDefaultItem());
        BakedModel model = this.f2460c.getModel(itemStack, c0763ni.level(), (LivingEntity) null, c0763ni.getId());
        poseStack.mulPose(Axis.YP.rotationDegrees(-localPlayer.getYHeadRot()));
        poseStack.scale(1.5f, 1.5f, 1.5f);
        poseStack.pushPose();
        poseStack.translate(0.05f, 0.0f, -0.15f);
        this.f2460c.render(itemStack, ItemDisplayContext.GROUND, false, poseStack, multiBufferSource, i, OverlayTexture.NO_OVERLAY, model);
        poseStack.popPose();
        poseStack.popPose();
        super.render(c0763ni, f, f2, poseStack, multiBufferSource, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull C0763ni c0763ni) {
        return InventoryMenu.BLOCK_ATLAS;
    }
}
