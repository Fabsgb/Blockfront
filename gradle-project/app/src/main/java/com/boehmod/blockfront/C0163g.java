package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ConnectionType;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.mm.MatchParty;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/g.class */
public final class C0163g extends iJ<C0297l> {
    public static final int f = 80;
    public static final int g = 120;
    public static final int h = 40;

    @NotNull
    private final String l;

    @NotNull
    private final C0351n a;
    public int i;
    private int j;
    private int k;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    private int f131l;
    private boolean s;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private EnumC0190h f132a;

    public C0163g(@NotNull String str, @NotNull C0297l c0297l) {
        super(c0297l);
        this.a = new C0351n();
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.f131l = 0;
        this.s = false;
        this.f132a = EnumC0190h.UNDECIDED;
        this.l = str;
    }

    @NotNull
    public EnumC0190h a() {
        return this.f132a;
    }

    public void a(@NotNull EnumC0190h enumC0190h) {
        this.f132a = enumC0190h;
    }

    public void a(@NotNull fV fVVar, @NotNull Minecraft minecraft, @NotNull C0297l c0297l) {
        Optional<MatchParty> party = fVVar.m404a(minecraft).getParty();
        UUID profileId = minecraft.getUser().getProfileId();
        party.ifPresent(matchParty -> {
            if (matchParty.isHost(profileId)) {
                C0270k c0270kM596a = c0297l.m596a();
                sendPacket(new PacketPartyEditSettings(c0270kM596a.a(), c0270kM596a.m543a()));
            }
        });
    }

    public void a(@NotNull Minecraft minecraft, @NotNull iS iSVar, @NotNull fV fVVar) {
        super.onUpdate();
        if (a().getStatus().isConnected() && ((C0459r) ((C0297l) this.b).b()).i()) {
            disconnect("", true);
        } else {
            a(minecraft, fVVar, iSVar);
        }
    }

    private void a(@NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull iS iSVar) {
        if (a().getStatus().isClosed()) {
            this.s = false;
            return;
        }
        int i = this.j;
        this.j = i + 1;
        if (i >= 80) {
            this.j = 0;
            b(minecraft, fVVar, iSVar);
        }
        int i2 = this.f131l;
        this.f131l = i2 + 1;
        if (i2 >= 120) {
            this.f131l = 0;
            m413a();
        }
        int i3 = this.k;
        this.k = i3 + 1;
        if (i3 >= 40) {
            this.k = 0;
            a(iSVar);
        }
    }

    private void b(@NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull iS iSVar) {
        iO iOVarA = a();
        UUID uuidMo409a = mo409a();
        iOVarA.b(RequestType.PLAYER_DATA, uuidMo409a);
        iOVarA.b(RequestType.PLAYER_STATUS, uuidMo409a);
        UUID clanId = iSVar.getClanId();
        if (clanId != null) {
            iOVarA.b(RequestType.CLAN_DATA, clanId);
        }
        C0432q c0432qM582a = ((C0297l) this.b).m582a();
        Set<UUID> setA = c0432qM582a.a();
        Objects.requireNonNull(fVVar);
        setA.forEach(fVVar::b);
        Set<UUID> setB = c0432qM582a.b();
        Objects.requireNonNull(fVVar);
        setB.forEach(fVVar::b);
        Iterator<UUID> it = c0432qM582a.a().iterator();
        while (it.hasNext()) {
            iOVarA.b(RequestType.PLAYER_STATUS, it.next());
        }
        iSVar.getParty().ifPresent(matchParty -> {
            Iterator<UUID> it2 = matchParty.getPartyUUIDs().iterator();
            while (it2.hasNext()) {
                iOVarA.b(RequestType.PLAYER_STATUS, it2.next());
            }
        });
        if (!this.s) {
            this.s = true;
            iOVarA.b(RequestType.PLAYER_INVENTORY, uuidMo409a);
            iOVarA.b(RequestType.PLAYER_INVENTORY_DEFAULTS, uuidMo409a);
            iOVarA.b(RequestType.PLAYER_INVENTORY_SHOWCASE, uuidMo409a);
            iOVarA.b(RequestType.PLAYER_CHALLENGES, uuidMo409a);
        }
        if (fVVar.m404a(minecraft).getInventory().getItems().isEmpty()) {
            iOVarA.b(RequestType.PLAYER_INVENTORY, uuidMo409a);
            iOVarA.b(RequestType.PLAYER_INVENTORY_DEFAULTS, uuidMo409a);
            iOVarA.b(RequestType.PLAYER_INVENTORY_SHOWCASE, uuidMo409a);
        }
        sendPacket(new PacketClientUpdateStatus());
    }

