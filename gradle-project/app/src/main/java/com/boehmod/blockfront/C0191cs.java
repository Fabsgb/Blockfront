package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p001mm.MatchParty;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cs */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cs.class */
public final class C0191cs extends AbstractC0195cw {

    /* JADX INFO: renamed from: eg */
    public static final int f1457eg = 4;

    /* JADX INFO: renamed from: eh */
    public static final int f1458eh = 100;

    /* JADX INFO: renamed from: ei */
    private static final int f1459ei = 100;

    /* JADX INFO: renamed from: dr */
    public static final float f1460dr = 0.75f;

    /* JADX INFO: renamed from: ds */
    private static final float f1467ds = 32.0f;

    /* JADX INFO: renamed from: dt */
    private static final float f1468dt = 37.0f;

    /* JADX INFO: renamed from: ej */
    private static final int f1470ej = 15;

    /* JADX INFO: renamed from: ek */
    private static final int f1480ek = 16;

    /* JADX INFO: renamed from: el */
    private static final int f1481el = 2;

    /* JADX INFO: renamed from: em */
    private static final int f1482em = 512;

    /* JADX INFO: renamed from: du */
    private static final float f1483du = 1.0f;

    /* JADX INFO: renamed from: dv */
    private static final float f1484dv = 1.25f;

    /* JADX INFO: renamed from: en */
    private static final int f1485en = 24;

    /* JADX INFO: renamed from: eo */
    private static final int f1486eo = 24;

    /* JADX INFO: renamed from: ep */
    private static final int f1487ep = 99;

    /* JADX INFO: renamed from: eq */
    private static final int f1488eq = 15;

    /* JADX INFO: renamed from: er */
    private static final int f1489er = 102;

    /* JADX INFO: renamed from: es */
    private static final int f1490es = 15;

    /* JADX INFO: renamed from: et */
    private static final int f1491et = 64;

    /* JADX INFO: renamed from: eu */
    private static final int f1492eu = 102;

    /* JADX INFO: renamed from: ev */
    private static final int f1493ev = 15;

    /* JADX INFO: renamed from: ew */
    public static final int f1494ew = 15;

    /* JADX INFO: renamed from: ex */
    public static final int f1495ex = 8;

    /* JADX INFO: renamed from: ey */
    public static int f1496ey;

    /* JADX INFO: renamed from: ez */
    public static int f1497ez;

    /* JADX INFO: renamed from: eA */
    public static int f1498eA;

    /* JADX INFO: renamed from: eB */
    private static final int f1499eB = 8;

    /* JADX INFO: renamed from: eC */
    private static int f1501eC;

    /* JADX INFO: renamed from: eD */
    private static int f1502eD;

    /* JADX INFO: renamed from: dw */
    private static float f1503dw;

    /* JADX INFO: renamed from: dx */
    private static float f1504dx;

    /* JADX INFO: renamed from: dy */
    private static float f1506dy;

    /* JADX INFO: renamed from: dz */
    private static float f1507dz;

    /* JADX INFO: renamed from: a */
    @Nullable
    private static C0872pk f1508a;

    /* JADX INFO: renamed from: l */
    @Nullable
    private static FormattedCharSequence f1513l;

    /* JADX INFO: renamed from: m */
    @Nullable
    private static FormattedCharSequence f1514m;

    /* JADX INFO: renamed from: n */
    @Nullable
    private static FormattedCharSequence f1515n;

    /* JADX INFO: renamed from: o */
    @Nullable
    private static FormattedCharSequence f1516o;

    /* JADX INFO: renamed from: eF */
    private static int f1517eF;

    /* JADX INFO: renamed from: H */
    @Nullable
    private static String f1518H;

    /* JADX INFO: renamed from: eG */
    private static int f1519eG;

    /* JADX INFO: renamed from: b */
    @NotNull
    private static FormattedCharSequence[] f1520b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static String[] f1521a;

    /* JADX INFO: renamed from: p */
    @NotNull
    private static final FormattedCharSequence f1522p;

    /* JADX INFO: renamed from: q */
    @Nullable
    private static FormattedCharSequence f1523q;

    /* JADX INFO: renamed from: eH */
    private static int f1524eH;

    /* JADX INFO: renamed from: eI */
    private static int f1525eI;

    /* JADX INFO: renamed from: r */
    @NotNull
    private static FormattedCharSequence f1526r;

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final int[] f1527h;

    /* JADX INFO: renamed from: c */
    @NotNull
    private static final FormattedCharSequence[] f1528c;

    /* JADX INFO: renamed from: eJ */
    private static int f1529eJ;

    /* JADX INFO: renamed from: eK */
    private static int f1530eK;

    /* JADX INFO: renamed from: s */
    @NotNull
    private static FormattedCharSequence f1531s;

    /* JADX INFO: renamed from: t */
    @NotNull
    private static FormattedCharSequence f1532t;

    /* JADX INFO: renamed from: eL */
    private static int f1533eL;

    /* JADX INFO: renamed from: u */
    @NotNull
    private static FormattedCharSequence f1534u;

    /* JADX INFO: renamed from: eM */
    private static int f1535eM;

    /* JADX INFO: renamed from: aW */
    private static boolean f1536aW;

    /* JADX INFO: renamed from: v */
    @NotNull
    private static FormattedCharSequence f1537v;

    /* JADX INFO: renamed from: an */
    @NotNull
    private static final ResourceLocation f1461an = C0532jO.m2378d("textures/gui/game/health_bar.png");

    /* JADX INFO: renamed from: ao */
    @NotNull
    private static final ResourceLocation f1462ao = C0532jO.m2378d("textures/gui/game/health.png");

    /* JADX INFO: renamed from: ap */
    @NotNull
    private static final ResourceLocation f1463ap = C0532jO.m2378d("textures/gui/game/health_vehicle.png");

    /* JADX INFO: renamed from: aq */
    @NotNull
    private static final ResourceLocation f1464aq = C0532jO.m2378d("textures/gui/menu/icons/spectator.png");

    /* JADX INFO: renamed from: ar */
    @NotNull
    private static final ResourceLocation f1465ar = C0532jO.m2378d("textures/misc/waypoints/waypoint_player_injured.png");

    /* JADX INFO: renamed from: as */
    @NotNull
    private static final ResourceLocation f1466as = C0532jO.m2378d("textures/misc/waypoints/waypoint_player_injured_callout.png");

    /* JADX INFO: renamed from: aX */
    @NotNull
    private static final Component f1469aX = Component.translatable("bf.message.dead.countdown.soon");

