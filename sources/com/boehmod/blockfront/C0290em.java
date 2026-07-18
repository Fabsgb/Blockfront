package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudInventoryFilter;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.awt.Rectangle;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.em */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/em.class */
public final class C0290em extends AbstractC0288ek {

    /* JADX INFO: renamed from: hN */
    private static final int f2189hN = 15;

    /* JADX INFO: renamed from: hO */
    public static final int f2196hO = 70;

    /* JADX INFO: renamed from: hP */
    public static final int f2197hP = 16;

    /* JADX INFO: renamed from: hQ */
    public static final int f2198hQ = 32;

    /* JADX INFO: renamed from: hR */
    private static final int f2199hR = 80;

    /* JADX INFO: renamed from: o */
    private static C0127bs f2204o;

    /* JADX INFO: renamed from: p */
    private static C0127bs f2205p;

    /* JADX INFO: renamed from: F */
    private static final List<C0129bu> f2190F = new ObjectArrayList();

    /* JADX INFO: renamed from: hp */
    public static final Component f2191hp = Component.translatable("bf.menu.inventory.sync");

    /* JADX INFO: renamed from: hq */
    public static final Component f2192hq = Component.translatable("bf.menu.inventory.text.none").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: hr */
    public static final Component f2193hr = Component.translatable("bf.menu.inventory.newitem").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: hs */
    public static final Component f2194hs = Component.translatable("bf.dropdown.text.next");

    /* JADX INFO: renamed from: ht */
    public static final Component f2195ht = Component.translatable("bf.dropdown.text.finish");

    /* JADX INFO: renamed from: hS */
    public static int f2200hS = 0;

    /* JADX INFO: renamed from: hT */
    static int f2201hT = 0;

    /* JADX INFO: renamed from: hU */
    private static int f2202hU = 1;

    /* JADX INFO: renamed from: hV */
    private static int f2203hV = 0;

    /* JADX INFO: renamed from: i */
    @Nullable
    private static CloudItemStack f2206i = null;

    /* JADX INFO: renamed from: j */
    private static UUID f2207j = null;

    /* JADX INFO: renamed from: bX */
    private static boolean f2208bX = false;

