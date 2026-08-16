package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import java.util.Set;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.je */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/je.class */
public class C0548je {
    /* JADX INFO: renamed from: a */
    public static float m2476a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull AbstractClanData abstractClanData) {
        Set<UUID> members = abstractClanData.getMembers();
        return ((Float) members.stream().map(uuid -> {
            C0555jl c0555jlM1149a = abstractC0184c.m1149a(uuid);
            return Float.valueOf(c0555jlM1149a.getKills() / Math.max(1, c0555jlM1149a.getDeaths()));
        }).reduce(Float.valueOf(0.0f), (v0, v1) -> {
            return Float.sum(v0, v1);
        })).floatValue() / members.size();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static MutableComponent m2477a(@NotNull C0555jl c0555jl) {
        AbstractClanData clanData = c0555jl.getClanData();
        if (clanData != null) {
            return m2478a(clanData);
        }
        return Component.empty();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static MutableComponent m2478a(@NotNull AbstractClanData abstractClanData) {
        return Component.literal(String.format("[%s] ", abstractClanData.getName())).withColor(ColorReferences.COLOR_THEME_CLANS_SOLID);
    }
}
