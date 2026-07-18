package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000mm.MatchParty;
import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.boehmod.bflib.cloud.packet.common.PacketDailyReward;
import com.boehmod.bflib.cloud.packet.common.discord.PacketDiscordLinkRequest;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nonnull;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dk.class */
public final class C0235dk extends C0234dj {

    /* JADX INFO: renamed from: ey */
    private static final Component f1942ey;

    /* JADX INFO: renamed from: ez */
    private static final Component f1943ez;

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final Set<UUID> f1944f;

    /* JADX INFO: renamed from: gm */
    public static final int f1945gm = 241;

    /* JADX INFO: renamed from: gn */
    public static final int f1946gn = 136;

    /* JADX INFO: renamed from: bx */
    @NotNull
    public static final ResourceLocation f1947bx;

    /* JADX INFO: renamed from: by */
    @Nonnull
    private static final ResourceLocation f1948by;

    /* JADX INFO: renamed from: eA */
    @Nonnull
    private static final Component f1949eA;

    /* JADX INFO: renamed from: bz */
    @Nonnull
    private static final ResourceLocation f1950bz;

    /* JADX INFO: renamed from: eB */
    @Nonnull
    private static final Component f1951eB;

    /* JADX INFO: renamed from: go */
    private static int f1952go;

    /* JADX INFO: renamed from: bq */
    static final /* synthetic */ boolean f1953bq;

    static {
        f1953bq = !C0235dk.class.desiredAssertionStatus();
        f1942ey = Component.translatable("bf.screen.menu.lobby");
        f1943ez = Component.translatable("bf.menu.button.nav.text.lobby");
        f1944f = new ObjectLinkedOpenHashSet();
        f1947bx = C0564jv.m2555d("textures/skins/game/nations/us/infantry/backpack.png");
        f1948by = C0564jv.m2555d("textures/gui/patreon.png");
        f1949eA = Component.translatable("bf.menu.patreon.visit.tooltip").withColor(ColorReferences.COLOR_THEME_PATREON);
        f1950bz = C0564jv.m2555d("textures/gui/discord.png");
        f1951eB = Component.translatable("bf.menu.button.discord.tip").withColor(ColorReferences.COLOR_THEME_DISCORD);
        f1952go = -1;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f1953bq && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft minecraft = Minecraft.getInstance();
        C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
        f1944f.add(c0326fV.m1676a(minecraft).getUUID());
        for (int i = 0; i < 4; i++) {
            UUID uuidRandomUUID = UUID.randomUUID();
            C0324fT c0324fTB = c0326fV.m1135b(uuidRandomUUID);
            C0482iS c0482iSA = c0326fV.mo1137a(uuidRandomUUID);
            c0482iSA.m2182a(PlayerDataType.DISPLAY);
            c0482iSA.setUsername(C0099bQ.f637a.m5976a().m5671ap());
            c0324fTB.m1075a(PlayerDataType.DISPLAY);
            f1944f.add(uuidRandomUUID);
        }
        m1374b(c0326fV);
    }

    public C0235dk() {
        super(f1942ey, f1943ez);
    }

    /* JADX INFO: renamed from: b */
    public static void m1374b(@NotNull C0326fV c0326fV) {
        C0562jt.log("Updating display textures...", new Object[0]);
        C1074ta c1074taM5969a = C1074ta.m5969a("us_airborne");
        Iterator<UUID> it = f1944f.iterator();
        while (it.hasNext()) {
            C0324fT c0324fTB = c0326fV.m1135b(it.next());
            Optional<Pair<C0866pf, C1015sV>> optionalM5979a = c1074taM5969a.m5979a(true);
            if (optionalM5979a.isPresent()) {
                c0324fTB.m1656a(C0564jv.m2555d("textures/skins/game/nations/us/infantry/" + ((C1015sV) optionalM5979a.get().getValue()).getKey() + ".png"), f1947bx);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0234dj, com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        int iIntValue = ((Integer) this.f1585a.m1676a(this.f1587b).getParty().map(matchParty -> {
            return Integer.valueOf(matchParty.getPartyUUIDs().hashCode());
        }).orElse(-1)).intValue();
        if (iIntValue != f1952go) {
            f1952go = iIntValue;
            this.f1587b.setScreen(new C0235dk());
        }
    }

    @Override // com.boehmod.blockfront.C0234dj, com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        m1375Z();
    }

    /* JADX INFO: renamed from: Z */
    private void m1375Z() {
        PacketDailyReward packetDailyRewardM2706b;
        if (this.f1587b.screen != this) {
            return;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b != null && c0622lM2667b.m2704a() != null && (packetDailyRewardM2706b = c0622lM2667b.m2706b()) != null) {
            this.f1587b.setScreen(new C0115bg(this, packetDailyRewardM2706b.streak(), packetDailyRewardM2706b.graced(), packetDailyRewardM2706b.rewards()));
        } else if (C0197cz.f1595aX) {
            this.f1587b.setScreen(new C0197cz(this));
            C0197cz.f1595aX = false;
        }
    }

    @Override // com.boehmod.blockfront.C0234dj, com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: E */
    public void mo775E() {
        super.mo775E();
        int i = this.width / 2;
        int i2 = (this.width - 16) - 7;
        m1376a(i - C0234dj.f1918gc, this.f1585a.m1676a(this.f1587b));
        addRenderableWidget(new C0291en(i2, 56, 16, 16));
        addRenderableWidget(new C0127bs(i2, 75, 16, 16, Component.empty(), button -> {
            C0357g c0357g = (C0357g) this.f1586e.m2667b();
            if (c0357g.m1716a().isConnected()) {
                c0357g.sendPacket(new PacketDiscordLinkRequest());
            }
        }).m651a(f1951eB).m645a(f1950bz).m647a(16, 16).m653a(C0127bs.a.SHADOW).m660e(ColorReferences.COLOR_THEME_DISCORD_SOLID).m666f(ColorReferences.COLOR_THEME_DISCORD_HOVERED_SOLID));
        addRenderableWidget(new C0127bs(i2, 94, 16, 16, Component.empty(), button2 -> {
            C0234dj.m1186b(this.f1587b, C0560jr.f3183aC);
        }).m651a(f1949eA).m645a(f1948by).m647a(16, 16).m653a(C0127bs.a.SHADOW).m660e(ColorReferences.COLOR_THEME_PATREON_SOLID).m666f(ColorReferences.COLOR_THEME_PATREON_HOVERED_SOLID));
    }

    /* JADX INFO: renamed from: a */
    private void m1376a(int i, @NotNull C0482iS c0482iS) {
        Set objectLinkedOpenHashSet;
        int i2 = i + C0238dn.f1978gs;
        Optional<MatchParty> party = c0482iS.getParty();
        if (party.isPresent()) {
            objectLinkedOpenHashSet = new ObjectLinkedOpenHashSet();
            objectLinkedOpenHashSet.addAll(party.get().getPlayers());
        } else {
            objectLinkedOpenHashSet = f1944f;
        }
        int size = f1945gm / objectLinkedOpenHashSet.size();
        int i3 = 0;
        for (UUID uuid : objectLinkedOpenHashSet) {
            addRenderableWidget(new C0292eo(i2 + (size * i3), 56, size, 136, this.f1585a.m1135b(uuid).getUUID().equals(this.f1587b.getUser().getProfileId()), i3, uuid));
            i3++;
        }
    }
}
