package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000mm.report.DominationMatchReportData;
import com.boehmod.bflib.cloud.common.p000mm.report.IMatchReportData;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.InterfaceC0978rl;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.rB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rB.class */
public final class C0942rB extends AbstractC0787oF<C0942rB, C0945rE, C1086tm<C0942rB, C0945rE>> implements InterfaceC0899qL, InterfaceC0900qM<C0942rB>, InterfaceC0901qN<C0945rE, C0943rC>, InterfaceC0902qO, InterfaceC0903qP, InterfaceC0905qR, InterfaceC0909qV, InterfaceC0912qY, InterfaceC0913qZ, InterfaceC0967ra, InterfaceC0968rb, InterfaceC0970rd, InterfaceC0971re, InterfaceC0973rg {

    /* JADX INFO: renamed from: iX */
    private static final Component f5009iX;

    /* JADX INFO: renamed from: iY */
    private static final Component f5010iY;

    /* JADX INFO: renamed from: iZ */
    private static final Component f5011iZ;

    /* JADX INFO: renamed from: ja */
    private static final Component f5012ja;

    /* JADX INFO: renamed from: lE */
    public static final float f5013lE = 2.0f;

    /* JADX INFO: renamed from: pJ */
    public static final int f5014pJ = 500;

    /* JADX INFO: renamed from: pK */
    public static final int f5015pK = 20;

    /* JADX INFO: renamed from: bi */
    @NotNull
    private final List<C0943rC> f5016bi;

    /* JADX INFO: renamed from: bj */
    @NotNull
    private final List<C0804oW> f5017bj;

    /* JADX INFO: renamed from: bk */
    @NotNull
    private final List<C0872pl> f5018bk;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C0709mh f5019b;

    /* JADX INFO: renamed from: c */
    @Nullable
    private C0709mh f5020c;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final C0597kb f5021d;

    /* JADX INFO: renamed from: pL */
    public int f5022pL;

    /* JADX INFO: renamed from: gP */
    static final /* synthetic */ boolean f5023gP;

    @Override // com.boehmod.blockfront.InterfaceC0901qN
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo4667a(@NotNull AbstractC0563ju abstractC0563ju, @NotNull Level level, @NotNull AbstractC0803oV abstractC0803oV, @NotNull String str, @NotNull String str2, @NotNull Set set) {
        m5168a((AbstractC0563ju<?, ?, ?>) abstractC0563ju, level, (C0943rC) abstractC0803oV, str, str2, (Set<UUID>) set);
    }

    static {
        f5023gP = !C0942rB.class.desiredAssertionStatus();
        f5009iX = Component.translatable("bf.popup.message.cpoint.defended").withStyle(ChatFormatting.GOLD);
        f5010iY = Component.translatable("bf.popup.message.crate").withStyle(ChatFormatting.YELLOW);
        f5011iZ = Component.translatable("bf.message.gamemode.switchteams.error.scores");
        f5012ja = Component.translatable("bf.message.gamemode.switchteams.error.scores");
    }

