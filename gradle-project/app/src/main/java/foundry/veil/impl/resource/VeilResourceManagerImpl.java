package foundry.veil.impl.resource;

import com.mojang.blaze3d.platform.NativeImage;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.VeilRenderer;
import foundry.veil.api.resource.VeilResource;
import foundry.veil.api.resource.VeilResourceInfo;
import foundry.veil.api.resource.VeilResourceLoader;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.api.resource.type.UnknownResource;
import foundry.veil.api.util.CompositeReloadListener;
import foundry.veil.ext.PackResourcesExtension;
import foundry.veil.impl.resource.loader.BlockModelResourceLoader;
import foundry.veil.impl.resource.loader.FlareResourcesLoader;
import foundry.veil.impl.resource.loader.FramebufferResourceLoader;
import foundry.veil.impl.resource.loader.LanguageResourceLoader;
import foundry.veil.impl.resource.loader.McMetaResourceLoader;
import foundry.veil.impl.resource.loader.PostPipelineResourceLoader;
import foundry.veil.impl.resource.loader.RenderTypeResourceLoader;
import foundry.veil.impl.resource.loader.ShaderIncludeLoader;
import foundry.veil.impl.resource.loader.ShaderResourceLoader;
import foundry.veil.impl.resource.loader.ShellResourceLoader;
import foundry.veil.impl.resource.loader.TextResourceLoader;
import foundry.veil.impl.resource.loader.TextureResourceLoader;
import foundry.veil.impl.resource.loader.VanillaShaderResourceLoader;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import it.unimi.dsi.fastutil.objects.ObjectSets;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.IoSupplier;
import net.minecraft.server.packs.resources.MultiPackResourceManager;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/resource/VeilResourceManagerImpl.class */
@ApiStatus.Internal
public class VeilResourceManagerImpl implements VeilResourceManager, NativeResource {
    private static final AtomicInteger WATCHER_ID = new AtomicInteger(1);
    private ResourceManager serverResourceManager = ResourceManager.Empty.INSTANCE;
    private final TextResourceLoader textResourceLoader = new TextResourceLoader();
    private final ObjectList<VeilResourceLoader> loaders = new ObjectArrayList(10);
    private final List<VeilPackResources> packResources = new LinkedList();
    private final Object2ObjectMap<Path, PackResourceListener> watchers = new Object2ObjectArrayMap();

    public void addVeilLoaders(VeilRenderer renderer) {
        addLoader(new ShaderResourceLoader(renderer.getShaderManager()));
        addLoader(new ShaderIncludeLoader());
        addLoader(new VanillaShaderResourceLoader());
        addLoader(new PostPipelineResourceLoader());
        addLoader(new FramebufferResourceLoader());
        addLoader(new RenderTypeResourceLoader());
        addLoader(new TextureResourceLoader());
        addLoader(new McMetaResourceLoader());
        addLoader(new LanguageResourceLoader());
        addLoader(new BlockModelResourceLoader());
        addLoader(new ShellResourceLoader());
        addLoader(new FlareResourcesLoader());
    }

    public void addLoader(VeilResourceLoader loader) {
        this.loaders.add(loader);
    }

    private void loadPack(ResourceManager resourceManager, VeilPackResources resources, Map<Path, PackResourceListener> watchers, PackType type, PackResources packResources) {
        if (packResources instanceof PackResourcesExtension) {
            PackResourcesExtension ext = (PackResourcesExtension) packResources;
            try {
                ext.veil$listResources((packType, loc, packPath, path, modResourcePath) -> {
                    if (packType != type) {
                        return;
                    }
                    try {
                        VeilResource<?> resource = visitResource(packType, resourceManager, loc, path, modResourcePath);
                        resources.add(packType, loc, resource);
                        if (!resource.resourceInfo().isStatic()) {
                            Path listenPath = modResourcePath != null ? modResourcePath : path;
                            if (listenPath != null) {
                                try {
                                    ((PackResourceListener) watchers.computeIfAbsent(packPath, p -> {
                                        return new PackResourceListener(this, p);
                                    })).listen(resource, listenPath);
                                } catch (Throwable t) {
                                    Veil.LOGGER.error("Failed to listen to resource: {}", resource.resourceInfo().location(), t);
                                }
                            }
                        }
                    } catch (Throwable t2) {
                        Veil.LOGGER.error("Error loading resource: {}", loc, t2);
                    }
                });
                return;
            } catch (Throwable t) {
                Veil.LOGGER.error("Failed to load resources from {}", getClass().getSimpleName(), t);
            }
        }
        for (String namespace : packResources.getNamespaces(type)) {
            packResources.listResources(type, namespace, "", (loc2, inputStreamIoSupplier) -> {
                try {
                    resources.add(type, loc2, visitResource(type, resourceManager, loc2, null, null));
                } catch (Throwable t2) {
                    Veil.LOGGER.error("Error loading resource: {}", loc2, t2);
                }
            });
        }
    }

