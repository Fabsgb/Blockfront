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

/* JADX INFO: renamed from: com.boehmod.blockfront.er, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/er.class */
public final class C0127er extends AbstractC0120ek {
    private static final Component hF = Component.translatable("bf.menu.text.punished.title").withStyle(ChatFormatting.RED);

    @NotNull
    private final List<MutableComponent> H;

    public C0127er(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, Component.empty());
        this.H = new ObjectArrayList();
        au();
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    protected void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull iS iSVar, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        PoseStack poseStackPose = guiGraphics.pose();
        Font font = minecraft.font;
        int i3 = this.width / 2;
        C0040bk.c(guiGraphics, getX(), getY(), this.width, this.height + 2, C0040bk.p());
        if (iSVar.hasActivePunishment(PunishmentType.BAN_MM) || iSVar.hasActivePunishment(PunishmentType.BAN_CLOUD)) {
            a(poseStackPose, guiGraphics, font, iSVar, i3);
        } else {
            a(poseStackPose, guiGraphics, font, i3);
        }
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i) {
        int y = getY() + 1;
        int i2 = 0;
        for (MutableComponent mutableComponent : this.H) {
            float f = y + (i2 * 15.2f);
            C0040bk.a(poseStack, guiGraphics, getX() + 1, f, this.width - 2, 14.2f, i2 % 2 == 0 ? 369098751 : 150994943);
            C0040bk.c(poseStack, font, guiGraphics, (Component) mutableComponent, getX() + i, f + 3.0f);
            i2++;
        }
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull iS iSVar, int i) {
        C0040bk.a(guiGraphics, getX(), getY(), this.width, this.height);
        C0040bk.c(font, guiGraphics, hF, getX() + i, getY() + 5);
        C0040bk.a(guiGraphics, getX() + 15, getY() + 17, this.width - 30, 1, ColorReferences.COLOR_WHITE_SOLID);
        guiGraphics.disableScissor();
        int x = getX() + 5;
        int y = getY() + 22;
        int i2 = 0;
        for (Punishment punishment : iSVar.getActivePunishments()) {
            int i3 = y + (18 * i2);
            C0040bk.a(poseStack, font, guiGraphics, (Component) Component.translatable(punishment.getType().getTranslatableName()).withStyle(ChatFormatting.RED), x, i3, 0.5f);
            C0040bk.a(poseStack, font, guiGraphics, (Component) Component.literal(punishment.getReason()), x, i3 + 5, 0.5f);
            C0040bk.a(poseStack, font, guiGraphics, (Component) Component.translatable("bf.message.profile.base.time.left", new Object[]{Component.literal(punishment.getTimeRemainingString()).withStyle(ChatFormatting.GRAY)}), x, i3 + 10, 0.5f);
            i2++;
        }
    }

    public void au() {
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null) {
            return;
        }
        iS iSVarM404a = ((fV) c0297lB.a()).m404a(Minecraft.getInstance());
        this.H.clear();
        int deaths = iSVarM404a.getDeaths();
        int kills = iSVarM404a.getKills();
        double dRound = ModLibraryMathHelper.round(kills / (deaths <= 0 ? 1.0f : deaths), 1);
        this.H.add(C0002a.f30b.copy().withStyle(ChatFormatting.GRAY).append(" ").append(C0002a.f28a.copy().withColor(ColorReferences.COLOR_WHITE)));
        this.H.add(Component.translatable("bf.message.profile.details.time", new Object[]{Component.literal(ModLibraryMathHelper.round(iSVarM404a.getMinutesPlayed() / 60.0d, 1) + "h").withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY));
        this.H.add(Component.translatable("bf.message.profile.details.games", new Object[]{Component.literal(C0637xp.a(iSVarM404a.getTotalGames())).withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY));
        this.H.add(Component.translatable("bf.message.profile.details.kd", new Object[]{Component.literal(String.valueOf(dRound)).withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY));
        this.H.add(Component.translatable("bf.message.profile.details.kills", new Object[]{Component.literal(C0637xp.a(kills)).withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY));
        this.H.add(Component.translatable("bf.message.profile.details.deaths", new Object[]{Component.literal(C0637xp.a(deaths)).withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY));
    }
}
