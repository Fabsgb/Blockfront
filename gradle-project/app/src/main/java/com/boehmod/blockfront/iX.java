package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemRarity;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemBooster;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCase;
import com.boehmod.bflib.cloud.common.item.types.CloudItemGun;
import com.boehmod.bflib.cloud.common.item.types.CloudItemMelee;
import com.boehmod.bflib.common.ColorReferences;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.SwitchBootstraps;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iX.class */
public class iX {

    @NotNull
    private static final Component hR = Component.translatable("bf.message.try.luck");

    @NotNull
    private static final Component hS = Component.translatable("bf.message.required.key").withStyle(ChatFormatting.BOLD);

    @NotNull
    private static final Component hT = Component.translatable("bf.message.author").withStyle(ChatFormatting.BOLD);

    @NotNull
    private static final Component hU = Component.translatable("bf.message.rarity").withStyle(ChatFormatting.BOLD);

    @NotNull
    private static final Component hV = Component.translatable("bf.message.collection").withStyle(ChatFormatting.BOLD);

    @NotNull
    private static final Component hW = Component.translatable("bf.message.equipped").withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);

    @NotNull
    private static final Component hX = Component.translatable("bf.message.showcased").withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);

    @NotNull
    private static final Component hY = Component.translatable("bf.message.default.item").withStyle(ChatFormatting.GRAY);

    @NotNull
    private static final Component hZ = Component.translatable("bf.message.mint").withStyle(ChatFormatting.BOLD);

    public static void a(@NotNull CloudRegistry cloudRegistry, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull CloudItemStack cloudItemStack, @NotNull ObjectList<Component> objectList, Font font, int i) {
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistry);
        if (cloudItem == null) {
            return;
        }
        objectList.add(Component.literal(cloudItem.getName()));
        a(cloudItem, (List<Component>) objectList);
        b(cloudItem, objectList);
        c(cloudItem, objectList);
        d(cloudItem, objectList);
        Objects.requireNonNull(cloudItem);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), CloudItemBooster.class, CloudItemCase.class, CloudItemMelee.class, CloudItemGun.class).dynamicInvoker().invoke(cloudItem, 0) /* invoke-custom */) {
            case 0:
                a((CloudItemBooster) cloudItem, objectList, font, i);
                break;
            case 1:
                a((CloudItemCase) cloudItem, (List<Component>) objectList);
                break;
            case 2:
                if (!((CloudItemMelee) cloudItem).isDefault()) {
                    a(cloudItemStack, objectList);
                }
                break;
            case 3:
                if (!((CloudItemGun) cloudItem).isDefault()) {
                    a(cloudItemStack, objectList);
                }
                break;
        }
        a(cloudRegistry, minecraft, fVVar, cloudItem, cloudItemStack, objectList);
    }

    private static void a(@NotNull CloudItemStack cloudItemStack, @NotNull ObjectList<Component> objectList) {
        double mint = cloudItemStack.getMint();
        if (mint > 0.0d) {
            int iA = C0040bk.a(ColorReferences.COLOR_THEME_MINT_VALUABLE, ColorReferences.COLOR_THEME_MINT_COMMON, mint);
            objectList.add(Component.empty());
            objectList.add(hZ);
            objectList.add(Component.literal(String.format(Locale.ROOT, "%.6f", Double.valueOf(mint))).withColor(iA));
        }
    }

    private static void a(@NotNull CloudItemCase cloudItemCase, @NotNull List<Component> list) {
        list.add(Component.empty());
        list.add(hR);
        list.add(Component.empty());
        list.add(hS);
        CloudItem<?> key = cloudItemCase.getKey();
        String displayName = key.getDisplayName();
        list.add(Component.literal(displayName).withStyle(Style.EMPTY.withColor(key.getRarity().getColor())));
    }

    private static void a(@NotNull CloudItemBooster cloudItemBooster, @NotNull List<Component> list, @NotNull Font font, int i) {
        list.add(Component.empty());
        ObjectListIterator it = iH.a(font, I18n.get("bf.screen.armory.booster.info", new Object[]{String.valueOf(ChatFormatting.GREEN) + cloudItemBooster.getSuffix() + String.valueOf(ChatFormatting.RESET)}), i).iterator();
        while (it.hasNext()) {
            list.add(Component.literal((String) it.next()));
        }
    }

    private static void a(@NotNull CloudItem<?> cloudItem, @NotNull List<Component> list) {
        String suffix = cloudItem.getSuffix();
        int color = cloudItem.getRarity().getColor();
        if (!suffix.isEmpty()) {
            list.add(Component.literal(suffix).withColor(color));
        }
        list.add(Component.empty());
    }

    private static void b(@NotNull CloudItem<?> cloudItem, @NotNull List<Component> list) {
        Optional<String> author = cloudItem.getAuthor();
        if (author.isPresent()) {
            list.add(Component.empty());
            list.add(hT);
            list.add(Component.literal(author.get()).withStyle(ChatFormatting.GRAY));
        }
    }

    private static void c(@NotNull CloudItem<?> cloudItem, @NotNull List<Component> list) {
        CloudItemRarity rarity = cloudItem.getRarity();
        list.add(hU);
        list.add(Component.literal(rarity.getName()).withColor(rarity.getColor()));
    }

    private static void d(@NotNull CloudItem<?> cloudItem, @NotNull List<Component> list) {
        String collection = cloudItem.getCollection();
        if (collection != null) {
            list.add(Component.empty());
            list.add(hV);
            list.add(Component.literal(collection).withStyle(ChatFormatting.GRAY));
        }
    }

    private static void a(@NotNull CloudRegistry cloudRegistry, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull CloudItem<?> cloudItem, @NotNull CloudItemStack cloudItemStack, @NotNull List<Component> list) {
        iN inventory = fVVar.m404a(minecraft).getInventory();
        if (inventory.a(cloudRegistry, cloudItemStack)) {
            list.add(Component.empty());
            list.add(hW);
        }
        if (inventory.isItemShowcased(cloudItemStack)) {
            list.add(Component.empty());
            list.add(hX);
        }
        if (cloudItem.isDefault()) {
            list.add(Component.empty());
            list.add(hY);
        }
    }
}