    private VeilResource<?> visitResource(@Nullable PackType packType, ResourceProvider provider, ResourceLocation loc, @Nullable Path path, @Nullable Path modResourcePath) throws IOException {
        ObjectListIterator it = this.loaders.iterator();
        while (it.hasNext()) {
            VeilResourceLoader loader = (VeilResourceLoader) it.next();
            if (loader.canLoad(packType, loc, path, modResourcePath)) {
                return loader.load(this, provider, packType, loc, path, modResourcePath);
            }
        }
        if (this.textResourceLoader.canLoad(packType, loc, path, modResourcePath)) {
            return this.textResourceLoader.load(this, provider, packType, loc, path, modResourcePath);
        }
        return new UnknownResource(new VeilResourceInfo(packType, loc, path, modResourcePath, false));
    }

    public PreparableReloadListener createReloadListener() {
        return CompositeReloadListener.m8346of(new PreparableReloadListener() { // from class: foundry.veil.impl.resource.VeilResourceManagerImpl.1
            public CompletableFuture<Void> reload(PreparableReloadListener.PreparationBarrier preparationBarrier, ResourceManager resourceManager, ProfilerFiller prepareProfiler, ProfilerFiller applyProfiler, Executor backgroundExecutor, Executor gameExecutor) {
                return VeilResourceManagerImpl.this.reloadClient(preparationBarrier, resourceManager, prepareProfiler, applyProfiler, backgroundExecutor, gameExecutor);
            }

            public String getName() {
                return VeilResourceManager.class.getSimpleName() + " Client";
            }
        }, new PreparableReloadListener() { // from class: foundry.veil.impl.resource.VeilResourceManagerImpl.2
            public CompletableFuture<Void> reload(PreparableReloadListener.PreparationBarrier preparationBarrier, ResourceManager resourceManager, ProfilerFiller prepareProfiler, ProfilerFiller applyProfiler, Executor backgroundExecutor, Executor gameExecutor) {
                return VeilResourceManagerImpl.this.reloadServer(preparationBarrier, resourceManager, prepareProfiler, applyProfiler, backgroundExecutor, gameExecutor);
            }

            public String getName() {
                return VeilResourceManager.class.getSimpleName() + " Server";
            }
        });
    }

