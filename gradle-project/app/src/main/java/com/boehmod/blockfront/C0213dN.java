package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dN.class */
public final class C0213dN extends AbstractC0217dR {

    /* JADX INFO: renamed from: fp */
    private static final Component f1636fp = Component.translatable("bf.message.achievement.nodata").withStyle(ChatFormatting.RED).withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0289ek<AbstractC0298et> f1637c;

    public C0213dN(@NotNull Screen screen, @NotNull C0555jl c0555jl) {
        super(screen, c0555jl, Component.translatable("bf.screen.profile.achievements", new Object[]{c0555jl.getUsername()}));
        this.f1637c = new C0289ek<>(0, 84, 235, 148, this);
    }

    @Override // com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        float fM466g = C0129bt.m466g();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int i5 = C0129bt.f861cu;
        if (this.f1637c.m1585h().isEmpty()) {
            C0129bt.m587a(guiGraphics, i3 - 32, (i4 - 32) - 14, 64, i5, fM466g);
            C0129bt.m483c(this.font, guiGraphics, f1636fp, i3, i4 + 26);
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        C0129bt.m591c(guiGraphics, this.f1637c.m381r(), this.f1637c.m385s(), this.f1637c.m374x(), this.f1637c.height(), C0129bt.m465t());
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        super.mo777H();
        int i = (this.width / 2) - 160;
        this.f1637c.m1578ar();
        this.f1637c.m375c(i + 25 + 4);
        this.f1637c.m376d(60);
        this.f1637c.m1575e(Token.NUMBER);
        this.f1637c.m378f(this.height - 115);
        this.f1637c.m383g(true);
        m794a(this.f1637c);
        for (CloudAchievement cloudAchievement : this.f1057f.m2855a().getAchievements()) {
            this.f1637c.m1577a(new C0290el(cloudAchievement, this.playerCloudData.hasAchievement(cloudAchievement)));
        }
    }
}
