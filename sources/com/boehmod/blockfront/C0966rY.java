package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p001mm.report.DominationMatchReportData;
import com.boehmod.bflib.cloud.common.p001mm.report.IMatchReportData;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.rY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rY.class */
public final class C0966rY extends AbstractC0863pb<C0966rY, C1022sb, C1058tJ<C0966rY, C1022sb>> implements InterfaceC0942rA, InterfaceC0943rB, InterfaceC0945rD, InterfaceC0976ri, InterfaceC0977rj<C0966rY>, InterfaceC0978rk<C1022sb, C0967rZ>, InterfaceC0979rl, InterfaceC0980rm, InterfaceC0982ro, InterfaceC0986rs, InterfaceC0989rv, InterfaceC0990rw, InterfaceC0991rx, InterfaceC0992ry {

    /* JADX INFO: renamed from: jk */
    private static final Component f5361jk;

    /* JADX INFO: renamed from: jl */
    private static final Component f5362jl;

    /* JADX INFO: renamed from: jm */
    private static final Component f5363jm;

    /* JADX INFO: renamed from: jn */
    private static final Component f5364jn;

    /* JADX INFO: renamed from: mD */
    public static final float f5365mD = 2.0f;

    /* JADX INFO: renamed from: rI */
    public static final int f5366rI = 500;

    /* JADX INFO: renamed from: rJ */
    public static final int f5367rJ = 20;

    /* JADX INFO: renamed from: bp */
    @NotNull
    private final List<C0967rZ> f5368bp;

    /* JADX INFO: renamed from: bq */
    @NotNull
    private final List<C0880ps> f5369bq;

    /* JADX INFO: renamed from: br */
    @NotNull
    private final List<C0843pH> f5370br;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C0680mD f5371b;

    /* JADX INFO: renamed from: c */
    @Nullable
    private C0680mD f5372c;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final C0620kx f5373d;

    /* JADX INFO: renamed from: rK */
    public int f5374rK;

    /* JADX INFO: renamed from: hj */
    static final /* synthetic */ boolean f5375hj;

    @Override // com.boehmod.blockfront.InterfaceC0978rk
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo5357a(@NotNull AbstractC0531jN abstractC0531jN, @NotNull Level level, @NotNull AbstractC0879pr abstractC0879pr, @NotNull String str, @NotNull String str2, @NotNull Set set) {
        m5352a((AbstractC0531jN<?, ?, ?>) abstractC0531jN, level, (C0967rZ) abstractC0879pr, str, str2, (Set<UUID>) set);
    }

    static {
        f5375hj = !C0966rY.class.desiredAssertionStatus();
        f5361jk = Component.translatable("bf.popup.message.cpoint.defended").withStyle(ChatFormatting.GOLD);
        f5362jl = Component.translatable("bf.popup.message.crate").withStyle(ChatFormatting.YELLOW);
        f5363jm = Component.translatable("bf.message.gamemode.switchteams.error.scores");
        f5364jn = Component.translatable("bf.message.gamemode.switchteams.error.scores");
    }

