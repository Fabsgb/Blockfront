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

/* JADX INFO: renamed from: com.boehmod.blockfront.kn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kn.class */
public class C0610kn extends AbstractC0617ku<C0948rG> {

    /* JADX INFO: renamed from: bd */
    private static final String f3529bd = "game/class_types";

    /* JADX INFO: renamed from: B */
    @NotNull
    private final Map<ResourceLocation, C0948rG> f3530B;

    public C0610kn(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
        this.f3530B = new Object2ObjectLinkedOpenHashMap();
    }

    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: G */
    protected String mo2768G() {
        return f3529bd;
    }

    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Codec<C0948rG> mo2769a() {
        return C0948rG.f5244R;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public ResourceLocation mo2774a(@NotNull C0948rG c0948rG, @NotNull ResourceLocation resourceLocation) {
        return C0532jO.m2378d(c0948rG.m5205aa());
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public Map<ResourceLocation, C0948rG> m2776i() {
        return Collections.unmodifiableMap(this.f3530B);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, C0948rG> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.f3530B.clear();
        this.f3530B.putAll(map);
        m2778b(map);
    }

    /* JADX INFO: renamed from: b */
    private static void m2778b(@NotNull Map<ResourceLocation, C0948rG> map) {
        C1093ts.m5998aZ();
        Iterator<Map.Entry<ResourceLocation, C0948rG>> it = map.entrySet().stream().sorted(Comparator.comparingInt(entry -> {
            return ((C0948rG) entry.getValue()).m5204bO();
        })).toList().iterator();
        while (it.hasNext()) {
            C0948rG value = it.next().getValue();
            new C1093ts(value.m5205aa(), value.m5206ae(), value.m5207af(), value.m5208bO(), value.m5209L(), value.m5210bP(), value.m5211bQ(), value.m5212bR(), value.m5213bS(), m2779a(value.m5214ag()));
        }
        C0530jM.log("Created %d class type(s) from data", Integer.valueOf(map.size()));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static PlayerRank m2779a(@NotNull String str) {
        ObjectIterator it = PlayerRank.PLAYER_RANK_MAP.values().iterator();
        while (it.hasNext()) {
            PlayerRank playerRank = (PlayerRank) it.next();
            if (playerRank.getTexture().equals(str)) {
                return playerRank;
            }
        }
        return PlayerRank.RECRUIT;
    }

    /* JADX INFO: renamed from: bz */
    public static void m2780bz() {
        m2778b(m2809a((Class<?>) C0610kn.class, f3529bd, C0948rG.f5244R, (c0948rG, str) -> {
            return C0532jO.m2378d(c0948rG.m5205aa());
        }));
    }
}
