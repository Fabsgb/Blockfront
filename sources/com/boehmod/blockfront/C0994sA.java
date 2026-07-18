package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.InterfaceC0978rl;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sA.class */
public final class C0994sA extends AbstractC0787oF<C0994sA, C0996sC, C1086tm<C0994sA, C0996sC>> implements InterfaceC0904qQ, InterfaceC0907qT, InterfaceC0911qX, InterfaceC0969rc {

    /* JADX INFO: renamed from: c */
    public static final C0866pf f5258c = new C0866pf(null, null, new ItemStack((ItemLike) C1231wY.f7174as.get()), null, null, null, null, null);

    /* JADX INFO: renamed from: bz */
    public final List<C0805oX> f5259bz;

    /* JADX INFO: renamed from: bA */
    private final List<DeferredHolder<Item, ? extends C1144ur>> f5260bA;

    /* JADX INFO: renamed from: cG */
    private final String f5261cG = "Role";

    /* JADX INFO: renamed from: j */
    private final C0597kb f5262j;

    /* JADX INFO: renamed from: rb */
    public int f5263rb;

    /* JADX INFO: renamed from: X */
    @NotNull
    public ObjectList<C1046sz> f5264X;

    /* JADX INFO: renamed from: Y */
    @NotNull
    public ObjectList<AbstractC1000sG> f5265Y;

