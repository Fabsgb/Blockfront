package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jX.class */
public class jX extends jY<C0472rm> {
    private static final String bb = "game/nation_types";

    @NotNull
    private final Map<ResourceLocation, C0472rm> D;

    public jX(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
        this.D = new Object2ObjectLinkedOpenHashMap();
    }

    @Override // com.boehmod.blockfront.jY
    @NotNull
    protected String z() {
        return bb;
    }

    @Override // com.boehmod.blockfront.jY
    @NotNull
    protected Codec<C0472rm> a() {
        return C0472rm.V;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.jY
    @NotNull
    public ResourceLocation a(@NotNull C0472rm c0472rm, @NotNull ResourceLocation resourceLocation) {
        return C0265jv.d(c0472rm.ae());
    }

    @NotNull
    public Map<ResourceLocation, C0472rm> j() {
        return Collections.unmodifiableMap(this.D);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, C0472rm> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.D.clear();
        this.D.putAll(map);
        d(map);
    }

    private static void d(@NotNull Map<ResourceLocation, C0472rm> map) {
        sZ.aR();
        Iterator<Map.Entry<ResourceLocation, C0472rm>> it = map.entrySet().stream().sorted(Comparator.comparingInt(entry -> {
            return ((C0472rm) entry.getValue()).bz();
        })).toList().iterator();
        while (it.hasNext()) {
            C0472rm value = it.next().getValue();
            new sZ(value.ae(), value.g(), value.af(), value.ag(), value.ah(), value.i().orElse(null), value.j().orElse(null), value.k().orElse(null), value.l().orElse(null), value.m1072l(), value.m());
        }
        C0263jt.log("Created %d nation type(s) from data", Integer.valueOf(map.size()));
    }

    public static void bo() {
        d(a((Class<?>) jX.class, bb, C0472rm.V, (c0472rm, str) -> {
            return C0265jv.d(c0472rm.ae());
        }));
    }
}
