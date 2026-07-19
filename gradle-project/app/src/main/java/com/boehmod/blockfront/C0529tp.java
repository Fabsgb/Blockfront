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

/* JADX INFO: renamed from: com.boehmod.blockfront.tp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tp.class */
public class C0529tp {
    public static final int rx = 2400;
    public static final int ry = 100;
    public static final int rz = 150;
    public static final String cZ = "Allies";
    public static final String da = "Axis";
    public static final C0528to d = new C0528to(jN.aO).a(true);
    public static final C0528to e = new C0528to("playedIntro");
    public static final C0528to f = new C0528to("saidGG");
    public static final C0528to g = new C0528to("spawnPro");
    public static final C0528to h = new C0528to("playTime");
    public static final C0528to i = new C0528to("class");
    public static final C0528to j = new C0528to("classIndex");
    public static final C0528to k = new C0528to("classAlive");
    public static final C0528to l = new C0527tn("score", "bf.popup.message.score", 40, ChatFormatting.AQUA);
    public static final C0528to m = new C0528to("itemPickedUp");
    public static final C0528to n = new C0528to("firstBlood").a(true);
    public static final C0528to o = new C0527tn("headShots", "bf.popup.message.headshot", 40, ChatFormatting.GREEN, C0624xc.uz).a(true);
    public static final C0528to p = new C0527tn("noScopes", "bf.popup.message.noscope", 40, ChatFormatting.YELLOW).a(true);
    public static final C0528to q = new C0528to("cpoints");
    public static final C0528to r = new C0528to("healtime");
    public static final C0528to s = new C0528to("points");
    public static final C0528to t = new C0528to("matchKarma").a(true);
    public static final C0528to u = new C0528to("soundboardSounds");
    public static final C0528to v = new C0528to("roundWins");
    public static final C0528to w = new C0528to("radioDelay");
    public static final C0528to x = new C0528to("waypointDelay");
    public static final C0528to y = new C0528to("teamSwitch");
    public static final C0528to z = new C0528to("warCry");
    public static final C0528to A = new C0528to("warCryCommander");
    public static final C0528to B = new C0528to("capturePointSpawn");
    public static final C0528to C = new C0528to("ggStage");
    public static final C0528to D = new C0527tn("kills", "bf.popup.message.kills", 40, ChatFormatting.YELLOW, C0624xc.pR).a(true).a((abstractC0264ju, c0528to, oFVar, uuid, i2, i3, itemStack, i4) -> {
        a(abstractC0264ju, c0528to, oFVar, uuid, i2, itemStack, i4);
    });
    public static final C0528to E = new C0528to("kills_streak").a(true).a((abstractC0264ju, c0528to, oFVar, uuid, i2, i3, itemStack, i4) -> {
        abstractC0264ju.m529b().sendPacket(new PacketPlayerDataSetValue(uuid, c0528to.getKey(), i3));
    });
    public static final C0528to F = new C0527tn("kills_vehicles", "bf.popup.message.kills.vehicle", 60, ChatFormatting.GREEN, C0624xc.pR).a(true);
    public static final C0528to G = new C0527tn("kills_infected", "bf.popup.message.kills.infected", 40, ChatFormatting.YELLOW, C0624xc.pR).a(true);
    public static final C0528to H = new C0528to("kills_infected_streak").a(true);
    public static final C0528to I = new C0527tn("kills_bots", "bf.popup.message.kills.bots", 40, ChatFormatting.GREEN, C0624xc.pR).a(true);
    public static final C0528to J = new C0528to("kills_bots_streak").a(true);
    public static final C0528to K = new C0527tn("kills_fire", "bf.popup.message.kills.fire", 40, ChatFormatting.GOLD, null).a(true);
    public static final C0528to L = new C0527tn("deaths", "bf.popup.message.deaths", 40, ChatFormatting.RED, C0624xc.pR).a(true);
    public static final C0528to M = new C0527tn("assists", "bf.popup.message.assists", 40, ChatFormatting.AQUA, C0624xc.pR).a(true).a((abstractC0264ju, c0528to, oFVar, uuid, i2, i3, itemStack, i4) -> {
        a(abstractC0264ju, c0528to, oFVar, uuid, i2, itemStack, i4);
    });
    public static final C0528to N = new C0528to("deaths_streak").a(true).a((abstractC0264ju, c0528to, oFVar, uuid, i2, i3, itemStack, i4) -> {
        abstractC0264ju.m529b().sendPacket(new PacketPlayerDataSetValue(uuid, c0528to.getKey(), i3));
    });
    public static final C0528to O = new C0527tn("backStabs", "bf.popup.message.backstabs", 60, ChatFormatting.RED, C0624xc.pR).a(true).a((abstractC0264ju, c0528to, oFVar, uuid, i2, i3, itemStack, i4) -> {
        a(abstractC0264ju, c0528to, oFVar, uuid, i2, itemStack, i4);
    });
    public static final C0528to P = new C0527tn("infected_rounds_won", "bf.popup.message.infected.rounds.won", 60, ChatFormatting.RED, C0624xc.pR).a(true);
    public static final C0528to Q = new C0527tn("infected_matches_won", "bf.popup.message.infected.matches.won", 60, ChatFormatting.RED, C0624xc.pR).a(true);
    public static final C0528to R = new C0528to("char");
    public static final C0528to S = new C0528to("trophies").a(true);
    public static final Component jz = Component.literal(String.valueOf((char) 57348)).withColor(ColorReferences.COLOR_WHITE).append(" ");

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull C0528to c0528to, @NotNull oF<?, ?, ?> oFVar, @NotNull UUID uuid, int i2, @Nullable ItemStack itemStack, int i3) {
        int iA;
        ServerPlayer serverPlayerA = oR.a(uuid);
        if (serverPlayerA == null) {
            return;
        }
        ItemStack mainHandItem = (itemStack == null || itemStack.isEmpty()) ? serverPlayerA.getMainHandItem() : itemStack;
        String string = null;
        String strName = null;
        if (!mainHandItem.isEmpty()) {
            string = BuiltInRegistries.ITEM.getKey(mainHandItem.getItem()).toString();
            Item item = mainHandItem.getItem();
            if (item instanceof C0558ur) {
                C0558ur c0558ur = (C0558ur) item;
                if (c0558ur.m1226a() != null) {
                    strName = c0558ur.m1226a().name();
                }
            }
        }
        if (i3 != -1) {
            iA = i3;
        } else {
            iA = oFVar.a(uuid).a(k.getKey(), -1);
        }
        abstractC0264ju.m529b().sendPacket(new PacketPlayerDataIncreaseValue(new PlayerStatExtra(string, strName, iA), uuid, c0528to.getKey(), i2));
    }
}
