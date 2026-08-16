package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.di */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/di.class */
public class C0234di extends C0144cH {

    /* JADX INFO: renamed from: dA */
    @NotNull
    private static final Component f1890dA = Component.translatable("bf.screen.ingame.buy.menu");

    /* JADX INFO: renamed from: a */
    @NotNull
    private final InterfaceC0984rq f1891a;

    public C0234di(@NotNull InterfaceC0984rq interfaceC0984rq) {
        super(f1890dA);
        this.f1891a = interfaceC0984rq;
    }

    protected void init() {
        super.init();
        LocalPlayer localPlayer = this.f1058a.player;
        if (localPlayer == null) {
            return;
        }
        int i = ((this.width / 2) - 67) - 1;
        int i2 = ((this.height / 2) - 67) - 1;
        List<C0886py> listMo5554a = this.f1891a.mo5554a(localPlayer.getUUID());
        int size = listMo5554a.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0886py c0886py = listMo5554a.get(i3);
            ItemStack itemStackM4636c = c0886py.m4636c();
            int i4 = i3;
            Vec2 vec2M4638e = c0886py.m4638e();
            if (vec2M4638e != null) {
                int i5 = (int) (1.0f + vec2M4638e.x);
                int i6 = (int) (1.0f - vec2M4638e.y);
                addRenderableWidget(new C0233dh(i + (45 * i5) + (1 * i5), i2 + (45 * i6) + (1 * i6), 45, 45, itemStackM4636c.getDisplayName().copy(), button -> {
                    m1352i(i4);
                }, c0886py).m327a(C0085bB.b.CENTER_BOTTOM).m334b(0.5f).m326a((Component) Component.literal("Cost: ").append(Component.literal(String.valueOf(c0886py.m4637bz())).withStyle(ChatFormatting.GREEN))));
            }
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
        C0129bt.m515a(guiGraphics, 0, 0, this.width, this.height, C0129bt.m465t());
        super.render(guiGraphics, i, i2, f);
    }

    /* JADX INFO: renamed from: i */
    public void m1352i(int i) {
        onClose();
        C1169vO.m6648c(new C1226wS(i));
    }
}
