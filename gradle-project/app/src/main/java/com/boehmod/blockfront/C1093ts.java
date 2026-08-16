package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ts */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ts.class */
public final class C1093ts {

    /* JADX INFO: renamed from: bL */
    @NotNull
    public static final List<C1093ts> f5891bL = new ObjectArrayList();

    /* JADX INFO: renamed from: U */
    @NotNull
    private static final Map<ResourceLocation, C1093ts> f5892U = new LinkedHashMap();

    /* JADX INFO: renamed from: V */
    @NotNull
    private static final Map<String, C1093ts> f5893V = new LinkedHashMap();

    /* JADX INFO: renamed from: to */
    private final int f5894to;

    /* JADX INFO: renamed from: cT */
    @NotNull
    private final String f5895cT;

    /* JADX INFO: renamed from: fz */
    @NotNull
    private final ResourceLocation f5896fz;

    /* JADX INFO: renamed from: cU */
    @NotNull
    private final String f5897cU;

    /* JADX INFO: renamed from: cV */
    @NotNull
    private final String f5898cV;

    /* JADX INFO: renamed from: hI */
    private final boolean f5899hI;

    /* JADX INFO: renamed from: fA */
    @NotNull
    private final ResourceLocation f5900fA;

    /* JADX INFO: renamed from: hJ */
    private final boolean f5901hJ;

    /* JADX INFO: renamed from: hK */
    private final boolean f5902hK;

    /* JADX INFO: renamed from: hL */
    private final boolean f5903hL;

    /* JADX INFO: renamed from: hM */
    private final boolean f5904hM;

    /* JADX INFO: renamed from: b */
    @NotNull
    private PlayerRank f5905b;

    static {
        C0610kn.m2780bz();
    }

    /* JADX INFO: renamed from: aZ */
    public static void m5998aZ() {
        f5891bL.clear();
        f5892U.clear();
        f5893V.clear();
    }

    public C1093ts(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @NotNull ResourceLocation resourceLocation, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f5905b = PlayerRank.RECRUIT;
        this.f5894to = f5891bL.size();
        this.f5895cT = str;
        this.f5896fz = C0532jO.m2378d(str);
        this.f5897cU = str2;
        this.f5898cV = str3;
        this.f5899hI = z;
        this.f5900fA = resourceLocation;
        this.f5901hJ = z2;
        this.f5902hK = z3;
        this.f5903hL = z4;
        this.f5904hM = z5;
        f5891bL.add(this);
        f5892U.put(this.f5896fz, this);
        f5893V.put(this.f5895cT, this);
    }

    public C1093ts(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @NotNull ResourceLocation resourceLocation, boolean z2, boolean z3, boolean z4, boolean z5, @NotNull PlayerRank playerRank) {
        this(str, str2, str3, z, resourceLocation, z2, z3, z4, z5);
        this.f5905b = playerRank;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1093ts m5999a(@NotNull ResourceLocation resourceLocation) {
        return f5892U.get(resourceLocation);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1093ts m6000a(@NotNull String str) {
        return f5893V.get(str);
    }

    @NotNull
    /* JADX INFO: renamed from: ax */
    public static List<C1093ts> m6001ax() {
        return Collections.unmodifiableList(f5891bL);
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public static C1093ts m6002c() {
        for (C1093ts c1093ts : f5891bL) {
            if (c1093ts.f5901hJ) {
                return c1093ts;
            }
        }
        return (C1093ts) f5891bL.getFirst();
    }

    @NotNull
    public String getKey() {
        return this.f5895cT;
    }

    @NotNull
    /* JADX INFO: renamed from: M */
    public ResourceLocation m6003M() {
        return this.f5896fz;
    }

    @NotNull
    /* JADX INFO: renamed from: as */
    public String m6004as() {
        return this.f5897cU;
    }

    @NotNull
    /* JADX INFO: renamed from: t */
    public String m6005t() {
        return this.f5898cV;
    }

    @NotNull
    public ResourceLocation getIcon() {
        return this.f5900fA;
    }

    /* JADX INFO: renamed from: cc */
    public boolean m6006cc() {
        return this.f5899hI;
    }

    /* JADX INFO: renamed from: bP */
    public boolean m6007bP() {
        return this.f5901hJ;
    }

    /* JADX INFO: renamed from: cd */
    public boolean m6008cd() {
        return this.f5902hK;
    }

    /* JADX INFO: renamed from: bR */
    public boolean m6009bR() {
        return this.f5903hL;
    }

    /* JADX INFO: renamed from: ce */
    public boolean m6010ce() {
        return this.f5904hM;
    }

    /* JADX INFO: renamed from: cc */
    public int m6011cc() {
        return this.f5894to;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public PlayerRank m6012a() {
        return this.f5905b;
    }

    /* JADX INFO: renamed from: a */
    public boolean m6013a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull Player player) {
        C0555jl c0555jlM1150a = abstractC0184c.m1150a(player);
        return c0555jlM1150a.getRank().getID() >= this.f5905b.getID() || c0555jlM1150a.getPrestigeLevel() > 0;
    }

    /* JADX INFO: renamed from: a */
    public boolean m6014a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        return !abstractC0863pb.mo3997e().contains(this);
    }

    /* JADX INFO: renamed from: n */
    public boolean m6015n(@NotNull String str) {
        return this.f5895cT.equals(str);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1093ts m6016a(int i) {
        if (i < 0 || i >= f5891bL.size()) {
            return null;
        }
        return f5891bL.get(i);
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public static C1093ts m6017b(@NotNull String str) {
        return f5893V.get(str);
    }
}