    private CompletableFuture<Void> reloadClient(PreparableReloadListener.PreparationBarrier preparationBarrier, ResourceManager resourceManager, ProfilerFiller preparationsProfiler, ProfilerFiller reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
        CompletableFuture completableFutureSupplyAsync = CompletableFuture.supplyAsync(() -> {
            List<VeilPackResources> packs = new LinkedList<>();
            Object2ObjectArrayMap object2ObjectArrayMap = new Object2ObjectArrayMap();
            resourceManager.listPacks().flatMap(pack -> {
                if (!(pack instanceof PackResourcesExtension)) {
                    return Stream.of(pack);
                }
                PackResourcesExtension extension = (PackResourcesExtension) pack;
                return extension.veil$listPacks();
            }).forEach(pack2 -> {
                VeilPackResources resources = new VeilPackResources(pack2.packId());
                loadPack(resourceManager, resources, object2ObjectArrayMap, PackType.CLIENT_RESOURCES, pack2);
                packs.add(resources);
                if (pack2 instanceof PackResourcesExtension) {
                    PackResourcesExtension extension = (PackResourcesExtension) pack2;
                    try {
                        IoSupplier<InputStream> icon = extension.veil$getIcon();
                        if (icon != null) {
                            NativeImage image = NativeImage.read((InputStream) icon.get());
                            boolean blur = extension.veil$blurIcon();
                            gameExecutor.execute(() -> {
                                try {
                                    resources.loadIcon(image, blur);
                                    if (image != null) {
                                        image.close();
                                    }
                                } catch (Throwable th) {
                                    if (image != null) {
                                        try {
                                            image.close();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                    }
                                    throw th;
                                }
                            });
                        }
                    } catch (Throwable t) {
                        Veil.LOGGER.error("Failed to load icon for pack: {}", pack2.packId(), t);
                    }
                }
            });
            return new Preparations(packs, object2ObjectArrayMap);
        }, backgroundExecutor);
        Objects.requireNonNull(preparationBarrier);
        return completableFutureSupplyAsync.thenCompose((v1) -> {
            return r1.wait(v1);
        }).thenAcceptAsync(preparations -> {
            free();
            this.packResources.addAll(preparations.packs());
            this.watchers.putAll(preparations.watchers());
        }, gameExecutor);
    }

    private CompletableFuture<Void> reloadServer(PreparableReloadListener.PreparationBarrier preparationBarrier, ResourceManager resourceManager, ProfilerFiller preparationsProfiler, ProfilerFiller reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
        CompletableFuture completableFutureSupplyAsync = CompletableFuture.supplyAsync(() -> {
            MultiPackResourceManager multiPackResourceManager = new MultiPackResourceManager(PackType.SERVER_DATA, resourceManager.listPacks().toList());
            this.serverResourceManager = multiPackResourceManager;
            return multiPackResourceManager;
        }, backgroundExecutor);
        Objects.requireNonNull(preparationBarrier);
        return completableFutureSupplyAsync.thenCompose((v1) -> {
            return r1.wait(v1);
        }).thenAcceptAsync(serverResourceManager -> {
            this.serverResourceManager = serverResourceManager;
        }, gameExecutor);
    }

    @Override // foundry.veil.api.resource.VeilResourceManager
    public ResourceManager clientResources() {
        return Minecraft.getInstance().getResourceManager();
    }

    @Override // foundry.veil.api.resource.VeilResourceManager
    public ResourceManager serverResources() {
        return this.serverResourceManager;
    }

    @Override // foundry.veil.api.resource.VeilResourceManager
    @Nullable
    public VeilResource<?> getVeilResource(String namespace, String path) {
        for (VeilPackResources pack : this.packResources) {
            VeilResource<?> resource = pack.getVeilResource(namespace, path);
            if (resource != null) {
                return resource;
            }
        }
        return null;
    }

    public void free() {
        ObjectIterator it = this.watchers.values().iterator();
        while (it.hasNext()) {
            PackResourceListener listener = (PackResourceListener) it.next();
            try {
                listener.close();
            } catch (IOException e) {
                Veil.LOGGER.error("Error closing watch service: {}", listener.getPath(), e);
            }
        }
        this.watchers.clear();
        for (VeilPackResources resources : this.packResources) {
            resources.free();
        }
        this.packResources.clear();
        WATCHER_ID.set(1);
    }

    public List<VeilPackResources> getAllPacks() {
        return this.packResources;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/resource/VeilResourceManagerImpl$Preparations.class */
    private static final class Preparations extends Record {
        private final List<VeilPackResources> packs;
        private final Object2ObjectMap<Path, PackResourceListener> watchers;

        private Preparations(List<VeilPackResources> packs, Object2ObjectMap<Path, PackResourceListener> watchers) {
            this.packs = packs;
            this.watchers = watchers;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Preparations.class), Preparations.class, "packs;watchers", "FIELD:Lfoundry/veil/impl/resource/VeilResourceManagerImpl$Preparations;->packs:Ljava/util/List;", "FIELD:Lfoundry/veil/impl/resource/VeilResourceManagerImpl$Preparations;->watchers:Lit/unimi/dsi/fastutil/objects/Object2ObjectMap;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Preparations.class), Preparations.class, "packs;watchers", "FIELD:Lfoundry/veil/impl/resource/VeilResourceManagerImpl$Preparations;->packs:Ljava/util/List;", "FIELD:Lfoundry/veil/impl/resource/VeilResourceManagerImpl$Preparations;->watchers:Lit/unimi/dsi/fastutil/objects/Object2ObjectMap;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Preparations.class, Object.class), Preparations.class, "packs;watchers", "FIELD:Lfoundry/veil/impl/resource/VeilResourceManagerImpl$Preparations;->packs:Ljava/util/List;", "FIELD:Lfoundry/veil/impl/resource/VeilResourceManagerImpl$Preparations;->watchers:Lit/unimi/dsi/fastutil/objects/Object2ObjectMap;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public List<VeilPackResources> packs() {
            return this.packs;
        }

        public Object2ObjectMap<Path, PackResourceListener> watchers() {
            return this.watchers;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/resource/VeilResourceManagerImpl$PackResourceListener.class */
    private static class PackResourceListener implements Closeable {
        private final VeilResourceManager resourceManager;
        private final Path path;
        private final WatchService watchService;
        private final ObjectSet<Path> watchedDirectories;
        private final ObjectSet<Path> ignoredPaths;
        private final Object2ObjectMap<Path, VeilResource<?>> resources;
        private final Thread watchThread;

        public PackResourceListener(VeilResourceManager resourceManager, Path path) {
            WatchService watchService;
            try {
                watchService = path.getFileSystem().newWatchService();
            } catch (Exception e) {
                watchService = null;
            }
            this.resourceManager = resourceManager;
            this.path = path;
            this.watchService = watchService;
            this.watchedDirectories = ObjectSets.synchronize(new ObjectArraySet());
            this.ignoredPaths = ObjectSets.synchronize(new ObjectArraySet());
            this.resources = new Object2ObjectOpenHashMap();
            if (this.watchService != null) {
                this.watchThread = new Thread(this::run, "Veil File Watcher Thread " + VeilResourceManagerImpl.WATCHER_ID.getAndIncrement());
                this.watchThread.start();
            } else {
                this.watchThread = null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void run() {
            VeilResource veilResource;
            while (true) {
                try {
                    WatchKey key = this.watchService.take();
                    for (WatchEvent<?> event : key.pollEvents()) {
                        WatchEvent.Kind<?> kind = event.kind();
                        if (kind != StandardWatchEventKinds.OVERFLOW) {
                            Path path = ((Path) key.watchable()).resolve((Path) event.context());
                            if (this.ignoredPaths.add(path) && (veilResource = (VeilResource) this.resources.get(path)) != 0) {
                                veilResource.onFileSystemChange(this.resourceManager, event).thenRun(() -> {
                                    this.ignoredPaths.remove(path);
                                    Minecraft.getInstance().execute(() -> {
                                        VeilRenderSystem.renderer().getEditorManager().onFileChange(veilResource);
                                    });
                                });
                            }
                        }
                    }
                    key.reset();
                } catch (ClosedWatchServiceException e) {
                    return;
                } catch (Throwable t) {
                    Veil.LOGGER.error("Error waiting for file", t);
                    return;
                }
            }
        }

        public void listen(VeilResource<?> resource, Path listenPath) throws IOException {
            Path folder = listenPath.getParent();
            if (folder == null) {
                return;
            }
            this.resources.put(listenPath, resource);
            if (this.watchService != null && this.watchedDirectories.add(folder)) {
                folder.register(this.watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.watchService != null) {
                this.watchService.close();
            }
            try {
                if (this.watchThread != null) {
                    this.watchThread.join();
                }
            } catch (InterruptedException e) {
                throw new IOException("Failed to stop watcher thread", e);
            }
        }

        public Path getPath() {
            return this.path;
        }
    }
}