    public C0994sA(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        super(abstractC0563ju, "ttt", "Trouble in Terrorist Town");
        this.f5259bz = new ObjectArrayList();
        this.f5260bA = ObjectArrayList.of(new DeferredHolder[]{C1231wY.f7261mP, C1231wY.f7260mO, C1231wY.f7262mQ, C1231wY.f7210lT, C1231wY.f7211lU, C1231wY.f7197lI, C1231wY.f7229mj, C1231wY.f7243mx, C1231wY.f7257mL, C1231wY.f7258mM, C1231wY.f7205lQ, C1231wY.f7195lG, C1231wY.f7240mu, C1231wY.f7241mv});
        this.f5261cG = "Role";
        this.f5262j = new C0597kb().m2628a("wp", new C0597kb().m2628a("add", new C0597kb((commandContext, strArr) -> {
            Player player = ((CommandSourceStack) commandContext.getSource()).source;
            this.f5259bz.add(new C0805oX(player));
            C0645lW.m2898b(player, Component.literal("Weapon spawn added. (" + this.f5259bz.size() + ")"));
        }).m2624a(C0599kd.f3307a)).m2628a("clear", new C0597kb((commandContext2, strArr2) -> {
            C0645lW.m2898b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Clearing all " + this.f5259bz.size() + " weapon spawns."));
            this.f5259bz.clear();
        }))).m2628a("spawn", new C0597kb().m2628a("add", new C0597kb((commandContext3, strArr3) -> {
            m3582b().f5270bB.add(new C0805oX(((CommandSourceStack) commandContext3.getSource()).source));
            C0645lW.m2898b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal("Player spawn added. (" + m3582b().f5270bB.size() + ")"));
        }).m2624a(C0599kd.f3307a)).m2628a("clear", new C0597kb((commandContext4, strArr4) -> {
            m3582b().f5270bB.clear();
            C0645lW.m2898b(((CommandSourceStack) commandContext4.getSource()).source, Component.literal("Player spawns cleared."));
        })));
        this.f5263rb = 0;
        this.f5264X = new ObjectArrayList();
        this.f5265Y = new ObjectArrayList();
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0995sB mo3559a(@NotNull C0622l c0622l) {
        return new C0995sB(c0622l, this, (C0326fV) this.f4249b);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0996sC mo3560a() {
        return new C0996sC(this, this.f4249b);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1084tk<C0994sA, C0996sC> mo3563a() {
        return new C1083tj(C1009sP::new);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: f */
    public Set<AbstractC0787oF.a> mo3649f() {
        return EnumSet.of(AbstractC0787oF.a.MAP_TYPE, AbstractC0787oF.a.LOBBY);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: g */
    public void mo3647g(@NotNull List<MutableComponent> list) {
        if (this.f5259bz.isEmpty()) {
            list.add(Component.literal("Weapon spawns in game '" + this.f4236bE + "' are missing."));
        }
        if (((C0996sC) this.f4248a).f5270bB.isEmpty()) {
            list.add(Component.literal("Player spawns in game '" + this.f4236bE + "' are missing."));
        }
        super.mo3647g(list);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3570a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f4250a.m5995b(abstractC0563ju, abstractC0183c, serverLevel);
        ObjectListIterator it = this.f5265Y.iterator();
        while (it.hasNext()) {
            ((AbstractC1000sG) it.next()).mo5459a(this, abstractC0183c, (Level) serverLevel, set);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: aZ */
    protected boolean mo3575aZ() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m5433a(@NotNull Level level, @NotNull Set<UUID> set) {
        ObjectListIterator it = this.f5265Y.iterator();
        while (it.hasNext()) {
            ((AbstractC1000sG) it.next()).mo5461a(this, level, set);
        }
        this.f5265Y.clear();
    }

    /* JADX INFO: renamed from: a */
    public void m5434a(@NotNull ServerPlayer serverPlayer, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        AbstractC1000sG abstractC1000sGM5467a = C1001sH.m5467a();
        abstractC1000sGM5467a.mo5460a(this, (Player) serverPlayer, (Level) serverLevel, set);
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.gamemode.ttt.randomat.activate", new Object[]{Component.literal(serverPlayer.getScoreboardName()).withStyle(ChatFormatting.GOLD)});
        MutableComponent mutableComponentWithStyle = Component.translatable(abstractC1000sGM5467a.getName()).withStyle(ChatFormatting.GOLD);
        MutableComponent mutableComponentWithStyle2 = Component.translatable(abstractC1000sGM5467a.mo5462p()).withStyle(ChatFormatting.GRAY);
        C0799oR.m3934a(this, (SoundEvent) C1280xc.f7811ui.get(), SoundSource.MASTER);
        C0799oR.m4001a(this, (List<Component>) List.of(mutableComponentTranslatable, mutableComponentWithStyle, mutableComponentWithStyle2), 80, abstractC1000sGM5467a.m5466ak());
        this.f5265Y.add(abstractC1000sGM5467a);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public boolean mo3597a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        C0796oO c0796oOMo3805b = ((C0996sC) this.f4248a).mo3805b();
        if (c0796oOMo3805b == null) {
            C0562jt.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((C0996sC) this.f4248a).m3776a(abstractC0563ju, enumC0800oS, serverLevel, serverPlayer, c0796oOMo3805b);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: d */
    public void mo3605d(@Nullable Level level) {
        this.f5263rb = 0;
        if (level != null) {
            m5433a(level, m3582b().m3809h());
        } else {
            this.f5265Y.clear();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3614a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.mo3614a(byteBuf, z);
        byteBuf.writeInt(this.f5264X.size());
        ObjectListIterator it = this.f5264X.iterator();
        while (it.hasNext()) {
            ((C1046sz) it.next()).mo4111c(byteBuf);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: g */
    public void mo3616g(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo3616g(byteBuf);
        this.f5264X.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            C1046sz c1046sz = new C1046sz();
            c1046sz.mo4110b(byteBuf);
            this.f5264X.add(c1046sz);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb mo3646a() {
        return this.f4242b.m2623a(this.f5262j);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: aG */
    public float mo3585aG() {
        return 2.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: f */
    public boolean mo3609f(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0802oU mo3610a() {
        return EnumC0802oU.ANYONE;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: bb */
    public boolean mo3611bb() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: aW */
    public int mo3617aW() {
        return 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: bd */
    public boolean mo3621bd() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: bf */
    public boolean mo3635bf() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0791oJ mo3613a() {
        return EnumC0791oJ.NONE;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @Nullable
    /* JADX INFO: renamed from: a */
    public CloudAchievement mo3636a() {
        return null;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: e */
    public boolean mo3608e(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0969rc
    /* JADX INFO: renamed from: b */
    public int mo5208b(@NotNull ServerPlayer serverPlayer) {
        return 8;
    }

    @Override // com.boehmod.blockfront.InterfaceC0969rc
    /* JADX INFO: renamed from: bv */
    public int mo5209bv() {
        return 160;
    }

    /* JADX INFO: renamed from: c */
    public void m5435c(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        UUID uuid;
        ServerPlayer serverPlayerM3963a;
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
        while (it.hasNext() && (serverPlayerM3963a = C0799oR.m3963a((uuid = (UUID) it.next()))) != null) {
            if (!C0799oR.m4052a((Player) serverPlayerM3963a, (AbstractC0182b<?, ?, ?, ?>) this.f4249b.m1136a((Player) serverPlayerM3963a))) {
                DeferredHolder<SoundEvent, SoundEvent> deferredHolder = C1280xc.f7594pZ;
                EnumC1004sK enumC1004sK = EnumC1004sK.INNOCENT;
                C0866pf c0866pf = null;
                int i3 = 0;
                if (i > 0) {
                    i--;
                    enumC1004sK = EnumC1004sK.TRAITOR;
                    deferredHolder = C1280xc.f7595qa;
                    i3 = 1;
                } else if (i2 > 0) {
                    i2--;
                    enumC1004sK = EnumC1004sK.DETECTIVE;
                    deferredHolder = C1280xc.f7593pY;
                    c0866pf = C0996sC.f5269d;
                    i3 = 2;
                } else if (!z) {
                    z = true;
                    enumC1004sK = EnumC1004sK.JESTER;
                    deferredHolder = C1280xc.f8528HX;
                }
                m5436a(uuid, enumC1004sK);
                C0799oR.m3972a(uuid, (Component) Component.empty(), (Component) Component.empty());
                C0799oR.m3971b(uuid, enumC1004sK.getTitle());
                C0799oR.m3972a(uuid, (Component) Component.empty(), (Component) Component.empty());
                C0799oR.m3972a(uuid, (Component) Component.empty(), enumC1004sK.getDescription());
                C0799oR.m3972a(uuid, (Component) Component.empty(), (Component) Component.empty());
                C0799oR.m3972a(uuid, (Component) Component.empty(), (Component) mutableComponentWithStyle);
                C0799oR.m3972a(uuid, (Component) Component.empty(), (Component) Component.empty());
                C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this, uuid, C1089tp.f5702s, i3);
                C0799oR.m4022a(serverLevel, serverPlayerM3963a, f5258c, true);
                if (c0866pf != null) {
                    C0799oR.m4022a(serverLevel, serverPlayerM3963a, c0866pf, true);
                }
                C0799oR.m3927a(uuid, (SoundEvent) deferredHolder.get(), SoundSource.MUSIC);
                C0799oR.m3927a(uuid, (SoundEvent) C1280xc.f7596qb.get(), SoundSource.MUSIC);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5436a(@NotNull UUID uuid, @NotNull EnumC1004sK enumC1004sK) {
        C0794oM c0794oMA = m5440a(uuid);
        Objects.requireNonNull(this);
        c0794oMA.m3857a("Role", enumC1004sK.getKey());
    }

    @CheckForNull
    /* JADX INFO: renamed from: a */
    public EnumC1005sL m5437a() {
        Set<UUID> setK = m3582b().m3814k();
        if (setK.isEmpty()) {
            return EnumC1005sL.BAD;
        }
        EnumC1005sL team = null;
        Iterator<UUID> it = setK.iterator();
        while (it.hasNext()) {
            EnumC1004sK enumC1004sKM5440a = m5440a(it.next());
            if (enumC1004sKM5440a != null && enumC1004sKM5440a != EnumC1004sK.JESTER) {
                if (team == null) {
                    team = enumC1004sKM5440a.getTeam();
                } else if (enumC1004sKM5440a.getTeam() != team) {
                    return null;
                }
            }
        }
        return team;
    }

    /* JADX INFO: renamed from: i */
    public void m5438i(@NotNull ServerPlayer serverPlayer) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectListIterator it = this.f5264X.iterator();
        while (it.hasNext()) {
            C1046sz c1046sz = (C1046sz) it.next();
            if (!c1046sz.m5820bQ() && Mth.sqrt((float) serverPlayer.distanceToSqr(c1046sz.f4424c)) <= 2.0d) {
                objectArrayList.add(c1046sz);
            }
        }
        if (objectArrayList.isEmpty()) {
            C0799oR.m3970c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.ttt.magnify.fail").withStyle(ChatFormatting.GRAY));
            return;
        }
        Iterator it2 = objectArrayList.iterator();
        while (it2.hasNext()) {
            ((C1046sz) it2.next()).m5821a(this, (Player) serverPlayer);
        }
    }

    /* JADX INFO: renamed from: a */
    public Set<UUID> m5439a(@NotNull EnumC1004sK enumC1004sK, @NotNull Set<UUID> set) {
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        for (UUID uuid : set) {
            if (m5440a(uuid).equals(enumC1004sK)) {
                objectOpenHashSet.add(uuid);
            }
        }
        return objectOpenHashSet;
    }

    /* JADX INFO: renamed from: a */
    public EnumC1004sK m5440a(@NotNull UUID uuid) {
        C0794oM c0794oMA = m5440a(uuid);
        Objects.requireNonNull(this);
        if (c0794oMA.m3852f("Role")) {
            Objects.requireNonNull(this);
            return EnumC1004sK.fromKey(c0794oMA.m3856l("Role"));
        }
        return EnumC1004sK.PENDING;
    }

    /* JADX INFO: renamed from: m */
    public boolean m5441m(@NotNull UUID uuid) {
        return m5444a(uuid, EnumC1004sK.INNOCENT.getKey());
    }

    /* JADX INFO: renamed from: n */
    public boolean m5442n(@NotNull UUID uuid) {
        return m5444a(uuid, EnumC1004sK.TRAITOR.getKey());
    }

    /* JADX INFO: renamed from: o */
    public boolean m5443o(@NotNull UUID uuid) {
        return m5444a(uuid, EnumC1004sK.DETECTIVE.getKey());
    }

    /* JADX INFO: renamed from: a */
    private boolean m5444a(@NotNull UUID uuid, @NotNull String str) {
        C0794oM c0794oMA = m5440a(uuid);
        Objects.requireNonNull(this);
        if (c0794oMA.m3852f("Role")) {
            Objects.requireNonNull(this);
            if (c0794oMA.m3856l("Role").equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0904qQ
    /* JADX INFO: renamed from: aS */
    public float mo4677aS() {
        return 0.5f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0911qX
    /* JADX INFO: renamed from: a */
    public boolean mo4695a(@NotNull Level level, @NotNull Player player, @NotNull AbstractC1128ub abstractC1128ub, @NotNull ItemStack itemStack) {
        return m5440a(player.getUUID()) == EnumC1004sK.DETECTIVE && (abstractC1128ub == C1231wY.f7125v.get() || abstractC1128ub == C1231wY.f7127x.get());
    }

    @Override // com.boehmod.blockfront.InterfaceC0911qX
    /* JADX INFO: renamed from: a */
    public void mo4696a(@NotNull ServerLevel serverLevel, @NotNull Player player, @NotNull AbstractC1128ub abstractC1128ub, @NotNull ItemStack itemStack) {
        if (player instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) player;
            if (abstractC1128ub == C1231wY.f7125v.get()) {
                m5438i(serverPlayer);
            }
            if (abstractC1128ub == C1231wY.f7127x.get()) {
                itemStack.shrink(1);
                m5434a(serverPlayer, serverLevel, m3582b().m3809h());
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public void m5445j(@NotNull ServerLevel serverLevel) {
        for (C0805oX c0805oX : this.f5259bz) {
            serverLevel.addFreshEntity(new ItemEntity(serverLevel, c0805oX.f4424c.x, c0805oX.f4424c.y + 0.5d, c0805oX.f4424c.z, new ItemStack((C1144ur) ((DeferredHolder) C1287xj.m7828a(this.f5260bA)).get())));
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0907qT
    /* JADX INFO: renamed from: a */
    public List<C0863pc> mo4680a(@NotNull UUID uuid) {
        return m5440a(uuid).getRoleItems();
    }

    @Override // com.boehmod.blockfront.InterfaceC0907qT
    /* JADX INFO: renamed from: c */
    public C1088to mo4681c() {
        return C1089tp.f5702s;
    }

    @Override // com.boehmod.blockfront.InterfaceC0907qT
    /* JADX INFO: renamed from: e */
    public MutableComponent mo4682e() {
        return Component.translatable("bf.message.gamemode.tip.store", new Object[]{Component.literal("M").withStyle(ChatFormatting.GRAY)}).withColor(ColorReferences.COLOR_WHITE);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0978rl mo3606a() {
        return new InterfaceC0978rl.i(List.copyOf(((C0996sC) this.f4248a).f5270bB), List.copyOf(this.f5259bz));
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3607a(@NotNull InterfaceC0978rl interfaceC0978rl) throws MatchException {
        if (interfaceC0978rl instanceof InterfaceC0978rl.i) {
            InterfaceC0978rl.i iVar = (InterfaceC0978rl.i) interfaceC0978rl;
            try {
                List<C0805oX> listM5390X = iVar.m5390X();
                List<C0805oX> listM5391ae = iVar.m5391ae();
                ((C0996sC) this.f4248a).f5270bB.clear();
                ((C0996sC) this.f4248a).f5270bB.addAll(listM5390X);
                this.f5259bz.clear();
                this.f5259bz.addAll(listM5391ae);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
