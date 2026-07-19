package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jT.class */
public class jT extends jY<uI> {
    private static final String aX = "gun_damage_configs";

    public jT(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override // com.boehmod.blockfront.jY
    @NotNull
    protected String z() {
        return aX;
    }

    @Override // com.boehmod.blockfront.jY
    @NotNull
    protected Codec<uI> a() {
        return uI.aj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.jY
    @NotNull
    public ResourceLocation a(@NotNull uI uIVar, @NotNull ResourceLocation resourceLocation) {
        String path = resourceLocation.getPath();
        return C0265jv.d(path.substring(path.lastIndexOf(47) + 1, path.lastIndexOf(46)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, uI> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        uI.aR();
        map.forEach(uI::a);
    }

    public static void bo() {
        Map mapA = a((Class<?>) jT.class, aX, uI.aj, (uIVar, str) -> {
            return C0265jv.d(str);
        });
        uI.aR();
        mapA.forEach(uI::a);
    }
}
