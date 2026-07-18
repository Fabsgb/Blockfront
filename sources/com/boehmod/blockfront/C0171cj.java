package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000mm.MatchParty;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.SwitchBootstraps;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.cj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cj.class */
public final class C0171cj extends AbstractC0179cn {

    /* JADX INFO: renamed from: dj */
    public static final int f1341dj = 4;

    /* JADX INFO: renamed from: dk */
    public static final int f1342dk = 100;

    /* JADX INFO: renamed from: dl */
    private static final int f1343dl = 100;

    /* JADX INFO: renamed from: dl */
    public static final float f1344dl = 0.75f;

    /* JADX INFO: renamed from: dm */
    private static final float f1351dm = 32.0f;

    /* JADX INFO: renamed from: dn */
    private static final float f1352dn = 37.0f;

    /* JADX INFO: renamed from: dm */
    private static final int f1354dm = 15;

    /* JADX INFO: renamed from: dn */
    private static final int f1364dn = 16;

    /* JADX INFO: renamed from: do */
    private static final int f1365do = 2;

    /* JADX INFO: renamed from: dp */
    private static final int f1366dp = 512;

    /* JADX INFO: renamed from: do */
    private static final float f1367do = 1.0f;

    /* JADX INFO: renamed from: dp */
    private static final float f1368dp = 1.25f;

    /* JADX INFO: renamed from: dq */
    private static final int f1369dq = 24;

    /* JADX INFO: renamed from: dr */
    private static final int f1370dr = 24;

    /* JADX INFO: renamed from: ds */
    private static final int f1371ds = 99;

    /* JADX INFO: renamed from: dt */
    private static final int f1372dt = 15;

    /* JADX INFO: renamed from: du */
    private static final int f1373du = 102;

    /* JADX INFO: renamed from: dv */
    private static final int f1374dv = 15;

    /* JADX INFO: renamed from: dw */
    private static final int f1375dw = 64;

    /* JADX INFO: renamed from: dx */
    private static final int f1376dx = 102;

    /* JADX INFO: renamed from: dy */
    private static final int f1377dy = 15;

    /* JADX INFO: renamed from: dz */
    public static final int f1378dz = 15;

    /* JADX INFO: renamed from: dA */
    public static final int f1379dA = 8;

    /* JADX INFO: renamed from: dB */
    public static int f1380dB;

    /* JADX INFO: renamed from: dC */
    public static int f1381dC;

    /* JADX INFO: renamed from: dD */
    public static int f1382dD;

    /* JADX INFO: renamed from: dE */
    private static final int f1383dE = 8;

    /* JADX INFO: renamed from: dF */
    private static int f1385dF;

    /* JADX INFO: renamed from: dG */
    private static int f1386dG;

    /* JADX INFO: renamed from: dq */
    private static float f1387dq;

    /* JADX INFO: renamed from: dr */
    private static float f1388dr;

    /* JADX INFO: renamed from: ds */
    private static float f1390ds;

    /* JADX INFO: renamed from: dt */
    private static float f1391dt;

    /* JADX INFO: renamed from: a */
    @Nullable
    private static C0796oO f1392a;

    /* JADX INFO: renamed from: l */
    @Nullable
    private static FormattedCharSequence f1397l;

    /* JADX INFO: renamed from: m */
    @Nullable
    private static FormattedCharSequence f1398m;

    /* JADX INFO: renamed from: n */
    @Nullable
    private static FormattedCharSequence f1399n;

    /* JADX INFO: renamed from: o */
    @Nullable
    private static FormattedCharSequence f1400o;

    /* JADX INFO: renamed from: dI */
    private static int f1401dI;

    /* JADX INFO: renamed from: p */
    @NotNull
    private static FormattedCharSequence f1402p;

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final int[] f1403f;

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final FormattedCharSequence[] f1404b;

    /* JADX INFO: renamed from: dJ */
    private static int f1405dJ;

    /* JADX INFO: renamed from: dK */
    private static int f1406dK;

    /* JADX INFO: renamed from: q */
    @NotNull
    private static FormattedCharSequence f1407q;

    /* JADX INFO: renamed from: r */
    @NotNull
    private static FormattedCharSequence f1408r;

    /* JADX INFO: renamed from: dL */
    private static int f1409dL;

    /* JADX INFO: renamed from: s */
    @NotNull
    private static FormattedCharSequence f1410s;

    /* JADX INFO: renamed from: dM */
    private static int f1411dM;

    /* JADX INFO: renamed from: aR */
    private static boolean f1412aR;

    /* JADX INFO: renamed from: t */
    @NotNull
    private static FormattedCharSequence f1413t;

    /* JADX INFO: renamed from: an */
    @NotNull
    private static final ResourceLocation f1345an = C0564jv.m2555d("textures/gui/game/health_bar.png");

    /* JADX INFO: renamed from: ao */
    @NotNull
    private static final ResourceLocation f1346ao = C0564jv.m2555d("textures/gui/game/health.png");

    /* JADX INFO: renamed from: ap */
    @NotNull
    private static final ResourceLocation f1347ap = C0564jv.m2555d("textures/gui/game/health_vehicle.png");

    /* JADX INFO: renamed from: aq */
    @NotNull
    private static final ResourceLocation f1348aq = C0564jv.m2555d("textures/gui/menu/icons/spectator.png");

    /* JADX INFO: renamed from: ar */
    @NotNull
    private static final ResourceLocation f1349ar = C0564jv.m2555d("textures/misc/waypoints/waypoint_player_injured.png");

    /* JADX INFO: renamed from: as */
    @NotNull
    private static final ResourceLocation f1350as = C0564jv.m2555d("textures/misc/waypoints/waypoint_player_injured_callout.png");

    /* JADX INFO: renamed from: aV */
    @NotNull
    private static final Component f1353aV = Component.translatable("bf.message.dead.countdown.soon");

    /* JADX INFO: renamed from: aW */
    @NotNull
    private static final Component f1355aW = Component.translatable("bf.spectate.nobody");

    /* JADX INFO: renamed from: aX */
    @NotNull
    private static final Component f1356aX = Component.translatable("bf.message.reloading");

    /* JADX INFO: renamed from: aY */
    @NotNull
    private static final Component f1357aY = Component.translatable("bf.message.none").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: aZ */
    @NotNull
    private static final Component f1358aZ = Component.translatable("bf.item.radio.resupplying");

