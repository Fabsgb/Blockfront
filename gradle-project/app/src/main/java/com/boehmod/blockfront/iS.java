package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.mm.SearchGame;
import com.boehmod.bflib.cloud.common.mm.report.MatchSummary;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iS.class */
public class iS extends AbstractPlayerCloudData<iN, PublicPlayerStatus> {

    @NotNull
    private static final Component hM;

    @NotNull
    private static final Component hN;

    @NotNull
    private static final Component hO;

    @NotNull
    private static final Component hP;

    @NotNull
    private Component hQ;
    private int jO;
    public int jP;

    @NotNull
    private final EnumMap<PunishmentType, Integer> a;

    @NotNull
    private final EnumMap<PunishmentType, Integer> b;
    private int jQ;

    @Nullable
    private ObjectList<MatchSummary> D;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private PlayerDataType f172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private PlayerGroup f173a;
    private boolean dp;
    private boolean dq;
    private boolean dr;
    private boolean ds;
    static final /* synthetic */ boolean dt;

    static {
        dt = !iS.class.desiredAssertionStatus();
        hM = Component.translatable("bf.status.match");
        hN = Component.translatable("bf.status.spectating");
        hO = Component.translatable("bf.status.party.host");
        hP = Component.translatable("bf.status.party");
    }

    public iS(@NotNull UUID uuid) {
        super(uuid);
        this.hQ = Component.empty();
        this.jO = 0;
        this.jP = 0;
        this.a = new EnumMap<>(PunishmentType.class);
        this.b = new EnumMap<>(PunishmentType.class);
        this.jQ = 0;
        this.D = null;
        this.f172a = PlayerDataType.PLAYER;
        this.f173a = null;
        this.dp = false;
        this.dq = false;
        this.dr = false;
        this.ds = false;
    }

    public void a(@NotNull PlayerDataType playerDataType) {
        this.f172a = playerDataType;
    }

    @NotNull
    public PlayerDataType a() {
        return this.f172a;
    }

    public boolean y() {
        return this.ds;
    }

    private void a(@NotNull ByteBuf byteBuf) {
        this.a.clear();
        for (PunishmentType punishmentType : PunishmentType.values()) {
            this.a.put(punishmentType, Integer.valueOf(byteBuf.readInt()));
            this.b.put(punishmentType, Integer.valueOf(byteBuf.readInt()));
        }
    }

    public void b(@NotNull Player player) {
        setUsername(player.getScoreboardName());
    }

    public void a(@NotNull xw xwVar) {
        UUID uuid = getUUID();
        int i = this.jO;
        this.jO = i + 1;
        if (i < 120) {
            return;
        }
        this.jO = 0;
        iO iOVarA = ((xu) xwVar.b()).mo409a();
        iOVarA.b(RequestType.PLAYER_DATA, uuid);
        iOVarA.b(RequestType.INVENTORY_MINIMAL, uuid);
    }

    @NotNull
    public MutableComponent b() {
        oO oOVarA;
        UUID uuid = getUUID();
        String username = getUsername();
        boolean z = false;
        MutableComponent mutableComponentAppend = this.f173a != null ? iP.a(this.f173a).append(" ") : Component.empty();
        MutableComponent mutableComponentLiteral = Component.literal(username);
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!dt && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
        if (oFVarMo604a != null && (oOVarA = oFVarMo604a.b().a(uuid)) != null) {
            z = true;
            mutableComponentLiteral.withStyle(oOVarA.a());
        }
        if (!z) {
            mutableComponentLiteral.withStyle(ChatFormatting.GRAY);
        }
        return mutableComponentAppend.append(mutableComponentLiteral);
    }

    public boolean j(@NotNull String str) {
        if (str.isEmpty()) {
            return true;
        }
        return this.f173a != null && (this.f173a.hasPermission(str) || this.f173a.hasPermission("*"));
    }

    @NotNull
    public Component k() {
        return this.hQ;
    }

    public boolean Y() {
        return this.dp;
    }

    public boolean Z() {
        return this.dq;
    }

    public boolean aa() {
        return this.dr;
    }

    public int ak() {
        return this.jQ;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public GameProfile m491a() {
        return new GameProfile(getUUID(), getUsername());
    }

    @NotNull
    public ObjectList<Component> c() {
        SearchGame matchGame;
        MutableComponent mutableComponentWithStyle;
        PublicPlayerStatus status = getStatus();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.profile.base.status", new Object[]{k()}));
        if (status.getOnlineStatus().isOnline() && (matchGame = status.getMatchGame()) != null) {
            objectArrayList.add(Component.empty());
            sW sWVarA = sW.a(matchGame.getId());
            if (sWVarA != null) {
                objectArrayList.add(Component.translatable("bf.status.game.mode", new Object[]{sWVarA.getDisplayName().copy().withStyle(ChatFormatting.GRAY)}));
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
        this.jQ = byteBuf.readInt();
        a(byteBuf);
        this.dp = byteBuf.readBoolean();
        this.dq = byteBuf.readBoolean();
        this.dr = byteBuf.readBoolean();
        this.ds = true;
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setStatus(@NotNull PublicPlayerStatus publicPlayerStatus) {
        super.setStatus(publicPlayerStatus);
        OnlineStatus onlineStatus = publicPlayerStatus.getOnlineStatus();
        int color = onlineStatus.getColor();
        Component componentTranslatable = Component.translatable(onlineStatus.getLabel());
        if (onlineStatus.isOnline()) {
            if (publicPlayerStatus.isSpectating()) {
                componentTranslatable = hN;
            } else if (publicPlayerStatus.isInGame()) {
                componentTranslatable = hM;
            } else {
                PartyStatus partyStatus = publicPlayerStatus.getPartyStatus();
                if (partyStatus != PartyStatus.NONE) {
                    componentTranslatable = partyStatus == PartyStatus.HOST ? hO : hP;
                }
            }
        }
        this.hQ = componentTranslatable.copy().withColor(color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public iN createInventory() {
        return new iN(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public PublicPlayerStatus createStatus() {
        return new PublicPlayerStatus();
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    @NotNull
    public Optional<PlayerGroup> getGroup() {
        return Optional.ofNullable(this.f173a);
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    public void setGroup(@Nullable PlayerGroup playerGroup) {
        this.f173a = playerGroup;
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    public int getPunishmentCount(@NotNull PunishmentType punishmentType) {
        return ((Integer) this.a.getOrDefault(punishmentType, 0)).intValue();
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    public boolean hasActivePunishment(@NotNull PunishmentType punishmentType) {
        return ((Integer) this.b.getOrDefault(punishmentType, 0)).intValue() > 0;
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    public AbstractClanData getClanData() {
        UUID clanId;
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a == null || (clanId = getClanId()) == null) {
            return null;
        }
        return abstractC0264juM166a.m531a().m307a(clanId);
    }

    public void b(@NotNull ObjectList<MatchSummary> objectList) {
        this.D = objectList;
    }

    @Nullable
    public ObjectList<MatchSummary> d() {
        return this.D;
    }

    public void aZ() {
        this.D = null;
    }
}
