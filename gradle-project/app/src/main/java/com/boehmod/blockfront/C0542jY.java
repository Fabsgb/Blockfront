package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000ac.SuspiciousShot;
import com.boehmod.bflib.cloud.common.p000ac.SuspiciousShotReason;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongListIterator;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.jY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jY.class */
public class C0542jY {

    /* JADX INFO: renamed from: am */
    public static final double f3223am = 2.0d;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C1264xD f3224b;

    /* JADX INFO: renamed from: lF */
    private final int f3225lF;

    /* JADX INFO: renamed from: lG */
    private static final int f3226lG = 3;

    /* JADX INFO: renamed from: s */
    private static final long f3227s = 20;

    /* JADX INFO: renamed from: t */
    private static final long f3228t = 30;

    /* JADX INFO: renamed from: u */
    private static final long f3229u = 2;

    /* JADX INFO: renamed from: hH */
    private static final float f3230hH = 5.0f;

    /* JADX INFO: renamed from: lH */
    private static final int f3231lH = 6;

    /* JADX INFO: renamed from: an */
    private static final double f3232an = 2.0d;

    /* JADX INFO: renamed from: v */
    private static final long f3235v = 20;

    /* JADX INFO: renamed from: aa */
    @NotNull
    private static final List<InterfaceC0597ka> f3233aa = List.of(C0542jY::m2423a, C0542jY::m2424b, C0542jY::m2425c);

    /* JADX INFO: renamed from: ab */
    @NotNull
    private static final List<InterfaceC0597ka> f3234ab = List.of(C0542jY::m2426d, C0542jY::m2427e, C0542jY::m2428f, C0542jY::m2429g, C0542jY::m2430h);

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final Long2ObjectMap<List<C0598kb>> f3236d = new Long2ObjectOpenHashMap();

    public C0542jY(@NotNull C1264xD c1264xD) {
        this(c1264xD, 3);
    }

