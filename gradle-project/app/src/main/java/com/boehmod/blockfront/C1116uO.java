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

/* JADX INFO: renamed from: com.boehmod.blockfront.uO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uO.class */
public class C1116uO {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final a f6039a = new a() { // from class: com.boehmod.blockfront.uO.1
        @Override // com.boehmod.blockfront.C1116uO.a
        @OnlyIn(Dist.CLIENT)
        /* JADX INFO: renamed from: a */
        public void mo6256a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull C1117uP c1117uP, @NotNull ItemStack itemStack, @NotNull Style style, int i, float f, float f2, int i2, int i3, int i4, int i5, float f3) {
            int iM6402cq = c1117uP.m6283a(itemStack).m6402cq();
            float fM7170f = C1270xJ.m7170f(C0191cs.f1496ey, C0191cs.f1497ez, f3);
            float f4 = (C0191cs.f1496ey / iM6402cq) * (i2 - 2);
            MutableComponent mutableComponentWithStyle = Component.literal(C1273xM.m7239b((int) fM7170f)).withStyle(ChatFormatting.BOLD).withStyle(style);
            MutableComponent mutableComponentWithColor = Component.literal("/").withColor(ColorReferences.COLOR_WHITE);
            MutableComponent mutableComponentAppend = mutableComponentWithStyle.append(mutableComponentWithColor).append(Component.literal(C1273xM.m7239b(C0191cs.f1498eA)).withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD)).append(Component.literal("ML").withColor(ColorReferences.COLOR_WHITE));
            C0129bt.m514a(poseStack, guiGraphics, f + 1.0f, f2, f4, 1.0f, ColorReferences.COLOR_WHITE_SOLID);
            C0129bt.m489b(poseStack, font, guiGraphics, (Component) mutableComponentAppend, i4 - 102, f2 + 5.0f, i, 0.75f);
        }
    };

    /* JADX INFO: renamed from: jR */
    @NotNull
    private static final Component f6040jR = Component.literal("/").withColor(ColorReferences.COLOR_WHITE);

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final a f6041b = new a() { // from class: com.boehmod.blockfront.uO.2

        /* JADX INFO: renamed from: ik */
        static final /* synthetic */ boolean f6042ik;

        static {
            f6042ik = !C1116uO.class.desiredAssertionStatus();
        }

        @Override // com.boehmod.blockfront.C1116uO.a
        @OnlyIn(Dist.CLIENT)
        /* JADX INFO: renamed from: a */
        public void mo6256a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull C1117uP c1117uP, @NotNull ItemStack itemStack, @NotNull Style style, int i, float f, float f2, int i2, int i3, int i4, int i5, float f3) {
            C0623l c0623lM2852b = C0623l.m2852b();
            if (!f6042ik && c0623lM2852b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            C1199vs c1199vsM6317b = c1117uP.m6317b();
            float fM6875cw = c1199vsM6317b.m6875cw();
            AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
            if (abstractC0863pbM2874a != null) {
                fM6875cw *= abstractC0863pbM2874a.mo4021aM();
            }
            C0129bt.m514a(poseStack, guiGraphics, f + 1.0f, f2, Math.min((i2 - 2.0f) * ((float) (((double) Math.max(c1117uP.m6382H(f3), 0.0f)) / ((double) fM6875cw))), i2 - 2.0f), 1.0f, ColorReferences.COLOR_WHITE_SOLID);
            C0129bt.m480b(poseStack, font, guiGraphics, (Component) Component.literal(String.valueOf(C0191cs.f1496ey)).withStyle(ChatFormatting.BOLD).withStyle(style).append(C1116uO.f6040jR).append(Component.literal(String.valueOf(C0191cs.f1498eA)).withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD)), i4 - i2, f2 + 4.0f, i);
            Component displayName = c1199vsM6317b.m6874a().getDisplayName();
            C0129bt.m480b(poseStack, font, guiGraphics, displayName, (i4 - font.width(displayName)) - 8, f2 + 4.0f, i);
        }
    };

    /* JADX INFO: renamed from: com.boehmod.blockfront.uO$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uO$a.class */
    public static abstract class a {
        @OnlyIn(Dist.CLIENT)
        /* JADX INFO: renamed from: a */
        public abstract void mo6256a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull C1117uP c1117uP, @NotNull ItemStack itemStack, @NotNull Style style, int i, float f, float f2, int i2, int i3, int i4, int i5, float f3);
    }
}
