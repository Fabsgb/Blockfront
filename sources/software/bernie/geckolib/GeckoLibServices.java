package software.bernie.geckolib;

import java.util.ServiceLoader;
import software.bernie.geckolib.service.GeckoLibEvents;
import software.bernie.geckolib.service.GeckoLibNetworking;
import software.bernie.geckolib.service.GeckoLibPlatform;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/GeckoLibServices.class */
public final class GeckoLibServices {
    public static final GeckoLibPlatform PLATFORM = (GeckoLibPlatform) load(GeckoLibPlatform.class);
    public static final GeckoLibNetworking NETWORK = (GeckoLibNetworking) load(GeckoLibNetworking.class);

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/GeckoLibServices$Client.class */
    public static class Client {
        public static final GeckoLibEvents EVENTS = (GeckoLibEvents) GeckoLibServices.load(GeckoLibEvents.class);
        public static final software.bernie.geckolib.service.GeckoLibClient ITEM_RENDERING = (software.bernie.geckolib.service.GeckoLibClient) GeckoLibServices.load(software.bernie.geckolib.service.GeckoLibClient.class);
    }

    private static <T> T load(Class<T> cls) {
        T t = (T) ServiceLoader.load(cls).findFirst().orElseThrow(() -> {
            return new NullPointerException("Failed to load service for " + cls.getName());
        });
        GeckoLibConstants.LOGGER.debug("Loaded {} for service {}", t, cls);
        return t;
    }
}
