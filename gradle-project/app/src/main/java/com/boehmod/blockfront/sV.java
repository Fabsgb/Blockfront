package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerRank;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sV.class */
public final class sV {

    @NotNull
    public static final List<sV> bE = new ObjectArrayList();

    @NotNull
    private static final Map<ResourceLocation, sV> U = new LinkedHashMap();

    @NotNull
    private static final Map<String, sV> V = new LinkedHashMap();
    private final int rn;

    @NotNull
    private final String cJ;

    @NotNull
    private final ResourceLocation fA;

    @NotNull
    private final String cK;

    @NotNull
    private final String cL;
    private final boolean ho;

    @NotNull
    private final ResourceLocation fB;
    private final boolean hp;
    private final boolean hq;
    private final boolean hr;
    private final boolean hs;

    @NotNull
    private PlayerRank b;

    static {
        jR.bo();
    }

    public static void aR() {
        bE.clear();
        U.clear();
        V.clear();
    }

    public sV(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @NotNull ResourceLocation resourceLocation, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.b = PlayerRank.RECRUIT;
        this.rn = bE.size();
        this.cJ = str;
        this.fA = C0265jv.d(str);
        this.cK = str2;
        this.cL = str3;
        this.ho = z;
        this.fB = resourceLocation;
        this.hp = z2;
        this.hq = z3;
        this.hr = z4;
        this.hs = z5;
        bE.add(this);
        U.put(this.fA, this);
        V.put(this.cJ, this);
    }

    public sV(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @NotNull ResourceLocation resourceLocation, boolean z2, boolean z3, boolean z4, boolean z5, @NotNull PlayerRank playerRank) {
        this(str, str2, str3, z, resourceLocation, z2, z3, z4, z5);
        this.b = playerRank;
    }

    @Nullable
    public static sV a(@NotNull ResourceLocation resourceLocation) {
        return U.get(resourceLocation);
    }

    @Nullable
    public static sV a(@NotNull String str) {
        return V.get(str);
    }

    @NotNull
    public static List<sV> av() {
        return Collections.unmodifiableList(bE);
    }

    @NotNull
    public static sV c() {
        for (sV sVVar : bE) {
            if (sVVar.hp) {
                return sVVar;
            }
        }
        return (sV) bE.getFirst();
    }

    @NotNull
    public String getKey() {
        return this.cJ;
    }

    @NotNull
    public ResourceLocation L() {
        return this.fA;
    }

    @NotNull
    public String al() {
        return this.cK;
    }

    @NotNull
    public String p() {
        return this.cL;
    }

    @NotNull
    public ResourceLocation getIcon() {
        return this.fB;
    }

    public boolean bS() {
        return this.ho;
    }

    public boolean bF() {
        return this.hp;
    }

    public boolean bT() {
        return this.hq;
    }

    public boolean bH() {
        return this.hr;
    }

    public boolean bU() {
        return this.hs;
    }

    public int bN() {
        return this.rn;
    }

    @NotNull
    public PlayerRank a() {
        return this.b;
    }

    public boolean a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Player player) {
        iS iSVarA = cVar.a(player);
        return iSVarA.getRank().getID() >= this.b.getID() || iSVarA.getPrestigeLevel() > 0;
    }

    public boolean a(@NotNull oF<?, ?, ?> oFVar) {
        return !oFVar.e().contains(this);
    }

    public boolean k(@NotNull String str) {
        return this.cJ.equals(str);
    }

    @Nullable
    public static sV a(int i) {
        if (i < 0 || i >= bE.size()) {
            return null;
        }
        return bE.get(i);
    }

    @Nullable
    public static sV b(@NotNull String str) {
        return V.get(str);
    }
}
