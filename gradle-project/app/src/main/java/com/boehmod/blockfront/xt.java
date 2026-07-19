package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.mm.MatchJoinIntent;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xt.class */
public class xt {

    @NotNull
    private final Cache<UUID, a> b = CacheBuilder.newBuilder().maximumSize(256).expireAfterAccess(1, TimeUnit.MINUTES).build();

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xt$a.class */
    public static final class a extends Record {

        @NotNull
        private final UUID Y;

        @NotNull
        private final MatchJoinIntent a;

        public a(@NotNull UUID uuid, @NotNull MatchJoinIntent matchJoinIntent) {
            this.Y = uuid;
            this.a = matchJoinIntent;
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
        public UUID r() {
            return this.Y;
        }

        @NotNull
        public MatchJoinIntent a() {
            return this.a;
        }
    }

    public void a(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull MatchJoinIntent matchJoinIntent) {
        this.b.put(uuid, new a(uuid2, matchJoinIntent));
    }

    @Nullable
    public a a(@NotNull UUID uuid) {
        a aVar = (a) this.b.getIfPresent(uuid);
        if (aVar != null) {
            this.b.invalidate(uuid);
        }
        return aVar;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Set<UUID> m1707a(@NotNull UUID uuid) {
        return a(uuid, MatchJoinIntent.PLAYING);
    }

    @NotNull
    public Set<UUID> b(@NotNull UUID uuid) {
        return a(uuid, MatchJoinIntent.SPECTATING);
    }

    @NotNull
    private Set<UUID> a(@NotNull UUID uuid, @NotNull MatchJoinIntent matchJoinIntent) {
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        this.b.asMap().forEach((uuid2, aVar) -> {
            if (aVar.a() == matchJoinIntent && aVar.r().equals(uuid)) {
                objectOpenHashSet.add(uuid2);
            }
        });
        return objectOpenHashSet;
    }

    public void a(@NotNull UUID uuid, @NotNull UUID uuid2) {
        this.b.asMap().forEach((uuid3, aVar) -> {
            if (aVar.r().equals(uuid)) {
                this.b.put(uuid3, new a(uuid2, aVar.a()));
            }
        });
    }
}
