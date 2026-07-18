package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.MatchSettings;
import com.boehmod.bflib.cloud.common.item.CloudItems;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.cloud.connection.ConnectionStatusContext;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0473iJ;
import com.boehmod.blockfront.AbstractC0568jz;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ju */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ju.class */
public abstract class AbstractC0563ju<H extends AbstractC0183c<?>, C extends AbstractC0473iJ<?>, AC extends AbstractC0568jz<?, ?>> {

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final H f3188a;

    /* JADX INFO: renamed from: ib */
    private static final Component f3190ib = Component.literal(String.valueOf((char) 57361)).append(" ").withColor(ColorReferences.COLOR_WHITE);

    /* JADX INFO: renamed from: jS */
    private static final int f3191jS = 120;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final C f3196a;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final CloudRegistry f3197a;

    /* JADX INFO: renamed from: n */
    @NotNull
    private final UUID f3189n = UUID.randomUUID();

    /* JADX INFO: renamed from: jT */
    private int f3192jT = 20;

    /* JADX INFO: renamed from: dv */
    private boolean f3193dv = false;

    /* JADX INFO: renamed from: r */
    @NotNull
    private final Map<UUID, AbstractC0787oF<?, ?, ?>> f3198r = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: s */
    @NotNull
    private final Map<String, AbstractC0787oF<?, ?, ?>> f3199s = new ConcurrentHashMap();

    /* JADX INFO: renamed from: t */
    @NotNull
    private final Map<UUID, AbstractC0787oF<?, ?, ?>> f3200t = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final AC f3195a = (AC) mo2518a();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0531jO f3194a = mo2517a();

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract C0531jO mo2517a();

    /* JADX INFO: renamed from: a */
    protected abstract AC mo2518a();

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract C mo2521a();

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract C1284xg mo2529a();

    /* JADX INFO: renamed from: f */
    public abstract boolean mo2551f();

    /* JADX INFO: renamed from: g */
    public abstract boolean mo2552g();

