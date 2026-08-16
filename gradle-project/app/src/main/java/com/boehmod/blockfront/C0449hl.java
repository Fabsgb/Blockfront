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

/* JADX INFO: renamed from: com.boehmod.blockfront.hl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hl.class */
public class C0449hl extends BlockEntityWithoutLevelRenderer implements GeoRenderer<C1068tT> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0271eS<C1068tT> f2803a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private C1068tT f2804a;

    public C0449hl(@NotNull C1068tT c1068tT) {
        this(c1068tT, Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels(), new C0271eS());
    }

    public C0449hl(@NotNull C1068tT c1068tT, @NotNull BlockEntityRenderDispatcher blockEntityRenderDispatcher, @NotNull EntityModelSet entityModelSet, @NotNull C0271eS<C1068tT> c0271eS) {
        super(blockEntityRenderDispatcher, entityModelSet);
        this.f2803a = c0271eS;
        this.f2804a = c1068tT;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0271eS<C1068tT> getGeoModel() {
        return this.f2803a;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1068tT mo9710getAnimatable() {
        return this.f2804a;
    }

    public void renderByItem(@NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2) {
        this.f2804a = (C1068tT) itemStack.getItem();
        float fM7188a = C1270xJ.m7188a(Minecraft.getInstance());
        C0271eS<C1068tT> geoModel = getGeoModel();
        AnimationState animationState = new AnimationState(this.f2804a, 0.0f, 0.0f, fM7188a, false);
        animationState.setData(DataTickets.ITEMSTACK, itemStack);
        animationState.animationTick += (double) fM7188a;
        this.f2803a.handleAnimations(this.f2804a, getInstanceId(this.f2804a), animationState, fM7188a);
        BakedGeoModel bakedModel = geoModel.getBakedModel(geoModel.getModelResource(mo9710getAnimatable()));
        RenderType renderTypeEntityTranslucentCull = RenderType.entityTranslucentCull(getTextureLocation(this.f2804a));
        actuallyRender(poseStack, this.f2804a, bakedModel, renderTypeEntityTranslucentCull, multiBufferSource, multiBufferSource.getBuffer(renderTypeEntityTranslucentCull), false, fM7188a, 15728880, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
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
    public void updateAnimatedTextureFrame(C1068tT c1068tT) {
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(C1068tT c1068tT) {
        return this.f2803a.getTextureResource(c1068tT);
    }
}
