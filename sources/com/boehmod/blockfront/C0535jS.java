package com.boehmod.blockfront;

import com.boehmod.blockfront.C0435hY;
import com.mojang.serialization.Codec;
import java.util.List;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jS.class */
public class C0535jS extends AbstractC0541jY<List<C0435hY.a>> {

    /* JADX INFO: renamed from: aV */
    private static final String f3153aV = "environment_sound_groups";

    /* JADX INFO: renamed from: aW */
    private static final String f3154aW = ".json";

    public C0535jS(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: z */
    protected String mo2406z() {
        return f3153aV;
    }

    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Codec<List<C0435hY.a>> mo2407a() {
        return C0435hY.f2815h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public ResourceLocation mo2412a(@NotNull List<C0435hY.a> list, @NotNull ResourceLocation resourceLocation) {
        return m2423a(resourceLocation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, List<C0435hY.a>> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        m2422c(map);
    }

    /* JADX INFO: renamed from: c */
    private static void m2422c(@NotNull Map<ResourceLocation, List<C0435hY.a>> map) {
        C0435hY.m2043aR();
        for (Map.Entry<ResourceLocation, List<C0435hY.a>> entry : map.entrySet()) {
            new C0435hY(entry.getKey(), entry.getValue());
        }
        C0562jt.log("Created %d environment sound group(s) from data", Integer.valueOf(map.size()));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ResourceLocation m2423a(@NotNull ResourceLocation resourceLocation) {
        String path = resourceLocation.getPath();
        return ResourceLocation.fromNamespaceAndPath(resourceLocation.getNamespace(), path.substring(path.startsWith("environment_sound_groups/") ? "environment_sound_groups/".length() : 0, path.endsWith(".json") ? path.length() - ".json".length() : path.length()));
    }

    /* JADX INFO: renamed from: bo */
    public static void m2424bo() {
        m2422c(m2450a((Class<?>) C0535jS.class, f3153aV, C0435hY.f2815h, (list, str) -> {
            return ResourceLocation.fromNamespaceAndPath("bf", str);
        }));
    }
}
