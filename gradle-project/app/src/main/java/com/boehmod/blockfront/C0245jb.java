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

/* JADX INFO: renamed from: com.boehmod.blockfront.jb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jb.class */
public class C0245jb {

    @NotNull
    public static final AbstractC0244ja<?> a = new C0247jd();

    @NotNull
    private static final Map<Class<? extends CloudItem<?>>, AbstractC0244ja<?>> p = new Object2ObjectOpenHashMap();

    static {
        a(CloudItemCallingCard.class, new iY());
        a(CloudItemCape.class, new iZ());
        a(CloudItemTrophy.class, new C0252ji());
        a(CloudItemCoin.class, new C0246jc());
        a(CloudItemGun.class, new C0248je());
        a(CloudItemMelee.class, new C0249jf());
        a(CloudItemSticker.class, new C0251jh());
        a(CloudItemPrestigeCard.class, new C0250jg());
    }

    public static void a(@NotNull Class<? extends CloudItem<?>> cls, @NotNull AbstractC0244ja<? extends CloudItem<?>> abstractC0244ja) {
        p.put(cls, abstractC0244ja);
    }

    @NotNull
    public static AbstractC0244ja<?> a(@NotNull CloudItem<?> cloudItem) {
        return p.getOrDefault(cloudItem.getClass(), a);
    }
}
