package software.bernie.geckolib.renderer.layer.vanilla;

import java.util.function.Function;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.renderer.GeoItemRenderer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/renderer/layer/vanilla/GeoItemVanillaRenderLayer.class */
public abstract class GeoItemVanillaRenderLayer<A extends Item & GeoItem, T extends Entity, M extends EntityModel<T>, R extends GeoItemRenderer<A>> extends AttachedAnimatableRenderLayer<A, T, M, R> {
    public GeoItemVanillaRenderLayer(RenderLayerParent<T, M> renderer, Function<Level, A> instanceFactory) {
        super(renderer, instanceFactory);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // software.bernie.geckolib.renderer.layer.vanilla.AttachedAnimatableRenderLayer
    @Nullable
    public R getRenderer(A animatable) {
        BlockEntityWithoutLevelRenderer geoItemRenderer = GeoRenderProvider.m8358of(animatable).getGeoItemRenderer();
        if (geoItemRenderer instanceof GeoItemRenderer) {
            return (R) geoItemRenderer;
        }
        return null;
    }
}
