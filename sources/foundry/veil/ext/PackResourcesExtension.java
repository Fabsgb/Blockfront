package foundry.veil.ext;

import foundry.veil.Veil;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.IoSupplier;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/ext/PackResourcesExtension.class */
@ApiStatus.Internal
public interface PackResourcesExtension {
    public static final String BUILD_RESOURCES_NAME = "resources";

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/ext/PackResourcesExtension$PackResourceConsumer.class */
    @FunctionalInterface
    public interface PackResourceConsumer {
        void accept(@Nullable PackType packType, ResourceLocation resourceLocation, Path path, Path path2, @Nullable Path path3);
    }

    void veil$listResources(PackResourceConsumer packResourceConsumer);

    @Nullable
    IoSupplier<InputStream> veil$getIcon();

    boolean veil$blurIcon();

    boolean veil$isStatic();

    List<Path> veil$getRawResourceRoots();

    default Stream<PackResources> veil$listPacks() {
        return Stream.of((PackResources) this);
    }

    @Nullable
    static Path findDevPath(Path root, Path file) {
        Path defaultRoot;
        if (file.getFileSystem() == FileSystems.getDefault() && file.getNameCount() > 3) {
            Path buildRoot = root;
            String sourceRoot = null;
            Path localPath = null;
            while (buildRoot != null) {
                try {
                    if (buildRoot.getFileName() == null || "build".equals(buildRoot.getFileName().toString())) {
                        break;
                    }
                    Path parent = buildRoot.getParent();
                    if (parent != null && parent.getFileName() != null && parent.getFileName().toString().equals(BUILD_RESOURCES_NAME)) {
                        sourceRoot = buildRoot.getFileName().toString();
                        localPath = buildRoot.relativize(file);
                    }
                    buildRoot = parent;
                } catch (Exception e) {
                    Veil.LOGGER.error("Failed to find IDE source root", e);
                    return null;
                }
            }
            if (buildRoot == null || sourceRoot == null || (defaultRoot = buildRoot.getParent()) == null) {
                return null;
            }
            Path buildPath = defaultRoot.resolve("src").resolve(sourceRoot).resolve(BUILD_RESOURCES_NAME).resolve(localPath);
            if (Files.exists(buildPath, new LinkOption[0])) {
                return buildPath;
            }
            Path projectRoot = defaultRoot.getParent();
            if (projectRoot == null) {
                return null;
            }
            Stream<Path> walk = Files.list(projectRoot).filter(path -> {
                return Files.isDirectory(path, new LinkOption[0]) && !path.startsWith(defaultRoot);
            });
            try {
                for (Path possibleRoot : walk.toList()) {
                    Path resourcesPath = possibleRoot.resolve("src").resolve(sourceRoot).resolve(BUILD_RESOURCES_NAME).resolve(localPath);
                    if (Files.exists(resourcesPath, new LinkOption[0])) {
                        if (walk != null) {
                            walk.close();
                        }
                        return resourcesPath;
                    }
                }
                if (walk != null) {
                    walk.close();
                }
                return null;
            } catch (Throwable th) {
                if (walk != null) {
                    try {
                        walk.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return null;
    }

    static List<Path> findDevPaths(Path root, Path file) {
        List<Path> paths = new ArrayList<>();
        if (file.getFileSystem() != FileSystems.getDefault()) {
            return paths;
        }
        if (file.getNameCount() > 3) {
            Path buildRoot = root;
            String sourceRoot = null;
            Path localPath = null;
            while (buildRoot != null) {
                try {
                    if (buildRoot.getFileName() == null || "build".equals(buildRoot.getFileName().toString())) {
                        break;
                    }
                    Path parent = buildRoot.getParent();
                    if (parent != null && parent.getFileName() != null && parent.getFileName().toString().equals(BUILD_RESOURCES_NAME)) {
                        sourceRoot = buildRoot.getFileName().toString();
                        localPath = buildRoot.relativize(file);
                    }
                    buildRoot = parent;
                } catch (Exception e) {
                    Veil.LOGGER.error("Failed to find IDE source root", e);
                }
            }
            if (buildRoot == null || sourceRoot == null) {
                return paths;
            }
            Path defaultRoot = buildRoot.getParent();
            if (defaultRoot == null) {
                return paths;
            }
            Path buildPath = defaultRoot.resolve("src").resolve(sourceRoot).resolve(BUILD_RESOURCES_NAME).resolve(localPath);
            if (Files.exists(buildPath, new LinkOption[0])) {
                paths.add(buildPath);
            }
            Path projectRoot = defaultRoot.getParent();
            if (projectRoot == null) {
                return paths;
            }
            Stream<Path> walk = Files.list(projectRoot).filter(path -> {
                return Files.isDirectory(path, new LinkOption[0]) && !path.startsWith(defaultRoot);
            });
            try {
                for (Path possibleRoot : walk.toList()) {
                    Path resourcesPath = possibleRoot.resolve("src").resolve(sourceRoot).resolve(BUILD_RESOURCES_NAME).resolve(localPath);
                    if (Files.exists(resourcesPath, new LinkOption[0])) {
                        paths.add(resourcesPath);
                    }
                }
                if (walk != null) {
                    walk.close();
                }
            } catch (Throwable th) {
                if (walk != null) {
                    try {
                        walk.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return paths;
    }
}
