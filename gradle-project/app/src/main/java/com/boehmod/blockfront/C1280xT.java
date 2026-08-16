package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.MatchData;
import com.boehmod.bflib.cloud.common.MatchSettings;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.p001mm.MatchJoinIntent;
import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.cloud.connection.ConnectionStatusContext;
import com.boehmod.bflib.cloud.packet.common.server.PacketServerGameStatus;
import com.boehmod.blockfront.server.net.PacketListenerInteraction;
import com.boehmod.blockfront.server.net.PacketListenerPlayerAction;
import com.boehmod.blockfront.server.net.PacketListenerPlayerMove;
import io.netty.channel.ChannelPipeline;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xT.class */
public final class C1280xT extends AbstractC0531jN<C1328yo, C1278xR, C1284xX> {

    /* JADX INFO: renamed from: km */
    @NotNull
    private static final Component f6882km;

    /* JADX INFO: renamed from: kn */
    @NotNull
    private static final Component f6883kn;

    /* JADX INFO: renamed from: ko */
    @NotNull
    private static final Component f6884ko;

    /* JADX INFO: renamed from: wm */
    private static final int f6885wm = 100;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1329yp f6886a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1277xQ f6887a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1330yq f6888a;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final C1264xD f6889f;

    /* JADX INFO: renamed from: a */
    @NotNull
    private C1276xP f6890a;

    /* JADX INFO: renamed from: m */
    @NotNull
    private String f6891m;

    /* JADX INFO: renamed from: wn */
    private int f6892wn;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1282xV f6893a;

    /* JADX INFO: renamed from: jX */
    static final /* synthetic */ boolean f6894jX;

    static {
        f6894jX = !C1280xT.class.desiredAssertionStatus();
        f6882km = Component.translatable("bf.message.disconnect.mm.error.no.match").withStyle(ChatFormatting.RED);
        f6883kn = Component.translatable("bf.message.disconnect.mm.error", new Object[]{f6882km});
        f6884ko = Component.translatable("bf.message.disconnect.mm.error.admin").withStyle(ChatFormatting.RED);
    }

