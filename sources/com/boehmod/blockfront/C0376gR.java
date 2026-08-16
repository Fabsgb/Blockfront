package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.WalkAnimationState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gR.class */
public final class C0376gR extends MobRenderer<C0769nn, C0267eO> {

    /* JADX INFO: renamed from: cI */
    private static final ResourceLocation f2525cI = C0532jO.m2378d("textures/models/entities/infected/dog.png");

    public C0376gR(EntityRendererProvider.Context context) {
        super(context, new C0267eO(context.bakeLayer(ModelLayers.WOLF)), 0.5f);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull C0769nn c0769nn, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        WalkAnimationState walkAnimationState = c0769nn.walkAnimation;
        ((C0267eO) this.model).prepareMobModel(c0769nn, walkAnimationState.position(f2), walkAnimationState.speed(f2), f2);
        super.render(c0769nn, f, f2, poseStack, multiBufferSource, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull C0769nn c0769nn) {
        return f2525cI;
    }
}
