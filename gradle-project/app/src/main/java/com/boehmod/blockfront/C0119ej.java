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

/* JADX INFO: renamed from: com.boehmod.blockfront.ej, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ej.class */
public final class C0119ej implements Toast {
    public static final int hL = 4;
    public static final int hM = 4;

    @NotNull
    private final EnumC0118ei a;

    @NotNull
    private Component o;

    @Nullable
    private Component ho;
    private long c;
    private boolean bS;

    public C0119ej(@NotNull EnumC0118ei enumC0118ei, @NotNull Component component, @Nullable Component component2) {
        this.a = enumC0118ei;
        this.o = component;
        this.ho = component2;
    }

    public static void a(@NotNull ToastComponent toastComponent, @NotNull EnumC0118ei enumC0118ei, @NotNull Component component, @Nullable Component component2) {
        C0119ej c0119ej = (C0119ej) toastComponent.getToast(C0119ej.class, enumC0118ei);
        if (c0119ej == null) {
            toastComponent.addToast(new C0119ej(enumC0118ei, component, component2));
        } else {
            c0119ej.a(component, component2);
        }
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull Component component) {
        a(minecraft, C0002a.f30b, component, EnumC0118ei.CLIENT_NOTIFICATION, false);
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull Component component, @NotNull EnumC0118ei enumC0118ei) {
        a(minecraft, C0002a.f30b, component, enumC0118ei, false);
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull Component component, @NotNull Component component2) {
        a(minecraft, component, component2, false);
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull Component component, @NotNull Component component2, boolean z) {
        a(minecraft, component, component2, EnumC0118ei.CLIENT_NOTIFICATION, z);
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull Component component, @NotNull Component component2, @NotNull EnumC0118ei enumC0118ei, boolean z) {
        if (minecraft.options.hideGui) {
            return;
        }
        a(minecraft.getToasts(), enumC0118ei, component, component2);
        if (z) {
            minecraft.getNarrator().sayNow(ChatFormatting.stripFormatting(component.getString() + component2.getString()));
        }
    }

    public void a(@NotNull Component component, @Nullable Component component2) {
        this.o = component;
        this.ho = component2;
        this.bS = true;
    }

    @NotNull
    public Toast.Visibility render(@NotNull GuiGraphics guiGraphics, @NotNull ToastComponent toastComponent, long j) {
        Font font = Minecraft.getInstance().font;
        PoseStack poseStackPose = guiGraphics.pose();
        if (this.bS) {
            this.c = j;
            this.bS = false;
        }
        boolean z = j - this.c >= 5000;
        float f = z ? 1.0f : (j - this.c) / 5000.0f;
        int iHeight = height();
        int iWidth = width();
        c(poseStackPose, guiGraphics);
        int i = iHeight - 8;
        C0040bk.a(poseStackPose, guiGraphics, this.a.getIcon(), (iWidth - i) - 4, 4, i);
        C0040bk.a(font, guiGraphics, this.o, 4, 4, this.a.getColor());
        if (this.ho != null) {
            C0040bk.a(poseStackPose, font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) font.split(this.ho, ((iWidth - i) - 4) * 2), 4.0f, 14.0f, 5, 0.5f);
        }
        C0040bk.a(poseStackPose, guiGraphics, 2.0f, iHeight - 3, (iWidth - 4) * f, 1.0f, ColorReferences.COLOR_WHITE, 0.25f * f);
        return z ? Toast.Visibility.HIDE : Toast.Visibility.SHOW;
    }

    public void c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics) {
        int iWidth = width();
        int iHeight = height();
        int color = a().getColor();
        int i = color - (-1442840576);
        C0040bk.a(guiGraphics, 1, 0, iWidth - 2, 1, -14606047);
        C0040bk.a(guiGraphics, 0, 1, iWidth, iHeight - 2, -14606047);
        C0040bk.a(guiGraphics, 1, iHeight - 1, iWidth - 2, 1, -14606047);
        C0040bk.a(guiGraphics, 1, 1, iWidth - 2, 1, color);
        C0040bk.a(guiGraphics, 1, iHeight - 2, iWidth - 2, 1, i);
        C0040bk.a(guiGraphics, 1, 2, 1, iHeight - 4, color, i);
        C0040bk.a(guiGraphics, iWidth - 2, 2, 1, iHeight - 4, color, i);
    }

    @NotNull
    public EnumC0118ei a() {
        return this.a;
    }

    public int height() {
        return 32;
    }
}
