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

/* JADX INFO: renamed from: com.boehmod.blockfront.ka, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ka.class */
public class C0271ka extends jY<C0474ro> {
    private static final String bd = "game/team_types";
    private static final String be = "game/class_templates";

    @NotNull
    private final Map<ResourceLocation, C0474ro> E;

    public C0271ka(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
        this.E = new Object2ObjectLinkedOpenHashMap();
    }

    @Override // com.boehmod.blockfront.jY
    @NotNull
    protected String z() {
        return bd;
    }

    @Override // com.boehmod.blockfront.jY
    @NotNull
    protected Codec<C0474ro> a() {
        return C0474ro.X;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.jY
    @NotNull
    public ResourceLocation a(@NotNull C0474ro c0474ro, @NotNull ResourceLocation resourceLocation) {
        String path = resourceLocation.getPath();
        return C0265jv.d(path.substring(path.lastIndexOf(47) + 1, path.lastIndexOf(46)));
    }

    @NotNull
    public Map<ResourceLocation, C0474ro> k() {
        return Collections.unmodifiableMap(this.E);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, C0474ro> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.E.clear();
        this.E.putAll(map);
        b(map, (Map<ResourceLocation, C0406pa>) a(resourceManager, be, C0406pa.u, C0271ka::a));
    }

    private static void b(@NotNull Map<ResourceLocation, C0474ro> map, @NotNull Map<ResourceLocation, C0406pa> map2) {
        C0514ta.aR();
        e(map2);
        for (Map.Entry<ResourceLocation, C0474ro> entry : map.entrySet()) {
            C0474ro value = entry.getValue();
            sZ sZVarA = sZ.a(value.af());
            if (sZVarA == null) {
                C0263jt.logError("Unknown nation '%s' for team type '%s'", value.af(), entry.getKey());
            } else {
                C0514ta c0514ta = new C0514ta(value.bA(), sZVarA, value.ag());
                ObjectArrayList objectArrayList = new ObjectArrayList();
                for (String str : value.aj()) {
                    try {
                        objectArrayList.add(mG.valueOf(str.toUpperCase(Locale.ROOT)));
                    } catch (IllegalArgumentException e) {
                        C0263jt.logError("Unknown race '%s' for team type '%s'", str, entry.getKey());
                    }
                }
                if (!objectArrayList.isEmpty()) {
                    c0514ta.a((List<mG>) objectArrayList);
                }
                Map<ResourceLocation, List<C0411pf>> mapN = value.n();
                if (mapN.isEmpty() && value.m().isPresent()) {
                    C0474ro c0474ro = map.get(value.m().get());
                    if (c0474ro != null) {
                        mapN = c0474ro.n();
                    } else {
                        C0263jt.logError("Team type '%s' inherits from '%s' which was not found", entry.getKey(), value.m().get());
                    }
                }
                c0514ta.f(a(mapN, map2, sZVarA));
            }
        }
        C0263jt.log("Created %d team type(s) from data", Integer.valueOf(map.size()));
    }

    @NotNull
    private static Map<ResourceLocation, List<C0411pf>> a(@NotNull Map<ResourceLocation, List<C0411pf>> map, @NotNull Map<ResourceLocation, C0406pa> map2, @NotNull sZ sZVar) {
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        for (Map.Entry<ResourceLocation, List<C0411pf>> entry : map.entrySet()) {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            Iterator<C0411pf> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectArrayList.add(a(it.next(), map2, sZVar));
            }
            object2ObjectLinkedOpenHashMap.put(entry.getKey(), objectArrayList);
        }
        return object2ObjectLinkedOpenHashMap;
    }

    @NotNull
    private static C0411pf a(@NotNull C0411pf c0411pf, @NotNull Map<ResourceLocation, C0406pa> map, @NotNull sZ sZVar) {
        String strA = c0411pf.A();
        if (strA == null) {
            return c0411pf;
        }
        C0406pa c0406pa = map.get(C0265jv.d(strA));
        if (c0406pa == null) {
            C0263jt.logError("Loadout references unknown class template '%s'", strA);
            return c0411pf;
        }
        C0411pf c0411pfA = c0406pa.a(sZVar, sZVar.m1106a(strA));
        C0411pf c0411pf2 = new C0411pf();
        Iterator<ItemStack> it = c0411pfA.G().iterator();
        while (it.hasNext()) {
            c0411pf2.e(it.next().copy());
        }
        Iterator<ItemStack> it2 = c0411pf.G().iterator();
        while (it2.hasNext()) {
            c0411pf2.e(it2.next().copy());
        }
        c0411pf2.b(c0411pf.bl() != 0 ? c0411pf.bl() : c0411pfA.bl());
        c0411pf2.a(c0411pf.bk() != 0 ? c0411pf.bk() : c0411pfA.bk());
        return c0411pf2;
    }

    private static void e(@NotNull Map<ResourceLocation, C0406pa> map) {
        for (sZ sZVar : sZ.av()) {
            for (Map.Entry<String, Map<String, ItemStack>> entry : sZVar.q().entrySet()) {
                String key = entry.getKey();
                C0406pa c0406pa = map.get(C0265jv.d(key));
                if (c0406pa == null) {
                    C0263jt.logError("Nation '%s' weaponOverrides references unknown template '%s'", sZVar.ao(), key);
                } else {
                    for (String str : entry.getValue().keySet()) {
                        if (!c0406pa.D().stream().anyMatch(c0415pj -> {
                            return str.equals(c0415pj.N());
                        })) {
                            C0263jt.logError("Nation '%s' weaponOverrides for template '%s' targets role '%s' which no slot uses", sZVar.ao(), key, str);
                        }
                    }
                }
            }
        }
    }

    @NotNull
    private static ResourceLocation a(@NotNull C0406pa c0406pa, @NotNull ResourceLocation resourceLocation) {
        String path = resourceLocation.getPath();
        return C0265jv.d(path.substring(path.lastIndexOf(47) + 1, path.lastIndexOf(46)));
    }

    public static void bo() {
        b((Map<ResourceLocation, C0474ro>) a((Class<?>) C0271ka.class, bd, C0474ro.X, (c0474ro, str) -> {
            return C0265jv.d(str);
        }), (Map<ResourceLocation, C0406pa>) a((Class<?>) C0271ka.class, be, C0406pa.u, (c0406pa, str2) -> {
            return C0265jv.d(str2);
        }));
    }
}
