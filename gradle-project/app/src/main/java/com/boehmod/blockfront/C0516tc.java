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

/* JADX INFO: renamed from: com.boehmod.blockfront.tc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tc.class */
public class C0516tc extends AbstractC0517td {

    @NotNull
    private static final Component jx;
    static final /* synthetic */ boolean hx;

    static {
        hx = !C0516tc.class.desiredAssertionStatus();
        jx = Component.translatable("bf.message.match.streak.title");
    }

    @Override // com.boehmod.blockfront.AbstractC0517td
    public void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull oF<?, ?, ?> oFVar, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        float fB = B(f);
        if (fB <= 0.02f) {
            fB = 0.02f;
        }
        C0297l c0297lB = C0297l.b();
        if (!hx && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        int iA = C0634xm.a(i6, fB);
        int iA2 = C0634xm.a(ColorReferences.COLOR_THEME_YELLOW_SOLID, fB);
        Minecraft minecraft = Minecraft.getInstance();
        fV fVVar = (fV) c0297lB.a();
        oQ oQVarM783a = oFVar.b().m783a();
        UUID uuidG = oQVarM783a.g();
        MutableComponent mutableComponentWithColor = Component.translatable("bf.message.match.streak.match", new Object[]{Component.literal(C0637xp.a(oQVarM783a.bc())).withColor(iA2)}).withColor(iA);
        MutableComponent mutableComponentLiteral = Component.literal("???");
        if (uuidG != null) {
            iS iSVarA = fVVar.mo306a(uuidG);
            C0040bk.a(fVVar, poseStack, guiGraphics, minecraft, (LivingEntity) C0040bk.a.a(minecraft, iSVarA.m491a()), i + 10 + 16.0f, i2 + 10 + 115 + (57.0f * (1.0f - fB)), 64.0f, 0.0f, 30.0f * Mth.sin(C0040bk.g() / 40.0f) * fB, fB, iA);
            int iA3 = oQVarM783a.a(uuidG);
            mutableComponentLiteral = Component.translatable("bf.message.match.streak.player", new Object[]{Component.literal(iSVarA.getUsername()).withColor(iA2), Component.translatable(iA3 <= 1 ? "bf.message.match.streak.player.count" : "bf.message.match.streak.player.count.plural", new Object[]{Component.literal(C0637xp.a(iA3)).withColor(iA2)})}).withColor(iA);
        }
        C0040bk.a(poseStack, font, guiGraphics, jx, 58.0f, (i2 + 10) - 2, iA, 2.0f);
        C0040bk.a(font, guiGraphics, (Component) mutableComponentWithColor, 58, i2 + 10 + 16, iA);
        C0040bk.a(font, guiGraphics, (Component) mutableComponentLiteral, 58, i2 + 10 + 26, iA);
    }
}
