package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.p000mm.SearchGame;
import com.boehmod.bflib.cloud.common.p000mm.report.MatchSummary;
import com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData;
import com.boehmod.bflib.cloud.common.player.PlayerDataContext;
import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.boehmod.bflib.cloud.common.player.PlayerGroup;
import com.boehmod.bflib.cloud.common.player.PunishmentType;
import com.boehmod.bflib.cloud.common.player.status.OnlineStatus;
import com.boehmod.bflib.cloud.common.player.status.PartyStatus;
import com.boehmod.bflib.cloud.common.player.status.PublicPlayerStatus;
import com.mojang.authlib.GameProfile;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iS.class */
public class C0482iS extends AbstractPlayerCloudData<C0477iN, PublicPlayerStatus> {

    /* JADX INFO: renamed from: hM */
    @NotNull
    private static final Component f2941hM;

    /* JADX INFO: renamed from: hN */
    @NotNull
    private static final Component f2942hN;

    /* JADX INFO: renamed from: hO */
    @NotNull
    private static final Component f2943hO;

    /* JADX INFO: renamed from: hP */
    @NotNull
    private static final Component f2944hP;

    /* JADX INFO: renamed from: hQ */
    @NotNull
    private Component f2945hQ;

    /* JADX INFO: renamed from: jO */
    private int f2946jO;

    /* JADX INFO: renamed from: jP */
    public int f2947jP;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final EnumMap<PunishmentType, Integer> f2948a;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final EnumMap<PunishmentType, Integer> f2949b;

    /* JADX INFO: renamed from: jQ */
    private int f2950jQ;

    /* JADX INFO: renamed from: D */
    @Nullable
    private ObjectList<MatchSummary> f2951D;

    /* JADX INFO: renamed from: a */
    @NotNull
    private PlayerDataType f2952a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private PlayerGroup f2953a;

    /* JADX INFO: renamed from: dp */
    private boolean f2954dp;

    /* JADX INFO: renamed from: dq */
    private boolean f2955dq;

    /* JADX INFO: renamed from: dr */
    private boolean f2956dr;

    /* JADX INFO: renamed from: ds */
    private boolean f2957ds;

    /* JADX INFO: renamed from: dt */
    static final /* synthetic */ boolean f2958dt;

    static {
        f2958dt = !C0482iS.class.desiredAssertionStatus();
        f2941hM = Component.translatable("bf.status.match");
        f2942hN = Component.translatable("bf.status.spectating");
        f2943hO = Component.translatable("bf.status.party.host");
        f2944hP = Component.translatable("bf.status.party");
    }

    public C0482iS(@NotNull UUID uuid) {
        super(uuid);
        this.f2945hQ = Component.empty();
        this.f2946jO = 0;
        this.f2947jP = 0;
        this.f2948a = new EnumMap<>(PunishmentType.class);
        this.f2949b = new EnumMap<>(PunishmentType.class);
        this.f2950jQ = 0;
        this.f2951D = null;
        this.f2952a = PlayerDataType.PLAYER;
        this.f2953a = null;
        this.f2954dp = false;
        this.f2955dq = false;
        this.f2956dr = false;
        this.f2957ds = false;
    }

