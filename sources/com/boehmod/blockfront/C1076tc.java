package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tc.class */
public class C1076tc extends AbstractC1077td {

    /* JADX INFO: renamed from: jx */
    @NotNull
    private static final Component f5650jx;

    /* JADX INFO: renamed from: hx */
    static final /* synthetic */ boolean f5651hx;

    static {
        f5651hx = !C1076tc.class.desiredAssertionStatus();
        f5650jx = Component.translatable("bf.message.match.streak.title");
    }

    @Override // com.boehmod.blockfront.AbstractC1077td
    /* JADX INFO: renamed from: a */
    public void mo5983a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        float fB = m5986B(f);
        if (fB <= 0.02f) {
            fB = 0.02f;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f5651hx && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        int iM7833a = C1290xm.m7833a(i6, fB);
        int iM7833a2 = C1290xm.m7833a(ColorReferences.COLOR_THEME_YELLOW_SOLID, fB);
        Minecraft minecraft = Minecraft.getInstance();
        C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
        C0798oQ c0798oQM3817a = abstractC0787oF.m3582b().m3817a();
        UUID uuidM3906g = c0798oQM3817a.m3906g();
        MutableComponent mutableComponentWithColor = Component.translatable("bf.message.match.streak.match", new Object[]{Component.literal(C1293xp.m7912a(c0798oQM3817a.m3907bc())).withColor(iM7833a2)}).withColor(iM7833a);
        MutableComponent mutableComponentLiteral = Component.literal("???");
        if (uuidM3906g != null) {
            C0482iS c0482iSA = c0326fV.mo1137a(uuidM3906g);
            C0119bk.m495a(c0326fV, poseStack, guiGraphics, minecraft, (LivingEntity) C0119bk.f736a.m316a(minecraft, c0482iSA.m2195a()), i + 10 + 16.0f, i2 + 10 + 115 + (57.0f * (1.0f - fB)), 64.0f, 0.0f, 30.0f * Mth.sin(C0119bk.m366g() / 40.0f) * fB, fB, iM7833a);
            int iM3905a = c0798oQM3817a.m3905a(uuidM3906g);
            mutableComponentLiteral = Component.translatable("bf.message.match.streak.player", new Object[]{Component.literal(c0482iSA.getUsername()).withColor(iM7833a2), Component.translatable(iM3905a <= 1 ? "bf.message.match.streak.player.count" : "bf.message.match.streak.player.count.plural", new Object[]{Component.literal(C1293xp.m7912a(iM3905a)).withColor(iM7833a2)})}).withColor(iM7833a);
        }
        C0119bk.m388a(poseStack, font, guiGraphics, f5650jx, 58.0f, (i2 + 10) - 2, iM7833a, 2.0f);
        C0119bk.m371a(font, guiGraphics, (Component) mutableComponentWithColor, 58, i2 + 10 + 16, iM7833a);
        C0119bk.m371a(font, guiGraphics, (Component) mutableComponentLiteral, 58, i2 + 10 + 26, iM7833a);
    }
}
