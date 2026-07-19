package foundry.veil.impl.resource.loader;

import foundry.veil.api.resource.VeilResource;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceLoader;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.api.resource.type.LanguageResource;
import java.io.IOException;
import java.nio.file.Path;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceProvider;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/resource/loader/LanguageResourceLoader.class */
public class LanguageResourceLoader implements VeilResourceLoader {
    public static final String EXTENSION = ".json";
    public static final String PATH = "lang";

    @Override // foundry.veil.api.resource.VeilResourceLoader
    public boolean canLoad(PackType packType, ResourceLocation location, @Nullable Path filePath, @Nullable Path modResourcePath) {
        if (packType != PackType.CLIENT_RESOURCES) {
            return false;
        }
        String path = location.getPath();
        if (path.startsWith(PATH)) {
            return path.endsWith(".json");
        }
        return false;
    }

    @Override // foundry.veil.api.resource.VeilResourceLoader
    public VeilResource<?> load(VeilResourceManager resourceManager, ResourceProvider provider, PackType packType, ResourceLocation location, @Nullable Path filePath, @Nullable Path modResourcePath) throws IOException {
        VeilResourceInfo info = new VeilResourceInfo(packType, location, filePath, modResourcePath, false);
        return new LanguageResource(info);
    }
}
