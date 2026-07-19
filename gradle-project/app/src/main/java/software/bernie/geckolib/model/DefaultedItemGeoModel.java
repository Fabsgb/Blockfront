package software.bernie.geckolib.model;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoAnimatable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/model/DefaultedItemGeoModel.class */
public class DefaultedItemGeoModel<T extends GeoAnimatable> extends DefaultedGeoModel<T> {
    public DefaultedItemGeoModel(ResourceLocation assetSubpath) {
        super(assetSubpath);
    }

    @Override // software.bernie.geckolib.model.DefaultedGeoModel
    protected String subtype() {
        return "item";
    }

    @Override // software.bernie.geckolib.model.DefaultedGeoModel
    public DefaultedItemGeoModel<T> withAltModel(ResourceLocation altPath) {
        return (DefaultedItemGeoModel) super.withAltModel(altPath);
    }

    @Override // software.bernie.geckolib.model.DefaultedGeoModel
    public DefaultedItemGeoModel<T> withAltAnimations(ResourceLocation altPath) {
        return (DefaultedItemGeoModel) super.withAltAnimations(altPath);
    }

    @Override // software.bernie.geckolib.model.DefaultedGeoModel
    public DefaultedItemGeoModel<T> withAltTexture(ResourceLocation altPath) {
        return (DefaultedItemGeoModel) super.withAltTexture(altPath);
    }
}
