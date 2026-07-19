package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dC.class */
public final class dC extends dG {
    private static final Component fj = Component.translatable("bf.message.achievement.nodata").withStyle(ChatFormatting.RED).withStyle(C0266jw.b);

    @NotNull
    private final dZ<AbstractC0116eg> b;

    public dC(@NotNull Screen screen, @NotNull iS iSVar) {
        super(screen, iSVar, Component.translatable("bf.screen.profile.achievements", new Object[]{iSVar.getUsername()}));
        this.b = new dZ<>(0, 84, 235, 148, this);
    }

    @Override // com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        float fG = C0040bk.g();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int i5 = C0040bk.bC;
        if (this.b.g().isEmpty()) {
            C0040bk.a(guiGraphics, i3 - 32, (i4 - 32) - 14, 64, i5, fG);
            C0040bk.c(this.font, guiGraphics, fj, i3, i4 + 26);
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        C0040bk.c(guiGraphics, this.b.n(), this.b.o(), this.b.t(), this.b.height(), C0040bk.p());
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void E() {
        super.E();
        int i = (this.width / 2) - 160;
        this.b.am();
        this.b.c(i + 25 + 4);
        this.b.d(60);
        this.b.e(Token.NUMBER);
        this.b.f(this.height - 115);
        this.b.g(true);
        a(this.b);
        for (CloudAchievement cloudAchievement : this.e.a().getAchievements()) {
            this.b.a(new C0110ea(cloudAchievement, this.playerCloudData.hasAchievement(cloudAchievement)));
        }
    }
}
