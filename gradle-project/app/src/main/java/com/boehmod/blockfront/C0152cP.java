package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

/* JADX INFO: renamed from: com.boehmod.blockfront.cP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cP.class */
public class C0152cP extends C0144cH {

    /* JADX INFO: renamed from: cF */
    private static final Component f1181cF = Component.translatable("bf.screen.callout");

    public C0152cP() {
        super(f1181cF);
    }

    protected void init() {
        super.init();
        int i = ((this.width / 2) - 96) - 2;
        int i2 = ((this.height / 2) - 96) - 2;
        for (EnumC0883pv enumC0883pv : EnumC0883pv.values()) {
            Vector2i buttonPosition = enumC0883pv.getButtonPosition();
            int i3 = 1 + buttonPosition.x;
            int i4 = 1 - buttonPosition.y;
            addRenderableWidget(new C0085bB(i + (64 * i3) + (2 * i3), i2 + (64 * i4) + (2 * i4), 64, 64, Component.translatable(enumC0883pv.getTranslation() + ".title"), button -> {
                m842a(enumC0883pv);
            }).m328a(C0085bB.a.FANCY).m320a(enumC0883pv.getTexture()).m323b(0, -4).m321d(32).m324a(0.0f, 20.0f));
        }
    }

    public void tick() {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = this.f1057f.m2874a();
        if (abstractC0863pbM2874a == null || abstractC0863pbM2874a.m4023a() != EnumC0871pj.GAME) {
            onClose();
        }
    }

    @Override // com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.f1058a.player == null) {
            return;
        }
        C0129bt.m515a(guiGraphics, 0, 0, this.width, this.height, C0129bt.m465t());
        super.render(guiGraphics, i, i2, f);
        int i3 = this.width / 2;
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = this.f1057f.m2874a();
        if (abstractC0863pbM2874a instanceof InterfaceC0945rD) {
            UUID uuid = this.f1058a.player.getUUID();
            int iM4445a = C0875pn.m4445a(abstractC0863pbM2874a, uuid, C1062tN.f5763A);
            C1093ts c1093tsM6016a = C1093ts.m6016a(C0875pn.m4445a(abstractC0863pbM2874a, uuid, C1062tN.f5745i));
            if (c1093tsM6016a != null && c1093tsM6016a.m6009bR()) {
                if (iM4445a <= 0) {
                    C0129bt.m483c(this.font, guiGraphics, (Component) Component.translatable("bf.message.ingame.warcry.commander", new Object[]{Component.translatable(EnumC0883pv.FORWARD.getTranslation()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED), i3, 30);
                } else {
                    C0129bt.m483c(this.font, guiGraphics, (Component) Component.translatable("bf.message.ingame.warcry.commander.cooldown", new Object[]{Component.literal(String.valueOf(iM4445a / 20)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED), i3, 30);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m842a(@NotNull EnumC0883pv enumC0883pv) {
        onClose();
        C0483iS.m2169a(this.f1058a, enumC0883pv);
    }
}
