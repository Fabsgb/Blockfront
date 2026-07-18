package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sV.class */
public final class C1015sV {

    /* JADX INFO: renamed from: bE */
    @NotNull
    public static final List<C1015sV> f5327bE = new ObjectArrayList();

    /* JADX INFO: renamed from: U */
    @NotNull
    private static final Map<ResourceLocation, C1015sV> f5328U = new LinkedHashMap();

    /* JADX INFO: renamed from: V */
    @NotNull
    private static final Map<String, C1015sV> f5329V = new LinkedHashMap();

    /* JADX INFO: renamed from: rn */
    private final int f5330rn;

    /* JADX INFO: renamed from: cJ */
    @NotNull
    private final String f5331cJ;

    /* JADX INFO: renamed from: fA */
    @NotNull
    private final ResourceLocation f5332fA;

    /* JADX INFO: renamed from: cK */
    @NotNull
    private final String f5333cK;

    /* JADX INFO: renamed from: cL */
    @NotNull
    private final String f5334cL;

    /* JADX INFO: renamed from: ho */
    private final boolean f5335ho;

    /* JADX INFO: renamed from: fB */
    @NotNull
    private final ResourceLocation f5336fB;

    /* JADX INFO: renamed from: hp */
    private final boolean f5337hp;

    /* JADX INFO: renamed from: hq */
    private final boolean f5338hq;

    /* JADX INFO: renamed from: hr */
    private final boolean f5339hr;

    /* JADX INFO: renamed from: hs */
    private final boolean f5340hs;

    /* JADX INFO: renamed from: b */
    @NotNull
    private PlayerRank f5341b;

    static {
        C0534jR.m2418bo();
    }

    /* JADX INFO: renamed from: aR */
    public static void m5510aR() {
        f5327bE.clear();
        f5328U.clear();
        f5329V.clear();
    }

    public C1015sV(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @NotNull ResourceLocation resourceLocation, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f5341b = PlayerRank.RECRUIT;
        this.f5330rn = f5327bE.size();
        this.f5331cJ = str;
        this.f5332fA = C0564jv.m2555d(str);
        this.f5333cK = str2;
        this.f5334cL = str3;
        this.f5335ho = z;
        this.f5336fB = resourceLocation;
        this.f5337hp = z2;
        this.f5338hq = z3;
        this.f5339hr = z4;
        this.f5340hs = z5;
        f5327bE.add(this);
        f5328U.put(this.f5332fA, this);
        f5329V.put(this.f5331cJ, this);
    }

    public C1015sV(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @NotNull ResourceLocation resourceLocation, boolean z2, boolean z3, boolean z4, boolean z5, @NotNull PlayerRank playerRank) {
        this(str, str2, str3, z, resourceLocation, z2, z3, z4, z5);
        this.f5341b = playerRank;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1015sV m5511a(@NotNull ResourceLocation resourceLocation) {
        return f5328U.get(resourceLocation);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1015sV m5512a(@NotNull String str) {
        return f5329V.get(str);
    }

    @NotNull
    /* JADX INFO: renamed from: av */
    public static List<C1015sV> m5513av() {
        return Collections.unmodifiableList(f5327bE);
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public static C1015sV m5514c() {
        for (C1015sV c1015sV : f5327bE) {
            if (c1015sV.f5337hp) {
                return c1015sV;
            }
        }
        return (C1015sV) f5327bE.getFirst();
    }

    @NotNull
    public String getKey() {
        return this.f5331cJ;
    }

    @NotNull
    /* JADX INFO: renamed from: L */
    public ResourceLocation m5515L() {
        return this.f5332fA;
    }

    @NotNull
    /* JADX INFO: renamed from: al */
    public String m5516al() {
        return this.f5333cK;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public String m5517p() {
        return this.f5334cL;
    }

    @NotNull
    public ResourceLocation getIcon() {
        return this.f5336fB;
    }

    /* JADX INFO: renamed from: bS */
    public boolean m5518bS() {
        return this.f5335ho;
    }

    /* JADX INFO: renamed from: bF */
    public boolean m5519bF() {
        return this.f5337hp;
    }

    /* JADX INFO: renamed from: bT */
    public boolean m5520bT() {
        return this.f5338hq;
    }

    /* JADX INFO: renamed from: bH */
    public boolean m5521bH() {
        return this.f5339hr;
    }

    /* JADX INFO: renamed from: bU */
    public boolean m5522bU() {
        return this.f5340hs;
    }

    /* JADX INFO: renamed from: bN */
    public int m5523bN() {
        return this.f5330rn;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public PlayerRank m5524a() {
        return this.f5341b;
    }

    /* JADX INFO: renamed from: a */
    public boolean m5525a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull Player player) {
        C0482iS c0482iSM1133a = abstractC0183c.m1133a(player);
        return c0482iSM1133a.getRank().getID() >= this.f5341b.getID() || c0482iSM1133a.getPrestigeLevel() > 0;
    }

    /* JADX INFO: renamed from: a */
    public boolean m5526a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        return !abstractC0787oF.mo3561e().contains(this);
    }

    /* JADX INFO: renamed from: k */
    public boolean m5527k(@NotNull String str) {
        return this.f5331cJ.equals(str);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1015sV m5528a(int i) {
        if (i < 0 || i >= f5327bE.size()) {
            return null;
        }
        return f5327bE.get(i);
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public static C1015sV m5529b(@NotNull String str) {
        return f5329V.get(str);
    }
}
