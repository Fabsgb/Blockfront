package software.bernie.geckolib.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Team;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.cache.texture.AnimatableTexture;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayersContainer;
import software.bernie.geckolib.util.ClientUtil;
import software.bernie.geckolib.util.Color;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/renderer/GeoEntityRenderer.class */
public class GeoEntityRenderer<T extends Entity & GeoAnimatable> extends EntityRenderer<T> implements GeoRenderer<T> {
    protected final GeoRenderLayersContainer<T> renderLayers;
    protected final GeoModel<T> model;
    protected T animatable;
    protected float scaleWidth;
    protected float scaleHeight;
    protected Matrix4f entityRenderTranslations;
    protected Matrix4f modelRenderTranslations;

    public GeoEntityRenderer(EntityRendererProvider.Context context, EntityType<? extends T> entityType) {
        this(context, new DefaultedEntityGeoModel(BuiltInRegistries.ENTITY_TYPE.getKey(entityType)));
    }

    public GeoEntityRenderer(EntityRendererProvider.Context renderManager, GeoModel<T> model) {
        super(renderManager);
        this.renderLayers = new GeoRenderLayersContainer<>(this);
        this.scaleWidth = 1.0f;
        this.scaleHeight = 1.0f;
        this.entityRenderTranslations = new Matrix4f();
        this.modelRenderTranslations = new Matrix4f();
        this.model = model;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public GeoModel<T> getGeoModel() {
        return this.model;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: getAnimatable, reason: merged with bridge method [inline-methods] */
    public T mo9710getAnimatable() {
        return this.animatable;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public long getInstanceId(T animatable) {
        return animatable.getId();
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public ResourceLocation getTextureLocation(T animatable) {
        return super.getTextureLocation(animatable);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public List<GeoRenderLayer<T>> getRenderLayers() {
        return (List<GeoRenderLayer<T>>) this.renderLayers.getRenderLayers();
    }

    public GeoEntityRenderer<T> addRenderLayer(GeoRenderLayer<T> renderLayer) {
        this.renderLayers.addLayer(renderLayer);
        return this;
    }

    public GeoEntityRenderer<T> withScale(float scale) {
        return withScale(scale, scale);
    }

    public GeoEntityRenderer<T> withScale(float scaleWidth, float scaleHeight) {
        this.scaleWidth = scaleWidth;
        this.scaleHeight = scaleHeight;
        return this;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public Color getRenderColor(T animatable, float partialTick, int packedLight) {
        Color color = super.getRenderColor(animatable, partialTick, packedLight);
        if (animatable.isInvisible() && !animatable.isInvisibleTo(ClientUtil.getClientPlayer())) {
            color = Color.ofARGB(Mth.ceil((color.getAlpha() * 38) / 255.0f), color.getRed(), color.getGreen(), color.getBlue());
        }
        return color;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    @Nullable
    public RenderType getRenderType(T animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        boolean invisible = animatable.isInvisible();
        if (invisible && !animatable.isInvisibleTo(ClientUtil.getClientPlayer())) {
            return RenderType.itemEntityTranslucentCull(texture);
        }
        if (!invisible) {
            return super.getRenderType(animatable, texture, bufferSource, partialTick);
        }
        if (Minecraft.getInstance().shouldEntityAppearGlowing(animatable)) {
            return RenderType.outline(texture);
        }
        return null;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void preRender(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        this.entityRenderTranslations = new Matrix4f(poseStack.last().pose());
        scaleModelForRender(this.scaleWidth, this.scaleHeight, poseStack, animatable, model, isReRender, partialTick, packedLight, packedOverlay);
    }

    @ApiStatus.Internal
    public void render(T entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        this.animatable = entity;
        defaultRender(poseStack, entity, bufferSource, null, null, entityYaw, partialTick, packedLight);
        this.animatable = null;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void actuallyRender(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        LivingEntity livingEntity;
        Direction bedDirection;
        poseStack.pushPose();
        if (animatable instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) animatable;
            livingEntity = entity;
        } else {
            livingEntity = null;
        }
        LivingEntity livingEntity2 = livingEntity;
        boolean shouldSit = animatable.isPassenger() && animatable.getVehicle() != null;
        float lerpBodyRot = livingEntity2 == null ? 0.0f : Mth.rotLerp(partialTick, livingEntity2.yBodyRotO, livingEntity2.yBodyRot);
        float lerpHeadRot = livingEntity2 == null ? 0.0f : Mth.rotLerp(partialTick, livingEntity2.yHeadRotO, livingEntity2.yHeadRot);
        float netHeadYaw = lerpHeadRot - lerpBodyRot;
        if (shouldSit) {
            LivingEntity vehicle = animatable.getVehicle();
            if (vehicle instanceof LivingEntity) {
                LivingEntity livingentity = vehicle;
                float clampedHeadYaw = Mth.clamp(Mth.wrapDegrees(lerpHeadRot - Mth.rotLerp(partialTick, livingentity.yBodyRotO, livingentity.yBodyRot)), -85.0f, 85.0f);
                lerpBodyRot = lerpHeadRot - clampedHeadYaw;
                if (clampedHeadYaw * clampedHeadYaw > 2500.0f) {
                    lerpBodyRot += clampedHeadYaw * 0.2f;
                }
                netHeadYaw = lerpHeadRot - lerpBodyRot;
            }
        }
        if (animatable.getPose() == Pose.SLEEPING && livingEntity2 != null && (bedDirection = livingEntity2.getBedOrientation()) != null) {
            float eyePosOffset = livingEntity2.getEyeHeight(Pose.STANDING) - 0.1f;
            poseStack.translate((-bedDirection.getStepX()) * eyePosOffset, 0.0f, (-bedDirection.getStepZ()) * eyePosOffset);
        }
        float nativeScale = livingEntity2 != null ? livingEntity2.getScale() : 1.0f;
        float ageInTicks = ((Entity) animatable).tickCount + partialTick;
        float limbSwingAmount = 0.0f;
        float limbSwing = 0.0f;
        poseStack.scale(nativeScale, nativeScale, nativeScale);
        applyRotations(animatable, poseStack, ageInTicks, lerpBodyRot, partialTick, nativeScale);
        if (!shouldSit && animatable.isAlive() && livingEntity2 != null) {
            limbSwingAmount = livingEntity2.walkAnimation.speed(partialTick);
            limbSwing = livingEntity2.walkAnimation.position(partialTick);
            if (livingEntity2.isBaby()) {
                limbSwing *= 3.0f;
            }
            if (limbSwingAmount > 1.0f) {
                limbSwingAmount = 1.0f;
            }
        }
        if (!isReRender) {
            float headPitch = Mth.lerp(partialTick, ((Entity) animatable).xRotO, animatable.getXRot());
            float motionThreshold = getMotionAnimThreshold(animatable);
            Vec3 velocity = animatable.getDeltaMovement();
            float avgVelocity = (float) ((Math.abs(velocity.x) + Math.abs(velocity.z)) / 2.0d);
            AnimationState<T> animationState = new AnimationState<>(animatable, limbSwing, limbSwingAmount, partialTick, avgVelocity >= motionThreshold && limbSwingAmount != 0.0f);
            long instanceId = getInstanceId((Entity) animatable);
            GeoModel<T> currentModel = getGeoModel();
            animationState.setData(DataTickets.TICK, Double.valueOf(animatable.getTick(animatable)));
            animationState.setData(DataTickets.ENTITY, animatable);
            animationState.setData(DataTickets.ENTITY_MODEL_DATA, new EntityModelData(shouldSit, livingEntity2 != null && livingEntity2.isBaby(), -netHeadYaw, -headPitch));
            Objects.requireNonNull(animationState);
            currentModel.addAdditionalStateData(animatable, instanceId, (x$0, x$1) -> {
                animationState.setData(x$0, x$1);
            });
            currentModel.handleAnimations(animatable, instanceId, animationState, partialTick);
        }
        poseStack.translate(0.0f, 0.01f, 0.0f);
        this.modelRenderTranslations = new Matrix4f(poseStack.last().pose());
        if (buffer != null) {
            super.actuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        }
        poseStack.popPose();
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void applyRenderLayers(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (!animatable.isSpectator()) {
            super.applyRenderLayers(poseStack, animatable, model, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void renderFinal(PoseStack poseStack, T animatable, BakedGeoModel model, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay, int colour) {
        Mob mob;
        Entity leashHolder;
        super.render(animatable, 0.0f, partialTick, poseStack, bufferSource, packedLight);
        if ((animatable instanceof Mob) && (leashHolder = (mob = (Mob) animatable).getLeashHolder()) != null) {
            renderLeash(mob, partialTick, poseStack, bufferSource, leashHolder);
        }
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void doPostRenderCleanup() {
        this.animatable = null;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void renderRecursively(PoseStack poseStack, T animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        poseStack.pushPose();
        RenderUtil.translateMatrixToBone(poseStack, bone);
        RenderUtil.translateToPivotPoint(poseStack, bone);
        RenderUtil.rotateMatrixAroundBone(poseStack, bone);
        RenderUtil.scaleMatrixForBone(poseStack, bone);
        if (bone.isTrackingMatrices()) {
            Matrix4f poseState = new Matrix4f(poseStack.last().pose());
            Matrix4f localMatrix = RenderUtil.invertAndMultiplyMatrices(poseState, this.entityRenderTranslations);
            bone.setModelSpaceMatrix(RenderUtil.invertAndMultiplyMatrices(poseState, this.modelRenderTranslations));
            bone.setLocalSpaceMatrix(RenderUtil.translateMatrix(localMatrix, getRenderOffset(this.animatable, 1.0f).toVector3f()));
            bone.setWorldSpaceMatrix(RenderUtil.translateMatrix(new Matrix4f(localMatrix), this.animatable.position().toVector3f()));
        }
        RenderUtil.translateAwayFromPivotPoint(poseStack, bone);
        VertexConsumer buffer2 = checkAndRefreshBuffer(isReRender, buffer, bufferSource, renderType);
        renderCubesOfBone(poseStack, bone, buffer2, packedLight, packedOverlay, colour);
        if (!isReRender) {
            applyRenderLayersForBone(poseStack, animatable, bone, renderType, bufferSource, buffer2, partialTick, packedLight, packedOverlay);
        }
        renderChildBones(poseStack, animatable, bone, renderType, bufferSource, buffer2, isReRender, partialTick, packedLight, packedOverlay, colour);
        poseStack.popPose();
    }

    @Deprecated(forRemoval = true)
    protected void applyRotations(T animatable, PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTick) {
        applyRotations(animatable, poseStack, ageInTicks, rotationYaw, partialTick, 1.0f);
    }

    protected void applyRotations(T animatable, PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTick, float nativeScale) {
        if (isShaking(animatable)) {
            rotationYaw += (float) (Math.cos(((double) ((Entity) animatable).tickCount) * 3.25d) * 3.141592653589793d * 0.4d);
        }
        if (!animatable.hasPose(Pose.SLEEPING)) {
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0f - rotationYaw));
        }
        if (animatable instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) animatable;
            if (livingEntity.deathTime > 0) {
                float deathRotation = (((livingEntity.deathTime + partialTick) - 1.0f) / 20.0f) * 1.6f;
                poseStack.mulPose(Axis.ZP.rotationDegrees(Math.min(Mth.sqrt(deathRotation), 1.0f) * getDeathMaxRotation(animatable)));
                return;
            }
            if (livingEntity.isAutoSpinAttack()) {
                poseStack.mulPose(Axis.XP.rotationDegrees((-90.0f) - livingEntity.getXRot()));
                poseStack.mulPose(Axis.YP.rotationDegrees((livingEntity.tickCount + partialTick) * (-75.0f)));
            } else {
                if (animatable.hasPose(Pose.SLEEPING)) {
                    Direction bedOrientation = livingEntity.getBedOrientation();
                    poseStack.mulPose(Axis.YP.rotationDegrees(bedOrientation != null ? RenderUtil.getDirectionAngle(bedOrientation) : rotationYaw));
                    poseStack.mulPose(Axis.ZP.rotationDegrees(getDeathMaxRotation(animatable)));
                    poseStack.mulPose(Axis.YP.rotationDegrees(270.0f));
                    return;
                }
                if (LivingEntityRenderer.isEntityUpsideDown(livingEntity)) {
                    poseStack.translate(0.0f, (animatable.getBbHeight() + 0.1f) / nativeScale, 0.0f);
                    poseStack.mulPose(Axis.ZP.rotationDegrees(180.0f));
                }
            }
        }
    }

    protected float getDeathMaxRotation(T animatable) {
        return 90.0f;
    }

    public double getNameRenderCutoffDistance(T animatable) {
        return animatable.isDiscrete() ? 32.0d : 64.0d;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public boolean shouldShowName(T animatable) throws MatchException {
        if (!(animatable instanceof LivingEntity)) {
            return super.shouldShowName(animatable);
        }
        double nameRenderCutoff = getNameRenderCutoffDistance(animatable);
        if (this.entityRenderDispatcher.distanceToSqr(animatable) >= nameRenderCutoff * nameRenderCutoff) {
            return false;
        }
        if ((animatable instanceof Mob) && !animatable.shouldShowName() && (!animatable.hasCustomName() || animatable != this.entityRenderDispatcher.crosshairPickEntity)) {
            return false;
        }
        Minecraft minecraft = Minecraft.getInstance();
        boolean visibleToClient = !animatable.isInvisibleTo(minecraft.player);
        PlayerTeam team = animatable.getTeam();
        if (team == null) {
            return Minecraft.renderNames() && animatable != minecraft.getCameraEntity() && visibleToClient && !animatable.isVehicle();
        }
        PlayerTeam team2 = minecraft.player.getTeam();
        switch (C15021.$SwitchMap$net$minecraft$world$scores$Team$Visibility[team.getNameTagVisibility().ordinal()]) {
            case 1:
                return visibleToClient;
            case 2:
                return false;
            case 3:
                if (team2 == null) {
                    return visibleToClient;
                }
                return team.isAlliedTo(team2) && (team.canSeeFriendlyInvisibles() || visibleToClient);
            case 4:
                if (team2 == null) {
                    return visibleToClient;
                }
                return !team.isAlliedTo(team2) && visibleToClient;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    /* JADX INFO: renamed from: software.bernie.geckolib.renderer.GeoEntityRenderer$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/renderer/GeoEntityRenderer$1.class */
    static /* synthetic */ class C15021 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$world$scores$Team$Visibility = new int[Team.Visibility.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$world$scores$Team$Visibility[Team.Visibility.ALWAYS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$world$scores$Team$Visibility[Team.Visibility.NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$world$scores$Team$Visibility[Team.Visibility.HIDE_FOR_OTHER_TEAMS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$net$minecraft$world$scores$Team$Visibility[Team.Visibility.HIDE_FOR_OWN_TEAM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public int getPackedOverlay(T animatable, float u, float partialTick) {
        if (!(animatable instanceof LivingEntity)) {
            return OverlayTexture.NO_OVERLAY;
        }
        LivingEntity entity = (LivingEntity) animatable;
        return OverlayTexture.pack(OverlayTexture.u(u), OverlayTexture.v(entity.hurtTime > 0 || entity.deathTime > 0));
    }

    public boolean isShaking(T animatable) {
        return animatable.isFullyFrozen();
    }

    public <E extends Entity, M extends Mob> void renderLeash(M mob, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, E leashHolder) {
        double lerpBodyAngle = (Mth.lerp(partialTick, ((Mob) mob).yBodyRotO, ((Mob) mob).yBodyRot) * 0.017453292f) + 1.5707964f;
        Vec3 leashOffset = mob.getLeashOffset(partialTick);
        double xAngleOffset = (Math.cos(lerpBodyAngle) * leashOffset.z) + (Math.sin(lerpBodyAngle) * leashOffset.x);
        double zAngleOffset = (Math.sin(lerpBodyAngle) * leashOffset.z) - (Math.cos(lerpBodyAngle) * leashOffset.x);
        double lerpOriginX = Mth.lerp(partialTick, ((Mob) mob).xo, mob.getX()) + xAngleOffset;
        double lerpOriginY = Mth.lerp(partialTick, ((Mob) mob).yo, mob.getY()) + leashOffset.y;
        double lerpOriginZ = Mth.lerp(partialTick, ((Mob) mob).zo, mob.getZ()) + zAngleOffset;
        Vec3 ropeGripPosition = leashHolder.getRopeHoldPosition(partialTick);
        float xDif = (float) (ropeGripPosition.x - lerpOriginX);
        float yDif = (float) (ropeGripPosition.y - lerpOriginY);
        float zDif = (float) (ropeGripPosition.z - lerpOriginZ);
        float offsetMod = (Mth.invSqrt((xDif * xDif) + (zDif * zDif)) * 0.025f) / 2.0f;
        float xOffset = zDif * offsetMod;
        float zOffset = xDif * offsetMod;
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.leash());
        BlockPos entityEyePos = BlockPos.containing(mob.getEyePosition(partialTick));
        BlockPos holderEyePos = BlockPos.containing(leashHolder.getEyePosition(partialTick));
        int entityBlockLight = getBlockLightLevel(mob, entityEyePos);
        int holderBlockLight = leashHolder.isOnFire() ? 15 : leashHolder.level().getBrightness(LightLayer.BLOCK, holderEyePos);
        int entitySkyLight = mob.level().getBrightness(LightLayer.SKY, entityEyePos);
        int holderSkyLight = mob.level().getBrightness(LightLayer.SKY, holderEyePos);
        poseStack.pushPose();
        poseStack.translate(xAngleOffset, leashOffset.y, zAngleOffset);
        Matrix4f posMatrix = new Matrix4f(poseStack.last().pose());
        for (int segment = 0; segment <= 24; segment++) {
            renderLeashPiece(vertexConsumer, posMatrix, xDif, yDif, zDif, entityBlockLight, holderBlockLight, entitySkyLight, holderSkyLight, 0.025f, 0.025f, xOffset, zOffset, segment, false);
        }
        for (int segment2 = 24; segment2 >= 0; segment2--) {
            renderLeashPiece(vertexConsumer, posMatrix, xDif, yDif, zDif, entityBlockLight, holderBlockLight, entitySkyLight, holderSkyLight, 0.025f, 0.0f, xOffset, zOffset, segment2, true);
        }
        poseStack.popPose();
    }

    private static void renderLeashPiece(VertexConsumer buffer, Matrix4f positionMatrix, float xDif, float yDif, float zDif, int entityBlockLight, int holderBlockLight, int entitySkyLight, int holderSkyLight, float width, float yOffset, float xOffset, float zOffset, int segment, boolean isLeashKnot) {
        float piecePosPercent = segment / 24.0f;
        int lerpBlockLight = (int) Mth.lerp(piecePosPercent, entityBlockLight, holderBlockLight);
        int lerpSkyLight = (int) Mth.lerp(piecePosPercent, entitySkyLight, holderSkyLight);
        int packedLight = LightTexture.pack(lerpBlockLight, lerpSkyLight);
        float knotColourMod = segment % 2 == (isLeashKnot ? 1 : 0) ? 0.7f : 1.0f;
        float red = 0.5f * knotColourMod;
        float green = 0.4f * knotColourMod;
        float blue = 0.3f * knotColourMod;
        float x = xDif * piecePosPercent;
        float y = yDif > 0.0f ? yDif * piecePosPercent * piecePosPercent : yDif - ((yDif * (1.0f - piecePosPercent)) * (1.0f - piecePosPercent));
        float z = zDif * piecePosPercent;
        buffer.addVertex(positionMatrix, x - xOffset, y + yOffset, z + zOffset).setColor(red, green, blue, 1.0f).setLight(packedLight);
        buffer.addVertex(positionMatrix, x + xOffset, (y + width) - yOffset, z - zOffset).setColor(red, green, blue, 1.0f).setLight(packedLight);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void updateAnimatedTextureFrame(T animatable) {
        AnimatableTexture.setAndUpdate(getTextureLocation((Entity) animatable));
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void fireCompileRenderLayersEvent() {
        GeckoLibServices.Client.EVENTS.fireCompileEntityRenderLayers(this);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public boolean firePreRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return GeckoLibServices.Client.EVENTS.fireEntityPreRender(this, poseStack, model, bufferSource, partialTick, packedLight);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void firePostRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        GeckoLibServices.Client.EVENTS.fireEntityPostRender(this, poseStack, model, bufferSource, partialTick, packedLight);
    }
}
