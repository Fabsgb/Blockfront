package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p001mm.MatchParty;
import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.boehmod.bflib.cloud.packet.common.PacketDailyReward;
import com.boehmod.bflib.cloud.packet.common.discord.PacketDiscordLinkRequest;
import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dt.class */
public final class C0245dt extends C0244ds {

    /* JADX INFO: renamed from: eB */
    private static final Component f2003eB;

    /* JADX INFO: renamed from: eC */
    private static final Component f2004eC;

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final Set<UUID> f2005e;

    /* JADX INFO: renamed from: hm */
    public static final int f2006hm = 241;

    /* JADX INFO: renamed from: hn */
    public static final int f2007hn = 136;

    /* JADX INFO: renamed from: bv */
    @NotNull
    public static final ResourceLocation f2008bv;

    /* JADX INFO: renamed from: bw */
    @Nonnull
    private static final ResourceLocation f2009bw;

    /* JADX INFO: renamed from: eD */
    @Nonnull
    private static final Component f2010eD;

    /* JADX INFO: renamed from: bx */
    @Nonnull
    private static final ResourceLocation f2011bx;

    /* JADX INFO: renamed from: eE */
    @Nonnull
    private static final Component f2012eE;

    /* JADX INFO: renamed from: ho */
    private static int f2013ho;

    /* JADX INFO: renamed from: bu */
    static final /* synthetic */ boolean f2014bu;

    static {
        f2014bu = !C0245dt.class.desiredAssertionStatus();
        f2003eB = Component.translatable("bf.screen.menu.lobby");
        f2004eC = Component.translatable("bf.menu.button.nav.text.lobby");
        f2005e = new ObjectLinkedOpenHashSet();
        f2008bv = C0532jO.m2378d("textures/skins/game/nations/us/infantry/backpack.png");
        f2009bw = C0532jO.m2378d("textures/gui/patreon.png");
        f2010eD = Component.translatable("bf.menu.patreon.visit.tooltip").withColor(ColorReferences.COLOR_THEME_PATREON);
        f2011bx = C0532jO.m2378d("textures/gui/discord.png");
        f2012eE = Component.translatable("bf.menu.button.discord.tip").withColor(ColorReferences.COLOR_THEME_DISCORD);
        f2013ho = -1;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2014bu && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft minecraft = Minecraft.getInstance();
        C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
        f2005e.add(c0396gl.m1886a(minecraft).getUUID());
        for (int i = 0; i < 4; i++) {
            UUID uuidRandomUUID = UUID.randomUUID();
            C0394gj c0394gjB = c0396gl.m1152b(uuidRandomUUID);
            C0555jl c0555jlA = c0396gl.mo1154a(uuidRandomUUID);
            c0555jlA.m2509a(PlayerDataType.DISPLAY);
            c0555jlA.setUsername(C0109bZ.f706a.m6179a().m6159aw());
            c0394gjB.m1092a(PlayerDataType.DISPLAY);
            f2005e.add(uuidRandomUUID);
        }
        m1401b(c0396gl);
    }

    public C0245dt() {
        super(f2003eB, f2004eC);
    }

    /* JADX INFO: renamed from: b */
    public static void m1401b(@NotNull C0396gl c0396gl) {
        C0530jM.log("Updating display textures...", new Object[0]);
        C1098tx c1098txM6172a = C1098tx.m6172a("us_airborne");
        Iterator<UUID> it = f2005e.iterator();
        while (it.hasNext()) {
            C0394gj c0394gjB = c0396gl.m1152b(it.next());
            Optional<Pair<C0837pB, C1093ts>> optionalM6182a = c1098txM6172a.m6182a(true);
            if (optionalM6182a.isPresent()) {
                c0394gjB.m1866a(C0532jO.m2378d("textures/skins/game/nations/us/infantry/" + ((C1093ts) optionalM6182a.get().getValue()).getKey() + ".png"), f2008bv);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0244ds, com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        int iIntValue = ((Integer) this.f1056a.m1886a(this.f1058a).getParty().map(matchParty -> {
            return Integer.valueOf(matchParty.getPartyUUIDs().hashCode());
        }).orElse(-1)).intValue();
        if (iIntValue != f2013ho) {
            f2013ho = iIntValue;
            this.f1058a.setScreen(new C0245dt());
        }
    }

    @Override // com.boehmod.blockfront.C0244ds, com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        m1402ad();
    }

    /* JADX INFO: renamed from: ad */
    private void m1402ad() {
        PacketDailyReward packetDailyRewardM2892b;
        if (this.f1058a.screen != this) {
            return;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b != null && c0623lM2852b.m2890a() != null && (packetDailyRewardM2892b = c0623lM2852b.m2892b()) != null) {
            this.f1058a.setScreen(new C0124bo(this, packetDailyRewardM2892b.streak(), packetDailyRewardM2892b.graced(), packetDailyRewardM2892b.rewards()));
        } else if (C0145cI.f1066bb) {
            this.f1058a.setScreen(new C0145cI(this));
            C0145cI.f1066bb = false;
        }
    }

    @Override // com.boehmod.blockfront.C0244ds, com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        super.mo777H();
        int i = this.width / 2;
        int i2 = (this.width - 16) - 7;
        m1403a(i - C0244ds.f1978hc, this.f1056a.m1886a(this.f1058a));
        addRenderableWidget(new C0253eA(i2, 56, 16, 16));
        addRenderableWidget(new C0085bB(i2, 75, 16, 16, Component.empty(), button -> {
            C0358g c0358g = (C0358g) this.f1057f.m2852b();
            if (c0358g.m1722a().isConnected()) {
                c0358g.sendPacket(new PacketDiscordLinkRequest());
            }
        }).m326a(f2012eE).m320a(f2011bx).m322a(16, 16).m328a(C0085bB.a.SHADOW).m335e(ColorReferences.COLOR_THEME_DISCORD_SOLID).m341f(ColorReferences.COLOR_THEME_DISCORD_HOVERED_SOLID));
        addRenderableWidget(new C0085bB(i2, 94, 16, 16, Component.empty(), button2 -> {
            C0244ds.m784b(this.f1058a, C0528jK.f3166aI);
        }).m326a(f2010eD).m320a(f2009bw).m322a(16, 16).m328a(C0085bB.a.SHADOW).m335e(ColorReferences.COLOR_THEME_PATREON_SOLID).m341f(ColorReferences.COLOR_THEME_PATREON_HOVERED_SOLID));
    }

    /* JADX INFO: renamed from: a */
    private void m1403a(int i, @NotNull C0555jl c0555jl) {
        Set objectLinkedOpenHashSet;
        int i2 = i + C0248dw.f2042hx;
        Optional<MatchParty> party = c0555jl.getParty();
        if (party.isPresent()) {
            objectLinkedOpenHashSet = new ObjectLinkedOpenHashSet();
            objectLinkedOpenHashSet.addAll(party.get().getPlayers());
        } else {
            objectLinkedOpenHashSet = f2005e;
        }
        int size = f2006hm / objectLinkedOpenHashSet.size();
        int i3 = 0;
        for (UUID uuid : objectLinkedOpenHashSet) {
            addRenderableWidget(new C0254eB(i2 + (size * i3), 56, size, 136, this.f1056a.m1152b(uuid).getUUID().equals(this.f1058a.getUser().getProfileId()), i3, uuid));
            i3++;
        }
    }
}
