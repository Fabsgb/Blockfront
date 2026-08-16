package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p001mm.MatchParty;
import com.boehmod.bflib.cloud.common.p001mm.SearchGame;
import com.boehmod.bflib.cloud.common.p001mm.SearchRegion;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMSearch;
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
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/k.class */
public class C0570k {

    /* JADX INFO: renamed from: o */
    private static final int f3328o = 20;

    /* JADX INFO: renamed from: b */
    public float f3332b;

    /* JADX INFO: renamed from: d */
    public float f3334d;

    /* JADX INFO: renamed from: a */
    @Nullable
    private InetSocketAddress f3336a;

    /* JADX INFO: renamed from: n */
    @Nullable
    private String f3337n;

    /* JADX INFO: renamed from: w */
    private boolean f3338w;

    /* JADX INFO: renamed from: v */
    private boolean f3329v = false;

    /* JADX INFO: renamed from: a */
    @NotNull
    public SearchGame f3330a = SearchGame.DOMINATION;

    /* JADX INFO: renamed from: a */
    @NotNull
    public SearchRegion f3331a = SearchRegion.ALL;

    /* JADX INFO: renamed from: c */
    public float f3333c = 0.0f;

    /* JADX INFO: renamed from: e */
    public float f3335e = 0.0f;

    /* JADX INFO: renamed from: p */
    private int f3339p = -1;

    /* JADX INFO: renamed from: a */
    public void m2572a(@NotNull Minecraft minecraft, @Nullable ClientLevel clientLevel, @Nullable LocalPlayer localPlayer, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl) {
        C0555jl c0555jlM1886a = c0396gl.m1886a(minecraft);
        boolean zIsSearching = this.f3329v;
        Optional<MatchParty> party = c0555jlM1886a.getParty();
        if (party.isPresent()) {
            zIsSearching = party.get().isSearching();
        }
        if (this.f3329v != zIsSearching) {
            this.f3329v = zIsSearching;
        }
        this.f3335e = this.f3334d;
        this.f3334d = C1270xJ.m7183h(this.f3334d, this.f3329v ? 1.0f : 0.0f, 0.1f);
        m2577b(minecraft, clientLevel, localPlayer, c0623l, c0396gl);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public SearchGame m2573a() {
        return this.f3330a;
    }

    /* JADX INFO: renamed from: a */
    public void m2574a(@NotNull SearchGame searchGame) {
        this.f3330a = searchGame;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public SearchRegion m2575a() {
        return this.f3331a;
    }

    /* JADX INFO: renamed from: a */
    public void m2576a(@NotNull SearchRegion searchRegion) {
        this.f3331a = searchRegion;
    }

    /* JADX INFO: renamed from: b */
    private void m2577b(@NotNull Minecraft minecraft, @Nullable ClientLevel clientLevel, @Nullable LocalPlayer localPlayer, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl) {
        this.f3333c = this.f3332b;
        if (this.f3339p >= 0) {
            int i = this.f3339p - 1;
            this.f3339p = i;
            if (i < 0) {
                m2579a(minecraft, c0623l);
            }
        }
        if (this.f3338w) {
            if (localPlayer != null && localPlayer.connection.getServerData() != null) {
                Connection connection = localPlayer.connection.getConnection();
                connection.disconnect(Component.empty());
                connection.setReadOnly();
                connection.handleDisconnection();
                m2578a(minecraft, clientLevel, c0623l, c0396gl);
            }
            if (this.f3338w && this.f3332b >= 1.0f) {
                m2578a(minecraft, clientLevel, c0623l, c0396gl);
            }
        }
        boolean z = this.f3338w || this.f3339p >= 0;
        this.f3332b = C1270xJ.m7161d(this.f3332b, z ? 1.0f : 0.0f, z ? 0.05f : 0.025f);
    }

    /* JADX INFO: renamed from: a */
    private void m2578a(@NotNull Minecraft minecraft, @Nullable ClientLevel clientLevel, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl) {
        if (this.f3338w) {
            this.f3338w = false;
            if (this.f3336a == null) {
                C0530jM.log("Failed to join MM game due to missing server address or match UUID", new Object[0]);
                return;
            }
            if (clientLevel != null) {
                clientLevel.disconnect();
                c0623l.m2879a(minecraft, c0396gl, clientLevel, (AbstractC0863pb<?, ?, ?>) null);
            }
            this.f3339p = ThreadLocalRandom.current().nextInt(21);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2579a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l) {
        m2587a(false);
        if (this.f3336a == null || c0623l.m2874a() != null) {
            return;
        }
        String hostString = this.f3336a.getHostString();
        int port = this.f3336a.getPort();
        C0530jM.log("Joining MM game on address '" + hostString + ":" + port + "'", new Object[0]);
        ServerData serverData = new ServerData("mm-server", "", ServerData.Type.OTHER);
        ConnectScreen.startConnecting(new C0245dt(), minecraft, new ServerAddress(hostString, port), serverData, false, (TransferState) null);
    }

    /* JADX INFO: renamed from: a */
    public void m2580a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull InetSocketAddress inetSocketAddress) {
        SoundManager soundManager = minecraft.getSoundManager();
        this.f3336a = inetSocketAddress;
        C0396gl c0396gl = (C0396gl) c0623l.m2855a();
        C0555jl c0555jlM1886a = c0396gl.m1886a(minecraft);
        if (this.f3337n != null) {
            C0301ew.m1623a(minecraft, (Component) Component.translatable("bf.message.friend.mm.match.join", new Object[]{this.f3337n}));
            this.f3337n = null;
        } else {
            c0555jlM1886a.getParty().ifPresent(matchParty -> {
                C0301ew.m1623a(minecraft, (Component) Component.translatable("bf.message.party.mm.match.new", new Object[]{c0396gl.mo1154a(matchParty.getHost()).getUsername()}));
            });
        }
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7964pl.get(), 1.0f));
        this.f3338w = true;
    }

