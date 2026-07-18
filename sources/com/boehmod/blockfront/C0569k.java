package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000mm.MatchParty;
import com.boehmod.bflib.cloud.common.p000mm.SearchGame;
import com.boehmod.bflib.cloud.common.p000mm.SearchRegion;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMSearch;
import java.net.InetSocketAddress;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ConnectScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.TransferState;
import net.minecraft.client.multiplayer.resolver.ServerAddress;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.k */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/k.class */
public class C0569k {

    /* JADX INFO: renamed from: m */
    private static final int f3227m = 20;

    /* JADX INFO: renamed from: b */
    public float f3231b;

    /* JADX INFO: renamed from: d */
    public float f3233d;

    /* JADX INFO: renamed from: a */
    @Nullable
    private InetSocketAddress f3235a;

    /* JADX INFO: renamed from: m */
    @Nullable
    private String f3236m;

    /* JADX INFO: renamed from: v */
    private boolean f3237v;

    /* JADX INFO: renamed from: u */
    private boolean f3228u = false;

    /* JADX INFO: renamed from: a */
    @NotNull
    public SearchGame f3229a = SearchGame.DOMINATION;

    /* JADX INFO: renamed from: a */
    @NotNull
    public SearchRegion f3230a = SearchRegion.ALL;

    /* JADX INFO: renamed from: c */
    public float f3232c = 0.0f;

    /* JADX INFO: renamed from: e */
    public float f3234e = 0.0f;

    /* JADX INFO: renamed from: n */
    private int f3238n = -1;

    /* JADX INFO: renamed from: a */
    public void m2583a(@NotNull Minecraft minecraft, @Nullable ClientLevel clientLevel, @Nullable LocalPlayer localPlayer, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV) {
        C0482iS c0482iSM1676a = c0326fV.m1676a(minecraft);
        boolean zIsSearching = this.f3228u;
        Optional<MatchParty> party = c0482iSM1676a.getParty();
        if (party.isPresent()) {
            zIsSearching = party.get().isSearching();
        }
        if (this.f3228u != zIsSearching) {
            this.f3228u = zIsSearching;
        }
        this.f3234e = this.f3233d;
        this.f3233d = C1290xm.m7856g(this.f3233d, this.f3228u ? 1.0f : 0.0f, 0.1f);
        m2588b(minecraft, clientLevel, localPlayer, c0622l, c0326fV);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public SearchGame m2584a() {
        return this.f3229a;
    }

    /* JADX INFO: renamed from: a */
    public void m2585a(@NotNull SearchGame searchGame) {
        this.f3229a = searchGame;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public SearchRegion m2586a() {
        return this.f3230a;
    }

    /* JADX INFO: renamed from: a */
    public void m2587a(@NotNull SearchRegion searchRegion) {
        this.f3230a = searchRegion;
    }

    /* JADX INFO: renamed from: b */
    private void m2588b(@NotNull Minecraft minecraft, @Nullable ClientLevel clientLevel, @Nullable LocalPlayer localPlayer, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV) {
        this.f3232c = this.f3231b;
        if (this.f3238n >= 0) {
            int i = this.f3238n - 1;
            this.f3238n = i;
            if (i < 0) {
                m2590a(minecraft, c0622l);
            }
        }
        if (this.f3237v) {
            if (localPlayer != null && localPlayer.connection.getServerData() != null) {
                Connection connection = localPlayer.connection.getConnection();
                connection.disconnect(Component.empty());
                connection.setReadOnly();
                connection.handleDisconnection();
                m2589a(minecraft, clientLevel, c0622l, c0326fV);
            }
            if (this.f3237v && this.f3231b >= 1.0f) {
                m2589a(minecraft, clientLevel, c0622l, c0326fV);
            }
        }
        boolean z = this.f3237v || this.f3238n >= 0;
        this.f3231b = C1290xm.m7835d(this.f3231b, z ? 1.0f : 0.0f, z ? 0.05f : 0.025f);
    }

    /* JADX INFO: renamed from: a */
    private void m2589a(@NotNull Minecraft minecraft, @Nullable ClientLevel clientLevel, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV) {
        if (this.f3237v) {
            this.f3237v = false;
            if (this.f3235a == null) {
                C0562jt.log("Failed to join MM game due to missing server address or match UUID", new Object[0]);
                return;
            }
            if (clientLevel != null) {
                clientLevel.disconnect();
                c0622l.m2693a(minecraft, c0326fV, clientLevel, (AbstractC0787oF<?, ?, ?>) null);
            }
            this.f3238n = ThreadLocalRandom.current().nextInt(21);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2590a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l) {
        m2598a(false);
        if (this.f3235a == null || c0622l.m2688a() != null) {
            return;
        }
        String hostString = this.f3235a.getHostString();
        int port = this.f3235a.getPort();
        C0562jt.log("Joining MM game on address '" + hostString + ":" + port + "'", new Object[0]);
        ServerData serverData = new ServerData("mm-server", "", ServerData.Type.OTHER);
        ConnectScreen.startConnecting(new C0235dk(), minecraft, new ServerAddress(hostString, port), serverData, false, (TransferState) null);
    }

    /* JADX INFO: renamed from: a */
    public void m2591a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull InetSocketAddress inetSocketAddress) {
        SoundManager soundManager = minecraft.getSoundManager();
        this.f3235a = inetSocketAddress;
        C0326fV c0326fV = (C0326fV) c0622l.m2670a();
        C0482iS c0482iSM1676a = c0326fV.m1676a(minecraft);
        if (this.f3236m != null) {
            C0287ej.m1507a(minecraft, (Component) Component.translatable("bf.message.friend.mm.match.join", new Object[]{this.f3236m}));
            this.f3236m = null;
        } else {
            c0482iSM1676a.getParty().ifPresent(matchParty -> {
                C0287ej.m1507a(minecraft, (Component) Component.translatable("bf.message.party.mm.match.new", new Object[]{c0326fV.mo1137a(matchParty.getHost()).getUsername()}));
            });
        }
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7552pj.get(), 1.0f));
        this.f3237v = true;
    }