    public C1280xT() {
        super(new C1328yo());
        this.f6887a = new C1277xQ();
        this.f6888a = new C1330yq();
        this.f6889f = new C1264xD();
        this.f6890a = C1276xP.m7249a();
        this.f6891m = C0030a.f270d;
        this.f6892wn = 0;
        m7281dQ();
        this.f6886a = new C1329yp(this);
        this.f6893a = new C1282xV(this.f6891m, this.f6890a.m7258dC());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1282xV m7277a() {
        return this.f6893a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1329yp m7278a() {
        return this.f6886a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1277xQ m7279a() {
        return this.f6887a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1330yq m7280a() {
        return this.f6888a;
    }

    /* JADX INFO: renamed from: dQ */
    private void m7281dQ() {
        MinecraftServer minecraftServerM2335a;
        this.f6890a = C1276xP.m7250a(new File(C0030a.f273f + "mm_server.json"));
        if (!this.f6890a.m7253aM().equals("default")) {
            this.f6891m = this.f6890a.m7253aM();
        }
        if (this.f6890a.m7254dA() && (minecraftServerM2335a = C0529jL.m2335a()) != null) {
            minecraftServerM2335a.setMotd("bf MM Server (P:'" + minecraftServerM2335a.getPort() + "' R:'" + this.f6890a.m7252b().getId() + "')");
        }
    }

    /* JADX INFO: renamed from: G */
    public void m7282G(@NotNull String str) {
        log("*** Shutting Down by BlockFront ***");
        log(str);
        MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
        if (minecraftServerM2335a != null) {
            minecraftServerM2335a.halt(true);
        }
    }

    /* JADX INFO: renamed from: j */
    public void m7283j(@NotNull ServerPlayer serverPlayer) {
        ServerLevel serverLevel = serverPlayer.serverLevel();
        UUID uuid = serverPlayer.getUUID();
        AbstractC0863pb<?, ?, ?> abstractC0863pbA = mo2354a(uuid);
        if (abstractC0863pbA != null) {
            abstractC0863pbA.m4067a(this, serverLevel, serverPlayer);
        }
        if (C0529jL.m2333af()) {
            ((C1328yo) this.f3171a).m1159r(uuid);
        }
        ((C1328yo) this.f3171a).m1158q(uuid);
        ((C1284xX) this.f3178a).m2407a().m7304s(uuid);
    }

    /* JADX INFO: renamed from: k */
    public void m7284k(@NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        C1328yo c1328yo = (C1328yo) m7277a();
        if (!mo2374f()) {
            MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
            if (!f6894jX && minecraftServerM2335a == null) {
                throw new AssertionError();
            }
            ServerLevel level = minecraftServerM2335a.getLevel(Level.OVERWORLD);
            if (level != null) {
                c1328yo.m1156a((AbstractC0531jN<?, ?, ?>) this, (Level) level);
            }
        }
        if (mo2374f()) {
            ServerLevel serverLevel = serverPlayer.serverLevel();
            BlockPos spawnPos = serverLevel.getLevelData().getSpawnPos();
            serverPlayer.setPos(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
            serverPlayer.teleportTo(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
            C0875pn.m4384a(c1328yo, serverLevel, serverPlayer);
            if (!m7285a(serverPlayer, uuid)) {
                if (!c1328yo.mo1154a(uuid).m2516l(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN)) {
                    C0530jM.log("Kicking player '%s' (%s) from the server, no match found!", serverPlayer.getScoreboardName(), uuid);
                    serverPlayer.sendSystemMessage(f6883kn);
                    serverPlayer.connection.disconnect(f6883kn);
                    return;
                }
                serverPlayer.sendSystemMessage(f6883kn);
                serverPlayer.sendSystemMessage(f6884ko);
            }
        }
        Connection connection = serverPlayer.connection.getConnection();
        C0530jM.log("Added custom packet listener for player connection '" + String.valueOf(serverPlayer.getUUID()) + "'.", new Object[0]);
        ChannelPipeline channelPipelinePipeline = connection.channel().pipeline();
        channelPipelinePipeline.addBefore("packet_handler", "mod_packet_handler_actions", new PacketListenerPlayerAction());
        channelPipelinePipeline.addBefore("packet_handler", "mod_packet_handler_interaction", new PacketListenerInteraction());
        channelPipelinePipeline.addBefore("packet_handler", "mod_packet_handler_move", new PacketListenerPlayerMove());
        C0551jh c0551jhA = ((C1278xR) m7289b()).mo1729a();
        c0551jhA.m2492b(RequestType.PLAYER_DATA, uuid);
        c0551jhA.m2492b(RequestType.INVENTORY_MINIMAL, uuid);
    }

    /* JADX INFO: renamed from: a */
    private boolean m7285a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        boolean zA;
        String scoreboardName = serverPlayer.getScoreboardName();
        C1277xQ c1277xQM7279a = m7279a();
        C0530jM.log(String.format("Attempting to assign player '%s' (%s) to scheduled match...", scoreboardName, uuid), new Object[0]);
        C1277xQ.a aVarM7260a = c1277xQM7279a.m7260a(serverPlayer.getUUID());
        if (aVarM7260a == null) {
            C0530jM.log("Failed to assign player to scheduled match, no match found!", new Object[0]);
            return false;
        }
        UUID uuidM7267s = aVarM7260a.m7267s();
        C0530jM.log(String.format("Found scheduled match '%s' for player '%s' (%s)", uuidM7267s, scoreboardName, uuid), new Object[0]);
        AbstractC0863pb<?, ?, ?> abstractC0863pbB = m2361b(uuidM7267s);
        if (abstractC0863pbB == null) {
            C0530jM.log("Failed to assign player to scheduled match, no game found!", new Object[0]);
            return false;
        }
        ServerLevel serverLevel = serverPlayer.serverLevel();
        if (aVarM7260a.m7268a() == MatchJoinIntent.SPECTATING) {
            zA = m2349b(serverLevel, serverPlayer, abstractC0863pbB);
        } else {
            zA = m2348a(serverLevel, serverPlayer, abstractC0863pbB);
        }
        if (zA) {
            C0530jM.log(String.format("Assigned player '%s' (%s) to match '%s' (intent %s)", scoreboardName, uuid, abstractC0863pbB.m4064e(), aVarM7260a.m7268a()), new Object[0]);
            return true;
        }
        C0530jM.log("Failed to assign player to scheduled match!", new Object[0]);
        return false;
    }

    /* JADX INFO: renamed from: dR */
    public void m7286dR() {
        ((C1278xR) this.f3179a).m2473bg();
    }

    public void log(@NotNull String str) {
        MinecraftServer minecraftServerM2335a;
        if (C0529jL.m2333af() && (minecraftServerM2335a = C0529jL.m2335a()) != null) {
            minecraftServerM2335a.sendSystemMessage(Component.literal(str));
        }
    }

    /* JADX INFO: renamed from: dS */
    private void m7287dS() {
        int i = this.f6892wn;
        this.f6892wn = i + 1;
        if (i > 100) {
            this.f6892wn = 0;
            m7288dT();
        }
    }

    /* JADX INFO: renamed from: dT */
    private void m7288dT() {
        C1094tt c1094ttM6019a;
        m7277a().m5889b(this.f3179a);
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Collection<C0868pg> collectionValues = m2366c().values();
        C1277xQ c1277xQM7279a = m7279a();
        Iterator<C0868pg> it = collectionValues.iterator();
        while (it.hasNext()) {
            AbstractC0863pb<?, ?, ?> abstractC0863pbM4272a = it.next().m4272a();
            if (abstractC0863pbM4272a != null && (c1094ttM6019a = C1094tt.m6019a(abstractC0863pbM4272a.m4030T())) != null) {
                UUID uuidM4064e = abstractC0863pbM4272a.m4064e();
                AbstractC0866pe abstractC0866peM4018b = abstractC0863pbM4272a.m4018b();
                int iM4220bm = abstractC0866peM4018b.m4220bm();
                MatchSettings matchSettings = new MatchSettings();
                matchSettings.copyFrom(abstractC0863pbM4272a.m4088a());
                if (!abstractC0863pbM4272a.mo4048bm()) {
                    matchSettings.setAllowSpectators(false);
                }
                ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet(abstractC0866peM4018b.m4245h());
                objectOpenHashSet.addAll(c1277xQM7279a.m7261a(uuidM4064e));
                Set<UUID> objectOpenHashSet2 = new ObjectOpenHashSet<>(abstractC0866peM4018b.m4246i());
                objectOpenHashSet2.addAll(c1277xQM7279a.m7262b(uuidM4064e));
                MatchData matchData = new MatchData(objectOpenHashSet, uuidM4064e, abstractC0863pbM4272a.m4027a().getName(), c1094ttM6019a.m6022a(), iM4220bm, matchSettings, abstractC0866peM4018b.mo4270bx());
                matchData.addSpectators(objectOpenHashSet2);
                objectArrayList.add(matchData);
            }
        }
        ((C1278xR) this.f3179a).sendPacket(new PacketServerGameStatus(objectArrayList, this.f6890a.m7252b()));
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1276xP m7289b() {
        return this.f6890a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public String m7290a() {
        return this.f6891m;
    }

    @Override // com.boehmod.blockfront.AbstractC0531jN
    /* JADX INFO: renamed from: f */
    public boolean mo2374f() {
        return this.f6890a.m7254dA();
    }

    @Override // com.boehmod.blockfront.AbstractC0531jN
    /* JADX INFO: renamed from: g */
    public boolean mo2375g() {
        return ((C1278xR) this.f3179a).mo1729a().isVerified();
    }

    @Override // com.boehmod.blockfront.AbstractC0531jN
    /* JADX INFO: renamed from: a */
    public void mo2376a(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatus connectionStatus2, @NotNull ConnectionStatusContext connectionStatusContext) {
        super.mo2376a(connectionStatus, connectionStatus2, connectionStatusContext);
    }

    @Override // com.boehmod.blockfront.AbstractC0531jN
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0607kk mo2339a() {
        return new C0607kk(this, false);
    }

    @Override // com.boehmod.blockfront.AbstractC0531jN
    /* JADX INFO: renamed from: a */
    public C1284xX mo2340a() {
        return new C1284xX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0531jN
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1278xR mo2344a() {
        return new C1278xR(this);
    }

    @Override // com.boehmod.blockfront.AbstractC0531jN
    /* JADX INFO: renamed from: a */
    public void mo2345a(@Nullable MinecraftServer minecraftServer, @NotNull ServerLevel serverLevel) {
        super.mo2345a(minecraftServer, serverLevel);
        ((C1284xX) this.f3178a).mo2406b(this);
        ((C1278xR) this.f3179a).onUpdate();
        m7277a().m5888a(this.f3179a);
        this.f6889f.m7126a(this, (Iterable<Entity>) null, serverLevel.getGameTime(), (LivingEntity) null);
        C0542jY.m2438a(this.f6889f);
        m7287dS();
        this.f6893a.onUpdate();
    }

    @Override // com.boehmod.blockfront.AbstractC0531jN
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1264xD mo2352a() {
        return this.f6889f;
    }
}
