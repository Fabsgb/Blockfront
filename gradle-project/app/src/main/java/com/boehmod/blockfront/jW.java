package com.boehmod.blockfront;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.InactiveProfiler;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jW.class */
public abstract class jW<A> extends SimplePreparableReloadListener<Map<ResourceLocation, A>> {

    @NotNull
    private final String aZ;

    @NotNull
    private final String ba;

    @NotNull
    private final Map<ResourceLocation, A> C;

    @NotNull
    private final Codec<A> k;
    private final A c;

    @NotNull
    Function<A, String> f;

    public jW(@NotNull ResourceManager resourceManager, @NotNull String str, @NotNull String str2, @NotNull Codec<A> codec, @NotNull A a, @NotNull Function<A, String> function) {
        if (resourceManager instanceof ReloadableResourceManager) {
            C0263jt.log("Registering reload listener for asset loader '" + str + "'", new Object[0]);
            ((ReloadableResourceManager) resourceManager).registerReloadListener(this);
        }
        this.aZ = str;
        this.ba = str2;
        this.k = codec;
        this.c = a;
        this.f = function;
        this.C = prepare(resourceManager, (ProfilerFiller) InactiveProfiler.INSTANCE);
    }

    @NotNull
    public A a(@NotNull String str) {
        return this.C.getOrDefault(C0265jv.d(str), this.c);
    }

    @NotNull
    public Collection<A> b() {
        return Collections.unmodifiableCollection(this.C.values());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<ResourceLocation, A> prepare(@NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        Gson gson = new Gson();
        List resourceStack = resourceManager.getResourceStack(C0265jv.d(this.ba));
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        Iterator it = resourceStack.iterator();
        while (it.hasNext()) {
            a(gson, (Map) object2ObjectLinkedOpenHashMap, (Resource) it.next());
        }
        C0263jt.log("Successfully loaded %s asset(s) for %s", Integer.valueOf(object2ObjectLinkedOpenHashMap.size()), this.aZ);
        return object2ObjectLinkedOpenHashMap;
    }

    private void a(@NotNull Gson gson, @NotNull Map<ResourceLocation, A> map, @NotNull Resource resource) {
        try {
            ((List) Codec.list(this.k).parse(JsonOps.INSTANCE, (JsonElement) gson.fromJson(new InputStreamReader(resource.open()), JsonElement.class)).getOrThrow(str -> {
                C0263jt.logError("Failed to parse (%s)", resource.toString(), str);
                return new RuntimeException(str);
            })).forEach(obj -> {
                String strApply = this.f.apply(obj);
                if (!ResourceLocation.isValidNamespace(strApply)) {
                    C0263jt.logError("Ignoring asset '%s' for %s (%s)", resource.toString(), this.aZ, "Non [a-z0-9_.-] character in namespace of location");
                } else {
                    map.put(C0265jv.d(strApply), obj);
                }
            });
        } catch (IOException e) {
            C0263jt.log("Failed to read asset '%s' (%s)", resource.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, A> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.C.clear();
        this.C.putAll(map);
    }
}
