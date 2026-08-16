package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCallingCard;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCape;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCoin;
import com.boehmod.bflib.cloud.common.item.types.CloudItemGun;
import com.boehmod.bflib.cloud.common.item.types.CloudItemMelee;
import com.boehmod.bflib.cloud.common.item.types.CloudItemPrestigeCard;
import com.boehmod.bflib.cloud.common.item.types.CloudItemSticker;
import com.boehmod.bflib.cloud.common.item.types.CloudItemTrophy;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ju */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ju.class */
public class C0564ju {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final AbstractC0563jt<?> f3321a = new C0566jw();

    /* JADX INFO: renamed from: p */
    @NotNull
    private static final Map<Class<? extends CloudItem<?>>, AbstractC0563jt<?>> f3322p = new Object2ObjectOpenHashMap();

    static {
        m2555a(CloudItemCallingCard.class, new C0561jr());
        m2555a(CloudItemCape.class, new C0562js());
        m2555a(CloudItemTrophy.class, new C0519jB());
        m2555a(CloudItemCoin.class, new C0565jv());
        m2555a(CloudItemGun.class, new C0567jx());
        m2555a(CloudItemMelee.class, new C0568jy());
        m2555a(CloudItemSticker.class, new C0518jA());
        m2555a(CloudItemPrestigeCard.class, new C0569jz());
    }

    /* JADX INFO: renamed from: a */
    public static void m2555a(@NotNull Class<? extends CloudItem<?>> cls, @NotNull AbstractC0563jt<? extends CloudItem<?>> abstractC0563jt) {
        f3322p.put(cls, abstractC0563jt);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static AbstractC0563jt<?> m2556a(@NotNull CloudItem<?> cloudItem) {
        return f3322p.getOrDefault(cloudItem.getClass(), f3321a);
    }
}
