package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudInventoryFilter;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ez */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ez.class */
public final class C0304ez extends AbstractC0302ex {

    /* JADX INFO: renamed from: jd */
    private static final int f2362jd = 15;

    /* JADX INFO: renamed from: je */
    public static final int f2369je = 70;

    /* JADX INFO: renamed from: jf */
    public static final int f2370jf = 16;

    /* JADX INFO: renamed from: jg */
    public static final int f2371jg = 32;

    /* JADX INFO: renamed from: jh */
    private static final int f2372jh = 80;

    /* JADX INFO: renamed from: o */
    private static C0085bB f2377o;

    /* JADX INFO: renamed from: p */
    private static C0085bB f2378p;

    /* JADX INFO: renamed from: H */
    private static final List<C0087bD> f2363H = new ObjectArrayList();

    /* JADX INFO: renamed from: hy */
    public static final Component f2364hy = Component.translatable("bf.menu.inventory.sync");

    /* JADX INFO: renamed from: hz */
    public static final Component f2365hz = Component.translatable("bf.menu.inventory.text.none").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: hA */
    public static final Component f2366hA = Component.translatable("bf.menu.inventory.newitem").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: hB */
    public static final Component f2367hB = Component.translatable("bf.dropdown.text.next");

    /* JADX INFO: renamed from: hC */
    public static final Component f2368hC = Component.translatable("bf.dropdown.text.finish");

    /* JADX INFO: renamed from: ji */
    public static int f2373ji = 0;

    /* JADX INFO: renamed from: jj */
    static int f2374jj = 0;

    /* JADX INFO: renamed from: jk */
    private static int f2375jk = 1;

    /* JADX INFO: renamed from: jl */
    private static int f2376jl = 0;

    /* JADX INFO: renamed from: i */
    @Nullable
    private static CloudItemStack f2379i = null;

    /* JADX INFO: renamed from: j */
    private static UUID f2380j = null;

    /* JADX INFO: renamed from: cf */
    private static boolean f2381cf = false;

