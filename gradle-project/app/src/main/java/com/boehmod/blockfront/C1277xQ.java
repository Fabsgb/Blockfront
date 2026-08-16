package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p001mm.MatchJoinIntent;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.xQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xQ.class */
public class C1277xQ {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Cache<UUID, a> f6879b = CacheBuilder.newBuilder().maximumSize(256).expireAfterAccess(1, TimeUnit.MINUTES).build();

    /* JADX INFO: renamed from: com.boehmod.blockfront.xQ$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xQ$a.class */
    public static final class a extends Record {

        /* JADX INFO: renamed from: aa */
        @NotNull
        private final UUID f6880aa;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final MatchJoinIntent f6881a;

        public a(@NotNull UUID uuid, @NotNull MatchJoinIntent matchJoinIntent) {
            this.f6880aa = uuid;
            this.f6881a = matchJoinIntent;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "matchUUID;intent", "FIELD:Lcom/boehmod/blockfront/xQ$a;->aa:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/xQ$a;->a:Lcom/boehmod/bflib/cloud/common/mm/MatchJoinIntent;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "matchUUID;intent", "FIELD:Lcom/boehmod/blockfront/xQ$a;->aa:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/xQ$a;->a:Lcom/boehmod/bflib/cloud/common/mm/MatchJoinIntent;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "matchUUID;intent", "FIELD:Lcom/boehmod/blockfront/xQ$a;->aa:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/xQ$a;->a:Lcom/boehmod/bflib/cloud/common/mm/MatchJoinIntent;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        /* JADX INFO: renamed from: s */
        public UUID m7267s() {
            return this.f6880aa;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public MatchJoinIntent m7268a() {
            return this.f6881a;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m7259a(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull MatchJoinIntent matchJoinIntent) {
        this.f6879b.put(uuid, new a(uuid2, matchJoinIntent));
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public a m7260a(@NotNull UUID uuid) {
        a aVar = (a) this.f6879b.getIfPresent(uuid);
        if (aVar != null) {
            this.f6879b.invalidate(uuid);
        }
        return aVar;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Set<UUID> m7261a(@NotNull UUID uuid) {
        return m7263a(uuid, MatchJoinIntent.PLAYING);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Set<UUID> m7262b(@NotNull UUID uuid) {
        return m7263a(uuid, MatchJoinIntent.SPECTATING);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private Set<UUID> m7263a(@NotNull UUID uuid, @NotNull MatchJoinIntent matchJoinIntent) {
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        this.f6879b.asMap().forEach((uuid2, aVar) -> {
            if (aVar.m7268a() == matchJoinIntent && aVar.m7267s().equals(uuid)) {
                objectOpenHashSet.add(uuid2);
            }
        });
        return objectOpenHashSet;
    }

    /* JADX INFO: renamed from: a */
    public void m7264a(@NotNull UUID uuid, @NotNull UUID uuid2) {
        this.f6879b.asMap().forEach((uuid3, aVar) -> {
            if (aVar.m7267s().equals(uuid)) {
                this.f6879b.put(uuid3, new a(uuid2, aVar.m7268a()));
            }
        });
    }
}
