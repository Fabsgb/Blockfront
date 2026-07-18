package software.bernie.geckolib.renderer.layer;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.GeoRenderer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/renderer/layer/GeoRenderLayersContainer.class */
public class GeoRenderLayersContainer<T extends GeoAnimatable> {
    private final GeoRenderer<T> renderer;
    private final List<GeoRenderLayer<T>> layers = new ObjectArrayList();
    private boolean compiledLayers = false;

    public GeoRenderLayersContainer(GeoRenderer<T> renderer) {
        this.renderer = renderer;
    }

    public List<GeoRenderLayer<T>> getRenderLayers() {
        if (!this.compiledLayers) {
            fireCompileRenderLayersEvent();
        }
        return this.layers;
    }

    public void addLayer(GeoRenderLayer<T> layer) {
        this.layers.add(layer);
    }

    public void fireCompileRenderLayersEvent() {
        this.compiledLayers = true;
        this.renderer.fireCompileRenderLayersEvent();
    }
}
