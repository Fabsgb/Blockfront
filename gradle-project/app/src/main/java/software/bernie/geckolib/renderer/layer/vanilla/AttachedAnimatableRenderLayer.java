package software.bernie.geckolib.renderer.layer.vanilla;

import com.mojang.blaze3d.vertex.PoseStack;
import java.lang.ref.WeakReference;
import java.util.function.Function;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.GeoRenderer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/renderer/layer/vanilla/AttachedAnimatableRenderLayer.class */
public abstract class AttachedAnimatableRenderLayer<A extends GeoAnimatable, T extends Entity, M extends EntityModel<T>, R extends GeoRenderer<A>> extends RenderLayer<T, M> {
    private final Function<Level, A> instanceCache;
    private final Function<Level, A> instanceFactory;

    protected abstract void renderAnimatableOnModel(T t, A a, M m, R r, PoseStack poseStack, MultiBufferSource multiBufferSource, float f, int i, float f2, float f3, float f4, float f5, float f6);

    @Nullable
    protected abstract R getRenderer(A a);

    public AttachedAnimatableRenderLayer(RenderLayerParent<T, M> renderLayerParent, Function<Level, A> function) {
        super(renderLayerParent);
        this.instanceCache = (Function<Level, A>) new Function<Level, A>() { // from class: software.bernie.geckolib.renderer.layer.vanilla.AttachedAnimatableRenderLayer.1

            @Nullable
            private WeakReference<A> cachedInstance = null;

            /* JADX WARN: Code duplicated, block: B:10:0x0021  */
            @Override // java.util.function.Function
            @Contract("null->null;!null->!null")
            @Nullable
            public A apply(@Nullable Level level) {
                A instance;
                if (level == null) {
                    this.cachedInstance = null;
                    return null;
                }
                if (this.cachedInstance != null) {
                    A a = this.cachedInstance.get();
                    instance = a;
                    if (a == null) {
                        A aApply = AttachedAnimatableRenderLayer.this.instanceFactory.apply(level);
                        instance = aApply;
                        this.cachedInstance = new WeakReference<>(aApply);
                    }
                } else {
                    A aApply2 = AttachedAnimatableRenderLayer.this.instanceFactory.apply(level);
                    instance = aApply2;
                    this.cachedInstance = new WeakReference<>(aApply2);
                }
                return instance;
            }
        };
        this.instanceFactory = function;
    }

    protected boolean shouldRender(T entity) {
        return true;
    }

    @Nullable
    public A getAnimatableInstance(T entity) {
        A animatable = this.instanceCache.apply(entity.level());
        if (animatable != null) {
            updateAnimatableTick(animatable, ((Entity) entity).tickCount);
        }
        return animatable;
    }

    protected void updateAnimatableTick(A instance, int tick) {
        if (instance instanceof Entity) {
            Entity geoEntity = (Entity) instance;
            geoEntity.tickCount = tick;
        }
    }

    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        GeoAnimatable animatableInstance;
        GeoRenderer renderer;
        if (!shouldRender(entity) || (animatableInstance = getAnimatableInstance(entity)) == null || (renderer = getRenderer(animatableInstance)) == null) {
            return;
        }
        poseStack.pushPose();
        renderAnimatableOnModel(entity, animatableInstance, getParentModel(), renderer, poseStack, bufferSource, partialTick, packedLight, ageInTicks, limbSwing, limbSwingAmount, netHeadYaw, headPitch);
        poseStack.popPose();
    }
}
