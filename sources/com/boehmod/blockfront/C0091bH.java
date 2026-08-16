package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.common.p001mm.MatchParty;
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
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bH.class */
public final class C0091bH extends AbstractC0139cC {

    /* JADX INFO: renamed from: S */
    private static final Component f599S = Component.translatable("bf.message.friend.error.party.in");

    /* JADX INFO: renamed from: T */
    private static final Component f600T = Component.translatable("bf.message.friend.error.party.null");

    /* JADX INFO: renamed from: U */
    private static final Component f601U = Component.translatable("bf.message.prompt.friend.remove.title");

    /* JADX INFO: renamed from: V */
    private static final Component f602V = Component.translatable("bf.message.prompt.friend.remove");

    /* JADX INFO: renamed from: W */
    private static final Component f603W = Component.translatable("bf.dropdown.text.profile");

    /* JADX INFO: renamed from: X */
    private static final Component f604X = Component.translatable("bf.dropdown.text.clan.invite.tip");

    /* JADX INFO: renamed from: Y */
    private static final Component f605Y = Component.translatable("bf.dropdown.text.party.invite");

    /* JADX INFO: renamed from: Z */
    private static final Component f606Z = Component.translatable("bf.dropdown.text.party.invite.tip");

    /* JADX INFO: renamed from: aa */
    private static final Component f607aa = Component.translatable("bf.dropdown.text.party.join");

    /* JADX INFO: renamed from: ab */
    private static final Component f608ab = Component.translatable("bf.dropdown.text.party.join.tip");

    /* JADX INFO: renamed from: ac */
    private static final Component f609ac = Component.translatable("bf.dropdown.text.game.join");

    /* JADX INFO: renamed from: ad */
    private static final Component f610ad = Component.translatable("bf.dropdown.text.game.join.tip");

    /* JADX INFO: renamed from: ae */
    private static final Component f611ae = Component.translatable("bf.dropdown.text.game.spectate");

    /* JADX INFO: renamed from: af */
    private static final Component f612af = Component.translatable("bf.dropdown.text.game.spectate.tip");

    /* JADX INFO: renamed from: ag */
    private static final Component f613ag = Component.translatable("bf.dropdown.text.remove").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: ah */
    private static final Component f614ah = Component.translatable("bf.dropdown.text.remove.tip").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: ai */
    private static final Component f615ai = Component.translatable("bf.dropdown.text.clan.invite");

    /* JADX INFO: renamed from: c */
    @NotNull
    private final UUID f616c;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0555jl f617b;

    public C0091bH(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull C0555jl c0555jl) {
        super(screen, i, i2, i3, i4, Component.translatable("bf.screen.dropdown.friend", new Object[]{c0555jl.getUsername()}));
        this.f616c = c0555jl.getUUID();
        C0555jl c0555jlM1886a = this.f1056a.m1886a(this.f1058a);
        c0555jlM1886a.getStatus().isInGame();
        Optional<MatchParty> party = c0555jlM1886a.getParty();
        AbstractClanData clanData = c0555jlM1886a.getClanData();
        boolean z = (clanData == null || clanData.isEmpty() || !clanData.getOwner().equals(c0555jlM1886a.getUUID())) ? false : true;
        this.f617b = c0555jl;
        PublicPlayerStatus status = this.f617b.getStatus();
        Component componentWithColor = f615ai;
        componentWithColor = z ? componentWithColor.copy().withColor(ColorReferences.COLOR_THEME_CLANS_SOLID) : componentWithColor;
        PublicPlayerStatus status2 = this.f617b.getStatus();
        OnlineStatus onlineStatus = status2.getOnlineStatus();
        boolean zIsInGame = status2.isInGame();
        m771a(f603W, (Component) Component.translatable("bf.dropdown.text.profile.tip", new Object[]{Component.literal(c0555jl.getUsername())}));
        m773a(componentWithColor, f604X, z);
        m773a(f605Y, f606Z, party.isPresent() && onlineStatus == OnlineStatus.ONLINE);
        m773a(f607aa, f608ab, status.getPartyStatus() != PartyStatus.NONE);
        m773a(f609ac, f610ad, zIsInGame);
        m773a(f611ae, f612af, zIsInGame);
        m771a(f613ag, f614ah);
    }

