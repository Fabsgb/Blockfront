package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ReportType;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.packet.common.PacketPunishPlayer;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dW.class */
public class dW extends C0080cx {
    public static final Component hi = Component.translatable("screen.staff.punish");
    public static final Component hj = Component.translatable("bf.menu.punish.reason.title");
    public static final Component hk = Component.translatable("bf.menu.punish.reason.tip").withStyle(ChatFormatting.GRAY);
    public static final Component hl = Component.translatable("bf.menu.button.back");
    public static final Component hm = Component.translatable("bf.menu.punish.prompt.title");

    /* JADX INFO: renamed from: hl, reason: collision with other field name */
    public static final int f115hl = 310;

    /* JADX INFO: renamed from: hm, reason: collision with other field name */
    public static final int f116hm = 100;

    @NotNull
    private final UUID g;
    private ReportType a;
    private C0048bs n;

    public dW(@NotNull Component component, @NotNull UUID uuid) {
        super(component, hi);
        this.g = uuid;
        ((C0163g) this.e.b()).a().b(RequestType.PLAYER_DATA, this.g);
    }

    @Override // com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = (this.height / 2) - 36;
        C0040bk.c(guiGraphics, i3 - 155, i4 - 10, f115hl, 100, 0, 0.5f);
        super.render(guiGraphics, i, i2, f);
        iS iSVarA = this.a.mo306a(this.g);
        int i5 = i3 - 68;
        int i6 = i4 - 35;
        C0040bk.a(this.b, this.e, poseStackPose, guiGraphics, iSVarA.m491a(), i5, i6, 18);
        C0040bk.a(this.font, guiGraphics, (Component) Component.literal(iSVarA.getUsername()), i5 + 18 + 4, i6 + 1);
        C0040bk.a(poseStackPose, this.font, guiGraphics, (Component) Component.literal(this.g.toString()).withStyle(ChatFormatting.GRAY), i5 + 18 + 4, i6 + 12, 0.5f);
        C0040bk.c(this.font, guiGraphics, hj, i3, i4);
        C0040bk.b(poseStackPose, this.font, guiGraphics, hk, i3, i4 + 12, 0.5f);
        if (this.n != null) {
            this.n.active = this.a != null;
        }
        if (this.a != null) {
            for (C0048bs c0048bs : this.renderables) {
                if (c0048bs instanceof C0048bs) {
                    C0048bs c0048bs2 = c0048bs;
                    int x = c0048bs2.getX();
                    int y = c0048bs2.getY();
                    int width = c0048bs2.getWidth();
                    int height = c0048bs2.getHeight();
                    if (c0048bs2.getMessage().getString().equals(this.a.getTitle())) {
                        C0040bk.a(guiGraphics, x - 1, y - 1, width + 2, 1, ColorReferences.COLOR_WHITE_SOLID);
                        C0040bk.a(guiGraphics, x - 1, y - 1, 1, height + 2, ColorReferences.COLOR_WHITE_SOLID);
                        C0040bk.a(guiGraphics, x - 1, y + height, width + 2, 1, ColorReferences.COLOR_WHITE_SOLID);
                        C0040bk.a(guiGraphics, x + width, y - 1, 1, height + 2, ColorReferences.COLOR_WHITE_SOLID);
                    }
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        super.mo280G();
        int i = this.width / 2;
        int i2 = ((this.height / 2) - 34) + 22;
        int width = 0;
        if (this.b.level == null) {
            addRenderableWidget(new C0048bs(5, 18, 20, 20, Component.empty(), button -> {
                this.b.setScreen(new C0094dk());
            }).a(aH).a(20, 20).a(C0048bs.a.NONE).a(hl));
        }
        ObjectArrayList<C0048bs> objectArrayList = new ObjectArrayList();
        for (ReportType reportType : ReportType.values()) {
            objectArrayList.add(new C0048bs(0, i2, 30, 30, Component.literal(reportType.getTitle()), button2 -> {
                this.a = reportType;
            }).a((Component) Component.literal(reportType.getDescription())).b(0.0f).b(C0265jv.d("textures/gui/reports/" + reportType.ordinal() + ".png")));
        }
        Iterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            width += ((C0048bs) it.next()).getWidth() + 5;
        }
        int i3 = i - (width / 2);
        int width2 = 0;
        for (C0048bs c0048bs : objectArrayList) {
            c0048bs.setX(i3 + width2);
            addRenderableWidget(c0048bs);
            width2 += c0048bs.getWidth() + 5;
        }
        C0048bs c0048bs2 = new C0048bs(i - 125, i2 + 30 + 5, 250, 20, Component.translatable("bf.menu.button.report.confirm"), button3 -> {
            iS iSVarA = this.a.mo306a(this.g);
            dT dTVar = new dT(this, hm, z -> {
                if (z) {
                    ((C0163g) this.e.b()).sendPacket(new PacketPunishPlayer(this.g, this.a));
                }
                this.b.setScreen((Screen) null);
            });
            dTVar.a((Component) Component.translatable("bf.menu.punish.prompt", new Object[]{Component.literal(iSVarA.getUsername()).withStyle(ChatFormatting.GRAY), Component.literal(this.a.getTitle()).withStyle(ChatFormatting.GRAY)}));
            this.b.setScreen(dTVar);
        });
        this.n = c0048bs2;
        addRenderableWidget(c0048bs2);
    }
}