    /* JADX INFO: renamed from: aY */
    @NotNull
    private static final Component f1471aY = Component.translatable("bf.spectate.nobody");

    /* JADX INFO: renamed from: aZ */
    @NotNull
    private static final Component f1472aZ = Component.translatable("bf.message.reloading");

    /* JADX INFO: renamed from: ba */
    @NotNull
    private static final Component f1473ba = Component.translatable("bf.message.none").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: bb */
    @NotNull
    private static final Component f1474bb = Component.translatable("bf.item.radio.resupplying");

    /* JADX INFO: renamed from: bc */
    @NotNull
    private static final Component f1475bc = Component.translatable("bf.item.radio.preparing");

    /* JADX INFO: renamed from: bd */
    @NotNull
    private static final Component f1476bd = Component.translatable("bf.message.ammo").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: be */
    @NotNull
    private static final Component f1477be = Component.literal("mph").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final DecimalFormat f1478a = new DecimalFormat("0.0");

    /* JADX INFO: renamed from: x */
    @NotNull
    private static final ObjectList<a> f1479x = new ObjectArrayList();

    /* JADX INFO: renamed from: h */
    @NotNull
    private static FormattedCharSequence f1500h = FormattedCharSequence.EMPTY;

    /* JADX INFO: renamed from: eE */
    private static int f1505eE = -1;

    /* JADX INFO: renamed from: i */
    @NotNull
    private static FormattedCharSequence f1509i = Component.literal("1").getVisualOrderText();

    /* JADX INFO: renamed from: j */
    @NotNull
    private static FormattedCharSequence f1510j = Component.literal("2").getVisualOrderText();

    /* JADX INFO: renamed from: k */
    @NotNull
    private static FormattedCharSequence f1511k = Component.literal("3").getVisualOrderText();

    /* JADX INFO: renamed from: a */
    private static final FormattedCharSequence[] f1512a = new FormattedCharSequence[4];

    static {
        for (int i = 0; i < 4; i++) {
            f1512a[i] = Component.literal(String.valueOf(4 + i)).getVisualOrderText();
        }
        f1517eF = Integer.MIN_VALUE;
        f1519eG = Integer.MIN_VALUE;
        f1520b = new FormattedCharSequence[0];
        f1521a = new String[0];
        f1522p = f1477be.getVisualOrderText();
        f1524eH = Integer.MIN_VALUE;
        f1525eI = Integer.MIN_VALUE;
        f1526r = FormattedCharSequence.EMPTY;
        f1527h = new int[4];
        f1528c = new FormattedCharSequence[4];
        f1529eJ = Integer.MIN_VALUE;
        f1530eK = Integer.MIN_VALUE;
        f1531s = FormattedCharSequence.EMPTY;
        f1532t = FormattedCharSequence.EMPTY;
        f1533eL = -1;
        f1534u = FormattedCharSequence.EMPTY;
        f1535eM = -1;
        f1537v = FormattedCharSequence.EMPTY;
    }

    /* JADX INFO: renamed from: a */
    public static void m1189a(@NotNull Minecraft minecraft, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, @Nullable LocalPlayer localPlayer, @NotNull C0394gj c0394gj) {
        if (localPlayer != null) {
            m1190c(minecraft, localPlayer);
        }
        if (abstractC0863pb == null || localPlayer == null) {
            return;
        }
        C0872pk c0872pkM4229a = abstractC0863pb.m4018b().m4229a(localPlayer.getUUID());
        if (c0872pkM4229a != null && c0872pkM4229a != f1508a) {
            f1508a = c0872pkM4229a;
            m1193a(c0872pkM4229a);
        }
        f1507dz = f1506dy;
        f1506dy = c0872pkM4229a == null ? 0.0f : c0872pkM4229a.m4303a(C1102uA.f6003b.getCooldownStat(), 0);
        m1194a(abstractC0863pb, localPlayer, c0394gj);
        m1191a(abstractC0863pb, localPlayer);
        m1192e(localPlayer);
    }

