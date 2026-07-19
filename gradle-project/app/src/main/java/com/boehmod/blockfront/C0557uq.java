package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uq.class */
public class C0557uq {

    @NotNull
    public static final a a = new a() { // from class: com.boehmod.blockfront.uq.1
        @Override // com.boehmod.blockfront.C0557uq.a
        @OnlyIn(Dist.CLIENT)
        public void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull C0558ur c0558ur, @NotNull ItemStack itemStack, @NotNull Style style, int i, float f, float f2, int i2, int i3, int i4, int i5, float f3) {
            int iCb = c0558ur.m1206a(itemStack).cb();
            float fE = C0634xm.e(C0066cj.dB, C0066cj.dC, f3);
            float f4 = (C0066cj.dB / iCb) * (i2 - 2);
            MutableComponent mutableComponentWithStyle = Component.literal(C0637xp.a((int) fE)).withStyle(ChatFormatting.BOLD).withStyle(style);
            MutableComponent mutableComponentWithColor = Component.literal("/").withColor(ColorReferences.COLOR_WHITE);
            MutableComponent mutableComponentAppend = mutableComponentWithStyle.append(mutableComponentWithColor).append(Component.literal(C0637xp.a(C0066cj.dD)).withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD)).append(Component.literal("ML").withColor(ColorReferences.COLOR_WHITE));
            C0040bk.a(poseStack, guiGraphics, f + 1.0f, f2, f4, 1.0f, ColorReferences.COLOR_WHITE_SOLID);
            C0040bk.b(poseStack, font, guiGraphics, (Component) mutableComponentAppend, i4 - 102, f2 + 5.0f, i, 0.75f);
        }
    };

    @NotNull
    private static final Component jE = Component.literal("/").withColor(ColorReferences.COLOR_WHITE);

    @NotNull
    public static final a b = new a() { // from class: com.boehmod.blockfront.uq.2
        static final /* synthetic */ boolean hQ;

        static {
            hQ = !C0557uq.class.desiredAssertionStatus();
        }

        @Override // com.boehmod.blockfront.C0557uq.a
        @OnlyIn(Dist.CLIENT)
        public void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull C0558ur c0558ur, @NotNull ItemStack itemStack, @NotNull Style style, int i, float f, float f2, int i2, int i3, int i4, int i5, float f3) {
            C0297l c0297lB = C0297l.b();
            if (!hQ && c0297lB == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            uS uSVarM1210a = c0558ur.m1210a();
            float fCg = uSVarM1210a.cg();
            oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
            if (oFVarM591a != null) {
                fCg *= oFVarM591a.aG();
            }
            C0040bk.a(poseStack, guiGraphics, f + 1.0f, f2, Math.min((i2 - 2.0f) * ((float) (((double) Math.max(c0558ur.E(f3), 0.0f)) / ((double) fCg))), i2 - 2.0f), 1.0f, ColorReferences.COLOR_WHITE_SOLID);
            C0040bk.b(poseStack, font, guiGraphics, (Component) Component.literal(String.valueOf(C0066cj.dB)).withStyle(ChatFormatting.BOLD).withStyle(style).append(C0557uq.jE).append(Component.literal(String.valueOf(C0066cj.dD)).withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD)), i4 - i2, f2 + 4.0f, i);
            C0040bk.b(poseStack, font, guiGraphics, uSVarM1210a.a().getDisplayName(), (i4 - font.width(r0)) - 8, f2 + 4.0f, i);
        }
    };

    /* JADX INFO: renamed from: com.boehmod.blockfront.uq$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uq$a.class */
    public static abstract class a {
        @OnlyIn(Dist.CLIENT)
        public abstract void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull C0558ur c0558ur, @NotNull ItemStack itemStack, @NotNull Style style, int i, float f, float f2, int i2, int i3, int i4, int i5, float f3);
    }
}
