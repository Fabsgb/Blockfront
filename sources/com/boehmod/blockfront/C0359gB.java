package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.WalkAnimationState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gB.class */
public final class C0359gB extends MobRenderer<C0693mR, C0253eB> {

    /* JADX INFO: renamed from: cI */
    private static final ResourceLocation f2449cI = C0564jv.m2555d("textures/models/entities/infected/dog.png");

    public C0359gB(EntityRendererProvider.Context context) {
        super(context, new C0253eB(context.bakeLayer(ModelLayers.WOLF)), 0.5f);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull C0693mR c0693mR, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        WalkAnimationState walkAnimationState = c0693mR.walkAnimation;
        ((C0253eB) this.model).prepareMobModel(c0693mR, walkAnimationState.position(f2), walkAnimationState.speed(f2), f2);
        super.render(c0693mR, f, f2, poseStack, multiBufferSource, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull C0693mR c0693mR) {
        return f2449cI;
    }
}
