package software.bernie.geckolib.model;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoAnimatable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/model/DefaultedBlockGeoModel.class */
public class DefaultedBlockGeoModel<T extends GeoAnimatable> extends DefaultedGeoModel<T> {
    public DefaultedBlockGeoModel(ResourceLocation assetSubpath) {
        super(assetSubpath);
    }

    @Override // software.bernie.geckolib.model.DefaultedGeoModel
    protected String subtype() {
        return "block";
    }

    @Override // software.bernie.geckolib.model.DefaultedGeoModel
    public DefaultedBlockGeoModel<T> withAltModel(ResourceLocation altPath) {
        return (DefaultedBlockGeoModel) super.withAltModel(altPath);
    }

    @Override // software.bernie.geckolib.model.DefaultedGeoModel
    public DefaultedBlockGeoModel<T> withAltAnimations(ResourceLocation altPath) {
        return (DefaultedBlockGeoModel) super.withAltAnimations(altPath);
    }

    @Override // software.bernie.geckolib.model.DefaultedGeoModel
    public DefaultedBlockGeoModel<T> withAltTexture(ResourceLocation altPath) {
        return (DefaultedBlockGeoModel) super.withAltTexture(altPath);
    }
}
