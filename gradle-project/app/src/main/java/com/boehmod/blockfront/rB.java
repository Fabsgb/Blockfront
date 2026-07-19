package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.mm.report.DominationMatchReportData;
import com.boehmod.bflib.cloud.common.mm.report.IMatchReportData;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.InterfaceC0471rl;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rB.class */
public final class rB extends oF<rB, rE, C0526tm<rB, rE>> implements qL, qM<rB>, qN<rE, rC>, qO, qP, qR, qV, qY, qZ, InterfaceC0460ra, InterfaceC0461rb, InterfaceC0463rd, InterfaceC0464re, InterfaceC0466rg {
    private static final Component iX;
    private static final Component iY;
    private static final Component iZ;
    private static final Component ja;
    public static final float lE = 2.0f;
    public static final int pJ = 500;
    public static final int pK = 20;

    @NotNull
    private final List<rC> bi;

    @NotNull
    private final List<oW> bj;

    @NotNull
    private final List<C0417pl> bk;

    @Nullable
    private C0332mh b;

    @Nullable
    private C0332mh c;

    @NotNull
    private final C0272kb d;
    public int pL;
    static final /* synthetic */ boolean gP;

    @Override // com.boehmod.blockfront.qN
    public /* bridge */ /* synthetic */ void a(@NotNull AbstractC0264ju abstractC0264ju, @NotNull Level level, @NotNull oV oVVar, @NotNull String str, @NotNull String str2, @NotNull Set set) {
        a((AbstractC0264ju<?, ?, ?>) abstractC0264ju, level, (rC) oVVar, str, str2, (Set<UUID>) set);
    }

    static {
        gP = !rB.class.desiredAssertionStatus();
        iX = Component.translatable("bf.popup.message.cpoint.defended").withStyle(ChatFormatting.GOLD);
        iY = Component.translatable("bf.popup.message.crate").withStyle(ChatFormatting.YELLOW);
        iZ = Component.translatable("bf.message.gamemode.switchteams.error.scores");
        ja = Component.translatable("bf.message.gamemode.switchteams.error.scores");
    }

