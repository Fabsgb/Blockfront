package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p001mm.report.IMatchReportData;
import com.boehmod.bflib.cloud.common.p001mm.report.OffensiveMatchReportData;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sG.class */
public final class C1001sG extends AbstractC0863pb<C1001sG, C1005sK, C1058tJ<C1001sG, C1005sK>> implements InterfaceC0942rA, InterfaceC0943rB, InterfaceC0977rj, InterfaceC0978rk<C1005sK, C1002sH>, InterfaceC0979rl, InterfaceC0980rm, InterfaceC0982ro, InterfaceC0986rs, InterfaceC0990rw, InterfaceC0991rx {

    /* JADX INFO: renamed from: sn */
    public static final int f5490sn = 8;

    /* JADX INFO: renamed from: so */
    public static final int f5491so = 4;

    /* JADX INFO: renamed from: sp */
    public static final int f5492sp = 2;

    /* JADX INFO: renamed from: sq */
    public static final int f5493sq = 400;

    /* JADX INFO: renamed from: sr */
    public static final int f5494sr = 15;

    /* JADX INFO: renamed from: ss */
    public static final int f5495ss = 15;

    /* JADX INFO: renamed from: mE */
    public static final float f5496mE = 0.35f;

    /* JADX INFO: renamed from: mF */
    public static final float f5497mF = 0.5f;

    /* JADX INFO: renamed from: st */
    public static final int f5498st = 200;

    /* JADX INFO: renamed from: su */
    public static final int f5499su = 5;

    /* JADX INFO: renamed from: sv */
    public static final int f5500sv = 3;

    /* JADX INFO: renamed from: sw */
    private static final int f5501sw = 20;

    /* JADX INFO: renamed from: sx */
    public static final int f5502sx = 10;

    /* JADX INFO: renamed from: sy */
    public static final int f5503sy = 200;

    /* JADX INFO: renamed from: sz */
    public static final int f5504sz = 400;

    /* JADX INFO: renamed from: mG */
    private static final float f5505mG = 30.0f;

    /* JADX INFO: renamed from: jH */
    @NotNull
    private static final Component f5506jH;

    /* JADX INFO: renamed from: u */
    @NotNull
    private static final MutableComponent f5507u;

    /* JADX INFO: renamed from: v */
    @NotNull
    private static final MutableComponent f5508v;

    /* JADX INFO: renamed from: bC */
    @NotNull
    private final List<C1004sJ> f5509bC;

    /* JADX INFO: renamed from: bD */
    @NotNull
    private final List<C1002sH> f5510bD;

    /* JADX INFO: renamed from: cJ */
    @NotNull
    private String f5511cJ;

    /* JADX INFO: renamed from: sA */
    private int f5512sA;

    /* JADX INFO: renamed from: sB */
    private int f5513sB;

    /* JADX INFO: renamed from: sC */
    private int f5514sC;

    /* JADX INFO: renamed from: sD */
    private int f5515sD;

    /* JADX INFO: renamed from: sE */
    private int f5516sE;

    /* JADX INFO: renamed from: ht */
    private boolean f5517ht;

    /* JADX INFO: renamed from: sF */
    private int f5518sF;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final Object2IntMap<UUID> f5519h;

    /* JADX INFO: renamed from: hu */
    private boolean f5520hu;

    /* JADX INFO: renamed from: sG */
    private int f5521sG;

    /* JADX INFO: renamed from: sH */
    private int f5522sH;

    /* JADX INFO: renamed from: sI */
    private int f5523sI;

    /* JADX INFO: renamed from: sJ */
    private int f5524sJ;

    /* JADX INFO: renamed from: sK */
    private int f5525sK;

    /* JADX INFO: renamed from: sL */
    private int f5526sL;

    /* JADX INFO: renamed from: sM */
    private int f5527sM;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C0680mD f5528b;

    /* JADX INFO: renamed from: c */
    @Nullable
    private C0680mD f5529c;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final C0620kx f5530h;

    /* JADX INFO: renamed from: hv */
    static final /* synthetic */ boolean f5531hv;

    @Override // com.boehmod.blockfront.InterfaceC0978rk
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo5357a(@NotNull AbstractC0531jN abstractC0531jN, @NotNull Level level, @NotNull AbstractC0879pr abstractC0879pr, @NotNull String str, @NotNull String str2, @NotNull Set set) {
        m5657a((AbstractC0531jN<?, ?, ?>) abstractC0531jN, level, (C1002sH) abstractC0879pr, str, str2, (Set<UUID>) set);
    }

    static {
        f5531hv = !C1001sG.class.desiredAssertionStatus();
        f5506jH = Component.translatable("bf.popup.message.crate").withStyle(ChatFormatting.YELLOW);
        f5507u = Component.translatable("bf.message.gamemode.of.rally.reinforced.reinforcements").withColor(ColorReferences.COLOR_THEME_YELLOW);
        f5508v = Component.translatable("bf.message.gamemode.of.rally.reinforced", new Object[]{f5507u}).withColor(ColorReferences.COLOR_WHITE);
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    private Collection<String> m5612g() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator<C1004sJ> it = this.f5509bC.iterator();
        while (it.hasNext()) {
            objectArrayList.add(it.next().f5558a.f4796bZ);
        }
        return objectArrayList;
    }

