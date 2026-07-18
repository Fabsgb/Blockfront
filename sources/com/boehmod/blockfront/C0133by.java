package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.common.p000mm.MatchParty;
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
import com.boehmod.blockfront.C0279eb;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.by */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/by.class */
public final class C0133by extends AbstractC0191ct {

    /* JADX INFO: renamed from: S */
    private static final Component f960S = Component.translatable("bf.message.friend.error.party.in");

    /* JADX INFO: renamed from: T */
    private static final Component f961T = Component.translatable("bf.message.friend.error.party.null");

    /* JADX INFO: renamed from: U */
    private static final Component f962U = Component.translatable("bf.message.prompt.friend.remove.title");

    /* JADX INFO: renamed from: V */
    private static final Component f963V = Component.translatable("bf.message.prompt.friend.remove");

    /* JADX INFO: renamed from: W */
    private static final Component f964W = Component.translatable("bf.dropdown.text.profile");

    /* JADX INFO: renamed from: X */
    private static final Component f965X = Component.translatable("bf.dropdown.text.clan.invite.tip");

    /* JADX INFO: renamed from: Y */
    private static final Component f966Y = Component.translatable("bf.dropdown.text.party.invite");

    /* JADX INFO: renamed from: Z */
    private static final Component f967Z = Component.translatable("bf.dropdown.text.party.invite.tip");

    /* JADX INFO: renamed from: aa */
    private static final Component f968aa = Component.translatable("bf.dropdown.text.party.join");

    /* JADX INFO: renamed from: ab */
    private static final Component f969ab = Component.translatable("bf.dropdown.text.party.join.tip");

    /* JADX INFO: renamed from: ac */
    private static final Component f970ac = Component.translatable("bf.dropdown.text.game.join");

    /* JADX INFO: renamed from: ad */
    private static final Component f971ad = Component.translatable("bf.dropdown.text.game.join.tip");

    /* JADX INFO: renamed from: ae */
    private static final Component f972ae = Component.translatable("bf.dropdown.text.game.spectate");

    /* JADX INFO: renamed from: af */
    private static final Component f973af = Component.translatable("bf.dropdown.text.game.spectate.tip");

    /* JADX INFO: renamed from: ag */
    private static final Component f974ag = Component.translatable("bf.dropdown.text.remove").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: ah */
    private static final Component f975ah = Component.translatable("bf.dropdown.text.remove.tip").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: ai */
    private static final Component f976ai = Component.translatable("bf.dropdown.text.clan.invite");

    /* JADX INFO: renamed from: c */
    @NotNull
    private final UUID f977c;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0482iS f978b;

    public C0133by(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull C0482iS c0482iS) {
        super(screen, i, i2, i3, i4, Component.translatable("bf.screen.dropdown.friend", new Object[]{c0482iS.getUsername()}));
        this.f977c = c0482iS.getUUID();
        C0482iS c0482iSM1676a = this.f1585a.m1676a(this.f1587b);
        c0482iSM1676a.getStatus().isInGame();
        Optional<MatchParty> party = c0482iSM1676a.getParty();
        AbstractClanData clanData = c0482iSM1676a.getClanData();
        boolean z = (clanData == null || clanData.isEmpty() || !clanData.getOwner().equals(c0482iSM1676a.getUUID())) ? false : true;
        this.f978b = c0482iS;
        PublicPlayerStatus status = this.f978b.getStatus();
        Component componentWithColor = f976ai;
        componentWithColor = z ? componentWithColor.copy().withColor(ColorReferences.COLOR_THEME_CLANS_SOLID) : componentWithColor;
        PublicPlayerStatus status2 = this.f978b.getStatus();
        OnlineStatus onlineStatus = status2.getOnlineStatus();
        boolean zIsInGame = status2.isInGame();
        m1174a(f964W, (Component) Component.translatable("bf.dropdown.text.profile.tip", new Object[]{Component.literal(c0482iS.getUsername())}));
        m1176a(componentWithColor, f965X, z);
        m1176a(f966Y, f967Z, party.isPresent() && onlineStatus == OnlineStatus.ONLINE);
        m1176a(f968aa, f969ab, status.getPartyStatus() != PartyStatus.NONE);
        m1176a(f970ac, f971ad, zIsInGame);
        m1176a(f972ae, f973af, zIsInGame);
        m1174a(f974ag, f975ah);
    }

