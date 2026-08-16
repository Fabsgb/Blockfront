package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kr.class */
public class C0614kr extends AbstractC0617ku<C1129ub> {

    /* JADX INFO: renamed from: bh */
    private static final String f3534bh = "gun_spread/configs";

    public C0614kr(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: G */
    protected String mo2768G() {
        return f3534bh;
    }

    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Codec<C1129ub> mo2769a() {
        return C1129ub.f6194ad;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public ResourceLocation mo2774a(@NotNull C1129ub c1129ub, @NotNull ResourceLocation resourceLocation) {
        String path = resourceLocation.getPath();
        return C0532jO.m2378d(path.substring(path.lastIndexOf(47) + 1, path.lastIndexOf(46)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, C1129ub> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        C1129ub.m6474aZ();
        map.forEach(C1129ub::m6473a);
    }

    /* JADX INFO: renamed from: bz */
    public static void m2792bz() {
        Map mapA = m2809a((Class<?>) C0614kr.class, f3534bh, C1129ub.f6194ad, (c1129ub, str) -> {
            return C0532jO.m2378d(str);
        });
        C1129ub.m6474aZ();
        mapA.forEach(C1129ub::m6473a);
    }
}
