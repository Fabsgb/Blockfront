package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.renderer.GeoRenderer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gV.class */
public class gV extends BlockEntityWithoutLevelRenderer implements GeoRenderer<C0535tv> {

    @NotNull
    private final eF<C0535tv> a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private C0535tv f133a;

    public gV(@NotNull C0535tv c0535tv) {
        this(c0535tv, Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels(), new eF());
    }

    public gV(@NotNull C0535tv c0535tv, @NotNull BlockEntityRenderDispatcher blockEntityRenderDispatcher, @NotNull EntityModelSet entityModelSet, @NotNull eF<C0535tv> eFVar) {
        super(blockEntityRenderDispatcher, entityModelSet);
        this.a = eFVar;
        this.f133a = c0535tv;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public eF<C0535tv> getGeoModel() {
        return this.a;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public C0535tv mo2142getAnimatable() {
        return this.f133a;
    }

    public void renderByItem(@NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2) {
        this.f133a = (C0535tv) itemStack.getItem();
        float fA = C0634xm.a(Minecraft.getInstance());
        eF<C0535tv> geoModel = getGeoModel();
        AnimationState animationState = new AnimationState(this.f133a, 0.0f, 0.0f, fA, false);
        animationState.setData(DataTickets.ITEMSTACK, itemStack);
        animationState.animationTick += (double) fA;
        this.a.handleAnimations(this.f133a, getInstanceId(this.f133a), animationState, fA);
        BakedGeoModel bakedModel = geoModel.getBakedModel(geoModel.getModelResource(mo2142getAnimatable()));
        RenderType renderTypeEntityTranslucentCull = RenderType.entityTranslucentCull(getTextureLocation(this.f133a));
        actuallyRender(poseStack, this.f133a, bakedModel, renderTypeEntityTranslucentCull, multiBufferSource, multiBufferSource.getBuffer(renderTypeEntityTranslucentCull), false, fA, 15728880, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void fireCompileRenderLayersEvent() {
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public boolean firePreRenderEvent(PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i) {
        return true;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void firePostRenderEvent(PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i) {
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void updateAnimatedTextureFrame(C0535tv c0535tv) {
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(C0535tv c0535tv) {
        return this.a.getTextureResource(c0535tv);
    }
}
