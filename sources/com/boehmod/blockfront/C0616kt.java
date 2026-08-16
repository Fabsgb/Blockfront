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

/* JADX INFO: renamed from: com.boehmod.blockfront.kt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kt.class */
public class C0616kt extends AbstractC0617ku<C0951rJ> {

    /* JADX INFO: renamed from: bk */
    private static final String f3541bk = "game/nation_types";

    /* JADX INFO: renamed from: D */
    @NotNull
    private final Map<ResourceLocation, C0951rJ> f3542D;

    public C0616kt(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
        this.f3542D = new Object2ObjectLinkedOpenHashMap();
    }

    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: G */
    protected String mo2768G() {
        return f3541bk;
    }

    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Codec<C0951rJ> mo2769a() {
        return C0951rJ.f5308V;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public ResourceLocation mo2774a(@NotNull C0951rJ c0951rJ, @NotNull ResourceLocation resourceLocation) {
        return C0532jO.m2378d(c0951rJ.m5270al());
    }

    @NotNull
    /* JADX INFO: renamed from: j */
    public Map<ResourceLocation, C0951rJ> m2801j() {
        return Collections.unmodifiableMap(this.f3542D);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, C0951rJ> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.f3542D.clear();
        this.f3542D.putAll(map);
        m2803d(map);
    }

    /* JADX INFO: renamed from: d */
    private static void m2803d(@NotNull Map<ResourceLocation, C0951rJ> map) {
        C1097tw.m6152aZ();
        Iterator<Map.Entry<ResourceLocation, C0951rJ>> it = map.entrySet().stream().sorted(Comparator.comparingInt(entry -> {
            return ((C0951rJ) entry.getValue()).m5269bO();
        })).toList().iterator();
        while (it.hasNext()) {
            C0951rJ value = it.next().getValue();
            new C1097tw(value.m5270al(), value.m5271k(), value.m5272ah(), value.m5273ai(), value.m5274aj(), value.m5275i().orElse(null), value.m5276j().orElse(null), value.m5277k().orElse(null), value.m5278l().orElse(null), value.m5279l(), value.m5280m());
        }
        C0530jM.log("Created %d nation type(s) from data", Integer.valueOf(map.size()));
    }

    /* JADX INFO: renamed from: bz */
    public static void m2804bz() {
        m2803d(m2809a((Class<?>) C0616kt.class, f3541bk, C0951rJ.f5308V, (c0951rJ, str) -> {
            return C0532jO.m2378d(c0951rJ.m5270al());
        }));
    }
}
