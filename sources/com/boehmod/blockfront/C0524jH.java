package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jH.class */
public final class C0524jH extends Record {

    /* JADX INFO: renamed from: p */
    private final long f3093p;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ServerPlayer f3094a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1300xw f3095a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1276xQ f3096a;

    /* JADX INFO: renamed from: W */
    @NotNull
    private final List<C1142up> f3097W;

    /* JADX INFO: renamed from: D */
    @NotNull
    private final Vec3 f3098D;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final Vec2 f3099g;

    /* JADX INFO: renamed from: hp */
    private final float f3100hp;

    /* JADX INFO: renamed from: hq */
    private final float f3101hq;

    /* JADX INFO: renamed from: q */
    private final long f3102q;

    /* JADX INFO: renamed from: kb */
    private final int f3103kb;

    public C0524jH(long j, @NotNull ServerPlayer serverPlayer, @NotNull C1300xw c1300xw, @NotNull C1276xQ c1276xQ, @NotNull List<C1142up> list, @NotNull Vec3 vec3, @NotNull Vec2 vec2, float f, float f2, long j2, int i) {
        this.f3093p = j;
        this.f3094a = serverPlayer;
        this.f3095a = c1300xw;
        this.f3096a = c1276xQ;
        this.f3097W = list;
        this.f3098D = vec3;
        this.f3099g = vec2;
        this.f3100hp = f;
        this.f3101hq = f2;
        this.f3102q = j2;
        this.f3103kb = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0524jH.class), C0524jH.class, "shootTick;serverPlayer;serverModManager;playerDataHandler;clientHits;position;direction;reportedItemSpread;shootBackPitch;randomSeed;pelletIndex", "FIELD:Lcom/boehmod/blockfront/jH;->p:J", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lnet/minecraft/server/level/ServerPlayer;", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lcom/boehmod/blockfront/xw;", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lcom/boehmod/blockfront/xQ;", "FIELD:Lcom/boehmod/blockfront/jH;->W:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/jH;->D:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/jH;->g:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/jH;->hp:F", "FIELD:Lcom/boehmod/blockfront/jH;->hq:F", "FIELD:Lcom/boehmod/blockfront/jH;->q:J", "FIELD:Lcom/boehmod/blockfront/jH;->kb:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0524jH.class), C0524jH.class, "shootTick;serverPlayer;serverModManager;playerDataHandler;clientHits;position;direction;reportedItemSpread;shootBackPitch;randomSeed;pelletIndex", "FIELD:Lcom/boehmod/blockfront/jH;->p:J", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lnet/minecraft/server/level/ServerPlayer;", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lcom/boehmod/blockfront/xw;", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lcom/boehmod/blockfront/xQ;", "FIELD:Lcom/boehmod/blockfront/jH;->W:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/jH;->D:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/jH;->g:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/jH;->hp:F", "FIELD:Lcom/boehmod/blockfront/jH;->hq:F", "FIELD:Lcom/boehmod/blockfront/jH;->q:J", "FIELD:Lcom/boehmod/blockfront/jH;->kb:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0524jH.class, Object.class), C0524jH.class, "shootTick;serverPlayer;serverModManager;playerDataHandler;clientHits;position;direction;reportedItemSpread;shootBackPitch;randomSeed;pelletIndex", "FIELD:Lcom/boehmod/blockfront/jH;->p:J", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lnet/minecraft/server/level/ServerPlayer;", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lcom/boehmod/blockfront/xw;", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lcom/boehmod/blockfront/xQ;", "FIELD:Lcom/boehmod/blockfront/jH;->W:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/jH;->D:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/jH;->g:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/jH;->hp:F", "FIELD:Lcom/boehmod/blockfront/jH;->hq:F", "FIELD:Lcom/boehmod/blockfront/jH;->q:J", "FIELD:Lcom/boehmod/blockfront/jH;->kb:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: f */
    public long m2311f() {
        return this.f3093p;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ServerPlayer m2312a() {
        return this.f3094a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1300xw m2313a() {
        return this.f3095a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1276xQ m2314a() {
        return this.f3096a;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public List<C1142up> m2315p() {
        return this.f3097W;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m2316h() {
        return this.f3098D;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vec2 m2317a() {
        return this.f3099g;
    }

    /* JADX INFO: renamed from: ad */
    public float m2318ad() {
        return this.f3100hp;
    }

    /* JADX INFO: renamed from: ae */
    public float m2319ae() {
        return this.f3101hq;
    }

    /* JADX INFO: renamed from: g */
    public long m2320g() {
        return this.f3102q;
    }

    /* JADX INFO: renamed from: am */
    public int m2321am() {
        return this.f3103kb;
    }
}
