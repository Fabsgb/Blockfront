package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.packet.common.clan.PacketClanKick;
import com.boehmod.blockfront.C0111eb;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bx.class */
public final class C0053bx extends AbstractC0076ct {
    private static final Component P = Component.translatable("bf.dropdown.text.profile");
    private static final Component Q = Component.translatable("bf.dropdown.text.clan.kick").withStyle(ChatFormatting.RED);
    private static final Component R = Component.translatable("bf.dropdown.text.clan.kick.tip").withStyle(ChatFormatting.RED);

    @NotNull
    private final UUID b;

    @NotNull
    private final iS a;

    public C0053bx(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull iS iSVar) {
        super(screen, i, i2, i3, i4, Component.translatable("bf.screen.dropdown.friend", new Object[]{iSVar.getUsername()}));
        this.b = iSVar.getUUID();
        this.a = iSVar;
        UUID profileId = this.b.getUser().getProfileId();
        boolean zEquals = this.b.equals(profileId);
        a(P, (Component) Component.translatable("bf.dropdown.text.profile.tip", new Object[]{Component.literal(iSVar.getUsername())}));
        AbstractClanData clanData = this.a.m404a(this.b).getClanData();
        if (!zEquals && clanData != null && clanData.getOwner().equals(profileId)) {
            a(Q, R);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0076ct, com.boehmod.blockfront.AbstractC0078cv, com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        C0040bk.a(guiGraphics, this.bm, this.bn - 22, this.cM, 22, C0040bk.p());
        C0040bk.a(guiGraphics, this.bm, this.bn - 22, this.cM, 22, C0040bk.p());
        C0040bk.a(this.a, guiGraphics, this.font, this.b, C0111eb.b.CLAN_MEMBER, this.bm, this.bn - 22, 22, false);
        C0040bk.a(this.b, this.e, poseStackPose, guiGraphics, this.a.m491a(), (this.bm + this.cM) - 20, (this.bn - 22) + 2, 18);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0076ct
    public void g(int i) {
        switch (i) {
            case 1:
                this.b.setScreen(new dE(this.c, this.a));
                break;
            case 2:
                ((C0163g) this.e.b()).sendPacket(new PacketClanKick(this.a.getUsername()));
                break;
        }
    }
}
