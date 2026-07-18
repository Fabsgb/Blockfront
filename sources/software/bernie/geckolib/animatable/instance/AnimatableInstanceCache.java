package software.bernie.geckolib.animatable.instance;

import com.google.common.base.Suppliers;
import java.util.Objects;
import java.util.function.Supplier;
import org.apache.commons.lang3.mutable.MutableObject;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.constant.dataticket.DataTicket;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animatable/instance/AnimatableInstanceCache.class */
public abstract class AnimatableInstanceCache {
    protected final GeoAnimatable animatable;
    protected final Supplier<GeoRenderProvider> renderProvider = Suppliers.memoize(() -> {
        GeoAnimatable patt0$temp = this.animatable;
        if (!(patt0$temp instanceof SingletonGeoAnimatable)) {
            return null;
        }
        SingletonGeoAnimatable singleton = (SingletonGeoAnimatable) patt0$temp;
        if (!GeckoLibServices.PLATFORM.isPhysicalClient()) {
            return null;
        }
        MutableObject<GeoRenderProvider> consumer = new MutableObject<>(GeoRenderProvider.DEFAULT);
        Objects.requireNonNull(consumer);
        singleton.createGeoRenderer((v1) -> {
            r1.setValue(v1);
        });
        return (GeoRenderProvider) consumer.getValue();
    });

    public abstract <T extends GeoAnimatable> AnimatableManager<T> getManagerForId(long j);

    public AnimatableInstanceCache(GeoAnimatable animatable) {
        this.animatable = animatable;
    }

    public <D> void addDataPoint(long uniqueId, DataTicket<D> dataTicket, D data) {
        getManagerForId(uniqueId).setData(dataTicket, data);
    }

    public <D> D getDataPoint(long j, DataTicket<D> dataTicket) {
        return (D) getManagerForId(j).getData(dataTicket);
    }

    public Object getRenderProvider() {
        return this.renderProvider.get();
    }
}