    /* JADX INFO: renamed from: a */
    public void m2182a(@NotNull PlayerDataType playerDataType) {
        this.f2952a = playerDataType;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public PlayerDataType m2183a() {
        return this.f2952a;
    }

    /* JADX INFO: renamed from: y */
    public boolean m2184y() {
        return this.f2957ds;
    }

    /* JADX INFO: renamed from: a */
    private void m2185a(@NotNull ByteBuf byteBuf) {
        this.f2948a.clear();
        for (PunishmentType punishmentType : PunishmentType.values()) {
            this.f2948a.put(punishmentType, Integer.valueOf(byteBuf.readInt()));
            this.f2949b.put(punishmentType, Integer.valueOf(byteBuf.readInt()));
        }
    }

    /* JADX INFO: renamed from: b */
    public void m2186b(@NotNull Player player) {
        setUsername(player.getScoreboardName());
    }

    /* JADX INFO: renamed from: a */
    public void m2187a(@NotNull C1300xw c1300xw) {
        UUID uuid = getUUID();
        int i = this.f2946jO;
        this.f2946jO = i + 1;
        if (i < 120) {
            return;
        }
        this.f2946jO = 0;
        C0478iO c0478iOA = ((C1298xu) c1300xw.m7961b()).mo1723a();
        c0478iOA.m2165b(RequestType.PLAYER_DATA, uuid);
        c0478iOA.m2165b(RequestType.INVENTORY_MINIMAL, uuid);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public MutableComponent m2188b() {
        C0796oO c0796oOM3793a;
        UUID uuid = getUUID();
        String username = getUsername();
        boolean z = false;
        MutableComponent mutableComponentAppend = this.f2953a != null ? C0479iP.m2173a(this.f2953a).append(" ") : Component.empty();
        MutableComponent mutableComponentLiteral = Component.literal(username);
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f2958dt && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
        if (abstractC0787oFMo2531a != null && (c0796oOM3793a = abstractC0787oFMo2531a.m3582b().m3793a(uuid)) != null) {
            z = true;
            mutableComponentLiteral.withStyle(c0796oOM3793a.m3876a());
        }
        if (!z) {
            mutableComponentLiteral.withStyle(ChatFormatting.GRAY);
        }
        return mutableComponentAppend.append(mutableComponentLiteral);
    }

    /* JADX INFO: renamed from: j */
    public boolean m2189j(@NotNull String str) {
        if (str.isEmpty()) {
            return true;
        }
        return this.f2953a != null && (this.f2953a.hasPermission(str) || this.f2953a.hasPermission("*"));
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public Component m2190k() {
        return this.f2945hQ;
    }

    /* JADX INFO: renamed from: Y */
    public boolean m2191Y() {
        return this.f2954dp;
    }

    /* JADX INFO: renamed from: Z */
    public boolean m2192Z() {
        return this.f2955dq;
    }

    /* JADX INFO: renamed from: aa */
    public boolean m2193aa() {
        return this.f2956dr;
    }

    /* JADX INFO: renamed from: ak */
    public int m2194ak() {
        return this.f2950jQ;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public GameProfile m2195a() {
        return new GameProfile(getUUID(), getUsername());
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public ObjectList<Component> m2196c() {
        SearchGame matchGame;
        MutableComponent mutableComponentWithStyle;
        PublicPlayerStatus status = getStatus();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.profile.base.status", new Object[]{m2190k()}));
        if (status.getOnlineStatus().isOnline() && (matchGame = status.getMatchGame()) != null) {
            objectArrayList.add(Component.empty());
            C1016sW c1016sWM5531a = C1016sW.m5531a(matchGame.getId());
            if (c1016sWM5531a != null) {
                objectArrayList.add(Component.translatable("bf.status.game.mode", new Object[]{c1016sWM5531a.getDisplayName().copy().withStyle(ChatFormatting.GRAY)}));
                if (status.getMatchMapName() != null) {
                    mutableComponentWithStyle = Component.literal(status.getMatchMapName()).withStyle(ChatFormatting.GRAY);
                } else {
                    mutableComponentWithStyle = Component.translatable("bf.message.unknown").withStyle(ChatFormatting.GRAY);
                }
                objectArrayList.add(Component.translatable("bf.status.game.map", new Object[]{mutableComponentWithStyle}));
                objectArrayList.add(Component.translatable("bf.status.game.players", new Object[]{Component.literal(String.valueOf(status.getMatchPlayerCount())).withStyle(ChatFormatting.GRAY), Component.literal(String.valueOf(status.getMatchMaxPlayerCount())).withStyle(ChatFormatting.GRAY)}));
            }
        }
        return objectArrayList;
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    public void read(@NotNull PlayerDataContext playerDataContext, @NotNull ByteBuf byteBuf) throws IOException {
        super.read(playerDataContext, byteBuf);
        this.f2950jQ = byteBuf.readInt();
        m2185a(byteBuf);
        this.f2954dp = byteBuf.readBoolean();
        this.f2955dq = byteBuf.readBoolean();
        this.f2956dr = byteBuf.readBoolean();
        this.f2957ds = true;
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    /* JADX INFO: renamed from: a */
    public void setStatus(@NotNull PublicPlayerStatus publicPlayerStatus) {
        super.setStatus(publicPlayerStatus);
        OnlineStatus onlineStatus = publicPlayerStatus.getOnlineStatus();
        int color = onlineStatus.getColor();
        Component componentTranslatable = Component.translatable(onlineStatus.getLabel());
        if (onlineStatus.isOnline()) {
            if (publicPlayerStatus.isSpectating()) {
                componentTranslatable = f2942hN;
            } else if (publicPlayerStatus.isInGame()) {
                componentTranslatable = f2941hM;
            } else {
                PartyStatus partyStatus = publicPlayerStatus.getPartyStatus();
                if (partyStatus != PartyStatus.NONE) {
                    componentTranslatable = partyStatus == PartyStatus.HOST ? f2943hO : f2944hP;
                }
            }
        }
        this.f2945hQ = componentTranslatable.copy().withColor(color);
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0477iN createInventory() {
        return new C0477iN(this);
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    @NotNull
    /* JADX INFO: renamed from: a */
    public PublicPlayerStatus createStatus() {
        return new PublicPlayerStatus();
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    @NotNull
    public Optional<PlayerGroup> getGroup() {
        return Optional.ofNullable(this.f2953a);
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    public void setGroup(@Nullable PlayerGroup playerGroup) {
        this.f2953a = playerGroup;
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    public int getPunishmentCount(@NotNull PunishmentType punishmentType) {
        return ((Integer) this.f2948a.getOrDefault(punishmentType, 0)).intValue();
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    public boolean hasActivePunishment(@NotNull PunishmentType punishmentType) {
        return ((Integer) this.f2949b.getOrDefault(punishmentType, 0)).intValue() > 0;
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    public AbstractClanData getClanData() {
        UUID clanId;
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a == null || (clanId = getClanId()) == null) {
            return null;
        }
        return abstractC0563juM168a.m2528a().m1138a(clanId);
    }

    /* JADX INFO: renamed from: b */
    public void m2200b(@NotNull ObjectList<MatchSummary> objectList) {
        this.f2951D = objectList;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public ObjectList<MatchSummary> m2201d() {
        return this.f2951D;
    }

    /* JADX INFO: renamed from: aZ */
    public void m2202aZ() {
        this.f2951D = null;
    }
}
