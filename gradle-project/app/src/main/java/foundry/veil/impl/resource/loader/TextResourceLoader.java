package foundry.veil.impl.resource.loader;

import foundry.veil.api.resource.VeilResource;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceLoader;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.api.resource.type.TextResource;
import java.io.IOException;
import java.nio.file.Path;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceProvider;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/resource/loader/TextResourceLoader.class */
public class TextResourceLoader implements VeilResourceLoader {
    @Override // foundry.veil.api.resource.VeilResourceLoader
    public boolean canLoad(PackType packType, ResourceLocation location, @Nullable Path filePath, @Nullable Path modResourcePath) {
        for (TextResource.Type type : TextResource.Type.values()) {
            if (location.getPath().endsWith(type.getExtension())) {
                return true;
            }
        }
        return false;
    }

    @Override // foundry.veil.api.resource.VeilResourceLoader
    public VeilResource<?> load(VeilResourceManager resourceManager, ResourceProvider provider, PackType packType, ResourceLocation location, @Nullable Path filePath, @Nullable Path modResourcePath) throws IOException {
        for (TextResource.Type type : TextResource.Type.values()) {
            if (location.getPath().endsWith(type.getExtension())) {
                return new TextResource(new VeilResourceInfo(packType, location, filePath, modResourcePath, false), type);
            }
        }
        throw new IOException("Unknown text resource: " + String.valueOf(location));
    }
}
