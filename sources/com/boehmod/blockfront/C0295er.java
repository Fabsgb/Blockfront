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

/* JADX INFO: renamed from: com.boehmod.blockfront.er */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/er.class */
public final class C0295er extends AbstractC0288ek {

    /* JADX INFO: renamed from: hF */
    private static final Component f2247hF = Component.translatable("bf.menu.text.punished.title").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: H */
    @NotNull
    private final List<MutableComponent> f2248H;

    public C0295er(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, Component.empty());
        this.f2248H = new ObjectArrayList();
        m1564au();
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    /* JADX INFO: renamed from: a */
    protected void mo1521a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull C0482iS c0482iS, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        PoseStack poseStackPose = guiGraphics.pose();
        Font font = minecraft.font;
        int i3 = this.width / 2;
        C0119bk.m491c(guiGraphics, getX(), getY(), this.width, this.height + 2, C0119bk.m365p());
        if (c0482iS.hasActivePunishment(PunishmentType.BAN_MM) || c0482iS.hasActivePunishment(PunishmentType.BAN_CLOUD)) {
            m1563a(poseStackPose, guiGraphics, font, c0482iS, i3);
        } else {
            m1562a(poseStackPose, guiGraphics, font, i3);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1562a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i) {
        int y = getY() + 1;
        int i2 = 0;
        for (MutableComponent mutableComponent : this.f2248H) {
            float f = y + (i2 * 15.2f);
            C0119bk.m414a(poseStack, guiGraphics, getX() + 1, f, this.width - 2, 14.2f, i2 % 2 == 0 ? 369098751 : 150994943);
            C0119bk.m382c(poseStack, font, guiGraphics, (Component) mutableComponent, getX() + i, f + 3.0f);
            i2++;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1563a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull C0482iS c0482iS, int i) {
        C0119bk.m517a(guiGraphics, getX(), getY(), this.width, this.height);
        C0119bk.m383c(font, guiGraphics, f2247hF, getX() + i, getY() + 5);
        C0119bk.m415a(guiGraphics, getX() + 15, getY() + 17, this.width - 30, 1, ColorReferences.COLOR_WHITE_SOLID);
        guiGraphics.disableScissor();
        int x = getX() + 5;
        int y = getY() + 22;
        int i2 = 0;
        for (Punishment punishment : c0482iS.getActivePunishments()) {
            int i3 = y + (18 * i2);
            C0119bk.m387a(poseStack, font, guiGraphics, (Component) Component.translatable(punishment.getType().getTranslatableName()).withStyle(ChatFormatting.RED), x, i3, 0.5f);
            C0119bk.m387a(poseStack, font, guiGraphics, (Component) Component.literal(punishment.getReason()), x, i3 + 5, 0.5f);
            C0119bk.m387a(poseStack, font, guiGraphics, (Component) Component.translatable("bf.message.profile.base.time.left", new Object[]{Component.literal(punishment.getTimeRemainingString()).withStyle(ChatFormatting.GRAY)}), x, i3 + 10, 0.5f);
            i2++;
        }
    }

    /* JADX INFO: renamed from: au */
    public void m1564au() {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null) {
            return;
        }
        C0482iS c0482iSM1676a = ((C0326fV) c0622lM2667b.m2670a()).m1676a(Minecraft.getInstance());
        this.f2248H.clear();
        int deaths = c0482iSM1676a.getDeaths();
        int kills = c0482iSM1676a.getKills();
        double dRound = ModLibraryMathHelper.round(kills / (deaths <= 0 ? 1.0f : deaths), 1);
        this.f2248H.add(C0029a.f251b.copy().withStyle(ChatFormatting.GRAY).append(" ").append(C0029a.f249a.copy().withColor(ColorReferences.COLOR_WHITE)));
        this.f2248H.add(Component.translatable("bf.message.profile.details.time", new Object[]{Component.literal(ModLibraryMathHelper.round(c0482iSM1676a.getMinutesPlayed() / 60.0d, 1) + "h").withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY));
        this.f2248H.add(Component.translatable("bf.message.profile.details.games", new Object[]{Component.literal(C1293xp.m7912a(c0482iSM1676a.getTotalGames())).withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY));
        this.f2248H.add(Component.translatable("bf.message.profile.details.kd", new Object[]{Component.literal(String.valueOf(dRound)).withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY));
        this.f2248H.add(Component.translatable("bf.message.profile.details.kills", new Object[]{Component.literal(C1293xp.m7912a(kills)).withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY));
        this.f2248H.add(Component.translatable("bf.message.profile.details.deaths", new Object[]{Component.literal(C1293xp.m7912a(deaths)).withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY));
    }
}
