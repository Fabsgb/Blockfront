package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerStatExtra;
import com.boehmod.bflib.cloud.packet.common.server.PacketPlayerDataIncreaseValue;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.tp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tp.class */
public class C1089tp {

    /* JADX INFO: renamed from: rx */
    public static final int f5684rx = 2400;

    /* JADX INFO: renamed from: ry */
    public static final int f5685ry = 100;

    /* JADX INFO: renamed from: rz */
    public static final int f5686rz = 150;

    /* JADX INFO: renamed from: cZ */
    public static final String f5729cZ = "Allies";

    /* JADX INFO: renamed from: da */
    public static final String f5730da = "Axis";

    /* JADX INFO: renamed from: d */
    public static final C1088to f5687d = new C1088to(C0530jN.f3135aO).m6005a(true);

    /* JADX INFO: renamed from: e */
    public static final C1088to f5688e = new C1088to("playedIntro");

    /* JADX INFO: renamed from: f */
    public static final C1088to f5689f = new C1088to("saidGG");

    /* JADX INFO: renamed from: g */
    public static final C1088to f5690g = new C1088to("spawnPro");

    /* JADX INFO: renamed from: h */
    public static final C1088to f5691h = new C1088to("playTime");

    /* JADX INFO: renamed from: i */
    public static final C1088to f5692i = new C1088to("class");

    /* JADX INFO: renamed from: j */
    public static final C1088to f5693j = new C1088to("classIndex");

    /* JADX INFO: renamed from: k */
    public static final C1088to f5694k = new C1088to("classAlive");

    /* JADX INFO: renamed from: l */
    public static final C1088to f5695l = new C1087tn("score", "bf.popup.message.score", 40, ChatFormatting.AQUA);

    /* JADX INFO: renamed from: m */
    public static final C1088to f5696m = new C1088to("itemPickedUp");

    /* JADX INFO: renamed from: n */
    public static final C1088to f5697n = new C1088to("firstBlood").m6005a(true);

    /* JADX INFO: renamed from: o */
    public static final C1088to f5698o = new C1087tn("headShots", "bf.popup.message.headshot", 40, ChatFormatting.GREEN, C1280xc.f7828uz).m6005a(true);

    /* JADX INFO: renamed from: p */
    public static final C1088to f5699p = new C1087tn("noScopes", "bf.popup.message.noscope", 40, ChatFormatting.YELLOW).m6005a(true);

    /* JADX INFO: renamed from: q */
    public static final C1088to f5700q = new C1088to("cpoints");

    /* JADX INFO: renamed from: r */
    public static final C1088to f5701r = new C1088to("healtime");

    /* JADX INFO: renamed from: s */
    public static final C1088to f5702s = new C1088to("points");

    /* JADX INFO: renamed from: t */
    public static final C1088to f5703t = new C1088to("matchKarma").m6005a(true);

    /* JADX INFO: renamed from: u */
    public static final C1088to f5704u = new C1088to("soundboardSounds");

    /* JADX INFO: renamed from: v */
    public static final C1088to f5705v = new C1088to("roundWins");

    /* JADX INFO: renamed from: w */
    public static final C1088to f5706w = new C1088to("radioDelay");

    /* JADX INFO: renamed from: x */
    public static final C1088to f5707x = new C1088to("waypointDelay");

    /* JADX INFO: renamed from: y */
    public static final C1088to f5708y = new C1088to("teamSwitch");

    /* JADX INFO: renamed from: z */
    public static final C1088to f5709z = new C1088to("warCry");

    /* JADX INFO: renamed from: A */
    public static final C1088to f5710A = new C1088to("warCryCommander");

    /* JADX INFO: renamed from: B */
    public static final C1088to f5711B = new C1088to("capturePointSpawn");

    /* JADX INFO: renamed from: C */
    public static final C1088to f5712C = new C1088to("ggStage");

    /* JADX INFO: renamed from: D */
    public static final C1088to f5713D = new C1087tn("kills", "bf.popup.message.kills", 40, ChatFormatting.YELLOW, C1280xc.f7586pR).m6005a(true).m6002a((abstractC0563ju, c1088to, abstractC0787oF, uuid, i, i2, itemStack, i3) -> {
        m6007a(abstractC0563ju, c1088to, abstractC0787oF, uuid, i, itemStack, i3);
    });

    /* JADX INFO: renamed from: E */
    public static final C1088to f5714E = new C1088to("kills_streak").m6005a(true).m6002a((abstractC0563ju, c1088to, abstractC0787oF, uuid, i, i2, itemStack, i3) -> {
        abstractC0563ju.m2520b().sendPacket(new PacketPlayerDataSetValue(uuid, c1088to.getKey(), i2));
    });

    /* JADX INFO: renamed from: F */
    public static final C1088to f5715F = new C1087tn("kills_vehicles", "bf.popup.message.kills.vehicle", 60, ChatFormatting.GREEN, C1280xc.f7586pR).m6005a(true);

