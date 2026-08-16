package software.bernie.geckolib.model;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoAnimatable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/model/DefaultedGeoModel.class */
public abstract class DefaultedGeoModel<T extends GeoAnimatable> extends GeoModel<T> {
    private ResourceLocation modelPath;
    private ResourceLocation texturePath;
    private ResourceLocation animationsPath;

    protected abstract String subtype();

    public DefaultedGeoModel(ResourceLocation assetSubpath) {
        this.modelPath = buildFormattedModelPath(assetSubpath);
        this.texturePath = buildFormattedTexturePath(assetSubpath);
        this.animationsPath = buildFormattedAnimationPath(assetSubpath);
    }

    public DefaultedGeoModel<T> withAltModel(ResourceLocation altPath) {
        this.modelPath = buildFormattedModelPath(altPath);
        return this;
    }

    public DefaultedGeoModel<T> withAltAnimations(ResourceLocation altPath) {
        this.animationsPath = buildFormattedAnimationPath(altPath);
        return this;
    }

    public DefaultedGeoModel<T> withAltTexture(ResourceLocation altPath) {
        this.texturePath = buildFormattedTexturePath(altPath);
        return this;
    }

    public ResourceLocation buildFormattedModelPath(ResourceLocation basePath) {
        return basePath.withPath("geo/" + subtype() + "/" + basePath.getPath() + ".geo.json");
    }

    public ResourceLocation buildFormattedAnimationPath(ResourceLocation basePath) {
        return basePath.withPath("animations/" + subtype() + "/" + basePath.getPath() + ".animation.json");
    }

    public ResourceLocation buildFormattedTexturePath(ResourceLocation basePath) {
        return basePath.withPath("textures/" + subtype() + "/" + basePath.getPath() + ".png");
    }

    @Override // software.bernie.geckolib.model.GeoModel
    public ResourceLocation getModelResource(T animatable) {
        return this.modelPath;
    }

    @Override // software.bernie.geckolib.model.GeoModel
    public ResourceLocation getTextureResource(T animatable) {
        return this.texturePath;
    }

    @Override // software.bernie.geckolib.model.GeoModel
    public ResourceLocation getAnimationResource(T animatable) {
        return this.animationsPath;
    }
}
