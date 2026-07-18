package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.resources.ResourceLocation;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ta */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ta.class */
public final class C1074ta {

    /* JADX INFO: renamed from: bR */
    @NotNull
    public static final List<C1074ta> f5641bR = new ObjectArrayList();

    /* JADX INFO: renamed from: ac */
    @NotNull
    private static final Map<ResourceLocation, C1074ta> f5642ac = new LinkedHashMap();

    /* JADX INFO: renamed from: a */
    public final byte f5643a;

    /* JADX INFO: renamed from: fJ */
    @NotNull
    private final ResourceLocation f5644fJ;

    /* JADX INFO: renamed from: a */
    private final C1019sZ f5645a;

    /* JADX INFO: renamed from: cW */
    private final String f5646cW;

    /* JADX INFO: renamed from: bd */
    private List<EnumC0682mG> f5647bd = List.of(EnumC0682mG.CAUCASIAN);

    /* JADX INFO: renamed from: ad */
    private final Map<C1015sV, ObjectList<C0866pf>> f5648ad = new LinkedHashMap();

    static {
        C0596ka.m2619bo();
    }

    /* JADX INFO: renamed from: aR */
    public static void m5967aR() {
        f5641bR.clear();
        f5642ac.clear();
    }

    public C1074ta(int i, @NotNull C1019sZ c1019sZ, @NotNull String str) {
        this.f5643a = (byte) i;
        this.f5645a = c1019sZ;
        this.f5646cW = str;
        this.f5644fJ = C0564jv.m2555d(c1019sZ.m5669ao() + "_" + str);
        f5641bR.add(this);
        f5642ac.put(this.f5644fJ, this);
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public static C1074ta m5968b(@NotNull ResourceLocation resourceLocation) {
        return f5642ac.get(resourceLocation);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1074ta m5969a(@NotNull String str) {
        return f5642ac.get(C0564jv.m2555d(str));
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    public static C1074ta m5970g() {
        C1074ta c1074ta = null;
        while (c1074ta == null) {
            c1074ta = f5641bR.get(ThreadLocalRandom.current().nextInt(f5641bR.size()));
            if (c1074ta.m5981a(C1015sV.m5514c(), 0) == null) {
                c1074ta = null;
            }
        }
        return c1074ta;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1074ta m5971a(@NotNull C1019sZ c1019sZ, @NotNull String str) {
        for (C1074ta c1074ta : f5641bR) {
            if (c1074ta.f5645a.m5669ao().equals(c1019sZ.m5669ao()) && c1074ta.f5646cW.equals(str)) {
                return c1074ta;
            }
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0682mG m5972a() {
        return this.f5647bd.get(ThreadLocalRandom.current().nextInt(this.f5647bd.size()));
    }

    /* JADX INFO: renamed from: a */
    public C1074ta m5973a(@NotNull List<EnumC0682mG> list) {
        this.f5647bd = list;
        return this;
    }

    /* JADX INFO: renamed from: bS */
    public int m5974bS() {
        return this.f5643a;
    }

    @NotNull
    /* JADX INFO: renamed from: L */
    public ResourceLocation m5975L() {
        return this.f5644fJ;
    }

    /* JADX INFO: renamed from: a */
    public C1019sZ m5976a() {
        return this.f5645a;
    }

    public String getSkin() {
        return this.f5646cW;
    }

    /* JADX INFO: renamed from: r */
    public Map<C1015sV, ObjectList<C0866pf>> m5977r() {
        return Collections.unmodifiableMap(this.f5648ad);
    }

    /* JADX INFO: renamed from: f */
    public void m5978f(@NotNull Map<ResourceLocation, List<C0866pf>> map) {
        this.f5648ad.clear();
        for (Map.Entry<ResourceLocation, List<C0866pf>> entry : map.entrySet()) {
            C1015sV c1015sVM5511a = C1015sV.m5511a(entry.getKey());
            if (c1015sVM5511a != null) {
                this.f5648ad.put(c1015sVM5511a, new ObjectArrayList(entry.getValue()));
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Optional<Pair<C0866pf, C1015sV>> m5979a(boolean z) {
        return m5980a(z, pair -> {
            return true;
        });
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Optional<Pair<C0866pf, C1015sV>> m5980a(boolean z, @NotNull Predicate<Pair<C0866pf, C1015sV>> predicate) {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Pair<C0866pf, C1015sV> pairOf = null;
        ObjectArrayList objectArrayList = new ObjectArrayList(this.f5648ad.entrySet());
        while (true) {
            if (pairOf != null && predicate.test(pairOf) && (!z || ((C1015sV) pairOf.getRight()).m5518bS())) {
                break;
            }
            Map.Entry entry = (Map.Entry) objectArrayList.get(threadLocalRandomCurrent.nextInt(objectArrayList.size()));
            ObjectList objectList = (ObjectList) entry.getValue();
            pairOf = Pair.of((C0866pf) objectList.get(threadLocalRandomCurrent.nextInt(objectList.size())), (C1015sV) entry.getKey());
        }
        return Optional.of(pairOf);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0866pf m5981a(@NotNull C1015sV c1015sV, int i) {
        ObjectList<C0866pf> objectList = this.f5648ad.get(c1015sV);
        if (objectList == null || i >= objectList.size()) {
            return null;
        }
        return (C0866pf) objectList.get(i);
    }
}
