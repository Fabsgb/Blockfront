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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jR.class */
public class jR extends jY<C0469rj> {
    private static final String aU = "game/class_types";

    @NotNull
    private final Map<ResourceLocation, C0469rj> B;

    public jR(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
        this.B = new Object2ObjectLinkedOpenHashMap();
    }

    @Override // com.boehmod.blockfront.jY
    @NotNull
    protected String z() {
        return aU;
    }

    @Override // com.boehmod.blockfront.jY
    @NotNull
    protected Codec<C0469rj> a() {
        return C0469rj.R;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.jY
    @NotNull
    public ResourceLocation a(@NotNull C0469rj c0469rj, @NotNull ResourceLocation resourceLocation) {
        return C0265jv.d(c0469rj.T());
    }

    @NotNull
    public Map<ResourceLocation, C0469rj> i() {
        return Collections.unmodifiableMap(this.B);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, C0469rj> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.B.clear();
        this.B.putAll(map);
        b(map);
    }

    private static void b(@NotNull Map<ResourceLocation, C0469rj> map) {
        sV.aR();
        Iterator<Map.Entry<ResourceLocation, C0469rj>> it = map.entrySet().stream().sorted(Comparator.comparingInt(entry -> {
            return ((C0469rj) entry.getValue()).bz();
        })).toList().iterator();
        while (it.hasNext()) {
            C0469rj value = it.next().getValue();
            new sV(value.T(), value.X(), value.Y(), value.bE(), value.K(), value.bF(), value.bG(), value.bH(), value.bI(), a(value.Z()));
        }
        C0263jt.log("Created %d class type(s) from data", Integer.valueOf(map.size()));
    }

    @NotNull
    private static PlayerRank a(@NotNull String str) {
        ObjectIterator it = PlayerRank.PLAYER_RANK_MAP.values().iterator();
        while (it.hasNext()) {
            PlayerRank playerRank = (PlayerRank) it.next();
            if (playerRank.getTexture().equals(str)) {
                return playerRank;
            }
        }
        return PlayerRank.RECRUIT;
    }

    public static void bo() {
        b((Map<ResourceLocation, C0469rj>) a((Class<?>) jR.class, aU, C0469rj.R, (c0469rj, str) -> {
            return C0265jv.d(c0469rj.T());
        }));
    }
}
