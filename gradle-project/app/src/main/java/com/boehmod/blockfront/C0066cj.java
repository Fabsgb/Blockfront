package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.mm.MatchParty;
import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cj.class */
public final class C0066cj extends AbstractC0070cn {
    public static final int dj = 4;
    public static final int dk = 100;
    private static final int dl = 100;

    /* JADX INFO: renamed from: dl, reason: collision with other field name */
    public static final float f88dl = 0.75f;
    private static final float dm = 32.0f;
    private static final float dn = 37.0f;

    /* JADX INFO: renamed from: dm, reason: collision with other field name */
    private static final int f89dm = 15;

    /* JADX INFO: renamed from: dn, reason: collision with other field name */
    private static final int f90dn = 16;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private static final int f91do = 2;
    private static final int dp = 512;

    /* JADX INFO: renamed from: do, reason: not valid java name and collision with other field name */
    private static final float f92do = 1.0f;

    /* JADX INFO: renamed from: dp, reason: collision with other field name */
    private static final float f93dp = 1.25f;
    private static final int dq = 24;
    private static final int dr = 24;
    private static final int ds = 99;
    private static final int dt = 15;
    private static final int du = 102;
    private static final int dv = 15;
    private static final int dw = 64;
    private static final int dx = 102;
    private static final int dy = 15;
    public static final int dz = 15;
    public static final int dA = 8;
    public static int dB;
    public static int dC;
    public static int dD;
    private static final int dE = 8;
    private static int dF;
    private static int dG;

    /* JADX INFO: renamed from: dq, reason: collision with other field name */
    private static float f94dq;

    /* JADX INFO: renamed from: dr, reason: collision with other field name */
    private static float f95dr;

    /* JADX INFO: renamed from: ds, reason: collision with other field name */
    private static float f96ds;

    /* JADX INFO: renamed from: dt, reason: collision with other field name */
    private static float f97dt;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private static oO f98a;

    @Nullable
    private static FormattedCharSequence l;

    @Nullable
    private static FormattedCharSequence m;

    @Nullable
    private static FormattedCharSequence n;

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    @Nullable
    private static FormattedCharSequence f100o;
    private static int dI;

    @NotNull
    private static FormattedCharSequence p;

    @NotNull
    private static final int[] f;

    @NotNull
    private static final FormattedCharSequence[] b;
    private static int dJ;
    private static int dK;

    @NotNull
    private static FormattedCharSequence q;

    @NotNull
    private static FormattedCharSequence r;
    private static int dL;

    @NotNull
    private static FormattedCharSequence s;
    private static int dM;
    private static boolean aR;

    @NotNull
    private static FormattedCharSequence t;

    @NotNull
    private static final ResourceLocation an = C0265jv.d("textures/gui/game/health_bar.png");

    @NotNull
    private static final ResourceLocation ao = C0265jv.d("textures/gui/game/health.png");

    @NotNull
    private static final ResourceLocation ap = C0265jv.d("textures/gui/game/health_vehicle.png");

    @NotNull
    private static final ResourceLocation aq = C0265jv.d("textures/gui/menu/icons/spectator.png");

    @NotNull
    private static final ResourceLocation ar = C0265jv.d("textures/misc/waypoints/waypoint_player_injured.png");

    @NotNull
    private static final ResourceLocation as = C0265jv.d("textures/misc/waypoints/waypoint_player_injured_callout.png");

    @NotNull
    private static final Component aV = Component.translatable("bf.message.dead.countdown.soon");

    @NotNull
    private static final Component aW = Component.translatable("bf.spectate.nobody");

    @NotNull
    private static final Component aX = Component.translatable("bf.message.reloading");

    @NotNull
    private static final Component aY = Component.translatable("bf.message.none").withStyle(ChatFormatting.GRAY);

    @NotNull
    private static final Component aZ = Component.translatable("bf.item.radio.resupplying");

    @NotNull
    private static final Component ba = Component.translatable("bf.item.radio.preparing");

    @NotNull
    private static final Component bb = Component.translatable("bf.message.ammo").withStyle(ChatFormatting.BOLD);

    @NotNull
    private static final Component bc = Component.literal("mph").withStyle(ChatFormatting.BOLD);

    @NotNull
    private static final DecimalFormat a = new DecimalFormat("0.0");

    @NotNull
    private static final ObjectList<a> o = new ObjectArrayList();

    @NotNull
    private static FormattedCharSequence h = FormattedCharSequence.EMPTY;
    private static int dH = -1;

    @NotNull
    private static FormattedCharSequence i = Component.literal("1").getVisualOrderText();

    @NotNull
    private static FormattedCharSequence j = Component.literal("2").getVisualOrderText();

    @NotNull
    private static FormattedCharSequence k = Component.literal("3").getVisualOrderText();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final FormattedCharSequence[] f99a = new FormattedCharSequence[4];

    static {
        for (int i2 = 0; i2 < 4; i2++) {
            f99a[i2] = Component.literal(String.valueOf(4 + i2)).getVisualOrderText();
        }
        dI = Integer.MIN_VALUE;
        p = FormattedCharSequence.EMPTY;
        f = new int[4];
        b = new FormattedCharSequence[4];
        dJ = Integer.MIN_VALUE;
        dK = Integer.MIN_VALUE;
        q = FormattedCharSequence.EMPTY;
        r = FormattedCharSequence.EMPTY;
        dL = -1;
        s = FormattedCharSequence.EMPTY;
        dM = -1;
        t = FormattedCharSequence.EMPTY;
    }

