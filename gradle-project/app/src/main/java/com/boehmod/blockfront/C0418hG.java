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

/* JADX INFO: renamed from: com.boehmod.blockfront.hG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hG.class */
public class C0418hG<T extends Player, M extends EntityModel<T> & ArmedModel & HeadedModel> extends PlayerItemInHandLayer<T, M> {

    /* JADX INFO: renamed from: ga */
    public static final float f2684ga = -0.55f;

    /* JADX INFO: renamed from: gb */
    public static final float f2685gb = -0.9f;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ItemInHandRenderer f2686a;

    public C0418hG(@NotNull RenderLayerParent<T, M> renderLayerParent, @NotNull ItemInHandRenderer itemInHandRenderer) {
        super(renderLayerParent, itemInHandRenderer);
        this.f2686a = itemInHandRenderer;
    }

    protected void renderArmWithItem(@NotNull LivingEntity livingEntity, ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull HumanoidArm humanoidArm, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        C0623l c0623lM2852b;
        if (livingEntity instanceof Player) {
            Player player = (Player) livingEntity;
            if (!(livingEntity instanceof C0109bZ) && (c0623lM2852b = C0623l.m2852b()) != null) {
                C0394gj c0394gj = (C0394gj) ((C0396gl) c0623lM2852b.m2855a()).m1150a(player);
                c0394gj.m1859aO();
                if (!c0394gj.m1860P()) {
                    return;
                }
            }
        }
        if (itemStack.is(C1308xv.f7693y) && livingEntity.getUseItem() == itemStack && livingEntity.swingTime == 0) {
            m1966a(livingEntity, itemStack, poseStack, multiBufferSource, i);
        } else {
            super.renderArmWithItem(livingEntity, itemStack, itemDisplayContext, humanoidArm, poseStack, multiBufferSource, i);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1966a(@NotNull LivingEntity livingEntity, @NotNull ItemStack itemStack, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        poseStack.pushPose();
        ModelPart head = getParentModel().getHead();
        float f = head.xRot;
        head.xRot = Mth.clamp(head.xRot, -0.5235988f, 1.5707964f);
        head.translateAndRotate(poseStack);
        head.xRot = f;
        CustomHeadLayer.translateToHead(poseStack, false);
        poseStack.translate(0.0f, -0.55f, -0.9f);
        this.f2686a.renderItem(livingEntity, itemStack, ItemDisplayContext.HEAD, false, poseStack, multiBufferSource, i);
        poseStack.popPose();
    }
}
