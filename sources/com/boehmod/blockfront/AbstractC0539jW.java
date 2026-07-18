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

/* JADX INFO: renamed from: com.boehmod.blockfront.jW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jW.class */
public abstract class AbstractC0539jW<A> extends SimplePreparableReloadListener<Map<ResourceLocation, A>> {

    /* JADX INFO: renamed from: aZ */
    @NotNull
    private final String f3157aZ;

    /* JADX INFO: renamed from: ba */
    @NotNull
    private final String f3158ba;

    /* JADX INFO: renamed from: C */
    @NotNull
    private final Map<ResourceLocation, A> f3159C;

    /* JADX INFO: renamed from: k */
    @NotNull
    private final Codec<A> f3160k;

    /* JADX INFO: renamed from: c */
    private final A f3161c;

    /* JADX INFO: renamed from: f */
    @NotNull
    Function<A, String> f3162f;

    public AbstractC0539jW(@NotNull ResourceManager resourceManager, @NotNull String str, @NotNull String str2, @NotNull Codec<A> codec, @NotNull A a, @NotNull Function<A, String> function) {
        if (resourceManager instanceof ReloadableResourceManager) {
            C0562jt.log("Registering reload listener for asset loader '" + str + "'", new Object[0]);
            ((ReloadableResourceManager) resourceManager).registerReloadListener(this);
        }
        this.f3157aZ = str;
        this.f3158ba = str2;
        this.f3160k = codec;
        this.f3161c = a;
        this.f3162f = function;
        this.f3159C = prepare(resourceManager, (ProfilerFiller) InactiveProfiler.INSTANCE);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public A m2435a(@NotNull String str) {
        return this.f3159C.getOrDefault(C0564jv.m2555d(str), this.f3161c);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Collection<A> m2436b() {
        return Collections.unmodifiableCollection(this.f3159C.values());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<ResourceLocation, A> prepare(@NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        Gson gson = new Gson();
        List resourceStack = resourceManager.getResourceStack(C0564jv.m2555d(this.f3158ba));
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        Iterator it = resourceStack.iterator();
        while (it.hasNext()) {
            m2438a(gson, (Map) object2ObjectLinkedOpenHashMap, (Resource) it.next());
        }
        C0562jt.log("Successfully loaded %s asset(s) for %s", Integer.valueOf(object2ObjectLinkedOpenHashMap.size()), this.f3157aZ);
        return object2ObjectLinkedOpenHashMap;
    }

    /* JADX INFO: renamed from: a */
    private void m2438a(@NotNull Gson gson, @NotNull Map<ResourceLocation, A> map, @NotNull Resource resource) {
        try {
            ((List) Codec.list(this.f3160k).parse(JsonOps.INSTANCE, (JsonElement) gson.fromJson(new InputStreamReader(resource.open()), JsonElement.class)).getOrThrow(str -> {
                C0562jt.logError("Failed to parse (%s)", resource.toString(), str);
                return new RuntimeException(str);
            })).forEach(obj -> {
                String strApply = this.f3162f.apply(obj);
                if (!ResourceLocation.isValidNamespace(strApply)) {
                    C0562jt.logError("Ignoring asset '%s' for %s (%s)", resource.toString(), this.f3157aZ, "Non [a-z0-9_.-] character in namespace of location");
                } else {
                    map.put(C0564jv.m2555d(strApply), obj);
                }
            });
        } catch (IOException e) {
            C0562jt.log("Failed to read asset '%s' (%s)", resource.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, A> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.f3159C.clear();
        this.f3159C.putAll(map);
    }
}