    /* JADX INFO: renamed from: ba */
    @NotNull
    private static final Component f1359ba = Component.translatable("bf.item.radio.preparing");

    /* JADX INFO: renamed from: bb */
    @NotNull
    private static final Component f1360bb = Component.translatable("bf.message.ammo").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: bc */
    @NotNull
    private static final Component f1361bc = Component.literal("mph").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final DecimalFormat f1362a = new DecimalFormat("0.0");

    /* JADX INFO: renamed from: o */
    @NotNull
    private static final ObjectList<a> f1363o = new ObjectArrayList();

    /* JADX INFO: renamed from: h */
    @NotNull
    private static FormattedCharSequence f1384h = FormattedCharSequence.EMPTY;

    /* JADX INFO: renamed from: dH */
    private static int f1389dH = -1;

    /* JADX INFO: renamed from: i */
    @NotNull
    private static FormattedCharSequence f1393i = Component.literal("1").getVisualOrderText();

    /* JADX INFO: renamed from: j */
    @NotNull
    private static FormattedCharSequence f1394j = Component.literal("2").getVisualOrderText();

    /* JADX INFO: renamed from: k */
    @NotNull
    private static FormattedCharSequence f1395k = Component.literal("3").getVisualOrderText();

    /* JADX INFO: renamed from: a */
    private static final FormattedCharSequence[] f1396a = new FormattedCharSequence[4];

    static {
        for (int i = 0; i < 4; i++) {
            f1396a[i] = Component.literal(String.valueOf(4 + i)).getVisualOrderText();
        }
        f1401dI = Integer.MIN_VALUE;
        f1402p = FormattedCharSequence.EMPTY;
        f1403f = new int[4];
        f1404b = new FormattedCharSequence[4];
        f1405dJ = Integer.MIN_VALUE;
        f1406dK = Integer.MIN_VALUE;
        f1407q = FormattedCharSequence.EMPTY;
        f1408r = FormattedCharSequence.EMPTY;
        f1409dL = -1;
        f1410s = FormattedCharSequence.EMPTY;
        f1411dM = -1;
        f1413t = FormattedCharSequence.EMPTY;
    }

    /* JADX INFO: renamed from: a */
    public static void m1002a(@NotNull Minecraft minecraft, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, @Nullable LocalPlayer localPlayer, @NotNull C0324fT c0324fT) {
        if (localPlayer != null) {
            m1003b(minecraft, localPlayer);
        }
        if (abstractC0787oF == null || localPlayer == null) {
            return;
        }
        C0796oO c0796oOM3793a = abstractC0787oF.m3582b().m3793a(localPlayer.getUUID());
        if (c0796oOM3793a != null && c0796oOM3793a != f1392a) {
            f1392a = c0796oOM3793a;
            m1006a(c0796oOM3793a);
        }
        f1391dt = f1390ds;
        f1390ds = c0796oOM3793a == null ? 0.0f : c0796oOM3793a.m3867a(C1129uc.f5937b.getCooldownStat(), 0);
        m1007a(abstractC0787oF, localPlayer, c0324fT);
        m1004a(abstractC0787oF, localPlayer);
        m1005e(localPlayer);
    }

