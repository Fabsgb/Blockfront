package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000mm.report.IMatchReportData;
import com.boehmod.bflib.cloud.common.p000mm.report.OffensiveMatchReportData;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.InterfaceC0978rl;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
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
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sj.class */
public final class C1030sj extends AbstractC0787oF<C1030sj, C1034sn, C1086tm<C1030sj, C1034sn>> implements InterfaceC0900qM, InterfaceC0901qN<C1034sn, C1031sk>, InterfaceC0902qO, InterfaceC0903qP, InterfaceC0905qR, InterfaceC0909qV, InterfaceC0913qZ, InterfaceC0967ra, InterfaceC0970rd, InterfaceC0971re {

    /* JADX INFO: renamed from: qm */
    public static final int f5443qm = 8;

    /* JADX INFO: renamed from: qn */
    public static final int f5444qn = 4;

    /* JADX INFO: renamed from: qo */
    public static final int f5445qo = 2;

    /* JADX INFO: renamed from: qp */
    public static final int f5446qp = 400;

    /* JADX INFO: renamed from: qq */
    public static final int f5447qq = 15;

    /* JADX INFO: renamed from: qr */
    public static final int f5448qr = 15;

    /* JADX INFO: renamed from: lF */
    public static final float f5449lF = 0.35f;

    /* JADX INFO: renamed from: lG */
    public static final float f5450lG = 0.5f;

    /* JADX INFO: renamed from: qs */
    public static final int f5451qs = 200;

    /* JADX INFO: renamed from: qt */
    public static final int f5452qt = 5;

    /* JADX INFO: renamed from: qu */
    public static final int f5453qu = 3;

    /* JADX INFO: renamed from: qv */
    private static final int f5454qv = 20;

    /* JADX INFO: renamed from: qw */
    public static final int f5455qw = 10;

    /* JADX INFO: renamed from: qx */
    public static final int f5456qx = 200;

    /* JADX INFO: renamed from: qy */
    public static final int f5457qy = 400;

    /* JADX INFO: renamed from: lH */
    private static final float f5458lH = 30.0f;

    /* JADX INFO: renamed from: ju */
    @NotNull
    private static final Component f5459ju;

    /* JADX INFO: renamed from: u */
    @NotNull
    private static final MutableComponent f5460u;

    /* JADX INFO: renamed from: v */
    @NotNull
    private static final MutableComponent f5461v;

    /* JADX INFO: renamed from: bv */
    @NotNull
    private final List<C1033sm> f5462bv;

    /* JADX INFO: renamed from: bw */
    @NotNull
    private final List<C1031sk> f5463bw;

    /* JADX INFO: renamed from: cz */
    @NotNull
    private String f5464cz;

    /* JADX INFO: renamed from: qz */
    private int f5465qz;

    /* JADX INFO: renamed from: qA */
    private int f5466qA;

    /* JADX INFO: renamed from: qB */
    private int f5467qB;

    /* JADX INFO: renamed from: qC */
    private int f5468qC;

    /* JADX INFO: renamed from: qD */
    private int f5469qD;

    /* JADX INFO: renamed from: gZ */
    private boolean f5470gZ;

    /* JADX INFO: renamed from: qE */
    private int f5471qE;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final Object2IntMap<UUID> f5472h;

    /* JADX INFO: renamed from: ha */
    private boolean f5473ha;

    /* JADX INFO: renamed from: qF */
    private int f5474qF;

    /* JADX INFO: renamed from: qG */
    private int f5475qG;

    /* JADX INFO: renamed from: qH */
    private int f5476qH;

    /* JADX INFO: renamed from: qI */
    private int f5477qI;

    /* JADX INFO: renamed from: qJ */
    private int f5478qJ;

    /* JADX INFO: renamed from: qK */
    private int f5479qK;

    /* JADX INFO: renamed from: qL */
    private int f5480qL;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C0709mh f5481b;

    /* JADX INFO: renamed from: c */
    @Nullable
    private C0709mh f5482c;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final C0597kb f5483h;

    /* JADX INFO: renamed from: hb */
    static final /* synthetic */ boolean f5484hb;

    @Override // com.boehmod.blockfront.InterfaceC0901qN
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo4667a(@NotNull AbstractC0563ju abstractC0563ju, @NotNull Level level, @NotNull AbstractC0803oV abstractC0803oV, @NotNull String str, @NotNull String str2, @NotNull Set set) {
        m5769a((AbstractC0563ju<?, ?, ?>) abstractC0563ju, level, (C1031sk) abstractC0803oV, str, str2, (Set<UUID>) set);
    }

    static {
        f5484hb = !C1030sj.class.desiredAssertionStatus();
        f5459ju = Component.translatable("bf.popup.message.crate").withStyle(ChatFormatting.YELLOW);
        f5460u = Component.translatable("bf.message.gamemode.of.rally.reinforced.reinforcements").withColor(ColorReferences.COLOR_THEME_YELLOW);
        f5461v = Component.translatable("bf.message.gamemode.of.rally.reinforced", new Object[]{f5460u}).withColor(ColorReferences.COLOR_WHITE);
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    private Collection<String> m5724g() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator<C1033sm> it = this.f5462bv.iterator();
        while (it.hasNext()) {
            objectArrayList.add(it.next().f5511a.f4399bP);
        }
        return objectArrayList;
    }

