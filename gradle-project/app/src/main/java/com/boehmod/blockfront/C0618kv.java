package com.boehmod.blockfront;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
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
import java.util.stream.Stream;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.InactiveProfiler;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kv.class */
public class C0618kv extends SimplePreparableReloadListener<Map<ResourceLocation, C1202vv>> {

    /* JADX INFO: renamed from: bl */
    @NotNull
    private static final String f3543bl = "gun_spread/patterns";

    public C0618kv(@NotNull ResourceManager resourceManager) {
        if (resourceManager instanceof ReloadableResourceManager) {
            C0530jM.log("Registering reload listener for spread pattern loader", new Object[0]);
            ((ReloadableResourceManager) resourceManager).registerReloadListener(this);
        }
        apply(prepare(resourceManager, (ProfilerFiller) InactiveProfiler.INSTANCE), resourceManager, InactiveProfiler.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<ResourceLocation, C1202vv> prepare(@NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        Gson gson = new Gson();
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        for (Map.Entry entry : resourceManager.listResources(f3543bl, resourceLocation -> {
            return resourceLocation.getPath().endsWith(".json");
        }).entrySet()) {
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(((Resource) entry.getValue()).open());
                try {
                    object2ObjectLinkedOpenHashMap.put(m2818e(((ResourceLocation) entry.getKey()).getPath()), (C1202vv) C1202vv.f6562am.parse(JsonOps.INSTANCE, (JsonElement) gson.fromJson(inputStreamReader, JsonElement.class)).getOrThrow(str -> {
                        C0530jM.logError("Failed to parse %s: %s", entry.getKey(), str);
                        return new RuntimeException(str);
                    }));
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
                C0530jM.m2338a("Failed to read %s", e, entry.getKey());
            }
        }
        C0530jM.log("Loaded %d spread pattern(s)", Integer.valueOf(object2ObjectLinkedOpenHashMap.size()));
        return object2ObjectLinkedOpenHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, C1202vv> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        C1202vv.m6885aZ();
        map.forEach(C1202vv::m6884a);
    }

    /* JADX INFO: renamed from: bz */
    public static void m2817bz() {
        Path pathOf;
        Gson gson = new Gson();
        try {
            URL resource = C0618kv.class.getResource("/assets/bf/gun_spread/patterns");
            if (resource == null) {
                C0530jM.log("No spread patterns directory on classpath (%s) — skipping bootstrap.", "/assets/bf/gun_spread/patterns");
                return;
            }
            URI uri = resource.toURI();
            FileSystem fileSystemNewFileSystem = null;
            if (uri.getScheme().equals("jar")) {
                fileSystemNewFileSystem = FileSystems.newFileSystem(uri, (Map<String, ?>) Map.of());
                pathOf = fileSystemNewFileSystem.getPath("/assets/bf/gun_spread/patterns", new String[0]);
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
                                C1202vv c1202vv = (C1202vv) C1202vv.f6562am.parse(JsonOps.INSTANCE, (JsonElement) gson.fromJson(inputStreamReader, JsonElement.class)).getOrThrow(str -> {
                                    C0530jM.logError("Failed to parse %s: %s", path2, str);
                                    return new RuntimeException(str);
                                });
                                String string = path2.getFileName().toString();
                                C1202vv.m6884a(C0532jO.m2378d(string.substring(0, string.lastIndexOf(46))), c1202vv);
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
                            C0530jM.m2338a("Failed to read %s", e, path2);
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
            C0530jM.m2338a("Failed to read classpath directory %s", e, "/assets/bf/gun_spread/patterns");
        }
        C0530jM.log("Bootstrapped %d spread pattern(s) from classpath", Integer.valueOf(C1202vv.f6563aq.size()));
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    private static ResourceLocation m2818e(@NotNull String str) {
        String strSubstring = str.substring(str.lastIndexOf(47) + 1);
        return C0532jO.m2378d(strSubstring.substring(0, strSubstring.lastIndexOf(46)));
    }
}
