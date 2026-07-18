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

/* JADX INFO: renamed from: com.boehmod.blockfront.uq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uq.class */
public class C1143uq {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final a f5973a = new a() { // from class: com.boehmod.blockfront.uq.1
        @Override // com.boehmod.blockfront.C1143uq.a
        @OnlyIn(Dist.CLIENT)
        /* JADX INFO: renamed from: a */
        public void mo6292a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull C1144ur c1144ur, @NotNull ItemStack itemStack, @NotNull Style style, int i, float f, float f2, int i2, int i3, int i4, int i5, float f3) {
            int iM6424cb = c1144ur.m6318a(itemStack).m6424cb();
            float fM7843e = C1290xm.m7843e(C0171cj.f1380dB, C0171cj.f1381dC, f3);
            float f4 = (C0171cj.f1380dB / iM6424cb) * (i2 - 2);
            MutableComponent mutableComponentWithStyle = Component.literal(C1293xp.m7912a((int) fM7843e)).withStyle(ChatFormatting.BOLD).withStyle(style);
            MutableComponent mutableComponentWithColor = Component.literal("/").withColor(ColorReferences.COLOR_WHITE);
            MutableComponent mutableComponentAppend = mutableComponentWithStyle.append(mutableComponentWithColor).append(Component.literal(C1293xp.m7912a(C0171cj.f1382dD)).withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD)).append(Component.literal("ML").withColor(ColorReferences.COLOR_WHITE));
            C0119bk.m414a(poseStack, guiGraphics, f + 1.0f, f2, f4, 1.0f, ColorReferences.COLOR_WHITE_SOLID);
            C0119bk.m389b(poseStack, font, guiGraphics, (Component) mutableComponentAppend, i4 - 102, f2 + 5.0f, i, 0.75f);
        }
    };

    /* JADX INFO: renamed from: jE */
    @NotNull
    private static final Component f5974jE = Component.literal("/").withColor(ColorReferences.COLOR_WHITE);

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final a f5975b = new a() { // from class: com.boehmod.blockfront.uq.2

        /* JADX INFO: renamed from: hQ */
        static final /* synthetic */ boolean f5976hQ;

        static {
            f5976hQ = !C1143uq.class.desiredAssertionStatus();
        }

        @Override // com.boehmod.blockfront.C1143uq.a
        @OnlyIn(Dist.CLIENT)
        /* JADX INFO: renamed from: a */
        public void mo6292a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull C1144ur c1144ur, @NotNull ItemStack itemStack, @NotNull Style style, int i, float f, float f2, int i2, int i3, int i4, int i5, float f3) {
            C0622l c0622lM2667b = C0622l.m2667b();
            if (!f5976hQ && c0622lM2667b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            C1119uS c1119uSM6347a = c1144ur.m6347a();
            float fM6222cg = c1119uSM6347a.m6222cg();
            AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
            if (abstractC0787oFM2688a != null) {
                fM6222cg *= abstractC0787oFM2688a.mo3585aG();
            }
            C0119bk.m414a(poseStack, guiGraphics, f + 1.0f, f2, Math.min((i2 - 2.0f) * ((float) (((double) Math.max(c1144ur.m6406E(f3), 0.0f)) / ((double) fM6222cg))), i2 - 2.0f), 1.0f, ColorReferences.COLOR_WHITE_SOLID);
            C0119bk.m380b(poseStack, font, guiGraphics, (Component) Component.literal(String.valueOf(C0171cj.f1380dB)).withStyle(ChatFormatting.BOLD).withStyle(style).append(C1143uq.f5974jE).append(Component.literal(String.valueOf(C0171cj.f1382dD)).withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD)), i4 - i2, f2 + 4.0f, i);
            C0119bk.m380b(poseStack, font, guiGraphics, c1119uSM6347a.m6221a().getDisplayName(), (i4 - font.width(r0)) - 8, f2 + 4.0f, i);
        }
    };

    /* JADX INFO: renamed from: com.boehmod.blockfront.uq$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uq$a.class */
    public static abstract class a {
        @OnlyIn(Dist.CLIENT)
        /* JADX INFO: renamed from: a */
        public abstract void mo6292a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull C1144ur c1144ur, @NotNull ItemStack itemStack, @NotNull Style style, int i, float f, float f2, int i2, int i3, int i4, int i5, float f3);
    }
}
