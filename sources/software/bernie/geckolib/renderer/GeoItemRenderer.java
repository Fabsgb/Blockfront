package software.bernie.geckolib.renderer;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.cache.texture.AnimatableTexture;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayersContainer;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/renderer/GeoItemRenderer.class */
public class GeoItemRenderer<T extends Item & GeoAnimatable> extends BlockEntityWithoutLevelRenderer implements GeoRenderer<T> {
    protected final GeoRenderLayersContainer<T> renderLayers;
    protected final GeoModel<T> model;
    protected ItemStack currentItemStack;
    protected ItemDisplayContext renderPerspective;
    protected T animatable;
    protected float scaleWidth;
    protected float scaleHeight;
    protected boolean useEntityGuiLighting;
    protected Matrix4f itemRenderTranslations;
    protected Matrix4f modelRenderTranslations;

    public GeoItemRenderer(GeoModel<T> model) {
        this(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels(), model);
    }

    public GeoItemRenderer(BlockEntityRenderDispatcher dispatcher, EntityModelSet modelSet, GeoModel<T> model) {
        super(dispatcher, modelSet);
        this.renderLayers = new GeoRenderLayersContainer<>(this);
        this.scaleWidth = 1.0f;
        this.scaleHeight = 1.0f;
        this.useEntityGuiLighting = false;
        this.itemRenderTranslations = new Matrix4f();
        this.modelRenderTranslations = new Matrix4f();
        this.model = model;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public GeoModel<T> getGeoModel() {
        return this.model;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: getAnimatable, reason: merged with bridge method [inline-methods] */
    public T mo9316getAnimatable() {
        return this.animatable;
    }

    public ItemStack getCurrentItemStack() {
        return this.currentItemStack;
    }

    public GeoItemRenderer<T> useAlternateGuiLighting() {
        this.useEntityGuiLighting = true;
        return this;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public long getInstanceId(T animatable) {
        return GeoItem.getId(this.currentItemStack);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public ResourceLocation getTextureLocation(T animatable) {
        return super.getTextureLocation(animatable);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public List<GeoRenderLayer<T>> getRenderLayers() {
        return (List<GeoRenderLayer<T>>) this.renderLayers.getRenderLayers();
    }

    public GeoItemRenderer<T> addRenderLayer(GeoRenderLayer<T> renderLayer) {
        this.renderLayers.addLayer(renderLayer);
        return this;
    }

    public GeoItemRenderer<T> withScale(float scale) {
        return withScale(scale, scale);
    }

    public GeoItemRenderer<T> withScale(float scaleWidth, float scaleHeight) {
        this.scaleWidth = scaleWidth;
        this.scaleHeight = scaleHeight;
        return this;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void preRender(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        this.itemRenderTranslations = new Matrix4f(poseStack.last().pose());
        scaleModelForRender(this.scaleWidth, this.scaleHeight, poseStack, animatable, model, isReRender, partialTick, packedLight, packedOverlay);
        if (!isReRender) {
            poseStack.translate(0.5f, 0.51f, 0.5f);
        }
    }

    @ApiStatus.Internal
    public void renderByItem(ItemStack itemStack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i2) {
        this.animatable = (T) itemStack.getItem();
        this.currentItemStack = itemStack;
        this.renderPerspective = itemDisplayContext;
        float gameTimeDeltaPartialTick = Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true);
        if (itemDisplayContext == ItemDisplayContext.GUI) {
            renderInGui(itemDisplayContext, poseStack, multiBufferSource, i, i2, gameTimeDeltaPartialTick);
        } else {
            RenderType renderType = getRenderType(this.animatable, getTextureLocation((Item) this.animatable), multiBufferSource, gameTimeDeltaPartialTick);
            defaultRender(poseStack, this.animatable, multiBufferSource, renderType, ItemRenderer.getFoilBufferDirect(multiBufferSource, renderType, false, this.currentItemStack != null && this.currentItemStack.hasFoil()), 0.0f, gameTimeDeltaPartialTick, i);
        }
        this.animatable = null;
    }

    protected void renderInGui(ItemDisplayContext transformType, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, float partialTick) {
        MultiBufferSource.BufferSource bufferSource2;
        setupLightingForGuiRender();
        if (bufferSource instanceof MultiBufferSource.BufferSource) {
            MultiBufferSource.BufferSource bufferSource22 = (MultiBufferSource.BufferSource) bufferSource;
            bufferSource2 = bufferSource22;
        } else {
            bufferSource2 = Minecraft.getInstance().levelRenderer.renderBuffers.bufferSource();
        }
        MultiBufferSource.BufferSource defaultBufferSource = bufferSource2;
        RenderType renderType = getRenderType(this.animatable, getTextureLocation((Item) this.animatable), defaultBufferSource, partialTick);
        VertexConsumer buffer = ItemRenderer.getFoilBufferDirect(bufferSource, renderType, true, this.currentItemStack != null && this.currentItemStack.hasFoil());
        poseStack.pushPose();
        defaultRender(poseStack, this.animatable, defaultBufferSource, renderType, buffer, 0.0f, partialTick, packedLight);
        defaultBufferSource.endBatch();
        RenderSystem.enableDepthTest();
        Lighting.setupFor3DItems();
        poseStack.popPose();
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void actuallyRender(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        if (!isReRender) {
            AnimationState<T> animationState = new AnimationState<>(animatable, 0.0f, 0.0f, partialTick, false);
            long instanceId = getInstanceId((Item) animatable);
            GeoModel<T> currentModel = getGeoModel();
            animationState.setData(DataTickets.TICK, Double.valueOf(animatable.getTick(this.currentItemStack)));
            animationState.setData(DataTickets.ITEM_RENDER_PERSPECTIVE, this.renderPerspective);
            animationState.setData(DataTickets.ITEMSTACK, this.currentItemStack);
            animatable.getAnimatableInstanceCache().getManagerForId(instanceId).setData(DataTickets.ITEM_RENDER_PERSPECTIVE, this.renderPerspective);
            Objects.requireNonNull(animationState);
            currentModel.addAdditionalStateData(animatable, instanceId, (x$0, x$1) -> {
                animationState.setData(x$0, x$1);
            });
            currentModel.handleAnimations(animatable, instanceId, animationState, partialTick);
        }
        this.modelRenderTranslations = new Matrix4f(poseStack.last().pose());
        if (buffer != null) {
            super.actuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        }
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void doPostRenderCleanup() {
        this.animatable = null;
        this.currentItemStack = null;
        this.renderPerspective = null;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void renderRecursively(PoseStack poseStack, T animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        if (bone.isTrackingMatrices()) {
            Matrix4f poseState = new Matrix4f(poseStack.last().pose());
            bone.setModelSpaceMatrix(RenderUtil.invertAndMultiplyMatrices(poseState, this.modelRenderTranslations));
            bone.setLocalSpaceMatrix(RenderUtil.invertAndMultiplyMatrices(poseState, this.itemRenderTranslations));
        }
        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }

    public void setupLightingForGuiRender() {
        if (this.useEntityGuiLighting) {
            Lighting.setupForEntityInInventory();
        } else {
            Lighting.setupForFlatItems();
        }
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void updateAnimatedTextureFrame(T animatable) {
        AnimatableTexture.setAndUpdate(getTextureLocation((Item) animatable));
    }

    public void fireCompileRenderLayersEvent() {
        GeckoLibServices.Client.EVENTS.fireCompileItemRenderLayers(this);
    }

    public boolean firePreRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return GeckoLibServices.Client.EVENTS.fireItemPreRender(this, poseStack, model, bufferSource, partialTick, packedLight);
    }

    public void firePostRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        GeckoLibServices.Client.EVENTS.fireItemPostRender(this, poseStack, model, bufferSource, partialTick, packedLight);
    }
}
