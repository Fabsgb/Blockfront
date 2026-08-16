package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ConnectionType;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.p001mm.MatchParty;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.common.PacketClientUpdateStatus;
import com.boehmod.bflib.cloud.packet.common.news.PacketNewsListRequest;
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
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/g.class */
public final class C0358g extends AbstractC0546jc<C0623l> {

    /* JADX INFO: renamed from: f */
    public static final int f2489f = 80;

    /* JADX INFO: renamed from: g */
    public static final int f2490g = 120;

    /* JADX INFO: renamed from: h */
    public static final int f2491h = 40;

    /* JADX INFO: renamed from: i */
    public static final int f2492i = 100;

    /* JADX INFO: renamed from: m */
    @NotNull
    private final String f2493m;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0729n f2494a;

    /* JADX INFO: renamed from: j */
    public int f2495j;

    /* JADX INFO: renamed from: k */
    private int f2496k;

    /* JADX INFO: renamed from: l */
    private int f2497l;

    /* JADX INFO: renamed from: m */
    private int f2498m;

    /* JADX INFO: renamed from: n */
    private int f2499n;

    /* JADX INFO: renamed from: t */
    private boolean f2500t;

    /* JADX INFO: renamed from: a */
    @NotNull
    private EnumC0411h f2501a;

    public C0358g(@NotNull String str, @NotNull C0623l c0623l) {
        super(c0623l);
        this.f2494a = new C0729n();
        this.f2495j = 0;
        this.f2496k = 0;
        this.f2497l = 0;
        this.f2498m = 0;
        this.f2499n = 100;
        this.f2500t = false;
        this.f2501a = EnumC0411h.UNDECIDED;
        this.f2493m = str;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0411h m1722a() {
        return this.f2501a;
    }

    /* JADX INFO: renamed from: a */
    public void m1723a(@NotNull EnumC0411h enumC0411h) {
        this.f2501a = enumC0411h;
    }

    /* JADX INFO: renamed from: a */
    public void m1724a(@NotNull C0396gl c0396gl, @NotNull Minecraft minecraft, @NotNull C0623l c0623l) {
        Optional<MatchParty> party = c0396gl.m1886a(minecraft).getParty();
        UUID profileId = minecraft.getUser().getProfileId();
        party.ifPresent(matchParty -> {
            if (matchParty.isHost(profileId)) {
                C0570k c0570kM2885a = c0623l.m2885a();
                sendPacket(new PacketPartyEditSettings(c0570kM2885a.m2573a(), c0570kM2885a.m2575a()));
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m1725a(@NotNull Minecraft minecraft, @NotNull C0555jl c0555jl, @NotNull C0396gl c0396gl) {
        super.onUpdate();
        if (m1722a().getStatus().isConnected() && ((C0994s) ((C0623l) this.f3263b).m2852b()).m5570i()) {
            disconnect("", true);
        } else {
            m1726a(minecraft, c0396gl, c0555jl);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1726a(@NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0555jl c0555jl) {
        if (m1722a().getStatus().isClosed()) {
            this.f2500t = false;
            return;
        }
        int i = this.f2496k;
        this.f2496k = i + 1;
        if (i >= 80) {
            this.f2496k = 0;
            m1727b(minecraft, c0396gl, c0555jl);
        }
        int i2 = this.f2498m;
        this.f2498m = i2 + 1;
        if (i2 >= 120) {
            this.f2498m = 0;
            m1737a();
        }
        int i3 = this.f2497l;
        this.f2497l = i3 + 1;
        if (i3 >= 40) {
            this.f2497l = 0;
            m1728a(c0555jl);
        }
        if (((C0623l) this.f3263b).m2863a().m1536N()) {
            return;
        }
        int i4 = this.f2499n;
        this.f2499n = i4 + 1;
        if (i4 >= 100) {
            this.f2499n = 0;
            sendPacket(new PacketNewsListRequest());
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1727b(@NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0555jl c0555jl) {
        C0551jh c0551jhA = m1722a();
        UUID uuidMo1729a = mo1729a();
        c0551jhA.m2492b(RequestType.PLAYER_DATA, uuidMo1729a);
        c0551jhA.m2492b(RequestType.PLAYER_STATUS, uuidMo1729a);
        UUID clanId = c0555jl.getClanId();
        if (clanId != null) {
            c0551jhA.m2492b(RequestType.CLAN_DATA, clanId);
        }
        C0888q c0888qM2861a = ((C0623l) this.f3263b).m2861a();
        Set<UUID> setM4641a = c0888qM2861a.m4641a();
        Objects.requireNonNull(c0396gl);
        setM4641a.forEach(c0396gl::m1152b);
        Set<UUID> setM4642b = c0888qM2861a.m4642b();
        Objects.requireNonNull(c0396gl);
        setM4642b.forEach(c0396gl::m1152b);
        Iterator<UUID> it = c0888qM2861a.m4641a().iterator();
        while (it.hasNext()) {
            c0551jhA.m2492b(RequestType.PLAYER_STATUS, it.next());
        }
        c0555jl.getParty().ifPresent(matchParty -> {
            Iterator<UUID> it2 = matchParty.getPartyUUIDs().iterator();
            while (it2.hasNext()) {
                c0551jhA.m2492b(RequestType.PLAYER_STATUS, it2.next());
            }
        });
        if (!this.f2500t) {
            this.f2500t = true;
            c0551jhA.m2492b(RequestType.PLAYER_INVENTORY, uuidMo1729a);
            c0551jhA.m2492b(RequestType.PLAYER_INVENTORY_DEFAULTS, uuidMo1729a);
            c0551jhA.m2492b(RequestType.PLAYER_INVENTORY_SHOWCASE, uuidMo1729a);
            c0551jhA.m2492b(RequestType.PLAYER_CHALLENGES, uuidMo1729a);
        }
        if (c0396gl.m1886a(minecraft).getInventory().getItems().isEmpty()) {
            c0551jhA.m2492b(RequestType.PLAYER_INVENTORY, uuidMo1729a);
            c0551jhA.m2492b(RequestType.PLAYER_INVENTORY_DEFAULTS, uuidMo1729a);
            c0551jhA.m2492b(RequestType.PLAYER_INVENTORY_SHOWCASE, uuidMo1729a);
        }
        sendPacket(new PacketClientUpdateStatus());
    }

    /* JADX INFO: renamed from: a */
    public void m1728a(@NotNull C0555jl c0555jl) {
        c0555jl.getParty().ifPresent(matchParty -> {
            C0551jh c0551jhA = ((C0358g) ((C0623l) this.f3263b).m2852b()).m1722a();
            for (UUID uuid : matchParty.getPlayers()) {
                c0551jhA.m2492b(RequestType.PLAYER_DATA, uuid);
                c0551jhA.m2492b(RequestType.INVENTORY_MINIMAL, uuid);
            }
        });
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    @NotNull
    /* JADX INFO: renamed from: a */
    public UUID mo1729a() {
        return (UUID) Objects.requireNonNull(Minecraft.getInstance().getUser().getProfileId());
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    @NotNull
    public String getUsername() {
        return Minecraft.getInstance().getUser().getName();
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    public byte[] getHardwareId() {
        return C0553jj.m2501a();
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    @NotNull
    public String getVersion() {
        return C0030a.f265c;
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    @NotNull
    public String getVersionHash() {
        String strX = ((C0623l) this.f3263b).m2870a().m2384x();
        return strX != null ? strX : "Unknown";
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    @NotNull
    public ConnectionType getType() {
        return ConnectionType.PLAYER;
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    /* JADX INFO: renamed from: b */
    public int mo1730b() {
        return 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    @NotNull
    /* JADX INFO: renamed from: a */
    public String mo1731a() {
        return this.f2493m;
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    @NotNull
    /* JADX INFO: renamed from: b */
    public String mo1732b() {
        return this.f2494a.m3345e();
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    /* JADX INFO: renamed from: c */
    public int mo1733c() {
        return C0030a.f271a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0546jc
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0551jh<C0623l> mo1738a(C0623l c0623l) {
        return new C0551jh<>(c0623l);
    }

    @Override // com.boehmod.blockfront.AbstractC0546jc
    public void sendPacket(@NotNull IPacket iPacket) {
        ModConnection modConnectionA = m1722a();
        if (modConnectionA.getStatus().isConnected()) {
            modConnectionA.sendPacket(iPacket);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0546jc, com.boehmod.blockfront.InterfaceC0554jk
    /* JADX INFO: renamed from: a */
    public void mo1735a(@NotNull String str) {
        super.mo1735a(str);
        C0301ew.m1623a(Minecraft.getInstance(), (Component) Component.translatable("bf.message.cloud.disconnect.reason", new Object[]{Component.literal(str).withStyle(ChatFormatting.GRAY)}));
        ((C0396gl) ((C0623l) this.f3263b).m2855a()).m1160dK();
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    /* JADX INFO: renamed from: a */
    public boolean mo1736a() {
        if (this.f2501a != EnumC0411h.ONLINE || ((C0623l) this.f3263b).m2870a().m2382ah() || ((C0994s) ((C0623l) this.f3263b).m2852b()).m5570i()) {
            return false;
        }
        this.f2494a.m3344d(Minecraft.getInstance());
        return this.f2494a.m3347h();
    }

    /* JADX INFO: renamed from: a */
    public void m1737a() {
        C0551jh c0551jhA = ((C0358g) ((C0623l) this.f3263b).m2852b()).m1722a();
        C0888q c0888qM2861a = ((C0623l) this.f3263b).m2861a();
        c0888qM2861a.m4641a().forEach(uuid -> {
            c0551jhA.m2492b(RequestType.PLAYER_DATA, uuid);
        });
        c0888qM2861a.m4642b().forEach(uuid2 -> {
            c0551jhA.m2492b(RequestType.PLAYER_DATA, uuid2);
        });
    }
}
