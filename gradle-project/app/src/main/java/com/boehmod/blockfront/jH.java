package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jH.class */
public final class jH extends Record {
    private final long p;

    @NotNull
    private final ServerPlayer a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final xw f181a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final xQ f182a;

    @NotNull
    private final List<C0556up> W;

    @NotNull
    private final Vec3 D;

    @NotNull
    private final Vec2 g;
    private final float hp;
    private final float hq;
    private final long q;
    private final int kb;

    public jH(long j, @NotNull ServerPlayer serverPlayer, @NotNull xw xwVar, @NotNull xQ xQVar, @NotNull List<C0556up> list, @NotNull Vec3 vec3, @NotNull Vec2 vec2, float f, float f2, long j2, int i) {
        this.p = j;
        this.a = serverPlayer;
        this.f181a = xwVar;
        this.f182a = xQVar;
        this.W = list;
        this.D = vec3;
        this.g = vec2;
        this.hp = f;
        this.hq = f2;
        this.q = j2;
        this.kb = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, jH.class), jH.class, "shootTick;serverPlayer;serverModManager;playerDataHandler;clientHits;position;direction;reportedItemSpread;shootBackPitch;randomSeed;pelletIndex", "FIELD:Lcom/boehmod/blockfront/jH;->p:J", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lnet/minecraft/server/level/ServerPlayer;", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lcom/boehmod/blockfront/xw;", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lcom/boehmod/blockfront/xQ;", "FIELD:Lcom/boehmod/blockfront/jH;->W:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/jH;->D:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/jH;->g:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/jH;->hp:F", "FIELD:Lcom/boehmod/blockfront/jH;->hq:F", "FIELD:Lcom/boehmod/blockfront/jH;->q:J", "FIELD:Lcom/boehmod/blockfront/jH;->kb:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, jH.class), jH.class, "shootTick;serverPlayer;serverModManager;playerDataHandler;clientHits;position;direction;reportedItemSpread;shootBackPitch;randomSeed;pelletIndex", "FIELD:Lcom/boehmod/blockfront/jH;->p:J", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lnet/minecraft/server/level/ServerPlayer;", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lcom/boehmod/blockfront/xw;", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lcom/boehmod/blockfront/xQ;", "FIELD:Lcom/boehmod/blockfront/jH;->W:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/jH;->D:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/jH;->g:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/jH;->hp:F", "FIELD:Lcom/boehmod/blockfront/jH;->hq:F", "FIELD:Lcom/boehmod/blockfront/jH;->q:J", "FIELD:Lcom/boehmod/blockfront/jH;->kb:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, jH.class, Object.class), jH.class, "shootTick;serverPlayer;serverModManager;playerDataHandler;clientHits;position;direction;reportedItemSpread;shootBackPitch;randomSeed;pelletIndex", "FIELD:Lcom/boehmod/blockfront/jH;->p:J", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lnet/minecraft/server/level/ServerPlayer;", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lcom/boehmod/blockfront/xw;", "FIELD:Lcom/boehmod/blockfront/jH;->a:Lcom/boehmod/blockfront/xQ;", "FIELD:Lcom/boehmod/blockfront/jH;->W:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/jH;->D:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/jH;->g:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/jH;->hp:F", "FIELD:Lcom/boehmod/blockfront/jH;->hq:F", "FIELD:Lcom/boehmod/blockfront/jH;->q:J", "FIELD:Lcom/boehmod/blockfront/jH;->kb:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public long f() {
        return this.p;
    }

    @NotNull
    public ServerPlayer a() {
        return this.a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public xw m514a() {
        return this.f181a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public xQ m515a() {
        return this.f182a;
    }

    @NotNull
    public List<C0556up> p() {
        return this.W;
    }

    @NotNull
    public Vec3 h() {
        return this.D;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Vec2 m516a() {
        return this.g;
    }

    public float ad() {
        return this.hp;
    }

    public float ae() {
        return this.hq;
    }

    public long g() {
        return this.q;
    }

    public int am() {
        return this.kb;
    }
}
