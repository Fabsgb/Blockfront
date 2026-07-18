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

/* JADX INFO: renamed from: com.boehmod.blockfront.dH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dH.class */
public final class C0206dH extends AbstractC0205dG {

    /* JADX INFO: renamed from: gt */
    private static final Component f1711gt = Component.translatable("bf.message.none").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: d */
    @NotNull
    private final C0224dZ<AbstractC0284eg> f1712d;

    public C0206dH(@NotNull Screen screen, @NotNull C0482iS c0482iS) {
        super(screen, c0482iS, Component.translatable("bf.screen.profile.stats", new Object[]{c0482iS.getUsername()}));
        this.f1712d = new C0224dZ<>(0, 84, 235, 148, this);
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        C0119bk.m491c(guiGraphics, this.f1712d.m709n(), this.f1712d.m710o(), this.f1712d.m699t(), this.f1712d.height(), C0119bk.m365p());
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: E */
    public void mo775E() {
        super.mo775E();
        this.f1712d.m700c(((this.width / 2) - 160) + 25 + 4);
        this.f1712d.m701d(60);
        this.f1712d.m1314e(Token.NUMBER);
        this.f1712d.m703f(this.height - 115);
        this.f1712d.m708g(true);
        m1195a(this.f1712d);
        this.f1712d.m1315c(Collections.singletonList("&cLoading Player Statistics..."));
        List<String> objectArrayList = new ObjectArrayList<>();
        double kills = ((double) this.playerCloudData.getKills()) / ((double) (this.playerCloudData.getDeaths() == 0 ? 1 : this.playerCloudData.getDeaths()));
        double headShots = ((double) this.playerCloudData.getHeadShots()) / ((double) (this.playerCloudData.getKills() == 0 ? 1 : this.playerCloudData.getKills()));
        double dRound = ModLibraryMathHelper.round(kills, 1);
        double dRound2 = ModLibraryMathHelper.round(headShots, 1);
        MutableComponent mutableComponentM2173a = f1711gt;
        Optional<PlayerGroup> group = this.playerCloudData.getGroup();
        if (group.isPresent()) {
            mutableComponentM2173a = C0479iP.m2173a(group.get());
        }
        if (C0424hN.f2713a.containsKey(this.playerCloudData.getUUID())) {
            this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.PLAYER_LEVELUP, 1.0f));
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
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.group", new Object[]{mutableComponentM2173a.getString()}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.karma", new Object[]{String.valueOf(ChatFormatting.LIGHT_PURPLE) + C1293xp.m7912a(this.playerCloudData.getMatchKarma())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.time", new Object[]{String.valueOf(ChatFormatting.GRAY) + ModLibraryMathHelper.round(this.playerCloudData.getMinutesPlayed() / 60.0d, 1) + "h"}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.games", new Object[]{String.valueOf(ChatFormatting.GRAY) + C1293xp.m7912a(this.playerCloudData.getTotalGames())}));
        objectArrayList.add("");
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.exp", new Object[]{String.valueOf(ChatFormatting.AQUA) + C1293xp.m7912a(this.playerCloudData.getExp())}));
        String strValueOf = String.valueOf(ChatFormatting.WHITE);
        Object[] objArr = new Object[1];
        objArr[0] = String.valueOf(dRound == 0.0d ? ChatFormatting.GRAY : dRound > 1.0d ? ChatFormatting.GREEN : ChatFormatting.RED) + dRound;
        objectArrayList.add(strValueOf + I18n.get("bf.message.profile.details.kd", objArr));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.headshots", new Object[]{String.valueOf(ChatFormatting.GREEN) + C1293xp.m7912a(this.playerCloudData.getHeadShots())}));
        String strValueOf2 = String.valueOf(ChatFormatting.WHITE);
        Object[] objArr2 = new Object[1];
        objArr2[0] = String.valueOf(dRound2 == 0.0d ? ChatFormatting.GRAY : dRound2 > 1.0d ? ChatFormatting.GREEN : ChatFormatting.RED) + dRound2;
        objectArrayList.add(strValueOf2 + I18n.get("bf.message.profile.details.headshots.ratio", objArr2));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.kills", new Object[]{String.valueOf(ChatFormatting.GREEN) + C1293xp.m7912a(this.playerCloudData.getKills())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.kills.streak", new Object[]{String.valueOf(ChatFormatting.GREEN) + C1293xp.m7912a(this.playerCloudData.getKillStreak())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.kills.fire", new Object[]{String.valueOf(ChatFormatting.GREEN) + C1293xp.m7912a(this.playerCloudData.getFireKills())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.backstabs", new Object[]{String.valueOf(ChatFormatting.GREEN) + C1293xp.m7912a(this.playerCloudData.getBackStabs())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.assists", new Object[]{String.valueOf(ChatFormatting.YELLOW) + C1293xp.m7912a(this.playerCloudData.getAssists())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.noscopes", new Object[]{String.valueOf(ChatFormatting.GREEN) + C1293xp.m7912a(this.playerCloudData.getNoScopes())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.deaths", new Object[]{String.valueOf(ChatFormatting.RED) + C1293xp.m7912a(this.playerCloudData.getDeaths())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.deaths.streak", new Object[]{String.valueOf(ChatFormatting.RED) + C1293xp.m7912a(this.playerCloudData.getDeathStreak())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.fb", new Object[]{String.valueOf(ChatFormatting.DARK_RED) + C1293xp.m7912a(this.playerCloudData.getFirstBloods())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.prestige", new Object[]{String.valueOf(ChatFormatting.YELLOW) + C1293xp.m7912a(this.playerCloudData.getPrestigeLevel())}));
        String strValueOf3 = String.valueOf(ChatFormatting.WHITE);
        Object[] objArr3 = new Object[1];
        objArr3[0] = this.playerCloudData.hasCompletedBootcamp() ? String.valueOf(ChatFormatting.GREEN) + "Yes" : String.valueOf(ChatFormatting.RED) + "No";
        objectArrayList.add(strValueOf3 + I18n.get("bf.message.profile.details.bootcamp", objArr3));
        objectArrayList.add("");
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.infected.rounds.won", new Object[]{String.valueOf(ChatFormatting.RED) + C1293xp.m7912a(this.playerCloudData.getInfectedRoundsWon())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.infected.matches.won", new Object[]{String.valueOf(ChatFormatting.RED) + C1293xp.m7912a(this.playerCloudData.getInfectedMatchesWon())}));
        objectArrayList.add("");
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.kills.bots", new Object[]{String.valueOf(ChatFormatting.BLUE) + C1293xp.m7912a(this.playerCloudData.getBotKills())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.kills.infected", new Object[]{String.valueOf(ChatFormatting.GREEN) + C1293xp.m7912a(this.playerCloudData.getInfectedKills())}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.kills.vehicles", new Object[]{String.valueOf(ChatFormatting.GRAY) + C1293xp.m7912a(this.playerCloudData.getVehicleKills())}));
        objectArrayList.add("");
        objectArrayList.add(String.valueOf(ChatFormatting.RED) + I18n.get("bf.message.profile.details.punishments", new Object[0]));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.punishments.warnings", new Object[]{String.valueOf(ChatFormatting.RED) + this.playerCloudData.getPunishmentCount(PunishmentType.WARNING)}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.punishments.mutes", new Object[]{String.valueOf(ChatFormatting.RED) + this.playerCloudData.getPunishmentCount(PunishmentType.MUTE)}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.punishments.bans.ac", new Object[]{String.valueOf(ChatFormatting.RED) + this.playerCloudData.getPunishmentCount(PunishmentType.BAN_MM)}));
        objectArrayList.add(String.valueOf(ChatFormatting.WHITE) + I18n.get("bf.message.profile.details.punishments.bans.cc", new Object[]{String.valueOf(ChatFormatting.RED) + this.playerCloudData.getPunishmentCount(PunishmentType.BAN_MM)}));
        objectArrayList.add("");
        this.f1712d.m1315c(objectArrayList);
    }
}
