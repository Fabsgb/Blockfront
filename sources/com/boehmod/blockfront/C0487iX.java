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

/* JADX INFO: renamed from: com.boehmod.blockfront.iX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iX.class */
public class C0487iX {

    /* JADX INFO: renamed from: hR */
    @NotNull
    private static final Component f2961hR = Component.translatable("bf.message.try.luck");

    /* JADX INFO: renamed from: hS */
    @NotNull
    private static final Component f2962hS = Component.translatable("bf.message.required.key").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: hT */
    @NotNull
    private static final Component f2963hT = Component.translatable("bf.message.author").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: hU */
    @NotNull
    private static final Component f2964hU = Component.translatable("bf.message.rarity").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: hV */
    @NotNull
    private static final Component f2965hV = Component.translatable("bf.message.collection").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: hW */
    @NotNull
    private static final Component f2966hW = Component.translatable("bf.message.equipped").withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);

    /* JADX INFO: renamed from: hX */
    @NotNull
    private static final Component f2967hX = Component.translatable("bf.message.showcased").withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);

    /* JADX INFO: renamed from: hY */
    @NotNull
    private static final Component f2968hY = Component.translatable("bf.message.default.item").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: hZ */
    @NotNull
    private static final Component f2969hZ = Component.translatable("bf.message.mint").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: a */
    public static void m2214a(@NotNull CloudRegistry cloudRegistry, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull CloudItemStack cloudItemStack, @NotNull ObjectList<Component> objectList, Font font, int i) {
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistry);
        if (cloudItem == null) {
            return;
        }
        objectList.add(Component.literal(cloudItem.getName()));
        m2218a(cloudItem, (List<Component>) objectList);
        m2219b(cloudItem, objectList);
        m2220c(cloudItem, objectList);
        m2221d(cloudItem, objectList);
        Objects.requireNonNull(cloudItem);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), CloudItemBooster.class, CloudItemCase.class, CloudItemMelee.class, CloudItemGun.class).dynamicInvoker().invoke(cloudItem, 0) /* invoke-custom */) {
            case 0:
                m2217a((CloudItemBooster) cloudItem, objectList, font, i);
                break;
            case 1:
                m2216a((CloudItemCase) cloudItem, (List<Component>) objectList);
                break;
            case 2:
                if (!((CloudItemMelee) cloudItem).isDefault()) {
                    m2215a(cloudItemStack, objectList);
                }
                break;
            case 3:
                if (!((CloudItemGun) cloudItem).isDefault()) {
                    m2215a(cloudItemStack, objectList);
                }
                break;
        }
        m2222a(cloudRegistry, minecraft, c0326fV, cloudItem, cloudItemStack, objectList);
    }

    /* JADX INFO: renamed from: a */
    private static void m2215a(@NotNull CloudItemStack cloudItemStack, @NotNull ObjectList<Component> objectList) {
        double mint = cloudItemStack.getMint();
        if (mint > 0.0d) {
            int iM543a = C0119bk.m543a(ColorReferences.COLOR_THEME_MINT_VALUABLE, ColorReferences.COLOR_THEME_MINT_COMMON, mint);
            objectList.add(Component.empty());
            objectList.add(f2969hZ);
            objectList.add(Component.literal(String.format(Locale.ROOT, "%.6f", Double.valueOf(mint))).withColor(iM543a));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2216a(@NotNull CloudItemCase cloudItemCase, @NotNull List<Component> list) {
        list.add(Component.empty());
        list.add(f2961hR);
        list.add(Component.empty());
        list.add(f2962hS);
        CloudItem<?> key = cloudItemCase.getKey();
        String displayName = key.getDisplayName();
        list.add(Component.literal(displayName).withStyle(Style.EMPTY.withColor(key.getRarity().getColor())));
    }

    /* JADX INFO: renamed from: a */
    private static void m2217a(@NotNull CloudItemBooster cloudItemBooster, @NotNull List<Component> list, @NotNull Font font, int i) {
        list.add(Component.empty());
        ObjectListIterator it = C0471iH.m2131a(font, I18n.get("bf.screen.armory.booster.info", new Object[]{String.valueOf(ChatFormatting.GREEN) + cloudItemBooster.getSuffix() + String.valueOf(ChatFormatting.RESET)}), i).iterator();
        while (it.hasNext()) {
            list.add(Component.literal((String) it.next()));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2218a(@NotNull CloudItem<?> cloudItem, @NotNull List<Component> list) {
        String suffix = cloudItem.getSuffix();
        int color = cloudItem.getRarity().getColor();
        if (!suffix.isEmpty()) {
            list.add(Component.literal(suffix).withColor(color));
        }
        list.add(Component.empty());
    }

    /* JADX INFO: renamed from: b */
    private static void m2219b(@NotNull CloudItem<?> cloudItem, @NotNull List<Component> list) {
        Optional<String> author = cloudItem.getAuthor();
        if (author.isPresent()) {
            list.add(Component.empty());
            list.add(f2963hT);
            list.add(Component.literal(author.get()).withStyle(ChatFormatting.GRAY));
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m2220c(@NotNull CloudItem<?> cloudItem, @NotNull List<Component> list) {
        CloudItemRarity rarity = cloudItem.getRarity();
        list.add(f2964hU);
        list.add(Component.literal(rarity.getName()).withColor(rarity.getColor()));
    }

    /* JADX INFO: renamed from: d */
    private static void m2221d(@NotNull CloudItem<?> cloudItem, @NotNull List<Component> list) {
        String collection = cloudItem.getCollection();
        if (collection != null) {
            list.add(Component.empty());
            list.add(f2965hV);
            list.add(Component.literal(collection).withStyle(ChatFormatting.GRAY));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2222a(@NotNull CloudRegistry cloudRegistry, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull CloudItem<?> cloudItem, @NotNull CloudItemStack cloudItemStack, @NotNull List<Component> list) {
        C0477iN inventory = c0326fV.m1676a(minecraft).getInventory();
        if (inventory.m2159a(cloudRegistry, cloudItemStack)) {
            list.add(Component.empty());
            list.add(f2966hW);
        }
        if (inventory.isItemShowcased(cloudItemStack)) {
            list.add(Component.empty());
            list.add(f2967hX);
        }
        if (cloudItem.isDefault()) {
            list.add(Component.empty());
            list.add(f2968hY);
        }
    }
}
