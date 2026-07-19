package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.xg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xg.class */
public class C0628xg {
    private static final int tE = 60;
    private static final int tF = 128;

    @NotNull
    private final Int2ObjectMap<jG>[] a = new Int2ObjectMap[60];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final long[] f403a = new long[60];
    private long F = 0;

    @NotNull
    private final ObjectSet<Entity> b = new ObjectOpenHashSet();

    public C0628xg() {
        Arrays.fill(this.f403a, -1L);
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @Nullable Iterable<Entity> iterable, long j, @Nullable LivingEntity livingEntity) {
        this.F = j;
        int i = (int) (j % 60);
        Int2ObjectMap<jG> int2ObjectOpenHashMap = this.a[i];
        if (int2ObjectOpenHashMap == null) {
            int2ObjectOpenHashMap = new Int2ObjectOpenHashMap<>();
            this.a[i] = int2ObjectOpenHashMap;
        } else {
            int2ObjectOpenHashMap.clear();
        }
        this.f403a[i] = j;
        if (iterable == null || C0262js.ac()) {
            a(abstractC0264ju, int2ObjectOpenHashMap, livingEntity);
        } else {
            a(abstractC0264ju, iterable, int2ObjectOpenHashMap, livingEntity);
        }
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull Iterable<Entity> iterable, @NotNull Int2ObjectMap<jG> int2ObjectMap, @Nullable LivingEntity livingEntity) {
        for (Entity entity : iterable) {
            if (s(entity)) {
                int2ObjectMap.put(entity.getId(), jG.a(abstractC0264ju, this.F, entity, livingEntity));
            }
        }
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull Int2ObjectMap<jG> int2ObjectMap, @Nullable LivingEntity livingEntity) {
        if (C0262js.a() == null) {
            return;
        }
        this.b.clear();
        Iterator<oK> it = abstractC0264ju.m534b().values().iterator();
        while (it.hasNext()) {
            oF<?, ?, ?> oFVarA = it.next().a();
            if (oFVarA != null) {
                Set<UUID> setH = oFVarA.b().h();
                if (!setH.isEmpty()) {
                    AABB aabbMinmax = null;
                    ServerLevel serverLevel = null;
                    Iterator<UUID> it2 = setH.iterator();
                    while (it2.hasNext()) {
                        ServerPlayer serverPlayerA = oR.a(it2.next());
                        if (serverPlayerA != null) {
                            if (serverLevel == null) {
                                serverLevel = serverPlayerA.serverLevel();
                            }
                            AABB boundingBox = serverPlayerA.getBoundingBox();
                            aabbMinmax = aabbMinmax == null ? boundingBox : aabbMinmax.minmax(boundingBox);
                        }
                    }
                    if (aabbMinmax != null) {
                        this.b.addAll(serverLevel.getEntities((Entity) null, aabbMinmax.inflate(128.0d), this::s));
                    }
                }
            }
        }
        ObjectIterator it3 = this.b.iterator();
        while (it3.hasNext()) {
            Entity entity = (Entity) it3.next();
            int2ObjectMap.put(entity.getId(), jG.a(abstractC0264ju, this.F, entity, livingEntity));
        }
    }

    private boolean s(@NotNull Entity entity) {
        if (entity instanceof InterfaceC0348mx) {
            return false;
        }
        if (entity instanceof LivingEntity) {
            return !((LivingEntity) entity).isDeadOrDying();
        }
        return entity instanceof mA;
    }

    @Nullable
    public jG a(long j, int i) {
        int i2 = (int) (j % 60);
        if (this.f403a[i2] != j) {
            return null;
        }
        return (jG) this.a[i2].get(i);
    }

    @Nullable
    public jG a(long j, int i, int i2) {
        jG jGVarA = a(j, i);
        if (jGVarA != null) {
            return jGVarA;
        }
        jG jGVar = null;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 1; i4 <= i2; i4++) {
            jG jGVarA2 = a(j + ((long) i4), i);
            jG jGVarA3 = a(j - ((long) i4), i);
            if (jGVarA2 != null && i4 < i3) {
                jGVar = jGVarA2;
                i3 = i4;
            }
            if (jGVarA3 != null && i4 < i3) {
                jGVar = jGVarA3;
                i3 = i4;
            }
        }
        return jGVar;
    }

    public boolean b(long j) {
        return this.f403a[(int) (j % 60)] != j;
    }

    public long k() {
        return this.F;
    }

    public long l() {
        long jMin = Long.MAX_VALUE;
        boolean z = false;
        for (long j : this.f403a) {
            if (j != -1) {
                jMin = Math.min(jMin, j);
                z = true;
            }
        }
        if (z) {
            return jMin;
        }
        return -1L;
    }

    public void e() {
        Arrays.fill(this.f403a, -1L);
        for (int i = 0; i < 60; i++) {
            if (this.a[i] != null) {
                this.a[i].clear();
            }
        }
    }

    public int cy() {
        int i = (int) (this.F % 60);
        if (this.f403a[i] != this.F) {
            return 0;
        }
        return this.a[i].size();
    }

    @NotNull
    public Collection<jG> a(long j) {
        int i = (int) (j % 60);
        return this.f403a[i] != j ? Collections.emptyList() : this.a[i].values();
    }
}
