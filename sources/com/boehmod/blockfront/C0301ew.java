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

/* JADX INFO: renamed from: com.boehmod.blockfront.ew */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ew.class */
public final class C0301ew implements Toast {

    /* JADX INFO: renamed from: jb */
    public static final int f2347jb = 4;

    /* JADX INFO: renamed from: jc */
    public static final int f2348jc = 4;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final EnumC0300ev f2349a;

    /* JADX INFO: renamed from: o */
    @NotNull
    private Component f2350o;

    /* JADX INFO: renamed from: hx */
    @Nullable
    private Component f2351hx;

    /* JADX INFO: renamed from: h */
    private long f2352h;

    /* JADX INFO: renamed from: ca */
    private boolean f2353ca;

    public C0301ew(@NotNull EnumC0300ev enumC0300ev, @NotNull Component component, @Nullable Component component2) {
        this.f2349a = enumC0300ev;
        this.f2350o = component;
        this.f2351hx = component2;
    }

    /* JADX INFO: renamed from: a */
    public static void m1622a(@NotNull ToastComponent toastComponent, @NotNull EnumC0300ev enumC0300ev, @NotNull Component component, @Nullable Component component2) {
        C0301ew c0301ew = (C0301ew) toastComponent.getToast(C0301ew.class, enumC0300ev);
        if (c0301ew == null) {
            toastComponent.addToast(new C0301ew(enumC0300ev, component, component2));
        } else {
            c0301ew.m1628a(component, component2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1623a(@NotNull Minecraft minecraft, @NotNull Component component) {
        m1627a(minecraft, C0030a.f268b, component, EnumC0300ev.CLIENT_NOTIFICATION, false);
    }

    /* JADX INFO: renamed from: a */
    public static void m1624a(@NotNull Minecraft minecraft, @NotNull Component component, @NotNull EnumC0300ev enumC0300ev) {
        m1627a(minecraft, C0030a.f268b, component, enumC0300ev, false);
    }

    /* JADX INFO: renamed from: a */
    public static void m1625a(@NotNull Minecraft minecraft, @NotNull Component component, @NotNull Component component2) {
        m1626a(minecraft, component, component2, false);
    }

    /* JADX INFO: renamed from: a */
    public static void m1626a(@NotNull Minecraft minecraft, @NotNull Component component, @NotNull Component component2, boolean z) {
        m1627a(minecraft, component, component2, EnumC0300ev.CLIENT_NOTIFICATION, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m1627a(@NotNull Minecraft minecraft, @NotNull Component component, @NotNull Component component2, @NotNull EnumC0300ev enumC0300ev, boolean z) {
        if (minecraft.options.hideGui) {
            return;
        }
        m1622a(minecraft.getToasts(), enumC0300ev, component, component2);
        if (z) {
            minecraft.getNarrator().sayNow(ChatFormatting.stripFormatting(component.getString() + component2.getString()));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1628a(@NotNull Component component, @Nullable Component component2) {
        this.f2350o = component;
        this.f2351hx = component2;
        this.f2353ca = true;
    }

    @NotNull
    public Toast.Visibility render(@NotNull GuiGraphics guiGraphics, @NotNull ToastComponent toastComponent, long j) {
        Font font = Minecraft.getInstance().font;
        PoseStack poseStackPose = guiGraphics.pose();
        if (this.f2353ca) {
            this.f2352h = j;
            this.f2353ca = false;
        }
        boolean z = j - this.f2352h >= 5000;
        float f = z ? 1.0f : (j - this.f2352h) / 5000.0f;
        int iHeight = height();
        int iWidth = width();
        m1629c(poseStackPose, guiGraphics);
        int i = iHeight - 8;
        C0129bt.m529a(poseStackPose, guiGraphics, this.f2349a.getIcon(), (iWidth - i) - 4, 4, i);
        C0129bt.m471a(font, guiGraphics, this.f2350o, 4, 4, this.f2349a.getColor());
        if (this.f2351hx != null) {
            C0129bt.m476a(poseStackPose, font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) font.split(this.f2351hx, ((iWidth - i) - 4) * 2), 4.0f, 14.0f, 5, 0.5f);
        }
        C0129bt.m516a(poseStackPose, guiGraphics, 2.0f, iHeight - 3, (iWidth - 4) * f, 1.0f, ColorReferences.COLOR_WHITE, 0.25f * f);
        return z ? Toast.Visibility.HIDE : Toast.Visibility.SHOW;
    }

    /* JADX INFO: renamed from: c */
    public void m1629c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics) {
        int iWidth = width();
        int iHeight = height();
        int color = m1630a().getColor();
        int i = color - (-1442840576);
        C0129bt.m518b(guiGraphics, 0, 0, iWidth, iHeight, -14606047);
        C0129bt.m515a(guiGraphics, 1, 1, iWidth - 2, 1, color);
        C0129bt.m515a(guiGraphics, 1, iHeight - 2, iWidth - 2, 1, i);
        C0129bt.m523a(guiGraphics, 1, 2, 1, iHeight - 4, color, i);
        C0129bt.m523a(guiGraphics, iWidth - 2, 2, 1, iHeight - 4, color, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0300ev m1630a() {
        return this.f2349a;
    }

    public int height() {
        return 32;
    }
}
