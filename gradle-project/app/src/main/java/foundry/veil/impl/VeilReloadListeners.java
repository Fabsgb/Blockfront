package foundry.veil.impl;

import foundry.veil.Veil;
import foundry.veil.VeilClient;
import foundry.veil.api.quasar.data.QuasarParticles;
import foundry.veil.ext.PackResourcesExtension;
import foundry.veil.impl.flare.FlareManager;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/VeilReloadListeners.class */
@ApiStatus.Internal
public final class VeilReloadListeners {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/VeilReloadListeners$Context.class */
    @FunctionalInterface
    public interface Context {
        void register(PackType packType, String str, PreparableReloadListener preparableReloadListener);
    }

    public static void registerListeners(Context context) {
        context.register(PackType.CLIENT_RESOURCES, "quasar", new QuasarParticles.Reloader());
        context.register(PackType.CLIENT_RESOURCES, "flare", FlareManager.Reloader.INSTANCE);
        if (Veil.IMGUIMC) {
            context.register(PackType.CLIENT_RESOURCES, PackResourcesExtension.BUILD_RESOURCES_NAME, VeilClient.resourceManager().createReloadListener());
        }
    }
}
