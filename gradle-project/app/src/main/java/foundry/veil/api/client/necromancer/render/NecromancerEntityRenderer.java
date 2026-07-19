package foundry.veil.api.client.necromancer.render;

import com.mojang.blaze3d.vertex.PoseStack;
import foundry.veil.api.client.necromancer.Skeleton;
import foundry.veil.api.client.necromancer.SkeletonParent;
import foundry.veil.api.client.necromancer.animation.Animator;
import foundry.veil.api.client.render.MatrixStack;
import foundry.veil.api.client.render.VeilRenderBridge;
import foundry.veil.impl.client.necromancer.render.NecromancerRenderDispatcher;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/necromancer/render/NecromancerEntityRenderer.class */
public abstract class NecromancerEntityRenderer<P extends Entity & SkeletonParent<P, S>, S extends Skeleton> extends EntityRenderer<P> {
    private final List<NecromancerEntityRenderLayer<P, S>> layers;

    public abstract S createSkeleton(P p);

    public abstract Animator<P, S> createAnimator(P p, S s);

    protected NecromancerEntityRenderer(EntityRendererProvider.Context context, float shadowRadius) {
        super(context);
        this.shadowRadius = shadowRadius;
        this.layers = new ObjectArrayList();
    }

    public void addLayer(NecromancerEntityRenderLayer<P, S> layer) {
        this.layers.add(layer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setupEntity(P parent) {
        Skeleton skeletonCreateSkeleton = createSkeleton(parent);
        ((SkeletonParent) parent).setSkeleton(skeletonCreateSkeleton);
        ((SkeletonParent) parent).setAnimator(createAnimator(parent, skeletonCreateSkeleton));
    }

    public void render(P parent, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        NecromancerRenderer renderer = NecromancerRenderDispatcher.getRenderer();
        render(parent, renderer, VeilRenderBridge.create(poseStack), packedLight, partialTick);
        super.render(parent, entityYaw, partialTick, poseStack, renderer, packedLight);
    }

    public void render(P parent, NecromancerRenderer renderer, MatrixStack matrixStack, int packedLight, float partialTicks) {
        Skeleton skeleton = ((SkeletonParent) parent).getSkeleton();
        if (skeleton == null) {
            return;
        }
        matrixStack.matrixPush();
        matrixStack.applyScale(0.0625f);
        for (NecromancerEntityRenderLayer<P, S> layer : this.layers) {
            layer.render(parent, skeleton, renderer, matrixStack, packedLight, partialTicks);
        }
        matrixStack.matrixPop();
    }

    public ResourceLocation getTextureLocation(P entity) {
        throw new UnsupportedOperationException();
    }
}
