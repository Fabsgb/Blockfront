package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.MatchSettings;
import com.boehmod.bflib.cloud.common.p001mm.report.IMatchReportData;
import com.boehmod.bflib.cloud.common.p001mm.report.MatchReportPlayer;
import com.boehmod.bflib.cloud.common.p001mm.report.MatchResult;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.common.PacketPlayerRandomDrop;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMMatchReport;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import com.boehmod.blockfront.C1058tJ;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.pb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pb.class */
public abstract class AbstractC0863pb<G extends AbstractC0863pb<G, P, S>, P extends AbstractC0866pe<G>, S extends C1058tJ<G, P>> implements Comparable<AbstractC0863pb<?, ?, ?>> {

    /* JADX INFO: renamed from: oo */
    protected static final int f4609oo = 2400;

    /* JADX INFO: renamed from: iG */
    @NotNull
    private static final Component f4610iG;

    /* JADX INFO: renamed from: iH */
    @NotNull
    private static final Component f4611iH;

    /* JADX INFO: renamed from: iI */
    @NotNull
    private static final Component f4612iI;

    /* JADX INFO: renamed from: iJ */
    @NotNull
    private static final Component f4613iJ;

    /* JADX INFO: renamed from: iK */
    @NotNull
    private static final Component f4614iK;

    /* JADX INFO: renamed from: iL */
    @NotNull
    private static final Component f4615iL;

    /* JADX INFO: renamed from: iM */
    @NotNull
    private static final Component f4616iM;

    /* JADX INFO: renamed from: iN */
    @NotNull
    private static final Component f4617iN;

    /* JADX INFO: renamed from: iO */
    @NotNull
    private static final Component f4618iO;

    /* JADX INFO: renamed from: iP */
    @NotNull
    private static final Component f4619iP;

    /* JADX INFO: renamed from: op */
    private static final int f4620op = 4;

    /* JADX INFO: renamed from: oq */
    private static final int f4621oq = 5;

    /* JADX INFO: renamed from: or */
    private static final int f4622or = 4;

    /* JADX INFO: renamed from: V */
    @NotNull
    private final ObjectList<AbstractC0954rM> f4623V;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final Object2ObjectMap<UUID, C0870pi> f4624e;

    /* JADX INFO: renamed from: iQ */
    @NotNull
    private final Component f4625iQ;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1065tQ f4626a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0869ph<G> f4627a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0846pK f4628a;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected EnumC0871pj f4629a;

    /* JADX INFO: renamed from: bN */
    protected String f4630bN;

    /* JADX INFO: renamed from: bO */
    @NotNull
    protected String f4631bO;

    /* JADX INFO: renamed from: a */
    @Nullable
    protected C1095tu f4632a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private C1096tv f4633a;

    /* JADX INFO: renamed from: os */
    private int f4634os;

    /* JADX INFO: renamed from: a */
    @Nullable
    protected C0604kh<C1095tu> f4635a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C0620kx f4636b;

    /* JADX INFO: renamed from: q */
    @Nullable
    private UUID f4637q;

    /* JADX INFO: renamed from: ot */
    private int f4638ot;

    /* JADX INFO: renamed from: dd */
    private boolean f4639dd;

    /* JADX INFO: renamed from: r */
    @NotNull
    private UUID f4640r;

    /* JADX INFO: renamed from: e */
    @NotNull
    protected final AbstractC0531jN<?, ?, ?> f4641e;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final P f4642a;

    /* JADX INFO: renamed from: b */
    protected final AbstractC0184c<?> f4643b;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final C1058tJ<G, P> f4644a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final MatchSettings f4645a;

    /* JADX INFO: renamed from: gp */
    private boolean f4646gp;

    /* JADX INFO: renamed from: ou */
    public static final int f4647ou = 200;

    /* JADX INFO: renamed from: gq */
    static final /* synthetic */ boolean f4648gq;

    /* JADX INFO: renamed from: com.boehmod.blockfront.pb$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pb$a.class */
    public enum a {
        MAP_TYPE,
        LOBBY,
        TEAM_SPAWNS
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract AbstractC0864pc<?, ?> mo3995a(@NotNull C0623l c0623l);

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract P mo3996a();

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract AbstractC1056tH<G, P> mo3999a();

    /* JADX INFO: renamed from: a */
    public abstract void mo4006a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set);

    /* JADX INFO: renamed from: bj */
    protected abstract boolean mo4011bj();

