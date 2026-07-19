package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cG.class */
public class cG extends C0081cy {
    private static final Component cD = Component.translatable("bf.screen.callout");

    public cG() {
        super(cD);
    }

    protected void init() {
        super.init();
        int i = ((this.width / 2) - 96) - 2;
        int i2 = ((this.height / 2) - 96) - 2;
        for (oZ oZVar : oZ.values()) {
            Vector2i buttonPosition = oZVar.getButtonPosition();
            int i3 = 1 + buttonPosition.x;
            int i4 = 1 - buttonPosition.y;
            addRenderableWidget(new C0048bs(i + (64 * i3) + (2 * i3), i2 + (64 * i4) + (2 * i4), 64, 64, Component.translatable(oZVar.getTranslation() + ".title"), button -> {
                a(oZVar);
            }).a(C0048bs.a.FANCY).a(oZVar.getTexture()).b(0, -4).d(32).a(0.0f, 20.0f));
        }
    }

    public void tick() {
        oF<?, ?, ?> oFVarM591a = this.e.m591a();
        if (oFVarM591a == null || oFVarM591a.m750a() != oN.GAME) {
            onClose();
        }
    }

    @Override // com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.b.player == null) {
            return;
        }
        C0040bk.a(guiGraphics, 0, 0, this.width, this.height, C0040bk.p());
        super.render(guiGraphics, i, i2, f);
        int i3 = this.width / 2;
        oF<?, ?, ?> oFVarM591a = this.e.m591a();
        if (oFVarM591a instanceof InterfaceC0466rg) {
            UUID uuid = this.b.player.getUUID();
            int iA = oR.a(oFVarM591a, uuid, C0529tp.A);
            sV sVVarA = sV.a(oR.a(oFVarM591a, uuid, C0529tp.i));
            if (sVVarA != null && sVVarA.bH()) {
                if (iA <= 0) {
                    C0040bk.c(this.font, guiGraphics, (Component) Component.translatable("bf.message.ingame.warcry.commander", new Object[]{Component.translatable(oZ.FORWARD.getTranslation()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED), i3, 30);
                } else {
                    C0040bk.c(this.font, guiGraphics, (Component) Component.translatable("bf.message.ingame.warcry.commander.cooldown", new Object[]{Component.literal(String.valueOf(iA / 20)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED), i3, 30);
                }
            }
        }
    }

    public void a(@NotNull oZ oZVar) {
        onClose();
        iB.a(this.b, oZVar);
    }
}