    public C1001sG(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        super(abstractC0531jN, "of", "Offensive");
        this.f5509bC = new ObjectArrayList();
        this.f5510bD = new ObjectArrayList();
        this.f5511cJ = C1062tN.f5782dk;
        this.f5512sA = 0;
        this.f5513sB = 8;
        this.f5514sC = 1;
        this.f5515sD = 0;
        this.f5516sE = 0;
        this.f5517ht = false;
        this.f5518sF = 0;
        this.f5519h = new Object2IntOpenHashMap();
        this.f5520hu = false;
        this.f5521sG = 0;
        this.f5522sH = 0;
        this.f5523sI = 0;
        this.f5524sJ = -1;
        this.f5525sK = -1;
        this.f5526sL = -1;
        this.f5527sM = -1;
        this.f5528b = null;
        this.f5529c = null;
        this.f5530h = new C0620kx().m2840a("obj", new C0620kx().m2840a("add", new C0620kx((commandContext, strArr) -> {
            Player player = ((CommandSourceStack) commandContext.getSource()).source;
            String str = strArr[0];
            this.f5509bC.add(new C1004sJ(new C1002sH((C1005sK) this.f4642a, player, str)));
            m5650dd();
            C0721ms.m3329b(((CommandSourceStack) commandContext.getSource()).source, Component.literal("Added objective " + str + ". (" + this.f5509bC.size() + ")"));
        }).m2836a(C0622kz.m2847a(new String[]{"title"})).m2836a(C0622kz.f3554a)).m2840a("move", new C0620kx((commandContext2, strArr2) -> {
            Player player = ((CommandSourceStack) commandContext2.getSource()).source;
            String str = strArr2[0];
            C1004sJ c1004sJM5649a = m5649a(str);
            if (c1004sJM5649a == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Objective " + str + " was not found!"));
            } else {
                c1004sJM5649a.f5558a.m4566c(new C0881pt(player));
                C0721ms.m3329b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Moved objective " + str + "."));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"title"})).m2836a(C0622kz.f3554a).m2842a((commandContext3, strArr3) -> {
            return strArr3.length == 0 ? m5612g() : List.of();
        })).m2840a("clear", new C0620kx((commandContext4, strArr4) -> {
            C0721ms.m3329b(((CommandSourceStack) commandContext4.getSource()).source, Component.literal("Clearing all " + this.f5509bC.size() + " objectives."));
            this.f5509bC.clear();
            m5650dd();
        })).m2840a("box", new C0620kx((commandContext5, strArr5) -> {
            String str;
            Player player = ((CommandSourceStack) commandContext5.getSource()).source;
            String str2 = strArr5[0];
            C1004sJ c1004sJM5649a = m5649a(str2);
            if (c1004sJM5649a == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext5.getSource()).source, Component.literal("Objective " + str2 + " was not found!"));
                return;
            }
            AABB aabbM1180j = this.f4643b.m1153a(player).m1115b().m1180j();
            c1004sJM5649a.f5558a.f4810g = aabbM1180j;
            CommandSource commandSource = ((CommandSourceStack) commandContext5.getSource()).source;
            if (aabbM1180j != null) {
                str = "Set capture box for " + str2 + " from your selection.";
            } else {
                str = "No AABB selection; cleared capture box for " + str2 + " (using radius).";
            }
            C0721ms.m3329b(commandSource, Component.literal(str));
        }).m2836a(C0622kz.m2847a(new String[]{"title"})).m2836a(C0622kz.f3554a).m2842a((commandContext6, strArr6) -> {
            return strArr6.length == 0 ? m5612g() : List.of();
        }))).m2840a("spawn", new C0620kx((commandContext7, strArr7) -> {
            Player player = ((CommandSourceStack) commandContext7.getSource()).source;
            String str = strArr7[0];
            String str2 = strArr7[1];
            C1004sJ c1004sJM5649a = m5649a(str);
            if (c1004sJM5649a == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Objective " + str + " was not found!"));
                return;
            }
            C0881pt c0881pt = new C0881pt(player);
            if (str2.equalsIgnoreCase("attacker")) {
                c1004sJM5649a.f5559bE.add(c0881pt);
                C0721ms.m3329b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Added attacker spawn to " + str + ". (" + c1004sJM5649a.f5559bE.size() + ")"));
            } else if (str2.equalsIgnoreCase("defender")) {
                c1004sJM5649a.f5560bF.add(c0881pt);
                C0721ms.m3329b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Added defender spawn to " + str + ". (" + c1004sJM5649a.f5560bF.size() + ")"));
            } else {
                C0721ms.m3329b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Role must be 'attacker' or 'defender'."));
                return;
            }
            m5615da();
        }).m2836a(C0622kz.m2847a(new String[]{"title", "role"})).m2836a(C0622kz.f3554a).m2842a((commandContext8, strArr8) -> {
            switch (strArr8.length) {
                case 0:
                    return m5612g();
                case 1:
                    return List.of("attacker", "defender");
                default:
                    return List.of();
            }
        })).m2840a("regroup", new C0620kx((commandContext9, strArr9) -> {
            Player player = ((CommandSourceStack) commandContext9.getSource()).source;
            String str = strArr9[0];
            C1004sJ c1004sJM5649a = m5649a(str);
            if (c1004sJM5649a == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext9.getSource()).source, Component.literal("Objective " + str + " was not found!"));
            } else {
                c1004sJM5649a.f5561i = new C0881pt(player);
                C0721ms.m3329b(((CommandSourceStack) commandContext9.getSource()).source, Component.literal("Set regroup point for " + str + "."));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"title"})).m2836a(C0622kz.f3554a).m2842a((commandContext10, strArr10) -> {
            return strArr10.length == 0 ? m5612g() : List.of();
        })).m2840a("boundary", new C0620kx().m2840a("set", new C0620kx((commandContext11, strArr11) -> {
            Player player = ((CommandSourceStack) commandContext11.getSource()).source;
            String str = strArr11[0];
            String str2 = strArr11[1];
            C1004sJ c1004sJM5649a = m5649a(str);
            if (c1004sJM5649a == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext11.getSource()).source, Component.literal("Objective " + str + " was not found!"));
                return;
            }
            C0882pu c0882puM1183c = this.f4643b.m1153a(player).m1115b().m1183c();
            if (c0882puM1183c == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext11.getSource()).source, Component.literal("No region selection! Select an area with the region wand first."));
                return;
            }
            if (str2.equalsIgnoreCase("attacker")) {
                c1004sJM5649a.f5562c = c0882puM1183c;
            } else if (str2.equalsIgnoreCase("defender")) {
                c1004sJM5649a.f5563d = c0882puM1183c;
            } else {
                C0721ms.m3329b(((CommandSourceStack) commandContext11.getSource()).source, Component.literal("Side must be 'attacker' or 'defender'."));
                return;
            }
            C0721ms.m3329b(((CommandSourceStack) commandContext11.getSource()).source, Component.literal("Set " + str2 + " boundary for " + str + " from your selection. (" + c0882puM1183c.m4599bt() + " points)"));
        }).m2836a(C0622kz.m2847a(new String[]{"title", "side"})).m2836a(C0622kz.f3554a).m2842a((commandContext12, strArr12) -> {
            switch (strArr12.length) {
                case 0:
                    return m5612g();
                case 1:
                    return List.of("attacker", "defender");
                default:
                    return List.of();
            }
        })).m2840a("clear", new C0620kx((commandContext13, strArr13) -> {
            String str = strArr13[0];
            String str2 = strArr13[1];
            C1004sJ c1004sJM5649a = m5649a(str);
            if (c1004sJM5649a == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext13.getSource()).source, Component.literal("Objective " + str + " was not found!"));
                return;
            }
            if (str2.equalsIgnoreCase("attacker")) {
                c1004sJM5649a.f5562c = new C0882pu();
            } else if (str2.equalsIgnoreCase("defender")) {
                c1004sJM5649a.f5563d = new C0882pu();
            } else {
                C0721ms.m3329b(((CommandSourceStack) commandContext13.getSource()).source, Component.literal("Side must be 'attacker' or 'defender'."));
                return;
            }
            C0721ms.m3329b(((CommandSourceStack) commandContext13.getSource()).source, Component.literal("Cleared " + str2 + " boundary for " + str + "."));
        }).m2836a(C0622kz.m2847a(new String[]{"title", "side"})).m2842a((commandContext14, strArr14) -> {
            switch (strArr14.length) {
                case 0:
                    return m5612g();
                case 1:
                    return List.of("attacker", "defender");
                default:
                    return List.of();
            }
        }))).m2840a("attacker", new C0620kx((commandContext15, strArr15) -> {
            String str = strArr15[0].equalsIgnoreCase("axis") ? C1062tN.f5783dl : C1062tN.f5782dk;
            this.f5511cJ = str;
            m5614cZ();
            C0721ms.m3329b(((CommandSourceStack) commandContext15.getSource()).source, Component.literal("Attacking team set to " + str + "."));
        }).m2836a(C0622kz.m2847a(new String[]{"team"})).m2842a((commandContext16, strArr16) -> {
            return strArr16.length == 0 ? List.of("allies", "axis") : List.of();
        }));
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1003sI mo3995a(@NotNull C0623l c0623l) {
        return new C1003sI(c0623l, this, (C0396gl) this.f4643b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1005sK mo3996a() {
        return new C1005sK(this, this.f4643b);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1056tH<C1001sG, C1005sK> mo3999a() {
        return new C1055tG(C1010sP::new);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4006a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f4644a.m5875b(abstractC0531jN, abstractC0184c, serverLevel);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: d */
    public void mo4041d(@Nullable Level level) {
        this.f5524sJ = -1;
        this.f5525sK = -1;
        this.f5526sL = -1;
        this.f5527sM = -1;
        m5613G(1);
    }

    /* JADX INFO: renamed from: G */
    public void m5613G(int i) {
        this.f5514sC = i;
        this.f5513sB = 4;
        this.f5515sD = 0;
        this.f5516sE = 0;
        this.f5517ht = false;
        this.f5520hu = false;
        this.f5521sG = 0;
        this.f5522sH = 0;
        this.f5523sI = 0;
        this.f5518sF = 0;
        this.f5519h.clear();
        m5614cZ();
    }

    /* JADX INFO: renamed from: cZ */
    private void m5614cZ() {
        this.f5512sA = 0;
        C0872pk c0872pkM5638g = m5638g();
        Iterator<C1004sJ> it = this.f5509bC.iterator();
        while (it.hasNext()) {
            C1002sH c1002sH = it.next().f5558a;
            c1002sH.m4556bd();
            c1002sH.f4803d = c0872pkM5638g;
        }
        m5615da();
    }

    /* JADX INFO: renamed from: da */
    private void m5615da() {
        C1004sJ c1004sJM5639a = m5639a();
        C0872pk c0872pkM5637f = m5637f();
        C0872pk c0872pkM5638g = m5638g();
        if (c0872pkM5637f != null) {
            c0872pkM5637f.m4311cF();
            if (c1004sJM5639a != null) {
                List<C0881pt> list = c1004sJM5639a.f5559bE;
                Objects.requireNonNull(c0872pkM5637f);
                list.forEach(c0872pkM5637f::m4310b);
            }
        }
        if (c0872pkM5638g != null) {
            c0872pkM5638g.m4311cF();
            if (c1004sJM5639a != null) {
                List<C0881pt> list2 = c1004sJM5639a.f5560bF;
                Objects.requireNonNull(c0872pkM5638g);
                list2.forEach(c0872pkM5638g::m4310b);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m5616c(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        if (this.f5518sF > 0) {
            this.f5518sF = Math.max(0, this.f5518sF - 20);
            if (this.f5518sF == 0) {
                m5617i(serverLevel);
            }
        }
        C1004sJ c1004sJM5639a = m5639a();
        if (c1004sJM5639a == null) {
            return;
        }
        c1004sJM5639a.f5558a.m4537a(abstractC0531jN, abstractC0184c, this, serverLevel, set);
        m5619a(abstractC0531jN, abstractC0184c, serverLevel);
        C1004sJ c1004sJM5639a2 = m5639a();
        if (c1004sJM5639a2 != null) {
            m5620a(abstractC0531jN, abstractC0184c, serverLevel, set, c1004sJM5639a2);
        }
    }

    /* JADX INFO: renamed from: i */
    public void m5617i(@NotNull ServerLevel serverLevel) {
        m5618a(serverLevel, m5637f());
    }

    /* JADX INFO: renamed from: a */
    private void m5618a(@NotNull ServerLevel serverLevel, @Nullable C0872pk c0872pk) {
        if (c0872pk == null) {
            return;
        }
        List<C0881pt> listM4309D = c0872pk.m4309D();
        if (listM4309D.isEmpty()) {
            return;
        }
        BlockPos blockPosM4587c = ((C0881pt) listM4309D.getFirst()).m4587c();
        serverLevel.playSound((Player) null, blockPosM4587c, (SoundEvent) C1312xz.f8878GP.get(), SoundSource.AMBIENT, f5505mG, 1.0f);
        serverLevel.playSound((Player) null, blockPosM4587c, (SoundEvent) C1312xz.f8877GO.get(), SoundSource.AMBIENT, f5505mG, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    private void m5619a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel) {
        int iM4320bo;
        C0872pk c0872pkM5637f = m5637f();
        if (c0872pkM5637f == null || (iM4320bo = c0872pkM5637f.m4320bo()) == 0) {
            return;
        }
        float fM5626c = (iM4320bo - m5626c(c0872pkM5637f)) / iM4320bo;
        if (this.f5513sB > 0 && fM5626c >= 0.35f) {
            this.f5515sD += 20;
            if (this.f5515sD >= 400) {
                this.f5515sD = 0;
                this.f5521sG = 0;
                this.f5513sB--;
                Iterator<ServerPlayer> it = m5624a(abstractC0531jN, abstractC0184c, serverLevel, c0872pkM5637f).iterator();
                while (it.hasNext()) {
                    C0875pn.m4365a(it.next(), (SoundEvent) C1312xz.f7990pL.get(), SoundSource.MUSIC, 1.5f, 1.0f);
                }
                C0875pn.m4427a((AbstractC0866pe<?>) this.f4642a, c0872pkM5637f, (Component) Component.translatable("bf.message.gamemode.of.waves.deployed").withStyle(ChatFormatting.WHITE), 60, "of.waves");
                return;
            }
            this.f5521sG = Math.max(1, (400 - this.f5515sD) / 20);
            return;
        }
        this.f5515sD = 0;
        this.f5521sG = 0;
    }

    /* JADX INFO: renamed from: a */
    private void m5620a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @NotNull C1004sJ c1004sJ) {
        C0872pk c0872pkM5638g = m5638g();
        if (c0872pkM5638g == null) {
            return;
        }
        int iM4320bo = c0872pkM5638g.m4320bo();
        if (iM4320bo == 0) {
            this.f5517ht = false;
            return;
        }
        int iM5626c = m5626c(c0872pkM5638g);
        int i = iM4320bo - iM5626c;
        float f = i / iM4320bo;
        boolean z = this.f5517ht;
        this.f5517ht = i > 0 && f >= 0.5f;
        if (!z && this.f5517ht) {
            C0875pn.m4361a(c0872pkM5638g.m4308h(), C0502il.m2254a().m2258d(EnumC1203vw.OFFENSIVE_REINFORCEMENTS_HINT));
            this.f5520hu = true;
        }
        if (!this.f5517ht) {
            this.f5516sE = 0;
            this.f5522sH = 0;
            return;
        }
        if (iM5626c == 0) {
            this.f5516sE += 20;
            if (this.f5516sE >= 200) {
                this.f5516sE = 0;
                this.f5522sH = 0;
                m5621a(abstractC0531jN, abstractC0184c, serverLevel, c0872pkM5638g);
                return;
            }
            this.f5522sH = Math.max(1, (200 - this.f5516sE) / 20);
            return;
        }
        this.f5516sE = 0;
        this.f5522sH = 0;
        if (m5623a(serverLevel, c0872pkM5638g, c1004sJ.f5561i, set)) {
            m5621a(abstractC0531jN, abstractC0184c, serverLevel, c0872pkM5638g);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5621a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull C0872pk c0872pk) {
        List<ServerPlayer> listM5624a = m5624a(abstractC0531jN, abstractC0184c, serverLevel, c0872pk);
        this.f5517ht = false;
        Iterator<ServerPlayer> it = listM5624a.iterator();
        while (it.hasNext()) {
            C0875pn.m4377a((Level) serverLevel, it.next().position(), (SoundEvent) C1312xz.f8000pV.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
        }
        C0875pn.m4361a(c0872pk.m4308h(), C0502il.m2254a().m2256b(EnumC1203vw.OFFENSIVE_REINFORCEMENTS_ARRIVE));
        this.f5520hu = false;
        C0875pn.m4427a((AbstractC0866pe<?>) this.f4642a, c0872pk, (Component) f5508v, 60, "of.rally");
    }

    /* JADX INFO: renamed from: db */
    public void m5622db() {
        if (this.f5520hu) {
            this.f5520hu = false;
            C0872pk c0872pkM5638g = m5638g();
            if (c0872pkM5638g != null) {
                C0875pn.m4361a(c0872pkM5638g.m4308h(), C0502il.m2254a().m2256b(EnumC1203vw.CONCLUDE_GENERIC));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m5623a(@NotNull ServerLevel serverLevel, @NotNull C0872pk c0872pk, @NotNull C0881pt c0881pt, @NotNull Set<UUID> set) {
        for (ServerPlayer serverPlayer : c0881pt.m4571a(serverLevel, 5, set)) {
            UUID uuid = serverPlayer.getUUID();
            if (c0872pk.m4315i(uuid) && !C0875pn.m4488a((Player) serverPlayer, (AbstractC0183b<?, ?, ?, ?>) this.f4643b.m1152b(uuid))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private List<ServerPlayer> m5624a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull C0872pk c0872pk) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (UUID uuid : c0872pk.m4308h()) {
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(uuid);
            if (serverPlayerM4399a != null && C0875pn.m4488a((Player) serverPlayerM4399a, (AbstractC0183b<?, ?, ?, ?>) abstractC0184c.m1152b(uuid))) {
                C0875pn.m4467a(abstractC0531jN, abstractC0184c, serverLevel, serverPlayerM4399a);
                objectArrayList.add(serverPlayerM4399a);
            }
        }
        C1004sJ c1004sJM5639a = m5639a();
        if (!objectArrayList.isEmpty() && c1004sJM5639a != null) {
            C0872pk c0872pkM5637f = m5637f();
            List<C0881pt> list = c0872pkM5637f != null && c0872pkM5637f.equals(c0872pk) ? c1004sJM5639a.f5559bE : c1004sJM5639a.f5560bF;
            if (!list.isEmpty()) {
                C1092tr c1092trM6164a = c0872pk.m4296a((AbstractC0863pb<?, ?, ?>) this).m6179a().m6164a();
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderM5991d = c1092trM6164a != null ? c1092trM6164a.m5991d() : null;
                if (deferredHolderM5991d != null) {
                    serverLevel.playSound((Player) null, ((C0881pt) list.getFirst()).m4587c(), (SoundEvent) deferredHolderM5991d.get(), SoundSource.PLAYERS, 5.0f, 1.0f);
                }
            }
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: a */
    private void m5625a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull C0872pk c0872pk) {
        m5624a(abstractC0531jN, this.f4643b, serverLevel, c0872pk);
        this.f5517ht = false;
        this.f5516sE = 0;
        this.f5522sH = 0;
    }

    /* JADX INFO: renamed from: c */
    private int m5626c(@NotNull C0872pk c0872pk) {
        int i = 0;
        for (UUID uuid : c0872pk.m4308h()) {
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(uuid);
            if (serverPlayerM4399a != null && !C0875pn.m4488a((Player) serverPlayerM4399a, (AbstractC0183b<?, ?, ?, ?>) this.f4643b.m1152b(uuid))) {
                i++;
            }
        }
        return i;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0882pu m5627a(@NotNull C0872pk c0872pk) {
        C1004sJ c1004sJM5639a = m5639a();
        if (c1004sJM5639a == null) {
            return null;
        }
        C0872pk c0872pkM5637f = m5637f();
        return (c0872pkM5637f == null || !c0872pkM5637f.equals(c0872pk)) ? c1004sJM5639a.f5563d : c1004sJM5639a.f5562c;
    }

    /* JADX INFO: renamed from: bW */
    public boolean m5628bW() {
        return this.f5518sF > 0;
    }

    /* JADX INFO: renamed from: bT */
    public int m5629bT() {
        if (this.f5518sF <= 0) {
            return 0;
        }
        return Math.max(1, this.f5518sF / 20);
    }

    /* JADX INFO: renamed from: h */
    public void m5630h(@NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        AbstractC0183b abstractC0183bM1152b = this.f4643b.m1152b(uuid);
        if (this.f4629a != EnumC0871pj.GAME || m5628bW() || C0875pn.m4488a((Player) serverPlayer, (AbstractC0183b<?, ?, ?, ?>) abstractC0183bM1152b) || abstractC0183bM1152b.m1116r() != null || ((C1005sK) this.f4642a).m4247g(uuid)) {
            this.f5519h.removeInt(uuid);
            return;
        }
        C0872pk c0872pkA = ((C1005sK) this.f4642a).m4229a(uuid);
        C0882pu c0882puM5627a = c0872pkA != null ? m5627a(c0872pkA) : null;
        if (c0882puM5627a == null || c0882puM5627a.m4608bE() || c0882puM5627a.m4604a((float) serverPlayer.getX(), (float) serverPlayer.getZ())) {
            this.f5519h.removeInt(uuid);
            return;
        }
        int orDefault = this.f5519h.getOrDefault(uuid, 200) - 1;
        if (orDefault <= 0) {
            this.f5519h.removeInt(uuid);
            serverPlayer.kill();
        } else {
            this.f5519h.put(uuid, orDefault);
        }
    }

    /* JADX INFO: renamed from: bX */
    public boolean m5631bX() {
        if (!this.f5509bC.isEmpty() && this.f5512sA >= this.f5509bC.size()) {
            return true;
        }
        C0872pk c0872pkM5637f = m5637f();
        return c0872pkM5637f != null && this.f5513sB <= 0 && m5626c(c0872pkM5637f) == 0;
    }

    /* JADX INFO: renamed from: bY */
    public boolean m5632bY() {
        return !this.f5509bC.isEmpty() && this.f5512sA >= this.f5509bC.size();
    }

    /* JADX INFO: renamed from: dc */
    public void m5633dc() {
        int iMin = Math.min(this.f5512sA, this.f5509bC.size());
        int iMax = Math.max(this.f5513sB, 0);
        if (this.f5514sC == 1) {
            this.f5524sJ = iMin;
            this.f5525sK = iMax;
        } else {
            this.f5526sL = iMin;
            this.f5527sM = iMax;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5634a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull AbstractC0184c<?> abstractC0184c) {
        C0872pk c0872pkA = ((C1005sK) this.f4642a).m4242a(C1062tN.f5782dk);
        C0872pk c0872pkA2 = ((C1005sK) this.f4642a).m4242a(C1062tN.f5783dl);
        if (c0872pkA == null || c0872pkA2 == null) {
            return;
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(c0872pkA.m4308h());
        ObjectArrayList objectArrayList2 = new ObjectArrayList(c0872pkA2.m4308h());
        c0872pkA.m4307cE();
        c0872pkA2.m4307cE();
        Iterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            c0872pkA2.m4305h((UUID) it.next());
        }
        Iterator it2 = objectArrayList2.iterator();
        while (it2.hasNext()) {
            c0872pkA.m4305h((UUID) it2.next());
        }
        m4073i().clear();
        c0872pkA.m4300a(C1062tN.f5759w, 0);
        c0872pkA.m4300a(C1062tN.f5760x, 0);
        c0872pkA2.m4300a(C1062tN.f5759w, 0);
        c0872pkA2.m4300a(C1062tN.f5760x, 0);
        m5613G(2);
        m5635a(serverLevel, abstractC0184c);
    }

    /* JADX INFO: renamed from: a */
    public void m5635a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0184c<?> abstractC0184c) {
        C0872pk c0872pkA;
        for (UUID uuid : ((C1005sK) this.f4642a).m4245h()) {
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(uuid);
            if (serverPlayerM4399a != null && (c0872pkA = ((C1005sK) this.f4642a).m4229a(uuid)) != null) {
                C0875pn.m4384a(abstractC0184c, serverLevel, serverPlayerM4399a);
                C0875pn.m4402a(abstractC0184c, serverPlayerM4399a, c0872pkA.m4299a((AbstractC0863pb<?, ?, ?>) this));
                C0875pn.m4474a(serverLevel, serverPlayerM4399a, this, c0872pkA);
                C0875pn.m4462f(serverPlayerM4399a);
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0887pz m5636a() {
        if (this.f5524sJ < 0 || this.f5526sL < 0) {
            return null;
        }
        C0872pk c0872pkM5637f = m5637f();
        C0872pk c0872pkM5638g = m5638g();
        if (this.f5526sL != this.f5524sJ) {
            return new C0887pz(this.f5526sL > this.f5524sJ ? c0872pkM5637f : c0872pkM5638g, null);
        }
        if (this.f5527sM != this.f5525sK) {
            return new C0887pz(this.f5527sM > this.f5525sK ? c0872pkM5637f : c0872pkM5638g, null);
        }
        return new C0887pz(null, null);
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public C0872pk m5637f() {
        return ((C1005sK) this.f4642a).m4242a(this.f5511cJ);
    }

    @Nullable
    /* JADX INFO: renamed from: g */
    public C0872pk m5638g() {
        C0872pk c0872pkM5637f = m5637f();
        if (c0872pkM5637f == null) {
            return null;
        }
        return c0872pkM5637f.m4316bz() ? ((C1005sK) this.f4642a).m4242a(C1062tN.f5783dl) : ((C1005sK) this.f4642a).m4242a(C1062tN.f5782dk);
    }

    @Override // com.boehmod.blockfront.InterfaceC0943rB
    /* JADX INFO: renamed from: a */
    public Component mo5178a(@NotNull ServerPlayer serverPlayer) {
        C0872pk c0872pkA = ((C1005sK) this.f4642a).m4242a(C1062tN.f5783dl);
        C0872pk c0872pkA2 = ((C1005sK) this.f4642a).m4242a(C1062tN.f5782dk);
        if (!f5531hv && c0872pkA == null) {
            throw new AssertionError();
        }
        if (f5531hv || c0872pkA2 != null) {
            return m4079a((Player) serverPlayer, c0872pkA.m4320bo(), c0872pkA2.m4320bo());
        }
        throw new AssertionError();
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

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1004sJ m5639a() {
        if (this.f5512sA >= 0 && this.f5512sA < this.f5509bC.size()) {
            return this.f5509bC.get(this.f5512sA);
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: aw */
    public List<C1004sJ> m5640aw() {
        return Collections.unmodifiableList(this.f5509bC);
    }

    /* JADX INFO: renamed from: bU */
    public int m5641bU() {
        return this.f5512sA;
    }

    /* JADX INFO: renamed from: bV */
    public int m5642bV() {
        return this.f5513sB;
    }

    /* JADX INFO: renamed from: bW */
    public int m5643bW() {
        return this.f5514sC;
    }

    /* JADX INFO: renamed from: bZ */
    public boolean m5644bZ() {
        return this.f5517ht;
    }

    /* JADX INFO: renamed from: bX */
    public int m5645bX() {
        return this.f5521sG;
    }

    /* JADX INFO: renamed from: bY */
    public int m5646bY() {
        return this.f5522sH;
    }

    /* JADX INFO: renamed from: bZ */
    public int m5647bZ() {
        return this.f5523sI;
    }

    /* JADX INFO: renamed from: H */
    public void m5648H(int i) {
        this.f5523sI = i;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private C1004sJ m5649a(@NotNull String str) {
        for (C1004sJ c1004sJ : this.f5509bC) {
            if (c1004sJ.f5558a.f4796bZ != null && c1004sJ.f5558a.f4796bZ.equalsIgnoreCase(str)) {
                return c1004sJ;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: dd */
    private void m5650dd() {
        m5651de();
        m5614cZ();
    }

    /* JADX INFO: renamed from: de */
    private void m5651de() {
        this.f5510bD.clear();
        Iterator<C1004sJ> it = this.f5509bC.iterator();
        while (it.hasNext()) {
            this.f5510bD.add(it.next().f5558a);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5652a(@Nullable C0680mD c0680mD) {
        this.f5528b = c0680mD;
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public C0680mD m5653c() {
        return this.f5528b;
    }

    /* JADX INFO: renamed from: b */
    public void m5654b(@Nullable C0680mD c0680mD) {
        this.f5529c = c0680mD;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public C0680mD m5655d() {
        return this.f5529c;
    }

    @Override // com.boehmod.blockfront.InterfaceC0978rk
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int mo5358a(@NotNull C1002sH c1002sH) {
        return 3;
    }

    @Override // com.boehmod.blockfront.InterfaceC0978rk
    /* JADX INFO: renamed from: Q */
    public List<C1002sH> mo5353Q() {
        return Collections.unmodifiableList(this.f5510bD);
    }

    /* JADX INFO: renamed from: a */
    public void m5657a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull Level level, @NotNull C1002sH c1002sH, @NotNull String str, @NotNull String str2, @NotNull Set<UUID> set) {
        this.f5512sA++;
        this.f5513sB = Math.min(8, this.f5513sB + 2);
        this.f5515sD = 0;
        m5615da();
        this.f5518sF = 400;
        C0872pk c0872pkM5637f = m5637f();
        if (!m5632bY()) {
            C0875pn.m4361a(set, C0502il.m2254a().m2256b(EnumC1203vw.OFFENSIVE_POINT_TAKEN));
            this.f5520hu = false;
        }
        C0875pn.m4377a(level, c1002sH.f4827c, (SoundEvent) C1312xz.f7997pS.get(), SoundSource.NEUTRAL, 2.0f, 1.0f);
        C0875pn.m4438a((AbstractC0863pb<?, ?, ?>) this, (Component) Component.translatable("bf.message.gamemode.of.point.captured", new Object[]{Component.literal(c1002sH.f4796bZ != null ? c1002sH.f4796bZ.toUpperCase(Locale.ROOT) : "?").withStyle(ChatFormatting.WHITE)}).withStyle(c0872pkM5637f != null ? c0872pkM5637f.m4312a() : Style.EMPTY), C0358g.f2490g, "of.capture", c1002sH.f4827c, c0872pkM5637f != null ? c0872pkM5637f.getColor() : ColorReferences.COLOR_WHITE, ColorReferences.COLOR_WHITE);
        C0872pk c0872pkM5638g = m5638g();
        if (c0872pkM5638g != null) {
            if (!m5632bY() && (level instanceof ServerLevel)) {
                m5625a(abstractC0531jN, (ServerLevel) level, c0872pkM5638g);
            }
            C0875pn.m4427a((AbstractC0866pe<?>) this.f4642a, c0872pkM5638g, (Component) Component.translatable("bf.message.gamemode.of.point.captured.retreat").withStyle(ChatFormatting.RED), C0358g.f2490g, "of.retreat");
        }
        Iterator<Player> it = c1002sH.m4570a(level, c1002sH.m4534a(mo5358a(c1002sH)), set).iterator();
        while (it.hasNext()) {
            UUID uuid = it.next().getUUID();
            C0875pn.m4451a(abstractC0531jN, this, uuid, C1062tN.f5748l, 3);
            C0875pn.m4450a(abstractC0531jN, this, uuid, C1062tN.f5753q);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0950rI mo4042a() {
        return new InterfaceC0950rI.f(this.f5509bC.stream().map(c1004sJ -> {
            C1002sH c1002sH = c1004sJ.f5558a;
            return new InterfaceC0950rI.g(new C0881pt(c1002sH.f4827c.x, c1002sH.f4827c.y, c1002sH.f4827c.z, c1002sH.f4826h.x, c1002sH.f4826h.y), c1002sH.f4796bZ, List.copyOf(c1004sJ.f5559bE), List.copyOf(c1004sJ.f5560bF), c1004sJ.f5561i, c1004sJ.f5562c, c1004sJ.f5563d, Optional.ofNullable(c1002sH.f4810g));
        }).toList(), this.f5511cJ, Optional.ofNullable(this.f5528b), Optional.ofNullable(this.f5529c));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4043a(@NotNull InterfaceC0950rI interfaceC0950rI) throws MatchException {
        if (interfaceC0950rI instanceof InterfaceC0950rI.f) {
            InterfaceC0950rI.f fVar = (InterfaceC0950rI.f) interfaceC0950rI;
            try {
                List<InterfaceC0950rI.g> listM5248ad = fVar.m5248ad();
                String strM5249ak = fVar.m5249ak();
                Optional<C0680mD> optionalM5250g = fVar.m5250g();
                Optional<C0680mD> optionalM5251h = fVar.m5251h();
                this.f5511cJ = strM5249ak;
                this.f5509bC.clear();
                for (InterfaceC0950rI.g gVar : listM5248ad) {
                    C1002sH c1002sH = new C1002sH((C1005sK) this.f4642a);
                    c1002sH.f4827c = gVar.m5253e().f4827c;
                    c1002sH.f4826h = gVar.m5253e().f4826h;
                    c1002sH.f4796bZ = gVar.m5254ab();
                    c1002sH.f4810g = gVar.m5260e().orElse(null);
                    C1004sJ c1004sJ = new C1004sJ(c1002sH);
                    c1004sJ.f5559bE.addAll(gVar.m5255ae());
                    c1004sJ.f5560bF.addAll(gVar.m5256af());
                    c1004sJ.f5561i = gVar.m5257g();
                    c1004sJ.f5562c = gVar.m5258a();
                    c1004sJ.f5563d = gVar.m5259b();
                    this.f5509bC.add(c1004sJ);
                }
                this.f5528b = optionalM5250g.orElse(null);
                this.f5529c = optionalM5251h.orElse(null);
                m5651de();
                m5613G(1);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4050a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.mo4050a(byteBuf, z);
        byteBuf.writeInt(this.f5512sA);
        byteBuf.writeInt(this.f5513sB);
        byteBuf.writeInt(this.f5514sC);
        byteBuf.writeBoolean(this.f5517ht);
        byteBuf.writeBoolean(C1062tN.f5783dl.equals(this.f5511cJ));
        byteBuf.writeInt(this.f5521sG);
        byteBuf.writeInt(this.f5522sH);
        byteBuf.writeInt(this.f5523sI);
        byteBuf.writeInt(this.f5518sF);
        byteBuf.writeInt(this.f5509bC.size());
        for (C1004sJ c1004sJ : this.f5509bC) {
            c1004sJ.f5558a.mo3870c(byteBuf);
            c1004sJ.f5561i.mo3870c(byteBuf);
            c1004sJ.f5562c.m4606c(byteBuf);
            c1004sJ.f5563d.m4606c(byteBuf);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: g */
    public void mo4052g(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo4052g(byteBuf);
        this.f5512sA = byteBuf.readInt();
        this.f5513sB = byteBuf.readInt();
        this.f5514sC = byteBuf.readInt();
        this.f5517ht = byteBuf.readBoolean();
        this.f5511cJ = byteBuf.readBoolean() ? C1062tN.f5783dl : C1062tN.f5782dk;
        this.f5521sG = byteBuf.readInt();
        this.f5522sH = byteBuf.readInt();
        this.f5523sI = byteBuf.readInt();
        this.f5518sF = byteBuf.readInt();
        int i = byteBuf.readInt();
        if (this.f5509bC.isEmpty()) {
            for (int i2 = 0; i2 < i; i2++) {
                C1004sJ c1004sJ = new C1004sJ(new C1002sH((C1005sK) this.f4642a, byteBuf));
                c1004sJ.f5561i.mo3869b(byteBuf);
                c1004sJ.f5562c.m4605b(byteBuf);
                c1004sJ.f5563d.m4605b(byteBuf);
                this.f5509bC.add(c1004sJ);
            }
            m5651de();
            return;
        }
        for (C1004sJ c1004sJ2 : this.f5509bC) {
            c1004sJ2.f5558a.mo3869b(byteBuf);
            c1004sJ2.f5561i.mo3869b(byteBuf);
            c1004sJ2.f5562c.m4605b(byteBuf);
            c1004sJ2.f5563d.m4605b(byteBuf);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx mo4082a() {
        return super.mo4082a().m2835a(this.f5530h);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: h */
    public void mo4083h(@NotNull List<MutableComponent> list) {
        if (this.f5509bC.isEmpty()) {
            list.add(Component.literal("Objectives in game '" + this.f4630bN + "' are missing."));
        }
        for (C1004sJ c1004sJ : this.f5509bC) {
            String str = c1004sJ.f5558a.f4796bZ;
            if (c1004sJ.f5559bE.isEmpty()) {
                list.add(Component.literal("Objective '" + str + "' in game '" + this.f4630bN + "' is missing attacker spawns."));
            }
            if (c1004sJ.f5560bF.isEmpty()) {
                list.add(Component.literal("Objective '" + str + "' in game '" + this.f4630bN + "' is missing defender spawns."));
            }
        }
        super.mo4083h(list);
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
        return new OffensiveMatchReportData(8, this.f5509bC.size());
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public boolean mo4033a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull EnumC0876po enumC0876po, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        C0872pk c0872pkB = ((C1005sK) this.f4642a).mo4241b();
        if (c0872pkB == null) {
            return false;
        }
        return ((C1005sK) this.f4642a).m4212a(abstractC0531jN, enumC0876po, serverLevel, serverPlayer, c0872pkB);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: f */
    public boolean mo4045f(@NotNull Player player) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bl */
    public boolean mo4047bl() {
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
        return CloudAchievements.ACH_MATCH_WIN_OF;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: e */
    public Set<C1093ts> mo3997e() {
        return Set.of(C1093ts.m6000a("anti_tank"));
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

    @Override // com.boehmod.blockfront.InterfaceC0982ro
    /* JADX INFO: renamed from: e */
    public boolean mo5354e(@NotNull ServerPlayer serverPlayer) {
        return this.f4629a == EnumC0871pj.GAME;
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
        C0875pn.m4379a(serverPlayer, new C1088tn(f5506jH, 40));
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.boehmod.blockfront.tx] */
    @Override // com.boehmod.blockfront.InterfaceC0980rm
    /* JADX INFO: renamed from: a */
    public void mo5341a(@NotNull C0715mm c0715mm) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.addAll(mo3996a().m6179a().m6163aF());
        objectArrayList.addAll(m4018b().m6179a().m6163aF());
        if (objectArrayList.isEmpty()) {
            return;
        }
        Collections.shuffle(objectArrayList);
        c0715mm.m3264c(new ItemStack((ItemLike) ((Supplier) objectArrayList.getFirst()).get()));
    }

    @Override // com.boehmod.blockfront.InterfaceC0980rm
    /* JADX INFO: renamed from: a */
    public int mo5342a(@NotNull C0715mm c0715mm) {
        return 3600;
    }

    @Override // com.boehmod.blockfront.InterfaceC0977rj
    /* JADX INFO: renamed from: a */
    public void mo5350a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull EnumC0883pv enumC0883pv) {
        m5551a(this, uuid, enumC0883pv);
    }
}
