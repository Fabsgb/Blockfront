package software.bernie.geckolib.model;

import java.util.Optional;
import java.util.function.BiConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoReplacedEntity;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationProcessor;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.GeckoLibCache;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.constant.dataticket.DataTicket;
import software.bernie.geckolib.loading.object.BakedAnimations;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/model/GeoModel.class */
public abstract class GeoModel<T extends GeoAnimatable> {
    private double animTime;
    private double lastGameTickTime;
    private final AnimationProcessor<T> processor = new AnimationProcessor<>(this);
    private BakedGeoModel currentModel = null;
    private long lastRenderedInstance = -1;

    @Deprecated
    public abstract ResourceLocation getModelResource(T t);

    @Deprecated
    public abstract ResourceLocation getTextureResource(T t);

    public abstract ResourceLocation getAnimationResource(T t);

    public ResourceLocation getModelResource(T animatable, @Nullable GeoRenderer<T> renderer) {
        return getModelResource(animatable);
    }

    public ResourceLocation getTextureResource(T animatable, @Nullable GeoRenderer<T> renderer) {
        return getTextureResource(animatable);
    }

    public ResourceLocation[] getAnimationResourceFallbacks(T animatable) {
        return new ResourceLocation[0];
    }

    public boolean crashIfBoneMissing() {
        return false;
    }

    @Nullable
    public RenderType getRenderType(T animatable, ResourceLocation texture) {
        return RenderType.entityCutoutNoCull(texture);
    }

    public BakedGeoModel getBakedModel(ResourceLocation location) {
        BakedGeoModel model = GeckoLibCache.getBakedModels().get(location);
        if (model == null) {
            if (!location.getPath().contains("geo/")) {
                throw GeckoLibConstants.exception(location, "Invalid model resource path provided - GeckoLib models must be placed in assets/<modid>/geo/");
            }
            throw GeckoLibConstants.exception(location, "Unable to find model");
        }
        if (model != this.currentModel) {
            this.processor.setActiveModel(model);
            this.currentModel = model;
        }
        return this.currentModel;
    }

    public Optional<GeoBone> getBone(String name) {
        return Optional.ofNullable(getAnimationProcessor().getBone(name));
    }

    @Nullable
    public Animation getAnimation(T animatable, String name) {
        ResourceLocation location = getAnimationResource(animatable);
        BakedAnimations bakedAnimations = GeckoLibCache.getBakedAnimations().get(location);
        Animation animation = bakedAnimations != null ? bakedAnimations.getAnimation(name) : null;
        if (animation != null) {
            return animation;
        }
        for (ResourceLocation fallbackLocation : getAnimationResourceFallbacks(animatable)) {
            location = fallbackLocation;
            bakedAnimations = GeckoLibCache.getBakedAnimations().get(fallbackLocation);
            Animation animation2 = bakedAnimations != null ? bakedAnimations.getAnimation(name) : null;
            if (animation2 != null) {
                return animation2;
            }
        }
        if (bakedAnimations == null) {
            if (!location.getPath().contains("animations/")) {
                throw GeckoLibConstants.exception(location, "Invalid animation resource path provided - GeckoLib animations must be placed in assets/<modid>/animations/");
            }
            throw GeckoLibConstants.exception(location, "Unable to find animation file.");
        }
        return null;
    }

    public AnimationProcessor<T> getAnimationProcessor() {
        return this.processor;
    }

    public void addAdditionalStateData(T animatable, long instanceId, BiConsumer<DataTicket<T>, T> dataConsumer) {
    }

    @ApiStatus.Internal
    public void handleAnimations(T animatable, long instanceId, AnimationState<T> animationState, float partialTick) {
        double currentTick;
        Minecraft mc = Minecraft.getInstance();
        AnimatableManager<T> animatableManager = animatable.getAnimatableInstanceCache().getManagerForId(instanceId);
        Double currentTick2 = (Double) animationState.getData(DataTickets.TICK);
        if (currentTick2 == null) {
            if (animatable instanceof Entity) {
                Entity entity = (Entity) animatable;
                currentTick = entity.tickCount;
            } else {
                currentTick = RenderUtil.getCurrentTick();
            }
            currentTick2 = Double.valueOf(currentTick);
        }
        if (animatableManager.getFirstTickTime() == -1.0d) {
            animatableManager.startedAt(currentTick2.doubleValue() + ((double) partialTick));
        }
        double currentFrameTime = ((animatable instanceof Entity) || (animatable instanceof GeoReplacedEntity)) ? currentTick2.doubleValue() + ((double) partialTick) : currentTick2.doubleValue() - animatableManager.getFirstTickTime();
        boolean isReRender = !animatableManager.isFirstTick() && currentFrameTime == animatableManager.getLastUpdateTime();
        if (isReRender && instanceId == this.lastRenderedInstance) {
            return;
        }
        if (!mc.isPaused() || animatable.shouldPlayAnimsWhileGamePaused()) {
            animatableManager.updatedAt(currentFrameTime);
            double lastUpdateTime = animatableManager.getLastUpdateTime();
            this.animTime += lastUpdateTime - this.lastGameTickTime;
            this.lastGameTickTime = lastUpdateTime;
        }
        animationState.animationTick = this.animTime;
        this.lastRenderedInstance = instanceId;
        AnimationProcessor<T> processor = getAnimationProcessor();
        processor.preAnimationSetup(animationState, this.animTime);
        if (!processor.getRegisteredBones().isEmpty()) {
            processor.tickAnimation(animatable, this, animatableManager, this.animTime, animationState, crashIfBoneMissing());
        }
        setCustomAnimations(animatable, instanceId, animationState);
    }

    public void setCustomAnimations(T animatable, long instanceId, AnimationState<T> animationState) {
    }

    public void applyMolangQueries(AnimationState<T> animationState, double animTime) {
    }
}
