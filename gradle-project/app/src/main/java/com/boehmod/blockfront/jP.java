package com.boehmod.blockfront;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Stream;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.InactiveProfiler;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jP.class */
public class jP extends SimplePreparableReloadListener<a> {

    @NotNull
    private static final String aQ = "attributes/block_traversable";

    @NotNull
    private static final String aR = "attributes/block_impact";

    @NotNull
    private static final String aS = "attributes/block";

    public jP(@NotNull ResourceManager resourceManager) {
        if (resourceManager instanceof ReloadableResourceManager) {
            C0263jt.log("Registering reload listener for block attribute loader", new Object[0]);
            ((ReloadableResourceManager) resourceManager).registerReloadListener(this);
        }
        apply(prepare(resourceManager, (ProfilerFiller) InactiveProfiler.INSTANCE), resourceManager, (ProfilerFiller) InactiveProfiler.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a prepare(@NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        Gson gson = new Gson();
        return new a(a(gson, resourceManager, aQ, C0566uz.ai), a(gson, resourceManager, aR, C0565uy.ag), a(gson, resourceManager, aS, C0564ux.ae));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull a aVar, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        a(aVar);
    }

    @NotNull
    private static <T> Map<ResourceLocation, T> a(@NotNull Gson gson, @NotNull ResourceManager resourceManager, @NotNull String str, @NotNull Codec<T> codec) {
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        for (Map.Entry entry : resourceManager.listResources(str, resourceLocation -> {
            return resourceLocation.getPath().endsWith(".json");
        }).entrySet()) {
            a(gson, codec, object2ObjectLinkedOpenHashMap, (ResourceLocation) entry.getKey(), (Resource) entry.getValue());
        }
        C0263jt.log("Loaded %d entries from %s", Integer.valueOf(object2ObjectLinkedOpenHashMap.size()), str);
        return object2ObjectLinkedOpenHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(@NotNull Gson gson, @NotNull Codec<T> codec, @NotNull Map<ResourceLocation, T> map, @NotNull ResourceLocation resourceLocation, @NotNull Resource resource) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(resource.open());
            try {
                map.put(e(resourceLocation.getPath()), codec.parse(JsonOps.INSTANCE, (JsonElement) gson.fromJson(inputStreamReader, JsonElement.class)).getOrThrow(str -> {
                    C0263jt.logError("Failed to parse %s: %s", resourceLocation, str);
                    return new RuntimeException(str);
                }));
                inputStreamReader.close();
            } finally {
            }
        } catch (IOException e) {
            C0263jt.a("Failed to read %s", e, resourceLocation);
        }
    }

    public static void bo() {
        Gson gson = new Gson();
        a(new a(a(gson, aQ, C0566uz.ai), a(gson, aR, C0565uy.ag), a(gson, aS, C0564ux.ae)));
        C0263jt.log("Bootstrapped block attributes from classpath", new Object[0]);
    }

    /* JADX WARN: Finally extract failed */
    @NotNull
    private static <T> Map<ResourceLocation, T> a(@NotNull Gson gson, @NotNull String str, @NotNull Codec<T> codec) {
        Path pathOf;
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        String str2 = "/assets/bf/" + str;
        try {
            URL resource = jP.class.getResource(str2);
            if (resource == null) {
                C0263jt.logError("Directory not found on classpath: %s", str2);
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
                                    C0263jt.logError("Failed to parse %s: %s", path2, str3);
                                    return new RuntimeException(str3);
                                });
                                String string = path2.getFileName().toString();
                                object2ObjectLinkedOpenHashMap.put(C0265jv.d(string.substring(0, string.lastIndexOf(46))), orThrow);
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
            C0263jt.a("Failed to read classpath directory %s", e, str2);
        }
        C0263jt.log("Loaded %d entries from classpath %s", Integer.valueOf(object2ObjectLinkedOpenHashMap.size()), str);
        return object2ObjectLinkedOpenHashMap;
    }