    public C0942rB(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        super(abstractC0563ju, "dom", "Domination");
        this.f5016bi = new ObjectArrayList();
        this.f5017bj = new ObjectArrayList();
        this.f5018bk = new ObjectArrayList();
        this.f5019b = null;
        this.f5020c = null;
        this.f5021d = new C0597kb().m2628a("cpoint", new C0597kb().m2628a("add", new C0597kb((commandContext, strArr) -> {
            ServerPlayer player = ((CommandSourceStack) commandContext.getSource()).getPlayer();
            CommandSource commandSource = ((CommandSourceStack) commandContext.getSource()).source;
            if (player == null) {
                return;
            }
            String str = strArr[0];
            this.f5016bi.add(new C0943rC((C0945rE) this.f4248a, player, str));
            C0645lW.m2898b(commandSource, Component.literal("Added capture point " + str + ". (" + this.f5016bi.size() + ")"));
        }).m2624a(C0599kd.m2635a(new String[]{"name"})).m2624a(C0599kd.f3307a)).m2628a("clear", new C0597kb((commandContext2, strArr2) -> {
            C0645lW.m2898b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Clearing all " + this.f5016bi.size() + " capture points."));
            this.f5016bi.clear();
        })).m2628a("move", new C0597kb((commandContext3, strArr3) -> {
            ServerPlayer player = ((CommandSourceStack) commandContext3.getSource()).getPlayer();
            CommandSource commandSource = ((CommandSourceStack) commandContext3.getSource()).source;
            if (player == null) {
                return;
            }
            String str = strArr3[0];
            for (C0943rC c0943rC : this.f5016bi) {
                if (c0943rC.f4399bP.equalsIgnoreCase(str)) {
                    c0943rC.m4129c(new C0805oX((Player) player));
                    C0645lW.m2898b(commandSource, Component.literal("Moved capture point " + str + "."));
                    return;
                }
            }
            C0645lW.m2898b(commandSource, Component.literal("Capture point " + str + " was not found!"));
        }).m2624a(C0599kd.m2635a(new String[]{"name"})).m2624a(C0599kd.f3307a).m2630a((commandContext4, strArr4) -> {
            if (strArr4.length == 0) {
                return this.f5016bi.stream().map(c0943rC -> {
                    return c0943rC.f4399bP;
                }).toList();
            }
            return List.of();
        })).m2628a("box", new C0597kb((commandContext5, strArr5) -> {
            String str;
            ServerPlayer player = ((CommandSourceStack) commandContext5.getSource()).getPlayer();
            CommandSource commandSource = ((CommandSourceStack) commandContext5.getSource()).source;
            if (player == null) {
                return;
            }
            String str2 = strArr5[0];
            for (C0943rC c0943rC : this.f5016bi) {
                if (c0943rC.f4399bP.equalsIgnoreCase(str2)) {
                    AABB aabbM1163j = this.f4249b.m1136a((Player) player).m1098b().m1163j();
                    c0943rC.f4408g = aabbM1163j;
                    if (aabbM1163j != null) {
                        str = "Set capture box for " + str2 + " from your selection.";
                    } else {
                        str = "No AABB selection; cleared capture box for " + str2 + " (using radius).";
                    }
                    C0645lW.m2898b(commandSource, Component.literal(str));
                    return;
                }
            }
            C0645lW.m2898b(commandSource, Component.literal("Capture point " + str2 + " was not found!"));
        }).m2624a(C0599kd.m2635a(new String[]{"name"})).m2624a(C0599kd.f3307a).m2630a((commandContext6, strArr6) -> {
            if (strArr6.length == 0) {
                return this.f5016bi.stream().map(c0943rC -> {
                    return c0943rC.f4399bP;
                }).toList();
            }
            return List.of();
        }))).m2628a("apoint", new C0597kb().m2628a("add", new C0597kb((commandContext7, strArr7) -> {
            this.f5017bj.add(new C0804oW(((CommandSourceStack) commandContext7.getSource()).source));
            C0645lW.m2898b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Added ammo point. (" + this.f5017bj.size() + ")"));
        }).m2624a(C0599kd.f3307a)).m2628a("clear", new C0597kb((commandContext8, strArr8) -> {
            C0645lW.m2898b(((CommandSourceStack) commandContext8.getSource()).source, Component.literal("Clearing all " + this.f5017bj.size() + " ammo points."));
            this.f5017bj.clear();
        }))).m2628a("vpoint", new C0597kb().m2628a("add", new C0597kb((commandContext9, strArr9) -> {
            String str = strArr9[0];
            String str2 = strArr9[1];
            this.f5018bk.add(new C0872pl(((CommandSourceStack) commandContext9.getSource()).source, str.equalsIgnoreCase("allies"), C1292xo.m7883b(str2)));
            C0645lW.m2898b(((CommandSourceStack) commandContext9.getSource()).source, Component.literal("Added " + str + " vehicle point (" + str2 + "). (" + this.f5018bk.size() + ")"));
        }).m2624a(C0599kd.m2635a(new String[]{"team", "entityType"})).m2624a(C0599kd.f3307a).m2630a((commandContext10, strArr10) -> {
            switch (strArr10.length) {
                case 0:
                    return List.of("allies", "axis");
                case 1:
                    return C1292xo.m7884i();
                default:
                    return List.of();
            }
        })).m2628a("clear", new C0597kb((commandContext11, strArr11) -> {
            C0645lW.m2898b(((CommandSourceStack) commandContext11.getSource()).source, Component.literal("Clearing all " + this.f5018bk.size() + " vehicle points."));
            this.f5018bk.clear();
        }))).m2628a("spawn", new C0597kb().m2628a("add", new C0597kb((commandContext12, strArr12) -> {
            String str = strArr12[0];
            C0805oX c0805oX = new C0805oX(((CommandSourceStack) commandContext12.getSource()).source);
            C0796oO c0796oOA = m3582b().m3806a(str);
            if (c0796oOA == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext12.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                c0796oOA.m3874b(c0805oX);
                C0645lW.m2898b(((CommandSourceStack) commandContext12.getSource()).source, Component.literal(c0796oOA.getName() + " team spawn added. (" + c0796oOA.m3873B().size() + ")"));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"team"})).m2624a(C0599kd.f3307a).m2630a((commandContext13, strArr13) -> {
            return strArr13.length == 0 ? m5152c() : List.of();
        })).m2628a("clear", new C0597kb((commandContext14, strArr14) -> {
            String str = strArr14[0];
            C0796oO c0796oOA = m3582b().m3806a(str);
            if (c0796oOA == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext14.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                c0796oOA.m3875ct();
                C0645lW.m2898b(((CommandSourceStack) commandContext14.getSource()).source, Component.literal(c0796oOA.getName() + " team's spawns cleared."));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"team"})).m2630a((commandContext15, strArr15) -> {
            return strArr15.length == 0 ? m5152c() : List.of();
        })));
        this.f5022pL = 0;
    }

