package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.mm.MatchParty;
import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.boehmod.bflib.cloud.packet.common.PacketDailyReward;
import com.boehmod.bflib.cloud.packet.common.discord.PacketDiscordLinkRequest;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dk.class */
public final class C0094dk extends C0093dj {
    private static final Component ey;
    private static final Component ez;

    @NotNull
    private static final Set<UUID> f;
    public static final int gm = 241;
    public static final int gn = 136;

    @NotNull
    public static final ResourceLocation bx;

    @Nonnull
    private static final ResourceLocation by;

    @Nonnull
    private static final Component eA;

    @Nonnull
    private static final ResourceLocation bz;

    @Nonnull
    private static final Component eB;
    private static int go;
    static final /* synthetic */ boolean bq;

    static {
        bq = !C0094dk.class.desiredAssertionStatus();
        ey = Component.translatable("bf.screen.menu.lobby");
        ez = Component.translatable("bf.menu.button.nav.text.lobby");
        f = new ObjectLinkedOpenHashSet();
        bx = C0265jv.d("textures/skins/game/nations/us/infantry/backpack.png");
        by = C0265jv.d("textures/gui/patreon.png");
        eA = Component.translatable("bf.menu.patreon.visit.tooltip").withColor(ColorReferences.COLOR_THEME_PATREON);
        bz = C0265jv.d("textures/gui/discord.png");
        eB = Component.translatable("bf.menu.button.discord.tip").withColor(ColorReferences.COLOR_THEME_DISCORD);
        go = -1;
        C0297l c0297lB = C0297l.b();
        if (!bq && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft minecraft = Minecraft.getInstance();
        fV fVVar = (fV) c0297lB.a();
        f.add(fVVar.m404a(minecraft).getUUID());
        for (int i = 0; i < 4; i++) {
            UUID uuidRandomUUID = UUID.randomUUID();
            fT fTVarB = fVVar.b(uuidRandomUUID);
            iS iSVarA = fVVar.mo306a(uuidRandomUUID);
            iSVarA.a(PlayerDataType.DISPLAY);
            iSVarA.setUsername(bQ.a.m1156a().ap());
            fTVarB.a(PlayerDataType.DISPLAY);
            f.add(uuidRandomUUID);
        }
        b(fVVar);
    }

    public C0094dk() {
        super(ey, ez);
    }

    public static void b(@NotNull fV fVVar) {
        C0263jt.log("Updating display textures...", new Object[0]);
        C0514ta c0514taA = C0514ta.a("us_airborne");
        Iterator<UUID> it = f.iterator();
        while (it.hasNext()) {
            fT fTVarB = fVVar.b(it.next());
            Optional<Pair<C0411pf, sV>> optionalA = c0514taA.a(true);
            if (optionalA.isPresent()) {
                fTVarB.a(C0265jv.d("textures/skins/game/nations/us/infantry/" + ((sV) optionalA.get().getValue()).getKey() + ".png"), bx);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0093dj, com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f2) {
        super.render(guiGraphics, i, i2, f2);
        int iIntValue = ((Integer) this.a.m404a(this.b).getParty().map(matchParty -> {
            return Integer.valueOf(matchParty.getPartyUUIDs().hashCode());
        }).orElse(-1)).intValue();
        if (iIntValue != go) {
            go = iIntValue;
            this.b.setScreen(new C0094dk());
        }
    }

    @Override // com.boehmod.blockfront.C0093dj, com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        Z();
    }

    private void Z() {
        PacketDailyReward packetDailyRewardM601b;
        if (this.b.screen != this) {
            return;
        }
        C0297l c0297lB = C0297l.b();
        if (c0297lB != null && c0297lB.m600a() != null && (packetDailyRewardM601b = c0297lB.m601b()) != null) {
            this.b.setScreen(new C0036bg(this, packetDailyRewardM601b.streak(), packetDailyRewardM601b.graced(), packetDailyRewardM601b.rewards()));
        } else if (C0082cz.aX) {
            this.b.setScreen(new C0082cz(this));
            C0082cz.aX = false;
        }
    }

    @Override // com.boehmod.blockfront.C0093dj, com.boehmod.blockfront.C0080cx
    public void E() {
        super.E();
        int i = this.width / 2;
        int i2 = (this.width - 16) - 7;
        a(i - C0093dj.gc, this.a.m404a(this.b));
        addRenderableWidget(new C0123en(i2, 56, 16, 16));
        addRenderableWidget(new C0048bs(i2, 75, 16, 16, Component.empty(), button -> {
            C0163g c0163g = (C0163g) this.e.b();
            if (c0163g.a().isConnected()) {
                c0163g.sendPacket(new PacketDiscordLinkRequest());
            }
        }).a(eB).a(bz).a(16, 16).a(C0048bs.a.SHADOW).e(ColorReferences.COLOR_THEME_DISCORD_SOLID).f(ColorReferences.COLOR_THEME_DISCORD_HOVERED_SOLID));
        addRenderableWidget(new C0048bs(i2, 94, 16, 16, Component.empty(), button2 -> {
            C0093dj.b(this.b, C0261jr.aC);
        }).a(eA).a(by).a(16, 16).a(C0048bs.a.SHADOW).e(ColorReferences.COLOR_THEME_PATREON_SOLID).f(ColorReferences.COLOR_THEME_PATREON_HOVERED_SOLID));
    }

    private void a(int i, @NotNull iS iSVar) {
        Set objectLinkedOpenHashSet;
        int i2 = i + C0097dn.gs;
        Optional<MatchParty> party = iSVar.getParty();
        if (party.isPresent()) {
            objectLinkedOpenHashSet = new ObjectLinkedOpenHashSet();
            objectLinkedOpenHashSet.addAll(party.get().getPlayers());
        } else {
            objectLinkedOpenHashSet = f;
        }
        int size = gm / objectLinkedOpenHashSet.size();
        int i3 = 0;
        for (UUID uuid : objectLinkedOpenHashSet) {
            addRenderableWidget(new C0124eo(i2 + (size * i3), 56, size, 136, this.a.b(uuid).getUUID().equals(this.b.getUser().getProfileId()), i3, uuid));
            i3++;
        }
    }
}
