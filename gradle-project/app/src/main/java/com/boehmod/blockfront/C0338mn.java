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

/* JADX INFO: renamed from: com.boehmod.blockfront.mn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mn.class */
public class C0338mn extends AbstractC0339mo {
    public static final MutableComponent q = Component.literal("US Bootcamp");

    @NotNull
    private final oF<?, ?, ?> e;
    private float hR = 1.0f;
    private float hQ = 1.0f;
    private float hT = 1.0f;
    private float hS = 1.0f;
    private int kB = 40;

    public C0338mn(@NotNull oF<?, ?, ?> oFVar) {
        this.e = oFVar;
    }

    @Override // com.boehmod.blockfront.AbstractC0339mo
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.hR = this.hQ;
        this.hT = this.hS;
        if (this.hQ > 0.0f) {
            this.hQ = Mth.lerp(0.1f, this.hQ, 0.0f);
            if (this.hQ <= 0.01f) {
                this.hQ = 0.0f;
            }
        } else if (this.kB > 0) {
            this.kB--;
        } else if (this.hS > 0.0f) {
            this.hS = C0634xm.d(this.hS, 0.0f, 0.03f);
        }
        return this.hS <= 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0339mo
    public void d(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        int i3 = i / 2;
        int i4 = i2 / 2;
        float fE = C0634xm.e(this.hQ, this.hR, f);
        float fE2 = C0634xm.e(this.hS, this.hT, f);
        if (fE2 <= 0.0f) {
            return;
        }
        int rgb = new Color(1.0f, 1.0f, 1.0f, Math.min(1.0f - fE, Math.min(1.0f, fE2 + 0.1f))).getRGB();
        float f2 = 40.0f * fE;
        oO oOVarA = this.e.b().a((UUID) Objects.requireNonNull(minecraft.getUser().getProfileId()));
        if (oOVarA != null) {
            C0040bk.a(guiGraphics, 0, 0, i, i2, 0, fE2);
            C0040bk.c(poseStack, font, guiGraphics, (Component) q, i3, (i4 - 35) + f2, rgb, 3.0f);
            C0040bk.c(poseStack, font, guiGraphics, (Component) Component.literal("August 20th, 1941").withStyle(oOVarA.a()), i3, (i4 - 10) + f2, rgb, 1.0f);
            C0040bk.a(guiGraphics, 0, 0, i, i2, 0, fE);
        }
    }
}
