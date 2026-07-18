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

/* JADX INFO: renamed from: com.boehmod.blockfront.bt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bt.class */
public class C0128bt extends C0127bs {

    /* JADX INFO: renamed from: aD */
    private boolean f920aD;

    /* JADX INFO: renamed from: cY */
    private float f921cY;

    /* JADX INFO: renamed from: aE */
    private boolean f922aE;

    public C0128bt(Minecraft minecraft, int i, int i2, int i3, int i4, Component component, C0234dj c0234dj) {
        this(minecraft, i, i2, i3, i4, component, button -> {
            minecraft.setScreen(c0234dj);
        });
    }

    public C0128bt(Minecraft minecraft, int i, int i2, int i3, int i4, Component component, Button.OnPress onPress) {
        super(i, i2, i3, i4, component, onPress);
        this.f920aD = false;
        this.f921cY = 0.0f;
        this.f922aE = false;
        Screen screen = minecraft.screen;
        if (screen instanceof C0195cx) {
            this.f920aD = component.getString().equalsIgnoreCase(((C0195cx) screen).f1584bj.getString());
        }
        this.width = (minecraft.font.width(component) + 15) / 2;
    }

    @Override // com.boehmod.blockfront.C0127bs
    public void playDownSound(@NotNull SoundManager soundManager) {
        if (this.f920aD) {
            return;
        }
        super.playDownSound(soundManager);
    }

    public void onPress() {
        if (this.f920aD) {
            return;
        }
        super.onPress();
    }

    @Override // com.boehmod.blockfront.C0127bs
    /* JADX INFO: renamed from: a */
    public C0128bt mo650a() {
        this.f922aE = true;
        return this;
    }

    @Override // com.boehmod.blockfront.C0127bs
    /* JADX INFO: renamed from: a */
    public void mo636a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, float f, float f2) {
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int x = getX();
        int y = getY();
        if (this.f920aD) {
            C0119bk.m445b(poseStack, guiGraphics, C0195cx.f1568aL, x + i3, y + i4, 50, 30, 1.0f, 1.0f - (0.2f * (Mth.sin(f / 2.0f) * Mth.sin(f / 4.0f))));
            C0119bk.m445b(poseStack, guiGraphics, C0195cx.f1568aL, x + i3, y + i4, 50, 30, 1.0f, this.f921cY);
            super.mo636a(guiGraphics, poseStack, i, i2, f, f2);
        }
        this.f921cY = Mth.lerp(0.3f, this.f921cY, this.isHovered ? 1.0f : 0.0f);
        if (this.f920aD && this.f922aE) {
            float f3 = 2.0f * this.f921cY;
            C0119bk.m413a(poseStack, x + i3 + 0.5f, y + this.height, i3, f3, mo668s(), 1);
            C0119bk.m413a(poseStack, x, y + this.height, i3 + 0.5f, f3, mo668s(), 2);
        }
    }

    @Override // com.boehmod.blockfront.C0127bs
    /* JADX INFO: renamed from: a */
    public void mo662a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        C0119bk.m392c(poseStack, font, guiGraphics, (Component) getMessage().withStyle(ChatFormatting.BOLD), getX() + (this.width / 2) + 0.5f, (getY() + (this.height / 2)) - 2, mo637r(), 0.5f);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public MutableComponent getMessage() {
        return Component.literal(super.getMessage().getString().toUpperCase(Locale.ROOT).replace("_", " "));
    }

    @Override // com.boehmod.blockfront.C0127bs
    /* JADX INFO: renamed from: r */
    public int mo637r() {
        return this.f920aD ? ColorReferences.COLOR_BLACK_SOLID : isHoveredOrFocused() ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID;
    }

    @Override // com.boehmod.blockfront.C0127bs
    /* JADX INFO: renamed from: s */
    public int mo668s() {
        return this.f920aD ? ColorReferences.COLOR_THEME_YELLOW_SOLID : C0119bk.m365p();
    }
}
