package foundry.veil.impl.resource.loader;

import foundry.veil.api.resource.VeilResource;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceLoader;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.api.resource.type.McMetaResource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceMetadata;
import net.minecraft.server.packs.resources.ResourceProvider;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/resource/loader/McMetaResourceLoader.class */
public class McMetaResourceLoader implements VeilResourceLoader {
    @Override // foundry.veil.api.resource.VeilResourceLoader
    public boolean canLoad(PackType packType, ResourceLocation location, @Nullable Path filePath, @Nullable Path modResourcePath) {
        return location.getPath().endsWith(".mcmeta");
    }

    @Override // foundry.veil.api.resource.VeilResourceLoader
    public VeilResource<?> load(VeilResourceManager resourceManager, ResourceProvider provider, PackType packType, ResourceLocation location, @Nullable Path filePath, @Nullable Path modResourcePath) throws IOException {
        ResourceLocation basePath = location.withPath(s -> {
            return s.substring(0, s.length() - 7);
        });
        Optional<Resource> optional = provider.getResource(basePath);
        if (optional.isPresent()) {
            return new McMetaResource(new VeilResourceInfo(packType, location, filePath, modResourcePath, true), basePath, optional.get().metadata());
        }
        InputStream stream = provider.open(location);
        try {
            McMetaResource mcMetaResource = new McMetaResource(new VeilResourceInfo(packType, location, filePath, modResourcePath, false), null, ResourceMetadata.fromJsonStream(stream));
            if (stream != null) {
                stream.close();
            }
            return mcMetaResource;
        } catch (Throwable th) {
            if (stream != null) {
                try {
                    stream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
