package foundry.veil.impl.resource.loader;

import foundry.veil.api.resource.VeilResource;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceLoader;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.api.resource.type.VanillaShaderFileResource;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceProvider;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/resource/loader/VanillaShaderResourceLoader.class */
public class VanillaShaderResourceLoader implements VeilResourceLoader {
    private static final Set<String> EXTENSIONS = Set.of(".glsl", ".vsh", ".fsh");

    @Override // foundry.veil.api.resource.VeilResourceLoader
    public boolean canLoad(PackType packType, ResourceLocation location, Path filePath, @Nullable Path modResourcePath) {
        if (packType != PackType.CLIENT_RESOURCES) {
            return false;
        }
        String path = location.getPath();
        if (path.startsWith("shaders")) {
            for (String extension : EXTENSIONS) {
                if (path.endsWith(extension)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // foundry.veil.api.resource.VeilResourceLoader
    public VeilResource<?> load(VeilResourceManager resourceManager, ResourceProvider provider, PackType packType, ResourceLocation location, @Nullable Path filePath, @Nullable Path modResourcePath) throws IOException {
        return new VanillaShaderFileResource(new VeilResourceInfo(packType, location, filePath, modResourcePath, false));
    }
}
