package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.MatchSettings;
import com.boehmod.bflib.cloud.common.item.CloudItems;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.cloud.connection.ConnectionStatusContext;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0536jS;
import com.boehmod.blockfront.AbstractC0546jc;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jN.class */
public abstract class AbstractC0531jN<H extends AbstractC0184c<?>, C extends AbstractC0546jc<?>, AC extends AbstractC0536jS<?, ?>> {

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final H f3171a;

    /* JADX INFO: renamed from: im */
    private static final Component f3173im = Component.literal(String.valueOf((char) 57361)).append(" ").withColor(ColorReferences.COLOR_WHITE);

    /* JADX INFO: renamed from: lz */
    private static final int f3174lz = 120;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final C f3179a;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final CloudRegistry f3180a;

    /* JADX INFO: renamed from: n */
    @NotNull
    private final UUID f3172n = UUID.randomUUID();

    /* JADX INFO: renamed from: lA */
    private int f3175lA = 20;

    /* JADX INFO: renamed from: dG */
    private boolean f3176dG = false;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1061tM f3181a = new C1061tM();

    /* JADX INFO: renamed from: r */
    @NotNull
    private final Map<UUID, AbstractC0863pb<?, ?, ?>> f3182r = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: s */
    @NotNull
    private final Map<String, AbstractC0863pb<?, ?, ?>> f3183s = new ConcurrentHashMap();

    /* JADX INFO: renamed from: t */
    @NotNull
    private final Map<UUID, AbstractC0863pb<?, ?, ?>> f3184t = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final AC f3178a = (AC) mo2340a();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0607kk f3177a = mo2339a();

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract C0607kk mo2339a();

    /* JADX INFO: renamed from: a */
    protected abstract AC mo2340a();

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract C mo2344a();

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract C1264xD mo2352a();

    /* JADX INFO: renamed from: f */
    public abstract boolean mo2374f();

    /* JADX INFO: renamed from: g */
    public abstract boolean mo2375g();

