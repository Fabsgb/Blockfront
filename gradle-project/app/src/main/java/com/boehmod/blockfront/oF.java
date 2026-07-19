package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.MatchSettings;
import com.boehmod.bflib.cloud.common.mm.report.IMatchReportData;
import com.boehmod.bflib.cloud.common.mm.report.MatchReportPlayer;
import com.boehmod.bflib.cloud.common.mm.report.MatchResult;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.common.PacketPlayerRandomDrop;
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMMatchReport;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0526tm;
import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
import com.boehmod.blockfront.sW;
import com.mojang.blaze3d.systems.RenderSystem;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.io.IOException;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oF.class */
public abstract class oF<G extends oF<G, P, S>, P extends oI<G>, S extends C0526tm<G, P>> implements Comparable<oF<?, ?, ?>> {
    protected static final int mq = 2400;

    @NotNull
    private static final Component iu;

    @NotNull
    private static final Component iv;

    @NotNull
    private static final Component iw;

    @NotNull
    private static final Component ix;

    @NotNull
    private static final Component iy;

    @NotNull
    private static final Component iz;

    @NotNull
    private static final Component iA;

    @NotNull
    private static final Component iB;

    @NotNull
    private static final Component iC;

    @NotNull
    private static final Component iD;
    private static final int mr = 4;
    private static final int ms = 5;
    private static final int mt = 4;

    @NotNull
    private final ObjectList<AbstractC0475rp> M;

    @NotNull
    private final Object2ObjectMap<UUID, oM> e;

    @NotNull
    private final Component iE;

    @NotNull
    private final C0532ts a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final oL<G> f261a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final C0420po f262a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    protected oN f263a;
    protected String bE;

    @NotNull
    protected String bF;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    protected sX f264a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private sY f265a;
    private int mu;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    protected jL<sX> f266a;

    @NotNull
    public final C0272kb b;

    @Nullable
    private UUID q;
    private int mv;
    private boolean cU;

    @NotNull
    private UUID r;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NotNull
    protected final AbstractC0264ju<?, ?, ?> f267e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    protected final P f268a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    protected final com.boehmod.blockfront.common.player.c<?> f269b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    protected final C0526tm<G, P> f270a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final MatchSettings f271a;
    private boolean fV;
    public static final int mw = 200;
    static final /* synthetic */ boolean fW;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oF$a.class */
    public enum a {
        MAP_TYPE,
        LOBBY,
        TEAM_SPAWNS
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public abstract oG<?, ?> a(@NotNull C0297l c0297l);

    @NotNull
    protected abstract P a();

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract AbstractC0524tk<G, P> mo749a();

    public abstract void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set);

    protected abstract boolean aZ();

