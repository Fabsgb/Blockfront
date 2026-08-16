package foundry.veil.forge.mixin.resources;

import com.mojang.datafixers.util.Pair;
import cpw.mods.niofs.union.UnionFileSystem;
import foundry.veil.Veil;
import foundry.veil.ext.PackResourcesExtension;
import foundry.veil.forge.impl.ForgePackHooks;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.resources.IoSupplier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/resources/PathPackResourcesMixin.class */
@Mixin({PathPackResources.class})
public abstract class PathPackResourcesMixin implements PackResources, PackResourcesExtension {

    @Shadow
    @Final
    private Path root;

    @Unique
    private String[] veil$icon;

    @Unique
    private boolean veil$iconBlur;

    @Shadow
    @Nullable
    public abstract IoSupplier<InputStream> getRootResource(String... strArr);

    @Override // foundry.veil.ext.PackResourcesExtension
    public void veil$listResources(final PackResourcesExtension.PackResourceConsumer consumer) {
        String packId = packId();
        final FileSystem fileSystem = this.root.getFileSystem();
        final String separator = fileSystem.getSeparator();
        for (final PackType type : PackType.values()) {
            final Path assetPath = this.root.resolve(type.getDirectory());
            if (Files.exists(assetPath, new LinkOption[0])) {
                try {
                    Files.walkFileTree(assetPath, new SimpleFileVisitor<Path>(this) { // from class: foundry.veil.forge.mixin.resources.PathPackResourcesMixin.1
                        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                            String[] parts = assetPath.relativize(file).toString().replace(separator, "/").split("/", 2);
                            String namespace = parts.length == 1 ? "root" : parts[0];
                            String path = parts.length == 1 ? parts[0] : parts[1];
                            ResourceLocation name = ResourceLocation.tryBuild(namespace, path);
                            if (name != null) {
                                Path packPath = assetPath;
                                Path filePath = file;
                                Path modResourcePath = null;
                                if (fileSystem instanceof UnionFileSystem) {
                                    UnionFileSystem unionFs = fileSystem;
                                    if (Files.isDirectory(unionFs.getPrimaryPath(), new LinkOption[0])) {
                                        Path primaryPath = unionFs.getPrimaryPath();
                                        Path buildDir = primaryPath.getParent().getParent().getParent();
                                        Path buildPath = buildDir.resolve(PackResourcesExtension.BUILD_RESOURCES_NAME).resolve(primaryPath.getFileName());
                                        packPath = buildPath.getFileSystem().getPath(packPath.toString(), new String[0]);
                                        filePath = buildPath.resolve(file.toString());
                                        modResourcePath = PackResourcesExtension.findDevPath(buildPath, filePath);
                                    }
                                }
                                consumer.accept(type, name, packPath, filePath, modResourcePath);
                            }
                            return FileVisitResult.CONTINUE;
                        }
                    });
                } catch (IOException e) {
                    Veil.LOGGER.warn("Failed to list resources in {} failed!", packId, e);
                }
            }
        }
    }

    @Override // foundry.veil.ext.PackResourcesExtension
    public boolean veil$isStatic() {
        return this.root.getFileSystem() != FileSystems.getDefault();
    }

    @Override // foundry.veil.ext.PackResourcesExtension
    public List<Path> veil$getRawResourceRoots() {
        return Collections.singletonList(this.root);
    }

    @Override // foundry.veil.ext.PackResourcesExtension
    @Nullable
    public IoSupplier<InputStream> veil$getIcon() {
        if (this.veil$icon == null) {
            Pair<String, Boolean> pair = ForgePackHooks.getIcon(this.root);
            this.veil$icon = pair != null ? ((String) pair.getFirst()).split("[/\\\\]") : new String[0];
            this.veil$iconBlur = pair != null && ((Boolean) pair.getSecond()).booleanValue();
        }
        return this.veil$icon.length == 0 ? getRootResource("pack.png") : getRootResource(this.veil$icon);
    }

    @Override // foundry.veil.ext.PackResourcesExtension
    public boolean veil$blurIcon() {
        return this.veil$iconBlur;
    }
}
