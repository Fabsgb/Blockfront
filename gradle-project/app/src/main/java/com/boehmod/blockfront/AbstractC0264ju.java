package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.MatchSettings;
import com.boehmod.bflib.cloud.common.item.CloudItems;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.cloud.connection.ConnectionStatusContext;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0269jz;
import com.boehmod.blockfront.common.player.c;
import com.boehmod.blockfront.iJ;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ju, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ju.class */
public abstract class AbstractC0264ju<H extends com.boehmod.blockfront.common.player.c<?>, C extends iJ<?>, AC extends AbstractC0269jz<?, ?>> {

    @NotNull
    protected final H a;
    private static final Component ib = Component.literal(String.valueOf((char) 57361)).append(" ").withColor(ColorReferences.COLOR_WHITE);
    private static final int jS = 120;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    protected final C f187a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    protected final CloudRegistry f188a;

    @NotNull
    private final UUID n = UUID.randomUUID();
    private int jT = 20;
    private boolean dv = false;

    @NotNull
    private final Map<UUID, oF<?, ?, ?>> r = new Object2ObjectOpenHashMap();

    @NotNull
    private final Map<String, oF<?, ?, ?>> s = new ConcurrentHashMap();

    @NotNull
    private final Map<UUID, oF<?, ?, ?>> t = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    protected final AC f186a = (AC) mo528a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final jO f185a = mo603a();

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract jO mo603a();

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    protected abstract AC mo528a();

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    protected abstract C mo530a();

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract C0628xg mo532a();

    public abstract boolean f();

    public abstract boolean g();

    public AbstractC0264ju(@NotNull H h) {
        this.a = h;
        this.f185a.init();
        this.f185a.a(C0279ki.class, jN.aP, C0277kg::new);
        this.f185a.a(sX.class, jN.aN, C0278kh::new);
        this.f185a.a(oK.class, jN.aO, C0276kf::new);
        this.f187a = (C) mo530a();
        this.f188a = new CloudRegistry();
        CloudAchievements.registerAchievements(this.f188a);
        CloudItems.registerItems(this.f188a);
    }

