package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ms, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ms.class */
public class C0343ms extends AbstractC0339mo {
    private static final Component im = Component.translatable("bf.message.gamemode.victory").withStyle(C0266jw.b);
    private static final Component in = Component.translatable("bf.message.gamemode.defeat").withStyle(C0266jw.b);
    public static final float il = 0.05f;

    /* JADX INFO: renamed from: im, reason: collision with other field name */
    public static final float f250im = 0.05f;

    /* JADX INFO: renamed from: in, reason: collision with other field name */
    public static final float f251in = 0.025f;

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    public static final float f418io = 4.0f;
    public static final float ip = 1.5f;
    private int kD = 20;
    private int kE = 140;
    private float ij = 0.0f;
    private float ik = 0.0f;
    private float iq = 0.0f;
    private float ir = 0.0f;

    /* JADX INFO: renamed from: io, reason: collision with other field name */
    private final Component f252io;

    /* JADX INFO: renamed from: ip, reason: collision with other field name */
    private final Component f253ip;

    public C0343ms(@NotNull oF<?, ?, ?> oFVar, @NotNull Component component, boolean z) {
        MutableComponent mutableComponentWithColor = Component.literal(C0637xp.p(component.getString())).withColor(ColorReferences.TROPHY_COLOR_GOLD);
        this.f252io = z ? im : in;
        this.f253ip = mutableComponentWithColor;
    }

    @Override // com.boehmod.blockfront.AbstractC0339mo
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.ik = this.ij;
        this.ir = this.iq;
        int i = this.kD;
        this.kD = i - 1;
        if (i <= 0) {
            int i2 = this.kE;
            this.kE = i2 - 1;
            if (i2 <= 0) {
                this.ij = C0634xm.d(this.ij, 0.0f, 0.05f);
            } else {
                this.ij = C0634xm.d(this.ij, 1.0f, 0.05f);
            }
        }
        if (this.kE <= 0 && this.ij <= 0.0f) {
            this.iq = C0634xm.d(this.iq, 1.0f, 0.025f);
        }
        if (this.iq >= 1.0f && this.ir >= 1.0f) {
            oG<?, ?> oGVarM593a = c0297l.m593a();
            if (oGVarM593a != null) {
                oGVarM593a.m774a().V(false);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0339mo
    public void d(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        int i3 = i / 2;
        int i4 = i2 / 2;
        float fE = C0634xm.e(this.ij, this.ik, f);
        if (fE >= 0.04f) {
            C0040bk.b(poseStack, guiGraphics, C0080cx.aJ, i3, i4, 200, 200, 0.0f, 0.25f * fE);
            int iA = C0634xm.a(ColorReferences.COLOR_WHITE, fE);
            C0040bk.c(poseStack, font, guiGraphics, this.f252io, i3, i4 - 30, iA, 4.0f);
            C0040bk.d(poseStack, font, guiGraphics, this.f253ip, i3 + 0.5f, i4 + 10, iA, 1.5f);
        }
        C0040bk.a(guiGraphics, 0, 0, i, i2, 0, C0634xm.e(this.iq, this.ir, f));
    }
}
