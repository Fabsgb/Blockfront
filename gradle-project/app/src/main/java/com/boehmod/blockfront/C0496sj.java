package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.mm.report.IMatchReportData;
import com.boehmod.bflib.cloud.common.mm.report.OffensiveMatchReportData;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.InterfaceC0471rl;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sj.class */
public final class C0496sj extends oF<C0496sj, C0500sn, C0526tm<C0496sj, C0500sn>> implements qM, qN<C0500sn, C0497sk>, qO, qP, qR, qV, qZ, InterfaceC0460ra, InterfaceC0463rd, InterfaceC0464re {
    public static final int qm = 8;
    public static final int qn = 4;
    public static final int qo = 2;
    public static final int qp = 400;
    public static final int qq = 15;
    public static final int qr = 15;
    public static final float lF = 0.35f;
    public static final float lG = 0.5f;
    public static final int qs = 200;
    public static final int qt = 5;
    public static final int qu = 3;
    private static final int qv = 20;
    public static final int qw = 10;
    public static final int qx = 200;
    public static final int qy = 400;
    private static final float lH = 30.0f;

    @NotNull
    private static final Component ju;

    @NotNull
    private static final MutableComponent u;

    @NotNull
    private static final MutableComponent v;

    @NotNull
    private final List<C0499sm> bv;

    @NotNull
    private final List<C0497sk> bw;

    @NotNull
    private String cz;
    private int qz;
    private int qA;
    private int qB;
    private int qC;
    private int qD;
    private boolean gZ;
    private int qE;

    @NotNull
    private final Object2IntMap<UUID> h;
    private boolean ha;
    private int qF;
    private int qG;
    private int qH;
    private int qI;
    private int qJ;
    private int qK;
    private int qL;

    @Nullable
    private C0332mh b;

    @Nullable
    private C0332mh c;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    @NotNull
    private final C0272kb f301h;
    static final /* synthetic */ boolean hb;

    @Override // com.boehmod.blockfront.qN
    public /* bridge */ /* synthetic */ void a(@NotNull AbstractC0264ju abstractC0264ju, @NotNull Level level, @NotNull oV oVVar, @NotNull String str, @NotNull String str2, @NotNull Set set) {
        a((AbstractC0264ju<?, ?, ?>) abstractC0264ju, level, (C0497sk) oVVar, str, str2, (Set<UUID>) set);
    }

    static {
        hb = !C0496sj.class.desiredAssertionStatus();
        ju = Component.translatable("bf.popup.message.crate").withStyle(ChatFormatting.YELLOW);
        u = Component.translatable("bf.message.gamemode.of.rally.reinforced.reinforcements").withColor(ColorReferences.COLOR_THEME_YELLOW);
        v = Component.translatable("bf.message.gamemode.of.rally.reinforced", new Object[]{u}).withColor(ColorReferences.COLOR_WHITE);
    }

