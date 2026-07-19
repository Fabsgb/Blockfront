package software.bernie.geckolib.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.cache.texture.AnimatableTexture;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayersContainer;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/renderer/GeoBlockRenderer.class */
public class GeoBlockRenderer<T extends BlockEntity & GeoAnimatable> implements GeoRenderer<T>, BlockEntityRenderer<T> {
    protected final GeoModel<T> model;
    protected T animatable;
    protected final GeoRenderLayersContainer<T> renderLayers = new GeoRenderLayersContainer<>(this);
    protected float scaleWidth = 1.0f;
    protected float scaleHeight = 1.0f;
    protected Matrix4f blockRenderTranslations = new Matrix4f();
    protected Matrix4f modelRenderTranslations = new Matrix4f();

    public GeoBlockRenderer(GeoModel<T> model) {
        this.model = model;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public GeoModel<T> getGeoModel() {
        return this.model;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: getAnimatable, reason: merged with bridge method [inline-methods] */
    public T mo2142getAnimatable() {
        return this.animatable;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public long getInstanceId(T animatable) {
        return animatable.getBlockPos().hashCode();
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public List<GeoRenderLayer<T>> getRenderLayers() {
        return (List<GeoRenderLayer<T>>) this.renderLayers.getRenderLayers();
    }

    public GeoBlockRenderer<T> addRenderLayer(GeoRenderLayer<T> renderLayer) {
        this.renderLayers.addLayer(renderLayer);
        return this;
    }

    public GeoBlockRenderer<T> withScale(float scale) {
        return withScale(scale, scale);
    }

    public GeoBlockRenderer<T> withScale(float scaleWidth, float scaleHeight) {
        this.scaleWidth = scaleWidth;
        this.scaleHeight = scaleHeight;
        return this;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void preRender(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        this.blockRenderTranslations = new Matrix4f(poseStack.last().pose());
        if (!isReRender) {
            poseStack.translate(0.5d, 0.0d, 0.5d);
        }
        scaleModelForRender(this.scaleWidth, this.scaleHeight, poseStack, animatable, model, isReRender, partialTick, packedLight, packedOverlay);
    }

    @ApiStatus.Internal
    public void render(T animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        this.animatable = animatable;
        defaultRender(poseStack, this.animatable, bufferSource, null, null, 0.0f, partialTick, packedLight);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void actuallyRender(PoseStack poseStack, T animatable, BakedGeoModel model, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        if (!isReRender) {
            AnimationState<T> animationState = new AnimationState<>(animatable, 0.0f, 0.0f, partialTick, false);
            long instanceId = getInstanceId((BlockEntity) animatable);
            GeoModel<T> currentModel = getGeoModel();
            animationState.setData(DataTickets.TICK, Double.valueOf(animatable.getTick(animatable)));
            animationState.setData(DataTickets.BLOCK_ENTITY, animatable);
            Objects.requireNonNull(animationState);
            currentModel.addAdditionalStateData(animatable, instanceId, (x$0, x$1) -> {
                animationState.setData(x$0, x$1);
            });
            rotateBlock(getFacing(animatable), poseStack);
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
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void renderRecursively(PoseStack poseStack, T animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        if (bone.isTrackingMatrices()) {
            Matrix4f poseState = new Matrix4f(poseStack.last().pose());
            Matrix4f localMatrix = RenderUtil.invertAndMultiplyMatrices(poseState, this.blockRenderTranslations);
            Matrix4f worldState = new Matrix4f(localMatrix);
            BlockPos pos = this.animatable.getBlockPos();
            bone.setModelSpaceMatrix(RenderUtil.invertAndMultiplyMatrices(poseState, this.modelRenderTranslations));
            bone.setLocalSpaceMatrix(localMatrix);
            bone.setWorldSpaceMatrix(worldState.translate(new Vector3f(pos.getX(), pos.getY(), pos.getZ())));
        }
        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }

    /* JADX INFO: renamed from: software.bernie.geckolib.renderer.GeoBlockRenderer$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/renderer/GeoBlockRenderer$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$core$Direction = new int[Direction.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.SOUTH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.WEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.EAST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.UP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    protected void rotateBlock(Direction facing, PoseStack poseStack) {
        switch (AnonymousClass1.$SwitchMap$net$minecraft$core$Direction[facing.ordinal()]) {
            case 1:
                poseStack.mulPose(Axis.YP.rotationDegrees(180.0f));
                break;
            case 2:
                poseStack.mulPose(Axis.YP.rotationDegrees(90.0f));
                break;
            case 3:
                poseStack.mulPose(Axis.YP.rotationDegrees(0.0f));
                break;
            case 4:
                poseStack.mulPose(Axis.YP.rotationDegrees(270.0f));
                break;
            case 5:
                poseStack.mulPose(Axis.XP.rotationDegrees(90.0f));
                break;
            case 6:
                poseStack.mulPose(Axis.XN.rotationDegrees(90.0f));
                break;
        }
    }

    protected Direction getFacing(T block) {
        BlockState blockState = block.getBlockState();
        if (blockState.hasProperty(HorizontalDirectionalBlock.FACING)) {
            return blockState.getValue(HorizontalDirectionalBlock.FACING);
        }
        if (blockState.hasProperty(DirectionalBlock.FACING)) {
            return blockState.getValue(DirectionalBlock.FACING);
        }
        return Direction.NORTH;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void updateAnimatedTextureFrame(T animatable) {
        AnimatableTexture.setAndUpdate(getTextureLocation(animatable));
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void fireCompileRenderLayersEvent() {
        GeckoLibServices.Client.EVENTS.fireCompileBlockRenderLayers(this);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public boolean firePreRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return GeckoLibServices.Client.EVENTS.fireBlockPreRender(this, poseStack, model, bufferSource, partialTick, packedLight);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void firePostRenderEvent(PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        GeckoLibServices.Client.EVENTS.fireBlockPostRender(this, poseStack, model, bufferSource, partialTick, packedLight);
    }
}
