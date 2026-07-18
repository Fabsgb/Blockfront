package foundry.veil.ext;

import java.util.Collection;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/ext/ShaderInstanceExtension.class */
@ApiStatus.Internal
public interface ShaderInstanceExtension {
    boolean veil$isRecompileReady(int i);

    boolean veil$applyCompile();

    boolean veil$swapBuffers(int i);

    void veil$recompile(boolean z, String str, int i);

    Collection<ResourceLocation> veil$getShaderSources();

    int veil$getActiveBuffers();
}
