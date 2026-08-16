package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sQ.class */
public final class C1011sQ extends AbstractC0863pb<C1011sQ, C1013sS, C1058tJ<C1011sQ, C1013sS>> implements InterfaceC0942rA, InterfaceC0943rB, InterfaceC0977rj<C1011sQ>, InterfaceC0979rl, InterfaceC0982ro, InterfaceC0986rs, InterfaceC0990rw, InterfaceC0991rx, InterfaceC0993rz {

    /* JADX INFO: renamed from: sZ */
    public static final int f5575sZ = 50;

    /* JADX INFO: renamed from: i */
    private final C0620kx f5576i;

    /* JADX INFO: renamed from: c */
    @Nullable
    private C0680mD f5577c;

    /* JADX INFO: renamed from: hy */
    static final /* synthetic */ boolean f5578hy;

    static {
        f5578hy = !C1011sQ.class.desiredAssertionStatus();
    }

    public C1011sQ(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        super(abstractC0531jN, "tdm", "Team Deathmatch");
        this.f5576i = new C0620kx().m2840a("spawn", new C0620kx().m2840a("add", new C0620kx((commandContext, strArr) -> {
            String str = strArr[0];
            C0881pt c0881pt = new C0881pt(((CommandSourceStack) commandContext.getSource()).source);
            C0872pk c0872pkA = m4018b().m4242a(str);
            if (c0872pkA == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                c0872pkA.m4310b(c0881pt);
                C0721ms.m3329b(((CommandSourceStack) commandContext.getSource()).source, Component.literal(c0872pkA.getName() + " team spawn added. (" + c0872pkA.m4309D().size() + ")"));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"team"})).m2836a(C0622kz.f3554a).m2842a((commandContext2, strArr2) -> {
            return strArr2.length == 0 ? m4019c() : List.of();
        })).m2840a("clear", new C0620kx((commandContext3, strArr3) -> {
            String str = strArr3[0];
            C0872pk c0872pkA = m4018b().m4242a(str);
            if (c0872pkA == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                c0872pkA.m4311cF();
                C0721ms.m3329b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal(c0872pkA.getName() + " team's spawns cleared."));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"team"})).m2842a((commandContext4, strArr4) -> {
            return strArr4.length == 0 ? m4019c() : List.of();
        })));
        this.f5577c = null;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public C0680mD m5695d() {
        return this.f5577c;
    }

    /* JADX INFO: renamed from: b */
    public void m5696b(@Nullable C0680mD c0680mD) {
        this.f5577c = c0680mD;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1012sR mo3995a(@NotNull C0623l c0623l) {
        return new C1012sR(c0623l, this, (C0396gl) this.f4643b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1013sS mo3996a() {
        return new C1013sS(this, this.f4643b);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1056tH<C1011sQ, C1013sS> mo3999a() {
        return new C1055tG(C1016sV::new);
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
    /* JADX INFO: renamed from: a */
    public boolean mo4033a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull EnumC0876po enumC0876po, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        C0872pk c0872pkB = ((C1013sS) this.f4642a).mo4241b();
        if (c0872pkB == null) {
            C0530jM.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((C1013sS) this.f4642a).m4212a(abstractC0531jN, enumC0876po, serverLevel, serverPlayer, c0872pkB);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: d */
    public void mo4041d(@Nullable Level level) {
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx mo4082a() {
        return this.f4636b.m2835a(this.f5576i);
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
        return CloudAchievements.ACH_MATCH_WIN_TDM;
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

    @Override // com.boehmod.blockfront.InterfaceC0943rB
    /* JADX INFO: renamed from: a */
    public Component mo5178a(@NotNull ServerPlayer serverPlayer) {
        C0872pk c0872pkA = ((C1013sS) this.f4642a).m4242a(C1062tN.f5783dl);
        if (!f5578hy && c0872pkA == null) {
            throw new AssertionError();
        }
        C0872pk c0872pkA2 = ((C1013sS) this.f4642a).m4242a(C1062tN.f5782dk);
        if (!f5578hy && c0872pkA2 == null) {
            throw new AssertionError();
        }
        MutableComponent mutableComponentTranslatable = null;
        if (c0872pkA.m4302a(C1062tN.f5748l) > 37.5d) {
            mutableComponentTranslatable = Component.translatable("bf.message.gamemode.switchteams.error.scores");
        }
        if (c0872pkA2.m4302a(C1062tN.f5748l) > 37.5d) {
            mutableComponentTranslatable = Component.translatable("bf.message.gamemode.switchteams.error.scores");
        }
        if (mutableComponentTranslatable != null) {
            return mutableComponentTranslatable;
        }
        return m4079a((Player) serverPlayer, c0872pkA.m4320bo(), c0872pkA2.m4320bo());
    }

    @Override // com.boehmod.blockfront.InterfaceC0943rB
    /* JADX INFO: renamed from: b */
    public void mo5179b(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        m4075a(abstractC0531jN, serverLevel, serverPlayer, uuid);
    }

    @Override // com.boehmod.blockfront.InterfaceC0943rB
    /* JADX INFO: renamed from: bM */
    public int mo5180bM() {
        return C1062tN.f5737tA;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: e */
    public Set<C1093ts> mo3997e() {
        return Set.of(C1093ts.m6000a("commander"));
    }

    @Override // com.boehmod.blockfront.InterfaceC0979rl
    /* JADX INFO: renamed from: bI */
    public boolean mo5343bI() {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0979rl
    /* JADX INFO: renamed from: bJ */
    public boolean mo5344bJ() {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0979rl
    /* JADX INFO: renamed from: bK */
    public boolean mo5345bK() {
        return true;
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

    @Override // com.boehmod.blockfront.InterfaceC0977rj
    /* JADX INFO: renamed from: a */
    public void mo5350a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull EnumC0883pv enumC0883pv) {
        m5551a(this, uuid, enumC0883pv);
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
        return new InterfaceC0950rI.h(Optional.ofNullable(m5695d()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4043a(@NotNull InterfaceC0950rI interfaceC0950rI) throws MatchException {
        if (interfaceC0950rI instanceof InterfaceC0950rI.h) {
            try {
                this.f5577c = ((InterfaceC0950rI.h) interfaceC0950rI).m5264h().orElse(null);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
