package software.bernie.geckolib.model;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.data.EntityModelData;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/model/DefaultedEntityGeoModel.class */
public class DefaultedEntityGeoModel<T extends GeoAnimatable> extends DefaultedGeoModel<T> {
    protected final boolean turnsHead;

    public DefaultedEntityGeoModel(ResourceLocation assetSubpath) {
        this(assetSubpath, false);
    }

    public DefaultedEntityGeoModel(ResourceLocation assetSubpath, boolean turnsHead) {
        super(assetSubpath);
        this.turnsHead = turnsHead;
    }

    @Override // software.bernie.geckolib.model.DefaultedGeoModel
    protected String subtype() {
        return "entity";
    }

    @Override // software.bernie.geckolib.model.GeoModel
    public void setCustomAnimations(T animatable, long instanceId, AnimationState<T> animationState) {
        GeoBone head;
        if (this.turnsHead && (head = getAnimationProcessor().getBone("head")) != null) {
            EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292f);
            head.setRotY(entityData.netHeadYaw() * 0.017453292f);
        }
    }

    @Override // software.bernie.geckolib.model.DefaultedGeoModel
    public DefaultedEntityGeoModel<T> withAltModel(ResourceLocation altPath) {
        return (DefaultedEntityGeoModel) super.withAltModel(altPath);
    }

    @Override // software.bernie.geckolib.model.DefaultedGeoModel
    public DefaultedEntityGeoModel<T> withAltAnimations(ResourceLocation altPath) {
        return (DefaultedEntityGeoModel) super.withAltAnimations(altPath);
    }

    @Override // software.bernie.geckolib.model.DefaultedGeoModel
    public DefaultedEntityGeoModel<T> withAltTexture(ResourceLocation altPath) {
        return (DefaultedEntityGeoModel) super.withAltTexture(altPath);
    }
}
