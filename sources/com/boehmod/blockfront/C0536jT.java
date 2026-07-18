package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jT.class */
public class C0536jT extends AbstractC0541jY<C1109uI> {

    /* JADX INFO: renamed from: aX */
    private static final String f3155aX = "gun_damage_configs";

    public C0536jT(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: z */
    protected String mo2406z() {
        return f3155aX;
    }

    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Codec<C1109uI> mo2407a() {
        return C1109uI.f5827aj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public ResourceLocation mo2412a(@NotNull C1109uI c1109uI, @NotNull ResourceLocation resourceLocation) {
        String path = resourceLocation.getPath();
        return C0564jv.m2555d(path.substring(path.lastIndexOf(47) + 1, path.lastIndexOf(46)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, C1109uI> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        C1109uI.m6113aR();
        map.forEach(C1109uI::m6111a);
    }

    /* JADX INFO: renamed from: bo */
    public static void m2427bo() {
        Map mapA = m2450a((Class<?>) C0536jT.class, f3155aX, C1109uI.f5827aj, (c1109uI, str) -> {
            return C0564jv.m2555d(str);
        });
        C1109uI.m6113aR();
        mapA.forEach(C1109uI::m6111a);
    }
}
