package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.util.List;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ko */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ko.class */
public class C0611ko extends AbstractC0617ku<List<C0506ip.a>> {

    /* JADX INFO: renamed from: be */
    private static final String f3531be = "environment_sound_groups";

    /* JADX INFO: renamed from: bf */
    private static final String f3532bf = ".json";

    public C0611ko(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: G */
    protected String mo2768G() {
        return f3531be;
    }

    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Codec<List<C0506ip.a>> mo2769a() {
        return C0506ip.f3117h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public ResourceLocation mo2774a(@NotNull List<C0506ip.a> list, @NotNull ResourceLocation resourceLocation) {
        return m2785a(resourceLocation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, List<C0506ip.a>> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        m2784c(map);
    }

    /* JADX INFO: renamed from: c */
    private static void m2784c(@NotNull Map<ResourceLocation, List<C0506ip.a>> map) {
        C0506ip.m2277aZ();
        for (Map.Entry<ResourceLocation, List<C0506ip.a>> entry : map.entrySet()) {
            new C0506ip(entry.getKey(), entry.getValue());
        }
        C0530jM.log("Created %d environment sound group(s) from data", Integer.valueOf(map.size()));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ResourceLocation m2785a(@NotNull ResourceLocation resourceLocation) {
        String path = resourceLocation.getPath();
        return ResourceLocation.fromNamespaceAndPath(resourceLocation.getNamespace(), path.substring(path.startsWith("environment_sound_groups/") ? "environment_sound_groups/".length() : 0, path.endsWith(".json") ? path.length() - ".json".length() : path.length()));
    }

    /* JADX INFO: renamed from: bz */
    public static void m2786bz() {
        m2784c((Map<ResourceLocation, List<C0506ip.a>>) m2809a((Class<?>) C0611ko.class, f3531be, C0506ip.f3117h, (list, str) -> {
            return ResourceLocation.fromNamespaceAndPath("bf", str);
        }));
    }
}
