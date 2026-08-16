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

/* JADX INFO: renamed from: com.boehmod.blockfront.kl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kl.class */
public class C0608kl extends SimplePreparableReloadListener<a> {

    /* JADX INFO: renamed from: aZ */
    @NotNull
    private static final String f3521aZ = "attributes/block_traversable";

    /* JADX INFO: renamed from: ba */
    @NotNull
    private static final String f3522ba = "attributes/block_impact";

    /* JADX INFO: renamed from: bb */
    @NotNull
    private static final String f3523bb = "attributes/block";

    public C0608kl(@NotNull ResourceManager resourceManager) {
        if (resourceManager instanceof ReloadableResourceManager) {
            C0530jM.log("Registering reload listener for block attribute loader", new Object[0]);
            ((ReloadableResourceManager) resourceManager).registerReloadListener(this);
        }
        apply(prepare(resourceManager, (ProfilerFiller) InactiveProfiler.INSTANCE), resourceManager, (ProfilerFiller) InactiveProfiler.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a prepare(@NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        Gson gson = new Gson();
        return new a(m2752a(gson, resourceManager, f3521aZ, C1127uZ.f6180ai), m2752a(gson, resourceManager, f3522ba, C1126uY.f6174ag), m2752a(gson, resourceManager, f3523bb, C1125uX.f6162ae));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull a aVar, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        m2756a(aVar);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static <T> Map<ResourceLocation, T> m2752a(@NotNull Gson gson, @NotNull ResourceManager resourceManager, @NotNull String str, @NotNull Codec<T> codec) {
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        for (Map.Entry entry : resourceManager.listResources(str, resourceLocation -> {
            return resourceLocation.getPath().endsWith(".json");
        }).entrySet()) {
            m2753a(gson, codec, object2ObjectLinkedOpenHashMap, (ResourceLocation) entry.getKey(), (Resource) entry.getValue());
        }
        C0530jM.log("Loaded %d entries from %s", Integer.valueOf(object2ObjectLinkedOpenHashMap.size()), str);
        return object2ObjectLinkedOpenHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private static <T> void m2753a(@NotNull Gson gson, @NotNull Codec<T> codec, @NotNull Map<ResourceLocation, T> map, @NotNull ResourceLocation resourceLocation, @NotNull Resource resource) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(resource.open());
            try {
                map.put(m2757e(resourceLocation.getPath()), codec.parse(JsonOps.INSTANCE, (JsonElement) gson.fromJson(inputStreamReader, JsonElement.class)).getOrThrow(str -> {
                    C0530jM.logError("Failed to parse %s: %s", resourceLocation, str);
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
            C0530jM.m2338a("Failed to read %s", e, resourceLocation);
        }
    }

    /* JADX INFO: renamed from: bz */
    public static void m2754bz() {
        Gson gson = new Gson();
        m2756a(new a(m2755a(gson, f3521aZ, C1127uZ.f6180ai), m2755a(gson, f3522ba, C1126uY.f6174ag), m2755a(gson, f3523bb, C1125uX.f6162ae)));
        C0530jM.log("Bootstrapped block attributes from classpath", new Object[0]);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static <T> Map<ResourceLocation, T> m2755a(@NotNull Gson gson, @NotNull String str, @NotNull Codec<T> codec) {
        Path pathOf;
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        String str2 = "/assets/bf/" + str;
        try {
            URL resource = C0608kl.class.getResource(str2);
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
                                    C0530jM.logError("Failed to parse %s: %s", path2, str3);
                                    return new RuntimeException(str3);
                                });
                                String string = path2.getFileName().toString();
                                object2ObjectLinkedOpenHashMap.put(C0532jO.m2378d(string.substring(0, string.lastIndexOf(46))), orThrow);
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
            C0530jM.m2338a("Failed to read classpath directory %s", e, str2);
        }
        C0530jM.log("Loaded %d entries from classpath %s", Integer.valueOf(object2ObjectLinkedOpenHashMap.size()), str);
        return object2ObjectLinkedOpenHashMap;
    }

    /* JADX INFO: renamed from: a */
    private static void m2756a(@NotNull a aVar) {
        C1127uZ.m6466aZ();
        C1126uY.m6439aZ();
        C1124uW.m6421aZ();
        aVar.f3524x.forEach(C1127uZ::m6467a);
        aVar.f3525y.forEach(C1126uY::m6440a);
        for (Map.Entry<ResourceLocation, C1125uX> entry : aVar.f3526z.entrySet()) {
            ResourceLocation key = entry.getKey();
            C1125uX value = entry.getValue();
            C1124uW c1124uW = new C1124uW((C1127uZ) value.m6431n().map(resourceLocation -> {
                C1127uZ c1127uZM6468a = C1127uZ.m6468a(resourceLocation);
                if (c1127uZM6468a == null) {
                    C0530jM.logError("Block attribute '%s' references unknown traversable '%s'", key, resourceLocation);
                }
                return c1127uZM6468a;
            }).orElse(null), (C1126uY) value.m6432o().map(resourceLocation2 -> {
                C1126uY c1126uYM6441a = C1126uY.m6441a(resourceLocation2);
                if (c1126uYM6441a == null) {
                    C0530jM.logError("Block attribute '%s' references unknown impact '%s'", key, resourceLocation2);
                }
                return c1126uYM6441a;
            }).orElse(null), value.m6435cN(), value.m6436cO());
            C1124uW.m6422a(key, c1124uW);
            for (ResourceLocation resourceLocation3 : value.m6433aJ()) {
                if (!BuiltInRegistries.BLOCK.containsKey(resourceLocation3)) {
                    C0530jM.logError("Block attribute '%s' references unknown block '%s'", key, resourceLocation3);
                } else {
                    c1124uW.m6423c((Block) BuiltInRegistries.BLOCK.get(resourceLocation3));
                }
            }
            for (String str : value.m6434aK()) {
                SoundType soundTypeM6762a = C1187vg.m6762a(str);
                if (soundTypeM6762a == null) {
                    C0530jM.logError("Block attribute '%s' references unknown sound type '%s'", key, str);
                } else {
                    c1124uW.m6424a(soundTypeM6762a);
                }
            }
        }
        C0530jM.log("Applied %d traversable, %d impact, %d block attribute(s)", Integer.valueOf(aVar.f3524x.size()), Integer.valueOf(aVar.f3525y.size()), Integer.valueOf(aVar.f3526z.size()));
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    private static ResourceLocation m2757e(@NotNull String str) {
        String strSubstring = str.substring(str.lastIndexOf(47) + 1);
        return C0532jO.m2378d(strSubstring.substring(0, strSubstring.lastIndexOf(46)));
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.kl$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kl$a.class */
    public static final class a extends Record {

        /* JADX INFO: renamed from: x */
        @NotNull
        private final Map<ResourceLocation, C1127uZ> f3524x;

        /* JADX INFO: renamed from: y */
        @NotNull
        private final Map<ResourceLocation, C1126uY> f3525y;

        /* JADX INFO: renamed from: z */
        @NotNull
        private final Map<ResourceLocation, C1125uX> f3526z;

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "traversable;impact;attributes", "FIELD:Lcom/boehmod/blockfront/kl$a;->x:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/kl$a;->y:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/kl$a;->z:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "traversable;impact;attributes", "FIELD:Lcom/boehmod/blockfront/kl$a;->x:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/kl$a;->y:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/kl$a;->z:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "traversable;impact;attributes", "FIELD:Lcom/boehmod/blockfront/kl$a;->x:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/kl$a;->y:Ljava/util/Map;", "FIELD:Lcom/boehmod/blockfront/kl$a;->z:Ljava/util/Map;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        /* JADX INFO: renamed from: e */
        public Map<ResourceLocation, C1127uZ> m2765e() {
            return this.f3524x;
        }

        @NotNull
        /* JADX INFO: renamed from: f */
        public Map<ResourceLocation, C1126uY> m2766f() {
            return this.f3525y;
        }

        @NotNull
        /* JADX INFO: renamed from: g */
        public Map<ResourceLocation, C1125uX> m2767g() {
            return this.f3526z;
        }

        public a(@NotNull Map<ResourceLocation, C1127uZ> map, @NotNull Map<ResourceLocation, C1126uY> map2, @NotNull Map<ResourceLocation, C1125uX> map3) {
            Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap(map);
            Object2ObjectOpenHashMap object2ObjectOpenHashMap2 = new Object2ObjectOpenHashMap(map2);
            Object2ObjectOpenHashMap object2ObjectOpenHashMap3 = new Object2ObjectOpenHashMap(map3);
            this.f3524x = object2ObjectOpenHashMap;
            this.f3525y = object2ObjectOpenHashMap2;
            this.f3526z = object2ObjectOpenHashMap3;
        }
    }
}
