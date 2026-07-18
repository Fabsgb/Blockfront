package software.bernie.geckolib.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.OutlineBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
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
import software.bernie.geckolib.util.Color;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/renderer/GeoArmorRenderer.class */
public class GeoArmorRenderer<T extends Item & GeoItem> extends HumanoidModel implements GeoRenderer<T> {
    protected final GeoRenderLayersContainer<T> renderLayers;
    protected final GeoModel<T> model;
    protected T animatable;
    protected HumanoidModel<?> baseModel;
    protected float scaleWidth;
    protected float scaleHeight;
    protected Matrix4f entityRenderTranslations;
    protected Matrix4f modelRenderTranslations;
    protected BakedGeoModel lastModel;
    protected GeoBone head;
    protected GeoBone body;
    protected GeoBone rightArm;
    protected GeoBone leftArm;
    protected GeoBone rightLeg;
    protected GeoBone leftLeg;
    protected GeoBone rightBoot;
    protected GeoBone leftBoot;
    protected Entity currentEntity;
    protected ItemStack currentStack;
    protected EquipmentSlot currentSlot;
    protected MultiBufferSource bufferSource;
    protected float partialTick;
    protected float limbSwing;
    protected float limbSwingAmount;
    protected float netHeadYaw;
    protected float headPitch;

