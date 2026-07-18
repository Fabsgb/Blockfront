package com.boehmod.blockfront;

import com.boehmod.blockfront.C0127bs;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cZ.class */
public class C0161cZ extends C0196cy {

    /* JADX INFO: renamed from: dy */
    @NotNull
    private static final Component f1319dy = Component.translatable("bf.screen.ingame.buy.menu");

    /* JADX INFO: renamed from: a */
    @NotNull
    private final InterfaceC0907qT f1320a;

    public C0161cZ(@NotNull InterfaceC0907qT interfaceC0907qT) {
        super(f1319dy);
        this.f1320a = interfaceC0907qT;
    }

    protected void init() {
        super.init();
        LocalPlayer localPlayer = this.f1587b.player;
        if (localPlayer == null) {
            return;
        }
        int i = ((this.width / 2) - 67) - 1;
        int i2 = ((this.height / 2) - 67) - 1;
        List<C0863pc> listMo4680a = this.f1320a.mo4680a(localPlayer.getUUID());
        int size = listMo4680a.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0863pc c0863pc = listMo4680a.get(i3);
            ItemStack itemStackM4311a = c0863pc.m4311a();
            int i4 = i3;
            Vec2 vec2M4313e = c0863pc.m4313e();
            if (vec2M4313e != null) {
                int i5 = (int) (1.0f + vec2M4313e.x);
                int i6 = (int) (1.0f - vec2M4313e.y);
                addRenderableWidget(new C0160cY(i + (45 * i5) + (1 * i5), i2 + (45 * i6) + (1 * i6), 45, 45, itemStackM4311a.getDisplayName().copy(), button -> {
                    m997i(i4);
                }, c0863pc).m652a(C0127bs.b.CENTER_BOTTOM).m659b(0.5f).m651a((Component) Component.literal("Cost: ").append(Component.literal(String.valueOf(c0863pc.m4312bk())).withStyle(ChatFormatting.GREEN))));
            }
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
        C0119bk.m415a(guiGraphics, 0, 0, this.width, this.height, C0119bk.m365p());
        super.render(guiGraphics, i, i2, f);
    }

    /* JADX INFO: renamed from: i */
    public void m997i(int i) {
        onClose();
        C1194vo.m6653c(new C1253wu(i));
    }
}
