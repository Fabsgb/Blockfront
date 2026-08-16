package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.km */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/km.class */
public class C0609km extends AbstractC0617ku<C0946rE> {

    /* JADX INFO: renamed from: bc */
    private static final String f3527bc = "game/bot_voices";

    /* JADX INFO: renamed from: A */
    @NotNull
    private final Map<ResourceLocation, C0946rE> f3528A;

    public C0609km(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
        this.f3528A = new Object2ObjectLinkedOpenHashMap();
    }

    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: G */
    protected String mo2768G() {
        return f3527bc;
    }

    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Codec<C0946rE> mo2769a() {
        return C0946rE.f5224P;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public ResourceLocation mo2774a(@NotNull C0946rE c0946rE, @NotNull ResourceLocation resourceLocation) {
        return C0532jO.m2378d(c0946rE.m5187aa());
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Map<ResourceLocation, C0946rE> m2770h() {
        return Collections.unmodifiableMap(this.f3528A);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, C0946rE> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.f3528A.clear();
        this.f3528A.putAll(map);
        m2772a(map);
    }

    /* JADX INFO: renamed from: a */
    private static void m2772a(@NotNull Map<ResourceLocation, C0946rE> map) {
        C1092tr.m5985aZ();
        Iterator<Map.Entry<ResourceLocation, C0946rE>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            C0946rE value = it.next().getValue();
            new C1092tr(value.m5187aa(), value.m5188E(), value.m5189F(), value.m5190G(), value.m5191H(), value.m5192I(), value.m5193J(), value.m5194K());
        }
        C0530jM.log("Created %d bot voice(s) from data", Integer.valueOf(map.size()));
    }

    /* JADX INFO: renamed from: bz */
    public static void m2773bz() {
        m2772a(m2809a((Class<?>) C0609km.class, f3527bc, C0946rE.f5224P, (c0946rE, str) -> {
            return C0532jO.m2378d(c0946rE.m5187aa());
        }));
    }
}