    /* JADX INFO: renamed from: b */
    public void m2592b(@Nullable String str) {
        this.f3236m = str;
    }

    /* JADX INFO: renamed from: c */
    public void m2593c() {
        this.f3237v = false;
        this.f3235a = null;
        this.f3238n = -1;
        this.f3236m = null;
    }

    /* JADX INFO: renamed from: b */
    public boolean m2594b() {
        return this.f3237v || this.f3238n >= 0;
    }

    /* JADX INFO: renamed from: b */
    public float m2595b(float f) {
        return C1290xm.m7843e(this.f3231b, this.f3232c, f);
    }

    /* JADX INFO: renamed from: c */
    public float m2596c(float f) {
        return C1290xm.m7843e(this.f3233d, this.f3234e, f);
    }

    /* JADX INFO: renamed from: c */
    public boolean m2597c() {
        return this.f3228u;
    }

    /* JADX INFO: renamed from: a */
    public void m2598a(boolean z) {
        this.f3228u = z;
    }

    /* JADX INFO: renamed from: b */
    public void m2599b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l) {
        C0326fV c0326fV = (C0326fV) c0622l.m2670a();
        C0482iS c0482iSM1676a = c0326fV.m1676a(minecraft);
        C0357g c0357g = (C0357g) c0622l.m2667b();
        SoundManager soundManager = minecraft.getSoundManager();
        C0562jt.log("Attempting to search for game...", new Object[0]);
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7550ph.get(), 1.0f));
        if (!c0482iSM1676a.hasCompletedBootcamp()) {
            m2585a(C1016sW.f5343b.m5534a());
        }
        ((C0357g) c0622l.m2667b()).m1718a(c0326fV, minecraft, c0622l);
        c0357g.sendPacket(new PacketMMSearch(m2584a(), m2586a()));
        m2598a(true);
    }
}
