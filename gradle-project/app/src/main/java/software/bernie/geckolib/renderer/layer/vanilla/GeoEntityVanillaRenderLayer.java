package software.bernie.geckolib.renderer.layer.vanilla;

import java.util.function.Function;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/renderer/layer/vanilla/GeoEntityVanillaRenderLayer.class */
public abstract class GeoEntityVanillaRenderLayer<A extends Entity & GeoEntity, T extends Entity, M extends EntityModel<T>, R extends GeoEntityRenderer<A>> extends AttachedAnimatableRenderLayer<A, T, M, R> {
    public GeoEntityVanillaRenderLayer(RenderLayerParent<T, M> renderer, Function<Level, A> instanceFactory) {
        super(renderer, instanceFactory);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // software.bernie.geckolib.renderer.layer.vanilla.AttachedAnimatableRenderLayer
    @Nullable
    public R getRenderer(A animatable) {
        EntityRenderDispatcher entityRenderers = Minecraft.getInstance().getEntityRenderDispatcher();
        EntityRenderer renderer = entityRenderers.getRenderer(animatable);
        if (renderer instanceof GeoEntityRenderer) {
            return (R) renderer;
        }
        return null;
    }
}
