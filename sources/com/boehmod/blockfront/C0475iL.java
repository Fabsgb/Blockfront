package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iL.class */
public class C0475iL {
    /* JADX INFO: renamed from: a */
    public static float m2149a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull AbstractClanData abstractClanData) {
        return ((Float) abstractClanData.getMembers().stream().map(uuid -> {
            C0482iS c0482iSM1132a = abstractC0183c.m1132a(uuid);
            return Float.valueOf(c0482iSM1132a.getKills() / Math.max(1, c0482iSM1132a.getDeaths()));
        }).reduce(Float.valueOf(0.0f), (v0, v1) -> {
            return Float.sum(v0, v1);
        })).floatValue() / r0.size();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static MutableComponent m2150a(@NotNull C0482iS c0482iS) {
        AbstractClanData clanData = c0482iS.getClanData();
        if (clanData != null) {
            return m2151a(clanData);
        }
        return Component.empty();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static MutableComponent m2151a(@NotNull AbstractClanData abstractClanData) {
        return Component.literal(String.format("[%s] ", abstractClanData.getName())).withColor(ColorReferences.COLOR_THEME_CLANS_SOLID);
    }
}