    @NotNull
    private Collection<String> g() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator<C0499sm> it = this.bv.iterator();
        while (it.hasNext()) {
            objectArrayList.add(it.next().a.bP);
        }
        return objectArrayList;
    }

    public C0496sj(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        super(abstractC0264ju, "of", "Offensive");
        this.bv = new ObjectArrayList();
        this.bw = new ObjectArrayList();
        this.cz = C0529tp.cZ;
        this.qz = 0;
        this.qA = 8;
        this.qB = 1;
        this.qC = 0;
        this.qD = 0;
        this.gZ = false;
        this.qE = 0;
        this.h = new Object2IntOpenHashMap();
        this.ha = false;
        this.qF = 0;
        this.qG = 0;
        this.qH = 0;
        this.qI = -1;
        this.qJ = -1;
        this.qK = -1;
        this.qL = -1;
        this.b = null;
        this.c = null;
        this.f301h = new C0272kb().a("obj", new C0272kb().a("add", new C0272kb((commandContext, strArr) -> {
            Player player = ((CommandSourceStack) commandContext.getSource()).source;
            String str = strArr[0];
            this.bv.add(new C0499sm(new C0497sk((C0500sn) this.f268a, player, str)));
            cR();
            lW.b(((CommandSourceStack) commandContext.getSource()).source, Component.literal("Added objective " + str + ". (" + this.bv.size() + ")"));
        }).a(C0274kd.a(new String[]{"title"})).a(C0274kd.a)).a("move", new C0272kb((commandContext2, strArr2) -> {
            Player player = ((CommandSourceStack) commandContext2.getSource()).source;
            String str = strArr2[0];
            C0499sm c0499smA = a(str);
            if (c0499smA == null) {
                lW.b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Objective " + str + " was not found!"));
            } else {
                c0499smA.a.c(new oX(player));
                lW.b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Moved objective " + str + "."));
            }
        }).a(C0274kd.a(new String[]{"title"})).a(C0274kd.a).a((commandContext3, strArr3) -> {
            return strArr3.length == 0 ? g() : List.of();
        })).a("clear", new C0272kb((commandContext4, strArr4) -> {
            lW.b(((CommandSourceStack) commandContext4.getSource()).source, Component.literal("Clearing all " + this.bv.size() + " objectives."));
            this.bv.clear();
            cR();
        })).a("box", new C0272kb((commandContext5, strArr5) -> {
            String str;
            Player player = ((CommandSourceStack) commandContext5.getSource()).source;
            String str2 = strArr5[0];
            C0499sm c0499smA = a(str2);
            if (c0499smA == null) {
                lW.b(((CommandSourceStack) commandContext5.getSource()).source, Component.literal("Objective " + str2 + " was not found!"));
                return;
            }
            AABB aabbJ = this.f269b.m305a(player).m301b().j();
            c0499smA.a.g = aabbJ;
            CommandSource commandSource = ((CommandSourceStack) commandContext5.getSource()).source;
            if (aabbJ != null) {
                str = "Set capture box for " + str2 + " from your selection.";
            } else {
                str = "No AABB selection; cleared capture box for " + str2 + " (using radius).";
            }
            lW.b(commandSource, Component.literal(str));
        }).a(C0274kd.a(new String[]{"title"})).a(C0274kd.a).a((commandContext6, strArr6) -> {
            return strArr6.length == 0 ? g() : List.of();
        }))).a("spawn", new C0272kb((commandContext7, strArr7) -> {
            Player player = ((CommandSourceStack) commandContext7.getSource()).source;
            String str = strArr7[0];
            String str2 = strArr7[1];
            C0499sm c0499smA = a(str);
            if (c0499smA == null) {
                lW.b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Objective " + str + " was not found!"));
                return;
            }
            oX oXVar = new oX(player);
            if (str2.equalsIgnoreCase("attacker")) {
                c0499smA.bx.add(oXVar);
                lW.b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Added attacker spawn to " + str + ". (" + c0499smA.bx.size() + ")"));
            } else if (str2.equalsIgnoreCase("defender")) {
                c0499smA.by.add(oXVar);
                lW.b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Added defender spawn to " + str + ". (" + c0499smA.by.size() + ")"));
            } else {
                lW.b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Role must be 'attacker' or 'defender'."));
                return;
            }
            cO();
        }).a(C0274kd.a(new String[]{"title", "role"})).a(C0274kd.a).a((commandContext8, strArr8) -> {
            switch (strArr8.length) {
                case 0:
                    return g();
                case 1:
                    return List.of("attacker", "defender");
                default:
                    return List.of();
            }
        })).a("regroup", new C0272kb((commandContext9, strArr9) -> {
            Player player = ((CommandSourceStack) commandContext9.getSource()).source;
            String str = strArr9[0];
            C0499sm c0499smA = a(str);
            if (c0499smA == null) {
                lW.b(((CommandSourceStack) commandContext9.getSource()).source, Component.literal("Objective " + str + " was not found!"));
            } else {
                c0499smA.i = new oX(player);
                lW.b(((CommandSourceStack) commandContext9.getSource()).source, Component.literal("Set regroup point for " + str + "."));
            }
        }).a(C0274kd.a(new String[]{"title"})).a(C0274kd.a).a((commandContext10, strArr10) -> {
            return strArr10.length == 0 ? g() : List.of();
        })).a("boundary", new C0272kb().a("set", new C0272kb((commandContext11, strArr11) -> {
            Player player = ((CommandSourceStack) commandContext11.getSource()).source;
            String str = strArr11[0];
            String str2 = strArr11[1];
            C0499sm c0499smA = a(str);
            if (c0499smA == null) {
                lW.b(((CommandSourceStack) commandContext11.getSource()).source, Component.literal("Objective " + str + " was not found!"));
                return;
            }
            oY oYVarC = this.f269b.m305a(player).m301b().c();
            if (oYVarC == null) {
                lW.b(((CommandSourceStack) commandContext11.getSource()).source, Component.literal("No region selection! Select an area with the region wand first."));
                return;
            }
            if (str2.equalsIgnoreCase("attacker")) {
                c0499smA.c = oYVarC;
            } else if (str2.equalsIgnoreCase("defender")) {
                c0499smA.d = oYVarC;
            } else {
                lW.b(((CommandSourceStack) commandContext11.getSource()).source, Component.literal("Side must be 'attacker' or 'defender'."));
                return;
            }
            lW.b(((CommandSourceStack) commandContext11.getSource()).source, Component.literal("Set " + str2 + " boundary for " + str + " from your selection. (" + oYVarC.be() + " points)"));
        }).a(C0274kd.a(new String[]{"title", "side"})).a(C0274kd.a).a((commandContext12, strArr12) -> {
            switch (strArr12.length) {
                case 0:
                    return g();
                case 1:
                    return List.of("attacker", "defender");
                default:
                    return List.of();
            }
        })).a("clear", new C0272kb((commandContext13, strArr13) -> {
            String str = strArr13[0];
            String str2 = strArr13[1];
            C0499sm c0499smA = a(str);
            if (c0499smA == null) {
                lW.b(((CommandSourceStack) commandContext13.getSource()).source, Component.literal("Objective " + str + " was not found!"));
                return;
            }
            if (str2.equalsIgnoreCase("attacker")) {
                c0499smA.c = new oY();
            } else if (str2.equalsIgnoreCase("defender")) {
                c0499smA.d = new oY();
            } else {
                lW.b(((CommandSourceStack) commandContext13.getSource()).source, Component.literal("Side must be 'attacker' or 'defender'."));
                return;
            }
            lW.b(((CommandSourceStack) commandContext13.getSource()).source, Component.literal("Cleared " + str2 + " boundary for " + str + "."));
        }).a(C0274kd.a(new String[]{"title", "side"})).a((commandContext14, strArr14) -> {
            switch (strArr14.length) {
                case 0:
                    return g();
                case 1:
                    return List.of("attacker", "defender");
                default:
                    return List.of();
            }
        }))).a("attacker", new C0272kb((commandContext15, strArr15) -> {
            String str = strArr15[0].equalsIgnoreCase("axis") ? C0529tp.da : C0529tp.cZ;
            this.cz = str;
            cN();
            lW.b(((CommandSourceStack) commandContext15.getSource()).source, Component.literal("Attacking team set to " + str + "."));
        }).a(C0274kd.a(new String[]{"team"})).a((commandContext16, strArr16) -> {
            return strArr16.length == 0 ? List.of("allies", "axis") : List.of();
        }));
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    public C0498sl a(@NotNull C0297l c0297l) {
        return new C0498sl(c0297l, this, (fV) this.f269b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.oF
    @NotNull
    public C0500sn a() {
        return new C0500sn(this, this.f269b);
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0524tk<C0496sj, C0500sn> mo749a() {
        return new C0523tj(C0505ss::new);
    }

    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f270a.b(abstractC0264ju, cVar, serverLevel);
    }

    @Override // com.boehmod.blockfront.oF
    public void d(@Nullable Level level) {
        this.qI = -1;
        this.qJ = -1;
        this.qK = -1;
        this.qL = -1;
        F(1);
    }

    public void F(int i) {
        this.qB = i;
        this.qA = 4;
        this.qC = 0;
        this.qD = 0;
        this.gZ = false;
        this.ha = false;
        this.qF = 0;
        this.qG = 0;
        this.qH = 0;
        this.qE = 0;
        this.h.clear();
        cN();
    }

    private void cN() {
        this.qz = 0;
        oO oOVarM1123g = m1123g();
        Iterator<C0499sm> it = this.bv.iterator();
        while (it.hasNext()) {
            C0497sk c0497sk = it.next().a;
            c0497sk.bf();
            c0497sk.d = oOVarM1123g;
        }
        cO();
    }

    private void cO() {
        C0499sm c0499smM1124a = m1124a();
        oO oOVarF = f();
        oO oOVarM1123g = m1123g();
        if (oOVarF != null) {
            oOVarF.ct();
            if (c0499smM1124a != null) {
                List<oX> list = c0499smM1124a.bx;
                Objects.requireNonNull(oOVarF);
                list.forEach(oOVarF::b);
            }
        }
        if (oOVarM1123g != null) {
            oOVarM1123g.ct();
            if (c0499smM1124a != null) {
                List<oX> list2 = c0499smM1124a.by;
                Objects.requireNonNull(oOVarM1123g);
                list2.forEach(oOVarM1123g::b);
            }
        }
    }

    public void c(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        if (this.qE > 0) {
            this.qE = Math.max(0, this.qE - 20);
            if (this.qE == 0) {
                i(serverLevel);
            }
        }
        C0499sm c0499smM1124a = m1124a();
        if (c0499smM1124a == null) {
            return;
        }
        c0499smM1124a.a.a(abstractC0264ju, cVar, this, serverLevel, set);
        a(abstractC0264ju, cVar, serverLevel);
        C0499sm c0499smM1124a2 = m1124a();
        if (c0499smM1124a2 != null) {
            a(abstractC0264ju, cVar, serverLevel, set, c0499smM1124a2);
        }
    }

    public void i(@NotNull ServerLevel serverLevel) {
        a(serverLevel, f());
    }

    private void a(@NotNull ServerLevel serverLevel, @Nullable oO oOVar) {
        if (oOVar == null) {
            return;
        }
        List<oX> listB = oOVar.B();
        if (listB.isEmpty()) {
            return;
        }
        BlockPos blockPosC = ((oX) listB.getFirst()).c();
        serverLevel.playSound((Player) null, blockPosC, (SoundEvent) C0624xc.GL.get(), SoundSource.AMBIENT, lH, 1.0f);
        serverLevel.playSound((Player) null, blockPosC, (SoundEvent) C0624xc.GK.get(), SoundSource.AMBIENT, lH, 1.0f);
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel) {
        int iAZ;
        oO oOVarF = f();
        if (oOVarF == null || (iAZ = oOVarF.aZ()) == 0) {
            return;
        }
        float fC = (iAZ - c(oOVarF)) / iAZ;
        if (this.qA > 0 && fC >= 0.35f) {
            this.qC += 20;
            if (this.qC >= 400) {
                this.qC = 0;
                this.qF = 0;
                this.qA--;
                Iterator<ServerPlayer> it = m1121a(abstractC0264ju, cVar, serverLevel, oOVarF).iterator();
                while (it.hasNext()) {
                    oR.a(it.next(), (SoundEvent) C0624xc.pJ.get(), SoundSource.MUSIC, 1.5f, 1.0f);
                }
                oR.a((oI<?>) this.f268a, oOVarF, (Component) Component.translatable("bf.message.gamemode.of.waves.deployed").withStyle(ChatFormatting.WHITE), 60, "of.waves");
                return;
            }
            this.qF = Math.max(1, (400 - this.qC) / 20);
            return;
        }
        this.qC = 0;
        this.qF = 0;
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @NotNull C0499sm c0499sm) {
        oO oOVarM1123g = m1123g();
        if (oOVarM1123g == null) {
            return;
        }
        int iAZ = oOVarM1123g.aZ();
        if (iAZ == 0) {
            this.gZ = false;
            return;
        }
        int iC = c(oOVarM1123g);
        int i = iAZ - iC;
        float f = i / iAZ;
        boolean z = this.gZ;
        this.gZ = i > 0 && f >= 0.5f;
        if (!z && this.gZ) {
            oR.a(oOVarM1123g.h(), hU.a().d(uW.OFFENSIVE_REINFORCEMENTS_HINT));
            this.ha = true;
        }
        if (!this.gZ) {
            this.qD = 0;
            this.qG = 0;
            return;
        }
        if (iC == 0) {
            this.qD += 20;
            if (this.qD >= 200) {
                this.qD = 0;
                this.qG = 0;
                a(abstractC0264ju, cVar, serverLevel, oOVarM1123g);
                return;
            }
            this.qG = Math.max(1, (200 - this.qD) / 20);
            return;
        }
        this.qD = 0;
        this.qG = 0;
        if (a(serverLevel, oOVarM1123g, c0499sm.i, set)) {
            a(abstractC0264ju, cVar, serverLevel, oOVarM1123g);
        }
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull oO oOVar) {
        List<ServerPlayer> listM1121a = m1121a(abstractC0264ju, cVar, serverLevel, oOVar);
        this.gZ = false;
        Iterator<ServerPlayer> it = listM1121a.iterator();
        while (it.hasNext()) {
            oR.a((Level) serverLevel, it.next().position(), (SoundEvent) C0624xc.pT.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
        }
        oR.a(oOVar.h(), hU.a().b(uW.OFFENSIVE_REINFORCEMENTS_ARRIVE));
        this.ha = false;
        oR.a((oI<?>) this.f268a, oOVar, (Component) v, 60, "of.rally");
    }

    public void cP() {
        if (this.ha) {
            this.ha = false;
            oO oOVarM1123g = m1123g();
            if (oOVarM1123g != null) {
                oR.a(oOVarM1123g.h(), hU.a().b(uW.CONCLUDE_GENERIC));
            }
        }
    }

    private boolean a(@NotNull ServerLevel serverLevel, @NotNull oO oOVar, @NotNull oX oXVar, @NotNull Set<UUID> set) {
        for (ServerPlayer serverPlayer : oXVar.a(serverLevel, 5, set)) {
            UUID uuid = serverPlayer.getUUID();
            if (oOVar.i(uuid) && !oR.a((Player) serverPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) this.f269b.b(uuid))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private List<ServerPlayer> m1121a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull oO oOVar) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (UUID uuid : oOVar.h()) {
            ServerPlayer serverPlayerA = oR.a(uuid);
            if (serverPlayerA != null && oR.a((Player) serverPlayerA, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) cVar.b(uuid))) {
                oR.a(abstractC0264ju, cVar, serverLevel, serverPlayerA);
                objectArrayList.add(serverPlayerA);
            }
        }
        C0499sm c0499smM1124a = m1124a();
        if (!objectArrayList.isEmpty() && c0499smM1124a != null) {
            oO oOVarF = f();
            List<oX> list = oOVarF != null && oOVarF.equals(oOVar) ? c0499smM1124a.bx : c0499smM1124a.by;
            if (!list.isEmpty()) {
                sU sUVarA = oOVar.a((oF<?, ?, ?>) this).m1156a().a();
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderD = sUVarA != null ? sUVarA.d() : null;
                if (deferredHolderD != null) {
                    serverLevel.playSound((Player) null, ((oX) list.getFirst()).c(), (SoundEvent) deferredHolderD.get(), SoundSource.PLAYERS, 5.0f, 1.0f);
                }
            }
        }
        return objectArrayList;
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull oO oOVar) {
        m1121a(abstractC0264ju, this.f269b, serverLevel, oOVar);
        this.gZ = false;
        this.qD = 0;
        this.qG = 0;
    }

    private int c(@NotNull oO oOVar) {
        int i = 0;
        for (UUID uuid : oOVar.h()) {
            ServerPlayer serverPlayerA = oR.a(uuid);
            if (serverPlayerA != null && !oR.a((Player) serverPlayerA, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) this.f269b.b(uuid))) {
                i++;
            }
        }
        return i;
    }

    @Nullable
    public oY a(@NotNull oO oOVar) {
        C0499sm c0499smM1124a = m1124a();
        if (c0499smM1124a == null) {
            return null;
        }
        oO oOVarF = f();
        return (oOVarF == null || !oOVarF.equals(oOVar)) ? c0499smM1124a.d : c0499smM1124a.c;
    }

    public boolean bM() {
        return this.qE > 0;
    }

    public int bE() {
        if (this.qE <= 0) {
            return 0;
        }
        return Math.max(1, this.qE / 20);
    }

    public void h(@NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        com.boehmod.blockfront.common.player.b bVarB = this.f269b.b(uuid);
        if (this.f263a != oN.GAME || bM() || oR.a((Player) serverPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) bVarB) || bVarB.q() != null || ((C0500sn) this.f268a).g(uuid)) {
            this.h.removeInt(uuid);
            return;
        }
        oO oOVarA = ((C0500sn) this.f268a).a(uuid);
        oY oYVarA = oOVarA != null ? a(oOVarA) : null;
        if (oYVarA == null || oYVarA.bu() || oYVarA.a((float) serverPlayer.getX(), (float) serverPlayer.getZ())) {
            this.h.removeInt(uuid);
            return;
        }
        int orDefault = this.h.getOrDefault(uuid, 200) - 1;
        if (orDefault <= 0) {
            this.h.removeInt(uuid);
            serverPlayer.kill();
        } else {
            this.h.put(uuid, orDefault);
        }
    }

    public boolean bN() {
        if (!this.bv.isEmpty() && this.qz >= this.bv.size()) {
            return true;
        }
        oO oOVarF = f();
        return oOVarF != null && this.qA <= 0 && c(oOVarF) == 0;
    }

    public boolean bO() {
        return !this.bv.isEmpty() && this.qz >= this.bv.size();
    }

    public void cQ() {
        int iMin = Math.min(this.qz, this.bv.size());
        int iMax = Math.max(this.qA, 0);
        if (this.qB == 1) {
            this.qI = iMin;
            this.qJ = iMax;
        } else {
            this.qK = iMin;
            this.qL = iMax;
        }
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        oO oOVarA = ((C0500sn) this.f268a).a(C0529tp.cZ);
        oO oOVarA2 = ((C0500sn) this.f268a).a(C0529tp.da);
        if (oOVarA == null || oOVarA2 == null) {
            return;
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(oOVarA.h());
        ObjectArrayList objectArrayList2 = new ObjectArrayList(oOVarA2.h());
        oOVarA.cs();
        oOVarA2.cs();
        Iterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            oOVarA2.h((UUID) it.next());
        }
        Iterator it2 = objectArrayList2.iterator();
        while (it2.hasNext()) {
            oOVarA.h((UUID) it2.next());
        }
        e().clear();
        oOVarA.a(C0529tp.w, 0);
        oOVarA.a(C0529tp.x, 0);
        oOVarA2.a(C0529tp.w, 0);
        oOVarA2.a(C0529tp.x, 0);
        F(2);
        a(serverLevel, cVar);
    }

    public void a(@NotNull ServerLevel serverLevel, @NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        oO oOVarA;
        for (UUID uuid : ((C0500sn) this.f268a).h()) {
            ServerPlayer serverPlayerA = oR.a(uuid);
            if (serverPlayerA != null && (oOVarA = ((C0500sn) this.f268a).a(uuid)) != null) {
                oR.a(cVar, serverLevel, serverPlayerA);
                oR.a(cVar, serverPlayerA, oOVarA.m789a((oF<?, ?, ?>) this));
                oR.a(serverLevel, serverPlayerA, this, oOVarA);
                oR.f(serverPlayerA);
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0409pd m1122a() {
        if (this.qI < 0 || this.qK < 0) {
            return null;
        }
        oO oOVarF = f();
        oO oOVarM1123g = m1123g();
        if (this.qK != this.qI) {
            return new C0409pd(this.qK > this.qI ? oOVarF : oOVarM1123g, null);
        }
        if (this.qL != this.qJ) {
            return new C0409pd(this.qL > this.qJ ? oOVarF : oOVarM1123g, null);
        }
        return new C0409pd(null, null);
    }

    @Nullable
    public oO f() {
        return ((C0500sn) this.f268a).a(this.cz);
    }

    @Nullable
    /* JADX INFO: renamed from: g, reason: collision with other method in class */
    public oO m1123g() {
        oO oOVarF = f();
        if (oOVarF == null) {
            return null;
        }
        return oOVarF.bp() ? ((C0500sn) this.f268a).a(C0529tp.da) : ((C0500sn) this.f268a).a(C0529tp.cZ);
    }

    @Override // com.boehmod.blockfront.InterfaceC0464re
    public Component a(@NotNull ServerPlayer serverPlayer) {
        oO oOVarA = ((C0500sn) this.f268a).a(C0529tp.da);
        oO oOVarA2 = ((C0500sn) this.f268a).a(C0529tp.cZ);
        if (!hb && oOVarA == null) {
            throw new AssertionError();
        }
        if (hb || oOVarA2 != null) {
            return a((Player) serverPlayer, oOVarA.aZ(), oOVarA2.aZ());
        }
        throw new AssertionError();
    }

    @Override // com.boehmod.blockfront.InterfaceC0464re
    public void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        a(abstractC0264ju, serverLevel, serverPlayer, uuid);
    }

    @Override // com.boehmod.blockfront.InterfaceC0464re
    public int bx() {
        return C0529tp.rx;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0499sm m1124a() {
        if (this.qz >= 0 && this.qz < this.bv.size()) {
            return this.bv.get(this.qz);
        }
        return null;
    }

    @NotNull
    public List<C0499sm> au() {
        return Collections.unmodifiableList(this.bv);
    }

    public int bF() {
        return this.qz;
    }

    public int bG() {
        return this.qA;
    }

    public int bH() {
        return this.qB;
    }

    public boolean bP() {
        return this.gZ;
    }

    public int bI() {
        return this.qF;
    }

    public int bJ() {
        return this.qG;
    }

    public int bK() {
        return this.qH;
    }

    public void G(int i) {
        this.qH = i;
    }

    @Nullable
    private C0499sm a(@NotNull String str) {
        for (C0499sm c0499sm : this.bv) {
            if (c0499sm.a.bP != null && c0499sm.a.bP.equalsIgnoreCase(str)) {
                return c0499sm;
            }
        }
        return null;
    }

    private void cR() {
        cS();
        cN();
    }

    private void cS() {
        this.bw.clear();
        Iterator<C0499sm> it = this.bv.iterator();
        while (it.hasNext()) {
            this.bw.add(it.next().a);
        }
    }

    public void a(@Nullable C0332mh c0332mh) {
        this.b = c0332mh;
    }

    @Nullable
    public C0332mh c() {
        return this.b;
    }

    public void b(@Nullable C0332mh c0332mh) {
        this.c = c0332mh;
    }

    @Nullable
    public C0332mh d() {
        return this.c;
    }

    @Override // com.boehmod.blockfront.qN
    public int a(@NotNull C0497sk c0497sk) {
        return 3;
    }

    @Override // com.boehmod.blockfront.qN
    public List<C0497sk> O() {
        return Collections.unmodifiableList(this.bw);
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull Level level, @NotNull C0497sk c0497sk, @NotNull String str, @NotNull String str2, @NotNull Set<UUID> set) {
        this.qz++;
        this.qA = Math.min(8, this.qA + 2);
        this.qC = 0;
        cO();
        this.qE = 400;
        oO oOVarF = f();
        if (!bO()) {
            oR.a(set, hU.a().b(uW.OFFENSIVE_POINT_TAKEN));
            this.ha = false;
        }
        oR.a(level, c0497sk.c, (SoundEvent) C0624xc.pQ.get(), SoundSource.NEUTRAL, 2.0f, 1.0f);
        oR.a((oF<?, ?, ?>) this, (Component) Component.translatable("bf.message.gamemode.of.point.captured", new Object[]{Component.literal(c0497sk.bP != null ? c0497sk.bP.toUpperCase(Locale.ROOT) : "?").withStyle(ChatFormatting.WHITE)}).withStyle(oOVarF != null ? oOVarF.a() : Style.EMPTY), C0163g.g, "of.capture", c0497sk.c, oOVarF != null ? oOVarF.getColor() : ColorReferences.COLOR_WHITE, ColorReferences.COLOR_WHITE);
        oO oOVarM1123g = m1123g();
        if (oOVarM1123g != null) {
            if (!bO() && (level instanceof ServerLevel)) {
                a(abstractC0264ju, (ServerLevel) level, oOVarM1123g);
            }
            oR.a((oI<?>) this.f268a, oOVarM1123g, (Component) Component.translatable("bf.message.gamemode.of.point.captured.retreat").withStyle(ChatFormatting.RED), C0163g.g, "of.retreat");
        }
        Iterator<Player> it = c0497sk.a(level, c0497sk.a(a(c0497sk)), set).iterator();
        while (it.hasNext()) {
            UUID uuid = it.next().getUUID();
            oR.a(abstractC0264ju, this, uuid, C0529tp.l, 3);
            oR.a(abstractC0264ju, this, uuid, C0529tp.q);
        }
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0471rl mo752a() {
        return new InterfaceC0471rl.f(this.bv.stream().map(c0499sm -> {
            C0497sk c0497sk = c0499sm.a;
            return new InterfaceC0471rl.g(new oX(c0497sk.c.x, c0497sk.c.y, c0497sk.c.z, c0497sk.h.x, c0497sk.h.y), c0497sk.bP, List.copyOf(c0499sm.bx), List.copyOf(c0499sm.by), c0499sm.i, c0499sm.c, c0499sm.d, Optional.ofNullable(c0497sk.g));
        }).toList(), this.cz, Optional.ofNullable(this.b), Optional.ofNullable(this.c));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull InterfaceC0471rl interfaceC0471rl) throws MatchException {
        if (interfaceC0471rl instanceof InterfaceC0471rl.f) {
            InterfaceC0471rl.f fVar = (InterfaceC0471rl.f) interfaceC0471rl;
            try {
                List<InterfaceC0471rl.g> listAb = fVar.ab();
                String strAd = fVar.ad();
                Optional<C0332mh> optionalG = fVar.g();
                Optional<C0332mh> optionalH = fVar.h();
                this.cz = strAd;
                this.bv.clear();
                for (InterfaceC0471rl.g gVar : listAb) {
                    C0497sk c0497sk = new C0497sk((C0500sn) this.f268a);
                    c0497sk.c = gVar.e().c;
                    c0497sk.h = gVar.e().h;
                    c0497sk.bP = gVar.U();
                    c0497sk.g = gVar.m1068e().orElse(null);
                    C0499sm c0499sm = new C0499sm(c0497sk);
                    c0499sm.bx.addAll(gVar.ac());
                    c0499sm.by.addAll(gVar.ad());
                    c0499sm.i = gVar.g();
                    c0499sm.c = gVar.a();
                    c0499sm.d = gVar.b();
                    this.bv.add(c0499sm);
                }
                this.b = optionalG.orElse(null);
                this.c = optionalH.orElse(null);
                cS();
                F(1);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }

    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.a(byteBuf, z);
        byteBuf.writeInt(this.qz);
        byteBuf.writeInt(this.qA);
        byteBuf.writeInt(this.qB);
        byteBuf.writeBoolean(this.gZ);
        byteBuf.writeBoolean(C0529tp.da.equals(this.cz));
        byteBuf.writeInt(this.qF);
        byteBuf.writeInt(this.qG);
        byteBuf.writeInt(this.qH);
        byteBuf.writeInt(this.qE);
        byteBuf.writeInt(this.bv.size());
        for (C0499sm c0499sm : this.bv) {
            c0499sm.a.c(byteBuf);
            c0499sm.i.c(byteBuf);
            c0499sm.c.c(byteBuf);
            c0499sm.d.c(byteBuf);
        }
    }

    @Override // com.boehmod.blockfront.oF
    public void g(@NotNull ByteBuf byteBuf) throws IOException {
        super.g(byteBuf);
        this.qz = byteBuf.readInt();
        this.qA = byteBuf.readInt();
        this.qB = byteBuf.readInt();
        this.gZ = byteBuf.readBoolean();
        this.cz = byteBuf.readBoolean() ? C0529tp.da : C0529tp.cZ;
        this.qF = byteBuf.readInt();
        this.qG = byteBuf.readInt();
        this.qH = byteBuf.readInt();
        this.qE = byteBuf.readInt();
        int i = byteBuf.readInt();
        if (this.bv.isEmpty()) {
            for (int i2 = 0; i2 < i; i2++) {
                C0499sm c0499sm = new C0499sm(new C0497sk((C0500sn) this.f268a, byteBuf));
                c0499sm.i.b(byteBuf);
                c0499sm.c.b(byteBuf);
                c0499sm.d.b(byteBuf);
                this.bv.add(c0499sm);
            }
            cS();
            return;
        }
        for (C0499sm c0499sm2 : this.bv) {
            c0499sm2.a.b(byteBuf);
            c0499sm2.i.b(byteBuf);
            c0499sm2.c.b(byteBuf);
            c0499sm2.d.b(byteBuf);
        }
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0272kb mo763a() {
        return super.mo763a().a(this.f301h);
    }

    @Override // com.boehmod.blockfront.oF
    public void g(@NotNull List<MutableComponent> list) {
        if (this.bv.isEmpty()) {
            list.add(Component.literal("Objectives in game '" + this.bE + "' are missing."));
        }
        for (C0499sm c0499sm : this.bv) {
            String str = c0499sm.a.bP;
            if (c0499sm.bx.isEmpty()) {
                list.add(Component.literal("Objective '" + str + "' in game '" + this.bE + "' is missing attacker spawns."));
            }
            if (c0499sm.by.isEmpty()) {
                list.add(Component.literal("Objective '" + str + "' in game '" + this.bE + "' is missing defender spawns."));
            }
        }
        super.g(list);
    }

    @Override // com.boehmod.blockfront.oF
    protected boolean aZ() {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    @Nullable
    protected IMatchReportData a(@NotNull C0409pd c0409pd) {
        return new OffensiveMatchReportData(8, this.bv.size());
    }

    @Override // com.boehmod.blockfront.oF
    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oS oSVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        oO oOVarB = ((C0500sn) this.f268a).b();
        if (oOVarB == null) {
            return false;
        }
        return ((C0500sn) this.f268a).a(abstractC0264ju, oSVar, serverLevel, serverPlayer, oOVarB);
    }

    @Override // com.boehmod.blockfront.oF
    public boolean f(@NotNull Player player) {
        return false;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean bb() {
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
        return CloudAchievements.ACH_MATCH_WIN_OF;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    public Set<sV> e() {
        return Set.of(sV.a("anti_tank"));
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
        oR.a(serverPlayer, new sQ(ju, 40));
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.boehmod.blockfront.ta] */
    @Override // com.boehmod.blockfront.qP
    public void a(@NotNull lQ lQVar) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.addAll(a().m1156a().aD());
        objectArrayList.addAll(b().m1156a().aD());
        if (objectArrayList.isEmpty()) {
            return;
        }
        Collections.shuffle(objectArrayList);
        lQVar.c(new ItemStack((ItemLike) ((Supplier) objectArrayList.getFirst()).get()));
    }

    @Override // com.boehmod.blockfront.qP
    /* JADX INFO: renamed from: a */
    public int mo921a(@NotNull lQ lQVar) {
        return 3600;
    }

    @Override // com.boehmod.blockfront.qM
    public void a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull oZ oZVar) {
        a(this, uuid, oZVar);
    }
}
