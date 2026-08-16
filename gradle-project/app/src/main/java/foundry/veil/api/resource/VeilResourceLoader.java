package foundry.veil.api.resource;

import java.io.IOException;
import java.nio.file.Path;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceProvider;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/VeilResourceLoader.class */
public interface VeilResourceLoader {
    boolean canLoad(PackType packType, ResourceLocation resourceLocation, @Nullable Path path, @Nullable Path path2);

    VeilResource<?> load(VeilResourceManager veilResourceManager, ResourceProvider resourceProvider, PackType packType, ResourceLocation resourceLocation, @Nullable Path path, @Nullable Path path2) throws IOException;
}
