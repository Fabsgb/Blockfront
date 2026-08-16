package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.awt.Color;
import java.util.Objects;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.mJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mJ.class */
public class C0686mJ extends AbstractC0687mK {

    /* JADX INFO: renamed from: q */
    public static final MutableComponent f3778q = Component.literal("US Bootcamp");

    /* JADX INFO: renamed from: e */
    @NotNull
    private final AbstractC0863pb<?, ?, ?> f3779e;

    /* JADX INFO: renamed from: iJ */
    private float f3781iJ = 1.0f;

    /* JADX INFO: renamed from: iI */
    private float f3780iI = 1.0f;

    /* JADX INFO: renamed from: iL */
    private float f3783iL = 1.0f;

    /* JADX INFO: renamed from: iK */
    private float f3782iK = 1.0f;

    /* JADX INFO: renamed from: mw */
    private int f3784mw = 40;

    public C0686mJ(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        this.f3779e = abstractC0863pb;
    }

    @Override // com.boehmod.blockfront.AbstractC0687mK
    /* JADX INFO: renamed from: a */
    public boolean mo3087a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.f3781iJ = this.f3780iI;
        this.f3783iL = this.f3782iK;
        if (this.f3780iI > 0.0f) {
            this.f3780iI = Mth.lerp(0.1f, this.f3780iI, 0.0f);
            if (this.f3780iI <= 0.01f) {
                this.f3780iI = 0.0f;
            }
        } else if (this.f3784mw > 0) {
            this.f3784mw--;
        } else if (this.f3782iK > 0.0f) {
            this.f3782iK = C1270xJ.m7161d(this.f3782iK, 0.0f, 0.03f);
        }
        return this.f3782iK <= 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0687mK
    /* JADX INFO: renamed from: d */
    public void mo3088d(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        int i3 = i / 2;
        int i4 = i2 / 2;
        float fM7170f = C1270xJ.m7170f(this.f3780iI, this.f3781iJ, f);
        float fM7170f2 = C1270xJ.m7170f(this.f3782iK, this.f3783iL, f);
        if (fM7170f2 <= 0.0f) {
            return;
        }
        int rgb = new Color(1.0f, 1.0f, 1.0f, Math.min(1.0f - fM7170f, Math.min(1.0f, fM7170f2 + 0.1f))).getRGB();
        float f2 = 40.0f * fM7170f;
        C0872pk c0872pkM4229a = this.f3779e.m4018b().m4229a((UUID) Objects.requireNonNull(minecraft.getUser().getProfileId()));
        if (c0872pkM4229a != null) {
            C0129bt.m517a(guiGraphics, 0, 0, i, i2, 0, fM7170f2);
            C0129bt.m492c(poseStack, font, guiGraphics, (Component) f3778q, i3, (i4 - 35) + f2, rgb, 3.0f);
            C0129bt.m492c(poseStack, font, guiGraphics, (Component) Component.literal("August 20th, 1941").withStyle(c0872pkM4229a.m4312a()), i3, (i4 - 10) + f2, rgb, 1.0f);
            C0129bt.m517a(guiGraphics, 0, 0, i, i2, 0, fM7170f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0687mK
    /* JADX INFO: renamed from: r */
    public float mo3089r(float f) {
        float fM7170f = C1270xJ.m7170f(this.f3780iI, this.f3781iJ, f);
        float fM7170f2 = C1270xJ.m7170f(this.f3782iK, this.f3783iL, f);
        if (fM7170f2 <= 0.0f) {
            return 0.0f;
        }
        return Math.max(fM7170f, fM7170f2);
    }
}
