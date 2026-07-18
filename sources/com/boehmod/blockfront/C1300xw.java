package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.MatchData;
import com.boehmod.bflib.cloud.common.MatchSettings;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.p000mm.MatchJoinIntent;
import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.cloud.connection.ConnectionStatusContext;
import com.boehmod.bflib.cloud.packet.common.server.PacketServerGameStatus;
import com.boehmod.blockfront.C1297xt;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.xw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xw.class */
public final class C1300xw extends AbstractC0563ju<C1276xQ, C1298xu, C1260xA> {

    /* JADX INFO: renamed from: jZ */
    @NotNull
    private static final Component f8684jZ;

    /* JADX INFO: renamed from: ka */
    @NotNull
    private static final Component f8685ka;

    /* JADX INFO: renamed from: kb */
    @NotNull
    private static final Component f8686kb;

    /* JADX INFO: renamed from: ui */
    private static final int f8687ui = 100;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1277xR f8688a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1297xt f8689a;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final C1284xg f8690e;

    /* JADX INFO: renamed from: a */
    @NotNull
    private C1296xs f8691a;

    /* JADX INFO: renamed from: l */
    @NotNull
    private String f8692l;

    /* JADX INFO: renamed from: uj */
    private int f8693uj;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1302xy f8694a;

    /* JADX INFO: renamed from: jH */
    static final /* synthetic */ boolean f8695jH;

    static {
        f8695jH = !C1300xw.class.desiredAssertionStatus();
        f8684jZ = Component.translatable("bf.message.disconnect.mm.error.no.match").withStyle(ChatFormatting.RED);
        f8685ka = Component.translatable("bf.message.disconnect.mm.error", new Object[]{f8684jZ});
        f8686kb = Component.translatable("bf.message.disconnect.mm.error.admin").withStyle(ChatFormatting.RED);
    }

