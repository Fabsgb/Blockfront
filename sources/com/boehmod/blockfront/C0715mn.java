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

/* JADX INFO: renamed from: com.boehmod.blockfront.mn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mn.class */
public class C0715mn extends AbstractC0716mo {

    /* JADX INFO: renamed from: q */
    public static final MutableComponent f3826q = Component.literal("US Bootcamp");

    /* JADX INFO: renamed from: e */
    @NotNull
    private final AbstractC0787oF<?, ?, ?> f3827e;

    /* JADX INFO: renamed from: hR */
    private float f3829hR = 1.0f;

    /* JADX INFO: renamed from: hQ */
    private float f3828hQ = 1.0f;

    /* JADX INFO: renamed from: hT */
    private float f3831hT = 1.0f;

    /* JADX INFO: renamed from: hS */
    private float f3830hS = 1.0f;

    /* JADX INFO: renamed from: kB */
    private int f3832kB = 40;

    public C0715mn(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        this.f3827e = abstractC0787oF;
    }

    @Override // com.boehmod.blockfront.AbstractC0716mo
    /* JADX INFO: renamed from: a */
    public boolean mo3254a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.f3829hR = this.f3828hQ;
        this.f3831hT = this.f3830hS;
        if (this.f3828hQ > 0.0f) {
            this.f3828hQ = Mth.lerp(0.1f, this.f3828hQ, 0.0f);
            if (this.f3828hQ <= 0.01f) {
                this.f3828hQ = 0.0f;
            }
        } else if (this.f3832kB > 0) {
            this.f3832kB--;
        } else if (this.f3830hS > 0.0f) {
            this.f3830hS = C1290xm.m7835d(this.f3830hS, 0.0f, 0.03f);
        }
        return this.f3830hS <= 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0716mo
    /* JADX INFO: renamed from: d */
    public void mo3255d(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        int i3 = i / 2;
        int i4 = i2 / 2;
        float fM7843e = C1290xm.m7843e(this.f3828hQ, this.f3829hR, f);
        float fM7843e2 = C1290xm.m7843e(this.f3830hS, this.f3831hT, f);
        if (fM7843e2 <= 0.0f) {
            return;
        }
        int rgb = new Color(1.0f, 1.0f, 1.0f, Math.min(1.0f - fM7843e, Math.min(1.0f, fM7843e2 + 0.1f))).getRGB();
        float f2 = 40.0f * fM7843e;
        C0796oO c0796oOM3793a = this.f3827e.m3582b().m3793a((UUID) Objects.requireNonNull(minecraft.getUser().getProfileId()));
        if (c0796oOM3793a != null) {
            C0119bk.m417a(guiGraphics, 0, 0, i, i2, 0, fM7843e2);
            C0119bk.m392c(poseStack, font, guiGraphics, (Component) f3826q, i3, (i4 - 35) + f2, rgb, 3.0f);
            C0119bk.m392c(poseStack, font, guiGraphics, (Component) Component.literal("August 20th, 1941").withStyle(c0796oOM3793a.m3876a()), i3, (i4 - 10) + f2, rgb, 1.0f);
            C0119bk.m417a(guiGraphics, 0, 0, i, i2, 0, fM7843e);
        }
    }
}
