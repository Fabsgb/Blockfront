package com.boehmod.blockfront;

import com.boehmod.blockfront.C0048bs;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cZ.class */
public class cZ extends C0081cy {

    @NotNull
    private static final Component dy = Component.translatable("bf.screen.ingame.buy.menu");

    @NotNull
    private final qT a;

    public cZ(@NotNull qT qTVar) {
        super(dy);
        this.a = qTVar;
    }

    protected void init() {
        super.init();
        LocalPlayer localPlayer = this.b.player;
        if (localPlayer == null) {
            return;
        }
        int i = ((this.width / 2) - 67) - 1;
        int i2 = ((this.height / 2) - 67) - 1;
        List<C0408pc> listMo1079a = this.a.mo1079a(localPlayer.getUUID());
        int size = listMo1079a.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0408pc c0408pc = listMo1079a.get(i3);
            ItemStack itemStackA = c0408pc.a();
            int i4 = i3;
            Vec2 vec2E = c0408pc.e();
            if (vec2E != null) {
                int i5 = (int) (1.0f + vec2E.x);
                int i6 = (int) (1.0f - vec2E.y);
                addRenderableWidget(new cY(i + (45 * i5) + (1 * i5), i2 + (45 * i6) + (1 * i6), 45, 45, itemStackA.getDisplayName().copy(), button -> {
                    i(i4);
                }, c0408pc).a(C0048bs.b.CENTER_BOTTOM).b(0.5f).a((Component) Component.literal("Cost: ").append(Component.literal(String.valueOf(c0408pc.bk())).withStyle(ChatFormatting.GREEN))));
            }
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
        C0040bk.a(guiGraphics, 0, 0, this.width, this.height, C0040bk.p());
        super.render(guiGraphics, i, i2, f);
    }

    public void i(int i) {
        onClose();
        C0582vo.c(new C0615wu(i));
    }
}
