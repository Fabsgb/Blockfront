package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Set;
import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tl.class */
public final class C1085tl<G extends AbstractC0787oF<G, P, ?>, P extends AbstractC0790oI<G>> extends Record {

    /* JADX INFO: renamed from: j */
    @NotNull
    private final G f5665j;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final P f5666c;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final AbstractC0563ju<?, ?, ?> f5667g;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final AbstractC0183c<?> f5668d;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ServerLevel f5669a;

    /* JADX INFO: renamed from: q */
    @NotNull
    private final Set<UUID> f5670q;

    public C1085tl(@NotNull G g, @NotNull P p, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f5665j = g;
        this.f5666c = p;
        this.f5667g = abstractC0563ju;
        this.f5668d = abstractC0183c;
        this.f5669a = serverLevel;
        this.f5670q = set;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1085tl.class), C1085tl.class, "game;playerHandler;manager;playerDataHandler;serverLevel;players", "FIELD:Lcom/boehmod/blockfront/tl;->j:Lcom/boehmod/blockfront/oF;", "FIELD:Lcom/boehmod/blockfront/tl;->c:Lcom/boehmod/blockfront/oI;", "FIELD:Lcom/boehmod/blockfront/tl;->g:Lcom/boehmod/blockfront/ju;", "FIELD:Lcom/boehmod/blockfront/tl;->d:Lcom/boehmod/blockfront/common/player/c;", "FIELD:Lcom/boehmod/blockfront/tl;->a:Lnet/minecraft/server/level/ServerLevel;", "FIELD:Lcom/boehmod/blockfront/tl;->q:Ljava/util/Set;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1085tl.class), C1085tl.class, "game;playerHandler;manager;playerDataHandler;serverLevel;players", "FIELD:Lcom/boehmod/blockfront/tl;->j:Lcom/boehmod/blockfront/oF;", "FIELD:Lcom/boehmod/blockfront/tl;->c:Lcom/boehmod/blockfront/oI;", "FIELD:Lcom/boehmod/blockfront/tl;->g:Lcom/boehmod/blockfront/ju;", "FIELD:Lcom/boehmod/blockfront/tl;->d:Lcom/boehmod/blockfront/common/player/c;", "FIELD:Lcom/boehmod/blockfront/tl;->a:Lnet/minecraft/server/level/ServerLevel;", "FIELD:Lcom/boehmod/blockfront/tl;->q:Ljava/util/Set;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1085tl.class, Object.class), C1085tl.class, "game;playerHandler;manager;playerDataHandler;serverLevel;players", "FIELD:Lcom/boehmod/blockfront/tl;->j:Lcom/boehmod/blockfront/oF;", "FIELD:Lcom/boehmod/blockfront/tl;->c:Lcom/boehmod/blockfront/oI;", "FIELD:Lcom/boehmod/blockfront/tl;->g:Lcom/boehmod/blockfront/ju;", "FIELD:Lcom/boehmod/blockfront/tl;->d:Lcom/boehmod/blockfront/common/player/c;", "FIELD:Lcom/boehmod/blockfront/tl;->a:Lnet/minecraft/server/level/ServerLevel;", "FIELD:Lcom/boehmod/blockfront/tl;->q:Ljava/util/Set;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public G m5989c() {
        return this.f5665j;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public P m5990c() {
        return this.f5666c;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public AbstractC0563ju<?, ?, ?> m5991b() {
        return this.f5667g;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public AbstractC0183c<?> m5992b() {
        return this.f5668d;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ServerLevel m5993a() {
        return this.f5669a;
    }

    @NotNull
    /* JADX INFO: renamed from: m */
    public Set<UUID> m5994m() {
        return this.f5670q;
    }
}
