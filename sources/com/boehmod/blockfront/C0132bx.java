package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.packet.common.clan.PacketClanKick;
import com.boehmod.blockfront.C0279eb;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bx.class */
public final class C0132bx extends AbstractC0191ct {

    /* JADX INFO: renamed from: P */
    private static final Component f955P = Component.translatable("bf.dropdown.text.profile");

    /* JADX INFO: renamed from: Q */
    private static final Component f956Q = Component.translatable("bf.dropdown.text.clan.kick").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: R */
    private static final Component f957R = Component.translatable("bf.dropdown.text.clan.kick.tip").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: b */
    @NotNull
    private final UUID f958b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0482iS f959a;

    public C0132bx(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull C0482iS c0482iS) {
        super(screen, i, i2, i3, i4, Component.translatable("bf.screen.dropdown.friend", new Object[]{c0482iS.getUsername()}));
        this.f958b = c0482iS.getUUID();
        this.f959a = c0482iS;
        UUID profileId = this.f1587b.getUser().getProfileId();
        boolean zEquals = this.f958b.equals(profileId);
        m1174a(f955P, (Component) Component.translatable("bf.dropdown.text.profile.tip", new Object[]{Component.literal(c0482iS.getUsername())}));
        AbstractClanData clanData = this.f1585a.m1676a(this.f1587b).getClanData();
        if (!zEquals && clanData != null && clanData.getOwner().equals(profileId)) {
            m1174a(f956Q, f957R);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0191ct, com.boehmod.blockfront.AbstractC0193cv, com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        C0119bk.m415a(guiGraphics, this.f1540bm, this.f1541bn - 22, this.f1542cM, 22, C0119bk.m365p());
        C0119bk.m415a(guiGraphics, this.f1540bm, this.f1541bn - 22, this.f1542cM, 22, C0119bk.m365p());
        C0119bk.m496a(this.f1585a, guiGraphics, this.font, this.f958b, C0279eb.b.CLAN_MEMBER, this.f1540bm, this.f1541bn - 22, 22, false);
        C0119bk.m485a(this.f1587b, this.f1586e, poseStackPose, guiGraphics, this.f959a.m2195a(), (this.f1540bm + this.f1542cM) - 20, (this.f1541bn - 22) + 2, 18);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0191ct
    /* JADX INFO: renamed from: g */
    public void mo286g(int i) {
        switch (i) {
            case 1:
                this.f1587b.setScreen(new C0203dE(this.f1556c, this.f959a));
                break;
            case 2:
                ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketClanKick(this.f959a.getUsername()));
                break;
        }
    }
}