    /* JADX INFO: renamed from: b */
    public void m2581b(@Nullable String str) {
        this.f3337n = str;
    }

    /* JADX INFO: renamed from: c */
    public void m2582c() {
        this.f3338w = false;
        this.f3336a = null;
        this.f3339p = -1;
        this.f3337n = null;
    }

    /* JADX INFO: renamed from: b */
    public boolean m2583b() {
        return this.f3338w || this.f3339p >= 0;
    }

    /* JADX INFO: renamed from: b */
    public float m2584b(float f) {
        return C1270xJ.m7170f(this.f3332b, this.f3333c, f);
    }

    /* JADX INFO: renamed from: c */
    public float m2585c(float f) {
        return C1270xJ.m7170f(this.f3334d, this.f3335e, f);
    }

    /* JADX INFO: renamed from: c */
    public boolean m2586c() {
        return this.f3329v;
    }

    /* JADX INFO: renamed from: a */
    public void m2587a(boolean z) {
        this.f3329v = z;
    }

    /* JADX INFO: renamed from: b */
    public void m2588b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l) {
        C0396gl c0396gl = (C0396gl) c0623l.m2855a();
        C0555jl c0555jlM1886a = c0396gl.m1886a(minecraft);
        C0358g c0358g = (C0358g) c0623l.m2852b();
        SoundManager soundManager = minecraft.getSoundManager();
        C0530jM.log("Attempting to search for game...", new Object[0]);
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7962pj.get(), 1.0f));
        if (!c0555jlM1886a.hasCompletedBootcamp()) {
            m2574a(C1094tt.f5907b.m6022a());
        }
        ((C0358g) c0623l.m2852b()).m1724a(c0396gl, minecraft, c0623l);
        c0358g.sendPacket(new PacketMMSearch(m2573a(), m2575a()));
        m2587a(true);
    }
}
