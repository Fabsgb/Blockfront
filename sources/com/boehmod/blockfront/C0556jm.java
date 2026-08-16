package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.pattern.SkinPattern;
import com.boehmod.bflib.cloud.common.item.types.CloudItemGun;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import javax.annotation.Nonnull;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jm.class */
public class C0556jm {

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final Int2ObjectMap<ItemStack> f3310d = new Int2ObjectOpenHashMap();

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final Int2ObjectMap<Item> f3311e = new Int2ObjectOpenHashMap();

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ItemStack m2530a(@NotNull CloudItem<?> cloudItem, @NotNull CloudItemStack cloudItemStack) {
        ItemStack itemStack = (ItemStack) f3310d.computeIfAbsent(cloudItem.getId(), i -> {
            ItemStack itemStack2 = new ItemStack(m2533a(cloudItem));
            m2531a((CloudItem<?>) cloudItem, itemStack2);
            return itemStack2;
        });
        m2532a(cloudItemStack, itemStack);
        return itemStack;
    }

    /* JADX INFO: renamed from: a */
    public static void m2531a(@NotNull CloudItem<?> cloudItem, @Nonnull ItemStack itemStack) {
        SkinPattern patternSkin;
        float skin = cloudItem.getSkin();
        itemStack.set(C1305xs.f7541V, false);
        if (skin != 0.0f) {
            itemStack.set(C1305xs.f7522C, Float.valueOf(skin));
            if ((cloudItem instanceof CloudItemGun) && (patternSkin = ((CloudItemGun) cloudItem).getPatternSkin()) != null) {
                itemStack.set(C1305xs.f7541V, true);
                itemStack.set(C1305xs.f7542W, Integer.valueOf(patternSkin.width()));
                itemStack.set(C1305xs.f7543X, Integer.valueOf(patternSkin.height()));
                itemStack.set(C1305xs.f7544Y, patternSkin.name());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2532a(@NotNull CloudItemStack cloudItemStack, @Nonnull ItemStack itemStack) {
        itemStack.set(C1305xs.f7540U, Double.valueOf(cloudItemStack.getMint()));
        for (int i = 0; i < 16; i++) {
            AbstractC1140um.m6565a(itemStack, i, cloudItemStack.getSticker(i));
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Item m2533a(@NotNull CloudItem<?> cloudItem) {
        return (Item) f3311e.computeIfAbsent(cloudItem.getId(), i -> {
            return (Item) BuiltInRegistries.ITEM.get(C0532jO.m2379a(cloudItem.getMinecraftItem()));
        });
    }
}
