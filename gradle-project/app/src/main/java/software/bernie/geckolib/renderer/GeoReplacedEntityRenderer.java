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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
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
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayersContainer;
import software.bernie.geckolib.util.ClientUtil;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/renderer/GeoReplacedEntityRenderer.class */
public class GeoReplacedEntityRenderer<E extends Entity, T extends GeoAnimatable> extends EntityRenderer<E> implements GeoRenderer<T> {
    protected final GeoRenderLayersContainer<T> renderLayers;
    protected final GeoModel<T> model;
    protected final T animatable;
    protected E currentEntity;
    protected float scaleWidth;
    protected float scaleHeight;
    protected Matrix4f entityRenderTranslations;
    protected Matrix4f modelRenderTranslations;

    public GeoReplacedEntityRenderer(EntityRendererProvider.Context renderManager, GeoModel<T> model, T animatable) {
        super(renderManager);
        this.renderLayers = new GeoRenderLayersContainer<>(this);
        this.scaleWidth = 1.0f;
        this.scaleHeight = 1.0f;
        this.entityRenderTranslations = new Matrix4f();
        this.modelRenderTranslations = new Matrix4f();
        this.model = model;
        this.animatable = animatable;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public GeoModel<T> getGeoModel() {
        return this.model;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: getAnimatable */
    public T mo2142getAnimatable() {
        return this.animatable;
    }

    public E getCurrentEntity() {
        return this.currentEntity;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public long getInstanceId(T animatable) {
        return this.currentEntity.getId();
    }

    public ResourceLocation getTextureLocation(E entity) {
        return super.getTextureLocation(this.animatable);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public List<GeoRenderLayer<T>> getRenderLayers() {
        return this.renderLayers.getRenderLayers();
    }

    public GeoReplacedEntityRenderer<E, T> addRenderLayer(GeoRenderLayer<T> renderLayer) {
        this.renderLayers.addLayer(renderLayer);
        return this;
    }

    public GeoReplacedEntityRenderer<E, T> withScale(float scale) {
        return withScale(scale, scale);
    }

    public GeoReplacedEntityRenderer<E, T> withScale(float scaleWidth, float scaleHeight) {
        this.scaleWidth = scaleWidth;
        this.scaleHeight = scaleHeight;
        return this;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    @Nullable
    public RenderType getRenderType(T animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        boolean invisible = this.currentEntity != null && this.currentEntity.isInvisible();
        if (invisible && !this.currentEntity.isInvisibleTo(ClientUtil.getClientPlayer())) {
            return RenderType.itemEntityTranslucentCull(texture);
        }
        if (!invisible) {
            return super.getRenderType(animatable, texture, bufferSource, partialTick);
        }
        if (this.currentEntity == null || !Minecraft.getInstance().shouldEntityAppearGlowing(this.currentEntity)) {
            return null;
        }
        return RenderType.outline(texture);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void preRender(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        this.entityRenderTranslations = new Matrix4f(poseStack.last().pose());
        scaleModelForRender(this.scaleWidth, this.scaleHeight, poseStack, animatable, model, isReRender, partialTick, packedLight, packedOverlay);
    }

    @ApiStatus.Internal
    public void render(E entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        this.currentEntity = entity;
        defaultRender(poseStack, this.animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void actuallyRender(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        LivingEntity livingEntity;
        boolean isMoving;
        Direction bedDirection;
        Entity leashHolder;
        poseStack.pushPose();
        LivingEntity livingEntity2 = this.currentEntity;
        if (livingEntity2 instanceof LivingEntity) {
            LivingEntity entity = livingEntity2;
            livingEntity = entity;
        } else {
            livingEntity = null;
        }
        LivingEntity livingEntity3 = livingEntity;
        Mob mob = this.currentEntity;
        if (mob instanceof Mob) {
            Mob mob2 = mob;
            if (!isReRender && (leashHolder = mob2.getLeashHolder()) != null) {
                renderLeash(mob2, partialTick, poseStack, bufferSource, leashHolder);
            }
        }
        boolean shouldSit = this.currentEntity.isPassenger() && this.currentEntity.getVehicle() != null;
        float lerpBodyRot = livingEntity3 == null ? 0.0f : Mth.rotLerp(partialTick, livingEntity3.yBodyRotO, livingEntity3.yBodyRot);
        float lerpHeadRot = livingEntity3 == null ? 0.0f : Mth.rotLerp(partialTick, livingEntity3.yHeadRotO, livingEntity3.yHeadRot);
        float netHeadYaw = lerpHeadRot - lerpBodyRot;
        if (shouldSit) {
            LivingEntity vehicle = this.currentEntity.getVehicle();
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
        if (this.currentEntity.getPose() == Pose.SLEEPING && livingEntity3 != null && (bedDirection = livingEntity3.getBedOrientation()) != null) {
            float eyePosOffset = livingEntity3.getEyeHeight(Pose.STANDING) - 0.1f;
            poseStack.translate((-bedDirection.getStepX()) * eyePosOffset, 0.0f, (-bedDirection.getStepZ()) * eyePosOffset);
        }
        float nativeScale = livingEntity3 != null ? livingEntity3.getScale() : 1.0f;
        float ageInTicks = ((Entity) this.currentEntity).tickCount + partialTick;
        float limbSwingAmount = 0.0f;
        float limbSwing = 0.0f;
        poseStack.scale(nativeScale, nativeScale, nativeScale);
        applyRotations(animatable, poseStack, ageInTicks, lerpBodyRot, partialTick, nativeScale);
        if (!shouldSit && this.currentEntity.isAlive() && livingEntity3 != null) {
            limbSwingAmount = livingEntity3.walkAnimation.speed(partialTick);
            limbSwing = livingEntity3.walkAnimation.position(partialTick);
            if (livingEntity3.isBaby()) {
                limbSwing *= 3.0f;
            }
            if (limbSwingAmount > 1.0f) {
                limbSwingAmount = 1.0f;
            }
        }
        float headPitch = Mth.lerp(partialTick, ((Entity) this.currentEntity).xRotO, this.currentEntity.getXRot());
        float motionThreshold = getMotionAnimThreshold(animatable);
        if (livingEntity3 != null) {
            Vec3 velocity = livingEntity3.getDeltaMovement();
            float avgVelocity = ((float) (Math.abs(velocity.x) + Math.abs(velocity.z))) / 2.0f;
            isMoving = avgVelocity >= motionThreshold && limbSwingAmount != 0.0f;
        } else {
            isMoving = limbSwingAmount <= (-motionThreshold) || limbSwingAmount >= motionThreshold;
        }
        if (!isReRender) {
            AnimationState<T> animationState = new AnimationState<>(animatable, limbSwing, limbSwingAmount, partialTick, isMoving);
            long instanceId = getInstanceId(animatable);
            GeoModel<T> currentModel = getGeoModel();
            animationState.setData(DataTickets.TICK, Double.valueOf(animatable.getTick(this.currentEntity)));
            animationState.setData(DataTickets.ENTITY, this.currentEntity);
            animationState.setData(DataTickets.ENTITY_MODEL_DATA, new EntityModelData(shouldSit, livingEntity3 != null && livingEntity3.isBaby(), -netHeadYaw, -headPitch));
            Objects.requireNonNull(animationState);
            currentModel.addAdditionalStateData(animatable, instanceId, (v1, v2) -> {
                r3.setData(v1, v2);
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
        if (!this.currentEntity.isSpectator()) {
            super.applyRenderLayers(poseStack, animatable, model, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void renderFinal(PoseStack poseStack, T animatable, BakedGeoModel model, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay, int colour) {
        Mob mob;
        Entity leashHolder;
        super.render(this.currentEntity, 0.0f, partialTick, poseStack, bufferSource, packedLight);
        Mob mob2 = this.currentEntity;
        if ((mob2 instanceof Mob) && (leashHolder = (mob = mob2).getLeashHolder()) != null) {
            renderLeash(mob, partialTick, poseStack, bufferSource, leashHolder);
        }
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void postRender(PoseStack poseStack, T animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        if (!isReRender) {
            super.render(this.currentEntity, 0.0f, partialTick, poseStack, bufferSource, packedLight);
        }
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void doPostRenderCleanup() {
        this.currentEntity = null;
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
            bone.setLocalSpaceMatrix(RenderUtil.translateMatrix(localMatrix, getRenderOffset(this.currentEntity, 1.0f).toVector3f()));
            bone.setWorldSpaceMatrix(RenderUtil.translateMatrix(new Matrix4f(localMatrix), this.currentEntity.position().toVector3f()));
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
            rotationYaw += (float) (Math.cos(((double) ((Entity) this.currentEntity).tickCount) * 3.25d) * 3.141592653589793d * 0.4d);
        }
        if (!this.currentEntity.hasPose(Pose.SLEEPING)) {
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0f - rotationYaw));
        }
        LivingEntity livingEntity = this.currentEntity;
        if (livingEntity instanceof LivingEntity) {
            LivingEntity livingEntity2 = livingEntity;
            if (livingEntity2.deathTime > 0) {
                float deathRotation = (((livingEntity2.deathTime + partialTick) - 1.0f) / 20.0f) * 1.6f;
                poseStack.mulPose(Axis.ZP.rotationDegrees(Math.min(Mth.sqrt(deathRotation), 1.0f) * getDeathMaxRotation(animatable)));
                return;
            }
            if (livingEntity2.isAutoSpinAttack()) {
                poseStack.mulPose(Axis.XP.rotationDegrees((-90.0f) - livingEntity2.getXRot()));
                poseStack.mulPose(Axis.YP.rotationDegrees((livingEntity2.tickCount + partialTick) * (-75.0f)));
            } else {
                if (livingEntity2.hasPose(Pose.SLEEPING)) {
                    Direction bedOrientation = livingEntity2.getBedOrientation();
                    poseStack.mulPose(Axis.YP.rotationDegrees(bedOrientation != null ? RenderUtil.getDirectionAngle(bedOrientation) : rotationYaw));
                    poseStack.mulPose(Axis.ZP.rotationDegrees(getDeathMaxRotation(animatable)));
                    poseStack.mulPose(Axis.YP.rotationDegrees(270.0f));
                    return;
                }
                if (LivingEntityRenderer.isEntityUpsideDown(livingEntity2)) {
                    poseStack.translate(0.0f, (livingEntity2.getBbHeight() + 0.1f) / nativeScale, 0.0f);
                    poseStack.mulPose(Axis.ZP.rotationDegrees(180.0f));
                }
            }
        }
    }

    protected float getDeathMaxRotation(T animatable) {
        return 90.0f;
    }

    public double getNameRenderCutoffDistance(E entity, T animatable) {
        return entity.isDiscrete() ? 32.0d : 64.0d;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public boolean shouldShowName(E entity) throws MatchException {
        if (!(entity instanceof LivingEntity)) {
            return super.shouldShowName(entity);
        }
        double nameRenderCutoff = getNameRenderCutoffDistance(entity, this.animatable);
        if (this.entityRenderDispatcher.distanceToSqr(entity) >= nameRenderCutoff * nameRenderCutoff) {
            return false;
        }
        if ((entity instanceof Mob) && !entity.shouldShowName() && (!entity.hasCustomName() || entity != this.entityRenderDispatcher.crosshairPickEntity)) {
            return false;
        }
        Minecraft minecraft = Minecraft.getInstance();
        boolean visibleToClient = !entity.isInvisibleTo(minecraft.player);
        PlayerTeam team = entity.getTeam();
        if (team == null) {
            return Minecraft.renderNames() && entity != minecraft.getCameraEntity() && visibleToClient && !entity.isVehicle();
        }
        PlayerTeam team2 = minecraft.player.getTeam();
        switch (AnonymousClass1.$SwitchMap$net$minecraft$world$scores$Team$Visibility[team.getNameTagVisibility().ordinal()]) {
            case 1:
                return visibleToClient;
            case 2:
                return false;
            case 3:
                return team2 == null ? visibleToClient : team.isAlliedTo(team2) && (team.canSeeFriendlyInvisibles() || visibleToClient);
            case 4:
                return team2 == null ? visibleToClient : !team.isAlliedTo(team2) && visibleToClient;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    /* JADX INFO: renamed from: software.bernie.geckolib.renderer.GeoReplacedEntityRenderer$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/renderer/GeoReplacedEntityRenderer$1.class */
    static /* synthetic */ class AnonymousClass1 {
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
        LivingEntity livingEntity = this.currentEntity;
        if (!(livingEntity instanceof LivingEntity)) {
            return OverlayTexture.NO_OVERLAY;
        }
        LivingEntity entity = livingEntity;
        return OverlayTexture.pack(OverlayTexture.u(u), OverlayTexture.v(entity.hurtTime > 0 || entity.deathTime > 0));
    }

    public boolean isShaking(T animatable) {
        return this.currentEntity.isFullyFrozen();
    }

    public <H extends Entity, M extends Mob> void renderLeash(M mob, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, H leashHolder) {
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
        AnimatableTexture.setAndUpdate(getTextureLocation(animatable));
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void fireCompileRenderLayersEvent() {
        GeckoLibServices.Client.EVENTS.fireCompileReplacedEntityRenderLayers(this);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public boolean firePreRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return GeckoLibServices.Client.EVENTS.fireReplacedEntityPreRender(this, poseStack, model, bufferSource, partialTick, packedLight);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void firePostRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        GeckoLibServices.Client.EVENTS.fireReplacedEntityPostRender(this, poseStack, model, bufferSource, partialTick, packedLight);
    }
}