    public abstract boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oS oSVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer);

    public abstract void d(@Nullable Level level);

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract InterfaceC0471rl mo752a();

    public abstract void a(@NotNull InterfaceC0471rl interfaceC0471rl);

    public abstract boolean e(@NotNull Player player);

    public abstract boolean f(@NotNull Player player);

    public abstract boolean bd();

    public abstract boolean bf();

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract CloudAchievement mo760a();

    static {
        fW = !oF.class.desiredAssertionStatus();
        iu = Component.translatable("bf.message.gamemode.switchteams.error.noteam");
        iv = Component.translatable("bf.message.gamemode.switchteams.error.unbalanced");
        iw = Component.translatable("bf.message.gamemode.switchteams.error.postgame");
        ix = Component.translatable("bf.message.gamemode.notification.rebalance");
        iy = Component.translatable("bf.message.command.assets.edit.games.tp.fail");
        iz = Component.translatable("bf.message.command.assets.edit.games.lobby");
        iA = Component.translatable("bf.popup.message.firstblood").withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD);
        iB = Component.translatable("bf.message.ingame.soundboard.fail.count").withStyle(ChatFormatting.RED);
        iC = Component.translatable("bf.message.disconnect.mm.restarting");
        iD = Component.translatable("bf.message.match.concluded").withStyle(ChatFormatting.RED);
    }

    public oF(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        this(abstractC0264ju, "Unknown", "Unknown");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public oF(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull String str, @NotNull String str2) {
        this.M = new ObjectArrayList();
        this.e = new Object2ObjectOpenHashMap();
        this.f263a = oN.IDLE;
        this.bE = "";
        this.f265a = new sY("default");
        this.mu = 0;
        this.b = new C0272kb().a("tp", new C0272kb((commandContext, strArr) -> {
            ServerPlayer serverPlayer = ((CommandSourceStack) commandContext.getSource()).source;
            oX oXVarC = b().c();
            if (oXVarC == null) {
                lW.b(((CommandSourceStack) commandContext.getSource()).source, iy);
                return;
            }
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!fW && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oR.a((com.boehmod.blockfront.common.player.c<?>) abstractC0264juM166a.m531a(), serverPlayer, oXVarC);
            lW.b(((CommandSourceStack) commandContext.getSource()).source, Component.translatable("bf.message.command.assets.edit.games.tp", new Object[]{Component.literal(this.bE).withStyle(C0266jw.e)}));
        }).a(C0274kd.a)).a("map", new C0272kb((commandContext2, strArr2) -> {
            String str3 = strArr2[0];
            lW.b(((CommandSourceStack) commandContext2.getSource()).source, Component.translatable("bf.message.command.assets.edit.games.mapname", new Object[]{Component.literal(str3).withStyle(C0266jw.e)}));
            a(new jL<>(sX.class, str3, sX.b));
        }).a(C0274kd.a(new String[]{"mapName"})).a((commandContext3, strArr3) -> {
            jM jMVarA;
            if (strArr3.length <= 0 && (jMVarA = jO.c().a(sX.class)) != null) {
                return jMVarA.d().keySet();
            }
            return List.of();
        })).a("lobby", new C0272kb((commandContext4, strArr4) -> {
            Player player = ((CommandSourceStack) commandContext4.getSource()).source;
            lW.b(((CommandSourceStack) commandContext4.getSource()).source, iz);
            b().a(new oX(player));
        }).a(C0274kd.a));
        this.q = null;
        this.mv = 0;
        this.cU = false;
        this.r = UUID.randomUUID();
        this.f271a = new MatchSettings();
        this.fV = true;
        this.f267e = abstractC0264ju;
        this.f269b = abstractC0264ju.m531a();
        this.f268a = (P) a();
        this.f270a = new C0526tm<>(this);
        this.bF = str;
        this.iE = Component.literal(str2);
        this.a = new C0532ts(this);
        this.f261a = new oL<>(this);
        ServerLevel serverLevel = null;
        MinecraftServer minecraftServerA = C0262js.a();
        oR.a(minecraftServerA != null ? minecraftServerA.getLevel(Level.OVERWORLD) : serverLevel, (oF<?, ?, ?>) this, (oI<?>) this.f268a);
        this.f262a = new C0420po(this instanceof qY ? ((qY) this).bu() : 1);
    }

    @NotNull
    public Set<sV> e() {
        return Set.of();
    }

    public int aS() {
        return 200;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull oF<?, ?, ?> oFVar) {
        return Integer.compare(oFVar.b().h().size(), this.f268a.h().size());
    }

    public void cl() {
        sX sXVarM751a = m751a();
        ObjectArrayList objectArrayList = new ObjectArrayList(sXVarM751a.o().values());
        C0263jt.log("Refreshing random environment for map '%s'... (%d Available)", m751a().getName(), Integer.valueOf(objectArrayList.size()));
        this.f265a = (sY) objectArrayList.get(ThreadLocalRandom.current().nextInt(objectArrayList.size()));
        this.mu++;
        C0263jt.log("Selected '%s' as the random environment for map '%s'.", this.f265a.getName(), sXVarM751a.getName());
    }

    public void cm() {
        sX sXVarM751a = m751a();
        Map<String, sY> mapO = sXVarM751a.o();
        if (mapO.isEmpty()) {
            C0263jt.logError("[Map Reload] Map '%s' has no environments after reload, keeping previous environment reference.", sXVarM751a.getName());
            return;
        }
        String name = this.f265a.getName();
        sY sYVar = mapO.get(name);
        if (sYVar != null) {
            this.f265a = sYVar;
            this.mu++;
            C0263jt.log("[Map Reload] Re-bound environment '%s' on map '%s' to the freshly-loaded instance.", name, sXVarM751a.getName());
        } else {
            C0263jt.log("[Map Reload] Environment '%s' no longer present on map '%s', picking a new one at random.", name, sXVarM751a.getName());
            cl();
        }
    }

    public int aT() {
        return this.mu;
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel) {
        Set<UUID> setH = this.f268a.h();
        if (a(serverLevel, setH)) {
            return;
        }
        this.fV = false;
        if (this.cU) {
            return;
        }
        if (this.mv > 0) {
            this.mv--;
        }
        m767a().a(this, abstractC0264ju, serverLevel, setH);
        m761e().removeIf(abstractC0475rp -> {
            return !abstractC0475rp.a(serverLevel, (oF<?, ?, ?>) this, (Set<UUID>) setH);
        });
        this.f268a.a(setH);
        a(abstractC0264ju, this.f269b, serverLevel, setH);
    }

    private boolean a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        if (set.isEmpty()) {
            a(oN.IDLE);
            if (!this.fV) {
                this.fV = true;
                C0263jt.log("[STAGE] No players in match '%s'! Restarting game.", L());
                d(serverLevel);
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull String str) {
        oF<?, ?, ?> oFVarA = abstractC0264ju.a(str);
        return oFVarA != null && a(abstractC0264ju, serverLevel, oFVarA);
    }

    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull UUID uuid) {
        oF<?, ?, ?> oFVarB = abstractC0264ju.b(uuid);
        if (oFVarB == null) {
            C0263jt.log("[Move] Failed to find game with UUID '%s'.", uuid);
            return false;
        }
        if (abstractC0264ju.a(oFVarB.m751a(), (oF<?, ?, ?>) this)) {
            C0263jt.log("[Move] Map '%s' is occupied.", oFVarB.m751a().getName());
            return false;
        }
        if (oFVarB.f263a != oN.IDLE) {
            C0263jt.log("[Move] Game '%s' is not idle.", oFVarB.f263a);
            return false;
        }
        C0263jt.log("[Move] Moving lobby to game '%s'...", oFVarB.L());
        return a(abstractC0264ju, serverLevel, oFVarB);
    }

    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar) {
        Set<UUID> setH = this.f268a.h();
        oQ oQVarM783a = this.f268a.m783a();
        oQVarM783a.cv();
        oFVar.b().m783a().a(oQVarM783a);
        oFVar.m766a().copyFrom(this.f271a);
        Iterator<UUID> it = oR.m794a(this.f269b, setH).iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerA = oR.a(it.next());
            if (serverPlayerA != null) {
                this.f268a.a(abstractC0264ju, serverLevel, serverPlayerA);
                if (!abstractC0264ju.a(serverLevel, serverPlayerA, oFVar)) {
                    C0263jt.log(String.format("Failed to assign player '%s' to game '%s', running game-mode '%s' on map '%s'", serverPlayerA.getScoreboardName(), oFVar.r, oFVar.bF, oFVar.m751a().getName()), new Object[0]);
                    oR.b(serverPlayerA, iC);
                }
            }
        }
        ObjectListIterator it2 = new ObjectArrayList(this.f268a.i()).iterator();
        while (it2.hasNext()) {
            ServerPlayer serverPlayerA2 = oR.a((UUID) it2.next());
            if (serverPlayerA2 != null) {
                this.f268a.c(abstractC0264ju, serverLevel, serverPlayerA2);
                if (!abstractC0264ju.b(serverLevel, serverPlayerA2, oFVar)) {
                    C0263jt.log(String.format("Failed to move spectator '%s' to game '%s'", serverPlayerA2.getScoreboardName(), oFVar.r), new Object[0]);
                }
            }
        }
        if (abstractC0264ju instanceof xw) {
            ((xw) abstractC0264ju).m1710a().a(this.r, oFVar.r);
            return true;
        }
        return true;
    }

    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @Nullable C0528to c0528to, boolean z, @NotNull C0409pd c0409pd, @NotNull Set<UUID> set) {
        MutableComponent mutableComponentEmpty;
        boolean z2 = (abstractC0264ju instanceof xw) && ((xw) abstractC0264ju).f();
        oR.a(serverLevel, (oF<?, ?, ?>) this, (oI<?>) this.f268a);
        TreeMap treeMap = new TreeMap((v0, v1) -> {
            return v0.compareTo(v1);
        });
        HashSet hashSet = new HashSet();
        set.forEach(uuid -> {
            treeMap.put(uuid, false);
        });
        if (c0409pd.g != null) {
            hashSet.addAll(c0409pd.g.h());
        }
        if (c0409pd.o != null) {
            hashSet.addAll(c0409pd.o);
        }
        hashSet.forEach(uuid2 -> {
            treeMap.merge(uuid2, true, (bool, bool2) -> {
                return true;
            });
        });
        if (c0409pd.g != null) {
            mutableComponentEmpty = Component.translatable("bf.message.gamemode.victorious.team", new Object[]{c0409pd.g.a((oF<?, ?, ?>) this).m1156a().getName()});
        } else if (c0409pd.o != null && !c0409pd.o.isEmpty()) {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            Iterator<UUID> it = c0409pd.o.iterator();
            while (it.hasNext()) {
                ServerPlayer serverPlayerA = oR.a(it.next());
                if (serverPlayerA != null) {
                    objectArrayList.add(serverPlayerA.getScoreboardName());
                }
            }
            mutableComponentEmpty = Component.translatable("bf.message.gamemode.victorious.team", new Object[]{iH.b(objectArrayList)});
        } else {
            mutableComponentEmpty = Component.empty();
        }
        MutableComponent mutableComponent = mutableComponentEmpty;
        treeMap.forEach((uuid3, bool) -> {
            a((AbstractC0264ju<?, ?, ?>) abstractC0264ju, z2, uuid3, mutableComponent, bool.booleanValue());
        });
        MutableComponent mutableComponent2 = mutableComponentEmpty;
        this.f268a.i().forEach(uuid4 -> {
            ServerPlayer serverPlayerA2 = oR.a(uuid4);
            if (serverPlayerA2 != null) {
                C0582vo.a(new C0599we(mutableComponent2, true), serverPlayerA2);
            }
        });
        if (z2 && aZ()) {
            oR.a(abstractC0264ju, (oF<?, ?, ?>) this, set, C0529tp.d);
            a(abstractC0264ju, 4, set);
            if (c0528to != null) {
                a(abstractC0264ju, 5, c0528to, z, set);
            }
            if (ba()) {
                a(abstractC0264ju, c0409pd, c0528to);
            }
        }
    }

    protected boolean ba() {
        sW sWVarA = sW.a(this.bF);
        if (sWVarA == null) {
            return false;
        }
        sW.a aVarM1094a = sWVarA.m1094a();
        return aVarM1094a == sW.a.VERSUS || aVarM1094a == sW.a.COOP;
    }

    @Nullable
    protected IMatchReportData a(@NotNull C0409pd c0409pd) {
        return null;
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull C0409pd c0409pd, @Nullable C0528to c0528to) {
        sW sWVarA;
        List objectArrayList;
        MatchResult matchResult;
        Set<UUID> setH = this.f268a.h();
        if (setH.isEmpty() || (sWVarA = sW.a(this.bF)) == null) {
            return;
        }
        oO oOVarA = this.f268a.a(C0529tp.da);
        oO oOVarA2 = this.f268a.a(C0529tp.cZ);
        boolean z = (oOVarA == null && oOVarA2 == null) ? false : true;
        String name = c0409pd.g != null ? c0409pd.g.getName() : null;
        int iA2 = oOVarA != null ? oOVarA.a(C0529tp.l) : 0;
        int iA3 = oOVarA2 != null ? oOVarA2.a(C0529tp.l) : 0;
        int iA4 = oOVarA != null ? oOVarA.a(C0529tp.L) : 0;
        int iA5 = oOVarA2 != null ? oOVarA2.a(C0529tp.L) : 0;
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        if (c0409pd.g != null) {
            objectOpenHashSet.addAll(c0409pd.g.h());
        }
        if (c0409pd.o != null) {
            objectOpenHashSet.addAll(c0409pd.o);
        }
        if (c0528to != null) {
            objectArrayList = new ObjectArrayList(oR.a((oF<?, ?, ?>) this, setH, c0528to));
        } else {
            objectArrayList = new ObjectArrayList(setH);
        }
        List list = objectArrayList;
        ObjectArrayList objectArrayList2 = new ObjectArrayList(setH.size());
        for (UUID uuid : setH) {
            oM oMVarA = a(uuid);
            oO oOVarA3 = this.f268a.a(uuid);
            String name2 = oOVarA3 != null ? oOVarA3.getName() : null;
            if (objectOpenHashSet.isEmpty()) {
                matchResult = MatchResult.DRAW;
            } else {
                matchResult = objectOpenHashSet.contains(uuid) ? MatchResult.WIN : MatchResult.LOSS;
            }
            MatchResult matchResult2 = matchResult;
            int iIndexOf = c0528to != null ? list.indexOf(uuid) + 1 : 0;
            Object2IntOpenHashMap object2IntOpenHashMap = new Object2IntOpenHashMap();
            int iA6 = oMVarA.a(C0529tp.q.getKey());
            if (iA6 != 0) {
                object2IntOpenHashMap.put("captures", iA6);
            }
            int iA7 = oMVarA.a(C0529tp.o.getKey());
            if (iA7 != 0) {
                object2IntOpenHashMap.put("headshots", iA7);
            }
            objectArrayList2.add(new MatchReportPlayer(uuid, name2, matchResult2, iIndexOf, oMVarA.a(C0529tp.D.getKey()), oMVarA.a(C0529tp.L.getKey()), oMVarA.a(C0529tp.M.getKey()), oMVarA.a(C0529tp.l.getKey()), object2IntOpenHashMap));
        }
        abstractC0264ju.m529b().sendPacket(new PacketMMMatchReport(m757e(), sWVarA.a(), m751a().getName(), m767a().getName(), 0, z, name, iA2, iA3, iA4, iA5, objectArrayList2, a(c0409pd)));
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, boolean z, @NotNull UUID uuid, @NotNull Component component, boolean z2) {
        CloudAchievement cloudAchievementMo760a;
        if (z2 && z && (cloudAchievementMo760a = mo760a()) != null) {
            oR.a(abstractC0264ju, uuid, cloudAchievementMo760a);
        }
        ServerPlayer serverPlayerA = oR.a(uuid);
        if (serverPlayerA != null) {
            C0582vo.a(new C0599we(component, z2), serverPlayerA);
        }
    }

    void c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, this.bE);
        IPacket.writeBoolean(byteBuf, this.f266a != null);
        if (this.f266a != null) {
            IPacket.writeString(byteBuf, ((sX) this.f266a.a()).getName());
        }
        IPacket.writeString(byteBuf, this.bF);
        IPacket.writeUUID(byteBuf, this.r);
        oX oXVarC = this.f268a.c();
        IPacket.writeBoolean(byteBuf, oXVarC != null);
        if (oXVarC != null) {
            oXVarC.c(byteBuf);
        }
    }

    void b(@NotNull ByteBuf byteBuf) throws IOException {
        this.bE = IPacket.readString(byteBuf);
        if (IPacket.readBoolean(byteBuf)) {
            this.f266a = new jL<>(sX.class, IPacket.readString(byteBuf), sX.b);
        }
        this.bF = IPacket.readString(byteBuf);
        this.r = IPacket.readUUID(byteBuf);
        if (IPacket.readBoolean(byteBuf)) {
            oX oXVar = new oX();
            oXVar.b(byteBuf);
            this.f268a.a(oXVar);
        }
    }

    @NotNull
    public final P b() {
        return this.f268a;
    }

    @NotNull
    public final Collection<String> c() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator<oO> it = this.f268a.A().iterator();
        while (it.hasNext()) {
            objectArrayList.add(it.next().getName());
        }
        return objectArrayList;
    }

    public float aF() {
        return 1.0f;
    }

    public float aG() {
        return 1.0f;
    }

    public int aU() {
        return 0;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public oN m750a() {
        return this.f263a;
    }

    public void a(@NotNull oN oNVar) {
        this.f263a = oNVar;
    }

    public String L() {
        return this.bE;
    }

    public void v(@NotNull String str) {
        this.bE = str;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public sX m751a() {
        if (this.f264a != null) {
            return this.f264a;
        }
        if (this.f266a == null || this.f266a.aj()) {
            return sX.b;
        }
        return (sX) this.f266a.a();
    }

    public void a(@NotNull jL<sX> jLVar) {
        this.f266a = jLVar;
    }

    public void a(@NotNull sX sXVar) {
        this.f266a = new jL<>(sXVar);
    }

    @NotNull
    public String M() {
        return this.bF;
    }

    public void w(@NotNull String str) {
        this.bF = str;
    }

    public int aV() {
        return InterfaceC0638xq.tQ;
    }

    @NotNull
    public oM a(@NotNull UUID uuid) {
        return (oM) this.e.computeIfAbsent(uuid, obj -> {
            return new oM();
        });
    }

    protected void d(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeBoolean(byteBuf, !this.e.isEmpty());
        if (this.e.isEmpty()) {
            return;
        }
        FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(byteBuf);
        byteBuf.writeInt(this.e.size());
        ObjectIterator it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            IPacket.writeUUID(byteBuf, (UUID) entry.getKey());
            friendlyByteBuf.writeNbt(((oM) entry.getValue()).a());
        }
    }

    protected void e(@NotNull ByteBuf byteBuf) throws IOException {
        if (IPacket.readBoolean(byteBuf)) {
            this.e.clear();
            FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(byteBuf);
            int i = byteBuf.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                UUID uuid = IPacket.readUUID(byteBuf);
                CompoundTag nbt = friendlyByteBuf.readNbt();
                if (nbt != null) {
                    this.e.put(uuid, new oM(nbt));
                }
            }
        }
    }

    public void c(@NotNull UUID uuid) {
        this.e.remove(uuid);
    }

    private void cn() {
        this.e.clear();
    }

    public void d(@Nullable ServerLevel serverLevel) {
        C0263jt.log("Resetting game '%s'...", L());
        UUID uuid = this.r;
        this.r = UUID.randomUUID();
        this.f267e.a((oF<?, ?, ?>) this, uuid, this.r);
        this.cU = false;
        this.f271a.reset();
        this.f268a.a(this.f267e, iD);
        this.f268a.bf();
        this.f270a.bf();
        this.f262a.bf();
        this.q = null;
        this.a.bf();
        m751a().cA();
        cl();
        cn();
        oR.a(serverLevel, (oF<?, ?, ?>) this, (oI<?>) this.f268a);
        d((Level) serverLevel);
    }

    public void c(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        if (abstractC0264ju instanceof xw) {
            xw xwVar = (xw) abstractC0264ju;
            if (xwVar.f() && xwVar.b().ds()) {
                xwVar.G("Stopping MM server. Game over.");
            }
        }
    }

    @NotNull
    public Component getDisplayName() {
        return this.iE;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public oU mo753a() {
        return oU.SAME_TEAM;
    }

    public boolean bb() {
        return false;
    }

    public boolean bc() {
        return true;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public oJ mo754a() {
        return oJ.ALL;
    }

    @OverridingMethodsMustInvokeSuper
    public void a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        IPacket.writeBoolean(byteBuf, z);
        c(byteBuf);
        d(byteBuf);
        IPacket.writeEnum(byteBuf, this.f263a);
        this.f268a.h(byteBuf);
        this.a.c(byteBuf);
        if (z) {
            m751a().k(byteBuf);
            this.f265a.c(byteBuf);
        }
    }

    public void f(@NotNull ByteBuf byteBuf) throws IOException {
        oP oPVarMo1035a;
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        Object objB = this.f270a.b();
        if ((objB instanceof InterfaceC0522ti) && (oPVarMo1035a = ((InterfaceC0522ti) objB).mo1035a(this)) != null) {
            IPacket.writeBoolean(byteBuf, true);
            oPVarMo1035a.c(byteBuf);
        } else {
            IPacket.writeBoolean(byteBuf, false);
        }
        IPacket.writeBoolean(byteBuf, (abstractC0264juM166a instanceof xw) && ((xw) abstractC0264juM166a).f());
    }

    @OverridingMethodsMustInvokeSuper
    public void g(@NotNull ByteBuf byteBuf) throws IOException {
        boolean z = IPacket.readBoolean(byteBuf);
        C0297l c0297lB = C0297l.b();
        if (!fW && c0297lB == null) {
            throw new AssertionError("Mod manager is null!");
        }
        b(byteBuf);
        e(byteBuf);
        this.f263a = (oN) IPacket.readEnum(byteBuf, oN.class);
        this.f268a.g(byteBuf);
        this.a.b(byteBuf);
        if (z) {
            Minecraft minecraft = Minecraft.getInstance();
            if (this.f264a == null) {
                this.f264a = new sX(c0297lB);
            }
            this.f264a.l(byteBuf);
            this.f265a.a(minecraft, RandomSource.create());
            this.f265a = new sY(byteBuf);
            this.f265a.G(minecraft);
            c0297lB.m595a().u(minecraft);
            Runnable runnable = () -> {
                minecraft.levelRenderer.allChanged();
                c0297lB.a((oF<?, ?, ?>) this);
            };
            if (!RenderSystem.isOnRenderThread()) {
                Objects.requireNonNull(runnable);
                RenderSystem.recordRenderCall(runnable::run);
            } else {
                runnable.run();
            }
        }
    }

    public int aW() {
        return 2;
    }

    public boolean a(@NotNull Set<UUID> set) {
        return set.size() >= aW();
    }

    protected void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, int i, @NotNull C0528to c0528to, boolean z, @NotNull Set<UUID> set) {
        a(abstractC0264ju, i, c0528to.getKey(), z, set);
    }

    protected void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, int i, @NotNull String str, boolean z, @NotNull Set<UUID> set) {
        for (UUID uuid : oR.a((oF<?, ?, ?>) this, i, str, set)) {
            if (abstractC0264ju.g() && z) {
                oR.a(abstractC0264ju, (oF<?, ?, ?>) this, uuid, C0529tp.S, 1);
            }
        }
    }

    protected void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, int i, @NotNull Set<UUID> set) {
        int size = set.size();
        if (size < 4) {
            return;
        }
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        int iNextInt = threadLocalRandomCurrent.nextInt(i);
        if (size >= 10) {
            iNextInt += threadLocalRandomCurrent.nextInt(i);
        }
        if (iNextInt <= 0) {
            return;
        }
        MutableComponent mutableComponentWithColor = Component.translatable("bf.message.match.drops", new Object[]{Integer.valueOf(iNextInt)}).withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);
        oR.f((oF<?, ?, ?>) this);
        oR.a((oF<?, ?, ?>) this, (Component) mutableComponentWithColor);
        for (UUID uuid : oR.a(set, iNextInt)) {
            ServerPlayer serverPlayerA = oR.a(uuid);
            if (serverPlayerA != null) {
                oR.a((oF<?, ?, ?>) this, (Component) Component.literal("  ").append(Component.literal(serverPlayerA.getScoreboardName()).withStyle(ChatFormatting.GOLD)));
                abstractC0264ju.m529b().sendPacket(new PacketPlayerRandomDrop(uuid, m757e()));
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0514ta m755a() {
        return m751a().e();
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public C0514ta m756b() {
        return m751a().f();
    }

    public void a(@NotNull AbstractC0475rp abstractC0475rp) {
        this.M.add(abstractC0475rp);
    }

    public boolean be() {
        return this.cU;
    }

    public void A(boolean z) {
        this.cU = z;
    }

    @NotNull
    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public UUID m757e() {
        return this.r;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0532ts m758a() {
        return this.a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public oL<? extends oF<G, P, S>> m759a() {
        return this.f261a;
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        if (this.f268a.g(uuid)) {
            this.f268a.c(abstractC0264ju, serverLevel, serverPlayer);
        } else {
            this.f268a.a(abstractC0264ju, serverLevel, serverPlayer);
            c(uuid);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerPlayer serverPlayer, @NotNull Component component) {
        return !(this instanceof InterfaceC0462rc) || a(abstractC0264ju, (InterfaceC0462rc) this, serverPlayer, serverPlayer.getUUID(), component, this.f268a.h());
    }

    private boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull InterfaceC0462rc interfaceC0462rc, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull Component component, @NotNull Set<UUID> set) {
        int iB2 = interfaceC0462rc.b(serverPlayer);
        int iBv = interfaceC0462rc.bv();
        String[] strArrSplit = component.getString().split(" ");
        if (strArrSplit.length != 1) {
            return true;
        }
        String str = strArrSplit[0];
        DeferredHolder deferredHolder = (DeferredHolder) C0624xc.g.get(str);
        if (deferredHolder == null) {
            return true;
        }
        if (oR.a((oF<?, ?, ?>) this, uuid, C0529tp.u) <= iB2) {
            if (this.mv <= 0) {
                this.mv = iBv;
                oR.a((oF<?, ?, ?>) this, (SoundEvent) deferredHolder.get(), SoundSource.MASTER, 100.0f, serverPlayer.position());
                oR.a(abstractC0264ju, (oF<?, ?, ?>) this, uuid, C0529tp.u);
                oR.a((oF<?, ?, ?>) this, (Component) Component.translatable("bf.message.ingame.soundboard.play", new Object[]{Component.literal(serverPlayer.getScoreboardName()).withStyle(ChatFormatting.AQUA), Component.literal(str).withStyle(ChatFormatting.AQUA)}).withStyle(ChatFormatting.BLUE));
                return false;
            }
            oR.c(serverPlayer, (Component) Component.translatable("bf.message.ingame.soundboard.fail.time", new Object[]{String.valueOf(this.mv / 20)}).withStyle(ChatFormatting.RED));
            return false;
        }
        oR.c(serverPlayer, iB);
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof oF) && ((oF) obj).r.equals(this.r);
    }

    public boolean a(@NotNull UUID uuid, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid2, boolean z, boolean z2) {
        com.boehmod.blockfront.common.player.b bVarM305a = this.f269b.m305a((Player) serverPlayer);
        oO oOVarA = this.f268a.a(uuid);
        if (!z || oOVarA == null || oOVarA.equals(this.f268a.a(uuid2))) {
            return oR.a((Player) serverPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) bVarM305a) || !z2 || bf();
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public ObjectList<AbstractC0475rp> m761e() {
        return this.M;
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull sV sVVar, int i) {
        C0263jt.log("Class type '%s' was requested by '%s'", sVVar, serverPlayer.getScoreboardName());
        if (!serverLevel.isClientSide() && (this instanceof qO)) {
            if (sVVar.a((oF<?, ?, ?>) this)) {
                if (this.f268a.a(abstractC0264ju, serverLevel, serverPlayer, uuid, sVVar, i)) {
                    C0263jt.log("Player '%s' has changed class to '%s'", serverPlayer.getScoreboardName(), sVVar);
                    return;
                } else {
                    C0263jt.log("Player '%s' failed to change class to '%s'", serverPlayer.getScoreboardName(), sVVar);
                    return;
                }
            }
            C0263jt.log("Player '%s' attempted to use an un-allowed class! (%s)", serverPlayer.getScoreboardName(), sVVar);
        }
    }

    protected void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        oO oOVarA = this.f268a.a(uuid);
        oO oOVarA2 = null;
        if (oOVarA != null) {
            if (oOVarA.bq()) {
                oOVarA2 = this.f268a.a(C0529tp.cZ);
            } else {
                oOVarA2 = this.f268a.a(C0529tp.da);
            }
        }
        if (oOVarA2 != null && a(abstractC0264ju, serverLevel, serverPlayer, uuid, oOVarA2)) {
            oR.a((oF<?, ?, ?>) this, (Component) Component.translatable("bf.message.gamemode.player.teamswitch", new Object[]{Component.literal(serverPlayer.getScoreboardName()), Component.literal(oOVarA2.getName().toUpperCase()).withStyle(oOVarA2.a())}));
            oR.a(abstractC0264ju, uuid, CloudAchievements.ACH_USER_SWITCH_TEAM);
        }
    }

    protected boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull oO oOVar) {
        if (oOVar.br()) {
            return false;
        }
        oO oOVarA = this.f268a.a(uuid);
        if (oOVarA != null) {
            oOVarA.f(uuid);
        }
        d(uuid);
        return this.f268a.m781a(abstractC0264ju, oS.SWITCH_TEAMS, serverLevel, serverPlayer, oOVar);
    }

    protected void d(@NotNull UUID uuid) {
        oM oMVarA = a(uuid);
        oMVarA.x(C0529tp.i.getKey());
        oMVarA.x(C0529tp.j.getKey());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel) {
        ServerPlayer serverPlayerA;
        oO oOVarA = this.f268a.a(C0529tp.cZ);
        oO oOVarA2 = this.f268a.a(C0529tp.da);
        if (oOVarA == null || oOVarA2 == null) {
            return;
        }
        Set<UUID> setM794a = oR.m794a(this.f269b, this.f268a.h());
        if (setM794a.size() < 2) {
            return;
        }
        boolean z = false;
        int i = 0;
        for (UUID uuid : setM794a) {
            boolean z2 = i % 4 == 0 || i % 4 == 3;
            i++;
            oO oOVar = z2 ? oOVarA : oOVarA2;
            if (this.f268a.a(uuid) != oOVar && (serverPlayerA = oR.a(uuid)) != null && a(abstractC0264ju, serverLevel, serverPlayerA, uuid, oOVar)) {
                z = true;
            }
        }
        if (!z) {
            return;
        }
        if (this instanceof InterfaceC0464re) {
            int iBx = ((InterfaceC0464re) this).bx();
            Iterator<UUID> it = setM794a.iterator();
            while (it.hasNext()) {
                oR.m792a((oF<?, ?, ?>) this, it.next(), C0529tp.y, iBx);
            }
        }
        Iterator<UUID> it2 = setM794a.iterator();
        while (it2.hasNext()) {
            oR.a(it2.next(), ix, 80, "rebalance");
        }
    }

    protected Component a(@NotNull Player player, int i, int i2) {
        oO oOVarA = this.f268a.a(player.getUUID());
        Component component = null;
        if (oOVarA == null) {
            component = iu;
        }
        if (oOVarA != null && (!oOVarA.bq() ? i > i2 : i2 > i)) {
            component = iv;
        }
        if (m750a() == oN.POST_GAME) {
            component = iw;
        }
        return component;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0528to m762a() {
        return C0529tp.l;
    }

    public boolean bg() {
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0272kb mo763a() {
        return this.b;
    }

    public void g(@NotNull List<MutableComponent> list) {
        Set<a> setMo1046f = mo1046f();
        if (setMo1046f.contains(a.LOBBY) && this.f268a.e == null) {
            list.add(Component.literal("Lobby position for game '" + this.bE + "' doesn't exist."));
        }
        if (setMo1046f.contains(a.TEAM_SPAWNS)) {
            for (oO oOVar : this.f268a.A()) {
                if (oOVar.B().isEmpty()) {
                    list.add(Component.literal("Team spawns for team '" + oOVar.getName() + "' for game '" + this.bE + "' don't exist."));
                }
            }
        }
        if (setMo1046f.contains(a.MAP_TYPE)) {
            if (this.f266a == null) {
                list.add(Component.literal("Map type for game '" + this.bE + "' is null."));
            } else if (this.f266a.aj()) {
                list.add(Component.literal("Map type for game '" + this.bE + "' doesn't exist. (Custom by default)"));
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0420po m764a() {
        return this.f262a;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public Set<a> mo1046f() {
        return EnumSet.allOf(a.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        if ((this instanceof qR) && ((qR) this).d(serverPlayer) && this.q == null) {
            this.q = uuid;
            this.f268a.h();
            oR.a(serverPlayer, new sQ(iA, 80));
            oR.a((oF<?, ?, ?>) this, (Component) Component.translatable("bf.message.gamemode.firstblood.announce", new Object[]{serverPlayer.getScoreboardName()}).withStyle(ChatFormatting.DARK_RED));
            oR.a(abstractC0264ju, (oF<?, ?, ?>) this, uuid, C0529tp.l);
            oR.a((oF<?, ?, ?>) this, (SoundEvent) C0624xc.qp.get(), SoundSource.MASTER);
            oR.a(abstractC0264ju, (oF<?, ?, ?>) this, uuid, C0529tp.n);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0526tm<G, P> m765a() {
        return this.f270a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public MatchSettings m766a() {
        return this.f271a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public sY m767a() {
        return this.f265a;
    }

    public void stop() {
        C0263jt.log("Stopping all systems for match '%s'", m757e());
        cn();
    }
}
