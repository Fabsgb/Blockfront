package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.MatchSettings;
import com.boehmod.bflib.cloud.common.p000mm.report.IMatchReportData;
import com.boehmod.bflib.cloud.common.p000mm.report.MatchReportPlayer;
import com.boehmod.bflib.cloud.common.p000mm.report.MatchResult;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.common.PacketPlayerRandomDrop;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMMatchReport;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
import com.boehmod.blockfront.C1016sW;
import com.boehmod.blockfront.C1086tm;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.oF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oF.class */
public abstract class AbstractC0787oF<G extends AbstractC0787oF<G, P, S>, P extends AbstractC0790oI<G>, S extends C1086tm<G, P>> implements Comparable<AbstractC0787oF<?, ?, ?>> {

    /* JADX INFO: renamed from: mq */
    protected static final int f4215mq = 2400;

    /* JADX INFO: renamed from: iu */
    @NotNull
    private static final Component f4216iu;

    /* JADX INFO: renamed from: iv */
    @NotNull
    private static final Component f4217iv;

    /* JADX INFO: renamed from: iw */
    @NotNull
    private static final Component f4218iw;

    /* JADX INFO: renamed from: ix */
    @NotNull
    private static final Component f4219ix;

    /* JADX INFO: renamed from: iy */
    @NotNull
    private static final Component f4220iy;

    /* JADX INFO: renamed from: iz */
    @NotNull
    private static final Component f4221iz;

    /* JADX INFO: renamed from: iA */
    @NotNull
    private static final Component f4222iA;

    /* JADX INFO: renamed from: iB */
    @NotNull
    private static final Component f4223iB;

    /* JADX INFO: renamed from: iC */
    @NotNull
    private static final Component f4224iC;

    /* JADX INFO: renamed from: iD */
    @NotNull
    private static final Component f4225iD;

    /* JADX INFO: renamed from: mr */
    private static final int f4226mr = 4;

    /* JADX INFO: renamed from: ms */
    private static final int f4227ms = 5;

    /* JADX INFO: renamed from: mt */
    private static final int f4228mt = 4;

    /* JADX INFO: renamed from: M */
    @NotNull
    private final ObjectList<AbstractC0982rp> f4229M;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final Object2ObjectMap<UUID, C0794oM> f4230e;

    /* JADX INFO: renamed from: iE */
    @NotNull
    private final Component f4231iE;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1092ts f4232a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0793oL<G> f4233a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0875po f4234a;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected EnumC0795oN f4235a;

    /* JADX INFO: renamed from: bE */
    protected String f4236bE;

    /* JADX INFO: renamed from: bF */
    @NotNull
    protected String f4237bF;

    /* JADX INFO: renamed from: a */
    @Nullable
    protected C1017sX f4238a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private C1018sY f4239a;

    /* JADX INFO: renamed from: mu */
    private int f4240mu;

    /* JADX INFO: renamed from: a */
    @Nullable
    protected C0528jL<C1017sX> f4241a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C0597kb f4242b;

    /* JADX INFO: renamed from: q */
    @Nullable
    private UUID f4243q;

    /* JADX INFO: renamed from: mv */
    private int f4244mv;

    /* JADX INFO: renamed from: cU */
    private boolean f4245cU;

    /* JADX INFO: renamed from: r */
    @NotNull
    private UUID f4246r;

    /* JADX INFO: renamed from: e */
    @NotNull
    protected final AbstractC0563ju<?, ?, ?> f4247e;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final P f4248a;

    /* JADX INFO: renamed from: b */
    protected final AbstractC0183c<?> f4249b;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final C1086tm<G, P> f4250a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final MatchSettings f4251a;

    /* JADX INFO: renamed from: fV */
    private boolean f4252fV;

    /* JADX INFO: renamed from: mw */
    public static final int f4253mw = 200;

    /* JADX INFO: renamed from: fW */
    static final /* synthetic */ boolean f4254fW;

    /* JADX INFO: renamed from: com.boehmod.blockfront.oF$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oF$a.class */
    public enum a {
        MAP_TYPE,
        LOBBY,
        TEAM_SPAWNS
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract AbstractC0788oG<?, ?> mo3559a(@NotNull C0622l c0622l);

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract P mo3560a();

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract AbstractC1084tk<G, P> mo3563a();

    /* JADX INFO: renamed from: a */
    public abstract void mo3570a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set);

    /* JADX INFO: renamed from: aZ */
    protected abstract boolean mo3575aZ();