    public C0966rY(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        super(abstractC0531jN, "dom", "Domination");
        this.f5368bp = new ObjectArrayList();
        this.f5369bq = new ObjectArrayList();
        this.f5370br = new ObjectArrayList();
        this.f5371b = null;
        this.f5372c = null;
        this.f5373d = new C0620kx().m2840a("cpoint", new C0620kx().m2840a("add", new C0620kx((commandContext, strArr) -> {
            ServerPlayer player = ((CommandSourceStack) commandContext.getSource()).getPlayer();
            CommandSource commandSource = ((CommandSourceStack) commandContext.getSource()).source;
            if (player == null) {
                return;
            }
            String str = strArr[0];
            this.f5368bp.add(new C0967rZ((C1022sb) this.f4642a, player, str));
            C0721ms.m3329b(commandSource, Component.literal("Added capture point " + str + ". (" + this.f5368bp.size() + ")"));
        }).m2836a(C0622kz.m2847a(new String[]{"name"})).m2836a(C0622kz.f3554a)).m2840a("clear", new C0620kx((commandContext2, strArr2) -> {
            C0721ms.m3329b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Clearing all " + this.f5368bp.size() + " capture points."));
            this.f5368bp.clear();
        })).m2840a("move", new C0620kx((commandContext3, strArr3) -> {
            ServerPlayer player = ((CommandSourceStack) commandContext3.getSource()).getPlayer();
            CommandSource commandSource = ((CommandSourceStack) commandContext3.getSource()).source;
            if (player == null) {
                return;
            }
            String str = strArr3[0];
            for (C0967rZ c0967rZ : this.f5368bp) {
                if (c0967rZ.f4796bZ.equalsIgnoreCase(str)) {
                    c0967rZ.m4566c(new C0881pt((Player) player));
                    C0721ms.m3329b(commandSource, Component.literal("Moved capture point " + str + "."));
                    return;
                }
            }
            C0721ms.m3329b(commandSource, Component.literal("Capture point " + str + " was not found!"));
        }).m2836a(C0622kz.m2847a(new String[]{"name"})).m2836a(C0622kz.f3554a).m2842a((commandContext4, strArr4) -> {
            if (strArr4.length == 0) {
                return this.f5368bp.stream().map(c0967rZ -> {
                    return c0967rZ.f4796bZ;
                }).toList();
            }
            return List.of();
        })).m2840a("box", new C0620kx((commandContext5, strArr5) -> {
            String str;
            ServerPlayer player = ((CommandSourceStack) commandContext5.getSource()).getPlayer();
            CommandSource commandSource = ((CommandSourceStack) commandContext5.getSource()).source;
            if (player == null) {
                return;
            }
            String str2 = strArr5[0];
            for (C0967rZ c0967rZ : this.f5368bp) {
                if (c0967rZ.f4796bZ.equalsIgnoreCase(str2)) {
                    AABB aabbM1180j = this.f4643b.m1153a((Player) player).m1115b().m1180j();
                    c0967rZ.f4810g = aabbM1180j;
                    if (aabbM1180j != null) {
                        str = "Set capture box for " + str2 + " from your selection.";
                    } else {
                        str = "No AABB selection; cleared capture box for " + str2 + " (using radius).";
                    }
                    C0721ms.m3329b(commandSource, Component.literal(str));
                    return;
                }
            }
            C0721ms.m3329b(commandSource, Component.literal("Capture point " + str2 + " was not found!"));
        }).m2836a(C0622kz.m2847a(new String[]{"name"})).m2836a(C0622kz.f3554a).m2842a((commandContext6, strArr6) -> {
            if (strArr6.length == 0) {
                return this.f5368bp.stream().map(c0967rZ -> {
                    return c0967rZ.f4796bZ;
                }).toList();
            }
            return List.of();
        }))).m2840a("apoint", new C0620kx().m2840a("add", new C0620kx((commandContext7, strArr7) -> {
            this.f5369bq.add(new C0880ps(((CommandSourceStack) commandContext7.getSource()).source));
            C0721ms.m3329b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Added ammo point. (" + this.f5369bq.size() + ")"));
        }).m2836a(C0622kz.f3554a)).m2840a("clear", new C0620kx((commandContext8, strArr8) -> {
            C0721ms.m3329b(((CommandSourceStack) commandContext8.getSource()).source, Component.literal("Clearing all " + this.f5369bq.size() + " ammo points."));
            this.f5369bq.clear();
        }))).m2840a("vpoint", new C0620kx().m2840a("add", new C0620kx((commandContext9, strArr9) -> {
            String str = strArr9[0];
            String str2 = strArr9[1];
            this.f5370br.add(new C0843pH(((CommandSourceStack) commandContext9.getSource()).source, str.equalsIgnoreCase("allies"), C1272xL.m7210b(str2)));
            C0721ms.m3329b(((CommandSourceStack) commandContext9.getSource()).source, Component.literal("Added " + str + " vehicle point (" + str2 + "). (" + this.f5370br.size() + ")"));
        }).m2836a(C0622kz.m2847a(new String[]{"team", "entityType"})).m2836a(C0622kz.f3554a).m2842a((commandContext10, strArr10) -> {
            switch (strArr10.length) {
                case 0:
                    return List.of("allies", "axis");
                case 1:
                    return C1272xL.m7211i();
                default:
                    return List.of();
            }
        })).m2840a("clear", new C0620kx((commandContext11, strArr11) -> {
            C0721ms.m3329b(((CommandSourceStack) commandContext11.getSource()).source, Component.literal("Clearing all " + this.f5370br.size() + " vehicle points."));
            this.f5370br.clear();
        }))).m2840a("spawn", new C0620kx().m2840a("add", new C0620kx((commandContext12, strArr12) -> {
            String str = strArr12[0];
            C0881pt c0881pt = new C0881pt(((CommandSourceStack) commandContext12.getSource()).source);
            C0872pk c0872pkA = m4018b().m4242a(str);
            if (c0872pkA == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext12.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                c0872pkA.m4310b(c0881pt);
                C0721ms.m3329b(((CommandSourceStack) commandContext12.getSource()).source, Component.literal(c0872pkA.getName() + " team spawn added. (" + c0872pkA.m4309D().size() + ")"));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"team"})).m2836a(C0622kz.f3554a).m2842a((commandContext13, strArr13) -> {
            return strArr13.length == 0 ? m5323c() : List.of();
        })).m2840a("clear", new C0620kx((commandContext14, strArr14) -> {
            String str = strArr14[0];
            C0872pk c0872pkA = m4018b().m4242a(str);
            if (c0872pkA == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext14.getSource()).source, Component.literal("Team " + str + " was not found!"));
            } else {
                c0872pkA.m4311cF();
                C0721ms.m3329b(((CommandSourceStack) commandContext14.getSource()).source, Component.literal(c0872pkA.getName() + " team's spawns cleared."));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"team"})).m2842a((commandContext15, strArr15) -> {
            return strArr15.length == 0 ? m5323c() : List.of();
        })));
        this.f5374rK = 0;
    }

    /* JADX INFO: renamed from: a */
    public static void m5320a(@NotNull C0966rY c0966rY, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull UUID uuid, boolean z) {
        if (C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) c0966rY, uuid, C1062tN.f5741e) != 0) {
            return;
        }
        C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) c0966rY, uuid, C1062tN.f5741e, 1);
        C0875pn.m4362a(uuid, C0502il.m2254a().m2257c(EnumC1203vw.WARMUP));
        C0680mD c0680mDM5323c = c0966rY.m5323c();
        if (c0680mDM5323c != null) {
            C0685mI c0685mI = new C0685mI();
            if (z) {
                c0685mI.m3080B(true);
            }
            C0875pn.m4355a(abstractC0531jN, c0680mDM5323c, c0685mI, uuid);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1021sa mo3995a(@NotNull C0623l c0623l) {
        return new C1021sa(c0623l, this, (C0396gl) this.f4643b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1022sb mo3996a() {
        return new C1022sb(this, this.f4643b);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1056tH<C0966rY, C1022sb> mo3999a() {
        return new C1055tG(C1025se::new);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: h */
    public void mo4083h(@NotNull List<MutableComponent> list) {
        if (this.f5368bp.isEmpty()) {
            list.add(Component.literal("Capture points in game '" + this.f4630bN + "' are missing."));
        }
        if (this.f5371b == null) {
            list.add(Component.literal("Intro sequence in game '" + this.f4630bN + "' is missing."));
        }
        if (this.f5372c == null) {
            list.add(Component.literal("Outro sequence in game '" + this.f4630bN + "' is missing."));
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
        return new DominationMatchReportData(f5366rI);
    }

    /* JADX INFO: renamed from: b */
    public void m5321b(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f5368bp.forEach(c0967rZ -> {
            c0967rZ.m4537a((AbstractC0531jN<?, ?, ?>) abstractC0531jN, (AbstractC0184c<?>) abstractC0184c, this, serverLevel, (Set<UUID>) set);
        });
        int i = this.f5374rK;
        this.f5374rK = i + 1;
        if (i > 3) {
            this.f5374rK = 0;
            Iterator<C0967rZ> it = this.f5368bp.iterator();
            while (it.hasNext()) {
                C0872pk c0872pkD = it.next().m4533d();
                if (c0872pkD != null) {
                    c0872pkD.m4300a(C1062tN.f5748l, c0872pkD.m4302a(C1062tN.f5748l) + 1);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public boolean mo4033a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull EnumC0876po enumC0876po, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        C0872pk c0872pkB = ((C1022sb) this.f4642a).mo4241b();
        if (c0872pkB == null) {
            C0530jM.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((C1022sb) this.f4642a).m4212a(abstractC0531jN, enumC0876po, serverLevel, serverPlayer, c0872pkB);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: d */
    public void mo4041d(@Nullable Level level) {
        m5322cU();
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4050a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.mo4050a(byteBuf, z);
        int size = this.f5368bp.size();
        byteBuf.writeInt(size);
        for (int i = 0; i < size; i++) {
            this.f5368bp.get(i).mo3870c(byteBuf);
        }
        int size2 = this.f5369bq.size();
        byteBuf.writeInt(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.f5369bq.get(i2).mo3870c(byteBuf);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: g */
    public void mo4052g(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo4052g(byteBuf);
        int i = byteBuf.readInt();
        if (this.f5368bp.isEmpty()) {
            for (int i2 = 0; i2 < i; i2++) {
                this.f5368bp.add(new C0967rZ((C1022sb) this.f4642a, byteBuf));
            }
        } else {
            Iterator<C0967rZ> it = this.f5368bp.iterator();
            while (it.hasNext()) {
                it.next().mo3869b(byteBuf);
            }
        }
        this.f5369bq.clear();
        int i3 = byteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            C0880ps c0880ps = new C0880ps();
            c0880ps.mo3869b(byteBuf);
            this.f5369bq.add(c0880ps);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0950rI mo4042a() {
        return new InterfaceC0950rI.b(mo5353Q().stream().map(c0967rZ -> {
            return new C0947rF(new C0881pt(c0967rZ.f4827c.x, c0967rZ.f4827c.y, c0967rZ.f4827c.z, c0967rZ.f4826h.x, c0967rZ.f4826h.y), c0967rZ.f4796bZ, c0967rZ.f4803d != null ? c0967rZ.f4803d.getName() : "", c0967rZ.f4804e != null ? c0967rZ.f4804e.getName() : "", c0967rZ.f4807pl, c0967rZ.f4811gB, Optional.ofNullable(c0967rZ.f4810g));
        }).toList(), List.copyOf(m5329aq()), List.copyOf(m5330ar()), Optional.ofNullable(m5323c()), Optional.ofNullable(m5324d()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4043a(@NotNull InterfaceC0950rI interfaceC0950rI) throws MatchException {
        if (interfaceC0950rI instanceof InterfaceC0950rI.b) {
            InterfaceC0950rI.b bVar = (InterfaceC0950rI.b) interfaceC0950rI;
            try {
                List<C0947rF> listM5232W = bVar.m5232W();
                List<C0880ps> listM5233X = bVar.m5233X();
                List<C0843pH> listM5234Y = bVar.m5234Y();
                Optional<C0680mD> optionalM5235g = bVar.m5235g();
                Optional<C0680mD> optionalM5236h = bVar.m5236h();
                this.f5368bp.clear();
                for (C0947rF c0947rF : listM5232W) {
                    C0967rZ c0967rZ = new C0967rZ((C1022sb) this.f4642a);
                    c0967rZ.f4827c = c0947rF.m5196e().f4827c;
                    c0967rZ.f4826h = c0947rF.m5196e().f4826h;
                    c0967rZ.f4796bZ = c0947rF.m5197ab();
                    c0967rZ.f4807pl = c0947rF.m5200bN();
                    c0967rZ.f4811gB = c0947rF.m5201bN();
                    c0967rZ.f4810g = c0947rF.m5202e().orElse(null);
                    this.f5368bp.add(c0967rZ);
                }
                this.f5369bq.clear();
                this.f5369bq.addAll(listM5233X);
                this.f5370br.clear();
                this.f5370br.addAll(listM5234Y);
                this.f5371b = optionalM5235g.orElse(null);
                this.f5372c = optionalM5236h.orElse(null);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }

    /* JADX INFO: renamed from: cU */
    public void m5322cU() {
        this.f5368bp.forEach((v0) -> {
            v0.m4556bd();
        });
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public C0680mD m5323c() {
        return this.f5371b;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public C0680mD m5324d() {
        return this.f5372c;
    }

    /* JADX INFO: renamed from: a */
    public void m5325a(@Nullable C0680mD c0680mD) {
        this.f5371b = c0680mD;
    }

    /* JADX INFO: renamed from: b */
    public void m5326b(@Nullable C0680mD c0680mD) {
        this.f5372c = c0680mD;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0967rZ m5327a(@NotNull Player player, @NotNull Set<UUID> set) {
        for (C0967rZ c0967rZ : this.f5368bp) {
            if (c0967rZ.m4570a(player.level(), c0967rZ.m4534a(mo5358a(c0967rZ)), set).contains(player)) {
                return c0967rZ;
            }
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0967rZ m5328a(@NotNull C0756na c0756na, @NotNull C0872pk c0872pk) {
        Vec3 vec3Position = c0756na.position();
        C0967rZ c0967rZ = null;
        for (C0967rZ c0967rZ2 : this.f5368bp) {
            if (c0967rZ2.mo4538c((LivingEntity) c0756na) && (c0967rZ == null || c0967rZ2.f4827c.distanceTo(vec3Position) < c0967rZ.f4827c.distanceTo(vec3Position))) {
                if (!c0872pk.equals(c0967rZ2.m4533d())) {
                    c0967rZ = c0967rZ2;
                }
            }
        }
        return c0967rZ;
    }

    @NotNull
    /* JADX INFO: renamed from: aq */
    public List<C0880ps> m5329aq() {
        return Collections.unmodifiableList(this.f5369bq);
    }

    @NotNull
    /* JADX INFO: renamed from: ar */
    public List<C0843pH> m5330ar() {
        return Collections.unmodifiableList(this.f5370br);
    }

    /* JADX INFO: renamed from: g */
    public void m5331g(@NotNull ServerLevel serverLevel) {
        this.f5370br.forEach(c0843pH -> {
            c0843pH.m3881a((AbstractC0863pb<?, ?, ?>) this, (Level) serverLevel);
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx mo4082a() {
        return super.mo4082a().m2835a(this.f5373d);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: f */
    public boolean mo4045f(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bl */
    public int mo4053bl() {
        return 1;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: e */
    public boolean mo4044e(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bn */
    public boolean mo4057bn() {
        return true;
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
        return CloudAchievements.ACH_MATCH_WIN_DOM;
    }

    @Override // com.boehmod.blockfront.InterfaceC0976ri
    /* JADX INFO: renamed from: e */
    public void mo5332e(@NotNull ServerLevel serverLevel) {
        C0875pn.m4358a(serverLevel, (AbstractC0863pb<?, ?, ?>) this, (AbstractC0866pe<?>) this.f4642a);
        C0872pk c0872pkA = ((C1022sb) this.f4642a).m4242a(C1062tN.f5783dl);
        C0872pk c0872pkA2 = ((C1022sb) this.f4642a).m4242a(C1062tN.f5782dk);
        if (!f5375hj && c0872pkA == null) {
            throw new AssertionError();
        }
        if (!f5375hj && c0872pkA2 == null) {
            throw new AssertionError();
        }
        int iMo5339b = mo5339b(c0872pkA2);
        int iMo5339b2 = mo5339b(c0872pkA);
        for (int i = 0; i < iMo5339b; i++) {
            C0875pn.m4499a((AbstractC0863pb<?, ?, ?>) this, serverLevel, c0872pkA2, true);
        }
        for (int i2 = 0; i2 < iMo5339b2; i2++) {
            C0875pn.m4499a((AbstractC0863pb<?, ?, ?>) this, serverLevel, c0872pkA, true);
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0976ri
    /* JADX INFO: renamed from: a */
    public void mo5333a(@NotNull C0756na c0756na, @NotNull Level level) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0976ri
    /* JADX INFO: renamed from: a */
    public void mo5334a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull C0756na c0756na, @NotNull DamageSource damageSource) {
        ServerPlayer serverPlayer;
        UUID uuid;
        C0872pk c0872pkA;
        C0872pk c0872pkM3553a = c0756na.m3553a();
        if (c0872pkM3553a != null && c0756na.m3578aT()) {
            C0872pk c0872pkA2 = ((C1022sb) this.f4642a).m4242a(C1062tN.f5783dl);
            C0872pk c0872pkA3 = ((C1022sb) this.f4642a).m4242a(C1062tN.f5782dk);
            if (!f5375hj && c0872pkA2 == null) {
                throw new AssertionError();
            }
            if (!f5375hj && c0872pkA3 == null) {
                throw new AssertionError();
            }
            switch (c0872pkM3553a.getName()) {
                case "Allies":
                    C0875pn.m4499a((AbstractC0863pb<?, ?, ?>) this, serverLevel, c0872pkA3, true);
                    break;
                case "Axis":
                    C0875pn.m4499a((AbstractC0863pb<?, ?, ?>) this, serverLevel, c0872pkA2, true);
                    break;
            }
        }
        ServerPlayer entity = damageSource.getEntity();
        if ((entity instanceof ServerPlayer) && (c0872pkA = ((C1022sb) this.f4642a).m4229a((uuid = (serverPlayer = entity).getUUID()))) != null) {
            C0875pn.m4450a(abstractC0531jN, this, uuid, C1062tN.f5748l);
            for (C0967rZ c0967rZ : this.f5368bp) {
                if (c0967rZ.m4535a((Entity) c0756na, mo5358a(c0967rZ)) && c0872pkA.equals(c0967rZ.m4533d())) {
                    C0875pn.m4379a(serverPlayer, new C1088tn(f5361jk, 40));
                    C0875pn.m4451a(abstractC0531jN, this, uuid, C1062tN.f5748l, 2);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0976ri
    /* JADX INFO: renamed from: a */
    public void mo5335a(@NotNull C0756na c0756na, @NotNull Player player) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0976ri
    /* JADX INFO: renamed from: a */
    public void mo5336a(@NotNull C0756na c0756na) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0976ri
    @Nullable
    /* JADX INFO: renamed from: a */
    public BlockPos mo5337a(@NotNull C0756na c0756na) {
        C0872pk c0872pkM3553a = c0756na.m3553a();
        if (c0872pkM3553a == null) {
            return null;
        }
        C0967rZ c0967rZM5328a = m5328a(c0756na, c0872pkM3553a);
        if (c0967rZM5328a != null) {
            return c0967rZM5328a.mo4542c();
        }
        C0872pk c0872pkA = ((C1022sb) this.f4642a).m4242a(c0872pkM3553a.m4316bz() ? C1062tN.f5783dl : C1062tN.f5782dk);
        if (c0872pkA != null) {
            return c0872pkA.m4299a((AbstractC0863pb<?, ?, ?>) this).m4587c();
        }
        return null;
    }

    @Override // com.boehmod.blockfront.InterfaceC0976ri
    /* JADX INFO: renamed from: a */
    public boolean mo5338a(@NotNull C0756na c0756na, @NotNull DamageSource damageSource) {
        C0756na entity = damageSource.getEntity();
        if (entity instanceof C0756na) {
            C0872pk c0872pkM3553a = entity.m3553a();
            return (c0872pkM3553a == null || c0872pkM3553a.equals(c0756na.m3553a())) ? false : true;
        }
        Player entity2 = damageSource.getEntity();
        if (entity2 instanceof Player) {
            C0872pk c0872pkA = ((C1022sb) this.f4642a).m4229a(entity2.getUUID());
            return (c0872pkA == null || c0872pkA.equals(c0756na.m3553a())) ? false : true;
        }
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0976ri
    /* JADX INFO: renamed from: b */
    public int mo5339b(@NotNull C0872pk c0872pk) {
        return 8;
    }

    @Override // com.boehmod.blockfront.InterfaceC0986rs
    /* JADX INFO: renamed from: i */
    public boolean mo5301i(@NotNull Player player) {
        return player.getHealth() > player.getMaxHealth() / 2.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0986rs
    /* JADX INFO: renamed from: a */
    public float mo5302a(@NotNull Player player) {
        return 0.5f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0986rs
    /* JADX INFO: renamed from: a */
    public int mo5303a(@NotNull Player player) {
        return 80;
    }

    @Override // com.boehmod.blockfront.InterfaceC0980rm
    /* JADX INFO: renamed from: a */
    public boolean mo5340a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull Level level, @NotNull ServerPlayer serverPlayer, @NotNull C0715mm c0715mm) {
        UUID uuid = serverPlayer.getUUID();
        ItemStack itemStackM3263c = c0715mm.m3263c();
        if (itemStackM3263c.isEmpty()) {
            return false;
        }
        Item item = itemStackM3263c.getItem();
        if (!(item instanceof C1117uP)) {
            return false;
        }
        C1117uP c1117uP = (C1117uP) item;
        serverPlayer.getInventory().setItem(c1117uP.m6364cE() ? 0 : 1, itemStackM3263c);
        DeferredItem<? extends C1119uR> deferredItemM6294a = c1117uP.m6294a();
        if (deferredItemM6294a != null) {
            ItemStack itemStack = new ItemStack((ItemLike) deferredItemM6294a.get());
            serverPlayer.setItemSlot(serverPlayer.getEquipmentSlotForItem(itemStack), itemStack);
        }
        c0715mm.m3264c(ItemStack.EMPTY);
        Vec3 vec3Position = serverPlayer.position();
        C0875pn.m4377a(level, vec3Position, (SoundEvent) C1312xz.f8000pV.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
        C0875pn.m4377a(level, vec3Position, SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 1.0f, 1.0f);
        C0875pn.m4451a(abstractC0531jN, this, uuid, C1062tN.f5748l, 2);
        C0875pn.m4379a(serverPlayer, new C1088tn(f5362jl, 40));
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.boehmod.blockfront.tx] */
    @Override // com.boehmod.blockfront.InterfaceC0980rm
    /* JADX INFO: renamed from: a */
    public void mo5341a(@NotNull C0715mm c0715mm) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.addAll(mo3996a().m6179a().m6163aF());
        objectArrayList.addAll(m4018b().m6179a().m6163aF());
        Collections.shuffle(objectArrayList);
        c0715mm.m3264c(new ItemStack((ItemLike) ((Supplier) objectArrayList.getFirst()).get()));
    }

    @Override // com.boehmod.blockfront.InterfaceC0980rm
    /* JADX INFO: renamed from: a */
    public int mo5342a(@NotNull C0715mm c0715mm) {
        return 3600;
    }

    @Override // com.boehmod.blockfront.InterfaceC0943rB
    /* JADX INFO: renamed from: a */
    public Component mo5178a(@NotNull ServerPlayer serverPlayer) {
        C0872pk c0872pkA = ((C1022sb) this.f4642a).m4242a(C1062tN.f5783dl);
        C0872pk c0872pkA2 = ((C1022sb) this.f4642a).m4242a(C1062tN.f5782dk);
        if (!f5375hj && c0872pkA == null) {
            throw new AssertionError();
        }
        if (!f5375hj && c0872pkA2 == null) {
            throw new AssertionError();
        }
        Component component = null;
        if (c0872pkA.m4302a(C1062tN.f5748l) > 375.0d) {
            component = f5363jm;
        }
        if (c0872pkA2.m4302a(C1062tN.f5748l) > 375.0d) {
            component = f5364jn;
        }
        if (component != null) {
            return component;
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

    @Override // com.boehmod.blockfront.InterfaceC0989rv
    /* JADX INFO: renamed from: bJ */
    public int mo5349bJ() {
        return 4;
    }

    @Override // com.boehmod.blockfront.InterfaceC0977rj
    /* JADX INFO: renamed from: a */
    public void mo5350a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull EnumC0883pv enumC0883pv) {
        m5551a(this, uuid, enumC0883pv);
    }

    @Override // com.boehmod.blockfront.InterfaceC0978rk
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int mo5358a(@NotNull C0967rZ c0967rZ) {
        return 3;
    }

    /* JADX INFO: renamed from: a */
    public void m5352a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull Level level, @NotNull C0967rZ c0967rZ, @NotNull String str, @NotNull String str2, @NotNull Set<UUID> set) {
        C1022sb c1022sbB = m4018b();
        C0872pk c0872pkA = c1022sbB.m4242a(str);
        if (!f5375hj && c0872pkA == null) {
            throw new AssertionError();
        }
        Set<UUID> setM4308h = c0872pkA.m4308h();
        C0872pk c0872pkA2 = c1022sbB.m4242a(str2);
        C0875pn.m4371a(setM4308h, (SoundEvent) C1312xz.f8030qz.get(), SoundSource.MUSIC, 1.0f);
        C0875pn.m4377a(level, c0967rZ.f4827c, (SoundEvent) C1312xz.f7997pS.get(), SoundSource.NEUTRAL, 2.0f, 1.0f);
        if (c0872pkA2 != null) {
            C0875pn.m4371a(c0872pkA2.m4308h(), (SoundEvent) C1312xz.f8031qA.get(), SoundSource.MUSIC, 1.0f);
        }
        C1098tx c1098txM4296a = c0872pkA.m4296a((AbstractC0863pb<?, ?, ?>) this);
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.notification.point.captured.team", new Object[]{Component.literal(c1098txM4296a.m6179a().getName()).withStyle(ChatFormatting.WHITE), Component.literal(c0967rZ.f4796bZ.toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.WHITE)}).withStyle(c0872pkA.m4312a());
        C0875pn.m4429a((AbstractC0866pe<?>) c1022sbB, c0872pkA, (Component) mutableComponentWithStyle, 80, AbstractC0879pr.f4790bY, c0967rZ.f4827c, c0872pkA.getColor(), ColorReferences.COLOR_WHITE);
        for (C0872pk c0872pk : c1022sbB.m4244C()) {
            if (!c0872pk.equals(c0872pkA)) {
                C0875pn.m4429a((AbstractC0866pe<?>) c1022sbB, c0872pk, (Component) mutableComponentWithStyle, 80, AbstractC0879pr.f4790bY, c0967rZ.f4827c, c0872pkA.getColor(), ColorReferences.COLOR_WHITE);
            }
        }
        Iterator<Player> it = c0967rZ.m4570a(level, c0967rZ.m4534a(mo5358a(c0967rZ)), set).iterator();
        while (it.hasNext()) {
            UUID uuid = it.next().getUUID();
            C0875pn.m4451a(abstractC0531jN, this, uuid, C1062tN.f5748l, 3);
            C0875pn.m4450a(abstractC0531jN, this, uuid, C1062tN.f5753q);
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0978rk
    /* JADX INFO: renamed from: Q */
    public List<C0967rZ> mo5353Q() {
        return Collections.unmodifiableList(this.f5368bp);
    }

    @Override // com.boehmod.blockfront.InterfaceC0945rD
    /* JADX INFO: renamed from: a */
    public boolean mo5184a(@NotNull Level level, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        return C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this, uuid, C1062tN.f5762z) > 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0945rD
    /* JADX INFO: renamed from: a */
    public void mo5185a(@NotNull Level level, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0945rD
    /* JADX INFO: renamed from: aZ */
    public float mo5186aZ() {
        return 32.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0982ro
    /* JADX INFO: renamed from: e */
    public boolean mo5354e(@NotNull ServerPlayer serverPlayer) {
        return this.f4629a == EnumC0871pj.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC0992ry
    /* JADX INFO: renamed from: a */
    public void mo5355a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerPlayer serverPlayer, @NotNull Vec3 vec3) {
        UUID uuid = serverPlayer.getUUID();
        C0872pk c0872pkA = ((C1022sb) this.f4642a).m4229a(uuid);
        if (c0872pkA == null) {
            return;
        }
        c0872pkA.m4324a(new C1244wk(uuid, UUID.randomUUID(), vec3));
    }

    @Override // com.boehmod.blockfront.InterfaceC0992ry
    /* JADX INFO: renamed from: a */
    public void mo5356a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull Vec3 vec3) {
        UUID uuid2 = serverPlayer.getUUID();
        C0872pk c0872pkA = ((C1022sb) this.f4642a).m4229a(uuid2);
        if (c0872pkA == null) {
            return;
        }
        c0872pkA.m4324a(new C1246wm(uuid2, uuid, vec3));
    }
}