    /* JADX INFO: renamed from: a */
    public static void m5149a(@NotNull C0942rB c0942rB, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull UUID uuid, boolean z) {
        if (C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) c0942rB, uuid, C1089tp.f5688e) != 0) {
            return;
        }
        C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) c0942rB, uuid, C1089tp.f5688e, 1);
        C0799oR.m3926a(uuid, C0431hU.m2020a().m2023c(EnumC1123uW.WARMUP));
        C0709mh c0709mhM5152c = c0942rB.m5152c();
        if (c0709mhM5152c != null) {
            C0714mm c0714mm = new C0714mm();
            if (z) {
                c0714mm.m3247B(true);
            }
            C0799oR.m3919a(abstractC0563ju, c0709mhM5152c, c0714mm, uuid);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0944rD mo3559a(@NotNull C0622l c0622l) {
        return new C0944rD(c0622l, this, (C0326fV) this.f4249b);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0945rE mo3560a() {
        return new C0945rE(this, this.f4249b);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1084tk<C0942rB, C0945rE> mo3563a() {
        return new C1083tj(C0948rH::new);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: g */
    public void mo3647g(@NotNull List<MutableComponent> list) {
        if (this.f5016bi.isEmpty()) {
            list.add(Component.literal("Capture points in game '" + this.f4236bE + "' are missing."));
        }
        if (this.f5019b == null) {
            list.add(Component.literal("Intro sequence in game '" + this.f4236bE + "' is missing."));
        }
        if (this.f5020c == null) {
            list.add(Component.literal("Outro sequence in game '" + this.f4236bE + "' is missing."));
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
        return new DominationMatchReportData(f5014pJ);
    }

    /* JADX INFO: renamed from: b */
    public void m5150b(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f5016bi.forEach(c0943rC -> {
            c0943rC.m4101a((AbstractC0563ju<?, ?, ?>) abstractC0563ju, (AbstractC0183c<?>) abstractC0183c, this, serverLevel, (Set<UUID>) set);
        });
        int i = this.f5022pL;
        this.f5022pL = i + 1;
        if (i > 3) {
            this.f5022pL = 0;
            Iterator<C0943rC> it = this.f5016bi.iterator();
            while (it.hasNext()) {
                C0796oO c0796oOD = it.next().m4097d();
                if (c0796oOD != null) {
                    c0796oOD.m3864a(C1089tp.f5695l, c0796oOD.m3866a(C1089tp.f5695l) + 1);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public boolean mo3597a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        C0796oO c0796oOB = ((C0945rE) this.f4248a).mo3805b();
        if (c0796oOB == null) {
            C0562jt.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((C0945rE) this.f4248a).m3776a(abstractC0563ju, enumC0800oS, serverLevel, serverPlayer, c0796oOB);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: d */
    public void mo3605d(@Nullable Level level) {
        m5151cI();
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3614a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.mo3614a(byteBuf, z);
        int size = this.f5016bi.size();
        byteBuf.writeInt(size);
        for (int i = 0; i < size; i++) {
            this.f5016bi.get(i).mo4111c(byteBuf);
        }
        int size2 = this.f5017bj.size();
        byteBuf.writeInt(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.f5017bj.get(i2).mo4111c(byteBuf);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: g */
    public void mo3616g(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo3616g(byteBuf);
        int i = byteBuf.readInt();
        if (this.f5016bi.isEmpty()) {
            for (int i2 = 0; i2 < i; i2++) {
                this.f5016bi.add(new C0943rC((C0945rE) this.f4248a, byteBuf));
            }
        } else {
            Iterator<C0943rC> it = this.f5016bi.iterator();
            while (it.hasNext()) {
                it.next().mo4110b(byteBuf);
            }
        }
        this.f5017bj.clear();
        int i3 = byteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            C0804oW c0804oW = new C0804oW();
            c0804oW.mo4110b(byteBuf);
            this.f5017bj.add(c0804oW);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0978rl mo3606a() {
        return new InterfaceC0978rl.b(mo4668O().stream().map(c0943rC -> {
            return new C0975ri(new C0805oX(c0943rC.f4424c.x, c0943rC.f4424c.y, c0943rC.f4424c.z, c0943rC.f4423h.x, c0943rC.f4423h.y), c0943rC.f4399bP, c0943rC.f4402d != null ? c0943rC.f4402d.getName() : "", c0943rC.f4403e != null ? c0943rC.f4403e.getName() : "", c0943rC.f4405nm, c0943rC.f4409gh, Optional.ofNullable(c0943rC.f4408g));
        }).toList(), List.copyOf(m5158ao()), List.copyOf(m5159ap()), Optional.ofNullable(m5152c()), Optional.ofNullable(m5153d()));
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3607a(@NotNull InterfaceC0978rl interfaceC0978rl) throws MatchException {
        if (interfaceC0978rl instanceof InterfaceC0978rl.b) {
            InterfaceC0978rl.b bVar = (InterfaceC0978rl.b) interfaceC0978rl;
            try {
                List<C0975ri> listM5356U = bVar.m5356U();
                List<C0804oW> listM5357V = bVar.m5357V();
                List<C0872pl> listM5358W = bVar.m5358W();
                Optional<C0709mh> optionalM5359g = bVar.m5359g();
                Optional<C0709mh> optionalM5360h = bVar.m5360h();
                this.f5016bi.clear();
                for (C0975ri c0975ri : listM5356U) {
                    C0943rC c0943rC = new C0943rC((C0945rE) this.f4248a);
                    c0943rC.f4424c = c0975ri.m5320e().f4424c;
                    c0943rC.f4423h = c0975ri.m5320e().f4423h;
                    c0943rC.f4399bP = c0975ri.m5321U();
                    c0943rC.f4405nm = c0975ri.m5324by();
                    c0943rC.f4409gh = c0975ri.m5325bD();
                    c0943rC.f4408g = c0975ri.m5326e().orElse(null);
                    this.f5016bi.add(c0943rC);
                }
                this.f5017bj.clear();
                this.f5017bj.addAll(listM5357V);
                this.f5018bk.clear();
                this.f5018bk.addAll(listM5358W);
                this.f5019b = optionalM5359g.orElse(null);
                this.f5020c = optionalM5360h.orElse(null);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }

    /* JADX INFO: renamed from: cI */
    public void m5151cI() {
        this.f5016bi.forEach((v0) -> {
            v0.m4118bf();
        });
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public C0709mh m5152c() {
        return this.f5019b;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public C0709mh m5153d() {
        return this.f5020c;
    }

    /* JADX INFO: renamed from: a */
    public void m5154a(@Nullable C0709mh c0709mh) {
        this.f5019b = c0709mh;
    }

    /* JADX INFO: renamed from: b */
    public void m5155b(@Nullable C0709mh c0709mh) {
        this.f5020c = c0709mh;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0943rC m5156a(@NotNull Player player, @NotNull Set<UUID> set) {
        for (C0943rC c0943rC : this.f5016bi) {
            if (c0943rC.m4133a(player.level(), c0943rC.m4098a(mo4666a(c0943rC)), set).contains(player)) {
                return c0943rC;
            }
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0943rC m5157a(@NotNull C0680mE c0680mE, @NotNull C0796oO c0796oO) {
        Vec3 vec3Position = c0680mE.position();
        C0943rC c0943rC = null;
        for (C0943rC c0943rC2 : this.f5016bi) {
            if (c0943rC2.mo4102c((LivingEntity) c0680mE) && (c0943rC == null || c0943rC2.f4424c.distanceTo(vec3Position) < c0943rC.f4424c.distanceTo(vec3Position))) {
                if (!c0796oO.equals(c0943rC2.m4097d())) {
                    c0943rC = c0943rC2;
                }
            }
        }
        return c0943rC;
    }

    @NotNull
    /* JADX INFO: renamed from: ao */
    public List<C0804oW> m5158ao() {
        return Collections.unmodifiableList(this.f5017bj);
    }

    @NotNull
    /* JADX INFO: renamed from: ap */
    public List<C0872pl> m5159ap() {
        return Collections.unmodifiableList(this.f5018bk);
    }

    /* JADX INFO: renamed from: g */
    public void m5160g(@NotNull ServerLevel serverLevel) {
        this.f5018bk.forEach(c0872pl -> {
            c0872pl.m4393a((AbstractC0787oF<?, ?, ?>) this, (Level) serverLevel);
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb mo3646a() {
        return super.mo3646a().m2623a(this.f5021d);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: f */
    public boolean mo3609f(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: aW */
    public int mo3617aW() {
        return 1;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: e */
    public boolean mo3608e(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: bd */
    public boolean mo3621bd() {
        return true;
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
        return CloudAchievements.ACH_MATCH_WIN_DOM;
    }

    @Override // com.boehmod.blockfront.InterfaceC0899qL
    /* JADX INFO: renamed from: e */
    public void mo4656e(@NotNull ServerLevel serverLevel) {
        C0799oR.m3922a(serverLevel, (AbstractC0787oF<?, ?, ?>) this, (AbstractC0790oI<?>) this.f4248a);
        C0796oO c0796oOA = ((C0945rE) this.f4248a).m3806a(C1089tp.f5730da);
        C0796oO c0796oOA2 = ((C0945rE) this.f4248a).m3806a(C1089tp.f5729cZ);
        if (!f5023gP && c0796oOA == null) {
            throw new AssertionError();
        }
        if (!f5023gP && c0796oOA2 == null) {
            throw new AssertionError();
        }
        int iMo4663b = mo4663b(c0796oOA2);
        int iMo4663b2 = mo4663b(c0796oOA);
        for (int i = 0; i < iMo4663b; i++) {
            C0799oR.m4063a((AbstractC0787oF<?, ?, ?>) this, serverLevel, c0796oOA2, true);
        }
        for (int i2 = 0; i2 < iMo4663b2; i2++) {
            C0799oR.m4063a((AbstractC0787oF<?, ?, ?>) this, serverLevel, c0796oOA, true);
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0899qL
    /* JADX INFO: renamed from: a */
    public void mo4657a(@NotNull C0680mE c0680mE, @NotNull Level level) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0899qL
    /* JADX INFO: renamed from: a */
    public void mo4658a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull C0680mE c0680mE, @NotNull DamageSource damageSource) {
        ServerPlayer serverPlayer;
        UUID uuid;
        C0796oO c0796oOA;
        C0796oO c0796oOM3046a = c0680mE.m3046a();
        if (c0796oOM3046a != null && c0680mE.m3071aJ()) {
            C0796oO c0796oOA2 = ((C0945rE) this.f4248a).m3806a(C1089tp.f5730da);
            C0796oO c0796oOA3 = ((C0945rE) this.f4248a).m3806a(C1089tp.f5729cZ);
            if (!f5023gP && c0796oOA2 == null) {
                throw new AssertionError();
            }
            if (!f5023gP && c0796oOA3 == null) {
                throw new AssertionError();
            }
            switch (c0796oOM3046a.getName()) {
                case "Allies":
                    C0799oR.m4063a((AbstractC0787oF<?, ?, ?>) this, serverLevel, c0796oOA3, true);
                    break;
                case "Axis":
                    C0799oR.m4063a((AbstractC0787oF<?, ?, ?>) this, serverLevel, c0796oOA2, true);
                    break;
            }
        }
        ServerPlayer entity = damageSource.getEntity();
        if ((entity instanceof ServerPlayer) && (c0796oOA = ((C0945rE) this.f4248a).m3793a((uuid = (serverPlayer = entity).getUUID()))) != null) {
            C0799oR.m4014a(abstractC0563ju, this, uuid, C1089tp.f5695l);
            for (C0943rC c0943rC : this.f5016bi) {
                if (c0943rC.m4099a((Entity) c0680mE, mo4666a(c0943rC)) && c0796oOA.equals(c0943rC.m4097d())) {
                    C0799oR.m3943a(serverPlayer, new C1010sQ(f5009iX, 40));
                    C0799oR.m4015a(abstractC0563ju, this, uuid, C1089tp.f5695l, 2);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0899qL
    /* JADX INFO: renamed from: a */
    public void mo4659a(@NotNull C0680mE c0680mE, @NotNull Player player) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0899qL
    /* JADX INFO: renamed from: a */
    public void mo4660a(@NotNull C0680mE c0680mE) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0899qL
    @Nullable
    /* JADX INFO: renamed from: a */
    public BlockPos mo4661a(@NotNull C0680mE c0680mE) {
        C0796oO c0796oOM3046a = c0680mE.m3046a();
        if (c0796oOM3046a == null) {
            return null;
        }
        C0943rC c0943rCM5157a = m5157a(c0680mE, c0796oOM3046a);
        if (c0943rCM5157a != null) {
            return c0943rCM5157a.m4096c();
        }
        C0796oO c0796oOA = ((C0945rE) this.f4248a).m3806a(c0796oOM3046a.m3880bp() ? C1089tp.f5730da : C1089tp.f5729cZ);
        if (c0796oOA != null) {
            return c0796oOA.m3863a((AbstractC0787oF<?, ?, ?>) this).m4150c();
        }
        return null;
    }

    @Override // com.boehmod.blockfront.InterfaceC0899qL
    /* JADX INFO: renamed from: a */
    public boolean mo4662a(@NotNull C0680mE c0680mE, @NotNull DamageSource damageSource) {
        C0680mE entity = damageSource.getEntity();
        if (entity instanceof C0680mE) {
            C0796oO c0796oOM3046a = entity.m3046a();
            return (c0796oOM3046a == null || c0796oOM3046a.equals(c0680mE.m3046a())) ? false : true;
        }
        Player entity2 = damageSource.getEntity();
        if (entity2 instanceof Player) {
            C0796oO c0796oOA = ((C0945rE) this.f4248a).m3793a(entity2.getUUID());
            return (c0796oOA == null || c0796oOA.equals(c0680mE.m3046a())) ? false : true;
        }
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0899qL
    /* JADX INFO: renamed from: b */
    public int mo4663b(@NotNull C0796oO c0796oO) {
        return 8;
    }

    @Override // com.boehmod.blockfront.InterfaceC0909qV
    /* JADX INFO: renamed from: i */
    public boolean mo4686i(@NotNull Player player) {
        return player.getHealth() > player.getMaxHealth() / 2.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0909qV
    /* JADX INFO: renamed from: a */
    public float mo4687a(@NotNull Player player) {
        return 0.5f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0909qV
    /* JADX INFO: renamed from: a */
    public int mo4688a(@NotNull Player player) {
        return 80;
    }

    @Override // com.boehmod.blockfront.InterfaceC0903qP
    /* JADX INFO: renamed from: a */
    public boolean mo4674a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull Level level, @NotNull ServerPlayer serverPlayer, @NotNull C0639lQ c0639lQ) {
        UUID uuid = serverPlayer.getUUID();
        ItemStack itemStackM2832a = c0639lQ.m2832a();
        if (itemStackM2832a.isEmpty()) {
            return false;
        }
        Item item = itemStackM2832a.getItem();
        if (!(item instanceof C1144ur)) {
            return false;
        }
        C1144ur c1144ur = (C1144ur) item;
        serverPlayer.getInventory().setItem(c1144ur.m6389cv() ? 0 : 1, itemStackM2832a);
        DeferredItem<? extends C1146ut> deferredItemM6327a = c1144ur.m6327a();
        if (deferredItemM6327a != null) {
            ItemStack itemStack = new ItemStack((ItemLike) deferredItemM6327a.get());
            serverPlayer.setItemSlot(serverPlayer.getEquipmentSlotForItem(itemStack), itemStack);
        }
        c0639lQ.m2833c(ItemStack.EMPTY);
        Vec3 vec3Position = serverPlayer.position();
        C0799oR.m3941a(level, vec3Position, (SoundEvent) C1280xc.f7588pT.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
        C0799oR.m3941a(level, vec3Position, SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 1.0f, 1.0f);
        C0799oR.m4015a(abstractC0563ju, this, uuid, C1089tp.f5695l, 2);
        C0799oR.m3943a(serverPlayer, new C1010sQ(f5010iY, 40));
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.boehmod.blockfront.ta] */
    @Override // com.boehmod.blockfront.InterfaceC0903qP
    /* JADX INFO: renamed from: a */
    public void mo4675a(@NotNull C0639lQ c0639lQ) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.addAll(mo3560a().m5976a().m5675aD());
        objectArrayList.addAll(m3582b().m5976a().m5675aD());
        Collections.shuffle(objectArrayList);
        c0639lQ.m2833c(new ItemStack((ItemLike) ((Supplier) objectArrayList.getFirst()).get()));
    }

    @Override // com.boehmod.blockfront.InterfaceC0903qP
    /* JADX INFO: renamed from: a */
    public int mo4676a(@NotNull C0639lQ c0639lQ) {
        return 3600;
    }

    @Override // com.boehmod.blockfront.InterfaceC0971re
    /* JADX INFO: renamed from: a */
    public Component mo5161a(@NotNull ServerPlayer serverPlayer) {
        C0796oO c0796oOA = ((C0945rE) this.f4248a).m3806a(C1089tp.f5730da);
        C0796oO c0796oOA2 = ((C0945rE) this.f4248a).m3806a(C1089tp.f5729cZ);
        if (!f5023gP && c0796oOA == null) {
            throw new AssertionError();
        }
        if (!f5023gP && c0796oOA2 == null) {
            throw new AssertionError();
        }
        Component component = null;
        if (c0796oOA.m3866a(C1089tp.f5695l) > 375.0d) {
            component = f5011iZ;
        }
        if (c0796oOA2.m3866a(C1089tp.f5695l) > 375.0d) {
            component = f5012ja;
        }
        if (component != null) {
            return component;
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

    @Override // com.boehmod.blockfront.InterfaceC0912qY
    /* JADX INFO: renamed from: bu */
    public int mo4697bu() {
        return 4;
    }

    @Override // com.boehmod.blockfront.InterfaceC0900qM
    /* JADX INFO: renamed from: a */
    public void mo4664a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull EnumC0807oZ enumC0807oZ) {
        m4665a(this, uuid, enumC0807oZ);
    }

    @Override // com.boehmod.blockfront.InterfaceC0901qN
    /* JADX INFO: renamed from: a */
    public int mo4666a(@NotNull C0943rC c0943rC) {
        return 3;
    }

    /* JADX INFO: renamed from: a */
    public void m5168a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull Level level, @NotNull C0943rC c0943rC, @NotNull String str, @NotNull String str2, @NotNull Set<UUID> set) {
        C0945rE c0945rEB = m3582b();
        C0796oO c0796oOA = c0945rEB.m3806a(str);
        if (!f5023gP && c0796oOA == null) {
            throw new AssertionError();
        }
        Set<UUID> setM3872h = c0796oOA.m3872h();
        C0796oO c0796oOA2 = c0945rEB.m3806a(str2);
        C0799oR.m3935a(setM3872h, (SoundEvent) C1280xc.f7618qx.get(), SoundSource.MUSIC, 1.0f);
        C0799oR.m3941a(level, c0943rC.f4424c, (SoundEvent) C1280xc.f7585pQ.get(), SoundSource.NEUTRAL, 2.0f, 1.0f);
        if (c0796oOA2 != null) {
            C0799oR.m3935a(c0796oOA2.m3872h(), (SoundEvent) C1280xc.f7619qy.get(), SoundSource.MUSIC, 1.0f);
        }
        C1074ta c1074taM3860a = c0796oOA.m3860a((AbstractC0787oF<?, ?, ?>) this);
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.notification.point.captured.team", new Object[]{Component.literal(c1074taM3860a.m5976a().getName()).withStyle(ChatFormatting.WHITE), Component.literal(c0943rC.f4399bP.toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.WHITE)}).withStyle(c0796oOA.m3876a());
        C0799oR.m3993a((AbstractC0790oI<?>) c0945rEB, c0796oOA, (Component) mutableComponentWithStyle, 80, AbstractC0803oV.f4393bO, c0943rC.f4424c, c0796oOA.getColor(), ColorReferences.COLOR_WHITE);
        for (C0796oO c0796oO : c0945rEB.m3808A()) {
            if (!c0796oO.equals(c0796oOA)) {
                C0799oR.m3993a((AbstractC0790oI<?>) c0945rEB, c0796oO, (Component) mutableComponentWithStyle, 80, AbstractC0803oV.f4393bO, c0943rC.f4424c, c0796oOA.getColor(), ColorReferences.COLOR_WHITE);
            }
        }
        Iterator<Player> it = c0943rC.m4133a(level, c0943rC.m4098a(mo4666a(c0943rC)), set).iterator();
        while (it.hasNext()) {
            UUID uuid = it.next().getUUID();
            C0799oR.m4015a(abstractC0563ju, this, uuid, C1089tp.f5695l, 3);
            C0799oR.m4014a(abstractC0563ju, this, uuid, C1089tp.f5700q);
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0901qN
    /* JADX INFO: renamed from: O */
    public List<C0943rC> mo4668O() {
        return Collections.unmodifiableList(this.f5016bi);
    }

    @Override // com.boehmod.blockfront.InterfaceC0973rg
    /* JADX INFO: renamed from: a */
    public boolean mo5169a(@NotNull Level level, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        return C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this, uuid, C1089tp.f5709z) > 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0973rg
    /* JADX INFO: renamed from: a */
    public void mo5170a(@NotNull Level level, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0973rg
    /* JADX INFO: renamed from: aT */
    public float mo5171aT() {
        return 32.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0905qR
    /* JADX INFO: renamed from: d */
    public boolean mo4678d(@NotNull ServerPlayer serverPlayer) {
        return this.f4235a == EnumC0795oN.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC0968rb
    /* JADX INFO: renamed from: a */
    public void mo5172a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerPlayer serverPlayer, @NotNull Vec3 vec3) {
        UUID uuid = serverPlayer.getUUID();
        C0796oO c0796oOA = ((C0945rE) this.f4248a).m3793a(uuid);
        if (c0796oOA == null) {
            return;
        }
        c0796oOA.m3888a(new C1165vL(uuid, UUID.randomUUID(), vec3));
    }

    @Override // com.boehmod.blockfront.InterfaceC0968rb
    /* JADX INFO: renamed from: a */
    public void mo5173a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull Vec3 vec3) {
        UUID uuid2 = serverPlayer.getUUID();
        C0796oO c0796oOA = ((C0945rE) this.f4248a).m3793a(uuid2);
        if (c0796oOA == null) {
            return;
        }
        c0796oOA.m3888a(new C1167vN(uuid2, uuid, vec3));
    }
}
