package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.PlayerItemInHandLayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hq.class */
public class C0207hq<T extends Player, M extends EntityModel<T> & ArmedModel & HeadedModel> extends PlayerItemInHandLayer<T, M> {
    public static final float fQ = -0.55f;
    public static final float fR = -0.9f;

    @NotNull
    private final ItemInHandRenderer a;

    public C0207hq(@NotNull RenderLayerParent<T, M> renderLayerParent, @NotNull ItemInHandRenderer itemInHandRenderer) {
        super(renderLayerParent, itemInHandRenderer);
        this.a = itemInHandRenderer;
    }

    protected void renderArmWithItem(@NotNull LivingEntity livingEntity, ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull HumanoidArm humanoidArm, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        C0297l c0297lB;
        if (livingEntity instanceof Player) {
            Player player = (Player) livingEntity;
            if (!(livingEntity instanceof bQ) && (c0297lB = C0297l.b()) != null) {
                fT fTVar = (fT) ((fV) c0297lB.a()).a(player);
                fTVar.aI();
                if (!fTVar.N()) {
                    return;
                }
            }
        }
        if (itemStack.is(wY.y) && livingEntity.getUseItem() == itemStack && livingEntity.swingTime == 0) {
            a(livingEntity, itemStack, poseStack, multiBufferSource, i);
        } else {
            super.renderArmWithItem(livingEntity, itemStack, itemDisplayContext, humanoidArm, poseStack, multiBufferSource, i);
        }
    }

    private void a(@NotNull LivingEntity livingEntity, @NotNull ItemStack itemStack, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        poseStack.pushPose();
        ModelPart head = getParentModel().getHead();
        float f = head.xRot;
        head.xRot = Mth.clamp(head.xRot, -0.5235988f, 1.5707964f);
        head.translateAndRotate(poseStack);
        head.xRot = f;
        CustomHeadLayer.translateToHead(poseStack, false);
        poseStack.translate(0.0f, -0.55f, -0.9f);
        this.a.renderItem(livingEntity, itemStack, ItemDisplayContext.HEAD, false, poseStack, multiBufferSource, i);
        poseStack.popPose();
    }
}