    public static void a(@NotNull Minecraft minecraft, @Nullable oF<?, ?, ?> oFVar, @Nullable LocalPlayer localPlayer, @NotNull fT fTVar) {
        if (localPlayer != null) {
            b(minecraft, localPlayer);
        }
        if (oFVar == null || localPlayer == null) {
            return;
        }
        oO oOVarA = oFVar.b().a(localPlayer.getUUID());
        if (oOVarA != null && oOVarA != f98a) {
            f98a = oOVarA;
            a(oOVarA);
        }
        f97dt = f96ds;
        f96ds = oOVarA == null ? 0.0f : oOVarA.m790a(C0543uc.b.getCooldownStat(), 0);
        a(oFVar, localPlayer, fTVar);
        a(oFVar, localPlayer);
        e(localPlayer);
    }

    private static void b(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer) {
        MutableComponent name;
        f95dr = f94dq;
        Inventory inventory = localPlayer.getInventory();
        ItemStack selected = inventory.getSelected();
        if (inventory.selected != dH) {
            dH = inventory.selected;
            if (selected.isEmpty()) {
                name = Component.empty();
            } else {
                Item item = selected.getItem();
                if (item instanceof tO) {
                    name = tO.m1151a(selected);
                } else {
                    name = item.getName(selected);
                }
            }
            h = name.getVisualOrderText();
            dF = minecraft.font.width(h);
            dG = 8;
            f95dr = 1.0f;
            f94dq = 1.0f;
        }
        if (dG > 0) {
            dG--;
        } else {
            f94dq = Mth.lerp(0.4f, f94dq, 0.0f);
        }
    }

