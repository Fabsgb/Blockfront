package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.Punishment;
import com.boehmod.bflib.cloud.common.player.PunishmentType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.bflib.common.util.ModLibraryMathHelper;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eE.class */
public final class C0257eE extends AbstractC0302ex {

    /* JADX INFO: renamed from: hO */
    private static final Component f2117hO = Component.translatable("bf.menu.text.punished.title").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: J */
    @NotNull
    private final List<MutableComponent> f2118J;

    public C0257eE(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, Component.empty());
        this.f2118J = new ObjectArrayList();
        m1466az();
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    /* JADX INFO: renamed from: a */
    protected void mo1440a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull C0555jl c0555jl, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        PoseStack poseStackPose = guiGraphics.pose();
        Font font = minecraft.font;
        int i3 = this.width / 2;
        C0129bt.m591c(guiGraphics, getX(), getY(), this.width, this.height + 2, C0129bt.m465t());
        if (c0555jl.hasActivePunishment(PunishmentType.BAN_MM) || c0555jl.hasActivePunishment(PunishmentType.BAN_CLOUD)) {
            m1465a(poseStackPose, guiGraphics, font, c0555jl, i3);
        } else {
            m1464a(poseStackPose, guiGraphics, font, i3);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1464a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i) {
        int y = getY() + 1;
        int i2 = 0;
        for (MutableComponent mutableComponent : this.f2118J) {
            float f = y + (i2 * 15.2f);
            C0129bt.m514a(poseStack, guiGraphics, getX() + 1, f, this.width - 2, 14.2f, i2 % 2 == 0 ? 369098751 : 150994943);
            C0129bt.m498d(poseStack, font, guiGraphics, (Component) mutableComponent, getX() + i, f + 3.0f);
            i2++;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1465a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull C0555jl c0555jl, int i) {
        C0129bt.m618a(guiGraphics, getX(), getY(), this.width, this.height);
        C0129bt.m483c(font, guiGraphics, f2117hO, getX() + i, getY() + 5);
        C0129bt.m515a(guiGraphics, getX() + 15, getY() + 17, this.width - 30, 1, ColorReferences.COLOR_WHITE_SOLID);
        guiGraphics.disableScissor();
        int x = getX() + 5;
        int y = getY() + 22;
        int i2 = 0;
        for (Punishment punishment : c0555jl.getActivePunishments()) {
            int i3 = y + (18 * i2);
            C0129bt.m487a(poseStack, font, guiGraphics, (Component) Component.translatable(punishment.getType().getTranslatableName()).withStyle(ChatFormatting.RED), x, i3, 0.5f);
            C0129bt.m487a(poseStack, font, guiGraphics, (Component) Component.literal(punishment.getReason()), x, i3 + 5, 0.5f);
            C0129bt.m487a(poseStack, font, guiGraphics, (Component) Component.translatable("bf.message.profile.base.time.left", new Object[]{Component.literal(punishment.getTimeRemainingString()).withStyle(ChatFormatting.GRAY)}), x, i3 + 10, 0.5f);
            i2++;
        }
    }

    /* JADX INFO: renamed from: az */
    public void m1466az() {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null) {
            return;
        }
        C0555jl c0555jlM1886a = ((C0396gl) c0623lM2852b.m2855a()).m1886a(Minecraft.getInstance());
        this.f2118J.clear();
        int deaths = c0555jlM1886a.getDeaths();
        int kills = c0555jlM1886a.getKills();
        double dRound = ModLibraryMathHelper.round(kills / (deaths <= 0 ? 1.0f : deaths), 1);
        this.f2118J.add(C0030a.f268b.copy().withStyle(ChatFormatting.GRAY).append(" ").append(C0030a.f266a.copy().withColor(ColorReferences.COLOR_WHITE)));
        this.f2118J.add(Component.translatable("bf.message.profile.details.time", new Object[]{Component.literal(ModLibraryMathHelper.round(c0555jlM1886a.getMinutesPlayed() / 60.0d, 1) + "h").withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY));
        this.f2118J.add(Component.translatable("bf.message.profile.details.games", new Object[]{Component.literal(C1273xM.m7239b(c0555jlM1886a.getTotalGames())).withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY));
        this.f2118J.add(Component.translatable("bf.message.profile.details.kd", new Object[]{Component.literal(String.valueOf(dRound)).withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY));
        this.f2118J.add(Component.translatable("bf.message.profile.details.kills", new Object[]{Component.literal(C1273xM.m7239b(kills)).withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY));
        this.f2118J.add(Component.translatable("bf.message.profile.details.deaths", new Object[]{Component.literal(C1273xM.m7239b(deaths)).withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY));
    }
}
