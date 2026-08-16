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

/* JADX INFO: renamed from: com.boehmod.blockfront.ks */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ks.class */
public abstract class AbstractC0615ks<A> extends SimplePreparableReloadListener<Map<ResourceLocation, A>> {

    /* JADX INFO: renamed from: bi */
    @NotNull
    private final String f3535bi;

    /* JADX INFO: renamed from: bj */
    @NotNull
    private final String f3536bj;

    /* JADX INFO: renamed from: C */
    @NotNull
    private final Map<ResourceLocation, A> f3537C;

    /* JADX INFO: renamed from: k */
    @NotNull
    private final Codec<A> f3538k;

    /* JADX INFO: renamed from: d */
    private final A f3539d;

    /* JADX INFO: renamed from: f */
    @NotNull
    Function<A, String> f3540f;

    public AbstractC0615ks(@NotNull ResourceManager resourceManager, @NotNull String str, @NotNull String str2, @NotNull Codec<A> codec, @NotNull A a, @NotNull Function<A, String> function) {
        if (resourceManager instanceof ReloadableResourceManager) {
            C0530jM.log("Registering reload listener for asset loader '" + str + "'", new Object[0]);
            ((ReloadableResourceManager) resourceManager).registerReloadListener(this);
        }
        this.f3535bi = str;
        this.f3536bj = str2;
        this.f3538k = codec;
        this.f3539d = a;
        this.f3540f = function;
        this.f3537C = prepare(resourceManager, (ProfilerFiller) InactiveProfiler.INSTANCE);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public A m2794a(@NotNull String str) {
        return this.f3537C.getOrDefault(C0532jO.m2378d(str), this.f3539d);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Collection<A> m2795b() {
        return Collections.unmodifiableCollection(this.f3537C.values());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<ResourceLocation, A> prepare(@NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        Gson gson = new Gson();
        List resourceStack = resourceManager.getResourceStack(C0532jO.m2378d(this.f3536bj));
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        Iterator it = resourceStack.iterator();
        while (it.hasNext()) {
            m2797a(gson, (Map) object2ObjectLinkedOpenHashMap, (Resource) it.next());
        }
        C0530jM.log("Successfully loaded %s asset(s) for %s", Integer.valueOf(object2ObjectLinkedOpenHashMap.size()), this.f3535bi);
        return object2ObjectLinkedOpenHashMap;
    }

    /* JADX INFO: renamed from: a */
    private void m2797a(@NotNull Gson gson, @NotNull Map<ResourceLocation, A> map, @NotNull Resource resource) {
        try {
            ((List) Codec.list(this.f3538k).parse(JsonOps.INSTANCE, (JsonElement) gson.fromJson(new InputStreamReader(resource.open()), JsonElement.class)).getOrThrow(str -> {
                C0530jM.logError("Failed to parse (%s)", resource.toString(), str);
                return new RuntimeException(str);
            })).forEach(obj -> {
                String strApply = this.f3540f.apply(obj);
                if (!ResourceLocation.isValidNamespace(strApply)) {
                    C0530jM.logError("Ignoring asset '%s' for %s (%s)", resource.toString(), this.f3535bi, "Non [a-z0-9_.-] character in namespace of location");
                } else {
                    map.put(C0532jO.m2378d(strApply), obj);
                }
            });
        } catch (IOException e) {
            C0530jM.log("Failed to read asset '%s' (%s)", resource.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, A> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.f3537C.clear();
        this.f3537C.putAll(map);
    }
}
