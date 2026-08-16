package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Set;
import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tI.class */
public final class C1057tI<G extends AbstractC0863pb<G, P, ?>, P extends AbstractC0866pe<G>> extends Record {

    /* JADX INFO: renamed from: j */
    @NotNull
    private final G f5712j;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final P f5713c;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final AbstractC0531jN<?, ?, ?> f5714g;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final AbstractC0184c<?> f5715d;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final ServerLevel f5716b;

    /* JADX INFO: renamed from: r */
    @NotNull
    private final Set<UUID> f5717r;

    public C1057tI(@NotNull G g, @NotNull P p, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f5712j = g;
        this.f5713c = p;
        this.f5714g = abstractC0531jN;
        this.f5715d = abstractC0184c;
        this.f5716b = serverLevel;
        this.f5717r = set;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1057tI.class), C1057tI.class, "game;playerHandler;manager;playerDataHandler;serverLevel;players", "FIELD:Lcom/boehmod/blockfront/tI;->j:Lcom/boehmod/blockfront/pb;", "FIELD:Lcom/boehmod/blockfront/tI;->c:Lcom/boehmod/blockfront/pe;", "FIELD:Lcom/boehmod/blockfront/tI;->g:Lcom/boehmod/blockfront/jN;", "FIELD:Lcom/boehmod/blockfront/tI;->d:Lcom/boehmod/blockfront/common/player/c;", "FIELD:Lcom/boehmod/blockfront/tI;->b:Lnet/minecraft/server/level/ServerLevel;", "FIELD:Lcom/boehmod/blockfront/tI;->r:Ljava/util/Set;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1057tI.class), C1057tI.class, "game;playerHandler;manager;playerDataHandler;serverLevel;players", "FIELD:Lcom/boehmod/blockfront/tI;->j:Lcom/boehmod/blockfront/pb;", "FIELD:Lcom/boehmod/blockfront/tI;->c:Lcom/boehmod/blockfront/pe;", "FIELD:Lcom/boehmod/blockfront/tI;->g:Lcom/boehmod/blockfront/jN;", "FIELD:Lcom/boehmod/blockfront/tI;->d:Lcom/boehmod/blockfront/common/player/c;", "FIELD:Lcom/boehmod/blockfront/tI;->b:Lnet/minecraft/server/level/ServerLevel;", "FIELD:Lcom/boehmod/blockfront/tI;->r:Ljava/util/Set;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1057tI.class, Object.class), C1057tI.class, "game;playerHandler;manager;playerDataHandler;serverLevel;players", "FIELD:Lcom/boehmod/blockfront/tI;->j:Lcom/boehmod/blockfront/pb;", "FIELD:Lcom/boehmod/blockfront/tI;->c:Lcom/boehmod/blockfront/pe;", "FIELD:Lcom/boehmod/blockfront/tI;->g:Lcom/boehmod/blockfront/jN;", "FIELD:Lcom/boehmod/blockfront/tI;->d:Lcom/boehmod/blockfront/common/player/c;", "FIELD:Lcom/boehmod/blockfront/tI;->b:Lnet/minecraft/server/level/ServerLevel;", "FIELD:Lcom/boehmod/blockfront/tI;->r:Ljava/util/Set;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public G m5869c() {
        return this.f5712j;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public P m5870c() {
        return this.f5713c;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public AbstractC0531jN<?, ?, ?> m5871b() {
        return this.f5714g;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public AbstractC0184c<?> m5872b() {
        return this.f5715d;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ServerLevel m5873a() {
        return this.f5716b;
    }

    @NotNull
    /* JADX INFO: renamed from: m */
    public Set<UUID> m5874m() {
        return this.f5717r;
    }
}