    public AbstractC0531jN(@NotNull H h) {
        this.f3171a = h;
        this.f3177a.init();
        this.f3177a.m2736a(C0575kE.class, C0606kj.f3514aY, C0573kC::new);
        this.f3177a.m2736a(C1095tu.class, C0606kj.f3512aW, C0574kD::new);
        this.f3177a.m2736a(C0868pg.class, C0606kj.f3513aX, C0572kB::new);
        this.f3179a = (C) mo2344a();
        this.f3180a = new CloudRegistry();
        CloudAchievements.registerAchievements(this.f3180a);
        CloudItems.registerItems(this.f3180a);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public final AC m2341b() {
        return this.f3178a;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C m2342b() {
        return this.f3179a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1061tM m2343a() {
        return this.f3181a;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo2345a(@Nullable MinecraftServer minecraftServer, @NotNull ServerLevel serverLevel) {
        m2347b(minecraftServer, serverLevel);
        m2346a(serverLevel);
    }

    /* JADX INFO: renamed from: a */
    private void m2346a(@NotNull ServerLevel serverLevel) {
        int i = this.f3175lA;
        this.f3175lA = i + 1;
        if (i >= 120) {
            this.f3175lA = 0;
            List listPlayers = serverLevel.players();
            if (!listPlayers.isEmpty()) {
                serverLevel.getServer().getPlayerList().broadcastAll(new ClientboundPlayerInfoUpdatePacket(EnumSet.of(ClientboundPlayerInfoUpdatePacket.Action.UPDATE_LATENCY), listPlayers));
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m2347b(@Nullable MinecraftServer minecraftServer, @NotNull ServerLevel serverLevel) {
        Map mapM2720d = this.f3177a.m2737a(C0868pg.class).m2720d();
        if (mapM2720d.isEmpty()) {
            return;
        }
        m2350a((Level) serverLevel, minecraftServer);
        mapM2720d.values().forEach(c0868pg -> {
            AbstractC0863pb<?, ?, ?> abstractC0863pbM4272a = c0868pg.m4272a();
            if (abstractC0863pbM4272a != null) {
                abstractC0863pbM4272a.m4004a((AbstractC0531jN<?, ?, ?>) this, serverLevel);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public boolean m2348a(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        C0530jM.log("Attempting to assign player '%s' to game '%s'.", serverPlayer.getScoreboardName(), abstractC0863pb.m4064e());
        UUID uuid = serverPlayer.getUUID();
        if (!abstractC0863pb.mo4033a((AbstractC0531jN<?, ?, ?>) this, EnumC0876po.NEW, serverLevel, serverPlayer)) {
            return false;
        }
        AbstractC0866pe abstractC0866peM4018b = abstractC0863pb.m4018b();
        Set<UUID> setM4245h = abstractC0866peM4018b.m4245h();
        C0872pk c0872pkM4229a = abstractC0866peM4018b.m4229a(uuid);
        MutableComponent mutableComponentLiteral = Component.literal(serverPlayer.getScoreboardName());
        Component componentWithStyle = f3173im;
        if (c0872pkM4229a != null) {
            mutableComponentLiteral = mutableComponentLiteral.withStyle(c0872pkM4229a.m4312a());
            componentWithStyle = componentWithStyle.copy().withStyle(c0872pkM4229a.m4313b());
        }
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.player.join", new Object[]{mutableComponentLiteral}).withStyle(ChatFormatting.GRAY);
        for (UUID uuid2 : setM4245h) {
            if (!uuid2.equals(uuid)) {
                C0875pn.m4408a(uuid2, componentWithStyle, (Component) mutableComponentWithStyle);
            }
        }
        C0530jM.log("Sending initial game packet to player '%s'.", serverPlayer.getScoreboardName());
        C1169vO.m6643a(new C1220wM(abstractC0863pb, true), serverPlayer);
        C0606kj.m2733a(abstractC0863pb, serverLevel, serverPlayer);
        return true;
    }

    /* JADX INFO: renamed from: b */
    public boolean m2349b(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        C0530jM.log("Attempting to assign spectator '%s' to game '%s'.", serverPlayer.getScoreboardName(), abstractC0863pb.m4064e());
        AbstractC0866pe abstractC0866peM4018b = abstractC0863pb.m4018b();
        MatchSettings matchSettingsM4088a = abstractC0863pb.m4088a();
        if (abstractC0866peM4018b.m4245h().isEmpty()) {
            C0530jM.log("Rejected spectator '%s' for game '%s' (match is empty, all players left).", serverPlayer.getScoreboardName(), abstractC0863pb.m4064e());
            return false;
        }
        if (!abstractC0863pb.mo4048bm() || !matchSettingsM4088a.allowsSpectators() || abstractC0866peM4018b.m4246i().size() >= matchSettingsM4088a.getMaxSpectators()) {
            C0530jM.log("Rejected spectator '%s' for game '%s' (spectating disabled or at capacity).", serverPlayer.getScoreboardName(), abstractC0863pb.m4064e());
            return false;
        }
        abstractC0866peM4018b.m4231b(this, serverLevel, serverPlayer);
        C1169vO.m6643a(new C1220wM(abstractC0863pb, true), serverPlayer);
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.player.join.spectator", new Object[]{Component.literal(serverPlayer.getScoreboardName())}).withStyle(ChatFormatting.GRAY);
        for (UUID uuid : abstractC0866peM4018b.m4248j()) {
            if (!uuid.equals(serverPlayer.getUUID())) {
                C0875pn.m4408a(uuid, f3173im, (Component) mutableComponentWithStyle);
            }
        }
        C0606kj.m2733a(abstractC0863pb, serverLevel, serverPlayer);
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m2350a(@NotNull Level level, @Nullable MinecraftServer minecraftServer) {
        if (this.f3176dG) {
            return;
        }
        this.f3176dG = true;
        GameRules gameRules = level.getGameRules();
        if ((this instanceof C1280xT) && ((C1280xT) this).mo2374f() && (level instanceof ServerLevel)) {
            ((ServerLevel) level).noSave = true;
        }
        gameRules.getRule(GameRules.RULE_DAYLIGHT).set(false, minecraftServer);
        gameRules.getRule(GameRules.RULE_DISABLE_RAIDS).set(true, minecraftServer);
        gameRules.getRule(GameRules.RULE_NATURAL_REGENERATION).set(false, minecraftServer);
        gameRules.getRule(GameRules.RULE_DOBLOCKDROPS).set(false, minecraftServer);
        gameRules.getRule(GameRules.RULE_DOENTITYDROPS).set(false, minecraftServer);
        gameRules.getRule(GameRules.RULE_DOMOBSPAWNING).set(false, minecraftServer);
        gameRules.getRule(GameRules.RULE_WEATHER_CYCLE).set(false, minecraftServer);
        gameRules.getRule(GameRules.RULE_SPECTATORSGENERATECHUNKS).set(true, minecraftServer);
        gameRules.getRule(GameRules.RULE_DOFIRETICK).set(false, minecraftServer);
        gameRules.getRule(GameRules.RULE_ANNOUNCE_ADVANCEMENTS).set(false, minecraftServer);
        gameRules.getRule(GameRules.RULE_LOGADMINCOMMANDS).set(false, minecraftServer);
        gameRules.getRule(GameRules.RULE_DO_TRADER_SPAWNING).set(false, minecraftServer);
        gameRules.getRule(GameRules.RULE_SHOWDEATHMESSAGES).set(false, minecraftServer);
        gameRules.getRule(GameRules.RULE_RANDOMTICKING).set(0, minecraftServer);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public H m2351a() {
        return this.f3171a;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0863pb<?, ?, ?> m2353a(@NotNull Player player) {
        return mo2354a(player.getUUID());
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0863pb<?, ?, ?> mo2354a(@NotNull UUID uuid) {
        return this.f3182r.get(uuid);
    }

    /* JADX INFO: renamed from: a */
    public void m2355a(@NotNull UUID uuid, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        this.f3182r.put(uuid, abstractC0863pb);
    }

    /* JADX INFO: renamed from: a */
    public void m2356a(@NotNull UUID uuid) {
        this.f3182r.remove(uuid);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public void m2357a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = mo2354a(uuid);
        if (abstractC0863pbMo2354a == 0) {
            return;
        }
        if (abstractC0863pbMo2354a instanceof InterfaceC0942rA) {
            C0875pn.m4447a(abstractC0863pbMo2354a, uuid, C1062tN.f5743g, ((InterfaceC0942rA) abstractC0863pbMo2354a).mo5175bL());
        }
        abstractC0863pbMo2354a.m4018b().mo4267a(abstractC0531jN, abstractC0184c, serverLevel, serverPlayer, uuid);
    }

    /* JADX INFO: renamed from: e */
    public boolean m2358e(@NotNull UUID uuid) {
        return mo2354a(uuid) != null;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2359a(@NotNull UUID uuid, @NotNull UUID uuid2) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = mo2354a(uuid);
        return abstractC0863pbMo2354a != null && abstractC0863pbMo2354a.m4018b().m4221f(uuid2);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0863pb<?, ?, ?> m2360a(@NotNull String str) {
        return this.f3183s.get(str.toLowerCase(Locale.ROOT));
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public AbstractC0863pb<?, ?, ?> m2361b(@NotNull UUID uuid) {
        return this.f3184t.get(uuid);
    }

    /* JADX INFO: renamed from: b */
    public void m2362b(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        this.f3183s.put(abstractC0863pb.m4025S().toLowerCase(Locale.ROOT), abstractC0863pb);
        this.f3184t.put(abstractC0863pb.m4064e(), abstractC0863pb);
    }

    /* JADX INFO: renamed from: c */
    public void m2363c(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        this.f3183s.remove(abstractC0863pb.m4025S().toLowerCase(Locale.ROOT), abstractC0863pb);
        this.f3184t.remove(abstractC0863pb.m4064e(), abstractC0863pb);
    }

    /* JADX INFO: renamed from: a */
    public void m2364a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull UUID uuid, @NotNull UUID uuid2) {
        if (this.f3184t.remove(uuid, abstractC0863pb)) {
            this.f3184t.put(uuid2, abstractC0863pb);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Map<String, C0868pg> m2365b() {
        return this.f3177a.m2737a(C0868pg.class).m2720d();
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Map<String, C0868pg> m2366c() {
        C0605ki c0605kiM2737a = this.f3177a.m2737a(C0868pg.class);
        Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap();
        for (Map.Entry entry : c0605kiM2737a.m2720d().entrySet()) {
            String str = (String) entry.getKey();
            C0868pg c0868pg = (C0868pg) entry.getValue();
            if (c0868pg.m4273by()) {
                object2ObjectOpenHashMap.put(str, c0868pg);
            }
        }
        return object2ObjectOpenHashMap;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0863pb<?, ?, ?> m2367a(@NotNull BlockPos blockPos, double d) {
        C0881pt c0881ptM4226c;
        AbstractC0863pb<?, ?, ?> abstractC0863pb = null;
        double d2 = -1.0d;
        Iterator it = this.f3177a.m2737a(C0868pg.class).m2720d().values().iterator();
        while (it.hasNext()) {
            AbstractC0863pb<?, ?, ?> abstractC0863pbM4272a = ((C0868pg) it.next()).m4272a();
            if (abstractC0863pbM4272a != null && abstractC0863pbM4272a.m4023a() == EnumC0871pj.GAME && (c0881ptM4226c = abstractC0863pbM4272a.m4018b().m4226c()) != null) {
                double dM4581a = c0881ptM4226c.m4581a(blockPos);
                if (dM4581a <= d && (d2 < 0.0d || dM4581a < d2)) {
                    abstractC0863pb = abstractC0863pbM4272a;
                    d2 = dM4581a;
                }
            }
        }
        return abstractC0863pb;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<AbstractC0863pb<?, ?, ?>> m2368a(@NotNull C1094tt c1094tt, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        String strM6025at = c1094tt.m6025at();
        Iterator<C0868pg> it = m2366c().values().iterator();
        while (it.hasNext()) {
            AbstractC0863pb<?, ?, ?> abstractC0863pbM4272a = it.next().m4272a();
            if (abstractC0863pbM4272a != null && abstractC0863pbM4272a.m4030T().equalsIgnoreCase(strM6025at) && !m2370a(abstractC0863pbM4272a.m4027a().getName(), abstractC0863pb)) {
                objectArrayList.add(abstractC0863pbM4272a);
            }
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2369a(@NotNull C1095tu c1095tu, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        return m2370a(c1095tu.getName(), abstractC0863pb);
    }

    /* JADX INFO: renamed from: a */
    public boolean m2370a(@NotNull String str, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        Iterator it = this.f3177a.m2737a(C0868pg.class).m2720d().values().iterator();
        while (it.hasNext()) {
            AbstractC0863pb<?, ?, ?> abstractC0863pbM4272a = ((C0868pg) it.next()).m4272a();
            if (abstractC0863pbM4272a != null && !abstractC0863pbM4272a.equals(abstractC0863pb) && ((abstractC0863pbM4272a.m4023a() != EnumC0871pj.IDLE && abstractC0863pbM4272a.m4027a().getName().equalsIgnoreCase(str)) || abstractC0863pbM4272a.m4065a().m5925o(str))) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public UUID m2371c() {
        return this.f3172n;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0607kk m2372b() {
        return this.f3177a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public CloudRegistry m2373a() {
        return this.f3180a;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo2376a(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatus connectionStatus2, @NotNull ConnectionStatusContext connectionStatusContext) {
        if (connectionStatus.isClosed() && connectionStatus2.isConnected()) {
            C0530jM.log("[Cloud] Established connection to the cloud.", new Object[0]);
        } else if (connectionStatus.isConnected() && connectionStatus2.isClosed()) {
            C0530jM.log("[Cloud] Lost connection to the cloud.", new Object[0]);
        }
    }
}
