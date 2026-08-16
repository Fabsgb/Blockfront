package com.boehmod.blockfront;

import com.boehmod.blockfront.C0756na;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hE.class */
public class C0416hE<T extends C0756na, M extends EntityModel<T> & ArmedModel> extends ItemInHandLayer<T, M> {
    public C0416hE(@NotNull RenderLayerParent<T, M> renderLayerParent, @NotNull ItemInHandRenderer itemInHandRenderer) {
        super(renderLayerParent, itemInHandRenderer);
    }

    protected void renderArmWithItem(@NotNull LivingEntity livingEntity, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull HumanoidArm humanoidArm, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        if (livingEntity instanceof C0756na) {
            C0756na c0756na = (C0756na) livingEntity;
            c0756na.m3534bO();
            if (!c0756na.m3535P()) {
                return;
            }
        }
        super.renderArmWithItem(livingEntity, itemStack, itemDisplayContext, humanoidArm, poseStack, multiBufferSource, i);
    }
}
