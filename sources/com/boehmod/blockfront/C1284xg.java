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

/* JADX INFO: renamed from: com.boehmod.blockfront.xg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xg.class */
public class C1284xg {

    /* JADX INFO: renamed from: tE */
    private static final int f8621tE = 60;

    /* JADX INFO: renamed from: tF */
    private static final int f8622tF = 128;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Int2ObjectMap<C0523jG>[] f8623a = new Int2ObjectMap[60];

    /* JADX INFO: renamed from: a */
    private final long[] f8624a = new long[60];

    /* JADX INFO: renamed from: F */
    private long f8625F = 0;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final ObjectSet<Entity> f8626b = new ObjectOpenHashSet();

    public C1284xg() {
        Arrays.fill(this.f8624a, -1L);
    }

    /* JADX INFO: renamed from: a */
    public void m7804a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @Nullable Iterable<Entity> iterable, long j, @Nullable LivingEntity livingEntity) {
        this.f8625F = j;
        int i = (int) (j % 60);
        Int2ObjectMap<C0523jG> int2ObjectOpenHashMap = this.f8623a[i];
        if (int2ObjectOpenHashMap == null) {
            int2ObjectOpenHashMap = new Int2ObjectOpenHashMap<>();
            this.f8623a[i] = int2ObjectOpenHashMap;
        } else {
            int2ObjectOpenHashMap.clear();
        }
        this.f8624a[i] = j;
        if (iterable == null || C0561js.m2513ac()) {
            m7806a(abstractC0563ju, int2ObjectOpenHashMap, livingEntity);
        } else {
            m7805a(abstractC0563ju, iterable, int2ObjectOpenHashMap, livingEntity);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m7805a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull Iterable<Entity> iterable, @NotNull Int2ObjectMap<C0523jG> int2ObjectMap, @Nullable LivingEntity livingEntity) {
        for (Entity entity : iterable) {
            if (m7807s(entity)) {
                int2ObjectMap.put(entity.getId(), C0523jG.m2307a(abstractC0563ju, this.f8625F, entity, livingEntity));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m7806a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull Int2ObjectMap<C0523jG> int2ObjectMap, @Nullable LivingEntity livingEntity) {
        if (C0561js.m2514a() == null) {
            return;
        }
        this.f8626b.clear();
        Iterator<C0792oK> it = abstractC0563ju.m2542b().values().iterator();
        while (it.hasNext()) {
            AbstractC0787oF<?, ?, ?> abstractC0787oFM3836a = it.next().m3836a();
            if (abstractC0787oFM3836a != null) {
                Set<UUID> setM3809h = abstractC0787oFM3836a.m3582b().m3809h();
                if (!setM3809h.isEmpty()) {
                    AABB aabbMinmax = null;
                    ServerLevel serverLevel = null;
                    Iterator<UUID> it2 = setM3809h.iterator();
                    while (it2.hasNext()) {
                        ServerPlayer serverPlayerM3963a = C0799oR.m3963a(it2.next());
                        if (serverPlayerM3963a != null) {
                            if (serverLevel == null) {
                                serverLevel = serverPlayerM3963a.serverLevel();
                            }
                            AABB boundingBox = serverPlayerM3963a.getBoundingBox();
                            aabbMinmax = aabbMinmax == null ? boundingBox : aabbMinmax.minmax(boundingBox);
                        }
                    }
                    if (aabbMinmax != null) {
                        this.f8626b.addAll(serverLevel.getEntities((Entity) null, aabbMinmax.inflate(128.0d), this::m7807s));
                    }
                }
            }
        }
        ObjectIterator it3 = this.f8626b.iterator();
        while (it3.hasNext()) {
            Entity entity = (Entity) it3.next();
            int2ObjectMap.put(entity.getId(), C0523jG.m2307a(abstractC0563ju, this.f8625F, entity, livingEntity));
        }
    }

    /* JADX INFO: renamed from: s */
    private boolean m7807s(@NotNull Entity entity) {
        if (entity instanceof InterfaceC0725mx) {
            return false;
        }
        if (entity instanceof LivingEntity) {
            return !((LivingEntity) entity).isDeadOrDying();
        }
        return entity instanceof AbstractC0676mA;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0523jG m7808a(long j, int i) {
        int i2 = (int) (j % 60);
        if (this.f8624a[i2] != j) {
            return null;
        }
        return (C0523jG) this.f8623a[i2].get(i);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0523jG m7809a(long j, int i, int i2) {
        C0523jG c0523jGM7808a = m7808a(j, i);
        if (c0523jGM7808a != null) {
            return c0523jGM7808a;
        }
        C0523jG c0523jG = null;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 1; i4 <= i2; i4++) {
            C0523jG c0523jGM7808a2 = m7808a(j + ((long) i4), i);
            C0523jG c0523jGM7808a3 = m7808a(j - ((long) i4), i);
            if (c0523jGM7808a2 != null && i4 < i3) {
                c0523jG = c0523jGM7808a2;
                i3 = i4;
            }
            if (c0523jGM7808a3 != null && i4 < i3) {
                c0523jG = c0523jGM7808a3;
                i3 = i4;
            }
        }
        return c0523jG;
    }

    /* JADX INFO: renamed from: b */
    public boolean m7810b(long j) {
        return this.f8624a[(int) (j % 60)] != j;
    }

    /* JADX INFO: renamed from: k */
    public long m7811k() {
        return this.f8625F;
    }

    /* JADX INFO: renamed from: l */
    public long m7812l() {
        long jMin = Long.MAX_VALUE;
        boolean z = false;
        for (long j : this.f8624a) {
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

    /* JADX INFO: renamed from: e */
    public void m7813e() {
        Arrays.fill(this.f8624a, -1L);
        for (int i = 0; i < 60; i++) {
            if (this.f8623a[i] != null) {
                this.f8623a[i].clear();
            }
        }
    }

    /* JADX INFO: renamed from: cy */
    public int m7814cy() {
        int i = (int) (this.f8625F % 60);
        if (this.f8624a[i] != this.f8625F) {
            return 0;
        }
        return this.f8623a[i].size();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<C0523jG> m7815a(long j) {
        int i = (int) (j % 60);
        return this.f8624a[i] != j ? Collections.emptyList() : this.f8623a[i].values();
    }
}
