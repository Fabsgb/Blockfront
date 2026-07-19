package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.blockfront.InterfaceC0471rl;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.st, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/st.class */
public final class C0506st extends oF<C0506st, C0508sv, C0526tm<C0506st, C0508sv>> implements qM<C0506st>, qO, qR, qV, qZ, InterfaceC0460ra, InterfaceC0462rc, InterfaceC0463rd, InterfaceC0464re {
    public static final int qY = 50;
    private final C0272kb i;

    @Nullable
    private C0332mh c;
    static final /* synthetic */ boolean he;

    static {
        he = !C0506st.class.desiredAssertionStatus();
    }

    public C0506st(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        super(abstractC0264ju, "tdm", "Team Deathmatch");
        this.i = new C0272kb().a("spawn", new C0272kb().a("add", new C0272kb((commandContext, strArr) -> {
            String str = strArr[0];
            oX oXVar = new oX(((CommandSourceStack) commandContext.getSource()).source);
            oO oOVarA = b().a(str);
            if (oOVarA == null) {
                lW.b(((CommandSourceStack) commandContext.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                oOVarA.b(oXVar);
                lW.b(((CommandSourceStack) commandContext.getSource()).source, Component.literal(oOVarA.getName() + " team spawn added. (" + oOVarA.B().size() + ")"));
            }
        }).a(C0274kd.a(new String[]{"team"})).a(C0274kd.a).a((commandContext2, strArr2) -> {
            return strArr2.length == 0 ? c() : List.of();
        })).a("clear", new C0272kb((commandContext3, strArr3) -> {
            String str = strArr3[0];
            oO oOVarA = b().a(str);
            if (oOVarA == null) {
                lW.b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                oOVarA.ct();
                lW.b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal(oOVarA.getName() + " team's spawns cleared."));
            }
        }).a(C0274kd.a(new String[]{"team"})).a((commandContext4, strArr4) -> {
            return strArr4.length == 0 ? c() : List.of();
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
    public C0507su a(@NotNull C0297l c0297l) {
        return new C0507su(c0297l, this, (fV) this.f269b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.oF
    @NotNull
    public C0508sv a() {
        return new C0508sv(this, this.f269b);
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0524tk<C0506st, C0508sv> mo749a() {
        return new C0523tj(C0511sy::new);
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
    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oS oSVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        oO oOVarB = ((C0508sv) this.f268a).b();
        if (oOVarB == null) {
            C0263jt.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((C0508sv) this.f268a).a(abstractC0264ju, oSVar, serverLevel, serverPlayer, oOVarB);
    }

    @Override // com.boehmod.blockfront.oF
    public void d(@Nullable Level level) {
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0272kb mo763a() {
        return this.b.a(this.i);
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
        return CloudAchievements.ACH_MATCH_WIN_TDM;
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

    @Override // com.boehmod.blockfront.InterfaceC0464re
    public Component a(@NotNull ServerPlayer serverPlayer) {
        oO oOVarA = ((C0508sv) this.f268a).a(C0529tp.da);
        if (!he && oOVarA == null) {
            throw new AssertionError();
        }
        oO oOVarA2 = ((C0508sv) this.f268a).a(C0529tp.cZ);
        if (!he && oOVarA2 == null) {
            throw new AssertionError();
        }
        MutableComponent mutableComponentTranslatable = null;
        if (oOVarA.a(C0529tp.l) > 37.5d) {
            mutableComponentTranslatable = Component.translatable("bf.message.gamemode.switchteams.error.scores");
        }
        if (oOVarA2.a(C0529tp.l) > 37.5d) {
            mutableComponentTranslatable = Component.translatable("bf.message.gamemode.switchteams.error.scores");
        }
        if (mutableComponentTranslatable != null) {
            return mutableComponentTranslatable;
        }
        return a((Player) serverPlayer, oOVarA.aZ(), oOVarA2.aZ());
    }

    @Override // com.boehmod.blockfront.InterfaceC0464re
    public void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        a(abstractC0264ju, serverLevel, serverPlayer, uuid);
    }

    @Override // com.boehmod.blockfront.InterfaceC0464re
    public int bx() {
        return C0529tp.rx;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    public Set<sV> e() {
        return Set.of(sV.a("commander"));
    }

    @Override // com.boehmod.blockfront.qO
    public boolean by() {
        return true;
    }

    @Override // com.boehmod.blockfront.qO
    public boolean bz() {
        return true;
    }

    @Override // com.boehmod.blockfront.qO
    public boolean bA() {
        return true;
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

    @Override // com.boehmod.blockfront.qM
    public void a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull oZ oZVar) {
        a(this, uuid, oZVar);
    }

    @Override // com.boehmod.blockfront.qR
    public boolean d(@NotNull ServerPlayer serverPlayer) {
        return this.f263a == oN.GAME;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0471rl mo752a() {
        return new InterfaceC0471rl.h(Optional.ofNullable(d()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull InterfaceC0471rl interfaceC0471rl) throws MatchException {
        if (interfaceC0471rl instanceof InterfaceC0471rl.h) {
            try {
                this.c = ((InterfaceC0471rl.h) interfaceC0471rl).h().orElse(null);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
