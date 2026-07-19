package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.MatchData;
import com.boehmod.bflib.cloud.common.MatchSettings;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.mm.MatchJoinIntent;
import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.cloud.connection.ConnectionStatusContext;
import com.boehmod.bflib.cloud.packet.common.server.PacketServerGameStatus;
import com.boehmod.blockfront.server.net.PacketListenerInteraction;
import com.boehmod.blockfront.server.net.PacketListenerPlayerAction;
import com.boehmod.blockfront.server.net.PacketListenerPlayerMove;
import com.boehmod.blockfront.xt;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xw.class */
public final class xw extends AbstractC0264ju<xQ, xu, xA> {

    @NotNull
    private static final Component jZ;

    @NotNull
    private static final Component ka;

    @NotNull
    private static final Component kb;
    private static final int ui = 100;

    @NotNull
    private final xR a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final xt f405a;

    @NotNull
    private final C0628xg e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private xs f406a;

    @NotNull
    private String l;
    private int uj;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final xy f407a;
    static final /* synthetic */ boolean jH;

    static {
        jH = !xw.class.desiredAssertionStatus();
        jZ = Component.translatable("bf.message.disconnect.mm.error.no.match").withStyle(ChatFormatting.RED);
        ka = Component.translatable("bf.message.disconnect.mm.error", new Object[]{jZ});
        kb = Component.translatable("bf.message.disconnect.mm.error.admin").withStyle(ChatFormatting.RED);
    }

    public xw() {
        super(new xQ());
        this.f405a = new xt();
        this.e = new C0628xg();
        this.f406a = xs.a();
        this.l = C0002a.d;
        this.uj = 0;
        dG();
        this.a = new xR(this);
        this.f407a = new xy(this.l, this.f406a.dt());
    }

