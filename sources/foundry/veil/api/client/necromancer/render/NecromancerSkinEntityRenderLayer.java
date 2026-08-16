package foundry.veil.api.client.necromancer.render;

import foundry.veil.api.client.necromancer.Skeleton;
import foundry.veil.api.client.necromancer.SkeletonParent;
import foundry.veil.api.client.render.MatrixStack;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/necromancer/render/NecromancerSkinEntityRenderLayer.class */
public abstract class NecromancerSkinEntityRenderLayer<T extends Entity & SkeletonParent<T, M>, M extends Skeleton> extends NecromancerEntityRenderLayer<T, M> {
    @Nullable
    public abstract RenderType getRenderType(T t);

    @Nullable
    public abstract Skin getSkin(T t);

    public NecromancerSkinEntityRenderLayer(NecromancerEntityRenderer<T, M> renderer) {
        super(renderer);
    }

    @Override // foundry.veil.api.client.necromancer.render.NecromancerEntityRenderLayer
    public void render(T parent, M skeleton, NecromancerRenderer renderer, MatrixStack matrixStack, int packedLight, float partialTicks) {
        Skin skin;
        RenderType renderType = getRenderType(parent);
        if (renderType != null && (skin = getSkin(parent)) != null) {
            renderSkin(parent, skeleton, skin, renderType, renderer, matrixStack, packedLight, partialTicks);
        }
    }

    protected void renderSkin(T parent, M skeleton, Skin skin, RenderType renderType, NecromancerRenderer renderer, MatrixStack matrixStack, int packedLight, float partialTicks) {
        renderer.setTransform(matrixStack.position());
        renderer.setLight(packedLight);
        renderer.draw(renderType, skeleton, skin, partialTicks);
        renderer.reset();
    }
}
