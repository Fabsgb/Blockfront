package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.common.mm.MatchParty;
import com.boehmod.bflib.cloud.common.player.status.OnlineStatus;
import com.boehmod.bflib.cloud.common.player.status.PartyStatus;
import com.boehmod.bflib.cloud.common.player.status.PublicPlayerStatus;
import com.boehmod.bflib.cloud.packet.common.clan.PacketClanInvite;
import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendJoinGame;
import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendRemove;
import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendSpectateGame;
import com.boehmod.bflib.cloud.packet.common.party.PacketPartyInvite;
import com.boehmod.bflib.cloud.packet.common.party.PacketPartyJoin;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0111eb;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.by, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/by.class */
public final class C0054by extends AbstractC0076ct {
    private static final Component S = Component.translatable("bf.message.friend.error.party.in");
    private static final Component T = Component.translatable("bf.message.friend.error.party.null");
    private static final Component U = Component.translatable("bf.message.prompt.friend.remove.title");
    private static final Component V = Component.translatable("bf.message.prompt.friend.remove");
    private static final Component W = Component.translatable("bf.dropdown.text.profile");
    private static final Component X = Component.translatable("bf.dropdown.text.clan.invite.tip");
    private static final Component Y = Component.translatable("bf.dropdown.text.party.invite");
    private static final Component Z = Component.translatable("bf.dropdown.text.party.invite.tip");
    private static final Component aa = Component.translatable("bf.dropdown.text.party.join");
    private static final Component ab = Component.translatable("bf.dropdown.text.party.join.tip");
    private static final Component ac = Component.translatable("bf.dropdown.text.game.join");
    private static final Component ad = Component.translatable("bf.dropdown.text.game.join.tip");
    private static final Component ae = Component.translatable("bf.dropdown.text.game.spectate");
    private static final Component af = Component.translatable("bf.dropdown.text.game.spectate.tip");
    private static final Component ag = Component.translatable("bf.dropdown.text.remove").withStyle(ChatFormatting.RED);
    private static final Component ah = Component.translatable("bf.dropdown.text.remove.tip").withStyle(ChatFormatting.RED);
    private static final Component ai = Component.translatable("bf.dropdown.text.clan.invite");

    @NotNull
    private final UUID c;

    @NotNull
    private final iS b;

    public C0054by(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull iS iSVar) {
        super(screen, i, i2, i3, i4, Component.translatable("bf.screen.dropdown.friend", new Object[]{iSVar.getUsername()}));
        this.c = iSVar.getUUID();
        iS iSVarM404a = this.a.m404a(this.b);
        iSVarM404a.getStatus().isInGame();
        Optional<MatchParty> party = iSVarM404a.getParty();
        AbstractClanData clanData = iSVarM404a.getClanData();
        boolean z = (clanData == null || clanData.isEmpty() || !clanData.getOwner().equals(iSVarM404a.getUUID())) ? false : true;
        this.b = iSVar;
        PublicPlayerStatus status = this.b.getStatus();
        Component componentWithColor = ai;
        componentWithColor = z ? componentWithColor.copy().withColor(ColorReferences.COLOR_THEME_CLANS_SOLID) : componentWithColor;
        PublicPlayerStatus status2 = this.b.getStatus();
        OnlineStatus onlineStatus = status2.getOnlineStatus();
        boolean zIsInGame = status2.isInGame();
        a(W, (Component) Component.translatable("bf.dropdown.text.profile.tip", new Object[]{Component.literal(iSVar.getUsername())}));
        a(componentWithColor, X, z);
        a(Y, Z, party.isPresent() && onlineStatus == OnlineStatus.ONLINE);
        a(aa, ab, status.getPartyStatus() != PartyStatus.NONE);
        a(ac, ad, zIsInGame);
        a(ae, af, zIsInGame);
        a(ag, ah);
    }

    @Override // com.boehmod.blockfront.AbstractC0076ct, com.boehmod.blockfront.AbstractC0078cv, com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        C0040bk.a(guiGraphics, this.bm, this.bn - 22, this.cM, 22, C0040bk.p());
        C0040bk.a(guiGraphics, this.bm, this.bn - 22, this.cM, 22, C0040bk.p());
        C0040bk.a(this.a, guiGraphics, this.font, this.c, C0111eb.b.FRIEND, this.bm, this.bn - 22, 22, false);
        C0040bk.a(this.b, this.e, poseStackPose, guiGraphics, this.b.m491a(), (this.bm + this.cM) - 20, (this.bn - 22) + 2, 18);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0076ct
    public void g(int i) {
        C0163g c0163g = (C0163g) this.e.b();
        iS iSVarM404a = this.a.m404a(this.b);
        iS iSVarA = this.a.mo306a(this.c);
        PublicPlayerStatus status = iSVarA.getStatus();
        ClientLevel clientLevel = this.b.level;
        switch (i) {
            case 1:
                this.b.setScreen(new dE(this.c, this.b));
                break;
            case 2:
                c0163g.sendPacket(new PacketClanInvite(iSVarA.getUsername()));
                break;
            case 3:
                if (status.getPartyStatus() == PartyStatus.NONE) {
                    c0163g.sendPacket(new PacketPartyInvite(this.c));
                } else {
                    C0119ej.a(this.b, (Component) Component.translatable("bf.message.party.already.in", new Object[]{this.b.getUsername()}));
                }
                break;
            case 4:
                if (iSVarM404a.getParty().isEmpty()) {
                    if (status.getPartyStatus() != PartyStatus.NONE) {
                        c0163g.sendPacket(new PacketPartyJoin(this.c));
                    } else {
                        C0119ej.a(this.b, T);
                    }
                } else {
                    C0119ej.a(this.b, S);
                }
                break;
            case 5:
                Optional<MatchParty> party = iSVarM404a.getParty();
                if (party.isEmpty() || party.get().getPlayers().contains(this.c)) {
                    if (this.b.getStatus().isInGame()) {
                        if (clientLevel != null) {
                            this.e.b(this.b, clientLevel);
                        }
                        this.e.m596a().b(this.b.getUsername());
                        c0163g.sendPacket(new PacketFriendJoinGame(this.c));
                    }
                } else {
                    C0119ej.a(this.b, S);
                }
                break;
            case 6:
                Optional<MatchParty> party2 = iSVarM404a.getParty();
                if (party2.isEmpty() || party2.get().getPlayers().contains(this.c)) {
                    if (this.b.getStatus().isInGame()) {
                        if (clientLevel != null) {
                            this.e.b(this.b, clientLevel);
                        }
                        this.e.m596a().b(this.b.getUsername());
                        c0163g.sendPacket(new PacketFriendSpectateGame(this.c));
                    }
                } else {
                    C0119ej.a(this.b, S);
                }
                break;
            case 7:
                dT dTVar = new dT(this.c, U, z -> {
                    if (z) {
                        c0163g.sendPacket(new PacketFriendRemove(this.b.getUUID()));
                    }
                });
                dTVar.a(V);
                this.b.setScreen(dTVar);
                break;
        }
    }
}
