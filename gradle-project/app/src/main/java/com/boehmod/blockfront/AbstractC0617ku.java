package com.boehmod.blockfront;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.InactiveProfiler;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ku */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ku.class */
public abstract class AbstractC0617ku<T> extends SimplePreparableReloadListener<Map<ResourceLocation, T>> {
    @NotNull
    /* JADX INFO: renamed from: G */
    protected abstract String mo2768G();

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract Codec<T> mo2769a();

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract ResourceLocation mo2774a(@NotNull T t, @NotNull ResourceLocation resourceLocation);

    protected AbstractC0617ku(@NotNull ResourceManager resourceManager) {
        if (resourceManager instanceof ReloadableResourceManager) {
            C0530jM.log("Registering reload listener for %s", mo2768G());
            ((ReloadableResourceManager) resourceManager).registerReloadListener(this);
        }
        apply(prepare(resourceManager, InactiveProfiler.INSTANCE), resourceManager, InactiveProfiler.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Map<ResourceLocation, T> prepare(@NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        Map<ResourceLocation, T> mapM2808a = m2808a(resourceManager, mo2768G(), mo2769a(), this::mo2774a);
        C0530jM.log("Loaded %d entries from %s", Integer.valueOf(mapM2808a.size()), mo2768G());
        return mapM2808a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* JADX INFO: renamed from: a */
    protected static <T> Map<ResourceLocation, T> m2808a(@NotNull ResourceManager resourceManager, @NotNull String str, @NotNull Codec<T> codec, @NotNull BiFunction<T, ResourceLocation, ResourceLocation> biFunction) {
        Gson gson = new Gson();
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        for (Map.Entry entry : resourceManager.listResources(str, resourceLocation -> {
            return resourceLocation.getPath().endsWith(".json");
        }).entrySet()) {
            ResourceLocation resourceLocation2 = (ResourceLocation) entry.getKey();
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(((Resource) entry.getValue()).open());
                try {
                    Object orThrow = codec.parse(JsonOps.INSTANCE, (JsonElement) gson.fromJson(inputStreamReader, JsonElement.class)).getOrThrow(str2 -> {
                        C0530jM.logError("Failed to parse %s from %s: %s", str, resourceLocation2, str2);
                        return new RuntimeException(str2);
                    });
                    object2ObjectLinkedOpenHashMap.put((ResourceLocation) biFunction.apply(orThrow, resourceLocation2), orThrow);
                    inputStreamReader.close();
                } catch (Throwable th) {
                    try {
                        inputStreamReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                C0530jM.m2338a("Failed to read %s from %s", e, str, resourceLocation2);
            }
        }
        return object2ObjectLinkedOpenHashMap;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected static <T> Map<ResourceLocation, T> m2809a(@NotNull Class<?> cls, @NotNull String str, @NotNull Codec<T> codec, @NotNull BiFunction<T, String, ResourceLocation> biFunction) {
        Path pathOf;
        Gson gson = new Gson();
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        String str2 = "/assets/bf/" + str;
        try {
            URL resource = cls.getResource(str2);
            if (resource == null) {
                C0530jM.logError("Directory not found on classpath: %s", str2);
                return object2ObjectLinkedOpenHashMap;
            }
            URI uri = resource.toURI();
            FileSystem fileSystemNewFileSystem = null;
            if (uri.getScheme().equals("jar")) {
                fileSystemNewFileSystem = FileSystems.newFileSystem(uri, (Map<String, ?>) Map.of());
                pathOf = fileSystemNewFileSystem.getPath(str2, new String[0]);
            } else {
                pathOf = Path.of(uri);
            }
            try {
                Stream<Path> list = Files.list(pathOf);
                try {
                    list.filter(path -> {
                        return path.toString().endsWith(".json");
                    }).sorted().forEach(path2 -> {
                        try {
                            InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(path2, new OpenOption[0]));
                            try {
                                Object orThrow = codec.parse(JsonOps.INSTANCE, (JsonElement) gson.fromJson(inputStreamReader, JsonElement.class)).getOrThrow(str3 -> {
                                    C0530jM.logError("Failed to parse from classpath %s: %s", path2, str3);
                                    return new RuntimeException(str3);
                                });
                                String string = path2.getFileName().toString();
                                object2ObjectLinkedOpenHashMap.put((ResourceLocation) biFunction.apply(orThrow, string.substring(0, string.lastIndexOf(46))), orThrow);
                                inputStreamReader.close();
                            } catch (Throwable th) {
                                try {
                                    inputStreamReader.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (Exception e) {
                            C0530jM.m2338a("Failed to read from classpath: %s", e, path2);
                        }
                    });
                    if (list != null) {
                        list.close();
                    }
                    if (fileSystemNewFileSystem != null) {
                        fileSystemNewFileSystem.close();
                    }
                } catch (Throwable th) {
                    if (list != null) {
                        try {
                            list.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (fileSystemNewFileSystem != null) {
                    fileSystemNewFileSystem.close();
                }
                throw th3;
            }
        } catch (Exception e) {
            C0530jM.m2338a("Failed to scan classpath directory %s", e, str2);
        }
        C0530jM.log("Loaded %d entries from classpath %s", Integer.valueOf(object2ObjectLinkedOpenHashMap.size()), str);
        return object2ObjectLinkedOpenHashMap;
    }
}
