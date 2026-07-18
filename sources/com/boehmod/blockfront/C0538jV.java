package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jV.class */
public class C0538jV extends AbstractC0541jY<C1051tD> {

    /* JADX INFO: renamed from: aY */
    private static final String f3156aY = "gun_spread/configs";

    public C0538jV(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: z */
    protected String mo2406z() {
        return f3156aY;
    }

    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Codec<C1051tD> mo2407a() {
        return C1051tD.f5555ad;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public ResourceLocation mo2412a(@NotNull C1051tD c1051tD, @NotNull ResourceLocation resourceLocation) {
        String path = resourceLocation.getPath();
        return C0564jv.m2555d(path.substring(path.lastIndexOf(47) + 1, path.lastIndexOf(46)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, C1051tD> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        C1051tD.m5838aR();
        map.forEach(C1051tD::m5837a);
    }

    /* JADX INFO: renamed from: bo */
    public static void m2433bo() {
        Map mapA = m2450a((Class<?>) C0538jV.class, f3156aY, C1051tD.f5555ad, (c1051tD, str) -> {
            return C0564jv.m2555d(str);
        });
        C1051tD.m5838aR();
        mapA.forEach(C1051tD::m5837a);
    }
}
