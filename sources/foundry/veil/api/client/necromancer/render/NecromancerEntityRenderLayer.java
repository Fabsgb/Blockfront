package foundry.veil.api.client.necromancer.render;

import foundry.veil.api.client.necromancer.Skeleton;
import foundry.veil.api.client.necromancer.SkeletonParent;
import foundry.veil.api.client.render.MatrixStack;
import net.minecraft.world.entity.Entity;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/necromancer/render/NecromancerEntityRenderLayer.class */
public abstract class NecromancerEntityRenderLayer<T extends Entity & SkeletonParent<T, M>, M extends Skeleton> {
    protected final NecromancerEntityRenderer<T, M> renderer;

    public abstract void render(T t, M m, NecromancerRenderer necromancerRenderer, MatrixStack matrixStack, int i, float f);

    public NecromancerEntityRenderLayer(NecromancerEntityRenderer<T, M> renderer) {
        this.renderer = renderer;
    }
}
