package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ej */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ej.class */
public final class C0287ej implements Toast {

    /* JADX INFO: renamed from: hL */
    public static final int f2174hL = 4;

    /* JADX INFO: renamed from: hM */
    public static final int f2175hM = 4;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final EnumC0286ei f2176a;

    /* JADX INFO: renamed from: o */
    @NotNull
    private Component f2177o;

    /* JADX INFO: renamed from: ho */
    @Nullable
    private Component f2178ho;

    /* JADX INFO: renamed from: c */
    private long f2179c;

    /* JADX INFO: renamed from: bS */
    private boolean f2180bS;

    public C0287ej(@NotNull EnumC0286ei enumC0286ei, @NotNull Component component, @Nullable Component component2) {
        this.f2176a = enumC0286ei;
        this.f2177o = component;
        this.f2178ho = component2;
    }

    /* JADX INFO: renamed from: a */
    public static void m1506a(@NotNull ToastComponent toastComponent, @NotNull EnumC0286ei enumC0286ei, @NotNull Component component, @Nullable Component component2) {
        C0287ej c0287ej = (C0287ej) toastComponent.getToast(C0287ej.class, enumC0286ei);
        if (c0287ej == null) {
            toastComponent.addToast(new C0287ej(enumC0286ei, component, component2));
        } else {
            c0287ej.m1512a(component, component2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1507a(@NotNull Minecraft minecraft, @NotNull Component component) {
        m1511a(minecraft, C0029a.f251b, component, EnumC0286ei.CLIENT_NOTIFICATION, false);
    }

    /* JADX INFO: renamed from: a */
    public static void m1508a(@NotNull Minecraft minecraft, @NotNull Component component, @NotNull EnumC0286ei enumC0286ei) {
        m1511a(minecraft, C0029a.f251b, component, enumC0286ei, false);
    }

    /* JADX INFO: renamed from: a */
    public static void m1509a(@NotNull Minecraft minecraft, @NotNull Component component, @NotNull Component component2) {
        m1510a(minecraft, component, component2, false);
    }

    /* JADX INFO: renamed from: a */
    public static void m1510a(@NotNull Minecraft minecraft, @NotNull Component component, @NotNull Component component2, boolean z) {
        m1511a(minecraft, component, component2, EnumC0286ei.CLIENT_NOTIFICATION, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m1511a(@NotNull Minecraft minecraft, @NotNull Component component, @NotNull Component component2, @NotNull EnumC0286ei enumC0286ei, boolean z) {
        if (minecraft.options.hideGui) {
            return;
        }
        m1506a(minecraft.getToasts(), enumC0286ei, component, component2);
        if (z) {
            minecraft.getNarrator().sayNow(ChatFormatting.stripFormatting(component.getString() + component2.getString()));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1512a(@NotNull Component component, @Nullable Component component2) {
        this.f2177o = component;
        this.f2178ho = component2;
        this.f2180bS = true;
    }

    @NotNull
    public Toast.Visibility render(@NotNull GuiGraphics guiGraphics, @NotNull ToastComponent toastComponent, long j) {
        Font font = Minecraft.getInstance().font;
        PoseStack poseStackPose = guiGraphics.pose();
        if (this.f2180bS) {
            this.f2179c = j;
            this.f2180bS = false;
        }
        boolean z = j - this.f2179c >= 5000;
        float f = z ? 1.0f : (j - this.f2179c) / 5000.0f;
        int iHeight = height();
        int iWidth = width();
        m1513c(poseStackPose, guiGraphics);
        int i = iHeight - 8;
        C0119bk.m429a(poseStackPose, guiGraphics, this.f2176a.getIcon(), (iWidth - i) - 4, 4, i);
        C0119bk.m371a(font, guiGraphics, this.f2177o, 4, 4, this.f2176a.getColor());
        if (this.f2178ho != null) {
            C0119bk.m376a(poseStackPose, font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) font.split(this.f2178ho, ((iWidth - i) - 4) * 2), 4.0f, 14.0f, 5, 0.5f);
        }
        C0119bk.m416a(poseStackPose, guiGraphics, 2.0f, iHeight - 3, (iWidth - 4) * f, 1.0f, ColorReferences.COLOR_WHITE, 0.25f * f);
        return z ? Toast.Visibility.HIDE : Toast.Visibility.SHOW;
    }

    /* JADX INFO: renamed from: c */
    public void m1513c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics) {
        int iWidth = width();
        int iHeight = height();
        int color = m1514a().getColor();
        int i = color - (-1442840576);
        C0119bk.m415a(guiGraphics, 1, 0, iWidth - 2, 1, -14606047);
        C0119bk.m415a(guiGraphics, 0, 1, iWidth, iHeight - 2, -14606047);
        C0119bk.m415a(guiGraphics, 1, iHeight - 1, iWidth - 2, 1, -14606047);
        C0119bk.m415a(guiGraphics, 1, 1, iWidth - 2, 1, color);
        C0119bk.m415a(guiGraphics, 1, iHeight - 2, iWidth - 2, 1, i);
        C0119bk.m423a(guiGraphics, 1, 2, 1, iHeight - 4, color, i);
        C0119bk.m423a(guiGraphics, iWidth - 2, 2, 1, iHeight - 4, color, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0286ei m1514a() {
        return this.f2176a;
    }

    public int height() {
        return 32;
    }
}