    public C1030sj(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        super(abstractC0563ju, "of", "Offensive");
        this.f5462bv = new ObjectArrayList();
        this.f5463bw = new ObjectArrayList();
        this.f5464cz = C1089tp.f5729cZ;
        this.f5465qz = 0;
        this.f5466qA = 8;
        this.f5467qB = 1;
        this.f5468qC = 0;
        this.f5469qD = 0;
        this.f5470gZ = false;
        this.f5471qE = 0;
        this.f5472h = new Object2IntOpenHashMap();
        this.f5473ha = false;
        this.f5474qF = 0;
        this.f5475qG = 0;
        this.f5476qH = 0;
        this.f5477qI = -1;
        this.f5478qJ = -1;
        this.f5479qK = -1;
        this.f5480qL = -1;
        this.f5481b = null;
        this.f5482c = null;
        this.f5483h = new C0597kb().m2628a("obj", new C0597kb().m2628a("add", new C0597kb((commandContext, strArr) -> {
            Player player = ((CommandSourceStack) commandContext.getSource()).source;
            String str = strArr[0];
            this.f5462bv.add(new C1033sm(new C1031sk((C1034sn) this.f4248a, player, str)));
            m5762cR();
            C0645lW.m2898b(((CommandSourceStack) commandContext.getSource()).source, Component.literal("Added objective " + str + ". (" + this.f5462bv.size() + ")"));
        }).m2624a(C0599kd.m2635a(new String[]{"title"})).m2624a(C0599kd.f3307a)).m2628a("move", new C0597kb((commandContext2, strArr2) -> {
            Player player = ((CommandSourceStack) commandContext2.getSource()).source;
            String str = strArr2[0];
            C1033sm c1033smM5761a = m5761a(str);
            if (c1033smM5761a == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Objective " + str + " was not found!"));
            } else {
                c1033smM5761a.f5511a.m4129c(new C0805oX(player));
                C0645lW.m2898b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Moved objective " + str + "."));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"title"})).m2624a(C0599kd.f3307a).m2630a((commandContext3, strArr3) -> {
            return strArr3.length == 0 ? m5724g() : List.of();
        })).m2628a("clear", new C0597kb((commandContext4, strArr4) -> {
            C0645lW.m2898b(((CommandSourceStack) commandContext4.getSource()).source, Component.literal("Clearing all " + this.f5462bv.size() + " objectives."));
            this.f5462bv.clear();
            m5762cR();
        })).m2628a("box", new C0597kb((commandContext5, strArr5) -> {
            String str;
            Player player = ((CommandSourceStack) commandContext5.getSource()).source;
            String str2 = strArr5[0];
            C1033sm c1033smM5761a = m5761a(str2);
            if (c1033smM5761a == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext5.getSource()).source, Component.literal("Objective " + str2 + " was not found!"));
                return;
            }
            AABB aabbM1163j = this.f4249b.m1136a(player).m1098b().m1163j();
            c1033smM5761a.f5511a.f4408g = aabbM1163j;
            CommandSource commandSource = ((CommandSourceStack) commandContext5.getSource()).source;
            if (aabbM1163j != null) {
                str = "Set capture box for " + str2 + " from your selection.";
            } else {
                str = "No AABB selection; cleared capture box for " + str2 + " (using radius).";
            }
            C0645lW.m2898b(commandSource, Component.literal(str));
        }).m2624a(C0599kd.m2635a(new String[]{"title"})).m2624a(C0599kd.f3307a).m2630a((commandContext6, strArr6) -> {
            return strArr6.length == 0 ? m5724g() : List.of();
        }))).m2628a("spawn", new C0597kb((commandContext7, strArr7) -> {
            Player player = ((CommandSourceStack) commandContext7.getSource()).source;
            String str = strArr7[0];
            String str2 = strArr7[1];
            C1033sm c1033smM5761a = m5761a(str);
            if (c1033smM5761a == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Objective " + str + " was not found!"));
                return;
            }
            C0805oX c0805oX = new C0805oX(player);
            if (str2.equalsIgnoreCase("attacker")) {
                c1033smM5761a.f5512bx.add(c0805oX);
                C0645lW.m2898b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Added attacker spawn to " + str + ". (" + c1033smM5761a.f5512bx.size() + ")"));
            } else if (str2.equalsIgnoreCase("defender")) {
                c1033smM5761a.f5513by.add(c0805oX);
                C0645lW.m2898b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Added defender spawn to " + str + ". (" + c1033smM5761a.f5513by.size() + ")"));
            } else {
                C0645lW.m2898b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Role must be 'attacker' or 'defender'."));
                return;
            }
            m5727cO();
        }).m2624a(C0599kd.m2635a(new String[]{"title", "role"})).m2624a(C0599kd.f3307a).m2630a((commandContext8, strArr8) -> {
            switch (strArr8.length) {
                case 0:
                    return m5724g();
                case 1:
                    return List.of("attacker", "defender");
                default:
                    return List.of();
            }
        })).m2628a("regroup", new C0597kb((commandContext9, strArr9) -> {
            Player player = ((CommandSourceStack) commandContext9.getSource()).source;
            String str = strArr9[0];
            C1033sm c1033smM5761a = m5761a(str);
            if (c1033smM5761a == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext9.getSource()).source, Component.literal("Objective " + str + " was not found!"));
            } else {
                c1033smM5761a.f5514i = new C0805oX(player);
                C0645lW.m2898b(((CommandSourceStack) commandContext9.getSource()).source, Component.literal("Set regroup point for " + str + "."));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"title"})).m2624a(C0599kd.f3307a).m2630a((commandContext10, strArr10) -> {
            return strArr10.length == 0 ? m5724g() : List.of();
        })).m2628a("boundary", new C0597kb().m2628a("set", new C0597kb((commandContext11, strArr11) -> {
            Player player = ((CommandSourceStack) commandContext11.getSource()).source;
            String str = strArr11[0];
            String str2 = strArr11[1];
            C1033sm c1033smM5761a = m5761a(str);
            if (c1033smM5761a == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext11.getSource()).source, Component.literal("Objective " + str + " was not found!"));
                return;
            }
            C0806oY c0806oYM1166c = this.f4249b.m1136a(player).m1098b().m1166c();
            if (c0806oYM1166c == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext11.getSource()).source, Component.literal("No region selection! Select an area with the region wand first."));
                return;
            }
            if (str2.equalsIgnoreCase("attacker")) {
                c1033smM5761a.f5515c = c0806oYM1166c;
            } else if (str2.equalsIgnoreCase("defender")) {
                c1033smM5761a.f5516d = c0806oYM1166c;
            } else {
                C0645lW.m2898b(((CommandSourceStack) commandContext11.getSource()).source, Component.literal("Side must be 'attacker' or 'defender'."));
                return;
            }
            C0645lW.m2898b(((CommandSourceStack) commandContext11.getSource()).source, Component.literal("Set " + str2 + " boundary for " + str + " from your selection. (" + c0806oYM1166c.m4162be() + " points)"));
        }).m2624a(C0599kd.m2635a(new String[]{"title", "side"})).m2624a(C0599kd.f3307a).m2630a((commandContext12, strArr12) -> {
            switch (strArr12.length) {
                case 0:
                    return m5724g();
                case 1:
                    return List.of("attacker", "defender");
                default:
                    return List.of();
            }
        })).m2628a("clear", new C0597kb((commandContext13, strArr13) -> {
            String str = strArr13[0];
            String str2 = strArr13[1];
            C1033sm c1033smM5761a = m5761a(str);
            if (c1033smM5761a == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext13.getSource()).source, Component.literal("Objective " + str + " was not found!"));
                return;
            }
            if (str2.equalsIgnoreCase("attacker")) {
                c1033smM5761a.f5515c = new C0806oY();
            } else if (str2.equalsIgnoreCase("defender")) {
                c1033smM5761a.f5516d = new C0806oY();
            } else {
                C0645lW.m2898b(((CommandSourceStack) commandContext13.getSource()).source, Component.literal("Side must be 'attacker' or 'defender'."));
                return;
            }
            C0645lW.m2898b(((CommandSourceStack) commandContext13.getSource()).source, Component.literal("Cleared " + str2 + " boundary for " + str + "."));
        }).m2624a(C0599kd.m2635a(new String[]{"title", "side"})).m2630a((commandContext14, strArr14) -> {
            switch (strArr14.length) {
                case 0:
                    return m5724g();
                case 1:
                    return List.of("attacker", "defender");
                default:
                    return List.of();
            }
        }))).m2628a("attacker", new C0597kb((commandContext15, strArr15) -> {
            String str = strArr15[0].equalsIgnoreCase("axis") ? C1089tp.f5730da : C1089tp.f5729cZ;
            this.f5464cz = str;
            m5726cN();
            C0645lW.m2898b(((CommandSourceStack) commandContext15.getSource()).source, Component.literal("Attacking team set to " + str + "."));
        }).m2624a(C0599kd.m2635a(new String[]{"team"})).m2630a((commandContext16, strArr16) -> {
            return strArr16.length == 0 ? List.of("allies", "axis") : List.of();
        }));
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1032sl mo3559a(@NotNull C0622l c0622l) {
        return new C1032sl(c0622l, this, (C0326fV) this.f4249b);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1034sn mo3560a() {
        return new C1034sn(this, this.f4249b);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1084tk<C1030sj, C1034sn> mo3563a() {
        return new C1083tj(C1039ss::new);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3570a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f4250a.m5995b(abstractC0563ju, abstractC0183c, serverLevel);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: d */
    public void mo3605d(@Nullable Level level) {
        this.f5477qI = -1;
        this.f5478qJ = -1;
        this.f5479qK = -1;
        this.f5480qL = -1;
        m5725F(1);
    }

    /* JADX INFO: renamed from: F */
    public void m5725F(int i) {
        this.f5467qB = i;
        this.f5466qA = 4;
        this.f5468qC = 0;
        this.f5469qD = 0;
        this.f5470gZ = false;
        this.f5473ha = false;
        this.f5474qF = 0;
        this.f5475qG = 0;
        this.f5476qH = 0;
        this.f5471qE = 0;
        this.f5472h.clear();
        m5726cN();
    }

    /* JADX INFO: renamed from: cN */
    private void m5726cN() {
        this.f5465qz = 0;
        C0796oO c0796oOM5750g = m5750g();
        Iterator<C1033sm> it = this.f5462bv.iterator();
        while (it.hasNext()) {
            C1031sk c1031sk = it.next().f5511a;
            c1031sk.m4118bf();
            c1031sk.f4402d = c0796oOM5750g;
        }
        m5727cO();
    }

    /* JADX INFO: renamed from: cO */
    private void m5727cO() {
        C1033sm c1033smM5751a = m5751a();
        C0796oO c0796oOM5749f = m5749f();
        C0796oO c0796oOM5750g = m5750g();
        if (c0796oOM5749f != null) {
            c0796oOM5749f.m3875ct();
            if (c1033smM5751a != null) {
                List<C0805oX> list = c1033smM5751a.f5512bx;
                Objects.requireNonNull(c0796oOM5749f);
                list.forEach(c0796oOM5749f::m3874b);
            }
        }
        if (c0796oOM5750g != null) {
            c0796oOM5750g.m3875ct();
            if (c1033smM5751a != null) {
                List<C0805oX> list2 = c1033smM5751a.f5513by;
                Objects.requireNonNull(c0796oOM5750g);
                list2.forEach(c0796oOM5750g::m3874b);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m5728c(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        if (this.f5471qE > 0) {
            this.f5471qE = Math.max(0, this.f5471qE - 20);
            if (this.f5471qE == 0) {
                m5729i(serverLevel);
            }
        }
        C1033sm c1033smM5751a = m5751a();
        if (c1033smM5751a == null) {
            return;
        }
        c1033smM5751a.f5511a.m4101a(abstractC0563ju, abstractC0183c, this, serverLevel, set);
        m5731a(abstractC0563ju, abstractC0183c, serverLevel);
        C1033sm c1033smM5751a2 = m5751a();
        if (c1033smM5751a2 != null) {
            m5732a(abstractC0563ju, abstractC0183c, serverLevel, set, c1033smM5751a2);
        }
    }

    /* JADX INFO: renamed from: i */
    public void m5729i(@NotNull ServerLevel serverLevel) {
        m5730a(serverLevel, m5749f());
    }

    /* JADX INFO: renamed from: a */
    private void m5730a(@NotNull ServerLevel serverLevel, @Nullable C0796oO c0796oO) {
        if (c0796oO == null) {
            return;
        }
        List<C0805oX> listM3873B = c0796oO.m3873B();
        if (listM3873B.isEmpty()) {
            return;
        }
        BlockPos blockPosM4150c = ((C0805oX) listM3873B.getFirst()).m4150c();
        serverLevel.playSound((Player) null, blockPosM4150c, (SoundEvent) C1280xc.f8464GL.get(), SoundSource.AMBIENT, f5458lH, 1.0f);
        serverLevel.playSound((Player) null, blockPosM4150c, (SoundEvent) C1280xc.f8463GK.get(), SoundSource.AMBIENT, f5458lH, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    private void m5731a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel) {
        int iM3884aZ;
        C0796oO c0796oOM5749f = m5749f();
        if (c0796oOM5749f == null || (iM3884aZ = c0796oOM5749f.m3884aZ()) == 0) {
            return;
        }
        float fM5738c = (iM3884aZ - m5738c(c0796oOM5749f)) / iM3884aZ;
        if (this.f5466qA > 0 && fM5738c >= 0.35f) {
            this.f5468qC += 20;
            if (this.f5468qC >= 400) {
                this.f5468qC = 0;
                this.f5474qF = 0;
                this.f5466qA--;
                Iterator<ServerPlayer> it = m5736a(abstractC0563ju, abstractC0183c, serverLevel, c0796oOM5749f).iterator();
                while (it.hasNext()) {
                    C0799oR.m3929a(it.next(), (SoundEvent) C1280xc.f7578pJ.get(), SoundSource.MUSIC, 1.5f, 1.0f);
                }
                C0799oR.m3991a((AbstractC0790oI<?>) this.f4248a, c0796oOM5749f, (Component) Component.translatable("bf.message.gamemode.of.waves.deployed").withStyle(ChatFormatting.WHITE), 60, "of.waves");
                return;
            }
            this.f5474qF = Math.max(1, (400 - this.f5468qC) / 20);
            return;
        }
        this.f5468qC = 0;
        this.f5474qF = 0;
    }

    /* JADX INFO: renamed from: a */
    private void m5732a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @NotNull C1033sm c1033sm) {
        C0796oO c0796oOM5750g = m5750g();
        if (c0796oOM5750g == null) {
            return;
        }
        int iM3884aZ = c0796oOM5750g.m3884aZ();
        if (iM3884aZ == 0) {
            this.f5470gZ = false;
            return;
        }
        int iM5738c = m5738c(c0796oOM5750g);
        int i = iM3884aZ - iM5738c;
        float f = i / iM3884aZ;
        boolean z = this.f5470gZ;
        this.f5470gZ = i > 0 && f >= 0.5f;
        if (!z && this.f5470gZ) {
            C0799oR.m3925a(c0796oOM5750g.m3872h(), C0431hU.m2020a().m2024d(EnumC1123uW.OFFENSIVE_REINFORCEMENTS_HINT));
            this.f5473ha = true;
        }
        if (!this.f5470gZ) {
            this.f5469qD = 0;
            this.f5475qG = 0;
            return;
        }
        if (iM5738c == 0) {
            this.f5469qD += 20;
            if (this.f5469qD >= 200) {
                this.f5469qD = 0;
                this.f5475qG = 0;
                m5733a(abstractC0563ju, abstractC0183c, serverLevel, c0796oOM5750g);
                return;
            }
            this.f5475qG = Math.max(1, (200 - this.f5469qD) / 20);
            return;
        }
        this.f5469qD = 0;
        this.f5475qG = 0;
        if (m5735a(serverLevel, c0796oOM5750g, c1033sm.f5514i, set)) {
            m5733a(abstractC0563ju, abstractC0183c, serverLevel, c0796oOM5750g);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5733a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull C0796oO c0796oO) {
        List<ServerPlayer> listM5736a = m5736a(abstractC0563ju, abstractC0183c, serverLevel, c0796oO);
        this.f5470gZ = false;
        Iterator<ServerPlayer> it = listM5736a.iterator();
        while (it.hasNext()) {
            C0799oR.m3941a((Level) serverLevel, it.next().position(), (SoundEvent) C1280xc.f7588pT.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
        }
        C0799oR.m3925a(c0796oO.m3872h(), C0431hU.m2020a().m2022b(EnumC1123uW.OFFENSIVE_REINFORCEMENTS_ARRIVE));
        this.f5473ha = false;
        C0799oR.m3991a((AbstractC0790oI<?>) this.f4248a, c0796oO, (Component) f5461v, 60, "of.rally");
    }

    /* JADX INFO: renamed from: cP */
    public void m5734cP() {
        if (this.f5473ha) {
            this.f5473ha = false;
            C0796oO c0796oOM5750g = m5750g();
            if (c0796oOM5750g != null) {
                C0799oR.m3925a(c0796oOM5750g.m3872h(), C0431hU.m2020a().m2022b(EnumC1123uW.CONCLUDE_GENERIC));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m5735a(@NotNull ServerLevel serverLevel, @NotNull C0796oO c0796oO, @NotNull C0805oX c0805oX, @NotNull Set<UUID> set) {
        for (ServerPlayer serverPlayer : c0805oX.m4134a(serverLevel, 5, set)) {
            UUID uuid = serverPlayer.getUUID();
            if (c0796oO.m3879i(uuid) && !C0799oR.m4052a((Player) serverPlayer, (AbstractC0182b<?, ?, ?, ?>) this.f4249b.m1135b(uuid))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private List<ServerPlayer> m5736a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull C0796oO c0796oO) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (UUID uuid : c0796oO.m3872h()) {
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(uuid);
            if (serverPlayerM3963a != null && C0799oR.m4052a((Player) serverPlayerM3963a, (AbstractC0182b<?, ?, ?, ?>) abstractC0183c.m1135b(uuid))) {
                C0799oR.m4031a(abstractC0563ju, abstractC0183c, serverLevel, serverPlayerM3963a);
                objectArrayList.add(serverPlayerM3963a);
            }
        }
        C1033sm c1033smM5751a = m5751a();
        if (!objectArrayList.isEmpty() && c1033smM5751a != null) {
            C0796oO c0796oOM5749f = m5749f();
            List<C0805oX> list = c0796oOM5749f != null && c0796oOM5749f.equals(c0796oO) ? c1033smM5751a.f5512bx : c1033smM5751a.f5513by;
            if (!list.isEmpty()) {
                C1014sU c1014sUM5676a = c0796oO.m3860a((AbstractC0787oF<?, ?, ?>) this).m5976a().m5676a();
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderM5503d = c1014sUM5676a != null ? c1014sUM5676a.m5503d() : null;
                if (deferredHolderM5503d != null) {
                    serverLevel.playSound((Player) null, ((C0805oX) list.getFirst()).m4150c(), (SoundEvent) deferredHolderM5503d.get(), SoundSource.PLAYERS, 5.0f, 1.0f);
                }
            }
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: a */
    private void m5737a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull C0796oO c0796oO) {
        m5736a(abstractC0563ju, this.f4249b, serverLevel, c0796oO);
        this.f5470gZ = false;
        this.f5469qD = 0;
        this.f5475qG = 0;
    }

    /* JADX INFO: renamed from: c */
    private int m5738c(@NotNull C0796oO c0796oO) {
        int i = 0;
        for (UUID uuid : c0796oO.m3872h()) {
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(uuid);
            if (serverPlayerM3963a != null && !C0799oR.m4052a((Player) serverPlayerM3963a, (AbstractC0182b<?, ?, ?, ?>) this.f4249b.m1135b(uuid))) {
                i++;
            }
        }
        return i;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0806oY m5739a(@NotNull C0796oO c0796oO) {
        C1033sm c1033smM5751a = m5751a();
        if (c1033smM5751a == null) {
            return null;
        }
        C0796oO c0796oOM5749f = m5749f();
        return (c0796oOM5749f == null || !c0796oOM5749f.equals(c0796oO)) ? c1033smM5751a.f5516d : c1033smM5751a.f5515c;
    }

    /* JADX INFO: renamed from: bM */
    public boolean m5740bM() {
        return this.f5471qE > 0;
    }

    /* JADX INFO: renamed from: bE */
    public int m5741bE() {
        if (this.f5471qE <= 0) {
            return 0;
        }
        return Math.max(1, this.f5471qE / 20);
    }

    /* JADX INFO: renamed from: h */
    public void m5742h(@NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        AbstractC0182b abstractC0182bM1135b = this.f4249b.m1135b(uuid);
        if (this.f4235a != EnumC0795oN.GAME || m5740bM() || C0799oR.m4052a((Player) serverPlayer, (AbstractC0182b<?, ?, ?, ?>) abstractC0182bM1135b) || abstractC0182bM1135b.m1099q() != null || ((C1034sn) this.f4248a).m3811g(uuid)) {
            this.f5472h.removeInt(uuid);
            return;
        }
        C0796oO c0796oOA = ((C1034sn) this.f4248a).m3793a(uuid);
        C0806oY c0806oYM5739a = c0796oOA != null ? m5739a(c0796oOA) : null;
        if (c0806oYM5739a == null || c0806oYM5739a.m4171bu() || c0806oYM5739a.m4167a((float) serverPlayer.getX(), (float) serverPlayer.getZ())) {
            this.f5472h.removeInt(uuid);
            return;
        }
        int orDefault = this.f5472h.getOrDefault(uuid, 200) - 1;
        if (orDefault <= 0) {
            this.f5472h.removeInt(uuid);
            serverPlayer.kill();
        } else {
            this.f5472h.put(uuid, orDefault);
        }
    }

    /* JADX INFO: renamed from: bN */
    public boolean m5743bN() {
        if (!this.f5462bv.isEmpty() && this.f5465qz >= this.f5462bv.size()) {
            return true;
        }
        C0796oO c0796oOM5749f = m5749f();
        return c0796oOM5749f != null && this.f5466qA <= 0 && m5738c(c0796oOM5749f) == 0;
    }

    /* JADX INFO: renamed from: bO */
    public boolean m5744bO() {
        return !this.f5462bv.isEmpty() && this.f5465qz >= this.f5462bv.size();
    }

    /* JADX INFO: renamed from: cQ */
    public void m5745cQ() {
        int iMin = Math.min(this.f5465qz, this.f5462bv.size());
        int iMax = Math.max(this.f5466qA, 0);
        if (this.f5467qB == 1) {
            this.f5477qI = iMin;
            this.f5478qJ = iMax;
        } else {
            this.f5479qK = iMin;
            this.f5480qL = iMax;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5746a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull AbstractC0183c<?> abstractC0183c) {
        C0796oO c0796oOA = ((C1034sn) this.f4248a).m3806a(C1089tp.f5729cZ);
        C0796oO c0796oOA2 = ((C1034sn) this.f4248a).m3806a(C1089tp.f5730da);
        if (c0796oOA == null || c0796oOA2 == null) {
            return;
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(c0796oOA.m3872h());
        ObjectArrayList objectArrayList2 = new ObjectArrayList(c0796oOA2.m3872h());
        c0796oOA.m3871cs();
        c0796oOA2.m3871cs();
        Iterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            c0796oOA2.m3869h((UUID) it.next());
        }
        Iterator it2 = objectArrayList2.iterator();
        while (it2.hasNext()) {
            c0796oOA.m3869h((UUID) it2.next());
        }
        mo3561e().clear();
        c0796oOA.m3864a(C1089tp.f5706w, 0);
        c0796oOA.m3864a(C1089tp.f5707x, 0);
        c0796oOA2.m3864a(C1089tp.f5706w, 0);
        c0796oOA2.m3864a(C1089tp.f5707x, 0);
        m5725F(2);
        m5747a(serverLevel, abstractC0183c);
    }

    /* JADX INFO: renamed from: a */
    public void m5747a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0183c<?> abstractC0183c) {
        C0796oO c0796oOA;
        for (UUID uuid : ((C1034sn) this.f4248a).m3809h()) {
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(uuid);
            if (serverPlayerM3963a != null && (c0796oOA = ((C1034sn) this.f4248a).m3793a(uuid)) != null) {
                C0799oR.m3948a(abstractC0183c, serverLevel, serverPlayerM3963a);
                C0799oR.m3966a(abstractC0183c, serverPlayerM3963a, c0796oOA.m3863a((AbstractC0787oF<?, ?, ?>) this));
                C0799oR.m4038a(serverLevel, serverPlayerM3963a, this, c0796oOA);
                C0799oR.m4026f(serverPlayerM3963a);
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0864pd m5748a() {
        if (this.f5477qI < 0 || this.f5479qK < 0) {
            return null;
        }
        C0796oO c0796oOM5749f = m5749f();
        C0796oO c0796oOM5750g = m5750g();
        if (this.f5479qK != this.f5477qI) {
            return new C0864pd(this.f5479qK > this.f5477qI ? c0796oOM5749f : c0796oOM5750g, null);
        }
        if (this.f5480qL != this.f5478qJ) {
            return new C0864pd(this.f5480qL > this.f5478qJ ? c0796oOM5749f : c0796oOM5750g, null);
        }
        return new C0864pd(null, null);
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public C0796oO m5749f() {
        return ((C1034sn) this.f4248a).m3806a(this.f5464cz);
    }

    @Nullable
    /* JADX INFO: renamed from: g */
    public C0796oO m5750g() {
        C0796oO c0796oOM5749f = m5749f();
        if (c0796oOM5749f == null) {
            return null;
        }
        return c0796oOM5749f.m3880bp() ? ((C1034sn) this.f4248a).m3806a(C1089tp.f5730da) : ((C1034sn) this.f4248a).m3806a(C1089tp.f5729cZ);
    }

    @Override // com.boehmod.blockfront.InterfaceC0971re
    /* JADX INFO: renamed from: a */
    public Component mo5161a(@NotNull ServerPlayer serverPlayer) {
        C0796oO c0796oOA = ((C1034sn) this.f4248a).m3806a(C1089tp.f5730da);
        C0796oO c0796oOA2 = ((C1034sn) this.f4248a).m3806a(C1089tp.f5729cZ);
        if (!f5484hb && c0796oOA == null) {
            throw new AssertionError();
        }
        if (f5484hb || c0796oOA2 != null) {
            return m3643a((Player) serverPlayer, c0796oOA.m3884aZ(), c0796oOA2.m3884aZ());
        }
        throw new AssertionError();
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

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1033sm m5751a() {
        if (this.f5465qz >= 0 && this.f5465qz < this.f5462bv.size()) {
            return this.f5462bv.get(this.f5465qz);
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: au */
    public List<C1033sm> m5752au() {
        return Collections.unmodifiableList(this.f5462bv);
    }

    /* JADX INFO: renamed from: bF */
    public int m5753bF() {
        return this.f5465qz;
    }

    /* JADX INFO: renamed from: bG */
    public int m5754bG() {
        return this.f5466qA;
    }

    /* JADX INFO: renamed from: bH */
    public int m5755bH() {
        return this.f5467qB;
    }

    /* JADX INFO: renamed from: bP */
    public boolean m5756bP() {
        return this.f5470gZ;
    }

    /* JADX INFO: renamed from: bI */
    public int m5757bI() {
        return this.f5474qF;
    }

    /* JADX INFO: renamed from: bJ */
    public int m5758bJ() {
        return this.f5475qG;
    }

    /* JADX INFO: renamed from: bK */
    public int m5759bK() {
        return this.f5476qH;
    }

    /* JADX INFO: renamed from: G */
    public void m5760G(int i) {
        this.f5476qH = i;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private C1033sm m5761a(@NotNull String str) {
        for (C1033sm c1033sm : this.f5462bv) {
            if (c1033sm.f5511a.f4399bP != null && c1033sm.f5511a.f4399bP.equalsIgnoreCase(str)) {
                return c1033sm;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: cR */
    private void m5762cR() {
        m5763cS();
        m5726cN();
    }

    /* JADX INFO: renamed from: cS */
    private void m5763cS() {
        this.f5463bw.clear();
        Iterator<C1033sm> it = this.f5462bv.iterator();
        while (it.hasNext()) {
            this.f5463bw.add(it.next().f5511a);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5764a(@Nullable C0709mh c0709mh) {
        this.f5481b = c0709mh;
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public C0709mh m5765c() {
        return this.f5481b;
    }

    /* JADX INFO: renamed from: b */
    public void m5766b(@Nullable C0709mh c0709mh) {
        this.f5482c = c0709mh;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public C0709mh m5767d() {
        return this.f5482c;
    }

    @Override // com.boehmod.blockfront.InterfaceC0901qN
    /* JADX INFO: renamed from: a */
    public int mo4666a(@NotNull C1031sk c1031sk) {
        return 3;
    }

    @Override // com.boehmod.blockfront.InterfaceC0901qN
    /* JADX INFO: renamed from: O */
    public List<C1031sk> mo4668O() {
        return Collections.unmodifiableList(this.f5463bw);
    }

    /* JADX INFO: renamed from: a */
    public void m5769a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull Level level, @NotNull C1031sk c1031sk, @NotNull String str, @NotNull String str2, @NotNull Set<UUID> set) {
        this.f5465qz++;
        this.f5466qA = Math.min(8, this.f5466qA + 2);
        this.f5468qC = 0;
        m5727cO();
        this.f5471qE = 400;
        C0796oO c0796oOM5749f = m5749f();
        if (!m5744bO()) {
            C0799oR.m3925a(set, C0431hU.m2020a().m2022b(EnumC1123uW.OFFENSIVE_POINT_TAKEN));
            this.f5473ha = false;
        }
        C0799oR.m3941a(level, c1031sk.f4424c, (SoundEvent) C1280xc.f7585pQ.get(), SoundSource.NEUTRAL, 2.0f, 1.0f);
        C0799oR.m4002a((AbstractC0787oF<?, ?, ?>) this, (Component) Component.translatable("bf.message.gamemode.of.point.captured", new Object[]{Component.literal(c1031sk.f4399bP != null ? c1031sk.f4399bP.toUpperCase(Locale.ROOT) : "?").withStyle(ChatFormatting.WHITE)}).withStyle(c0796oOM5749f != null ? c0796oOM5749f.m3876a() : Style.EMPTY), C0357g.f2439g, "of.capture", c1031sk.f4424c, c0796oOM5749f != null ? c0796oOM5749f.getColor() : ColorReferences.COLOR_WHITE, ColorReferences.COLOR_WHITE);
        C0796oO c0796oOM5750g = m5750g();
        if (c0796oOM5750g != null) {
            if (!m5744bO() && (level instanceof ServerLevel)) {
                m5737a(abstractC0563ju, (ServerLevel) level, c0796oOM5750g);
            }
            C0799oR.m3991a((AbstractC0790oI<?>) this.f4248a, c0796oOM5750g, (Component) Component.translatable("bf.message.gamemode.of.point.captured.retreat").withStyle(ChatFormatting.RED), C0357g.f2439g, "of.retreat");
        }
        Iterator<Player> it = c1031sk.m4133a(level, c1031sk.m4098a(mo4666a(c1031sk)), set).iterator();
        while (it.hasNext()) {
            UUID uuid = it.next().getUUID();
            C0799oR.m4015a(abstractC0563ju, this, uuid, C1089tp.f5695l, 3);
            C0799oR.m4014a(abstractC0563ju, this, uuid, C1089tp.f5700q);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0978rl mo3606a() {
        return new InterfaceC0978rl.f(this.f5462bv.stream().map(c1033sm -> {
            C1031sk c1031sk = c1033sm.f5511a;
            return new InterfaceC0978rl.g(new C0805oX(c1031sk.f4424c.x, c1031sk.f4424c.y, c1031sk.f4424c.z, c1031sk.f4423h.x, c1031sk.f4423h.y), c1031sk.f4399bP, List.copyOf(c1033sm.f5512bx), List.copyOf(c1033sm.f5513by), c1033sm.f5514i, c1033sm.f5515c, c1033sm.f5516d, Optional.ofNullable(c1031sk.f4408g));
        }).toList(), this.f5464cz, Optional.ofNullable(this.f5481b), Optional.ofNullable(this.f5482c));
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3607a(@NotNull InterfaceC0978rl interfaceC0978rl) throws MatchException {
        if (interfaceC0978rl instanceof InterfaceC0978rl.f) {
            InterfaceC0978rl.f fVar = (InterfaceC0978rl.f) interfaceC0978rl;
            try {
                List<InterfaceC0978rl.g> listM5372ab = fVar.m5372ab();
                String strM5373ad = fVar.m5373ad();
                Optional<C0709mh> optionalM5374g = fVar.m5374g();
                Optional<C0709mh> optionalM5375h = fVar.m5375h();
                this.f5464cz = strM5373ad;
                this.f5462bv.clear();
                for (InterfaceC0978rl.g gVar : listM5372ab) {
                    C1031sk c1031sk = new C1031sk((C1034sn) this.f4248a);
                    c1031sk.f4424c = gVar.m5377e().f4424c;
                    c1031sk.f4423h = gVar.m5377e().f4423h;
                    c1031sk.f4399bP = gVar.m5378U();
                    c1031sk.f4408g = gVar.m5384e().orElse(null);
                    C1033sm c1033sm = new C1033sm(c1031sk);
                    c1033sm.f5512bx.addAll(gVar.m5379ac());
                    c1033sm.f5513by.addAll(gVar.m5380ad());
                    c1033sm.f5514i = gVar.m5381g();
                    c1033sm.f5515c = gVar.m5382a();
                    c1033sm.f5516d = gVar.m5383b();
                    this.f5462bv.add(c1033sm);
                }
                this.f5481b = optionalM5374g.orElse(null);
                this.f5482c = optionalM5375h.orElse(null);
                m5763cS();
                m5725F(1);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3614a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.mo3614a(byteBuf, z);
        byteBuf.writeInt(this.f5465qz);
        byteBuf.writeInt(this.f5466qA);
        byteBuf.writeInt(this.f5467qB);
        byteBuf.writeBoolean(this.f5470gZ);
        byteBuf.writeBoolean(C1089tp.f5730da.equals(this.f5464cz));
        byteBuf.writeInt(this.f5474qF);
        byteBuf.writeInt(this.f5475qG);
        byteBuf.writeInt(this.f5476qH);
        byteBuf.writeInt(this.f5471qE);
        byteBuf.writeInt(this.f5462bv.size());
        for (C1033sm c1033sm : this.f5462bv) {
            c1033sm.f5511a.mo4111c(byteBuf);
            c1033sm.f5514i.mo4111c(byteBuf);
            c1033sm.f5515c.m4169c(byteBuf);
            c1033sm.f5516d.m4169c(byteBuf);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: g */
    public void mo3616g(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo3616g(byteBuf);
        this.f5465qz = byteBuf.readInt();
        this.f5466qA = byteBuf.readInt();
        this.f5467qB = byteBuf.readInt();
        this.f5470gZ = byteBuf.readBoolean();
        this.f5464cz = byteBuf.readBoolean() ? C1089tp.f5730da : C1089tp.f5729cZ;
        this.f5474qF = byteBuf.readInt();
        this.f5475qG = byteBuf.readInt();
        this.f5476qH = byteBuf.readInt();
        this.f5471qE = byteBuf.readInt();
        int i = byteBuf.readInt();
        if (this.f5462bv.isEmpty()) {
            for (int i2 = 0; i2 < i; i2++) {
                C1033sm c1033sm = new C1033sm(new C1031sk((C1034sn) this.f4248a, byteBuf));
                c1033sm.f5514i.mo4110b(byteBuf);
                c1033sm.f5515c.m4168b(byteBuf);
                c1033sm.f5516d.m4168b(byteBuf);
                this.f5462bv.add(c1033sm);
            }
            m5763cS();
            return;
        }
        for (C1033sm c1033sm2 : this.f5462bv) {
            c1033sm2.f5511a.mo4110b(byteBuf);
            c1033sm2.f5514i.mo4110b(byteBuf);
            c1033sm2.f5515c.m4168b(byteBuf);
            c1033sm2.f5516d.m4168b(byteBuf);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb mo3646a() {
        return super.mo3646a().m2623a(this.f5483h);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: g */
    public void mo3647g(@NotNull List<MutableComponent> list) {
        if (this.f5462bv.isEmpty()) {
            list.add(Component.literal("Objectives in game '" + this.f4236bE + "' are missing."));
        }
        for (C1033sm c1033sm : this.f5462bv) {
            String str = c1033sm.f5511a.f4399bP;
            if (c1033sm.f5512bx.isEmpty()) {
                list.add(Component.literal("Objective '" + str + "' in game '" + this.f4236bE + "' is missing attacker spawns."));
            }
            if (c1033sm.f5513by.isEmpty()) {
                list.add(Component.literal("Objective '" + str + "' in game '" + this.f4236bE + "' is missing defender spawns."));
            }
        }
        super.mo3647g(list);
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
        return new OffensiveMatchReportData(8, this.f5462bv.size());
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public boolean mo3597a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        C0796oO c0796oOB = ((C1034sn) this.f4248a).mo3805b();
        if (c0796oOB == null) {
            return false;
        }
        return ((C1034sn) this.f4248a).m3776a(abstractC0563ju, enumC0800oS, serverLevel, serverPlayer, c0796oOB);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: f */
    public boolean mo3609f(@NotNull Player player) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: bb */
    public boolean mo3611bb() {
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
        return CloudAchievements.ACH_MATCH_WIN_OF;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: e */
    public Set<C1015sV> mo3561e() {
        return Set.of(C1015sV.m5512a("anti_tank"));
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
        C0799oR.m3943a(serverPlayer, new C1010sQ(f5459ju, 40));
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.boehmod.blockfront.ta] */
    @Override // com.boehmod.blockfront.InterfaceC0903qP
    /* JADX INFO: renamed from: a */
    public void mo4675a(@NotNull C0639lQ c0639lQ) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.addAll(mo3560a().m5976a().m5675aD());
        objectArrayList.addAll(m3582b().m5976a().m5675aD());
        if (objectArrayList.isEmpty()) {
            return;
        }
        Collections.shuffle(objectArrayList);
        c0639lQ.m2833c(new ItemStack((ItemLike) ((Supplier) objectArrayList.getFirst()).get()));
    }

    @Override // com.boehmod.blockfront.InterfaceC0903qP
    /* JADX INFO: renamed from: a */
    public int mo4676a(@NotNull C0639lQ c0639lQ) {
        return 3600;
    }

    @Override // com.boehmod.blockfront.InterfaceC0900qM
    /* JADX INFO: renamed from: a */
    public void mo4664a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull EnumC0807oZ enumC0807oZ) {
        m4665a(this, uuid, enumC0807oZ);
    }
}
