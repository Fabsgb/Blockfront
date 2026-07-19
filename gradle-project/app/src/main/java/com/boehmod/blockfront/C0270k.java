package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.mm.MatchParty;
import com.boehmod.bflib.cloud.common.mm.SearchGame;
import com.boehmod.bflib.cloud.common.mm.SearchRegion;
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMSearch;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/k.class */
public class C0270k {
    private static final int m = 20;
    public float b;
    public float d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private InetSocketAddress f192a;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    @Nullable
    private String f193m;
    private boolean v;
    private boolean u = false;

    @NotNull
    public SearchGame a = SearchGame.DOMINATION;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public SearchRegion f191a = SearchRegion.ALL;
    public float c = 0.0f;
    public float e = 0.0f;
    private int n = -1;

    public void a(@NotNull Minecraft minecraft, @Nullable ClientLevel clientLevel, @Nullable LocalPlayer localPlayer, @NotNull C0297l c0297l, @NotNull fV fVVar) {
        iS iSVarM404a = fVVar.m404a(minecraft);
        boolean zIsSearching = this.u;
        Optional<MatchParty> party = iSVarM404a.getParty();
        if (party.isPresent()) {
            zIsSearching = party.get().isSearching();
        }
        if (this.u != zIsSearching) {
            this.u = zIsSearching;
        }
        this.e = this.d;
        this.d = C0634xm.g(this.d, this.u ? 1.0f : 0.0f, 0.1f);
        b(minecraft, clientLevel, localPlayer, c0297l, fVVar);
    }

    @NotNull
    public SearchGame a() {
        return this.a;
    }

    public void a(@NotNull SearchGame searchGame) {
        this.a = searchGame;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public SearchRegion m543a() {
        return this.f191a;
    }

    public void a(@NotNull SearchRegion searchRegion) {
        this.f191a = searchRegion;
    }

    private void b(@NotNull Minecraft minecraft, @Nullable ClientLevel clientLevel, @Nullable LocalPlayer localPlayer, @NotNull C0297l c0297l, @NotNull fV fVVar) {
        this.c = this.b;
        if (this.n >= 0) {
            int i = this.n - 1;
            this.n = i;
            if (i < 0) {
                a(minecraft, c0297l);
            }
        }
        if (this.v) {
            if (localPlayer != null && localPlayer.connection.getServerData() != null) {
                Connection connection = localPlayer.connection.getConnection();
                connection.disconnect(Component.empty());
                connection.setReadOnly();
                connection.handleDisconnection();
                a(minecraft, clientLevel, c0297l, fVVar);
            }
            if (this.v && this.b >= 1.0f) {
                a(minecraft, clientLevel, c0297l, fVVar);
            }
        }
        boolean z = this.v || this.n >= 0;
        this.b = C0634xm.d(this.b, z ? 1.0f : 0.0f, z ? 0.05f : 0.025f);
    }

    private void a(@NotNull Minecraft minecraft, @Nullable ClientLevel clientLevel, @NotNull C0297l c0297l, @NotNull fV fVVar) {
        if (this.v) {
            this.v = false;
            if (this.f192a == null) {
                C0263jt.log("Failed to join MM game due to missing server address or match UUID", new Object[0]);
                return;
            }
            if (clientLevel != null) {
                clientLevel.disconnect();
                c0297l.a(minecraft, fVVar, clientLevel, (oF<?, ?, ?>) null);
            }
            this.n = ThreadLocalRandom.current().nextInt(21);
        }
    }

    private void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l) {
        a(false);
        if (this.f192a == null || c0297l.m591a() != null) {
            return;
        }
        String hostString = this.f192a.getHostString();
        int port = this.f192a.getPort();
        C0263jt.log("Joining MM game on address '" + hostString + ":" + port + "'", new Object[0]);
        ServerData serverData = new ServerData("mm-server", "", ServerData.Type.OTHER);
        ConnectScreen.startConnecting(new C0094dk(), minecraft, new ServerAddress(hostString, port), serverData, false, (TransferState) null);
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull InetSocketAddress inetSocketAddress) {
        SoundManager soundManager = minecraft.getSoundManager();
        this.f192a = inetSocketAddress;
        fV fVVar = (fV) c0297l.a();
        iS iSVarM404a = fVVar.m404a(minecraft);
        if (this.f193m != null) {
            C0119ej.a(minecraft, (Component) Component.translatable("bf.message.friend.mm.match.join", new Object[]{this.f193m}));
            this.f193m = null;
        } else {
            iSVarM404a.getParty().ifPresent(matchParty -> {
                C0119ej.a(minecraft, (Component) Component.translatable("bf.message.party.mm.match.new", new Object[]{fVVar.mo306a(matchParty.getHost()).getUsername()}));
            });
        }
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pj.get(), 1.0f));
        this.v = true;
    }

    public void b(@Nullable String str) {
        this.f193m = str;
    }

    public void c() {
        this.v = false;
        this.f192a = null;
        this.n = -1;
        this.f193m = null;
    }

    public boolean b() {
        return this.v || this.n >= 0;
    }

    public float b(float f) {
        return C0634xm.e(this.b, this.c, f);
    }

    public float c(float f) {
        return C0634xm.e(this.d, this.e, f);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m544c() {
        return this.u;
    }

    public void a(boolean z) {
        this.u = z;
    }

    public void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l) {
        fV fVVar = (fV) c0297l.a();
        iS iSVarM404a = fVVar.m404a(minecraft);
        C0163g c0163g = (C0163g) c0297l.b();
        SoundManager soundManager = minecraft.getSoundManager();
        C0263jt.log("Attempting to search for game...", new Object[0]);
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.ph.get(), 1.0f));
        if (!iSVarM404a.hasCompletedBootcamp()) {
            a(sW.b.a());
        }
        ((C0163g) c0297l.b()).a(fVVar, minecraft, c0297l);
        c0163g.sendPacket(new PacketMMSearch(a(), m543a()));
        a(true);
    }
}