    public void a(@NotNull iS iSVar) {
        iSVar.getParty().ifPresent(matchParty -> {
            iO iOVarA = ((C0163g) ((C0297l) this.b).b()).a();
            for (UUID uuid : matchParty.getPlayers()) {
                iOVarA.b(RequestType.PLAYER_DATA, uuid);
                iOVarA.b(RequestType.INVENTORY_MINIMAL, uuid);
            }
        });
    }

    @Override // com.boehmod.blockfront.iR
    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public UUID mo409a() {
        return (UUID) Objects.requireNonNull(Minecraft.getInstance().getUser().getProfileId());
    }

    @Override // com.boehmod.blockfront.iR
    @NotNull
    public String getUsername() {
        return Minecraft.getInstance().getUser().getName();
    }

    @Override // com.boehmod.blockfront.iR
    public byte[] getHardwareId() {
        return iQ.a();
    }

    @Override // com.boehmod.blockfront.iR
    @NotNull
    public String getVersion() {
        return C0002a.c;
    }

    @Override // com.boehmod.blockfront.iR
    @NotNull
    public String getVersionHash() {
        String strT = ((C0297l) this.b).m588a().t();
        return strT != null ? strT : "Unknown";
    }

    @Override // com.boehmod.blockfront.iR
    @NotNull
    public ConnectionType getType() {
        return ConnectionType.PLAYER;
    }

    @Override // com.boehmod.blockfront.iR
    public int b() {
        return 0;
    }

    @Override // com.boehmod.blockfront.iR
    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo410a() {
        return this.l;
    }

    @Override // com.boehmod.blockfront.iR
    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String mo411b() {
        return this.a.e();
    }

    @Override // com.boehmod.blockfront.iR
    public int c() {
        return C0002a.f32a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.iJ
    @NotNull
    public iO<C0297l> a(C0297l c0297l) {
        return new iO<>(c0297l);
    }

    @Override // com.boehmod.blockfront.iJ
    public void sendPacket(@NotNull IPacket iPacket) {
        ModConnection modConnectionA = a();
        if (modConnectionA.getStatus().isConnected()) {
            modConnectionA.sendPacket(iPacket);
        }
    }

    @Override // com.boehmod.blockfront.iJ, com.boehmod.blockfront.iR
    public void a(@NotNull String str) {
        super.a(str);
        C0119ej.a(Minecraft.getInstance(), (Component) Component.translatable("bf.message.cloud.disconnect.reason", new Object[]{Component.literal(str).withStyle(ChatFormatting.GRAY)}));
        ((fV) ((C0297l) this.b).a()).dA();
    }

    @Override // com.boehmod.blockfront.iR
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo412a() {
        if (this.f132a != EnumC0190h.ONLINE || ((C0297l) this.b).m588a().ad() || ((C0459r) ((C0297l) this.b).b()).i()) {
            return false;
        }
        this.a.d(Minecraft.getInstance());
        return this.a.h();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m413a() {
        iO iOVarA = ((C0163g) ((C0297l) this.b).b()).a();
        C0432q c0432qM582a = ((C0297l) this.b).m582a();
        c0432qM582a.a().forEach(uuid -> {
            iOVarA.b(RequestType.PLAYER_DATA, uuid);
        });
        c0432qM582a.b().forEach(uuid2 -> {
            iOVarA.b(RequestType.PLAYER_DATA, uuid2);
        });
    }
}
