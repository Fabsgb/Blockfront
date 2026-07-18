package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ConnectionType;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.p000mm.MatchParty;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.common.PacketClientUpdateStatus;
import com.boehmod.bflib.cloud.packet.common.party.PacketPartyEditSettings;
import com.boehmod.blockfront.cloud.connection.ModConnection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.g */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/g.class */
public final class C0357g extends AbstractC0473iJ<C0622l> {

    /* JADX INFO: renamed from: f */
    public static final int f2438f = 80;

    /* JADX INFO: renamed from: g */
    public static final int f2439g = 120;

    /* JADX INFO: renamed from: h */
    public static final int f2440h = 40;

    /* JADX INFO: renamed from: l */
    @NotNull
    private final String f2441l;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0728n f2442a;

    /* JADX INFO: renamed from: i */
    public int f2443i;

    /* JADX INFO: renamed from: j */
    private int f2444j;

    /* JADX INFO: renamed from: k */
    private int f2445k;

    /* JADX INFO: renamed from: l */
    private int f2446l;

    /* JADX INFO: renamed from: s */
    private boolean f2447s;

    /* JADX INFO: renamed from: a */
    @NotNull
    private EnumC0410h f2448a;

    public C0357g(@NotNull String str, @NotNull C0622l c0622l) {
        super(c0622l);
        this.f2442a = new C0728n();
        this.f2443i = 0;
        this.f2444j = 0;
        this.f2445k = 0;
        this.f2446l = 0;
        this.f2447s = false;
        this.f2448a = EnumC0410h.UNDECIDED;
        this.f2441l = str;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0410h m1716a() {
        return this.f2448a;
    }

    /* JADX INFO: renamed from: a */
    public void m1717a(@NotNull EnumC0410h enumC0410h) {
        this.f2448a = enumC0410h;
    }

    /* JADX INFO: renamed from: a */
    public void m1718a(@NotNull C0326fV c0326fV, @NotNull Minecraft minecraft, @NotNull C0622l c0622l) {
        Optional<MatchParty> party = c0326fV.m1676a(minecraft).getParty();
        UUID profileId = minecraft.getUser().getProfileId();
        party.ifPresent(matchParty -> {
            if (matchParty.isHost(profileId)) {
                C0569k c0569kM2699a = c0622l.m2699a();
                sendPacket(new PacketPartyEditSettings(c0569kM2699a.m2584a(), c0569kM2699a.m2586a()));
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m1719a(@NotNull Minecraft minecraft, @NotNull C0482iS c0482iS, @NotNull C0326fV c0326fV) {
        super.onUpdate();
        if (m1716a().getStatus().isConnected() && ((C0940r) ((C0622l) this.f2914b).m2667b()).m5133i()) {
            disconnect("", true);
        } else {
            m1720a(minecraft, c0326fV, c0482iS);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1720a(@NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C0482iS c0482iS) {
        if (m1716a().getStatus().isClosed()) {
            this.f2447s = false;
            return;
        }
        int i = this.f2444j;
        this.f2444j = i + 1;
        if (i >= 80) {
            this.f2444j = 0;
            m1721b(minecraft, c0326fV, c0482iS);
        }
        int i2 = this.f2446l;
        this.f2446l = i2 + 1;
        if (i2 >= 120) {
            this.f2446l = 0;
            m1731a();
        }
        int i3 = this.f2445k;
        this.f2445k = i3 + 1;
        if (i3 >= 40) {
            this.f2445k = 0;
            m1722a(c0482iS);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1721b(@NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C0482iS c0482iS) {
        C0478iO c0478iOA = m1716a();
        UUID uuidMo1723a = mo1723a();
        c0478iOA.m2165b(RequestType.PLAYER_DATA, uuidMo1723a);
        c0478iOA.m2165b(RequestType.PLAYER_STATUS, uuidMo1723a);
        UUID clanId = c0482iS.getClanId();
        if (clanId != null) {
            c0478iOA.m2165b(RequestType.CLAN_DATA, clanId);
        }
        C0887q c0887qM2676a = ((C0622l) this.f2914b).m2676a();
        Set<UUID> setM4458a = c0887qM2676a.m4458a();
        Objects.requireNonNull(c0326fV);
        setM4458a.forEach(c0326fV::m1135b);
        Set<UUID> setM4459b = c0887qM2676a.m4459b();
        Objects.requireNonNull(c0326fV);
        setM4459b.forEach(c0326fV::m1135b);
        Iterator<UUID> it = c0887qM2676a.m4458a().iterator();
        while (it.hasNext()) {
            c0478iOA.m2165b(RequestType.PLAYER_STATUS, it.next());
        }
        c0482iS.getParty().ifPresent(matchParty -> {
            Iterator<UUID> it2 = matchParty.getPartyUUIDs().iterator();
            while (it2.hasNext()) {
                c0478iOA.m2165b(RequestType.PLAYER_STATUS, it2.next());
            }
        });
        if (!this.f2447s) {
            this.f2447s = true;
            c0478iOA.m2165b(RequestType.PLAYER_INVENTORY, uuidMo1723a);
            c0478iOA.m2165b(RequestType.PLAYER_INVENTORY_DEFAULTS, uuidMo1723a);
            c0478iOA.m2165b(RequestType.PLAYER_INVENTORY_SHOWCASE, uuidMo1723a);
            c0478iOA.m2165b(RequestType.PLAYER_CHALLENGES, uuidMo1723a);
        }
        if (c0326fV.m1676a(minecraft).getInventory().getItems().isEmpty()) {
            c0478iOA.m2165b(RequestType.PLAYER_INVENTORY, uuidMo1723a);
            c0478iOA.m2165b(RequestType.PLAYER_INVENTORY_DEFAULTS, uuidMo1723a);
            c0478iOA.m2165b(RequestType.PLAYER_INVENTORY_SHOWCASE, uuidMo1723a);
        }
        sendPacket(new PacketClientUpdateStatus());
    }

    /* JADX INFO: renamed from: a */
    public void m1722a(@NotNull C0482iS c0482iS) {
        c0482iS.getParty().ifPresent(matchParty -> {
            C0478iO c0478iOA = ((C0357g) ((C0622l) this.f2914b).m2667b()).m1716a();
            for (UUID uuid : matchParty.getPlayers()) {
                c0478iOA.m2165b(RequestType.PLAYER_DATA, uuid);
                c0478iOA.m2165b(RequestType.INVENTORY_MINIMAL, uuid);
            }
        });
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    @NotNull
    /* JADX INFO: renamed from: a */
    public UUID mo1723a() {
        return (UUID) Objects.requireNonNull(Minecraft.getInstance().getUser().getProfileId());
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    @NotNull
    public String getUsername() {
        return Minecraft.getInstance().getUser().getName();
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    public byte[] getHardwareId() {
        return C0480iQ.m2174a();
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    @NotNull
    public String getVersion() {
        return C0029a.f248c;
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    @NotNull
    public String getVersionHash() {
        String strT = ((C0622l) this.f2914b).m2684a().m2560t();
        return strT != null ? strT : "Unknown";
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    @NotNull
    public ConnectionType getType() {
        return ConnectionType.PLAYER;
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    /* JADX INFO: renamed from: b */
    public int mo1724b() {
        return 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    @NotNull
    /* JADX INFO: renamed from: a */
    public String mo1725a() {
        return this.f2441l;
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    @NotNull
    /* JADX INFO: renamed from: b */
    public String mo1726b() {
        return this.f2442a.m3287e();
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    /* JADX INFO: renamed from: c */
    public int mo1727c() {
        return C0029a.f254a;
    }

    @Override // com.boehmod.blockfront.AbstractC0473iJ
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0478iO<C0622l> mo1732a(C0622l c0622l) {
        return new C0478iO<>(c0622l);
    }

    @Override // com.boehmod.blockfront.AbstractC0473iJ
    public void sendPacket(@NotNull IPacket iPacket) {
        ModConnection modConnectionA = m1716a();
        if (modConnectionA.getStatus().isConnected()) {
            modConnectionA.sendPacket(iPacket);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0473iJ, com.boehmod.blockfront.InterfaceC0481iR
    /* JADX INFO: renamed from: a */
    public void mo1729a(@NotNull String str) {
        super.mo1729a(str);
        C0287ej.m1507a(Minecraft.getInstance(), (Component) Component.translatable("bf.message.cloud.disconnect.reason", new Object[]{Component.literal(str).withStyle(ChatFormatting.GRAY)}));
        ((C0326fV) ((C0622l) this.f2914b).m2670a()).m1143dA();
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    /* JADX INFO: renamed from: a */
    public boolean mo1730a() {
        if (this.f2448a != EnumC0410h.ONLINE || ((C0622l) this.f2914b).m2684a().m2558ad() || ((C0940r) ((C0622l) this.f2914b).m2667b()).m5133i()) {
            return false;
        }
        this.f2442a.m3286d(Minecraft.getInstance());
        return this.f2442a.m3289h();
    }

    /* JADX INFO: renamed from: a */
    public void m1731a() {
        C0478iO c0478iOA = ((C0357g) ((C0622l) this.f2914b).m2667b()).m1716a();
        C0887q c0887qM2676a = ((C0622l) this.f2914b).m2676a();
        c0887qM2676a.m4458a().forEach(uuid -> {
            c0478iOA.m2165b(RequestType.PLAYER_DATA, uuid);
        });
        c0887qM2676a.m4459b().forEach(uuid2 -> {
            c0478iOA.m2165b(RequestType.PLAYER_DATA, uuid2);
        });
    }
}
