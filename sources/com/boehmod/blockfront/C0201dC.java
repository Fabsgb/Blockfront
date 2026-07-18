package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dC.class */
public final class C0201dC extends AbstractC0205dG {

    /* JADX INFO: renamed from: fj */
    private static final Component f1607fj = Component.translatable("bf.message.achievement.nodata").withStyle(ChatFormatting.RED).withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0224dZ<AbstractC0284eg> f1608b;

    public C0201dC(@NotNull Screen screen, @NotNull C0482iS c0482iS) {
        super(screen, c0482iS, Component.translatable("bf.screen.profile.achievements", new Object[]{c0482iS.getUsername()}));
        this.f1608b = new C0224dZ<>(0, 84, 235, 148, this);
    }

    @Override // com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        float fM366g = C0119bk.m366g();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int i5 = C0119bk.f726bC;
        if (this.f1608b.m1324g().isEmpty()) {
            C0119bk.m487a(guiGraphics, i3 - 32, (i4 - 32) - 14, 64, i5, fM366g);
            C0119bk.m383c(this.font, guiGraphics, f1607fj, i3, i4 + 26);
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        C0119bk.m491c(guiGraphics, this.f1608b.m709n(), this.f1608b.m710o(), this.f1608b.m699t(), this.f1608b.height(), C0119bk.m365p());
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: E */
    public void mo775E() {
        super.mo775E();
        int i = (this.width / 2) - 160;
        this.f1608b.m1317am();
        this.f1608b.m700c(i + 25 + 4);
        this.f1608b.m701d(60);
        this.f1608b.m1314e(Token.NUMBER);
        this.f1608b.m703f(this.height - 115);
        this.f1608b.m708g(true);
        m1195a(this.f1608b);
        for (CloudAchievement cloudAchievement : this.f1586e.m2670a().getAchievements()) {
            this.f1608b.m1316a(new C0278ea(cloudAchievement, this.playerCloudData.hasAchievement(cloudAchievement)));
        }
    }
}
