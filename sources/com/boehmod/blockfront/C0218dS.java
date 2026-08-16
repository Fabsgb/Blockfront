package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerGroup;
import com.boehmod.bflib.cloud.common.player.PunishmentType;
import com.boehmod.bflib.cloud.common.player.status.OnlineStatus;
import com.boehmod.bflib.common.util.ModLibraryMathHelper;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvents;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dS.class */
public final class C0218dS extends AbstractC0217dR {

    /* JADX INFO: renamed from: gz */
    private static final Component f1740gz = Component.translatable("bf.message.none").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: e */
    @NotNull
    private final C0289ek<AbstractC0298et> f1741e;

    public C0218dS(@NotNull Screen screen, @NotNull C0555jl c0555jl) {
        super(screen, c0555jl, Component.translatable("bf.screen.profile.stats", new Object[]{c0555jl.getUsername()}));
        this.f1741e = new C0289ek<>(0, 84, 235, 148, this);
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        C0129bt.m591c(guiGraphics, this.f1741e.m381r(), this.f1741e.m385s(), this.f1741e.m374x(), this.f1741e.height(), C0129bt.m465t());
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        ChatFormatting chatFormatting;
        ChatFormatting chatFormatting2;
        super.mo777H();
        this.f1741e.m375c(((this.width / 2) - 160) + 25 + 4);
        this.f1741e.m376d(60);
        this.f1741e.m1575e(Token.NUMBER);
        this.f1741e.m378f(this.height - 115);
        this.f1741e.m383g(true);
        m794a(this.f1741e);
        this.f1741e.m1576c(Collections.singletonList("&cLoading Player Statistics..."));
        List<String> objectArrayList = new ObjectArrayList<>();
        double kills = ((double) this.playerCloudData.getKills()) / ((double) (this.playerCloudData.getDeaths() == 0 ? 1 : this.playerCloudData.getDeaths()));
        double headShots = ((double) this.playerCloudData.getHeadShots()) / ((double) (this.playerCloudData.getKills() == 0 ? 1 : this.playerCloudData.getKills()));
        double dRound = ModLibraryMathHelper.round(kills, 1);
        double dRound2 = ModLibraryMathHelper.round(headShots, 1);
        MutableComponent mutableComponentM2500a = f1740gz;
        Optional<PlayerGroup> group = this.playerCloudData.getGroup();
        if (group.isPresent()) {
            mutableComponentM2500a = C0552ji.m2500a(group.get());
        }
        if (C0495ie.f3014a.containsKey(this.playerCloudData.getUUID())) {
            this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.PLAYER_LEVELUP, 1.0f));
            objectArrayList.add("");
            objectArrayList.add(String.valueOf(ChatFormatting.YELLOW) + String.valueOf(ChatFormatting.BOLD) + I18n.get("bf.message.profile.details.scoreboard.featured", new Object[0]));
            objectArrayList.add(String.valueOf(ChatFormatting.YELLOW) + I18n.get("bf.message.profile.details.scoreboard.featured.message", new Object[0]));
        }
        objectArrayList.add("");
        objectArrayList.add(String.valueOf(ChatFormatting.GRAY) + this.playerCloudData.getUsername() + " - " + I18n.get("bf.message.profile.details", new Object[0]));
        if (this.playerCloudData.hasActivePunishment(PunishmentType.BAN_CLOUD)) {
            objectArrayList.add("");
            objectArrayList.add(String.valueOf(ChatFormatting.RED) + I18n.get("bf.profile.main.banned", new Object[0]));
            objectArrayList.add(String.valueOf(ChatFormatting.GRAY) + I18n.get("bf.profile.main.banned.info", new Object[0]));
        }
        OnlineStatus onlineStatus = this.playerCloudData.getStatus().getOnlineStatus();
        objectArrayList.add("");
        objectArrayList.add(onlineStatus == OnlineStatus.ONLINE ? String.valueOf(ChatFormatting.GREEN) + String.valueOf(ChatFormatting.BOLD) + I18n.get("bf.message.online", new Object[0]) : String.valueOf(ChatFormatting.RED) + String.valueOf(ChatFormatting.BOLD) + I18n.get("bf.message.offline", new Object[0]));
        objectArrayList.add("");
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.boosters", new Object[]{String.valueOf(ChatFormatting.GREEN) + this.playerCloudData.getActiveBoosters().size()}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.group", new Object[]{mutableComponentM2500a.getString()}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.karma", new Object[]{String.valueOf(ChatFormatting.LIGHT_PURPLE) + C1273xM.m7239b(this.playerCloudData.getMatchKarma())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.time", new Object[]{String.valueOf(ChatFormatting.GRAY) + ModLibraryMathHelper.round(this.playerCloudData.getMinutesPlayed() / 60.0d, 1) + "h"}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.games", new Object[]{String.valueOf(ChatFormatting.GRAY) + C1273xM.m7239b(this.playerCloudData.getTotalGames())}));
        objectArrayList.add("");
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.exp", new Object[]{String.valueOf(ChatFormatting.AQUA) + C1273xM.m7239b(this.playerCloudData.getExp())}));
        String strValueOf = String.valueOf(ChatFormatting.WHITE);
        Object[] objArr = new Object[1];
        if (dRound == 0.0d) {
            chatFormatting = ChatFormatting.GRAY;
        } else {
            chatFormatting = dRound > 1.0d ? ChatFormatting.GREEN : ChatFormatting.RED;
        }
        objArr[0] = String.valueOf(chatFormatting) + dRound;
        objectArrayList.add(strValueOf + I18n.get("bf.message.profile.details.kd", objArr));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.headshots", new Object[]{String.valueOf(ChatFormatting.GREEN) + C1273xM.m7239b(this.playerCloudData.getHeadShots())}));
        String strValueOf2 = String.valueOf(ChatFormatting.WHITE);
        Object[] objArr2 = new Object[1];
        if (dRound2 == 0.0d) {
            chatFormatting2 = ChatFormatting.GRAY;
        } else {
            chatFormatting2 = dRound2 > 1.0d ? ChatFormatting.GREEN : ChatFormatting.RED;
        }
        objArr2[0] = String.valueOf(chatFormatting2) + dRound2;
        objectArrayList.add(strValueOf2 + I18n.get("bf.message.profile.details.headshots.ratio", objArr2));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.kills", new Object[]{String.valueOf(ChatFormatting.GREEN) + C1273xM.m7239b(this.playerCloudData.getKills())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.kills.streak", new Object[]{String.valueOf(ChatFormatting.GREEN) + C1273xM.m7239b(this.playerCloudData.getKillStreak())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.kills.fire", new Object[]{String.valueOf(ChatFormatting.GREEN) + C1273xM.m7239b(this.playerCloudData.getFireKills())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.backstabs", new Object[]{String.valueOf(ChatFormatting.GREEN) + C1273xM.m7239b(this.playerCloudData.getBackStabs())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.assists", new Object[]{String.valueOf(ChatFormatting.YELLOW) + C1273xM.m7239b(this.playerCloudData.getAssists())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.noscopes", new Object[]{String.valueOf(ChatFormatting.GREEN) + C1273xM.m7239b(this.playerCloudData.getNoScopes())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.deaths", new Object[]{String.valueOf(ChatFormatting.RED) + C1273xM.m7239b(this.playerCloudData.getDeaths())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.deaths.streak", new Object[]{String.valueOf(ChatFormatting.RED) + C1273xM.m7239b(this.playerCloudData.getDeathStreak())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.fb", new Object[]{String.valueOf(ChatFormatting.DARK_RED) + C1273xM.m7239b(this.playerCloudData.getFirstBloods())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.prestige", new Object[]{String.valueOf(ChatFormatting.YELLOW) + C1273xM.m7239b(this.playerCloudData.getPrestigeLevel())}));
        String strValueOf3 = String.valueOf(ChatFormatting.WHITE);
        Object[] objArr3 = new Object[1];
        objArr3[0] = this.playerCloudData.hasCompletedBootcamp() ? String.valueOf(ChatFormatting.GREEN) + "Yes" : String.valueOf(ChatFormatting.RED) + "No";
        objectArrayList.add(strValueOf3 + I18n.get("bf.message.profile.details.bootcamp", objArr3));
        objectArrayList.add("");
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.infected.rounds.won", new Object[]{String.valueOf(ChatFormatting.RED) + C1273xM.m7239b(this.playerCloudData.getInfectedRoundsWon())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.infected.matches.won", new Object[]{String.valueOf(ChatFormatting.RED) + C1273xM.m7239b(this.playerCloudData.getInfectedMatchesWon())}));
        objectArrayList.add("");
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.kills.bots", new Object[]{String.valueOf(ChatFormatting.BLUE) + C1273xM.m7239b(this.playerCloudData.getBotKills())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.kills.infected", new Object[]{String.valueOf(ChatFormatting.GREEN) + C1273xM.m7239b(this.playerCloudData.getInfectedKills())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.kills.vehicles", new Object[]{String.valueOf(ChatFormatting.GRAY) + C1273xM.m7239b(this.playerCloudData.getVehicleKills())}));
        objectArrayList.add("");
        objectArrayList.add(String.valueOf(ChatFormatting.RED) + I18n.get("bf.message.profile.details.punishments", new Object[0]));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.punishments.warnings", new Object[]{String.valueOf(ChatFormatting.RED) + this.playerCloudData.getPunishmentCount(PunishmentType.WARNING)}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.punishments.mutes", new Object[]{String.valueOf(ChatFormatting.RED) + this.playerCloudData.getPunishmentCount(PunishmentType.MUTE)}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.punishments.bans.ac", new Object[]{String.valueOf(ChatFormatting.RED) + this.playerCloudData.getPunishmentCount(PunishmentType.BAN_MM)}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.punishments.bans.cc", new Object[]{String.valueOf(ChatFormatting.RED) + this.playerCloudData.getPunishmentCount(PunishmentType.BAN_MM)}));
        objectArrayList.add("");
        this.f1741e.m1576c(objectArrayList);
    }
}