    public rB(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        super(abstractC0264ju, "dom", "Domination");
        this.bi = new ObjectArrayList();
        this.bj = new ObjectArrayList();
        this.bk = new ObjectArrayList();
        this.b = null;
        this.c = null;
        this.d = new C0272kb().a("cpoint", new C0272kb().a("add", new C0272kb((commandContext, strArr) -> {
            ServerPlayer player = ((CommandSourceStack) commandContext.getSource()).getPlayer();
            CommandSource commandSource = ((CommandSourceStack) commandContext.getSource()).source;
            if (player == null) {
                return;
            }
            String str = strArr[0];
            this.bi.add(new rC((rE) this.f268a, player, str));
            lW.b(commandSource, Component.literal("Added capture point " + str + ". (" + this.bi.size() + ")"));
        }).a(C0274kd.a(new String[]{"name"})).a(C0274kd.a)).a("clear", new C0272kb((commandContext2, strArr2) -> {
            lW.b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Clearing all " + this.bi.size() + " capture points."));
            this.bi.clear();
        })).a("move", new C0272kb((commandContext3, strArr3) -> {
            ServerPlayer player = ((CommandSourceStack) commandContext3.getSource()).getPlayer();
            CommandSource commandSource = ((CommandSourceStack) commandContext3.getSource()).source;
            if (player == null) {
                return;
            }
            String str = strArr3[0];
            for (rC rCVar : this.bi) {
                if (rCVar.bP.equalsIgnoreCase(str)) {
                    rCVar.c(new oX((Player) player));
                    lW.b(commandSource, Component.literal("Moved capture point " + str + "."));
                    return;
                }
            }
            lW.b(commandSource, Component.literal("Capture point " + str + " was not found!"));
        }).a(C0274kd.a(new String[]{"name"})).a(C0274kd.a).a((commandContext4, strArr4) -> {
            if (strArr4.length == 0) {
                return this.bi.stream().map(rCVar -> {
                    return rCVar.bP;
                }).toList();
            }
            return List.of();
        })).a("box", new C0272kb((commandContext5, strArr5) -> {
            String str;
            ServerPlayer player = ((CommandSourceStack) commandContext5.getSource()).getPlayer();
            CommandSource commandSource = ((CommandSourceStack) commandContext5.getSource()).source;
            if (player == null) {
                return;
            }
            String str2 = strArr5[0];
            for (rC rCVar : this.bi) {
                if (rCVar.bP.equalsIgnoreCase(str2)) {
                    AABB aabbJ = this.f269b.m305a((Player) player).m301b().j();
                    rCVar.g = aabbJ;
                    if (aabbJ != null) {
                        str = "Set capture box for " + str2 + " from your selection.";
                    } else {
                        str = "No AABB selection; cleared capture box for " + str2 + " (using radius).";
                    }
                    lW.b(commandSource, Component.literal(str));
                    return;
                }
            }
            lW.b(commandSource, Component.literal("Capture point " + str2 + " was not found!"));
        }).a(C0274kd.a(new String[]{"name"})).a(C0274kd.a).a((commandContext6, strArr6) -> {
            if (strArr6.length == 0) {
                return this.bi.stream().map(rCVar -> {
                    return rCVar.bP;
                }).toList();
            }
            return List.of();
        }))).a("apoint", new C0272kb().a("add", new C0272kb((commandContext7, strArr7) -> {
            this.bj.add(new oW(((CommandSourceStack) commandContext7.getSource()).source));
            lW.b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Added ammo point. (" + this.bj.size() + ")"));
        }).a(C0274kd.a)).a("clear", new C0272kb((commandContext8, strArr8) -> {
            lW.b(((CommandSourceStack) commandContext8.getSource()).source, Component.literal("Clearing all " + this.bj.size() + " ammo points."));
            this.bj.clear();
        }))).a("vpoint", new C0272kb().a("add", new C0272kb((commandContext9, strArr9) -> {
            String str = strArr9[0];
            String str2 = strArr9[1];
            this.bk.add(new C0417pl(((CommandSourceStack) commandContext9.getSource()).source, str.equalsIgnoreCase("allies"), C0636xo.b(str2)));
            lW.b(((CommandSourceStack) commandContext9.getSource()).source, Component.literal("Added " + str + " vehicle point (" + str2 + "). (" + this.bk.size() + ")"));
        }).a(C0274kd.a(new String[]{"team", "entityType"})).a(C0274kd.a).a((commandContext10, strArr10) -> {
            switch (strArr10.length) {
                case 0:
                    return List.of("allies", "axis");
                case 1:
                    return C0636xo.i();
                default:
                    return List.of();
            }
        })).a("clear", new C0272kb((commandContext11, strArr11) -> {
            lW.b(((CommandSourceStack) commandContext11.getSource()).source, Component.literal("Clearing all " + this.bk.size() + " vehicle points."));
            this.bk.clear();
        }))).a("spawn", new C0272kb().a("add", new C0272kb((commandContext12, strArr12) -> {
            String str = strArr12[0];
            oX oXVar = new oX(((CommandSourceStack) commandContext12.getSource()).source);
            oO oOVarA = b().a(str);
            if (oOVarA == null) {
                lW.b(((CommandSourceStack) commandContext12.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                oOVarA.b(oXVar);
                lW.b(((CommandSourceStack) commandContext12.getSource()).source, Component.literal(oOVarA.getName() + " team spawn added. (" + oOVarA.B().size() + ")"));
            }
        }).a(C0274kd.a(new String[]{"team"})).a(C0274kd.a).a((commandContext13, strArr13) -> {
            return strArr13.length == 0 ? c() : List.of();
        })).a("clear", new C0272kb((commandContext14, strArr14) -> {
            String str = strArr14[0];
            oO oOVarA = b().a(str);
            if (oOVarA == null) {
                lW.b(((CommandSourceStack) commandContext14.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                oOVarA.ct();
                lW.b(((CommandSourceStack) commandContext14.getSource()).source, Component.literal(oOVarA.getName() + " team's spawns cleared."));
            }
        }).a(C0274kd.a(new String[]{"team"})).a((commandContext15, strArr15) -> {
            return strArr15.length == 0 ? c() : List.of();
        })));
        this.pL = 0;
    }

    public static void a(@NotNull rB rBVar, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull UUID uuid, boolean z) {
        if (oR.a((oF<?, ?, ?>) rBVar, uuid, C0529tp.e) != 0) {
            return;
        }
        oR.m792a((oF<?, ?, ?>) rBVar, uuid, C0529tp.e, 1);
        oR.a(uuid, hU.a().c(uW.WARMUP));
        C0332mh c0332mhC = rBVar.c();
        if (c0332mhC != null) {
            C0337mm c0337mm = new C0337mm();
            if (z) {
                c0337mm.B(true);
            }
            oR.a(abstractC0264ju, c0332mhC, c0337mm, uuid);
        }
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    public rD a(@NotNull C0297l c0297l) {
        return new rD(c0297l, this, (fV) this.f269b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.oF
    @NotNull
    public rE a() {
        return new rE(this, this.f269b);
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0524tk<rB, rE> mo749a() {
        return new C0523tj(rH::new);
    }

    @Override // com.boehmod.blockfront.oF
    public void g(@NotNull List<MutableComponent> list) {
        if (this.bi.isEmpty()) {
            list.add(Component.literal("Capture points in game '" + this.bE + "' are missing."));
        }
        if (this.b == null) {
            list.add(Component.literal("Intro sequence in game '" + this.bE + "' is missing."));
        }
        if (this.c == null) {
            list.add(Component.literal("Outro sequence in game '" + this.bE + "' is missing."));
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
        return new DominationMatchReportData(pJ);
    }

    public void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.bi.forEach(rCVar -> {
            rCVar.a((AbstractC0264ju<?, ?, ?>) abstractC0264ju, (com.boehmod.blockfront.common.player.c<?>) cVar, this, serverLevel, (Set<UUID>) set);
        });
        int i = this.pL;
        this.pL = i + 1;
        if (i > 3) {
            this.pL = 0;
            Iterator<rC> it = this.bi.iterator();
            while (it.hasNext()) {
                oO oOVarD = it.next().d();
                if (oOVarD != null) {
                    oOVarD.a(C0529tp.l, oOVarD.a(C0529tp.l) + 1);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.oF
    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oS oSVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        oO oOVarB = ((rE) this.f268a).b();
        if (oOVarB == null) {
            C0263jt.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((rE) this.f268a).a(abstractC0264ju, oSVar, serverLevel, serverPlayer, oOVarB);
    }

    @Override // com.boehmod.blockfront.oF
    public void d(@Nullable Level level) {
        cI();
    }

    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.a(byteBuf, z);
        int size = this.bi.size();
        byteBuf.writeInt(size);
        for (int i = 0; i < size; i++) {
            this.bi.get(i).c(byteBuf);
        }
        int size2 = this.bj.size();
        byteBuf.writeInt(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.bj.get(i2).c(byteBuf);
        }
    }

    @Override // com.boehmod.blockfront.oF
    public void g(@NotNull ByteBuf byteBuf) throws IOException {
        super.g(byteBuf);
        int i = byteBuf.readInt();
        if (this.bi.isEmpty()) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bi.add(new rC((rE) this.f268a, byteBuf));
            }
        } else {
            Iterator<rC> it = this.bi.iterator();
            while (it.hasNext()) {
                it.next().b(byteBuf);
            }
        }
        this.bj.clear();
        int i3 = byteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            oW oWVar = new oW();
            oWVar.b(byteBuf);
            this.bj.add(oWVar);
        }
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0471rl mo752a() {
        return new InterfaceC0471rl.b(O().stream().map(rCVar -> {
            return new C0468ri(new oX(rCVar.c.x, rCVar.c.y, rCVar.c.z, rCVar.h.x, rCVar.h.y), rCVar.bP, rCVar.d != null ? rCVar.d.getName() : "", rCVar.e != null ? rCVar.e.getName() : "", rCVar.nm, rCVar.gh, Optional.ofNullable(rCVar.g));
        }).toList(), List.copyOf(ao()), List.copyOf(ap()), Optional.ofNullable(c()), Optional.ofNullable(d()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull InterfaceC0471rl interfaceC0471rl) throws MatchException {
        if (interfaceC0471rl instanceof InterfaceC0471rl.b) {
            InterfaceC0471rl.b bVar = (InterfaceC0471rl.b) interfaceC0471rl;
            try {
                List<C0468ri> listU = bVar.U();
                List<oW> listV = bVar.V();
                List<C0417pl> listW = bVar.W();
                Optional<C0332mh> optionalG = bVar.g();
                Optional<C0332mh> optionalH = bVar.h();
                this.bi.clear();
                for (C0468ri c0468ri : listU) {
                    rC rCVar = new rC((rE) this.f268a);
                    rCVar.c = c0468ri.e().c;
                    rCVar.h = c0468ri.e().h;
                    rCVar.bP = c0468ri.U();
                    rCVar.nm = c0468ri.by();
                    rCVar.gh = c0468ri.bD();
                    rCVar.g = c0468ri.m1057e().orElse(null);
                    this.bi.add(rCVar);
                }
                this.bj.clear();
                this.bj.addAll(listV);
                this.bk.clear();
                this.bk.addAll(listW);
                this.b = optionalG.orElse(null);
                this.c = optionalH.orElse(null);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }

    public void cI() {
        this.bi.forEach((v0) -> {
            v0.bf();
        });
    }

    @Nullable
    public C0332mh c() {
        return this.b;
    }

    @Nullable
    public C0332mh d() {
        return this.c;
    }

    public void a(@Nullable C0332mh c0332mh) {
        this.b = c0332mh;
    }

    public void b(@Nullable C0332mh c0332mh) {
        this.c = c0332mh;
    }

    @Nullable
    public rC a(@NotNull Player player, @NotNull Set<UUID> set) {
        for (rC rCVar : this.bi) {
            if (rCVar.a(player.level(), rCVar.a(a(rCVar)), set).contains(player)) {
                return rCVar;
            }
        }
        return null;
    }

    @Nullable
    public rC a(@NotNull mE mEVar, @NotNull oO oOVar) {
        Vec3 vec3Position = mEVar.position();
        rC rCVar = null;
        for (rC rCVar2 : this.bi) {
            if (rCVar2.c((LivingEntity) mEVar) && (rCVar == null || rCVar2.c.distanceTo(vec3Position) < rCVar.c.distanceTo(vec3Position))) {
                if (!oOVar.equals(rCVar2.d())) {
                    rCVar = rCVar2;
                }
            }
        }
        return rCVar;
    }

    @NotNull
    public List<oW> ao() {
        return Collections.unmodifiableList(this.bj);
    }

    @NotNull
    public List<C0417pl> ap() {
        return Collections.unmodifiableList(this.bk);
    }

    public void g(@NotNull ServerLevel serverLevel) {
        this.bk.forEach(c0417pl -> {
            c0417pl.a((oF<?, ?, ?>) this, (Level) serverLevel);
        });
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0272kb mo763a() {
        return super.mo763a().a(this.d);
    }

    @Override // com.boehmod.blockfront.oF
    public boolean f(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    public int aW() {
        return 1;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean e(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean bd() {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean bf() {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public CloudAchievement mo760a() {
        return CloudAchievements.ACH_MATCH_WIN_DOM;
    }

    @Override // com.boehmod.blockfront.qL
    public void e(@NotNull ServerLevel serverLevel) {
        oR.a(serverLevel, (oF<?, ?, ?>) this, (oI<?>) this.f268a);
        oO oOVarA = ((rE) this.f268a).a(C0529tp.da);
        oO oOVarA2 = ((rE) this.f268a).a(C0529tp.cZ);
        if (!gP && oOVarA == null) {
            throw new AssertionError();
        }
        if (!gP && oOVarA2 == null) {
            throw new AssertionError();
        }
        int iB = b(oOVarA2);
        int iB2 = b(oOVarA);
        for (int i = 0; i < iB; i++) {
            oR.a((oF<?, ?, ?>) this, serverLevel, oOVarA2, true);
        }
        for (int i2 = 0; i2 < iB2; i2++) {
            oR.a((oF<?, ?, ?>) this, serverLevel, oOVarA, true);
        }
    }

    @Override // com.boehmod.blockfront.qL
    public void a(@NotNull mE mEVar, @NotNull Level level) {
    }

    @Override // com.boehmod.blockfront.qL
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull mE mEVar, @NotNull DamageSource damageSource) {
        ServerPlayer serverPlayer;
        UUID uuid;
        oO oOVarA;
        oO oOVarM671a = mEVar.m671a();
        if (oOVarM671a != null && mEVar.aJ()) {
            oO oOVarA2 = ((rE) this.f268a).a(C0529tp.da);
            oO oOVarA3 = ((rE) this.f268a).a(C0529tp.cZ);
            if (!gP && oOVarA2 == null) {
                throw new AssertionError();
            }
            if (!gP && oOVarA3 == null) {
                throw new AssertionError();
            }
            switch (oOVarM671a.getName()) {
                case "Allies":
                    oR.a((oF<?, ?, ?>) this, serverLevel, oOVarA3, true);
                    break;
                case "Axis":
                    oR.a((oF<?, ?, ?>) this, serverLevel, oOVarA2, true);
                    break;
            }
        }
        ServerPlayer entity = damageSource.getEntity();
        if ((entity instanceof ServerPlayer) && (oOVarA = ((rE) this.f268a).a((uuid = (serverPlayer = entity).getUUID()))) != null) {
            oR.a(abstractC0264ju, this, uuid, C0529tp.l);
            for (rC rCVar : this.bi) {
                if (rCVar.a((Entity) mEVar, a(rCVar)) && oOVarA.equals(rCVar.d())) {
                    oR.a(serverPlayer, new sQ(iX, 40));
                    oR.a(abstractC0264ju, this, uuid, C0529tp.l, 2);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.qL
    public void a(@NotNull mE mEVar, @NotNull Player player) {
    }

    @Override // com.boehmod.blockfront.qL
    public void a(@NotNull mE mEVar) {
    }

    @Override // com.boehmod.blockfront.qL
    @Nullable
    /* JADX INFO: renamed from: a */
    public BlockPos mo920a(@NotNull mE mEVar) {
        oO oOVarM671a = mEVar.m671a();
        if (oOVarM671a == null) {
            return null;
        }
        rC rCVarA = a(mEVar, oOVarM671a);
        if (rCVarA != null) {
            return rCVarA.c();
        }
        oO oOVarA = ((rE) this.f268a).a(oOVarM671a.bp() ? C0529tp.da : C0529tp.cZ);
        if (oOVarA != null) {
            return oOVarA.m789a((oF<?, ?, ?>) this).c();
        }
        return null;
    }

    @Override // com.boehmod.blockfront.qL
    public boolean a(@NotNull mE mEVar, @NotNull DamageSource damageSource) {
        mE entity = damageSource.getEntity();
        if (entity instanceof mE) {
            oO oOVarM671a = entity.m671a();
            return (oOVarM671a == null || oOVarM671a.equals(mEVar.m671a())) ? false : true;
        }
        Player entity2 = damageSource.getEntity();
        if (entity2 instanceof Player) {
            oO oOVarA = ((rE) this.f268a).a(entity2.getUUID());
            return (oOVarA == null || oOVarA.equals(mEVar.m671a())) ? false : true;
        }
        return false;
    }

    @Override // com.boehmod.blockfront.qL
    public int b(@NotNull oO oOVar) {
        return 8;
    }

    @Override // com.boehmod.blockfront.qV
    public boolean i(@NotNull Player player) {
        return player.getHealth() > player.getMaxHealth() / 2.0f;
    }

    @Override // com.boehmod.blockfront.qV
    public float a(@NotNull Player player) {
        return 0.5f;
    }

    @Override // com.boehmod.blockfront.qV
    /* JADX INFO: renamed from: a */
    public int mo922a(@NotNull Player player) {
        return 80;
    }

    @Override // com.boehmod.blockfront.qP
    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull Level level, @NotNull ServerPlayer serverPlayer, @NotNull lQ lQVar) {
        UUID uuid = serverPlayer.getUUID();
        ItemStack itemStackA = lQVar.a();
        if (itemStackA.isEmpty()) {
            return false;
        }
        Item item = itemStackA.getItem();
        if (!(item instanceof C0558ur)) {
            return false;
        }
        C0558ur c0558ur = (C0558ur) item;
        serverPlayer.getInventory().setItem(c0558ur.cv() ? 0 : 1, itemStackA);
        DeferredItem<? extends C0560ut> deferredItemA = c0558ur.a();
        if (deferredItemA != null) {
            ItemStack itemStack = new ItemStack((ItemLike) deferredItemA.get());
            serverPlayer.setItemSlot(serverPlayer.getEquipmentSlotForItem(itemStack), itemStack);
        }
        lQVar.c(ItemStack.EMPTY);
        Vec3 vec3Position = serverPlayer.position();
        oR.a(level, vec3Position, (SoundEvent) C0624xc.pT.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
        oR.a(level, vec3Position, SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 1.0f, 1.0f);
        oR.a(abstractC0264ju, this, uuid, C0529tp.l, 2);
        oR.a(serverPlayer, new sQ(iY, 40));
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.boehmod.blockfront.ta] */
    @Override // com.boehmod.blockfront.qP
    public void a(@NotNull lQ lQVar) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.addAll(a().m1156a().aD());
        objectArrayList.addAll(b().m1156a().aD());
        Collections.shuffle(objectArrayList);
        lQVar.c(new ItemStack((ItemLike) ((Supplier) objectArrayList.getFirst()).get()));
    }

    @Override // com.boehmod.blockfront.qP
    /* JADX INFO: renamed from: a */
    public int mo921a(@NotNull lQ lQVar) {
        return 3600;
    }

    @Override // com.boehmod.blockfront.InterfaceC0464re
    public Component a(@NotNull ServerPlayer serverPlayer) {
        oO oOVarA = ((rE) this.f268a).a(C0529tp.da);
        oO oOVarA2 = ((rE) this.f268a).a(C0529tp.cZ);
        if (!gP && oOVarA == null) {
            throw new AssertionError();
        }
        if (!gP && oOVarA2 == null) {
            throw new AssertionError();
        }
        Component component = null;
        if (oOVarA.a(C0529tp.l) > 375.0d) {
            component = iZ;
        }
        if (oOVarA2.a(C0529tp.l) > 375.0d) {
            component = ja;
        }
        if (component != null) {
            return component;
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

    @Override // com.boehmod.blockfront.qY
    public int bu() {
        return 4;
    }

    @Override // com.boehmod.blockfront.qM
    public void a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull oZ oZVar) {
        a(this, uuid, oZVar);
    }

    @Override // com.boehmod.blockfront.qN
    public int a(@NotNull rC rCVar) {
        return 3;
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull Level level, @NotNull rC rCVar, @NotNull String str, @NotNull String str2, @NotNull Set<UUID> set) {
        rE rEVarB = b();
        oO oOVarA = rEVarB.a(str);
        if (!gP && oOVarA == null) {
            throw new AssertionError();
        }
        Set<UUID> setH = oOVarA.h();
        oO oOVarA2 = rEVarB.a(str2);
        oR.a(setH, (SoundEvent) C0624xc.qx.get(), SoundSource.MUSIC, 1.0f);
        oR.a(level, rCVar.c, (SoundEvent) C0624xc.pQ.get(), SoundSource.NEUTRAL, 2.0f, 1.0f);
        if (oOVarA2 != null) {
            oR.a(oOVarA2.h(), (SoundEvent) C0624xc.qy.get(), SoundSource.MUSIC, 1.0f);
        }
        C0514ta c0514taA = oOVarA.a((oF<?, ?, ?>) this);
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.notification.point.captured.team", new Object[]{Component.literal(c0514taA.m1156a().getName()).withStyle(ChatFormatting.WHITE), Component.literal(rCVar.bP.toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.WHITE)}).withStyle(oOVarA.a());
        oR.a((oI<?>) rEVarB, oOVarA, (Component) mutableComponentWithStyle, 80, oV.bO, rCVar.c, oOVarA.getColor(), ColorReferences.COLOR_WHITE);
        for (oO oOVar : rEVarB.A()) {
            if (!oOVar.equals(oOVarA)) {
                oR.a((oI<?>) rEVarB, oOVar, (Component) mutableComponentWithStyle, 80, oV.bO, rCVar.c, oOVarA.getColor(), ColorReferences.COLOR_WHITE);
            }
        }
        Iterator<Player> it = rCVar.a(level, rCVar.a(a(rCVar)), set).iterator();
        while (it.hasNext()) {
            UUID uuid = it.next().getUUID();
            oR.a(abstractC0264ju, this, uuid, C0529tp.l, 3);
            oR.a(abstractC0264ju, this, uuid, C0529tp.q);
        }
    }

    @Override // com.boehmod.blockfront.qN
    public List<rC> O() {
        return Collections.unmodifiableList(this.bi);
    }

    @Override // com.boehmod.blockfront.InterfaceC0466rg
    public boolean a(@NotNull Level level, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        return oR.a((oF<?, ?, ?>) this, uuid, C0529tp.z) > 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0466rg
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo1024a(@NotNull Level level, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0466rg
    public float aT() {
        return 32.0f;
    }

    @Override // com.boehmod.blockfront.qR
    public boolean d(@NotNull ServerPlayer serverPlayer) {
        return this.f263a == oN.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC0461rb
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerPlayer serverPlayer, @NotNull Vec3 vec3) {
        UUID uuid = serverPlayer.getUUID();
        oO oOVarA = ((rE) this.f268a).a(uuid);
        if (oOVarA == null) {
            return;
        }
        oOVarA.a(new vL(uuid, UUID.randomUUID(), vec3));
    }

    @Override // com.boehmod.blockfront.InterfaceC0461rb
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull Vec3 vec3) {
        UUID uuid2 = serverPlayer.getUUID();
        oO oOVarA = ((rE) this.f268a).a(uuid2);
        if (oOVarA == null) {
            return;
        }
        oOVarA.a(new vN(uuid2, uuid, vec3));
    }
}
