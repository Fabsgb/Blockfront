package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ReportType;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.packet.common.PacketPunishPlayer;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eh.class */
public class C0286eh extends C0143cG {

    /* JADX INFO: renamed from: ho */
    public static final Component f2246ho = Component.translatable("screen.staff.punish");

    /* JADX INFO: renamed from: hp */
    public static final Component f2247hp = Component.translatable("bf.menu.punish.reason.title");

    /* JADX INFO: renamed from: hq */
    public static final Component f2248hq = Component.translatable("bf.menu.punish.reason.tip").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: hr */
    public static final Component f2249hr = Component.translatable("bf.menu.button.back");

    /* JADX INFO: renamed from: hs */
    public static final Component f2250hs = Component.translatable("bf.menu.punish.prompt.title");

    /* JADX INFO: renamed from: iv */
    public static final int f2251iv = 310;

    /* JADX INFO: renamed from: iw */
    public static final int f2252iw = 100;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final UUID f2253g;

    /* JADX INFO: renamed from: a */
    private ReportType f2254a;

    /* JADX INFO: renamed from: n */
    private C0085bB f2255n;

    public C0286eh(@NotNull Component component, @NotNull UUID uuid) {
        super(component, f2246ho);
        this.f2253g = uuid;
        ((C0358g) this.f1057f.m2852b()).m1722a().m2492b(RequestType.PLAYER_DATA, this.f2253g);
    }

    @Override // com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = (this.height / 2) - 36;
        C0129bt.m593c(guiGraphics, i3 - 155, i4 - 10, f2251iv, 100, 0, 0.5f);
        super.render(guiGraphics, i, i2, f);
        C0555jl c0555jlA = this.f1056a.mo1154a(this.f2253g);
        int i5 = i3 - 68;
        int i6 = i4 - 35;
        C0129bt.m585a(this.f1058a, this.f1057f, poseStackPose, guiGraphics, c0555jlA.m2522a(), i5, i6, 18);
        C0129bt.m470a(this.font, guiGraphics, (Component) Component.literal(c0555jlA.getUsername()), i5 + 18 + 4, i6 + 1);
        C0129bt.m487a(poseStackPose, this.font, guiGraphics, (Component) Component.literal(this.f2253g.toString()).withStyle(ChatFormatting.GRAY), i5 + 18 + 4, i6 + 12, 0.5f);
        C0129bt.m483c(this.font, guiGraphics, f2247hp, i3, i4);
        C0129bt.m491b(poseStackPose, this.font, guiGraphics, f2248hq, i3, i4 + 12, 0.5f);
        if (this.f2255n != null) {
            this.f2255n.active = this.f2254a != null;
        }
        if (this.f2254a != null) {
            for (C0085bB c0085bB : this.renderables) {
                if (c0085bB instanceof C0085bB) {
                    C0085bB c0085bB2 = c0085bB;
                    int x = c0085bB2.getX();
                    int y = c0085bB2.getY();
                    int width = c0085bB2.getWidth();
                    int height = c0085bB2.getHeight();
                    if (c0085bB2.getMessage().getString().equals(this.f2254a.getTitle())) {
                        C0129bt.m515a(guiGraphics, x - 1, y - 1, width + 2, 1, ColorReferences.COLOR_WHITE_SOLID);
                        C0129bt.m515a(guiGraphics, x - 1, y - 1, 1, height + 2, ColorReferences.COLOR_WHITE_SOLID);
                        C0129bt.m515a(guiGraphics, x - 1, y + height, width + 2, 1, ColorReferences.COLOR_WHITE_SOLID);
                        C0129bt.m515a(guiGraphics, x + width, y - 1, 1, height + 2, ColorReferences.COLOR_WHITE_SOLID);
                    }
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        super.mo776K();
        int i = this.width / 2;
        int i2 = ((this.height / 2) - 34) + 22;
        int width = 0;
        if (this.f1058a.level == null) {
            addRenderableWidget(new C0085bB(5, 18, 20, 20, Component.empty(), button -> {
                this.f1058a.setScreen(new C0245dt());
            }).m320a(f1037aH).m322a(20, 20).m328a(C0085bB.a.NONE).m326a(f2249hr));
        }
        ObjectArrayList<C0085bB> objectArrayList = new ObjectArrayList();
        for (ReportType reportType : ReportType.values()) {
            objectArrayList.add(new C0085bB(0, i2, 30, 30, Component.literal(reportType.getTitle()), button2 -> {
                this.f2254a = reportType;
            }).m326a((Component) Component.literal(reportType.getDescription())).m334b(0.0f).m330b(C0532jO.m2378d("textures/gui/reports/" + reportType.ordinal() + ".png")));
        }
        Iterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            width += ((C0085bB) it.next()).getWidth() + 5;
        }
        int i3 = i - (width / 2);
        int width2 = 0;
        for (C0085bB c0085bB : objectArrayList) {
            c0085bB.setX(i3 + width2);
            addRenderableWidget(c0085bB);
            width2 += c0085bB.getWidth() + 5;
        }
        C0085bB c0085bB2 = new C0085bB(i - 125, i2 + 30 + 5, 250, 20, Component.translatable("bf.menu.button.report.confirm"), button3 -> {
            C0555jl c0555jlA = this.f1056a.mo1154a(this.f2253g);
            C0283ee c0283ee = new C0283ee(this, f2250hs, z -> {
                if (z) {
                    ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketPunishPlayer(this.f2253g, this.f2254a));
                }
                this.f1058a.setScreen((Screen) null);
            });
            c0283ee.m1324a((Component) Component.translatable("bf.menu.punish.prompt", new Object[]{Component.literal(c0555jlA.getUsername()).withStyle(ChatFormatting.GRAY), Component.literal(this.f2254a.getTitle()).withStyle(ChatFormatting.GRAY)}));
            this.f1058a.setScreen(c0283ee);
        });
        this.f2255n = c0085bB2;
        addRenderableWidget(c0085bB2);
    }
}