    private static void a(@NotNull a aVar) {
        C0566uz.aR();
        C0565uy.aR();
        C0563uw.aR();
        aVar.x.forEach(C0566uz::a);
        aVar.y.forEach(C0565uy::a);
        for (Map.Entry<ResourceLocation, C0564ux> entry : aVar.z.entrySet()) {
            ResourceLocation key = entry.getKey();
            C0564ux value = entry.getValue();
            C0563uw c0563uw = new C0563uw((C0566uz) value.n().map(resourceLocation -> {
                C0566uz c0566uzA = C0566uz.a(resourceLocation);
                if (c0566uzA == null) {
                    C0263jt.logError("Block attribute '%s' references unknown traversable '%s'", key, resourceLocation);
                }
                return c0566uzA;
            }).orElse(null), (C0565uy) value.o().map(resourceLocation2 -> {
                C0565uy c0565uyA = C0565uy.a(resourceLocation2);
                if (c0565uyA == null) {
                    C0263jt.logError("Block attribute '%s' references unknown impact '%s'", key, resourceLocation2);
                }
                return c0565uyA;
            }).orElse(null), value.cE(), value.cF());
            C0563uw.a(key, c0563uw);
            for (ResourceLocation resourceLocation3 : value.aF()) {
                if (!BuiltInRegistries.BLOCK.containsKey(resourceLocation3)) {
                    C0263jt.logError("Block attribute '%s' references unknown block '%s'", key, resourceLocation3);
                } else {
                    c0563uw.c((Block) BuiltInRegistries.BLOCK.get(resourceLocation3));
                }
            }
            for (String str : value.aG()) {
                SoundType soundTypeA = uG.a(str);
                if (soundTypeA == null) {
                    C0263jt.logError("Block attribute '%s' references unknown sound type '%s'", key, str);
                } else {
                    c0563uw.a(soundTypeA);
                }
            }
        }
        C0263jt.log("Applied %d traversable, %d impact, %d block attribute(s)", Integer.valueOf(aVar.x.size()), Integer.valueOf(aVar.y.size()), Integer.valueOf(aVar.z.size()));
    }

    @NotNull
    private static ResourceLocation e(@NotNull String str) {
        String strSubstring = str.substring(str.lastIndexOf(47) + 1);
        return C0265jv.d(strSubstring.substring(0, strSubstring.lastIndexOf(46)));
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jP$a.class */
    public static final class a extends Record {

        @NotNull
        private final Map<ResourceLocation, C0566uz> x;

        @NotNull
        private final Map<ResourceLocation, C0565uy> y;

        @NotNull
        private final Map<ResourceLocation, C0564ux> z;

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "traversable;impact;attributes", "FIELD:Lcom/boehmod/blockfront/jP$a;->x:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/jP$a;->y:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/jP$a;->z:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "traversable;impact;attributes", "FIELD:Lcom/boehmod/blockfront/jP$a;->x:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/jP$a;->y:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/jP$a;->z:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "traversable;impact;attributes", "FIELD:Lcom/boehmod/blockfront/jP$a;->x:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/jP$a;->y:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/jP$a;->z:Ljava/util/Map;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        public Map<ResourceLocation, C0566uz> e() {
            return this.x;
        }

        @NotNull
        public Map<ResourceLocation, C0565uy> f() {
            return this.y;
        }

        @NotNull
        public Map<ResourceLocation, C0564ux> g() {
            return this.z;
        }

        public a(@NotNull Map<ResourceLocation, C0566uz> map, @NotNull Map<ResourceLocation, C0565uy> map2, @NotNull Map<ResourceLocation, C0564ux> map3) {
            Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap(map);
            Object2ObjectOpenHashMap object2ObjectOpenHashMap2 = new Object2ObjectOpenHashMap(map2);
            Object2ObjectOpenHashMap object2ObjectOpenHashMap3 = new Object2ObjectOpenHashMap(map3);
            this.x = object2ObjectOpenHashMap;
            this.y = object2ObjectOpenHashMap2;
            this.z = object2ObjectOpenHashMap3;
        }
    }
}
