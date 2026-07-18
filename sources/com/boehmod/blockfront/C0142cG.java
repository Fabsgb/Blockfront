package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

/* JADX INFO: renamed from: com.boehmod.blockfront.cG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cG.class */
public class C0142cG extends C0196cy {

    /* JADX INFO: renamed from: cD */
    private static final Component f1091cD = Component.translatable("bf.screen.callout");

    public C0142cG() {
        super(f1091cD);
    }

    protected void init() {
        super.init();
        int i = ((this.width / 2) - 96) - 2;
        int i2 = ((this.height / 2) - 96) - 2;
        for (EnumC0807oZ enumC0807oZ : EnumC0807oZ.values()) {
            Vector2i buttonPosition = enumC0807oZ.getButtonPosition();
            int i3 = 1 + buttonPosition.x;
            int i4 = 1 - buttonPosition.y;
            addRenderableWidget(new C0127bs(i + (64 * i3) + (2 * i3), i2 + (64 * i4) + (2 * i4), 64, 64, Component.translatable(enumC0807oZ.getTranslation() + ".title"), button -> {
                m788a(enumC0807oZ);
            }).m653a(C0127bs.a.FANCY).m645a(enumC0807oZ.getTexture()).m648b(0, -4).m646d(32).m649a(0.0f, 20.0f));
        }
    }

    public void tick() {
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = this.f1586e.m2688a();
        if (abstractC0787oFM2688a == null || abstractC0787oFM2688a.m3587a() != EnumC0795oN.GAME) {
            onClose();
        }
    }

    @Override // com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.f1587b.player == null) {
            return;
        }
        C0119bk.m415a(guiGraphics, 0, 0, this.width, this.height, C0119bk.m365p());
        super.render(guiGraphics, i, i2, f);
        int i3 = this.width / 2;
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = this.f1586e.m2688a();
        if (abstractC0787oFM2688a instanceof InterfaceC0973rg) {
            UUID uuid = this.f1587b.player.getUUID();
            int iM4009a = C0799oR.m4009a(abstractC0787oFM2688a, uuid, C1089tp.f5710A);
            C1015sV c1015sVM5528a = C1015sV.m5528a(C0799oR.m4009a(abstractC0787oFM2688a, uuid, C1089tp.f5692i));
            if (c1015sVM5528a != null && c1015sVM5528a.m5521bH()) {
                if (iM4009a <= 0) {
                    C0119bk.m383c(this.font, guiGraphics, (Component) Component.translatable("bf.message.ingame.warcry.commander", new Object[]{Component.translatable(EnumC0807oZ.FORWARD.getTranslation()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED), i3, 30);
                } else {
                    C0119bk.m383c(this.font, guiGraphics, (Component) Component.translatable("bf.message.ingame.warcry.commander.cooldown", new Object[]{Component.literal(String.valueOf(iM4009a / 20)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED), i3, 30);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m788a(@NotNull EnumC0807oZ enumC0807oZ) {
        onClose();
        C0465iB.m2098a(this.f1587b, enumC0807oZ);
    }
}
