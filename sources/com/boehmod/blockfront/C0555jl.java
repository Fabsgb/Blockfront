package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.p001mm.SearchGame;
import com.boehmod.bflib.cloud.common.p001mm.report.MatchSummary;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.jl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jl.class */
public class C0555jl extends AbstractPlayerCloudData<C0550jg, PublicPlayerStatus> {

    /* JADX INFO: renamed from: hX */
    @NotNull
    private static final Component f3292hX;

    /* JADX INFO: renamed from: hY */
    @NotNull
    private static final Component f3293hY;

    /* JADX INFO: renamed from: hZ */
    @NotNull
    private static final Component f3294hZ;

    /* JADX INFO: renamed from: ia */
    @NotNull
    private static final Component f3295ia;

    /* JADX INFO: renamed from: ib */
    @NotNull
    private Component f3296ib;

    /* JADX INFO: renamed from: lv */
    private int f3297lv;

    /* JADX INFO: renamed from: lw */
    public int f3298lw;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final EnumMap<PunishmentType, Integer> f3299a;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final EnumMap<PunishmentType, Integer> f3300b;

    /* JADX INFO: renamed from: lx */
    private int f3301lx;

    /* JADX INFO: renamed from: M */
    @Nullable
    private ObjectList<MatchSummary> f3302M;

    /* JADX INFO: renamed from: a */
    @NotNull
    private PlayerDataType f3303a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private PlayerGroup f3304a;

    /* JADX INFO: renamed from: dA */
    private boolean f3305dA;

    /* JADX INFO: renamed from: dB */
    private boolean f3306dB;

    /* JADX INFO: renamed from: dC */
    private boolean f3307dC;

    /* JADX INFO: renamed from: dD */
    private boolean f3308dD;

    /* JADX INFO: renamed from: dE */
    static final /* synthetic */ boolean f3309dE;

    static {
        f3309dE = !C0555jl.class.desiredAssertionStatus();
        f3292hX = Component.translatable("bf.status.match");
        f3293hY = Component.translatable("bf.status.spectating");
        f3294hZ = Component.translatable("bf.status.party.host");
        f3295ia = Component.translatable("bf.status.party");
    }

    public C0555jl(@NotNull UUID uuid) {
        super(uuid);
        this.f3296ib = Component.empty();
        this.f3297lv = 0;
        this.f3298lw = 0;
        this.f3299a = new EnumMap<>(PunishmentType.class);
        this.f3300b = new EnumMap<>(PunishmentType.class);
        this.f3301lx = 0;
        this.f3302M = null;
        this.f3303a = PlayerDataType.PLAYER;
        this.f3304a = null;
        this.f3305dA = false;
        this.f3306dB = false;
        this.f3307dC = false;
        this.f3308dD = false;
    }

