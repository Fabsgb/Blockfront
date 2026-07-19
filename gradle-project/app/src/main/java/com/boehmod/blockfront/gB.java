package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.WalkAnimationState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gB.class */
public final class gB extends MobRenderer<mR, eB> {
    private static final ResourceLocation cI = C0265jv.d("textures/models/entities/infected/dog.png");

    public gB(EntityRendererProvider.Context context) {
        super(context, new eB(context.bakeLayer(ModelLayers.WOLF)), 0.5f);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull mR mRVar, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        WalkAnimationState walkAnimationState = mRVar.walkAnimation;
        ((eB) this.model).prepareMobModel(mRVar, walkAnimationState.position(f2), walkAnimationState.speed(f2), f2);
        super.render(mRVar, f, f2, poseStack, multiBufferSource, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull mR mRVar) {
        return cI;
    }
}
