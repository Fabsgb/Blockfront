package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.io.IOException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sX.class */
public final class C1018sX extends AbstractC0863pb<C1018sX, C1020sZ, C1058tJ<C1018sX, C1020sZ>> implements InterfaceC0981rn, InterfaceC0984rq, InterfaceC0988ru, InterfaceC0993rz {

    /* JADX INFO: renamed from: c */
    public static final C0837pB f5587c = new C0837pB(null, null, new ItemStack((ItemLike) C1308xv.f7739as.get()), null, null, null, null, null);

    /* JADX INFO: renamed from: bG */
    public final List<C0881pt> f5588bG;

    /* JADX INFO: renamed from: bH */
    private final List<DeferredHolder<Item, ? extends C1117uP>> f5589bH;

    /* JADX INFO: renamed from: cQ */
    private final String f5590cQ = "Role";

    /* JADX INFO: renamed from: j */
    private final C0620kx f5591j;

    /* JADX INFO: renamed from: tc */
    public int f5592tc;

    /* JADX INFO: renamed from: ag */
    @NotNull
    public ObjectList<C1017sW> f5593ag;

    /* JADX INFO: renamed from: ah */
    @NotNull
    public ObjectList<AbstractC1078td> f5594ah;

    public C1018sX(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        super(abstractC0531jN, "ttt", "Trouble in Terrorist Town");
        this.f5588bG = new ObjectArrayList();
        this.f5589bH = ObjectArrayList.of(new DeferredHolder[]{C1308xv.f7826mP, C1308xv.f7825mO, C1308xv.f7827mQ, C1308xv.f7775lT, C1308xv.f7776lU, C1308xv.f7762lI, C1308xv.f7794mj, C1308xv.f7808mx, C1308xv.f7822mL, C1308xv.f7823mM, C1308xv.f7770lQ, C1308xv.f7760lG, C1308xv.f7805mu, C1308xv.f7806mv});
        this.f5590cQ = "Role";
        this.f5591j = new C0620kx().m2840a("wp", new C0620kx().m2840a("add", new C0620kx((commandContext, strArr) -> {
            Player player = ((CommandSourceStack) commandContext.getSource()).source;
            this.f5588bG.add(new C0881pt(player));
            C0721ms.m3329b(player, Component.literal("Weapon spawn added. (" + this.f5588bG.size() + ")"));
        }).m2836a(C0622kz.f3554a)).m2840a("clear", new C0620kx((commandContext2, strArr2) -> {
            C0721ms.m3329b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Clearing all " + this.f5588bG.size() + " weapon spawns."));
            this.f5588bG.clear();
        }))).m2840a("spawn", new C0620kx().m2840a("add", new C0620kx((commandContext3, strArr3) -> {
            m4018b().f5599bI.add(new C0881pt(((CommandSourceStack) commandContext3.getSource()).source));
            C0721ms.m3329b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal("Player spawn added. (" + m4018b().f5599bI.size() + ")"));
        }).m2836a(C0622kz.f3554a)).m2840a("clear", new C0620kx((commandContext4, strArr4) -> {
            m4018b().f5599bI.clear();
            C0721ms.m3329b(((CommandSourceStack) commandContext4.getSource()).source, Component.literal("Player spawns cleared."));
        })));
        this.f5592tc = 0;
        this.f5593ag = new ObjectArrayList();
        this.f5594ah = new ObjectArrayList();
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1019sY mo3995a(@NotNull C0623l c0623l) {
        return new C1019sY(c0623l, this, (C0396gl) this.f4643b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1020sZ mo3996a() {
        return new C1020sZ(this, this.f4643b);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1056tH<C1018sX, C1020sZ> mo3999a() {
        return new C1055tG(C1087tm::new);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: f */
    public Set<AbstractC0863pb.a> mo4085f() {
        return EnumSet.of(AbstractC0863pb.a.MAP_TYPE, AbstractC0863pb.a.LOBBY);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: h */
    public void mo4083h(@NotNull List<MutableComponent> list) {
        if (this.f5588bG.isEmpty()) {
            list.add(Component.literal("Weapon spawns in game '" + this.f4630bN + "' are missing."));
        }
        if (((C1020sZ) this.f4642a).f5599bI.isEmpty()) {
            list.add(Component.literal("Player spawns in game '" + this.f4630bN + "' are missing."));
        }
        super.mo4083h(list);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4006a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f4644a.m5875b(abstractC0531jN, abstractC0184c, serverLevel);
        ObjectListIterator it = this.f5594ah.iterator();
        while (it.hasNext()) {
            ((AbstractC1078td) it.next()).mo5947a(this, abstractC0184c, (Level) serverLevel, set);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bj */
    protected boolean mo4011bj() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m5711a(@NotNull Level level, @NotNull Set<UUID> set) {
        ObjectListIterator it = this.f5594ah.iterator();
        while (it.hasNext()) {
            ((AbstractC1078td) it.next()).mo5949a(this, level, set);
        }
        this.f5594ah.clear();
    }

    /* JADX INFO: renamed from: a */
    public void m5712a(@NotNull ServerPlayer serverPlayer, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        AbstractC1078td abstractC1078tdM5955a = C1079te.m5955a();
        abstractC1078tdM5955a.mo5948a(this, (Player) serverPlayer, (Level) serverLevel, set);
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.gamemode.ttt.randomat.activate", new Object[]{Component.literal(serverPlayer.getScoreboardName()).withStyle(ChatFormatting.GOLD)});
        MutableComponent mutableComponentWithStyle = Component.translatable(abstractC1078tdM5955a.getName()).withStyle(ChatFormatting.GOLD);
        MutableComponent mutableComponentWithStyle2 = Component.translatable(abstractC1078tdM5955a.mo5950t()).withStyle(ChatFormatting.GRAY);
        C0875pn.m4370a(this, (SoundEvent) C1312xz.f8222uj.get(), SoundSource.MASTER);
        C0875pn.m4437a(this, (List<Component>) List.of(mutableComponentTranslatable, mutableComponentWithStyle, mutableComponentWithStyle2), 80, abstractC1078tdM5955a.m5954ar());
        this.f5594ah.add(abstractC1078tdM5955a);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public boolean mo4033a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull EnumC0876po enumC0876po, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        C0872pk c0872pkMo4241b = ((C1020sZ) this.f4642a).mo4241b();
        if (c0872pkMo4241b == null) {
            C0530jM.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((C1020sZ) this.f4642a).m4212a(abstractC0531jN, enumC0876po, serverLevel, serverPlayer, c0872pkMo4241b);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: d */
    public void mo4041d(@Nullable Level level) {
        this.f5592tc = 0;
        if (level != null) {
            m5711a(level, m4018b().m4245h());
        } else {
            this.f5594ah.clear();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4050a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.mo4050a(byteBuf, z);
        byteBuf.writeInt(this.f5593ag.size());
        ObjectListIterator it = this.f5593ag.iterator();
        while (it.hasNext()) {
            ((C1017sW) it.next()).mo3870c(byteBuf);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: g */
    public void mo4052g(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo4052g(byteBuf);
        this.f5593ag.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            C1017sW c1017sW = new C1017sW();
            c1017sW.mo3869b(byteBuf);
            this.f5593ag.add(c1017sW);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx mo4082a() {
        return this.f4636b.m2835a(this.f5591j);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: aM */
    public float mo4021aM() {
        return 2.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: f */
    public boolean mo4045f(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0878pq mo4046a() {
        return EnumC0878pq.ANYONE;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bl */
    public boolean mo4047bl() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bl */
    public int mo4053bl() {
        return 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bn */
    public boolean mo4057bn() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bp */
    public boolean mo4071bp() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0867pf mo4049a() {
        return EnumC0867pf.NONE;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @Nullable
    /* JADX INFO: renamed from: a */
    public CloudAchievement mo4072a() {
        return null;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: e */
    public boolean mo4044e(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0993rz
    /* JADX INFO: renamed from: b */
    public int mo5568b(@NotNull ServerPlayer serverPlayer) {
        return 8;
    }

    @Override // com.boehmod.blockfront.InterfaceC0993rz
    /* JADX INFO: renamed from: bK */
    public int mo5569bK() {
        return 160;
    }

    /* JADX INFO: renamed from: c */
    public void m5713c(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        UUID uuid;
        ServerPlayer serverPlayerM4399a;
        ObjectArrayList objectArrayList = new ObjectArrayList(set);
        Collections.shuffle(objectArrayList);
        int i = 1;
        int i2 = 1;
        boolean z = false;
        if (set.size() >= 14) {
            i = 4;
            i2 = 2;
        }
        if (set.size() >= 12) {
            i = 3;
            i2 = 1;
        } else if (set.size() >= 8) {
            i = 2;
        }
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.ttt.roles.all", new Object[]{Component.literal(String.valueOf(i)).withColor(ColorReferences.COLOR_THEME_TTT_TRAITOR), Component.literal(String.valueOf(i2)).withColor(ColorReferences.COLOR_THEME_TTT_DETECTIVE)}).withStyle(ChatFormatting.GRAY);
        ObjectListIterator it = objectArrayList.iterator();
        while (it.hasNext() && (serverPlayerM4399a = C0875pn.m4399a((uuid = (UUID) it.next()))) != null) {
            if (!C0875pn.m4488a((Player) serverPlayerM4399a, (AbstractC0183b<?, ?, ?, ?>) this.f4643b.m1153a((Player) serverPlayerM4399a))) {
                DeferredHolder<SoundEvent, SoundEvent> deferredHolder = C1312xz.f8006qb;
                EnumC1082th enumC1082th = EnumC1082th.INNOCENT;
                C0837pB c0837pB = null;
                int i3 = 0;
                if (i > 0) {
                    i--;
                    enumC1082th = EnumC1082th.TRAITOR;
                    deferredHolder = C1312xz.f8007qc;
                    i3 = 1;
                } else if (i2 > 0) {
                    i2--;
                    enumC1082th = EnumC1082th.DETECTIVE;
                    deferredHolder = C1312xz.f8005qa;
                    c0837pB = C1020sZ.f5598d;
                    i3 = 2;
                } else if (!z) {
                    z = true;
                    enumC1082th = EnumC1082th.JESTER;
                    deferredHolder = C1312xz.f8942Ib;
                }
                m5714a(uuid, enumC1082th);
                C0875pn.m4408a(uuid, (Component) Component.empty(), (Component) Component.empty());
                C0875pn.m4407b(uuid, enumC1082th.getTitle());
                C0875pn.m4408a(uuid, (Component) Component.empty(), (Component) Component.empty());
                C0875pn.m4408a(uuid, (Component) Component.empty(), enumC1082th.getDescription());
                C0875pn.m4408a(uuid, (Component) Component.empty(), (Component) Component.empty());
                C0875pn.m4408a(uuid, (Component) Component.empty(), (Component) mutableComponentWithStyle);
                C0875pn.m4408a(uuid, (Component) Component.empty(), (Component) Component.empty());
                C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this, uuid, C1062tN.f5755s, i3);
                C0875pn.m4458a(serverLevel, serverPlayerM4399a, f5587c, true);
                if (c0837pB != null) {
                    C0875pn.m4458a(serverLevel, serverPlayerM4399a, c0837pB, true);
                }
                C0875pn.m4363a(uuid, (SoundEvent) deferredHolder.get(), SoundSource.MUSIC);
                C0875pn.m4363a(uuid, (SoundEvent) C1312xz.f8008qd.get(), SoundSource.MUSIC);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5714a(@NotNull UUID uuid, @NotNull EnumC1082th enumC1082th) {
        C0870pi c0870piA = m5718a(uuid);
        Objects.requireNonNull(this);
        c0870piA.m4293a("Role", enumC1082th.getKey());
    }

    @CheckForNull
    /* JADX INFO: renamed from: a */
    public EnumC1083ti m5715a() {
        Set<UUID> setK = m4018b().m4250k();
        if (setK.isEmpty()) {
            return EnumC1083ti.BAD;
        }
        EnumC1083ti team = null;
        Iterator<UUID> it = setK.iterator();
        while (it.hasNext()) {
            EnumC1082th enumC1082thM5718a = m5718a(it.next());
            if (enumC1082thM5718a != null && enumC1082thM5718a != EnumC1082th.JESTER) {
                if (team == null) {
                    team = enumC1082thM5718a.getTeam();
                } else if (enumC1082thM5718a.getTeam() != team) {
                    return null;
                }
            }
        }
        return team;
    }

    /* JADX INFO: renamed from: i */
    public void m5716i(@NotNull ServerPlayer serverPlayer) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectListIterator it = this.f5593ag.iterator();
        while (it.hasNext()) {
            C1017sW c1017sW = (C1017sW) it.next();
            if (!c1017sW.m5709ca() && Mth.sqrt((float) serverPlayer.distanceToSqr(c1017sW.f4827c)) <= 2.0d) {
                objectArrayList.add(c1017sW);
            }
        }
        if (objectArrayList.isEmpty()) {
            C0875pn.m4406c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.ttt.magnify.fail").withStyle(ChatFormatting.GRAY));
            return;
        }
        Iterator it2 = objectArrayList.iterator();
        while (it2.hasNext()) {
            ((C1017sW) it2.next()).m5710a(this, (Player) serverPlayer);
        }
    }

    /* JADX INFO: renamed from: a */
    public Set<UUID> m5717a(@NotNull EnumC1082th enumC1082th, @NotNull Set<UUID> set) {
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        for (UUID uuid : set) {
            if (m5718a(uuid).equals(enumC1082th)) {
                objectOpenHashSet.add(uuid);
            }
        }
        return objectOpenHashSet;
    }

    /* JADX INFO: renamed from: a */
    public EnumC1082th m5718a(@NotNull UUID uuid) {
        C0870pi c0870piA = m5718a(uuid);
        Objects.requireNonNull(this);
        if (c0870piA.m4288h("Role")) {
            Objects.requireNonNull(this);
            return EnumC1082th.fromKey(c0870piA.m4292l("Role"));
        }
        return EnumC1082th.PENDING;
    }

    /* JADX INFO: renamed from: m */
    public boolean m5719m(@NotNull UUID uuid) {
        return m5722a(uuid, EnumC1082th.INNOCENT.getKey());
    }

    /* JADX INFO: renamed from: n */
    public boolean m5720n(@NotNull UUID uuid) {
        return m5722a(uuid, EnumC1082th.TRAITOR.getKey());
    }

    /* JADX INFO: renamed from: o */
    public boolean m5721o(@NotNull UUID uuid) {
        return m5722a(uuid, EnumC1082th.DETECTIVE.getKey());
    }

    /* JADX INFO: renamed from: a */
    private boolean m5722a(@NotNull UUID uuid, @NotNull String str) {
        C0870pi c0870piA = m5718a(uuid);
        Objects.requireNonNull(this);
        if (c0870piA.m4288h("Role")) {
            Objects.requireNonNull(this);
            if (c0870piA.m4292l("Role").equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0981rn
    /* JADX INFO: renamed from: aY */
    public float mo5552aY() {
        return 0.5f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0988ru
    /* JADX INFO: renamed from: a */
    public boolean mo5566a(@NotNull Level level, @NotNull Player player, @NotNull AbstractC1153uz abstractC1153uz, @NotNull ItemStack itemStack) {
        return m5718a(player.getUUID()) == EnumC1082th.DETECTIVE && (abstractC1153uz == C1308xv.f7690v.get() || abstractC1153uz == C1308xv.f7692x.get());
    }

    @Override // com.boehmod.blockfront.InterfaceC0988ru
    /* JADX INFO: renamed from: a */
    public void mo5567a(@NotNull ServerLevel serverLevel, @NotNull Player player, @NotNull AbstractC1153uz abstractC1153uz, @NotNull ItemStack itemStack) {
        if (player instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) player;
            if (abstractC1153uz == C1308xv.f7690v.get()) {
                m5716i(serverPlayer);
            }
            if (abstractC1153uz == C1308xv.f7692x.get()) {
                itemStack.shrink(1);
                m5712a(serverPlayer, serverLevel, m4018b().m4245h());
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public void m5723j(@NotNull ServerLevel serverLevel) {
        for (C0881pt c0881pt : this.f5588bG) {
            serverLevel.addFreshEntity(new ItemEntity(serverLevel, c0881pt.f4827c.x, c0881pt.f4827c.y + 0.5d, c0881pt.f4827c.z, new ItemStack((C1117uP) ((DeferredHolder) C1267xG.m7152a(this.f5589bH)).get())));
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0984rq
    /* JADX INFO: renamed from: a */
    public List<C0886py> mo5554a(@NotNull UUID uuid) {
        return m5718a(uuid).getRoleItems();
    }

    @Override // com.boehmod.blockfront.InterfaceC0984rq
    /* JADX INFO: renamed from: c */
    public C1060tL mo5555c() {
        return C1062tN.f5755s;
    }

    @Override // com.boehmod.blockfront.InterfaceC0984rq
    /* JADX INFO: renamed from: e */
    public MutableComponent mo5556e() {
        return Component.translatable("bf.message.gamemode.tip.store", new Object[]{Component.literal("M").withStyle(ChatFormatting.GRAY)}).withColor(ColorReferences.COLOR_WHITE);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0950rI mo4042a() {
        return new InterfaceC0950rI.i(List.copyOf(((C1020sZ) this.f4642a).f5599bI), List.copyOf(this.f5588bG));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4043a(@NotNull InterfaceC0950rI interfaceC0950rI) throws MatchException {
        if (interfaceC0950rI instanceof InterfaceC0950rI.i) {
            InterfaceC0950rI.i iVar = (InterfaceC0950rI.i) interfaceC0950rI;
            try {
                List<C0881pt> listM5266Z = iVar.m5266Z();
                List<C0881pt> listM5267ag = iVar.m5267ag();
                ((C1020sZ) this.f4642a).f5599bI.clear();
                ((C1020sZ) this.f4642a).f5599bI.addAll(listM5266Z);
                this.f5588bG.clear();
                this.f5588bG.addAll(listM5267ag);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
