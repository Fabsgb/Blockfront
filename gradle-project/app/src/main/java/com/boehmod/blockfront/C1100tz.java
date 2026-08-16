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

/* JADX INFO: renamed from: com.boehmod.blockfront.tz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tz.class */
public class C1100tz extends AbstractC1049tA {

    /* JADX INFO: renamed from: jK */
    @NotNull
    private static final Component f5995jK;

    /* JADX INFO: renamed from: hR */
    static final /* synthetic */ boolean f5996hR;

    static {
        f5996hR = !C1100tz.class.desiredAssertionStatus();
        f5995jK = Component.translatable("bf.message.match.streak.title");
    }

    @Override // com.boehmod.blockfront.AbstractC1049tA
    /* JADX INFO: renamed from: a */
    public void mo5865a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        float fE = m5866E(f);
        if (fE <= 0.02f) {
            fE = 0.02f;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f5996hR && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        int iM7159a = C1270xJ.m7159a(i6, fE);
        int iM7159a2 = C1270xJ.m7159a(ColorReferences.COLOR_THEME_YELLOW_SOLID, fE);
        Minecraft minecraft = Minecraft.getInstance();
        C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
        C0874pm c0874pmM4253a = abstractC0863pb.m4018b().m4253a();
        UUID uuidM4342g = c0874pmM4253a.m4342g();
        MutableComponent mutableComponentWithColor = Component.translatable("bf.message.match.streak.match", new Object[]{Component.literal(C1273xM.m7239b(c0874pmM4253a.m4343br())).withColor(iM7159a2)}).withColor(iM7159a);
        MutableComponent mutableComponentLiteral = Component.literal("???");
        if (uuidM4342g != null) {
            C0555jl c0555jlA = c0396gl.mo1154a(uuidM4342g);
            C0129bt.m595a(c0396gl, poseStack, guiGraphics, minecraft, (LivingEntity) C0129bt.f871a.m1039a(minecraft, c0555jlA.m2522a()), i + 10 + 16.0f, i2 + 10 + 115 + (57.0f * (1.0f - fE)), 64.0f, 0.0f, 30.0f * Mth.sin(C0129bt.m466g() / 40.0f) * fE, fE, iM7159a);
            int iM4341a = c0874pmM4253a.m4341a(uuidM4342g);
            mutableComponentLiteral = Component.translatable("bf.message.match.streak.player", new Object[]{Component.literal(c0555jlA.getUsername()).withColor(iM7159a2), Component.translatable(iM4341a <= 1 ? "bf.message.match.streak.player.count" : "bf.message.match.streak.player.count.plural", new Object[]{Component.literal(C1273xM.m7239b(iM4341a)).withColor(iM7159a2)})}).withColor(iM7159a);
        }
        C0129bt.m488a(poseStack, font, guiGraphics, f5995jK, 58.0f, (i2 + 10) - 2, iM7159a, 2.0f);
        C0129bt.m471a(font, guiGraphics, (Component) mutableComponentWithColor, 58, i2 + 10 + 16, iM7159a);
        C0129bt.m471a(font, guiGraphics, (Component) mutableComponentLiteral, 58, i2 + 10 + 26, iM7159a);
    }
}
