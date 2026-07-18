package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ka */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ka.class */
public class C0596ka extends AbstractC0541jY<C0981ro> {

    /* JADX INFO: renamed from: bd */
    private static final String f3297bd = "game/team_types";

    /* JADX INFO: renamed from: be */
    private static final String f3298be = "game/class_templates";

    /* JADX INFO: renamed from: E */
    @NotNull
    private final Map<ResourceLocation, C0981ro> f3299E;

    public C0596ka(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
        this.f3299E = new Object2ObjectLinkedOpenHashMap();
    }

    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: z */
    protected String mo2406z() {
        return f3297bd;
    }

    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Codec<C0981ro> mo2407a() {
        return C0981ro.f5214X;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0541jY
    @NotNull
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public ResourceLocation mo2412a(@NotNull C0981ro c0981ro, @NotNull ResourceLocation resourceLocation) {
        String path = resourceLocation.getPath();
        return C0564jv.m2555d(path.substring(path.lastIndexOf(47) + 1, path.lastIndexOf(46)));
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public Map<ResourceLocation, C0981ro> m2612k() {
        return Collections.unmodifiableMap(this.f3299E);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, C0981ro> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.f3299E.clear();
        this.f3299E.putAll(map);
        m2614b(map, (Map<ResourceLocation, C0861pa>) m2449a(resourceManager, f3298be, C0861pa.f4507u, C0596ka::m2618a));
    }

    /* JADX INFO: renamed from: b */
    private static void m2614b(@NotNull Map<ResourceLocation, C0981ro> map, @NotNull Map<ResourceLocation, C0861pa> map2) {
        C1074ta.m5967aR();
        m2617e(map2);
        for (Map.Entry<ResourceLocation, C0981ro> entry : map.entrySet()) {
            C0981ro value = entry.getValue();
            C1019sZ c1019sZM5665a = C1019sZ.m5665a(value.m5410af());
            if (c1019sZM5665a == null) {
                C0562jt.logError("Unknown nation '%s' for team type '%s'", value.m5410af(), entry.getKey());
            } else {
                C1074ta c1074ta = new C1074ta(value.m5409bA(), c1019sZM5665a, value.m5411ag());
                ObjectArrayList objectArrayList = new ObjectArrayList();
                for (String str : value.m5412aj()) {
                    try {
                        objectArrayList.add(EnumC0682mG.valueOf(str.toUpperCase(Locale.ROOT)));
                    } catch (IllegalArgumentException e) {
                        C0562jt.logError("Unknown race '%s' for team type '%s'", str, entry.getKey());
                    }
                }
                if (!objectArrayList.isEmpty()) {
                    c1074ta.m5973a((List<EnumC0682mG>) objectArrayList);
                }
                Map<ResourceLocation, List<C0866pf>> mapM5413n = value.m5413n();
                if (mapM5413n.isEmpty() && value.m5414m().isPresent()) {
                    C0981ro c0981ro = map.get(value.m5414m().get());
                    if (c0981ro != null) {
                        mapM5413n = c0981ro.m5413n();
                    } else {
                        C0562jt.logError("Team type '%s' inherits from '%s' which was not found", entry.getKey(), value.m5414m().get());
                    }
                }
                c1074ta.m5978f(m2615a(mapM5413n, map2, c1019sZM5665a));
            }
        }
        C0562jt.log("Created %d team type(s) from data", Integer.valueOf(map.size()));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Map<ResourceLocation, List<C0866pf>> m2615a(@NotNull Map<ResourceLocation, List<C0866pf>> map, @NotNull Map<ResourceLocation, C0861pa> map2, @NotNull C1019sZ c1019sZ) {
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        for (Map.Entry<ResourceLocation, List<C0866pf>> entry : map.entrySet()) {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            Iterator<C0866pf> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectArrayList.add(m2616a(it.next(), map2, c1019sZ));
            }
            object2ObjectLinkedOpenHashMap.put(entry.getKey(), objectArrayList);
        }
        return object2ObjectLinkedOpenHashMap;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static C0866pf m2616a(@NotNull C0866pf c0866pf, @NotNull Map<ResourceLocation, C0861pa> map, @NotNull C1019sZ c1019sZ) {
        String strM4335A = c0866pf.m4335A();
        if (strM4335A == null) {
            return c0866pf;
        }
        C0861pa c0861pa = map.get(C0564jv.m2555d(strM4335A));
        if (c0861pa == null) {
            C0562jt.logError("Loadout references unknown class template '%s'", strM4335A);
            return c0866pf;
        }
        C0866pf c0866pfM4289a = c0861pa.m4289a(c1019sZ, c1019sZ.m5673a(strM4335A));
        C0866pf c0866pf2 = new C0866pf();
        Iterator<ItemStack> it = c0866pfM4289a.m4347G().iterator();
        while (it.hasNext()) {
            c0866pf2.m4330e(it.next().copy());
        }
        Iterator<ItemStack> it2 = c0866pf.m4347G().iterator();
        while (it2.hasNext()) {
            c0866pf2.m4330e(it2.next().copy());
        }
        c0866pf2.m4334b(c0866pf.m4333bl() != 0 ? c0866pf.m4333bl() : c0866pfM4289a.m4333bl());
        c0866pf2.m4332a(c0866pf.m4331bk() != 0 ? c0866pf.m4331bk() : c0866pfM4289a.m4331bk());
        return c0866pf2;
    }

    /* JADX INFO: renamed from: e */
    private static void m2617e(@NotNull Map<ResourceLocation, C0861pa> map) {
        for (C1019sZ c1019sZ : C1019sZ.m5666av()) {
            for (Map.Entry<String, Map<String, ItemStack>> entry : c1019sZ.m5674q().entrySet()) {
                String key = entry.getKey();
                C0861pa c0861pa = map.get(C0564jv.m2555d(key));
                if (c0861pa == null) {
                    C0562jt.logError("Nation '%s' weaponOverrides references unknown template '%s'", c1019sZ.m5669ao(), key);
                } else {
                    for (String str : entry.getValue().keySet()) {
                        if (!c0861pa.m4291D().stream().anyMatch(c0870pj -> {
                            return str.equals(c0870pj.m4375N());
                        })) {
                            C0562jt.logError("Nation '%s' weaponOverrides for template '%s' targets role '%s' which no slot uses", c1019sZ.m5669ao(), key, str);
                        }
                    }
                }
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ResourceLocation m2618a(@NotNull C0861pa c0861pa, @NotNull ResourceLocation resourceLocation) {
        String path = resourceLocation.getPath();
        return C0564jv.m2555d(path.substring(path.lastIndexOf(47) + 1, path.lastIndexOf(46)));
    }

    /* JADX INFO: renamed from: bo */
    public static void m2619bo() {
        m2614b((Map<ResourceLocation, C0981ro>) m2450a((Class<?>) C0596ka.class, f3297bd, C0981ro.f5214X, (c0981ro, str) -> {
            return C0564jv.m2555d(str);
        }), (Map<ResourceLocation, C0861pa>) m2450a((Class<?>) C0596ka.class, f3298be, C0861pa.f4507u, (c0861pa, str2) -> {
            return C0564jv.m2555d(str2);
        }));
    }
}
