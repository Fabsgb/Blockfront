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

/* JADX INFO: renamed from: com.boehmod.blockfront.bC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bC.class */
public class C0086bC extends C0085bB {

    /* JADX INFO: renamed from: aI */
    private boolean f559aI;

    /* JADX INFO: renamed from: de */
    private float f560de;

    /* JADX INFO: renamed from: aJ */
    private boolean f561aJ;

    public C0086bC(Minecraft minecraft, int i, int i2, int i3, int i4, Component component, C0244ds c0244ds) {
        this(minecraft, i, i2, i3, i4, component, button -> {
            minecraft.setScreen(c0244ds);
        });
    }

    public C0086bC(Minecraft minecraft, int i, int i2, int i3, int i4, Component component, Button.OnPress onPress) {
        super(i, i2, i3, i4, component, onPress);
        this.f559aI = false;
        this.f560de = 0.0f;
        this.f561aJ = false;
        Screen screen = minecraft.screen;
        if (screen instanceof C0143cG) {
            this.f559aI = component.getString().equalsIgnoreCase(((C0143cG) screen).f1055bl.getString());
        }
        this.width = (minecraft.font.width(component) + 15) / 2;
    }

    @Override // com.boehmod.blockfront.C0085bB
    public void playDownSound(@NotNull SoundManager soundManager) {
        if (this.f559aI) {
            return;
        }
        super.playDownSound(soundManager);
    }

    public void onPress() {
        if (this.f559aI) {
            return;
        }
        super.onPress();
    }

    @Override // com.boehmod.blockfront.C0085bB
    /* JADX INFO: renamed from: a */
    public C0086bC mo325a() {
        this.f561aJ = true;
        return this;
    }

    @Override // com.boehmod.blockfront.C0085bB
    /* JADX INFO: renamed from: a */
    public void mo311a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, float f, float f2) {
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int x = getX();
        int y = getY();
        if (this.f559aI) {
            C0129bt.m545b(poseStack, guiGraphics, C0143cG.f1041aL, x + i3, y + i4, 50, 30, 1.0f, 1.0f - (0.2f * (Mth.sin(f / 2.0f) * Mth.sin(f / 4.0f))));
            C0129bt.m545b(poseStack, guiGraphics, C0143cG.f1041aL, x + i3, y + i4, 50, 30, 1.0f, this.f560de);
            super.mo311a(guiGraphics, poseStack, i, i2, f, f2);
        }
        this.f560de = Mth.lerp(0.3f, this.f560de, this.isHovered ? 1.0f : 0.0f);
        if (this.f559aI && this.f561aJ) {
            float f3 = 2.0f * this.f560de;
            C0129bt.m513a(poseStack, x + i3 + 0.5f, y + this.height, i3, f3, mo343w(), 1);
            C0129bt.m513a(poseStack, x, y + this.height, i3 + 0.5f, f3, mo343w(), 2);
        }
    }

    @Override // com.boehmod.blockfront.C0085bB
    /* JADX INFO: renamed from: a */
    public void mo337a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        C0129bt.m492c(poseStack, font, guiGraphics, (Component) getMessage().withStyle(ChatFormatting.BOLD), getX() + (this.width / 2) + 0.5f, (getY() + (this.height / 2)) - 2, mo312v(), 0.5f);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public MutableComponent getMessage() {
        return Component.literal(super.getMessage().getString().toUpperCase(Locale.ROOT).replace("_", " "));
    }

    @Override // com.boehmod.blockfront.C0085bB
    /* JADX INFO: renamed from: v */
    public int mo312v() {
        if (this.f559aI) {
            return ColorReferences.COLOR_BLACK_SOLID;
        }
        return isHoveredOrFocused() ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID;
    }

    @Override // com.boehmod.blockfront.C0085bB
    /* JADX INFO: renamed from: w */
    public int mo343w() {
        return this.f559aI ? ColorReferences.COLOR_THEME_YELLOW_SOLID : C0129bt.m465t();
    }
}
