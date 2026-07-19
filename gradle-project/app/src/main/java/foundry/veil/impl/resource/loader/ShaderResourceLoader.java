package foundry.veil.impl.resource.loader;

import foundry.veil.api.client.render.shader.ShaderManager;
import foundry.veil.api.resource.VeilResource;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceLoader;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.api.resource.type.VeilShaderDefinitionResource;
import foundry.veil.api.resource.type.VeilShaderFileResource;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceProvider;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/resource/loader/ShaderResourceLoader.class */
public class ShaderResourceLoader implements VeilResourceLoader {
    private static final Set<String> EXTENSIONS = Set.of(".json", ".glsl", ".vsh", ".tcsh", ".tesh", ".gsh", ".fsh", ".comp");
    private final ShaderManager shaderManager;

    public ShaderResourceLoader(ShaderManager shaderManager) {
        this.shaderManager = shaderManager;
    }

    @Override // foundry.veil.api.resource.VeilResourceLoader
    public boolean canLoad(PackType packType, ResourceLocation location, Path filePath, @Nullable Path modResourcePath) {
        if (packType != PackType.CLIENT_RESOURCES) {
            return false;
        }
        String path = location.getPath();
        if (path.startsWith(this.shaderManager.getSourceSet().getFolder())) {
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
        VeilResourceInfo info = new VeilResourceInfo(packType, location, filePath, modResourcePath, false);
        return location.getPath().endsWith(".json") ? new VeilShaderDefinitionResource(info, this.shaderManager) : new VeilShaderFileResource(info, this.shaderManager);
    }
}