    private static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer) {
        int iA = oFVar.a(localPlayer.getUUID()).a(C0529tp.E.getKey());
        if (o.size() > iA) {
            o.clear();
        } else {
            while (o.size() < iA) {
                o.add(new a());
            }
        }
    }

    private static void e(@NotNull LocalPlayer localPlayer) {
        Entity vehicle = localPlayer.getVehicle();
        if (!(vehicle instanceof AbstractC0376ny)) {
            m = null;
            n = null;
            f100o = null;
            return;
        }
        AbstractC0376ny abstractC0376ny = (AbstractC0376ny) vehicle;
        m = Component.literal(String.valueOf((int) abstractC0376ny.az())).withStyle(ChatFormatting.BOLD).getVisualOrderText();
        n = Component.literal(a.format(((double) (abstractC0376ny.ay() * 20.0f)) * 2.237d)).getVisualOrderText();
        f100o = null;
        nD nDVarA = abstractC0376ny.a((Entity) localPlayer);
        if (nDVarA != null && (abstractC0376ny instanceof nA)) {
            nA nAVar = (nA) abstractC0376ny;
            for (nN<?> nNVar : nDVarA.m715b()) {
                if (nNVar instanceof nL) {
                    f100o = Component.literal(String.valueOf(nAVar.a((nL) nNVar).m711a(nAVar.getEntityData()))).getVisualOrderText();
                    return;
                }
            }
        }
    }

    private static void a(@NotNull oO oOVar) {
        Style styleA = oOVar.a();
        i = Component.literal("1").withStyle(styleA).getVisualOrderText();
        j = Component.literal("2").withStyle(styleA).getVisualOrderText();
        k = Component.literal("3").withStyle(styleA).getVisualOrderText();
        for (int i2 = 0; i2 < 4; i2++) {
            f99a[i2] = Component.literal(String.valueOf(4 + i2)).withStyle(styleA).getVisualOrderText();
        }
    }

    private static void a(@NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull fT fTVar) {
        int iA;
        l = null;
        if (!oR.a((Player) localPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) fTVar) && (oFVar instanceof InterfaceC0466rg) && (iA = oFVar.a(localPlayer.getUUID()).a(C0529tp.z.getKey())) > 0) {
            l = Component.translatable("bf.message.ingame.warcry", new Object[]{Component.literal(wM.d.getKey().getDisplayName().getString().toUpperCase(Locale.ROOT)).withColor(ColorReferences.COLOR_WHITE), Component.literal(String.valueOf(iA / 20)).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.RED).getVisualOrderText();
        }
    }

    private void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull fT fTVar, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i2, int i3) {
        Component componentA;
        MutableComponent mutableComponentAppend = Component.empty().append(aW).append(C0037bh.a(C0040bk.g()));
        UUID uuidQ = fTVar.q();
        if (uuidQ != null && minecraft.level != null && minecraft.level.getPlayerByUUID(uuidQ) != null) {
            mutableComponentAppend = ((fV) c0297l.a()).mo306a(uuidQ).b();
        }
        int i4 = (i3 - 15) - 4;
        int i5 = i4 - 19;
        a(guiGraphics, font, (Component) Component.translatable("bf.spectate.cycle.hint", new Object[]{wM.f.getTranslatedKeyMessage(), wM.e.getTranslatedKeyMessage()}), i2, i4);
        a(guiGraphics, font, (Component) Component.translatable("bf.spectate.watching", new Object[]{mutableComponentAppend}), i2, i5);
        oG<?, ?> oGVarM593a = c0297l.m593a();
        if (oGVarM593a != null && (componentA = oGVarM593a.a(minecraft, c0297l, localPlayer, fTVar)) != null) {
            a(guiGraphics, font, componentA, i2, i5 - 19);
        }
    }

    private static void a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Component component, int i2, int i3) {
        int iWidth = font.width(component) + 6;
        C0040bk.b(guiGraphics, i2 - (iWidth / 2), i3, iWidth, 15, C0040bk.p());
        C0040bk.a(guiGraphics.pose(), font, guiGraphics, component, i2, i3 + 4, ColorReferences.COLOR_WHITE);
    }

    private static void a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, int i2, int i3, int i4) {
        if (i2 != dJ) {
            dJ = i2;
            q = Component.literal(String.valueOf(i2)).getVisualOrderText();
        }
        if (i3 != dK) {
            dK = i3;
            r = Component.literal(String.valueOf(i3)).getVisualOrderText();
        }
        int i5 = (((i4 - 15) - 4) - 15) - 4;
        int iA = 4;
        if (i2 > 0) {
            iA = 4 + a(guiGraphics, font, q, 4, i5, ColorReferences.COLOR_WHITE) + 4;
        }
        if (i3 > 0) {
            oO oOVarA = oFVar.b().a(localPlayer.getUUID());
            a(guiGraphics, font, r, iA, i5, oOVarA != null ? oOVarA.getColor() : ColorReferences.COLOR_WHITE);
        }
    }

    private static int a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull FormattedCharSequence formattedCharSequence, int i2, int i3, int i4) {
        int iWidth = 17 + font.width(formattedCharSequence) + 4;
        C0040bk.b(guiGraphics, i2, i3, iWidth, 15, C0040bk.p());
        C0040bk.a(guiGraphics.pose(), guiGraphics, aq, i2, i3, 15, 15, 0.0f, 1.0f, i4);
        C0040bk.b(font, guiGraphics, formattedCharSequence, i2 + 15 + 2, i3 + 4, i4);
        return iWidth;
    }

    private static void a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, int i2, int i3) {
        if (l == null) {
            return;
        }
        C0040bk.a(guiGraphics.pose(), font, guiGraphics, l, i2, i3);
    }

    public void a(@NotNull Font font, @NotNull oF<?, ?, ?> oFVar, @NotNull oG<?, ?> oGVar, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, int i2, int i3, float f2, float f3) {
        int iP = C0040bk.p();
        oO oOVarA = oFVar.b().a(localPlayer.getUUID());
        if (oOVarA == null) {
            return;
        }
        oOVarA.a(oFVar);
        float f4 = ds / 2.0f;
        float f5 = 30 / 2.0f;
        int i4 = i2 - (ds + 4);
        int i5 = i3 - 137;
        Inventory inventory = localPlayer.getInventory();
        int i6 = inventory.selected;
        TextColor color = oOVarA.a().getColor();
        int value = color != null ? color.getValue() : ColorReferences.COLOR_WHITE_SOLID;
        float fE = C0634xm.e(oGVar.kk, oGVar.kl, f3);
        if (fE < 1.0f && localPlayer.getVehicle() == null) {
            poseStack.pushPose();
            poseStack.translate((ds + 4 + 10) * fE, 0.0f, 0.0f);
            ItemStack item = inventory.getItem(0);
            if (i6 == 0) {
                C0040bk.a(guiGraphics, i4 + 1, i5 + 1, ds - 2, 30 - 2, value, 0.55f);
            }
            C0040bk.a(guiGraphics, i4 + 1, i5, ds - 2, 1, iP);
            C0040bk.a(guiGraphics, i4, i5 + 1, ds, 30 - 2, iP);
            C0040bk.a(guiGraphics, i4 + 1, (i5 + 30) - 1, ds - 2, 1, iP);
            C0040bk.b(font, guiGraphics, i, i4 + 2, i5 + 2);
            C0040bk.a(poseStack, guiGraphics, item, i4 + f4, i5 + f5, 3.5f);
            ItemStack item2 = inventory.getItem(1);
            int i7 = i5 + 31;
            if (i6 == 1) {
                C0040bk.a(guiGraphics, i4 + 1, i7 + 1, ds - 2, 30 - 2, value, 0.55f);
            }
            C0040bk.a(guiGraphics, i4 + 1, i7, ds - 2, 1, iP);
            C0040bk.a(guiGraphics, i4, i7 + 1, ds, 30 - 2, iP);
            C0040bk.a(guiGraphics, i4 + 1, (i7 + 30) - 1, ds - 2, 1, iP);
            C0040bk.b(font, guiGraphics, j, i4 + 2, i7 + 2);
            C0040bk.a(poseStack, guiGraphics, item2, i4 + f4, i7 + f5, 2.5f);
            ItemStack item3 = inventory.getItem(2);
            int i8 = i7 + 31;
            if (i6 == 2) {
                C0040bk.a(guiGraphics, i4 + 1, i8 + 1, ds - 2, 30 - 2, value, 0.55f);
            }
            C0040bk.a(guiGraphics, i4 + 1, i8, ds - 2, 1, iP);
            C0040bk.a(guiGraphics, i4, i8 + 1, ds, 30 - 2, iP);
            C0040bk.a(guiGraphics, i4 + 1, (i8 + 30) - 1, ds - 2, 1, iP);
            C0040bk.b(font, guiGraphics, k, i4 + 2, i8 + 2);
            if (!item3.isEmpty()) {
                C0040bk.a(poseStack, guiGraphics, item3, i4 + f4, i8 + f5, 3.1f);
            }
            int i9 = i8 + 31;
            for (int i10 = 0; i10 < 4; i10++) {
                a(font, guiGraphics, poseStack, inventory, i10, i6, i4, i9, value, 0.55f);
                i4 += 25;
            }
            poseStack.popPose();
        }
        int i11 = (i2 - ds) - 4;
        int i12 = i3 - 19;
        a(minecraft, localPlayer, poseStack, guiGraphics, font, oFVar, inventory, i2, i3, iP, value, i11, i12, ds, 15, f2, f3);
        a(poseStack, guiGraphics, font, oGVar, localPlayer, i3 - 15, 15, 102, iP, f3);
        a(poseStack, guiGraphics, font, localPlayer, iP, i3, 15);
        b(poseStack, guiGraphics, i11, i12, f3);
    }

    private static void a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Inventory inventory, int i2, int i3, int i4, int i5, int i6, float f2) {
        int iP = C0040bk.p();
        ItemStack item = inventory.getItem(3 + i2);
        int count = item.getCount();
        if (i3 == 3 + i2) {
            C0040bk.a(guiGraphics, i4 + 1, i5 + 1, 22, 22, i6, f2);
        }
        C0040bk.a(guiGraphics, i4 + 1, i5, 22, 1, iP);
        C0040bk.a(guiGraphics, i4, i5 + 1, 24, 22, iP);
        C0040bk.a(guiGraphics, i4 + 1, (i5 + 24) - 1, 22, 1, iP);
        float f3 = 1.0f;
        if (!item.isEmpty() && (item.getItem() instanceof tW)) {
            f3 = 1.25f;
        }
        C0040bk.a(poseStack, guiGraphics, item, i4 + 12.0f, i5 + 12.0f, f3);
        poseStack.translate(0.0f, 0.0f, 512.0f);
        C0040bk.b(font, guiGraphics, f99a[i2], i4 + 2, i5 + 2);
        if (count > 1) {
            if (count != f[i2]) {
                f[i2] = count;
                b[i2] = Component.literal(C0637xp.a(count)).getVisualOrderText();
            }
            C0040bk.b(font, guiGraphics, b[i2], (i4 + 24) - 7, (i5 + 24) - 9);
        }
        poseStack.translate(0.0f, 0.0f, -512.0f);
    }

    private void a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull oF<?, ?, ?> oFVar, @NotNull Inventory inventory, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f2, float f3) {
        C0040bk.a(guiGraphics, i6 + 1, i7, i8 - 2, 1, i4);
        C0040bk.a(guiGraphics, i6, i7 + 1, i8, i9 - 2, i4);
        C0040bk.a(guiGraphics, i6 + 1, (i7 + i9) - 1, i8 - 2, 1, i4);
        ItemStack selected = inventory.getSelected();
        if (selected.isEmpty()) {
        }
        Item item = selected.getItem();
        Objects.requireNonNull(item);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), C0558ur.class, tI.class, C0543uc.class, C0550uj.class).dynamicInvoker().invoke(item, 0) /* invoke-custom */) {
            case 0:
                a(minecraft, font, poseStack, guiGraphics, (C0558ur) item, selected, i2, i3, i5, i6, i7, i8, i9, f2, f3);
                break;
            case 1:
                float attackStrengthScale = localPlayer.getAttackStrengthScale(f3);
                if (attackStrengthScale < 1.0f) {
                    C0040bk.a(poseStack, guiGraphics, i6 + 1, i7, (i8 * attackStrengthScale) - 2.0f, 1.0f, ColorReferences.COLOR_WHITE_SOLID);
                }
                a(poseStack, guiGraphics, font, i5, i6, i7, i8);
                break;
            case 2:
                a(localPlayer, poseStack, guiGraphics, font, oFVar, i5, i6, i7, i8, f2, f3);
                break;
            case 3:
                if (((C0550uj) item).ck() && C0132ew.J()) {
                    C0040bk.a(poseStack, guiGraphics, i6 + 1, i7, (i8 * C0132ew.u()) - 2.0f, 1.0f, ColorReferences.COLOR_WHITE_SOLID);
                }
                a(poseStack, guiGraphics, font, i5, i6, i7, i8);
                break;
            default:
                a(poseStack, guiGraphics, font, i5, i6, i7, i8);
                break;
        }
    }

    private static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i2, float f2, float f3, int i3) {
        float fMin = dF > 0 ? Math.min(1.0f, (i3 - 2) / dF) : 1.0f;
        Objects.requireNonNull(font);
        C0040bk.a(poseStack, font, guiGraphics, h, f2 + (i3 / 2.0f), f3 + 4.0f + ((1.0f - fMin) * 9.0f * 0.5f), i2, fMin);
    }

    private void a(@NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull oF<?, ?, ?> oFVar, int i2, float f2, float f3, int i3, float f4, float f5) {
        oO oOVarA = oFVar.b().a(localPlayer.getUUID());
        if (oOVarA == null) {
            return;
        }
        EnumC0481rv enumC0481rv = C0543uc.b;
        int iM790a = oOVarA.m790a(enumC0481rv.getCooldownStat(), 0);
        float f6 = f2 + (i3 / 2.0f);
        if (iM790a <= 0) {
            a(poseStack, guiGraphics, font, i2, f2, f3, i3);
            return;
        }
        C0040bk.a(poseStack, guiGraphics, f2 + 1.0f, f3, (C0634xm.e(f96ds, f97dt, f5) * (i3 - 2)) / enumC0481rv.getMaxCooldown(), 1.0f, ColorReferences.COLOR_WHITE_SOLID);
        boolean zIsWaypoint = enumC0481rv.isWaypoint();
        String strA = C0037bh.a(f4);
        if (strA.length() != dM || zIsWaypoint != aR) {
            dM = strA.length();
            aR = zIsWaypoint;
            t = (zIsWaypoint ? ba : aZ).copy().append(Component.literal(strA)).getVisualOrderText();
        }
        C0040bk.b(poseStack, font, guiGraphics, t, f6, f3 + 4.0f, i2);
    }

    private static void a(@NotNull Minecraft minecraft, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull C0558ur c0558ur, @NotNull ItemStack itemStack, int i2, int i3, int i4, float f2, float f3, int i5, int i6, float f4, float f5) {
        int iCb = c0558ur.m1206a(itemStack).cb();
        Style styleWithColor = Style.EMPTY.withColor(ChatFormatting.WHITE);
        if (dB < iCb / 2) {
            styleWithColor = Style.EMPTY.withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);
            if (dB < iCb / 4) {
                styleWithColor = Style.EMPTY.withColor(ChatFormatting.RED);
            }
        }
        if (!C0558ur.m1202f(itemStack)) {
            float fE = C0634xm.e(f94dq, f95dr, f5);
            C0040bk.a(guiGraphics, (int) f2, (int) f3, i5, i6);
            poseStack.pushPose();
            poseStack.translate(0.0f, i6 * fE, 0.0f);
            c0558ur.m1209a().a(minecraft, poseStack, guiGraphics, font, c0558ur, itemStack, styleWithColor, i4, f2, f3, i5, i6, i2, i3, f5);
            poseStack.popPose();
            if (fE > 0.0f) {
                float fMin = dF > 0 ? Math.min(1.0f, (i5 - 2) / dF) : 1.0f;
                Objects.requireNonNull(font);
                poseStack.pushPose();
                poseStack.translate(0.0f, (-i6) * (1.0f - fE), 0.0f);
                C0040bk.a(poseStack, font, guiGraphics, h, f2 + (i5 / 2.0f), f3 + 4.0f + ((1.0f - fMin) * 9.0f * 0.5f), C0634xm.a(i4, fE), fMin);
                poseStack.popPose();
            }
            guiGraphics.disableScissor();
            return;
        }
        float fA = (c0558ur.a(itemStack, f5) * i5) / c0558ur.m1207e(itemStack);
        String strA = C0037bh.a(f4);
        if (strA.length() != dL) {
            dL = strA.length();
            s = aX.copy().append(Component.literal(strA)).getVisualOrderText();
        }
        C0040bk.a(poseStack, guiGraphics, f2 + 1.0f, f3, fA - 2.0f, 1.0f, ColorReferences.COLOR_WHITE_SOLID);
        C0040bk.b(poseStack, font, guiGraphics, s, f2 + (i5 / 2.0f), f3 + 4.0f, i4);
    }

    public static void a(@NotNull ItemStack itemStack) {
        dC = dB;
        dB = C0558ur.a(itemStack);
        dD = C0558ur.m1200b(itemStack);
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull C0558ur c0558ur, @NotNull ItemStack itemStack, int i2, int i3, float f2, float f3) {
        int iP = C0040bk.p();
        int i4 = ColorReferences.COLOR_WHITE_SOLID;
        int i5 = i2 - 105;
        int i6 = i3 - 21;
        C0040bk.a(guiGraphics, i5 + 1, i6, 97, 1, iP);
        C0040bk.a(guiGraphics, i5, i6 + 1, ds, 13, iP);
        C0040bk.a(guiGraphics, i5 + 1, (i6 + 15) - 1, 97, 1, iP);
        a(minecraft, font, poseStack, guiGraphics, c0558ur, itemStack, i2, i3, i4, i5, i6, ds, 15, f2, f3);
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull LocalPlayer localPlayer, @NotNull Collection<C0045bp> collection) {
        C0038bi.a(poseStack, guiGraphics, font, localPlayer, collection, 4, 4, 0.75f, 100, 100);
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull oG<?, ?> oGVar, @NotNull LocalPlayer localPlayer, int i2, int i3, int i4, int i5, float f2) {
        float fY = oGVar.y(f2);
        float fE = C0634xm.e(aY.bX, aY.bY, f2);
        int i6 = i2 - 4;
        float f3 = (64.0f * fE) / 20.0f;
        C0040bk.a(guiGraphics, 5, i6, i4 - 2, 1, i5);
        C0040bk.a(guiGraphics, 4, i6 + 1, i4, i3 - 2, i5);
        C0040bk.a(guiGraphics, 5, (i6 + i3) - 1, i4 - 2, 1, i5);
        C0040bk.a(poseStack, guiGraphics, ao, 4, i6, i3, i3);
        int iMax = Math.max((int) fE, 1);
        if (iMax != dI) {
            dI = iMax;
            p = Component.literal(String.valueOf(iMax)).withStyle(ChatFormatting.BOLD).getVisualOrderText();
        }
        C0040bk.a(poseStack, font, guiGraphics, p, 30.0f, i6 + 4);
        C0040bk.a(guiGraphics, 40, i6 + 4, 64, 7, i5);
        int i7 = i6 + 4;
        C0040bk.a(guiGraphics, 40, i7, (int) f3, 7);
        C0040bk.a(poseStack, guiGraphics, an, 40, i7, 64, 7);
        guiGraphics.disableScissor();
        if (aY.bX <= 5.0f) {
            C0040bk.a(poseStack, guiGraphics, 40.0f, i2 - 2, f3, 7.0f, ColorReferences.COLOR_THEME_RED);
        }
        int foodLevel = localPlayer.getFoodData().getFoodLevel();
        if (fY < 20.0f) {
            C0040bk.a(poseStack, guiGraphics, 5.0f, i6, ((i4 - 2) * fY) / 20.0f, 1.0f, foodLevel <= 1 ? ColorReferences.COLOR_BLACK_SOLID + C0040bk.bC : ColorReferences.COLOR_WHITE_SOLID);
        }
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull LocalPlayer localPlayer, int i2, int i3, int i4) {
        Entity vehicle = localPlayer.getVehicle();
        if (vehicle instanceof AbstractC0376ny) {
            AbstractC0376ny abstractC0376ny = (AbstractC0376ny) vehicle;
            FormattedCharSequence formattedCharSequence = m;
            FormattedCharSequence formattedCharSequence2 = n;
            if (formattedCharSequence == null || formattedCharSequence2 == null) {
                return;
            }
            nE<AbstractC0376ny> nEVarM741b = abstractC0376ny.m741b();
            float fAz = abstractC0376ny.az();
            int i5 = ((i3 - 15) - 4) - (i4 + 1);
            float f2 = 64.0f * (fAz / nEVarM741b.jC);
            C0040bk.a(guiGraphics, 4, i5, 102, 15, i2);
            C0040bk.a(poseStack, guiGraphics, ap, 4, i5, 15, 15);
            C0040bk.a(poseStack, font, guiGraphics, formattedCharSequence, 30.0f, i5 + 4);
            C0040bk.a(guiGraphics, 40, i5 + 4, 64, 7, i2);
            int i6 = i5 + 4;
            C0040bk.a(guiGraphics, 40, i6, (int) f2, 7);
            C0040bk.a(poseStack, guiGraphics, an, 40, i6, 64, 7);
            guiGraphics.disableScissor();
            int i7 = (i4 * 2) + 1;
            C0040bk.a(guiGraphics, 107, i5, i7, i7, i2);
            C0040bk.a(poseStack, font, guiGraphics, formattedCharSequence2, 107 + (i7 / 2), i5 + 5, 1.5f);
            C0040bk.c(font, guiGraphics, bc, 107 + (i7 / 2), i5 + 18);
            FormattedCharSequence formattedCharSequence3 = f100o;
            if (formattedCharSequence3 != null) {
                C0040bk.a(guiGraphics, 107 + i7 + 1, i5, i7, i7, i2);
                C0040bk.a(poseStack, font, guiGraphics, formattedCharSequence3, 107 + i7 + 1 + (i7 / 2), i5 + 5, 1.5f);
                C0040bk.c(font, guiGraphics, bb, 107 + i7 + 1 + (i7 / 2), i5 + 18);
            }
            int iGuiWidth = (guiGraphics.guiWidth() - ds) - 4;
            int i8 = i3 - 42;
            int i9 = 0;
            int size = nEVarM741b.aj.size();
            for (int i10 = 0; i10 < size; i10++) {
                nD nDVar = nEVarM741b.aj.get(i10);
                int i11 = i8 - (21 * i9);
                C0040bk.a(guiGraphics, iGuiWidth, i11, ds, 20, i2);
                C0040bk.a(poseStack, guiGraphics, nDVar.getIcon(), iGuiWidth, i11, 20, 20, 2.0f);
                MutableComponent mutableComponentCopy = aY.copy();
                if (i10 < abstractC0376ny.getPassengers().size()) {
                    mutableComponentCopy = Component.literal(((Entity) abstractC0376ny.getPassengers().get(i10)).getScoreboardName());
                }
                C0040bk.c(font, guiGraphics, (Component) mutableComponentCopy, iGuiWidth + 49, (i11 + 10) - 3);
                i9++;
            }
        }
    }

    private static int u() {
        int i2 = 138;
        if (f100o != null) {
            i2 = 138 + 32;
        }
        return i2;
    }

    private void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i2, int i3, float f2) {
        int size = o.size();
        int iMin = (i2 - 16) - (Math.min(size, 15) * 2);
        int i4 = i3 - 1;
        int i5 = iMin;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            i5 += 2;
            ((a) o.get(i7)).a(poseStack, guiGraphics, i5 - 2, i4 + (i7 % 2 == 0 ? 2 : 0) + i6, 16, f2);
            if (i7 != 0 && i7 % 15 == 0) {
                i5 = iMin;
                i6 += 4;
            }
        }
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull oF<?, ?, ?> oFVar, @NotNull oG<? extends oF<?, ?, ?>, ?> oGVar, boolean z, int i2, float f2) {
        List<C0421pp> listY = oGVar.y();
        int size = listY.size();
        for (int i3 = 0; i3 < size; i3++) {
            poseStack.pushPose();
            poseStack.translate(7.0f, i2 + (i3 * 16), 0.0f);
            listY.get(i3).a(guiGraphics, font, oFVar, z, f2);
            poseStack.popPose();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0070cn
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0297l c0297l) {
        int iU;
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        float fG = C0040bk.g();
        if (!hN.j.T() || minecraft.options.hideGui || clientLevel == null || localPlayer == null) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        oF<?, ?, ?> oFVarM591a = c0297l.m591a();
        if (oFVarM591a == null) {
            return;
        }
        float gameTimeDeltaPartialTick = deltaTracker.getGameTimeDeltaPartialTick(true);
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        int i2 = iGuiWidth / 2;
        int i3 = iGuiHeight / 2;
        fV fVVar = (fV) c0297l.a();
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        fT fTVarA = fVVar.a(minecraft);
        iS iSVarM404a = fVVar.m404a(minecraft);
        boolean z = c0297l.m592d() || (localPlayer.isSpectator() && oFVarM591a.bb());
        if (!z && ((hN.t.T() && fTVarA.dk()) || localPlayer.isDeadOrDying())) {
            C0040bk.a(guiGraphics, 0, 0, iGuiWidth, iGuiHeight, ColorReferences.COLOR_BLACK_SOLID);
        }
        if (z && !c0297l.m602a().ay()) {
            a(minecraft, c0297l, localPlayer, fTVarA, guiGraphics, font, i2, iGuiHeight);
        }
        int iCt = fTVarA.ct();
        int iCu = fTVarA.cu();
        if (hN.p.T() && !z && !c0297l.m602a().ay() && (iCt > 0 || iCu > 0)) {
            a(guiGraphics, font, oFVarM591a, localPlayer, iCt, iCu, iGuiHeight);
        }
        C0040bk.a(guiGraphics, 0, 0, iGuiWidth, iGuiHeight, 0, Math.max(0.0f, C0634xm.e(aQ.bc, aQ.bd, gameTimeDeltaPartialTick) - 1.0f));
        if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof C0558ur)) {
            a(mainHandItem);
        }
        oG<?, ?> oGVarM593a = c0297l.m593a();
        if (oGVarM593a == null) {
            return;
        }
        Set<UUID> setH = oFVarM591a.b().h();
        a(minecraft, c0297l, fVVar, guiGraphics, font, oGVarM593a, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        a(guiGraphics, font, i2, i3);
        oGVarM593a.a(minecraft, c0297l, localPlayer, clientLevel, fTVarA, guiGraphics, font, poseStackPose, bufferSource, setH, iGuiWidth, iGuiHeight, i2, i3, fG, gameTimeDeltaPartialTick);
        a(minecraft, localPlayer, oGVarM593a, poseStackPose, guiGraphics, font, oFVarM591a, fVVar, gameTimeDeltaPartialTick, iGuiWidth, i2, i3);
        if (!c0297l.m602a().ay()) {
            float fE = C0634xm.e(oGVarM593a.km, oGVarM593a.kn, gameTimeDeltaPartialTick);
            poseStackPose.pushPose();
            poseStackPose.translate(0.0f, 0.0f, 400.0f);
            C0040bk.a(guiGraphics, 0, 0, iGuiWidth, iGuiHeight, ColorReferences.COLOR_BLACK_SOLID, fE);
            poseStackPose.popPose();
            if (!fTVarA.dk()) {
                a(font, oFVarM591a, oGVarM593a, guiGraphics, poseStackPose, minecraft, localPlayer, iGuiWidth, iGuiHeight, fG, gameTimeDeltaPartialTick);
                Optional<MatchParty> party = iSVarM404a.getParty();
                if (party.isPresent()) {
                    MatchParty matchParty = party.get();
                    int iH = C0126eq.h(15);
                    int iB = C0126eq.b(matchParty, true, iH);
                    if (localPlayer.getVehicle() instanceof AbstractC0376ny) {
                        iU = u() + 4;
                    } else {
                        iU = C0093dj.gd;
                    }
                    C0126eq.a(minecraft, c0297l, poseStackPose, guiGraphics, matchParty, iU + 1, ((iGuiHeight - iB) - 4) + 1, -1, true, true, iH - 2, false);
                }
            }
        }
        if (minecraft.options.keyPlayerList.isDown()) {
            oGVarM593a.a(poseStackPose, guiGraphics, font, minecraft, c0297l, localPlayer, iSVarM404a, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        }
    }

    private void a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull oG<? extends oF<?, ?, ?>, ?> oGVar, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull oF<?, ?, ?> oFVar, @NotNull fV fVVar, float f2, int i2, int i3, int i4) {
        oO oOVarA;
        oO oOVarA2;
        boolean zShowDebugScreen = minecraft.getDebugOverlay().showDebugScreen();
        Collection<C0045bp> collectionD = oGVar.d();
        poseStack.pushPose();
        if (zShowDebugScreen) {
            poseStack.translate(0.0f, 210.0f, 0.0f);
        }
        if (hN.m.T()) {
            a(poseStack, guiGraphics, font, localPlayer, collectionD);
        }
        int i5 = 25;
        if (hN.m.T()) {
            i5 = 25 + 104;
        }
        if ((oFVar instanceof qZ) && hN.n.T()) {
            a(poseStack, guiGraphics, font, oFVar, oGVar, zShowDebugScreen, i5, f2);
        }
        poseStack.popPose();
        int i6 = 0;
        for (sQ sQVar : oGVar.z()) {
            int i7 = i6;
            i6++;
            sQVar.a(guiGraphics, font, i3 + (i2 / 4), (i4 / 2) + ((sQVar.getHeight() + 3) * i7), f2);
        }
        Camera mainCamera = minecraft.gameRenderer.getMainCamera();
        oI<?> oIVarB = oFVar.b();
        Iterator<C0413ph> it = oGVar.x().iterator();
        while (it.hasNext()) {
            it.next().a(mainCamera, localPlayer, poseStack, guiGraphics, oIVarB, f2);
        }
        UUID uuid = localPlayer.getUUID();
        if (oGVar.bi() && gJ.a(oFVar, uuid) != null && minecraft.level != null && (oOVarA = oIVarB.a(uuid)) != null) {
            int iGuiHeight = guiGraphics.guiHeight();
            float fAbs = 0.7f + (0.3f * Math.abs(Mth.sin(C0040bk.g() / 8.0f)));
            for (AbstractClientPlayer abstractClientPlayer : minecraft.level.players()) {
                UUID uuid2 = abstractClientPlayer.getUUID();
                if (!uuid2.equals(uuid) && !abstractClientPlayer.isDeadOrDying() && (oOVarA2 = oIVarB.a(uuid2)) != null && oOVarA2.getName().equals(oOVarA.getName())) {
                    fT fTVar = (fT) fVVar.a((Player) abstractClientPlayer);
                    ResourceLocation resourceLocation = null;
                    boolean z = false;
                    if (fTVar.ah() > 0 && fTVar.a() == oZ.MEDIC) {
                        resourceLocation = as;
                        z = true;
                    }
                    if (resourceLocation == null && gJ.c(abstractClientPlayer) && localPlayer.hasLineOfSight(abstractClientPlayer)) {
                        resourceLocation = ar;
                    }
                    if (resourceLocation != null) {
                        float fI = fAbs;
                        if (!z) {
                            fI *= C0634xm.i((float) abstractClientPlayer.position().distanceTo(localPlayer.position()), dm, dn);
                            if (fI <= 0.0f) {
                            }
                        }
                        C0040bk.m231a(poseStack, guiGraphics, resourceLocation, abstractClientPlayer.getPosition(f2).add(0.0d, 1.25d, 0.0d), mainCamera, i2, iGuiHeight, 8, 8, fI * 0.5f, ColorReferences.COLOR_WHITE, 32, false, f2);
                    }
                }
            }
        }
    }

    private void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull oG<?, ?> oGVar, int i2, int i3, float f2) {
        sR sRVarM773a = oGVar.m773a();
        if (sRVarM773a != null) {
            sRVarM773a.a(minecraft, c0297l, fVVar, guiGraphics, font, i2, i3, f2);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.cj$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cj$a.class */
    public static class a {

        @NotNull
        private static final ResourceLocation at = C0265jv.d("textures/gui/kill.png");

        @NotNull
        private static final ResourceLocation au = C0265jv.d("textures/gui/kill_flash.png");
        private float du = 0.0f;
        private float dv = 1.0f;

        public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, float f) {
            poseStack.pushPose();
            poseStack.translate(0.0f, 25.0f * (1.0f - this.du), 0.0f);
            float f2 = f / 2.0f;
            this.du = Mth.lerp(f2, this.du, 1.0f);
            this.dv = Mth.lerp(f2 / 4.0f, this.dv, 0.0f);
            C0040bk.a(poseStack, guiGraphics, at, i, i2, i3, i3, this.du);
            C0040bk.a(poseStack, guiGraphics, au, i, i2, i3, i3, this.dv * this.du);
            poseStack.popPose();
        }

        public float r() {
            return this.du;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.cj$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cj$b.class */
    public static class b {

        @NotNull
        private final ResourceLocation av;
        private float aD;
        private float aE;

        public b(@NotNull Random random, @NotNull a aVar) {
            this.aD = 0.8f - (0.2f * random.nextFloat());
            this.aE = this.aD;
            this.av = C0265jv.d("textures/gui/overlay/" + aVar.id + random.nextInt(aVar.textureCount) + ".png");
        }

        public void c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
            float fE = C0634xm.e(this.aD, this.aE, f);
            if (fE > 0.0f) {
                C0040bk.a(poseStack, guiGraphics, this.av, 0, 0, i, i2, fE);
            }
        }

        public boolean k() {
            this.aE = this.aD;
            this.aD = C0634xm.d(this.aD, 0.0f, 0.005f);
            return this.aD + this.aE == 0.0f;
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

            private final String id;
            private final int textureCount;

            a(@NotNull String str, int i) {
                this.id = str;
                this.textureCount = i;
            }
        }
    }
}
