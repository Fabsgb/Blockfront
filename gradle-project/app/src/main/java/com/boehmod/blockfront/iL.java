package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iL.class */
public class iL {
    public static float a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull AbstractClanData abstractClanData) {
        return ((Float) abstractClanData.getMembers().stream().map(uuid -> {
            iS iSVarA = cVar.a(uuid);
            return Float.valueOf(iSVarA.getKills() / Math.max(1, iSVarA.getDeaths()));
        }).reduce(Float.valueOf(0.0f), (v0, v1) -> {
            return Float.sum(v0, v1);
        })).floatValue() / r0.size();
    }

    @NotNull
    public static MutableComponent a(@NotNull iS iSVar) {
        AbstractClanData clanData = iSVar.getClanData();
        if (clanData != null) {
            return a(clanData);
        }
        return Component.empty();
    }

    @NotNull
    public static MutableComponent a(@NotNull AbstractClanData abstractClanData) {
        return Component.literal(String.format("[%s] ", abstractClanData.getName())).withColor(ColorReferences.COLOR_THEME_CLANS_SOLID);
    }
}
