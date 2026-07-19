package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.mm.report.FreeForAllMatchReportData;
import com.boehmod.bflib.cloud.common.mm.report.IMatchReportData;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.blockfront.InterfaceC0471rl;
import com.boehmod.blockfront.oF;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rI.class */
public final class rI extends oF<rI, rK, C0526tm<rI, rK>> implements qO, qR, qV, qZ, InterfaceC0460ra, InterfaceC0462rc, InterfaceC0463rd {
    public static final int pN = 30;

    @NotNull
    private final C0272kb e;

    @Nullable
    private C0332mh c;

    public rI(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        super(abstractC0264ju, "ffa", "Free For All");
        this.e = new C0272kb().a("spawn", new C0272kb().a("add", new C0272kb((commandContext, strArr) -> {
            b().d(new oX(((CommandSourceStack) commandContext.getSource()).source));
            lW.b(((CommandSourceStack) commandContext.getSource()).source, Component.literal("Player spawn added. (" + b().aq().size() + ")"));
        }).a(C0274kd.a)).a("clear", new C0272kb((commandContext2, strArr2) -> {
            b().cJ();
            lW.b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Player spawns cleared."));
        })));
        this.c = null;
    }

    @Nullable
    public C0332mh d() {
        return this.c;
    }

    public void b(@Nullable C0332mh c0332mh) {
        this.c = c0332mh;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    public rJ a(@NotNull C0297l c0297l) {
        return new rJ(c0297l, this, (fV) this.f269b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.oF
    @NotNull
    public rK a() {
        return new rK(this, this.f269b);
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0524tk<rI, rK> mo749a() {
        return new C0523tj(rN::new);
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: f */
    public Set<oF.a> mo1046f() {
        return EnumSet.of(oF.a.MAP_TYPE, oF.a.LOBBY);
    }

    @Override // com.boehmod.blockfront.oF
    public void g(@NotNull List<MutableComponent> list) {
        if (((rK) this.f268a).aq().isEmpty()) {
            list.add(Component.literal("Player spawns in game '" + this.bE + "' are missing."));
        }
        super.g(list);
    }

    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f270a.b(abstractC0264ju, cVar, serverLevel);
    }

    @Override // com.boehmod.blockfront.oF
    protected boolean aZ() {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    @Nullable
    protected IMatchReportData a(@NotNull C0409pd c0409pd) {
        return new FreeForAllMatchReportData(30);
    }

    @Override // com.boehmod.blockfront.oF
    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oS oSVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        oO oOVarB = ((rK) this.f268a).b();
        if (oOVarB == null) {
            C0263jt.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((rK) this.f268a).a(abstractC0264ju, oSVar, serverLevel, serverPlayer, oOVarB);
    }

    @Override // com.boehmod.blockfront.oF
    public void d(@Nullable Level level) {
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0272kb mo763a() {
        return super.mo763a().a(this.e);
    }

    @Override // com.boehmod.blockfront.oF
    public boolean f(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    public int aW() {
        return 2;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean bd() {
        return false;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean bf() {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public CloudAchievement mo760a() {
        return CloudAchievements.ACH_MATCH_WIN_FFA;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean e(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.qV
    public boolean i(@NotNull Player player) {
        return player.getHealth() < player.getMaxHealth();
    }

    @Override // com.boehmod.blockfront.qV
    public float a(@NotNull Player player) {
        return 1.0f;
    }

    @Override // com.boehmod.blockfront.qV
    /* JADX INFO: renamed from: a */
    public int mo922a(@NotNull Player player) {
        return 40;
    }

    @Override // com.boehmod.blockfront.InterfaceC0462rc
    public int b(@NotNull ServerPlayer serverPlayer) {
        return 8;
    }

    @Override // com.boehmod.blockfront.InterfaceC0462rc
    public int bv() {
        return 160;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    public Set<sV> e() {
        return Set.of(sV.a("anti_tank"), sV.a("commander"));
    }

    @Override // com.boehmod.blockfront.oF
    public int aS() {
        return 0;
    }

    @Override // com.boehmod.blockfront.qO
    public boolean by() {
        return false;
    }

    @Override // com.boehmod.blockfront.qO
    public boolean bz() {
        return true;
    }

    @Override // com.boehmod.blockfront.qO
    public boolean bA() {
        return false;
    }

    @Override // com.boehmod.blockfront.qO
    public boolean bB() {
        return true;
    }

    @Override // com.boehmod.blockfront.qO
    public int a(@NotNull sV sVVar) {
        switch (sVVar.getKey()) {
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

    @Override // com.boehmod.blockfront.InterfaceC0463rd
    public int bw() {
        return 150;
    }

    @Override // com.boehmod.blockfront.InterfaceC0463rd
    public boolean j(@NotNull UUID uuid) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0463rd
    public boolean k(@NotNull UUID uuid) {
        return true;
    }

    @Override // com.boehmod.blockfront.qZ
    /* JADX INFO: renamed from: bC */
    public boolean mo1047bC() {
        return true;
    }

    @Override // com.boehmod.blockfront.qR
    public boolean d(@NotNull ServerPlayer serverPlayer) {
        return this.f263a == oN.GAME;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0471rl mo752a() {
        return new InterfaceC0471rl.c(List.copyOf(((rK) this.f268a).aq()), Optional.ofNullable(d()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull InterfaceC0471rl interfaceC0471rl) throws MatchException {
        if (interfaceC0471rl instanceof InterfaceC0471rl.c) {
            InterfaceC0471rl.c cVar = (InterfaceC0471rl.c) interfaceC0471rl;
            try {
                List<oX> listX = cVar.X();
                Optional<C0332mh> optionalH = cVar.h();
                ((rK) this.f268a).cJ();
                Iterator<oX> it = listX.iterator();
                while (it.hasNext()) {
                    ((rK) this.f268a).d(it.next());
                }
                this.c = optionalH.orElse(null);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