    /* JADX INFO: renamed from: G */
    public static final C1088to f5716G = new C1087tn("kills_infected", "bf.popup.message.kills.infected", 40, ChatFormatting.YELLOW, C1280xc.f7586pR).m6005a(true);

    /* JADX INFO: renamed from: H */
    public static final C1088to f5717H = new C1088to("kills_infected_streak").m6005a(true);

    /* JADX INFO: renamed from: I */
    public static final C1088to f5718I = new C1087tn("kills_bots", "bf.popup.message.kills.bots", 40, ChatFormatting.GREEN, C1280xc.f7586pR).m6005a(true);

    /* JADX INFO: renamed from: J */
    public static final C1088to f5719J = new C1088to("kills_bots_streak").m6005a(true);

    /* JADX INFO: renamed from: K */
    public static final C1088to f5720K = new C1087tn("kills_fire", "bf.popup.message.kills.fire", 40, ChatFormatting.GOLD, null).m6005a(true);

    /* JADX INFO: renamed from: L */
    public static final C1088to f5721L = new C1087tn("deaths", "bf.popup.message.deaths", 40, ChatFormatting.RED, C1280xc.f7586pR).m6005a(true);

    /* JADX INFO: renamed from: M */
    public static final C1088to f5722M = new C1087tn("assists", "bf.popup.message.assists", 40, ChatFormatting.AQUA, C1280xc.f7586pR).m6005a(true).m6002a((abstractC0563ju, c1088to, abstractC0787oF, uuid, i, i2, itemStack, i3) -> {
        m6007a(abstractC0563ju, c1088to, abstractC0787oF, uuid, i, itemStack, i3);
    });

    /* JADX INFO: renamed from: N */
    public static final C1088to f5723N = new C1088to("deaths_streak").m6005a(true).m6002a((abstractC0563ju, c1088to, abstractC0787oF, uuid, i, i2, itemStack, i3) -> {
        abstractC0563ju.m2520b().sendPacket(new PacketPlayerDataSetValue(uuid, c1088to.getKey(), i2));
    });

    /* JADX INFO: renamed from: O */
    public static final C1088to f5724O = new C1087tn("backStabs", "bf.popup.message.backstabs", 60, ChatFormatting.RED, C1280xc.f7586pR).m6005a(true).m6002a((abstractC0563ju, c1088to, abstractC0787oF, uuid, i, i2, itemStack, i3) -> {
        m6007a(abstractC0563ju, c1088to, abstractC0787oF, uuid, i, itemStack, i3);
    });

    /* JADX INFO: renamed from: P */
    public static final C1088to f5725P = new C1087tn("infected_rounds_won", "bf.popup.message.infected.rounds.won", 60, ChatFormatting.RED, C1280xc.f7586pR).m6005a(true);

    /* JADX INFO: renamed from: Q */
    public static final C1088to f5726Q = new C1087tn("infected_matches_won", "bf.popup.message.infected.matches.won", 60, ChatFormatting.RED, C1280xc.f7586pR).m6005a(true);

    /* JADX INFO: renamed from: R */
    public static final C1088to f5727R = new C1088to("char");

    /* JADX INFO: renamed from: S */
    public static final C1088to f5728S = new C1088to("trophies").m6005a(true);

    /* JADX INFO: renamed from: jz */
    public static final Component f5731jz = Component.literal(String.valueOf((char) 57348)).withColor(ColorReferences.COLOR_WHITE).append(" ");

    /* JADX INFO: renamed from: a */
    public static void m6007a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull C1088to c1088to, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull UUID uuid, int i, @Nullable ItemStack itemStack, int i2) {
        int iM3854a;
        ServerPlayer serverPlayerM3963a = C0799oR.m3963a(uuid);
        if (serverPlayerM3963a == null) {
            return;
        }
        ItemStack mainHandItem = (itemStack == null || itemStack.isEmpty()) ? serverPlayerM3963a.getMainHandItem() : itemStack;
        String string = null;
        String strName = null;
        if (!mainHandItem.isEmpty()) {
            string = BuiltInRegistries.ITEM.getKey(mainHandItem.getItem()).toString();
            Item item = mainHandItem.getItem();
            if (item instanceof C1144ur) {
                C1144ur c1144ur = (C1144ur) item;
                if (c1144ur.m6420a() != null) {
                    strName = c1144ur.m6420a().name();
                }
            }
        }
        if (i2 != -1) {
            iM3854a = i2;
        } else {
            iM3854a = abstractC0787oF.m3598a(uuid).m3854a(f5694k.getKey(), -1);
        }
        abstractC0563ju.m2520b().sendPacket(new PacketPlayerDataIncreaseValue(new PlayerStatExtra(string, strName, iM3854a), uuid, c1088to.getKey(), i));
    }
}