    @NotNull
    public xy a() {
        return this.f407a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public xR m1709a() {
        return this.a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public xt m1710a() {
        return this.f405a;
    }

    private void dG() {
        MinecraftServer minecraftServerA;
        this.f406a = xs.a(new File(C0002a.e + "mm_server.json"));
        if (!this.f406a.aF().equals("default")) {
            this.l = this.f406a.aF();
        }
        if (this.f406a.dr() && (minecraftServerA = C0262js.a()) != null) {
            minecraftServerA.setMotd("bf MM Server (P:'" + minecraftServerA.getPort() + "' R:'" + this.f406a.b().getId() + "')");
        }
    }

    public void G(@NotNull String str) {
        log("*** Shutting Down by BlockFront ***");
        log(str);
        MinecraftServer minecraftServerA = C0262js.a();
        if (minecraftServerA != null) {
            minecraftServerA.halt(true);
        }
    }

    public void j(@NotNull ServerPlayer serverPlayer) {
        ServerLevel serverLevel = serverPlayer.serverLevel();
        UUID uuid = serverPlayer.getUUID();
        oF<?, ?, ?> oFVarA = mo604a(uuid);
        if (oFVarA != null) {
            oFVarA.a(this, serverLevel, serverPlayer);
        }
        if (C0262js.ac()) {
            ((xQ) this.a).r(uuid);
        }
        ((xQ) this.a).q(uuid);
        ((xA) this.f186a).a().s(uuid);
    }

    public void k(@NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        xQ xQVar = (xQ) a();
        if (!f()) {
            MinecraftServer minecraftServerA = C0262js.a();
            if (!jH && minecraftServerA == null) {
                throw new AssertionError();
            }
            ServerLevel level = minecraftServerA.getLevel(Level.OVERWORLD);
            if (level != null) {
                xQVar.a((AbstractC0264ju<?, ?, ?>) this, (Level) level);
            }
        }
        if (f()) {
            ServerLevel serverLevel = serverPlayer.serverLevel();
            BlockPos spawnPos = serverLevel.getLevelData().getSpawnPos();
            serverPlayer.setPos(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
            serverPlayer.teleportTo(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
            oR.a(xQVar, serverLevel, serverPlayer);
            if (!a(serverPlayer, uuid)) {
                if (!xQVar.mo306a(uuid).j(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN)) {
                    C0263jt.log("Kicking player '%s' (%s) from the server, no match found!", serverPlayer.getScoreboardName(), uuid);
                    serverPlayer.sendSystemMessage(ka);
                    serverPlayer.connection.disconnect(ka);
                    return;
                }
                serverPlayer.sendSystemMessage(ka);
                serverPlayer.sendSystemMessage(kb);
            }
        }
        Connection connection = serverPlayer.connection.getConnection();
        C0263jt.log("Added custom packet listener for player connection '" + String.valueOf(serverPlayer.getUUID()) + "'.", new Object[0]);
        ChannelPipeline channelPipelinePipeline = connection.channel().pipeline();
        channelPipelinePipeline.addBefore("packet_handler", "mod_packet_handler_actions", new PacketListenerPlayerAction());
        channelPipelinePipeline.addBefore("packet_handler", "mod_packet_handler_interaction", new PacketListenerInteraction());
        channelPipelinePipeline.addBefore("packet_handler", "mod_packet_handler_move", new PacketListenerPlayerMove());
        iO iOVarA = ((xu) b()).mo409a();
        iOVarA.b(RequestType.PLAYER_DATA, uuid);
        iOVarA.b(RequestType.INVENTORY_MINIMAL, uuid);
    }

    private boolean a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        boolean zA;
        String scoreboardName = serverPlayer.getScoreboardName();
        xt xtVarM1710a = m1710a();
        C0263jt.log(String.format("Attempting to assign player '%s' (%s) to scheduled match...", scoreboardName, uuid), new Object[0]);
        xt.a aVarA = xtVarM1710a.a(serverPlayer.getUUID());
        if (aVarA == null) {
            C0263jt.log("Failed to assign player to scheduled match, no match found!", new Object[0]);
            return false;
        }
        UUID uuidR = aVarA.r();
        C0263jt.log(String.format("Found scheduled match '%s' for player '%s' (%s)", uuidR, scoreboardName, uuid), new Object[0]);
        oF<?, ?, ?> oFVarB = b(uuidR);
        if (oFVarB == null) {
            C0263jt.log("Failed to assign player to scheduled match, no game found!", new Object[0]);
            return false;
        }
        ServerLevel serverLevel = serverPlayer.serverLevel();
        if (aVarA.a() == MatchJoinIntent.SPECTATING) {
            zA = b(serverLevel, serverPlayer, oFVarB);
        } else {
            zA = a(serverLevel, serverPlayer, oFVarB);
        }
        if (zA) {
            C0263jt.log(String.format("Assigned player '%s' (%s) to match '%s' (intent %s)", scoreboardName, uuid, oFVarB.m757e(), aVarA.a()), new Object[0]);
            return true;
        }
        C0263jt.log("Failed to assign player to scheduled match!", new Object[0]);
        return false;
    }

    public void dH() {
        ((xu) this.f187a).aU();
    }

    public void log(@NotNull String str) {
        MinecraftServer minecraftServerA;
        if (C0262js.ac() && (minecraftServerA = C0262js.a()) != null) {
            minecraftServerA.sendSystemMessage(Component.literal(str));
        }
    }

    private void dI() {
        int i = this.uj;
        this.uj = i + 1;
        if (i > 100) {
            this.uj = 0;
            dJ();
        }
    }

    private void dJ() {
        sW sWVarA;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Collection<oK> collectionValues = c().values();
        xt xtVarM1710a = m1710a();
        Iterator<oK> it = collectionValues.iterator();
        while (it.hasNext()) {
            oF<?, ?, ?> oFVarA = it.next().a();
            if (oFVarA != null && (sWVarA = sW.a(oFVarA.M())) != null) {
                UUID uuidM757e = oFVarA.m757e();
                oI oIVarB = oFVarA.b();
                int iAX = oIVarB.aX();
                MatchSettings matchSettings = new MatchSettings();
                matchSettings.copyFrom(oFVarA.m766a());
                if (!oFVarA.bc()) {
                    matchSettings.setAllowSpectators(false);
                }
                ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet(oIVarB.h());
                objectOpenHashSet.addAll(xtVarM1710a.m1707a(uuidM757e));
                Set<UUID> objectOpenHashSet2 = new ObjectOpenHashSet<>(oIVarB.i());
                objectOpenHashSet2.addAll(xtVarM1710a.b(uuidM757e));
                MatchData matchData = new MatchData(objectOpenHashSet, uuidM757e, oFVarA.m751a().getName(), sWVarA.a(), iAX, matchSettings, oIVarB.bn());
                matchData.addSpectators(objectOpenHashSet2);
                objectArrayList.add(matchData);
            }
        }
        ((xu) this.f187a).sendPacket(new PacketServerGameStatus(objectArrayList, this.f406a.b()));
    }

    @NotNull
    public xs b() {
        return this.f406a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m1711a() {
        return this.l;
    }

    @Override // com.boehmod.blockfront.AbstractC0264ju
    public boolean f() {
        return this.f406a.dr();
    }

    @Override // com.boehmod.blockfront.AbstractC0264ju
    public boolean g() {
        return ((xu) this.f187a).mo409a().isVerified();
    }

    @Override // com.boehmod.blockfront.AbstractC0264ju
    public void a(@NotNull ConnectionStatus connectionStatus, @NotNull ConnectionStatus connectionStatus2, @NotNull ConnectionStatusContext connectionStatusContext) {
        super.a(connectionStatus, connectionStatus2, connectionStatusContext);
    }

    @Override // com.boehmod.blockfront.AbstractC0264ju
    @NotNull
    /* JADX INFO: renamed from: a */
    protected jO mo603a() {
        return new jO(this, false);
    }

    @Override // com.boehmod.blockfront.AbstractC0264ju
    /* JADX INFO: renamed from: a */
    public xA mo528a() {
        return new xA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0264ju
    @NotNull
    /* JADX INFO: renamed from: a */
    public xu mo530a() {
        return new xu(this);
    }

    @Override // com.boehmod.blockfront.AbstractC0264ju
    public void a(@Nullable MinecraftServer minecraftServer, @NotNull ServerLevel serverLevel) {
        super.a(minecraftServer, serverLevel);
        ((xA) this.f186a).b(this);
        ((xu) this.f187a).onUpdate();
        this.e.a(this, (Iterable<Entity>) null, serverLevel.getGameTime(), (LivingEntity) null);
        jF.a(this.e);
        dI();
        this.f407a.onUpdate();
    }

    @Override // com.boehmod.blockfront.AbstractC0264ju
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0628xg mo532a() {
        return this.e;
    }
}