    /* JADX INFO: renamed from: c */
    private static void m1190c(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer) {
        MutableComponent name;
        f1504dx = f1503dw;
        Inventory inventory = localPlayer.getInventory();
        ItemStack selected = inventory.getSelected();
        if (inventory.selected != f1505eE) {
            f1505eE = inventory.selected;
            if (selected.isEmpty()) {
                name = Component.empty();
            } else {
                Item item = selected.getItem();
                if (item instanceof AbstractC1140um) {
                    name = AbstractC1140um.m6570a(selected);
                } else {
                    name = item.getName(selected);
                }
            }
            f1500h = name.getVisualOrderText();
            f1501eC = minecraft.font.width(f1500h);
            f1502eD = 8;
            f1504dx = 1.0f;
            f1503dw = 1.0f;
        }
        if (f1502eD > 0) {
            f1502eD--;
        } else {
            f1503dw = Mth.lerp(0.4f, f1503dw, 0.0f);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1191a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer) {
        int iM4289a = abstractC0863pb.m4034a(localPlayer.getUUID()).m4289a(C1062tN.f5767E.getKey());
        if (f1479x.size() > iM4289a) {
            f1479x.clear();
        } else {
            while (f1479x.size() < iM4289a) {
                f1479x.add(new a());
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private static void m1192e(@NotNull LocalPlayer localPlayer) {
        Entity vehicle = localPlayer.getVehicle();
        if (!(vehicle instanceof AbstractC0750nU)) {
            f1514m = null;
            f1515n = null;
            f1516o = null;
            return;
        }
        AbstractC0750nU abstractC0750nU = (AbstractC0750nU) vehicle;
        int iM3444aF = (int) abstractC0750nU.m3444aF();
        if (f1514m == null || iM3444aF != f1517eF) {
            f1517eF = iM3444aF;
            f1514m = Component.literal(String.valueOf(iM3444aF)).withStyle(ChatFormatting.BOLD).getVisualOrderText();
        }
        String str = f1478a.format(((double) (abstractC0750nU.m3442aE() * 20.0f)) * 2.237d);
        if (f1515n == null || !str.equals(f1518H)) {
            f1518H = str;
            f1515n = Component.literal(str).getVisualOrderText();
        }
        int iM3484a = Integer.MIN_VALUE;
        C0755nZ c0755nZM3472a = abstractC0750nU.m3472a((Entity) localPlayer);
        if (c0755nZM3472a != null && (abstractC0750nU instanceof AbstractC0752nW)) {
            AbstractC0752nW abstractC0752nW = (AbstractC0752nW) abstractC0750nU;
            for (AbstractC0818oj<?> abstractC0818oj : c0755nZM3472a.m3514c()) {
                if (abstractC0818oj instanceof C0816oh) {
                    iM3484a = abstractC0752nW.m3479a((C0816oh) abstractC0818oj).m3484a(abstractC0752nW.getEntityData());
                    break;
                }
            }
        }
        if (iM3484a == Integer.MIN_VALUE) {
            f1516o = null;
        } else if (f1516o == null || iM3484a != f1519eG) {
            f1519eG = iM3484a;
            f1516o = Component.literal(String.valueOf(iM3484a)).getVisualOrderText();
        }
        int size = abstractC0750nU.m3436b().f4372aq.size();
        if (f1520b.length != size) {
            f1520b = new FormattedCharSequence[size];
            f1521a = new String[size];
        }
        List passengers = abstractC0750nU.getPassengers();
        int i = 0;
        while (i < size) {
            String scoreboardName = i < passengers.size() ? ((Entity) passengers.get(i)).getScoreboardName() : null;
            if (f1520b[i] == null || !Objects.equals(scoreboardName, f1521a[i])) {
                f1521a[i] = scoreboardName;
                f1520b[i] = (scoreboardName == null ? f1473ba : Component.literal(scoreboardName)).getVisualOrderText();
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1193a(@NotNull C0872pk c0872pk) {
        Style styleM4312a = c0872pk.m4312a();
        f1509i = Component.literal("1").withStyle(styleM4312a).getVisualOrderText();
        f1510j = Component.literal("2").withStyle(styleM4312a).getVisualOrderText();
        f1511k = Component.literal("3").withStyle(styleM4312a).getVisualOrderText();
        for (int i = 0; i < 4; i++) {
            f1512a[i] = Component.literal(String.valueOf(4 + i)).withStyle(styleM4312a).getVisualOrderText();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1194a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull C0394gj c0394gj) {
        if (C0875pn.m4488a((Player) localPlayer, (AbstractC0183b<?, ?, ?, ?>) c0394gj) || !(abstractC0863pb instanceof InterfaceC0945rD)) {
            f1513l = null;
            return;
        }
        int iM4289a = abstractC0863pb.m4034a(localPlayer.getUUID()).m4289a(C1062tN.f5762z.getKey());
        if (iM4289a <= 0) {
            f1513l = null;
            return;
        }
        int i = iM4289a / 20;
        if (f1513l == null || i != f1524eH) {
            f1524eH = i;
            f1513l = Component.translatable("bf.message.ingame.warcry", new Object[]{Component.literal(C1296xj.f7482d.getKey().getDisplayName().getString().toUpperCase(Locale.ROOT)).withColor(ColorReferences.COLOR_WHITE), Component.literal(String.valueOf(i)).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.RED).getVisualOrderText();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1195a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull C0394gj c0394gj, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2) {
        Component componentMo4141a;
        MutableComponent mutableComponentAppend = Component.empty().append(f1471aY).append(C0125bp.m439a(C0129bt.m466g()));
        UUID uuidR = c0394gj.m1116r();
        if (uuidR != null && minecraft.level != null && minecraft.level.getPlayerByUUID(uuidR) != null) {
            mutableComponentAppend = ((C0396gl) c0623l.m2855a()).mo1154a(uuidR).m2515b();
        }
        int i3 = (i2 - 15) - 4;
        int i4 = i3 - 19;
        m1196a(guiGraphics, font, (Component) Component.translatable("bf.spectate.cycle.hint", new Object[]{C1296xj.f7484f.getTranslatedKeyMessage(), C1296xj.f7483e.getTranslatedKeyMessage()}), i, i3);
        m1196a(guiGraphics, font, (Component) Component.translatable("bf.spectate.watching", new Object[]{mutableComponentAppend}), i, i4);
        AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623l.m2878a();
        if (abstractC0864pcM2878a != null && (componentMo4141a = abstractC0864pcM2878a.mo4141a(minecraft, c0623l, localPlayer, c0394gj)) != null) {
            m1196a(guiGraphics, font, componentMo4141a, i, i4 - 19);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1196a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Component component, int i, int i2) {
        int iWidth = font.width(component) + 6;
        C0129bt.m518b(guiGraphics, i - (iWidth / 2), i2, iWidth, 15, C0129bt.m465t());
        C0129bt.m501a(guiGraphics.pose(), font, guiGraphics, component, i, i2 + 4, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: a */
    private static void m1197a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, int i, int i2, int i3) {
        if (i != f1529eJ) {
            f1529eJ = i;
            f1531s = Component.literal(String.valueOf(i)).getVisualOrderText();
        }
        if (i2 != f1530eK) {
            f1530eK = i2;
            f1532t = Component.literal(String.valueOf(i2)).getVisualOrderText();
        }
        int i4 = (((i3 - 15) - 4) - 15) - 4;
        int iM1198a = 4;
        if (i > 0) {
            iM1198a = 4 + m1198a(guiGraphics, font, f1531s, 4, i4, ColorReferences.COLOR_WHITE) + 4;
        }
        if (i2 > 0) {
            C0872pk c0872pkM4229a = abstractC0863pb.m4018b().m4229a(localPlayer.getUUID());
            m1198a(guiGraphics, font, f1532t, iM1198a, i4, c0872pkM4229a != null ? c0872pkM4229a.getColor() : ColorReferences.COLOR_WHITE);
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m1198a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2, int i3) {
        int iWidth = 17 + font.width(formattedCharSequence) + 4;
        C0129bt.m518b(guiGraphics, i, i2, iWidth, 15, C0129bt.m465t());
        C0129bt.m537a(guiGraphics.pose(), guiGraphics, f1464aq, i, i2, 15, 15, 0.0f, 1.0f, i3);
        C0129bt.m505b(font, guiGraphics, formattedCharSequence, i + 15 + 2, i2 + 4, i3);
        return iWidth;
    }

    /* JADX INFO: renamed from: a */
    private static void m1199a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2) {
        if (f1513l == null) {
            return;
        }
        C0129bt.m509a(guiGraphics.pose(), font, guiGraphics, f1513l, i, i2);
    }

    /* JADX INFO: renamed from: a */
    public void m1200a(@NotNull Font font, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0864pc<?, ?> abstractC0864pc, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, int i, int i2, float f, float f2) {
        int iM465t = C0129bt.m465t();
        C0872pk c0872pkM4229a = abstractC0863pb.m4018b().m4229a(localPlayer.getUUID());
        if (c0872pkM4229a == null) {
            return;
        }
        c0872pkM4229a.m4296a(abstractC0863pb);
        float f3 = f1487ep / 2.0f;
        float f4 = 30 / 2.0f;
        int i3 = i - (f1487ep + 4);
        int i4 = i2 - 137;
        Inventory inventory = localPlayer.getInventory();
        int i5 = inventory.selected;
        TextColor color = c0872pkM4229a.m4312a().getColor();
        int value = color != null ? color.getValue() : ColorReferences.COLOR_WHITE_SOLID;
        float fM7170f = C1270xJ.m7170f(abstractC0864pc.f4691ld, abstractC0864pc.f4692le, f2);
        if (fM7170f < 1.0f && localPlayer.getVehicle() == null) {
            float f5 = (f1487ep + 4 + 10) * fM7170f;
            poseStack.pushPose();
            poseStack.translate(f5, 0.0f, 0.0f);
            ItemStack item = inventory.getItem(0);
            if (i5 == 0) {
                C0129bt.m517a(guiGraphics, i3 + 1, i4 + 1, f1487ep - 2, 30 - 2, value, 0.55f);
            }
            C0129bt.m518b(guiGraphics, i3, i4, f1487ep, 30, iM465t);
            C0129bt.m504b(font, guiGraphics, f1509i, i3 + 2, i4 + 2);
            C0126bq.m441a(poseStack, guiGraphics, item, i3 + f3, i4 + f4, 3.5f);
            ItemStack item2 = inventory.getItem(1);
            int i6 = i4 + 31;
            if (i5 == 1) {
                C0129bt.m517a(guiGraphics, i3 + 1, i6 + 1, f1487ep - 2, 30 - 2, value, 0.55f);
            }
            C0129bt.m518b(guiGraphics, i3, i6, f1487ep, 30, iM465t);
            C0129bt.m504b(font, guiGraphics, f1510j, i3 + 2, i6 + 2);
            C0126bq.m441a(poseStack, guiGraphics, item2, i3 + f3, i6 + f4, 2.5f);
            ItemStack item3 = inventory.getItem(2);
            int i7 = i6 + 31;
            if (i5 == 2) {
                C0129bt.m517a(guiGraphics, i3 + 1, i7 + 1, f1487ep - 2, 30 - 2, value, 0.55f);
            }
            C0129bt.m518b(guiGraphics, i3, i7, f1487ep, 30, iM465t);
            C0129bt.m504b(font, guiGraphics, f1511k, i3 + 2, i7 + 2);
            if (!item3.isEmpty()) {
                C0126bq.m441a(poseStack, guiGraphics, item3, i3 + f3, i7 + f4, 3.1f);
            }
            int i8 = i7 + 31;
            for (int i9 = 0; i9 < 4; i9++) {
                m1201a(font, guiGraphics, poseStack, inventory, i9, i5, i3, i8, value, 0.55f);
                i3 += 25;
            }
            poseStack.popPose();
        }
        int i10 = (i - f1487ep) - 4;
        int i11 = i2 - 19;
        m1202a(minecraft, localPlayer, poseStack, guiGraphics, font, abstractC0863pb, inventory, i, i2, iM465t, value, i10, i11, f1487ep, 15, f, f2);
        m1209a(poseStack, guiGraphics, font, abstractC0864pc, localPlayer, i2 - 15, 15, 102, iM465t, f2);
        m1210a(poseStack, guiGraphics, font, localPlayer, iM465t, i2, 15);
        m1212b(poseStack, guiGraphics, i10, i11, f2);
    }

    /* JADX INFO: renamed from: a */
    private static void m1201a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Inventory inventory, int i, int i2, int i3, int i4, int i5, float f) {
        int iM465t = C0129bt.m465t();
        ItemStack item = inventory.getItem(3 + i);
        int count = item.getCount();
        if (i2 == 3 + i) {
            C0129bt.m517a(guiGraphics, i3 + 1, i4 + 1, 22, 22, i5, f);
        }
        C0129bt.m518b(guiGraphics, i3, i4, 24, 24, iM465t);
        float f2 = 1.0f;
        if (!item.isEmpty() && (item.getItem() instanceof InterfaceC1148uu)) {
            f2 = 1.25f;
        }
        C0126bq.m441a(poseStack, guiGraphics, item, i3 + 12.0f, i4 + 12.0f, f2);
        poseStack.translate(0.0f, 0.0f, 512.0f);
        C0129bt.m504b(font, guiGraphics, f1512a[i], i3 + 2, i4 + 2);
        if (count > 1) {
            if (count != f1527h[i]) {
                f1527h[i] = count;
                f1528c[i] = Component.literal(C1273xM.m7239b(count)).getVisualOrderText();
            }
            C0129bt.m504b(font, guiGraphics, f1528c[i], (i3 + 24) - 7, (i4 + 24) - 9);
        }
        poseStack.translate(0.0f, 0.0f, -512.0f);
    }

    /* JADX INFO: renamed from: a */
    private void m1202a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Inventory inventory, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, float f2) {
        C0129bt.m518b(guiGraphics, i5, i6, i7, i8, i3);
        ItemStack selected = inventory.getSelected();
        if (selected.isEmpty()) {
        }
        Item item = selected.getItem();
        Objects.requireNonNull(item);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), C1117uP.class, C1134ug.class, C1102uA.class, C1109uH.class).dynamicInvoker().invoke(item, 0) /* invoke-custom */) {
            case 0:
                m1205a(minecraft, font, poseStack, guiGraphics, (C1117uP) item, selected, i, i2, i4, i5, i6, i7, i8, f, f2);
                break;
            case 1:
                float attackStrengthScale = localPlayer.getAttackStrengthScale(f2);
                if (attackStrengthScale < 1.0f) {
                    C0129bt.m514a(poseStack, guiGraphics, i5 + 1, i6, (i7 * attackStrengthScale) - 2.0f, 1.0f, ColorReferences.COLOR_WHITE_SOLID);
                }
                m1203a(poseStack, guiGraphics, font, i4, i5, i6, i7);
                break;
            case 2:
                m1204a(localPlayer, poseStack, guiGraphics, font, abstractC0863pb, i4, i5, i6, i7, f, f2);
                break;
            case 3:
                if (((C1109uH) item).mo6228cu() && C0262eJ.m1487K()) {
                    C0129bt.m514a(poseStack, guiGraphics, i5 + 1, i6, (i7 * C0262eJ.m1493u()) - 2.0f, 1.0f, ColorReferences.COLOR_WHITE_SOLID);
                }
                m1203a(poseStack, guiGraphics, font, i4, i5, i6, i7);
                break;
            default:
                m1203a(poseStack, guiGraphics, font, i4, i5, i6, i7);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1203a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, float f, float f2, int i2) {
        float fMin = f1501eC > 0 ? Math.min(1.0f, (i2 - 2) / f1501eC) : 1.0f;
        Objects.requireNonNull(font);
        C0129bt.m512a(poseStack, font, guiGraphics, f1500h, f + (i2 / 2.0f), f2 + 4.0f + ((1.0f - fMin) * 9.0f * 0.5f), i, fMin);
    }

    /* JADX INFO: renamed from: a */
    private void m1204a(@NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, int i, float f, float f2, int i2, float f3, float f4) {
        C0872pk c0872pkM4229a = abstractC0863pb.m4018b().m4229a(localPlayer.getUUID());
        if (c0872pkM4229a == null) {
            return;
        }
        EnumC0960rS enumC0960rS = C1102uA.f6003b;
        int iM4303a = c0872pkM4229a.m4303a(enumC0960rS.getCooldownStat(), 0);
        float f5 = f + (i2 / 2.0f);
        if (iM4303a <= 0) {
            m1203a(poseStack, guiGraphics, font, i, f, f2, i2);
            return;
        }
        C0129bt.m514a(poseStack, guiGraphics, f + 1.0f, f2, (C1270xJ.m7170f(f1506dy, f1507dz, f4) * (i2 - 2)) / enumC0960rS.getMaxCooldown(), 1.0f, ColorReferences.COLOR_WHITE_SOLID);
        boolean zIsWaypoint = enumC0960rS.isWaypoint();
        String strM439a = C0125bp.m439a(f3);
        if (strM439a.length() != f1535eM || zIsWaypoint != f1536aW) {
            f1535eM = strM439a.length();
            f1536aW = zIsWaypoint;
            f1537v = (zIsWaypoint ? f1475bc : f1474bb).copy().append(Component.literal(strM439a)).getVisualOrderText();
        }
        C0129bt.m510b(poseStack, font, guiGraphics, f1537v, f5, f2 + 4.0f, i);
    }

    /* JADX INFO: renamed from: a */
    private static void m1205a(@NotNull Minecraft minecraft, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull C1117uP c1117uP, @NotNull ItemStack itemStack, int i, int i2, int i3, float f, float f2, int i4, int i5, float f3, float f4) {
        int iM6402cq = c1117uP.m6283a(itemStack).m6402cq();
        Style styleWithColor = Style.EMPTY.withColor(ChatFormatting.WHITE);
        if (f1496ey < iM6402cq / 2) {
            styleWithColor = Style.EMPTY.withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);
            if (f1496ey < iM6402cq / 4) {
                styleWithColor = Style.EMPTY.withColor(ChatFormatting.RED);
            }
        }
        if (!C0486iV.m2182aa()) {
            float fM7170f = C1270xJ.m7170f(f1503dw, f1504dx, f4);
            C0129bt.m618a(guiGraphics, (int) f, (int) f2, i4, i5);
            poseStack.pushPose();
            poseStack.translate(0.0f, i5 * fM7170f, 0.0f);
            c1117uP.m6300a().mo6256a(minecraft, poseStack, guiGraphics, font, c1117uP, itemStack, styleWithColor, i3, f, f2, i4, i5, i, i2, f4);
            poseStack.popPose();
            if (fM7170f > 0.0f) {
                float fMin = f1501eC > 0 ? Math.min(1.0f, (i4 - 2) / f1501eC) : 1.0f;
                Objects.requireNonNull(font);
                poseStack.pushPose();
                poseStack.translate(0.0f, (-i5) * (1.0f - fM7170f), 0.0f);
                C0129bt.m512a(poseStack, font, guiGraphics, f1500h, f + (i4 / 2.0f), f2 + 4.0f + ((1.0f - fMin) * 9.0f * 0.5f), C1270xJ.m7159a(i3, fM7170f), fMin);
                poseStack.popPose();
            }
            guiGraphics.disableScissor();
            return;
        }
        float fM2186o = (C0486iV.m2186o(f4) * i4) / Math.max(1.0f, C0486iV.m2185Y());
        String strM439a = C0125bp.m439a(f3);
        if (strM439a.length() != f1533eL) {
            f1533eL = strM439a.length();
            f1534u = f1472aZ.copy().append(Component.literal(strM439a)).getVisualOrderText();
        }
        C0129bt.m514a(poseStack, guiGraphics, f + 1.0f, f2, fM2186o - 2.0f, 1.0f, ColorReferences.COLOR_WHITE_SOLID);
        C0129bt.m510b(poseStack, font, guiGraphics, f1534u, f + (i4 / 2.0f), f2 + 4.0f, i3);
    }

    /* JADX INFO: renamed from: J */
    public static void m1206J() {
        f1497ez = f1496ey;
        f1496ey = C0486iV.m2179aw();
        f1498eA = C0486iV.m2181ax();
    }

    /* JADX INFO: renamed from: a */
    public static void m1207a(@NotNull Minecraft minecraft, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull C1117uP c1117uP, @NotNull ItemStack itemStack, int i, int i2, float f, float f2) {
        int iM465t = C0129bt.m465t();
        int i3 = ColorReferences.COLOR_WHITE_SOLID;
        int i4 = i - 105;
        int i5 = i2 - 21;
        C0129bt.m518b(guiGraphics, i4, i5, f1487ep, 15, iM465t);
        m1205a(minecraft, font, poseStack, guiGraphics, c1117uP, itemStack, i, i2, i3, i4, i5, f1487ep, 15, f, f2);
    }

    /* JADX INFO: renamed from: a */
    private void m1208a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull LocalPlayer localPlayer, @NotNull Collection<C0134by> collection) {
        C0127br.m448a(poseStack, guiGraphics, font, localPlayer, collection, 4, 4, 0.75f, 100, 100);
    }

    /* JADX INFO: renamed from: a */
    private void m1209a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0864pc<?, ?> abstractC0864pc, @NotNull LocalPlayer localPlayer, int i, int i2, int i3, int i4, float f) {
        float fM4115B = abstractC0864pc.m4115B(f);
        float fM7170f = C1270xJ.m7170f(C0116bg.f792cd, C0116bg.f793ce, f);
        int i5 = i - 4;
        float f2 = (64.0f * fM7170f) / 20.0f;
        C0129bt.m518b(guiGraphics, 4, i5, i3, i2, i4);
        C0129bt.m531a(poseStack, guiGraphics, f1462ao, 4, i5, i2, i2);
        int iMax = Math.max((int) fM7170f, 1);
        if (iMax != f1525eI) {
            f1525eI = iMax;
            f1526r = Component.literal(String.valueOf(iMax)).withStyle(ChatFormatting.BOLD).getVisualOrderText();
        }
        C0129bt.m509a(poseStack, font, guiGraphics, f1526r, 30.0f, i5 + 4);
        C0129bt.m515a(guiGraphics, 40, i5 + 4, 64, 7, i4);
        int i6 = i5 + 4;
        C0129bt.m618a(guiGraphics, 40, i6, (int) f2, 7);
        C0129bt.m531a(poseStack, guiGraphics, f1461an, 40, i6, 64, 7);
        guiGraphics.disableScissor();
        if (C0116bg.f792cd <= 5.0f) {
            C0129bt.m514a(poseStack, guiGraphics, 40.0f, i - 2, f2, 7.0f, ColorReferences.COLOR_THEME_RED);
        }
        int foodLevel = localPlayer.getFoodData().getFoodLevel();
        if (fM4115B < 20.0f) {
            C0129bt.m514a(poseStack, guiGraphics, 5.0f, i5, ((i3 - 2) * fM4115B) / 20.0f, 1.0f, foodLevel <= 1 ? ColorReferences.COLOR_BLACK_SOLID + C0129bt.f861cu : ColorReferences.COLOR_WHITE_SOLID);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1210a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull LocalPlayer localPlayer, int i, int i2, int i3) {
        Entity vehicle = localPlayer.getVehicle();
        if (vehicle instanceof AbstractC0750nU) {
            AbstractC0750nU abstractC0750nU = (AbstractC0750nU) vehicle;
            FormattedCharSequence formattedCharSequence = f1514m;
            FormattedCharSequence formattedCharSequence2 = f1515n;
            if (formattedCharSequence == null || formattedCharSequence2 == null) {
                return;
            }
            C0809oa<AbstractC0750nU> c0809oaM3436b = abstractC0750nU.m3436b();
            float fM3444aF = abstractC0750nU.m3444aF();
            int i4 = ((i2 - 15) - 4) - (i3 + 1);
            float f = 64.0f * (fM3444aF / c0809oaM3436b.f4377kv);
            C0129bt.m515a(guiGraphics, 4, i4, 102, 15, i);
            C0129bt.m531a(poseStack, guiGraphics, f1463ap, 4, i4, 15, 15);
            C0129bt.m509a(poseStack, font, guiGraphics, formattedCharSequence, 30.0f, i4 + 4);
            C0129bt.m515a(guiGraphics, 40, i4 + 4, 64, 7, i);
            int i5 = i4 + 4;
            C0129bt.m618a(guiGraphics, 40, i5, (int) f, 7);
            C0129bt.m531a(poseStack, guiGraphics, f1461an, 40, i5, 64, 7);
            guiGraphics.disableScissor();
            int i6 = (i3 * 2) + 1;
            C0129bt.m515a(guiGraphics, 107, i4, i6, i6, i);
            C0129bt.m511a(poseStack, font, guiGraphics, formattedCharSequence2, 107 + (i6 / 2), i4 + 5, 1.5f);
            C0129bt.m507c(font, guiGraphics, f1522p, 107 + (i6 / 2), i4 + 18);
            FormattedCharSequence formattedCharSequence3 = f1516o;
            if (formattedCharSequence3 != null) {
                if (f1523q == null) {
                    f1523q = f1476bd.getVisualOrderText();
                }
                C0129bt.m515a(guiGraphics, 107 + i6 + 1, i4, i6, i6, i);
                C0129bt.m511a(poseStack, font, guiGraphics, formattedCharSequence3, 107 + i6 + 1 + (i6 / 2), i4 + 5, 1.5f);
                C0129bt.m507c(font, guiGraphics, f1523q, 107 + i6 + 1 + (i6 / 2), i4 + 18);
            }
            int iGuiWidth = (guiGraphics.guiWidth() - f1487ep) - 4;
            int i7 = i2 - 42;
            int i8 = 0;
            int size = c0809oaM3436b.f4372aq.size();
            for (int i9 = 0; i9 < size; i9++) {
                C0755nZ c0755nZ = c0809oaM3436b.f4372aq.get(i9);
                int i10 = i7 - (21 * i8);
                C0129bt.m515a(guiGraphics, iGuiWidth, i10, f1487ep, 20, i);
                C0129bt.m533a(poseStack, guiGraphics, c0755nZ.getIcon(), iGuiWidth, i10, 20, 20, 2.0f);
                if (i9 < f1520b.length && f1520b[i9] != null) {
                    C0129bt.m507c(font, guiGraphics, f1520b[i9], iGuiWidth + 49, (i10 + 10) - 3);
                }
                i8++;
            }
        }
    }

    /* JADX INFO: renamed from: y */
    private static int m1211y() {
        int i = 138;
        if (f1516o != null) {
            i = 138 + 32;
        }
        return i;
    }

    /* JADX INFO: renamed from: b */
    private void m1212b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        int size = f1479x.size();
        int iMin = (i - 16) - (Math.min(size, 15) * 2);
        int i3 = i2 - 1;
        int i4 = iMin;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i4 += 2;
            ((a) f1479x.get(i6)).m1218a(poseStack, guiGraphics, i4 - 2, i3 + (i6 % 2 == 0 ? 2 : 0) + i5, 16, f);
            if (i6 != 0 && i6 % 15 == 0) {
                i4 = iMin;
                i5 += 4;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1213a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0864pc<? extends AbstractC0863pb<?, ?, ?>, ?> abstractC0864pc, boolean z, int i, float f) {
        List<C0847pL> listM4177A = abstractC0864pc.m4177A();
        if (listM4177A.isEmpty()) {
            return;
        }
        guiGraphics.drawManaged(() -> {
            int size = listM4177A.size();
            for (int i2 = 0; i2 < size; i2++) {
                poseStack.pushPose();
                poseStack.translate(7.0f, i + (i2 * 16), 0.0f);
                ((C0847pL) listM4177A.get(i2)).m3911a(guiGraphics, font, abstractC0863pb, z, f);
                poseStack.popPose();
            }
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0195cw
    /* JADX INFO: renamed from: a */
    public void mo1214a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0623l c0623l) {
        int iM1211y;
        AbstractC0864pc<?, ?> abstractC0864pcM2878a;
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        float fM466g = C0129bt.m466g();
        if (minecraft.options.hideGui || clientLevel == null || localPlayer == null) {
            return;
        }
        if (!C0495ie.f3030j.m2230U()) {
            if (minecraft.options.keyPlayerList.isDown() && (abstractC0864pcM2878a = c0623l.m2878a()) != null) {
                abstractC0864pcM2878a.m4148a(guiGraphics.pose(), guiGraphics, font, minecraft, c0623l, localPlayer, ((C0396gl) c0623l.m2855a()).m1886a(minecraft), guiGraphics.guiWidth(), guiGraphics.guiHeight(), deltaTracker.getGameTimeDeltaPartialTick(true));
                return;
            }
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623l.m2874a();
        if (abstractC0863pbM2874a == null) {
            return;
        }
        float gameTimeDeltaPartialTick = deltaTracker.getGameTimeDeltaPartialTick(true);
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        int i = iGuiWidth / 2;
        int i2 = iGuiHeight / 2;
        C0396gl c0396gl = (C0396gl) c0623l.m2855a();
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        C0394gj c0394gjM1885a = c0396gl.m1885a(minecraft);
        C0555jl c0555jlM1886a = c0396gl.m1886a(minecraft);
        boolean z = c0623l.m2875d() || (localPlayer.isSpectator() && abstractC0863pbM2874a.mo4047bl());
        if (!z && ((C0495ie.f3040t.m2230U() && c0394gjM1885a.m1104dt()) || localPlayer.isDeadOrDying())) {
            C0129bt.m515a(guiGraphics, 0, 0, iGuiWidth, iGuiHeight, ColorReferences.COLOR_BLACK_SOLID);
        }
        if (z && !c0623l.m2895a().m3074aJ()) {
            m1195a(minecraft, c0623l, localPlayer, c0394gjM1885a, guiGraphics, font, i, iGuiHeight);
        }
        int iCJ = c0394gjM1885a.m1120cJ();
        int iCK = c0394gjM1885a.m1121cK();
        if (C0495ie.f3036p.m2230U() && !z && !c0623l.m2895a().m3074aJ() && (iCJ > 0 || iCK > 0)) {
            m1197a(guiGraphics, font, abstractC0863pbM2874a, localPlayer, iCJ, iCK, iGuiHeight);
        }
        C0129bt.m517a(guiGraphics, 0, 0, iGuiWidth, iGuiHeight, 0, Math.max(0.0f, C1270xJ.m7170f(C0055aY.f401bi, C0055aY.f402bj, gameTimeDeltaPartialTick) - 1.0f));
        if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof C1117uP)) {
            m1206J();
        }
        AbstractC0864pc<?, ?> abstractC0864pcM2878a2 = c0623l.m2878a();
        if (abstractC0864pcM2878a2 == null) {
            return;
        }
        Set<UUID> setM4245h = abstractC0863pbM2874a.m4018b().m4245h();
        m1216a(minecraft, c0623l, c0396gl, guiGraphics, font, abstractC0864pcM2878a2, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        m1199a(guiGraphics, font, i, i2);
        abstractC0864pcM2878a2.m4134a(minecraft, c0623l, localPlayer, clientLevel, c0394gjM1885a, guiGraphics, font, poseStackPose, bufferSource, setM4245h, iGuiWidth, iGuiHeight, i, i2, fM466g, gameTimeDeltaPartialTick);
        m1215a(minecraft, localPlayer, abstractC0864pcM2878a2, poseStackPose, guiGraphics, font, abstractC0863pbM2874a, c0396gl, gameTimeDeltaPartialTick, iGuiWidth, i, i2);
        if (!c0623l.m2895a().m3074aJ()) {
            float fM7170f = C1270xJ.m7170f(abstractC0864pcM2878a2.f4693lf, abstractC0864pcM2878a2.f4694lg, gameTimeDeltaPartialTick);
            poseStackPose.pushPose();
            poseStackPose.translate(0.0f, 0.0f, 400.0f);
            C0129bt.m517a(guiGraphics, 0, 0, iGuiWidth, iGuiHeight, ColorReferences.COLOR_BLACK_SOLID, fM7170f);
            poseStackPose.popPose();
            if (!c0394gjM1885a.m1104dt()) {
                m1200a(font, abstractC0863pbM2874a, abstractC0864pcM2878a2, guiGraphics, poseStackPose, minecraft, localPlayer, iGuiWidth, iGuiHeight, fM466g, gameTimeDeltaPartialTick);
                Optional<MatchParty> party = c0555jlM1886a.getParty();
                if (party.isPresent()) {
                    MatchParty matchParty = party.get();
                    int iM1460h = C0256eD.m1460h(15);
                    int iM1459b = C0256eD.m1459b(matchParty, true, iM1460h);
                    if (localPlayer.getVehicle() instanceof AbstractC0750nU) {
                        iM1211y = m1211y() + 4;
                    } else {
                        iM1211y = C0244ds.f1979hd;
                    }
                    C0256eD.m1454a(minecraft, c0623l, poseStackPose, guiGraphics, matchParty, iM1211y + 1, ((iGuiHeight - iM1459b) - 4) + 1, -1, true, true, iM1460h - 2, false);
                }
            }
        }
        if (minecraft.options.keyPlayerList.isDown()) {
            abstractC0864pcM2878a2.m4148a(poseStackPose, guiGraphics, font, minecraft, c0623l, localPlayer, c0555jlM1886a, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1215a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull AbstractC0864pc<? extends AbstractC0863pb<?, ?, ?>, ?> abstractC0864pc, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0396gl c0396gl, float f, int i, int i2, int i3) {
        C0872pk c0872pkM4229a;
        C0872pk c0872pkM4229a2;
        boolean zShowDebugScreen = minecraft.getDebugOverlay().showDebugScreen();
        Collection<C0134by> collectionM4117d = abstractC0864pc.m4117d();
        poseStack.pushPose();
        if (zShowDebugScreen) {
            poseStack.translate(0.0f, 210.0f, 0.0f);
        }
        if (C0495ie.f3033m.m2230U()) {
            m1208a(poseStack, guiGraphics, font, localPlayer, collectionM4117d);
        }
        int i4 = 25;
        if (C0495ie.f3033m.m2230U()) {
            i4 = 25 + 104;
        }
        if ((abstractC0863pb instanceof InterfaceC0990rw) && C0495ie.f3034n.m2230U()) {
            m1213a(poseStack, guiGraphics, font, abstractC0863pb, abstractC0864pc, zShowDebugScreen, i4, f);
        }
        poseStack.popPose();
        int i5 = 0;
        for (C1088tn c1088tn : abstractC0864pc.m4178B()) {
            int i6 = i5;
            i5++;
            c1088tn.m5964a(guiGraphics, font, i2 + (i / 4), (i3 / 2) + ((c1088tn.getHeight() + 3) * i6), f);
        }
        Camera mainCamera = minecraft.gameRenderer.getMainCamera();
        AbstractC0866pe<?> abstractC0866peM4018b = abstractC0863pb.m4018b();
        Iterator<C0839pD> it = abstractC0864pc.m4143z().iterator();
        while (it.hasNext()) {
            it.next().m3844a(mainCamera, localPlayer, poseStack, guiGraphics, abstractC0866peM4018b, f);
        }
        UUID uuid = localPlayer.getUUID();
        if (abstractC0864pc.mo4155bs() && C0384gZ.m1827a(abstractC0863pb, uuid) != null && minecraft.level != null && (c0872pkM4229a = abstractC0866peM4018b.m4229a(uuid)) != null) {
            int iGuiHeight = guiGraphics.guiHeight();
            float fAbs = 0.7f + (0.3f * Math.abs(Mth.sin(C0129bt.m466g() / 8.0f)));
            for (AbstractClientPlayer abstractClientPlayer : minecraft.level.players()) {
                UUID uuid2 = abstractClientPlayer.getUUID();
                if (!uuid2.equals(uuid) && !abstractClientPlayer.isDeadOrDying() && (c0872pkM4229a2 = abstractC0866peM4018b.m4229a(uuid2)) != null && c0872pkM4229a2.getName().equals(c0872pkM4229a.getName())) {
                    C0394gj c0394gj = (C0394gj) c0396gl.m1150a((Player) abstractClientPlayer);
                    ResourceLocation resourceLocation = null;
                    boolean z = false;
                    if (c0394gj.m1876at() > 0 && c0394gj.m1875a() == EnumC0883pv.MEDIC) {
                        resourceLocation = f1466as;
                        z = true;
                    }
                    if (resourceLocation == null && C0384gZ.m1826c(abstractClientPlayer) && localPlayer.hasLineOfSight(abstractClientPlayer)) {
                        resourceLocation = f1465ar;
                    }
                    if (resourceLocation != null) {
                        float fM7190j = fAbs;
                        if (!z) {
                            fM7190j *= C1270xJ.m7190j((float) abstractClientPlayer.position().distanceTo(localPlayer.position()), f1467ds, f1468dt);
                            if (fM7190j <= 0.0f) {
                            }
                        }
                        C0129bt.m654a(poseStack, guiGraphics, resourceLocation, abstractClientPlayer.getPosition(f).add(0.0d, 1.25d, 0.0d), mainCamera, i, iGuiHeight, 8, 8, fM7190j * 0.5f, ColorReferences.COLOR_WHITE, 32, false, f);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1216a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0864pc<?, ?> abstractC0864pc, int i, int i2, float f) {
        C1089to c1089toM4173a = abstractC0864pc.m4173a();
        if (c1089toM4173a != null) {
            c1089toM4173a.m5966a(minecraft, c0623l, c0396gl, guiGraphics, font, i, i2, f);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.cs$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cs$a.class */
    public static class a {

        /* JADX INFO: renamed from: at */
        @NotNull
        private static final ResourceLocation f1538at = C0532jO.m2378d("textures/gui/kill.png");

        /* JADX INFO: renamed from: au */
        @NotNull
        private static final ResourceLocation f1539au = C0532jO.m2378d("textures/gui/kill_flash.png");

        /* JADX INFO: renamed from: dA */
        private float f1540dA = 0.0f;

        /* JADX INFO: renamed from: dB */
        private float f1541dB = 1.0f;

        /* JADX INFO: renamed from: a */
        public void m1218a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, float f) {
            poseStack.pushPose();
            poseStack.translate(0.0f, 25.0f * (1.0f - this.f1540dA), 0.0f);
            float f2 = f / 2.0f;
            this.f1540dA = Mth.lerp(f2, this.f1540dA, 1.0f);
            this.f1541dB = Mth.lerp(f2 / 4.0f, this.f1541dB, 0.0f);
            C0129bt.m533a(poseStack, guiGraphics, f1538at, i, i2, i3, i3, this.f1540dA);
            C0129bt.m533a(poseStack, guiGraphics, f1539au, i, i2, i3, i3, this.f1541dB * this.f1540dA);
            poseStack.popPose();
        }

        /* JADX INFO: renamed from: r */
        public float m1219r() {
            return this.f1540dA;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.cs$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cs$b.class */
    public static class b {

        /* JADX INFO: renamed from: av */
        @NotNull
        private final ResourceLocation f1542av;

        /* JADX INFO: renamed from: aI */
        private float f1543aI;

        /* JADX INFO: renamed from: aJ */
        private float f1544aJ;

        public b(@NotNull Random random, @NotNull a aVar) {
            this.f1543aI = 0.8f - (0.2f * random.nextFloat());
            this.f1544aJ = this.f1543aI;
            this.f1542av = C0532jO.m2378d("textures/gui/overlay/" + aVar.f1545id + random.nextInt(aVar.textureCount) + ".png");
        }

        /* JADX INFO: renamed from: c */
        public void m1220c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
            float fM7170f = C1270xJ.m7170f(this.f1543aI, this.f1544aJ, f);
            if (fM7170f > 0.0f) {
                C0129bt.m533a(poseStack, guiGraphics, this.f1542av, 0, 0, i, i2, fM7170f);
            }
        }

        /* JADX INFO: renamed from: l */
        public boolean m1221l() {
            this.f1544aJ = this.f1543aI;
            this.f1543aI = C1270xJ.m7161d(this.f1543aI, 0.0f, 0.005f);
            return this.f1543aI + this.f1544aJ == 0.0f;
        }

        /* JADX INFO: renamed from: com.boehmod.blockfront.cs$b$a */
        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cs$b$a.class */
        public enum a {
            BLOOD("blood", 7),
            DIRT("dirt", 5),
            SNOW("snow", 5),
            SPICE_GOLD("spice_gold", 7),
            SPICE_RED("spice_red", 7),
            SPICE_WHITE("spice_white", 7);


            /* JADX INFO: renamed from: id */
            private final String f1545id;
            private final int textureCount;

            a(String str, int i) {
                this.f1545id = str;
                this.textureCount = i;
            }
        }
    }
}