    @Override // com.boehmod.blockfront.AbstractC0191ct, com.boehmod.blockfront.AbstractC0193cv, com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        C0119bk.m415a(guiGraphics, this.f1540bm, this.f1541bn - 22, this.f1542cM, 22, C0119bk.m365p());
        C0119bk.m415a(guiGraphics, this.f1540bm, this.f1541bn - 22, this.f1542cM, 22, C0119bk.m365p());
        C0119bk.m496a(this.f1585a, guiGraphics, this.font, this.f977c, C0279eb.b.FRIEND, this.f1540bm, this.f1541bn - 22, 22, false);
        C0119bk.m485a(this.f1587b, this.f1586e, poseStackPose, guiGraphics, this.f978b.m2195a(), (this.f1540bm + this.f1542cM) - 20, (this.f1541bn - 22) + 2, 18);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0191ct
    /* JADX INFO: renamed from: g */
    public void mo286g(int i) {
        C0357g c0357g = (C0357g) this.f1586e.m2667b();
        C0482iS c0482iSM1676a = this.f1585a.m1676a(this.f1587b);
        C0482iS c0482iSA = this.f1585a.mo1137a(this.f977c);
        PublicPlayerStatus status = c0482iSA.getStatus();
        ClientLevel clientLevel = this.f1587b.level;
        switch (i) {
            case 1:
                this.f1587b.setScreen(new C0203dE(this.f1556c, this.f978b));
                break;
            case 2:
                c0357g.sendPacket(new PacketClanInvite(c0482iSA.getUsername()));
                break;
            case 3:
                if (status.getPartyStatus() == PartyStatus.NONE) {
                    c0357g.sendPacket(new PacketPartyInvite(this.f977c));
                } else {
                    C0287ej.m1507a(this.f1587b, (Component) Component.translatable("bf.message.party.already.in", new Object[]{this.f978b.getUsername()}));
                }
                break;
            case 4:
                if (c0482iSM1676a.getParty().isEmpty()) {
                    if (status.getPartyStatus() != PartyStatus.NONE) {
                        c0357g.sendPacket(new PacketPartyJoin(this.f977c));
                    } else {
                        C0287ej.m1507a(this.f1587b, f961T);
                    }
                } else {
                    C0287ej.m1507a(this.f1587b, f960S);
                }
                break;
            case 5:
                Optional<MatchParty> party = c0482iSM1676a.getParty();
                if (party.isEmpty() || party.get().getPlayers().contains(this.f977c)) {
                    if (this.f978b.getStatus().isInGame()) {
                        if (clientLevel != null) {
                            this.f1586e.m2669b(this.f1587b, clientLevel);
                        }
                        this.f1586e.m2699a().m2592b(this.f978b.getUsername());
                        c0357g.sendPacket(new PacketFriendJoinGame(this.f977c));
                    }
                } else {
                    C0287ej.m1507a(this.f1587b, f960S);
                }
                break;
            case 6:
                Optional<MatchParty> party2 = c0482iSM1676a.getParty();
                if (party2.isEmpty() || party2.get().getPlayers().contains(this.f977c)) {
                    if (this.f978b.getStatus().isInGame()) {
                        if (clientLevel != null) {
                            this.f1586e.m2669b(this.f1587b, clientLevel);
                        }
                        this.f1586e.m2699a().m2592b(this.f978b.getUsername());
                        c0357g.sendPacket(new PacketFriendSpectateGame(this.f977c));
                    }
                } else {
                    C0287ej.m1507a(this.f1587b, f960S);
                }
                break;
            case 7:
                C0218dT c0218dT = new C0218dT(this.f1556c, f962U, z -> {
                    if (z) {
                        c0357g.sendPacket(new PacketFriendRemove(this.f978b.getUUID()));
                    }
                });
                c0218dT.m1273a(f963V);
                this.f1587b.setScreen(c0218dT);
                break;
        }
    }
}
