package software.bernie.geckolib;

import software.bernie.geckolib.cache.GeckoLibCache;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/GeckoLibClient.class */
public final class GeckoLibClient {
    public static void init() {
        GeckoLibCache.registerReloadListener();
    }
}
