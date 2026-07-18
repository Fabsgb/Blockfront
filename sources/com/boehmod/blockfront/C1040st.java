package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.blockfront.InterfaceC0978rl;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.st */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/st.class */
public final class C1040st extends AbstractC0787oF<C1040st, C1042sv, C1086tm<C1040st, C1042sv>> implements InterfaceC0900qM<C1040st>, InterfaceC0902qO, InterfaceC0905qR, InterfaceC0909qV, InterfaceC0913qZ, InterfaceC0967ra, InterfaceC0969rc, InterfaceC0970rd, InterfaceC0971re {

    /* JADX INFO: renamed from: qY */
    public static final int f5528qY = 50;

    /* JADX INFO: renamed from: i */
    private final C0597kb f5529i;

    /* JADX INFO: renamed from: c */
    @Nullable
    private C0709mh f5530c;

    /* JADX INFO: renamed from: he */
    static final /* synthetic */ boolean f5531he;

    static {
        f5531he = !C1040st.class.desiredAssertionStatus();
    }

    public C1040st(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        super(abstractC0563ju, "tdm", "Team Deathmatch");
        this.f5529i = new C0597kb().m2628a("spawn", new C0597kb().m2628a("add", new C0597kb((commandContext, strArr) -> {
            String str = strArr[0];
            C0805oX c0805oX = new C0805oX(((CommandSourceStack) commandContext.getSource()).source);
            C0796oO c0796oOA = m3582b().m3806a(str);
            if (c0796oOA == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                c0796oOA.m3874b(c0805oX);
                C0645lW.m2898b(((CommandSourceStack) commandContext.getSource()).source, Component.literal(c0796oOA.getName() + " team spawn added. (" + c0796oOA.m3873B().size() + ")"));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"team"})).m2624a(C0599kd.f3307a).m2630a((commandContext2, strArr2) -> {
            return strArr2.length == 0 ? m3583c() : List.of();
        })).m2628a("clear", new C0597kb((commandContext3, strArr3) -> {
            String str = strArr3[0];
            C0796oO c0796oOA = m3582b().m3806a(str);
            if (c0796oOA == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                c0796oOA.m3875ct();
                C0645lW.m2898b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal(c0796oOA.getName() + " team's spawns cleared."));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"team"})).m2630a((commandContext4, strArr4) -> {
            return strArr4.length == 0 ? m3583c() : List.of();
        })));
        this.f5530c = null;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public C0709mh m5806d() {
        return this.f5530c;
    }

    /* JADX INFO: renamed from: b */
    public void m5807b(@Nullable C0709mh c0709mh) {
        this.f5530c = c0709mh;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1041su mo3559a(@NotNull C0622l c0622l) {
        return new C1041su(c0622l, this, (C0326fV) this.f4249b);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1042sv mo3560a() {
        return new C1042sv(this, this.f4249b);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1084tk<C1040st, C1042sv> mo3563a() {
        return new C1083tj(C1045sy::new);
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
    /* JADX INFO: renamed from: a */
    public boolean mo3597a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        C0796oO c0796oOB = ((C1042sv) this.f4248a).mo3805b();
        if (c0796oOB == null) {
            C0562jt.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((C1042sv) this.f4248a).m3776a(abstractC0563ju, enumC0800oS, serverLevel, serverPlayer, c0796oOB);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: d */
    public void mo3605d(@Nullable Level level) {
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb mo3646a() {
        return this.f4242b.m2623a(this.f5529i);
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
        return CloudAchievements.ACH_MATCH_WIN_TDM;
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

    @Override // com.boehmod.blockfront.InterfaceC0971re
    /* JADX INFO: renamed from: a */
    public Component mo5161a(@NotNull ServerPlayer serverPlayer) {
        C0796oO c0796oOA = ((C1042sv) this.f4248a).m3806a(C1089tp.f5730da);
        if (!f5531he && c0796oOA == null) {
            throw new AssertionError();
        }
        C0796oO c0796oOA2 = ((C1042sv) this.f4248a).m3806a(C1089tp.f5729cZ);
        if (!f5531he && c0796oOA2 == null) {
            throw new AssertionError();
        }
        MutableComponent mutableComponentTranslatable = null;
        if (c0796oOA.m3866a(C1089tp.f5695l) > 37.5d) {
            mutableComponentTranslatable = Component.translatable("bf.message.gamemode.switchteams.error.scores");
        }
        if (c0796oOA2.m3866a(C1089tp.f5695l) > 37.5d) {
            mutableComponentTranslatable = Component.translatable("bf.message.gamemode.switchteams.error.scores");
        }
        if (mutableComponentTranslatable != null) {
            return mutableComponentTranslatable;
        }
        return m3643a((Player) serverPlayer, c0796oOA.m3884aZ(), c0796oOA2.m3884aZ());
    }

    @Override // com.boehmod.blockfront.InterfaceC0971re
    /* JADX INFO: renamed from: b */
    public void mo5162b(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        m3639a(abstractC0563ju, serverLevel, serverPlayer, uuid);
    }

    @Override // com.boehmod.blockfront.InterfaceC0971re
    /* JADX INFO: renamed from: bx */
    public int mo5163bx() {
        return C1089tp.f5684rx;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: e */
    public Set<C1015sV> mo3561e() {
        return Set.of(C1015sV.m5512a("commander"));
    }

    @Override // com.boehmod.blockfront.InterfaceC0902qO
    /* JADX INFO: renamed from: by */
    public boolean mo4669by() {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0902qO
    /* JADX INFO: renamed from: bz */
    public boolean mo4670bz() {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0902qO
    /* JADX INFO: renamed from: bA */
    public boolean mo4671bA() {
        return true;
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

    @Override // com.boehmod.blockfront.InterfaceC0900qM
    /* JADX INFO: renamed from: a */
    public void mo4664a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull EnumC0807oZ enumC0807oZ) {
        m4665a(this, uuid, enumC0807oZ);
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
        return new InterfaceC0978rl.h(Optional.ofNullable(m5806d()));
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3607a(@NotNull InterfaceC0978rl interfaceC0978rl) throws MatchException {
        if (interfaceC0978rl instanceof InterfaceC0978rl.h) {
            try {
                this.f5530c = ((InterfaceC0978rl.h) interfaceC0978rl).m5388h().orElse(null);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
