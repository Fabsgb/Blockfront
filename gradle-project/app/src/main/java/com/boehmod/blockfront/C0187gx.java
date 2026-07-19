package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gx.class */
public final class C0187gx extends EntityRenderer<mB> {

    @NotNull
    private final ItemRenderer b;

    public C0187gx(@NotNull EntityRendererProvider.Context context, @NotNull ItemRenderer itemRenderer) {
        super(context);
        this.b = itemRenderer;
        this.shadowRadius = 0.15f;
        this.shadowStrength = 0.75f;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull mB mBVar, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        if (Minecraft.getInstance().player == null) {
            return;
        }
        ItemStack itemStack = new ItemStack(b());
        BakedModel model = this.b.getModel(itemStack, mBVar.level(), (LivingEntity) null, mBVar.getId());
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(-mBVar.getYRot()));
        poseStack.translate(0.0f, 0.23f, 0.0f);
        this.b.render(itemStack, ItemDisplayContext.GROUND, false, poseStack, multiBufferSource, i, OverlayTexture.NO_OVERLAY, model);
        poseStack.popPose();
        super.render(mBVar, f, f2, poseStack, multiBufferSource, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull mB mBVar) {
        return InventoryMenu.BLOCK_ATLAS;
    }

    private Item b() {
        return (Item) wY.n.get();
    }
}
