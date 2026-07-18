package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000mm.MatchJoinIntent;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xt.class */
public class C1297xt {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Cache<UUID, a> f8681b = CacheBuilder.newBuilder().maximumSize(256).expireAfterAccess(1, TimeUnit.MINUTES).build();

    /* JADX INFO: renamed from: com.boehmod.blockfront.xt$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xt$a.class */
    public static final class a extends Record {

        /* JADX INFO: renamed from: Y */
        @NotNull
        private final UUID f8682Y;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final MatchJoinIntent f8683a;

        public a(@NotNull UUID uuid, @NotNull MatchJoinIntent matchJoinIntent) {
            this.f8682Y = uuid;
            this.f8683a = matchJoinIntent;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "matchUUID;intent", "FIELD:Lcom/boehmod/blockfront/xt$a;->Y:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/xt$a;->a:Lcom/boehmod/bflib/cloud/common/mm/MatchJoinIntent;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "matchUUID;intent", "FIELD:Lcom/boehmod/blockfront/xt$a;->Y:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/xt$a;->a:Lcom/boehmod/bflib/cloud/common/mm/MatchJoinIntent;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "matchUUID;intent", "FIELD:Lcom/boehmod/blockfront/xt$a;->Y:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/xt$a;->a:Lcom/boehmod/bflib/cloud/common/mm/MatchJoinIntent;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        /* JADX INFO: renamed from: r */
        public UUID m7940r() {
            return this.f8682Y;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public MatchJoinIntent m7941a() {
            return this.f8683a;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m7932a(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull MatchJoinIntent matchJoinIntent) {
        this.f8681b.put(uuid, new a(uuid2, matchJoinIntent));
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public a m7933a(@NotNull UUID uuid) {
        a aVar = (a) this.f8681b.getIfPresent(uuid);
        if (aVar != null) {
            this.f8681b.invalidate(uuid);
        }
        return aVar;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Set<UUID> m7934a(@NotNull UUID uuid) {
        return m7936a(uuid, MatchJoinIntent.PLAYING);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Set<UUID> m7935b(@NotNull UUID uuid) {
        return m7936a(uuid, MatchJoinIntent.SPECTATING);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private Set<UUID> m7936a(@NotNull UUID uuid, @NotNull MatchJoinIntent matchJoinIntent) {
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        this.f8681b.asMap().forEach((uuid2, aVar) -> {
            if (aVar.m7941a() == matchJoinIntent && aVar.m7940r().equals(uuid)) {
                objectOpenHashSet.add(uuid2);
            }
        });
        return objectOpenHashSet;
    }

    /* JADX INFO: renamed from: a */
    public void m7937a(@NotNull UUID uuid, @NotNull UUID uuid2) {
        this.f8681b.asMap().forEach((uuid3, aVar) -> {
            if (aVar.m7940r().equals(uuid)) {
                this.f8681b.put(uuid3, new a(uuid2, aVar.m7941a()));
            }
        });
    }
}
