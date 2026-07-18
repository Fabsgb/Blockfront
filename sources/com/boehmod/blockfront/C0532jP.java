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

/* JADX INFO: renamed from: com.boehmod.blockfront.jP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jP.class */
public class C0532jP extends SimplePreparableReloadListener<a> {

    /* JADX INFO: renamed from: aQ */
    @NotNull
    private static final String f3143aQ = "attributes/block_traversable";

    /* JADX INFO: renamed from: aR */
    @NotNull
    private static final String f3144aR = "attributes/block_impact";

    /* JADX INFO: renamed from: aS */
    @NotNull
    private static final String f3145aS = "attributes/block";

    public C0532jP(@NotNull ResourceManager resourceManager) {
        if (resourceManager instanceof ReloadableResourceManager) {
            C0562jt.log("Registering reload listener for block attribute loader", new Object[0]);
            ((ReloadableResourceManager) resourceManager).registerReloadListener(this);
        }
        apply(prepare(resourceManager, (ProfilerFiller) InactiveProfiler.INSTANCE), resourceManager, (ProfilerFiller) InactiveProfiler.INSTANCE);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public a prepare(@NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        Gson gson = new Gson();
        return new a(m2390a(gson, resourceManager, f3143aQ, C1152uz.f6110ai), m2390a(gson, resourceManager, f3144aR, C1151uy.f6104ag), m2390a(gson, resourceManager, f3145aS, C1150ux.f6093ae));
    }

    /* JADX INFO: renamed from: a */
    public void apply(@NotNull a aVar, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        m2394a(aVar);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static <T> Map<ResourceLocation, T> m2390a(@NotNull Gson gson, @NotNull ResourceManager resourceManager, @NotNull String str, @NotNull Codec<T> codec) {
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        for (Map.Entry entry : resourceManager.listResources(str, resourceLocation -> {
            return resourceLocation.getPath().endsWith(".json");
        }).entrySet()) {
            m2391a(gson, codec, object2ObjectLinkedOpenHashMap, (ResourceLocation) entry.getKey(), (Resource) entry.getValue());
        }
        C0562jt.log("Loaded %d entries from %s", Integer.valueOf(object2ObjectLinkedOpenHashMap.size()), str);
        return object2ObjectLinkedOpenHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private static <T> void m2391a(@NotNull Gson gson, @NotNull Codec<T> codec, @NotNull Map<ResourceLocation, T> map, @NotNull ResourceLocation resourceLocation, @NotNull Resource resource) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(resource.open());
            try {
                map.put(m2395e(resourceLocation.getPath()), codec.parse(JsonOps.INSTANCE, (JsonElement) gson.fromJson(inputStreamReader, JsonElement.class)).getOrThrow(str -> {
                    C0562jt.logError("Failed to parse %s: %s", resourceLocation, str);
                    return new RuntimeException(str);
                }));
                inputStreamReader.close();
            } finally {
            }
        } catch (IOException e) {
            C0562jt.m2516a("Failed to read %s", e, resourceLocation);
        }
    }

    /* JADX INFO: renamed from: bo */
    public static void m2392bo() {
        Gson gson = new Gson();
        m2394a(new a(m2393a(gson, f3143aQ, C1152uz.f6110ai), m2393a(gson, f3144aR, C1151uy.f6104ag), m2393a(gson, f3145aS, C1150ux.f6093ae)));
        C0562jt.log("Bootstrapped block attributes from classpath", new Object[0]);
    }

    /* JADX WARN: Finally extract failed */
    @NotNull
    /* JADX INFO: renamed from: a */
    private static <T> Map<ResourceLocation, T> m2393a(@NotNull Gson gson, @NotNull String str, @NotNull Codec<T> codec) {
        Path pathOf;
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        String str2 = "/assets/bf/" + str;
        try {
            URL resource = C0532jP.class.getResource(str2);
            if (resource == null) {
                C0562jt.logError("Directory not found on classpath: %s", str2);
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
                                    C0562jt.logError("Failed to parse %s: %s", path2, str3);
                                    return new RuntimeException(str3);
                                });
                                String string = path2.getFileName().toString();
                                object2ObjectLinkedOpenHashMap.put(C0564jv.m2555d(string.substring(0, string.lastIndexOf(46))), orThrow);
                                inputStreamReader.close();
                            } finally {
                            }
                        } catch (Exception e) {
                            C0562jt.m2516a("Failed to read %s", e, path2);
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
            C0562jt.m2516a("Failed to read classpath directory %s", e, str2);
        }
        C0562jt.log("Loaded %d entries from classpath %s", Integer.valueOf(object2ObjectLinkedOpenHashMap.size()), str);
        return object2ObjectLinkedOpenHashMap;
    }

    /* JADX INFO: renamed from: a */
    private static void m2394a(@NotNull a aVar) {
        C1152uz.m6477aR();
        C1151uy.m6453aR();
        C1149uw.m6435aR();
        aVar.f3146x.forEach(C1152uz::m6478a);
        aVar.f3147y.forEach(C1151uy::m6454a);
        for (Map.Entry<ResourceLocation, C1150ux> entry : aVar.f3148z.entrySet()) {
            ResourceLocation key = entry.getKey();
            C1150ux value = entry.getValue();
            C1149uw c1149uw = new C1149uw((C1152uz) value.m6445n().map(resourceLocation -> {
                C1152uz c1152uzM6479a = C1152uz.m6479a(resourceLocation);
                if (c1152uzM6479a == null) {
                    C0562jt.logError("Block attribute '%s' references unknown traversable '%s'", key, resourceLocation);
                }
                return c1152uzM6479a;
            }).orElse(null), (C1151uy) value.m6446o().map(resourceLocation2 -> {
                C1151uy c1151uyM6455a = C1151uy.m6455a(resourceLocation2);
                if (c1151uyM6455a == null) {
                    C0562jt.logError("Block attribute '%s' references unknown impact '%s'", key, resourceLocation2);
                }
                return c1151uyM6455a;
            }).orElse(null), value.m6449cE(), value.m6450cF());
            C1149uw.m6436a(key, c1149uw);
            for (ResourceLocation resourceLocation3 : value.m6447aF()) {
                if (!BuiltInRegistries.BLOCK.containsKey(resourceLocation3)) {
                    C0562jt.logError("Block attribute '%s' references unknown block '%s'", key, resourceLocation3);
                } else {
                    c1149uw.m6437c((Block) BuiltInRegistries.BLOCK.get(resourceLocation3));
                }
            }
            for (String str : value.m6448aG()) {
                SoundType soundTypeM6109a = C1107uG.m6109a(str);
                if (soundTypeM6109a == null) {
                    C0562jt.logError("Block attribute '%s' references unknown sound type '%s'", key, str);
                } else {
                    c1149uw.m6438a(soundTypeM6109a);
                }
            }
        }
        C0562jt.log("Applied %d traversable, %d impact, %d block attribute(s)", Integer.valueOf(aVar.f3146x.size()), Integer.valueOf(aVar.f3147y.size()), Integer.valueOf(aVar.f3148z.size()));
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    private static ResourceLocation m2395e(@NotNull String str) {
        String strSubstring = str.substring(str.lastIndexOf(47) + 1);
        return C0564jv.m2555d(strSubstring.substring(0, strSubstring.lastIndexOf(46)));
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.jP$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jP$a.class */
    public static final class a extends Record {

        /* JADX INFO: renamed from: x */
        @NotNull
        private final Map<ResourceLocation, C1152uz> f3146x;

        /* JADX INFO: renamed from: y */
        @NotNull
        private final Map<ResourceLocation, C1151uy> f3147y;

        /* JADX INFO: renamed from: z */
        @NotNull
        private final Map<ResourceLocation, C1150ux> f3148z;

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
        /* JADX INFO: renamed from: e */
        public Map<ResourceLocation, C1152uz> m2403e() {
            return this.f3146x;
        }

        @NotNull
        /* JADX INFO: renamed from: f */
        public Map<ResourceLocation, C1151uy> m2404f() {
            return this.f3147y;
        }

        @NotNull
        /* JADX INFO: renamed from: g */
        public Map<ResourceLocation, C1150ux> m2405g() {
            return this.f3148z;
        }

        public a(@NotNull Map<ResourceLocation, C1152uz> map, @NotNull Map<ResourceLocation, C1151uy> map2, @NotNull Map<ResourceLocation, C1150ux> map3) {
            Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap(map);
            Object2ObjectOpenHashMap object2ObjectOpenHashMap2 = new Object2ObjectOpenHashMap(map2);
            Object2ObjectOpenHashMap object2ObjectOpenHashMap3 = new Object2ObjectOpenHashMap(map3);
            this.f3146x = object2ObjectOpenHashMap;
            this.f3147y = object2ObjectOpenHashMap2;
            this.f3148z = object2ObjectOpenHashMap3;
        }
    }
}
