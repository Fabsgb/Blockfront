package com.boehmod.blockfront;

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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jF.class */
public class jF {
    public static final double ae = 2.0d;

    @NotNull
    private final C0628xg b;
    private final int jY;
    private static final int jZ = 3;
    private static final long n = 20;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    private static final Long2ObjectMap<List<jH>> f180b = new Long2ObjectOpenHashMap();

    public jF(@NotNull C0628xg c0628xg) {
        this(c0628xg, 3);
    }

    public jF(@NotNull C0628xg c0628xg, int i) {
        this.b = c0628xg;
        this.jY = i;
    }

    @NotNull
    public jE a(@NotNull xw xwVar, @NotNull xQ xQVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull List<C0556up> list, Vec3 vec3, Vec2 vec2, float f, float f2, long j, long j2, int i) {
        nD nDVarA;
        xO xOVar = (xO) xQVar.a((Player) serverPlayer);
        boolean zAh = xOVar.m1675a().ah();
        long jK = this.b.k();
        boolean z = j > jK;
        boolean z2 = false;
        ItemStack itemInHand = serverPlayer.getItemInHand(InteractionHand.MAIN_HAND);
        Entity vehicle = serverPlayer.getVehicle();
        if ((vehicle instanceof AbstractC0376ny) && (nDVarA = ((AbstractC0376ny) vehicle).a((Entity) serverPlayer)) != null) {
            Iterator<nN<?>> it = nDVarA.m715b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                nN<?> next = it.next();
                if (next instanceof nL) {
                    itemInHand = new ItemStack(((nL) next).c());
                    z2 = true;
                    break;
                }
            }
        }
        Item item = itemInHand.getItem();
        if (!(item instanceof C0558ur)) {
            if (zAh) {
                oR.a(serverLevel, xwVar, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " attempted to validate a shot without holding a gun item.").withStyle(ChatFormatting.RED));
            }
            return jE.f179a;
        }
        C0558ur c0558ur = (C0558ur) item;
        if (iM.dg && !z2 && !a(xwVar, serverLevel, serverPlayer, zAh, f, c0558ur, itemInHand, xOVar)) {
            return jE.f179a;
        }
        if (!serverPlayer.getEyePosition().closerThan(vec3, 2.0d)) {
            if (zAh) {
                float fDistanceTo = (float) serverPlayer.getEyePosition().distanceTo(vec3);
                String scoreboardName = serverPlayer.getScoreboardName();
                String str = String.format("%.2f", Float.valueOf(fDistanceTo));
                double d = vec3.x;
                double d2 = vec3.y;
                double d3 = vec3.z;
                oR.a(serverLevel, xwVar, (Component) Component.literal("Player " + scoreboardName + " attempted to validate a shot from an invalid position: " + str + " blocks away. (" + d + ", " + serverLevel + ", " + d2 + ")").withStyle(ChatFormatting.RED));
            }
            return jE.f179a;
        }
        if (!a(xwVar, serverLevel, serverPlayer, zAh, itemInHand, c0558ur, j, xOVar, !z)) {
            return jE.f179a;
        }
        if (z) {
            long j3 = j - jK;
            if (j3 > n) {
                if (zAh) {
                    oR.a(serverLevel, xwVar, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " attempted to validate a shot too far in the future: " + j + " (" + serverLevel + " ticks ahead). Current tick: " + j3 + ". Max prediction: 20 ticks").withStyle(ChatFormatting.RED));
                }
                return jE.f179a;
            }
            jH jHVar = new jH(j, serverPlayer, xwVar, xQVar, list, vec3, vec2, f, f2, j2, i);
            synchronized (f180b) {
                ((List) f180b.computeIfAbsent(j, j4 -> {
                    return new ObjectArrayList();
                })).add(jHVar);
            }
            if (zAh) {
                oR.a(serverLevel, xwVar, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " submitted a future-time hit (tick " + j + ", " + serverLevel + " ticks ahead). Stored for validation when time is reached.").withStyle(ChatFormatting.YELLOW));
            }
            return jE.b;
        }
        if (j < this.b.l()) {
            if (zAh) {
                oR.a(serverLevel, xwVar, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " attempted to validate a shot with an old tick: " + j + ". Oldest tick: " + serverLevel).withStyle(ChatFormatting.RED));
            }
            return jE.f179a;
        }
        if (this.b.b(j)) {
            if (zAh) {
                oR.a(serverLevel, xwVar, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " attempted to validate a shot with no data for tick: " + j).withStyle(ChatFormatting.RED));
            }
            return jE.f179a;
        }
        jG jGVarA = this.b.a(j, serverPlayer.getId());
        if (jGVarA != null && !jGVarA.ag()) {
            if (zAh) {
                oR.a(serverLevel, xwVar, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " attempted to validate a shot while unable to shoot at tick: " + j).withStyle(ChatFormatting.RED));
            }
            return jE.f179a;
        }
        try {
            List<C0556up> listA = new uF(serverPlayer, xQVar, c0558ur.m1216a(), this.b, vec3, vec2, f, f2, j, this.jY).a(xwVar, serverLevel, RandomSource.create(j2), new Random(j2), (LivingEntity) serverPlayer, c0558ur, j, j2, i);
            if (!a(xwVar, serverLevel, serverPlayer, zAh, list, listA)) {
                ((xO) xQVar.a((Player) serverPlayer)).m1675a().be();
                return jE.f179a;
            }
            if (zAh) {
                oR.a(serverLevel, xwVar, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " successfully validated a shot with " + list.size() + " client hits and " + listA.size() + " server hits.").withStyle(ChatFormatting.GREEN));
            }
            return jE.a(a(serverLevel, list, listA));
        } catch (Exception e) {
            return jE.f179a;
        }
    }

    @NotNull
    private static List<C0556up> a(@NotNull ServerLevel serverLevel, @NotNull List<C0556up> list, @NotNull List<C0556up> list2) {
        Int2ObjectOpenHashMap int2ObjectOpenHashMap = new Int2ObjectOpenHashMap(list2.size());
        for (C0556up c0556up : list2) {
            int2ObjectOpenHashMap.put(c0556up.al(), c0556up);
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(list.size());
        IntOpenHashSet intOpenHashSet = new IntOpenHashSet(list.size());
        for (C0556up c0556up2 : list) {
            int iAl = c0556up2.al();
            if (intOpenHashSet.add(iAl)) {
                C0556up c0556up3 = (C0556up) int2ObjectOpenHashMap.get(iAl);
                if (c0556up3 != null) {
                    objectArrayList.add(new C0556up(iAl, c0556up3.bu(), c0556up3.co(), c0556up3.cp(), c0556up2.cq(), c0556up3.cr(), c0556up3.b(), c0556up3.z()));
                } else if (serverLevel.getEntity(iAl) instanceof InterfaceC0348mx) {
                    objectArrayList.add(c0556up2);
                }
            }
        }
        return objectArrayList;
    }

    private boolean a(xw xwVar, ServerLevel serverLevel, ServerPlayer serverPlayer, boolean z, @NotNull List<C0556up> list, @NotNull List<C0556up> list2) {
        IntOpenHashSet intOpenHashSet = new IntOpenHashSet();
        Iterator<C0556up> it = list.iterator();
        while (it.hasNext()) {
            intOpenHashSet.add(it.next().al());
        }
        intOpenHashSet.removeIf(i -> {
            return serverLevel.getEntity(i) instanceof InterfaceC0348mx;
        });
        IntOpenHashSet intOpenHashSet2 = new IntOpenHashSet(list2.size());
        Iterator<C0556up> it2 = list2.iterator();
        while (it2.hasNext()) {
            intOpenHashSet2.add(it2.next().al());
        }
        IntIterator it3 = intOpenHashSet.iterator();
        while (it3.hasNext()) {
            int iIntValue = ((Integer) it3.next()).intValue();
            if (!intOpenHashSet2.contains(iIntValue)) {
                if (z) {
                    oR.a(serverLevel, xwVar, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " reported a hit on entity ID " + iIntValue + " that was not found in the server's hit results. Server hits: " + String.valueOf(intOpenHashSet2)).withStyle(ChatFormatting.RED));
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    public boolean a(@NotNull xw xwVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, boolean z, float f, @NotNull C0558ur c0558ur, @NotNull ItemStack itemStack, @NotNull xO xOVar) {
        DeferredItem<? extends C0560ut> deferredItemA = c0558ur.a();
        uH uHVarM1208a = c0558ur.m1208a(itemStack);
        float fB = C0562uv.b(deferredItemA, uHVarM1208a, c0558ur.cw());
        float fA = C0562uv.a(uHVarM1208a, deferredItemA);
        if (!C0562uv.a(f, fB, fA)) {
            if (z) {
                oR.a(serverLevel, xwVar, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " reported an invalid spread: " + String.format("%.4f", Float.valueOf(f)) + ". Expected range: [" + String.format("%.4f", Float.valueOf(fB)) + ", " + String.format("%.4f", Float.valueOf(fA)) + "]").withStyle(ChatFormatting.RED));
                return false;
            }
            return false;
        }
        if (z) {
            oR.a(serverLevel, xwVar, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " reported a valid spread: " + String.format("%.4f", Float.valueOf(f)) + ". Expected range: [" + String.format("%.4f", Float.valueOf(fB)) + ", " + String.format("%.4f", Float.valueOf(fA)) + "]").withStyle(ChatFormatting.GRAY));
            return true;
        }
        return true;
    }

    private boolean a(@NotNull xw xwVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, boolean z, @NotNull ItemStack itemStack, @NotNull C0558ur c0558ur, long j, @NotNull xO xOVar, boolean z2) {
        Object obj;
        String str;
        jJ jJVarM1676a = xOVar.m1676a();
        if (!jJVarM1676a.a(itemStack, j, z2)) {
            if (z) {
                uS uSVarM1210a = c0558ur.m1210a();
                int iCg = uSVarM1210a.cg();
                int iCh = uSVarM1210a.ch();
                long jH = jJVarM1676a.h();
                if (iCh > 1) {
                    obj = "multi-pellet fire rate limit";
                    str = String.format("Expected minimum %d ticks between trigger pulls for %d-pellet weapon, but only %d ticks passed", Integer.valueOf(iCg), Integer.valueOf(iCh), Long.valueOf(jH >= 0 ? j - jH : 0L));
                } else {
                    obj = "fire rate limit";
                    str = "Expected minimum " + iCg + " ticks between shots, but only " + (jH >= 0 ? j - jH : 0L) + " ticks passed";
                }
                oR.a(serverLevel, xwVar, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " violated " + obj + ": " + str + ". Weapon: " + itemStack.getItem().getDescriptionId()).withStyle(ChatFormatting.RED));
                return false;
            }
            return false;
        }
        if (z) {
            int iCh2 = c0558ur.m1210a().ch();
            oR.a(serverLevel, xwVar, (Component) Component.literal("Player " + serverPlayer.getScoreboardName() + " passed " + (iCh2 > 1 ? "multi-pellet fire rate" : "fire rate") + " validation for " + itemStack.getItem().getDescriptionId() + (iCh2 > 1 ? " (" + iCh2 + " pellets)" : "")).withStyle(ChatFormatting.GRAY));
            return true;
        }
        return true;
    }

    public static void a(@NotNull C0628xg c0628xg) {
        long jK = c0628xg.k();
        synchronized (f180b) {
            LongArrayList longArrayList = new LongArrayList();
            ObjectIterator it = f180b.long2ObjectEntrySet().iterator();
            while (it.hasNext()) {
                long longKey = ((Long2ObjectMap.Entry) it.next()).getLongKey();
                if (longKey <= jK) {
                    longArrayList.add(longKey);
                }
            }
            LongListIterator it2 = longArrayList.iterator();
            while (it2.hasNext()) {
                List<jH> list = (List) f180b.remove(((Long) it2.next()).longValue());
                if (list != null && !list.isEmpty()) {
                    for (jH jHVar : list) {
                        if (jHVar.a().isAlive()) {
                            jE jEVarA = new jF(c0628xg).a(jHVar.m514a(), jHVar.m515a(), jHVar.a().serverLevel(), jHVar.a(), jHVar.p(), jHVar.h(), jHVar.m516a(), jHVar.ad(), jHVar.ae(), jHVar.f(), jHVar.g(), jHVar.am());
                            if (jEVarA.af()) {
                                xw xwVarM514a = jHVar.m514a();
                                uE.a((AbstractC0264ju<?, ?, ?>) xwVarM514a, (com.boehmod.blockfront.common.player.c<?>) jHVar.m515a(), jHVar.a().level(), (LivingEntity) jHVar.a(), xwVarM514a.a((Player) jHVar.a()), jEVarA.o());
                            }
                        }
                    }
                }
            }
        }
    }
}