    /* JADX INFO: renamed from: a */
    public abstract boolean mo3597a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer);

    /* JADX INFO: renamed from: d */
    public abstract void mo3605d(@Nullable Level level);

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract InterfaceC0978rl mo3606a();

    /* JADX INFO: renamed from: a */
    public abstract void mo3607a(@NotNull InterfaceC0978rl interfaceC0978rl);

    /* JADX INFO: renamed from: e */
    public abstract boolean mo3608e(@NotNull Player player);

    /* JADX INFO: renamed from: f */
    public abstract boolean mo3609f(@NotNull Player player);

    /* JADX INFO: renamed from: bd */
    public abstract boolean mo3621bd();

    /* JADX INFO: renamed from: bf */
    public abstract boolean mo3635bf();

    @Nullable
    /* JADX INFO: renamed from: a */
    public abstract CloudAchievement mo3636a();

    static {
        f4254fW = !AbstractC0787oF.class.desiredAssertionStatus();
        f4216iu = Component.translatable("bf.message.gamemode.switchteams.error.noteam");
        f4217iv = Component.translatable("bf.message.gamemode.switchteams.error.unbalanced");
        f4218iw = Component.translatable("bf.message.gamemode.switchteams.error.postgame");
        f4219ix = Component.translatable("bf.message.gamemode.notification.rebalance");
        f4220iy = Component.translatable("bf.message.command.assets.edit.games.tp.fail");
        f4221iz = Component.translatable("bf.message.command.assets.edit.games.lobby");
        f4222iA = Component.translatable("bf.popup.message.firstblood").withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD);
        f4223iB = Component.translatable("bf.message.ingame.soundboard.fail.count").withStyle(ChatFormatting.RED);
        f4224iC = Component.translatable("bf.message.disconnect.mm.restarting");
        f4225iD = Component.translatable("bf.message.match.concluded").withStyle(ChatFormatting.RED);
    }

    public AbstractC0787oF(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        this(abstractC0563ju, "Unknown", "Unknown");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC0787oF(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull String str, @NotNull String str2) {
        this.f4229M = new ObjectArrayList();
        this.f4230e = new Object2ObjectOpenHashMap();
        this.f4235a = EnumC0795oN.IDLE;
        this.f4236bE = "";
        this.f4239a = new C1018sY("default");
        this.f4240mu = 0;
        this.f4242b = new C0597kb().m2628a("tp", new C0597kb((commandContext, strArr) -> {
            ServerPlayer serverPlayer = ((CommandSourceStack) commandContext.getSource()).source;
            C0805oX c0805oXM3790c = m3582b().m3790c();
            if (c0805oXM3790c == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext.getSource()).source, f4220iy);
                return;
            }
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f4254fW && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            C0799oR.m3966a((AbstractC0183c<?>) abstractC0563juM168a.m2528a(), serverPlayer, c0805oXM3790c);
            C0645lW.m2898b(((CommandSourceStack) commandContext.getSource()).source, Component.translatable("bf.message.command.assets.edit.games.tp", new Object[]{Component.literal(this.f4236bE).withStyle(C0565jw.f3204e)}));
        }).m2624a(C0599kd.f3307a)).m2628a("map", new C0597kb((commandContext2, strArr2) -> {
            String str3 = strArr2[0];
            C0645lW.m2898b(((CommandSourceStack) commandContext2.getSource()).source, Component.translatable("bf.message.command.assets.edit.games.mapname", new Object[]{Component.literal(str3).withStyle(C0565jw.f3204e)}));
            m3592a(new C0528jL<>(C1017sX.class, str3, C1017sX.f5367b));
        }).m2624a(C0599kd.m2635a(new String[]{"mapName"})).m2630a((commandContext3, strArr3) -> {
            C0529jM c0529jMM2375a;
            if (strArr3.length <= 0 && (c0529jMM2375a = C0531jO.m2372c().m2375a(C1017sX.class)) != null) {
                return c0529jMM2375a.m2358d().keySet();
            }
            return List.of();
        })).m2628a("lobby", new C0597kb((commandContext4, strArr4) -> {
            Player player = ((CommandSourceStack) commandContext4.getSource()).source;
            C0645lW.m2898b(((CommandSourceStack) commandContext4.getSource()).source, f4221iz);
            m3582b().m3791a(new C0805oX(player));
        }).m2624a(C0599kd.f3307a));
        this.f4243q = null;
        this.f4244mv = 0;
        this.f4245cU = false;
        this.f4246r = UUID.randomUUID();
        this.f4251a = new MatchSettings();
        this.f4252fV = true;
        this.f4247e = abstractC0563ju;
        this.f4249b = abstractC0563ju.m2528a();
        this.f4248a = (P) mo3560a();
        this.f4250a = new C1086tm<>(this);
        this.f4237bF = str;
        this.f4231iE = Component.literal(str2);
        this.f4232a = new C1092ts(this);
        this.f4233a = new C0793oL<>(this);
        ServerLevel serverLevel = null;
        MinecraftServer minecraftServerM2514a = C0561js.m2514a();
        C0799oR.m3922a(minecraftServerM2514a != null ? minecraftServerM2514a.getLevel(Level.OVERWORLD) : serverLevel, (AbstractC0787oF<?, ?, ?>) this, (AbstractC0790oI<?>) this.f4248a);
        this.f4234a = new C0875po(this instanceof InterfaceC0912qY ? ((InterfaceC0912qY) this).mo4697bu() : 1);
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public Set<C1015sV> mo3561e() {
        return Set.of();
    }

    /* JADX INFO: renamed from: aS */
    public int mo3562aS() {
        return 200;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a */
    public int compareTo(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        return Integer.compare(abstractC0787oF.m3582b().m3809h().size(), this.f4248a.m3809h().size());
    }

    /* JADX INFO: renamed from: cl */
    public void m3565cl() {
        C1017sX c1017sXM3591a = m3591a();
        ObjectArrayList objectArrayList = new ObjectArrayList(c1017sXM3591a.m5563o().values());
        C0562jt.log("Refreshing random environment for map '%s'... (%d Available)", m3591a().getName(), Integer.valueOf(objectArrayList.size()));
        this.f4239a = (C1018sY) objectArrayList.get(ThreadLocalRandom.current().nextInt(objectArrayList.size()));
        this.f4240mu++;
        C0562jt.log("Selected '%s' as the random environment for map '%s'.", this.f4239a.getName(), c1017sXM3591a.getName());
    }

    /* JADX INFO: renamed from: cm */
    public void m3566cm() {
        C1017sX c1017sXM3591a = m3591a();
        Map<String, C1018sY> mapM5563o = c1017sXM3591a.m5563o();
        if (mapM5563o.isEmpty()) {
            C0562jt.logError("[Map Reload] Map '%s' has no environments after reload, keeping previous environment reference.", c1017sXM3591a.getName());
            return;
        }
        String name = this.f4239a.getName();
        C1018sY c1018sY = mapM5563o.get(name);
        if (c1018sY != null) {
            this.f4239a = c1018sY;
            this.f4240mu++;
            C0562jt.log("[Map Reload] Re-bound environment '%s' on map '%s' to the freshly-loaded instance.", name, c1017sXM3591a.getName());
        } else {
            C0562jt.log("[Map Reload] Environment '%s' no longer present on map '%s', picking a new one at random.", name, c1017sXM3591a.getName());
            m3565cl();
        }
    }

    /* JADX INFO: renamed from: aT */
    public int m3567aT() {
        return this.f4240mu;
    }

    /* JADX INFO: renamed from: a */
    public void m3568a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel) {
        Set<UUID> setM3809h = this.f4248a.m3809h();
        if (m3569a(serverLevel, setM3809h)) {
            return;
        }
        this.f4252fV = false;
        if (this.f4245cU) {
            return;
        }
        if (this.f4244mv > 0) {
            this.f4244mv--;
        }
        m3653a().m5591a(this, abstractC0563ju, serverLevel, setM3809h);
        m3637e().removeIf(abstractC0982rp -> {
            return !abstractC0982rp.mo5416a(serverLevel, (AbstractC0787oF<?, ?, ?>) this, (Set<UUID>) setM3809h);
        });
        this.f4248a.m3772a(setM3809h);
        mo3570a(abstractC0563ju, this.f4249b, serverLevel, setM3809h);
    }

    /* JADX INFO: renamed from: a */
    private boolean m3569a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        if (set.isEmpty()) {
            m3588a(EnumC0795oN.IDLE);
            if (!this.f4252fV) {
                this.f4252fV = true;
                C0562jt.log("[STAGE] No players in match '%s'! Restarting game.", m3589L());
                m3603d(serverLevel);
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public boolean m3571a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull String str) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2537a = abstractC0563ju.m2537a(str);
        return abstractC0787oFM2537a != null && m3573a(abstractC0563ju, serverLevel, abstractC0787oFM2537a);
    }

    /* JADX INFO: renamed from: a */
    public boolean m3572a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull UUID uuid) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2538b = abstractC0563ju.m2538b(uuid);
        if (abstractC0787oFM2538b == null) {
            C0562jt.log("[Move] Failed to find game with UUID '%s'.", uuid);
            return false;
        }
        if (abstractC0563ju.m2546a(abstractC0787oFM2538b.m3591a(), (AbstractC0787oF<?, ?, ?>) this)) {
            C0562jt.log("[Move] Map '%s' is occupied.", abstractC0787oFM2538b.m3591a().getName());
            return false;
        }
        if (abstractC0787oFM2538b.f4235a != EnumC0795oN.IDLE) {
            C0562jt.log("[Move] Game '%s' is not idle.", abstractC0787oFM2538b.f4235a);
            return false;
        }
        C0562jt.log("[Move] Moving lobby to game '%s'...", abstractC0787oFM2538b.m3589L());
        return m3573a(abstractC0563ju, serverLevel, abstractC0787oFM2538b);
    }

    /* JADX INFO: renamed from: a */
    public boolean m3573a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        Set<UUID> setM3809h = this.f4248a.m3809h();
        C0798oQ c0798oQM3817a = this.f4248a.m3817a();
        c0798oQM3817a.m3903cv();
        abstractC0787oF.m3582b().m3817a().m3911a(c0798oQM3817a);
        abstractC0787oF.m3652a().copyFrom(this.f4251a);
        Iterator<UUID> it = C0799oR.m4056a(this.f4249b, setM3809h).iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(it.next());
            if (serverPlayerM3963a != null) {
                this.f4248a.m3794a(abstractC0563ju, serverLevel, serverPlayerM3963a);
                if (!abstractC0563ju.m2525a(serverLevel, serverPlayerM3963a, abstractC0787oF)) {
                    C0562jt.log(String.format("Failed to assign player '%s' to game '%s', running game-mode '%s' on map '%s'", serverPlayerM3963a.getScoreboardName(), abstractC0787oF.f4246r, abstractC0787oF.f4237bF, abstractC0787oF.m3591a().getName()), new Object[0]);
                    C0799oR.m3962b(serverPlayerM3963a, f4224iC);
                }
            }
        }
        ObjectListIterator it2 = new ObjectArrayList(this.f4248a.m3810i()).iterator();
        while (it2.hasNext()) {
            ServerPlayer serverPlayerM3963a2 = C0799oR.m3963a((UUID) it2.next());
            if (serverPlayerM3963a2 != null) {
                this.f4248a.m3796c(abstractC0563ju, serverLevel, serverPlayerM3963a2);
                if (!abstractC0563ju.m2526b(serverLevel, serverPlayerM3963a2, abstractC0787oF)) {
                    C0562jt.log(String.format("Failed to move spectator '%s' to game '%s'", serverPlayerM3963a2.getScoreboardName(), abstractC0787oF.f4246r), new Object[0]);
                }
            }
        }
        if (abstractC0563ju instanceof C1300xw) {
            ((C1300xw) abstractC0563ju).m7952a().m7937a(this.f4246r, abstractC0787oF.f4246r);
            return true;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m3574a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @Nullable C1088to c1088to, boolean z, @NotNull C0864pd c0864pd, @NotNull Set<UUID> set) {
        MutableComponent mutableComponentEmpty;
        boolean z2 = (abstractC0563ju instanceof C1300xw) && ((C1300xw) abstractC0563ju).mo2551f();
        C0799oR.m3922a(serverLevel, (AbstractC0787oF<?, ?, ?>) this, (AbstractC0790oI<?>) this.f4248a);
        TreeMap treeMap = new TreeMap((v0, v1) -> {
            return v0.compareTo(v1);
        });
        HashSet hashSet = new HashSet();
        set.forEach(uuid -> {
            treeMap.put(uuid, false);
        });
        if (c0864pd.f4532g != null) {
            hashSet.addAll(c0864pd.f4532g.m3872h());
        }
        if (c0864pd.f4533o != null) {
            hashSet.addAll(c0864pd.f4533o);
        }
        hashSet.forEach(uuid2 -> {
            treeMap.merge(uuid2, true, (bool, bool2) -> {
                return true;
            });
        });
        if (c0864pd.f4532g != null) {
            mutableComponentEmpty = Component.translatable("bf.message.gamemode.victorious.team", new Object[]{c0864pd.f4532g.m3860a((AbstractC0787oF<?, ?, ?>) this).m5976a().getName()});
        } else if (c0864pd.f4533o != null && !c0864pd.f4533o.isEmpty()) {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            Iterator<UUID> it = c0864pd.f4533o.iterator();
            while (it.hasNext()) {
                ServerPlayer serverPlayerM3963a = C0799oR.m3963a(it.next());
                if (serverPlayerM3963a != null) {
                    objectArrayList.add(serverPlayerM3963a.getScoreboardName());
                }
            }
            mutableComponentEmpty = Component.translatable("bf.message.gamemode.victorious.team", new Object[]{C0471iH.m2134b(objectArrayList)});
        } else {
            mutableComponentEmpty = Component.empty();
        }
        MutableComponent mutableComponent = mutableComponentEmpty;
        treeMap.forEach((uuid3, bool) -> {
            m3579a((AbstractC0563ju<?, ?, ?>) abstractC0563ju, z2, uuid3, mutableComponent, bool.booleanValue());
        });
        MutableComponent mutableComponent2 = mutableComponentEmpty;
        this.f4248a.m3810i().forEach(uuid4 -> {
            ServerPlayer serverPlayerM3963a2 = C0799oR.m3963a(uuid4);
            if (serverPlayerM3963a2 != null) {
                C1194vo.m6648a(new C1237we(mutableComponent2, true), serverPlayerM3963a2);
            }
        });
        if (z2 && mo3575aZ()) {
            C0799oR.m4012a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this, set, C1089tp.f5687d);
            m3622a(abstractC0563ju, 4, set);
            if (c1088to != null) {
                m3619a(abstractC0563ju, 5, c1088to, z, set);
            }
            if (m3576ba()) {
                m3578a(abstractC0563ju, c0864pd, c1088to);
            }
        }
    }

    /* JADX INFO: renamed from: ba */
    protected boolean m3576ba() {
        C1016sW c1016sWM5531a = C1016sW.m5531a(this.f4237bF);
        if (c1016sWM5531a == null) {
            return false;
        }
        C1016sW.a aVarM5535a = c1016sWM5531a.m5535a();
        return aVarM5535a == C1016sW.a.VERSUS || aVarM5535a == C1016sW.a.COOP;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    protected IMatchReportData mo3577a(@NotNull C0864pd c0864pd) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    private void m3578a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull C0864pd c0864pd, @Nullable C1088to c1088to) {
        C1016sW c1016sWM5531a;
        List objectArrayList;
        MatchResult matchResult;
        Set<UUID> setM3809h = this.f4248a.m3809h();
        if (setM3809h.isEmpty() || (c1016sWM5531a = C1016sW.m5531a(this.f4237bF)) == null) {
            return;
        }
        C0796oO c0796oOM3806a = this.f4248a.m3806a(C1089tp.f5730da);
        C0796oO c0796oOM3806a2 = this.f4248a.m3806a(C1089tp.f5729cZ);
        boolean z = (c0796oOM3806a == null && c0796oOM3806a2 == null) ? false : true;
        String name = c0864pd.f4532g != null ? c0864pd.f4532g.getName() : null;
        int iM3866a = c0796oOM3806a != null ? c0796oOM3806a.m3866a(C1089tp.f5695l) : 0;
        int iM3866a2 = c0796oOM3806a2 != null ? c0796oOM3806a2.m3866a(C1089tp.f5695l) : 0;
        int iM3866a3 = c0796oOM3806a != null ? c0796oOM3806a.m3866a(C1089tp.f5721L) : 0;
        int iM3866a4 = c0796oOM3806a2 != null ? c0796oOM3806a2.m3866a(C1089tp.f5721L) : 0;
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        if (c0864pd.f4532g != null) {
            objectOpenHashSet.addAll(c0864pd.f4532g.m3872h());
        }
        if (c0864pd.f4533o != null) {
            objectOpenHashSet.addAll(c0864pd.f4533o);
        }
        if (c1088to != null) {
            objectArrayList = new ObjectArrayList(C0799oR.m3950a((AbstractC0787oF<?, ?, ?>) this, setM3809h, c1088to));
        } else {
            objectArrayList = new ObjectArrayList(setM3809h);
        }
        List list = objectArrayList;
        ObjectArrayList objectArrayList2 = new ObjectArrayList(setM3809h.size());
        for (UUID uuid : setM3809h) {
            C0794oM c0794oMM3598a = m3598a(uuid);
            C0796oO c0796oOM3793a = this.f4248a.m3793a(uuid);
            String name2 = c0796oOM3793a != null ? c0796oOM3793a.getName() : null;
            if (objectOpenHashSet.isEmpty()) {
                matchResult = MatchResult.DRAW;
            } else {
                matchResult = objectOpenHashSet.contains(uuid) ? MatchResult.WIN : MatchResult.LOSS;
            }
            MatchResult matchResult2 = matchResult;
            int iIndexOf = c1088to != null ? list.indexOf(uuid) + 1 : 0;
            Object2IntOpenHashMap object2IntOpenHashMap = new Object2IntOpenHashMap();
            int iM3853a = c0794oMM3598a.m3853a(C1089tp.f5700q.getKey());
            if (iM3853a != 0) {
                object2IntOpenHashMap.put("captures", iM3853a);
            }
            int iM3853a2 = c0794oMM3598a.m3853a(C1089tp.f5698o.getKey());
            if (iM3853a2 != 0) {
                object2IntOpenHashMap.put("headshots", iM3853a2);
            }
            objectArrayList2.add(new MatchReportPlayer(uuid, name2, matchResult2, iIndexOf, c0794oMM3598a.m3853a(C1089tp.f5713D.getKey()), c0794oMM3598a.m3853a(C1089tp.f5721L.getKey()), c0794oMM3598a.m3853a(C1089tp.f5722M.getKey()), c0794oMM3598a.m3853a(C1089tp.f5695l.getKey()), object2IntOpenHashMap));
        }
        abstractC0563ju.m2520b().sendPacket(new PacketMMMatchReport(m3628e(), c1016sWM5531a.m5534a(), m3591a().getName(), m3653a().getName(), 0, z, name, iM3866a, iM3866a2, iM3866a3, iM3866a4, objectArrayList2, mo3577a(c0864pd)));
    }

    /* JADX INFO: renamed from: a */
    private void m3579a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, boolean z, @NotNull UUID uuid, @NotNull Component component, boolean z2) {
        CloudAchievement cloudAchievementMo3636a;
        if (z2 && z && (cloudAchievementMo3636a = mo3636a()) != null) {
            C0799oR.m4025a(abstractC0563ju, uuid, cloudAchievementMo3636a);
        }
        ServerPlayer serverPlayerM3963a = C0799oR.m3963a(uuid);
        if (serverPlayerM3963a != null) {
            C1194vo.m6648a(new C1237we(component, z2), serverPlayerM3963a);
        }
    }

    /* JADX INFO: renamed from: c */
    void m3580c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, this.f4236bE);
        IPacket.writeBoolean(byteBuf, this.f4241a != null);
        if (this.f4241a != null) {
            IPacket.writeString(byteBuf, ((C1017sX) this.f4241a.m2338a()).getName());
        }
        IPacket.writeString(byteBuf, this.f4237bF);
        IPacket.writeUUID(byteBuf, this.f4246r);
        C0805oX c0805oXM3790c = this.f4248a.m3790c();
        IPacket.writeBoolean(byteBuf, c0805oXM3790c != null);
        if (c0805oXM3790c != null) {
            c0805oXM3790c.mo4111c(byteBuf);
        }
    }

    /* JADX INFO: renamed from: b */
    void m3581b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4236bE = IPacket.readString(byteBuf);
        if (IPacket.readBoolean(byteBuf)) {
            this.f4241a = new C0528jL<>(C1017sX.class, IPacket.readString(byteBuf), C1017sX.f5367b);
        }
        this.f4237bF = IPacket.readString(byteBuf);
        this.f4246r = IPacket.readUUID(byteBuf);
        if (IPacket.readBoolean(byteBuf)) {
            C0805oX c0805oX = new C0805oX();
            c0805oX.mo4110b(byteBuf);
            this.f4248a.m3791a(c0805oX);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public final P m3582b() {
        return this.f4248a;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public final Collection<String> m3583c() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator<C0796oO> it = this.f4248a.m3808A().iterator();
        while (it.hasNext()) {
            objectArrayList.add(it.next().getName());
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: aF */
    public float m3584aF() {
        return 1.0f;
    }

    /* JADX INFO: renamed from: aG */
    public float mo3585aG() {
        return 1.0f;
    }

    /* JADX INFO: renamed from: aU */
    public int m3586aU() {
        return 0;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0795oN m3587a() {
        return this.f4235a;
    }

    /* JADX INFO: renamed from: a */
    public void m3588a(@NotNull EnumC0795oN enumC0795oN) {
        this.f4235a = enumC0795oN;
    }

    /* JADX INFO: renamed from: L */
    public String m3589L() {
        return this.f4236bE;
    }

    /* JADX INFO: renamed from: v */
    public void m3590v(@NotNull String str) {
        this.f4236bE = str;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1017sX m3591a() {
        if (this.f4238a != null) {
            return this.f4238a;
        }
        if (this.f4241a == null || this.f4241a.m2341aj()) {
            return C1017sX.f5367b;
        }
        return (C1017sX) this.f4241a.m2338a();
    }

    /* JADX INFO: renamed from: a */
    public void m3592a(@NotNull C0528jL<C1017sX> c0528jL) {
        this.f4241a = c0528jL;
    }

    /* JADX INFO: renamed from: a */
    public void m3593a(@NotNull C1017sX c1017sX) {
        this.f4241a = new C0528jL<>(c1017sX);
    }

    @NotNull
    /* JADX INFO: renamed from: M */
    public String m3594M() {
        return this.f4237bF;
    }

    /* JADX INFO: renamed from: w */
    public void m3595w(@NotNull String str) {
        this.f4237bF = str;
    }

    /* JADX INFO: renamed from: aV */
    public int m3596aV() {
        return InterfaceC1294xq.f8655tQ;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0794oM m3598a(@NotNull UUID uuid) {
        return (C0794oM) this.f4230e.computeIfAbsent(uuid, obj -> {
            return new C0794oM();
        });
    }

    /* JADX INFO: renamed from: d */
    protected void m3599d(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeBoolean(byteBuf, !this.f4230e.isEmpty());
        if (this.f4230e.isEmpty()) {
            return;
        }
        FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(byteBuf);
        byteBuf.writeInt(this.f4230e.size());
        ObjectIterator it = this.f4230e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            IPacket.writeUUID(byteBuf, (UUID) entry.getKey());
            friendlyByteBuf.writeNbt(((C0794oM) entry.getValue()).m3851a());
        }
    }

    /* JADX INFO: renamed from: e */
    protected void m3600e(@NotNull ByteBuf byteBuf) throws IOException {
        if (IPacket.readBoolean(byteBuf)) {
            this.f4230e.clear();
            FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(byteBuf);
            int i = byteBuf.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                UUID uuid = IPacket.readUUID(byteBuf);
                CompoundTag nbt = friendlyByteBuf.readNbt();
                if (nbt != null) {
                    this.f4230e.put(uuid, new C0794oM(nbt));
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m3601c(@NotNull UUID uuid) {
        this.f4230e.remove(uuid);
    }

    /* JADX INFO: renamed from: cn */
    private void m3602cn() {
        this.f4230e.clear();
    }

    /* JADX INFO: renamed from: d */
    public void m3603d(@Nullable ServerLevel serverLevel) {
        C0562jt.log("Resetting game '%s'...", m3589L());
        UUID uuid = this.f4246r;
        this.f4246r = UUID.randomUUID();
        this.f4247e.m2541a((AbstractC0787oF<?, ?, ?>) this, uuid, this.f4246r);
        this.f4245cU = false;
        this.f4251a.reset();
        this.f4248a.m3802a(this.f4247e, f4225iD);
        this.f4248a.mo3818bf();
        this.f4250a.m5999bf();
        this.f4234a.m4416bf();
        this.f4243q = null;
        this.f4232a.m6035bf();
        m3591a().m5567cA();
        m3565cl();
        m3602cn();
        C0799oR.m3922a(serverLevel, (AbstractC0787oF<?, ?, ?>) this, (AbstractC0790oI<?>) this.f4248a);
        mo3605d((Level) serverLevel);
    }

    /* JADX INFO: renamed from: c */
    public void m3604c(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        if (abstractC0563ju instanceof C1300xw) {
            C1300xw c1300xw = (C1300xw) abstractC0563ju;
            if (c1300xw.mo2551f() && c1300xw.m7961b().m7930ds()) {
                c1300xw.m7954G("Stopping MM server. Game over.");
            }
        }
    }

    @NotNull
    public Component getDisplayName() {
        return this.f4231iE;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0802oU mo3610a() {
        return EnumC0802oU.SAME_TEAM;
    }

    /* JADX INFO: renamed from: bb */
    public boolean mo3611bb() {
        return false;
    }

    /* JADX INFO: renamed from: bc */
    public boolean mo3612bc() {
        return true;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0791oJ mo3613a() {
        return EnumC0791oJ.ALL;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo3614a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        IPacket.writeBoolean(byteBuf, z);
        m3580c(byteBuf);
        m3599d(byteBuf);
        IPacket.writeEnum(byteBuf, this.f4235a);
        this.f4248a.m3819h(byteBuf);
        this.f4232a.m6034c(byteBuf);
        if (z) {
            m3591a().m5565k(byteBuf);
            this.f4239a.m5656c(byteBuf);
        }
    }

    /* JADX INFO: renamed from: f */
    public void m3615f(@NotNull ByteBuf byteBuf) throws IOException {
        C0797oP c0797oPMo5202a;
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        Object objM6000b = this.f4250a.m6000b();
        if ((objM6000b instanceof InterfaceC1082ti) && (c0797oPMo5202a = ((InterfaceC1082ti) objM6000b).mo5202a(this)) != null) {
            IPacket.writeBoolean(byteBuf, true);
            c0797oPMo5202a.m3902c(byteBuf);
        } else {
            IPacket.writeBoolean(byteBuf, false);
        }
        IPacket.writeBoolean(byteBuf, (abstractC0563juM168a instanceof C1300xw) && ((C1300xw) abstractC0563juM168a).mo2551f());
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: g */
    public void mo3616g(@NotNull ByteBuf byteBuf) throws IOException {
        boolean z = IPacket.readBoolean(byteBuf);
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f4254fW && c0622lM2667b == null) {
            throw new AssertionError("Mod manager is null!");
        }
        m3581b(byteBuf);
        m3600e(byteBuf);
        this.f4235a = (EnumC0795oN) IPacket.readEnum(byteBuf, EnumC0795oN.class);
        this.f4248a.m3820g(byteBuf);
        this.f4232a.m6033b(byteBuf);
        if (z) {
            Minecraft minecraft = Minecraft.getInstance();
            if (this.f4238a == null) {
                this.f4238a = new C1017sX(c0622lM2667b);
            }
            this.f4238a.m5566l(byteBuf);
            this.f4239a.m5658a(minecraft, RandomSource.create());
            this.f4239a = new C1018sY(byteBuf);
            this.f4239a.m5593G(minecraft);
            c0622lM2667b.m2698a().m4355u(minecraft);
            Runnable runnable = () -> {
                minecraft.levelRenderer.allChanged();
                c0622lM2667b.m2695a((AbstractC0787oF<?, ?, ?>) this);
            };
            if (!RenderSystem.isOnRenderThread()) {
                Objects.requireNonNull(runnable);
                RenderSystem.recordRenderCall(runnable::run);
            } else {
                runnable.run();
            }
        }
    }

    /* JADX INFO: renamed from: aW */
    public int mo3617aW() {
        return 2;
    }

    /* JADX INFO: renamed from: a */
    public boolean m3618a(@NotNull Set<UUID> set) {
        return set.size() >= mo3617aW();
    }

    /* JADX INFO: renamed from: a */
    protected void m3619a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, int i, @NotNull C1088to c1088to, boolean z, @NotNull Set<UUID> set) {
        m3620a(abstractC0563ju, i, c1088to.getKey(), z, set);
    }

    /* JADX INFO: renamed from: a */
    protected void m3620a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, int i, @NotNull String str, boolean z, @NotNull Set<UUID> set) {
        for (UUID uuid : C0799oR.m3953a((AbstractC0787oF<?, ?, ?>) this, i, str, set)) {
            if (abstractC0563ju.mo2552g() && z) {
                C0799oR.m4015a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this, uuid, C1089tp.f5728S, 1);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m3622a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, int i, @NotNull Set<UUID> set) {
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
        C0799oR.m3980f((AbstractC0787oF<?, ?, ?>) this);
        C0799oR.m3981a((AbstractC0787oF<?, ?, ?>) this, (Component) mutableComponentWithColor);
        for (UUID uuid : C0799oR.m3955a(set, iNextInt)) {
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(uuid);
            if (serverPlayerM3963a != null) {
                C0799oR.m3981a((AbstractC0787oF<?, ?, ?>) this, (Component) Component.literal("  ").append(Component.literal(serverPlayerM3963a.getScoreboardName()).withStyle(ChatFormatting.GOLD)));
                abstractC0563ju.m2520b().sendPacket(new PacketPlayerRandomDrop(uuid, m3628e()));
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1074ta m3623a() {
        return m3591a().m5559e();
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1074ta m3624b() {
        return m3591a().m5560f();
    }

    /* JADX INFO: renamed from: a */
    public void m3625a(@NotNull AbstractC0982rp abstractC0982rp) {
        this.f4229M.add(abstractC0982rp);
    }

    /* JADX INFO: renamed from: be */
    public boolean m3626be() {
        return this.f4245cU;
    }

    /* JADX INFO: renamed from: A */
    public void m3627A(boolean z) {
        this.f4245cU = z;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public UUID m3628e() {
        return this.f4246r;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1092ts m3629a() {
        return this.f4232a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0793oL<? extends AbstractC0787oF<G, P, S>> m3630a() {
        return this.f4233a;
    }

    /* JADX INFO: renamed from: a */
    public void m3631a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        if (this.f4248a.m3811g(uuid)) {
            this.f4248a.m3796c(abstractC0563ju, serverLevel, serverPlayer);
        } else {
            this.f4248a.m3794a(abstractC0563ju, serverLevel, serverPlayer);
            m3601c(uuid);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public boolean m3632a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerPlayer serverPlayer, @NotNull Component component) {
        return !(this instanceof InterfaceC0969rc) || m3633a(abstractC0563ju, (InterfaceC0969rc) this, serverPlayer, serverPlayer.getUUID(), component, this.f4248a.m3809h());
    }

    /* JADX INFO: renamed from: a */
    private boolean m3633a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull InterfaceC0969rc interfaceC0969rc, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull Component component, @NotNull Set<UUID> set) {
        int iMo5208b = interfaceC0969rc.mo5208b(serverPlayer);
        int iMo5209bv = interfaceC0969rc.mo5209bv();
        String[] strArrSplit = component.getString().split(" ");
        if (strArrSplit.length != 1) {
            return true;
        }
        String str = strArrSplit[0];
        DeferredHolder deferredHolder = (DeferredHolder) C1280xc.f7498g.get(str);
        if (deferredHolder == null) {
            return true;
        }
        if (C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this, uuid, C1089tp.f5704u) <= iMo5208b) {
            if (this.f4244mv <= 0) {
                this.f4244mv = iMo5209bv;
                C0799oR.m3938a((AbstractC0787oF<?, ?, ?>) this, (SoundEvent) deferredHolder.get(), SoundSource.MASTER, 100.0f, serverPlayer.position());
                C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this, uuid, C1089tp.f5704u);
                C0799oR.m3981a((AbstractC0787oF<?, ?, ?>) this, (Component) Component.translatable("bf.message.ingame.soundboard.play", new Object[]{Component.literal(serverPlayer.getScoreboardName()).withStyle(ChatFormatting.AQUA), Component.literal(str).withStyle(ChatFormatting.AQUA)}).withStyle(ChatFormatting.BLUE));
                return false;
            }
            C0799oR.m3970c(serverPlayer, (Component) Component.translatable("bf.message.ingame.soundboard.fail.time", new Object[]{String.valueOf(this.f4244mv / 20)}).withStyle(ChatFormatting.RED));
            return false;
        }
        C0799oR.m3970c(serverPlayer, f4223iB);
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof AbstractC0787oF) && ((AbstractC0787oF) obj).f4246r.equals(this.f4246r);
    }

    /* JADX INFO: renamed from: a */
    public boolean m3634a(@NotNull UUID uuid, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid2, boolean z, boolean z2) {
        AbstractC0182b abstractC0182bM1136a = this.f4249b.m1136a((Player) serverPlayer);
        C0796oO c0796oOM3793a = this.f4248a.m3793a(uuid);
        if (!z || c0796oOM3793a == null || c0796oOM3793a.equals(this.f4248a.m3793a(uuid2))) {
            return C0799oR.m4052a((Player) serverPlayer, (AbstractC0182b<?, ?, ?, ?>) abstractC0182bM1136a) || !z2 || mo3635bf();
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public ObjectList<AbstractC0982rp> m3637e() {
        return this.f4229M;
    }

    /* JADX INFO: renamed from: a */
    public void m3638a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C1015sV c1015sV, int i) {
        C0562jt.log("Class type '%s' was requested by '%s'", c1015sV, serverPlayer.getScoreboardName());
        if (!serverLevel.isClientSide() && (this instanceof InterfaceC0902qO)) {
            if (c1015sV.m5526a((AbstractC0787oF<?, ?, ?>) this)) {
                if (this.f4248a.m3774a(abstractC0563ju, serverLevel, serverPlayer, uuid, c1015sV, i)) {
                    C0562jt.log("Player '%s' has changed class to '%s'", serverPlayer.getScoreboardName(), c1015sV);
                    return;
                } else {
                    C0562jt.log("Player '%s' failed to change class to '%s'", serverPlayer.getScoreboardName(), c1015sV);
                    return;
                }
            }
            C0562jt.log("Player '%s' attempted to use an un-allowed class! (%s)", serverPlayer.getScoreboardName(), c1015sV);
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m3639a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        C0796oO c0796oOM3793a = this.f4248a.m3793a(uuid);
        C0796oO c0796oOM3806a = null;
        if (c0796oOM3793a != null) {
            if (c0796oOM3793a.m3881bq()) {
                c0796oOM3806a = this.f4248a.m3806a(C1089tp.f5729cZ);
            } else {
                c0796oOM3806a = this.f4248a.m3806a(C1089tp.f5730da);
            }
        }
        if (c0796oOM3806a != null && m3640a(abstractC0563ju, serverLevel, serverPlayer, uuid, c0796oOM3806a)) {
            C0799oR.m3981a((AbstractC0787oF<?, ?, ?>) this, (Component) Component.translatable("bf.message.gamemode.player.teamswitch", new Object[]{Component.literal(serverPlayer.getScoreboardName()), Component.literal(c0796oOM3806a.getName().toUpperCase()).withStyle(c0796oOM3806a.m3876a())}));
            C0799oR.m4025a(abstractC0563ju, uuid, CloudAchievements.ACH_USER_SWITCH_TEAM);
        }
    }

    /* JADX INFO: renamed from: a */
    protected boolean m3640a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C0796oO c0796oO) {
        if (c0796oO.m3885br()) {
            return false;
        }
        C0796oO c0796oOM3793a = this.f4248a.m3793a(uuid);
        if (c0796oOM3793a != null) {
            c0796oOM3793a.m3870f(uuid);
        }
        m3641d(uuid);
        return this.f4248a.m3804a(abstractC0563ju, EnumC0800oS.SWITCH_TEAMS, serverLevel, serverPlayer, c0796oO);
    }

    /* JADX INFO: renamed from: d */
    protected void m3641d(@NotNull UUID uuid) {
        C0794oM c0794oMM3598a = m3598a(uuid);
        c0794oMM3598a.m3858x(C1089tp.f5692i.getKey());
        c0794oMM3598a.m3858x(C1089tp.f5693j.getKey());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: b */
    public void m3642b(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel) {
        ServerPlayer serverPlayerM3963a;
        C0796oO c0796oOM3806a = this.f4248a.m3806a(C1089tp.f5729cZ);
        C0796oO c0796oOM3806a2 = this.f4248a.m3806a(C1089tp.f5730da);
        if (c0796oOM3806a == null || c0796oOM3806a2 == null) {
            return;
        }
        Set<UUID> setM4056a = C0799oR.m4056a(this.f4249b, this.f4248a.m3809h());
        if (setM4056a.size() < 2) {
            return;
        }
        boolean z = false;
        int i = 0;
        for (UUID uuid : setM4056a) {
            boolean z2 = i % 4 == 0 || i % 4 == 3;
            i++;
            C0796oO c0796oO = z2 ? c0796oOM3806a : c0796oOM3806a2;
            if (this.f4248a.m3793a(uuid) != c0796oO && (serverPlayerM3963a = C0799oR.m3963a(uuid)) != null && m3640a(abstractC0563ju, serverLevel, serverPlayerM3963a, uuid, c0796oO)) {
                z = true;
            }
        }
        if (!z) {
            return;
        }
        if (this instanceof InterfaceC0971re) {
            int iMo5163bx = ((InterfaceC0971re) this).mo5163bx();
            Iterator<UUID> it = setM4056a.iterator();
            while (it.hasNext()) {
                C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this, it.next(), C1089tp.f5708y, iMo5163bx);
            }
        }
        Iterator<UUID> it2 = setM4056a.iterator();
        while (it2.hasNext()) {
            C0799oR.m4004a(it2.next(), f4219ix, 80, "rebalance");
        }
    }

    /* JADX INFO: renamed from: a */
    protected Component m3643a(@NotNull Player player, int i, int i2) {
        C0796oO c0796oOM3793a = this.f4248a.m3793a(player.getUUID());
        Component component = null;
        if (c0796oOM3793a == null) {
            component = f4216iu;
        }
        if (c0796oOM3793a != null && (!c0796oOM3793a.m3881bq() ? i > i2 : i2 > i)) {
            component = f4217iv;
        }
        if (m3587a() == EnumC0795oN.POST_GAME) {
            component = f4218iw;
        }
        return component;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1088to m3644a() {
        return C1089tp.f5695l;
    }

    /* JADX INFO: renamed from: bg */
    public boolean m3645bg() {
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb mo3646a() {
        return this.f4242b;
    }

    /* JADX INFO: renamed from: g */
    public void mo3647g(@NotNull List<MutableComponent> list) {
        Set<a> setMo3649f = mo3649f();
        if (setMo3649f.contains(a.LOBBY) && this.f4248a.f4341e == null) {
            list.add(Component.literal("Lobby position for game '" + this.f4236bE + "' doesn't exist."));
        }
        if (setMo3649f.contains(a.TEAM_SPAWNS)) {
            for (C0796oO c0796oO : this.f4248a.m3808A()) {
                if (c0796oO.m3873B().isEmpty()) {
                    list.add(Component.literal("Team spawns for team '" + c0796oO.getName() + "' for game '" + this.f4236bE + "' don't exist."));
                }
            }
        }
        if (setMo3649f.contains(a.MAP_TYPE)) {
            if (this.f4241a == null) {
                list.add(Component.literal("Map type for game '" + this.f4236bE + "' is null."));
            } else if (this.f4241a.m2341aj()) {
                list.add(Component.literal("Map type for game '" + this.f4236bE + "' doesn't exist. (Custom by default)"));
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0875po m3648a() {
        return this.f4234a;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public Set<a> mo3649f() {
        return EnumSet.allOf(a.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public void m3650a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        if ((this instanceof InterfaceC0905qR) && ((InterfaceC0905qR) this).mo4678d(serverPlayer) && this.f4243q == null) {
            this.f4243q = uuid;
            this.f4248a.m3809h();
            C0799oR.m3943a(serverPlayer, new C1010sQ(f4222iA, 80));
            C0799oR.m3981a((AbstractC0787oF<?, ?, ?>) this, (Component) Component.translatable("bf.message.gamemode.firstblood.announce", new Object[]{serverPlayer.getScoreboardName()}).withStyle(ChatFormatting.DARK_RED));
            C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this, uuid, C1089tp.f5695l);
            C0799oR.m3934a((AbstractC0787oF<?, ?, ?>) this, (SoundEvent) C1280xc.f7610qp.get(), SoundSource.MASTER);
            C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this, uuid, C1089tp.f5697n);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1086tm<G, P> m3651a() {
        return this.f4250a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public MatchSettings m3652a() {
        return this.f4251a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1018sY m3653a() {
        return this.f4239a;
    }

    public void stop() {
        C0562jt.log("Stopping all systems for match '%s'", m3628e());
        m3602cn();
    }
}
