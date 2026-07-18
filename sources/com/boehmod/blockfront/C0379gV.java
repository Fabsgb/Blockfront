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

/* JADX INFO: renamed from: com.boehmod.blockfront.gV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gV.class */
public class C0379gV extends BlockEntityWithoutLevelRenderer implements GeoRenderer<C1095tv> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0257eF<C1095tv> f2465a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private C1095tv f2466a;

    public C0379gV(@NotNull C1095tv c1095tv) {
        this(c1095tv, Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels(), new C0257eF());
    }

    public C0379gV(@NotNull C1095tv c1095tv, @NotNull BlockEntityRenderDispatcher blockEntityRenderDispatcher, @NotNull EntityModelSet entityModelSet, @NotNull C0257eF<C1095tv> c0257eF) {
        super(blockEntityRenderDispatcher, entityModelSet);
        this.f2465a = c0257eF;
        this.f2466a = c1095tv;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a */
    public C0257eF<C1095tv> getGeoModel() {
        return this.f2465a;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a */
    public C1095tv mo9316getAnimatable() {
        return this.f2466a;
    }

    public void renderByItem(@NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2) {
        this.f2466a = (C1095tv) itemStack.getItem();
        float fM7861a = C1290xm.m7861a(Minecraft.getInstance());
        C0257eF<C1095tv> geoModel = getGeoModel();
        AnimationState animationState = new AnimationState(this.f2466a, 0.0f, 0.0f, fM7861a, false);
        animationState.setData(DataTickets.ITEMSTACK, itemStack);
        animationState.animationTick += (double) fM7861a;
        this.f2465a.handleAnimations(this.f2466a, getInstanceId(this.f2466a), animationState, fM7861a);
        BakedGeoModel bakedModel = geoModel.getBakedModel(geoModel.getModelResource(mo9316getAnimatable()));
        RenderType renderTypeEntityTranslucentCull = RenderType.entityTranslucentCull(getTextureLocation(this.f2466a));
        actuallyRender(poseStack, this.f2466a, bakedModel, renderTypeEntityTranslucentCull, multiBufferSource, multiBufferSource.getBuffer(renderTypeEntityTranslucentCull), false, fM7861a, 15728880, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
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
    /* JADX INFO: renamed from: a */
    public void updateAnimatedTextureFrame(C1095tv c1095tv) {
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: d */
    public ResourceLocation getTextureLocation(C1095tv c1095tv) {
        return this.f2465a.getTextureResource(c1095tv);
    }
}
