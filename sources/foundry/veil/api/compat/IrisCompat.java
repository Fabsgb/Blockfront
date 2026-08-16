package foundry.veil.api.compat;

import foundry.veil.Veil;
import foundry.veil.ext.iris.IrisRenderTargetExtension;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import net.minecraft.client.renderer.ShaderInstance;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/compat/IrisCompat.class */
public interface IrisCompat {

    @Nullable
    public static final IrisCompat INSTANCE;

    Set<ShaderInstance> getLoadedShaders();

    Map<String, IrisRenderTargetExtension> getRenderTargets();

    boolean areShadersLoaded();

    @ApiStatus.Experimental
    void recompile();

    Class<?> getPipelineClass();

    static {
        INSTANCE = Veil.platform().isModLoaded("iris") ? (IrisCompat) ServiceLoader.load(IrisCompat.class).findFirst().orElse(null) : null;
    }

    static boolean isLoaded() {
        return INSTANCE != null;
    }
}
