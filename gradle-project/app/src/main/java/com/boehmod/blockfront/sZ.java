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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sZ.class */
public final class sZ implements StringRepresentable {

    @NotNull
    public static final List<sZ> bN = new ObjectArrayList();

    @NotNull
    private static final Map<String, sZ> Z = new LinkedHashMap();
    private final int rs = bN.size();

    @NotNull
    private final String cU;

    @NotNull
    private final String cV;

    @NotNull
    private final ResourceLocation fE;

    @NotNull
    private final List<ResourceLocation> bO;

    @NotNull
    private final List<ResourceLocation> bP;

    @NotNull
    private final Map<String, ItemStack> aa;

    @NotNull
    private final Map<String, Map<String, ItemStack>> ab;

    @NotNull
    private final List<String> bQ;

    @Nullable
    private final ResourceLocation fF;

    @Nullable
    private final ResourceLocation fG;

    @Nullable
    private final ResourceLocation fH;

    @Nullable
    private final ResourceLocation fI;

    static {
        jX.bo();
    }

    public static void aR() {
        bN.clear();
        Z.clear();
    }

    public sZ(@NotNull String str, @NotNull String str2, @NotNull List<ResourceLocation> list, @NotNull List<ResourceLocation> list2, @NotNull List<String> list3, @Nullable ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2, @Nullable ResourceLocation resourceLocation3, @Nullable ResourceLocation resourceLocation4, @NotNull Map<String, ItemStack> map, @NotNull Map<String, Map<String, ItemStack>> map2) {
        this.cU = str;
        this.cV = str2;
        this.fE = C0265jv.d("textures/misc/flag_" + str + ".png");
        this.bO = List.copyOf(list);
        this.bP = List.copyOf(list2);
        this.bQ = List.copyOf(list3);
        this.aa = Map.copyOf(map);
        this.ab = Map.copyOf(map2);
        this.fF = resourceLocation;
        this.fG = resourceLocation2;
        this.fH = resourceLocation3;
        this.fI = resourceLocation4;
        bN.add(this);
        Z.put(this.cU, this);
    }

    @Nullable
    public static sZ a(@NotNull String str) {
        return Z.get(str);
    }

    @NotNull
    public static List<sZ> av() {
        return Collections.unmodifiableList(bN);
    }

    @Nullable
    public static sZ a(int i) {
        if (i < 0 || i >= bN.size()) {
            return null;
        }
        return bN.get(i);
    }

    public int bN() {
        return this.rs;
    }

    @NotNull
    public String ao() {
        return this.cU;
    }

    @NotNull
    public String getName() {
        return this.cV;
    }

    @NotNull
    public ResourceLocation N() {
        return this.fE;
    }

    @NotNull
    public String getSerializedName() {
        return this.cU;
    }

    @NotNull
    public String ap() {
        return this.bQ.get(ThreadLocalRandom.current().nextInt(this.bQ.size()));
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ItemStack m1105a(@NotNull String str) {
        return this.aa.get(str);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, ItemStack> m1106a(@NotNull String str) {
        return this.ab.getOrDefault(str, Map.of());
    }

    @NotNull
    public Map<String, Map<String, ItemStack>> q() {
        return this.ab;
    }

    @NotNull
    public List<Supplier<? extends Item>> aD() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (ResourceLocation resourceLocation : this.bP) {
            Iterator it = wY.a.getEntries().iterator();
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
    public sU a() {
        if (this.bO.isEmpty()) {
            return null;
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator<ResourceLocation> it = this.bO.iterator();
        while (it.hasNext()) {
            sU sUVarA = sU.a(it.next());
            if (sUVarA != null) {
                objectArrayList.add(sUVarA);
            }
        }
        if (objectArrayList.isEmpty()) {
            return null;
        }
        return (sU) C0631xj.a((List) objectArrayList);
    }

    @Nullable
    private static DeferredHolder<SoundEvent, SoundEvent> a(@Nullable ResourceLocation resourceLocation) {
        if (resourceLocation == null) {
            return null;
        }
        return (DeferredHolder) C0624xc.h.get(resourceLocation.toString());
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> k() {
        return a(this.fF);
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> l() {
        return a(this.fG);
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> m() {
        return a(this.fH);
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> n() {
        return a(this.fI);
    }
}
