package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kp.class */
public class C0612kp extends AbstractC0617ku<C1189vi> {

    /* JADX INFO: renamed from: bg */
    private static final String f3533bg = "gun_damage_configs";

    public C0612kp(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
    }

    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: G */
    protected String mo2768G() {
        return f3533bg;
    }

    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Codec<C1189vi> mo2769a() {
        return C1189vi.f6466aj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public ResourceLocation mo2774a(@NotNull C1189vi c1189vi, @NotNull ResourceLocation resourceLocation) {
        String path = resourceLocation.getPath();
        return C0532jO.m2378d(path.substring(path.lastIndexOf(47) + 1, path.lastIndexOf(46)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, C1189vi> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        C1189vi.m6766aZ();
        map.forEach(C1189vi::m6764a);
    }

    /* JADX INFO: renamed from: bz */
    public static void m2789bz() {
        Map mapA = m2809a((Class<?>) C0612kp.class, f3533bg, C1189vi.f6466aj, (c1189vi, str) -> {
            return C0532jO.m2378d(str);
        });
        C1189vi.m6766aZ();
        mapA.forEach(C1189vi::m6764a);
    }
}