    public C0542jY(@NotNull C1264xD c1264xD, int i) {
        this.f3224b = c1264xD;
        this.f3225lF = i;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0541jX m2421a(@NotNull C1280xT c1280xT, @NotNull C1328yo c1328yo, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull ItemStack itemStack, @NotNull C1117uP c1117uP, boolean z, @NotNull List<C1120uS> list, Vec3 vec3, Vec2 vec2, float f, float f2, long j) {
        C1326ym c1326ym = (C1326ym) c1328yo.m1150a((Player) serverPlayer);
        boolean zM2652am = c1326ym.m8300a().m2652am();
        long jM7134l = this.f3224b.m7134l();
        boolean z2 = j > jM7134l;
        C0602kf c0602kf = new C0602kf(c1280xT, serverLevel, serverPlayer, c1326ym, this.f3224b, itemStack, c1117uP, z, list, vec3, f, j, jM7134l, z2, zM2652am);
        if (m2422a(f3233aa, c0602kf) != null) {
            return C0541jX.f3221a;
        }
        if (z2) {
            long j2 = j - jM7134l;
            if (j2 > 20) {
                m2435a(c0602kf, SuspiciousShotReason.PREDICTION_TOO_FAR, "attempted to validate a shot too far in the future: " + j + " (" + c0602kf + " ticks ahead). Current tick: " + j2 + ". Max prediction: 20 ticks");
                return C0541jX.f3221a;
            }
            C0598kb c0598kb = new C0598kb(j, serverPlayer, c1280xT, c1328yo, itemStack.copy(), c1117uP, z, list, vec3, vec2, f, f2);
            synchronized (f3236d) {
                ((List) f3236d.computeIfAbsent(j, j3 -> {
                    return new ObjectArrayList();
                })).add(c0598kb);
            }
            if (zM2652am) {
                C0875pn.m4410a(serverLevel, c1280xT, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " submitted a future-time shot (tick " + j + ", " + serverLevel + " ticks ahead). Stored for validation when time is reached.").withStyle(ChatFormatting.YELLOW));
            }
            return C0541jX.f3222b;
        }
        if (m2422a(f3234ab, c0602kf) != null) {
            return C0541jX.f3221a;
        }
        try {
            ObjectArrayList objectArrayList = new ObjectArrayList(list.size());
            for (C1120uS c1120uS : list) {
                int iM6410cs = c1120uS.m6410cs();
                C1186vf c1186vf = new C1186vf(serverPlayer, c1328yo, c1117uP.m6369a(), this.f3224b, vec3, vec2, f, f2, j, this.f3225lF);
                long jM6414a = C1121uT.m6414a(serverPlayer.getUUID(), j, iM6410cs);
                List<C1115uN> listM6757a = c1186vf.m6757a(c1280xT, serverLevel, RandomSource.create(jM6414a), new Random(jM6414a), (LivingEntity) serverPlayer, c1117uP, c1117uP.m6315a(itemStack), j, jM6414a, iM6410cs);
                if (!m2437a(c0602kf, c1120uS.m6411aH(), listM6757a)) {
                    return C0541jX.f3221a;
                }
                objectArrayList.add(new C1120uS(iM6410cs, m2436a(serverLevel, c1120uS.m6411aH(), listM6757a), c1186vf.m6758aP()));
            }
            if (zM2652am || C0549jf.f3271dt) {
                m2431a(c0602kf, vec2, f2, objectArrayList);
            }
            if (zM2652am) {
                C0875pn.m4410a(serverLevel, c1280xT, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " successfully validated a shot of " + objectArrayList.size() + " pellet(s).").withStyle(ChatFormatting.GREEN));
            }
            return C0541jX.m2417a(objectArrayList);
        } catch (Exception e) {
            C0530jM.log("Shot validation threw for player " + serverPlayer.getScoreboardName() + ": " + String.valueOf(e), new Object[0]);
            return C0541jX.f3221a;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static C0601ke m2422a(@NotNull List<InterfaceC0597ka> list, @NotNull C0602kf c0602kf) {
        Iterator<InterfaceC0597ka> it = list.iterator();
        while (it.hasNext()) {
            C0601ke c0601keCheck = it.next().check(c0602kf);
            if (c0601keCheck != null) {
                SuspiciousShotReason suspiciousShotReasonM2671a = c0601keCheck.m2671a();
                if (suspiciousShotReasonM2671a != null) {
                    m2435a(c0602kf, suspiciousShotReasonM2671a, c0601keCheck.m2672C());
                } else if (c0602kf.m2689ar()) {
                    C0875pn.m4410a(c0602kf.m2676a(), c0602kf.m2675b(), (Component) Component.literal("Player " + c0602kf.m2677a().getScoreboardName() + " " + c0601keCheck.m2672C()).withStyle(ChatFormatting.RED));
                }
                return c0601keCheck;
            }
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static C0601ke m2423a(@NotNull C0602kf c0602kf) {
        List<C1120uS> listM2683r = c0602kf.m2683r();
        int iM6878cx = c0602kf.m2681b().m6315a(c0602kf.m2680b()).m6878cx();
        boolean z = listM2683r.size() == iM6878cx;
        if (z) {
            IntOpenHashSet intOpenHashSet = new IntOpenHashSet(iM6878cx);
            Iterator<C1120uS> it = listM2683r.iterator();
            while (it.hasNext()) {
                int iM6410cs = it.next().m6410cs();
                if (iM6410cs < 0 || iM6410cs >= iM6878cx || !intOpenHashSet.add(iM6410cs)) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            return null;
        }
        return C0601ke.m2669a(SuspiciousShotReason.INVALID_PELLET_SET, "reported an invalid pellet1 set: " + listM2683r.size() + " pellet(s) for a weapon firing " + iM6878cx);
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    private static C0601ke m2424b(@NotNull C0602kf c0602kf) {
        if (!C0549jf.f3268dq || c0602kf.m2682al()) {
            return null;
        }
        C1117uP c1117uPM2681b = c0602kf.m2681b();
        float fM2685ae = c0602kf.m2685ae();
        DeferredItem<? extends C1119uR> deferredItemA = c1117uPM2681b.m6294a();
        C1188vh c1188vhM6296a = c1117uPM2681b.m6296a(c0602kf.m2680b());
        float fM6418a = C1123uV.m6418a((C1129ub) deferredItemA, c1188vhM6296a, c1117uPM2681b.m6366cF());
        float fM6419a = C1123uV.m6419a(c1188vhM6296a, (C1129ub) deferredItemA);
        if (!C1123uV.m6420a(fM2685ae, fM6418a, fM6419a)) {
            return C0601ke.m2669a(SuspiciousShotReason.INVALID_SPREAD, "reported an invalid spread: " + String.format("%.4f", Float.valueOf(fM2685ae)) + ". Expected range: [" + String.format("%.4f", Float.valueOf(fM6418a)) + ", " + String.format("%.4f", Float.valueOf(fM6419a)) + "]");
        }
        if (c0602kf.m2689ar()) {
            C0875pn.m4410a(c0602kf.m2676a(), c0602kf.m2675b(), (Component) Component.literal("Player " + c0602kf.m2677a().getScoreboardName() + " reported a valid spread: " + String.format("%.4f", Float.valueOf(fM2685ae)) + ". Expected range: [" + String.format("%.4f", Float.valueOf(fM6418a)) + ", " + String.format("%.4f", Float.valueOf(fM6419a)) + "]").withStyle(ChatFormatting.GRAY));
            return null;
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    private static C0601ke m2425c(@NotNull C0602kf c0602kf) {
        ItemStack itemStackM2680b = c0602kf.m2680b();
        long jM2686g = c0602kf.m2686g();
        C0600kd c0600kdM8301a = c0602kf.m2678a().m8301a();
        if (!c0600kdM8301a.m2666a(itemStackM2680b, jM2686g, !c0602kf.m2688aq())) {
            int iM6875cw = c0602kf.m2681b().m6315a(itemStackM2680b).m6875cw();
            long jM2667a = c0600kdM8301a.m2667a(itemStackM2680b);
            long j = jM2667a >= 0 ? jM2686g - jM2667a : 0L;
            SuspiciousShotReason suspiciousShotReason = SuspiciousShotReason.FIRE_RATE;
            itemStackM2680b.getItem().getDescriptionId();
            return C0601ke.m2669a(suspiciousShotReason, "violated fire rate limit: Expected minimum " + iM6875cw + " ticks between trigger pulls, but only " + j + " ticks passed. Weapon: " + suspiciousShotReason);
        }
        if (c0602kf.m2689ar()) {
            C0875pn.m4410a(c0602kf.m2676a(), c0602kf.m2675b(), (Component) Component.literal("Player " + c0602kf.m2677a().getScoreboardName() + " passed fire rate validation for " + itemStackM2680b.getItem().getDescriptionId()).withStyle(ChatFormatting.GRAY));
            return null;
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    private static C0601ke m2426d(@NotNull C0602kf c0602kf) {
        if (c0602kf.m2686g() < c0602kf.m2679b().m7135m()) {
            SuspiciousShotReason suspiciousShotReason = SuspiciousShotReason.STALE_TICK;
            return C0601ke.m2669a(suspiciousShotReason, "attempted to validate a shot with an old tick: " + c0602kf.m2686g() + ". Oldest tick: " + suspiciousShotReason);
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    private static C0601ke m2427e(@NotNull C0602kf c0602kf) {
        long jM2687h = c0602kf.m2687h() - c0602kf.m2686g();
        if (jM2687h > 20) {
            return C0601ke.m2670a("attempted to validate a shot " + jM2687h + " ticks in the past. Max backtrack: 20 ticks");
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    private static C0601ke m2428f(@NotNull C0602kf c0602kf) {
        if (c0602kf.m2679b().m7133f(c0602kf.m2686g())) {
            return C0601ke.m2670a("attempted to validate a shot with no data for tick: " + c0602kf.m2686g());
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: g */
    private static C0601ke m2429g(@NotNull C0602kf c0602kf) {
        Vec3 vec3M2684h = c0602kf.m2684h();
        Vec3 vec3M2674j = c0602kf.m2674j();
        if (!vec3M2674j.closerThan(vec3M2684h, 2.0d)) {
            float fDistanceTo = (float) vec3M2674j.distanceTo(vec3M2684h);
            SuspiciousShotReason suspiciousShotReason = SuspiciousShotReason.INVALID_POSITION;
            String str = String.format("%.2f", Float.valueOf(fDistanceTo));
            long jM2686g = c0602kf.m2686g();
            double d = vec3M2684h.x;
            double d2 = vec3M2684h.y;
            double d3 = vec3M2684h.z;
            return C0601ke.m2669a(suspiciousShotReason, "attempted to validate a shot from an invalid position: " + str + " blocks away at tick " + jM2686g + ". (" + suspiciousShotReason + ", " + d + ", " + suspiciousShotReason + ")");
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: h */
    private static C0601ke m2430h(@NotNull C0602kf c0602kf) {
        C0543jZ c0543jZM2673a = c0602kf.m2673a();
        if (c0543jZM2673a != null && !c0543jZM2673a.m2452ak()) {
            return C0601ke.m2669a(SuspiciousShotReason.CANNOT_SHOOT, "attempted to validate a shot while unable to shoot at tick: " + c0602kf.m2686g());
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private static void m2431a(@NotNull C0602kf c0602kf, @NotNull Vec2 vec2, float f, @NotNull List<C1120uS> list) {
        C0543jZ c0543jZM7131a;
        C0599kc c0599kcM8300a = c0602kf.m2678a().m8300a();
        C1115uN c1115uN = null;
        C0543jZ c0543jZ = null;
        boolean z = false;
        boolean zM6250an = false;
        Iterator<C1120uS> it = list.iterator();
        while (it.hasNext()) {
            for (C1115uN c1115uN2 : it.next().m6411aH()) {
                if (!(c0602kf.m2676a().getEntity(c1115uN2.m6248aB()) instanceof InterfaceC0696mT)) {
                    z = true;
                    zM6250an |= c1115uN2.m6250an();
                    if (c1115uN == null && (c0543jZM7131a = c0602kf.m2679b().m7131a(c0602kf.m2686g(), c1115uN2.m6248aB())) != null) {
                        c1115uN = c1115uN2;
                        c0543jZ = c0543jZM7131a;
                    }
                }
            }
        }
        C1117uP c1117uPM2681b = c0602kf.m2681b();
        c0599kcM8300a.m2635a(z, zM6250an, c0602kf.m2686g(), c1117uPM2681b.m6315a(c0602kf.m2680b()).m6875cw(), Math.abs(f), (c0602kf.m2682al() || c1117uPM2681b.m6366cF() || c1117uPM2681b.m6395a().m5933bk() == 0.0f) ? false : true);
        boolean zAR = c0602kf.m2678a().m1128aR();
        long jM2637a = c0599kcM8300a.m2637a(c0602kf.m2686g());
        while (true) {
            long j = jM2637a;
            if (j > c0602kf.m2686g()) {
                break;
            }
            C0543jZ c0543jZM7131a2 = c0602kf.m2679b().m7131a(j, c0602kf.m2677a().getId());
            C0543jZ c0543jZM7131a3 = c0602kf.m2679b().m7131a(j - 1, c0602kf.m2677a().getId());
            if (c0543jZM7131a2 != null && c0543jZM7131a3 != null) {
                c0599kcM8300a.m2638a(zAR, c0543jZM7131a3.m2449ac(), c0543jZM7131a2.m2449ac(), c0543jZM7131a3.m2450ad(), c0543jZM7131a2.m2450ad());
            }
            jM2637a = j + 1;
        }
        if (c1115uN == null) {
            return;
        }
        Vec3 vec3M2684h = c0602kf.m2684h();
        Vec3 vec3DirectionFromRotation = Vec3.directionFromRotation(vec2);
        Vec3 vec3Subtract = c0543jZ.m2447g().getCenter().subtract(vec3M2684h);
        double length = vec3Subtract.length();
        if (length < 0.001d) {
            return;
        }
        float degrees = (float) Math.toDegrees(Math.atan2(-vec3Subtract.x, vec3Subtract.z));
        float f2 = (float) (-Math.toDegrees(Math.atan2(vec3Subtract.y, Math.sqrt((vec3Subtract.x * vec3Subtract.x) + (vec3Subtract.z * vec3Subtract.z)))));
        float fWrapDegrees = Mth.wrapDegrees(vec2.y - degrees);
        float f3 = vec2.x - f2;
        float fTan = (float) (length * Math.tan(Math.toRadians(fWrapDegrees)));
        float fTan2 = (float) (length * Math.tan(Math.toRadians(f3)));
        float fM2434a = m2434a(vec3DirectionFromRotation, vec3Subtract);
        String str = "body";
        AABB aabbM2441e = c0543jZ.m2441e();
        if (aabbM2441e != null) {
            float fM2434a2 = m2434a(vec3DirectionFromRotation, aabbM2441e.getCenter().subtract(vec3M2684h));
            if (fM2434a2 < fM2434a) {
                fM2434a = fM2434a2;
                str = "head";
            }
        }
        AABB aabbM2442f = c0543jZ.m2442f();
        if (aabbM2442f != null) {
            float fM2434a3 = m2434a(vec3DirectionFromRotation, aabbM2442f.getCenter().subtract(vec3M2684h));
            if (fM2434a3 < fM2434a) {
                fM2434a = fM2434a3;
                str = C0394gj.f2552af;
            }
        }
        float fM2434a4 = Float.NaN;
        C0543jZ c0543jZM7131a4 = c0602kf.m2679b().m7131a(c0602kf.m2686g() - 1, c0602kf.m2677a().getId());
        if (c0543jZM7131a4 != null) {
            fM2434a4 = m2434a(Vec3.directionFromRotation(c0543jZM7131a4.m2450ad(), c0543jZM7131a4.m2449ac()), vec3DirectionFromRotation);
        }
        float fM2434a5 = Float.NaN;
        C0543jZ c0543jZM7131a5 = c0602kf.m2679b().m7131a(c0602kf.m2686g() - 3, c0602kf.m2677a().getId());
        C0543jZ c0543jZM7131a6 = c0602kf.m2679b().m7131a(c0602kf.m2686g() - 3, c1115uN.m6248aB());
        if (c0543jZM7131a5 != null && c0543jZM7131a6 != null) {
            fM2434a5 = m2434a(Vec3.directionFromRotation(c0543jZM7131a5.m2450ad(), c0543jZM7131a5.m2449ac()), c0543jZM7131a6.m2447g().getCenter().subtract(c0543jZM7131a5.m2443g()));
        }
        c0602kf.m2678a().m8300a().m2634a(new C0599kc.a(fM2434a, fTan, fTan2, fM2434a4, fM2434a5, str, c1115uN.m6250an()));
        if (c0599kcM8300a.m2644d(c0602kf.m2686g())) {
            m2432a(c0602kf, c1115uN.m6248aB());
        }
        if (c0602kf.m2689ar() && !Float.isNaN(fM2434a4) && fM2434a4 >= 15.0f) {
            C0875pn.m4410a(c0602kf.m2676a(), c0602kf.m2675b(), (Component) Component.literal("Player " + c0602kf.m2677a().getScoreboardName() + " SNAP " + String.format("%.1f", Float.valueOf(fM2434a4)) + "deg onto " + str).withStyle(ChatFormatting.RED));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2432a(@NotNull C0602kf c0602kf, int i) {
        C1264xD c1264xDM2679b = c0602kf.m2679b();
        int id = c0602kf.m2677a().getId();
        long jM2686g = c0602kf.m2686g();
        int i2 = 0;
        int i3 = 0;
        Vec3 vec3M2446h = null;
        Vec3 vec3M2446h2 = null;
        long jMax = Math.max(c1264xDM2679b.m7135m(), jM2686g - f3228t);
        while (true) {
            long j = jMax;
            if (j >= jM2686g) {
                break;
            }
            C0543jZ c0543jZM7131a = c1264xDM2679b.m7131a(j, id);
            C0543jZ c0543jZM7131a2 = c1264xDM2679b.m7131a(j, i);
            if (c0543jZM7131a != null && c0543jZM7131a2 != null) {
                Vec3 vec3M2443g = c0543jZM7131a.m2443g();
                Vec3 center = c0543jZM7131a2.m2447g().getCenter();
                if (m2434a(Vec3.directionFromRotation(c0543jZM7131a.m2450ad(), c0543jZM7131a.m2449ac()), center.subtract(vec3M2443g)) <= 5.0f) {
                    i2++;
                    if (vec3M2446h == null) {
                        vec3M2446h = c0543jZM7131a2.m2446h();
                    }
                    vec3M2446h2 = c0543jZM7131a2.m2446h();
                    if (m2433a(c0602kf, vec3M2443g, center) && m2433a(c0602kf, vec3M2443g, c0543jZM7131a2.m2443g())) {
                        i3++;
                    }
                }
            }
            jMax = j + f3229u;
        }
        if (i2 < 6 || vec3M2446h == null || vec3M2446h.distanceTo(vec3M2446h2) < 2.0d) {
            return;
        }
        c0602kf.m2678a().m8300a().m2636g(i3 / i2);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m2433a(@NotNull C0602kf c0602kf, @NotNull Vec3 vec3, @NotNull Vec3 vec4) {
        return c0602kf.m2676a().clip(new ClipContext(vec3, vec4, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, c0602kf.m2677a())).getType() == HitResult.Type.BLOCK;
    }

    /* JADX INFO: renamed from: a */
    private static float m2434a(@NotNull Vec3 vec3, @NotNull Vec3 vec4) {
        double length = vec3.length() * vec4.length();
        if (length < 1.0E-9d) {
            return 0.0f;
        }
        return (float) Math.toDegrees(Math.acos(Mth.clamp(vec3.dot(vec4) / length, -1.0d, 1.0d)));
    }

    /* JADX INFO: renamed from: a */
    private static void m2435a(@NotNull C0602kf c0602kf, @NotNull SuspiciousShotReason suspiciousShotReason, @NotNull String str) {
        c0602kf.m2678a().m8300a().m2651a(new SuspiciousShot(suspiciousShotReason, str, c0602kf.m2680b().getItem().getDescriptionId(), c0602kf.m2686g(), System.currentTimeMillis()));
        if (c0602kf.m2689ar()) {
            C0875pn.m4410a(c0602kf.m2676a(), c0602kf.m2675b(), (Component) Component.literal("Player " + c0602kf.m2677a().getScoreboardName() + " " + str).withStyle(ChatFormatting.RED));
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static List<C1115uN> m2436a(@NotNull ServerLevel serverLevel, @NotNull List<C1115uN> list, @NotNull List<C1115uN> list2) {
        Int2ObjectOpenHashMap int2ObjectOpenHashMap = new Int2ObjectOpenHashMap(list2.size());
        for (C1115uN c1115uN : list2) {
            int2ObjectOpenHashMap.put(c1115uN.m6248aB(), c1115uN);
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(list.size());
        IntOpenHashSet intOpenHashSet = new IntOpenHashSet(list.size());
        for (C1115uN c1115uN2 : list) {
            int iM6248aB = c1115uN2.m6248aB();
            if (intOpenHashSet.add(iM6248aB)) {
                C1115uN c1115uN3 = (C1115uN) int2ObjectOpenHashMap.get(iM6248aB);
                if (c1115uN3 != null) {
                    objectArrayList.add(new C1115uN(iM6248aB, c1115uN3.m6249bA(), c1115uN3.m6250an(), c1115uN3.m6251cy(), c1115uN2.m6252cz(), c1115uN3.m6253cA(), c1115uN3.m6254b(), c1115uN3.m6255A()));
                } else if (serverLevel.getEntity(iM6248aB) instanceof InterfaceC0696mT) {
                    objectArrayList.add(c1115uN2);
                }
            }
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m2437a(@NotNull C0602kf c0602kf, @NotNull List<C1115uN> list, @NotNull List<C1115uN> list2) {
        IntOpenHashSet intOpenHashSet = new IntOpenHashSet();
        Iterator<C1115uN> it = list.iterator();
        while (it.hasNext()) {
            intOpenHashSet.add(it.next().m6248aB());
        }
        intOpenHashSet.removeIf(i -> {
            return c0602kf.m2676a().getEntity(i) instanceof InterfaceC0696mT;
        });
        IntOpenHashSet intOpenHashSet2 = new IntOpenHashSet(list2.size());
        Iterator<C1115uN> it2 = list2.iterator();
        while (it2.hasNext()) {
            intOpenHashSet2.add(it2.next().m6248aB());
        }
        IntIterator it3 = intOpenHashSet.iterator();
        while (it3.hasNext()) {
            int iIntValue = ((Integer) it3.next()).intValue();
            if (!intOpenHashSet2.contains(iIntValue)) {
                m2435a(c0602kf, SuspiciousShotReason.HIT_MISMATCH, "reported a hit on entity ID " + iIntValue + " that was not found in the server's hit results. Server hits: " + String.valueOf(intOpenHashSet2));
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static void m2438a(@NotNull C1264xD c1264xD) {
        long jM7134l = c1264xD.m7134l();
        synchronized (f3236d) {
            LongArrayList longArrayList = new LongArrayList();
            ObjectIterator it = f3236d.long2ObjectEntrySet().iterator();
            while (it.hasNext()) {
                long longKey = ((Long2ObjectMap.Entry) it.next()).getLongKey();
                if (longKey <= jM7134l) {
                    longArrayList.add(longKey);
                }
            }
            LongListIterator it2 = longArrayList.iterator();
            while (it2.hasNext()) {
                List<C0598kb> list = (List) f3236d.remove(((Long) it2.next()).longValue());
                if (list != null && !list.isEmpty()) {
                    for (C0598kb c0598kb : list) {
                        if (!C0875pn.m4488a((Player) c0598kb.m2623a(), (AbstractC0183b<?, ?, ?, ?>) c0598kb.m2625a().m1150a((Player) c0598kb.m2623a()))) {
                            C0541jX c0541jXM2421a = new C0542jY(c1264xD).m2421a(c0598kb.m2624a(), c0598kb.m2625a(), c0598kb.m2623a().serverLevel(), c0598kb.m2623a(), c0598kb.m2626b(), c0598kb.m2627b(), c0598kb.m2628al(), c0598kb.m2629r(), c0598kb.m2630h(), c0598kb.m2631a(), c0598kb.m2632ae(), c0598kb.m2633af(), c0598kb.m2622g());
                            if (c0541jXM2421a.m2418aj()) {
                                C1280xT c1280xTM2624a = c0598kb.m2624a();
                                C1185ve.m6750a((AbstractC0531jN<?, ?, ?>) c1280xTM2624a, (AbstractC0184c<?>) c0598kb.m2625a(), c0598kb.m2623a().serverLevel(), (LivingEntity) c0598kb.m2623a(), c1280xTM2624a.m2353a((Player) c0598kb.m2623a()), c0541jXM2421a.m2420q());
                            }
                        }
                    }
                }
            }
        }
    }
}
