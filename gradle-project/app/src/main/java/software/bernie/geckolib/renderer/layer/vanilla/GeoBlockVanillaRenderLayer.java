package software.bernie.geckolib.renderer.layer.vanilla;

import java.util.function.Function;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/renderer/layer/vanilla/GeoBlockVanillaRenderLayer.class */
public abstract class GeoBlockVanillaRenderLayer<A extends BlockEntity & GeoBlockEntity, T extends Entity, M extends EntityModel<T>, R extends GeoBlockRenderer<A>> extends AttachedAnimatableRenderLayer<A, T, M, R> {
    public GeoBlockVanillaRenderLayer(RenderLayerParent<T, M> renderer, Function<Level, A> instanceFactory) {
        super(renderer, instanceFactory);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // software.bernie.geckolib.renderer.layer.vanilla.AttachedAnimatableRenderLayer
    @Nullable
    public R getRenderer(A animatable) {
        BlockEntityRenderDispatcher blockRenderers = Minecraft.getInstance().getBlockEntityRenderDispatcher();
        BlockEntityRenderer renderer = blockRenderers.getRenderer(animatable);
        if (renderer instanceof GeoBlockRenderer) {
            return (R) renderer;
        }
        return null;
    }
}