    @NotNull
    public final AC b() {
        return this.f186a;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public C m529b() {
        return this.f187a;
    }

    @OverridingMethodsMustInvokeSuper
    public void a(@Nullable MinecraftServer minecraftServer, @NotNull ServerLevel serverLevel) {
        b(minecraftServer, serverLevel);
        a(serverLevel);
    }

    private void a(@NotNull ServerLevel serverLevel) {
        int i = this.jT;
        this.jT = i + 1;
        if (i >= 120) {
            this.jT = 0;
            List listPlayers = serverLevel.players();
            if (!listPlayers.isEmpty()) {
                serverLevel.getServer().getPlayerList().broadcastAll(new ClientboundPlayerInfoUpdatePacket(EnumSet.of(ClientboundPlayerInfoUpdatePacket.Action.UPDATE_LATENCY), listPlayers));
            }
        }
    }

    private void b(@Nullable MinecraftServer minecraftServer, @NotNull ServerLevel serverLevel) {
        Map mapD = this.f185a.a(oK.class).d();
        if (mapD.isEmpty()) {
            return;
        }
        a((Level) serverLevel, minecraftServer);
        mapD.values().forEach(oKVar -> {
            oF<?, ?, ?> oFVarA = oKVar.a();
            if (oFVarA != null) {
                oFVarA.a((AbstractC0264ju<?, ?, ?>) this, serverLevel);
            }
        });
    }

    public boolean a(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull oF<?, ?, ?> oFVar) {
        C0263jt.log("Attempting to assign player '%s' to game '%s'.", serverPlayer.getScoreboardName(), oFVar.m757e());
        UUID uuid = serverPlayer.getUUID();
        if (!oFVar.a((AbstractC0264ju<?, ?, ?>) this, oS.NEW, serverLevel, serverPlayer)) {
            return false;
        }
        oI oIVarB = oFVar.b();
        Set<UUID> setH = oIVarB.h();
        oO oOVarA = oIVarB.a(uuid);
        MutableComponent mutableComponentLiteral = Component.literal(serverPlayer.getScoreboardName());
        Component componentWithStyle = ib;
        if (oOVarA != null) {
            mutableComponentLiteral = mutableComponentLiteral.withStyle(oOVarA.a());
            componentWithStyle = componentWithStyle.copy().withStyle(oOVarA.b());
        }
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.player.join", new Object[]{mutableComponentLiteral}).withStyle(ChatFormatting.GRAY);
        for (UUID uuid2 : setH) {
            if (!uuid2.equals(uuid)) {
                oR.a(uuid2, componentWithStyle, (Component) mutableComponentWithStyle);
            }
        }
        C0263jt.log("Sending initial game packet to player '%s'.", serverPlayer.getScoreboardName());
        C0582vo.a(new C0609wo(oFVar, true), serverPlayer);
        jN.a(oFVar, serverLevel, serverPlayer);
        return true;
    }

    public boolean b(@NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull oF<?, ?, ?> oFVar) {
        C0263jt.log("Attempting to assign spectator '%s' to game '%s'.", serverPlayer.getScoreboardName(), oFVar.m757e());
        oI oIVarB = oFVar.b();
        MatchSettings matchSettingsM766a = oFVar.m766a();
        if (oIVarB.h().isEmpty()) {
            C0263jt.log("Rejected spectator '%s' for game '%s' (match is empty, all players left).", serverPlayer.getScoreboardName(), oFVar.m757e());
            return false;
        }
        if (!oFVar.bc() || !matchSettingsM766a.allowsSpectators() || oIVarB.i().size() >= matchSettingsM766a.getMaxSpectators()) {
            C0263jt.log("Rejected spectator '%s' for game '%s' (spectating disabled or at capacity).", serverPlayer.getScoreboardName(), oFVar.m757e());
            return false;
        }
        oIVarB.b(this, serverLevel, serverPlayer);
        C0582vo.a(new C0609wo(oFVar, true), serverPlayer);
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.player.join.spectator", new Object[]{Component.literal(serverPlayer.getScoreboardName())}).withStyle(ChatFormatting.GRAY);
        for (UUID uuid : oIVarB.j()) {
            if (!uuid.equals(serverPlayer.getUUID())) {
                oR.a(uuid, ib, (Component) mutableComponentWithStyle);
            }
        }
        jN.a(oFVar, serverLevel, serverPlayer);
        return true;
    }

    private void a(@NotNull Level level, @Nullable MinecraftServer minecraftServer) {
        if (this.dv) {
            return;
        }
        this.dv = true;
        GameRules gameRules = level.getGameRules();
        if ((this instanceof xw) && ((xw) this).f() && (level instanceof ServerLevel)) {
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
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public H m531a() {
        return this.a;
    }

    @Nullable
    public oF<?, ?, ?> a(@NotNull Player player) {
        return mo604a(player.getUUID());
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public oF<?, ?, ?> mo604a(@NotNull UUID uuid) {
        return this.r.get(uuid);
    }

    public void a(@NotNull UUID uuid, @NotNull oF<?, ?, ?> oFVar) {
        this.r.put(uuid, oFVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m533a(@NotNull UUID uuid) {
        this.r.remove(uuid);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        oF<?, ?, ?> oFVarMo604a = mo604a(uuid);
        if (oFVarMo604a == 0) {
            return;
        }
        if (oFVarMo604a instanceof InterfaceC0463rd) {
            oR.m792a(oFVarMo604a, uuid, C0529tp.g, ((InterfaceC0463rd) oFVarMo604a).bw());
        }
        oFVarMo604a.b().a(abstractC0264ju, cVar, serverLevel, serverPlayer, uuid);
    }

    public boolean e(@NotNull UUID uuid) {
        return mo604a(uuid) != null;
    }

    public boolean a(@NotNull UUID uuid, @NotNull UUID uuid2) {
        oF<?, ?, ?> oFVarMo604a = mo604a(uuid);
        return oFVarMo604a != null && oFVarMo604a.b().f(uuid2);
    }

    @Nullable
    public oF<?, ?, ?> a(@NotNull String str) {
        return this.s.get(str.toLowerCase(Locale.ROOT));
    }

    @Nullable
    public oF<?, ?, ?> b(@NotNull UUID uuid) {
        return this.t.get(uuid);
    }

    public void b(@NotNull oF<?, ?, ?> oFVar) {
        this.s.put(oFVar.L().toLowerCase(Locale.ROOT), oFVar);
        this.t.put(oFVar.m757e(), oFVar);
    }

    public void c(@NotNull oF<?, ?, ?> oFVar) {
        this.s.remove(oFVar.L().toLowerCase(Locale.ROOT), oFVar);
        this.t.remove(oFVar.m757e(), oFVar);
    }

    public void a(@NotNull oF<?, ?, ?> oFVar, @NotNull UUID uuid, @NotNull UUID uuid2) {
        if (this.t.remove(uuid, oFVar)) {
            this.t.put(uuid2, oFVar);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public Map<String, oK> m534b() {
        return this.f185a.a(oK.class).d();
    }

    @NotNull
    public Map<String, oK> c() {
        jM jMVarA = this.f185a.a(oK.class);
        Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap();
        for (Map.Entry entry : jMVarA.d().entrySet()) {
            String str = (String) entry.getKey();
            oK oKVar = (oK) entry.getValue();
            if (oKVar.bo()) {
                object2ObjectOpenHashMap.put(str, oKVar);
            }
        }
        return object2ObjectOpenHashMap;
    }

    @Nullable
    public oF<?, ?, ?> a(@NotNull BlockPos blockPos, double d) {
        oX oXVarC;
        oF<?, ?, ?> oFVar = null;
        double d2 = -1.0d;
        Iterator it = this.f185a.a(oK.class).d().values().iterator();
        while (it.hasNext()) {
            oF<?, ?, ?> oFVarA = ((oK) it.next()).a();
            if (oFVarA != null && oFVarA.m750a() == oN.GAME && (oXVarC = oFVarA.b().c()) != null) {
                double dA = oXVarC.a(blockPos);
                if (dA <= d && (d2 < 0.0d || dA < d2)) {
                    oFVar = oFVarA;
                    d2 = dA;
                }
            }
        }
        return oFVar;
    }

    @NotNull
    public List<oF<?, ?, ?>> a(@NotNull sW sWVar, @Nullable oF<?, ?, ?> oFVar) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        String strAm = sWVar.am();
        Iterator<oK> it = c().values().iterator();
        while (it.hasNext()) {
            oF<?, ?, ?> oFVarA = it.next().a();
            if (oFVarA != null && oFVarA.M().equalsIgnoreCase(strAm) && !a(oFVarA.m751a().getName(), oFVar)) {
                objectArrayList.add(oFVarA);
            }
        }
        return objectArrayList;
    }

    public boolean a(@NotNull sX sXVar, @Nullable oF<?, ?, ?> oFVar) {
        return a(sXVar.getName(), oFVar);
    }

    public boolean a(@NotNull String str, @Nullable oF<?, ?, ?> oFVar) {
        Iterator it = this.f185a.a(oK.class).d().values().iterator();
        while (it.hasNext()) {
            oF<?, ?, ?> oFVarA = ((oK) it.next()).a();
            if (oFVarA != null && !oFVarA.equals(oFVar) && ((oFVarA.m750a() != oN.IDLE && oFVarA.m751a().getName().equalsIgnoreCase(str)) || oFVarA.m758a().l(str))) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public UUID m535c() {
        return this.n;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public jO m536b() {
        return this.f185a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public CloudRegistry m537a() {
        return this.f188a;
    }

    @OverridingMethodsMustInvokeSuper
    public void a(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatus connectionStatus2, @NotNull ConnectionStatusContext connectionStatusContext) {
        if (connectionStatus.isClosed() && connectionStatus2.isConnected()) {
            C0263jt.log("[Cloud] Established connection to the cloud.", new Object[0]);
        } else if (connectionStatus.isConnected() && connectionStatus2.isClosed()) {
            C0263jt.log("[Cloud] Lost connection to the cloud.", new Object[0]);
        }
    }
}
