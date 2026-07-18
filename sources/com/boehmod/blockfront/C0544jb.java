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

/* JADX INFO: renamed from: com.boehmod.blockfront.jb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jb.class */
public class C0544jb {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final AbstractC0543ja<?> f3166a = new C0546jd();

    /* JADX INFO: renamed from: p */
    @NotNull
    private static final Map<Class<? extends CloudItem<?>>, AbstractC0543ja<?>> f3167p = new Object2ObjectOpenHashMap();

    static {
        m2467a(CloudItemCallingCard.class, new C0488iY());
        m2467a(CloudItemCape.class, new C0489iZ());
        m2467a(CloudItemTrophy.class, new C0551ji());
        m2467a(CloudItemCoin.class, new C0545jc());
        m2467a(CloudItemGun.class, new C0547je());
        m2467a(CloudItemMelee.class, new C0548jf());
        m2467a(CloudItemSticker.class, new C0550jh());
        m2467a(CloudItemPrestigeCard.class, new C0549jg());
    }

    /* JADX INFO: renamed from: a */
    public static void m2467a(@NotNull Class<? extends CloudItem<?>> cls, @NotNull AbstractC0543ja<? extends CloudItem<?>> abstractC0543ja) {
        f3167p.put(cls, abstractC0543ja);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static AbstractC0543ja<?> m2468a(@NotNull CloudItem<?> cloudItem) {
        return f3167p.getOrDefault(cloudItem.getClass(), f3166a);
    }
}
