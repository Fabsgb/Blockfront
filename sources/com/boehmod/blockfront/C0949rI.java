package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000mm.report.FreeForAllMatchReportData;
import com.boehmod.bflib.cloud.common.p000mm.report.IMatchReportData;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.InterfaceC0978rl;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.rI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rI.class */
public final class C0949rI extends AbstractC0787oF<C0949rI, C0951rK, C1086tm<C0949rI, C0951rK>> implements InterfaceC0902qO, InterfaceC0905qR, InterfaceC0909qV, InterfaceC0913qZ, InterfaceC0967ra, InterfaceC0969rc, InterfaceC0970rd {

    /* JADX INFO: renamed from: pN */
    public static final int f5040pN = 30;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final C0597kb f5041e;

    /* JADX INFO: renamed from: c */
    @Nullable
    private C0709mh f5042c;

    public C0949rI(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        super(abstractC0563ju, "ffa", "Free For All");
        this.f5041e = new C0597kb().m2628a("spawn", new C0597kb().m2628a("add", new C0597kb((commandContext, strArr) -> {
            m3582b().m5217d(new C0805oX(((CommandSourceStack) commandContext.getSource()).source));
            C0645lW.m2898b(((CommandSourceStack) commandContext.getSource()).source, Component.literal("Player spawn added. (" + m3582b().m5216aq().size() + ")"));
        }).m2624a(C0599kd.f3307a)).m2628a("clear", new C0597kb((commandContext2, strArr2) -> {
            m3582b().m5218cJ();
            C0645lW.m2898b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Player spawns cleared."));
        })));
        this.f5042c = null;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public C0709mh m5206d() {
        return this.f5042c;
    }

    /* JADX INFO: renamed from: b */
    public void m5207b(@Nullable C0709mh c0709mh) {
        this.f5042c = c0709mh;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0950rJ mo3559a(@NotNull C0622l c0622l) {
        return new C0950rJ(c0622l, this, (C0326fV) this.f4249b);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0951rK mo3560a() {
        return new C0951rK(this, this.f4249b);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1084tk<C0949rI, C0951rK> mo3563a() {
        return new C1083tj(C0954rN::new);
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
        if (((C0951rK) this.f4248a).m5216aq().isEmpty()) {
            list.add(Component.literal("Player spawns in game '" + this.f4236bE + "' are missing."));
        }
        super.mo3647g(list);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3570a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f4250a.m5995b(abstractC0563ju, abstractC0183c, serverLevel);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: aZ */
    protected boolean mo3575aZ() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @Nullable
    /* JADX INFO: renamed from: a */
    protected IMatchReportData mo3577a(@NotNull C0864pd c0864pd) {
        return new FreeForAllMatchReportData(30);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public boolean mo3597a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        C0796oO c0796oOMo3805b = ((C0951rK) this.f4248a).mo3805b();
        if (c0796oOMo3805b == null) {
            C0562jt.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((C0951rK) this.f4248a).m3776a(abstractC0563ju, enumC0800oS, serverLevel, serverPlayer, c0796oOMo3805b);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: d */
    public void mo3605d(@Nullable Level level) {
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb mo3646a() {
        return super.mo3646a().m2623a(this.f5041e);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: f */
    public boolean mo3609f(@NotNull Player player) {
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
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public CloudAchievement mo3636a() {
        return CloudAchievements.ACH_MATCH_WIN_FFA;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: e */
    public boolean mo3608e(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0909qV
    /* JADX INFO: renamed from: i */
    public boolean mo4686i(@NotNull Player player) {
        return player.getHealth() < player.getMaxHealth();
    }

    @Override // com.boehmod.blockfront.InterfaceC0909qV
    /* JADX INFO: renamed from: a */
    public float mo4687a(@NotNull Player player) {
        return 1.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0909qV
    /* JADX INFO: renamed from: a */
    public int mo4688a(@NotNull Player player) {
        return 40;
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

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: e */
    public Set<C1015sV> mo3561e() {
        return Set.of(C1015sV.m5512a("anti_tank"), C1015sV.m5512a("commander"));
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: aS */
    public int mo3562aS() {
        return 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0902qO
    /* JADX INFO: renamed from: by */
    public boolean mo4669by() {
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0902qO
    /* JADX INFO: renamed from: bz */
    public boolean mo4670bz() {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0902qO
    /* JADX INFO: renamed from: bA */
    public boolean mo4671bA() {
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0902qO
    /* JADX INFO: renamed from: bB */
    public boolean mo4672bB() {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0902qO
    /* JADX INFO: renamed from: a */
    public int mo4673a(@NotNull C1015sV c1015sV) {
        switch (c1015sV.getKey()) {
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

    @Override // com.boehmod.blockfront.InterfaceC0970rd
    /* JADX INFO: renamed from: bw */
    public int mo5164bw() {
        return 150;
    }

    @Override // com.boehmod.blockfront.InterfaceC0970rd
    /* JADX INFO: renamed from: j */
    public boolean mo5165j(@NotNull UUID uuid) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0970rd
    /* JADX INFO: renamed from: k */
    public boolean mo5166k(@NotNull UUID uuid) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0913qZ
    /* JADX INFO: renamed from: bC */
    public boolean mo4698bC() {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0905qR
    /* JADX INFO: renamed from: d */
    public boolean mo4678d(@NotNull ServerPlayer serverPlayer) {
        return this.f4235a == EnumC0795oN.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0978rl mo3606a() {
        return new InterfaceC0978rl.c(List.copyOf(((C0951rK) this.f4248a).m5216aq()), Optional.ofNullable(m5206d()));
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3607a(@NotNull InterfaceC0978rl interfaceC0978rl) throws MatchException {
        if (interfaceC0978rl instanceof InterfaceC0978rl.c) {
            InterfaceC0978rl.c cVar = (InterfaceC0978rl.c) interfaceC0978rl;
            try {
                List<C0805oX> listM5362X = cVar.m5362X();
                Optional<C0709mh> optionalM5363h = cVar.m5363h();
                ((C0951rK) this.f4248a).m5218cJ();
                Iterator<C0805oX> it = listM5362X.iterator();
                while (it.hasNext()) {
                    ((C0951rK) this.f4248a).m5217d(it.next());
                }
                this.f5042c = optionalM5363h.orElse(null);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
