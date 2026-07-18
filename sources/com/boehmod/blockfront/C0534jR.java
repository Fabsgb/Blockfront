package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jR.class */
public class C0534jR extends AbstractC0541jY<C0976rj> {

    /* JADX INFO: renamed from: aU */
    private static final String f3151aU = "game/class_types";

    /* JADX INFO: renamed from: B */
    @NotNull
    private final Map<ResourceLocation, C0976rj> f3152B;

    public C0534jR(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
        this.f3152B = new Object2ObjectLinkedOpenHashMap();
    }

    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: z */
    protected String mo2406z() {
        return f3151aU;
    }

    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Codec<C0976rj> mo2407a() {
        return C0976rj.f5140R;
    }

    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: a */
    public ResourceLocation mo2412a(@NotNull C0976rj c0976rj, @NotNull ResourceLocation resourceLocation) {
        return C0564jv.m2555d(c0976rj.m5329T());
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public Map<ResourceLocation, C0976rj> m2414i() {
        return Collections.unmodifiableMap(this.f3152B);
    }

    /* JADX INFO: renamed from: a */
    public void apply(@NotNull Map<ResourceLocation, C0976rj> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.f3152B.clear();
        this.f3152B.putAll(map);
        m2416b(map);
    }

    /* JADX INFO: renamed from: b */
    private static void m2416b(@NotNull Map<ResourceLocation, C0976rj> map) {
        C1015sV.m5510aR();
        Iterator<Map.Entry<ResourceLocation, C0976rj>> it = map.entrySet().stream().sorted(Comparator.comparingInt(entry -> {
            return ((C0976rj) entry.getValue()).m5328bz();
        })).toList().iterator();
        while (it.hasNext()) {
            C0976rj value = it.next().getValue();
            new C1015sV(value.m5329T(), value.m5330X(), value.m5331Y(), value.m5332bE(), value.m5333K(), value.m5334bF(), value.m5335bG(), value.m5336bH(), value.m5337bI(), m2417a(value.m5338Z()));
        }
        C0562jt.log("Created %d class type(s) from data", Integer.valueOf(map.size()));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static PlayerRank m2417a(@NotNull String str) {
        ObjectIterator it = PlayerRank.PLAYER_RANK_MAP.values().iterator();
        while (it.hasNext()) {
            PlayerRank playerRank = (PlayerRank) it.next();
            if (playerRank.getTexture().equals(str)) {
                return playerRank;
            }
        }
        return PlayerRank.RECRUIT;
    }

    /* JADX INFO: renamed from: bo */
    public static void m2418bo() {
        m2416b((Map<ResourceLocation, C0976rj>) m2450a((Class<?>) C0534jR.class, f3151aU, C0976rj.f5140R, (c0976rj, str) -> {
            return C0564jv.m2555d(c0976rj.m5329T());
        }));
    }
}
