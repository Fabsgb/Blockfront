package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudInventoryFilter;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.em, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/em.class */
public final class C0122em extends AbstractC0120ek {
    private static final int hN = 15;
    public static final int hO = 70;
    public static final int hP = 16;
    public static final int hQ = 32;
    private static final int hR = 80;
    private static C0048bs o;
    private static C0048bs p;
    private static final List<C0050bu> F = new ObjectArrayList();
    public static final Component hp = Component.translatable("bf.menu.inventory.sync");
    public static final Component hq = Component.translatable("bf.menu.inventory.text.none").withStyle(C0266jw.b);
    public static final Component hr = Component.translatable("bf.menu.inventory.newitem").withStyle(ChatFormatting.BOLD);
    public static final Component hs = Component.translatable("bf.dropdown.text.next");
    public static final Component ht = Component.translatable("bf.dropdown.text.finish");
    public static int hS = 0;
    static int hT = 0;
    private static int hU = 1;
    private static int hV = 0;

    @Nullable
    private static CloudItemStack i = null;
    private static UUID j = null;
    private static boolean bX = false;

    public C0122em(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5, Component.empty());
        init();
    }

    private static void ar() {
        if (hU > 1 && hS < hU - 1) {
            hS++;
        }
    }

    private static void as() {
        if (hS > 0) {
            hS--;
        }
    }

    public void init() {
        Minecraft minecraft = Minecraft.getInstance();
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null) {
            return;
        }
        fV fVVar = (fV) c0297lB.a();
        CloudRegistry cloudRegistryA = c0297lB.a();
        iS iSVarM404a = fVVar.m404a(minecraft);
        iN inventory = iSVarM404a.getInventory();
        List<CloudItemStack> listFilterByRarity = CloudInventoryFilter.filterByRarity(cloudRegistryA, inventory.getItems());
        if (C0097dn.a != CloudItemType.ALL) {
            listFilterByRarity = CloudInventoryFilter.filterByType(cloudRegistryA, listFilterByRarity, C0097dn.a);
        }
        if (!inventory.n().isEmpty()) {
            if (!bX) {
                bX = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.PLAYER_LEVELUP, 1.0f));
            }
        } else {
            bX = false;
        }
        F.clear();
        ap();
        hU = f(listFilterByRarity.size());
        int x = getX() + 12;
        int y = getY() + 4;
        int i2 = hS * 15;
        int size = listFilterByRarity.size();
        for (int i3 = 0; i3 < 3; i3++) {
            for (int i4 = 0; i4 < 5; i4++) {
                if (i2 < size) {
                    CloudItemStack cloudItemStack = listFilterByRarity.get(i2);
                    F.add(new C0050bu(minecraft.screen, cloudItemStack, x + (i4 * 42), y + (i3 * 43), 40, 40, inventory.a(cloudRegistryA, cloudItemStack), inventory.isItemShowcased(cloudItemStack.getUUID())).a(true));
                }
                i2++;
            }
        }
        C0048bs c0048bs = new C0048bs(getX() + 2, (getY() + (this.height / 2)) - 3, 10, 10, Component.literal("<"), button -> {
            if (i == null) {
                as();
                init();
            }
        });
        c0048bs.a(C0048bs.a.NONE);
        c0048bs.a();
        a((AbstractWidget) c0048bs);
        C0048bs c0048bs2 = new C0048bs((getX() + this.width) - 11, (getY() + (this.height / 2)) - 3, 10, 10, Component.literal(">"), button2 -> {
            if (i == null) {
                ar();
                init();
            }
        });
        c0048bs2.a(C0048bs.a.NONE);
        c0048bs2.a();
        a((AbstractWidget) c0048bs2);
        int y2 = (getY() + this.height) - 40;
        p = new C0048bs(getX() + 32, y2, 70, 16, ht, button3 -> {
            i = null;
            minecraft.setScreen(new C0097dn());
            iSVarM404a.getInventory().aW();
            bX = false;
        });
        p.a(C0048bs.a.SHADOW);
        p.a(0.0f, 1.0f);
        p.a();
        a((AbstractWidget) p, true);
        o = new C0048bs(((getX() + this.width) - 70) - 32, y2, 70, 16, hs, button4 -> {
            i = null;
            minecraft.setScreen(new C0097dn());
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.EXPERIENCE_ORB_PICKUP, (float) (0.8999999761581421d + (0.20000000298023224d * Math.random()))));
        });
        o.a(C0048bs.a.SHADOW);
        o.a(0.0f, 1.0f);
        o.a();
        a((AbstractWidget) o, true);
        v(false);
    }

    private void v(boolean z) {
        o.visible = z;
        o.active = z;
        p.visible = z;
        p.active = z;
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    public void a(float f) {
        Minecraft minecraft = Minecraft.getInstance();
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null) {
            return;
        }
        fV fVVar = (fV) c0297lB.a();
        CloudRegistry cloudRegistryA = c0297lB.a();
        iN inventory = fVVar.m404a(minecraft).getInventory();
        if (hT > 0) {
            hT--;
            return;
        }
        int i2 = hV;
        hV = i2 + 1;
        if (i2 > 5) {
            init();
            hV = 0;
        }
        F.forEach(c0050bu -> {
            c0050bu.d(inventory.a(cloudRegistryA, c0050bu.a()));
            c0050bu.e(inventory.isItemShowcased(c0050bu.a().getUUID()));
        });
        if (i == null) {
            inventory.a().ifPresent(uuid -> {
                i = inventory.getStackFromUUID(uuid).orElse(null);
            });
        }
        Stream<UUID> stream = inventory.n().stream();
        Objects.requireNonNull(inventory);
        inventory.e((ObjectArrayList) stream.filter(inventory::hasItemStack).collect(Collectors.toCollection(ObjectArrayList::new)));
        v(i != null);
        F.forEach(c0050bu2 -> {
            c0050bu2.a(minecraft, cloudRegistryA);
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    protected void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull iS iSVar, @NotNull GuiGraphics guiGraphics, int i2, int i3, float f, float f2) {
        PoseStack poseStackPose = guiGraphics.pose();
        Font font = minecraft.font;
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        CloudRegistry cloudRegistryA = c0297l.a();
        C0040bk.c(guiGraphics, getX(), getY(), this.width, this.height, C0040bk.p());
        poseStackPose.pushPose();
        int i4 = this.width / 2;
        int i5 = this.height / 2;
        if (hT > 0) {
            C0040bk.c(font, guiGraphics, hp, getX() + i4, getY() + 50);
            poseStackPose.popPose();
            return;
        }
        int size = F.size();
        C0050bu c0050bu = null;
        for (int i6 = 0; i6 < size; i6++) {
            C0050bu c0050bu2 = F.get(i6);
            c0050bu2.a(minecraft, guiGraphics, font, i != null, i2, i3, f2);
            if (c0050bu2.a(i2, i3) && c0050bu != c0050bu2 && i == null) {
                c0050bu = c0050bu2;
            }
        }
        if (F.isEmpty()) {
            C0040bk.a(guiGraphics, (getX() + i4) - (42 / 2), ((getY() + i5) - 42) + 8, 42, ColorReferences.COLOR_WHITE_SOLID, f);
            C0040bk.c(font, guiGraphics, hq, getX() + i4, getY() + (this.height / 2) + 16);
        }
        if (c0050bu != null && !c0050bu.a.getUUID().equals(j)) {
            j = c0050bu.a.getUUID();
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pq.get(), 1.0f));
            minecraft.getNarrator().sayNow(c0050bu.a.getDisplayName(cloudRegistryA, true));
        }
        a(minecraft, guiGraphics, font, poseStackPose, bufferSource, cloudRegistryA, iSVar, i2, i3, f2);
        poseStackPose.popPose();
    }

    private void a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull CloudRegistry cloudRegistry, @NotNull iS iSVar, int i2, int i3, float f) {
        if (i == null) {
            return;
        }
        int i4 = this.width / 2;
        int i5 = this.height / 2;
        CloudItem<?> cloudItem = i.getCloudItem(cloudRegistry);
        if (cloudItem == null) {
            return;
        }
        int color = cloudItem.getRarity().getColor();
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 80.0f);
        C0040bk.a(guiGraphics, getX(), getY(), this.width, this.height, C0040bk.p(), 0.9f);
        poseStack.pushPose();
        C0040bk.b(poseStack, guiGraphics, C0080cx.aT, getX() + i4, getY() + i5, this.width, this.height, 0.0f, 1.0f, color);
        C0245jb.a(cloudItem).a(cloudItem, i, minecraft, guiGraphics, poseStack, multiBufferSource, getX(), getY(), this.width, this.height, i2, i3, f);
        C0040bk.c(poseStack, font, guiGraphics, hr, getX() + (this.width / 2), getY() + 4, 1.5f);
        String displayName = i.getDisplayName(cloudRegistry);
        C0040bk.c(poseStack, font, guiGraphics, (Component) Component.literal(displayName).withStyle(ChatFormatting.BOLD).withColor(color), getX() + (this.width / 2), getY() + 20, C0634xm.a(displayName, minecraft.font, 2.0f, this.width - 60, 2.0f));
        List<UUID> listN = iSVar.getInventory().n();
        if (!listN.isEmpty()) {
            C0040bk.a(poseStack, font, guiGraphics, (Component) Component.translatable("bf.menu.inventory.newitem.more", new Object[]{String.valueOf(listN.size())}).withStyle(ChatFormatting.GRAY), getX() + (this.width / 2), (getY() + this.height) - 18);
        }
        o.render(guiGraphics, i2, i3, f);
        p.render(guiGraphics, i2, i3, f);
        poseStack.popPose();
        poseStack.popPose();
    }

    private int f(int i2) {
        int i3 = i2;
        int i4 = 0;
        while (i3 > 0) {
            i3 -= 15;
            i4++;
        }
        return i4;
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    public boolean mouseClicked(double d, double d2, int i2) {
        Minecraft minecraft = Minecraft.getInstance();
        C0297l c0297lB = C0297l.b();
        if (c0297lB != null) {
            for (C0050bu c0050bu : F) {
                if (new Rectangle(c0050bu.bm, c0050bu.bn, c0050bu.cM, c0050bu.cN).contains(d, d2) && i2 == 1) {
                    minecraft.setScreen(iW.a(minecraft.screen, c0297lB, c0050bu.a, (int) (d + 2.0d), (int) (d2 + 2.0d)));
                    return true;
                }
            }
        }
        return super.mouseClicked(d, d2, i2);
    }
}
