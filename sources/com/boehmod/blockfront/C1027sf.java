package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p001mm.report.FreeForAllMatchReportData;
import com.boehmod.bflib.cloud.common.p001mm.report.IMatchReportData;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sf.class */
public final class C1027sf extends AbstractC0863pb<C1027sf, C1029sh, C1058tJ<C1027sf, C1029sh>> implements InterfaceC0942rA, InterfaceC0979rl, InterfaceC0982ro, InterfaceC0986rs, InterfaceC0990rw, InterfaceC0991rx, InterfaceC0993rz {

    /* JADX INFO: renamed from: rO */
    public static final int f5617rO = 30;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final C0620kx f5618e;

    /* JADX INFO: renamed from: c */
    @Nullable
    private C0680mD f5619c;

    public C1027sf(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        super(abstractC0531jN, "ffa", "Free For All");
        this.f5618e = new C0620kx().m2840a("spawn", new C0620kx().m2840a("add", new C0620kx((commandContext, strArr) -> {
            m4018b().m5755d(new C0881pt(((CommandSourceStack) commandContext.getSource()).source));
            C0721ms.m3329b(((CommandSourceStack) commandContext.getSource()).source, Component.literal("Player spawn added. (" + m4018b().m5754as().size() + ")"));
        }).m2836a(C0622kz.f3554a)).m2840a("clear", new C0620kx((commandContext2, strArr2) -> {
            m4018b().m5756cV();
            C0721ms.m3329b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Player spawns cleared."));
        })));
        this.f5619c = null;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public C0680mD m5746d() {
        return this.f5619c;
    }

    /* JADX INFO: renamed from: b */
    public void m5747b(@Nullable C0680mD c0680mD) {
        this.f5619c = c0680mD;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1028sg mo3995a(@NotNull C0623l c0623l) {
        return new C1028sg(c0623l, this, (C0396gl) this.f4643b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1029sh mo3996a() {
        return new C1029sh(this, this.f4643b);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1056tH<C1027sf, C1029sh> mo3999a() {
        return new C1055tG(C1032sk::new);
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
        if (((C1029sh) this.f4642a).m5754as().isEmpty()) {
            list.add(Component.literal("Player spawns in game '" + this.f4630bN + "' are missing."));
        }
        super.mo4083h(list);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4006a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f4644a.m5875b(abstractC0531jN, abstractC0184c, serverLevel);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bj */
    protected boolean mo4011bj() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @Nullable
    /* JADX INFO: renamed from: a */
    protected IMatchReportData mo4013a(@NotNull C0887pz c0887pz) {
        return new FreeForAllMatchReportData(30);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public boolean mo4033a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull EnumC0876po enumC0876po, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        C0872pk c0872pkMo4241b = ((C1029sh) this.f4642a).mo4241b();
        if (c0872pkMo4241b == null) {
            C0530jM.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((C1029sh) this.f4642a).m4212a(abstractC0531jN, enumC0876po, serverLevel, serverPlayer, c0872pkMo4241b);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: d */
    public void mo4041d(@Nullable Level level) {
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx mo4082a() {
        return super.mo4082a().m2835a(this.f5618e);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: f */
    public boolean mo4045f(@NotNull Player player) {
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
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public CloudAchievement mo4072a() {
        return CloudAchievements.ACH_MATCH_WIN_FFA;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: e */
    public boolean mo4044e(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0986rs
    /* JADX INFO: renamed from: i */
    public boolean mo5301i(@NotNull Player player) {
        return player.getHealth() < player.getMaxHealth();
    }

    @Override // com.boehmod.blockfront.InterfaceC0986rs
    /* JADX INFO: renamed from: a */
    public float mo5302a(@NotNull Player player) {
        return 1.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0986rs
    /* JADX INFO: renamed from: a */
    public int mo5303a(@NotNull Player player) {
        return 40;
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

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: e */
    public Set<C1093ts> mo3997e() {
        return Set.of(C1093ts.m6000a("anti_tank"), C1093ts.m6000a("commander"));
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bh */
    public int mo3998bh() {
        return 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0979rl
    /* JADX INFO: renamed from: bI */
    public boolean mo5343bI() {
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0979rl
    /* JADX INFO: renamed from: bJ */
    public boolean mo5344bJ() {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0979rl
    /* JADX INFO: renamed from: bK */
    public boolean mo5345bK() {
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0979rl
    /* JADX INFO: renamed from: bL */
    public boolean mo5346bL() {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0979rl
    /* JADX INFO: renamed from: a */
    public int mo5347a(@NotNull C1093ts c1093ts) {
        switch (c1093ts.getKey()) {
            case "assault":
                return 3;
            case "support":
            case "medic":
            case "sniper":
                return 2;
            case "gunner":
            case "specialist":
            case "anti_tank":
            case "commander":
                return 1;
            default:
                return 0;
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0942rA
    /* JADX INFO: renamed from: bL */
    public int mo5175bL() {
        return 150;
    }

    @Override // com.boehmod.blockfront.InterfaceC0942rA
    /* JADX INFO: renamed from: j */
    public boolean mo5176j(@NotNull UUID uuid) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0942rA
    /* JADX INFO: renamed from: k */
    public boolean mo5177k(@NotNull UUID uuid) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0990rw
    /* JADX INFO: renamed from: bM */
    public boolean mo5348bM() {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0982ro
    /* JADX INFO: renamed from: e */
    public boolean mo5354e(@NotNull ServerPlayer serverPlayer) {
        return this.f4629a == EnumC0871pj.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0950rI mo4042a() {
        return new InterfaceC0950rI.c(List.copyOf(((C1029sh) this.f4642a).m5754as()), Optional.ofNullable(m5746d()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4043a(@NotNull InterfaceC0950rI interfaceC0950rI) throws MatchException {
        if (interfaceC0950rI instanceof InterfaceC0950rI.c) {
            InterfaceC0950rI.c cVar = (InterfaceC0950rI.c) interfaceC0950rI;
            try {
                List<C0881pt> listM5238Z = cVar.m5238Z();
                Optional<C0680mD> optionalM5239h = cVar.m5239h();
                ((C1029sh) this.f4642a).m5756cV();
                Iterator<C0881pt> it = listM5238Z.iterator();
                while (it.hasNext()) {
                    ((C1029sh) this.f4642a).m5755d(it.next());
                }
                this.f5619c = optionalM5239h.orElse(null);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
