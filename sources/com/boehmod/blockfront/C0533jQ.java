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

/* JADX INFO: renamed from: com.boehmod.blockfront.jQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jQ.class */
public class C0533jQ extends AbstractC0541jY<C0974rh> {

    /* JADX INFO: renamed from: aT */
    private static final String f3149aT = "game/bot_voices";

    /* JADX INFO: renamed from: A */
    @NotNull
    private final Map<ResourceLocation, C0974rh> f3150A;

    public C0533jQ(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
        this.f3150A = new Object2ObjectLinkedOpenHashMap();
    }

    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: z */
    protected String mo2406z() {
        return f3149aT;
    }

    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Codec<C0974rh> mo2407a() {
        return C0974rh.f5120P;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public ResourceLocation mo2412a(@NotNull C0974rh c0974rh, @NotNull ResourceLocation resourceLocation) {
        return C0564jv.m2555d(c0974rh.m5311T());
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Map<ResourceLocation, C0974rh> m2408h() {
        return Collections.unmodifiableMap(this.f3150A);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, C0974rh> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.f3150A.clear();
        this.f3150A.putAll(map);
        m2410a(map);
    }

    /* JADX INFO: renamed from: a */
    private static void m2410a(@NotNull Map<ResourceLocation, C0974rh> map) {
        C1014sU.m5497aR();
        Iterator<Map.Entry<ResourceLocation, C0974rh>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            C0974rh value = it.next().getValue();
            new C1014sU(value.m5311T(), value.m5312D(), value.m5313E(), value.m5314F(), value.m5315G(), value.m5316H(), value.m5317I(), value.m5318J());
        }
        C0562jt.log("Created %d bot voice(s) from data", Integer.valueOf(map.size()));
    }

    /* JADX INFO: renamed from: bo */
    public static void m2411bo() {
        m2410a(m2450a((Class<?>) C0533jQ.class, f3149aT, C0974rh.f5120P, (c0974rh, str) -> {
            return C0564jv.m2555d(c0974rh.m5311T());
        }));
    }
}