    /* JADX INFO: renamed from: b */
    private static void m1003b(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer) {
        MutableComponent name;
        f1388dr = f1387dq;
        Inventory inventory = localPlayer.getInventory();
        ItemStack selected = inventory.getSelected();
        if (inventory.selected != f1389dH) {
            f1389dH = inventory.selected;
            if (selected.isEmpty()) {
                name = Component.empty();
            } else {
                Item item = selected.getItem();
                if (item instanceof AbstractC1062tO) {
                    name = AbstractC1062tO.m5938a(selected);
                } else {
                    name = item.getName(selected);
                }
            }
            f1384h = name.getVisualOrderText();
            f1385dF = minecraft.font.width(f1384h);
            f1386dG = 8;
            f1388dr = 1.0f;
            f1387dq = 1.0f;
        }
        if (f1386dG > 0) {
            f1386dG--;
        } else {
            f1387dq = Mth.lerp(0.4f, f1387dq, 0.0f);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1004a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer) {
        int iM3853a = abstractC0787oF.m3598a(localPlayer.getUUID()).m3853a(C1089tp.f5714E.getKey());
        if (f1363o.size() > iM3853a) {
            f1363o.clear();
        } else {
            while (f1363o.size() < iM3853a) {
                f1363o.add(new a());
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private static void m1005e(@NotNull LocalPlayer localPlayer) {
        Entity vehicle = localPlayer.getVehicle();
        if (!(vehicle instanceof AbstractC0779ny)) {
            f1398m = null;
            f1399n = null;
            f1400o = null;
            return;
        }
        AbstractC0779ny abstractC0779ny = (AbstractC0779ny) vehicle;
        f1398m = Component.literal(String.valueOf((int) abstractC0779ny.m3507az())).withStyle(ChatFormatting.BOLD).getVisualOrderText();
        f1399n = Component.literal(f1362a.format(((double) (abstractC0779ny.m3505ay() * 20.0f)) * 2.237d)).getVisualOrderText();
        f1400o = null;
        C0732nD c0732nDM3535a = abstractC0779ny.m3535a((Entity) localPlayer);
        if (c0732nDM3535a != null && (abstractC0779ny instanceof AbstractC0729nA)) {
            AbstractC0729nA abstractC0729nA = (AbstractC0729nA) abstractC0779ny;
            for (AbstractC0742nN<?> abstractC0742nN : c0732nDM3535a.m3327b()) {
                if (abstractC0742nN instanceof C0740nL) {
                    f1400o = Component.literal(String.valueOf(abstractC0729nA.m3290a((C0740nL) abstractC0742nN).m3297a(abstractC0729nA.getEntityData()))).getVisualOrderText();
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1006a(@NotNull C0796oO c0796oO) {
        Style styleM3876a = c0796oO.m3876a();
        f1393i = Component.literal("1").withStyle(styleM3876a).getVisualOrderText();
        f1394j = Component.literal("2").withStyle(styleM3876a).getVisualOrderText();
        f1395k = Component.literal("3").withStyle(styleM3876a).getVisualOrderText();
        for (int i = 0; i < 4; i++) {
            f1396a[i] = Component.literal(String.valueOf(4 + i)).withStyle(styleM3876a).getVisualOrderText();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1007a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull C0324fT c0324fT) {
        int iM3853a;
        f1397l = null;
        if (!C0799oR.m4052a((Player) localPlayer, (AbstractC0182b<?, ?, ?, ?>) c0324fT) && (abstractC0787oF instanceof InterfaceC0973rg) && (iM3853a = abstractC0787oF.m3598a(localPlayer.getUUID()).m3853a(C1089tp.f5709z.getKey())) > 0) {
            f1397l = Component.translatable("bf.message.ingame.warcry", new Object[]{Component.literal(C1219wM.f6919d.getKey().getDisplayName().getString().toUpperCase(Locale.ROOT)).withColor(ColorReferences.COLOR_WHITE), Component.literal(String.valueOf(iM3853a / 20)).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.RED).getVisualOrderText();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1008a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull C0324fT c0324fT, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2) {
        Component componentMo3705a;
        MutableComponent mutableComponentAppend = Component.empty().append(f1355aW).append(C0116bh.m346a(C0119bk.m366g()));
        UUID uuidQ = c0324fT.m1099q();
        if (uuidQ != null && minecraft.level != null && minecraft.level.getPlayerByUUID(uuidQ) != null) {
            mutableComponentAppend = ((C0326fV) c0622l.m2670a()).mo1137a(uuidQ).m2188b();
        }
        int i3 = (i2 - 15) - 4;
        int i4 = i3 - 19;
        m1009a(guiGraphics, font, (Component) Component.translatable("bf.spectate.cycle.hint", new Object[]{C1219wM.f6921f.getTranslatedKeyMessage(), C1219wM.f6920e.getTranslatedKeyMessage()}), i, i3);
        m1009a(guiGraphics, font, (Component) Component.translatable("bf.spectate.watching", new Object[]{mutableComponentAppend}), i, i4);
        AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622l.m2692a();
        if (abstractC0788oGM2692a != null && (componentMo3705a = abstractC0788oGM2692a.mo3705a(minecraft, c0622l, localPlayer, c0324fT)) != null) {
            m1009a(guiGraphics, font, componentMo3705a, i, i4 - 19);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1009a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Component component, int i, int i2) {
        int iWidth = font.width(component) + 6;
        C0119bk.m418b(guiGraphics, i - (iWidth / 2), i2, iWidth, 15, C0119bk.m365p());
        C0119bk.m401a(guiGraphics.pose(), font, guiGraphics, component, i, i2 + 4, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: a */
    private static void m1010a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, int i, int i2, int i3) {
        if (i != f1405dJ) {
            f1405dJ = i;
            f1407q = Component.literal(String.valueOf(i)).getVisualOrderText();
        }
        if (i2 != f1406dK) {
            f1406dK = i2;
            f1408r = Component.literal(String.valueOf(i2)).getVisualOrderText();
        }
        int i4 = (((i3 - 15) - 4) - 15) - 4;
        int iM1011a = 4;
        if (i > 0) {
            iM1011a = 4 + m1011a(guiGraphics, font, f1407q, 4, i4, ColorReferences.COLOR_WHITE) + 4;
        }
        if (i2 > 0) {
            C0796oO c0796oOM3793a = abstractC0787oF.m3582b().m3793a(localPlayer.getUUID());
            m1011a(guiGraphics, font, f1408r, iM1011a, i4, c0796oOM3793a != null ? c0796oOM3793a.getColor() : ColorReferences.COLOR_WHITE);
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m1011a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2, int i3) {
        int iWidth = 17 + font.width(formattedCharSequence) + 4;
        C0119bk.m418b(guiGraphics, i, i2, iWidth, 15, C0119bk.m365p());
        C0119bk.m437a(guiGraphics.pose(), guiGraphics, f1348aq, i, i2, 15, 15, 0.0f, 1.0f, i3);
        C0119bk.m405b(font, guiGraphics, formattedCharSequence, i + 15 + 2, i2 + 4, i3);
        return iWidth;
    }

    /* JADX INFO: renamed from: a */
    private static void m1012a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2) {
        if (f1397l == null) {
            return;
        }
        C0119bk.m409a(guiGraphics.pose(), font, guiGraphics, f1397l, i, i2);
    }

    /* JADX INFO: renamed from: a */
    public void m1013a(@NotNull Font font, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0788oG<?, ?> abstractC0788oG, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, int i, int i2, float f, float f2) {
        int iM365p = C0119bk.m365p();
        C0796oO c0796oOM3793a = abstractC0787oF.m3582b().m3793a(localPlayer.getUUID());
        if (c0796oOM3793a == null) {
            return;
        }
        c0796oOM3793a.m3860a(abstractC0787oF);
        float f3 = f1371ds / 2.0f;
        float f4 = 30 / 2.0f;
        int i3 = i - (f1371ds + 4);
        int i4 = i2 - 137;
        Inventory inventory = localPlayer.getInventory();
        int i5 = inventory.selected;
        TextColor color = c0796oOM3793a.m3876a().getColor();
        int value = color != null ? color.getValue() : ColorReferences.COLOR_WHITE_SOLID;
        float fM7843e = C1290xm.m7843e(abstractC0788oG.f4297kk, abstractC0788oG.f4298kl, f2);
        if (fM7843e < 1.0f && localPlayer.getVehicle() == null) {
            poseStack.pushPose();
            poseStack.translate((f1371ds + 4 + 10) * fM7843e, 0.0f, 0.0f);
            ItemStack item = inventory.getItem(0);
            if (i5 == 0) {
                C0119bk.m417a(guiGraphics, i3 + 1, i4 + 1, f1371ds - 2, 30 - 2, value, 0.55f);
            }
            C0119bk.m415a(guiGraphics, i3 + 1, i4, f1371ds - 2, 1, iM365p);
            C0119bk.m415a(guiGraphics, i3, i4 + 1, f1371ds, 30 - 2, iM365p);
            C0119bk.m415a(guiGraphics, i3 + 1, (i4 + 30) - 1, f1371ds - 2, 1, iM365p);
            C0119bk.m404b(font, guiGraphics, f1393i, i3 + 2, i4 + 2);
            C0119bk.m501a(poseStack, guiGraphics, item, i3 + f3, i4 + f4, 3.5f);
            ItemStack item2 = inventory.getItem(1);
            int i6 = i4 + 31;
            if (i5 == 1) {
                C0119bk.m417a(guiGraphics, i3 + 1, i6 + 1, f1371ds - 2, 30 - 2, value, 0.55f);
            }
            C0119bk.m415a(guiGraphics, i3 + 1, i6, f1371ds - 2, 1, iM365p);
            C0119bk.m415a(guiGraphics, i3, i6 + 1, f1371ds, 30 - 2, iM365p);
            C0119bk.m415a(guiGraphics, i3 + 1, (i6 + 30) - 1, f1371ds - 2, 1, iM365p);
            C0119bk.m404b(font, guiGraphics, f1394j, i3 + 2, i6 + 2);
            C0119bk.m501a(poseStack, guiGraphics, item2, i3 + f3, i6 + f4, 2.5f);
            ItemStack item3 = inventory.getItem(2);
            int i7 = i6 + 31;
            if (i5 == 2) {
                C0119bk.m417a(guiGraphics, i3 + 1, i7 + 1, f1371ds - 2, 30 - 2, value, 0.55f);
            }
            C0119bk.m415a(guiGraphics, i3 + 1, i7, f1371ds - 2, 1, iM365p);
            C0119bk.m415a(guiGraphics, i3, i7 + 1, f1371ds, 30 - 2, iM365p);
            C0119bk.m415a(guiGraphics, i3 + 1, (i7 + 30) - 1, f1371ds - 2, 1, iM365p);
            C0119bk.m404b(font, guiGraphics, f1395k, i3 + 2, i7 + 2);
            if (!item3.isEmpty()) {
                C0119bk.m501a(poseStack, guiGraphics, item3, i3 + f3, i7 + f4, 3.1f);
            }
            int i8 = i7 + 31;
            for (int i9 = 0; i9 < 4; i9++) {
                m1014a(font, guiGraphics, poseStack, inventory, i9, i5, i3, i8, value, 0.55f);
                i3 += 25;
            }
            poseStack.popPose();
        }
        int i10 = (i - f1371ds) - 4;
        int i11 = i2 - 19;
        m1015a(minecraft, localPlayer, poseStack, guiGraphics, font, abstractC0787oF, inventory, i, i2, iM365p, value, i10, i11, f1371ds, 15, f, f2);
        m1022a(poseStack, guiGraphics, font, abstractC0788oG, localPlayer, i2 - 15, 15, 102, iM365p, f2);
        m1023a(poseStack, guiGraphics, font, localPlayer, iM365p, i2, 15);
        m1025b(poseStack, guiGraphics, i10, i11, f2);
    }

    /* JADX INFO: renamed from: a */
    private static void m1014a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Inventory inventory, int i, int i2, int i3, int i4, int i5, float f) {
        int iM365p = C0119bk.m365p();
        ItemStack item = inventory.getItem(3 + i);
        int count = item.getCount();
        if (i2 == 3 + i) {
            C0119bk.m417a(guiGraphics, i3 + 1, i4 + 1, 22, 22, i5, f);
        }
        C0119bk.m415a(guiGraphics, i3 + 1, i4, 22, 1, iM365p);
        C0119bk.m415a(guiGraphics, i3, i4 + 1, 24, 22, iM365p);
        C0119bk.m415a(guiGraphics, i3 + 1, (i4 + 24) - 1, 22, 1, iM365p);
        float f2 = 1.0f;
        if (!item.isEmpty() && (item.getItem() instanceof InterfaceC1070tW)) {
            f2 = 1.25f;
        }
        C0119bk.m501a(poseStack, guiGraphics, item, i3 + 12.0f, i4 + 12.0f, f2);
        poseStack.translate(0.0f, 0.0f, 512.0f);
        C0119bk.m404b(font, guiGraphics, f1396a[i], i3 + 2, i4 + 2);
        if (count > 1) {
            if (count != f1403f[i]) {
                f1403f[i] = count;
                f1404b[i] = Component.literal(C1293xp.m7912a(count)).getVisualOrderText();
            }
            C0119bk.m404b(font, guiGraphics, f1404b[i], (i3 + 24) - 7, (i4 + 24) - 9);
        }
        poseStack.translate(0.0f, 0.0f, -512.0f);
    }

    /* JADX INFO: renamed from: a */
    private void m1015a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Inventory inventory, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, float f2) {
        C0119bk.m415a(guiGraphics, i5 + 1, i6, i7 - 2, 1, i3);
        C0119bk.m415a(guiGraphics, i5, i6 + 1, i7, i8 - 2, i3);
        C0119bk.m415a(guiGraphics, i5 + 1, (i6 + i8) - 1, i7 - 2, 1, i3);
        ItemStack selected = inventory.getSelected();
        if (selected.isEmpty()) {
        }
        Item item = selected.getItem();
        Objects.requireNonNull(item);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), C1144ur.class, C1056tI.class, C1129uc.class, C1136uj.class).dynamicInvoker().invoke(item, 0) /* invoke-custom */) {
            case 0:
                m1018a(minecraft, font, poseStack, guiGraphics, (C1144ur) item, selected, i, i2, i4, i5, i6, i7, i8, f, f2);
                break;
            case 1:
                float attackStrengthScale = localPlayer.getAttackStrengthScale(f2);
                if (attackStrengthScale < 1.0f) {
                    C0119bk.m414a(poseStack, guiGraphics, i5 + 1, i6, (i7 * attackStrengthScale) - 2.0f, 1.0f, ColorReferences.COLOR_WHITE_SOLID);
                }
                m1016a(poseStack, guiGraphics, font, i4, i5, i6, i7);
                break;
            case 2:
                m1017a(localPlayer, poseStack, guiGraphics, font, abstractC0787oF, i4, i5, i6, i7, f, f2);
                break;
            case 3:
                if (((C1136uj) item).mo5957ck() && C0300ew.m1583J()) {
                    C0119bk.m414a(poseStack, guiGraphics, i5 + 1, i6, (i7 * C0300ew.m1589u()) - 2.0f, 1.0f, ColorReferences.COLOR_WHITE_SOLID);
                }
                m1016a(poseStack, guiGraphics, font, i4, i5, i6, i7);
                break;
            default:
                m1016a(poseStack, guiGraphics, font, i4, i5, i6, i7);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1016a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, float f, float f2, int i2) {
        float fMin = f1385dF > 0 ? Math.min(1.0f, (i2 - 2) / f1385dF) : 1.0f;
        Objects.requireNonNull(font);
        C0119bk.m412a(poseStack, font, guiGraphics, f1384h, f + (i2 / 2.0f), f2 + 4.0f + ((1.0f - fMin) * 9.0f * 0.5f), i, fMin);
    }

    /* JADX INFO: renamed from: a */
    private void m1017a(@NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, int i, float f, float f2, int i2, float f3, float f4) {
        C0796oO c0796oOM3793a = abstractC0787oF.m3582b().m3793a(localPlayer.getUUID());
        if (c0796oOM3793a == null) {
            return;
        }
        EnumC0988rv enumC0988rv = C1129uc.f5937b;
        int iM3867a = c0796oOM3793a.m3867a(enumC0988rv.getCooldownStat(), 0);
        float f5 = f + (i2 / 2.0f);
        if (iM3867a <= 0) {
            m1016a(poseStack, guiGraphics, font, i, f, f2, i2);
            return;
        }
        C0119bk.m414a(poseStack, guiGraphics, f + 1.0f, f2, (C1290xm.m7843e(f1390ds, f1391dt, f4) * (i2 - 2)) / enumC0988rv.getMaxCooldown(), 1.0f, ColorReferences.COLOR_WHITE_SOLID);
        boolean zIsWaypoint = enumC0988rv.isWaypoint();
        String strM346a = C0116bh.m346a(f3);
        if (strM346a.length() != f1411dM || zIsWaypoint != f1412aR) {
            f1411dM = strM346a.length();
            f1412aR = zIsWaypoint;
            f1413t = (zIsWaypoint ? f1359ba : f1358aZ).copy().append(Component.literal(strM346a)).getVisualOrderText();
        }
        C0119bk.m410b(poseStack, font, guiGraphics, f1413t, f5, f2 + 4.0f, i);
    }

    /* JADX INFO: renamed from: a */
    private static void m1018a(@NotNull Minecraft minecraft, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull C1144ur c1144ur, @NotNull ItemStack itemStack, int i, int i2, int i3, float f, float f2, int i4, int i5, float f3, float f4) {
        int iM6424cb = c1144ur.m6318a(itemStack).m6424cb();
        Style styleWithColor = Style.EMPTY.withColor(ChatFormatting.WHITE);
        if (f1380dB < iM6424cb / 2) {
            styleWithColor = Style.EMPTY.withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);
            if (f1380dB < iM6424cb / 4) {
                styleWithColor = Style.EMPTY.withColor(ChatFormatting.RED);
            }
        }
        if (!C1144ur.m6311f(itemStack)) {
            float fM7843e = C1290xm.m7843e(f1387dq, f1388dr, f4);
            C0119bk.m517a(guiGraphics, (int) f, (int) f2, i4, i5);
            poseStack.pushPose();
            poseStack.translate(0.0f, i5 * fM7843e, 0.0f);
            c1144ur.m6333a().mo6292a(minecraft, poseStack, guiGraphics, font, c1144ur, itemStack, styleWithColor, i3, f, f2, i4, i5, i, i2, f4);
            poseStack.popPose();
            if (fM7843e > 0.0f) {
                float fMin = f1385dF > 0 ? Math.min(1.0f, (i4 - 2) / f1385dF) : 1.0f;
                Objects.requireNonNull(font);
                poseStack.pushPose();
                poseStack.translate(0.0f, (-i5) * (1.0f - fM7843e), 0.0f);
                C0119bk.m412a(poseStack, font, guiGraphics, f1384h, f + (i4 / 2.0f), f2 + 4.0f + ((1.0f - fMin) * 9.0f * 0.5f), C1290xm.m7833a(i3, fM7843e), fMin);
                poseStack.popPose();
            }
            guiGraphics.disableScissor();
            return;
        }
        float fM6407a = (c1144ur.m6407a(itemStack, f4) * i4) / c1144ur.m6319e(itemStack);
        String strM346a = C0116bh.m346a(f3);
        if (strM346a.length() != f1409dL) {
            f1409dL = strM346a.length();
            f1410s = f1356aX.copy().append(Component.literal(strM346a)).getVisualOrderText();
        }
        C0119bk.m414a(poseStack, guiGraphics, f + 1.0f, f2, fM6407a - 2.0f, 1.0f, ColorReferences.COLOR_WHITE_SOLID);
        C0119bk.m410b(poseStack, font, guiGraphics, f1410s, f + (i4 / 2.0f), f2 + 4.0f, i3);
    }

    /* JADX INFO: renamed from: a */
    public static void m1019a(@NotNull ItemStack itemStack) {
        f1381dC = f1380dB;
        f1380dB = C1144ur.m6301a(itemStack);
        f1382dD = C1144ur.m6304b(itemStack);
    }

    /* JADX INFO: renamed from: a */
    public static void m1020a(@NotNull Minecraft minecraft, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull C1144ur c1144ur, @NotNull ItemStack itemStack, int i, int i2, float f, float f2) {
        int iM365p = C0119bk.m365p();
        int i3 = ColorReferences.COLOR_WHITE_SOLID;
        int i4 = i - 105;
        int i5 = i2 - 21;
        C0119bk.m415a(guiGraphics, i4 + 1, i5, 97, 1, iM365p);
        C0119bk.m415a(guiGraphics, i4, i5 + 1, f1371ds, 13, iM365p);
        C0119bk.m415a(guiGraphics, i4 + 1, (i5 + 15) - 1, 97, 1, iM365p);
        m1018a(minecraft, font, poseStack, guiGraphics, c1144ur, itemStack, i, i2, i3, i4, i5, f1371ds, 15, f, f2);
    }

    /* JADX INFO: renamed from: a */
    private void m1021a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull LocalPlayer localPlayer, @NotNull Collection<C0124bp> collection) {
        C0117bi.m348a(poseStack, guiGraphics, font, localPlayer, collection, 4, 4, 0.75f, 100, 100);
    }

    /* JADX INFO: renamed from: a */
    private void m1022a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0788oG<?, ?> abstractC0788oG, @NotNull LocalPlayer localPlayer, int i, int i2, int i3, int i4, float f) {
        float fM3679y = abstractC0788oG.m3679y(f);
        float fM7843e = C1290xm.m7843e(C0054aY.f378bX, C0054aY.f379bY, f);
        int i5 = i - 4;
        float f2 = (64.0f * fM7843e) / 20.0f;
        C0119bk.m415a(guiGraphics, 5, i5, i3 - 2, 1, i4);
        C0119bk.m415a(guiGraphics, 4, i5 + 1, i3, i2 - 2, i4);
        C0119bk.m415a(guiGraphics, 5, (i5 + i2) - 1, i3 - 2, 1, i4);
        C0119bk.m431a(poseStack, guiGraphics, f1346ao, 4, i5, i2, i2);
        int iMax = Math.max((int) fM7843e, 1);
        if (iMax != f1401dI) {
            f1401dI = iMax;
            f1402p = Component.literal(String.valueOf(iMax)).withStyle(ChatFormatting.BOLD).getVisualOrderText();
        }
        C0119bk.m409a(poseStack, font, guiGraphics, f1402p, 30.0f, i5 + 4);
        C0119bk.m415a(guiGraphics, 40, i5 + 4, 64, 7, i4);
        int i6 = i5 + 4;
        C0119bk.m517a(guiGraphics, 40, i6, (int) f2, 7);
        C0119bk.m431a(poseStack, guiGraphics, f1345an, 40, i6, 64, 7);
        guiGraphics.disableScissor();
        if (C0054aY.f378bX <= 5.0f) {
            C0119bk.m414a(poseStack, guiGraphics, 40.0f, i - 2, f2, 7.0f, ColorReferences.COLOR_THEME_RED);
        }
        int foodLevel = localPlayer.getFoodData().getFoodLevel();
        if (fM3679y < 20.0f) {
            C0119bk.m414a(poseStack, guiGraphics, 5.0f, i5, ((i3 - 2) * fM3679y) / 20.0f, 1.0f, foodLevel <= 1 ? ColorReferences.COLOR_BLACK_SOLID + C0119bk.f726bC : ColorReferences.COLOR_WHITE_SOLID);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1023a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull LocalPlayer localPlayer, int i, int i2, int i3) {
        Entity vehicle = localPlayer.getVehicle();
        if (vehicle instanceof AbstractC0779ny) {
            AbstractC0779ny abstractC0779ny = (AbstractC0779ny) vehicle;
            FormattedCharSequence formattedCharSequence = f1398m;
            FormattedCharSequence formattedCharSequence2 = f1399n;
            if (formattedCharSequence == null || formattedCharSequence2 == null) {
                return;
            }
            C0733nE<AbstractC0779ny> c0733nEM3499b = abstractC0779ny.m3499b();
            float fM3507az = abstractC0779ny.m3507az();
            int i4 = ((i2 - 15) - 4) - (i3 + 1);
            float f = 64.0f * (fM3507az / c0733nEM3499b.f3949jC);
            C0119bk.m415a(guiGraphics, 4, i4, 102, 15, i);
            C0119bk.m431a(poseStack, guiGraphics, f1347ap, 4, i4, 15, 15);
            C0119bk.m409a(poseStack, font, guiGraphics, formattedCharSequence, 30.0f, i4 + 4);
            C0119bk.m415a(guiGraphics, 40, i4 + 4, 64, 7, i);
            int i5 = i4 + 4;
            C0119bk.m517a(guiGraphics, 40, i5, (int) f, 7);
            C0119bk.m431a(poseStack, guiGraphics, f1345an, 40, i5, 64, 7);
            guiGraphics.disableScissor();
            int i6 = (i3 * 2) + 1;
            C0119bk.m415a(guiGraphics, 107, i4, i6, i6, i);
            C0119bk.m411a(poseStack, font, guiGraphics, formattedCharSequence2, 107 + (i6 / 2), i4 + 5, 1.5f);
            C0119bk.m383c(font, guiGraphics, f1361bc, 107 + (i6 / 2), i4 + 18);
            FormattedCharSequence formattedCharSequence3 = f1400o;
            if (formattedCharSequence3 != null) {
                C0119bk.m415a(guiGraphics, 107 + i6 + 1, i4, i6, i6, i);
                C0119bk.m411a(poseStack, font, guiGraphics, formattedCharSequence3, 107 + i6 + 1 + (i6 / 2), i4 + 5, 1.5f);
                C0119bk.m383c(font, guiGraphics, f1360bb, 107 + i6 + 1 + (i6 / 2), i4 + 18);
            }
            int iGuiWidth = (guiGraphics.guiWidth() - f1371ds) - 4;
            int i7 = i2 - 42;
            int i8 = 0;
            int size = c0733nEM3499b.f3944aj.size();
            for (int i9 = 0; i9 < size; i9++) {
                C0732nD c0732nD = c0733nEM3499b.f3944aj.get(i9);
                int i10 = i7 - (21 * i8);
                C0119bk.m415a(guiGraphics, iGuiWidth, i10, f1371ds, 20, i);
                C0119bk.m433a(poseStack, guiGraphics, c0732nD.getIcon(), iGuiWidth, i10, 20, 20, 2.0f);
                MutableComponent mutableComponentCopy = f1357aY.copy();
                if (i9 < abstractC0779ny.getPassengers().size()) {
                    mutableComponentCopy = Component.literal(((Entity) abstractC0779ny.getPassengers().get(i9)).getScoreboardName());
                }
                C0119bk.m383c(font, guiGraphics, (Component) mutableComponentCopy, iGuiWidth + 49, (i10 + 10) - 3);
                i8++;
            }
        }
    }

    /* JADX INFO: renamed from: u */
    private static int m1024u() {
        int i = 138;
        if (f1400o != null) {
            i = 138 + 32;
        }
        return i;
    }

    /* JADX INFO: renamed from: b */
    private void m1025b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        int size = f1363o.size();
        int iMin = (i - 16) - (Math.min(size, 15) * 2);
        int i3 = i2 - 1;
        int i4 = iMin;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i4 += 2;
            ((a) f1363o.get(i6)).m1030a(poseStack, guiGraphics, i4 - 2, i3 + (i6 % 2 == 0 ? 2 : 0) + i5, 16, f);
            if (i6 != 0 && i6 % 15 == 0) {
                i4 = iMin;
                i5 += 4;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1026a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0788oG<? extends AbstractC0787oF<?, ?, ?>, ?> abstractC0788oG, boolean z, int i, float f) {
        List<C0876pp> listM3741y = abstractC0788oG.m3741y();
        int size = listM3741y.size();
        for (int i2 = 0; i2 < size; i2++) {
            poseStack.pushPose();
            poseStack.translate(7.0f, i + (i2 * 16), 0.0f);
            listM3741y.get(i2).m4423a(guiGraphics, font, abstractC0787oF, z, f);
            poseStack.popPose();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0179cn
    /* JADX INFO: renamed from: a */
    public void mo1027a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0622l c0622l) {
        int iM1024u;
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        float fM366g = C0119bk.m366g();
        if (!C0424hN.f2729j.m1996T() || minecraft.options.hideGui || clientLevel == null || localPlayer == null) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622l.m2688a();
        if (abstractC0787oFM2688a == null) {
            return;
        }
        float gameTimeDeltaPartialTick = deltaTracker.getGameTimeDeltaPartialTick(true);
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        int i = iGuiWidth / 2;
        int i2 = iGuiHeight / 2;
        C0326fV c0326fV = (C0326fV) c0622l.m2670a();
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        C0324fT c0324fTM1675a = c0326fV.m1675a(minecraft);
        C0482iS c0482iSM1676a = c0326fV.m1676a(minecraft);
        boolean z = c0622l.m2689d() || (localPlayer.isSpectator() && abstractC0787oFM2688a.mo3611bb());
        if (!z && ((C0424hN.f2739t.m1996T() && c0324fTM1675a.m1087dk()) || localPlayer.isDeadOrDying())) {
            C0119bk.m415a(guiGraphics, 0, 0, iGuiWidth, iGuiHeight, ColorReferences.COLOR_BLACK_SOLID);
        }
        if (z && !c0622l.m2709a().m3241ay()) {
            m1008a(minecraft, c0622l, localPlayer, c0324fTM1675a, guiGraphics, font, i, iGuiHeight);
        }
        int iCt = c0324fTM1675a.m1103ct();
        int iCu = c0324fTM1675a.m1104cu();
        if (C0424hN.f2735p.m1996T() && !z && !c0622l.m2709a().m3241ay() && (iCt > 0 || iCu > 0)) {
            m1010a(guiGraphics, font, abstractC0787oFM2688a, localPlayer, iCt, iCu, iGuiHeight);
        }
        C0119bk.m417a(guiGraphics, 0, 0, iGuiWidth, iGuiHeight, 0, Math.max(0.0f, C1290xm.m7843e(C0046aQ.f298bc, C0046aQ.f299bd, gameTimeDeltaPartialTick) - 1.0f));
        if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof C1144ur)) {
            m1019a(mainHandItem);
        }
        AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622l.m2692a();
        if (abstractC0788oGM2692a == null) {
            return;
        }
        Set<UUID> setM3809h = abstractC0787oFM2688a.m3582b().m3809h();
        m1029a(minecraft, c0622l, c0326fV, guiGraphics, font, abstractC0788oGM2692a, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        m1012a(guiGraphics, font, i, i2);
        abstractC0788oGM2692a.m3698a(minecraft, c0622l, localPlayer, clientLevel, c0324fTM1675a, guiGraphics, font, poseStackPose, bufferSource, setM3809h, iGuiWidth, iGuiHeight, i, i2, fM366g, gameTimeDeltaPartialTick);
        m1028a(minecraft, localPlayer, abstractC0788oGM2692a, poseStackPose, guiGraphics, font, abstractC0787oFM2688a, c0326fV, gameTimeDeltaPartialTick, iGuiWidth, i, i2);
        if (!c0622l.m2709a().m3241ay()) {
            float fM7843e = C1290xm.m7843e(abstractC0788oGM2692a.f4299km, abstractC0788oGM2692a.f4300kn, gameTimeDeltaPartialTick);
            poseStackPose.pushPose();
            poseStackPose.translate(0.0f, 0.0f, 400.0f);
            C0119bk.m417a(guiGraphics, 0, 0, iGuiWidth, iGuiHeight, ColorReferences.COLOR_BLACK_SOLID, fM7843e);
            poseStackPose.popPose();
            if (!c0324fTM1675a.m1087dk()) {
                m1013a(font, abstractC0787oFM2688a, abstractC0788oGM2692a, guiGraphics, poseStackPose, minecraft, localPlayer, iGuiWidth, iGuiHeight, fM366g, gameTimeDeltaPartialTick);
                Optional<MatchParty> party = c0482iSM1676a.getParty();
                if (party.isPresent()) {
                    MatchParty matchParty = party.get();
                    int iM1558h = C0294eq.m1558h(15);
                    int iM1557b = C0294eq.m1557b(matchParty, true, iM1558h);
                    if (localPlayer.getVehicle() instanceof AbstractC0779ny) {
                        iM1024u = m1024u() + 4;
                    } else {
                        iM1024u = C0234dj.f1919gd;
                    }
                    C0294eq.m1552a(minecraft, c0622l, poseStackPose, guiGraphics, matchParty, iM1024u + 1, ((iGuiHeight - iM1557b) - 4) + 1, -1, true, true, iM1558h - 2, false);
                }
            }
        }
        if (minecraft.options.keyPlayerList.isDown()) {
            abstractC0788oGM2692a.m3712a(poseStackPose, guiGraphics, font, minecraft, c0622l, localPlayer, c0482iSM1676a, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1028a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull AbstractC0788oG<? extends AbstractC0787oF<?, ?, ?>, ?> abstractC0788oG, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0326fV c0326fV, float f, int i, int i2, int i3) {
        C0796oO c0796oOM3793a;
        C0796oO c0796oOM3793a2;
        boolean zShowDebugScreen = minecraft.getDebugOverlay().showDebugScreen();
        Collection<C0124bp> collectionM3681d = abstractC0788oG.m3681d();
        poseStack.pushPose();
        if (zShowDebugScreen) {
            poseStack.translate(0.0f, 210.0f, 0.0f);
        }
        if (C0424hN.f2732m.m1996T()) {
            m1021a(poseStack, guiGraphics, font, localPlayer, collectionM3681d);
        }
        int i4 = 25;
        if (C0424hN.f2732m.m1996T()) {
            i4 = 25 + 104;
        }
        if ((abstractC0787oF instanceof InterfaceC0913qZ) && C0424hN.f2733n.m1996T()) {
            m1026a(poseStack, guiGraphics, font, abstractC0787oF, abstractC0788oG, zShowDebugScreen, i4, f);
        }
        poseStack.popPose();
        int i5 = 0;
        for (C1010sQ c1010sQ : abstractC0788oG.m3742z()) {
            int i6 = i5;
            i5++;
            c1010sQ.m5476a(guiGraphics, font, i2 + (i / 4), (i3 / 2) + ((c1010sQ.getHeight() + 3) * i6), f);
        }
        Camera mainCamera = minecraft.gameRenderer.getMainCamera();
        AbstractC0790oI<?> abstractC0790oIM3582b = abstractC0787oF.m3582b();
        Iterator<C0868ph> it = abstractC0788oG.m3707x().iterator();
        while (it.hasNext()) {
            it.next().m4359a(mainCamera, localPlayer, poseStack, guiGraphics, abstractC0790oIM3582b, f);
        }
        UUID uuid = localPlayer.getUUID();
        if (abstractC0788oG.mo3719bi() && C0367gJ.m1760a(abstractC0787oF, uuid) != null && minecraft.level != null && (c0796oOM3793a = abstractC0790oIM3582b.m3793a(uuid)) != null) {
            int iGuiHeight = guiGraphics.guiHeight();
            float fAbs = 0.7f + (0.3f * Math.abs(Mth.sin(C0119bk.m366g() / 8.0f)));
            for (AbstractClientPlayer abstractClientPlayer : minecraft.level.players()) {
                UUID uuid2 = abstractClientPlayer.getUUID();
                if (!uuid2.equals(uuid) && !abstractClientPlayer.isDeadOrDying() && (c0796oOM3793a2 = abstractC0790oIM3582b.m3793a(uuid2)) != null && c0796oOM3793a2.getName().equals(c0796oOM3793a.getName())) {
                    C0324fT c0324fT = (C0324fT) c0326fV.m1133a((Player) abstractClientPlayer);
                    ResourceLocation resourceLocation = null;
                    boolean z = false;
                    if (c0324fT.m1666ah() > 0 && c0324fT.m1665a() == EnumC0807oZ.MEDIC) {
                        resourceLocation = f1350as;
                        z = true;
                    }
                    if (resourceLocation == null && C0367gJ.m1759c(abstractClientPlayer) && localPlayer.hasLineOfSight(abstractClientPlayer)) {
                        resourceLocation = f1349ar;
                    }
                    if (resourceLocation != null) {
                        float fM7863i = fAbs;
                        if (!z) {
                            fM7863i *= C1290xm.m7863i((float) abstractClientPlayer.position().distanceTo(localPlayer.position()), f1351dm, f1352dn);
                            if (fM7863i <= 0.0f) {
                            }
                        }
                        C0119bk.m551a(poseStack, guiGraphics, resourceLocation, abstractClientPlayer.getPosition(f).add(0.0d, 1.25d, 0.0d), mainCamera, i, iGuiHeight, 8, 8, fM7863i * 0.5f, ColorReferences.COLOR_WHITE, 32, false, f);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1029a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0788oG<?, ?> abstractC0788oG, int i, int i2, float f) {
        C1011sR c1011sRM3737a = abstractC0788oG.m3737a();
        if (c1011sRM3737a != null) {
            c1011sRM3737a.m5478a(minecraft, c0622l, c0326fV, guiGraphics, font, i, i2, f);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.cj$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cj$a.class */
    public static class a {

        /* JADX INFO: renamed from: at */
        @NotNull
        private static final ResourceLocation f1414at = C0564jv.m2555d("textures/gui/kill.png");

        /* JADX INFO: renamed from: au */
        @NotNull
        private static final ResourceLocation f1415au = C0564jv.m2555d("textures/gui/kill_flash.png");

        /* JADX INFO: renamed from: du */
        private float f1416du = 0.0f;

        /* JADX INFO: renamed from: dv */
        private float f1417dv = 1.0f;

        /* JADX INFO: renamed from: a */
        public void m1030a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, float f) {
            poseStack.pushPose();
            poseStack.translate(0.0f, 25.0f * (1.0f - this.f1416du), 0.0f);
            float f2 = f / 2.0f;
            this.f1416du = Mth.lerp(f2, this.f1416du, 1.0f);
            this.f1417dv = Mth.lerp(f2 / 4.0f, this.f1417dv, 0.0f);
            C0119bk.m433a(poseStack, guiGraphics, f1414at, i, i2, i3, i3, this.f1416du);
            C0119bk.m433a(poseStack, guiGraphics, f1415au, i, i2, i3, i3, this.f1417dv * this.f1416du);
            poseStack.popPose();
        }

        /* JADX INFO: renamed from: r */
        public float m1031r() {
            return this.f1416du;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.cj$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cj$b.class */
    public static class b {

        /* JADX INFO: renamed from: av */
        @NotNull
        private final ResourceLocation f1418av;

        /* JADX INFO: renamed from: aD */
        private float f1419aD;

        /* JADX INFO: renamed from: aE */
        private float f1420aE;

        public b(@NotNull Random random, @NotNull a aVar) {
            this.f1419aD = 0.8f - (0.2f * random.nextFloat());
            this.f1420aE = this.f1419aD;
            this.f1418av = C0564jv.m2555d("textures/gui/overlay/" + aVar.f1421id + random.nextInt(aVar.textureCount) + ".png");
        }

        /* JADX INFO: renamed from: c */
        public void m1032c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
            float fM7843e = C1290xm.m7843e(this.f1419aD, this.f1420aE, f);
            if (fM7843e > 0.0f) {
                C0119bk.m433a(poseStack, guiGraphics, this.f1418av, 0, 0, i, i2, fM7843e);
            }
        }

        /* JADX INFO: renamed from: k */
        public boolean m1033k() {
            this.f1420aE = this.f1419aD;
            this.f1419aD = C1290xm.m7835d(this.f1419aD, 0.0f, 0.005f);
            return this.f1419aD + this.f1420aE == 0.0f;
        }

        /* JADX INFO: renamed from: com.boehmod.blockfront.cj$b$a */
        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cj$b$a.class */
        public enum a {
            BLOOD("blood", 7),
            DIRT("dirt", 5),
            SNOW("snow", 5),
            SPICE_GOLD("spice_gold", 7),
            SPICE_RED("spice_red", 7),
            SPICE_WHITE("spice_white", 7);


            /* JADX INFO: renamed from: id */
            private final String f1421id;
            private final int textureCount;

            a(@NotNull String str, int i) {
                this.f1421id = str;
                this.textureCount = i;
            }
        }
    }
}