    public AbstractC0563ju(@NotNull H h) {
        this.f3188a = h;
        this.f3194a.init();
        this.f3194a.m2374a(C0604ki.class, C0530jN.f3136aP, C0602kg::new);
        this.f3194a.m2374a(C1017sX.class, C0530jN.f3134aN, C0603kh::new);
        this.f3194a.m2374a(C0792oK.class, C0530jN.f3135aO, C0601kf::new);
        this.f3196a = (C) mo2521a();
        this.f3197a = new CloudRegistry();
        CloudAchievements.registerAchievements(this.f3197a);
        CloudItems.registerItems(this.f3197a);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public final AC m2519b() {
        return this.f3195a;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C m2520b() {
        return this.f3196a;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo2522a(@Nullable MinecraftServer minecraftServer, @NotNull ServerLevel serverLevel) {
        m2524b(minecraftServer, serverLevel);
        m2523a(serverLevel);
    }

    /* JADX INFO: renamed from: a */
    private void m2523a(@NotNull ServerLevel serverLevel) {
        int i = this.f3192jT;
        this.f3192jT = i + 1;
        if (i >= 120) {
            this.f3192jT = 0;
            List listPlayers = serverLevel.players();
            if (!listPlayers.isEmpty()) {
                serverLevel.getServer().getPlayerList().broadcastAll(new ClientboundPlayerInfoUpdatePacket(EnumSet.of(ClientboundPlayerInfoUpdatePacket.Action.UPDATE_LATENCY), listPlayers));
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m2524b(@Nullable MinecraftServer minecraftServer, @NotNull ServerLevel serverLevel) {
        Map mapM2358d = this.f3194a.m2375a(C0792oK.class).m2358d();
        if (mapM2358d.isEmpty()) {
            return;
        }
        m2527a((Level) serverLevel, minecraftServer);
        mapM2358d.values().forEach(c0792oK -> {
            AbstractC0787oF<?, ?, ?> abstractC0787oFM3836a = c0792oK.m3836a();
            if (abstractC0787oFM3836a != null) {
                abstractC0787oFM3836a.m3568a((AbstractC0563ju<?, ?, ?>) this, serverLevel);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public boolean m2525a(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        C0562jt.log("Attempting to assign player '%s' to game '%s'.", serverPlayer.getScoreboardName(), abstractC0787oF.m3628e());
        UUID uuid = serverPlayer.getUUID();
        if (!abstractC0787oF.mo3597a((AbstractC0563ju<?, ?, ?>) this, EnumC0800oS.NEW, serverLevel, serverPlayer)) {
            return false;
        }
        AbstractC0790oI abstractC0790oIM3582b = abstractC0787oF.m3582b();
        Set<UUID> setM3809h = abstractC0790oIM3582b.m3809h();
        C0796oO c0796oOM3793a = abstractC0790oIM3582b.m3793a(uuid);
        MutableComponent mutableComponentLiteral = Component.literal(serverPlayer.getScoreboardName());
        Component componentWithStyle = f3190ib;
        if (c0796oOM3793a != null) {
            mutableComponentLiteral = mutableComponentLiteral.withStyle(c0796oOM3793a.m3876a());
            componentWithStyle = componentWithStyle.copy().withStyle(c0796oOM3793a.m3877b());
        }
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.player.join", new Object[]{mutableComponentLiteral}).withStyle(ChatFormatting.GRAY);
        for (UUID uuid2 : setM3809h) {
            if (!uuid2.equals(uuid)) {
                C0799oR.m3972a(uuid2, componentWithStyle, (Component) mutableComponentWithStyle);
            }
        }
        C0562jt.log("Sending initial game packet to player '%s'.", serverPlayer.getScoreboardName());
        C1194vo.m6648a(new C1247wo(abstractC0787oF, true), serverPlayer);
        C0530jN.m2371a(abstractC0787oF, serverLevel, serverPlayer);
        return true;
    }

    /* JADX INFO: renamed from: b */
    public boolean m2526b(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        C0562jt.log("Attempting to assign spectator '%s' to game '%s'.", serverPlayer.getScoreboardName(), abstractC0787oF.m3628e());
        AbstractC0790oI abstractC0790oIM3582b = abstractC0787oF.m3582b();
        MatchSettings matchSettingsM3652a = abstractC0787oF.m3652a();
        if (abstractC0790oIM3582b.m3809h().isEmpty()) {
            C0562jt.log("Rejected spectator '%s' for game '%s' (match is empty, all players left).", serverPlayer.getScoreboardName(), abstractC0787oF.m3628e());
            return false;
        }
        if (!abstractC0787oF.mo3612bc() || !matchSettingsM3652a.allowsSpectators() || abstractC0790oIM3582b.m3810i().size() >= matchSettingsM3652a.getMaxSpectators()) {
            C0562jt.log("Rejected spectator '%s' for game '%s' (spectating disabled or at capacity).", serverPlayer.getScoreboardName(), abstractC0787oF.m3628e());
            return false;
        }
        abstractC0790oIM3582b.m3795b(this, serverLevel, serverPlayer);
        C1194vo.m6648a(new C1247wo(abstractC0787oF, true), serverPlayer);
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.player.join.spectator", new Object[]{Component.literal(serverPlayer.getScoreboardName())}).withStyle(ChatFormatting.GRAY);
        for (UUID uuid : abstractC0790oIM3582b.m3812j()) {
            if (!uuid.equals(serverPlayer.getUUID())) {
                C0799oR.m3972a(uuid, f3190ib, (Component) mutableComponentWithStyle);
            }
        }
        C0530jN.m2371a(abstractC0787oF, serverLevel, serverPlayer);
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m2527a(@NotNull Level level, @Nullable MinecraftServer minecraftServer) {
        if (this.f3193dv) {
            return;
        }
        this.f3193dv = true;
        GameRules gameRules = level.getGameRules();
        if ((this instanceof C1300xw) && ((C1300xw) this).mo2551f() && (level instanceof ServerLevel)) {
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
    public H m2528a() {
        return this.f3188a;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0787oF<?, ?, ?> m2530a(@NotNull Player player) {
        return mo2531a(player.getUUID());
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0787oF<?, ?, ?> mo2531a(@NotNull UUID uuid) {
        return this.f3198r.get(uuid);
    }

    /* JADX INFO: renamed from: a */
    public void m2532a(@NotNull UUID uuid, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        this.f3198r.put(uuid, abstractC0787oF);
    }

    /* JADX INFO: renamed from: a */
    public void m2533a(@NotNull UUID uuid) {
        this.f3198r.remove(uuid);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public void m2534a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = mo2531a(uuid);
        if (abstractC0787oFMo2531a == 0) {
            return;
        }
        if (abstractC0787oFMo2531a instanceof InterfaceC0970rd) {
            C0799oR.m4011a(abstractC0787oFMo2531a, uuid, C1089tp.f5690g, ((InterfaceC0970rd) abstractC0787oFMo2531a).mo5164bw());
        }
        abstractC0787oFMo2531a.m3582b().mo3831a(abstractC0563ju, abstractC0183c, serverLevel, serverPlayer, uuid);
    }

    /* JADX INFO: renamed from: e */
    public boolean m2535e(@NotNull UUID uuid) {
        return mo2531a(uuid) != null;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2536a(@NotNull UUID uuid, @NotNull UUID uuid2) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = mo2531a(uuid);
        return abstractC0787oFMo2531a != null && abstractC0787oFMo2531a.m3582b().m3785f(uuid2);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0787oF<?, ?, ?> m2537a(@NotNull String str) {
        return this.f3199s.get(str.toLowerCase(Locale.ROOT));
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public AbstractC0787oF<?, ?, ?> m2538b(@NotNull UUID uuid) {
        return this.f3200t.get(uuid);
    }

    /* JADX INFO: renamed from: b */
    public void m2539b(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        this.f3199s.put(abstractC0787oF.m3589L().toLowerCase(Locale.ROOT), abstractC0787oF);
        this.f3200t.put(abstractC0787oF.m3628e(), abstractC0787oF);
    }

    /* JADX INFO: renamed from: c */
    public void m2540c(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        this.f3199s.remove(abstractC0787oF.m3589L().toLowerCase(Locale.ROOT), abstractC0787oF);
        this.f3200t.remove(abstractC0787oF.m3628e(), abstractC0787oF);
    }

    /* JADX INFO: renamed from: a */
    public void m2541a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull UUID uuid, @NotNull UUID uuid2) {
        if (this.f3200t.remove(uuid, abstractC0787oF)) {
            this.f3200t.put(uuid2, abstractC0787oF);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Map<String, C0792oK> m2542b() {
        return this.f3194a.m2375a(C0792oK.class).m2358d();
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Map<String, C0792oK> m2543c() {
        C0529jM c0529jMM2375a = this.f3194a.m2375a(C0792oK.class);
        Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap();
        for (Map.Entry entry : c0529jMM2375a.m2358d().entrySet()) {
            String str = (String) entry.getKey();
            C0792oK c0792oK = (C0792oK) entry.getValue();
            if (c0792oK.m3837bo()) {
                object2ObjectOpenHashMap.put(str, c0792oK);
            }
        }
        return object2ObjectOpenHashMap;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0787oF<?, ?, ?> m2544a(@NotNull BlockPos blockPos, double d) {
        C0805oX c0805oXM3790c;
        AbstractC0787oF<?, ?, ?> abstractC0787oF = null;
        double d2 = -1.0d;
        Iterator it = this.f3194a.m2375a(C0792oK.class).m2358d().values().iterator();
        while (it.hasNext()) {
            AbstractC0787oF<?, ?, ?> abstractC0787oFM3836a = ((C0792oK) it.next()).m3836a();
            if (abstractC0787oFM3836a != null && abstractC0787oFM3836a.m3587a() == EnumC0795oN.GAME && (c0805oXM3790c = abstractC0787oFM3836a.m3582b().m3790c()) != null) {
                double dM4144a = c0805oXM3790c.m4144a(blockPos);
                if (dM4144a <= d && (d2 < 0.0d || dM4144a < d2)) {
                    abstractC0787oF = abstractC0787oFM3836a;
                    d2 = dM4144a;
                }
            }
        }
        return abstractC0787oF;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<AbstractC0787oF<?, ?, ?>> m2545a(@NotNull C1016sW c1016sW, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        String strM5537am = c1016sW.m5537am();
        Iterator<C0792oK> it = m2543c().values().iterator();
        while (it.hasNext()) {
            AbstractC0787oF<?, ?, ?> abstractC0787oFM3836a = it.next().m3836a();
            if (abstractC0787oFM3836a != null && abstractC0787oFM3836a.m3594M().equalsIgnoreCase(strM5537am) && !m2547a(abstractC0787oFM3836a.m3591a().getName(), abstractC0787oF)) {
                objectArrayList.add(abstractC0787oFM3836a);
            }
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2546a(@NotNull C1017sX c1017sX, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        return m2547a(c1017sX.getName(), abstractC0787oF);
    }

    /* JADX INFO: renamed from: a */
    public boolean m2547a(@NotNull String str, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        Iterator it = this.f3194a.m2375a(C0792oK.class).m2358d().values().iterator();
        while (it.hasNext()) {
            AbstractC0787oF<?, ?, ?> abstractC0787oFM3836a = ((C0792oK) it.next()).m3836a();
            if (abstractC0787oFM3836a != null && !abstractC0787oFM3836a.equals(abstractC0787oF) && ((abstractC0787oFM3836a.m3587a() != EnumC0795oN.IDLE && abstractC0787oFM3836a.m3591a().getName().equalsIgnoreCase(str)) || abstractC0787oFM3836a.m3629a().m6039l(str))) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public UUID m2548c() {
        return this.f3189n;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0531jO m2549b() {
        return this.f3194a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public CloudRegistry m2550a() {
        return this.f3197a;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo2553a(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatus connectionStatus2, @NotNull ConnectionStatusContext connectionStatusContext) {
        if (connectionStatus.isClosed() && connectionStatus2.isConnected()) {
            C0562jt.log("[Cloud] Established connection to the cloud.", new Object[0]);
        } else if (connectionStatus.isConnected() && connectionStatus2.isClosed()) {
            C0562jt.log("[Cloud] Lost connection to the cloud.", new Object[0]);
        }
    }
}
