package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Locale;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bt.class */
public class C0049bt extends C0048bs {
    private boolean aD;
    private float cY;
    private boolean aE;

    public C0049bt(Minecraft minecraft, int i, int i2, int i3, int i4, Component component, C0093dj c0093dj) {
        this(minecraft, i, i2, i3, i4, component, button -> {
            minecraft.setScreen(c0093dj);
        });
    }

    public C0049bt(Minecraft minecraft, int i, int i2, int i3, int i4, Component component, Button.OnPress onPress) {
        super(i, i2, i3, i4, component, onPress);
        this.aD = false;
        this.cY = 0.0f;
        this.aE = false;
        Screen screen = minecraft.screen;
        if (screen instanceof C0080cx) {
            this.aD = component.getString().equalsIgnoreCase(((C0080cx) screen).bj.getString());
        }
        this.width = (minecraft.font.width(component) + 15) / 2;
    }

    @Override // com.boehmod.blockfront.C0048bs
    public void playDownSound(@NotNull SoundManager soundManager) {
        if (this.aD) {
            return;
        }
        super.playDownSound(soundManager);
    }

    public void onPress() {
        if (this.aD) {
            return;
        }
        super.onPress();
    }

    @Override // com.boehmod.blockfront.C0048bs
    public C0049bt a() {
        this.aE = true;
        return this;
    }

    @Override // com.boehmod.blockfront.C0048bs
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, float f, float f2) {
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int x = getX();
        int y = getY();
        if (this.aD) {
            C0040bk.b(poseStack, guiGraphics, C0080cx.aL, x + i3, y + i4, 50, 30, 1.0f, 1.0f - (0.2f * (Mth.sin(f / 2.0f) * Mth.sin(f / 4.0f))));
            C0040bk.b(poseStack, guiGraphics, C0080cx.aL, x + i3, y + i4, 50, 30, 1.0f, this.cY);
            super.a(guiGraphics, poseStack, i, i2, f, f2);
        }
        this.cY = Mth.lerp(0.3f, this.cY, this.isHovered ? 1.0f : 0.0f);
        if (this.aD && this.aE) {
            float f3 = 2.0f * this.cY;
            C0040bk.a(poseStack, x + i3 + 0.5f, y + this.height, i3, f3, s(), 1);
            C0040bk.a(poseStack, x, y + this.height, i3 + 0.5f, f3, s(), 2);
        }
    }

    @Override // com.boehmod.blockfront.C0048bs
    public void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        C0040bk.c(poseStack, font, guiGraphics, (Component) getMessage().withStyle(ChatFormatting.BOLD), getX() + (this.width / 2) + 0.5f, (getY() + (this.height / 2)) - 2, r(), 0.5f);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public MutableComponent getMessage() {
        return Component.literal(super.getMessage().getString().toUpperCase(Locale.ROOT).replace("_", " "));
    }

    @Override // com.boehmod.blockfront.C0048bs
    public int r() {
        return this.aD ? ColorReferences.COLOR_BLACK_SOLID : isHoveredOrFocused() ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID;
    }

    @Override // com.boehmod.blockfront.C0048bs
    public int s() {
        return this.aD ? ColorReferences.COLOR_THEME_YELLOW_SOLID : C0040bk.p();
    }
}
