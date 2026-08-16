package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerStatExtra;
import com.boehmod.bflib.cloud.packet.common.server.PacketPlayerDataSetValue;
import com.boehmod.bflib.common.ColorReferences;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.tN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tN.class */
public class C1062tN {

    /* JADX INFO: renamed from: tA */
    public static final int f5737tA = 2400;

    /* JADX INFO: renamed from: tB */
    public static final int f5738tB = 100;

    /* JADX INFO: renamed from: tC */
    public static final int f5739tC = 150;

    /* JADX INFO: renamed from: dk */
    public static final String f5782dk = "Allies";

    /* JADX INFO: renamed from: dl */
    public static final String f5783dl = "Axis";

    /* JADX INFO: renamed from: d */
    public static final C1060tL f5740d = new C1060tL(C0606kj.f3513aX).m5885a(true);

    /* JADX INFO: renamed from: e */
    public static final C1060tL f5741e = new C1060tL("playedIntro");

    /* JADX INFO: renamed from: f */
    public static final C1060tL f5742f = new C1060tL("saidGG");

    /* JADX INFO: renamed from: g */
    public static final C1060tL f5743g = new C1060tL("spawnPro");

    /* JADX INFO: renamed from: h */
    public static final C1060tL f5744h = new C1060tL("playTime");

    /* JADX INFO: renamed from: i */
    public static final C1060tL f5745i = new C1060tL("class");

    /* JADX INFO: renamed from: j */
    public static final C1060tL f5746j = new C1060tL("classIndex");

    /* JADX INFO: renamed from: k */
    public static final C1060tL f5747k = new C1060tL("classAlive");

    /* JADX INFO: renamed from: l */
    public static final C1060tL f5748l = new C1059tK("score", "bf.popup.message.score", 40, ChatFormatting.AQUA);

    /* JADX INFO: renamed from: m */
    public static final C1060tL f5749m = new C1060tL("itemPickedUp");

    /* JADX INFO: renamed from: n */
    public static final C1060tL f5750n = new C1060tL("firstBlood").m5885a(true);

    /* JADX INFO: renamed from: o */
    public static final C1060tL f5751o = new C1059tK("headShots", "bf.popup.message.headshot", 40, ChatFormatting.GREEN, C1312xz.f8241uC).m5885a(true);

    /* JADX INFO: renamed from: p */
    public static final C1060tL f5752p = new C1059tK("noScopes", "bf.popup.message.noscope", 40, ChatFormatting.YELLOW).m5885a(true);

    /* JADX INFO: renamed from: q */
    public static final C1060tL f5753q = new C1060tL("cpoints");

    /* JADX INFO: renamed from: r */
    public static final C1060tL f5754r = new C1060tL("healtime");

    /* JADX INFO: renamed from: s */
    public static final C1060tL f5755s = new C1060tL("points");

    /* JADX INFO: renamed from: t */
    public static final C1060tL f5756t = new C1060tL("matchKarma").m5885a(true);

    /* JADX INFO: renamed from: u */
    public static final C1060tL f5757u = new C1060tL("soundboardSounds");

    /* JADX INFO: renamed from: v */
    public static final C1060tL f5758v = new C1060tL("roundWins");

    /* JADX INFO: renamed from: w */
    public static final C1060tL f5759w = new C1060tL("radioDelay");

    /* JADX INFO: renamed from: x */
    public static final C1060tL f5760x = new C1060tL("waypointDelay");

    /* JADX INFO: renamed from: y */
    public static final C1060tL f5761y = new C1060tL("teamSwitch");

    /* JADX INFO: renamed from: z */
    public static final C1060tL f5762z = new C1060tL("warCry");

    /* JADX INFO: renamed from: A */
    public static final C1060tL f5763A = new C1060tL("warCryCommander");

    /* JADX INFO: renamed from: B */
    public static final C1060tL f5764B = new C1060tL("capturePointSpawn");

    /* JADX INFO: renamed from: C */
    public static final C1060tL f5765C = new C1060tL("ggStage");

    /* JADX INFO: renamed from: D */
    public static final C1060tL f5766D = new C1059tK("kills", "bf.popup.message.kills", 40, ChatFormatting.YELLOW, C1312xz.f7998pT).m5885a(true).m5882a((abstractC0531jN, c1060tL, abstractC0863pb, uuid, i, i2, itemStack, i3) -> {
        m5893a(abstractC0531jN, c1060tL, abstractC0863pb, uuid, i, itemStack, i3);
    });

    /* JADX INFO: renamed from: E */
    public static final C1060tL f5767E = new C1060tL("kills_streak").m5885a(true).m5882a((abstractC0531jN, c1060tL, abstractC0863pb, uuid, i, i2, itemStack, i3) -> {
        abstractC0531jN.m2342b().sendPacket(new PacketPlayerDataSetValue(uuid, c1060tL.getKey(), i2));
    });

