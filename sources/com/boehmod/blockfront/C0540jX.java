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

/* JADX INFO: renamed from: com.boehmod.blockfront.jX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jX.class */
public class C0540jX extends AbstractC0541jY<C0979rm> {

    /* JADX INFO: renamed from: bb */
    private static final String f3163bb = "game/nation_types";

    /* JADX INFO: renamed from: D */
    @NotNull
    private final Map<ResourceLocation, C0979rm> f3164D;

    public C0540jX(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
        this.f3164D = new Object2ObjectLinkedOpenHashMap();
    }

    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: z */
    protected String mo2406z() {
        return f3163bb;
    }

    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Codec<C0979rm> mo2407a() {
        return C0979rm.f5204V;
    }

    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: a */
    public ResourceLocation mo2412a(@NotNull C0979rm c0979rm, @NotNull ResourceLocation resourceLocation) {
        return C0564jv.m2555d(c0979rm.m5394ae());
    }

    @NotNull
    /* JADX INFO: renamed from: j */
    public Map<ResourceLocation, C0979rm> m2442j() {
        return Collections.unmodifiableMap(this.f3164D);
    }

    /* JADX INFO: renamed from: a */
    public void apply(@NotNull Map<ResourceLocation, C0979rm> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.f3164D.clear();
        this.f3164D.putAll(map);
        m2444d(map);
    }

    /* JADX INFO: renamed from: d */
    private static void m2444d(@NotNull Map<ResourceLocation, C0979rm> map) {
        C1019sZ.m5664aR();
        Iterator<Map.Entry<ResourceLocation, C0979rm>> it = map.entrySet().stream().sorted(Comparator.comparingInt(entry -> {
            return ((C0979rm) entry.getValue()).m5393bz();
        })).toList().iterator();
        while (it.hasNext()) {
            C0979rm value = it.next().getValue();
            new C1019sZ(value.m5394ae(), value.m5395g(), value.m5396af(), value.m5397ag(), value.m5398ah(), value.m5399i().orElse(null), value.m5400j().orElse(null), value.m5401k().orElse(null), value.m5402l().orElse(null), value.m5403l(), value.m5404m());
        }
        C0562jt.log("Created %d nation type(s) from data", Integer.valueOf(map.size()));
    }

    /* JADX INFO: renamed from: bo */
    public static void m2445bo() {
        m2444d(m2450a((Class<?>) C0540jX.class, f3163bb, C0979rm.f5204V, (c0979rm, str) -> {
            return C0564jv.m2555d(c0979rm.m5394ae());
        }));
    }
}
