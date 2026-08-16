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

/* JADX INFO: renamed from: com.boehmod.blockfront.tx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tx.class */
public final class C1098tx {

    /* JADX INFO: renamed from: bY */
    @NotNull
    public static final List<C1098tx> f5986bY = new ObjectArrayList();

    /* JADX INFO: renamed from: ac */
    @NotNull
    private static final Map<ResourceLocation, C1098tx> f5987ac = new LinkedHashMap();

    /* JADX INFO: renamed from: a */
    public final byte f5988a;

    /* JADX INFO: renamed from: fI */
    @NotNull
    private final ResourceLocation f5989fI;

    /* JADX INFO: renamed from: a */
    private final C1097tw f5990a;

    /* JADX INFO: renamed from: dg */
    private final String f5991dg;

    /* JADX INFO: renamed from: bk */
    private List<EnumC0758nc> f5992bk = List.of(EnumC0758nc.CAUCASIAN);

    /* JADX INFO: renamed from: ad */
    private final Map<C1093ts, ObjectList<C0837pB>> f5993ad = new LinkedHashMap();

    static {
        C0619kw.m2831bz();
    }

    /* JADX INFO: renamed from: aZ */
    public static void m6170aZ() {
        f5986bY.clear();
        f5987ac.clear();
    }

    public C1098tx(int i, @NotNull C1097tw c1097tw, @NotNull String str) {
        this.f5988a = (byte) i;
        this.f5990a = c1097tw;
        this.f5991dg = str;
        this.f5989fI = C0532jO.m2378d(c1097tw.m6157av() + "_" + str);
        f5986bY.add(this);
        f5987ac.put(this.f5989fI, this);
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public static C1098tx m6171b(@NotNull ResourceLocation resourceLocation) {
        return f5987ac.get(resourceLocation);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1098tx m6172a(@NotNull String str) {
        return f5987ac.get(C0532jO.m2378d(str));
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    public static C1098tx m6173g() {
        C1098tx c1098tx = null;
        while (c1098tx == null) {
            c1098tx = f5986bY.get(ThreadLocalRandom.current().nextInt(f5986bY.size()));
            if (c1098tx.m6184a(C1093ts.m6002c(), 0) == null) {
                c1098tx = null;
            }
        }
        return c1098tx;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1098tx m6174a(@NotNull C1097tw c1097tw, @NotNull String str) {
        for (C1098tx c1098tx : f5986bY) {
            if (c1098tx.f5990a.m6157av().equals(c1097tw.m6157av()) && c1098tx.f5991dg.equals(str)) {
                return c1098tx;
            }
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0758nc m6175a() {
        return this.f5992bk.get(ThreadLocalRandom.current().nextInt(this.f5992bk.size()));
    }

    /* JADX INFO: renamed from: a */
    public C1098tx m6176a(@NotNull List<EnumC0758nc> list) {
        this.f5992bk = list;
        return this;
    }

    /* JADX INFO: renamed from: ch */
    public int m6177ch() {
        return this.f5988a;
    }

    @NotNull
    /* JADX INFO: renamed from: M */
    public ResourceLocation m6178M() {
        return this.f5989fI;
    }

    /* JADX INFO: renamed from: a */
    public C1097tw m6179a() {
        return this.f5990a;
    }

    public String getSkin() {
        return this.f5991dg;
    }

    /* JADX INFO: renamed from: r */
    public Map<C1093ts, ObjectList<C0837pB>> m6180r() {
        return Collections.unmodifiableMap(this.f5993ad);
    }

    /* JADX INFO: renamed from: f */
    public void m6181f(@NotNull Map<ResourceLocation, List<C0837pB>> map) {
        this.f5993ad.clear();
        for (Map.Entry<ResourceLocation, List<C0837pB>> entry : map.entrySet()) {
            C1093ts c1093tsM5999a = C1093ts.m5999a(entry.getKey());
            if (c1093tsM5999a != null) {
                this.f5993ad.put(c1093tsM5999a, new ObjectArrayList(entry.getValue()));
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Optional<Pair<C0837pB, C1093ts>> m6182a(boolean z) {
        return m6183a(z, pair -> {
            return true;
        });
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Optional<Pair<C0837pB, C1093ts>> m6183a(boolean z, @NotNull Predicate<Pair<C0837pB, C1093ts>> predicate) {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Pair<C0837pB, C1093ts> pairOf = null;
        ObjectArrayList objectArrayList = new ObjectArrayList(this.f5993ad.entrySet());
        while (true) {
            if (pairOf != null && predicate.test(pairOf) && (!z || ((C1093ts) pairOf.getRight()).m6006cc())) {
                break;
            }
            Map.Entry entry = (Map.Entry) objectArrayList.get(threadLocalRandomCurrent.nextInt(objectArrayList.size()));
            ObjectList objectList = (ObjectList) entry.getValue();
            pairOf = Pair.of((C0837pB) objectList.get(threadLocalRandomCurrent.nextInt(objectList.size())), (C1093ts) entry.getKey());
        }
        return Optional.of(pairOf);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0837pB m6184a(@NotNull C1093ts c1093ts, int i) {
        ObjectList<C0837pB> objectList = this.f5993ad.get(c1093ts);
        if (objectList == null || i >= objectList.size()) {
            return null;
        }
        return (C0837pB) objectList.get(i);
    }
}
