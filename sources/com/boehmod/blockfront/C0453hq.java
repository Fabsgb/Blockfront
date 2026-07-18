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

/* JADX INFO: renamed from: com.boehmod.blockfront.hq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hq.class */
public class C0453hq<T extends Player, M extends EntityModel<T> & ArmedModel & HeadedModel> extends PlayerItemInHandLayer<T, M> {

    /* JADX INFO: renamed from: fQ */
    public static final float f2854fQ = -0.55f;

    /* JADX INFO: renamed from: fR */
    public static final float f2855fR = -0.9f;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ItemInHandRenderer f2856a;

    public C0453hq(@NotNull RenderLayerParent<T, M> renderLayerParent, @NotNull ItemInHandRenderer itemInHandRenderer) {
        super(renderLayerParent, itemInHandRenderer);
        this.f2856a = itemInHandRenderer;
    }

    protected void renderArmWithItem(@NotNull LivingEntity livingEntity, ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull HumanoidArm humanoidArm, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        C0622l c0622lM2667b;
        if (livingEntity instanceof Player) {
            Player player = (Player) livingEntity;
            if (!(livingEntity instanceof C0099bQ) && (c0622lM2667b = C0622l.m2667b()) != null) {
                C0324fT c0324fT = (C0324fT) ((C0326fV) c0622lM2667b.m2670a()).m1133a(player);
                c0324fT.m1649aI();
                if (!c0324fT.m1650N()) {
                    return;
                }
            }
        }
        if (itemStack.is(C1231wY.f7128y) && livingEntity.getUseItem() == itemStack && livingEntity.swingTime == 0) {
            m2064a(livingEntity, itemStack, poseStack, multiBufferSource, i);
        } else {
            super.renderArmWithItem(livingEntity, itemStack, itemDisplayContext, humanoidArm, poseStack, multiBufferSource, i);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2064a(@NotNull LivingEntity livingEntity, @NotNull ItemStack itemStack, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        poseStack.pushPose();
        ModelPart head = getParentModel().getHead();
        float f = head.xRot;
        head.xRot = Mth.clamp(head.xRot, -0.5235988f, 1.5707964f);
        head.translateAndRotate(poseStack);
        head.xRot = f;
        CustomHeadLayer.translateToHead(poseStack, false);
        poseStack.translate(0.0f, -0.55f, -0.9f);
        this.f2856a.renderItem(livingEntity, itemStack, ItemDisplayContext.HEAD, false, poseStack, multiBufferSource, i);
        poseStack.popPose();
    }
}
