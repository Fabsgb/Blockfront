package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.packet.common.clan.PacketClanKick;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bG.class */
public final class C0090bG extends AbstractC0139cC {

    /* JADX INFO: renamed from: P */
    private static final Component f594P = Component.translatable("bf.dropdown.text.profile");

    /* JADX INFO: renamed from: Q */
    private static final Component f595Q = Component.translatable("bf.dropdown.text.clan.kick").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: R */
    private static final Component f596R = Component.translatable("bf.dropdown.text.clan.kick.tip").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: b */
    @NotNull
    private final UUID f597b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0555jl f598a;

    public C0090bG(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull C0555jl c0555jl) {
        super(screen, i, i2, i3, i4, Component.translatable("bf.screen.dropdown.friend", new Object[]{c0555jl.getUsername()}));
        this.f597b = c0555jl.getUUID();
        this.f598a = c0555jl;
        UUID profileId = this.f1058a.getUser().getProfileId();
        boolean zEquals = this.f597b.equals(profileId);
        m771a(f594P, (Component) Component.translatable("bf.dropdown.text.profile.tip", new Object[]{Component.literal(c0555jl.getUsername())}));
        AbstractClanData clanData = this.f1056a.m1886a(this.f1058a).getClanData();
        if (!zEquals && clanData != null && clanData.getOwner().equals(profileId)) {
            m771a(f595Q, f596R);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0139cC, com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        C0129bt.m515a(guiGraphics, this.f1020cc, this.f1021cd - 22, this.f1022dE, 22, C0129bt.m465t());
        C0129bt.m515a(guiGraphics, this.f1020cc, this.f1021cd - 22, this.f1022dE, 22, C0129bt.m465t());
        C0129bt.m596a(this.f1056a, guiGraphics, this.font, this.f597b, C0292en.b.CLAN_MEMBER, this.f1020cc, this.f1021cd - 22, 22, false);
        C0129bt.m585a(this.f1058a, this.f1057f, poseStackPose, guiGraphics, this.f598a.m2522a(), (this.f1020cc + this.f1022dE) - 20, (this.f1021cd - 22) + 2, 18);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0139cC
    /* JADX INFO: renamed from: g */
    public void mo390g(int i) {
        switch (i) {
            case 1:
                this.f1058a.setScreen(new C0215dP(this.f1035c, this.f598a));
                break;
            case 2:
                ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketClanKick(this.f598a.getUsername()));
                break;
        }
    }
}