    public GeoArmorRenderer(GeoModel<T> model) {
        super(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.PLAYER_INNER_ARMOR));
        this.renderLayers = new GeoRenderLayersContainer<>(this);
        this.scaleWidth = 1.0f;
        this.scaleHeight = 1.0f;
        this.entityRenderTranslations = new Matrix4f();
        this.modelRenderTranslations = new Matrix4f();
        this.lastModel = null;
        this.head = null;
        this.body = null;
        this.rightArm = null;
        this.leftArm = null;
        this.rightLeg = null;
        this.leftLeg = null;
        this.rightBoot = null;
        this.leftBoot = null;
        this.currentEntity = null;
        this.currentStack = null;
        this.currentSlot = null;
        this.bufferSource = null;
        this.model = model;
        this.young = false;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public GeoModel<T> getGeoModel() {
        return this.model;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: getAnimatable */
    public T mo9316getAnimatable() {
        return this.animatable;
    }

    public Entity getCurrentEntity() {
        return this.currentEntity;
    }

    public ItemStack getCurrentStack() {
        return this.currentStack;
    }

    public EquipmentSlot getCurrentSlot() {
        return this.currentSlot;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public long getInstanceId(T animatable) {
        return GeoItem.getId(this.currentStack) + ((long) this.currentEntity.getId());
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public RenderType getRenderType(T animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.armorCutoutNoCull(texture);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public List<GeoRenderLayer<T>> getRenderLayers() {
        return (List<GeoRenderLayer<T>>) this.renderLayers.getRenderLayers();
    }

    public GeoArmorRenderer<T> addRenderLayer(GeoRenderLayer<T> renderLayer) {
        this.renderLayers.addLayer(renderLayer);
        return this;
    }

    public GeoArmorRenderer<T> withScale(float scale) {
        return withScale(scale, scale);
    }

    public GeoArmorRenderer<T> withScale(float scaleWidth, float scaleHeight) {
        this.scaleWidth = scaleWidth;
        this.scaleHeight = scaleHeight;
        return this;
    }

    @Nullable
    public GeoBone getHeadBone(GeoModel<T> model) {
        return model.getBone("armorHead").orElse(null);
    }

    @Nullable
    public GeoBone getBodyBone(GeoModel<T> model) {
        return model.getBone("armorBody").orElse(null);
    }

    @Nullable
    public GeoBone getRightArmBone(GeoModel<T> model) {
        return model.getBone("armorRightArm").orElse(null);
    }

    @Nullable
    public GeoBone getLeftArmBone(GeoModel<T> model) {
        return model.getBone("armorLeftArm").orElse(null);
    }

    @Nullable
    public GeoBone getRightLegBone(GeoModel<T> model) {
        return model.getBone("armorRightLeg").orElse(null);
    }

    @Nullable
    public GeoBone getLeftLegBone(GeoModel<T> model) {
        return model.getBone("armorLeftLeg").orElse(null);
    }

    @Nullable
    public GeoBone getRightBootBone(GeoModel<T> model) {
        return model.getBone("armorRightBoot").orElse(null);
    }

    @Nullable
    public GeoBone getLeftBootBone(GeoModel<T> model) {
        return model.getBone("armorLeftBoot").orElse(null);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public Color getRenderColor(T animatable, float partialTick, int packedLight) {
        return this.currentStack.is(ItemTags.DYEABLE) ? Color.ofOpaque(DyedItemColor.getOrDefault(this.currentStack, -6265536)) : Color.WHITE;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void preRender(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        this.entityRenderTranslations = new Matrix4f(poseStack.last().pose());
        applyBaseModel(this.baseModel);
        grabRelevantBones(model);
        applyBaseTransformations(this.baseModel);
        scaleModelForBaby(poseStack, animatable, partialTick, isReRender);
        scaleModelForRender(this.scaleWidth, this.scaleHeight, poseStack, animatable, model, isReRender, partialTick, packedLight, packedOverlay);
        if (!(this.currentEntity instanceof GeoAnimatable)) {
            applyBoneVisibilityBySlot(this.currentSlot);
        }
    }

    @ApiStatus.Internal
    public void renderToBuffer(PoseStack poseStack, @Nullable VertexConsumer buffer, int packedLight, int packedOverlay, int colour) {
        Minecraft mc = Minecraft.getInstance();
        OutlineBufferSource outlineBufferSourceBufferSource = mc.levelRenderer.renderBuffers.bufferSource();
        if (mc.levelRenderer.shouldShowEntityOutlines() && mc.shouldEntityAppearGlowing(this.currentEntity)) {
            outlineBufferSourceBufferSource = mc.levelRenderer.renderBuffers.outlineBufferSource();
        }
        float partialTick = mc.getTimer().getGameTimeDeltaPartialTick(true);
        RenderType renderType = getRenderType((Item) this.animatable, getTextureLocation(this.animatable), (MultiBufferSource) outlineBufferSourceBufferSource, partialTick);
        VertexConsumer buffer2 = ItemRenderer.getArmorFoilBuffer(outlineBufferSourceBufferSource, renderType, this.currentStack.hasFoil());
        defaultRender(poseStack, this.animatable, outlineBufferSourceBufferSource, null, buffer2, 0.0f, partialTick, packedLight);
        this.animatable = null;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void actuallyRender(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        poseStack.pushPose();
        poseStack.translate(0.0f, 1.5f, 0.0f);
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        if (!isReRender) {
            AnimationState<T> animationState = new AnimationState<>(animatable, 0.0f, 0.0f, partialTick, false);
            long instanceId = getInstanceId(animatable);
            GeoModel<T> currentModel = getGeoModel();
            animationState.setData(DataTickets.TICK, Double.valueOf(animatable.getTick(this.currentEntity)));
            animationState.setData(DataTickets.ITEMSTACK, this.currentStack);
            animationState.setData(DataTickets.ENTITY, this.currentEntity);
            animationState.setData(DataTickets.EQUIPMENT_SLOT, this.currentSlot);
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
        poseStack.popPose();
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void doPostRenderCleanup() {
        this.baseModel = null;
        this.currentEntity = null;
        this.currentStack = null;
        this.animatable = null;
        this.currentSlot = null;
        this.bufferSource = null;
        this.partialTick = 0.0f;
        this.limbSwing = 0.0f;
        this.limbSwingAmount = 0.0f;
        this.netHeadYaw = 0.0f;
        this.headPitch = 0.0f;
    }

    @Deprecated(forRemoval = true)
    public void doArmourPostRenderCleanup() {
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void renderRecursively(PoseStack poseStack, T animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        if (bone.isTrackingMatrices()) {
            Matrix4f poseState = new Matrix4f(poseStack.last().pose());
            bone.setModelSpaceMatrix(RenderUtil.invertAndMultiplyMatrices(poseState, this.modelRenderTranslations));
            bone.setLocalSpaceMatrix(RenderUtil.invertAndMultiplyMatrices(poseState, this.entityRenderTranslations));
        }
        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }

    protected void grabRelevantBones(BakedGeoModel bakedModel) {
        if (this.lastModel == bakedModel) {
            return;
        }
        GeoModel<T> model = getGeoModel();
        this.lastModel = bakedModel;
        this.head = getHeadBone(model);
        this.body = getBodyBone(model);
        this.rightArm = getRightArmBone(model);
        this.leftArm = getLeftArmBone(model);
        this.rightLeg = getRightLegBone(model);
        this.leftLeg = getLeftLegBone(model);
        this.rightBoot = getRightBootBone(model);
        this.leftBoot = getLeftBootBone(model);
    }

    @Deprecated(forRemoval = true)
    public void prepForRender(@Nullable Entity entity, ItemStack stack, @Nullable EquipmentSlot slot, @Nullable HumanoidModel<?> baseModel) {
        if (entity == null || slot == null || baseModel == null) {
            return;
        }
        Minecraft mc = Minecraft.getInstance();
        prepForRender(entity, stack, slot, baseModel, mc.levelRenderer.renderBuffers.bufferSource(), mc.getTimer().getGameTimeDeltaPartialTick(true), 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void prepForRender(Entity entity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> humanoidModel, MultiBufferSource multiBufferSource, float f, float f2, float f3, float f4, float f5) {
        this.baseModel = humanoidModel;
        this.currentEntity = entity;
        this.currentStack = itemStack;
        this.animatable = (T) itemStack.getItem();
        this.currentSlot = equipmentSlot;
        this.bufferSource = multiBufferSource;
        this.partialTick = f;
        this.limbSwing = f2;
        this.limbSwingAmount = f3;
        this.netHeadYaw = f4;
        this.headPitch = f5;
    }

    protected void applyBaseModel(HumanoidModel<?> baseModel) {
        this.young = baseModel.young;
        this.crouching = baseModel.crouching;
        this.riding = baseModel.riding;
        this.rightArmPose = baseModel.rightArmPose;
        this.leftArmPose = baseModel.leftArmPose;
    }

    protected void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
        setAllVisible(false);
        switch (C14731.$SwitchMap$net$minecraft$world$entity$EquipmentSlot[currentSlot.ordinal()]) {
            case 1:
                setBoneVisible(this.head, true);
                break;
            case 2:
                setBoneVisible(this.body, true);
                setBoneVisible(this.rightArm, true);
                setBoneVisible(this.leftArm, true);
                break;
            case 3:
                setBoneVisible(this.rightLeg, true);
                setBoneVisible(this.leftLeg, true);
                break;
            case 4:
                setBoneVisible(this.rightBoot, true);
                setBoneVisible(this.leftBoot, true);
                break;
        }
    }

    /* JADX INFO: renamed from: software.bernie.geckolib.renderer.GeoArmorRenderer$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/renderer/GeoArmorRenderer$1.class */
    static /* synthetic */ class C14731 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$world$entity$EquipmentSlot = new int[EquipmentSlot.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$world$entity$EquipmentSlot[EquipmentSlot.HEAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$world$entity$EquipmentSlot[EquipmentSlot.CHEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$world$entity$EquipmentSlot[EquipmentSlot.LEGS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$net$minecraft$world$entity$EquipmentSlot[EquipmentSlot.FEET.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public void applyBoneVisibilityByPart(EquipmentSlot currentSlot, ModelPart currentPart, HumanoidModel<?> model) {
        setAllVisible(false);
        currentPart.visible = true;
        GeoBone bone = null;
        if (currentPart == model.hat || currentPart == model.head) {
            bone = this.head;
        } else if (currentPart == model.body) {
            bone = this.body;
        } else if (currentPart == model.leftArm) {
            bone = this.leftArm;
        } else if (currentPart == model.rightArm) {
            bone = this.rightArm;
        } else if (currentPart == model.leftLeg) {
            bone = currentSlot == EquipmentSlot.FEET ? this.leftBoot : this.leftLeg;
        } else if (currentPart == model.rightLeg) {
            bone = currentSlot == EquipmentSlot.FEET ? this.rightBoot : this.rightLeg;
        }
        if (bone != null) {
            bone.setHidden(false);
        }
    }

    protected void applyBaseTransformations(HumanoidModel<?> baseModel) {
        if (this.head != null) {
            ModelPart headPart = baseModel.head;
            RenderUtil.matchModelPartRot(headPart, this.head);
            this.head.updatePosition(headPart.x, -headPart.y, headPart.z);
        }
        if (this.body != null) {
            ModelPart bodyPart = baseModel.body;
            RenderUtil.matchModelPartRot(bodyPart, this.body);
            this.body.updatePosition(bodyPart.x, -bodyPart.y, bodyPart.z);
        }
        if (this.rightArm != null) {
            ModelPart rightArmPart = baseModel.rightArm;
            RenderUtil.matchModelPartRot(rightArmPart, this.rightArm);
            this.rightArm.updatePosition(rightArmPart.x + 5.0f, 2.0f - rightArmPart.y, rightArmPart.z);
        }
        if (this.leftArm != null) {
            ModelPart leftArmPart = baseModel.leftArm;
            RenderUtil.matchModelPartRot(leftArmPart, this.leftArm);
            this.leftArm.updatePosition(leftArmPart.x - 5.0f, 2.0f - leftArmPart.y, leftArmPart.z);
        }
        if (this.rightLeg != null) {
            ModelPart rightLegPart = baseModel.rightLeg;
            RenderUtil.matchModelPartRot(rightLegPart, this.rightLeg);
            this.rightLeg.updatePosition(rightLegPart.x + 2.0f, 12.0f - rightLegPart.y, rightLegPart.z);
            if (this.rightBoot != null) {
                RenderUtil.matchModelPartRot(rightLegPart, this.rightBoot);
                this.rightBoot.updatePosition(rightLegPart.x + 2.0f, 12.0f - rightLegPart.y, rightLegPart.z);
            }
        }
        if (this.leftLeg != null) {
            ModelPart leftLegPart = baseModel.leftLeg;
            RenderUtil.matchModelPartRot(leftLegPart, this.leftLeg);
            this.leftLeg.updatePosition(leftLegPart.x - 2.0f, 12.0f - leftLegPart.y, leftLegPart.z);
            if (this.leftBoot != null) {
                RenderUtil.matchModelPartRot(leftLegPart, this.leftBoot);
                this.leftBoot.updatePosition(leftLegPart.x - 2.0f, 12.0f - leftLegPart.y, leftLegPart.z);
            }
        }
    }

    public void setAllVisible(boolean pVisible) {
        super.setAllVisible(pVisible);
        setBoneVisible(this.head, pVisible);
        setBoneVisible(this.body, pVisible);
        setBoneVisible(this.rightArm, pVisible);
        setBoneVisible(this.leftArm, pVisible);
        setBoneVisible(this.rightLeg, pVisible);
        setBoneVisible(this.leftLeg, pVisible);
        setBoneVisible(this.rightBoot, pVisible);
        setBoneVisible(this.leftBoot, pVisible);
    }

    public void scaleModelForBaby(PoseStack poseStack, T animatable, float partialTick, boolean isReRender) {
        if (!this.young || isReRender) {
            return;
        }
        if (this.currentSlot == EquipmentSlot.HEAD) {
            if (this.baseModel.scaleHead) {
                float headScale = 1.5f / this.baseModel.babyHeadScale;
                poseStack.scale(headScale, headScale, headScale);
            }
            poseStack.translate(0.0f, this.baseModel.babyYHeadOffset / 16.0f, this.baseModel.babyZHeadOffset / 16.0f);
            return;
        }
        float bodyScale = 1.0f / this.baseModel.babyBodyScale;
        poseStack.scale(bodyScale, bodyScale, bodyScale);
        poseStack.translate(0.0f, this.baseModel.bodyYOffset / 16.0f, 0.0f);
    }

    protected void setBoneVisible(@Nullable GeoBone bone, boolean visible) {
        if (bone == null) {
            return;
        }
        bone.setHidden(!visible);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void updateAnimatedTextureFrame(T animatable) {
        if (this.currentEntity != null) {
            AnimatableTexture.setAndUpdate(getTextureLocation(animatable));
        }
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void fireCompileRenderLayersEvent() {
        GeckoLibServices.Client.EVENTS.fireCompileArmorRenderLayers(this);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public boolean firePreRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return GeckoLibServices.Client.EVENTS.fireArmorPreRender(this, poseStack, model, bufferSource, partialTick, packedLight);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void firePostRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        GeckoLibServices.Client.EVENTS.fireArmorPostRender(this, poseStack, model, bufferSource, partialTick, packedLight);
    }
}
