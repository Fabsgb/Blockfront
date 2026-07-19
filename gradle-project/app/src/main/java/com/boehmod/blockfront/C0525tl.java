package com.boehmod.blockfront;

import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Set;
import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tl.class */
public final class C0525tl<G extends oF<G, P, ?>, P extends oI<G>> extends Record {

    @NotNull
    private final G j;

    @NotNull
    private final P c;

    @NotNull
    private final AbstractC0264ju<?, ?, ?> g;

    @NotNull
    private final com.boehmod.blockfront.common.player.c<?> d;

    @NotNull
    private final ServerLevel a;

    @NotNull
    private final Set<UUID> q;

    public C0525tl(@NotNull G g, @NotNull P p, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.j = g;
        this.c = p;
        this.g = abstractC0264ju;
        this.d = cVar;
        this.a = serverLevel;
        this.q = set;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0525tl.class), C0525tl.class, "game;playerHandler;manager;playerDataHandler;serverLevel;players", "FIELD:Lcom/boehmod/blockfront/tl;->j:Lcom/boehmod/blockfront/oF;", "FIELD:Lcom/boehmod/blockfront/tl;->c:Lcom/boehmod/blockfront/oI;", "FIELD:Lcom/boehmod/blockfront/tl;->g:Lcom/boehmod/blockfront/ju;", "FIELD:Lcom/boehmod/blockfront/tl;->d:Lcom/boehmod/blockfront/common/player/c;", "FIELD:Lcom/boehmod/blockfront/tl;->a:Lnet/minecraft/server/level/ServerLevel;", "FIELD:Lcom/boehmod/blockfront/tl;->q:Ljava/util/Set;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0525tl.class), C0525tl.class, "game;playerHandler;manager;playerDataHandler;serverLevel;players", "FIELD:Lcom/boehmod/blockfront/tl;->j:Lcom/boehmod/blockfront/oF;", "FIELD:Lcom/boehmod/blockfront/tl;->c:Lcom/boehmod/blockfront/oI;", "FIELD:Lcom/boehmod/blockfront/tl;->g:Lcom/boehmod/blockfront/ju;", "FIELD:Lcom/boehmod/blockfront/tl;->d:Lcom/boehmod/blockfront/common/player/c;", "FIELD:Lcom/boehmod/blockfront/tl;->a:Lnet/minecraft/server/level/ServerLevel;", "FIELD:Lcom/boehmod/blockfront/tl;->q:Ljava/util/Set;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0525tl.class, Object.class), C0525tl.class, "game;playerHandler;manager;playerDataHandler;serverLevel;players", "FIELD:Lcom/boehmod/blockfront/tl;->j:Lcom/boehmod/blockfront/oF;", "FIELD:Lcom/boehmod/blockfront/tl;->c:Lcom/boehmod/blockfront/oI;", "FIELD:Lcom/boehmod/blockfront/tl;->g:Lcom/boehmod/blockfront/ju;", "FIELD:Lcom/boehmod/blockfront/tl;->d:Lcom/boehmod/blockfront/common/player/c;", "FIELD:Lcom/boehmod/blockfront/tl;->a:Lnet/minecraft/server/level/ServerLevel;", "FIELD:Lcom/boehmod/blockfront/tl;->q:Ljava/util/Set;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public G c() {
        return this.j;
    }

    @NotNull
    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public P m1161c() {
        return this.c;
    }

    @NotNull
    public AbstractC0264ju<?, ?, ?> b() {
        return this.g;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public com.boehmod.blockfront.common.player.c<?> m1162b() {
        return this.d;
    }

    @NotNull
    public ServerLevel a() {
        return this.a;
    }

    @NotNull
    public Set<UUID> m() {
        return this.q;
    }
}