    /* JADX INFO: renamed from: F */
    public static final C1060tL f5768F = new C1059tK("kills_vehicles", "bf.popup.message.kills.vehicle", 60, ChatFormatting.GREEN, C1312xz.f7998pT).m5885a(true);

    /* JADX INFO: renamed from: G */
    public static final C1060tL f5769G = new C1059tK("kills_infected", "bf.popup.message.kills.infected", 40, ChatFormatting.YELLOW, C1312xz.f7998pT).m5885a(true);

    /* JADX INFO: renamed from: H */
    public static final C1060tL f5770H = new C1060tL("kills_infected_streak").m5885a(true);

    /* JADX INFO: renamed from: I */
    public static final C1060tL f5771I = new C1059tK("kills_bots", "bf.popup.message.kills.bots", 40, ChatFormatting.GREEN, C1312xz.f7998pT).m5885a(true);

    /* JADX INFO: renamed from: J */
    public static final C1060tL f5772J = new C1060tL("kills_bots_streak").m5885a(true);

    /* JADX INFO: renamed from: K */
    public static final C1060tL f5773K = new C1059tK("kills_fire", "bf.popup.message.kills.fire", 40, ChatFormatting.GOLD, null).m5885a(true);

    /* JADX INFO: renamed from: L */
    public static final C1060tL f5774L = new C1059tK("deaths", "bf.popup.message.deaths", 40, ChatFormatting.RED, C1312xz.f7998pT).m5885a(true);

    /* JADX INFO: renamed from: M */
    public static final C1060tL f5775M = new C1059tK("assists", "bf.popup.message.assists", 40, ChatFormatting.AQUA, C1312xz.f7998pT).m5885a(true).m5882a((abstractC0531jN, c1060tL, abstractC0863pb, uuid, i, i2, itemStack, i3) -> {
        m5893a(abstractC0531jN, c1060tL, abstractC0863pb, uuid, i, itemStack, i3);
    });

    /* JADX INFO: renamed from: N */
    public static final C1060tL f5776N = new C1060tL("deaths_streak").m5885a(true).m5882a((abstractC0531jN, c1060tL, abstractC0863pb, uuid, i, i2, itemStack, i3) -> {
        abstractC0531jN.m2342b().sendPacket(new PacketPlayerDataSetValue(uuid, c1060tL.getKey(), i2));
    });

    /* JADX INFO: renamed from: O */
    public static final C1060tL f5777O = new C1059tK("backStabs", "bf.popup.message.backstabs", 60, ChatFormatting.RED, C1312xz.f7998pT).m5885a(true).m5882a((abstractC0531jN, c1060tL, abstractC0863pb, uuid, i, i2, itemStack, i3) -> {
        m5893a(abstractC0531jN, c1060tL, abstractC0863pb, uuid, i, itemStack, i3);
    });

    /* JADX INFO: renamed from: P */
    public static final C1060tL f5778P = new C1059tK("infected_rounds_won", "bf.popup.message.infected.rounds.won", 60, ChatFormatting.RED, C1312xz.f7998pT).m5885a(true);

    /* JADX INFO: renamed from: Q */
    public static final C1060tL f5779Q = new C1059tK("infected_matches_won", "bf.popup.message.infected.matches.won", 60, ChatFormatting.RED, C1312xz.f7998pT).m5885a(true);

    /* JADX INFO: renamed from: R */
    public static final C1060tL f5780R = new C1060tL("char");

    /* JADX INFO: renamed from: S */
    public static final C1060tL f5781S = new C1060tL("trophies").m5885a(true);

    /* JADX INFO: renamed from: jM */
    public static final Component f5784jM = Component.literal(String.valueOf((char) 57348)).withColor(ColorReferences.COLOR_WHITE).append(" ");

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static void m5893a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull C1060tL c1060tL, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull UUID uuid, int i, @Nullable ItemStack itemStack, int i2) {
        int iM4290a;
        ServerPlayer serverPlayerM4399a = C0875pn.m4399a(uuid);
        if (serverPlayerM4399a == null) {
            return;
        }
        ItemStack mainHandItem = (itemStack == null || itemStack.isEmpty()) ? serverPlayerM4399a.getMainHandItem() : itemStack;
        String string = null;
        String strName = null;
        if (!mainHandItem.isEmpty()) {
            string = BuiltInRegistries.ITEM.getKey(mainHandItem.getItem()).toString();
            Item item = mainHandItem.getItem();
            if (item instanceof C1117uP) {
                C1117uP c1117uP = (C1117uP) item;
                if (c1117uP.m6398a() != null) {
                    strName = c1117uP.m6398a().name();
                }
            }
        }
        if (i2 != -1) {
            iM4290a = i2;
        } else {
            iM4290a = abstractC0863pb.m4034a(uuid).m4290a(f5747k.getKey(), -1);
        }
        abstractC0531jN.m2343a().m5887a(uuid, c1060tL.getKey(), i, new PlayerStatExtra(string, strName, iM4290a));
    }
}