    public C0304ez(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, Component.empty());
        init();
    }

    /* JADX INFO: renamed from: aw */
    private static void m1640aw() {
        if (f2375jk > 1 && f2373ji < f2375jk - 1) {
            f2373ji++;
        }
    }

    /* JADX INFO: renamed from: ax */
    private static void m1641ax() {
        if (f2373ji > 0) {
            f2373ji--;
        }
    }

    public void init() {
        Minecraft minecraft = Minecraft.getInstance();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null) {
            return;
        }
        C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
        CloudRegistry cloudRegistryA = c0623lM2852b.m2855a();
        C0555jl c0555jlM1886a = c0396gl.m1886a(minecraft);
        C0550jg inventory = c0555jlM1886a.getInventory();
        List<CloudItemStack> listFilterByRarity = CloudInventoryFilter.filterByRarity(cloudRegistryA, inventory.getItems());
        if (C0248dw.f2044a != CloudItemType.ALL) {
            listFilterByRarity = CloudInventoryFilter.filterByType(cloudRegistryA, listFilterByRarity, C0248dw.f2044a);
        }
        if (!inventory.m2481p().isEmpty()) {
            if (!f2381cf) {
                f2381cf = true;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.PLAYER_LEVELUP, 1.0f));
            }
        } else {
            f2381cf = false;
        }
        f2363H.clear();
        m1633au();
        f2375jk = m1644f(listFilterByRarity.size());
        int x = getX() + 12;
        int y = getY() + 4;
        int i = f2373ji * 15;
        int size = listFilterByRarity.size();
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 5; i3++) {
                if (i < size) {
                    CloudItemStack cloudItemStack = listFilterByRarity.get(i);
                    f2363H.add(new C0087bD(minecraft.screen, cloudItemStack, x + (i3 * 42), y + (i2 * 43), 40, 40, inventory.m2486a(cloudRegistryA, cloudItemStack), inventory.isItemShowcased(cloudItemStack.getUUID())).m347a(true));
                }
                i++;
            }
        }
        C0085bB c0085bB = new C0085bB(getX() + 2, (getY() + (this.height / 2)) - 3, 10, 10, Component.literal("<"), button -> {
            if (f2379i == null) {
                m1641ax();
                init();
            }
        });
        c0085bB.m328a(C0085bB.a.NONE);
        c0085bB.mo325a();
        m1631a((AbstractWidget) c0085bB);
        C0085bB c0085bB2 = new C0085bB((getX() + this.width) - 11, (getY() + (this.height / 2)) - 3, 10, 10, Component.literal(">"), button2 -> {
            if (f2379i == null) {
                m1640aw();
                init();
            }
        });
        c0085bB2.m328a(C0085bB.a.NONE);
        c0085bB2.mo325a();
        m1631a((AbstractWidget) c0085bB2);
        int y2 = (getY() + this.height) - 40;
        f2378p = new C0085bB(getX() + 32, y2, 70, 16, f2368hC, button3 -> {
            f2379i = null;
            minecraft.setScreen(new C0248dw());
            c0555jlM1886a.getInventory().m2484bi();
            f2381cf = false;
        });
        f2378p.m328a(C0085bB.a.SHADOW);
        f2378p.m324a(0.0f, 1.0f);
        f2378p.mo325a();
        m1632a((AbstractWidget) f2378p, true);
        f2377o = new C0085bB(((getX() + this.width) - 70) - 32, y2, 70, 16, f2367hB, button4 -> {
            f2379i = null;
            minecraft.setScreen(new C0248dw());
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.EXPERIENCE_ORB_PICKUP, (float) (0.8999999761581421d + (0.20000000298023224d * Math.random()))));
        });
        f2377o.m328a(C0085bB.a.SHADOW);
        f2377o.m324a(0.0f, 1.0f);
        f2377o.mo325a();
        m1632a((AbstractWidget) f2377o, true);
        m1642v(false);
    }

    /* JADX INFO: renamed from: v */
    private void m1642v(boolean z) {
        f2377o.visible = z;
        f2377o.active = z;
        f2378p.visible = z;
        f2378p.active = z;
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    /* JADX INFO: renamed from: a */
    public void mo1443a(float f) {
        Minecraft minecraft = Minecraft.getInstance();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null) {
            return;
        }
        C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
        CloudRegistry cloudRegistryA = c0623lM2852b.m2855a();
        C0550jg inventory = c0396gl.m1886a(minecraft).getInventory();
        if (f2374jj > 0) {
            f2374jj--;
            return;
        }
        int i = f2376jl;
        f2376jl = i + 1;
        if (i > 5) {
            init();
            f2376jl = 0;
        }
        f2363H.forEach(c0087bD -> {
            c0087bD.m354d(inventory.m2486a(cloudRegistryA, c0087bD.m356a()));
            c0087bD.m355e(inventory.isItemShowcased(c0087bD.m356a().getUUID()));
        });
        if (f2379i == null) {
            inventory.m2483a().ifPresent(uuid -> {
                f2379i = inventory.getStackFromUUID(uuid).orElse(null);
            });
        }
        Stream<UUID> stream = inventory.m2481p().stream();
        Objects.requireNonNull(inventory);
        inventory.m2482f((ObjectArrayList) stream.filter(inventory::hasItemStack).collect(Collectors.toCollection(ObjectArrayList::new)));
        m1642v(f2379i != null);
        f2363H.forEach(c0087bD2 -> {
            c0087bD2.m348a(minecraft, cloudRegistryA);
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    /* JADX INFO: renamed from: a */
    protected void mo1440a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull C0555jl c0555jl, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        PoseStack poseStackPose = guiGraphics.pose();
        Font font = minecraft.font;
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        CloudRegistry cloudRegistryA = c0623l.m2855a();
        C0129bt.m591c(guiGraphics, getX(), getY(), this.width, this.height, C0129bt.m465t());
        poseStackPose.pushPose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        if (f2374jj > 0) {
            C0129bt.m483c(font, guiGraphics, f2364hy, getX() + i3, getY() + 50);
            poseStackPose.popPose();
            return;
        }
        int size = f2363H.size();
        C0087bD c0087bD = null;
        for (int i5 = 0; i5 < size; i5++) {
            C0087bD c0087bD2 = f2363H.get(i5);
            c0087bD2.m350a(minecraft, guiGraphics, font, f2379i != null, i, i2, f2);
            if (c0087bD2.m353a(i, i2) && c0087bD != c0087bD2 && f2379i == null) {
                c0087bD = c0087bD2;
            }
        }
        if (f2363H.isEmpty()) {
            C0129bt.m587a(guiGraphics, (getX() + i3) - (42 / 2), ((getY() + i4) - 42) + 8, 42, ColorReferences.COLOR_WHITE_SOLID, f);
            C0129bt.m483c(font, guiGraphics, f2365hz, getX() + i3, getY() + (this.height / 2) + 16);
        }
        if (c0087bD != null && !c0087bD.f565a.getUUID().equals(f2380j)) {
            f2380j = c0087bD.f565a.getUUID();
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7971ps.get(), 1.0f));
            minecraft.getNarrator().sayNow(c0087bD.f565a.getDisplayName(cloudRegistryA, true));
        }
        m1643a(minecraft, guiGraphics, font, poseStackPose, bufferSource, cloudRegistryA, c0555jl, i, i2, f2);
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    private void m1643a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull CloudRegistry cloudRegistry, @NotNull C0555jl c0555jl, int i, int i2, float f) {
        if (f2379i == null) {
            return;
        }
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        CloudItem<?> cloudItem = f2379i.getCloudItem(cloudRegistry);
        if (cloudItem == null) {
            return;
        }
        int color = cloudItem.getRarity().getColor();
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 80.0f);
        C0129bt.m517a(guiGraphics, getX(), getY(), this.width, this.height, C0129bt.m465t(), 0.9f);
        poseStack.pushPose();
        C0129bt.m547b(poseStack, guiGraphics, C0143cG.f1047aR, getX() + i3, getY() + i4, this.width, this.height, 0.0f, 1.0f, color);
        C0564ju.m2556a(cloudItem).mo2302a(cloudItem, f2379i, minecraft, guiGraphics, poseStack, multiBufferSource, getX(), getY(), this.width, this.height, i, i2, f);
        C0129bt.m494c(poseStack, font, guiGraphics, f2366hA, getX() + (this.width / 2), getY() + 4, 1.5f);
        String displayName = f2379i.getDisplayName(cloudRegistry);
        C0129bt.m494c(poseStack, font, guiGraphics, (Component) Component.literal(displayName).withStyle(ChatFormatting.BOLD).withColor(color), getX() + (this.width / 2), getY() + 20, C1270xJ.m7194a(displayName, minecraft.font, 2.0f, this.width - 60, 2.0f));
        List<UUID> listM2481p = c0555jl.getInventory().m2481p();
        if (!listM2481p.isEmpty()) {
            C0129bt.m499a(poseStack, font, guiGraphics, (Component) Component.translatable("bf.menu.inventory.newitem.more", new Object[]{String.valueOf(listM2481p.size())}).withStyle(ChatFormatting.GRAY), getX() + (this.width / 2), (getY() + this.height) - 18);
        }
        f2377o.render(guiGraphics, i, i2, f);
        f2378p.render(guiGraphics, i, i2, f);
        poseStack.popPose();
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: f */
    private int m1644f(int i) {
        int i2 = i;
        int i3 = 0;
        while (i2 > 0) {
            i2 -= 15;
            i3++;
        }
        return i3;
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    public boolean mouseClicked(double d, double d2, int i) {
        Minecraft minecraft = Minecraft.getInstance();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b != null) {
            for (C0087bD c0087bD : f2363H) {
                if (new Rectangle(c0087bD.f566cc, c0087bD.f568cd, c0087bD.f569dE, c0087bD.f570dF).contains(d, d2) && i == 1) {
                    minecraft.setScreen(C0559jp.m2540a(minecraft.screen, c0623lM2852b, c0087bD.f565a, (int) (d + 2.0d), (int) (d2 + 2.0d)));
                    return true;
                }
            }
        }
        return super.mouseClicked(d, d2, i);
    }
}
