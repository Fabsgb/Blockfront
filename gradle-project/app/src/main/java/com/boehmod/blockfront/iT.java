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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iT.class */
public class iT {

    @NotNull
    private static final Int2ObjectMap<ItemStack> c = new Int2ObjectOpenHashMap();

    @NotNull
    private static final Int2ObjectMap<Item> d = new Int2ObjectOpenHashMap();

    @NotNull
    public static ItemStack a(@NotNull CloudItem<?> cloudItem, @NotNull CloudItemStack cloudItemStack) {
        ItemStack itemStack = (ItemStack) c.computeIfAbsent(cloudItem.getId(), i -> {
            ItemStack itemStack2 = new ItemStack(a(cloudItem));
            a((CloudItem<?>) cloudItem, itemStack2);
            return itemStack2;
        });
        a(cloudItemStack, itemStack);
        return itemStack;
    }

    public static void a(@NotNull CloudItem<?> cloudItem, @Nonnull ItemStack itemStack) {
        SkinPattern patternSkin;
        float skin = cloudItem.getSkin();
        itemStack.set(wV.T, false);
        if (skin != 0.0f) {
            itemStack.set(wV.C, Float.valueOf(skin));
            if ((cloudItem instanceof CloudItemGun) && (patternSkin = ((CloudItemGun) cloudItem).getPatternSkin()) != null) {
                itemStack.set(wV.T, true);
                itemStack.set(wV.U, Integer.valueOf(patternSkin.width()));
                itemStack.set(wV.V, Integer.valueOf(patternSkin.height()));
                itemStack.set(wV.W, patternSkin.name());
            }
        }
    }

    public static void a(@NotNull CloudItemStack cloudItemStack, @Nonnull ItemStack itemStack) {
        itemStack.set(wV.S, Double.valueOf(cloudItemStack.getMint()));
        for (int i = 0; i < 16; i++) {
            tO.a(itemStack, i, cloudItemStack.getSticker(i));
        }
    }

    @NotNull
    public static Item a(@NotNull CloudItem<?> cloudItem) {
        return (Item) d.computeIfAbsent(cloudItem.getId(), i -> {
            return (Item) BuiltInRegistries.ITEM.get(C0265jv.a(cloudItem.getMinecraftItem()));
        });
    }
}
