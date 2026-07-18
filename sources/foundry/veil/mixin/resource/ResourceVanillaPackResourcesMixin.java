package foundry.veil.mixin.resource;

import foundry.veil.Veil;
import foundry.veil.ext.PackResourcesExtension;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.VanillaPackResources;
import net.minecraft.server.packs.resources.IoSupplier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/resource/ResourceVanillaPackResourcesMixin.class */
@Mixin({VanillaPackResources.class})
public abstract class ResourceVanillaPackResourcesMixin implements PackResourcesExtension {

    @Shadow
    @Final
    private Map<PackType, List<Path>> pathsForType;

    @Shadow
    @Final
    private Set<String> namespaces;

    @Shadow
    public abstract IoSupplier<InputStream> getRootResource(String... strArr);

    @Override // foundry.veil.ext.PackResourcesExtension
    public void veil$listResources(final PackResourcesExtension.PackResourceConsumer consumer) {
        for (Map.Entry<PackType, List<Path>> entry : this.pathsForType.entrySet()) {
            final PackType type = entry.getKey();
            for (Path basePath : entry.getValue()) {
                final String separator = basePath.getFileSystem().getSeparator();
                for (final String namespace : this.namespaces) {
                    final Path nsPath = basePath.resolve(namespace);
                    try {
                        Files.walkFileTree(nsPath, new SimpleFileVisitor<Path>(this) { // from class: foundry.veil.mixin.resource.ResourceVanillaPackResourcesMixin.1
                            @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                                if (type == PackType.CLIENT_RESOURCES && dir.endsWith(PackType.SERVER_DATA.getDirectory())) {
                                    return FileVisitResult.SKIP_SUBTREE;
                                }
                                if (type == PackType.SERVER_DATA && dir.endsWith(PackType.CLIENT_RESOURCES.getDirectory())) {
                                    return FileVisitResult.SKIP_SUBTREE;
                                }
                                return FileVisitResult.CONTINUE;
                            }

                            @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                                String filename = nsPath.relativize(file).toString().replace(separator, "/");
                                ResourceLocation name = ResourceLocation.tryBuild(namespace, filename);
                                if (name != null) {
                                    consumer.accept(type, name, nsPath, file, null);
                                }
                                return FileVisitResult.CONTINUE;
                            }

                            @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                                if (file.endsWith("/assets/realms") || file.endsWith("/data/realms")) {
                                    return FileVisitResult.CONTINUE;
                                }
                                return super.visitFileFailed(file, exc);
                            }
                        });
                    } catch (IOException e) {
                        Veil.LOGGER.warn("findResources in vanilla {} failed!", namespace, e);
                    }
                }
            }
        }
    }

    @Override // foundry.veil.ext.PackResourcesExtension
    public boolean veil$isStatic() {
        return true;
    }

    @Override // foundry.veil.ext.PackResourcesExtension
    public List<Path> veil$getRawResourceRoots() {
        return Collections.emptyList();
    }

    @Override // foundry.veil.ext.PackResourcesExtension
    @Nullable
    public IoSupplier<InputStream> veil$getIcon() {
        return getRootResource("icons", "icon_32x32.png");
    }

    @Override // foundry.veil.ext.PackResourcesExtension
    public boolean veil$blurIcon() {
        return false;
    }
}
