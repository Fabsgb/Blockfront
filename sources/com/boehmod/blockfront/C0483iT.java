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

/* JADX INFO: renamed from: com.boehmod.blockfront.iT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iT.class */
public class C0483iT {

    /* JADX INFO: renamed from: c */
    @NotNull
    private static final Int2ObjectMap<ItemStack> f2959c = new Int2ObjectOpenHashMap();

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final Int2ObjectMap<Item> f2960d = new Int2ObjectOpenHashMap();

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ItemStack m2203a(@NotNull CloudItem<?> cloudItem, @NotNull CloudItemStack cloudItemStack) {
        ItemStack itemStack = (ItemStack) f2959c.computeIfAbsent(cloudItem.getId(), i -> {
            ItemStack itemStack2 = new ItemStack(m2206a(cloudItem));
            m2204a((CloudItem<?>) cloudItem, itemStack2);
            return itemStack2;
        });
        m2205a(cloudItemStack, itemStack);
        return itemStack;
    }

    /* JADX INFO: renamed from: a */
    public static void m2204a(@NotNull CloudItem<?> cloudItem, @Nonnull ItemStack itemStack) {
        SkinPattern patternSkin;
        float skin = cloudItem.getSkin();
        itemStack.set(C1228wV.f6976T, false);
        if (skin != 0.0f) {
            itemStack.set(C1228wV.f6959C, Float.valueOf(skin));
            if ((cloudItem instanceof CloudItemGun) && (patternSkin = ((CloudItemGun) cloudItem).getPatternSkin()) != null) {
                itemStack.set(C1228wV.f6976T, true);
                itemStack.set(C1228wV.f6977U, Integer.valueOf(patternSkin.width()));
                itemStack.set(C1228wV.f6978V, Integer.valueOf(patternSkin.height()));
                itemStack.set(C1228wV.f6979W, patternSkin.name());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2205a(@NotNull CloudItemStack cloudItemStack, @Nonnull ItemStack itemStack) {
        itemStack.set(C1228wV.f6975S, Double.valueOf(cloudItemStack.getMint()));
        for (int i = 0; i < 16; i++) {
            AbstractC1062tO.m5931a(itemStack, i, cloudItemStack.getSticker(i));
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Item m2206a(@NotNull CloudItem<?> cloudItem) {
        return (Item) f2960d.computeIfAbsent(cloudItem.getId(), i -> {
            return (Item) BuiltInRegistries.ITEM.get(C0564jv.m2556a(cloudItem.getMinecraftItem()));
        });
    }
}
