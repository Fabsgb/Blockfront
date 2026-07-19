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

/* JADX INFO: renamed from: com.boehmod.blockfront.ta, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ta.class */
public final class C0514ta {

    @NotNull
    public static final List<C0514ta> bR = new ObjectArrayList();

    @NotNull
    private static final Map<ResourceLocation, C0514ta> ac = new LinkedHashMap();
    public final byte a;

    @NotNull
    private final ResourceLocation fJ;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final sZ f302a;
    private final String cW;
    private List<mG> bd = List.of(mG.CAUCASIAN);
    private final Map<sV, ObjectList<C0411pf>> ad = new LinkedHashMap();

    static {
        C0271ka.bo();
    }

    public static void aR() {
        bR.clear();
        ac.clear();
    }

    public C0514ta(int i, @NotNull sZ sZVar, @NotNull String str) {
        this.a = (byte) i;
        this.f302a = sZVar;
        this.cW = str;
        this.fJ = C0265jv.d(sZVar.ao() + "_" + str);
        bR.add(this);
        ac.put(this.fJ, this);
    }

    @Nullable
    public static C0514ta b(@NotNull ResourceLocation resourceLocation) {
        return ac.get(resourceLocation);
    }

    @Nullable
    public static C0514ta a(@NotNull String str) {
        return ac.get(C0265jv.d(str));
    }

    @NotNull
    public static C0514ta g() {
        C0514ta c0514ta = null;
        while (c0514ta == null) {
            c0514ta = bR.get(ThreadLocalRandom.current().nextInt(bR.size()));
            if (c0514ta.a(sV.c(), 0) == null) {
                c0514ta = null;
            }
        }
        return c0514ta;
    }

    @Nullable
    public static C0514ta a(@NotNull sZ sZVar, @NotNull String str) {
        for (C0514ta c0514ta : bR) {
            if (c0514ta.f302a.ao().equals(sZVar.ao()) && c0514ta.cW.equals(str)) {
                return c0514ta;
            }
        }
        return null;
    }

    @NotNull
    public mG a() {
        return this.bd.get(ThreadLocalRandom.current().nextInt(this.bd.size()));
    }

    public C0514ta a(@NotNull List<mG> list) {
        this.bd = list;
        return this;
    }

    public int bS() {
        return this.a;
    }

    @NotNull
    public ResourceLocation L() {
        return this.fJ;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public sZ m1156a() {
        return this.f302a;
    }

    public String getSkin() {
        return this.cW;
    }

    public Map<sV, ObjectList<C0411pf>> r() {
        return Collections.unmodifiableMap(this.ad);
    }

    public void f(@NotNull Map<ResourceLocation, List<C0411pf>> map) {
        this.ad.clear();
        for (Map.Entry<ResourceLocation, List<C0411pf>> entry : map.entrySet()) {
            sV sVVarA = sV.a(entry.getKey());
            if (sVVarA != null) {
                this.ad.put(sVVarA, new ObjectArrayList(entry.getValue()));
            }
        }
    }

    @NotNull
    public Optional<Pair<C0411pf, sV>> a(boolean z) {
        return a(z, pair -> {
            return true;
        });
    }

    @NotNull
    public Optional<Pair<C0411pf, sV>> a(boolean z, @NotNull Predicate<Pair<C0411pf, sV>> predicate) {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Pair<C0411pf, sV> pairOf = null;
        ObjectArrayList objectArrayList = new ObjectArrayList(this.ad.entrySet());
        while (true) {
            if (pairOf != null && predicate.test(pairOf) && (!z || ((sV) pairOf.getRight()).bS())) {
                break;
            }
            Map.Entry entry = (Map.Entry) objectArrayList.get(threadLocalRandomCurrent.nextInt(objectArrayList.size()));
            ObjectList objectList = (ObjectList) entry.getValue();
            pairOf = Pair.of((C0411pf) objectList.get(threadLocalRandomCurrent.nextInt(objectList.size())), (sV) entry.getKey());
        }
        return Optional.of(pairOf);
    }

    @Nullable
    public C0411pf a(@NotNull sV sVVar, int i) {
        ObjectList<C0411pf> objectList = this.ad.get(sVVar);
        if (objectList == null || i >= objectList.size()) {
            return null;
        }
        return (C0411pf) objectList.get(i);
    }
}
