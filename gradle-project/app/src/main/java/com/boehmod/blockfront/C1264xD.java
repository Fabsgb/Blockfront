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

/* JADX INFO: renamed from: com.boehmod.blockfront.xD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xD.class */
public class C1264xD {

    /* JADX INFO: renamed from: vI */
    private static final int f6811vI = 60;

    /* JADX INFO: renamed from: vJ */
    private static final int f6812vJ = 128;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Int2ObjectMap<C0543jZ>[] f6813a = new Int2ObjectMap[60];

    /* JADX INFO: renamed from: a */
    private final long[] f6814a = new long[60];

    /* JADX INFO: renamed from: L */
    private long f6815L = 0;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final ObjectSet<Entity> f6816e = new ObjectOpenHashSet();

    public C1264xD() {
        Arrays.fill(this.f6814a, -1L);
    }

    /* JADX INFO: renamed from: a */
    public void m7126a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @Nullable Iterable<Entity> iterable, long j, @Nullable LivingEntity livingEntity) {
        this.f6815L = j;
        int i = (int) (j % 60);
        Int2ObjectMap<C0543jZ> int2ObjectOpenHashMap = this.f6813a[i];
        if (int2ObjectOpenHashMap == null) {
            int2ObjectOpenHashMap = new Int2ObjectOpenHashMap<>();
            this.f6813a[i] = int2ObjectOpenHashMap;
        } else {
            int2ObjectOpenHashMap.clear();
        }
        this.f6814a[i] = j;
        if (iterable == null || C0529jL.m2333af()) {
            m7128a(abstractC0531jN, int2ObjectOpenHashMap, livingEntity);
        } else {
            m7127a(abstractC0531jN, iterable, int2ObjectOpenHashMap, livingEntity);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m7127a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull Iterable<Entity> iterable, @NotNull Int2ObjectMap<C0543jZ> int2ObjectMap, @Nullable LivingEntity livingEntity) {
        for (Entity entity : iterable) {
            if (m7129s(entity)) {
                int2ObjectMap.put(entity.getId(), C0543jZ.m2453a(abstractC0531jN, this.f6815L, entity, livingEntity));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m7128a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull Int2ObjectMap<C0543jZ> int2ObjectMap, @Nullable LivingEntity livingEntity) {
        if (C0529jL.m2335a() == null) {
            return;
        }
        this.f6816e.clear();
        Iterator<C0868pg> it = abstractC0531jN.m2365b().values().iterator();
        while (it.hasNext()) {
            AbstractC0863pb<?, ?, ?> abstractC0863pbM4272a = it.next().m4272a();
            if (abstractC0863pbM4272a != null) {
                Set<UUID> setM4245h = abstractC0863pbM4272a.m4018b().m4245h();
                if (!setM4245h.isEmpty()) {
                    AABB aabbMinmax = null;
                    ServerLevel serverLevel = null;
                    Iterator<UUID> it2 = setM4245h.iterator();
                    while (it2.hasNext()) {
                        ServerPlayer serverPlayerM4399a = C0875pn.m4399a(it2.next());
                        if (serverPlayerM4399a != null) {
                            if (serverLevel == null) {
                                serverLevel = serverPlayerM4399a.serverLevel();
                            }
                            AABB boundingBox = serverPlayerM4399a.getBoundingBox();
                            aabbMinmax = aabbMinmax == null ? boundingBox : aabbMinmax.minmax(boundingBox);
                        }
                    }
                    if (aabbMinmax != null) {
                        this.f6816e.addAll(serverLevel.getEntities((Entity) null, aabbMinmax.inflate(128.0d), this::m7129s));
                    }
                }
            }
        }
        ObjectIterator it3 = this.f6816e.iterator();
        while (it3.hasNext()) {
            Entity entity = (Entity) it3.next();
            int2ObjectMap.put(entity.getId(), C0543jZ.m2453a(abstractC0531jN, this.f6815L, entity, livingEntity));
        }
    }

    /* JADX INFO: renamed from: s */
    private boolean m7129s(@NotNull Entity entity) {
        if (entity instanceof InterfaceC0696mT) {
            return false;
        }
        if (entity instanceof LivingEntity) {
            return !((LivingEntity) entity).isDeadOrDying();
        }
        return entity instanceof AbstractC0699mW;
    }

    /* JADX INFO: renamed from: a */
    private int m7130a(long j) {
        if (j < 0) {
            return -1;
        }
        int i = (int) (j % 60);
        if (this.f6814a[i] == j) {
            return i;
        }
        return -1;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0543jZ m7131a(long j, int i) {
        int iM7130a = m7130a(j);
        if (iM7130a == -1) {
            return null;
        }
        return (C0543jZ) this.f6813a[iM7130a].get(i);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0543jZ m7132a(long j, int i, int i2) {
        C0543jZ c0543jZM7131a = m7131a(j, i);
        if (c0543jZM7131a != null) {
            return c0543jZM7131a;
        }
        C0543jZ c0543jZ = null;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 1; i4 <= i2; i4++) {
            C0543jZ c0543jZM7131a2 = m7131a(j + ((long) i4), i);
            C0543jZ c0543jZM7131a3 = m7131a(j - ((long) i4), i);
            if (c0543jZM7131a2 != null && i4 < i3) {
                c0543jZ = c0543jZM7131a2;
                i3 = i4;
            }
            if (c0543jZM7131a3 != null && i4 < i3) {
                c0543jZ = c0543jZM7131a3;
                i3 = i4;
            }
        }
        return c0543jZ;
    }

    /* JADX INFO: renamed from: f */
    public boolean m7133f(long j) {
        return m7130a(j) == -1;
    }

    /* JADX INFO: renamed from: l */
    public long m7134l() {
        return this.f6815L;
    }

    /* JADX INFO: renamed from: m */
    public long m7135m() {
        long jMin = Long.MAX_VALUE;
        boolean z = false;
        for (long j : this.f6814a) {
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
    public void m7136e() {
        Arrays.fill(this.f6814a, -1L);
        for (int i = 0; i < 60; i++) {
            if (this.f6813a[i] != null) {
                this.f6813a[i].clear();
            }
        }
    }

    /* JADX INFO: renamed from: cO */
    public int m7137cO() {
        int iM7130a = m7130a(this.f6815L);
        if (iM7130a == -1) {
            return 0;
        }
        return this.f6813a[iM7130a].size();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<C0543jZ> m7138a(long j) {
        int iM7130a = m7130a(j);
        return iM7130a == -1 ? Collections.emptyList() : this.f6813a[iM7130a].values();
    }
}
