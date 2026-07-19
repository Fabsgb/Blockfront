package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jV.class */
public class jV extends jY<tD> {
    private static final String aY = "gun_spread/configs";

    public jV(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override // com.boehmod.blockfront.jY
    @NotNull
    protected String z() {
        return aY;
    }

    @Override // com.boehmod.blockfront.jY
    @NotNull
    protected Codec<tD> a() {
        return tD.ad;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.jY
    @NotNull
    public ResourceLocation a(@NotNull tD tDVar, @NotNull ResourceLocation resourceLocation) {
        String path = resourceLocation.getPath();
        return C0265jv.d(path.substring(path.lastIndexOf(47) + 1, path.lastIndexOf(46)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, tD> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        tD.aR();
        map.forEach(tD::a);
    }

    public static void bo() {
        Map mapA = a((Class<?>) jV.class, aY, tD.ad, (tDVar, str) -> {
            return C0265jv.d(str);
        });
        tD.aR();
        mapA.forEach(tD::a);
    }
}
