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

/* JADX INFO: renamed from: com.boehmod.blockfront.kw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kw.class */
public class C0619kw extends AbstractC0617ku<C0953rL> {

    /* JADX INFO: renamed from: bm */
    private static final String f3544bm = "game/team_types";

    /* JADX INFO: renamed from: bn */
    private static final String f3545bn = "game/class_templates";

    /* JADX INFO: renamed from: E */
    @NotNull
    private final Map<ResourceLocation, C0953rL> f3546E;

    public C0619kw(@NotNull ResourceManager resourceManager) {
        super(resourceManager);
        this.f3546E = new Object2ObjectLinkedOpenHashMap();
    }

    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: G */
    protected String mo2768G() {
        return f3544bm;
    }

    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Codec<C0953rL> mo2769a() {
        return C0953rL.f5318X;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0617ku
    @NotNull
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public ResourceLocation mo2774a(@NotNull C0953rL c0953rL, @NotNull ResourceLocation resourceLocation) {
        String path = resourceLocation.getPath();
        return C0532jO.m2378d(path.substring(path.lastIndexOf(47) + 1, path.lastIndexOf(46)));
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public Map<ResourceLocation, C0953rL> m2824k() {
        return Collections.unmodifiableMap(this.f3546E);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(@NotNull Map<ResourceLocation, C0953rL> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.f3546E.clear();
        this.f3546E.putAll(map);
        m2826b(map, (Map<ResourceLocation, C0884pw>) m2808a(resourceManager, f3545bn, C0884pw.f4840u, C0619kw::m2830a));
    }

    /* JADX INFO: renamed from: b */
    private static void m2826b(@NotNull Map<ResourceLocation, C0953rL> map, @NotNull Map<ResourceLocation, C0884pw> map2) {
        C1098tx.m6170aZ();
        m2829e(map2);
        for (Map.Entry<ResourceLocation, C0953rL> entry : map.entrySet()) {
            C0953rL value = entry.getValue();
            C1097tw c1097twM6153a = C1097tw.m6153a(value.m5286am());
            if (c1097twM6153a == null) {
                C0530jM.logError("Unknown nation '%s' for team type '%s'", value.m5286am(), entry.getKey());
            } else {
                C1098tx c1098tx = new C1098tx(value.m5285bP(), c1097twM6153a, value.m5287an());
                ObjectArrayList objectArrayList = new ObjectArrayList();
                for (String str : value.m5288al()) {
                    try {
                        objectArrayList.add(EnumC0758nc.valueOf(str.toUpperCase(Locale.ROOT)));
                    } catch (IllegalArgumentException e) {
                        C0530jM.logError("Unknown race '%s' for team type '%s'", str, entry.getKey());
                    }
                }
                if (!objectArrayList.isEmpty()) {
                    c1098tx.m6176a((List<EnumC0758nc>) objectArrayList);
                }
                Map<ResourceLocation, List<C0837pB>> mapM5289n = value.m5289n();
                if (mapM5289n.isEmpty() && value.m5290m().isPresent()) {
                    C0953rL c0953rL = map.get(value.m5290m().get());
                    if (c0953rL != null) {
                        mapM5289n = c0953rL.m5289n();
                    } else {
                        C0530jM.logError("Team type '%s' inherits from '%s' which was not found", entry.getKey(), value.m5290m().get());
                    }
                }
                c1098tx.m6181f(m2827a(mapM5289n, map2, c1097twM6153a));
            }
        }
        C0530jM.log("Created %d team type(s) from data", Integer.valueOf(map.size()));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Map<ResourceLocation, List<C0837pB>> m2827a(@NotNull Map<ResourceLocation, List<C0837pB>> map, @NotNull Map<ResourceLocation, C0884pw> map2, @NotNull C1097tw c1097tw) {
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        for (Map.Entry<ResourceLocation, List<C0837pB>> entry : map.entrySet()) {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            Iterator<C0837pB> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectArrayList.add(m2828a(it.next(), map2, c1097tw));
            }
            object2ObjectLinkedOpenHashMap.put(entry.getKey(), objectArrayList);
        }
        return object2ObjectLinkedOpenHashMap;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static C0837pB m2828a(@NotNull C0837pB c0837pB, @NotNull Map<ResourceLocation, C0884pw> map, @NotNull C1097tw c1097tw) {
        String strM3820H = c0837pB.m3820H();
        if (strM3820H == null) {
            return c0837pB;
        }
        C0884pw c0884pw = map.get(C0532jO.m2378d(strM3820H));
        if (c0884pw == null) {
            C0530jM.logError("Loadout references unknown class template '%s'", strM3820H);
            return c0837pB;
        }
        C0837pB c0837pBM4614a = c0884pw.m4614a(c1097tw, c1097tw.m6161a(strM3820H));
        C0837pB c0837pB2 = new C0837pB();
        Iterator<ItemStack> it = c0837pBM4614a.m3832I().iterator();
        while (it.hasNext()) {
            c0837pB2.m3815e(it.next().copy());
        }
        Iterator<ItemStack> it2 = c0837pB.m3832I().iterator();
        while (it2.hasNext()) {
            c0837pB2.m3815e(it2.next().copy());
        }
        c0837pB2.m3819b(c0837pB.m3818bA() != 0 ? c0837pB.m3818bA() : c0837pBM4614a.m3818bA());
        c0837pB2.m3817a(c0837pB.m3816bz() != 0 ? c0837pB.m3816bz() : c0837pBM4614a.m3816bz());
        return c0837pB2;
    }

    /* JADX INFO: renamed from: e */
    private static void m2829e(@NotNull Map<ResourceLocation, C0884pw> map) {
        for (C1097tw c1097tw : C1097tw.m6154ax()) {
            for (Map.Entry<String, Map<String, ItemStack>> entry : c1097tw.m6162q().entrySet()) {
                String key = entry.getKey();
                C0884pw c0884pw = map.get(C0532jO.m2378d(key));
                if (c0884pw == null) {
                    C0530jM.logError("Nation '%s' weaponOverrides references unknown template '%s'", c1097tw.m6157av(), key);
                } else {
                    for (String str : entry.getValue().keySet()) {
                        if (!c0884pw.m4616F().stream().anyMatch(c0841pF -> {
                            return str.equals(c0841pF.m3861U());
                        })) {
                            C0530jM.logError("Nation '%s' weaponOverrides for template '%s' targets role '%s' which no slot uses", c1097tw.m6157av(), key, str);
                        }
                    }
                }
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ResourceLocation m2830a(@NotNull C0884pw c0884pw, @NotNull ResourceLocation resourceLocation) {
        String path = resourceLocation.getPath();
        return C0532jO.m2378d(path.substring(path.lastIndexOf(47) + 1, path.lastIndexOf(46)));
    }

    /* JADX INFO: renamed from: bz */
    public static void m2831bz() {
        m2826b((Map<ResourceLocation, C0953rL>) m2809a((Class<?>) C0619kw.class, f3544bm, C0953rL.f5318X, (c0953rL, str) -> {
            return C0532jO.m2378d(str);
        }), (Map<ResourceLocation, C0884pw>) m2809a((Class<?>) C0619kw.class, f3545bn, C0884pw.f4840u, (c0884pw, str2) -> {
            return C0532jO.m2378d(str2);
        }));
    }
}
