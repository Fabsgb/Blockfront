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

/* JADX INFO: renamed from: com.boehmod.blockfront.tw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tw.class */
public final class C1097tw implements StringRepresentable {

    /* JADX INFO: renamed from: bU */
    @NotNull
    public static final List<C1097tw> f5971bU = new ObjectArrayList();

    /* JADX INFO: renamed from: Z */
    @NotNull
    private static final Map<String, C1097tw> f5972Z = new LinkedHashMap();

    /* JADX INFO: renamed from: tt */
    private final int f5973tt = f5971bU.size();

    /* JADX INFO: renamed from: de */
    @NotNull
    private final String f5974de;

    /* JADX INFO: renamed from: df */
    @NotNull
    private final String f5975df;

    /* JADX INFO: renamed from: fD */
    @NotNull
    private final ResourceLocation f5976fD;

    /* JADX INFO: renamed from: bV */
    @NotNull
    private final List<ResourceLocation> f5977bV;

    /* JADX INFO: renamed from: bW */
    @NotNull
    private final List<ResourceLocation> f5978bW;

    /* JADX INFO: renamed from: aa */
    @NotNull
    private final Map<String, ItemStack> f5979aa;

    /* JADX INFO: renamed from: ab */
    @NotNull
    private final Map<String, Map<String, ItemStack>> f5980ab;

    /* JADX INFO: renamed from: bX */
    @NotNull
    private final List<String> f5981bX;

    /* JADX INFO: renamed from: fE */
    @Nullable
    private final ResourceLocation f5982fE;

    /* JADX INFO: renamed from: fF */
    @Nullable
    private final ResourceLocation f5983fF;

    /* JADX INFO: renamed from: fG */
    @Nullable
    private final ResourceLocation f5984fG;

    /* JADX INFO: renamed from: fH */
    @Nullable
    private final ResourceLocation f5985fH;

    static {
        C0616kt.m2804bz();
    }

    /* JADX INFO: renamed from: aZ */
    public static void m6152aZ() {
        f5971bU.clear();
        f5972Z.clear();
    }

    public C1097tw(@NotNull String str, @NotNull String str2, @NotNull List<ResourceLocation> list, @NotNull List<ResourceLocation> list2, @NotNull List<String> list3, @Nullable ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2, @Nullable ResourceLocation resourceLocation3, @Nullable ResourceLocation resourceLocation4, @NotNull Map<String, ItemStack> map, @NotNull Map<String, Map<String, ItemStack>> map2) {
        this.f5974de = str;
        this.f5975df = str2;
        this.f5976fD = C0532jO.m2378d("textures/misc/flag_" + str + ".png");
        this.f5977bV = List.copyOf(list);
        this.f5978bW = List.copyOf(list2);
        this.f5981bX = List.copyOf(list3);
        this.f5979aa = Map.copyOf(map);
        this.f5980ab = Map.copyOf(map2);
        this.f5982fE = resourceLocation;
        this.f5983fF = resourceLocation2;
        this.f5984fG = resourceLocation3;
        this.f5985fH = resourceLocation4;
        f5971bU.add(this);
        f5972Z.put(this.f5974de, this);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1097tw m6153a(@NotNull String str) {
        return f5972Z.get(str);
    }

    @NotNull
    /* JADX INFO: renamed from: ax */
    public static List<C1097tw> m6154ax() {
        return Collections.unmodifiableList(f5971bU);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1097tw m6155a(int i) {
        if (i < 0 || i >= f5971bU.size()) {
            return null;
        }
        return f5971bU.get(i);
    }

    /* JADX INFO: renamed from: cc */
    public int m6156cc() {
        return this.f5973tt;
    }

    @NotNull
    /* JADX INFO: renamed from: av */
    public String m6157av() {
        return this.f5974de;
    }

    @NotNull
    public String getName() {
        return this.f5975df;
    }

    @NotNull
    /* JADX INFO: renamed from: O */
    public ResourceLocation m6158O() {
        return this.f5976fD;
    }

    @NotNull
    public String getSerializedName() {
        return this.f5974de;
    }

    @NotNull
    /* JADX INFO: renamed from: aw */
    public String m6159aw() {
        return this.f5981bX.get(ThreadLocalRandom.current().nextInt(this.f5981bX.size()));
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public ItemStack m6160a(@NotNull String str) {
        return this.f5979aa.get(str);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Map<String, ItemStack> m6161a(@NotNull String str) {
        return this.f5980ab.getOrDefault(str, Map.of());
    }

    @NotNull
    /* JADX INFO: renamed from: q */
    public Map<String, Map<String, ItemStack>> m6162q() {
        return this.f5980ab;
    }

    @NotNull
    /* JADX INFO: renamed from: aF */
    public List<Supplier<? extends Item>> m6163aF() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (ResourceLocation resourceLocation : this.f5978bW) {
            for (DeferredHolder deferredHolder : C1308xv.f7668a.getEntries()) {
                if (deferredHolder.getId().equals(resourceLocation)) {
                    objectArrayList.add(deferredHolder);
                    break;
                }
            }
        }
        return Collections.unmodifiableList(objectArrayList);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1092tr m6164a() {
        if (this.f5977bV.isEmpty()) {
            return null;
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator<ResourceLocation> it = this.f5977bV.iterator();
        while (it.hasNext()) {
            C1092tr c1092trM5986a = C1092tr.m5986a(it.next());
            if (c1092trM5986a != null) {
                objectArrayList.add(c1092trM5986a);
            }
        }
        if (objectArrayList.isEmpty()) {
            return null;
        }
        return (C1092tr) C1267xG.m7152a((List) objectArrayList);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static DeferredHolder<SoundEvent, SoundEvent> m6165a(@Nullable ResourceLocation resourceLocation) {
        if (resourceLocation == null) {
            return null;
        }
        return (DeferredHolder) C1312xz.f7911h.get(resourceLocation.toString());
    }

    @Nullable
    /* JADX INFO: renamed from: k */
    public DeferredHolder<SoundEvent, SoundEvent> m6166k() {
        return m6165a(this.f5982fE);
    }

    @Nullable
    /* JADX INFO: renamed from: l */
    public DeferredHolder<SoundEvent, SoundEvent> m6167l() {
        return m6165a(this.f5983fF);
    }

    @Nullable
    /* JADX INFO: renamed from: m */
    public DeferredHolder<SoundEvent, SoundEvent> m6168m() {
        return m6165a(this.f5984fG);
    }

    @Nullable
    /* JADX INFO: renamed from: n */
    public DeferredHolder<SoundEvent, SoundEvent> m6169n() {
        return m6165a(this.f5985fH);
    }
}
