package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ReportType;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.packet.common.PacketPunishPlayer;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dW.class */
public class C0221dW extends C0195cx {

    /* JADX INFO: renamed from: hi */
    public static final Component f1805hi = Component.translatable("screen.staff.punish");

    /* JADX INFO: renamed from: hj */
    public static final Component f1806hj = Component.translatable("bf.menu.punish.reason.title");

    /* JADX INFO: renamed from: hk */
    public static final Component f1807hk = Component.translatable("bf.menu.punish.reason.tip").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: hl */
    public static final Component f1808hl = Component.translatable("bf.menu.button.back");

    /* JADX INFO: renamed from: hm */
    public static final Component f1809hm = Component.translatable("bf.menu.punish.prompt.title");

    /* JADX INFO: renamed from: hl */
    public static final int f1810hl = 310;

    /* JADX INFO: renamed from: hm */
    public static final int f1811hm = 100;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final UUID f1812g;

    /* JADX INFO: renamed from: a */
    private ReportType f1813a;

    /* JADX INFO: renamed from: n */
    private C0127bs f1814n;

    public C0221dW(@NotNull Component component, @NotNull UUID uuid) {
        super(component, f1805hi);
        this.f1812g = uuid;
        ((C0357g) this.f1586e.m2667b()).m1716a().m2165b(RequestType.PLAYER_DATA, this.f1812g);
    }

    @Override // com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = (this.height / 2) - 36;
        C0119bk.m493c(guiGraphics, i3 - 155, i4 - 10, f1810hl, 100, 0, 0.5f);
        super.render(guiGraphics, i, i2, f);
        C0482iS c0482iSA = this.f1585a.mo1137a(this.f1812g);
        int i5 = i3 - 68;
        int i6 = i4 - 35;
        C0119bk.m485a(this.f1587b, this.f1586e, poseStackPose, guiGraphics, c0482iSA.m2195a(), i5, i6, 18);
        C0119bk.m370a(this.font, guiGraphics, (Component) Component.literal(c0482iSA.getUsername()), i5 + 18 + 4, i6 + 1);
        C0119bk.m387a(poseStackPose, this.font, guiGraphics, (Component) Component.literal(this.f1812g.toString()).withStyle(ChatFormatting.GRAY), i5 + 18 + 4, i6 + 12, 0.5f);
        C0119bk.m383c(this.font, guiGraphics, f1806hj, i3, i4);
        C0119bk.m391b(poseStackPose, this.font, guiGraphics, f1807hk, i3, i4 + 12, 0.5f);
        if (this.f1814n != null) {
            this.f1814n.active = this.f1813a != null;
        }
        if (this.f1813a != null) {
            for (C0127bs c0127bs : this.renderables) {
                if (c0127bs instanceof C0127bs) {
                    C0127bs c0127bs2 = c0127bs;
                    int x = c0127bs2.getX();
                    int y = c0127bs2.getY();
                    int width = c0127bs2.getWidth();
                    int height = c0127bs2.getHeight();
                    if (c0127bs2.getMessage().getString().equals(this.f1813a.getTitle())) {
                        C0119bk.m415a(guiGraphics, x - 1, y - 1, width + 2, 1, ColorReferences.COLOR_WHITE_SOLID);
                        C0119bk.m415a(guiGraphics, x - 1, y - 1, 1, height + 2, ColorReferences.COLOR_WHITE_SOLID);
                        C0119bk.m415a(guiGraphics, x - 1, y + height, width + 2, 1, ColorReferences.COLOR_WHITE_SOLID);
                        C0119bk.m415a(guiGraphics, x + width, y - 1, 1, height + 2, ColorReferences.COLOR_WHITE_SOLID);
                    }
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        super.mo744G();
        int i = this.width / 2;
        int i2 = ((this.height / 2) - 34) + 22;
        int width = 0;
        if (this.f1587b.level == null) {
            addRenderableWidget(new C0127bs(5, 18, 20, 20, Component.empty(), button -> {
                this.f1587b.setScreen(new C0235dk());
            }).m645a(f1564aH).m647a(20, 20).m653a(C0127bs.a.NONE).m651a(f1808hl));
        }
        ObjectArrayList<C0127bs> objectArrayList = new ObjectArrayList();
        for (ReportType reportType : ReportType.values()) {
            objectArrayList.add(new C0127bs(0, i2, 30, 30, Component.literal(reportType.getTitle()), button2 -> {
                this.f1813a = reportType;
            }).m651a((Component) Component.literal(reportType.getDescription())).m659b(0.0f).m655b(C0564jv.m2555d("textures/gui/reports/" + reportType.ordinal() + ".png")));
        }
        Iterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            width += ((C0127bs) it.next()).getWidth() + 5;
        }
        int i3 = i - (width / 2);
        int width2 = 0;
        for (C0127bs c0127bs : objectArrayList) {
            c0127bs.setX(i3 + width2);
            addRenderableWidget(c0127bs);
            width2 += c0127bs.getWidth() + 5;
        }
        C0127bs c0127bs2 = new C0127bs(i - 125, i2 + 30 + 5, 250, 20, Component.translatable("bf.menu.button.report.confirm"), button3 -> {
            C0482iS c0482iSA = this.f1585a.mo1137a(this.f1812g);
            C0218dT c0218dT = new C0218dT(this, f1809hm, z -> {
                if (z) {
                    ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketPunishPlayer(this.f1812g, this.f1813a));
                }
                this.f1587b.setScreen((Screen) null);
            });
            c0218dT.m1273a((Component) Component.translatable("bf.menu.punish.prompt", new Object[]{Component.literal(c0482iSA.getUsername()).withStyle(ChatFormatting.GRAY), Component.literal(this.f1813a.getTitle()).withStyle(ChatFormatting.GRAY)}));
            this.f1587b.setScreen(c0218dT);
        });
        this.f1814n = c0127bs2;
        addRenderableWidget(c0127bs2);
    }
}
