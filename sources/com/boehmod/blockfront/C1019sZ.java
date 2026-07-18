package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sZ.class */
public final class C1019sZ implements StringRepresentable {

    /* JADX INFO: renamed from: bN */
    @NotNull
    public static final List<C1019sZ> f5407bN = new ObjectArrayList();

    /* JADX INFO: renamed from: Z */
    @NotNull
    private static final Map<String, C1019sZ> f5408Z = new LinkedHashMap();

    /* JADX INFO: renamed from: rs */
    private final int f5409rs = f5407bN.size();

    /* JADX INFO: renamed from: cU */
    @NotNull
    private final String f5410cU;

    /* JADX INFO: renamed from: cV */
    @NotNull
    private final String f5411cV;

    /* JADX INFO: renamed from: fE */
    @NotNull
    private final ResourceLocation f5412fE;

    /* JADX INFO: renamed from: bO */
    @NotNull
    private final List<ResourceLocation> f5413bO;

    /* JADX INFO: renamed from: bP */
    @NotNull
    private final List<ResourceLocation> f5414bP;

    /* JADX INFO: renamed from: aa */
    @NotNull
    private final Map<String, ItemStack> f5415aa;

    /* JADX INFO: renamed from: ab */
    @NotNull
    private final Map<String, Map<String, ItemStack>> f5416ab;

    /* JADX INFO: renamed from: bQ */
    @NotNull
    private final List<String> f5417bQ;

    /* JADX INFO: renamed from: fF */
    @Nullable
    private final ResourceLocation f5418fF;

    /* JADX INFO: renamed from: fG */
    @Nullable
    private final ResourceLocation f5419fG;

    /* JADX INFO: renamed from: fH */
    @Nullable
    private final ResourceLocation f5420fH;

    /* JADX INFO: renamed from: fI */
    @Nullable
    private final ResourceLocation f5421fI;

    static {
        C0540jX.m2445bo();
    }

    /* JADX INFO: renamed from: aR */
    public static void m5664aR() {
        f5407bN.clear();
        f5408Z.clear();
    }

    public C1019sZ(@NotNull String str, @NotNull String str2, @NotNull List<ResourceLocation> list, @NotNull List<ResourceLocation> list2, @NotNull List<String> list3, @Nullable ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2, @Nullable ResourceLocation resourceLocation3, @Nullable ResourceLocation resourceLocation4, @NotNull Map<String, ItemStack> map, @NotNull Map<String, Map<String, ItemStack>> map2) {
        this.f5410cU = str;
        this.f5411cV = str2;
        this.f5412fE = C0564jv.m2555d("textures/misc/flag_" + str + ".png");
        this.f5413bO = List.copyOf(list);
        this.f5414bP = List.copyOf(list2);
        this.f5417bQ = List.copyOf(list3);
        this.f5415aa = Map.copyOf(map);
        this.f5416ab = Map.copyOf(map2);
        this.f5418fF = resourceLocation;
        this.f5419fG = resourceLocation2;
        this.f5420fH = resourceLocation3;
        this.f5421fI = resourceLocation4;
        f5407bN.add(this);
        f5408Z.put(this.f5410cU, this);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1019sZ m5665a(@NotNull String str) {
        return f5408Z.get(str);
    }

    @NotNull
    /* JADX INFO: renamed from: av */
    public static List<C1019sZ> m5666av() {
        return Collections.unmodifiableList(f5407bN);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1019sZ m5667a(int i) {
        if (i < 0 || i >= f5407bN.size()) {
            return null;
        }
        return f5407bN.get(i);
    }

    /* JADX INFO: renamed from: bN */
    public int m5668bN() {
        return this.f5409rs;
    }

    @NotNull
    /* JADX INFO: renamed from: ao */
    public String m5669ao() {
        return this.f5410cU;
    }

    @NotNull
    public String getName() {
        return this.f5411cV;
    }

    @NotNull
    /* JADX INFO: renamed from: N */
    public ResourceLocation m5670N() {
        return this.f5412fE;
    }

    @NotNull
    public String getSerializedName() {
        return this.f5410cU;
    }

    @NotNull
    /* JADX INFO: renamed from: ap */
    public String m5671ap() {
        return this.f5417bQ.get(ThreadLocalRandom.current().nextInt(this.f5417bQ.size()));
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public ItemStack m5672a(@NotNull String str) {
        return this.f5415aa.get(str);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Map<String, ItemStack> m5673a(@NotNull String str) {
        return this.f5416ab.getOrDefault(str, Map.of());
    }

    @NotNull
    /* JADX INFO: renamed from: q */
    public Map<String, Map<String, ItemStack>> m5674q() {
        return this.f5416ab;
    }

    @NotNull
    /* JADX INFO: renamed from: aD */
    public List<Supplier<? extends Item>> m5675aD() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (ResourceLocation resourceLocation : this.f5414bP) {
            Iterator it = C1231wY.f7103a.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    DeferredHolder deferredHolder = (DeferredHolder) it.next();
                    if (deferredHolder.getId().equals(resourceLocation)) {
                        objectArrayList.add(deferredHolder);
                        break;
                    }
                }
            }
        }
        return Collections.unmodifiableList(objectArrayList);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1014sU m5676a() {
        if (this.f5413bO.isEmpty()) {
            return null;
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator<ResourceLocation> it = this.f5413bO.iterator();
        while (it.hasNext()) {
            C1014sU c1014sUM5498a = C1014sU.m5498a(it.next());
            if (c1014sUM5498a != null) {
                objectArrayList.add(c1014sUM5498a);
            }
        }
        if (objectArrayList.isEmpty()) {
            return null;
        }
        return (C1014sU) C1287xj.m7828a((List) objectArrayList);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static DeferredHolder<SoundEvent, SoundEvent> m5677a(@Nullable ResourceLocation resourceLocation) {
        if (resourceLocation == null) {
            return null;
        }
        return (DeferredHolder) C1280xc.f7499h.get(resourceLocation.toString());
    }

    @Nullable
    /* JADX INFO: renamed from: k */
    public DeferredHolder<SoundEvent, SoundEvent> m5678k() {
        return m5677a(this.f5418fF);
    }

    @Nullable
    /* JADX INFO: renamed from: l */
    public DeferredHolder<SoundEvent, SoundEvent> m5679l() {
        return m5677a(this.f5419fG);
    }

    @Nullable
    /* JADX INFO: renamed from: m */
    public DeferredHolder<SoundEvent, SoundEvent> m5680m() {
        return m5677a(this.f5420fH);
    }

    @Nullable
    /* JADX INFO: renamed from: n */
    public DeferredHolder<SoundEvent, SoundEvent> m5681n() {
        return m5677a(this.f5421fI);
    }
}
