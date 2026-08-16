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

/* JADX INFO: renamed from: com.boehmod.blockfront.jq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jq.class */
public class C0560jq {

    /* JADX INFO: renamed from: ic */
    @NotNull
    private static final Component f3312ic = Component.translatable("bf.message.try.luck");

    /* JADX INFO: renamed from: id */
    @NotNull
    private static final Component f3313id = Component.translatable("bf.message.required.key").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: ie */
    @NotNull
    private static final Component f3314ie = Component.translatable("bf.message.author").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: if */
    @NotNull
    private static final Component f3315if = Component.translatable("bf.message.rarity").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: ig */
    @NotNull
    private static final Component f3316ig = Component.translatable("bf.message.collection").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: ih */
    @NotNull
    private static final Component f3317ih = Component.translatable("bf.message.equipped").withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);

    /* JADX INFO: renamed from: ii */
    @NotNull
    private static final Component f3318ii = Component.translatable("bf.message.showcased").withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);

    /* JADX INFO: renamed from: ij */
    @NotNull
    private static final Component f3319ij = Component.translatable("bf.message.default.item").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: ik */
    @NotNull
    private static final Component f3320ik = Component.translatable("bf.message.mint").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: a */
    public static void m2541a(@NotNull CloudRegistry cloudRegistry, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull CloudItemStack cloudItemStack, @NotNull ObjectList<Component> objectList, Font font, int i) {
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistry);
        if (cloudItem == null) {
            return;
        }
        objectList.add(Component.literal(cloudItem.getName()));
        m2545a(cloudItem, (List<Component>) objectList);
        m2546b(cloudItem, objectList);
        m2547c(cloudItem, objectList);
        m2548d(cloudItem, objectList);
        Objects.requireNonNull(cloudItem);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), CloudItemBooster.class, CloudItemCase.class, CloudItemMelee.class, CloudItemGun.class).dynamicInvoker().invoke(cloudItem, 0) /* invoke-custom */) {
            case 0:
                m2544a((CloudItemBooster) cloudItem, objectList, font, i);
                break;
            case 1:
                m2543a((CloudItemCase) cloudItem, (List<Component>) objectList);
                break;
            case 2:
                if (!((CloudItemMelee) cloudItem).isDefault()) {
                    m2542a(cloudItemStack, objectList);
                }
                break;
            case 3:
                if (!((CloudItemGun) cloudItem).isDefault()) {
                    m2542a(cloudItemStack, objectList);
                }
                break;
        }
        m2549a(cloudRegistry, minecraft, c0396gl, cloudItem, cloudItemStack, objectList);
    }

    /* JADX INFO: renamed from: a */
    private static void m2542a(@NotNull CloudItemStack cloudItemStack, @NotNull ObjectList<Component> objectList) {
        double mint = cloudItemStack.getMint();
        if (mint > 0.0d) {
            int iM646a = C0129bt.m646a(ColorReferences.COLOR_THEME_MINT_VALUABLE, ColorReferences.COLOR_THEME_MINT_COMMON, mint);
            objectList.add(Component.empty());
            objectList.add(f3320ik);
            objectList.add(Component.literal(String.format(Locale.ROOT, "%.6f", Double.valueOf(mint))).withColor(iM646a));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2543a(@NotNull CloudItemCase cloudItemCase, @NotNull List<Component> list) {
        list.add(Component.empty());
        list.add(f3312ic);
        list.add(Component.empty());
        list.add(f3313id);
        CloudItem<?> key = cloudItemCase.getKey();
        String displayName = key.getDisplayName();
        list.add(Component.literal(displayName).withStyle(Style.EMPTY.withColor(key.getRarity().getColor())));
    }

    /* JADX INFO: renamed from: a */
    private static void m2544a(@NotNull CloudItemBooster cloudItemBooster, @NotNull List<Component> list, @NotNull Font font, int i) {
        list.add(Component.empty());
        ObjectListIterator it = C0544ja.m2458a(font, I18n.get("bf.screen.armory.booster.info", new Object[]{String.valueOf(ChatFormatting.GREEN) + cloudItemBooster.getSuffix() + String.valueOf(ChatFormatting.RESET)}), i).iterator();
        while (it.hasNext()) {
            list.add(Component.literal((String) it.next()));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2545a(@NotNull CloudItem<?> cloudItem, @NotNull List<Component> list) {
        String suffix = cloudItem.getSuffix();
        int color = cloudItem.getRarity().getColor();
        if (!suffix.isEmpty()) {
            list.add(Component.literal(suffix).withColor(color));
        }
        list.add(Component.empty());
    }

    /* JADX INFO: renamed from: b */
    private static void m2546b(@NotNull CloudItem<?> cloudItem, @NotNull List<Component> list) {
        Optional<String> author = cloudItem.getAuthor();
        if (author.isPresent()) {
            list.add(Component.empty());
            list.add(f3314ie);
            list.add(Component.literal(author.get()).withStyle(ChatFormatting.GRAY));
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m2547c(@NotNull CloudItem<?> cloudItem, @NotNull List<Component> list) {
        CloudItemRarity rarity = cloudItem.getRarity();
        list.add(f3315if);
        list.add(Component.literal(rarity.getName()).withColor(rarity.getColor()));
    }

    /* JADX INFO: renamed from: d */
    private static void m2548d(@NotNull CloudItem<?> cloudItem, @NotNull List<Component> list) {
        String collection = cloudItem.getCollection();
        if (collection != null) {
            list.add(Component.empty());
            list.add(f3316ig);
            list.add(Component.literal(collection).withStyle(ChatFormatting.GRAY));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2549a(@NotNull CloudRegistry cloudRegistry, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull CloudItem<?> cloudItem, @NotNull CloudItemStack cloudItemStack, @NotNull List<Component> list) {
        C0550jg inventory = c0396gl.m1886a(minecraft).getInventory();
        if (inventory.m2486a(cloudRegistry, cloudItemStack)) {
            list.add(Component.empty());
            list.add(f3317ih);
        }
        if (inventory.isItemShowcased(cloudItemStack)) {
            list.add(Component.empty());
            list.add(f3318ii);
        }
        if (cloudItem.isDefault()) {
            list.add(Component.empty());
            list.add(f3319ij);
        }
    }
}