    @Override // com.boehmod.blockfront.AbstractC0139cC, com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        C0129bt.m515a(guiGraphics, this.f1020cc, this.f1021cd - 22, this.f1022dE, 22, C0129bt.m465t());
        C0129bt.m515a(guiGraphics, this.f1020cc, this.f1021cd - 22, this.f1022dE, 22, C0129bt.m465t());
        C0129bt.m596a(this.f1056a, guiGraphics, this.font, this.f616c, C0292en.b.FRIEND, this.f1020cc, this.f1021cd - 22, 22, false);
        C0129bt.m585a(this.f1058a, this.f1057f, poseStackPose, guiGraphics, this.f617b.m2522a(), (this.f1020cc + this.f1022dE) - 20, (this.f1021cd - 22) + 2, 18);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0139cC
    /* JADX INFO: renamed from: g */
    public void mo390g(int i) {
        C0358g c0358g = (C0358g) this.f1057f.m2852b();
        C0555jl c0555jlM1886a = this.f1056a.m1886a(this.f1058a);
        C0555jl c0555jlA = this.f1056a.mo1154a(this.f616c);
        PublicPlayerStatus status = c0555jlA.getStatus();
        switch (i) {
            case 1:
                this.f1058a.setScreen(new C0215dP(this.f1035c, this.f617b));
                break;
            case 2:
                c0358g.sendPacket(new PacketClanInvite(c0555jlA.getUsername()));
                break;
            case 3:
                if (status.getPartyStatus() == PartyStatus.NONE) {
                    c0358g.sendPacket(new PacketPartyInvite(this.f616c));
                } else {
                    C0301ew.m1623a(this.f1058a, (Component) Component.translatable("bf.message.party.already.in", new Object[]{this.f617b.getUsername()}));
                }
                break;
            case 4:
                if (c0555jlM1886a.getParty().isEmpty()) {
                    if (status.getPartyStatus() != PartyStatus.NONE) {
                        c0358g.sendPacket(new PacketPartyJoin(this.f616c));
                    } else {
                        C0301ew.m1623a(this.f1058a, f600T);
                    }
                } else {
                    C0301ew.m1623a(this.f1058a, f599S);
                }
                break;
            case 5:
                Optional<MatchParty> party = c0555jlM1886a.getParty();
                if (party.isEmpty() || party.get().getPlayers().contains(this.f616c)) {
                    if (this.f617b.getStatus().isInGame()) {
                        this.f1057f.m2885a().m2581b(this.f617b.getUsername());
                        c0358g.sendPacket(new PacketFriendJoinGame(this.f616c));
                    }
                } else {
                    C0301ew.m1623a(this.f1058a, f599S);
                }
                break;
            case 6:
                Optional<MatchParty> party2 = c0555jlM1886a.getParty();
                if (party2.isEmpty() || party2.get().getPlayers().contains(this.f616c)) {
                    if (this.f617b.getStatus().isInGame()) {
                        this.f1057f.m2885a().m2581b(this.f617b.getUsername());
                        c0358g.sendPacket(new PacketFriendSpectateGame(this.f616c));
                    }
                } else {
                    C0301ew.m1623a(this.f1058a, f599S);
                }
                break;
            case C0994s.f5462C /* 7 */:
                C0283ee c0283ee = new C0283ee(this.f1035c, f601U, z -> {
                    if (z) {
                        c0358g.sendPacket(new PacketFriendRemove(this.f617b.getUUID()));
                    }
                });
                c0283ee.m1324a(f602V);
                this.f1058a.setScreen(c0283ee);
                break;
        }
    }
}
