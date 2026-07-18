package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
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
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jF.class */
public class C0522jF {

    /* JADX INFO: renamed from: ae */
    public static final double f3067ae = 2.0d;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C1284xg f3068b;

    /* JADX INFO: renamed from: jY */
    private final int f3069jY;

    /* JADX INFO: renamed from: jZ */
    private static final int f3070jZ = 3;

    /* JADX INFO: renamed from: n */
    private static final long f3071n = 20;

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final Long2ObjectMap<List<C0524jH>> f3072b = new Long2ObjectOpenHashMap();

    public C0522jF(@NotNull C1284xg c1284xg) {
        this(c1284xg, 3);
    }

    public C0522jF(@NotNull C1284xg c1284xg, int i) {
        this.f3068b = c1284xg;
        this.f3069jY = i;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0521jE m2287a(@NotNull C1300xw c1300xw, @NotNull C1276xQ c1276xQ, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull List<C1142up> list, Vec3 vec3, Vec2 vec2, float f, float f2, long j, long j2, int i) {
        C0732nD c0732nDM3535a;
        C1274xO c1274xO = (C1274xO) c1276xQ.m1133a((Player) serverPlayer);
        boolean zM2323ah = c1274xO.m7784a().m2323ah();
        long jM7811k = this.f3068b.m7811k();
        boolean z = j > jM7811k;
        boolean z2 = false;
        ItemStack itemInHand = serverPlayer.getItemInHand(InteractionHand.MAIN_HAND);
        Entity vehicle = serverPlayer.getVehicle();
        if ((vehicle instanceof AbstractC0779ny) && (c0732nDM3535a = ((AbstractC0779ny) vehicle).m3535a((Entity) serverPlayer)) != null) {
            Iterator<AbstractC0742nN<?>> it = c0732nDM3535a.m3327b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbstractC0742nN<?> next = it.next();
                if (next instanceof C0740nL) {
                    itemInHand = new ItemStack(((C0740nL) next).m3392c());
                    z2 = true;
                    break;
                }
            }
        }
        Item item = itemInHand.getItem();
        if (!(item instanceof C1144ur)) {
            if (zM2323ah) {
                C0799oR.m3974a(serverLevel, c1300xw, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " attempted to validate a shot without holding a gun item.").withStyle(ChatFormatting.RED));
            }
            return C0521jE.f3065a;
        }
        C1144ur c1144ur = (C1144ur) item;
        if (C0476iM.f2919dg && !z2 && !m2290a(c1300xw, serverLevel, serverPlayer, zM2323ah, f, c1144ur, itemInHand, c1274xO)) {
            return C0521jE.f3065a;
        }
        if (!serverPlayer.getEyePosition().closerThan(vec3, 2.0d)) {
            if (zM2323ah) {
                float fDistanceTo = (float) serverPlayer.getEyePosition().distanceTo(vec3);
                String scoreboardName = serverPlayer.getScoreboardName();
                String str = String.format("%.2f", Float.valueOf(fDistanceTo));
                double d = vec3.x;
                double d2 = vec3.y;
                double d3 = vec3.z;
                C0799oR.m3974a(serverLevel, c1300xw, (Component) Component.literal("Player " + scoreboardName + " attempted to validate a shot from an invalid position: " + str + " blocks away. (" + d + ", " + serverLevel + ", " + d2 + ")").withStyle(ChatFormatting.RED));
            }
            return C0521jE.f3065a;
        }
        if (!m2291a(c1300xw, serverLevel, serverPlayer, zM2323ah, itemInHand, c1144ur, j, c1274xO, !z)) {
            return C0521jE.f3065a;
        }
        if (z) {
            long j3 = j - jM7811k;
            if (j3 > f3071n) {
                if (zM2323ah) {
                    C0799oR.m3974a(serverLevel, c1300xw, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " attempted to validate a shot too far in the future: " + j + " (" + serverLevel + " ticks ahead). Current tick: " + j3 + ". Max prediction: 20 ticks").withStyle(ChatFormatting.RED));
                }
                return C0521jE.f3065a;
            }
            C0524jH c0524jH = new C0524jH(j, serverPlayer, c1300xw, c1276xQ, list, vec3, vec2, f, f2, j2, i);
            synchronized (f3072b) {
                ((List) f3072b.computeIfAbsent(j, j4 -> {
                    return new ObjectArrayList();
                })).add(c0524jH);
            }
            if (zM2323ah) {
                C0799oR.m3974a(serverLevel, c1300xw, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " submitted a future-time hit (tick " + j + ", " + serverLevel + " ticks ahead). Stored for validation when time is reached.").withStyle(ChatFormatting.YELLOW));
            }
            return C0521jE.f3066b;
        }
        if (j < this.f3068b.m7812l()) {
            if (zM2323ah) {
                C0799oR.m3974a(serverLevel, c1300xw, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " attempted to validate a shot with an old tick: " + j + ". Oldest tick: " + serverLevel).withStyle(ChatFormatting.RED));
            }
            return C0521jE.f3065a;
        }
        if (this.f3068b.m7810b(j)) {
            if (zM2323ah) {
                C0799oR.m3974a(serverLevel, c1300xw, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " attempted to validate a shot with no data for tick: " + j).withStyle(ChatFormatting.RED));
            }
            return C0521jE.f3065a;
        }
        C0523jG c0523jGM7808a = this.f3068b.m7808a(j, serverPlayer.getId());
        if (c0523jGM7808a != null && !c0523jGM7808a.m2306ag()) {
            if (zM2323ah) {
                C0799oR.m3974a(serverLevel, c1300xw, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " attempted to validate a shot while unable to shoot at tick: " + j).withStyle(ChatFormatting.RED));
            }
            return C0521jE.f3065a;
        }
        try {
            List<C1142up> listM6104a = new C1106uF(serverPlayer, c1276xQ, c1144ur.m6394a(), this.f3068b, vec3, vec2, f, f2, j, this.f3069jY).m6104a(c1300xw, serverLevel, RandomSource.create(j2), new Random(j2), (LivingEntity) serverPlayer, c1144ur, j, j2, i);
            if (!m2289a(c1300xw, serverLevel, serverPlayer, zM2323ah, list, listM6104a)) {
                ((C1274xO) c1276xQ.m1133a((Player) serverPlayer)).m7784a().m2322be();
                return C0521jE.f3065a;
            }
            if (zM2323ah) {
                C0799oR.m3974a(serverLevel, c1300xw, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " successfully validated a shot with " + list.size() + " client hits and " + listM6104a.size() + " server hits.").withStyle(ChatFormatting.GREEN));
            }
            return C0521jE.m2283a(m2288a(serverLevel, list, listM6104a));
        } catch (Exception e) {
            return C0521jE.f3065a;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static List<C1142up> m2288a(@NotNull ServerLevel serverLevel, @NotNull List<C1142up> list, @NotNull List<C1142up> list2) {
        Int2ObjectOpenHashMap int2ObjectOpenHashMap = new Int2ObjectOpenHashMap(list2.size());
        for (C1142up c1142up : list2) {
            int2ObjectOpenHashMap.put(c1142up.m6284al(), c1142up);
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(list.size());
        IntOpenHashSet intOpenHashSet = new IntOpenHashSet(list.size());
        for (C1142up c1142up2 : list) {
            int iM6284al = c1142up2.m6284al();
            if (intOpenHashSet.add(iM6284al)) {
                C1142up c1142up3 = (C1142up) int2ObjectOpenHashMap.get(iM6284al);
                if (c1142up3 != null) {
                    objectArrayList.add(new C1142up(iM6284al, c1142up3.m6285bu(), c1142up3.m6286co(), c1142up3.m6287cp(), c1142up2.m6288cq(), c1142up3.m6289cr(), c1142up3.m6290b(), c1142up3.m6291z()));
                } else if (serverLevel.getEntity(iM6284al) instanceof InterfaceC0725mx) {
                    objectArrayList.add(c1142up2);
                }
            }
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: a */
    private boolean m2289a(C1300xw c1300xw, ServerLevel serverLevel, ServerPlayer serverPlayer, boolean z, @NotNull List<C1142up> list, @NotNull List<C1142up> list2) {
        IntOpenHashSet intOpenHashSet = new IntOpenHashSet();
        Iterator<C1142up> it = list.iterator();
        while (it.hasNext()) {
            intOpenHashSet.add(it.next().m6284al());
        }
        intOpenHashSet.removeIf(i -> {
            return serverLevel.getEntity(i) instanceof InterfaceC0725mx;
        });
        IntOpenHashSet intOpenHashSet2 = new IntOpenHashSet(list2.size());
        Iterator<C1142up> it2 = list2.iterator();
        while (it2.hasNext()) {
            intOpenHashSet2.add(it2.next().m6284al());
        }
        IntIterator it3 = intOpenHashSet.iterator();
        while (it3.hasNext()) {
            int iIntValue = ((Integer) it3.next()).intValue();
            if (!intOpenHashSet2.contains(iIntValue)) {
                if (z) {
                    C0799oR.m3974a(serverLevel, c1300xw, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " reported a hit on entity ID " + iIntValue + " that was not found in the server's hit results. Server hits: " + String.valueOf(intOpenHashSet2)).withStyle(ChatFormatting.RED));
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2290a(@NotNull C1300xw c1300xw, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, boolean z, float f, @NotNull C1144ur c1144ur, @NotNull ItemStack itemStack, @NotNull C1274xO c1274xO) {
        DeferredItem<? extends C1146ut> deferredItemA = c1144ur.m6327a();
        C1108uH c1108uHM6329a = c1144ur.m6329a(itemStack);
        float fM6432b = C1148uv.m6432b(deferredItemA, c1108uHM6329a, c1144ur.m6391cw());
        float fM6433a = C1148uv.m6433a(c1108uHM6329a, deferredItemA);
        if (!C1148uv.m6434a(f, fM6432b, fM6433a)) {
            if (z) {
                C0799oR.m3974a(serverLevel, c1300xw, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " reported an invalid spread: " + String.format("%.4f", Float.valueOf(f)) + ". Expected range: [" + String.format("%.4f", Float.valueOf(fM6432b)) + ", " + String.format("%.4f", Float.valueOf(fM6433a)) + "]").withStyle(ChatFormatting.RED));
                return false;
            }
            return false;
        }
        if (z) {
            C0799oR.m3974a(serverLevel, c1300xw, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " reported a valid spread: " + String.format("%.4f", Float.valueOf(f)) + ". Expected range: [" + String.format("%.4f", Float.valueOf(fM6432b)) + ", " + String.format("%.4f", Float.valueOf(fM6433a)) + "]").withStyle(ChatFormatting.GRAY));
            return true;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m2291a(@NotNull C1300xw c1300xw, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, boolean z, @NotNull ItemStack itemStack, @NotNull C1144ur c1144ur, long j, @NotNull C1274xO c1274xO, boolean z2) {
        Object obj;
        String str;
        C0526jJ c0526jJM7785a = c1274xO.m7785a();
        if (!c0526jJM7785a.m2327a(itemStack, j, z2)) {
            if (z) {
                C1119uS c1119uSM6347a = c1144ur.m6347a();
                int iM6222cg = c1119uSM6347a.m6222cg();
                int iM6225ch = c1119uSM6347a.m6225ch();
                long jM2328h = c0526jJM7785a.m2328h();
                if (iM6225ch > 1) {
                    obj = "multi-pellet fire rate limit";
                    str = String.format("Expected minimum %d ticks between trigger pulls for %d-pellet weapon, but only %d ticks passed", Integer.valueOf(iM6222cg), Integer.valueOf(iM6225ch), Long.valueOf(jM2328h >= 0 ? j - jM2328h : 0L));
                } else {
                    obj = "fire rate limit";
                    str = "Expected minimum " + iM6222cg + " ticks between shots, but only " + (jM2328h >= 0 ? j - jM2328h : 0L) + " ticks passed";
                }
                C0799oR.m3974a(serverLevel, c1300xw, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " violated " + obj + ": " + str + ". Weapon: " + itemStack.getItem().getDescriptionId()).withStyle(ChatFormatting.RED));
                return false;
            }
            return false;
        }
        if (z) {
            int iM6225ch2 = c1144ur.m6347a().m6225ch();
            C0799oR.m3974a(serverLevel, c1300xw, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " passed " + (iM6225ch2 > 1 ? "multi-pellet fire rate" : "fire rate") + " validation for " + itemStack.getItem().getDescriptionId() + (iM6225ch2 > 1 ? " (" + iM6225ch2 + " pellets)" : "")).withStyle(ChatFormatting.GRAY));
            return true;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static void m2292a(@NotNull C1284xg c1284xg) {
        long jM7811k = c1284xg.m7811k();
        synchronized (f3072b) {
            LongArrayList longArrayList = new LongArrayList();
            ObjectIterator it = f3072b.long2ObjectEntrySet().iterator();
            while (it.hasNext()) {
                long longKey = ((Long2ObjectMap.Entry) it.next()).getLongKey();
                if (longKey <= jM7811k) {
                    longArrayList.add(longKey);
                }
            }
            LongListIterator it2 = longArrayList.iterator();
            while (it2.hasNext()) {
                List<C0524jH> list = (List) f3072b.remove(((Long) it2.next()).longValue());
                if (list != null && !list.isEmpty()) {
                    for (C0524jH c0524jH : list) {
                        if (c0524jH.m2312a().isAlive()) {
                            C0521jE c0521jEM2287a = new C0522jF(c1284xg).m2287a(c0524jH.m2313a(), c0524jH.m2314a(), c0524jH.m2312a().serverLevel(), c0524jH.m2312a(), c0524jH.m2315p(), c0524jH.m2316h(), c0524jH.m2317a(), c0524jH.m2318ad(), c0524jH.m2319ae(), c0524jH.m2311f(), c0524jH.m2320g(), c0524jH.m2321am());
                            if (c0521jEM2287a.m2284af()) {
                                C1300xw c1300xwM2313a = c0524jH.m2313a();
                                C1105uE.m6098a((AbstractC0563ju<?, ?, ?>) c1300xwM2313a, (AbstractC0183c<?>) c0524jH.m2314a(), c0524jH.m2312a().level(), (LivingEntity) c0524jH.m2312a(), c1300xwM2313a.m2530a((Player) c0524jH.m2312a()), c0521jEM2287a.m2286o());
                            }
                        }
                    }
                }
            }
        }
    }
}
