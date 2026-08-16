package foundry.veil.api.resource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.Resource;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/VeilResourceInfo.class */
public final class VeilResourceInfo extends Record {
    private final PackType packType;
    private final ResourceLocation location;
    private final Path filePath;

    @Nullable
    private final Path modResourcePath;
    private final boolean hidden;

    public VeilResourceInfo(PackType packType, ResourceLocation location, Path filePath, @Nullable Path modResourcePath, boolean hidden) {
        this.packType = packType;
        this.location = location;
        this.filePath = filePath;
        this.modResourcePath = modResourcePath;
        this.hidden = hidden;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, VeilResourceInfo.class), VeilResourceInfo.class, "packType;location;filePath;modResourcePath;hidden", "FIELD:Lfoundry/veil/api/resource/VeilResourceInfo;->packType:Lnet/minecraft/server/packs/PackType;", "FIELD:Lfoundry/veil/api/resource/VeilResourceInfo;->location:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/resource/VeilResourceInfo;->filePath:Ljava/nio/file/Path;", "FIELD:Lfoundry/veil/api/resource/VeilResourceInfo;->modResourcePath:Ljava/nio/file/Path;", "FIELD:Lfoundry/veil/api/resource/VeilResourceInfo;->hidden:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, VeilResourceInfo.class), VeilResourceInfo.class, "packType;location;filePath;modResourcePath;hidden", "FIELD:Lfoundry/veil/api/resource/VeilResourceInfo;->packType:Lnet/minecraft/server/packs/PackType;", "FIELD:Lfoundry/veil/api/resource/VeilResourceInfo;->location:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/resource/VeilResourceInfo;->filePath:Ljava/nio/file/Path;", "FIELD:Lfoundry/veil/api/resource/VeilResourceInfo;->modResourcePath:Ljava/nio/file/Path;", "FIELD:Lfoundry/veil/api/resource/VeilResourceInfo;->hidden:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, VeilResourceInfo.class, Object.class), VeilResourceInfo.class, "packType;location;filePath;modResourcePath;hidden", "FIELD:Lfoundry/veil/api/resource/VeilResourceInfo;->packType:Lnet/minecraft/server/packs/PackType;", "FIELD:Lfoundry/veil/api/resource/VeilResourceInfo;->location:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/resource/VeilResourceInfo;->filePath:Ljava/nio/file/Path;", "FIELD:Lfoundry/veil/api/resource/VeilResourceInfo;->modResourcePath:Ljava/nio/file/Path;", "FIELD:Lfoundry/veil/api/resource/VeilResourceInfo;->hidden:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public PackType packType() {
        return this.packType;
    }

    public ResourceLocation location() {
        return this.location;
    }

    public Path filePath() {
        return this.filePath;
    }

    @Nullable
    public Path modResourcePath() {
        return this.modResourcePath;
    }

    public boolean hidden() {
        return this.hidden;
    }

    public Optional<Resource> getResource(VeilResourceManager resourceManager) {
        return resourceManager.resources(this).getResource(this.location);
    }

    public Resource getResourceOrThrow(VeilResourceManager resourceManager) throws FileNotFoundException {
        return getResource(resourceManager).orElseThrow(() -> {
            return new FileNotFoundException(this.location.toString());
        });
    }

    public InputStream open(VeilResourceManager resourceManager) throws IOException {
        return getResourceOrThrow(resourceManager).open();
    }

    public BufferedReader openAsReader(VeilResourceManager resourceManager) throws IOException {
        return getResourceOrThrow(resourceManager).openAsReader();
    }

    public String fileName() {
        String path = location().getPath();
        String[] split = path.split("/");
        return split[split.length - 1];
    }

    public boolean isStatic() {
        Path filePath = this.modResourcePath != null ? this.modResourcePath : this.filePath;
        return filePath == null || filePath.getFileSystem() != FileSystems.getDefault();
    }
}
