package com.boehmod.blockfront;

import com.boehmod.blockfront.hY;
import com.mojang.serialization.Codec;
import java.util.List;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jS.class */
public class jS extends jY<List<hY.a>> {
    private static final String aV = "environment_sound_groups";
    private static final String aW = ".json";

    public jS(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override // com.boehmod.blockfront.jY
    @NotNull
    protected String z() {
        return aV;
    }

    @Override // com.boehmod.blockfront.jY
    @NotNull
    protected Codec<List<hY.a>> a() {
        return hY.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.jY
    @NotNull
    public ResourceLocation a(@NotNull List<hY.a> list, @NotNull ResourceLocation resourceLocation) {
        return a(resourceLocation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, List<hY.a>> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        c(map);
    }

    private static void c(@NotNull Map<ResourceLocation, List<hY.a>> map) {
        hY.aR();
        for (Map.Entry<ResourceLocation, List<hY.a>> entry : map.entrySet()) {
            new hY(entry.getKey(), entry.getValue());
        }
        C0263jt.log("Created %d environment sound group(s) from data", Integer.valueOf(map.size()));
    }

    @NotNull
    private static ResourceLocation a(@NotNull ResourceLocation resourceLocation) {
        String path = resourceLocation.getPath();
        return ResourceLocation.fromNamespaceAndPath(resourceLocation.getNamespace(), path.substring(path.startsWith("environment_sound_groups/") ? "environment_sound_groups/".length() : 0, path.endsWith(".json") ? path.length() - ".json".length() : path.length()));
    }

    public static void bo() {
        c(a((Class<?>) jS.class, aV, hY.h, (list, str) -> {
            return ResourceLocation.fromNamespaceAndPath("bf", str);
        }));
    }
}