    /* JADX INFO: renamed from: a */
    public abstract boolean mo4033a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull EnumC0876po enumC0876po, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer);

    /* JADX INFO: renamed from: d */
    public abstract void mo4041d(@Nullable Level level);

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract InterfaceC0950rI mo4042a();

    /* JADX INFO: renamed from: a */
    public abstract void mo4043a(@NotNull InterfaceC0950rI interfaceC0950rI);

    /* JADX INFO: renamed from: e */
    public abstract boolean mo4044e(@NotNull Player player);

    /* JADX INFO: renamed from: f */
    public abstract boolean mo4045f(@NotNull Player player);

    /* JADX INFO: renamed from: bn */
    public abstract boolean mo4057bn();

    /* JADX INFO: renamed from: bp */
    public abstract boolean mo4071bp();

    @Nullable
    /* JADX INFO: renamed from: a */
    public abstract CloudAchievement mo4072a();

    static {
        f4648gq = !AbstractC0863pb.class.desiredAssertionStatus();
        f4610iG = Component.translatable("bf.message.gamemode.switchteams.error.noteam");
        f4611iH = Component.translatable("bf.message.gamemode.switchteams.error.unbalanced");
        f4612iI = Component.translatable("bf.message.gamemode.switchteams.error.postgame");
        f4613iJ = Component.translatable("bf.message.gamemode.notification.rebalance");
        f4614iK = Component.translatable("bf.message.command.assets.edit.games.tp.fail");
        f4615iL = Component.translatable("bf.message.command.assets.edit.games.lobby");
        f4616iM = Component.translatable("bf.popup.message.firstblood").withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD);
        f4617iN = Component.translatable("bf.message.ingame.soundboard.fail.count").withStyle(ChatFormatting.RED);
        f4618iO = Component.translatable("bf.message.disconnect.mm.restarting");
        f4619iP = Component.translatable("bf.message.match.concluded").withStyle(ChatFormatting.RED);
    }

    public AbstractC0863pb(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        this(abstractC0531jN, "Unknown", "Unknown");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC0863pb(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull String str, @NotNull String str2) {
        this.f4623V = new ObjectArrayList();
        this.f4624e = new Object2ObjectOpenHashMap();
        this.f4629a = EnumC0871pj.IDLE;
        this.f4630bN = "";
        this.f4633a = new C1096tv("default");
        this.f4634os = 0;
        this.f4636b = new C0620kx().m2840a("tp", new C0620kx((commandContext, strArr) -> {
            ServerPlayer serverPlayer = ((CommandSourceStack) commandContext.getSource()).source;
            C0881pt c0881ptM4226c = m4018b().m4226c();
            if (c0881ptM4226c == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext.getSource()).source, f4614iK);
                return;
            }
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4648gq && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            C0875pn.m4402a((AbstractC0184c<?>) abstractC0531jNM179a.m2351a(), serverPlayer, c0881ptM4226c);
            C0721ms.m3329b(((CommandSourceStack) commandContext.getSource()).source, Component.translatable("bf.message.command.assets.edit.games.tp", new Object[]{Component.literal(this.f4630bN).withStyle(C0533jP.f3188e)}));
        }).m2836a(C0622kz.f3554a)).m2840a("map", new C0620kx((commandContext2, strArr2) -> {
            String str3 = strArr2[0];
            C0721ms.m3329b(((CommandSourceStack) commandContext2.getSource()).source, Component.translatable("bf.message.command.assets.edit.games.mapname", new Object[]{Component.literal(str3).withStyle(C0533jP.f3188e)}));
            m4028a(new C0604kh<>(C1095tu.class, str3, C1095tu.f5931b));
        }).m2836a(C0622kz.m2847a(new String[]{"mapName"})).m2842a((commandContext3, strArr3) -> {
            C0605ki c0605kiM2737a;
            if (strArr3.length <= 0 && (c0605kiM2737a = C0607kk.m2734c().m2737a(C1095tu.class)) != null) {
                return c0605kiM2737a.m2720d().keySet();
            }
            return List.of();
        })).m2840a("lobby", new C0620kx((commandContext4, strArr4) -> {
            Player player = ((CommandSourceStack) commandContext4.getSource()).source;
            C0721ms.m3329b(((CommandSourceStack) commandContext4.getSource()).source, f4615iL);
            m4018b().m4227a(new C0881pt(player));
        }).m2836a(C0622kz.f3554a));
        this.f4637q = null;
        this.f4638ot = 0;
        this.f4639dd = false;
        this.f4640r = UUID.randomUUID();
        this.f4645a = new MatchSettings();
        this.f4646gp = true;
        this.f4641e = abstractC0531jN;
        this.f4643b = abstractC0531jN.m2351a();
        this.f4642a = (P) mo3996a();
        this.f4644a = new C1058tJ<>(this);
        this.f4631bO = str;
        this.f4625iQ = Component.literal(str2);
        this.f4626a = new C1065tQ(this);
        this.f4627a = new C0869ph<>(this);
        ServerLevel serverLevel = null;
        MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
        C0875pn.m4358a(minecraftServerM2335a != null ? minecraftServerM2335a.getLevel(Level.OVERWORLD) : serverLevel, (AbstractC0863pb<?, ?, ?>) this, (AbstractC0866pe<?>) this.f4642a);
        this.f4628a = new C0846pK(this instanceof InterfaceC0989rv ? ((InterfaceC0989rv) this).mo5349bJ() : 1);
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public Set<C1093ts> mo3997e() {
        return Set.of();
    }

    /* JADX INFO: renamed from: bh */
    public int mo3998bh() {
        return 200;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        return Integer.compare(abstractC0863pb.m4018b().m4245h().size(), this.f4642a.m4245h().size());
    }

    /* JADX INFO: renamed from: cx */
    public void m4001cx() {
        C1095tu c1095tuM4027a = m4027a();
        ObjectArrayList objectArrayList = new ObjectArrayList(c1095tuM4027a.m6051o().values());
        C0530jM.log("Refreshing random environment for map '%s'... (%d Available)", m4027a().getName(), Integer.valueOf(objectArrayList.size()));
        this.f4633a = (C1096tv) objectArrayList.get(ThreadLocalRandom.current().nextInt(objectArrayList.size()));
        this.f4634os++;
        C0530jM.log("Selected '%s' as the random environment for map '%s'.", this.f4633a.getName(), c1095tuM4027a.getName());
    }

    /* JADX INFO: renamed from: cy */
    public void m4002cy() {
        C1095tu c1095tuM4027a = m4027a();
        Map<String, C1096tv> mapM6051o = c1095tuM4027a.m6051o();
        if (mapM6051o.isEmpty()) {
            C0530jM.logError("[Map Reload] Map '%s' has no environments after reload, keeping previous environment reference.", c1095tuM4027a.getName());
            return;
        }
        String name = this.f4633a.getName();
        C1096tv c1096tv = mapM6051o.get(name);
        if (c1096tv != null) {
            this.f4633a = c1096tv;
            this.f4634os++;
            C0530jM.log("[Map Reload] Re-bound environment '%s' on map '%s' to the freshly-loaded instance.", name, c1095tuM4027a.getName());
        } else {
            C0530jM.log("[Map Reload] Environment '%s' no longer present on map '%s', picking a new one at random.", name, c1095tuM4027a.getName());
            m4001cx();
        }
    }

    /* JADX INFO: renamed from: bi */
    public int m4003bi() {
        return this.f4634os;
    }

    /* JADX INFO: renamed from: a */
    public void m4004a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel) {
        Set<UUID> setM4245h = this.f4642a.m4245h();
        if (m4005a(serverLevel, setM4245h)) {
            return;
        }
        this.f4646gp = false;
        if (this.f4639dd) {
            return;
        }
        if (this.f4638ot > 0) {
            this.f4638ot--;
        }
        m4089a().m6079a(this, abstractC0531jN, serverLevel, setM4245h);
        m4073i().removeIf(abstractC0954rM -> {
            return !abstractC0954rM.mo5292a(serverLevel, (AbstractC0863pb<?, ?, ?>) this, (Set<UUID>) setM4245h);
        });
        this.f4642a.m4208a(setM4245h);
        mo4006a(abstractC0531jN, this.f4643b, serverLevel, setM4245h);
    }

    /* JADX INFO: renamed from: a */
    private boolean m4005a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        if (set.isEmpty()) {
            m4024a(EnumC0871pj.IDLE);
            if (!this.f4646gp) {
                this.f4646gp = true;
                C0530jM.log("[STAGE] No players in match '%s'! Restarting game.", m4025S());
                m4039d(serverLevel);
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public boolean m4007a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull String str) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2360a = abstractC0531jN.m2360a(str);
        return abstractC0863pbM2360a != null && m4009a(abstractC0531jN, serverLevel, abstractC0863pbM2360a);
    }

    /* JADX INFO: renamed from: a */
    public boolean m4008a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull UUID uuid) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2361b = abstractC0531jN.m2361b(uuid);
        if (abstractC0863pbM2361b == null) {
            C0530jM.log("[Move] Failed to find game with UUID '%s'.", uuid);
            return false;
        }
        if (abstractC0531jN.m2369a(abstractC0863pbM2361b.m4027a(), (AbstractC0863pb<?, ?, ?>) this)) {
            C0530jM.log("[Move] Map '%s' is occupied.", abstractC0863pbM2361b.m4027a().getName());
            return false;
        }
        if (abstractC0863pbM2361b.f4629a != EnumC0871pj.IDLE) {
            C0530jM.log("[Move] Game '%s' is not idle.", abstractC0863pbM2361b.f4629a);
            return false;
        }
        C0530jM.log("[Move] Moving lobby to game '%s'...", abstractC0863pbM2361b.m4025S());
        return m4009a(abstractC0531jN, serverLevel, abstractC0863pbM2361b);
    }

    /* JADX INFO: renamed from: a */
    public boolean m4009a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        Set<UUID> setM4245h = this.f4642a.m4245h();
        C0874pm c0874pmM4253a = this.f4642a.m4253a();
        c0874pmM4253a.m4339cH();
        abstractC0863pb.m4018b().m4253a().m4347a(c0874pmM4253a);
        abstractC0863pb.m4088a().copyFrom(this.f4645a);
        Iterator<UUID> it = C0875pn.m4492a(this.f4643b, setM4245h).iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(it.next());
            if (serverPlayerM4399a != null) {
                this.f4642a.m4230a(abstractC0531jN, serverLevel, serverPlayerM4399a);
                if (!abstractC0531jN.m2348a(serverLevel, serverPlayerM4399a, abstractC0863pb)) {
                    C0530jM.log(String.format("Failed to assign player '%s' to game '%s', running game-mode '%s' on map '%s'", serverPlayerM4399a.getScoreboardName(), abstractC0863pb.f4640r, abstractC0863pb.f4631bO, abstractC0863pb.m4027a().getName()), new Object[0]);
                    C0875pn.m4398b(serverPlayerM4399a, f4618iO);
                }
            }
        }
        ObjectListIterator it2 = new ObjectArrayList(this.f4642a.m4246i()).iterator();
        while (it2.hasNext()) {
            ServerPlayer serverPlayerM4399a2 = C0875pn.m4399a((UUID) it2.next());
            if (serverPlayerM4399a2 != null) {
                this.f4642a.m4232c(abstractC0531jN, serverLevel, serverPlayerM4399a2);
                if (!abstractC0531jN.m2349b(serverLevel, serverPlayerM4399a2, abstractC0863pb)) {
                    C0530jM.log(String.format("Failed to move spectator '%s' to game '%s'", serverPlayerM4399a2.getScoreboardName(), abstractC0863pb.f4640r), new Object[0]);
                }
            }
        }
        if (abstractC0531jN instanceof C1280xT) {
            ((C1280xT) abstractC0531jN).m7279a().m7264a(this.f4640r, abstractC0863pb.f4640r);
            return true;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m4010a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @Nullable C1060tL c1060tL, boolean z, @NotNull C0887pz c0887pz, @NotNull Set<UUID> set) {
        MutableComponent mutableComponentEmpty;
        boolean z2 = (abstractC0531jN instanceof C1280xT) && ((C1280xT) abstractC0531jN).mo2374f();
        C0875pn.m4358a(serverLevel, (AbstractC0863pb<?, ?, ?>) this, (AbstractC0866pe<?>) this.f4642a);
        TreeMap treeMap = new TreeMap((v0, v1) -> {
            return v0.compareTo(v1);
        });
        HashSet hashSet = new HashSet();
        set.forEach(uuid -> {
            treeMap.put(uuid, false);
        });
        if (c0887pz.f4865i != null) {
            hashSet.addAll(c0887pz.f4865i.m4308h());
        }
        if (c0887pz.f4866p != null) {
            hashSet.addAll(c0887pz.f4866p);
        }
        hashSet.forEach(uuid2 -> {
            treeMap.merge(uuid2, true, (bool, bool2) -> {
                return true;
            });
        });
        if (c0887pz.f4865i != null) {
            mutableComponentEmpty = Component.translatable("bf.message.gamemode.victorious.team", new Object[]{c0887pz.f4865i.m4296a((AbstractC0863pb<?, ?, ?>) this).m6179a().getName()});
        } else if (c0887pz.f4866p != null && !c0887pz.f4866p.isEmpty()) {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            Iterator<UUID> it = c0887pz.f4866p.iterator();
            while (it.hasNext()) {
                ServerPlayer serverPlayerM4399a = C0875pn.m4399a(it.next());
                if (serverPlayerM4399a != null) {
                    objectArrayList.add(serverPlayerM4399a.getScoreboardName());
                }
            }
            mutableComponentEmpty = Component.translatable("bf.message.gamemode.victorious.team", new Object[]{C0544ja.m2461b(objectArrayList)});
        } else {
            mutableComponentEmpty = Component.empty();
        }
        MutableComponent mutableComponent = mutableComponentEmpty;
        treeMap.forEach((uuid3, bool) -> {
            m4015a((AbstractC0531jN<?, ?, ?>) abstractC0531jN, z2, uuid3, mutableComponent, bool.booleanValue());
        });
        MutableComponent mutableComponent2 = mutableComponentEmpty;
        this.f4642a.m4246i().forEach(uuid4 -> {
            ServerPlayer serverPlayerM4399a2 = C0875pn.m4399a(uuid4);
            if (serverPlayerM4399a2 != null) {
                C1169vO.m6643a(new C1211wD(mutableComponent2, true), serverPlayerM4399a2);
            }
        });
        if (z2 && mo4011bj()) {
            C0875pn.m4448a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this, set, C1062tN.f5740d);
            m4058a(abstractC0531jN, 4, set);
            if (c1060tL != null) {
                m4055a(abstractC0531jN, 5, c1060tL, z, set);
            }
            if (m4012bk()) {
                m4014a(abstractC0531jN, c0887pz, c1060tL);
            }
        }
    }

    /* JADX INFO: renamed from: bk */
    protected boolean m4012bk() {
        C1094tt c1094ttM6019a = C1094tt.m6019a(this.f4631bO);
        if (c1094ttM6019a == null) {
            return false;
        }
        C1094tt.a aVarM6023a = c1094ttM6019a.m6023a();
        return aVarM6023a == C1094tt.a.VERSUS || aVarM6023a == C1094tt.a.COOP;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    protected IMatchReportData mo4013a(@NotNull C0887pz c0887pz) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    private void m4014a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull C0887pz c0887pz, @Nullable C1060tL c1060tL) {
        C1094tt c1094ttM6019a;
        List objectArrayList;
        MatchResult matchResult;
        Set<UUID> setM4245h = this.f4642a.m4245h();
        if (setM4245h.isEmpty() || (c1094ttM6019a = C1094tt.m6019a(this.f4631bO)) == null) {
            return;
        }
        C0872pk c0872pkM4242a = this.f4642a.m4242a(C1062tN.f5783dl);
        C0872pk c0872pkM4242a2 = this.f4642a.m4242a(C1062tN.f5782dk);
        boolean z = (c0872pkM4242a == null && c0872pkM4242a2 == null) ? false : true;
        String name = c0887pz.f4865i != null ? c0887pz.f4865i.getName() : null;
        int iM4302a = c0872pkM4242a != null ? c0872pkM4242a.m4302a(C1062tN.f5748l) : 0;
        int iM4302a2 = c0872pkM4242a2 != null ? c0872pkM4242a2.m4302a(C1062tN.f5748l) : 0;
        int iM4302a3 = c0872pkM4242a != null ? c0872pkM4242a.m4302a(C1062tN.f5774L) : 0;
        int iM4302a4 = c0872pkM4242a2 != null ? c0872pkM4242a2.m4302a(C1062tN.f5774L) : 0;
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        if (c0887pz.f4865i != null) {
            objectOpenHashSet.addAll(c0887pz.f4865i.m4308h());
        }
        if (c0887pz.f4866p != null) {
            objectOpenHashSet.addAll(c0887pz.f4866p);
        }
        if (c1060tL != null) {
            objectArrayList = new ObjectArrayList(C0875pn.m4386a((AbstractC0863pb<?, ?, ?>) this, setM4245h, c1060tL));
        } else {
            objectArrayList = new ObjectArrayList(setM4245h);
        }
        List list = objectArrayList;
        ObjectArrayList objectArrayList2 = new ObjectArrayList(setM4245h.size());
        for (UUID uuid : setM4245h) {
            C0870pi c0870piM4034a = m4034a(uuid);
            C0872pk c0872pkM4229a = this.f4642a.m4229a(uuid);
            String name2 = c0872pkM4229a != null ? c0872pkM4229a.getName() : null;
            if (objectOpenHashSet.isEmpty()) {
                matchResult = MatchResult.DRAW;
            } else {
                matchResult = objectOpenHashSet.contains(uuid) ? MatchResult.WIN : MatchResult.LOSS;
            }
            MatchResult matchResult2 = matchResult;
            int iIndexOf = c1060tL != null ? list.indexOf(uuid) + 1 : 0;
            Object2IntOpenHashMap object2IntOpenHashMap = new Object2IntOpenHashMap();
            int iM4289a = c0870piM4034a.m4289a(C1062tN.f5753q.getKey());
            if (iM4289a != 0) {
                object2IntOpenHashMap.put("captures", iM4289a);
            }
            int iM4289a2 = c0870piM4034a.m4289a(C1062tN.f5751o.getKey());
            if (iM4289a2 != 0) {
                object2IntOpenHashMap.put("headshots", iM4289a2);
            }
            objectArrayList2.add(new MatchReportPlayer(uuid, name2, matchResult2, iIndexOf, c0870piM4034a.m4289a(C1062tN.f5766D.getKey()), c0870piM4034a.m4289a(C1062tN.f5774L.getKey()), c0870piM4034a.m4289a(C1062tN.f5775M.getKey()), c0870piM4034a.m4289a(C1062tN.f5748l.getKey()), object2IntOpenHashMap));
        }
        abstractC0531jN.m2342b().sendPacket(new PacketMMMatchReport(m4064e(), c1094ttM6019a.m6022a(), m4027a().getName(), m4089a().getName(), 0, z, name, iM4302a, iM4302a2, iM4302a3, iM4302a4, objectArrayList2, mo4013a(c0887pz)));
    }

    /* JADX INFO: renamed from: a */
    private void m4015a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, boolean z, @NotNull UUID uuid, @NotNull Component component, boolean z2) {
        CloudAchievement cloudAchievementMo4072a;
        if (z2 && z && (cloudAchievementMo4072a = mo4072a()) != null) {
            C0875pn.m4461a(abstractC0531jN, uuid, cloudAchievementMo4072a);
        }
        ServerPlayer serverPlayerM4399a = C0875pn.m4399a(uuid);
        if (serverPlayerM4399a != null) {
            C1169vO.m6643a(new C1211wD(component, z2), serverPlayerM4399a);
        }
    }

    /* JADX INFO: renamed from: c */
    void m4016c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, this.f4630bN);
        IPacket.writeBoolean(byteBuf, this.f4635a != null);
        if (this.f4635a != null) {
            IPacket.writeString(byteBuf, ((C1095tu) this.f4635a.m2698a()).getName());
        }
        IPacket.writeString(byteBuf, this.f4631bO);
        IPacket.writeUUID(byteBuf, this.f4640r);
        C0881pt c0881ptM4226c = this.f4642a.m4226c();
        IPacket.writeBoolean(byteBuf, c0881ptM4226c != null);
        if (c0881ptM4226c != null) {
            c0881ptM4226c.mo3870c(byteBuf);
        }
    }

    /* JADX INFO: renamed from: b */
    void m4017b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4630bN = IPacket.readString(byteBuf);
        if (IPacket.readBoolean(byteBuf)) {
            this.f4635a = new C0604kh<>(C1095tu.class, IPacket.readString(byteBuf), C1095tu.f5931b);
        }
        this.f4631bO = IPacket.readString(byteBuf);
        this.f4640r = IPacket.readUUID(byteBuf);
        if (IPacket.readBoolean(byteBuf)) {
            C0881pt c0881pt = new C0881pt();
            c0881pt.mo3869b(byteBuf);
            this.f4642a.m4227a(c0881pt);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public final P m4018b() {
        return this.f4642a;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public final Collection<String> m4019c() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator<C0872pk> it = this.f4642a.m4244C().iterator();
        while (it.hasNext()) {
            objectArrayList.add(it.next().getName());
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: aL */
    public float m4020aL() {
        return 1.0f;
    }

    /* JADX INFO: renamed from: aM */
    public float mo4021aM() {
        return 1.0f;
    }

    /* JADX INFO: renamed from: bj */
    public int m4022bj() {
        return 0;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0871pj m4023a() {
        return this.f4629a;
    }

    /* JADX INFO: renamed from: a */
    public void m4024a(@NotNull EnumC0871pj enumC0871pj) {
        this.f4629a = enumC0871pj;
    }

    /* JADX INFO: renamed from: S */
    public String m4025S() {
        return this.f4630bN;
    }

    /* JADX INFO: renamed from: v */
    public void m4026v(@NotNull String str) {
        this.f4630bN = str;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1095tu m4027a() {
        if (this.f4632a != null) {
            return this.f4632a;
        }
        if (this.f4635a == null || this.f4635a.m2701at()) {
            return C1095tu.f5931b;
        }
        return (C1095tu) this.f4635a.m2698a();
    }

    /* JADX INFO: renamed from: a */
    public void m4028a(@NotNull C0604kh<C1095tu> c0604kh) {
        this.f4635a = c0604kh;
    }

    /* JADX INFO: renamed from: a */
    public void m4029a(@NotNull C1095tu c1095tu) {
        this.f4635a = new C0604kh<>(c1095tu);
    }

    @NotNull
    /* JADX INFO: renamed from: T */
    public String m4030T() {
        return this.f4631bO;
    }

    /* JADX INFO: renamed from: w */
    public void m4031w(@NotNull String str) {
        this.f4631bO = str;
    }

    /* JADX INFO: renamed from: bk */
    public int m4032bk() {
        return InterfaceC1274xN.f6852vU;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0870pi m4034a(@NotNull UUID uuid) {
        return (C0870pi) this.f4624e.computeIfAbsent(uuid, obj -> {
            return new C0870pi();
        });
    }

    /* JADX INFO: renamed from: d */
    protected void m4035d(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeBoolean(byteBuf, !this.f4624e.isEmpty());
        if (this.f4624e.isEmpty()) {
            return;
        }
        FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(byteBuf);
        byteBuf.writeInt(this.f4624e.size());
        ObjectIterator it = this.f4624e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            IPacket.writeUUID(byteBuf, (UUID) entry.getKey());
            friendlyByteBuf.writeNbt(((C0870pi) entry.getValue()).m4287a());
        }
    }

    /* JADX INFO: renamed from: e */
    protected void m4036e(@NotNull ByteBuf byteBuf) throws IOException {
        if (IPacket.readBoolean(byteBuf)) {
            this.f4624e.clear();
            FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(byteBuf);
            int i = byteBuf.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                UUID uuid = IPacket.readUUID(byteBuf);
                CompoundTag nbt = friendlyByteBuf.readNbt();
                if (nbt != null) {
                    this.f4624e.put(uuid, new C0870pi(nbt));
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m4037c(@NotNull UUID uuid) {
        this.f4624e.remove(uuid);
    }

    /* JADX INFO: renamed from: cz */
    private void m4038cz() {
        this.f4624e.clear();
    }

    /* JADX INFO: renamed from: d */
    public void m4039d(@Nullable ServerLevel serverLevel) {
        C0530jM.log("Resetting game '%s'...", m4025S());
        UUID uuid = this.f4640r;
        this.f4640r = UUID.randomUUID();
        this.f4641e.m2364a((AbstractC0863pb<?, ?, ?>) this, uuid, this.f4640r);
        this.f4639dd = false;
        this.f4645a.reset();
        this.f4642a.m4238a(this.f4641e, f4619iP);
        this.f4642a.mo4254bd();
        this.f4644a.m5879bd();
        this.f4628a.m3904bd();
        this.f4637q = null;
        this.f4626a.m5921bd();
        m4027a().m6055cM();
        m4001cx();
        m4038cz();
        C0875pn.m4358a(serverLevel, (AbstractC0863pb<?, ?, ?>) this, (AbstractC0866pe<?>) this.f4642a);
        mo4041d((Level) serverLevel);
    }

    /* JADX INFO: renamed from: c */
    public void m4040c(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        if (abstractC0531jN instanceof C1280xT) {
            C1280xT c1280xT = (C1280xT) abstractC0531jN;
            if (c1280xT.mo2374f() && c1280xT.m7289b().m7257dB()) {
                c1280xT.m7282G("Stopping MM server. Game over.");
            }
        }
    }

    @NotNull
    public Component getDisplayName() {
        return this.f4625iQ;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0878pq mo4046a() {
        return EnumC0878pq.SAME_TEAM;
    }

    /* JADX INFO: renamed from: bl */
    public boolean mo4047bl() {
        return false;
    }

    /* JADX INFO: renamed from: bm */
    public boolean mo4048bm() {
        return true;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0867pf mo4049a() {
        return EnumC0867pf.ALL;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo4050a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        IPacket.writeBoolean(byteBuf, z);
        m4016c(byteBuf);
        m4035d(byteBuf);
        IPacket.writeEnum(byteBuf, this.f4629a);
        this.f4642a.m4255h(byteBuf);
        this.f4626a.m5920c(byteBuf);
        if (z) {
            m4027a().m6053k(byteBuf);
            this.f4633a.m6144c(byteBuf);
        }
    }

    /* JADX INFO: renamed from: f */
    public void m4051f(@NotNull ByteBuf byteBuf) throws IOException {
        C0873pl c0873plMo5608a;
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        Object objM5880b = this.f4644a.m5880b();
        if ((objM5880b instanceof InterfaceC1054tF) && (c0873plMo5608a = ((InterfaceC1054tF) objM5880b).mo5608a(this)) != null) {
            IPacket.writeBoolean(byteBuf, true);
            c0873plMo5608a.m4338c(byteBuf);
        } else {
            IPacket.writeBoolean(byteBuf, false);
        }
        IPacket.writeBoolean(byteBuf, (abstractC0531jNM179a instanceof C1280xT) && ((C1280xT) abstractC0531jNM179a).mo2374f());
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: g */
    public void mo4052g(@NotNull ByteBuf byteBuf) throws IOException {
        boolean z = IPacket.readBoolean(byteBuf);
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f4648gq && c0623lM2852b == null) {
            throw new AssertionError("Mod manager is null!");
        }
        m4017b(byteBuf);
        m4036e(byteBuf);
        this.f4629a = (EnumC0871pj) IPacket.readEnum(byteBuf, EnumC0871pj.class);
        this.f4642a.m4256g(byteBuf);
        this.f4626a.m5919b(byteBuf);
        if (z) {
            Minecraft minecraft = Minecraft.getInstance();
            if (this.f4632a == null) {
                this.f4632a = new C1095tu(c0623lM2852b);
            }
            this.f4632a.m6054l(byteBuf);
            this.f4633a.m6146a(minecraft, RandomSource.create());
            this.f4633a = new C1096tv(byteBuf);
            this.f4633a.m6081I(minecraft);
            c0623lM2852b.m2884a().m3840w(minecraft);
            Runnable runnable = () -> {
                minecraft.levelRenderer.allChanged();
                c0623lM2852b.m2881a((AbstractC0863pb<?, ?, ?>) this);
            };
            if (!RenderSystem.isOnRenderThread()) {
                Objects.requireNonNull(runnable);
                RenderSystem.recordRenderCall(runnable::run);
            } else {
                runnable.run();
            }
        }
    }

    /* JADX INFO: renamed from: bl */
    public int mo4053bl() {
        return 2;
    }

    /* JADX INFO: renamed from: a */
    public boolean m4054a(@NotNull Set<UUID> set) {
        return set.size() >= mo4053bl();
    }

    /* JADX INFO: renamed from: a */
    protected void m4055a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, int i, @NotNull C1060tL c1060tL, boolean z, @NotNull Set<UUID> set) {
        m4056a(abstractC0531jN, i, c1060tL.getKey(), z, set);
    }

    /* JADX INFO: renamed from: a */
    protected void m4056a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, int i, @NotNull String str, boolean z, @NotNull Set<UUID> set) {
        for (UUID uuid : C0875pn.m4389a((AbstractC0863pb<?, ?, ?>) this, i, str, set)) {
            if (abstractC0531jN.mo2375g() && z) {
                C0875pn.m4451a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this, uuid, C1062tN.f5781S, 1);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m4058a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, int i, @NotNull Set<UUID> set) {
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
        C0875pn.m4416f((AbstractC0863pb<?, ?, ?>) this);
        C0875pn.m4417a((AbstractC0863pb<?, ?, ?>) this, (Component) mutableComponentWithColor);
        for (UUID uuid : C0875pn.m4391a(set, iNextInt)) {
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(uuid);
            if (serverPlayerM4399a != null) {
                C0875pn.m4417a((AbstractC0863pb<?, ?, ?>) this, (Component) Component.literal("  ").append(Component.literal(serverPlayerM4399a.getScoreboardName()).withStyle(ChatFormatting.GOLD)));
                abstractC0531jN.m2342b().sendPacket(new PacketPlayerRandomDrop(uuid, m4064e()));
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1098tx m4059a() {
        return m4027a().m6047e();
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1098tx m4060b() {
        return m4027a().m6048f();
    }

    /* JADX INFO: renamed from: a */
    public void m4061a(@NotNull AbstractC0954rM abstractC0954rM) {
        this.f4623V.add(abstractC0954rM);
    }

    /* JADX INFO: renamed from: bo */
    public boolean m4062bo() {
        return this.f4639dd;
    }

    /* JADX INFO: renamed from: A */
    public void m4063A(boolean z) {
        this.f4639dd = z;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public UUID m4064e() {
        return this.f4640r;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1065tQ m4065a() {
        return this.f4626a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0869ph<? extends AbstractC0863pb<G, P, S>> m4066a() {
        return this.f4627a;
    }

    /* JADX INFO: renamed from: a */
    public void m4067a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        if (this.f4642a.m4247g(uuid)) {
            this.f4642a.m4232c(abstractC0531jN, serverLevel, serverPlayer);
        } else {
            this.f4642a.m4230a(abstractC0531jN, serverLevel, serverPlayer);
            m4037c(uuid);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public boolean m4068a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerPlayer serverPlayer, @NotNull Component component) {
        return !(this instanceof InterfaceC0993rz) || m4069a(abstractC0531jN, (InterfaceC0993rz) this, serverPlayer, serverPlayer.getUUID(), component, this.f4642a.m4245h());
    }

    /* JADX INFO: renamed from: a */
    private boolean m4069a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull InterfaceC0993rz interfaceC0993rz, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull Component component, @NotNull Set<UUID> set) {
        int iMo5568b = interfaceC0993rz.mo5568b(serverPlayer);
        int iMo5569bK = interfaceC0993rz.mo5569bK();
        String[] strArrSplit = component.getString().split(" ");
        if (strArrSplit.length != 1) {
            return true;
        }
        String str = strArrSplit[0];
        DeferredHolder deferredHolder = (DeferredHolder) C1312xz.f7910g.get(str);
        if (deferredHolder == null) {
            return true;
        }
        if (C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this, uuid, C1062tN.f5757u) <= iMo5568b) {
            if (this.f4638ot <= 0) {
                this.f4638ot = iMo5569bK;
                C0875pn.m4374a((AbstractC0863pb<?, ?, ?>) this, (SoundEvent) deferredHolder.get(), SoundSource.MASTER, 100.0f, serverPlayer.position());
                C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this, uuid, C1062tN.f5757u);
                C0875pn.m4417a((AbstractC0863pb<?, ?, ?>) this, (Component) Component.translatable("bf.message.ingame.soundboard.play", new Object[]{Component.literal(serverPlayer.getScoreboardName()).withStyle(ChatFormatting.AQUA), Component.literal(str).withStyle(ChatFormatting.AQUA)}).withStyle(ChatFormatting.BLUE));
                return false;
            }
            C0875pn.m4406c(serverPlayer, (Component) Component.translatable("bf.message.ingame.soundboard.fail.time", new Object[]{String.valueOf(this.f4638ot / 20)}).withStyle(ChatFormatting.RED));
            return false;
        }
        C0875pn.m4406c(serverPlayer, f4617iN);
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof AbstractC0863pb) && ((AbstractC0863pb) obj).f4640r.equals(this.f4640r);
    }

    /* JADX INFO: renamed from: a */
    public boolean m4070a(@NotNull UUID uuid, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid2, boolean z, boolean z2) {
        AbstractC0183b abstractC0183bM1153a = this.f4643b.m1153a((Player) serverPlayer);
        C0872pk c0872pkM4229a = this.f4642a.m4229a(uuid);
        if (!z || c0872pkM4229a == null || c0872pkM4229a.equals(this.f4642a.m4229a(uuid2))) {
            return C0875pn.m4488a((Player) serverPlayer, (AbstractC0183b<?, ?, ?, ?>) abstractC0183bM1153a) || !z2 || mo4071bp();
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public ObjectList<AbstractC0954rM> m4073i() {
        return this.f4623V;
    }

    /* JADX INFO: renamed from: a */
    public void m4074a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C1093ts c1093ts, int i) {
        C0530jM.log("Class type '%s' was requested by '%s'", c1093ts, serverPlayer.getScoreboardName());
        if (!serverLevel.isClientSide() && (this instanceof InterfaceC0979rl)) {
            if (c1093ts.m6014a((AbstractC0863pb<?, ?, ?>) this)) {
                if (this.f4642a.m4210a(abstractC0531jN, serverLevel, serverPlayer, uuid, c1093ts, i)) {
                    C0530jM.log("Player '%s' has changed class to '%s'", serverPlayer.getScoreboardName(), c1093ts);
                    return;
                } else {
                    C0530jM.log("Player '%s' failed to change class to '%s'", serverPlayer.getScoreboardName(), c1093ts);
                    return;
                }
            }
            C0530jM.log("Player '%s' attempted to use an un-allowed class! (%s)", serverPlayer.getScoreboardName(), c1093ts);
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m4075a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        C0872pk c0872pkM4229a = this.f4642a.m4229a(uuid);
        C0872pk c0872pkM4242a = null;
        if (c0872pkM4229a != null) {
            if (c0872pkM4229a.m4317bA()) {
                c0872pkM4242a = this.f4642a.m4242a(C1062tN.f5782dk);
            } else {
                c0872pkM4242a = this.f4642a.m4242a(C1062tN.f5783dl);
            }
        }
        if (c0872pkM4242a != null && m4076a(abstractC0531jN, serverLevel, serverPlayer, uuid, c0872pkM4242a)) {
            C0875pn.m4417a((AbstractC0863pb<?, ?, ?>) this, (Component) Component.translatable("bf.message.gamemode.player.teamswitch", new Object[]{Component.literal(serverPlayer.getScoreboardName()), Component.literal(c0872pkM4242a.getName().toUpperCase()).withStyle(c0872pkM4242a.m4312a())}));
            C0875pn.m4461a(abstractC0531jN, uuid, CloudAchievements.ACH_USER_SWITCH_TEAM);
        }
    }

    /* JADX INFO: renamed from: a */
    protected boolean m4076a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C0872pk c0872pk) {
        if (c0872pk.m4321bB()) {
            return false;
        }
        C0872pk c0872pkM4229a = this.f4642a.m4229a(uuid);
        if (c0872pkM4229a != null) {
            c0872pkM4229a.m4306f(uuid);
        }
        m4077d(uuid);
        return this.f4642a.m4240a(abstractC0531jN, EnumC0876po.SWITCH_TEAMS, serverLevel, serverPlayer, c0872pk);
    }

    /* JADX INFO: renamed from: d */
    protected void m4077d(@NotNull UUID uuid) {
        C0870pi c0870piM4034a = m4034a(uuid);
        c0870piM4034a.m4294x(C1062tN.f5745i.getKey());
        c0870piM4034a.m4294x(C1062tN.f5746j.getKey());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: b */
    public void m4078b(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel) {
        ServerPlayer serverPlayerM4399a;
        C0872pk c0872pkM4242a = this.f4642a.m4242a(C1062tN.f5782dk);
        C0872pk c0872pkM4242a2 = this.f4642a.m4242a(C1062tN.f5783dl);
        if (c0872pkM4242a == null || c0872pkM4242a2 == null) {
            return;
        }
        Set<UUID> setM4492a = C0875pn.m4492a(this.f4643b, this.f4642a.m4245h());
        if (setM4492a.size() < 2) {
            return;
        }
        boolean z = false;
        int i = 0;
        for (UUID uuid : setM4492a) {
            boolean z2 = i % 4 == 0 || i % 4 == 3;
            i++;
            C0872pk c0872pk = z2 ? c0872pkM4242a : c0872pkM4242a2;
            if (this.f4642a.m4229a(uuid) != c0872pk && (serverPlayerM4399a = C0875pn.m4399a(uuid)) != null && m4076a(abstractC0531jN, serverLevel, serverPlayerM4399a, uuid, c0872pk)) {
                z = true;
            }
        }
        if (!z) {
            return;
        }
        if (this instanceof InterfaceC0943rB) {
            int iMo5180bM = ((InterfaceC0943rB) this).mo5180bM();
            Iterator<UUID> it = setM4492a.iterator();
            while (it.hasNext()) {
                C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this, it.next(), C1062tN.f5761y, iMo5180bM);
            }
        }
        Iterator<UUID> it2 = setM4492a.iterator();
        while (it2.hasNext()) {
            C0875pn.m4440a(it2.next(), f4613iJ, 80, "rebalance");
        }
    }

    /* JADX INFO: renamed from: a */
    protected Component m4079a(@NotNull Player player, int i, int i2) {
        C0872pk c0872pkM4229a = this.f4642a.m4229a(player.getUUID());
        Component component = null;
        if (c0872pkM4229a == null) {
            component = f4610iG;
        }
        if (c0872pkM4229a != null && (!c0872pkM4229a.m4317bA() ? i > i2 : i2 > i)) {
            component = f4611iH;
        }
        if (m4023a() == EnumC0871pj.POST_GAME) {
            component = f4612iI;
        }
        return component;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1060tL m4080a() {
        return C1062tN.f5748l;
    }

    /* JADX INFO: renamed from: bq */
    public boolean m4081bq() {
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx mo4082a() {
        return this.f4636b;
    }

    /* JADX INFO: renamed from: h */
    public void mo4083h(@NotNull List<MutableComponent> list) {
        Set<a> setMo4085f = mo4085f();
        if (setMo4085f.contains(a.LOBBY) && this.f4642a.f4736e == null) {
            list.add(Component.literal("Lobby position for game '" + this.f4630bN + "' doesn't exist."));
        }
        if (setMo4085f.contains(a.TEAM_SPAWNS)) {
            for (C0872pk c0872pk : this.f4642a.m4244C()) {
                if (c0872pk.m4309D().isEmpty()) {
                    list.add(Component.literal("Team spawns for team '" + c0872pk.getName() + "' for game '" + this.f4630bN + "' don't exist."));
                }
            }
        }
        if (setMo4085f.contains(a.MAP_TYPE)) {
            if (this.f4635a == null) {
                list.add(Component.literal("Map type for game '" + this.f4630bN + "' is null."));
            } else if (this.f4635a.m2701at()) {
                list.add(Component.literal("Map type for game '" + this.f4630bN + "' doesn't exist. (Custom by default)"));
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0846pK m4084a() {
        return this.f4628a;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public Set<a> mo4085f() {
        return EnumSet.allOf(a.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public void m4086a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        if ((this instanceof InterfaceC0982ro) && ((InterfaceC0982ro) this).mo5354e(serverPlayer) && this.f4637q == null) {
            this.f4637q = uuid;
            this.f4642a.m4245h();
            C0875pn.m4379a(serverPlayer, new C1088tn(f4616iM, 80));
            C0875pn.m4417a((AbstractC0863pb<?, ?, ?>) this, (Component) Component.translatable("bf.message.gamemode.firstblood.announce", new Object[]{serverPlayer.getScoreboardName()}).withStyle(ChatFormatting.DARK_RED));
            C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this, uuid, C1062tN.f5748l);
            C0875pn.m4370a((AbstractC0863pb<?, ?, ?>) this, (SoundEvent) C1312xz.f8022qr.get(), SoundSource.MASTER);
            C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this, uuid, C1062tN.f5750n);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1058tJ<G, P> m4087a() {
        return this.f4644a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public MatchSettings m4088a() {
        return this.f4645a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1096tv m4089a() {
        return this.f4633a;
    }

    public void stop() {
        C0530jM.log("Stopping all systems for match '%s'", m4064e());
        m4038cz();
    }
}