    /* JADX INFO: renamed from: a */
    public void m2509a(@NotNull PlayerDataType playerDataType) {
        this.f3303a = playerDataType;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public PlayerDataType m2510a() {
        return this.f3303a;
    }

    /* JADX INFO: renamed from: z */
    public boolean m2511z() {
        return this.f3308dD;
    }

    /* JADX INFO: renamed from: a */
    private void m2512a(@NotNull ByteBuf byteBuf) {
        this.f3299a.clear();
        for (PunishmentType punishmentType : PunishmentType.values()) {
            this.f3299a.put(punishmentType, Integer.valueOf(byteBuf.readInt()));
            this.f3300b.put(punishmentType, Integer.valueOf(byteBuf.readInt()));
        }
    }

    /* JADX INFO: renamed from: b */
    public void m2513b(@NotNull Player player) {
        setUsername(player.getScoreboardName());
    }

    /* JADX INFO: renamed from: a */
    public void m2514a(@NotNull C1280xT c1280xT) {
        UUID uuid = getUUID();
        int i = this.f3297lv;
        this.f3297lv = i + 1;
        if (i < 120) {
            return;
        }
        this.f3297lv = 0;
        C0551jh c0551jhA = ((C1278xR) c1280xT.m7289b()).mo1729a();
        c0551jhA.m2492b(RequestType.PLAYER_DATA, uuid);
        c0551jhA.m2492b(RequestType.INVENTORY_MINIMAL, uuid);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public MutableComponent m2515b() {
        C0872pk c0872pkM4229a;
        UUID uuid = getUUID();
        String username = getUsername();
        boolean z = false;
        MutableComponent mutableComponentAppend = this.f3304a != null ? C0552ji.m2500a(this.f3304a).append(" ") : Component.empty();
        MutableComponent mutableComponentLiteral = Component.literal(username);
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f3309dE && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
        if (abstractC0863pbMo2354a != null && (c0872pkM4229a = abstractC0863pbMo2354a.m4018b().m4229a(uuid)) != null) {
            z = true;
            mutableComponentLiteral.withStyle(c0872pkM4229a.m4312a());
        }
        if (!z) {
            mutableComponentLiteral.withStyle(ChatFormatting.GRAY);
        }
        return mutableComponentAppend.append(mutableComponentLiteral);
    }

    /* JADX INFO: renamed from: l */
    public boolean m2516l(@NotNull String str) {
        if (str.isEmpty()) {
            return true;
        }
        return this.f3304a != null && (this.f3304a.hasPermission(str) || this.f3304a.hasPermission("*"));
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public Component m2517k() {
        return this.f3296ib;
    }

    /* JADX INFO: renamed from: ab */
    public boolean m2518ab() {
        return this.f3305dA;
    }

    /* JADX INFO: renamed from: ac */
    public boolean m2519ac() {
        return this.f3306dB;
    }

    /* JADX INFO: renamed from: ad */
    public boolean m2520ad() {
        return this.f3307dC;
    }

    /* JADX INFO: renamed from: aA */
    public int m2521aA() {
        return this.f3301lx;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public GameProfile m2522a() {
        return new GameProfile(getUUID(), getUsername());
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    public ObjectList<Component> m2523g() {
        SearchGame matchGame;
        MutableComponent mutableComponentWithStyle;
        PublicPlayerStatus status = getStatus();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.profile.base.status", new Object[]{m2517k()}));
        if (status.getOnlineStatus().isOnline() && (matchGame = status.getMatchGame()) != null) {
            objectArrayList.add(Component.empty());
            C1094tt c1094ttM6019a = C1094tt.m6019a(matchGame.getId());
            if (c1094ttM6019a != null) {
                objectArrayList.add(Component.translatable("bf.status.game.mode", new Object[]{c1094ttM6019a.getDisplayName().copy().withStyle(ChatFormatting.GRAY)}));
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
        this.f3301lx = byteBuf.readInt();
        m2512a(byteBuf);
        this.f3305dA = byteBuf.readBoolean();
        this.f3306dB = byteBuf.readBoolean();
        this.f3307dC = byteBuf.readBoolean();
        this.f3308dD = true;
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
                componentTranslatable = f3293hY;
            } else if (publicPlayerStatus.isInGame()) {
                componentTranslatable = f3292hX;
            } else {
                PartyStatus partyStatus = publicPlayerStatus.getPartyStatus();
                if (partyStatus != PartyStatus.NONE) {
                    componentTranslatable = partyStatus == PartyStatus.HOST ? f3294hZ : f3295ia;
                }
            }
        }
        this.f3296ib = componentTranslatable.copy().withColor(color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0550jg createInventory() {
        return new C0550jg(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public PublicPlayerStatus createStatus() {
        return new PublicPlayerStatus();
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    @NotNull
    public Optional<PlayerGroup> getGroup() {
        return Optional.ofNullable(this.f3304a);
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    public void setGroup(@Nullable PlayerGroup playerGroup) {
        this.f3304a = playerGroup;
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    public int getPunishmentCount(@NotNull PunishmentType punishmentType) {
        return ((Integer) this.f3299a.getOrDefault(punishmentType, 0)).intValue();
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    public boolean hasActivePunishment(@NotNull PunishmentType punishmentType) {
        return ((Integer) this.f3300b.getOrDefault(punishmentType, 0)).intValue() > 0;
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData
    public AbstractClanData getClanData() {
        UUID clanId;
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a == null || (clanId = getClanId()) == null) {
            return null;
        }
        return abstractC0531jNM179a.m2351a().m1155a(clanId);
    }

    /* JADX INFO: renamed from: b */
    public void m2527b(@NotNull ObjectList<MatchSummary> objectList) {
        this.f3302M = objectList;
    }

    @Nullable
    /* JADX INFO: renamed from: h */
    public ObjectList<MatchSummary> m2528h() {
        return this.f3302M;
    }

    /* JADX INFO: renamed from: bl */
    public void m2529bl() {
        this.f3302M = null;
    }
}
