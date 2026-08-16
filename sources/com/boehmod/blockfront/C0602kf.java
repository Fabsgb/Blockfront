package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.kf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kf.class */
public final class C0602kf extends Record {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C1280xT f3477b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ServerLevel f3478a;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final ServerPlayer f3479b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1326ym f3480a;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C1264xD f3481c;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final ItemStack f3482e;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final C1117uP f3483d;

    /* JADX INFO: renamed from: dS */
    private final boolean f3484dS;

    /* JADX INFO: renamed from: ad */
    @NotNull
    private final List<C1120uS> f3485ad;

    /* JADX INFO: renamed from: E */
    private final Vec3 f3486E;

    /* JADX INFO: renamed from: ii */
    private final float f3487ii;

    /* JADX INFO: renamed from: K */
    private final long f3488K;

    /* JADX INFO: renamed from: L */
    private final long f3489L;

    /* JADX INFO: renamed from: dT */
    private final boolean f3490dT;

    /* JADX INFO: renamed from: dU */
    private final boolean f3491dU;

    public C0602kf(@NotNull C1280xT c1280xT, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull C1326ym c1326ym, @NotNull C1264xD c1264xD, @NotNull ItemStack itemStack, @NotNull C1117uP c1117uP, boolean z, @NotNull List<C1120uS> list, Vec3 vec3, float f, long j, long j2, boolean z2, boolean z3) {
        this.f3477b = c1280xT;
        this.f3478a = serverLevel;
        this.f3479b = serverPlayer;
        this.f3480a = c1326ym;
        this.f3481c = c1264xD;
        this.f3482e = itemStack;
        this.f3483d = c1117uP;
        this.f3484dS = z;
        this.f3485ad = list;
        this.f3486E = vec3;
        this.f3487ii = f;
        this.f3488K = j;
        this.f3489L = j2;
        this.f3490dT = z2;
        this.f3491dU = z3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0602kf.class), C0602kf.class, "manager;serverLevel;serverPlayer;playerData;entityTracker;weaponStack;gunItem;skipSpread;pellets;position;reportedItemSpread;shootTick;currentTick;isFutureHit;loggingEnabled", "FIELD:Lcom/boehmod/blockfront/kf;->b:Lcom/boehmod/blockfront/xT;", "FIELD:Lcom/boehmod/blockfront/kf;->a:Lnet/minecraft/server/level/ServerLevel;", "FIELD:Lcom/boehmod/blockfront/kf;->b:Lnet/minecraft/server/level/ServerPlayer;", "FIELD:Lcom/boehmod/blockfront/kf;->a:Lcom/boehmod/blockfront/ym;", "FIELD:Lcom/boehmod/blockfront/kf;->c:Lcom/boehmod/blockfront/xD;", "FIELD:Lcom/boehmod/blockfront/kf;->e:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/kf;->d:Lcom/boehmod/blockfront/uP;", "FIELD:Lcom/boehmod/blockfront/kf;->dS:Z", "FIELD:Lcom/boehmod/blockfront/kf;->ad:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/kf;->E:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/kf;->ii:F", "FIELD:Lcom/boehmod/blockfront/kf;->K:J", "FIELD:Lcom/boehmod/blockfront/kf;->L:J", "FIELD:Lcom/boehmod/blockfront/kf;->dT:Z", "FIELD:Lcom/boehmod/blockfront/kf;->dU:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0602kf.class), C0602kf.class, "manager;serverLevel;serverPlayer;playerData;entityTracker;weaponStack;gunItem;skipSpread;pellets;position;reportedItemSpread;shootTick;currentTick;isFutureHit;loggingEnabled", "FIELD:Lcom/boehmod/blockfront/kf;->b:Lcom/boehmod/blockfront/xT;", "FIELD:Lcom/boehmod/blockfront/kf;->a:Lnet/minecraft/server/level/ServerLevel;", "FIELD:Lcom/boehmod/blockfront/kf;->b:Lnet/minecraft/server/level/ServerPlayer;", "FIELD:Lcom/boehmod/blockfront/kf;->a:Lcom/boehmod/blockfront/ym;", "FIELD:Lcom/boehmod/blockfront/kf;->c:Lcom/boehmod/blockfront/xD;", "FIELD:Lcom/boehmod/blockfront/kf;->e:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/kf;->d:Lcom/boehmod/blockfront/uP;", "FIELD:Lcom/boehmod/blockfront/kf;->dS:Z", "FIELD:Lcom/boehmod/blockfront/kf;->ad:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/kf;->E:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/kf;->ii:F", "FIELD:Lcom/boehmod/blockfront/kf;->K:J", "FIELD:Lcom/boehmod/blockfront/kf;->L:J", "FIELD:Lcom/boehmod/blockfront/kf;->dT:Z", "FIELD:Lcom/boehmod/blockfront/kf;->dU:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0602kf.class, Object.class), C0602kf.class, "manager;serverLevel;serverPlayer;playerData;entityTracker;weaponStack;gunItem;skipSpread;pellets;position;reportedItemSpread;shootTick;currentTick;isFutureHit;loggingEnabled", "FIELD:Lcom/boehmod/blockfront/kf;->b:Lcom/boehmod/blockfront/xT;", "FIELD:Lcom/boehmod/blockfront/kf;->a:Lnet/minecraft/server/level/ServerLevel;", "FIELD:Lcom/boehmod/blockfront/kf;->b:Lnet/minecraft/server/level/ServerPlayer;", "FIELD:Lcom/boehmod/blockfront/kf;->a:Lcom/boehmod/blockfront/ym;", "FIELD:Lcom/boehmod/blockfront/kf;->c:Lcom/boehmod/blockfront/xD;", "FIELD:Lcom/boehmod/blockfront/kf;->e:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/kf;->d:Lcom/boehmod/blockfront/uP;", "FIELD:Lcom/boehmod/blockfront/kf;->dS:Z", "FIELD:Lcom/boehmod/blockfront/kf;->ad:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/kf;->E:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/kf;->ii:F", "FIELD:Lcom/boehmod/blockfront/kf;->K:J", "FIELD:Lcom/boehmod/blockfront/kf;->L:J", "FIELD:Lcom/boehmod/blockfront/kf;->dT:Z", "FIELD:Lcom/boehmod/blockfront/kf;->dU:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1280xT m2675b() {
        return this.f3477b;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ServerLevel m2676a() {
        return this.f3478a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ServerPlayer m2677a() {
        return this.f3479b;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1326ym m2678a() {
        return this.f3480a;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1264xD m2679b() {
        return this.f3481c;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public ItemStack m2680b() {
        return this.f3482e;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1117uP m2681b() {
        return this.f3483d;
    }

    /* JADX INFO: renamed from: al */
    public boolean m2682al() {
        return this.f3484dS;
    }

    @NotNull
    /* JADX INFO: renamed from: r */
    public List<C1120uS> m2683r() {
        return this.f3485ad;
    }

    /* JADX INFO: renamed from: h */
    public Vec3 m2684h() {
        return this.f3486E;
    }

    /* JADX INFO: renamed from: ae */
    public float m2685ae() {
        return this.f3487ii;
    }

    /* JADX INFO: renamed from: g */
    public long m2686g() {
        return this.f3488K;
    }

    /* JADX INFO: renamed from: h */
    public long m2687h() {
        return this.f3489L;
    }

    /* JADX INFO: renamed from: aq */
    public boolean m2688aq() {
        return this.f3490dT;
    }

    /* JADX INFO: renamed from: ar */
    public boolean m2689ar() {
        return this.f3491dU;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0543jZ m2673a() {
        return this.f3481c.m7131a(this.f3488K, this.f3479b.getId());
    }

    @NotNull
    /* JADX INFO: renamed from: j */
    public Vec3 m2674j() {
        C0543jZ c0543jZM2673a = m2673a();
        return c0543jZM2673a != null ? c0543jZM2673a.m2443g() : this.f3479b.getEyePosition();
    }
}
