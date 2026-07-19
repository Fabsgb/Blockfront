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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jQ.class */
public class jQ extends jY<C0467rh> {
    private static final String aT = "game/bot_voices";

    @NotNull
    private final Map<ResourceLocation, C0467rh> A;

    public jQ(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
        this.A = new Object2ObjectLinkedOpenHashMap();
    }

    @Override // com.boehmod.blockfront.jY
    @NotNull
    protected String z() {
        return aT;
    }

    @Override // com.boehmod.blockfront.jY
    @NotNull
    protected Codec<C0467rh> a() {
        return C0467rh.P;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.jY
    @NotNull
    public ResourceLocation a(@NotNull C0467rh c0467rh, @NotNull ResourceLocation resourceLocation) {
        return C0265jv.d(c0467rh.T());
    }

    @NotNull
    public Map<ResourceLocation, C0467rh> h() {
        return Collections.unmodifiableMap(this.A);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, C0467rh> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.A.clear();
        this.A.putAll(map);
        a(map);
    }

    private static void a(@NotNull Map<ResourceLocation, C0467rh> map) {
        sU.aR();
        Iterator<Map.Entry<ResourceLocation, C0467rh>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            C0467rh value = it.next().getValue();
            new sU(value.T(), value.D(), value.E(), value.F(), value.G(), value.H(), value.I(), value.J());
        }
        C0263jt.log("Created %d bot voice(s) from data", Integer.valueOf(map.size()));
    }

    public static void bo() {
        a(a((Class<?>) jQ.class, aT, C0467rh.P, (c0467rh, str) -> {
            return C0265jv.d(c0467rh.T());
        }));
    }
}