    public C0290em(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, Component.empty());
        init();
    }

    /* JADX INFO: renamed from: ar */
    private static void m1530ar() {
        if (f2202hU > 1 && f2200hS < f2202hU - 1) {
            f2200hS++;
        }
    }

    /* JADX INFO: renamed from: as */
    private static void m1531as() {
        if (f2200hS > 0) {
            f2200hS--;
        }
    }

    public void init() {
        Minecraft minecraft = Minecraft.getInstance();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null) {
            return;
        }
        C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
        CloudRegistry cloudRegistryA = c0622lM2667b.m2670a();
        C0482iS c0482iSM1676a = c0326fV.m1676a(minecraft);
        C0477iN inventory = c0482iSM1676a.getInventory();
        List<CloudItemStack> listFilterByRarity = CloudInventoryFilter.filterByRarity(cloudRegistryA, inventory.getItems());
        if (C0238dn.f1980a != CloudItemType.ALL) {
            listFilterByRarity = CloudInventoryFilter.filterByType(cloudRegistryA, listFilterByRarity, C0238dn.f1980a);
        }
        if (!inventory.m2154n().isEmpty()) {
            if (!f2208bX) {
                f2208bX = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.PLAYER_LEVELUP, 1.0f));
            }
        } else {
            f2208bX = false;
        }
        f2190F.clear();
        m1517ap();
        f2202hU = m1534f(listFilterByRarity.size());
        int x = getX() + 12;
        int y = getY() + 4;
        int i = f2200hS * 15;
        int size = listFilterByRarity.size();
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 5; i3++) {
                if (i < size) {
                    CloudItemStack cloudItemStack = listFilterByRarity.get(i);
                    f2190F.add(new C0129bu(minecraft.screen, cloudItemStack, x + (i3 * 42), y + (i2 * 43), 40, 40, inventory.m2159a(cloudRegistryA, cloudItemStack), inventory.isItemShowcased(cloudItemStack.getUUID())).m672a(true));
                }
                i++;
            }
        }
        C0127bs c0127bs = new C0127bs(getX() + 2, (getY() + (this.height / 2)) - 3, 10, 10, Component.literal("<"), button -> {
            if (f2206i == null) {
                m1531as();
                init();
            }
        });
        c0127bs.m653a(C0127bs.a.NONE);
        c0127bs.mo650a();
        m1515a((AbstractWidget) c0127bs);
        C0127bs c0127bs2 = new C0127bs((getX() + this.width) - 11, (getY() + (this.height / 2)) - 3, 10, 10, Component.literal(">"), button2 -> {
            if (f2206i == null) {
                m1530ar();
                init();
            }
        });
        c0127bs2.m653a(C0127bs.a.NONE);
        c0127bs2.mo650a();
        m1515a((AbstractWidget) c0127bs2);
        int y2 = (getY() + this.height) - 40;
        f2205p = new C0127bs(getX() + 32, y2, 70, 16, f2195ht, button3 -> {
            f2206i = null;
            minecraft.setScreen(new C0238dn());
            c0482iSM1676a.getInventory().m2157aW();
            f2208bX = false;
        });
        f2205p.m653a(C0127bs.a.SHADOW);
        f2205p.m649a(0.0f, 1.0f);
        f2205p.mo650a();
        m1516a((AbstractWidget) f2205p, true);
        f2204o = new C0127bs(((getX() + this.width) - 70) - 32, y2, 70, 16, f2194hs, button4 -> {
            f2206i = null;
            minecraft.setScreen(new C0238dn());
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.EXPERIENCE_ORB_PICKUP, (float) (0.8999999761581421d + (0.20000000298023224d * Math.random()))));
        });
        f2204o.m653a(C0127bs.a.SHADOW);
        f2204o.m649a(0.0f, 1.0f);
        f2204o.mo650a();
        m1516a((AbstractWidget) f2204o, true);
        m1532v(false);
    }

    /* JADX INFO: renamed from: v */
    private void m1532v(boolean z) {
        f2204o.visible = z;
        f2204o.active = z;
        f2205p.visible = z;
        f2205p.active = z;
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    /* JADX INFO: renamed from: a */
    public void mo1519a(float f) {
        Minecraft minecraft = Minecraft.getInstance();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null) {
            return;
        }
        C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
        CloudRegistry cloudRegistryA = c0622lM2667b.m2670a();
        C0477iN inventory = c0326fV.m1676a(minecraft).getInventory();
        if (f2201hT > 0) {
            f2201hT--;
            return;
        }
        int i = f2203hV;
        f2203hV = i + 1;
        if (i > 5) {
            init();
            f2203hV = 0;
        }
        f2190F.forEach(c0129bu -> {
            c0129bu.m679d(inventory.m2159a(cloudRegistryA, c0129bu.m681a()));
            c0129bu.m680e(inventory.isItemShowcased(c0129bu.m681a().getUUID()));
        });
        if (f2206i == null) {
            inventory.m2156a().ifPresent(uuid -> {
                f2206i = inventory.getStackFromUUID(uuid).orElse(null);
            });
        }
        Stream<UUID> stream = inventory.m2154n().stream();
        Objects.requireNonNull(inventory);
        inventory.m2155e((ObjectArrayList) stream.filter(inventory::hasItemStack).collect(Collectors.toCollection(ObjectArrayList::new)));
        m1532v(f2206i != null);
        f2190F.forEach(c0129bu2 -> {
            c0129bu2.m673a(minecraft, cloudRegistryA);
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    /* JADX INFO: renamed from: a */
    protected void mo1521a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull C0482iS c0482iS, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        PoseStack poseStackPose = guiGraphics.pose();
        Font font = minecraft.font;
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        CloudRegistry cloudRegistryA = c0622l.m2670a();
        C0119bk.m491c(guiGraphics, getX(), getY(), this.width, this.height, C0119bk.m365p());
        poseStackPose.pushPose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        if (f2201hT > 0) {
            C0119bk.m383c(font, guiGraphics, f2191hp, getX() + i3, getY() + 50);
            poseStackPose.popPose();
            return;
        }
        int size = f2190F.size();
        C0129bu c0129bu = null;
        for (int i5 = 0; i5 < size; i5++) {
            C0129bu c0129bu2 = f2190F.get(i5);
            c0129bu2.m675a(minecraft, guiGraphics, font, f2206i != null, i, i2, f2);
            if (c0129bu2.m678a(i, i2) && c0129bu != c0129bu2 && f2206i == null) {
                c0129bu = c0129bu2;
            }
        }
        if (f2190F.isEmpty()) {
            C0119bk.m487a(guiGraphics, (getX() + i3) - (42 / 2), ((getY() + i4) - 42) + 8, 42, ColorReferences.COLOR_WHITE_SOLID, f);
            C0119bk.m383c(font, guiGraphics, f2192hq, getX() + i3, getY() + (this.height / 2) + 16);
        }
        if (c0129bu != null && !c0129bu.f926a.getUUID().equals(f2207j)) {
            f2207j = c0129bu.f926a.getUUID();
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7559pq.get(), 1.0f));
            minecraft.getNarrator().sayNow(c0129bu.f926a.getDisplayName(cloudRegistryA, true));
        }
        m1533a(minecraft, guiGraphics, font, poseStackPose, bufferSource, cloudRegistryA, c0482iS, i, i2, f2);
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    private void m1533a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull CloudRegistry cloudRegistry, @NotNull C0482iS c0482iS, int i, int i2, float f) {
        if (f2206i == null) {
            return;
        }
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        CloudItem<?> cloudItem = f2206i.getCloudItem(cloudRegistry);
        if (cloudItem == null) {
            return;
        }
        int color = cloudItem.getRarity().getColor();
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 80.0f);
        C0119bk.m417a(guiGraphics, getX(), getY(), this.width, this.height, C0119bk.m365p(), 0.9f);
        poseStack.pushPose();
        C0119bk.m447b(poseStack, guiGraphics, C0195cx.f1576aT, getX() + i3, getY() + i4, this.width, this.height, 0.0f, 1.0f, color);
        C0544jb.m2468a(cloudItem).mo2226a(cloudItem, f2206i, minecraft, guiGraphics, poseStack, multiBufferSource, getX(), getY(), this.width, this.height, i, i2, f);
        C0119bk.m394c(poseStack, font, guiGraphics, f2193hr, getX() + (this.width / 2), getY() + 4, 1.5f);
        String displayName = f2206i.getDisplayName(cloudRegistry);
        C0119bk.m394c(poseStack, font, guiGraphics, (Component) Component.literal(displayName).withStyle(ChatFormatting.BOLD).withColor(color), getX() + (this.width / 2), getY() + 20, C1290xm.m7867a(displayName, minecraft.font, 2.0f, this.width - 60, 2.0f));
        List<UUID> listM2154n = c0482iS.getInventory().m2154n();
        if (!listM2154n.isEmpty()) {
            C0119bk.m399a(poseStack, font, guiGraphics, (Component) Component.translatable("bf.menu.inventory.newitem.more", new Object[]{String.valueOf(listM2154n.size())}).withStyle(ChatFormatting.GRAY), getX() + (this.width / 2), (getY() + this.height) - 18);
        }
        f2204o.render(guiGraphics, i, i2, f);
        f2205p.render(guiGraphics, i, i2, f);
        poseStack.popPose();
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: f */
    private int m1534f(int i) {
        int i2 = i;
        int i3 = 0;
        while (i2 > 0) {
            i2 -= 15;
            i3++;
        }
        return i3;
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    public boolean mouseClicked(double d, double d2, int i) {
        Minecraft minecraft = Minecraft.getInstance();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b != null) {
            for (C0129bu c0129bu : f2190F) {
                if (new Rectangle(c0129bu.f927bm, c0129bu.f929bn, c0129bu.f930cM, c0129bu.f931cN).contains(d, d2) && i == 1) {
                    minecraft.setScreen(C0486iW.m2213a(minecraft.screen, c0622lM2667b, c0129bu.f926a, (int) (d + 2.0d), (int) (d2 + 2.0d)));
                    return true;
                }
            }
        }
        return super.mouseClicked(d, d2, i);
    }
}