    public C1300xw() {
        super(new C1276xQ());
        this.f8689a = new C1297xt();
        this.f8690e = new C1284xg();
        this.f8691a = C1296xs.m7922a();
        this.f8692l = C0029a.f253d;
        this.f8693uj = 0;
        m7953dG();
        this.f8688a = new C1277xR(this);
        this.f8694a = new C1302xy(this.f8692l, this.f8691a.m7931dt());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1302xy m7950a() {
        return this.f8694a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1277xR m7951a() {
        return this.f8688a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1297xt m7952a() {
        return this.f8689a;
    }

    /* JADX INFO: renamed from: dG */
    private void m7953dG() {
        MinecraftServer minecraftServerM2514a;
        this.f8691a = C1296xs.m7923a(new File(C0029a.f255e + "mm_server.json"));
        if (!this.f8691a.m7926aF().equals("default")) {
            this.f8692l = this.f8691a.m7926aF();
        }
        if (this.f8691a.m7927dr() && (minecraftServerM2514a = C0561js.m2514a()) != null) {
            minecraftServerM2514a.setMotd("bf MM Server (P:'" + minecraftServerM2514a.getPort() + "' R:'" + this.f8691a.m7925b().getId() + "')");
        }
    }

    /* JADX INFO: renamed from: G */
    public void m7954G(@NotNull String str) {
        log("*** Shutting Down by BlockFront ***");
        log(str);
        MinecraftServer minecraftServerM2514a = C0561js.m2514a();
        if (minecraftServerM2514a != null) {
            minecraftServerM2514a.halt(true);
        }
    }

    /* JADX INFO: renamed from: j */
    public void m7955j(@NotNull ServerPlayer serverPlayer) {
        ServerLevel serverLevel = serverPlayer.serverLevel();
        UUID uuid = serverPlayer.getUUID();
        AbstractC0787oF<?, ?, ?> abstractC0787oFA = mo2531a(uuid);
        if (abstractC0787oFA != null) {
            abstractC0787oFA.m3631a(this, serverLevel, serverPlayer);
        }
        if (C0561js.m2513ac()) {
            ((C1276xQ) this.f3188a).m1142r(uuid);
        }
        ((C1276xQ) this.f3188a).m1141q(uuid);
        ((C1260xA) this.f3195a).m2582a().m7746s(uuid);
    }

    /* JADX INFO: renamed from: k */
    public void m7956k(@NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        C1276xQ c1276xQ = (C1276xQ) m7950a();
        if (!mo2551f()) {
            MinecraftServer minecraftServerM2514a = C0561js.m2514a();
            if (!f8695jH && minecraftServerM2514a == null) {
                throw new AssertionError();
            }
            ServerLevel level = minecraftServerM2514a.getLevel(Level.OVERWORLD);
            if (level != null) {
                c1276xQ.m1139a((AbstractC0563ju<?, ?, ?>) this, (Level) level);
            }
        }
        if (mo2551f()) {
            ServerLevel serverLevel = serverPlayer.serverLevel();
            BlockPos spawnPos = serverLevel.getLevelData().getSpawnPos();
            serverPlayer.setPos(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
            serverPlayer.teleportTo(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
            C0799oR.m3948a(c1276xQ, serverLevel, serverPlayer);
            if (!m7957a(serverPlayer, uuid)) {
                if (!c1276xQ.mo1137a(uuid).m2189j(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN)) {
                    C0562jt.log("Kicking player '%s' (%s) from the server, no match found!", serverPlayer.getScoreboardName(), uuid);
                    serverPlayer.sendSystemMessage(f8685ka);
                    serverPlayer.connection.disconnect(f8685ka);
                    return;
                }
                serverPlayer.sendSystemMessage(f8685ka);
                serverPlayer.sendSystemMessage(f8686kb);
            }
        }
        Connection connection = serverPlayer.connection.getConnection();
        C0562jt.log("Added custom packet listener for player connection '" + String.valueOf(serverPlayer.getUUID()) + "'.", new Object[0]);
        ChannelPipeline channelPipelinePipeline = connection.channel().pipeline();
        channelPipelinePipeline.addBefore("packet_handler", "mod_packet_handler_actions", new PacketListenerPlayerAction());
        channelPipelinePipeline.addBefore("packet_handler", "mod_packet_handler_interaction", new PacketListenerInteraction());
        channelPipelinePipeline.addBefore("packet_handler", "mod_packet_handler_move", new PacketListenerPlayerMove());
        C0478iO c0478iOA = ((C1298xu) m7961b()).mo1723a();
        c0478iOA.m2165b(RequestType.PLAYER_DATA, uuid);
        c0478iOA.m2165b(RequestType.INVENTORY_MINIMAL, uuid);
    }

    /* JADX INFO: renamed from: a */
    private boolean m7957a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        boolean zA;
        String scoreboardName = serverPlayer.getScoreboardName();
        C1297xt c1297xtM7952a = m7952a();
        C0562jt.log(String.format("Attempting to assign player '%s' (%s) to scheduled match...", scoreboardName, uuid), new Object[0]);
        C1297xt.a aVarM7933a = c1297xtM7952a.m7933a(serverPlayer.getUUID());
        if (aVarM7933a == null) {
            C0562jt.log("Failed to assign player to scheduled match, no match found!", new Object[0]);
            return false;
        }
        UUID uuidM7940r = aVarM7933a.m7940r();
        C0562jt.log(String.format("Found scheduled match '%s' for player '%s' (%s)", uuidM7940r, scoreboardName, uuid), new Object[0]);
        AbstractC0787oF<?, ?, ?> abstractC0787oFB = m2538b(uuidM7940r);
        if (abstractC0787oFB == null) {
            C0562jt.log("Failed to assign player to scheduled match, no game found!", new Object[0]);
            return false;
        }
        ServerLevel serverLevel = serverPlayer.serverLevel();
        if (aVarM7933a.m7941a() == MatchJoinIntent.SPECTATING) {
            zA = m2526b(serverLevel, serverPlayer, abstractC0787oFB);
        } else {
            zA = m2525a(serverLevel, serverPlayer, abstractC0787oFB);
        }
        if (zA) {
            C0562jt.log(String.format("Assigned player '%s' (%s) to match '%s' (intent %s)", scoreboardName, uuid, abstractC0787oFB.m3628e(), aVarM7933a.m7941a()), new Object[0]);
            return true;
        }
        C0562jt.log("Failed to assign player to scheduled match!", new Object[0]);
        return false;
    }

    /* JADX INFO: renamed from: dH */
    public void m7958dH() {
        ((C1298xu) this.f3196a).m2146aU();
    }

    public void log(@NotNull String str) {
        MinecraftServer minecraftServerM2514a;
        if (C0561js.m2513ac() && (minecraftServerM2514a = C0561js.m2514a()) != null) {
            minecraftServerM2514a.sendSystemMessage(Component.literal(str));
        }
    }

    /* JADX INFO: renamed from: dI */
    private void m7959dI() {
        int i = this.f8693uj;
        this.f8693uj = i + 1;
        if (i > 100) {
            this.f8693uj = 0;
            m7960dJ();
        }
    }

    /* JADX INFO: renamed from: dJ */
    private void m7960dJ() {
        C1016sW c1016sWM5531a;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Collection<C0792oK> collectionValues = m2543c().values();
        C1297xt c1297xtM7952a = m7952a();
        Iterator<C0792oK> it = collectionValues.iterator();
        while (it.hasNext()) {
            AbstractC0787oF<?, ?, ?> abstractC0787oFM3836a = it.next().m3836a();
            if (abstractC0787oFM3836a != null && (c1016sWM5531a = C1016sW.m5531a(abstractC0787oFM3836a.m3594M())) != null) {
                UUID uuidM3628e = abstractC0787oFM3836a.m3628e();
                AbstractC0790oI abstractC0790oIM3582b = abstractC0787oFM3836a.m3582b();
                int iM3784aX = abstractC0790oIM3582b.m3784aX();
                MatchSettings matchSettings = new MatchSettings();
                matchSettings.copyFrom(abstractC0787oFM3836a.m3652a());
                if (!abstractC0787oFM3836a.mo3612bc()) {
                    matchSettings.setAllowSpectators(false);
                }
                ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet(abstractC0790oIM3582b.m3809h());
                objectOpenHashSet.addAll(c1297xtM7952a.m7934a(uuidM3628e));
                Set<UUID> objectOpenHashSet2 = new ObjectOpenHashSet<>(abstractC0790oIM3582b.m3810i());
                objectOpenHashSet2.addAll(c1297xtM7952a.m7935b(uuidM3628e));
                MatchData matchData = new MatchData(objectOpenHashSet, uuidM3628e, abstractC0787oFM3836a.m3591a().getName(), c1016sWM5531a.m5534a(), iM3784aX, matchSettings, abstractC0790oIM3582b.mo3834bn());
                matchData.addSpectators(objectOpenHashSet2);
                objectArrayList.add(matchData);
            }
        }
        ((C1298xu) this.f3196a).sendPacket(new PacketServerGameStatus(objectArrayList, this.f8691a.m7925b()));
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1296xs m7961b() {
        return this.f8691a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public String m7962a() {
        return this.f8692l;
    }

    @Override // com.boehmod.blockfront.AbstractC0563ju
    /* JADX INFO: renamed from: f */
    public boolean mo2551f() {
        return this.f8691a.m7927dr();
    }

    @Override // com.boehmod.blockfront.AbstractC0563ju
    /* JADX INFO: renamed from: g */
    public boolean mo2552g() {
        return ((C1298xu) this.f3196a).mo1723a().isVerified();
    }

    @Override // com.boehmod.blockfront.AbstractC0563ju
    /* JADX INFO: renamed from: a */
    public void mo2553a(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatus connectionStatus2, @NotNull ConnectionStatusContext connectionStatusContext) {
        super.mo2553a(connectionStatus, connectionStatus2, connectionStatusContext);
    }

    @Override // com.boehmod.blockfront.AbstractC0563ju
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0531jO mo2517a() {
        return new C0531jO(this, false);
    }

    @Override // com.boehmod.blockfront.AbstractC0563ju
    /* JADX INFO: renamed from: a */
    public C1260xA mo2518a() {
        return new C1260xA();
    }

    @Override // com.boehmod.blockfront.AbstractC0563ju
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1298xu mo2521a() {
        return new C1298xu(this);
    }

    @Override // com.boehmod.blockfront.AbstractC0563ju
    /* JADX INFO: renamed from: a */
    public void mo2522a(@Nullable MinecraftServer minecraftServer, @NotNull ServerLevel serverLevel) {
        super.mo2522a(minecraftServer, serverLevel);
        ((C1260xA) this.f3195a).mo2581b(this);
        ((C1298xu) this.f3196a).onUpdate();
        this.f8690e.m7804a(this, (Iterable<Entity>) null, serverLevel.getGameTime(), (LivingEntity) null);
        C0522jF.m2292a(this.f8690e);
        m7959dI();
        this.f8694a.onUpdate();
    }

    @Override // com.boehmod.blockfront.AbstractC0563ju
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1284xg mo2529a() {
        return this.f8690e;
    }
}
