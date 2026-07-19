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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jZ.class */
public class jZ extends SimplePreparableReloadListener<Map<ResourceLocation, uV>> {

    @NotNull
    private static final String bc = "gun_spread/patterns";

    public jZ(@NotNull ResourceManager resourceManager) {
        if (resourceManager instanceof ReloadableResourceManager) {
            C0263jt.log("Registering reload listener for spread pattern loader", new Object[0]);
            ((ReloadableResourceManager) resourceManager).registerReloadListener(this);
        }
        apply(prepare(resourceManager, (ProfilerFiller) InactiveProfiler.INSTANCE), resourceManager, InactiveProfiler.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<ResourceLocation, uV> prepare(@NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        Gson gson = new Gson();
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        for (Map.Entry entry : resourceManager.listResources(bc, resourceLocation -> {
            return resourceLocation.getPath().endsWith(".json");
        }).entrySet()) {
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(((Resource) entry.getValue()).open());
                try {
                    object2ObjectLinkedOpenHashMap.put(e(((ResourceLocation) entry.getKey()).getPath()), (uV) uV.am.parse(JsonOps.INSTANCE, (JsonElement) gson.fromJson(inputStreamReader, JsonElement.class)).getOrThrow(str -> {
                        C0263jt.logError("Failed to parse %s: %s", entry.getKey(), str);
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
                C0263jt.a("Failed to read %s", e, entry.getKey());
            }
        }
        C0263jt.log("Loaded %d spread pattern(s)", Integer.valueOf(object2ObjectLinkedOpenHashMap.size()));
        return object2ObjectLinkedOpenHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, uV> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        uV.aR();
        map.forEach(uV::a);
    }

    /* JADX WARN: Finally extract failed */
    public static void bo() {
        Path pathOf;
        Gson gson = new Gson();
        try {
            URL resource = jZ.class.getResource("/assets/bf/gun_spread/patterns");
            if (resource == null) {
                C0263jt.log("No spread patterns directory on classpath (%s) — skipping bootstrap.", "/assets/bf/gun_spread/patterns");
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
                                uV uVVar = (uV) uV.am.parse(JsonOps.INSTANCE, (JsonElement) gson.fromJson(inputStreamReader, JsonElement.class)).getOrThrow(str -> {
                                    C0263jt.logError("Failed to parse %s: %s", path2, str);
                                    return new RuntimeException(str);
                                });
                                String string = path2.getFileName().toString();
                                uV.a(C0265jv.d(string.substring(0, string.lastIndexOf(46))), uVVar);
                                inputStreamReader.close();
                            } finally {
                            }
                        } catch (Exception e) {
                            C0263jt.a("Failed to read %s", e, path2);
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
            C0263jt.a("Failed to read classpath directory %s", e, "/assets/bf/gun_spread/patterns");
        }
        C0263jt.log("Bootstrapped %d spread pattern(s) from classpath", Integer.valueOf(uV.aq.size()));
    }

    @NotNull
    private static ResourceLocation e(@NotNull String str) {
        String strSubstring = str.substring(str.lastIndexOf(47) + 1);
        return C0265jv.d(strSubstring.substring(0, strSubstring.lastIndexOf(46)));
    }
}
